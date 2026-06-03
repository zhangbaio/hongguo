package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;
import kotlinx.datetime.format.m1;
import kotlinx.datetime.format.y;
import zm6.l;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o {
    public static final o a;
    private static final Object b;
    private static final Map<String, kotlinx.datetime.format.x<zm6.h>> c;
    private static final zm6.l d;
    public static final int e;

    private o() {
    }

    public final String e() {
        return d(Clock.System.INSTANCE.now().toEpochMilliseconds(), "yyyy-MM-dd");
    }

    static {
        Covode.recordClassIndex(609533);
        a = new o();
        b = new Object();
        c = new LinkedHashMap();
        d = zm6.l.Companion.c("UTC+8");
        e = 8;
    }

    private final zm6.h k(long j) {
        return zm6.m.c(Instant.Companion.a(j), d);
    }

    public final long h(long j) {
        Instant a2 = Instant.Companion.a(j);
        zm6.l a3 = zm6.l.Companion.a();
        return zm6.m.a(zm6.m.c(a2, a3).b(), a3).toEpochMilliseconds();
    }

    public final boolean i(long j) {
        if (h(Clock.System.INSTANCE.now().toEpochMilliseconds()) == h(j)) {
            return true;
        }
        return false;
    }

    private final kotlinx.datetime.format.x<zm6.h> f(final String str) {
        synchronized (b) {
            Map<String, kotlinx.datetime.format.x<zm6.h>> map = c;
            kotlinx.datetime.format.x<zm6.h> xVar = map.get(str);
            if (xVar != null) {
                return xVar;
            }
            kotlinx.datetime.format.x<zm6.h> a2 = zm6.h.Companion.a(new Function1() { // from class: com.dragon.read.kmp.utils.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit g;
                    g = o.g(str, (y.b) obj);
                    return g;
                }
            });
            map.put(str, a2);
            return a2;
        }
    }

    public final String j(long j) {
        long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds();
        Instant.a aVar = Instant.Companion;
        Instant a2 = aVar.a(epochMilliseconds);
        l.a aVar2 = zm6.l.Companion;
        int k = zm6.m.c(a2, aVar2.a()).k();
        int k2 = zm6.m.c(aVar.a(j), aVar2.a()).k();
        if (epochMilliseconds >= j) {
            long j2 = epochMilliseconds - j;
            if (j2 < 60000) {
                return "刚刚";
            }
            if (j2 < 3600000) {
                return (j2 / 60000) + "分钟前";
            }
            if (j2 < 86400000) {
                return (j2 / 3600000) + "小时前";
            }
            if (j2 < 345600000) {
                return (j2 / 86400000) + "天前";
            }
            if (k == k2) {
                return d(j, "M-d");
            }
            return d(j, "yyyy-M-d");
        }
        if (j - epochMilliseconds < 60000) {
            return "刚刚";
        }
        return d(j, "yyyy-M-d");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(String str, y.b Format) {
        Intrinsics.checkNotNullParameter(Format, "$this$Format");
        m1.i(Format, str);
        return Unit.INSTANCE;
    }

    public final int b(long j, long j2) {
        return (int) ((h(j2) - h(j)) / 86400000);
    }

    public final int c(long j, long j2) {
        return Math.abs((int) ((h(j2) - h(j)) / 86400000));
    }

    public final String d(long j, String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        return f(pattern).format(k(j));
    }
}
