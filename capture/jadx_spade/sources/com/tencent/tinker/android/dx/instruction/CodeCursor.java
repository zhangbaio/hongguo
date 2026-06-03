package com.tencent.tinker.android.dx.instruction;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.utils.SparseIntArray;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class CodeCursor {
    private final SparseIntArray baseAddressMap = new SparseIntArray();
    private int cursor = 0;

    static {
        Covode.recordClassIndex(653628);
    }

    public final int cursor() {
        return this.cursor;
    }

    public void reset() {
        this.baseAddressMap.clear();
        this.cursor = 0;
    }

    public final int baseAddressForCursor() {
        int indexOfKey = this.baseAddressMap.indexOfKey(this.cursor);
        if (indexOfKey < 0) {
            return this.cursor;
        }
        return this.baseAddressMap.valueAt(indexOfKey);
    }

    protected final void advance(int i) {
        this.cursor += i;
    }

    public final void setBaseAddress(int i, int i2) {
        this.baseAddressMap.put(i, i2);
    }
}
