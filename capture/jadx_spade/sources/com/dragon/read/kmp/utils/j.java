package com.dragon.read.kmp.utils;

import androidx.compose.ui.graphics.y;
import com.bytedance.covode.number.Covode;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j {
    private static final Map<String, androidx.compose.ui.graphics.l0> a;

    public static final Map<String, androidx.compose.ui.graphics.l0> c() {
        return a;
    }

    static {
        Covode.recordClassIndex(609527);
        a = new LinkedHashMap();
    }

    private static final long h(long j) {
        float coerceIn;
        float coerceIn2;
        float coerceIn3;
        float coerceIn4;
        coerceIn = RangesKt___RangesKt.coerceIn(androidx.compose.ui.graphics.l0.u(j), 0.0f, 1.0f);
        coerceIn2 = RangesKt___RangesKt.coerceIn(androidx.compose.ui.graphics.l0.t(j), 0.0f, 1.0f);
        coerceIn3 = RangesKt___RangesKt.coerceIn(androidx.compose.ui.graphics.l0.r(j), 0.0f, 1.0f);
        coerceIn4 = RangesKt___RangesKt.coerceIn(androidx.compose.ui.graphics.l0.q(j), 0.0f, 1.0f);
        return androidx.compose.ui.graphics.l0.m(j, coerceIn4, coerceIn, coerceIn2, coerceIn3);
    }

    public static final androidx.compose.ui.graphics.l0 d(String str) {
        String replace$default;
        int checkRadix;
        int checkRadix2;
        int checkRadix3;
        int checkRadix4;
        int checkRadix5;
        int checkRadix6;
        int checkRadix7;
        if (str == null) {
            return null;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(str, "#", "", false, 4, (Object) null);
        if (replace$default.length() >= 8) {
            String substring = replace$default.substring(0, 2);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            checkRadix4 = CharsKt__CharJVMKt.checkRadix(16);
            int parseInt = Integer.parseInt(substring, checkRadix4);
            String substring2 = replace$default.substring(2, 4);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            checkRadix5 = CharsKt__CharJVMKt.checkRadix(16);
            int parseInt2 = Integer.parseInt(substring2, checkRadix5);
            String substring3 = replace$default.substring(4, 6);
            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
            checkRadix6 = CharsKt__CharJVMKt.checkRadix(16);
            int parseInt3 = Integer.parseInt(substring3, checkRadix6);
            String substring4 = replace$default.substring(6, 8);
            Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
            checkRadix7 = CharsKt__CharJVMKt.checkRadix(16);
            return androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.n0.c(parseInt2, parseInt3, Integer.parseInt(substring4, checkRadix7), parseInt));
        }
        if (replace$default.length() != 6) {
            return null;
        }
        String substring5 = replace$default.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(substring5, "substring(...)");
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        int parseInt4 = Integer.parseInt(substring5, checkRadix);
        String substring6 = replace$default.substring(2, 4);
        Intrinsics.checkNotNullExpressionValue(substring6, "substring(...)");
        checkRadix2 = CharsKt__CharJVMKt.checkRadix(16);
        int parseInt5 = Integer.parseInt(substring6, checkRadix2);
        String substring7 = replace$default.substring(4, 6);
        Intrinsics.checkNotNullExpressionValue(substring7, "substring(...)");
        checkRadix3 = CharsKt__CharJVMKt.checkRadix(16);
        return androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.n0.f(parseInt4, parseInt5, Integer.parseInt(substring7, checkRadix3), 0, 8, (Object) null));
    }

    public static final long a(String str, String str2) {
        long g;
        androidx.compose.ui.graphics.l0 d = d(str2);
        if (d != null) {
            g = d.x();
        } else {
            g = androidx.compose.ui.graphics.l0.b.g();
        }
        return b(str, g);
    }

    public static final long b(String str, long j) {
        String replace$default;
        int checkRadix;
        int checkRadix2;
        int checkRadix3;
        int checkRadix4;
        int checkRadix5;
        int checkRadix6;
        int checkRadix7;
        if (str == null) {
            return j;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(str, "#", "", false, 4, (Object) null);
        if (replace$default.length() >= 8) {
            String substring = replace$default.substring(0, 2);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            checkRadix4 = CharsKt__CharJVMKt.checkRadix(16);
            int parseInt = Integer.parseInt(substring, checkRadix4);
            String substring2 = replace$default.substring(2, 4);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            checkRadix5 = CharsKt__CharJVMKt.checkRadix(16);
            int parseInt2 = Integer.parseInt(substring2, checkRadix5);
            String substring3 = replace$default.substring(4, 6);
            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
            checkRadix6 = CharsKt__CharJVMKt.checkRadix(16);
            int parseInt3 = Integer.parseInt(substring3, checkRadix6);
            String substring4 = replace$default.substring(6, 8);
            Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
            checkRadix7 = CharsKt__CharJVMKt.checkRadix(16);
            return androidx.compose.ui.graphics.n0.c(parseInt, parseInt2, parseInt3, Integer.parseInt(substring4, checkRadix7));
        }
        if (replace$default.length() == 6) {
            String substring5 = replace$default.substring(0, 2);
            Intrinsics.checkNotNullExpressionValue(substring5, "substring(...)");
            checkRadix = CharsKt__CharJVMKt.checkRadix(16);
            int parseInt4 = Integer.parseInt(substring5, checkRadix);
            String substring6 = replace$default.substring(2, 4);
            Intrinsics.checkNotNullExpressionValue(substring6, "substring(...)");
            checkRadix2 = CharsKt__CharJVMKt.checkRadix(16);
            int parseInt5 = Integer.parseInt(substring6, checkRadix2);
            String substring7 = replace$default.substring(4, 6);
            Intrinsics.checkNotNullExpressionValue(substring7, "substring(...)");
            checkRadix3 = CharsKt__CharJVMKt.checkRadix(16);
            return androidx.compose.ui.graphics.n0.f(parseInt4, parseInt5, Integer.parseInt(substring7, checkRadix3), 0, 8, (Object) null);
        }
        return j;
    }

    public static final long e(String str, long j) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return j;
        }
        androidx.compose.ui.graphics.l0 l0Var = a.get(str);
        if (l0Var == null) {
            if (str.charAt(0) == '#') {
                int length = str.length();
                if (length != 7) {
                    if (length == 9) {
                        StringBuilder sb = new StringBuilder();
                        sb.append('#');
                        String substring = str.substring(7);
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        sb.append(substring);
                        String substring2 = str.substring(1, 7);
                        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                        sb.append(substring2);
                        androidx.compose.ui.graphics.l0 d = d(sb.toString());
                        if (d != null) {
                            j = d.x();
                        }
                    }
                } else {
                    androidx.compose.ui.graphics.l0 d2 = d(str);
                    if (d2 != null) {
                        j = d2.x();
                    }
                }
            } else if (str.length() == 6) {
                androidx.compose.ui.graphics.l0 d3 = d('#' + str);
                if (d3 != null) {
                    j = d3.x();
                }
            }
            l0Var = androidx.compose.ui.graphics.l0.j(j);
        }
        return l0Var.x();
    }

    public static final long f(long j, long j2, int i, Float f) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float q;
        y.a aVar = androidx.compose.ui.graphics.y.a;
        if (androidx.compose.ui.graphics.y.E(i, aVar.z())) {
            float u = androidx.compose.ui.graphics.l0.u(j2);
            float t = androidx.compose.ui.graphics.l0.t(j2);
            float r = androidx.compose.ui.graphics.l0.r(j2);
            if (f != null) {
                q = f.floatValue();
            } else {
                q = androidx.compose.ui.graphics.l0.q(j) * androidx.compose.ui.graphics.l0.q(j2);
            }
            return h(androidx.compose.ui.graphics.n0.e(u, t, r, q, (androidx.compose.ui.graphics.colorspace.c) null, 16, (Object) null));
        }
        float u2 = androidx.compose.ui.graphics.l0.u(j);
        float t2 = androidx.compose.ui.graphics.l0.t(j);
        float r2 = androidx.compose.ui.graphics.l0.r(j);
        float q2 = androidx.compose.ui.graphics.l0.q(j);
        float u3 = androidx.compose.ui.graphics.l0.u(j2);
        float t3 = androidx.compose.ui.graphics.l0.t(j2);
        float r3 = androidx.compose.ui.graphics.l0.r(j2);
        float q3 = androidx.compose.ui.graphics.l0.q(j2);
        if (androidx.compose.ui.graphics.y.E(i, aVar.r())) {
            float f9 = u2 * u3;
            float f10 = t2 * t3;
            float f11 = r2 * r3;
            if (f != null) {
                f8 = f.floatValue();
            } else {
                f8 = q2 * q3;
            }
            return h(androidx.compose.ui.graphics.n0.e(f9, f10, f11, f8, (androidx.compose.ui.graphics.colorspace.c) null, 16, (Object) null));
        }
        if (androidx.compose.ui.graphics.y.E(i, aVar.v())) {
            float f12 = 1.0f - ((1.0f - u2) * (1.0f - u3));
            float f13 = 1.0f - ((1.0f - t2) * (1.0f - t3));
            float f14 = 1.0f - ((1.0f - r2) * (1.0f - r3));
            if (f != null) {
                f7 = f.floatValue();
            } else {
                f7 = (q2 + q3) - (q2 * q3);
            }
            return h(androidx.compose.ui.graphics.n0.e(f12, f13, f14, f7, (androidx.compose.ui.graphics.colorspace.c) null, 16, (Object) null));
        }
        if (androidx.compose.ui.graphics.y.E(i, aVar.s())) {
            if (u2 <= 0.5f) {
                f3 = 2 * u2 * u3;
            } else {
                f3 = 1.0f - ((2 * (1.0f - u2)) * (1.0f - u3));
            }
            float f15 = f3;
            if (t2 <= 0.5f) {
                f4 = 2 * t2 * t3;
            } else {
                f4 = 1.0f - ((2 * (1.0f - t2)) * (1.0f - t3));
            }
            float f16 = f4;
            if (r2 <= 0.5f) {
                f5 = 2 * r2 * r3;
            } else {
                f5 = 1.0f - ((2 * (1.0f - r2)) * (1.0f - r3));
            }
            if (f != null) {
                f6 = f.floatValue();
            } else {
                f6 = q2 * q3;
            }
            return h(androidx.compose.ui.graphics.n0.e(f15, f16, f5, f6, (androidx.compose.ui.graphics.colorspace.c) null, 16, (Object) null));
        }
        if (f != null) {
            f2 = f.floatValue();
        } else {
            f2 = q2 * q3;
        }
        return h(androidx.compose.ui.graphics.n0.e(u3, t3, r3, f2, (androidx.compose.ui.graphics.colorspace.c) null, 16, (Object) null));
    }

    public static /* synthetic */ long g(long j, long j2, int i, Float f, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = androidx.compose.ui.graphics.y.a.z();
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            f = null;
        }
        return f(j, j2, i3, f);
    }
}
