package com.ss.ttvideoengine.utils;

import android.os.SystemClock;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PlayDuration {
    private int mState = 2;
    private int mPlayedDuration = 0;
    private long mStartPlayTime = 0;

    static {
        Covode.recordClassIndex(652753);
    }

    public void clear() {
        this.mPlayedDuration = 0;
        if (this.mState == 1) {
            this.mStartPlayTime = SystemClock.elapsedRealtime();
        }
    }

    public void reset() {
        this.mState = 2;
        this.mPlayedDuration = 0;
        this.mStartPlayTime = 0L;
    }

    public void start() {
        if (this.mState == 2) {
            this.mStartPlayTime = SystemClock.elapsedRealtime();
            this.mState = 1;
        }
    }

    public int getPlayedDuration() {
        if (this.mState == 1) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.mStartPlayTime;
            int i = (int) (elapsedRealtime - j);
            if (i >= 0 && j > 0) {
                this.mPlayedDuration += i;
            }
            this.mStartPlayTime = elapsedRealtime;
        }
        return this.mPlayedDuration;
    }

    public void stop() {
        if (this.mState == 1) {
            this.mState = 2;
            int elapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.mStartPlayTime);
            if (elapsedRealtime >= 0) {
                this.mPlayedDuration += elapsedRealtime;
            }
        }
    }
}
