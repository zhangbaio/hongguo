package com.ss.ttm.player;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.View;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
interface ITTRenderView {

    /* renamed from: com.ss.ttm.player.ITTRenderView$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$reuse(ITTRenderView iTTRenderView) {
        }
    }

    public interface RenderCallback {
        void onSurfaceChanged(int i, int i2);

        void onSurfaceCreated(Surface surface);

        void onSurfaceDestroyed();
    }

    public interface SnapshotCallback {
        void onResult(int i, Bitmap bitmap);
    }

    Surface getSurface();

    View getView();

    void reCreateSurface();

    void reuse();

    void setFixedSizeIfNeeded(int i, int i2);

    void setRenderCallback(RenderCallback renderCallback);

    void snapshotBitmap(boolean z, SnapshotCallback snapshotCallback);
}
