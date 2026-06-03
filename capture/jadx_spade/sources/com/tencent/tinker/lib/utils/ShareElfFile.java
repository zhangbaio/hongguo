package com.tencent.tinker.lib.utils;

import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ShareElfFile implements Closeable {
    public ElfHeader elfHeader;
    private final FileInputStream fis;
    public ProgramHeader[] programHeaders;
    public SectionHeader[] sectionHeaders;
    private final Map<String, SectionHeader> sectionNameToHeaderMap = new HashMap();

    static {
        Covode.recordClassIndex(653936);
    }

    public FileChannel getChannel() {
        return this.fis.getChannel();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.fis.close();
        this.sectionNameToHeaderMap.clear();
        this.programHeaders = null;
        this.sectionHeaders = null;
    }

    public ByteOrder getDataOrder() {
        if (this.elfHeader.eIndent[5] == 1) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        return ByteOrder.BIG_ENDIAN;
    }

    public boolean is32BitElf() {
        if (this.elfHeader.eIndent[4] == 1) {
            return true;
        }
        return false;
    }

    public SectionHeader getSectionHeaderByName(String str) {
        return this.sectionNameToHeaderMap.get(str);
    }

    public static String readCString(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName("ASCII"));
    }

    public ByteBuffer getSection(SectionHeader sectionHeader) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate((int) sectionHeader.shSize);
        this.fis.getChannel().position(sectionHeader.shOffset);
        readUntilLimit(this.fis.getChannel(), allocate, "failed to read section: " + sectionHeader.shNameStr);
        return allocate;
    }

    public ByteBuffer getSegment(ProgramHeader programHeader) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate((int) programHeader.pFileSize);
        this.fis.getChannel().position(programHeader.pOffset);
        readUntilLimit(this.fis.getChannel(), allocate, "failed to read segment (type: " + programHeader.pType + ").");
        return allocate;
    }

    public static int getFileTypeByMagic(File file) throws IOException {
        InputStream inputStream = null;
        try {
            byte[] bArr = new byte[4];
            InputStream polarisFileInputStreamWrapper = new PolarisFileInputStreamWrapper(file);
            try {
                polarisFileInputStreamWrapper.read(bArr);
                byte b = bArr[0];
                if (b == 100 && bArr[1] == 101 && bArr[2] == 121 && bArr[3] == 10) {
                    try {
                        polarisFileInputStreamWrapper.close();
                    } catch (Throwable unused) {
                    }
                    return 0;
                }
                if (b == Byte.MAX_VALUE && bArr[1] == 69 && bArr[2] == 76) {
                    if (bArr[3] == 70) {
                        try {
                            polarisFileInputStreamWrapper.close();
                        } catch (Throwable unused2) {
                        }
                        return 1;
                    }
                }
                try {
                    polarisFileInputStreamWrapper.close();
                    return -1;
                } catch (Throwable unused3) {
                    return -1;
                }
            } catch (Throwable th) {
                th = th;
                inputStream = polarisFileInputStreamWrapper;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public ShareElfFile(File file) throws IOException {
        ByteOrder byteOrder;
        SectionHeader[] sectionHeaderArr;
        this.elfHeader = null;
        this.programHeaders = null;
        this.sectionHeaders = null;
        PolarisFileInputStreamWrapper polarisFileInputStreamWrapper = new PolarisFileInputStreamWrapper(file);
        this.fis = polarisFileInputStreamWrapper;
        FileChannel channel = polarisFileInputStreamWrapper.getChannel();
        this.elfHeader = new ElfHeader(channel);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.elfHeader.ePhEntSize);
        if (this.elfHeader.eIndent[5] == 1) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        allocate.order(byteOrder);
        channel.position(this.elfHeader.ePhOff);
        this.programHeaders = new ProgramHeader[this.elfHeader.ePhNum];
        for (int i = 0; i < this.programHeaders.length; i++) {
            readUntilLimit(channel, allocate, "failed to read phdr.");
            this.programHeaders[i] = new ProgramHeader(allocate, this.elfHeader.eIndent[4]);
        }
        channel.position(this.elfHeader.eShOff);
        allocate.limit(this.elfHeader.eShEntSize);
        this.sectionHeaders = new SectionHeader[this.elfHeader.eShNum];
        int i2 = 0;
        while (true) {
            sectionHeaderArr = this.sectionHeaders;
            if (i2 >= sectionHeaderArr.length) {
                break;
            }
            readUntilLimit(channel, allocate, "failed to read shdr.");
            this.sectionHeaders[i2] = new SectionHeader(allocate, this.elfHeader.eIndent[4]);
            i2++;
        }
        short s = this.elfHeader.eShStrNdx;
        if (s > 0) {
            ByteBuffer section = getSection(sectionHeaderArr[s]);
            for (SectionHeader sectionHeader : this.sectionHeaders) {
                section.position(sectionHeader.shName);
                String readCString = readCString(section);
                sectionHeader.shNameStr = readCString;
                this.sectionNameToHeaderMap.put(readCString, sectionHeader);
            }
        }
    }

    public static class ElfHeader {
        public final short eEhSize;
        public final long eEntry;
        public final int eFlags;
        public final byte[] eIndent;
        public final short eMachine;
        public final short ePhEntSize;
        public final short ePhNum;
        public final long ePhOff;
        public final short eShEntSize;
        public final short eShNum;
        public final long eShOff;
        public final short eShStrNdx;
        public final short eType;
        public final int eVersion;

        static {
            Covode.recordClassIndex(653937);
        }

        private ElfHeader(FileChannel fileChannel) throws IOException {
            int i;
            ByteOrder byteOrder;
            byte[] bArr = new byte[16];
            this.eIndent = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] == Byte.MAX_VALUE && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                ShareElfFile.assertInRange(bArr[4], 1, 2, "bad elf class: " + ((int) bArr[4]));
                ShareElfFile.assertInRange(bArr[5], 1, 2, "bad elf data encoding: " + ((int) bArr[5]));
                if (bArr[4] == 1) {
                    i = 36;
                } else {
                    i = 48;
                }
                ByteBuffer allocate = ByteBuffer.allocate(i);
                if (bArr[5] == 1) {
                    byteOrder = ByteOrder.LITTLE_ENDIAN;
                } else {
                    byteOrder = ByteOrder.BIG_ENDIAN;
                }
                allocate.order(byteOrder);
                ShareElfFile.readUntilLimit(fileChannel, allocate, "failed to read rest part of ehdr.");
                this.eType = allocate.getShort();
                this.eMachine = allocate.getShort();
                int i2 = allocate.getInt();
                this.eVersion = i2;
                ShareElfFile.assertInRange(i2, 1, 1, "bad elf version: " + i2);
                byte b = bArr[4];
                if (b != 1) {
                    if (b == 2) {
                        this.eEntry = allocate.getLong();
                        this.ePhOff = allocate.getLong();
                        this.eShOff = allocate.getLong();
                    } else {
                        throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                    }
                } else {
                    this.eEntry = allocate.getInt();
                    this.ePhOff = allocate.getInt();
                    this.eShOff = allocate.getInt();
                }
                this.eFlags = allocate.getInt();
                this.eEhSize = allocate.getShort();
                this.ePhEntSize = allocate.getShort();
                this.ePhNum = allocate.getShort();
                this.eShEntSize = allocate.getShort();
                this.eShNum = allocate.getShort();
                this.eShStrNdx = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
        }
    }

    public static class ProgramHeader {
        public final long pAlign;
        public final long pFileSize;
        public final int pFlags;
        public final long pMemSize;
        public final long pOffset;
        public final long pPddr;
        public final int pType;
        public final long pVddr;

        static {
            Covode.recordClassIndex(653938);
        }

        private ProgramHeader(ByteBuffer byteBuffer, int i) throws IOException {
            if (i != 1) {
                if (i == 2) {
                    this.pType = byteBuffer.getInt();
                    this.pFlags = byteBuffer.getInt();
                    this.pOffset = byteBuffer.getLong();
                    this.pVddr = byteBuffer.getLong();
                    this.pPddr = byteBuffer.getLong();
                    this.pFileSize = byteBuffer.getLong();
                    this.pMemSize = byteBuffer.getLong();
                    this.pAlign = byteBuffer.getLong();
                    return;
                }
                throw new IOException("Unexpected elf class: " + i);
            }
            this.pType = byteBuffer.getInt();
            this.pOffset = byteBuffer.getInt();
            this.pVddr = byteBuffer.getInt();
            this.pPddr = byteBuffer.getInt();
            this.pFileSize = byteBuffer.getInt();
            this.pMemSize = byteBuffer.getInt();
            this.pFlags = byteBuffer.getInt();
            this.pAlign = byteBuffer.getInt();
        }
    }

    public static class SectionHeader {
        public final long shAddr;
        public final long shAddrAlign;
        public final long shEntSize;
        public final long shFlags;
        public final int shInfo;
        public final int shLink;
        public final int shName;
        public String shNameStr;
        public final long shOffset;
        public final long shSize;
        public final int shType;

        static {
            Covode.recordClassIndex(653939);
        }

        private SectionHeader(ByteBuffer byteBuffer, int i) throws IOException {
            if (i != 1) {
                if (i == 2) {
                    this.shName = byteBuffer.getInt();
                    this.shType = byteBuffer.getInt();
                    this.shFlags = byteBuffer.getLong();
                    this.shAddr = byteBuffer.getLong();
                    this.shOffset = byteBuffer.getLong();
                    this.shSize = byteBuffer.getLong();
                    this.shLink = byteBuffer.getInt();
                    this.shInfo = byteBuffer.getInt();
                    this.shAddrAlign = byteBuffer.getLong();
                    this.shEntSize = byteBuffer.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + i);
                }
            } else {
                this.shName = byteBuffer.getInt();
                this.shType = byteBuffer.getInt();
                this.shFlags = byteBuffer.getInt();
                this.shAddr = byteBuffer.getInt();
                this.shOffset = byteBuffer.getInt();
                this.shSize = byteBuffer.getInt();
                this.shLink = byteBuffer.getInt();
                this.shInfo = byteBuffer.getInt();
                this.shAddrAlign = byteBuffer.getInt();
                this.shEntSize = byteBuffer.getInt();
            }
            this.shNameStr = null;
        }
    }

    public static void readUntilLimit(FileChannel fileChannel, ByteBuffer byteBuffer, String str) throws IOException {
        byteBuffer.rewind();
        int read = fileChannel.read(byteBuffer);
        if (read == byteBuffer.limit()) {
            byteBuffer.flip();
            return;
        }
        throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + read + " bytes were read.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void assertInRange(int i, int i2, int i3, String str) throws IOException {
        if (i >= i2 && i <= i3) {
        } else {
            throw new IOException(str);
        }
    }
}
