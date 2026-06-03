package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import java.util.Arrays;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class AnnotationSet extends TableOfContents.Section.Item<AnnotationSet> {
    public int[] annotationOffsets;

    static {
        Covode.recordClassIndex(653584);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        return (this.annotationOffsets.length + 1) * 4;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return Arrays.hashCode(this.annotationOffsets);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        if (!(obj instanceof AnnotationSet) || compareTo((AnnotationSet) obj) != 0) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(AnnotationSet annotationSet) {
        int length = this.annotationOffsets.length;
        int length2 = annotationSet.annotationOffsets.length;
        if (length != length2) {
            return CompareUtils.uCompare(length, length2);
        }
        for (int i = 0; i < length; i++) {
            int i2 = this.annotationOffsets[i];
            int i3 = annotationSet.annotationOffsets[i];
            if (i2 != i3) {
                return CompareUtils.uCompare(i2, i3);
            }
        }
        return 0;
    }

    public AnnotationSet(int i, int[] iArr) {
        super(i);
        this.annotationOffsets = iArr;
    }
}
