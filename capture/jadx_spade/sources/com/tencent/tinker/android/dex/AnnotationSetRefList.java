package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import java.util.Arrays;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class AnnotationSetRefList extends TableOfContents.Section.Item<AnnotationSetRefList> {
    public int[] annotationSetRefItems;

    static {
        Covode.recordClassIndex(653585);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        return (this.annotationSetRefItems.length + 1) * 4;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return Arrays.hashCode(this.annotationSetRefItems);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        if (!(obj instanceof AnnotationSetRefList) || compareTo((AnnotationSetRefList) obj) != 0) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(AnnotationSetRefList annotationSetRefList) {
        int length = this.annotationSetRefItems.length;
        int length2 = annotationSetRefList.annotationSetRefItems.length;
        if (length != length2) {
            return CompareUtils.uCompare(length, length2);
        }
        for (int i = 0; i < length; i++) {
            int i2 = this.annotationSetRefItems[i];
            int i3 = annotationSetRefList.annotationSetRefItems[i];
            if (i2 != i3) {
                return CompareUtils.uCompare(i2, i3);
            }
        }
        return 0;
    }

    public AnnotationSetRefList(int i, int[] iArr) {
        super(i);
        this.annotationSetRefItems = iArr;
    }
}
