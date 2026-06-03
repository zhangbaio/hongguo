package com.ttreader.tthtmlparser;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.ttreader.tthtmlparser.position.TTPagePosition;
import com.ttreader.tthtmlparser.position.TTPosition;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class SelectionInfo {
    private final boolean dragStartOrEnd;
    private final TTPosition endDocPosition;
    private final LineLayoutBounds endPointerAttachLineInfo;
    private final TTPagePosition endPointerInfo;
    private final String postText;
    private final String preText;
    private final TTPosition startDocPosition;
    private final LineLayoutBounds startPointerAttachLineInfo;
    private final TTPagePosition startPointerInfo;
    private final String text;
    private final LineLayoutBounds visibleFirstLineInfo;
    private final LineLayoutBounds visibleLastLineInfo;

    static {
        Covode.recordClassIndex(654724);
    }

    public final TTPosition component1() {
        return this.startDocPosition;
    }

    public final String component10() {
        return this.text;
    }

    public final String component11() {
        return this.preText;
    }

    public final String component12() {
        return this.postText;
    }

    public final TTPosition component2() {
        return this.endDocPosition;
    }

    public final LineLayoutBounds component3() {
        return this.visibleFirstLineInfo;
    }

    public final LineLayoutBounds component4() {
        return this.visibleLastLineInfo;
    }

    public final TTPagePosition component5() {
        return this.startPointerInfo;
    }

    public final LineLayoutBounds component6() {
        return this.startPointerAttachLineInfo;
    }

    public final TTPagePosition component7() {
        return this.endPointerInfo;
    }

    public final LineLayoutBounds component8() {
        return this.endPointerAttachLineInfo;
    }

    public final boolean component9() {
        return this.dragStartOrEnd;
    }

    public final SelectionInfo copy(TTPosition startDocPosition, TTPosition endDocPosition, LineLayoutBounds visibleFirstLineInfo, LineLayoutBounds visibleLastLineInfo, TTPagePosition startPointerInfo, LineLayoutBounds startPointerAttachLineInfo, TTPagePosition endPointerInfo, LineLayoutBounds endPointerAttachLineInfo, boolean z, String text, String preText, String postText) {
        Intrinsics.checkNotNullParameter(startDocPosition, "startDocPosition");
        Intrinsics.checkNotNullParameter(endDocPosition, "endDocPosition");
        Intrinsics.checkNotNullParameter(visibleFirstLineInfo, "visibleFirstLineInfo");
        Intrinsics.checkNotNullParameter(visibleLastLineInfo, "visibleLastLineInfo");
        Intrinsics.checkNotNullParameter(startPointerInfo, "startPointerInfo");
        Intrinsics.checkNotNullParameter(startPointerAttachLineInfo, "startPointerAttachLineInfo");
        Intrinsics.checkNotNullParameter(endPointerInfo, "endPointerInfo");
        Intrinsics.checkNotNullParameter(endPointerAttachLineInfo, "endPointerAttachLineInfo");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(preText, "preText");
        Intrinsics.checkNotNullParameter(postText, "postText");
        return new SelectionInfo(startDocPosition, endDocPosition, visibleFirstLineInfo, visibleLastLineInfo, startPointerInfo, startPointerAttachLineInfo, endPointerInfo, endPointerAttachLineInfo, z, text, preText, postText);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectionInfo)) {
            return false;
        }
        SelectionInfo selectionInfo = (SelectionInfo) obj;
        return Intrinsics.areEqual(this.startDocPosition, selectionInfo.startDocPosition) && Intrinsics.areEqual(this.endDocPosition, selectionInfo.endDocPosition) && Intrinsics.areEqual(this.visibleFirstLineInfo, selectionInfo.visibleFirstLineInfo) && Intrinsics.areEqual(this.visibleLastLineInfo, selectionInfo.visibleLastLineInfo) && Intrinsics.areEqual(this.startPointerInfo, selectionInfo.startPointerInfo) && Intrinsics.areEqual(this.startPointerAttachLineInfo, selectionInfo.startPointerAttachLineInfo) && Intrinsics.areEqual(this.endPointerInfo, selectionInfo.endPointerInfo) && Intrinsics.areEqual(this.endPointerAttachLineInfo, selectionInfo.endPointerAttachLineInfo) && this.dragStartOrEnd == selectionInfo.dragStartOrEnd && Intrinsics.areEqual(this.text, selectionInfo.text) && Intrinsics.areEqual(this.preText, selectionInfo.preText) && Intrinsics.areEqual(this.postText, selectionInfo.postText);
    }

    public int hashCode() {
        return (((((((((((((((((((((this.startDocPosition.hashCode() * 31) + this.endDocPosition.hashCode()) * 31) + this.visibleFirstLineInfo.hashCode()) * 31) + this.visibleLastLineInfo.hashCode()) * 31) + this.startPointerInfo.hashCode()) * 31) + this.startPointerAttachLineInfo.hashCode()) * 31) + this.endPointerInfo.hashCode()) * 31) + this.endPointerAttachLineInfo.hashCode()) * 31) + m.a(this.dragStartOrEnd)) * 31) + this.text.hashCode()) * 31) + this.preText.hashCode()) * 31) + this.postText.hashCode();
    }

    public String toString() {
        return "SelectionInfo(startDocPosition=" + this.startDocPosition + ", endDocPosition=" + this.endDocPosition + ", visibleFirstLineInfo=" + this.visibleFirstLineInfo + ", visibleLastLineInfo=" + this.visibleLastLineInfo + ", startPointerInfo=" + this.startPointerInfo + ", startPointerAttachLineInfo=" + this.startPointerAttachLineInfo + ", endPointerInfo=" + this.endPointerInfo + ", endPointerAttachLineInfo=" + this.endPointerAttachLineInfo + ", dragStartOrEnd=" + this.dragStartOrEnd + ", text=" + this.text + ", preText=" + this.preText + ", postText=" + this.postText + ')';
    }

    public final boolean getDragStartOrEnd() {
        return this.dragStartOrEnd;
    }

    public final TTPosition getEndDocPosition() {
        return this.endDocPosition;
    }

    public final LineLayoutBounds getEndPointerAttachLineInfo() {
        return this.endPointerAttachLineInfo;
    }

    public final TTPagePosition getEndPointerInfo() {
        return this.endPointerInfo;
    }

    public final String getPostText() {
        return this.postText;
    }

    public final String getPreText() {
        return this.preText;
    }

    public final TTPosition getStartDocPosition() {
        return this.startDocPosition;
    }

    public final LineLayoutBounds getStartPointerAttachLineInfo() {
        return this.startPointerAttachLineInfo;
    }

    public final TTPagePosition getStartPointerInfo() {
        return this.startPointerInfo;
    }

    public final String getText() {
        return this.text;
    }

    public final LineLayoutBounds getVisibleFirstLineInfo() {
        return this.visibleFirstLineInfo;
    }

    public final LineLayoutBounds getVisibleLastLineInfo() {
        return this.visibleLastLineInfo;
    }

    public SelectionInfo(TTPosition startDocPosition, TTPosition endDocPosition, LineLayoutBounds visibleFirstLineInfo, LineLayoutBounds visibleLastLineInfo, TTPagePosition startPointerInfo, LineLayoutBounds startPointerAttachLineInfo, TTPagePosition endPointerInfo, LineLayoutBounds endPointerAttachLineInfo, boolean z, String text, String preText, String postText) {
        Intrinsics.checkNotNullParameter(startDocPosition, "startDocPosition");
        Intrinsics.checkNotNullParameter(endDocPosition, "endDocPosition");
        Intrinsics.checkNotNullParameter(visibleFirstLineInfo, "visibleFirstLineInfo");
        Intrinsics.checkNotNullParameter(visibleLastLineInfo, "visibleLastLineInfo");
        Intrinsics.checkNotNullParameter(startPointerInfo, "startPointerInfo");
        Intrinsics.checkNotNullParameter(startPointerAttachLineInfo, "startPointerAttachLineInfo");
        Intrinsics.checkNotNullParameter(endPointerInfo, "endPointerInfo");
        Intrinsics.checkNotNullParameter(endPointerAttachLineInfo, "endPointerAttachLineInfo");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(preText, "preText");
        Intrinsics.checkNotNullParameter(postText, "postText");
        this.startDocPosition = startDocPosition;
        this.endDocPosition = endDocPosition;
        this.visibleFirstLineInfo = visibleFirstLineInfo;
        this.visibleLastLineInfo = visibleLastLineInfo;
        this.startPointerInfo = startPointerInfo;
        this.startPointerAttachLineInfo = startPointerAttachLineInfo;
        this.endPointerInfo = endPointerInfo;
        this.endPointerAttachLineInfo = endPointerAttachLineInfo;
        this.dragStartOrEnd = z;
        this.text = text;
        this.preText = preText;
        this.postText = postText;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ SelectionInfo(com.ttreader.tthtmlparser.position.TTPosition r17, com.ttreader.tthtmlparser.position.TTPosition r18, com.ttreader.tthtmlparser.LineLayoutBounds r19, com.ttreader.tthtmlparser.LineLayoutBounds r20, com.ttreader.tthtmlparser.position.TTPagePosition r21, com.ttreader.tthtmlparser.LineLayoutBounds r22, com.ttreader.tthtmlparser.position.TTPagePosition r23, com.ttreader.tthtmlparser.LineLayoutBounds r24, boolean r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, int r29, kotlin.jvm.internal.DefaultConstructorMarker r30) {
        /*
            r16 = this;
            r0 = r29
            r1 = r0 & 512(0x200, float:7.17E-43)
            java.lang.String r2 = ""
            if (r1 == 0) goto La
            r13 = r2
            goto Lc
        La:
            r13 = r26
        Lc:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L12
            r14 = r2
            goto L14
        L12:
            r14 = r27
        L14:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L1a
            r15 = r2
            goto L1c
        L1a:
            r15 = r28
        L1c:
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ttreader.tthtmlparser.SelectionInfo.<init>(com.ttreader.tthtmlparser.position.TTPosition, com.ttreader.tthtmlparser.position.TTPosition, com.ttreader.tthtmlparser.LineLayoutBounds, com.ttreader.tthtmlparser.LineLayoutBounds, com.ttreader.tthtmlparser.position.TTPagePosition, com.ttreader.tthtmlparser.LineLayoutBounds, com.ttreader.tthtmlparser.position.TTPagePosition, com.ttreader.tthtmlparser.LineLayoutBounds, boolean, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
