package com.ttreader.tthtmlparser.position;

import android.graphics.PointF;
import com.bytedance.covode.number.Covode;
import com.ttreader.tthtmlparser.TTEpubUtils;
import java.io.DataOutputStream;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TTPagePosition {
    private final int pageIndex;
    private final float x;
    private final float y;

    static {
        Covode.recordClassIndex(654781);
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final void writeStream(DataOutputStream output) {
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeInt(this.pageIndex);
        output.writeFloat(TTEpubUtils.Px2Dp(this.x + 0.5f));
        output.writeFloat(TTEpubUtils.Px2Dp(this.y + 0.5f));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TTPagePosition(int i, PointF pointF) {
        this(i, pointF.x, pointF.y);
        Intrinsics.checkNotNullParameter(pointF, "pointF");
    }

    public TTPagePosition(int i, float f, float f2) {
        this.pageIndex = i;
        this.x = f;
        this.y = f2;
    }
}
