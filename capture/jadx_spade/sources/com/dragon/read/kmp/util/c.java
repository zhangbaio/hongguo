package com.dragon.read.kmp.util;

import androidx.compose.ui.graphics.n0;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.v0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;
    private static final com.dragon.read.kmp.i b;

    private c() {
    }

    private static final float d(float f, float f2, float f3) {
        float f4;
        if (f3 < 0.0f) {
            f3 += 1.0f;
        }
        if (f3 > 1.0f) {
            f3 -= 1.0f;
        }
        if (f3 < 0.16666667f) {
            f4 = (f2 - f) * 6.0f * f3;
        } else {
            if (f3 < 0.5f) {
                return f2;
            }
            if (f3 >= 0.6666667f) {
                return f;
            }
            f4 = (f2 - f) * (0.6666667f - f3) * 6.0f;
        }
        return f + f4;
    }

    static {
        Covode.recordClassIndex(609459);
        a = new c();
        b = new com.dragon.read.kmp.i("ColorUtils");
    }

    private final int f(String str) {
        int checkRadix;
        if (StringsKt__StringsJVMKt.startsWith$default(str, "#", false, 2, null)) {
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            checkRadix = CharsKt__CharJVMKt.checkRadix(16);
            long parseLong = Long.parseLong(substring, checkRadix);
            int length = substring.length();
            if (length != 6) {
                if (length == 8) {
                    return (int) parseLong;
                }
                throw new IllegalArgumentException("Unknown color length: " + str);
            }
            return (-16777216) | ((int) parseLong);
        }
        throw new IllegalArgumentException("Unknown color format: " + str);
    }

    public final int b(float[] hsl) {
        int coerceIn;
        int coerceIn2;
        int coerceIn3;
        Intrinsics.checkNotNullParameter(hsl, "hsl");
        float f = hsl[0];
        float f2 = hsl[1];
        float f3 = hsl[2];
        float abs = (1.0f - Math.abs((2 * f3) - 1.0f)) * f2;
        float f4 = f3 - (0.5f * abs);
        float abs2 = (1.0f - Math.abs(((f / 60.0f) % 2.0f) - 1.0f)) * abs;
        int i = (((int) f) / 60) % 6;
        float f5 = 0.0f;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                abs = 0.0f;
                            }
                        } else {
                            abs2 = abs;
                            abs = abs2;
                        }
                        coerceIn = RangesKt___RangesKt.coerceIn((int) ((abs + f4) * 255.0f), 0, 255);
                        coerceIn2 = RangesKt___RangesKt.coerceIn((int) ((f5 + f4) * 255.0f), 0, 255);
                        coerceIn3 = RangesKt___RangesKt.coerceIn((int) ((abs2 + f4) * 255.0f), 0, 255);
                        return coerceIn3 | (coerceIn << 16) | (-16777216) | (coerceIn2 << 8);
                    }
                    f5 = abs2;
                    abs2 = abs;
                } else {
                    f5 = abs;
                }
                abs = 0.0f;
                coerceIn = RangesKt___RangesKt.coerceIn((int) ((abs + f4) * 255.0f), 0, 255);
                coerceIn2 = RangesKt___RangesKt.coerceIn((int) ((f5 + f4) * 255.0f), 0, 255);
                coerceIn3 = RangesKt___RangesKt.coerceIn((int) ((abs2 + f4) * 255.0f), 0, 255);
                return coerceIn3 | (coerceIn << 16) | (-16777216) | (coerceIn2 << 8);
            }
            f5 = abs;
            abs = abs2;
        } else {
            f5 = abs2;
        }
        abs2 = 0.0f;
        coerceIn = RangesKt___RangesKt.coerceIn((int) ((abs + f4) * 255.0f), 0, 255);
        coerceIn2 = RangesKt___RangesKt.coerceIn((int) ((f5 + f4) * 255.0f), 0, 255);
        coerceIn3 = RangesKt___RangesKt.coerceIn((int) ((abs2 + f4) * 255.0f), 0, 255);
        return coerceIn3 | (coerceIn << 16) | (-16777216) | (coerceIn2 << 8);
    }

    public final int g(String str, String defaultColor) {
        Intrinsics.checkNotNullParameter(defaultColor, "defaultColor");
        return e(h(str, defaultColor), defaultColor);
    }

    public final int e(String str, String defaultColor) {
        Intrinsics.checkNotNullParameter(defaultColor, "defaultColor");
        if (!v0.a.a(str)) {
            Intrinsics.checkNotNull(str);
            try {
                return f(str);
            } catch (Throwable th) {
                b.b("illegal color " + str, th);
            }
        }
        return f(defaultColor);
    }

    public final void a(int i, float[] hsl) {
        boolean z;
        float f;
        float f2;
        float coerceIn;
        float coerceIn2;
        float coerceIn3;
        boolean z2;
        boolean z3;
        boolean z4;
        float f3;
        float f4;
        float f5;
        Intrinsics.checkNotNullParameter(hsl, "hsl");
        float f6 = ((i >> 16) & 255) / 255.0f;
        float f7 = ((i >> 8) & 255) / 255.0f;
        float f8 = (i & 255) / 255.0f;
        float max = Math.max(f6, Math.max(f7, f8));
        float min = Math.min(f6, Math.min(f7, f8));
        float f9 = max - min;
        float f10 = max + min;
        float f11 = f10 / 2.0f;
        if (max == min) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (f11 > 0.5f) {
                f10 = (2.0f - max) - min;
            }
            f2 = f9 / f10;
            if (max == f6) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                f4 = (f7 - f8) / f9;
                if (f7 < f8) {
                    f5 = 6.0f;
                } else {
                    f5 = 0.0f;
                }
            } else {
                if (max == f7) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    f3 = ((f8 - f6) / f9) + 2.0f;
                } else {
                    if (max == f8) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        f4 = (f6 - f7) / f9;
                        f5 = 4.0f;
                    } else {
                        f3 = 0.0f;
                    }
                }
                f = f3 / 6.0f;
            }
            f3 = f4 + f5;
            f = f3 / 6.0f;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        coerceIn = RangesKt___RangesKt.coerceIn(f * 360.0f, 0.0f, 360.0f);
        hsl[0] = coerceIn;
        coerceIn2 = RangesKt___RangesKt.coerceIn(f2, 0.0f, 1.0f);
        hsl[1] = coerceIn2;
        coerceIn3 = RangesKt___RangesKt.coerceIn(f11, 0.0f, 1.0f);
        hsl[2] = coerceIn3;
    }

    public final String h(String str, String defaultColor) {
        Intrinsics.checkNotNullParameter(defaultColor, "defaultColor");
        if (str == null) {
            return defaultColor;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder("#");
        if (length == 7 && str.charAt(0) == '#') {
            return str;
        }
        if (length == 9 && str.charAt(0) == '#') {
            String substring = str.substring(7, 9);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            sb.append(substring);
            String substring2 = str.substring(1, 7);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            sb.append(substring2);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
        if ((length == 4 || length == 5) && str.charAt(0) == '#') {
            if (length == 5) {
                sb.append(str.charAt(4));
                sb.append(str.charAt(4));
            }
            sb.append(str.charAt(1));
            sb.append(str.charAt(1));
            sb.append(str.charAt(2));
            sb.append(str.charAt(2));
            sb.append(str.charAt(3));
            sb.append(str.charAt(3));
            String sb3 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
            return sb3;
        }
        return defaultColor;
    }

    public final long c(float f, float f2, float f3) {
        float f4;
        float f5 = (f % 360.0f) / 360.0f;
        if (f3 < 0.5f) {
            f4 = (f2 + 1.0f) * f3;
        } else {
            f4 = (f3 + f2) - (f2 * f3);
        }
        float f6 = (f3 * 2.0f) - f4;
        return n0.e(d(f6, f4, f5 + 0.33333334f), d(f6, f4, f5), d(f6, f4, f5 - 0.33333334f), 1.0f, (androidx.compose.ui.graphics.colorspace.c) null, 16, (Object) null);
    }
}
