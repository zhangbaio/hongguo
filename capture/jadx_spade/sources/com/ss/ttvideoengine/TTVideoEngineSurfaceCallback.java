package com.ss.ttvideoengine;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.covode.number.Covode;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.lang.ref.WeakReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTVideoEngineSurfaceCallback implements SurfaceHolder.Callback {
    private WeakReference<TTVideoEngine> mEngine;

    static {
        Covode.recordClassIndex(652367);
    }

    public void reset() {
        this.mEngine.clear();
    }

    public TTVideoEngineSurfaceCallback(TTVideoEngine tTVideoEngine) {
        this.mEngine = new WeakReference<>(tTVideoEngine);
        TTVideoEngineLog.d("TTVideoEngineSurfaceCallback", "new surface callback:" + this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        TTVideoEngineLog.d("TTVideoEngineSurfaceCallback", "surfaceCreated, " + surfaceHolder);
        TTVideoEngine tTVideoEngine = this.mEngine.get();
        if (tTVideoEngine != null) {
            tTVideoEngine.getLogger().setSurfaceSourceType("surface created");
            Surface surface = surfaceHolder.getSurface();
            VideoSurface textureSurface = tTVideoEngine.getTextureSurface();
            if (textureSurface != null) {
                textureSurface.setIntOption(9, 1);
                textureSurface.updateRenderSurface(surface);
                textureSurface.setIntOption(9, 0);
                textureSurface.setIntOption(25, 1);
                TTVideoEngineLog.d("TTVideoEngineSurfaceCallback", "set texturerender force draw");
                return;
            }
            long j = TTVideoEngineConfig.setSurfaceTimeoutForCreated;
            if (j == Long.MIN_VALUE) {
                j = tTVideoEngine.getLongOption(950);
            }
            tTVideoEngine.setSurfaceSync(surface, j);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        TTVideoEngineLog.d("TTVideoEngineSurfaceCallback", "surfaceDestroyed, " + surfaceHolder);
        TTVideoEngine tTVideoEngine = this.mEngine.get();
        if (tTVideoEngine != null) {
            tTVideoEngine.getLogger().setSurfaceSourceType("surface destroyed");
            VideoSurface textureSurface = tTVideoEngine.getTextureSurface();
            if (textureSurface != null) {
                textureSurface.setIntOption(9, 1);
                textureSurface.updateRenderSurface((Surface) null);
                textureSurface.setIntOption(9, 0);
            } else {
                long j = TTVideoEngineConfig.setSurfaceTimeoutForDestroy;
                if (j == Long.MIN_VALUE) {
                    j = tTVideoEngine.getLongOption(950);
                }
                tTVideoEngine.setSurfaceSync(null, j);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        VideoSurface textureSurface;
        TTVideoEngineLog.d("TTVideoEngineSurfaceCallback", "surfaceChanged, " + surfaceHolder + ", i:" + i + ",i1:" + i2 + ", i2:" + i3);
        TTVideoEngine tTVideoEngine = this.mEngine.get();
        if (tTVideoEngine != null && (textureSurface = tTVideoEngine.getTextureSurface()) != null) {
            textureSurface.setSurfaceDimensions(i2, i3);
        }
    }
}
