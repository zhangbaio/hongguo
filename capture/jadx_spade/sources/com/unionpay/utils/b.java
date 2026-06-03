package com.unionpay.utils;

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
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    private static HashMap a;

    static {
        Covode.recordClassIndex(654932);
        a = new c();
    }

    public static int c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x008c, code lost:
    
        if (r0.equals(r9) != false) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String d(android.content.Context r9) {
        /*
            java.lang.String r0 = "sePayConf"
            java.lang.String r1 = "configs"
            java.lang.String r2 = com.unionpay.utils.UPUtils.c(r9, r1)
            java.lang.String r3 = "mode"
            java.lang.String r3 = com.unionpay.utils.UPUtils.c(r9, r3)
            java.lang.String r4 = "or"
            java.lang.String r9 = com.unionpay.utils.UPUtils.c(r9, r4)
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            r5 = 0
            r6 = 2
            java.lang.String r7 = ""
            if (r4 != 0) goto L8f
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L8f
            boolean r4 = android.text.TextUtils.isEmpty(r9)
            if (r4 != 0) goto L8f
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L8f
            r4.<init>(r2)     // Catch: java.lang.Exception -> L8f
            java.lang.String r2 = "sign"
            java.lang.String r2 = com.unionpay.utils.i.b(r4, r2)     // Catch: java.lang.Exception -> L8f
            int r3 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.Exception -> L3a
            goto L3b
        L3a:
            r3 = 0
        L3b:
            java.lang.String r8 = new java.lang.String     // Catch: java.lang.Exception -> L8f
            java.lang.String r1 = r4.getString(r1)     // Catch: java.lang.Exception -> L8f
            byte[] r1 = android.util.Base64.decode(r1, r6)     // Catch: java.lang.Exception -> L8f
            r8.<init>(r1)     // Catch: java.lang.Exception -> L8f
            boolean r1 = r4.has(r0)     // Catch: java.lang.Exception -> L8f
            if (r1 == 0) goto L5c
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Exception -> L8f
            java.lang.String r0 = r4.getString(r0)     // Catch: java.lang.Exception -> L8f
            byte[] r0 = android.util.Base64.decode(r0, r6)     // Catch: java.lang.Exception -> L8f
            r1.<init>(r0)     // Catch: java.lang.Exception -> L8f
            goto L5d
        L5c:
            r1 = r7
        L5d:
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L8f
            if (r0 == 0) goto L64
            r1 = r7
        L64:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L8f
            r0.<init>()     // Catch: java.lang.Exception -> L8f
            r0.append(r8)     // Catch: java.lang.Exception -> L8f
            r0.append(r1)     // Catch: java.lang.Exception -> L8f
            r0.append(r9)     // Catch: java.lang.Exception -> L8f
            java.lang.String r9 = r0.toString()     // Catch: java.lang.Exception -> L8f
            java.lang.String r9 = com.unionpay.utils.UPUtils.d(r9)     // Catch: java.lang.Exception -> L8f
            java.lang.String r9 = k(r9)     // Catch: java.lang.Exception -> L8f
            java.lang.String r0 = com.unionpay.utils.UPUtils.b(r3, r2)     // Catch: java.lang.Exception -> L8f
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L8f
            if (r1 != 0) goto L8f
            boolean r9 = r0.equals(r9)     // Catch: java.lang.Exception -> L8f
            if (r9 == 0) goto L8f
            goto L90
        L8f:
            r8 = r7
        L90:
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch: java.lang.Exception -> Lc4
            r9.<init>(r8)     // Catch: java.lang.Exception -> Lc4
            int r0 = r9.length()
        L99:
            if (r5 >= r0) goto Lc4
            java.lang.Object r1 = com.unionpay.utils.i.a(r9, r5)
            if (r1 == 0) goto Lc1
            org.json.JSONObject r1 = (org.json.JSONObject) r1
            java.lang.String r2 = "type"
            java.lang.String r2 = com.unionpay.utils.i.b(r1, r2)
            java.lang.String r3 = "app"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto Lc1
            java.lang.String r9 = "ca"
            java.lang.String r9 = com.unionpay.utils.i.b(r1, r9)
            java.lang.String r0 = new java.lang.String
            byte[] r9 = android.util.Base64.decode(r9, r6)
            r0.<init>(r9)
            return r0
        Lc1:
            int r5 = r5 + 1
            goto L99
        Lc4:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.utils.b.d(android.content.Context):java.lang.String");
    }

    public static String e(InputStream inputStream, String str) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    return byteArrayOutputStream.toString(str);
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Throwable unused) {
                return null;
            }
        }
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

    public static boolean g() {
        try {
            return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean h(Context context, String str) {
        PackageInfo packageInfo = null;
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && !TextUtils.isEmpty(str)) {
                    packageInfo = b(packageManager, str, 0);
                }
            } catch (Exception unused) {
            }
        }
        return packageInfo != null;
    }

    public static boolean i(Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    int p = p(context, str);
                    int q = q(str3);
                    if (h(context, str) && p >= q) {
                        if (str2.equalsIgnoreCase(j(context, str, "SHA256"))) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:15|16|17|(6:35|36|20|21|(2:23|24)|(2:27|28))|19|20|21|(0)|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0063, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
    
        r3.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005e, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005f, code lost:
    
        r3.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0050 A[Catch: CertificateEncodingException -> 0x005e, NoSuchAlgorithmException -> 0x0063, Exception -> 0x0070, TRY_LEAVE, TryCatch #2 {NoSuchAlgorithmException -> 0x0063, blocks: (B:21:0x004a, B:23:0x0050), top: B:20:0x004a, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0069 A[Catch: Exception -> 0x0070, TRY_LEAVE, TryCatch #1 {Exception -> 0x0070, blocks: (B:51:0x0005, B:7:0x000f, B:9:0x001b, B:11:0x001f, B:13:0x0022, B:15:0x0027, B:17:0x0030, B:36:0x003e, B:21:0x004a, B:23:0x0050, B:27:0x0069, B:34:0x005f, B:32:0x0064, B:39:0x0046, B:42:0x0038, B:47:0x0015), top: B:50:0x0005, inners: #0, #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String j(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            if (r3 == 0) goto La
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch: java.lang.Exception -> L70
            goto Lb
        La:
            r3 = r1
        Lb:
            if (r3 == 0) goto L18
            r2 = 64
            android.content.pm.PackageInfo r3 = b(r3, r4, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L14 java.lang.Exception -> L70
            goto L19
        L14:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Exception -> L70
        L18:
            r3 = r1
        L19:
            if (r3 == 0) goto L70
            android.content.pm.Signature[] r3 = r3.signatures     // Catch: java.lang.Exception -> L70
            if (r3 == 0) goto L70
            int r4 = r3.length     // Catch: java.lang.Exception -> L70
            if (r4 <= 0) goto L70
            r4 = 0
            r3 = r3[r4]     // Catch: java.lang.Exception -> L70
            if (r3 == 0) goto L70
            byte[] r3 = r3.toByteArray()     // Catch: java.lang.Exception -> L70
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L70
            r4.<init>(r3)     // Catch: java.lang.Exception -> L70
            java.lang.String r3 = "X509"
            java.security.cert.CertificateFactory r3 = java.security.cert.CertificateFactory.getInstance(r3)     // Catch: java.security.cert.CertificateException -> L37 java.lang.Exception -> L70
            goto L3c
        L37:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Exception -> L70
            r3 = r1
        L3c:
            if (r3 == 0) goto L49
            java.security.cert.Certificate r3 = r3.generateCertificate(r4)     // Catch: java.security.cert.CertificateException -> L45 java.lang.Exception -> L70
            java.security.cert.X509Certificate r3 = (java.security.cert.X509Certificate) r3     // Catch: java.security.cert.CertificateException -> L45 java.lang.Exception -> L70
            goto L4a
        L45:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Exception -> L70
        L49:
            r3 = r1
        L4a:
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r5)     // Catch: java.security.cert.CertificateEncodingException -> L5e java.security.NoSuchAlgorithmException -> L63 java.lang.Exception -> L70
            if (r3 == 0) goto L67
            byte[] r3 = r3.getEncoded()     // Catch: java.security.cert.CertificateEncodingException -> L5e java.security.NoSuchAlgorithmException -> L63 java.lang.Exception -> L70
            byte[] r3 = r4.digest(r3)     // Catch: java.security.cert.CertificateEncodingException -> L5e java.security.NoSuchAlgorithmException -> L63 java.lang.Exception -> L70
            java.lang.String r3 = f(r3)     // Catch: java.security.cert.CertificateEncodingException -> L5e java.security.NoSuchAlgorithmException -> L63 java.lang.Exception -> L70
            r1 = r3
            goto L67
        L5e:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Exception -> L70
            goto L67
        L63:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Exception -> L70
        L67:
            if (r1 == 0) goto L70
            java.lang.String r3 = ":"
            java.lang.String r3 = r1.replaceAll(r3, r0)     // Catch: java.lang.Exception -> L70
            return r3
        L70:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.utils.b.j(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String k(String str) {
        if (str == null) {
            return "";
        }
        char[] charArray = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        for (byte b : str.getBytes()) {
            sb.append(charArray[(b & 240) >> 4]);
            sb.append(charArray[b & 15]);
        }
        return sb.toString().trim();
    }

    public static String l(Context context, String str) {
        return j(context, str, "SHA1");
    }

    public static String m(String str) {
        return !TextUtils.isEmpty((CharSequence) a.get(str)) ? (String) a.get(str) : str;
    }

    public static String n(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo b = b(context.getPackageManager(), str, 0);
            return b != null ? b.versionName : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String o(String str) {
        if (str == null) {
            return "";
        }
        try {
            return Pattern.compile("[\":,\\[\\]{}]").matcher(str).replaceAll("").trim();
        } catch (Exception unused) {
            return "";
        }
    }

    private static int p(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            PackageInfo b = b(context.getPackageManager(), str, 0);
            if (b != null) {
                return b.versionCode;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static int q(String str) {
        try {
            return Integer.valueOf(str, 10).intValue();
        } catch (Exception unused) {
            return Integer.MAX_VALUE;
        }
    }

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo b(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            PackageInfo a2 = a(packageManager, packageName, i);
            Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return a2;
        }
        x55.b bVar = x55.b.a;
        PackageInfo f = bVar.f(packageName, i);
        if (f != null) {
            return f;
        }
        PackageInfo a3 = a(packageManager, packageName, i);
        Intrinsics.checkNotNull(a3, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i, a3);
        return a3;
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
