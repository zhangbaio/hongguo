package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.ss.ttm.player.ITTRenderView;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
class TTTextureView extends TextureView implements ITTRenderView, TextureView.SurfaceTextureListener {
    private boolean mEnableSurfaceTextureReuse;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private ITTRenderView.RenderCallback renderCallback;

    static {
        Covode.recordClassIndex(652199);
    }

    public void TTTextureView__destroyHardwareResources$___twin___() {
        super.destroyHardwareResources();
    }

    public void destroyHardwareResources() {
        com_ss_ttm_player_TTTextureView_com_dragon_read_base_lancet_TextureViewAop_destroyHardwareResourcesProxy(this);
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void reuse() {
        this.mEnableSurfaceTextureReuse = true;
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void setFixedSizeIfNeeded(int i, int i2) {
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public Surface getSurface() {
        return this.mSurface;
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        reusedSurfaceTexture();
    }

    private void reusedSurfaceTexture() {
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        SurfaceTexture surfaceTexture2 = this.mSurfaceTexture;
        if (surfaceTexture2 != null && surfaceTexture != surfaceTexture2) {
            setSurfaceTexture(surfaceTexture2);
        }
        this.mEnableSurfaceTextureReuse = false;
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void reCreateSurface() {
        ITTRenderView.RenderCallback renderCallback = this.renderCallback;
        if (renderCallback != null && this.mSurfaceTexture != null) {
            renderCallback.onSurfaceDestroyed();
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
                this.mSurface = null;
            }
            Surface surface2 = new Surface(this.mSurfaceTexture);
            this.mSurface = surface2;
            this.renderCallback.onSurfaceCreated(surface2);
        }
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void setRenderCallback(ITTRenderView.RenderCallback renderCallback) {
        this.renderCallback = renderCallback;
    }

    public TTTextureView(Context context) {
        super(context);
        this.mSurface = null;
        this.mSurfaceTexture = null;
        this.mEnableSurfaceTextureReuse = false;
        init();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.view.TextureView")
    @Insert(mayCreateSuper = true, shouldIgnoreCheck = true, value = "destroyHardwareResources")
    public static void com_ss_ttm_player_TTTextureView_com_dragon_read_base_lancet_TextureViewAop_destroyHardwareResourcesProxy(TTTextureView tTTextureView) {
        try {
            tTTextureView.TTTextureView__destroyHardwareResources$___twin___();
            Log.d("TextureViewAop", "destroyHardwareResourcesProxy");
        } catch (Exception e) {
            LogWrapper.e("TextureView aop 出异常了，error = %s", new Object[]{Log.getStackTraceString(e)});
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        ITTRenderView.RenderCallback renderCallback = this.renderCallback;
        if (renderCallback != null && !this.mEnableSurfaceTextureReuse) {
            renderCallback.onSurfaceDestroyed();
        }
        if (!this.mEnableSurfaceTextureReuse) {
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
                this.mSurface = null;
            }
            this.mSurfaceTexture = null;
        }
        return !this.mEnableSurfaceTextureReuse;
    }

    @Override // com.ss.ttm.player.ITTRenderView
    public void snapshotBitmap(boolean z, ITTRenderView.SnapshotCallback snapshotCallback) {
        int i;
        if (snapshotCallback == null) {
            return;
        }
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            i = 0;
        } else {
            i = -1;
        }
        snapshotCallback.onResult(i, bitmap);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        ITTRenderView.RenderCallback renderCallback = this.renderCallback;
        if (renderCallback != null) {
            renderCallback.onSurfaceChanged(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (!this.mEnableSurfaceTextureReuse || this.mSurfaceTexture == null) {
            this.mSurfaceTexture = surfaceTexture;
            this.mSurface = new Surface(surfaceTexture);
        }
        ITTRenderView.RenderCallback renderCallback = this.renderCallback;
        if (renderCallback != null) {
            renderCallback.onSurfaceCreated(this.mSurface);
        }
    }
}
