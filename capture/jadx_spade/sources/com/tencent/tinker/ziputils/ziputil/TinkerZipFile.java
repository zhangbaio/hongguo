package com.tencent.tinker.ziputils.ziputil;

import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.zip.ZipException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TinkerZipFile implements Closeable, ZipConstants {
    private String comment;
    private final LinkedHashMap<String, TinkerZipEntry> entries;
    private File fileToDeleteOnClose;
    private final String filename;
    private RandomAccessFile raf;

    static {
        Covode.recordClassIndex(653979);
    }

    public String getName() {
        return this.filename;
    }

    public static class RAFStream extends InputStream {
        private long endOffset;
        private long offset;
        private final RandomAccessFile sharedRaf;

        static {
            Covode.recordClassIndex(653981);
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            return Streams.readSingleByte(this);
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            if (this.offset < this.endOffset) {
                return 1;
            }
            return 0;
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            long j2 = this.endOffset;
            long j3 = this.offset;
            if (j > j2 - j3) {
                j = j2 - j3;
            }
            this.offset = j3 + j;
            return j;
        }

        public RAFStream(RandomAccessFile randomAccessFile, long j) throws IOException {
            this(randomAccessFile, j, randomAccessFile.length());
        }

        public RAFStream(RandomAccessFile randomAccessFile, long j, long j2) {
            this.sharedRaf = randomAccessFile;
            this.offset = j;
            this.endOffset = j2;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            synchronized (this.sharedRaf) {
                long j = this.endOffset;
                long j2 = this.offset;
                long j3 = j - j2;
                if (i2 > j3) {
                    i2 = (int) j3;
                }
                this.sharedRaf.seek(j2);
                int read = this.sharedRaf.read(bArr, i, i2);
                if (read > 0) {
                    this.offset += read;
                    return read;
                }
                return -1;
            }
        }
    }

    public String getComment() {
        checkNotClosed();
        return this.comment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNotClosed() {
        if (this.raf != null) {
        } else {
            throw new IllegalStateException("Zip file closed");
        }
    }

    public int size() {
        checkNotClosed();
        return this.entries.size();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.raf;
        if (randomAccessFile != null) {
            synchronized (randomAccessFile) {
                this.raf = null;
                randomAccessFile.close();
            }
            File file = this.fileToDeleteOnClose;
            if (file != null) {
                file.delete();
                this.fileToDeleteOnClose = null;
            }
        }
    }

    public Enumeration<? extends TinkerZipEntry> entries() {
        checkNotClosed();
        final Iterator<TinkerZipEntry> it2 = this.entries.values().iterator();
        return new Enumeration<TinkerZipEntry>() { // from class: com.tencent.tinker.ziputils.ziputil.TinkerZipFile.1
            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                TinkerZipFile.this.checkNotClosed();
                return it2.hasNext();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Enumeration
            public TinkerZipEntry nextElement() {
                TinkerZipFile.this.checkNotClosed();
                return (TinkerZipEntry) it2.next();
            }
        };
    }

    private void readCentralDir() throws IOException {
        long length = this.raf.length() - 22;
        long j = 0;
        if (length >= 0) {
            this.raf.seek(0L);
            if (Integer.reverseBytes(this.raf.readInt()) == 67324752) {
                long j2 = length - 65536;
                if (j2 >= 0) {
                    j = j2;
                }
                do {
                    this.raf.seek(length);
                    if (Integer.reverseBytes(this.raf.readInt()) == 101010256) {
                        byte[] bArr = new byte[18];
                        this.raf.readFully(bArr);
                        BufferIterator it2 = HeapBufferIterator.iterator(bArr, 0, 18, ByteOrder.LITTLE_ENDIAN);
                        int readShort = it2.readShort() & 65535;
                        int readShort2 = it2.readShort() & 65535;
                        int readShort3 = it2.readShort() & 65535;
                        int readShort4 = it2.readShort() & 65535;
                        it2.skip(4);
                        long readInt = it2.readInt() & 4294967295L;
                        int readShort5 = it2.readShort() & 65535;
                        if (readShort3 == readShort4 && readShort == 0 && readShort2 == 0) {
                            if (readShort5 > 0) {
                                byte[] bArr2 = new byte[readShort5];
                                this.raf.readFully(bArr2);
                                this.comment = new String(bArr2, 0, readShort5, StandardCharsets.UTF_8);
                            }
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(new RAFStream(this.raf, readInt), 4096);
                            byte[] bArr3 = new byte[46];
                            for (int i = 0; i < readShort3; i++) {
                                TinkerZipEntry tinkerZipEntry = new TinkerZipEntry(bArr3, bufferedInputStream, StandardCharsets.UTF_8, false);
                                if (tinkerZipEntry.localHeaderRelOffset < readInt) {
                                    String name = tinkerZipEntry.getName();
                                    if (this.entries.put(name, tinkerZipEntry) != null) {
                                        throw new ZipException("Duplicate entry name: " + name);
                                    }
                                } else {
                                    throw new ZipException("Local file header offset is after central directory");
                                }
                            }
                            return;
                        }
                        throw new ZipException("Spanned archives not supported");
                    }
                    length--;
                } while (length >= j);
                throw new ZipException("End Of Central Directory signature not found");
            }
            throw new ZipException("Not a zip archive");
        }
        throw new ZipException("File too short to be a zip file: " + this.raf.length());
    }

    public TinkerZipFile(File file) throws ZipException, IOException {
        this(file, 1);
    }

    public TinkerZipFile(String str) throws IOException {
        this(new PolarisFileWrapper(str), 1);
    }

    public static boolean isEmpty(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            return false;
        }
        return true;
    }

    public TinkerZipEntry getEntry(String str) {
        checkNotClosed();
        if (str != null) {
            TinkerZipEntry tinkerZipEntry = this.entries.get(str);
            if (tinkerZipEntry == null) {
                return this.entries.get(str + "/");
            }
            return tinkerZipEntry;
        }
        throw new NullPointerException("entryName == null");
    }

    public InputStream getInputStream(TinkerZipEntry tinkerZipEntry) throws IOException {
        RAFStream rAFStream;
        TinkerZipEntry entry = getEntry(tinkerZipEntry.getName());
        if (entry == null) {
            return null;
        }
        RandomAccessFile randomAccessFile = this.raf;
        synchronized (randomAccessFile) {
            rAFStream = new RAFStream(randomAccessFile, entry.localHeaderRelOffset);
            DataInputStream dataInputStream = new DataInputStream(rAFStream);
            int reverseBytes = Integer.reverseBytes(dataInputStream.readInt());
            if (reverseBytes != 67324752) {
                throwZipException(this.filename, randomAccessFile.length(), entry.getName(), entry.localHeaderRelOffset, "Local File Header", reverseBytes);
            }
            dataInputStream.skipBytes(2);
            int reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            if ((reverseBytes2 & 1) == 0) {
                dataInputStream.skipBytes(18);
                int reverseBytes3 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
                int reverseBytes4 = 65535 & Short.reverseBytes(dataInputStream.readShort());
                dataInputStream.close();
                rAFStream.skip(reverseBytes3 + reverseBytes4);
                if (entry.compressionMethod == 0) {
                    rAFStream.endOffset = rAFStream.offset + entry.size;
                } else {
                    rAFStream.endOffset = rAFStream.offset + entry.compressedSize;
                }
            } else {
                throw new ZipException("Invalid General Purpose Bit Flag: " + reverseBytes2);
            }
        }
        return rAFStream;
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public TinkerZipFile(File file, int i) throws IOException {
        this.entries = new LinkedHashMap<>();
        String path = file.getPath();
        this.filename = path;
        if (i != 1 && i != 5) {
            throw new IllegalArgumentException("Bad mode: " + i);
        }
        if ((i & 4) != 0) {
            this.fileToDeleteOnClose = file;
            file.deleteOnExit();
        } else {
            this.fileToDeleteOnClose = null;
        }
        this.raf = new RandomAccessFile(path, "r");
        readCentralDir();
    }

    static class EocdRecord {
        final long centralDirOffset;
        final int commentLength;
        final long numEntries;

        static {
            Covode.recordClassIndex(653980);
        }

        EocdRecord(long j, long j2, int i) {
            this.numEntries = j;
            this.centralDirOffset = j2;
            this.commentLength = i;
        }
    }

    private static EocdRecord parseEocdRecord(RandomAccessFile randomAccessFile, long j, boolean z) throws IOException {
        long j2;
        long j3;
        randomAccessFile.seek(j);
        byte[] bArr = new byte[18];
        randomAccessFile.readFully(bArr);
        BufferIterator it2 = HeapBufferIterator.iterator(bArr, 0, 18, ByteOrder.LITTLE_ENDIAN);
        if (z) {
            it2.skip(16);
            j2 = -1;
            j3 = -1;
        } else {
            int readShort = it2.readShort() & 65535;
            int readShort2 = it2.readShort() & 65535;
            long readShort3 = it2.readShort() & 65535;
            int readShort4 = it2.readShort() & 65535;
            it2.skip(4);
            long readInt = it2.readInt() & 4294967295L;
            if (readShort3 == readShort4 && readShort == 0 && readShort2 == 0) {
                j2 = readShort3;
                j3 = readInt;
            } else {
                throw new ZipException("Spanned archives not supported");
            }
        }
        return new EocdRecord(j2, j3, it2.readShort() & 65535);
    }

    static void throwZipException(String str, long j, String str2, long j2, String str3, int i) throws ZipException {
        throw new ZipException("file name:" + str + ", file size" + j + ", entry name:" + str2 + ", entry localHeaderRelOffset:" + j2 + ", " + str3 + " signature not found; was " + Integer.toHexString(i));
    }
}
