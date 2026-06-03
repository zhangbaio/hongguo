package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j0 {
    static {
        Covode.recordClassIndex(609556);
    }

    public static final String a(long j, boolean z) {
        if (j < 0) {
            return "0";
        }
        if (j < 10000) {
            return String.valueOf(j);
        }
        if (j < 100000000) {
            long j2 = (long) (j / 1000.0f);
            if (z) {
                long j3 = 10;
                if (j2 % j3 == 0) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(Locale.getDefault(), "%d万", Arrays.copyOf(new Object[]{Long.valueOf(j2 / j3)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    return format;
                }
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(Locale.getDefault(), "%.1f万", Arrays.copyOf(new Object[]{Float.valueOf(j2 / 10.0f)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        }
        if (j < 1000000000) {
            long j4 = j / 10000000;
            if (z) {
                long j5 = 10;
                if (j4 % j5 == 0) {
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    String format3 = String.format(Locale.getDefault(), "%d亿", Arrays.copyOf(new Object[]{Long.valueOf(j4 / j5)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                    return format3;
                }
            }
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            String format4 = String.format(Locale.getDefault(), "%.1f亿", Arrays.copyOf(new Object[]{Float.valueOf((j4 * 1.0f) / 10)}, 1));
            Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
            return format4;
        }
        StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
        String format5 = String.format(Locale.getDefault(), "%d亿", Arrays.copyOf(new Object[]{Long.valueOf(j / 100000000)}, 1));
        Intrinsics.checkNotNullExpressionValue(format5, "format(...)");
        return format5;
    }
}
