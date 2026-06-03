package com.ttreader.tthtmlparser;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTEpubPageData {
    private final int[] data;
    private final int lineDataOffset;
    private final int paraCount;
    private final int paraIndexOffset;
    private final int paraRangeOffset;
    public final Range range;
    public final int rowCount;

    static {
        Covode.recordClassIndex(654749);
    }

    public Range getLineRange(int i) {
        int i2 = this.lineDataOffset + (i * 2);
        int[] iArr = this.data;
        return new Range(iArr[i2], iArr[i2 + 1]);
    }

    public TTEpubPageData(int[] iArr) {
        this.data = iArr;
        this.range = new Range(iArr[0], iArr[1]);
        int i = iArr[2];
        this.rowCount = i;
        int i2 = iArr[3];
        this.paraCount = i2;
        this.lineDataOffset = 4;
        int i3 = 4 + (i * 2);
        this.paraIndexOffset = i3;
        this.paraRangeOffset = i3 + i2;
    }

    public int getParagraphIndexByRange(Range range) {
        for (int i = 0; i < this.paraCount; i++) {
            int i2 = i * 2;
            if (range.location >= this.data[this.paraRangeOffset + i2]) {
                int end = range.end();
                int[] iArr = this.data;
                if (end <= iArr[this.paraRangeOffset + i2 + 1]) {
                    return iArr[this.paraIndexOffset + i];
                }
            }
        }
        return -1;
    }

    public Range getParagraphRange(int i) {
        for (int i2 = 0; i2 < this.paraCount; i2++) {
            if (this.data[this.paraIndexOffset + i2] == i) {
                int[] iArr = this.data;
                int i3 = this.paraRangeOffset;
                int i4 = i2 * 2;
                return new Range(iArr[i3 + i4], iArr[i3 + i4 + 1]);
            }
        }
        return new Range(0, 0);
    }
}
