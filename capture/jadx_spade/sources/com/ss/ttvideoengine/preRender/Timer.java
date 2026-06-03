package com.ss.ttvideoengine.preRender;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface Timer {

    public interface TimerListener {
        void trigger();
    }

    void addTimerListener(TimerListener timerListener);

    void removeTimerListener(TimerListener timerListener);

    void start();

    void stop();
}
