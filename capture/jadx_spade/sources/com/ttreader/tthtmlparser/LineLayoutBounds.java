package com.ttreader.tthtmlparser;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class LineLayoutBounds {
    private final float height;
    private final float left;
    private final int lineIndex;
    private final int pageIndex;
    private final float top;
    private final float width;

    static {
        Covode.recordClassIndex(654718);
    }

    public LineLayoutBounds() {
        this(0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 63, null);
    }

    public static /* synthetic */ LineLayoutBounds copy$default(LineLayoutBounds lineLayoutBounds, int i, int i2, float f, float f2, float f3, float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = lineLayoutBounds.pageIndex;
        }
        if ((i3 & 2) != 0) {
            i2 = lineLayoutBounds.lineIndex;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            f = lineLayoutBounds.left;
        }
        float f5 = f;
        if ((i3 & 8) != 0) {
            f2 = lineLayoutBounds.top;
        }
        float f6 = f2;
        if ((i3 & 16) != 0) {
            f3 = lineLayoutBounds.width;
        }
        float f7 = f3;
        if ((i3 & 32) != 0) {
            f4 = lineLayoutBounds.height;
        }
        return lineLayoutBounds.copy(i, i4, f5, f6, f7, f4);
    }

    public final int component1() {
        return this.pageIndex;
    }

    public final int component2() {
        return this.lineIndex;
    }

    public final float component3() {
        return this.left;
    }

    public final float component4() {
        return this.top;
    }

    public final float component5() {
        return this.width;
    }

    public final float component6() {
        return this.height;
    }

    public final LineLayoutBounds copy(int i, int i2, float f, float f2, float f3, float f4) {
        return new LineLayoutBounds(i, i2, f, f2, f3, f4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineLayoutBounds)) {
            return false;
        }
        LineLayoutBounds lineLayoutBounds = (LineLayoutBounds) obj;
        return this.pageIndex == lineLayoutBounds.pageIndex && this.lineIndex == lineLayoutBounds.lineIndex && Float.compare(this.left, lineLayoutBounds.left) == 0 && Float.compare(this.top, lineLayoutBounds.top) == 0 && Float.compare(this.width, lineLayoutBounds.width) == 0 && Float.compare(this.height, lineLayoutBounds.height) == 0;
    }

    public int hashCode() {
        return (((((((((this.pageIndex * 31) + this.lineIndex) * 31) + Float.floatToIntBits(this.left)) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.width)) * 31) + Float.floatToIntBits(this.height);
    }

    public String toString() {
        return "LineLayoutBounds(pageIndex=" + this.pageIndex + ", lineIndex=" + this.lineIndex + ", left=" + this.left + ", top=" + this.top + ", width=" + this.width + ", height=" + this.height + ')';
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getLeft() {
        return this.left;
    }

    public final int getLineIndex() {
        return this.lineIndex;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public final float getTop() {
        return this.top;
    }

    public final float getWidth() {
        return this.width;
    }

    public LineLayoutBounds(int i, int i2, float f, float f2, float f3, float f4) {
        this.pageIndex = i;
        this.lineIndex = i2;
        this.left = f;
        this.top = f2;
        this.width = f3;
        this.height = f4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ LineLayoutBounds(int r5, int r6, float r7, float r8, float r9, float r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            r0 = -1
            if (r12 == 0) goto L7
            r12 = -1
            goto L8
        L7:
            r12 = r5
        L8:
            r5 = r11 & 2
            if (r5 == 0) goto Ld
            goto Le
        Ld:
            r0 = r6
        Le:
            r5 = r11 & 4
            r6 = 0
            if (r5 == 0) goto L15
            r1 = 0
            goto L16
        L15:
            r1 = r7
        L16:
            r5 = r11 & 8
            if (r5 == 0) goto L1c
            r2 = 0
            goto L1d
        L1c:
            r2 = r8
        L1d:
            r5 = r11 & 16
            if (r5 == 0) goto L23
            r3 = 0
            goto L24
        L23:
            r3 = r9
        L24:
            r5 = r11 & 32
            if (r5 == 0) goto L2a
            r11 = 0
            goto L2b
        L2a:
            r11 = r10
        L2b:
            r5 = r4
            r6 = r12
            r7 = r0
            r8 = r1
            r9 = r2
            r10 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ttreader.tthtmlparser.LineLayoutBounds.<init>(int, int, float, float, float, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
