package com.tt.android.qualitystat.config;

import com.bytedance.covode.number.Covode;
import com.tt.android.qualitystat.base.QualityStatLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    private static int a;
    private static long b;
    private static long c;
    private static long d;
    private static boolean e;
    private static boolean f;
    public static final d g;

    private d() {
    }

    public final long d() {
        return b;
    }

    public final int e() {
        return a;
    }

    private final long c() {
        return b + 86400000;
    }

    private final long b() {
        return c() - 900000;
    }

    static {
        Covode.recordClassIndex(654038);
        d dVar = new d();
        g = dVar;
        a = -1;
        b = dVar.f();
    }

    private final long f() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        Intrinsics.checkExpressionValueIsNotNull(calendar, "Calendar.getInstance().a…ndar.SECOND, 0)\n        }");
        Date time = calendar.getTime();
        Intrinsics.checkExpressionValueIsNotNull(time, "Calendar.getInstance().a…SECOND, 0)\n        }.time");
        return time.getTime();
    }

    private final long a(long j) {
        List listOf;
        Comparable min;
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j > 86400000) {
            return -1L;
        }
        long j2 = 300000;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Long[]{Long.valueOf(b + j2), Long.valueOf(b()), Long.valueOf(c() + j2)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listOf) {
            if (((Number) obj).longValue() > currentTimeMillis) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        min = CollectionsKt___CollectionsJvmKt.min((Iterable) arrayList);
        Long l = (Long) min;
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public final void g(boolean z) {
        boolean enable;
        Boolean enable2;
        b bVar = b.f;
        StatConfig d2 = bVar.d();
        if (d2 != null && (enable2 = d2.getEnable()) != null) {
            enable = enable2.booleanValue();
        } else {
            enable = StatConfig.i.c().enable();
        }
        h(enable, z);
        QualityStatLog qualityStatLog = QualityStatLog.c;
        StringBuilder sb = new StringBuilder();
        sb.append("SamplingConfigHelper init, oldConfig=");
        sb.append(enable);
        sb.append(", newConfig=");
        sb.append(z);
        sb.append(", samplingType=");
        sb.append(a);
        sb.append(", samplingEffectMode=");
        c cVar = c.b;
        sb.append(cVar.c().C());
        qualityStatLog.f(sb.toString());
        if (enable != z) {
            bVar.e(enable, z);
            com.tt.android.qualitystat.base.d.c.f(true);
        }
        b = f();
        Triple<Long, Boolean, Boolean> a2 = bVar.a();
        if (a2 != null) {
            c = a2.getFirst().longValue();
            e = a2.getSecond().booleanValue();
        }
        f = z;
        d = a(c);
        qualityStatLog.f("last enable status change = " + a2 + ", nextJudgeTs=" + d + ", " + ((d - System.currentTimeMillis()) / 3600000) + " hour later, should report now = " + cVar.a());
    }

    public final boolean i(boolean z) {
        if (d > 0) {
            boolean z2 = e;
            boolean z3 = f;
            if (z2 != z3) {
                if (System.currentTimeMillis() < d) {
                    return e;
                }
                z3 = true;
                if (f ? System.currentTimeMillis() <= c() + 300000 : System.currentTimeMillis() >= b()) {
                    z3 = false;
                }
                d = a(c);
                QualityStatLog.c.f("shouldReport=" + z3 + ", localConfig=" + z + ", cachedStatusEnable=" + e + ", latestStatusEnable=" + f + ", lastSamplingChangeTime=" + c + ", nextJudgeTs=" + d);
            }
            return z3;
        }
        return z;
    }

    private final void h(boolean z, boolean z2) {
        if (z && z2) {
            a = 3;
            return;
        }
        if (!z && z2) {
            a = 1;
            return;
        }
        if (z && !z2) {
            a = 2;
        } else if (!z && !z2) {
            a = 0;
        }
    }
}
