package com.dragon.read.kmp.util.kotlin;

import com.bytedance.covode.number.Covode;
import java.util.Arrays;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    static {
        Covode.recordClassIndex(609506);
    }

    private static final float e(float f, float f2, float f3) {
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

    private static final float h(float f, float f2, float f3, float f4, float f5) {
        return (f3 > f2 ? 1 : (f3 == f2 ? 0 : -1)) == 0 ? f4 : f4 + (((f - f2) * (f5 - f4)) / (f3 - f2));
    }

    public static final int a(float[] hsl) {
        Intrinsics.checkNotNullParameter(hsl, "hsl");
        float[] copyOf = Arrays.copyOf(hsl, hsl.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        float h = h(copyOf[1], 0.0f, 1.0f, 0.25f, 1.0f);
        float h2 = h(copyOf[2], 0.0f, 1.0f, 0.25f, 1.0f);
        float h3 = h(h, 0.25f, 1.0f, 0.65f, 0.75f);
        float h4 = h(h2, 0.25f, 1.0f, 0.65f, 0.75f);
        copyOf[1] = h3;
        copyOf[2] = h4;
        return g(copyOf, 0, 2, null);
    }

    private static final int i(String str) {
        int checkRadix;
        if (str != null) {
            if (StringsKt__StringsJVMKt.startsWith$default(str, "#", false, 2, null)) {
                String substring = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                try {
                    checkRadix = CharsKt__CharJVMKt.checkRadix(16);
                    long parseLong = Long.parseLong(substring, checkRadix);
                    int length = str.length();
                    if (length != 7) {
                        if (length == 9) {
                            return (int) parseLong;
                        }
                        throw new IllegalArgumentException("Unknown color: " + str);
                    }
                    return (int) (4278190080L | parseLong);
                } catch (Exception unused) {
                    throw new IllegalArgumentException("Unknown color: " + str);
                }
            }
            throw new IllegalArgumentException("Unknown color: " + str);
        }
        throw new NullPointerException("color is null");
    }

    public static final void j(String str, float[] hsl) {
        Intrinsics.checkNotNullParameter(hsl, "hsl");
        b(i(str), hsl);
    }

    public static final void k(String colorString, float[] hsv) {
        Intrinsics.checkNotNullParameter(colorString, "colorString");
        Intrinsics.checkNotNullParameter(hsv, "hsv");
        c(i(colorString), hsv);
    }

    public static final void c(int i, float[] hsv) {
        boolean z;
        float f;
        boolean z2;
        boolean z3;
        boolean z4;
        float f2;
        Intrinsics.checkNotNullParameter(hsv, "hsv");
        float f3 = ((i >> 16) & 255) / 255.0f;
        float f4 = ((i >> 8) & 255) / 255.0f;
        float f5 = (i & 255) / 255.0f;
        float max = Math.max(f3, Math.max(f4, f5));
        float min = max - Math.min(f3, Math.min(f4, f5));
        float f6 = 0.0f;
        if (max == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            f = min / max;
        } else {
            f = 0.0f;
        }
        if (min == 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            if (f3 == max) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                f2 = (f4 - f5) / min;
            } else {
                if (f4 == max) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    f2 = ((f5 - f3) / min) + 2.0f;
                } else {
                    f2 = ((f3 - f4) / min) + 4.0f;
                }
            }
            float f7 = f2 * 60.0f;
            if (f7 < 0.0f) {
                f6 = f7 + 360.0f;
            } else {
                f6 = f7;
            }
        }
        hsv[0] = f6;
        hsv[1] = f;
        hsv[2] = max;
    }

    public static final int l(int i, float f) {
        boolean z;
        float f2;
        boolean z2;
        float f3;
        float f4;
        float f5;
        float f6;
        float coerceIn;
        int i2 = (i >> 24) & 255;
        float f7 = ((i >> 16) & 255) / 255.0f;
        float f8 = ((i >> 8) & 255) / 255.0f;
        float f9 = (i & 255) / 255.0f;
        float max = Math.max(f7, Math.max(f8, f9));
        float min = Math.min(f7, Math.min(f8, f9));
        float f10 = max + min;
        float f11 = f10 / 2.0f;
        boolean z3 = true;
        int i3 = 0;
        if (max == min) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            f6 = 0.0f;
            f2 = 0.0f;
        } else {
            float f12 = max - min;
            if (f11 > 0.5f) {
                f2 = f12 / ((2.0f - max) - min);
            } else {
                f2 = f12 / f10;
            }
            if (max == f7) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                f3 = (f8 - f9) / f12;
                if (f8 < f9) {
                    i3 = 6;
                }
                f4 = i3;
            } else {
                if (max != f8) {
                    z3 = false;
                }
                if (z3) {
                    f5 = 2 + ((f9 - f7) / f12);
                    f6 = f5 / 6.0f;
                } else {
                    f3 = (f7 - f8) / f12;
                    f4 = 4;
                }
            }
            f5 = f3 + f4;
            f6 = f5 / 6.0f;
        }
        coerceIn = RangesKt___RangesKt.coerceIn(f, 0.0f, 1.0f);
        return d(f6, f2, coerceIn, i2);
    }

    public static final void b(int i, float[] hsl) {
        boolean z;
        float f;
        boolean z2;
        boolean z3;
        float f2;
        float f3;
        float coerceIn;
        float coerceIn2;
        float coerceIn3;
        Intrinsics.checkNotNullParameter(hsl, "hsl");
        float f4 = ((i >> 16) & 255) / 255.0f;
        float f5 = ((i >> 8) & 255) / 255.0f;
        float f6 = (i & 255) / 255.0f;
        float max = Math.max(f4, Math.max(f5, f6));
        float min = Math.min(f4, Math.min(f5, f6));
        float f7 = max - min;
        float f8 = max + min;
        float f9 = f8 / 2.0f;
        if (f7 == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            f3 = 0.0f;
            f = 0.0f;
        } else {
            if (f9 > 0.5f) {
                f8 = (2.0f - max) - min;
            }
            f = f7 / f8;
            if (max == f4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                f2 = ((f5 - f6) / f7) % 6.0f;
            } else {
                if (max == f5) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    f2 = ((f6 - f4) / f7) + 2.0f;
                } else {
                    f2 = ((f4 - f5) / f7) + 4.0f;
                }
            }
            f3 = f2 * 60.0f;
            if (f3 < 0.0f) {
                f3 += 360.0f;
            }
        }
        coerceIn = RangesKt___RangesKt.coerceIn(f3, 0.0f, 360.0f);
        hsl[0] = coerceIn;
        coerceIn2 = RangesKt___RangesKt.coerceIn(f, 0.0f, 1.0f);
        hsl[1] = coerceIn2;
        coerceIn3 = RangesKt___RangesKt.coerceIn(f9, 0.0f, 1.0f);
        hsl[2] = coerceIn3;
    }

    public static final int f(float[] hsv, int i) {
        float coerceIn;
        float coerceIn2;
        Triple triple;
        int coerceIn3;
        int coerceIn4;
        int coerceIn5;
        int coerceIn6;
        Intrinsics.checkNotNullParameter(hsv, "hsv");
        float f = hsv[0];
        float f2 = hsv[1];
        Float valueOf = Float.valueOf(0.0f);
        coerceIn = RangesKt___RangesKt.coerceIn(f2, 0.0f, 1.0f);
        coerceIn2 = RangesKt___RangesKt.coerceIn(hsv[2], 0.0f, 1.0f);
        float f3 = 360;
        float f4 = ((f % f3) + f3) % f3;
        float f5 = coerceIn * coerceIn2;
        float abs = (1.0f - Math.abs(((f4 / 60.0f) % 2.0f) - 1.0f)) * f5;
        float f6 = coerceIn2 - f5;
        if (f4 < 60.0f) {
            triple = new Triple(Float.valueOf(f5), Float.valueOf(abs), valueOf);
        } else if (f4 < 120.0f) {
            triple = new Triple(Float.valueOf(abs), Float.valueOf(f5), valueOf);
        } else if (f4 < 180.0f) {
            triple = new Triple(valueOf, Float.valueOf(f5), Float.valueOf(abs));
        } else if (f4 < 240.0f) {
            triple = new Triple(valueOf, Float.valueOf(abs), Float.valueOf(f5));
        } else if (f4 < 300.0f) {
            triple = new Triple(Float.valueOf(abs), valueOf, Float.valueOf(f5));
        } else {
            triple = new Triple(Float.valueOf(f5), valueOf, Float.valueOf(abs));
        }
        float floatValue = ((Number) triple.component1()).floatValue();
        float floatValue2 = ((Number) triple.component2()).floatValue();
        float floatValue3 = ((Number) triple.component3()).floatValue();
        float f7 = 255;
        coerceIn3 = RangesKt___RangesKt.coerceIn((int) ((floatValue + f6) * f7), 0, 255);
        coerceIn4 = RangesKt___RangesKt.coerceIn((int) ((floatValue2 + f6) * f7), 0, 255);
        coerceIn5 = RangesKt___RangesKt.coerceIn((int) ((floatValue3 + f6) * f7), 0, 255);
        coerceIn6 = RangesKt___RangesKt.coerceIn(i, 0, 255);
        return coerceIn5 | (coerceIn6 << 24) | (coerceIn3 << 16) | (coerceIn4 << 8);
    }

    public static /* synthetic */ int g(float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 255;
        }
        return f(fArr, i);
    }

    public static final int d(float f, float f2, float f3, int i) {
        boolean z;
        float f4;
        float e;
        float e2;
        int roundToInt;
        int coerceIn;
        int roundToInt2;
        int coerceIn2;
        int roundToInt3;
        int coerceIn3;
        if (f2 == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            e2 = f3;
            e = e2;
        } else {
            if (f3 < 0.5f) {
                f4 = (f2 + 1.0f) * f3;
            } else {
                f4 = (f3 + f2) - (f2 * f3);
            }
            float f5 = (f3 * 2.0f) - f4;
            float e3 = e(f5, f4, f + 0.33333334f);
            e = e(f5, f4, f);
            e2 = e(f5, f4, f - 0.33333334f);
            f3 = e3;
        }
        float f6 = 255;
        roundToInt = MathKt__MathJVMKt.roundToInt(f3 * f6);
        coerceIn = RangesKt___RangesKt.coerceIn(roundToInt, 0, 255);
        roundToInt2 = MathKt__MathJVMKt.roundToInt(e * f6);
        coerceIn2 = RangesKt___RangesKt.coerceIn(roundToInt2, 0, 255);
        roundToInt3 = MathKt__MathJVMKt.roundToInt(e2 * f6);
        coerceIn3 = RangesKt___RangesKt.coerceIn(roundToInt3, 0, 255);
        return coerceIn3 | (i << 24) | (coerceIn << 16) | (coerceIn2 << 8);
    }
}
