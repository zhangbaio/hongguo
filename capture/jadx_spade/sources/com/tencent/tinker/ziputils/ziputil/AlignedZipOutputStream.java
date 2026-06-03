package com.tencent.tinker.ziputils.ziputil;

import com.bytedance.covode.number.Covode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class AlignedZipOutputStream extends DeflaterOutputStream {
    private static final byte[] EMPTY_BYTE_ARRAY;
    private static final byte[] ONE_ELEM_BYTE_ARRAY;
    private final int alignBytes;
    private ByteArrayOutputStream cDir;
    private boolean closed;
    private byte[] commentBytes;
    private int compressionLevel;
    private final CRC32 crc;
    private long crcDataSize;
    private ZipEntry currentEntry;
    private int defaultCompressionMethod;
    private final HashSet<String> entries;
    private boolean finished;
    private byte[] nameBytes;
    private int nameLength;
    private int offset;
    private int padding;

    private void checkOpen() throws IOException {
        if (!this.closed) {
        } else {
            throw new IOException("Stream is closed");
        }
    }

    static {
        Covode.recordClassIndex(653970);
        EMPTY_BYTE_ARRAY = new byte[0];
        ONE_ELEM_BYTE_ARRAY = new byte[]{0};
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            finish();
            ((DeflaterOutputStream) this).def.end();
            ((DeflaterOutputStream) this).out.close();
            ((DeflaterOutputStream) this).out = null;
            this.closed = true;
        }
    }

    @Override // java.util.zip.DeflaterOutputStream
    public void finish() throws IOException {
        checkOpen();
        if (this.finished) {
            return;
        }
        if (!this.entries.isEmpty()) {
            if (this.currentEntry != null) {
                closeEntry();
            }
            int size = this.cDir.size();
            writeLong(this.cDir, 101010256L);
            writeShort(this.cDir, 0);
            writeShort(this.cDir, 0);
            writeShort(this.cDir, this.entries.size());
            writeShort(this.cDir, this.entries.size());
            writeLong(this.cDir, size);
            writeLong(this.cDir, this.offset + this.padding);
            writeShort(this.cDir, this.commentBytes.length);
            byte[] bArr = this.commentBytes;
            if (bArr.length > 0) {
                this.cDir.write(bArr);
            }
            this.cDir.writeTo(((DeflaterOutputStream) this).out);
            this.cDir = null;
            this.finished = true;
            return;
        }
        throw new ZipException("No entries");
    }

    public void closeEntry() throws IOException {
        int i;
        int i2;
        int writeLong;
        checkOpen();
        ZipEntry zipEntry = this.currentEntry;
        if (zipEntry == null) {
            return;
        }
        if (zipEntry.getMethod() == 8) {
            super.finish();
        }
        if (this.currentEntry.getMethod() == 0) {
            if (this.crc.getValue() == this.currentEntry.getCrc()) {
                if (this.currentEntry.getSize() != this.crcDataSize) {
                    throw new ZipException("Size mismatch");
                }
            } else {
                throw new ZipException("CRC mismatch");
            }
        }
        if (this.currentEntry.getMethod() != 0) {
            writeLong(((DeflaterOutputStream) this).out, 134695760L);
            this.currentEntry.setCrc(this.crc.getValue());
            writeLong(((DeflaterOutputStream) this).out, this.currentEntry.getCrc());
            this.currentEntry.setCompressedSize(((DeflaterOutputStream) this).def.getTotalOut());
            writeLong(((DeflaterOutputStream) this).out, this.currentEntry.getCompressedSize());
            this.currentEntry.setSize(((DeflaterOutputStream) this).def.getTotalIn());
            writeLong(((DeflaterOutputStream) this).out, this.currentEntry.getSize());
            i = 46;
        } else {
            i = 30;
        }
        if (this.currentEntry.getMethod() == 0) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        writeLong(this.cDir, 33639248L);
        writeShort(this.cDir, 20);
        writeShort(this.cDir, 20);
        writeShort(this.cDir, i2 | 2048);
        writeShort(this.cDir, this.currentEntry.getMethod());
        writeShort(this.cDir, 0);
        writeShort(this.cDir, 33);
        writeLong(this.cDir, this.crc.getValue());
        if (this.currentEntry.getMethod() == 8) {
            writeLong = (int) (i + writeLong(this.cDir, ((DeflaterOutputStream) this).def.getTotalOut()));
            writeLong(this.cDir, ((DeflaterOutputStream) this).def.getTotalIn());
        } else {
            writeLong = (int) (i + writeLong(this.cDir, this.crcDataSize));
            writeLong(this.cDir, this.crcDataSize);
        }
        int writeShort = writeLong + writeShort(this.cDir, this.nameLength);
        if (this.currentEntry.getExtra() != null) {
            writeShort += writeShort(this.cDir, this.currentEntry.getExtra().length);
        } else {
            writeShort(this.cDir, 0);
        }
        String comment = this.currentEntry.getComment();
        byte[] bArr = EMPTY_BYTE_ARRAY;
        if (comment != null) {
            bArr = comment.getBytes(Charset.forName("UTF-8"));
        }
        writeShort(this.cDir, bArr.length);
        writeShort(this.cDir, 0);
        writeShort(this.cDir, 0);
        writeLong(this.cDir, 0L);
        writeLong(this.cDir, this.offset);
        this.cDir.write(this.nameBytes);
        this.nameBytes = null;
        if (this.currentEntry.getExtra() != null) {
            this.cDir.write(this.currentEntry.getExtra());
        }
        this.offset += writeShort + this.padding;
        this.padding = 0;
        if (bArr.length > 0) {
            this.cDir.write(bArr);
        }
        this.currentEntry = null;
        this.crc.reset();
        this.crcDataSize = 0L;
        ((DeflaterOutputStream) this).def.reset();
    }

    public AlignedZipOutputStream(OutputStream outputStream) {
        this(outputStream, 4);
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = ONE_ELEM_BYTE_ARRAY;
        bArr[0] = (byte) (i & 255);
        write(bArr, 0, 1);
    }

    public void setComment(String str) {
        if (str == null) {
            this.commentBytes = null;
            return;
        }
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        if (bytes.length <= 65535) {
            this.commentBytes = bytes;
            return;
        }
        throw new IllegalArgumentException("Comment too long: " + bytes.length + " bytes");
    }

    public void setLevel(int i) {
        if (i >= -1 && i <= 9) {
            this.compressionLevel = i;
            return;
        }
        throw new IllegalArgumentException("Bad level: " + i);
    }

    public void setMethod(int i) {
        if (i != 0 && i != 8) {
            throw new IllegalArgumentException("Bad method: " + i);
        }
        this.defaultCompressionMethod = i;
    }

    public void putNextEntry(ZipEntry zipEntry) throws IOException {
        int i;
        if (this.currentEntry != null) {
            closeEntry();
        }
        int method = zipEntry.getMethod();
        if (method == -1) {
            method = this.defaultCompressionMethod;
        }
        if (method == 0) {
            if (zipEntry.getCompressedSize() == -1) {
                zipEntry.setCompressedSize(zipEntry.getSize());
            } else if (zipEntry.getSize() == -1) {
                zipEntry.setSize(zipEntry.getCompressedSize());
            }
            if (zipEntry.getCrc() != -1) {
                if (zipEntry.getSize() != -1) {
                    if (zipEntry.getSize() != zipEntry.getCompressedSize()) {
                        throw new ZipException("STORED entry size/compressed size mismatch");
                    }
                } else {
                    throw new ZipException("STORED entry missing size");
                }
            } else {
                throw new ZipException("STORED entry missing CRC");
            }
        }
        checkOpen();
        if (!this.entries.contains(zipEntry.getName())) {
            if (this.entries.size() != 65535) {
                byte[] bytes = zipEntry.getName().getBytes(Charset.forName("UTF-8"));
                this.nameBytes = bytes;
                int length = bytes.length;
                this.nameLength = length;
                if (length <= 65535) {
                    ((DeflaterOutputStream) this).def.setLevel(this.compressionLevel);
                    zipEntry.setMethod(method);
                    this.currentEntry = zipEntry;
                    this.entries.add(zipEntry.getName());
                    int i2 = 0;
                    if (method == 0) {
                        i = 0;
                    } else {
                        i = 8;
                    }
                    writeLong(((DeflaterOutputStream) this).out, 67324752L);
                    writeShort(((DeflaterOutputStream) this).out, 20);
                    writeShort(((DeflaterOutputStream) this).out, i | 2048);
                    writeShort(((DeflaterOutputStream) this).out, method);
                    if (this.currentEntry.getTime() == -1) {
                        this.currentEntry.setTime(System.currentTimeMillis());
                    }
                    writeShort(((DeflaterOutputStream) this).out, 0);
                    writeShort(((DeflaterOutputStream) this).out, 33);
                    if (method == 0) {
                        writeLong(((DeflaterOutputStream) this).out, this.currentEntry.getCrc());
                        writeLong(((DeflaterOutputStream) this).out, this.currentEntry.getSize());
                        writeLong(((DeflaterOutputStream) this).out, this.currentEntry.getSize());
                    } else {
                        writeLong(((DeflaterOutputStream) this).out, 0L);
                        writeLong(((DeflaterOutputStream) this).out, 0L);
                        writeLong(((DeflaterOutputStream) this).out, 0L);
                    }
                    writeShort(((DeflaterOutputStream) this).out, this.nameLength);
                    int i3 = this.offset + 30 + this.nameLength;
                    if (this.currentEntry.getExtra() != null) {
                        i2 = this.currentEntry.getExtra().length;
                    }
                    this.padding = getPaddingByteCount(this.currentEntry, i3 + i2);
                    if (this.currentEntry.getExtra() != null) {
                        writeShort(((DeflaterOutputStream) this).out, this.currentEntry.getExtra().length + this.padding);
                    } else {
                        writeShort(((DeflaterOutputStream) this).out, this.padding);
                    }
                    ((DeflaterOutputStream) this).out.write(this.nameBytes);
                    if (this.currentEntry.getExtra() != null) {
                        ((DeflaterOutputStream) this).out.write(this.currentEntry.getExtra());
                    }
                    makePaddingToStream(((DeflaterOutputStream) this).out, this.padding);
                    return;
                }
                throw new IllegalArgumentException("Name too long: " + this.nameLength + " UTF-8 bytes");
            }
            throw new ZipException("Too many entries for the zip file format's 16-bit entry count");
        }
        throw new ZipException("Entry already exists: " + zipEntry.getName());
    }

    private void makePaddingToStream(OutputStream outputStream, int i) throws IOException {
        if (i <= 0) {
            return;
        }
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                outputStream.write(0);
                i = i2;
            } else {
                return;
            }
        }
    }

    private int getPaddingByteCount(ZipEntry zipEntry, int i) {
        int i2;
        if (zipEntry.getMethod() == 0 && (i2 = this.alignBytes) != 0) {
            return (i2 - (i % i2)) % i2;
        }
        return 0;
    }

    public AlignedZipOutputStream(OutputStream outputStream, int i) {
        super(outputStream, new Deflater(-1, true));
        this.commentBytes = EMPTY_BYTE_ARRAY;
        this.entries = new HashSet<>();
        this.defaultCompressionMethod = 8;
        this.compressionLevel = -1;
        this.cDir = new ByteArrayOutputStream();
        this.crc = new CRC32();
        this.crcDataSize = 0L;
        this.offset = 0;
        this.finished = false;
        this.closed = false;
        this.padding = 0;
        this.alignBytes = i;
    }

    private long writeLong(OutputStream outputStream, long j) throws IOException {
        outputStream.write((int) (255 & j));
        outputStream.write(((int) (j >> 8)) & 255);
        outputStream.write(((int) (j >> 16)) & 255);
        outputStream.write(((int) (j >> 24)) & 255);
        return j;
    }

    private int writeShort(OutputStream outputStream, int i) throws IOException {
        if (i <= 65535) {
            outputStream.write(i & 255);
            outputStream.write((i >> 8) & 255);
            return i;
        }
        throw new IllegalArgumentException("value " + i + " is too large for type 'short'.");
    }

    private void checkOffsetAndCount(int i, int i2, int i3) {
        if ((i2 | i3) >= 0 && i2 <= i && i - i2 >= i3) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException("length=" + i + "; regionStart=" + i2 + "; regionLength=" + i3);
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkOffsetAndCount(bArr.length, i, i2);
        ZipEntry zipEntry = this.currentEntry;
        if (zipEntry != null) {
            if (zipEntry.getMethod() == 0) {
                ((DeflaterOutputStream) this).out.write(bArr, i, i2);
            } else {
                super.write(bArr, i, i2);
            }
            this.crc.update(bArr, i, i2);
            this.crcDataSize += i2;
            return;
        }
        throw new ZipException("No active entry");
    }
}
