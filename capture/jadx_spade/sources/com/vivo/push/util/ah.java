package com.vivo.push.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.DebugManager;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ah {
    private static String[] a;
    private static String[] b;
    private static String[] c;
    private static String[] d;
    private static String[] e;
    private static Map<String, Bundle> f;

    private static Cursor com_vivo_push_util_ah_android_content_ContentResolver_query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Result preInvoke = new HeliosApiHook().preInvoke(240004, "android/content/ContentResolver", "query", contentResolver, new Object[]{uri, strArr, str, strArr2, str2}, "android.database.Cursor", new ExtraInfo(false, "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;"));
        return preInvoke.isIntercept() ? (Cursor) preInvoke.getReturnValue() : contentResolver.query(uri, strArr, str, strArr2, str2);
    }

    public static boolean a(Context context, String str, boolean z) {
        Cursor a2;
        Cursor cursor = null;
        try {
            try {
                try {
                    Uri uri = com.vivo.push.x.e;
                    String[] strArr = new String[2];
                    strArr[0] = str;
                    strArr[1] = z ? "1" : "0";
                    a2 = a(uri, "appPkgName = ? and agreePrivacyStatement = ? ", strArr, context);
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            cursor.close();
                        } catch (Exception e2) {
                            t.a("Utility", "close", e2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                t.a("Utility", "syncAgreePrivacyStatement", e3);
                if (0 != 0) {
                    cursor.close();
                }
            }
        } catch (Exception e4) {
            t.a("Utility", "close", e4);
        }
        if (a2 == null) {
            t.a("Utility", "cursor is null");
            if (a2 != null) {
                try {
                    a2.close();
                } catch (Exception e5) {
                    t.a("Utility", "close", e5);
                }
            }
            return false;
        }
        if (!a2.moveToFirst()) {
            a2.close();
            return false;
        }
        boolean parseBoolean = Boolean.parseBoolean(a2.getString(a2.getColumnIndex("agreePrivacyStatement")));
        try {
            a2.close();
        } catch (Exception e6) {
            t.a("Utility", "close", e6);
        }
        return parseBoolean;
    }

    public static boolean a(Collection<?> collection) {
        return collection == null || collection.size() <= 0;
    }

    static {
        Covode.recordClassIndex(655184);
        a = new String[]{"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
        c = new String[]{"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
        d = new String[]{"com.vivo.push.sdk.RegistrationReceiver"};
        e = new String[0];
        f = new ConcurrentHashMap();
    }

    public static long a(Context context) {
        String a2 = aa.a(context);
        if (TextUtils.isEmpty(a2)) {
            t.a("Utility", "systemPushPkgName is null");
            return -1L;
        }
        return a(context, a2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b1, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 24) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0099, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 24) goto L43;
     */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00b6: MOVE (r1 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:17170614), block:B:76:0x00b6 */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00aa A[Catch: Exception -> 0x00b4, TRY_ENTER, TryCatch #4 {Exception -> 0x00b4, blocks: (B:50:0x0092, B:52:0x0097, B:45:0x009b, B:41:0x00aa, B:43:0x00af), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00af A[Catch: Exception -> 0x00b4, TRY_LEAVE, TryCatch #4 {Exception -> 0x00b4, blocks: (B:50:0x0092, B:52:0x0097, B:45:0x009b, B:41:0x00aa, B:43:0x00af), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.security.PublicKey c(android.content.Context r12) {
        /*
            r0 = 24
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La2
            java.lang.String r3 = "Utility"
            if (r2 < r0) goto L2d
            android.content.ContentResolver r4 = r12.getContentResolver()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La2
            android.net.Uri r6 = com.vivo.push.x.a     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La2
            android.content.ContentProviderClient r4 = r4.acquireUnstableContentProviderClient(r6)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La2
            if (r4 == 0) goto L2b
            java.lang.String r5 = "client is null"
            com.vivo.push.util.t.a(r3, r5)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r5 = r4
            android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            goto L2f
        L24:
            r12 = move-exception
            goto Lb7
        L27:
            r12 = move-exception
            r5 = r1
            goto La5
        L2b:
            r5 = r1
            goto L2f
        L2d:
            r4 = r1
            r5 = r4
        L2f:
            if (r5 != 0) goto L43
            android.content.ContentResolver r6 = r12.getContentResolver()     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            android.net.Uri r7 = com.vivo.push.x.a     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r12 = com_vivo_push_util_ah_android_content_ContentResolver_query(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            r5 = r12
            goto L43
        L41:
            r12 = move-exception
            goto La5
        L43:
            if (r5 != 0) goto L52
            if (r5 == 0) goto L4a
            r5.close()     // Catch: java.lang.Exception -> L51
        L4a:
            if (r4 == 0) goto L51
            if (r2 < r0) goto L51
            r4.close()     // Catch: java.lang.Exception -> L51
        L51:
            return r1
        L52:
            boolean r12 = r5.moveToNext()     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            if (r12 == 0) goto L92
            java.lang.String r12 = "pushkey"
            java.lang.String r2 = "name"
            int r2 = r5.getColumnIndex(r2)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            java.lang.String r2 = r5.getString(r2)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            boolean r12 = r12.equals(r2)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            if (r12 == 0) goto L52
            java.lang.String r12 = "value"
            int r12 = r5.getColumnIndex(r12)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            java.lang.String r12 = r5.getString(r12)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            java.lang.String r2 = "result key : "
            java.lang.String r6 = java.lang.String.valueOf(r12)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            java.lang.String r2 = r2.concat(r6)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            com.vivo.push.util.t.d(r3, r2)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            java.security.PublicKey r12 = com.vivo.push.util.ab.a(r12)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> Lb5
            r5.close()     // Catch: java.lang.Exception -> L91
            if (r4 == 0) goto L91
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L91
            if (r1 < r0) goto L91
            r4.close()     // Catch: java.lang.Exception -> L91
        L91:
            return r12
        L92:
            r5.close()     // Catch: java.lang.Exception -> Lb4
            if (r4 == 0) goto Lb4
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> Lb4
            if (r12 < r0) goto Lb4
        L9b:
            r4.close()     // Catch: java.lang.Exception -> Lb4
            goto Lb4
        L9f:
            r12 = move-exception
            r4 = r1
            goto Lb7
        La2:
            r12 = move-exception
            r4 = r1
            r5 = r4
        La5:
            r12.printStackTrace()     // Catch: java.lang.Throwable -> Lb5
            if (r5 == 0) goto Lad
            r5.close()     // Catch: java.lang.Exception -> Lb4
        Lad:
            if (r4 == 0) goto Lb4
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> Lb4
            if (r12 < r0) goto Lb4
            goto L9b
        Lb4:
            return r1
        Lb5:
            r12 = move-exception
            r1 = r5
        Lb7:
            if (r1 == 0) goto Lbc
            r1.close()     // Catch: java.lang.Exception -> Lc5
        Lbc:
            if (r4 == 0) goto Lc5
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> Lc5
            if (r1 < r0) goto Lc5
            r4.close()     // Catch: java.lang.Exception -> Lc5
        Lc5:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ah.c(android.content.Context):java.security.PublicKey");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00eb A[Catch: Exception -> 0x00e7, TryCatch #2 {Exception -> 0x00e7, blocks: (B:77:0x00e3, B:65:0x00eb, B:67:0x00ef), top: B:76:0x00e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean d(android.content.Context r19) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ah.d(android.content.Context):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c8, code lost:
    
        r10 = r10 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(android.content.Context r15) throws com.vivo.push.util.VivoPushException {
        /*
            Method dump skipped, instructions count: 642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ah.b(android.content.Context):void");
    }

    public static Object a(String str, String str2) throws Exception {
        Class q = l3.a.q(str);
        return q.getField(str2).get(q);
    }

    public static String b(Context context, String str) {
        Object a2 = a(context, str, "verification_status");
        if (a2 != null) {
            return a2.toString();
        }
        return "";
    }

    public static int c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            int a2 = (int) a(context, str);
            if (a2 <= 0) {
                return d(context, str);
            }
            return a2;
        }
        t.a("Utility", "getClientSdkVersionCode() error, context is null or pkgName is empty");
        return 0;
    }

    public static long a(Context context, String str) {
        Object a2 = a(context, str, "com.vivo.push.sdk_version");
        if (a2 == null) {
            a2 = a(context, str, "sdk_version");
        }
        if (a2 != null) {
            try {
                return Long.parseLong(a2.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                t.a("Utility", "getSdkVersionCode error ", e2);
                return -1L;
            }
        }
        t.a("Utility", "getSdkVersionCode sdk version is null");
        return -1L;
    }

    public static String b(String str, String str2) {
        String str3;
        try {
            str3 = (String) l3.a.q("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        if (str3 != null && str3.length() != 0) {
            return str3;
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int d(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "Utility"
            r1 = 0
            if (r3 == 0) goto L46
            boolean r2 = android.text.TextUtils.isEmpty(r4)
            if (r2 == 0) goto Lc
            goto L46
        Lc:
            java.lang.String r2 = "sdk_version_vivo"
            java.lang.Object r3 = a(r3, r4, r2)
            boolean r4 = r3 instanceof java.lang.String
            if (r4 == 0) goto L1b
            java.lang.String r3 = (java.lang.String) r3
        L18:
            r4 = r3
            r3 = 0
            goto L2f
        L1b:
            boolean r4 = r3 instanceof java.lang.Integer
            if (r4 == 0) goto L28
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.String r4 = ""
            goto L2f
        L28:
            if (r3 == 0) goto L45
            java.lang.String r3 = r3.toString()
            goto L18
        L2f:
            if (r3 <= 0) goto L32
            return r3
        L32:
            int r1 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Exception -> L37
            goto L45
        L37:
            r3 = move-exception
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "getClientSdkVersion: "
            java.lang.String r3 = r4.concat(r3)
            com.vivo.push.util.t.a(r0, r3)
        L45:
            return r1
        L46:
            java.lang.String r3 = "getClientSdkVersion() error, context is null or pkgName is empty"
            com.vivo.push.util.t.a(r0, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ah.d(android.content.Context, java.lang.String):int");
    }

    private static void a(ComponentInfo componentInfo, String str) throws VivoPushException {
        if (componentInfo.applicationInfo.packageName.equals(str)) {
            return;
        }
        for (String str2 : a) {
            if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(":pushservice")) {
                throw new VivoPushException("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
            }
        }
    }

    @Proxy("getApplicationInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static ApplicationInfo INVOKEVIRTUAL_com_vivo_push_util_ah_com_dragon_read_resource_PackageManagerAop_getApplicationInfo(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, i);
            Intrinsics.checkNotNull(applicationInfo, "null cannot be cast to non-null type android.content.pm.ApplicationInfo");
            return applicationInfo;
        }
        x55.b bVar = x55.b.a;
        ApplicationInfo d2 = bVar.d(packageName, i);
        if (d2 != null) {
            return d2;
        }
        ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo(packageName, i);
        Intrinsics.checkNotNull(applicationInfo2, "null cannot be cast to non-null type android.content.pm.ApplicationInfo");
        bVar.a(packageName, i, applicationInfo2);
        return applicationInfo2;
    }

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_vivo_push_util_ah_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            PackageInfo INVOKEVIRTUAL_com_vivo_push_util_ah_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_vivo_push_util_ah_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
            Intrinsics.checkNotNull(INVOKEVIRTUAL_com_vivo_push_util_ah_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return INVOKEVIRTUAL_com_vivo_push_util_ah_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
        }
        x55.b bVar = x55.b.a;
        PackageInfo f2 = bVar.f(packageName, i);
        if (f2 != null) {
            return f2;
        }
        PackageInfo INVOKEVIRTUAL_com_vivo_push_util_ah_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_vivo_push_util_ah_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
        Intrinsics.checkNotNull(INVOKEVIRTUAL_com_vivo_push_util_ah_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i, INVOKEVIRTUAL_com_vivo_push_util_ah_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
        return INVOKEVIRTUAL_com_vivo_push_util_ah_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
    }

    @Proxy("getPackageInfo")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_vivo_push_util_ah_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i) {
        if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
            return null;
        }
        if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
            LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + Log.getStackTraceString(new Exception()), new Object[0]);
        }
        return packageManager.getPackageInfo(str, i);
    }

    public static Object a(Context context, String str, String str2) {
        Object obj;
        Object obj2;
        Bundle bundle;
        Bundle bundle2 = null;
        if (context == null || str2 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, Bundle> map = f;
            if (map != null && map.size() > 0 && (bundle = f.get(str)) != null) {
                obj = bundle.get(str2);
            } else {
                obj = null;
            }
            if (obj != null) {
                return obj;
            }
            try {
                ApplicationInfo INVOKEVIRTUAL_com_vivo_push_util_ah_com_dragon_read_resource_PackageManagerAop_getApplicationInfo = INVOKEVIRTUAL_com_vivo_push_util_ah_com_dragon_read_resource_PackageManagerAop_getApplicationInfo(context.getPackageManager(), str, 128);
                if (INVOKEVIRTUAL_com_vivo_push_util_ah_com_dragon_read_resource_PackageManagerAop_getApplicationInfo != null) {
                    bundle2 = INVOKEVIRTUAL_com_vivo_push_util_ah_com_dragon_read_resource_PackageManagerAop_getApplicationInfo.metaData;
                }
                if (bundle2 != null) {
                    obj2 = bundle2.get(str2);
                } else {
                    obj2 = obj;
                }
                try {
                    if (f.size() <= 300) {
                        f.put(str, bundle2);
                        return obj2;
                    }
                    return obj2;
                } catch (Exception e2) {
                    bundle2 = obj2;
                    e = e2;
                    t.a("Utility", "getMetaValue::".concat(String.valueOf(e)));
                    return bundle2;
                }
            } catch (Exception e3) {
                e = e3;
                bundle2 = obj;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    private static void a(String str, ComponentInfo[] componentInfoArr, String str2) throws VivoPushException {
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (str.equals(componentInfo.name)) {
                if (componentInfo.enabled) {
                    a(componentInfo, str2);
                    return;
                }
                throw new VivoPushException(componentInfo.name + " module Push-SDK need is illegitmacy !");
            }
        }
        throw new VivoPushException(str + " module Push-SDK need is not exist");
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0082: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:67502210), block:B:49:0x0082 */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.database.Cursor a(android.net.Uri r13, java.lang.String r14, java.lang.String[] r15, android.content.Context r16) {
        /*
            java.lang.String r1 = "close"
            r2 = 24
            java.lang.String r3 = "Utility"
            r4 = 0
            if (r16 != 0) goto Lf
            java.lang.String r0 = "context is null"
            com.vivo.push.util.t.a(r3, r0)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            return r4
        Lf:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            if (r0 < r2) goto L30
            android.content.ContentResolver r5 = r16.getContentResolver()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            r12 = r13
            android.content.ContentProviderClient r5 = r5.acquireUnstableContentProviderClient(r13)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            if (r5 == 0) goto L2e
            java.lang.String r6 = "client is null"
            com.vivo.push.util.t.a(r3, r6)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L81
            r8 = 0
            r11 = 0
            r6 = r5
            r7 = r13
            r9 = r14
            r10 = r15
            android.database.Cursor r6 = r6.query(r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L81
            goto L33
        L2e:
            r6 = r4
            goto L33
        L30:
            r12 = r13
            r5 = r4
            r6 = r5
        L33:
            if (r6 != 0) goto L45
            android.content.ContentResolver r6 = r16.getContentResolver()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L81
            r8 = 0
            r11 = 0
            r7 = r13
            r9 = r14
            r10 = r15
            android.database.Cursor r6 = com_vivo_push_util_ah_android_content_ContentResolver_query(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L81
            goto L45
        L43:
            r0 = move-exception
            goto L6d
        L45:
            if (r6 != 0) goto L5a
            java.lang.String r6 = "cursor is null"
            com.vivo.push.util.t.a(r3, r6)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L81
            if (r5 == 0) goto L59
            if (r0 < r2) goto L59
            r5.close()     // Catch: java.lang.Exception -> L54
            goto L59
        L54:
            r0 = move-exception
            r2 = r0
            com.vivo.push.util.t.a(r3, r1, r2)
        L59:
            return r4
        L5a:
            if (r5 == 0) goto L67
            if (r0 < r2) goto L67
            r5.close()     // Catch: java.lang.Exception -> L62
            goto L67
        L62:
            r0 = move-exception
            r2 = r0
            com.vivo.push.util.t.a(r3, r1, r2)
        L67:
            return r6
        L68:
            r0 = move-exception
        L69:
            r5 = r0
            goto L84
        L6b:
            r0 = move-exception
            r5 = r4
        L6d:
            java.lang.String r6 = "queryContentResolver"
            com.vivo.push.util.t.a(r3, r6, r0)     // Catch: java.lang.Throwable -> L81
            if (r5 == 0) goto L80
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L7c
            if (r0 < r2) goto L80
            r5.close()     // Catch: java.lang.Exception -> L7c
            goto L80
        L7c:
            r0 = move-exception
            com.vivo.push.util.t.a(r3, r1, r0)
        L80:
            return r4
        L81:
            r0 = move-exception
            r4 = r5
            goto L69
        L84:
            if (r4 == 0) goto L92
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L8e
            if (r0 < r2) goto L92
            r4.close()     // Catch: java.lang.Exception -> L8e
            goto L92
        L8e:
            r0 = move-exception
            com.vivo.push.util.t.a(r3, r1, r0)
        L92:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ah.a(android.net.Uri, java.lang.String, java.lang.String[], android.content.Context):android.database.Cursor");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d5 A[Catch: Exception -> 0x00d1, TryCatch #7 {Exception -> 0x00d1, blocks: (B:74:0x00cd, B:62:0x00d5, B:64:0x00d9), top: B:73:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(android.content.Context r16, java.lang.String r17, java.lang.String r18, long r19) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ah.a(android.content.Context, java.lang.String, java.lang.String, long):boolean");
    }
}
