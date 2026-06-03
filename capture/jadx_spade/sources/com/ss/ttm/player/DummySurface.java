package com.ss.ttm.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ssconfig.local.QualityOptExperiment;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.f1;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import java.util.concurrent.ConcurrentLinkedQueue;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class DummySurface extends Surface {
    private static int SetOutputSurfaceExceptionCounter;
    private static volatile int SetOutputSurfaceExceptionLimit;
    private static int SetOutputSurfaceExceptionOtherCounter;
    private static volatile int SetOutputSurfaceExceptionOtherLimit;
    private static volatile int cacheMode;
    private static final ConcurrentLinkedQueue<DummySurface> caches;
    private static int secureMode;
    private static boolean secureModeInitialized;
    private static volatile boolean useDummySurfaceCaches;
    private volatile boolean cached;
    private boolean hasSetOutputSurfaceException;
    private boolean hasSetOutputSurfaceExceptionOther;
    public final boolean secure;
    private final DummySurfaceThread thread;
    private boolean threadReleased;

    private static void assertApiLevel17OrHigher() {
    }

    public static DummySurface newInstanceV17(boolean z) {
        return com_ss_ttm_player_DummySurface_com_dragon_read_base_lancet_EglSurfaceTextureAop_newInstanceV17(z);
    }

    private static class DummySurfaceThread extends HandlerThread implements Handler.Callback {
        private EGLSurfaceTexture eglSurfaceTexture;
        private Handler handler;
        private Error initError;
        private RuntimeException initException;
        private DummySurface surface;

        static {
            Covode.recordClassIndex(652102);
        }

        public DummySurfaceThread() {
            super("dummySurface");
        }

        private void releaseInternal() {
            EGLSurfaceTexture eGLSurfaceTexture = this.eglSurfaceTexture;
            if (eGLSurfaceTexture != null) {
                eGLSurfaceTexture.release();
                return;
            }
            throw null;
        }

        public void release() {
            Handler handler = this.handler;
            if (handler != null) {
                handler.sendEmptyMessage(2);
                return;
            }
            throw null;
        }

        private void initInternal(int i) {
            boolean z;
            EGLSurfaceTexture eGLSurfaceTexture = this.eglSurfaceTexture;
            if (eGLSurfaceTexture != null) {
                eGLSurfaceTexture.init(i);
                SurfaceTexture surfaceTexture = this.eglSurfaceTexture.getSurfaceTexture();
                if (i != 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.surface = new DummySurface(this, surfaceTexture, z);
                return;
            }
            throw null;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            try {
                if (i != 1) {
                    if (i != 2) {
                        return true;
                    }
                    try {
                        releaseInternal();
                    } finally {
                        try {
                            return true;
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    initInternal(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e) {
                    Log.e("DummySurface", "Failed to initialize dummy surface", e);
                    this.initError = e;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e2) {
                    Log.e("DummySurface", "Failed to initialize dummy surface", e2);
                    this.initException = e2;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }

        public DummySurface init(int i) {
            boolean z;
            start();
            this.handler = new HandlerDelegate(getLooper(), this);
            this.eglSurfaceTexture = new EGLSurfaceTexture(this.handler);
            synchronized (this) {
                z = false;
                this.handler.obtainMessage(1, i, 0).sendToTarget();
                while (this.surface == null && this.initException == null && this.initError == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.initException;
            if (runtimeException == null) {
                Error error = this.initError;
                if (error == null) {
                    DummySurface dummySurface = this.surface;
                    if (dummySurface != null) {
                        return dummySurface;
                    }
                    throw null;
                }
                throw error;
            }
            throw runtimeException;
        }
    }

    static {
        Covode.recordClassIndex(652101);
        SetOutputSurfaceExceptionLimit = 1;
        SetOutputSurfaceExceptionOtherLimit = 1;
        SetOutputSurfaceExceptionCounter = 0;
        SetOutputSurfaceExceptionOtherCounter = 0;
        caches = new ConcurrentLinkedQueue<>();
        useDummySurfaceCaches = false;
        cacheMode = 0;
    }

    private void releaseInternal() {
        Log.d("DummySurface", "release DummySurface internal@" + hashCode());
        super.release();
        synchronized (this.thread) {
            if (!this.threadReleased) {
                this.thread.release();
                this.threadReleased = true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    @Override // android.view.Surface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void release() {
        /*
            r5 = this;
            boolean r0 = com.ss.ttm.player.DummySurface.useDummySurfaceCaches
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L1c
            java.util.concurrent.ConcurrentLinkedQueue<com.ss.ttm.player.DummySurface> r0 = com.ss.ttm.player.DummySurface.caches
            int r0 = r0.size()
            if (r0 > r1) goto L1c
            boolean r0 = r5.secure
            if (r0 != 0) goto L1c
            boolean r0 = r5.isValid()
            if (r0 != 0) goto L1a
            goto L1c
        L1a:
            r0 = 1
            goto L1d
        L1c:
            r0 = 0
        L1d:
            if (r0 == 0) goto L5d
            int r4 = com.ss.ttm.player.DummySurface.cacheMode
            if (r4 != r3) goto L28
            boolean r4 = r5.hasSetOutputSurfaceException
            if (r4 == 0) goto L28
            goto L5e
        L28:
            int r4 = com.ss.ttm.player.DummySurface.cacheMode
            if (r4 != r1) goto L31
            boolean r1 = r5.hasSetOutputSurfaceExceptionOther
            if (r1 == 0) goto L31
            goto L5e
        L31:
            int r1 = com.ss.ttm.player.DummySurface.cacheMode
            r4 = 3
            if (r1 != r4) goto L47
            boolean r1 = r5.hasSetOutputSurfaceException
            if (r1 == 0) goto L47
            int r1 = com.ss.ttm.player.DummySurface.SetOutputSurfaceExceptionCounter
            int r1 = r1 + r3
            com.ss.ttm.player.DummySurface.SetOutputSurfaceExceptionCounter = r1
            int r4 = com.ss.ttm.player.DummySurface.SetOutputSurfaceExceptionLimit
            if (r1 < r4) goto L5d
            useCaches(r2)
            goto L5e
        L47:
            int r1 = com.ss.ttm.player.DummySurface.cacheMode
            r4 = 4
            if (r1 != r4) goto L5d
            boolean r1 = r5.hasSetOutputSurfaceExceptionOther
            if (r1 == 0) goto L5d
            int r1 = com.ss.ttm.player.DummySurface.SetOutputSurfaceExceptionOtherCounter
            int r1 = r1 + r3
            com.ss.ttm.player.DummySurface.SetOutputSurfaceExceptionOtherCounter = r1
            int r4 = com.ss.ttm.player.DummySurface.SetOutputSurfaceExceptionOtherLimit
            if (r1 < r4) goto L5d
            useCaches(r2)
            goto L5e
        L5d:
            r2 = r0
        L5e:
            if (r2 != 0) goto L64
            r5.releaseInternal()
            return
        L64:
            boolean r0 = r5.cached
            if (r0 != 0) goto L89
            java.util.concurrent.ConcurrentLinkedQueue<com.ss.ttm.player.DummySurface> r0 = com.ss.ttm.player.DummySurface.caches
            r0.add(r5)
            r5.cached = r3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "cache DummySurface@"
            r0.append(r1)
            int r1 = r5.hashCode()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "DummySurface"
            android.util.Log.d(r1, r0)
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.DummySurface.release():void");
    }

    public static void useCaches(boolean z) {
        useCaches(z, 0);
    }

    public void addEvent(int i) {
        if (i != 1) {
            if (i == 2) {
                this.hasSetOutputSurfaceExceptionOther = true;
            }
        } else {
            this.hasSetOutputSurfaceException = true;
            this.hasSetOutputSurfaceExceptionOther = true;
        }
    }

    public static DummySurface DummySurface__newInstanceV17$___twin___(boolean z) {
        DummySurface poll;
        if (useDummySurfaceCaches && !z && (poll = caches.poll()) != null) {
            poll.cached = false;
            Log.d("DummySurface", "get cached DummySurface@" + poll.hashCode());
            return poll;
        }
        return newInstanceV17Internal(z);
    }

    @TargetClass("com.ss.ttm.player.DummySurface")
    @Insert("newInstanceV17")
    public static DummySurface com_ss_ttm_player_DummySurface_com_dragon_read_base_lancet_EglSurfaceTextureAop_newInstanceV17(boolean z) {
        try {
            return DummySurface__newInstanceV17$___twin___(z);
        } catch (Throwable th) {
            LogWrapper.error("EGLSurfaceTextureAop", th.getMessage(), new Object[0]);
            if (QualityOptExperiment.INSTANCE.getConfig().eglCatchEnable) {
                f1.b(th);
                ko2.h.b(th);
                return null;
            }
            throw th;
        }
    }

    private static int getSecureModeV24(Context context) {
        String eglQueryString;
        if ((Build.VERSION.SDK_INT < 26 && ("samsung".equals(Build.MANUFACTURER) || "XT1650".equals(Build.MODEL))) || (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) == null || !eglQueryString.contains("EGL_EXT_protected_content")) {
            return 0;
        }
        if (eglQueryString.contains("EGL_KHR_surfaceless_context")) {
            return 1;
        }
        return 2;
    }

    public static synchronized boolean isSecureSupported(Context context) {
        boolean z;
        int secureModeV24;
        synchronized (DummySurface.class) {
            z = true;
            if (!secureModeInitialized) {
                if (Build.VERSION.SDK_INT < 24) {
                    secureModeV24 = 0;
                } else {
                    secureModeV24 = getSecureModeV24(context);
                }
                secureMode = secureModeV24;
                secureModeInitialized = true;
            }
            if (secureMode == 0) {
                z = false;
            }
        }
        return z;
    }

    private static DummySurface newInstanceV17Internal(boolean z) {
        int i;
        Log.d("DummySurface", "create DummySurface internal:" + z);
        assertApiLevel17OrHigher();
        DummySurfaceThread dummySurfaceThread = new DummySurfaceThread();
        if (z) {
            i = secureMode;
        } else {
            i = 0;
        }
        return dummySurfaceThread.init(i);
    }

    public static void useCaches(boolean z, int i) {
        useCaches(z, i, SetOutputSurfaceExceptionLimit);
    }

    private DummySurface(DummySurfaceThread dummySurfaceThread, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.cached = false;
        this.hasSetOutputSurfaceException = false;
        this.hasSetOutputSurfaceExceptionOther = false;
        this.thread = dummySurfaceThread;
        this.secure = z;
    }

    public static void useCaches(boolean z, int i, int i2) {
        Log.d("DummySurface", "useCaches:" + z + ":" + i + ":" + i2);
        useDummySurfaceCaches = z;
        cacheMode = i;
        if (i == 3) {
            SetOutputSurfaceExceptionLimit = i2;
        } else if (i == 4) {
            SetOutputSurfaceExceptionOtherLimit = i2;
        }
        if (useDummySurfaceCaches) {
            return;
        }
        while (true) {
            ConcurrentLinkedQueue<DummySurface> concurrentLinkedQueue = caches;
            if (!concurrentLinkedQueue.isEmpty()) {
                DummySurface poll = concurrentLinkedQueue.poll();
                if (poll != null) {
                    poll.release();
                }
            } else {
                return;
            }
        }
    }
}
