package com.tencent.tinker.ziputils.ziputil;

import com.bytedance.covode.number.Covode;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.zip.ZipException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TinkerZipOutputStream extends FilterOutputStream implements ZipConstants {
    public static final byte[] BYTE;
    private static final byte[] ZIP64_PLACEHOLDER_BYTES;
    private boolean archiveNeedsZip64EocdRecord;
    private ByteArrayOutputStream cDir;
    private byte[] commentBytes;
    private TinkerZipEntry currentEntry;
    private boolean currentEntryNeedsZip64;
    private int defaultCompressionMethod;
    private final HashSet<String> entries;
    private byte[] entryCommentBytes;
    private final boolean forceZip64;
    private byte[] nameBytes;
    private long offset;

    private void checkOpen() throws IOException {
        if (this.cDir != null) {
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (((FilterOutputStream) this).out != null) {
            finish();
            ((FilterOutputStream) this).out.close();
            ((FilterOutputStream) this).out = null;
        }
    }

    static {
        Covode.recordClassIndex(653982);
        BYTE = new byte[0];
        ZIP64_PLACEHOLDER_BYTES = new byte[]{-1, -1, -1, -1};
    }

    public void finish() throws IOException {
        if (((FilterOutputStream) this).out != null) {
            if (this.cDir == null) {
                return;
            }
            if (!this.entries.isEmpty()) {
                if (this.currentEntry != null) {
                    closeEntry();
                }
                int size = this.cDir.size();
                writeLongAsUint32(this.cDir, 101010256L);
                writeIntAsUint16(this.cDir, 0);
                writeIntAsUint16(this.cDir, 0);
                if (this.archiveNeedsZip64EocdRecord) {
                    writeIntAsUint16(this.cDir, 65535);
                    writeIntAsUint16(this.cDir, 65535);
                    writeLongAsUint32(this.cDir, -1L);
                    writeLongAsUint32(this.cDir, -1L);
                } else {
                    writeIntAsUint16(this.cDir, this.entries.size());
                    writeIntAsUint16(this.cDir, this.entries.size());
                    writeLongAsUint32(this.cDir, size);
                    writeLongAsUint32(this.cDir, this.offset);
                }
                writeIntAsUint16(this.cDir, this.commentBytes.length);
                byte[] bArr = this.commentBytes;
                if (bArr.length > 0) {
                    this.cDir.write(bArr);
                }
                this.cDir.writeTo(((FilterOutputStream) this).out);
                this.cDir = null;
                return;
            }
            throw new ZipException("No entries");
        }
        throw new IOException("Stream is closed");
    }

    public void closeEntry() throws IOException {
        long j;
        int i;
        long size;
        checkOpen();
        TinkerZipEntry tinkerZipEntry = this.currentEntry;
        if (tinkerZipEntry == null) {
            return;
        }
        if (tinkerZipEntry.getMethod() != 0) {
            writeLongAsUint32(((FilterOutputStream) this).out, 134695760L);
            writeLongAsUint32(((FilterOutputStream) this).out, this.currentEntry.crc);
            writeLongAsUint32(((FilterOutputStream) this).out, this.currentEntry.compressedSize);
            writeLongAsUint32(((FilterOutputStream) this).out, this.currentEntry.size);
            j = 46;
        } else {
            j = 30;
        }
        if (this.currentEntry.getMethod() == 0) {
            i = 0;
        } else {
            i = 8;
        }
        writeLongAsUint32(this.cDir, 33639248L);
        writeIntAsUint16(this.cDir, 20);
        writeIntAsUint16(this.cDir, 20);
        writeIntAsUint16(this.cDir, i | 2048);
        writeIntAsUint16(this.cDir, this.currentEntry.getMethod());
        writeIntAsUint16(this.cDir, this.currentEntry.time);
        writeIntAsUint16(this.cDir, this.currentEntry.modDate);
        writeLongAsUint32(this.cDir, this.currentEntry.crc);
        if (this.currentEntry.getMethod() == 8) {
            size = this.currentEntry.getCompressedSize();
        } else {
            size = this.currentEntry.getSize();
        }
        writeLongAsUint32(this.cDir, this.currentEntry.getCompressedSize());
        writeLongAsUint32(this.cDir, this.currentEntry.getSize());
        long writeIntAsUint16 = j + size + writeIntAsUint16(this.cDir, this.nameBytes.length);
        if (this.currentEntry.extra != null) {
            writeIntAsUint16 += writeIntAsUint16(this.cDir, r2.length);
        } else {
            writeIntAsUint16(this.cDir, 0);
        }
        writeIntAsUint16(this.cDir, this.entryCommentBytes.length);
        writeIntAsUint16(this.cDir, 0);
        writeIntAsUint16(this.cDir, 0);
        writeLongAsUint32(this.cDir, 0L);
        writeLongAsUint32(this.cDir, this.currentEntry.localHeaderRelOffset);
        this.cDir.write(this.nameBytes);
        this.nameBytes = null;
        byte[] bArr = this.currentEntry.extra;
        if (bArr != null) {
            this.cDir.write(bArr);
        }
        this.offset += writeIntAsUint16;
        byte[] bArr2 = this.entryCommentBytes;
        if (bArr2.length > 0) {
            this.cDir.write(bArr2);
            this.entryCommentBytes = BYTE;
        }
        this.currentEntry = null;
    }

    public TinkerZipOutputStream(OutputStream outputStream) {
        this(outputStream, false);
    }

    public void setComment(String str) {
        if (str == null) {
            this.commentBytes = BYTE;
            return;
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        checkSizeIsWithinShort("Comment", bytes);
        this.commentBytes = bytes;
    }

    public void putNextEntry(TinkerZipEntry tinkerZipEntry) throws IOException {
        int i;
        if (this.currentEntry != null) {
            closeEntry();
        }
        int method = tinkerZipEntry.getMethod();
        if (method == -1) {
            method = this.defaultCompressionMethod;
        }
        if (method == 0) {
            if (tinkerZipEntry.getCompressedSize() == -1) {
                tinkerZipEntry.setCompressedSize(tinkerZipEntry.getSize());
            } else if (tinkerZipEntry.getSize() == -1) {
                tinkerZipEntry.setSize(tinkerZipEntry.getCompressedSize());
            }
            if (tinkerZipEntry.getCrc() != -1) {
                if (tinkerZipEntry.getSize() != -1) {
                    if (tinkerZipEntry.size != tinkerZipEntry.compressedSize) {
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
        tinkerZipEntry.comment = null;
        tinkerZipEntry.extra = null;
        tinkerZipEntry.time = 40691;
        tinkerZipEntry.modDate = 18698;
        String str = tinkerZipEntry.name;
        Charset charset = StandardCharsets.UTF_8;
        byte[] bytes = str.getBytes(charset);
        this.nameBytes = bytes;
        checkSizeIsWithinShort("Name", bytes);
        this.entryCommentBytes = BYTE;
        String str2 = tinkerZipEntry.comment;
        if (str2 != null) {
            byte[] bytes2 = str2.getBytes(charset);
            this.entryCommentBytes = bytes2;
            checkSizeIsWithinShort("Comment", bytes2);
        }
        tinkerZipEntry.setMethod(method);
        this.currentEntry = tinkerZipEntry;
        tinkerZipEntry.localHeaderRelOffset = this.offset;
        this.entries.add(tinkerZipEntry.name);
        if (method == 0) {
            i = 0;
        } else {
            i = 8;
        }
        writeLongAsUint32(((FilterOutputStream) this).out, 67324752L);
        writeIntAsUint16(((FilterOutputStream) this).out, 20);
        writeIntAsUint16(((FilterOutputStream) this).out, i | 2048);
        writeIntAsUint16(((FilterOutputStream) this).out, method);
        writeIntAsUint16(((FilterOutputStream) this).out, this.currentEntry.time);
        writeIntAsUint16(((FilterOutputStream) this).out, this.currentEntry.modDate);
        if (method == 0) {
            writeLongAsUint32(((FilterOutputStream) this).out, this.currentEntry.crc);
            writeLongAsUint32(((FilterOutputStream) this).out, this.currentEntry.size);
            writeLongAsUint32(((FilterOutputStream) this).out, this.currentEntry.size);
        } else {
            writeLongAsUint32(((FilterOutputStream) this).out, 0L);
            writeLongAsUint32(((FilterOutputStream) this).out, 0L);
            writeLongAsUint32(((FilterOutputStream) this).out, 0L);
        }
        writeIntAsUint16(((FilterOutputStream) this).out, this.nameBytes.length);
        byte[] bArr = this.currentEntry.extra;
        if (bArr != null) {
            writeIntAsUint16(((FilterOutputStream) this).out, bArr.length);
        } else {
            writeIntAsUint16(((FilterOutputStream) this).out, 0);
        }
        ((FilterOutputStream) this).out.write(this.nameBytes);
        byte[] bArr2 = this.currentEntry.extra;
        if (bArr2 != null) {
            ((FilterOutputStream) this).out.write(bArr2);
        }
    }

    static int writeIntAsUint16(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        return i;
    }

    public TinkerZipOutputStream(OutputStream outputStream, boolean z) {
        super(outputStream);
        this.entries = new HashSet<>();
        this.commentBytes = BYTE;
        this.defaultCompressionMethod = 8;
        this.cDir = new ByteArrayOutputStream();
        this.offset = 0L;
        this.forceZip64 = z;
    }

    private void checkSizeIsWithinShort(String str, byte[] bArr) {
        if (bArr.length <= 65535) {
            return;
        }
        throw new IllegalArgumentException(str + " too long in UTF-8:" + bArr.length + " bytes");
    }

    static long writeLongAsUint32(OutputStream outputStream, long j) throws IOException {
        outputStream.write((int) (255 & j));
        outputStream.write(((int) (j >> 8)) & 255);
        outputStream.write(((int) (j >> 16)) & 255);
        outputStream.write(((int) (j >> 24)) & 255);
        return j;
    }

    static long writeLongAsUint64(OutputStream outputStream, long j) throws IOException {
        int i = (int) j;
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
        int i2 = (int) (j >> 32);
        outputStream.write(i2 & 255);
        outputStream.write((i2 >> 8) & 255);
        outputStream.write((i2 >> 16) & 255);
        outputStream.write((i2 >> 24) & 255);
        return j;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        TinkerZipEntry tinkerZipEntry = this.currentEntry;
        if (tinkerZipEntry != null) {
            if (tinkerZipEntry.getMethod() == 0) {
                ((FilterOutputStream) this).out.write(bArr, i, i2);
                return;
            } else {
                ((FilterOutputStream) this).out.write(bArr, i, i2);
                return;
            }
        }
        throw new ZipException("No active entry");
    }
}
