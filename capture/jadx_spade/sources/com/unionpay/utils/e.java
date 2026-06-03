package com.unionpay.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.DebugManager;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e {
    static {
        Covode.recordClassIndex(654935);
    }

    public static String c() {
        String str = Build.VERSION.RELEASE;
        return !TextUtils.isEmpty(str) ? str.trim() : "";
    }

    public static String d(Context context) {
        try {
            String packageName = context instanceof Activity ? ((Activity) context).getPackageName() : "";
            return packageName == null ? "" : packageName;
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String e(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = ""
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch: java.lang.Exception -> L6d
            r1 = 64
            r2 = 0
            android.content.pm.PackageInfo r3 = b(r3, r4, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Le java.lang.Exception -> L6d
            goto L13
        Le:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Exception -> L6d
            r3 = r2
        L13:
            if (r3 == 0) goto L71
            android.content.pm.Signature[] r3 = r3.signatures     // Catch: java.lang.Exception -> L6d
            r4 = 0
            r3 = r3[r4]     // Catch: java.lang.Exception -> L6d
            byte[] r3 = r3.toByteArray()     // Catch: java.lang.Exception -> L6d
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L6d
            r4.<init>(r3)     // Catch: java.lang.Exception -> L6d
            java.lang.String r3 = "X509"
            java.security.cert.CertificateFactory r3 = java.security.cert.CertificateFactory.getInstance(r3)     // Catch: java.security.cert.CertificateException -> L2a java.lang.Exception -> L6d
            goto L2f
        L2a:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Exception -> L6d
            r3 = r2
        L2f:
            if (r3 == 0) goto L41
            java.security.cert.Certificate r3 = r3.generateCertificate(r4)     // Catch: java.security.cert.CertificateException -> L3d java.lang.Exception -> L6d
            boolean r4 = r3 instanceof java.security.cert.X509Certificate     // Catch: java.security.cert.CertificateException -> L3d java.lang.Exception -> L6d
            if (r4 == 0) goto L41
            java.security.cert.X509Certificate r3 = (java.security.cert.X509Certificate) r3     // Catch: java.security.cert.CertificateException -> L3d java.lang.Exception -> L6d
            r2 = r3
            goto L41
        L3d:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Exception -> L6d
        L41:
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r5)     // Catch: java.security.cert.CertificateEncodingException -> L54 java.security.NoSuchAlgorithmException -> L59 java.lang.Exception -> L6d
            if (r2 == 0) goto L5d
            byte[] r4 = r2.getEncoded()     // Catch: java.security.cert.CertificateEncodingException -> L54 java.security.NoSuchAlgorithmException -> L59 java.lang.Exception -> L6d
            byte[] r3 = r3.digest(r4)     // Catch: java.security.cert.CertificateEncodingException -> L54 java.security.NoSuchAlgorithmException -> L59 java.lang.Exception -> L6d
            java.lang.String r3 = f(r3)     // Catch: java.security.cert.CertificateEncodingException -> L54 java.security.NoSuchAlgorithmException -> L59 java.lang.Exception -> L6d
            goto L5e
        L54:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Exception -> L6d
            goto L5d
        L59:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Exception -> L6d
        L5d:
            r3 = r0
        L5e:
            if (r3 == 0) goto L6b
            java.lang.String r4 = ":"
            java.lang.String r0 = r3.replaceAll(r4, r0)     // Catch: java.lang.Exception -> L67
            goto L71
        L67:
            r4 = move-exception
            r0 = r3
            r3 = r4
            goto L6e
        L6b:
            r0 = r3
            goto L71
        L6d:
            r3 = move-exception
        L6e:
            r3.printStackTrace()
        L71:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.utils.e.e(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    private static String f(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase());
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    public static String g() {
        String str = Build.MODEL;
        if (!TextUtils.isEmpty(str)) {
            String trim = str.trim();
            if (!TextUtils.isEmpty(trim)) {
                return trim.replace(" ", "");
            }
        }
        return "";
    }

    public static String h(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String c = UPUtils.c(context, "merchant_id");
            if (TextUtils.isEmpty(c)) {
                c = UUID.randomUUID().toString();
                if (!TextUtils.isEmpty(c)) {
                    c = c.replaceAll("-", "");
                    UPUtils.g(context, c, "merchant_id");
                }
            }
            return c;
        } catch (Exception unused) {
            return "";
        }
    }

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo b(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            PackageInfo a = a(packageManager, packageName, i);
            Intrinsics.checkNotNull(a, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return a;
        }
        x55.b bVar = x55.b.a;
        PackageInfo f = bVar.f(packageName, i);
        if (f != null) {
            return f;
        }
        PackageInfo a2 = a(packageManager, packageName, i);
        Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i, a2);
        return a2;
    }

    @Proxy("getPackageInfo")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
    public static PackageInfo a(PackageManager packageManager, String str, int i) {
        if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
            return null;
        }
        if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
            LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + Log.getStackTraceString(new Exception()), new Object[0]);
        }
        return packageManager.getPackageInfo(str, i);
    }
}
