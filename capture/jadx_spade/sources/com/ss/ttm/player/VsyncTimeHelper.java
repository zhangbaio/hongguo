package com.ss.ttm.player;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttm.utils.Util;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VsyncTimeHelper {
    private final DefaultDisplayListener displayListener;
    private long vsyncDurationNs;
    private final UIVSyncSampler vsyncSampler;
    private final WindowManager windowManager;

    static {
        Covode.recordClassIndex(652216);
    }

    private static final class UIVSyncSampler implements Choreographer.FrameCallback, Handler.Callback {
        private static final UIVSyncSampler INSTANCE;
        private Bundle bundle;
        private Choreographer choreographer;
        private final HandlerThread choreographerOwnerThread;
        private int currentUIFps;
        private final Handler handler;
        private int lowestUIFps;
        private final Handler mainHandler;
        private int observerCount;
        private long uiVsyncDurationNs;
        private long vsyncSampleCount;
        public volatile long sampledVsyncTimeNs = -9223372036854775807L;
        public volatile long lastSampledVsyncTimeNs = -9223372036854775807L;
        public volatile int skipedFrameCount = 0;

        public static UIVSyncSampler getInstance() {
            return INSTANCE;
        }

        public void addObserver() {
            this.handler.sendEmptyMessage(0);
        }

        public void removeObserver() {
            this.handler.sendEmptyMessage(1);
        }

        static {
            Covode.recordClassIndex(652218);
            INSTANCE = new UIVSyncSampler();
        }

        private void addObserverInternal() {
            Choreographer choreographer;
            this.observerCount++;
            StringBuilder sb = new StringBuilder();
            sb.append("add observer cnt = ");
            sb.append(this.observerCount);
            if (this.observerCount == 1 && (choreographer = this.choreographer) != null) {
                choreographer.postFrameCallback(this);
            }
        }

        private void removeObserverInternal() {
            Choreographer choreographer;
            this.observerCount--;
            StringBuilder sb = new StringBuilder();
            sb.append("remove observer cnt = ");
            sb.append(this.observerCount);
            if (this.observerCount == 0 && (choreographer = this.choreographer) != null) {
                choreographer.removeFrameCallback(this);
                this.sampledVsyncTimeNs = -9223372036854775807L;
                this.lastSampledVsyncTimeNs = -9223372036854775807L;
                this.skipedFrameCount = 0;
                this.currentUIFps = 0;
                this.lowestUIFps = 0;
                this.vsyncSampleCount = 0L;
            }
        }

        private UIVSyncSampler() {
            HandlerThread handlerThread = new HandlerThread("Vsync:Handler");
            this.choreographerOwnerThread = handlerThread;
            handlerThread.start();
            this.handler = new HandlerDelegate(handlerThread.getLooper(), this);
            this.bundle = new Bundle();
            HandlerDelegate handlerDelegate = new HandlerDelegate(Looper.getMainLooper());
            this.mainHandler = handlerDelegate;
            handlerDelegate.post(new Runnable() { // from class: com.ss.ttm.player.VsyncTimeHelper.UIVSyncSampler.1
                @Override // java.lang.Runnable
                public void run() {
                    UIVSyncSampler.this.choreographer = Choreographer.getInstance();
                    if (UIVSyncSampler.this.observerCount > 0) {
                        UIVSyncSampler.this.choreographer.postFrameCallback(UIVSyncSampler.INSTANCE);
                    }
                }
            });
        }

        private void updateUIVsyncDurationNs(long j) {
            this.uiVsyncDurationNs = j;
            StringBuilder sb = new StringBuilder();
            sb.append("refresh rate = ");
            sb.append(this.uiVsyncDurationNs);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            Message obtainMessage = this.handler.obtainMessage(2);
            this.bundle.putLong("time", j);
            obtainMessage.setData(this.bundle);
            obtainMessage.sendToTarget();
            this.choreographer.postFrameCallback(this);
        }

        public void updateVsyncDuration(long j) {
            this.bundle.putLong("vsync", j);
            Message obtainMessage = this.handler.obtainMessage(4);
            obtainMessage.setData(this.bundle);
            obtainMessage.sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 4) {
                            return false;
                        }
                        updateUIVsyncDurationNs(message.getData().getLong("vsync"));
                        return true;
                    }
                    recordUIFps(message.getData().getLong("time"));
                    return true;
                }
                removeObserverInternal();
                return true;
            }
            addObserverInternal();
            return true;
        }

        private void recordUIFps(long j) {
            int i;
            if (this.uiVsyncDurationNs == 0) {
                return;
            }
            this.vsyncSampleCount++;
            this.sampledVsyncTimeNs = j;
            if (this.lastSampledVsyncTimeNs == -9223372036854775807L) {
                this.lastSampledVsyncTimeNs = this.sampledVsyncTimeNs;
                return;
            }
            long j2 = this.sampledVsyncTimeNs - this.lastSampledVsyncTimeNs;
            if (j2 <= 0) {
                this.lastSampledVsyncTimeNs = -9223372036854775807L;
                return;
            }
            long j3 = this.uiVsyncDurationNs;
            if (j2 - j3 > 0) {
                i = Math.round((j2 - j3) / j3);
            } else {
                i = 0;
            }
            this.skipedFrameCount += i;
            int i2 = (int) (1000000000 / j2);
            this.currentUIFps = i2;
            int i3 = this.lowestUIFps;
            if (i3 != 0) {
                i2 = Math.min(i3, i2);
            }
            this.lowestUIFps = i2;
            this.lastSampledVsyncTimeNs = this.sampledVsyncTimeNs;
            StringBuilder sb = new StringBuilder();
            sb.append("vsync diff = ");
            sb.append(j2 * 1.0E-6f);
            sb.append(", skipped frame = ");
            sb.append(i);
            sb.append(", total = ");
            sb.append(this.skipedFrameCount);
            sb.append(", fps = ");
            sb.append(this.currentUIFps);
            sb.append(", lowest fps = ");
            sb.append(this.lowestUIFps);
        }
    }

    public long getVsyncDurationNs() {
        return this.vsyncDurationNs;
    }

    private final class DefaultDisplayListener implements DisplayManager.DisplayListener {
        private final DisplayManager displayManager;

        static {
            Covode.recordClassIndex(652217);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }

        public void register() {
            this.displayManager.registerDisplayListener(this, null);
        }

        public void unregister() {
            this.displayManager.unregisterDisplayListener(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            if (i == 0) {
                VsyncTimeHelper.this.updateDefaultDisplayRefreshRateParams();
            }
        }

        public DefaultDisplayListener(DisplayManager displayManager) {
            this.displayManager = displayManager;
        }
    }

    public int getLowestUIFps() {
        return this.vsyncSampler.lowestUIFps;
    }

    public int getUIFps() {
        return this.vsyncSampler.currentUIFps;
    }

    public void disable() {
        if (this.windowManager != null) {
            DefaultDisplayListener defaultDisplayListener = this.displayListener;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.unregister();
            }
            this.vsyncSampler.removeObserver();
        }
    }

    public void enable() {
        if (this.windowManager != null) {
            this.vsyncSampler.addObserver();
            DefaultDisplayListener defaultDisplayListener = this.displayListener;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.register();
            }
            updateDefaultDisplayRefreshRateParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDefaultDisplayRefreshRateParams() {
        Display display;
        if (Util.SDK_INT < 30) {
            display = this.windowManager.getDefaultDisplay();
        } else {
            display = null;
        }
        if (display != null) {
            this.vsyncDurationNs = (long) (1.0E9d / display.getRefreshRate());
        } else {
            this.vsyncDurationNs = 62500000L;
        }
        this.vsyncSampler.updateVsyncDuration(this.vsyncDurationNs);
    }

    private DefaultDisplayListener maybeBuildDefaultDisplayListenerV17(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new DefaultDisplayListener(displayManager);
    }

    public VsyncTimeHelper(Context context) {
        if (context != null) {
            context = context.getApplicationContext();
            this.windowManager = (WindowManager) context.getSystemService("window");
        } else {
            this.windowManager = null;
        }
        if (this.windowManager != null) {
            this.displayListener = Util.SDK_INT >= 17 ? maybeBuildDefaultDisplayListenerV17(context) : null;
            this.vsyncSampler = UIVSyncSampler.getInstance();
        } else {
            this.displayListener = null;
            this.vsyncSampler = null;
        }
        this.vsyncDurationNs = -9223372036854775807L;
    }
}
