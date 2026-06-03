package com.ss.ttm.player;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import android.view.Surface;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttm.player.ITTRenderView;
import com.ss.ttm.player.TTAVWindowClient;
import com.ss.ttm.player.TTWindowClient;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
class TTWindowClient implements TTAVWindowClient {
    private WindowClientOnInfoCallback mOnInfoCallback;
    private ITTRenderView mRenderView;
    private long mCWindowShellHandle = 0;
    private long mNativeWindowHandle = 0;
    private ClientType mClientType = ClientType.UN_KNOWN;
    private WeakReference<TTPlayer> mTTPlayerRef = null;
    private WeakReference<MediaPlayerClient> mMediaPlayerClientRef = null;
    private WeakReference<TTAVWindowClient.ExternalInterface> mExternalRef = null;
    private int mWindowUsage = 0;
    private final ReentrantLock mLock = new ReentrantLock();

    interface WindowClientOnInfoCallback {
        void onInfo(int i, int i2);
    }

    static {
        Covode.recordClassIndex(652201);
    }

    private native long nativeCreateWindow(Surface surface, TTWindowClient tTWindowClient);

    private native void nativeOnNewWindowAvailable(long j, long j2);

    private native void nativeOnWindowChanged(long j, int i, int i2, int i3);

    private native void nativeOnWindowDestroyed(long j);

    private native void nativeSetWindowUsage(long j, int i);

    private native void nativeWindowBindPlayer(long j, long j2);

    private native void nativeWindowHandleIncRef(long j);

    private TTAVWindowClient.ExternalInterface getExternal() {
        WeakReference<TTAVWindowClient.ExternalInterface> weakReference = this.mExternalRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private MediaPlayerClient getMediaPlayerClient() {
        WeakReference<MediaPlayerClient> weakReference = this.mMediaPlayerClientRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private TTPlayer getTTPlayer() {
        WeakReference<TTPlayer> weakReference = this.mTTPlayerRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void clearAllWeakReference() {
        WeakReference<TTPlayer> weakReference = this.mTTPlayerRef;
        if (weakReference != null) {
            weakReference.clear();
            this.mTTPlayerRef = null;
        }
        WeakReference<MediaPlayerClient> weakReference2 = this.mMediaPlayerClientRef;
        if (weakReference2 != null) {
            weakReference2.clear();
            this.mMediaPlayerClientRef = null;
        }
        WeakReference<TTAVWindowClient.ExternalInterface> weakReference3 = this.mExternalRef;
        if (weakReference3 != null) {
            weakReference3.clear();
            this.mExternalRef = null;
        }
    }

    /* renamed from: com.ss.ttm.player.TTWindowClient$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType;

        static {
            int[] iArr = new int[ClientType.values().length];
            $SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType = iArr;
            try {
                iArr[ClientType.TT_PLAYER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType[ClientType.C_WINDOW_SHELL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType[ClientType.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType[ClientType.EXTERNAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void windowDestroyInternal() {
        int i = AnonymousClass1.$SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType[this.mClientType.ordinal()];
        if (i != 3) {
            if (i != 4) {
                long j = this.mNativeWindowHandle;
                if (0 == j) {
                    return;
                }
                nativeOnWindowDestroyed(j);
                this.mNativeWindowHandle = 0L;
                return;
            }
            TTAVWindowClient.ExternalInterface external = getExternal();
            if (external != null) {
                external.onWindowDestroyed();
                return;
            }
            return;
        }
        MediaPlayerClient mediaPlayerClient = getMediaPlayerClient();
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setSurface(null);
        }
    }

    public void onWindowDestroyed() {
        com.ss.vcbkit.a.c("TTPlayerView", "ttmn client destroyed type:  " + TTPlayerViewHelper.objectToString(this) + ", " + this.mClientType);
        this.mLock.lock();
        try {
            windowDestroyInternal();
        } finally {
            this.mLock.unlock();
        }
    }

    private enum ClientType {
        UN_KNOWN,
        TT_PLAYER,
        C_WINDOW_SHELL,
        OTHER,
        EXTERNAL;

        static {
            Covode.recordClassIndex(652202);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    private void windowChangeBindInternal() {
        final ?? r0;
        if (this.mOnInfoCallback == null) {
            return;
        }
        if (this.mClientType == ClientType.EXTERNAL) {
            r0 = 1;
        } else {
            r0 = 0;
        }
        com.ss.vcbkit.a.c("TTPlayerView", "ttmn client bing changed neededFixedSize: " + ((boolean) r0));
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDelegate handlerDelegate = new HandlerDelegate(Looper.getMainLooper());
            final WindowClientOnInfoCallback windowClientOnInfoCallback = this.mOnInfoCallback;
            if (windowClientOnInfoCallback != null) {
                handlerDelegate.postAtFrontOfQueue(new Runnable() { // from class: com.ss.ttm.player.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        TTWindowClient.lambda$windowChangeBindInternal$2(TTWindowClient.WindowClientOnInfoCallback.this, r0);
                    }
                });
                return;
            }
            return;
        }
        this.mOnInfoCallback.onInfo(7, 0);
        this.mOnInfoCallback.onInfo(6, r0);
    }

    private void setExternal(TTAVWindowClient.ExternalInterface externalInterface) {
        this.mExternalRef = new WeakReference<>(externalInterface);
    }

    private void setMediaPlayerClient(MediaPlayerClient mediaPlayerClient) {
        this.mMediaPlayerClientRef = new WeakReference<>(mediaPlayerClient);
    }

    private void setTTPlayer(TTPlayer tTPlayer) {
        this.mTTPlayerRef = new WeakReference<>(tTPlayer);
    }

    private boolean reCreateNativeWindow(Surface surface) {
        long nativeCreateWindow = nativeCreateWindow(surface, this);
        this.mNativeWindowHandle = nativeCreateWindow;
        if (0 != nativeCreateWindow) {
            return true;
        }
        return false;
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void setWindowUsage(int i) {
        this.mLock.lock();
        try {
            this.mWindowUsage = i;
            long j = this.mNativeWindowHandle;
            if (j != 0) {
                nativeSetWindowUsage(j, i);
            }
        } finally {
            this.mLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void unbindExternal(TTAVWindowClient.ExternalInterface externalInterface) {
        this.mLock.lock();
        try {
            TTAVWindowClient.ExternalInterface external = getExternal();
            if (external != null && external == externalInterface) {
                external.onWindowDestroyed();
                WeakReference<TTAVWindowClient.ExternalInterface> weakReference = this.mExternalRef;
                if (weakReference != null) {
                    weakReference.clear();
                    this.mExternalRef = null;
                }
            }
        } finally {
            this.mLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void unbindMediaClient(MediaPlayerClient mediaPlayerClient) {
        this.mLock.lock();
        try {
            MediaPlayerClient mediaPlayerClient2 = getMediaPlayerClient();
            if (mediaPlayerClient2 != null && mediaPlayerClient2 == mediaPlayerClient) {
                mediaPlayerClient2.setSurfaceTimeOut(null, 0);
                WeakReference<MediaPlayerClient> weakReference = this.mMediaPlayerClientRef;
                if (weakReference != null) {
                    weakReference.clear();
                    this.mMediaPlayerClientRef = null;
                }
            }
        } finally {
            this.mLock.unlock();
        }
    }

    private void newWindowAvailableInternal(Surface surface) {
        TTAVWindowClient.ExternalInterface external;
        if (surface == null) {
            return;
        }
        windowDestroyInternal();
        int i = AnonymousClass1.$SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType[this.mClientType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4 || (external = getExternal()) == null) {
                        return;
                    }
                    external.onNewWindowAvailable(surface);
                    return;
                }
                MediaPlayerClient mediaPlayerClient = getMediaPlayerClient();
                if (mediaPlayerClient == null) {
                    return;
                }
                mediaPlayerClient.setSurface(surface);
                return;
            }
            if (0 == this.mCWindowShellHandle || !reCreateNativeWindow(surface)) {
                return;
            }
            nativeOnNewWindowAvailable(this.mCWindowShellHandle, this.mNativeWindowHandle);
            return;
        }
        TTPlayer tTPlayer = getTTPlayer();
        if (tTPlayer == null || !reCreateNativeWindow(surface)) {
            return;
        }
        nativeWindowBindPlayer(this.mNativeWindowHandle, tTPlayer.getNativePlayer());
        nativeSetWindowUsage(this.mNativeWindowHandle, this.mWindowUsage);
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void bindMediaClient(MediaPlayerClient mediaPlayerClient) {
        this.mLock.lock();
        try {
            MediaPlayerClient mediaPlayerClient2 = getMediaPlayerClient();
            com.ss.vcbkit.a.c("TTPlayerView", "ttmn client bind media client " + TTPlayerViewHelper.objectToString(this) + ",  curr: " + TTPlayerViewHelper.objectToString(mediaPlayerClient) + ", target: " + TTPlayerViewHelper.objectToString(mediaPlayerClient2));
            if (mediaPlayerClient2 != mediaPlayerClient) {
                windowDestroyInternal();
                this.mClientType = ClientType.OTHER;
                clearAllWeakReference();
                windowChangeBindInternal();
                if (mediaPlayerClient != null) {
                    setMediaPlayerClient(mediaPlayerClient);
                    Surface surface = this.mRenderView.getSurface();
                    if (surface != null) {
                        mediaPlayerClient.setSurface(surface);
                    }
                }
            }
        } finally {
            this.mLock.unlock();
        }
    }

    public void onNewWindowAvailable(Surface surface) {
        com.ss.vcbkit.a.c("TTPlayerView", "ttmn client available  " + TTPlayerViewHelper.objectToString(this) + ", type: " + this.mClientType + ", surface: " + TTPlayerViewHelper.objectToString(surface));
        this.mLock.lock();
        try {
            newWindowAvailableInternal(surface);
        } finally {
            this.mLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void bindExternal(TTAVWindowClient.ExternalInterface externalInterface) {
        this.mLock.lock();
        try {
            TTAVWindowClient.ExternalInterface external = getExternal();
            com.ss.vcbkit.a.c("TTPlayerView", "ttmn client bind external " + TTPlayerViewHelper.objectToString(this) + ",  curr: " + TTPlayerViewHelper.objectToString(external) + ", target: " + TTPlayerViewHelper.objectToString(externalInterface));
            if (externalInterface != external) {
                windowDestroyInternal();
                this.mClientType = ClientType.EXTERNAL;
                clearAllWeakReference();
                windowChangeBindInternal();
                if (externalInterface != null) {
                    setExternal(externalInterface);
                    Surface surface = this.mRenderView.getSurface();
                    if (surface != null) {
                        externalInterface.onNewWindowAvailable(surface);
                        externalInterface.onWindowChanged(this.mRenderView.getView().getWidth(), this.mRenderView.getView().getHeight());
                    }
                }
            }
        } finally {
            this.mLock.unlock();
        }
    }

    public void bindPlayer(TTPlayer tTPlayer) {
        ITTRenderView iTTRenderView;
        Surface surface;
        this.mLock.lock();
        try {
            TTPlayer tTPlayer2 = getTTPlayer();
            com.ss.vcbkit.a.c("TTPlayerView", "ttmn client bind player  " + TTPlayerViewHelper.objectToString(this) + ", curr: " + TTPlayerViewHelper.objectToString(tTPlayer2) + ", target: " + TTPlayerViewHelper.objectToString(tTPlayer));
            if (tTPlayer != tTPlayer2) {
                ClientType clientType = ClientType.TT_PLAYER;
                if (clientType != this.mClientType) {
                    windowDestroyInternal();
                }
                this.mClientType = clientType;
                clearAllWeakReference();
                windowChangeBindInternal();
                if (tTPlayer != null) {
                    setTTPlayer(tTPlayer);
                    if (0 != this.mNativeWindowHandle || ((iTTRenderView = this.mRenderView) != null && (surface = iTTRenderView.getSurface()) != null && reCreateNativeWindow(surface))) {
                        nativeWindowBindPlayer(this.mNativeWindowHandle, tTPlayer.getNativePlayer());
                        nativeSetWindowUsage(this.mNativeWindowHandle, this.mWindowUsage);
                        nativeOnWindowChanged(this.mNativeWindowHandle, this.mRenderView.getView().getWidth(), this.mRenderView.getView().getHeight(), 1);
                    }
                }
            }
        } finally {
            this.mLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$windowChangeBindInternal$2(WindowClientOnInfoCallback windowClientOnInfoCallback, boolean z) {
        windowClientOnInfoCallback.onInfo(7, 0);
        windowClientOnInfoCallback.onInfo(6, z ? 1 : 0);
    }

    public TTWindowClient(ITTRenderView iTTRenderView, WindowClientOnInfoCallback windowClientOnInfoCallback) {
        this.mOnInfoCallback = null;
        this.mRenderView = null;
        this.mRenderView = iTTRenderView;
        this.mOnInfoCallback = windowClientOnInfoCallback;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x000d, code lost:
    
        if (r5 != r4.mCWindowShellHandle) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long setWindowShellHandle(long r5, boolean r7) {
        /*
            r4 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r4.mLock
            r0.lock()
            r0 = 0
            if (r7 == 0) goto L15
            long r2 = r4.mCWindowShellHandle     // Catch: java.lang.Throwable -> L47
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 == 0) goto L15
        Lf:
            java.util.concurrent.locks.ReentrantLock r5 = r4.mLock
            r5.unlock()
            return r0
        L15:
            r4.mCWindowShellHandle = r5     // Catch: java.lang.Throwable -> L47
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 != 0) goto L1c
            goto Lf
        L1c:
            com.ss.ttm.player.TTWindowClient$ClientType r5 = com.ss.ttm.player.TTWindowClient.ClientType.C_WINDOW_SHELL     // Catch: java.lang.Throwable -> L47
            r4.mClientType = r5     // Catch: java.lang.Throwable -> L47
            com.ss.ttm.player.ITTRenderView r5 = r4.mRenderView     // Catch: java.lang.Throwable -> L47
            if (r5 != 0) goto L25
            goto Lf
        L25:
            r4.windowChangeBindInternal()     // Catch: java.lang.Throwable -> L47
            long r5 = r4.mNativeWindowHandle     // Catch: java.lang.Throwable -> L47
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 != 0) goto L3a
            com.ss.ttm.player.ITTRenderView r5 = r4.mRenderView     // Catch: java.lang.Throwable -> L47
            android.view.Surface r5 = r5.getSurface()     // Catch: java.lang.Throwable -> L47
            long r5 = r4.nativeCreateWindow(r5, r4)     // Catch: java.lang.Throwable -> L47
            r4.mNativeWindowHandle = r5     // Catch: java.lang.Throwable -> L47
        L3a:
            long r5 = r4.mNativeWindowHandle     // Catch: java.lang.Throwable -> L47
            r4.nativeWindowHandleIncRef(r5)     // Catch: java.lang.Throwable -> L47
            long r5 = r4.mNativeWindowHandle     // Catch: java.lang.Throwable -> L47
            java.util.concurrent.locks.ReentrantLock r7 = r4.mLock
            r7.unlock()
            return r5
        L47:
            r5 = move-exception
            java.util.concurrent.locks.ReentrantLock r6 = r4.mLock
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.TTWindowClient.setWindowShellHandle(long, boolean):long");
    }

    protected void onInfo(final int i, final int i2) {
        com.ss.vcbkit.a.c("TTPlayerView", "ttmn client onInfo " + TTPlayerViewHelper.objectToString(this) + ", what: " + i + ", parameter: " + i2);
        HandlerDelegate handlerDelegate = new HandlerDelegate(Looper.getMainLooper());
        final WindowClientOnInfoCallback windowClientOnInfoCallback = this.mOnInfoCallback;
        if (windowClientOnInfoCallback != null) {
            handlerDelegate.postAtFrontOfQueue(new Runnable() { // from class: com.ss.ttm.player.g
                @Override // java.lang.Runnable
                public final void run() {
                    TTWindowClient.WindowClientOnInfoCallback.this.onInfo(i, i2);
                }
            });
        }
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void snapshotBitmap(boolean z, final TTAVWindowClient.SnapshotListener snapshotListener) {
        this.mLock.lock();
        if (snapshotListener != null) {
            try {
                ITTRenderView iTTRenderView = this.mRenderView;
                if (iTTRenderView != null) {
                    if (Build.VERSION.SDK_INT < 24 && !(iTTRenderView instanceof TTTextureView)) {
                        TTAVWindowClient.ExternalInterface external = getExternal();
                        if (ClientType.EXTERNAL == this.mClientType && external != null) {
                            external.snapshotBitmap(snapshotListener);
                        } else {
                            snapshotListener.onResult(-1, null);
                        }
                    }
                    Objects.requireNonNull(snapshotListener);
                    iTTRenderView.snapshotBitmap(z, new ITTRenderView.SnapshotCallback() { // from class: com.ss.ttm.player.i
                        @Override // com.ss.ttm.player.ITTRenderView.SnapshotCallback
                        public final void onResult(int i, Bitmap bitmap) {
                            TTAVWindowClient.SnapshotListener.this.onResult(i, bitmap);
                        }
                    });
                }
            } finally {
                this.mLock.unlock();
            }
        }
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void updateVideoSize(final int i, final int i2) {
        com.ss.vcbkit.a.c("TTPlayerView", "ttmn client updateVideoSize " + TTPlayerViewHelper.objectToString(this) + ",  width: " + i + ", height: " + i2);
        if (this.mOnInfoCallback == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDelegate handlerDelegate = new HandlerDelegate(Looper.getMainLooper());
            final WindowClientOnInfoCallback windowClientOnInfoCallback = this.mOnInfoCallback;
            if (windowClientOnInfoCallback != null) {
                handlerDelegate.postAtFrontOfQueue(new Runnable() { // from class: com.ss.ttm.player.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        TTWindowClient.lambda$updateVideoSize$0(TTWindowClient.WindowClientOnInfoCallback.this, i, i2);
                    }
                });
                return;
            }
            return;
        }
        this.mOnInfoCallback.onInfo(5, (i << 16) + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateVideoSize$0(WindowClientOnInfoCallback windowClientOnInfoCallback, int i, int i2) {
        windowClientOnInfoCallback.onInfo(5, (i << 16) + i2);
    }

    private void windowChangedInternal(int i, int i2, boolean z) {
        int i3 = AnonymousClass1.$SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType[this.mClientType.ordinal()];
        if (i3 != 3) {
            if (i3 != 4) {
                long j = this.mNativeWindowHandle;
                if (0 == j) {
                    return;
                }
                nativeOnWindowChanged(j, i, i2, z ? 1 : 0);
                return;
            }
            TTAVWindowClient.ExternalInterface external = getExternal();
            if (external != null) {
                external.onWindowChanged(i, i2);
            }
        }
    }

    public void onWindowChanged(int i, int i2, boolean z) {
        com.ss.vcbkit.a.c("TTPlayerView", "ttmn client changed " + TTPlayerViewHelper.objectToString(this) + ", type: " + this.mClientType + ", w: " + i + ", h: " + i2 + ", crop: " + z);
        this.mLock.lock();
        try {
            windowChangedInternal(i, i2, z);
        } finally {
            this.mLock.unlock();
        }
    }
}
