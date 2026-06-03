package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttm.player.ITTRenderView;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
class TTSurfaceView extends SurfaceView implements ITTRenderView {
    int mFixedSizeWidth;
    private ITTRenderView.RenderCallback mRenderCallback;
    private Surface mSurface;

    static {
        Covode.recordClassIndex(652198);
    }

    private static void com_ss_ttm_player_TTSurfaceView_android_view_PixelCopy_request(SurfaceView surfaceView, Bitmap bitmap, PixelCopy.OnPixelCopyFinishedListener onPixelCopyFinishedListener, Handler handler) {
        if (new HeliosApiHook().preInvoke(102104, "android/view/PixelCopy", "request", PixelCopy.class, new Object[]{surfaceView, bitmap, onPixelCopyFinishedListener, handler}, "void", new ExtraInfo(false, "(Landroid/view/SurfaceView;Landroid/graphics/Bitmap;Landroid/view/PixelCopy$OnPixelCopyFinishedListener;Landroid/os/Handler;)V")).isIntercept()) {
            return;
        }
        PixelCopy.request(surfaceView, bitmap, onPixelCopyFinishedListener, handler);
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public View getView() {
        return this;
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public /* synthetic */ void reuse() {
        ITTRenderView.CC.$default$reuse(this);
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public Surface getSurface() {
        return this.mSurface;
    }

    private void init() {
        getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.ss.ttm.player.TTSurfaceView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                com.ss.vcbkit.a.c("TTPlayerView", "ttmn surface view: " + this + ", create: " + surfaceHolder);
                TTSurfaceView.this.mSurface = surfaceHolder.getSurface();
                if (TTSurfaceView.this.mRenderCallback != null) {
                    TTSurfaceView.this.mRenderCallback.onSurfaceCreated(TTSurfaceView.this.mSurface);
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                com.ss.vcbkit.a.c("TTPlayerView", "ttmn surface view: " + TTPlayerViewHelper.objectToString(this) + ", destroyed 111: " + surfaceHolder);
                TTSurfaceView.this.mSurface = null;
                if (TTSurfaceView.this.mRenderCallback != null) {
                    TTSurfaceView.this.mRenderCallback.onSurfaceDestroyed();
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                com.ss.vcbkit.a.c("TTPlayerView", "ttmn surface view: " + TTPlayerViewHelper.objectToString(this) + ", changed: " + surfaceHolder + ", widht: " + i2 + ", height: " + i3);
                if (TTSurfaceView.this.mRenderCallback != null) {
                    if (surfaceHolder.getSurface() != TTSurfaceView.this.mSurface) {
                        TTSurfaceView.this.mSurface = surfaceHolder.getSurface();
                        TTSurfaceView.this.mRenderCallback.onSurfaceCreated(TTSurfaceView.this.mSurface);
                    }
                    TTSurfaceView.this.mRenderCallback.onSurfaceChanged(i2, i3);
                }
            }
        });
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void reCreateSurface() {
        setVisibility(8);
        setVisibility(0);
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void setRenderCallback(ITTRenderView.RenderCallback renderCallback) {
        this.mRenderCallback = renderCallback;
    }

    public TTSurfaceView(Context context) {
        super(context);
        this.mSurface = null;
        this.mRenderCallback = null;
        this.mFixedSizeWidth = -1;
        init();
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void setFixedSizeIfNeeded(int i, int i2) {
        com.ss.vcbkit.a.c("TTPlayerView", "ttmn surface view: " + TTPlayerViewHelper.objectToString(this) + ", fixed size w: " + i + ", h: " + i2 + ", ow: " + this.mFixedSizeWidth);
        if (i > 0 && i < this.mFixedSizeWidth) {
            return;
        }
        getHolder().setFixedSize(i, i2);
        this.mFixedSizeWidth = i;
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void snapshotBitmap(boolean z, final ITTRenderView.SnapshotCallback snapshotCallback) {
        Bitmap.Config config;
        if (snapshotCallback == null) {
            return;
        }
        if (z) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        int i = Build.VERSION.SDK_INT;
        if (i == 28) {
            config = Bitmap.Config.ARGB_8888;
        }
        if (i >= 24) {
            try {
                final Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), config);
                com_ss_ttm_player_TTSurfaceView_android_view_PixelCopy_request(this, createBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.ss.ttm.player.f
                    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                    public final void onPixelCopyFinished(int i2) {
                        TTSurfaceView.lambda$snapshotBitmap$0(ITTRenderView.SnapshotCallback.this, createBitmap, i2);
                    }
                }, new HandlerDelegate(Looper.getMainLooper()));
                return;
            } catch (Exception e) {
                com.ss.vcbkit.a.b("TTPlayerView", "ttmn surface view snapshot failed: " + e);
                snapshotCallback.onResult(-1, null);
                return;
            }
        }
        snapshotCallback.onResult(-1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$snapshotBitmap$0(ITTRenderView.SnapshotCallback snapshotCallback, Bitmap bitmap, int i) {
        if (i != 0) {
            bitmap = null;
        }
        snapshotCallback.onResult(i, bitmap);
    }
}
