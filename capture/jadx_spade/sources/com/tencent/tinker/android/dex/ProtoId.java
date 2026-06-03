package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.android.dex.util.HashCodeHelper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ProtoId extends TableOfContents.Section.Item<ProtoId> {
    public int parametersOffset;
    public int returnTypeIndex;
    public int shortyIndex;

    static {
        Covode.recordClassIndex(653615);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        return 12;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return HashCodeHelper.hash(Integer.valueOf(this.shortyIndex), Integer.valueOf(this.returnTypeIndex), Integer.valueOf(this.parametersOffset));
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        if (!(obj instanceof ProtoId) || compareTo((ProtoId) obj) != 0) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(ProtoId protoId) {
        int uCompare = CompareUtils.uCompare(this.shortyIndex, protoId.shortyIndex);
        if (uCompare != 0) {
            return uCompare;
        }
        int uCompare2 = CompareUtils.uCompare(this.returnTypeIndex, protoId.returnTypeIndex);
        if (uCompare2 != 0) {
            return uCompare2;
        }
        return CompareUtils.sCompare(this.parametersOffset, protoId.parametersOffset);
    }

    public ProtoId(int i, int i2, int i3, int i4) {
        super(i);
        this.shortyIndex = i2;
        this.returnTypeIndex = i3;
        this.parametersOffset = i4;
    }
}
