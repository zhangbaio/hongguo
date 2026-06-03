package com.xs.fm.player.sdk.play.player.video.custom.surfaceview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.PixelCopy;
import android.view.SurfaceView;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.ss.ttvideoengine.SnapshotListener;
import com.ss.ttvideoengine.TTVideoEngine;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xk6.g;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a extends SurfaceView {
    private final bl6.a a;
    private int b;
    private int c;
    private int d;

    static {
        Covode.recordClassIndex(656028);
    }

    private static void a(SurfaceView surfaceView, Bitmap bitmap, PixelCopy.OnPixelCopyFinishedListener onPixelCopyFinishedListener, Handler handler) {
        if (new HeliosApiHook().preInvoke(102104, "android/view/PixelCopy", "request", PixelCopy.class, new Object[]{surfaceView, bitmap, onPixelCopyFinishedListener, handler}, "void", new ExtraInfo(false, "(Landroid/view/SurfaceView;Landroid/graphics/Bitmap;Landroid/view/PixelCopy$OnPixelCopyFinishedListener;Landroid/os/Handler;)V")).isIntercept()) {
            return;
        }
        PixelCopy.request(surfaceView, bitmap, onPixelCopyFinishedListener, handler);
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

    /* renamed from: com.xs.fm.player.sdk.play.player.video.custom.surfaceview.a$a, reason: collision with other inner class name */
    public static final class PixelCopyOnPixelCopyFinishedListenerC0136a implements PixelCopy.OnPixelCopyFinishedListener {
        final /* synthetic */ com.xs.fm.player.sdk.play.player.video.custom.surfaceview.b a;
        final /* synthetic */ Bitmap b;

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i) {
            this.a.onResult(i, this.b);
        }

        PixelCopyOnPixelCopyFinishedListenerC0136a(com.xs.fm.player.sdk.play.player.video.custom.surfaceview.b bVar, Bitmap bitmap) {
            this.a = bVar;
            this.b = bitmap;
        }
    }

    public static final class b implements SnapshotListener {
        final /* synthetic */ com.xs.fm.player.sdk.play.player.video.custom.surfaceview.b a;

        b(com.xs.fm.player.sdk.play.player.video.custom.surfaceview.b bVar) {
            this.a = bVar;
        }

        @Override // com.ss.ttvideoengine.SnapshotListener
        public void onSnapShot(Bitmap bitmap, int i, int i2) {
            this.a.onResult(0, bitmap);
        }
    }

    public final void setTextureVideoStyle(int i) {
        this.d = i;
        requestLayout();
    }

    public final void c(int i, int i2) {
        if (this.b != i || this.c != i2) {
            this.a.d("setVideoSize, width = " + i + ", height = " + i2, new Object[0]);
            this.b = i;
            this.c = i2;
            requestLayout();
        }
    }

    public final Bitmap b(TTVideoEngine tTVideoEngine, com.xs.fm.player.sdk.play.player.video.custom.surfaceview.b bVar) {
        if (bVar != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    Context context = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context, "context");
                    Resources resources = context.getResources();
                    Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
                    Bitmap createBitmap = Bitmap.createBitmap(resources.getDisplayMetrics(), this.b, this.c, Bitmap.Config.RGB_565);
                    a(this, createBitmap, new PixelCopyOnPixelCopyFinishedListenerC0136a(bVar, createBitmap), g.b());
                    return null;
                } catch (Throwable th) {
                    this.a.b("getSnapshotBitmap PixelCopy error" + Log.getStackTraceString(th), new Object[0]);
                    return null;
                }
            }
            tTVideoEngine.snapshot(new b(bVar));
            return null;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006a, code lost:
    
        if (r3 <= 2.128d) goto L24;
     */
    @Override // android.view.SurfaceView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xs.fm.player.sdk.play.player.video.custom.surfaceview.a.onMeasure(int, int):void");
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new bl6.a("BaseVideoSurfaceView");
    }

    public /* synthetic */ a(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
