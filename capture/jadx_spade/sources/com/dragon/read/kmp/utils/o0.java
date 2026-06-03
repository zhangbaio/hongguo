package com.dragon.read.kmp.utils;

import a0.f;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.g2;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.GradientOrientation;
import com.bytedance.kmp.reading.model.w40;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o0 {
    public static final o0 a;

    static {
        Covode.recordClassIndex(609561);
        a = new o0();
    }

    private o0() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
    
        r3 = kotlin.text.StringsKt__StringsKt.removePrefix(r3, (java.lang.CharSequence) "#");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean c(java.lang.String r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L1e
            java.lang.CharSequence r3 = kotlin.text.StringsKt.trim(r3)
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L1e
            java.lang.String r1 = "#"
            java.lang.String r3 = kotlin.text.StringsKt.removePrefix(r3, r1)
            if (r3 == 0) goto L1e
            int r3 = r3.length()
            r1 = 8
            if (r3 != r1) goto L1e
            r0 = 1
        L1e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.utils.o0.c(java.lang.String):boolean");
    }

    private final androidx.compose.ui.graphics.l0 d(String str) {
        boolean z;
        Object m773constructorimpl;
        String removePrefix;
        androidx.compose.ui.graphics.l0 d;
        Object obj = null;
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            removePrefix = StringsKt__StringsKt.removePrefix(StringsKt__StringsKt.trim((CharSequence) str).toString(), (CharSequence) "#");
            int length = removePrefix.length();
            if (length != 6) {
                if (length != 8) {
                    d = null;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append('#');
                    String substring = removePrefix.substring(6);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    sb.append(substring);
                    String substring2 = removePrefix.substring(0, 6);
                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                    sb.append(substring2);
                    d = j.d(sb.toString());
                }
            } else {
                d = j.d('#' + removePrefix);
            }
            m773constructorimpl = Result.m773constructorimpl(d);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m779isFailureimpl(m773constructorimpl)) {
            obj = m773constructorimpl;
        }
        return (androidx.compose.ui.graphics.l0) obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0030 A[Catch: Exception -> 0x0052, TRY_LEAVE, TryCatch #0 {Exception -> 0x0052, blocks: (B:10:0x0011, B:12:0x0017, B:15:0x0023, B:21:0x0030), top: B:9:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long b(java.lang.String r12, java.lang.String r13, long r14) {
        /*
            r11 = this;
            r0 = 0
            r1 = 1
            if (r12 == 0) goto Ld
            int r2 = r12.length()
            if (r2 != 0) goto Lb
            goto Ld
        Lb:
            r2 = 0
            goto Le
        Ld:
            r2 = 1
        Le:
            if (r2 == 0) goto L11
            return r14
        L11:
            androidx.compose.ui.graphics.l0 r2 = r11.d(r12)     // Catch: java.lang.Exception -> L52
            if (r2 == 0) goto L51
            long r3 = r2.x()     // Catch: java.lang.Exception -> L52
            boolean r12 = r11.c(r12)     // Catch: java.lang.Exception -> L52
            if (r12 != 0) goto L50
            if (r13 == 0) goto L2c
            int r12 = r13.length()     // Catch: java.lang.Exception -> L52
            if (r12 != 0) goto L2a
            goto L2c
        L2a:
            r12 = 0
            goto L2d
        L2c:
            r12 = 1
        L2d:
            if (r12 == 0) goto L30
            goto L50
        L30:
            r12 = 0
            r2 = 0
            float r12 = com.dragon.read.kmp.utils.h0.h(r13, r12, r1, r2)     // Catch: java.lang.Exception -> L52
            r13 = 255(0xff, float:3.57E-43)
            float r1 = (float) r13     // Catch: java.lang.Exception -> L52
            float r12 = r12 * r1
            int r12 = (int) r12     // Catch: java.lang.Exception -> L52
            int r12 = kotlin.ranges.RangesKt.coerceIn(r12, r0, r13)     // Catch: java.lang.Exception -> L52
            float r12 = (float) r12     // Catch: java.lang.Exception -> L52
            r13 = 1132396544(0x437f0000, float:255.0)
            float r5 = r12 / r13
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 14
            r10 = 0
            long r12 = androidx.compose.ui.graphics.l0.n(r3, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L52
            return r12
        L50:
            return r3
        L51:
            return r14
        L52:
            r12 = move-exception
            com.dragon.read.kmp.j r0 = com.dragon.read.kmp.j.a
            java.lang.String r1 = "KmpRecommendColorUtils"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r2 = "parse color error: "
            r13.append(r2)
            java.lang.String r12 = r12.getMessage()
            r13.append(r12)
            java.lang.String r2 = r13.toString()
            r3 = 0
            r4 = 4
            r5 = 0
            com.dragon.read.kmp.j.c(r0, r1, r2, r3, r4, r5)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.utils.o0.b(java.lang.String, java.lang.String, long):long");
    }

    public final Modifier a(Modifier modifier, w40 w40Var, Theme theme, long j) {
        List list;
        boolean z;
        g2 d;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(theme, "theme");
        if (w40Var == null) {
            return BackgroundKt.d(modifier, j, (f2) null, 2, (Object) null);
        }
        if (com.dragon.read.kmp.service.d1.d(theme)) {
            list = w40Var.j;
        } else {
            list = w40Var.i;
        }
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return BackgroundKt.d(modifier, j, (f2) null, 2, (Object) null);
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(androidx.compose.ui.graphics.l0.j(j.b((String) it2.next(), j)));
        }
        if (arrayList.isEmpty()) {
            return BackgroundKt.d(modifier, j, (f2) null, 2, (Object) null);
        }
        if (arrayList.size() == 1) {
            d = new g2(((androidx.compose.ui.graphics.l0) CollectionsKt___CollectionsKt.first((List) arrayList)).x(), (DefaultConstructorMarker) null);
        } else {
            Integer num = w40Var.k;
            int value = GradientOrientation.LEFT_RIGHT.getValue();
            if (num != null && num.intValue() == value) {
                d = c0.a.d(androidx.compose.ui.graphics.c0.b, arrayList, 0.0f, 0.0f, 0, 14, (Object) null);
            } else {
                int value2 = GradientOrientation.TOP_BOTTOM.getValue();
                if (num != null && num.intValue() == value2) {
                    d = c0.a.p(androidx.compose.ui.graphics.c0.b, arrayList, 0.0f, 0.0f, 0, 14, (Object) null);
                } else {
                    int value3 = GradientOrientation.TL_BR.getValue();
                    if (num != null && num.intValue() == value3) {
                        c0.a aVar = androidx.compose.ui.graphics.c0.b;
                        f.a aVar2 = a0.f.b;
                        d = c0.a.h(aVar, arrayList, aVar2.c(), aVar2.a(), 0, 8, (Object) null);
                    } else {
                        int value4 = GradientOrientation.TR_BL.getValue();
                        if (num != null && num.intValue() == value4) {
                            d = c0.a.h(androidx.compose.ui.graphics.c0.b, arrayList, a0.f.e((Float.floatToRawIntBits(Float.POSITIVE_INFINITY) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), a0.f.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(Float.POSITIVE_INFINITY) & 4294967295L)), 0, 8, (Object) null);
                        } else {
                            d = c0.a.d(androidx.compose.ui.graphics.c0.b, arrayList, 0.0f, 0.0f, 0, 14, (Object) null);
                        }
                    }
                }
            }
        }
        return BackgroundKt.b(modifier, d, (f2) null, 0.0f, 6, (Object) null);
    }
}
