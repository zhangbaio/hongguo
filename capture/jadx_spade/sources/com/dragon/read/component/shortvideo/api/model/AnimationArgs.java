package com.dragon.read.component.shortvideo.api.model;

import android.graphics.PointF;
import android.view.View;
import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class AnimationArgs implements Serializable {
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private final int cardHeight;
    private final int cardWidth;
    private final float coverEndTransX;
    private final float coverEndTransY;
    private SeriesTransition coverEnterTransition;
    private SeriesTransition coverExitTransition;
    private final float coverScaleX;
    private final float coverScaleY;
    private final int coverStartHeight;
    private final int coverStartWidth;
    private final float coverTransX;
    private final float coverTransY;
    private boolean disableExtraGroupTransition;
    private boolean disableExtraTransition;
    private boolean disableShareElementTransition;
    private SeriesTransition extraEnterTransition;
    private SeriesTransition extraExitTransition;
    private SeriesTransition extraGroupEnterTransition;
    private SeriesTransition extraGroupExitTransition;
    private final int extraStartHeight;
    private final int extraStartWidth;
    private final float extraTransX;
    private final float extraTransY;
    private boolean fixedViewPagerSizeWhenTransition;
    private final boolean hasReturnTransition;
    private boolean initViewPagerAfterTransition;
    private SeriesTransition pageEnterTransition;
    private SeriesTransition pageExitTransition;
    private final int screenHeight;
    private boolean useTotalDuration;

    static {
        Covode.recordClassIndex(598759);
        Companion = new a(null);
    }

    public AnimationArgs() {
        this(0, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 0, 0, false, 65535, null);
    }

    public final int getCardHeight() {
        return this.cardHeight;
    }

    public final int getCardWidth() {
        return this.cardWidth;
    }

    public final float getCoverEndTransX() {
        return this.coverEndTransX;
    }

    public final float getCoverEndTransY() {
        return this.coverEndTransY;
    }

    public final SeriesTransition getCoverEnterTransition() {
        return this.coverEnterTransition;
    }

    public final SeriesTransition getCoverExitTransition() {
        return this.coverExitTransition;
    }

    public final float getCoverScaleX() {
        return this.coverScaleX;
    }

    public final float getCoverScaleY() {
        return this.coverScaleY;
    }

    public final int getCoverStartHeight() {
        return this.coverStartHeight;
    }

    public final int getCoverStartWidth() {
        return this.coverStartWidth;
    }

    public final float getCoverTransX() {
        return this.coverTransX;
    }

    public final float getCoverTransY() {
        return this.coverTransY;
    }

    public final boolean getDisableExtraGroupTransition() {
        return this.disableExtraGroupTransition;
    }

    public final boolean getDisableExtraTransition() {
        return this.disableExtraTransition;
    }

    public final boolean getDisableShareElementTransition() {
        return this.disableShareElementTransition;
    }

    public final SeriesTransition getExtraEnterTransition() {
        return this.extraEnterTransition;
    }

    public final SeriesTransition getExtraExitTransition() {
        return this.extraExitTransition;
    }

    public final SeriesTransition getExtraGroupEnterTransition() {
        return this.extraGroupEnterTransition;
    }

    public final SeriesTransition getExtraGroupExitTransition() {
        return this.extraGroupExitTransition;
    }

    public final int getExtraStartHeight() {
        return this.extraStartHeight;
    }

    public final int getExtraStartWidth() {
        return this.extraStartWidth;
    }

    public final float getExtraTransX() {
        return this.extraTransX;
    }

    public final float getExtraTransY() {
        return this.extraTransY;
    }

    public final boolean getFixedViewPagerSizeWhenTransition() {
        return this.fixedViewPagerSizeWhenTransition;
    }

    public final boolean getHasReturnTransition() {
        return this.hasReturnTransition;
    }

    public final boolean getInitViewPagerAfterTransition() {
        return this.initViewPagerAfterTransition;
    }

    public final SeriesTransition getPageEnterTransition() {
        return this.pageEnterTransition;
    }

    public final SeriesTransition getPageExitTransition() {
        return this.pageExitTransition;
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final boolean getUseTotalDuration() {
        return this.useTotalDuration;
    }

    public final void setCoverEnterTransition(SeriesTransition seriesTransition) {
        this.coverEnterTransition = seriesTransition;
    }

    public final void setCoverExitTransition(SeriesTransition seriesTransition) {
        this.coverExitTransition = seriesTransition;
    }

    public final void setDisableExtraGroupTransition(boolean z) {
        this.disableExtraGroupTransition = z;
    }

    public final void setDisableExtraTransition(boolean z) {
        this.disableExtraTransition = z;
    }

    public final void setDisableShareElementTransition(boolean z) {
        this.disableShareElementTransition = z;
    }

    public final void setExtraEnterTransition(SeriesTransition seriesTransition) {
        this.extraEnterTransition = seriesTransition;
    }

    public final void setExtraExitTransition(SeriesTransition seriesTransition) {
        this.extraExitTransition = seriesTransition;
    }

    public final void setExtraGroupEnterTransition(SeriesTransition seriesTransition) {
        this.extraGroupEnterTransition = seriesTransition;
    }

    public final void setExtraGroupExitTransition(SeriesTransition seriesTransition) {
        this.extraGroupExitTransition = seriesTransition;
    }

    public final void setFixedViewPagerSizeWhenTransition(boolean z) {
        this.fixedViewPagerSizeWhenTransition = z;
    }

    public final void setInitViewPagerAfterTransition(boolean z) {
        this.initViewPagerAfterTransition = z;
    }

    public final void setPageEnterTransition(SeriesTransition seriesTransition) {
        this.pageEnterTransition = seriesTransition;
    }

    public final void setPageExitTransition(SeriesTransition seriesTransition) {
        this.pageExitTransition = seriesTransition;
    }

    public final void setUseTotalDuration(boolean z) {
        this.useTotalDuration = z;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598760);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PointF a(View view, int i, int i2) {
            Intrinsics.checkNotNullParameter(view, "view");
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            float f = i3;
            if (i == 0) {
                i = view.getWidth();
            }
            float f2 = f + (i / 2.0f);
            float f3 = i4;
            if (i2 == 0) {
                i2 = view.getHeight();
            }
            return new PointF(f2, f3 + (i2 / 2.0f));
        }

        public static /* synthetic */ PointF b(a aVar, View view, int i, int i2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            return aVar.a(view, i, i2);
        }
    }

    public AnimationArgs(int i, float f, float f2, int i2, int i3, float f3, float f4, float f5, float f6, int i4, int i5, float f7, float f8, int i6, int i7, boolean z) {
        this.screenHeight = i;
        this.coverTransX = f;
        this.coverTransY = f2;
        this.coverStartWidth = i2;
        this.coverStartHeight = i3;
        this.coverScaleX = f3;
        this.coverScaleY = f4;
        this.coverEndTransX = f5;
        this.coverEndTransY = f6;
        this.extraStartWidth = i4;
        this.extraStartHeight = i5;
        this.extraTransX = f7;
        this.extraTransY = f8;
        this.cardWidth = i6;
        this.cardHeight = i7;
        this.hasReturnTransition = z;
        this.useTotalDuration = true;
        this.initViewPagerAfterTransition = true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ AnimationArgs(int r18, float r19, float r20, int r21, int r22, float r23, float r24, float r25, float r26, int r27, int r28, float r29, float r30, int r31, int r32, boolean r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.model.AnimationArgs.<init>(int, float, float, int, int, float, float, float, float, int, int, float, float, int, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
