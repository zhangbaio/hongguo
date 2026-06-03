package com.ss.ttm.player;

import android.graphics.Bitmap;
import android.view.Surface;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface TTAVWindowClient {

    public interface SnapshotListener {
        void onResult(int i, Bitmap bitmap);
    }

    void bindExternal(ExternalInterface externalInterface);

    void bindMediaClient(MediaPlayerClient mediaPlayerClient);

    void setWindowUsage(int i);

    void snapshotBitmap(boolean z, SnapshotListener snapshotListener);

    void unbindExternal(ExternalInterface externalInterface);

    void unbindMediaClient(MediaPlayerClient mediaPlayerClient);

    void updateVideoSize(int i, int i2);

    public interface ExternalInterface {
        void onNewWindowAvailable(Surface surface);

        void onWindowChanged(int i, int i2);

        void onWindowDestroyed();

        void snapshotBitmap(SnapshotListener snapshotListener);

        /* renamed from: com.ss.ttm.player.TTAVWindowClient$ExternalInterface$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
        }
    }
}
