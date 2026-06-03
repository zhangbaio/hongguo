package com.ttreader.tthtmlparser.highlight;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.ttreader.tthtmlparser.Range;
import com.ttreader.tttext.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class HighlightRange {
    private final boolean canMerge;
    private final boolean clickable;
    private final long drawPriority;
    private final int endOffsetInChapter;
    private final String highlightId;
    private final boolean needDrawSorted;
    private final int startOffsetInChapter;
    private final HighlightStyle style;

    static {
        Covode.recordClassIndex(654771);
    }

    public final int component1() {
        return this.startOffsetInChapter;
    }

    public final int component2() {
        return this.endOffsetInChapter;
    }

    public final HighlightStyle component3() {
        return this.style;
    }

    public final String component4() {
        return this.highlightId;
    }

    public final boolean component5() {
        return this.canMerge;
    }

    public final boolean component6() {
        return this.needDrawSorted;
    }

    public final long component7() {
        return this.drawPriority;
    }

    public final boolean component8() {
        return this.clickable;
    }

    public final HighlightRange copy(int i, int i2, HighlightStyle style, String highlightId, boolean z, boolean z2, long j, boolean z3) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(highlightId, "highlightId");
        return new HighlightRange(i, i2, style, highlightId, z, z2, j, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HighlightRange)) {
            return false;
        }
        HighlightRange highlightRange = (HighlightRange) obj;
        return this.startOffsetInChapter == highlightRange.startOffsetInChapter && this.endOffsetInChapter == highlightRange.endOffsetInChapter && Intrinsics.areEqual(this.style, highlightRange.style) && Intrinsics.areEqual(this.highlightId, highlightRange.highlightId) && this.canMerge == highlightRange.canMerge && this.needDrawSorted == highlightRange.needDrawSorted && this.drawPriority == highlightRange.drawPriority && this.clickable == highlightRange.clickable;
    }

    public int hashCode() {
        return (((((((((((((this.startOffsetInChapter * 31) + this.endOffsetInChapter) * 31) + this.style.hashCode()) * 31) + this.highlightId.hashCode()) * 31) + m.a(this.canMerge)) * 31) + m.a(this.needDrawSorted)) * 31) + j.a(this.drawPriority)) * 31) + m.a(this.clickable);
    }

    public String toString() {
        return "HighlightRange(startOffsetInChapter=" + this.startOffsetInChapter + ", endOffsetInChapter=" + this.endOffsetInChapter + ", style=" + this.style + ", highlightId=" + this.highlightId + ", canMerge=" + this.canMerge + ", needDrawSorted=" + this.needDrawSorted + ", drawPriority=" + this.drawPriority + ", clickable=" + this.clickable + ')';
    }

    public final boolean getCanMerge() {
        return this.canMerge;
    }

    public final boolean getClickable() {
        return this.clickable;
    }

    public final long getDrawPriority() {
        return this.drawPriority;
    }

    public final int getEndOffsetInChapter() {
        return this.endOffsetInChapter;
    }

    public final String getHighlightId() {
        return this.highlightId;
    }

    public final boolean getNeedDrawSorted() {
        return this.needDrawSorted;
    }

    public final int getStartOffsetInChapter() {
        return this.startOffsetInChapter;
    }

    public final HighlightStyle getStyle() {
        return this.style;
    }

    public final byte[] convertBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b bVar = new b(byteArrayOutputStream);
        try {
            bVar.writeInt(this.startOffsetInChapter);
            bVar.writeInt(this.endOffsetInChapter);
            this.style.convertBytes$TTHtmlParser_release(bVar);
            bVar.writeBoolean(this.canMerge);
            bVar.writeBoolean(this.needDrawSorted);
            bVar.writeLong(this.drawPriority);
            bVar.writeBoolean(this.clickable);
            bVar.a(this.highlightId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HighlightRange(Range range, String highlightId) {
        this(range.start(), range.end(), null, highlightId, false, false, 0L, false, 244, null);
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(highlightId, "highlightId");
    }

    public HighlightRange(int i, int i2, HighlightStyle style, String highlightId, boolean z, boolean z2, long j, boolean z3) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(highlightId, "highlightId");
        this.startOffsetInChapter = i;
        this.endOffsetInChapter = i2;
        this.style = style;
        this.highlightId = highlightId;
        this.canMerge = z;
        this.needDrawSorted = z2;
        this.drawPriority = j;
        this.clickable = z3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ HighlightRange(int r16, int r17, com.ttreader.tthtmlparser.highlight.HighlightStyle r18, java.lang.String r19, boolean r20, boolean r21, long r22, boolean r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r15 = this;
            r0 = r25
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L10
            com.ttreader.tthtmlparser.highlight.HighlightStyle r1 = new com.ttreader.tthtmlparser.highlight.HighlightStyle
            r3 = 3
            r4 = 0
            r1.<init>(r4, r2, r3, r4)
            r8 = r1
            goto L12
        L10:
            r8 = r18
        L12:
            r1 = r0 & 8
            if (r1 == 0) goto L1a
            java.lang.String r1 = ""
            r9 = r1
            goto L1c
        L1a:
            r9 = r19
        L1c:
            r1 = r0 & 16
            if (r1 == 0) goto L22
            r10 = 0
            goto L24
        L22:
            r10 = r20
        L24:
            r1 = r0 & 32
            if (r1 == 0) goto L2a
            r11 = 0
            goto L2c
        L2a:
            r11 = r21
        L2c:
            r1 = r0 & 64
            if (r1 == 0) goto L36
            long r3 = java.lang.System.currentTimeMillis()
            r12 = r3
            goto L38
        L36:
            r12 = r22
        L38:
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L3e
            r14 = 0
            goto L40
        L3e:
            r14 = r24
        L40:
            r5 = r15
            r6 = r16
            r7 = r17
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ttreader.tthtmlparser.highlight.HighlightRange.<init>(int, int, com.ttreader.tthtmlparser.highlight.HighlightStyle, java.lang.String, boolean, boolean, long, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
