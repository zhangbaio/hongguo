package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.android.dex.util.HashCodeHelper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class MethodId extends TableOfContents.Section.Item<MethodId> {
    public int declaringClassIndex;
    public int nameIndex;
    public int protoIndex;

    static {
        Covode.recordClassIndex(653613);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        return 8;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return HashCodeHelper.hash(Integer.valueOf(this.declaringClassIndex), Integer.valueOf(this.protoIndex), Integer.valueOf(this.nameIndex));
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        if (!(obj instanceof MethodId) || compareTo((MethodId) obj) != 0) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(MethodId methodId) {
        int i = this.declaringClassIndex;
        int i2 = methodId.declaringClassIndex;
        if (i != i2) {
            return CompareUtils.uCompare(i, i2);
        }
        int i3 = this.nameIndex;
        int i4 = methodId.nameIndex;
        if (i3 != i4) {
            return CompareUtils.uCompare(i3, i4);
        }
        return CompareUtils.uCompare(this.protoIndex, methodId.protoIndex);
    }

    public MethodId(int i, int i2, int i3, int i4) {
        super(i);
        this.declaringClassIndex = i2;
        this.protoIndex = i3;
        this.nameIndex = i4;
    }
}
