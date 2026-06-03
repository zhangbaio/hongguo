package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.android.dex.util.HashCodeHelper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class FieldId extends TableOfContents.Section.Item<FieldId> {
    public int declaringClassIndex;
    public int nameIndex;
    public int typeIndex;

    static {
        Covode.recordClassIndex(653611);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        return 8;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return HashCodeHelper.hash(Integer.valueOf(this.declaringClassIndex), Integer.valueOf(this.typeIndex), Integer.valueOf(this.nameIndex));
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        if (!(obj instanceof FieldId) || compareTo((FieldId) obj) != 0) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(FieldId fieldId) {
        int i = this.declaringClassIndex;
        int i2 = fieldId.declaringClassIndex;
        if (i != i2) {
            return CompareUtils.uCompare(i, i2);
        }
        int i3 = this.nameIndex;
        int i4 = fieldId.nameIndex;
        if (i3 != i4) {
            return CompareUtils.uCompare(i3, i4);
        }
        return CompareUtils.uCompare(this.typeIndex, fieldId.typeIndex);
    }

    public FieldId(int i, int i2, int i3, int i4) {
        super(i);
        this.declaringClassIndex = i2;
        this.typeIndex = i3;
        this.nameIndex = i4;
    }
}
