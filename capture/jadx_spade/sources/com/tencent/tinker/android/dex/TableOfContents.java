package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.tinker.android.dex.Dex;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TableOfContents {
    public final Section annotationSetRefLists;
    public final Section annotationSets;
    public final Section annotations;
    public final Section annotationsDirectories;
    public int checksum;
    public final Section classDatas;
    public final Section classDefs;
    public final Section codes;
    public int dataOff;
    public int dataSize;
    public final Section debugInfos;
    public final Section encodedArrays;
    public final Section fieldIds;
    public int fileSize;
    public final Section header;
    public int linkOff;
    public int linkSize;
    public final Section mapList;
    public final Section methodIds;
    public final Section protoIds;
    public final Section[] sections;
    public byte[] signature;
    public final Section stringDatas;
    public final Section stringIds;
    public final Section typeIds;
    public final Section typeLists;

    static {
        Covode.recordClassIndex(653618);
    }

    public static class Section implements Comparable<Section> {
        public int byteCount;
        public boolean isElementFourByteAligned;
        public int off;
        public int size;
        public final short type;

        static {
            Covode.recordClassIndex(653619);
        }

        public static abstract class Item<T> implements Comparable<T> {
            public int off;

            static {
                Covode.recordClassIndex(653620);
            }

            public abstract int byteCountInDex();

            public int hashCode() {
                return super.hashCode();
            }

            public Item(int i) {
                this.off = i;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public boolean equals(Object obj) {
                if (compareTo(obj) == 0) {
                    return true;
                }
                return false;
            }
        }

        public boolean exists() {
            if (this.size > 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            return String.format("Section[type=%#x,off=%#x,size=%#x]", Short.valueOf(this.type), Integer.valueOf(this.off), Integer.valueOf(this.size));
        }

        @Override // java.lang.Comparable
        public int compareTo(Section section) {
            int i = this.off;
            int i2 = section.off;
            if (i != i2) {
                if (i < i2) {
                    return -1;
                }
                return 1;
            }
            int remapTypeOrderId = remapTypeOrderId(this.type);
            int remapTypeOrderId2 = remapTypeOrderId(section.type);
            if (remapTypeOrderId != remapTypeOrderId2) {
                if (remapTypeOrderId < remapTypeOrderId2) {
                    return -1;
                }
                return 1;
            }
            return 0;
        }

        private int remapTypeOrderId(int i) {
            switch (i) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    return 6;
                default:
                    switch (i) {
                        case 4096:
                            return 17;
                        case 4097:
                            return 8;
                        case 4098:
                            return 11;
                        case 4099:
                            return 10;
                        default:
                            switch (i) {
                                case 8192:
                                    return 15;
                                case 8193:
                                    return 14;
                                case 8194:
                                    return 7;
                                case 8195:
                                    return 13;
                                case 8196:
                                    return 9;
                                case 8197:
                                    return 16;
                                case 8198:
                                    return 12;
                                default:
                                    throw new IllegalArgumentException("unknown section type: " + i);
                            }
                    }
            }
        }

        public Section(int i, boolean z) {
            this.size = 0;
            this.off = -1;
            this.byteCount = 0;
            this.type = (short) i;
            this.isElementFourByteAligned = z;
            if (i == 0) {
                this.off = 0;
                this.size = 1;
                this.byteCount = 112;
            } else if (i == 4096) {
                this.size = 1;
            }
        }
    }

    public void computeSizesFromOffsets() {
        int i = this.fileSize;
        for (int length = this.sections.length - 1; length >= 0; length--) {
            Section section = this.sections[length];
            int i2 = section.off;
            if (i2 != -1) {
                if (i2 <= i) {
                    section.byteCount = i - i2;
                    i = i2;
                } else {
                    throw new DexException("Map is unsorted at " + section);
                }
            }
        }
        int i3 = this.header.byteCount + this.stringIds.byteCount + this.typeIds.byteCount + this.protoIds.byteCount + this.fieldIds.byteCount + this.methodIds.byteCount + this.classDefs.byteCount;
        this.dataOff = i3;
        this.dataSize = this.fileSize - i3;
    }

    public TableOfContents() {
        Section section = new Section(0, true);
        this.header = section;
        Section section2 = new Section(1, true);
        this.stringIds = section2;
        Section section3 = new Section(2, true);
        this.typeIds = section3;
        Section section4 = new Section(3, true);
        this.protoIds = section4;
        Section section5 = new Section(4, true);
        this.fieldIds = section5;
        Section section6 = new Section(5, true);
        this.methodIds = section6;
        Section section7 = new Section(6, true);
        this.classDefs = section7;
        Section section8 = new Section(4096, true);
        this.mapList = section8;
        Section section9 = new Section(4097, true);
        this.typeLists = section9;
        Section section10 = new Section(4098, true);
        this.annotationSetRefLists = section10;
        Section section11 = new Section(4099, true);
        this.annotationSets = section11;
        Section section12 = new Section(8192, false);
        this.classDatas = section12;
        Section section13 = new Section(8193, true);
        this.codes = section13;
        Section section14 = new Section(8194, false);
        this.stringDatas = section14;
        Section section15 = new Section(8195, false);
        this.debugInfos = section15;
        Section section16 = new Section(8196, false);
        this.annotations = section16;
        Section section17 = new Section(8197, false);
        this.encodedArrays = section17;
        Section section18 = new Section(8198, true);
        this.annotationsDirectories = section18;
        this.sections = new Section[]{section, section2, section3, section4, section5, section6, section7, section8, section9, section10, section11, section12, section13, section14, section15, section16, section17, section18};
        this.signature = new byte[20];
    }

    public void readFrom(Dex dex) throws IOException {
        readHeader(dex.openSection(this.header));
        readMap(dex.openSection(this.mapList.off));
        computeSizesFromOffsets();
    }

    private Section getSection(short s) {
        for (Section section : this.sections) {
            if (section.type == s) {
                return section;
            }
        }
        throw new IllegalArgumentException("No such map item: " + ((int) s));
    }

    public void writeMap(Dex.Section section) throws IOException {
        int i = 0;
        for (Section section2 : this.sections) {
            if (section2.exists()) {
                i++;
            }
        }
        section.writeInt(i);
        for (Section section3 : this.sections) {
            if (section3.exists()) {
                section.writeShort(section3.type);
                section.writeShort((short) 0);
                section.writeInt(section3.size);
                section.writeInt(section3.off);
            }
        }
    }

    private void readMap(Dex.Section section) throws IOException {
        int i;
        int readInt = section.readInt();
        Section section2 = null;
        int i2 = 0;
        while (i2 < readInt) {
            short readShort = section.readShort();
            section.readShort();
            Section section3 = getSection(readShort);
            int readInt2 = section.readInt();
            int readInt3 = section.readInt();
            int i3 = section3.size;
            if ((i3 != 0 && i3 != readInt2) || ((i = section3.off) != -1 && i != readInt3)) {
                throw new DexException("Unexpected map value for 0x" + Integer.toHexString(readShort));
            }
            section3.size = readInt2;
            section3.off = readInt3;
            if (section2 != null && section2.off > readInt3) {
                throw new DexException("Map is unsorted at " + section2 + ", " + section3);
            }
            i2++;
            section2 = section3;
        }
        this.header.off = 0;
        Arrays.sort(this.sections);
        int i4 = 1;
        while (true) {
            Section[] sectionArr = this.sections;
            if (i4 < sectionArr.length) {
                Section section4 = sectionArr[i4];
                if (section4.off == -1) {
                    section4.off = sectionArr[i4 - 1].off;
                }
                i4++;
            } else {
                return;
            }
        }
    }

    public Section getSectionByType(int i) {
        switch (i) {
            case 0:
                return this.header;
            case 1:
                return this.stringIds;
            case 2:
                return this.typeIds;
            case 3:
                return this.protoIds;
            case 4:
                return this.fieldIds;
            case 5:
                return this.methodIds;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return this.classDefs;
            default:
                switch (i) {
                    case 4096:
                        return this.mapList;
                    case 4097:
                        return this.typeLists;
                    case 4098:
                        return this.annotationSetRefLists;
                    case 4099:
                        return this.annotationSets;
                    default:
                        switch (i) {
                            case 8192:
                                return this.classDatas;
                            case 8193:
                                return this.codes;
                            case 8194:
                                return this.stringDatas;
                            case 8195:
                                return this.debugInfos;
                            case 8196:
                                return this.annotations;
                            case 8197:
                                return this.encodedArrays;
                            case 8198:
                                return this.annotationsDirectories;
                            default:
                                throw new IllegalArgumentException("unknown section type: " + i);
                        }
                }
        }
    }

    public void writeHeader(Dex.Section section) throws IOException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        section.write(DexFormat.apiToMagic(13).getBytes("UTF-8"));
        section.writeInt(this.checksum);
        section.write(this.signature);
        section.writeInt(this.fileSize);
        section.writeInt(112);
        section.writeInt(305419896);
        section.writeInt(this.linkSize);
        section.writeInt(this.linkOff);
        section.writeInt(this.mapList.off);
        section.writeInt(this.stringIds.size);
        int i6 = 0;
        if (this.stringIds.exists()) {
            i = this.stringIds.off;
        } else {
            i = 0;
        }
        section.writeInt(i);
        section.writeInt(this.typeIds.size);
        if (this.typeIds.exists()) {
            i2 = this.typeIds.off;
        } else {
            i2 = 0;
        }
        section.writeInt(i2);
        section.writeInt(this.protoIds.size);
        if (this.protoIds.exists()) {
            i3 = this.protoIds.off;
        } else {
            i3 = 0;
        }
        section.writeInt(i3);
        section.writeInt(this.fieldIds.size);
        if (this.fieldIds.exists()) {
            i4 = this.fieldIds.off;
        } else {
            i4 = 0;
        }
        section.writeInt(i4);
        section.writeInt(this.methodIds.size);
        if (this.methodIds.exists()) {
            i5 = this.methodIds.off;
        } else {
            i5 = 0;
        }
        section.writeInt(i5);
        section.writeInt(this.classDefs.size);
        if (this.classDefs.exists()) {
            i6 = this.classDefs.off;
        }
        section.writeInt(i6);
        section.writeInt(this.dataSize);
        section.writeInt(this.dataOff);
    }

    private void readHeader(Dex.Section section) throws UnsupportedEncodingException {
        byte[] readByteArray = section.readByteArray(8);
        if (DexFormat.magicToApi(readByteArray) == 13) {
            this.checksum = section.readInt();
            this.signature = section.readByteArray(20);
            this.fileSize = section.readInt();
            int readInt = section.readInt();
            if (readInt == 112) {
                int readInt2 = section.readInt();
                if (readInt2 == 305419896) {
                    this.linkSize = section.readInt();
                    this.linkOff = section.readInt();
                    this.mapList.off = section.readInt();
                    if (this.mapList.off != 0) {
                        this.stringIds.size = section.readInt();
                        this.stringIds.off = section.readInt();
                        this.typeIds.size = section.readInt();
                        this.typeIds.off = section.readInt();
                        this.protoIds.size = section.readInt();
                        this.protoIds.off = section.readInt();
                        this.fieldIds.size = section.readInt();
                        this.fieldIds.off = section.readInt();
                        this.methodIds.size = section.readInt();
                        this.methodIds.off = section.readInt();
                        this.classDefs.size = section.readInt();
                        this.classDefs.off = section.readInt();
                        this.dataSize = section.readInt();
                        this.dataOff = section.readInt();
                        return;
                    }
                    throw new DexException("Cannot merge dex files that do not contain a map");
                }
                throw new DexException("Unexpected endian tag: 0x" + Integer.toHexString(readInt2));
            }
            throw new DexException("Unexpected header: 0x" + Integer.toHexString(readInt));
        }
        throw new DexException("Unexpected magic: " + Arrays.toString(readByteArray));
    }
}
