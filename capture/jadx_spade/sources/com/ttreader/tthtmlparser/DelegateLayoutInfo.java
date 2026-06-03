package com.ttreader.tthtmlparser;

import android.graphics.Rect;
import com.bytedance.covode.number.Covode;
import com.ttreader.tthtmlparser.position.TTPosition;
import com.ttreader.tttext.IRunDelegate;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class DelegateLayoutInfo {
    private final IRunDelegate delegate;
    private TTPosition position;
    private final Rect rect;

    static {
        Covode.recordClassIndex(654711);
    }

    public final IRunDelegate getDelegate() {
        return this.delegate;
    }

    public final TTPosition getPosition() {
        return this.position;
    }

    public final Rect getRect() {
        return this.rect;
    }

    public final void setPosition(TTPosition position) {
        Intrinsics.checkNotNullParameter(position, "position");
        this.position = position;
    }

    public DelegateLayoutInfo(TTPosition position, Rect rect, IRunDelegate iRunDelegate) {
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.position = position;
        this.rect = rect;
        this.delegate = iRunDelegate;
    }
}
