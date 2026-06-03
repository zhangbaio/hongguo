package com.ss.ttvideoengine.preRender;

import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.ttvideoengine.preRender.Timer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TimerDefault implements Timer {
    private ScheduledExecutorService mExecutor;
    private int mInternal;
    private final CopyOnWriteArrayList<Timer.TimerListener> mListeners;

    static {
        Covode.recordClassIndex(652626);
    }

    @Override // com.ss.ttvideoengine.preRender.Timer
    public synchronized void stop() {
    }

    private static class Holder {
        private static final TimerDefault TIMER_DEFAULT;

        private Holder() {
        }

        static {
            Covode.recordClassIndex(652627);
            TIMER_DEFAULT = new TimerDefault();
        }
    }

    public static TimerDefault instance() {
        return Holder.TIMER_DEFAULT;
    }

    private TimerDefault() {
        this.mInternal = 300;
        this.mListeners = new CopyOnWriteArrayList<>();
    }

    public void stopTimer() {
        ScheduledExecutorService scheduledExecutorService = this.mExecutor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.mExecutor = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void run() {
        Iterator<Timer.TimerListener> it2 = this.mListeners.iterator();
        while (it2.hasNext()) {
            Timer.TimerListener next = it2.next();
            if (next != null) {
                next.trigger();
            }
        }
    }

    @Override // com.ss.ttvideoengine.preRender.Timer
    public synchronized void start() {
        if (this.mListeners.isEmpty()) {
            stopTimer();
            return;
        }
        ScheduledExecutorService scheduledExecutorService = this.mExecutor;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            ScheduledExecutorService newSingleThreadScheduledExecutor = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("/TimerDefault"));
            this.mExecutor = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.scheduleWithFixedDelay(new Runnable() { // from class: com.ss.ttvideoengine.preRender.e
                @Override // java.lang.Runnable
                public final void run() {
                    TimerDefault.this.run();
                }
            }, 0L, this.mInternal, TimeUnit.MILLISECONDS);
        }
    }

    public void setInternal(int i) {
        this.mInternal = i;
    }

    @Override // com.ss.ttvideoengine.preRender.Timer
    public synchronized void addTimerListener(Timer.TimerListener timerListener) {
        if (timerListener == null) {
            return;
        }
        this.mListeners.addIfAbsent(timerListener);
    }

    @Override // com.ss.ttvideoengine.preRender.Timer
    public synchronized void removeTimerListener(Timer.TimerListener timerListener) {
        this.mListeners.remove(timerListener);
        if (this.mListeners.isEmpty()) {
            stopTimer();
        }
    }
}
