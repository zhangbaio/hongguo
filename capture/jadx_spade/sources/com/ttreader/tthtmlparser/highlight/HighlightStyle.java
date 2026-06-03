package com.ttreader.tthtmlparser.highlight;

import com.bytedance.covode.number.Covode;
import java.io.DataOutputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class HighlightStyle {
    private final int color;
    private final MarkStyle markStyle;

    static {
        Covode.recordClassIndex(654772);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HighlightStyle() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ HighlightStyle copy$default(HighlightStyle highlightStyle, MarkStyle markStyle, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            markStyle = highlightStyle.markStyle;
        }
        if ((i2 & 2) != 0) {
            i = highlightStyle.color;
        }
        return highlightStyle.copy(markStyle, i);
    }

    public final MarkStyle component1() {
        return this.markStyle;
    }

    public final int component2() {
        return this.color;
    }

    public final HighlightStyle copy(MarkStyle markStyle, int i) {
        Intrinsics.checkNotNullParameter(markStyle, "markStyle");
        return new HighlightStyle(markStyle, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HighlightStyle)) {
            return false;
        }
        HighlightStyle highlightStyle = (HighlightStyle) obj;
        return this.markStyle == highlightStyle.markStyle && this.color == highlightStyle.color;
    }

    public int hashCode() {
        return (this.markStyle.hashCode() * 31) + this.color;
    }

    public String toString() {
        return "HighlightStyle(markStyle=" + this.markStyle + ", color=" + this.color + ')';
    }

    public final int getColor() {
        return this.color;
    }

    public final MarkStyle getMarkStyle() {
        return this.markStyle;
    }

    public final void convertBytes$TTHtmlParser_release(DataOutputStream output) {
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeInt(this.markStyle.ordinal());
        output.writeInt(this.color);
    }

    public HighlightStyle(MarkStyle markStyle, int i) {
        Intrinsics.checkNotNullParameter(markStyle, "markStyle");
        this.markStyle = markStyle;
        this.color = i;
    }

    public /* synthetic */ HighlightStyle(MarkStyle markStyle, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? MarkStyle.Background : markStyle, (i2 & 2) != 0 ? 0 : i);
    }
}
