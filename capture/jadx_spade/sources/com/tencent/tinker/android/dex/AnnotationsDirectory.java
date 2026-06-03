package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.android.dex.util.HashCodeHelper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class AnnotationsDirectory extends TableOfContents.Section.Item<AnnotationsDirectory> {
    public int classAnnotationsOffset;
    public int[][] fieldAnnotations;
    public int[][] methodAnnotations;
    public int[][] parameterAnnotations;

    static {
        Covode.recordClassIndex(653586);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        return (((this.fieldAnnotations.length + this.methodAnnotations.length + this.parameterAnnotations.length) * 2) + 4) * 4;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return HashCodeHelper.hash(Integer.valueOf(this.classAnnotationsOffset), this.fieldAnnotations, this.methodAnnotations, this.parameterAnnotations);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        if (!(obj instanceof AnnotationsDirectory) || compareTo((AnnotationsDirectory) obj) != 0) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(AnnotationsDirectory annotationsDirectory) {
        int i = this.classAnnotationsOffset;
        int i2 = annotationsDirectory.classAnnotationsOffset;
        if (i != i2) {
            return CompareUtils.uCompare(i, i2);
        }
        int length = this.fieldAnnotations.length;
        int length2 = this.methodAnnotations.length;
        int length3 = this.parameterAnnotations.length;
        int length4 = annotationsDirectory.fieldAnnotations.length;
        int length5 = annotationsDirectory.methodAnnotations.length;
        int length6 = annotationsDirectory.parameterAnnotations.length;
        if (length != length4) {
            return CompareUtils.sCompare(length, length4);
        }
        if (length2 != length5) {
            return CompareUtils.sCompare(length2, length5);
        }
        if (length3 != length6) {
            return CompareUtils.sCompare(length3, length6);
        }
        for (int i3 = 0; i3 < length; i3++) {
            int[] iArr = this.fieldAnnotations[i3];
            int i4 = iArr[0];
            int i5 = iArr[1];
            int[] iArr2 = annotationsDirectory.fieldAnnotations[i3];
            int i6 = iArr2[0];
            int i7 = iArr2[1];
            if (i4 != i6) {
                return CompareUtils.uCompare(i4, i6);
            }
            if (i5 != i7) {
                return CompareUtils.sCompare(i5, i7);
            }
        }
        for (int i8 = 0; i8 < length2; i8++) {
            int[] iArr3 = this.methodAnnotations[i8];
            int i9 = iArr3[0];
            int i10 = iArr3[1];
            int[] iArr4 = annotationsDirectory.methodAnnotations[i8];
            int i11 = iArr4[0];
            int i12 = iArr4[1];
            if (i9 != i11) {
                return CompareUtils.uCompare(i9, i11);
            }
            if (i10 != i12) {
                return CompareUtils.sCompare(i10, i12);
            }
        }
        for (int i13 = 0; i13 < length3; i13++) {
            int[] iArr5 = this.parameterAnnotations[i13];
            int i14 = iArr5[0];
            int i15 = iArr5[1];
            int[] iArr6 = annotationsDirectory.parameterAnnotations[i13];
            int i16 = iArr6[0];
            int i17 = iArr6[1];
            if (i14 != i16) {
                return CompareUtils.uCompare(i14, i16);
            }
            if (i15 != i17) {
                return CompareUtils.sCompare(i15, i17);
            }
        }
        return 0;
    }

    public AnnotationsDirectory(int i, int i2, int[][] iArr, int[][] iArr2, int[][] iArr3) {
        super(i);
        this.classAnnotationsOffset = i2;
        this.fieldAnnotations = iArr;
        this.methodAnnotations = iArr2;
        this.parameterAnnotations = iArr3;
    }
}
