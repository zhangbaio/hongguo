package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i0 {
    public static final i0 a;

    static {
        Covode.recordClassIndex(609555);
        a = new i0();
    }

    private i0() {
    }

    public final String a(long j) {
        return c(j, true);
    }

    public final String h(long j) {
        return i(String.valueOf(j));
    }

    public final String i(String intString) {
        Long longOrNull;
        long j;
        Intrinsics.checkNotNullParameter(intString, "intString");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(intString);
        if (longOrNull != null) {
            j = longOrNull.longValue();
        } else {
            j = 0;
        }
        return j0.a(j, true);
    }

    public final String c(long j, boolean z) {
        return j0.a(j, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000f A[Catch: Exception -> 0x0014, TRY_LEAVE, TryCatch #0 {Exception -> 0x0014, blocks: (B:14:0x0002, B:7:0x000f), top: B:13:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final double d(java.lang.String r2, double r3) {
        /*
            r1 = this;
            if (r2 == 0) goto Lb
            int r0 = r2.length()     // Catch: java.lang.Exception -> L14
            if (r0 != 0) goto L9
            goto Lb
        L9:
            r0 = 0
            goto Lc
        Lb:
            r0 = 1
        Lc:
            if (r0 == 0) goto Lf
            goto L14
        Lf:
            double r2 = java.lang.Double.parseDouble(r2)     // Catch: java.lang.Exception -> L14
            r3 = r2
        L14:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.utils.i0.d(java.lang.String, double):double");
    }

    public final float e(String number, float f) {
        boolean z;
        Intrinsics.checkNotNullParameter(number, "number");
        try {
            if (number.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return Float.parseFloat(number);
            }
            return f;
        } catch (Exception unused) {
            return f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000f A[Catch: Exception -> 0x0014, TRY_LEAVE, TryCatch #0 {Exception -> 0x0014, blocks: (B:14:0x0002, B:7:0x000f), top: B:13:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g(java.lang.String r2, int r3) {
        /*
            r1 = this;
            if (r2 == 0) goto Lb
            int r0 = r2.length()     // Catch: java.lang.Exception -> L14
            if (r0 != 0) goto L9
            goto Lb
        L9:
            r0 = 0
            goto Lc
        Lb:
            r0 = 1
        Lc:
            if (r0 == 0) goto Lf
            goto L14
        Lf:
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Exception -> L14
            r3 = r2
        L14:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.utils.i0.g(java.lang.String, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000f A[Catch: Exception -> 0x0014, TRY_LEAVE, TryCatch #0 {Exception -> 0x0014, blocks: (B:13:0x0002, B:7:0x000f), top: B:12:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long f(java.lang.String r7, long r8) {
        /*
            r6 = this;
            if (r7 == 0) goto Lb
            int r0 = r7.length()     // Catch: java.lang.Exception -> L14
            if (r0 != 0) goto L9
            goto Lb
        L9:
            r0 = 0
            goto Lc
        Lb:
            r0 = 1
        Lc:
            if (r0 == 0) goto Lf
            goto L13
        Lf:
            long r8 = java.lang.Long.parseLong(r7)     // Catch: java.lang.Exception -> L14
        L13:
            return r8
        L14:
            com.dragon.read.kmp.j r0 = com.dragon.read.kmp.j.a
            java.lang.String r1 = "NumberUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Parse Long Error: %s"
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            r3 = 0
            r4 = 4
            r5 = 0
            com.dragon.read.kmp.j.c(r0, r1, r2, r3, r4, r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.utils.i0.f(java.lang.String, long):long");
    }

    public final String b(long j, boolean z) {
        if (j < 0) {
            return "0";
        }
        if (j < 10000) {
            return String.valueOf(j);
        }
        if (j < 100000000) {
            long j2 = ((j * 10) + 5000) / 10000;
            long j3 = j2 / 10;
            int i = (int) (j2 % 10);
            if (z && i == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(j3);
                sb.append((char) 19975);
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(j3);
            sb2.append('.');
            sb2.append(i);
            sb2.append((char) 19975);
            return sb2.toString();
        }
        long j4 = ((j * 10) + 50000000) / 100000000;
        long j5 = j4 / 10;
        int i2 = (int) (j4 % 10);
        if (z && i2 == 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(j5);
            sb3.append((char) 20159);
            return sb3.toString();
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(j5);
        sb4.append('.');
        sb4.append(i2);
        sb4.append((char) 20159);
        return sb4.toString();
    }
}
