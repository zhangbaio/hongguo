package kotlin.math;

import com.bytedance.covode.number.Covode;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MathKt__MathJVMKt extends b {
    static {
        Covode.recordClassIndex(658592);
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(double d) {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(float f) {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(int i) {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(long j) {
    }

    public static /* synthetic */ void getSign$annotations(double d) {
    }

    public static /* synthetic */ void getSign$annotations(float f) {
    }

    public static /* synthetic */ void getSign$annotations(int i) {
    }

    public static /* synthetic */ void getSign$annotations(long j) {
    }

    public static /* synthetic */ void getUlp$annotations(double d) {
    }

    public static /* synthetic */ void getUlp$annotations(float f) {
    }

    private static final double abs(double d) {
        return Math.abs(d);
    }

    private static final double acos(double d) {
        return Math.acos(d);
    }

    private static final float acosh(float f) {
        return (float) acosh(f);
    }

    private static final double asin(double d) {
        return Math.asin(d);
    }

    private static final float asinh(float f) {
        return (float) asinh(f);
    }

    private static final double atan(double d) {
        return Math.atan(d);
    }

    private static final float atanh(float f) {
        return (float) atanh(f);
    }

    private static final double cbrt(double d) {
        return Math.cbrt(d);
    }

    private static final double ceil(double d) {
        return Math.ceil(d);
    }

    private static final double cos(double d) {
        return Math.cos(d);
    }

    private static final double cosh(double d) {
        return Math.cosh(d);
    }

    private static final double exp(double d) {
        return Math.exp(d);
    }

    private static final double expm1(double d) {
        return Math.expm1(d);
    }

    private static final double floor(double d) {
        return Math.floor(d);
    }

    private static final double getAbsoluteValue(double d) {
        return Math.abs(d);
    }

    private static final double getSign(double d) {
        return Math.signum(d);
    }

    private static final double getUlp(double d) {
        return Math.ulp(d);
    }

    private static final double ln(double d) {
        return Math.log(d);
    }

    private static final double ln1p(double d) {
        return Math.log1p(d);
    }

    private static final double log10(double d) {
        return Math.log10(d);
    }

    public static final double log2(double d) {
        return Math.log(d) / a.b;
    }

    private static final double nextDown(double d) {
        return Math.nextAfter(d, Double.NEGATIVE_INFINITY);
    }

    private static final double nextUp(double d) {
        return Math.nextUp(d);
    }

    private static final double round(double d) {
        return Math.rint(d);
    }

    public static long roundToLong(float f) {
        long roundToLong;
        roundToLong = roundToLong(f);
        return roundToLong;
    }

    private static final double sign(double d) {
        return Math.signum(d);
    }

    private static final double sin(double d) {
        return Math.sin(d);
    }

    private static final double sinh(double d) {
        return Math.sinh(d);
    }

    private static final double sqrt(double d) {
        return Math.sqrt(d);
    }

    private static final double tan(double d) {
        return Math.tan(d);
    }

    private static final double tanh(double d) {
        return Math.tanh(d);
    }

    private static final float abs(float f) {
        return Math.abs(f);
    }

    private static final float acos(float f) {
        return (float) Math.acos(f);
    }

    private static final float asin(float f) {
        return (float) Math.asin(f);
    }

    private static final float atan(float f) {
        return (float) Math.atan(f);
    }

    private static final float cbrt(float f) {
        return (float) Math.cbrt(f);
    }

    private static final float ceil(float f) {
        return (float) Math.ceil(f);
    }

    private static final float cos(float f) {
        return (float) Math.cos(f);
    }

    private static final float cosh(float f) {
        return (float) Math.cosh(f);
    }

    private static final float exp(float f) {
        return (float) Math.exp(f);
    }

    private static final float expm1(float f) {
        return (float) Math.expm1(f);
    }

    private static final float floor(float f) {
        return (float) Math.floor(f);
    }

    private static final float getAbsoluteValue(float f) {
        return Math.abs(f);
    }

    private static final float getSign(float f) {
        return Math.signum(f);
    }

    private static final float getUlp(float f) {
        return Math.ulp(f);
    }

    private static final float ln(float f) {
        return (float) Math.log(f);
    }

    private static final float ln1p(float f) {
        return (float) Math.log1p(f);
    }

    private static final float log10(float f) {
        return (float) Math.log10(f);
    }

    public static final float log2(float f) {
        return (float) (Math.log(f) / a.b);
    }

    private static final float nextDown(float f) {
        return Math.nextAfter(f, Double.NEGATIVE_INFINITY);
    }

    private static final float nextUp(float f) {
        return Math.nextUp(f);
    }

    private static final float round(float f) {
        return (float) Math.rint(f);
    }

    private static final float sign(float f) {
        return Math.signum(f);
    }

    private static final float sin(float f) {
        return (float) Math.sin(f);
    }

    private static final float sinh(float f) {
        return (float) Math.sinh(f);
    }

    private static final float sqrt(float f) {
        return (float) Math.sqrt(f);
    }

    private static final float tan(float f) {
        return (float) Math.tan(f);
    }

    private static final float tanh(float f) {
        return (float) Math.tanh(f);
    }

    private static final int abs(int i) {
        return Math.abs(i);
    }

    private static final int getAbsoluteValue(int i) {
        return Math.abs(i);
    }

    public static int getSign(int i) {
        return Integer.signum(i);
    }

    public static int roundToInt(float f) {
        if (!Float.isNaN(f)) {
            return Math.round(f);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static long roundToLong(double d) {
        if (!Double.isNaN(d)) {
            return Math.round(d);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static final double truncate(double d) {
        if (!Double.isNaN(d) && !Double.isInfinite(d)) {
            if (d > 0.0d) {
                return Math.floor(d);
            }
            return Math.ceil(d);
        }
        return d;
    }

    private static final long abs(long j) {
        return Math.abs(j);
    }

    public static final double atanh(double d) {
        if (Math.abs(d) < a.e) {
            if (Math.abs(d) > a.d) {
                return d + (((d * d) * d) / 3);
            }
            return d;
        }
        double d2 = 1;
        return Math.log((d2 + d) / (d2 - d)) / 2;
    }

    private static final long getAbsoluteValue(long j) {
        return Math.abs(j);
    }

    public static int getSign(long j) {
        return Long.signum(j);
    }

    public static int roundToInt(double d) {
        if (!Double.isNaN(d)) {
            if (d > 2.147483647E9d) {
                return Integer.MAX_VALUE;
            }
            if (d < -2.147483648E9d) {
                return Integer.MIN_VALUE;
            }
            return (int) Math.round(d);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static final float truncate(float f) {
        double ceil;
        if (!Float.isNaN(f) && !Float.isInfinite(f)) {
            if (f > 0.0f) {
                ceil = Math.floor(f);
            } else {
                ceil = Math.ceil(f);
            }
            return (float) ceil;
        }
        return f;
    }

    public static final double acosh(double d) {
        if (d < 1.0d) {
            return Double.NaN;
        }
        if (d > a.f) {
            return Math.log(d) + a.b;
        }
        double d2 = 1;
        double d3 = d - d2;
        if (d3 >= a.e) {
            return Math.log(d + Math.sqrt((d * d) - d2));
        }
        double sqrt = Math.sqrt(d3);
        if (sqrt >= a.d) {
            sqrt -= ((sqrt * sqrt) * sqrt) / 12;
        }
        return sqrt * Math.sqrt(2.0d);
    }

    public static final double asinh(double d) {
        double d2 = a.e;
        if (d >= d2) {
            if (d > a.g) {
                if (d > a.f) {
                    return Math.log(d) + a.b;
                }
                double d3 = d * 2;
                return Math.log(d3 + (1 / d3));
            }
            return Math.log(d + Math.sqrt((d * d) + 1));
        }
        if (d <= (-d2)) {
            return -asinh(-d);
        }
        if (Math.abs(d) >= a.d) {
            return d - (((d * d) * d) / 6);
        }
        return d;
    }

    private static final double IEEErem(double d, double d2) {
        return Math.IEEEremainder(d, d2);
    }

    private static final double atan2(double d, double d2) {
        return Math.atan2(d, d2);
    }

    private static final double hypot(double d, double d2) {
        return Math.hypot(d, d2);
    }

    private static final double max(double d, double d2) {
        return Math.max(d, d2);
    }

    private static final double min(double d, double d2) {
        return Math.min(d, d2);
    }

    private static final double nextTowards(double d, double d2) {
        return Math.nextAfter(d, d2);
    }

    private static final double pow(double d, double d2) {
        return Math.pow(d, d2);
    }

    private static final double withSign(double d, double d2) {
        return Math.copySign(d, d2);
    }

    private static final float IEEErem(float f, float f2) {
        return (float) Math.IEEEremainder(f, f2);
    }

    private static final float atan2(float f, float f2) {
        return (float) Math.atan2(f, f2);
    }

    private static final float hypot(float f, float f2) {
        return (float) Math.hypot(f, f2);
    }

    private static final float max(float f, float f2) {
        return Math.max(f, f2);
    }

    private static final float min(float f, float f2) {
        return Math.min(f, f2);
    }

    private static final float nextTowards(float f, float f2) {
        return Math.nextAfter(f, f2);
    }

    private static final double pow(double d, int i) {
        return Math.pow(d, i);
    }

    private static final double withSign(double d, int i) {
        return Math.copySign(d, i);
    }

    public static final double log(double d, double d2) {
        boolean z;
        if (d2 > 0.0d) {
            if (d2 == 1.0d) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return Math.log(d) / Math.log(d2);
            }
            return Double.NaN;
        }
        return Double.NaN;
    }

    private static final int max(int i, int i2) {
        return Math.max(i, i2);
    }

    private static final int min(int i, int i2) {
        return Math.min(i, i2);
    }

    private static final float pow(float f, float f2) {
        return (float) Math.pow(f, f2);
    }

    private static final float withSign(float f, float f2) {
        return Math.copySign(f, f2);
    }

    public static final float log(float f, float f2) {
        boolean z;
        if (f2 > 0.0f) {
            if (f2 == 1.0f) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return (float) (Math.log(f) / Math.log(f2));
            }
            return Float.NaN;
        }
        return Float.NaN;
    }

    private static final long max(long j, long j2) {
        return Math.max(j, j2);
    }

    private static final long min(long j, long j2) {
        return Math.min(j, j2);
    }

    private static final float pow(float f, int i) {
        return (float) Math.pow(f, i);
    }

    private static final float withSign(float f, int i) {
        return Math.copySign(f, i);
    }
}
