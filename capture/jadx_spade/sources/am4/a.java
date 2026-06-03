package am4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base.ui.util.ScreenUtils;
import ig4.f;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import zl4.r;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    static {
        Covode.recordClassIndex(608261);
    }

    private static final String a(double d) {
        long j = (long) (d * 10.0d);
        double d2 = j / 10.0d;
        if (j % 10 == 0) {
            return String.valueOf((long) d2);
        }
        return String.valueOf(d2);
    }

    public static final String b(com.dragon.read.kmp.reader.state.a aVar) {
        boolean z;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        String str = aVar.r;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return "正在阅读";
        }
        return "累计阅读";
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String c(com.dragon.read.kmp.reader.state.a r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = r5.r
            if (r0 == 0) goto L12
            int r0 = r0.length()
            if (r0 != 0) goto L10
            goto L12
        L10:
            r0 = 0
            goto L13
        L12:
            r0 = 1
        L13:
            if (r0 != 0) goto L19
            java.lang.String r0 = r5.r
            if (r0 != 0) goto L1b
        L19:
            java.lang.String r0 = r5.q
        L1b:
            java.lang.String r5 = "人"
            if (r0 == 0) goto L3e
            java.lang.Long r0 = kotlin.text.StringsKt.toLongOrNull(r0)
            if (r0 == 0) goto L3e
            long r0 = r0.longValue()
            r2 = 100000000(0x5f5e100, double:4.94065646E-316)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L35
            java.lang.String r5 = "亿人"
            goto L3e
        L35:
            r2 = 10000(0x2710, double:4.9407E-320)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L3e
            java.lang.String r5 = "万人"
        L3e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: am4.a.c(com.dragon.read.kmp.reader.state.a):java.lang.String");
    }

    public static final String e(com.dragon.read.kmp.reader.state.a aVar) {
        long j;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Integer num = aVar.h;
        if (num != null) {
            j = num.intValue();
        } else {
            j = 0;
        }
        if (j < 100) {
            return "漫画/绘本/图书";
        }
        if (j >= 100000000) {
            return "亿字";
        }
        if (j >= 10000) {
            return "万字";
        }
        return "字";
    }

    public static final String d(com.dragon.read.kmp.reader.state.a aVar) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        String str = aVar.r;
        if (str == null && (str = aVar.q) == null) {
            str = "";
        }
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            if (longValue >= 100000000) {
                return a(longValue / 1.0E8d);
            }
            if (longValue >= 10000) {
                return a(longValue / 10000.0d);
            }
            return String.valueOf(longValue);
        }
        return str;
    }

    public static final String f(com.dragon.read.kmp.reader.state.a aVar) {
        long j;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Integer num = aVar.h;
        if (num != null) {
            j = num.intValue();
        } else {
            j = 0;
        }
        if (j < 100) {
            return "";
        }
        if (j >= 100000000) {
            return a(j / 1.0E8d);
        }
        if (j >= 10000) {
            return a(j / 10000.0d);
        }
        return String.valueOf(j);
    }

    public static final boolean g(Composer composer, int i) {
        composer.startReplaceGroup(600322080);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(600322080, i, -1, "com.dragon.read.kmp.reader.bookcover.isPadScreen (BookCoverCommonUtils.kt:89)");
        }
        boolean z = false;
        if (ScreenUtils.a.i(f.a(composer, 0)) && !((Boolean) composer.consume(r.z())).booleanValue()) {
            z = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return z;
    }
}
