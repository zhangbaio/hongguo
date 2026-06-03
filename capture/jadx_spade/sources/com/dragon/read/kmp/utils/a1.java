package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.time.DurationUnit;
import kotlin.time.TimeSource$Monotonic;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a1 {
    public static final a1 a;
    private static final kotlin.time.m b;
    public static final int c;

    private a1() {
    }

    public final int a() {
        return c(b());
    }

    public final long b() {
        return Clock.System.INSTANCE.now().toEpochMilliseconds();
    }

    public final kotlin.time.m g() {
        return TimeSource$Monotonic.ValueTimeMark.m1039boximpl(TimeSource$Monotonic.INSTANCE.m1037markNowz9LOYto());
    }

    static {
        Covode.recordClassIndex(609574);
        a1 a1Var = new a1();
        a = a1Var;
        b = a1Var.g();
        c = 8;
    }

    public final int c(long j) {
        return zm6.m.c(Instant.Companion.a(j), zm6.l.Companion.a()).b().f();
    }

    public final String h(long j) {
        long b2 = b() + (j * 1000);
        zm6.h c2 = zm6.m.c(Instant.Companion.a(b2), zm6.l.Companion.a());
        String padStart = StringsKt__StringsKt.padStart(String.valueOf(c2.d()), 2, '0');
        String padStart2 = StringsKt__StringsKt.padStart(String.valueOf(c2.e()), 2, '0');
        StringBuilder sb = new StringBuilder();
        sb.append(c2.c());
        sb.append((char) 26085);
        String[] strArr = {sb.toString(), padStart + ':' + padStart2};
        int a2 = a();
        int c3 = c(b2);
        if (c3 == a2) {
            return "今天" + strArr[1];
        }
        if (c3 == a2 + 1) {
            return "明天" + strArr[1];
        }
        if (c3 == a2 + 2) {
            return "后天" + strArr[1];
        }
        return strArr[0] + strArr[1];
    }

    public final long d(kotlin.time.m mark, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(mark, "mark");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return kotlin.time.c.T(mark.mo1054elapsedNowUwyO8pc(), unit);
    }

    public final long m(kotlin.time.m mark, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(mark, "mark");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return kotlin.time.c.T(mark.mo1054elapsedNowUwyO8pc(), unit);
    }

    public final String i(long j, boolean z) {
        StringBuilder sb = new StringBuilder();
        long j2 = 3600;
        long j3 = j / j2;
        if (j3 > 0 || z) {
            if (j3 < 10) {
                sb.append('0');
            }
            sb.append(j3);
            sb.append(':');
        }
        long j4 = 60;
        long j5 = (j % j2) / j4;
        if (j5 < 10) {
            sb.append('0');
        }
        sb.append(j5);
        sb.append(':');
        long j6 = j % j4;
        if (j6 < 10) {
            sb.append('0');
        }
        sb.append(j6);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final String f(long j, boolean z) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        if (j < 0) {
            j = 0;
        }
        long j2 = ((int) j) / 3600000;
        long j3 = j - (3600000 * j2);
        long j4 = j3 / 60000;
        long j5 = j3 - (60000 * j4);
        if (j4 <= 9) {
            sb = new StringBuilder();
            sb.append('0');
        } else {
            sb = new StringBuilder();
            sb.append("");
        }
        sb.append(j4);
        String sb4 = sb.toString();
        if (j5 <= 9) {
            sb2 = new StringBuilder();
            sb2.append('0');
        } else {
            sb2 = new StringBuilder();
            sb2.append("");
        }
        sb2.append(j5);
        String sb5 = sb2.toString();
        if (!z && j2 <= 0) {
            return sb4 + ':' + sb5;
        }
        if (j2 <= 9) {
            sb3 = new StringBuilder();
            sb3.append('0');
        } else {
            sb3 = new StringBuilder();
            sb3.append("");
        }
        sb3.append(j2);
        return sb3.toString() + ':' + sb4 + ':' + sb5;
    }

    public final String k(int i, boolean z, boolean z2) {
        if (z && i % 3600 == 0) {
            if (z2) {
                return ' ' + (i / 3600) + " 小时";
            }
            return (i / 3600) + "小时";
        }
        if (i > 60) {
            if (z2) {
                return ' ' + (i / 60) + " 分钟";
            }
            return (i / 60) + "分钟";
        }
        if (z2) {
            return ' ' + i + " 秒";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append((char) 31186);
        return sb.toString();
    }

    public static /* synthetic */ long e(a1 a1Var, kotlin.time.m mVar, DurationUnit durationUnit, int i, Object obj) {
        if ((i & 2) != 0) {
            durationUnit = DurationUnit.MILLISECONDS;
        }
        return a1Var.d(mVar, durationUnit);
    }

    public static /* synthetic */ String j(a1 a1Var, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return a1Var.i(j, z);
    }

    public static /* synthetic */ long n(a1 a1Var, kotlin.time.m mVar, DurationUnit durationUnit, int i, Object obj) {
        if ((i & 1) != 0) {
            mVar = b;
        }
        if ((i & 2) != 0) {
            durationUnit = DurationUnit.MILLISECONDS;
        }
        return a1Var.m(mVar, durationUnit);
    }

    public static /* synthetic */ String l(a1 a1Var, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return a1Var.k(i, z, z2);
    }
}
