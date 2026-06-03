package com.ttreader.tthtmlparser.highlight;

import com.bytedance.covode.number.Covode;
import com.ttreader.tthtmlparser.position.TTPosition;
import java.io.DataOutputStream;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class HighLightInfo {
    private final boolean clickable;
    private final int drawPriority;
    private final TTPosition end;
    private final TTPosition start;
    private final HighlightStyle style;

    static {
        Covode.recordClassIndex(654770);
    }

    public final boolean getClickable() {
        return this.clickable;
    }

    public final int getDrawPriority() {
        return this.drawPriority;
    }

    public final TTPosition getEnd() {
        return this.end;
    }

    public final TTPosition getStart() {
        return this.start;
    }

    public final HighlightStyle getStyle() {
        return this.style;
    }

    public final void convertBytes$TTHtmlParser_release(DataOutputStream output) {
        Intrinsics.checkNotNullParameter(output, "output");
        this.start.convertBytes$TTHtmlParser_release(output);
        this.end.convertBytes$TTHtmlParser_release(output);
        this.style.convertBytes$TTHtmlParser_release(output);
        output.writeBoolean(this.clickable);
        output.writeInt(this.drawPriority);
    }

    public HighLightInfo(TTPosition start, TTPosition end, HighlightStyle style, boolean z, int i) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(style, "style");
        this.start = start;
        this.end = end;
        this.style = style;
        this.clickable = z;
        this.drawPriority = i;
    }
}
