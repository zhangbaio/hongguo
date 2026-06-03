package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.android.dex.util.HashCodeHelper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ClassDef extends TableOfContents.Section.Item<ClassDef> {
    public int accessFlags;
    public int annotationsOffset;
    public int classDataOffset;
    public int interfacesOffset;
    public int sourceFileIndex;
    public int staticValuesOffset;
    public int supertypeIndex;
    public int typeIndex;

    static {
        Covode.recordClassIndex(653590);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        return 32;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return HashCodeHelper.hash(Integer.valueOf(this.typeIndex), Integer.valueOf(this.accessFlags), Integer.valueOf(this.supertypeIndex), Integer.valueOf(this.interfacesOffset), Integer.valueOf(this.sourceFileIndex), Integer.valueOf(this.annotationsOffset), Integer.valueOf(this.classDataOffset), Integer.valueOf(this.staticValuesOffset));
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        if (!(obj instanceof ClassDef) || compareTo((ClassDef) obj) != 0) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(ClassDef classDef) {
        int uCompare = CompareUtils.uCompare(this.typeIndex, classDef.typeIndex);
        if (uCompare != 0) {
            return uCompare;
        }
        int sCompare = CompareUtils.sCompare(this.accessFlags, classDef.accessFlags);
        if (sCompare != 0) {
            return sCompare;
        }
        int uCompare2 = CompareUtils.uCompare(this.supertypeIndex, classDef.supertypeIndex);
        if (uCompare2 != 0) {
            return uCompare2;
        }
        int sCompare2 = CompareUtils.sCompare(this.interfacesOffset, classDef.interfacesOffset);
        if (sCompare2 != 0) {
            return sCompare2;
        }
        int uCompare3 = CompareUtils.uCompare(this.sourceFileIndex, classDef.sourceFileIndex);
        if (uCompare3 != 0) {
            return uCompare3;
        }
        int sCompare3 = CompareUtils.sCompare(this.annotationsOffset, classDef.annotationsOffset);
        if (sCompare3 != 0) {
            return sCompare3;
        }
        int sCompare4 = CompareUtils.sCompare(this.classDataOffset, classDef.classDataOffset);
        if (sCompare4 != 0) {
            return sCompare4;
        }
        return CompareUtils.sCompare(this.staticValuesOffset, classDef.staticValuesOffset);
    }

    public ClassDef(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        super(i);
        this.typeIndex = i2;
        this.accessFlags = i3;
        this.supertypeIndex = i4;
        this.interfacesOffset = i5;
        this.sourceFileIndex = i6;
        this.annotationsOffset = i7;
        this.classDataOffset = i8;
        this.staticValuesOffset = i9;
    }
}
