package com.xs.fm.player.sdk.play.player.video.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a extends TextureView {
    private final bl6.a a;
    private int b;
    private int c;
    private int d;

    static {
        Covode.recordClassIndex(655999);
    }

    protected final int getVideoHeight() {
        return this.c;
    }

    protected final int getVideoWidth() {
        return this.b;
    }

    protected final void setVideoHeight(int i) {
        this.c = i;
    }

    protected final void setVideoWidth(int i) {
        this.b = i;
    }

    public final void setTextureVideoStyle(int i) {
        this.d = i;
        requestLayout();
    }

    public final void a(int i, int i2) {
        if (this.b != i || this.c != i2) {
            this.a.d("setVideoSize, width = " + i + ", height = " + i2, new Object[0]);
            this.b = i;
            this.c = i2;
            requestLayout();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0099, code lost:
    
        if (r3 <= 2.128d) goto L24;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xs.fm.player.sdk.play.player.video.custom.a.onMeasure(int, int):void");
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new bl6.a("BaseTextureVideoView");
    }

    public /* synthetic */ a(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
