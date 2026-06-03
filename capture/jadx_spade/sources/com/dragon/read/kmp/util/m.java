package com.dragon.read.kmp.util;

import com.bytedance.covode.number.Covode;
import kotlin.time.TimeSource$Monotonic;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m {
    public static final m a;
    private static final com.dragon.read.kmp.i b;
    private static final kotlin.time.m c;
    public static final int d;

    private m() {
    }

    private final long d() {
        return Clock.System.INSTANCE.now().toEpochMilliseconds();
    }

    public final long c() {
        return kotlin.time.c.r(c.mo1054elapsedNowUwyO8pc());
    }

    static {
        Covode.recordClassIndex(609490);
        a = new m();
        b = new com.dragon.read.kmp.i("TimeUtils");
        c = TimeSource$Monotonic.ValueTimeMark.m1039boximpl(TimeSource$Monotonic.INSTANCE.m1037markNowz9LOYto());
        d = 8;
    }

    public final boolean b(long j) {
        long d2 = d();
        zm6.l a2 = zm6.l.Companion.a();
        Instant.a aVar = Instant.Companion;
        if (zm6.m.c(aVar.a(d2), a2).k() == zm6.m.c(aVar.a(j), a2).k()) {
            return true;
        }
        return false;
    }

    public final boolean a(long j, long j2) {
        long j3 = (((j2 + 28800000) / 86400000) * 86400000) - 28800000;
        if (j >= j3 && j < j3 + 86400000) {
            return true;
        }
        return false;
    }
}
