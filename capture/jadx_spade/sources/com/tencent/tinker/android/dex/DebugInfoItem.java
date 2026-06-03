package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.android.dex.util.HashCodeHelper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DebugInfoItem extends TableOfContents.Section.Item<DebugInfoItem> {
    public byte[] infoSTM;
    public int lineStart;
    public int[] parameterNames;

    static {
        Covode.recordClassIndex(653594);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return HashCodeHelper.hash(Integer.valueOf(this.lineStart), this.parameterNames, this.infoSTM);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        int unsignedLeb128Size = Leb128.unsignedLeb128Size(this.lineStart) + Leb128.unsignedLeb128Size(this.parameterNames.length);
        for (int i : this.parameterNames) {
            unsignedLeb128Size += Leb128.unsignedLeb128p1Size(i);
        }
        return unsignedLeb128Size + (this.infoSTM.length * 1);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        if (!(obj instanceof DebugInfoItem) || compareTo((DebugInfoItem) obj) != 0) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(DebugInfoItem debugInfoItem) {
        int i = this.lineStart;
        int i2 = debugInfoItem.lineStart;
        if (i != i2) {
            return i - i2;
        }
        int uArrCompare = CompareUtils.uArrCompare(this.parameterNames, debugInfoItem.parameterNames);
        if (uArrCompare != 0) {
            return uArrCompare;
        }
        return CompareUtils.uArrCompare(this.infoSTM, debugInfoItem.infoSTM);
    }

    public DebugInfoItem(int i, int i2, int[] iArr, byte[] bArr) {
        super(i);
        this.lineStart = i2;
        this.parameterNames = iArr;
        this.infoSTM = bArr;
    }
}
