package com.vivo.push;

import android.os.SystemClock;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class y {
    private volatile long a = -1;

    static {
        Covode.recordClassIndex(655215);
    }

    public final synchronized boolean a() {
        boolean z;
        long j = this.a;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (j != -1 && elapsedRealtime > j && elapsedRealtime < j + 2000) {
            z = true;
        } else {
            z = false;
        }
        this.a = SystemClock.elapsedRealtime();
        return z;
    }
}
