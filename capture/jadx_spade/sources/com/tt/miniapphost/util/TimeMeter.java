package com.tt.miniapphost.util;

import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TimeMeter {
    private AtomicLong mLeftPoint;
    private AtomicLong mLength = new AtomicLong(0);
    private volatile long mStartPoint;

    static {
        Covode.recordClassIndex(654131);
    }

    public static long currentMillis() {
        return SystemClock.uptimeMillis();
    }

    public long getIntervalTime() {
        return this.mLength.get();
    }

    public static TimeMeter newAndStart() {
        return newAndStart(currentMillis());
    }

    public long start() {
        return start(currentMillis());
    }

    public TimeMeter() {
        AtomicLong atomicLong = new AtomicLong(-1L);
        this.mLeftPoint = atomicLong;
        this.mStartPoint = atomicLong.get();
    }

    public long getMillisAfterStart() {
        if (this.mStartPoint == -1) {
            return 0;
        }
        return currentMillis() - this.mStartPoint;
    }

    public boolean isRunning() {
        if (-1 != this.mLeftPoint.addAndGet(0L) && 0 == this.mLength.addAndGet(0L)) {
            return true;
        }
        return false;
    }

    public long stop() {
        long j;
        long j2 = this.mLeftPoint.get();
        if (-1 != j2) {
            j = currentMillis() - j2;
        } else {
            j = 0;
        }
        if (this.mLength.compareAndSet(0L, j)) {
            this.mLeftPoint.set(-1L);
        }
        return this.mLength.get();
    }

    public static long nowDiff(long j) {
        return currentMillis() - j;
    }

    public static long nowAfterStart(TimeMeter timeMeter) {
        if (timeMeter == null) {
            return 0L;
        }
        return timeMeter.getMillisAfterStart();
    }

    public static long stop(TimeMeter timeMeter) {
        if (timeMeter == null) {
            return 0L;
        }
        return timeMeter.stop();
    }

    public static TimeMeter newAndStart(long j) {
        TimeMeter timeMeter = new TimeMeter();
        timeMeter.start(j);
        return timeMeter;
    }

    public long start(long j) {
        if (this.mLeftPoint.compareAndSet(-1L, j)) {
            this.mLength.set(0L);
            this.mStartPoint = this.mLeftPoint.get();
        }
        return this.mLeftPoint.get();
    }
}
