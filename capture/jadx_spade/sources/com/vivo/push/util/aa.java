package com.vivo.push.util;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.DebugManager;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class aa {
    private static Boolean a;
    private static String b;

    private static Cursor com_vivo_push_util_aa_android_content_ContentResolver_query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Result preInvoke = new HeliosApiHook().preInvoke(240004, "android/content/ContentResolver", "query", contentResolver, new Object[]{uri, strArr, str, strArr2, str2}, "android.database.Cursor", new ExtraInfo(false, "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;"));
        return preInvoke.isIntercept() ? (Cursor) preInvoke.getReturnValue() : contentResolver.query(uri, strArr, str, strArr2, str2);
    }

    static {
        Covode.recordClassIndex(655177);
        b = null;
    }

    public static boolean b(Context context) {
        ProviderInfo resolveContentProvider;
        Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = null;
        if (context != null && !TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (resolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128)) != null) {
            str = resolveContentProvider.packageName;
        }
        Boolean valueOf = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(f(context, str)));
        a = valueOf;
        return valueOf.booleanValue();
    }

    private static com.vivo.push.model.a c(Context context) {
        String a2 = a(context);
        ApplicationInfo applicationInfo = null;
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        com.vivo.push.model.a aVar = new com.vivo.push.model.a(a2);
        try {
            PackageInfo INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_resource_PackageManagerAop_getPackageInfo = INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_resource_PackageManagerAop_getPackageInfo(context.getPackageManager(), a2, 128);
            if (INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_resource_PackageManagerAop_getPackageInfo != null) {
                aVar.a(INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_resource_PackageManagerAop_getPackageInfo.versionCode);
                aVar.a(INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_resource_PackageManagerAop_getPackageInfo.versionName);
                applicationInfo = INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_resource_PackageManagerAop_getPackageInfo.applicationInfo;
            }
            if (applicationInfo != null) {
                aVar.a(ah.a(context, a2));
            }
            aVar.a(a(context, a2));
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            t.b("PushPackageUtils", "PackageManager NameNotFoundException is null", e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0100 A[Catch: Exception -> 0x00eb, TRY_ENTER, TryCatch #3 {Exception -> 0x00eb, blocks: (B:75:0x00de, B:77:0x00e3, B:79:0x00e7, B:33:0x0100, B:35:0x0105, B:37:0x0109), top: B:7:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0105 A[Catch: Exception -> 0x00eb, TryCatch #3 {Exception -> 0x00eb, blocks: (B:75:0x00de, B:77:0x00e3, B:79:0x00e7, B:33:0x0100, B:35:0x0105, B:37:0x0109), top: B:7:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.aa.a(android.content.Context):java.lang.String");
    }

    public static boolean c(Context context, String str) {
        return a(context, str, "com.vivo.pushclient.action.RECEIVE");
    }

    public static boolean d(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.RECEIVE");
    }

    public static int b(Context context, String str) {
        int i;
        if (a(context, str, "com.vivo.pushservice.action.RECEIVE")) {
            i = 0;
        } else {
            i = -1;
        }
        if (a(context, str, "com.vivo.pushclient.action.RECEIVE")) {
            return 1;
        }
        return i;
    }

    public static boolean a(Context context, String str) {
        ServiceInfo serviceInfo;
        if (!TextUtils.isEmpty(str) && context != null) {
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(str);
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, TTVideoEngineInterface.PLAYER_OPTION_PRE_RENDER_BUFFERING_UPDATE_PRECENTAGE);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                int size = queryIntentServices.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    ResolveInfo resolveInfo = queryIntentServices.get(i);
                    if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                        String str2 = serviceInfo.name;
                        boolean z2 = serviceInfo.exported;
                        if ("com.vivo.push.sdk.service.PushService".equals(str2) && z2) {
                            boolean z3 = resolveInfo.serviceInfo.enabled;
                            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.vivo.push.sdk.service.PushService"));
                            if (componentEnabledSetting != 1 && (componentEnabledSetting != 0 || !z3)) {
                                z = false;
                            } else {
                                z = true;
                            }
                        }
                    }
                }
                return z;
            }
            t.a("PushPackageUtils", "isEnablePush error: can not find push service.");
        }
        return false;
    }

    private static com.vivo.push.model.a e(Context context, String str) {
        boolean z;
        ApplicationInfo applicationInfo;
        if (!TextUtils.isEmpty(str)) {
            if (!a(context, str, "com.vivo.pushservice.action.METHOD") && !a(context, str, "com.vivo.pushservice.action.RECEIVE")) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                com.vivo.push.model.a aVar = new com.vivo.push.model.a(str);
                try {
                    PackageInfo INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_resource_PackageManagerAop_getPackageInfo = INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_resource_PackageManagerAop_getPackageInfo(context.getPackageManager(), str, 128);
                    if (INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_resource_PackageManagerAop_getPackageInfo != null) {
                        aVar.a(INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_resource_PackageManagerAop_getPackageInfo.versionCode);
                        aVar.a(INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_resource_PackageManagerAop_getPackageInfo.versionName);
                        applicationInfo = INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_resource_PackageManagerAop_getPackageInfo.applicationInfo;
                    } else {
                        applicationInfo = null;
                    }
                    if (applicationInfo != null) {
                        aVar.a(ah.a(context, str));
                    }
                    aVar.a(a(context, str));
                    return aVar;
                } catch (Exception e) {
                    t.a("PushPackageUtils", "getPushPackageInfo exception: ", e);
                }
            }
        }
        return null;
    }

    private static String f(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                Signature[] signatureArr = INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_resource_PackageManagerAop_getPackageInfo(context.getPackageManager(), str, 64).signatures;
                byte[] digest = MessageDigest.getInstance("SHA256").digest(signatureArr[0].toByteArray());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : digest) {
                    String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                    if (upperCase.length() == 1) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(upperCase);
                }
                return stringBuffer.toString();
            } catch (Exception e) {
                t.a("PushPackageUtils", " getSignatureSHA exception ".concat(String.valueOf(e)));
            }
        }
        return null;
    }

    public static com.vivo.push.model.a a(Context context, com.vivo.push.restructure.b.b bVar) {
        com.vivo.push.model.a aVar;
        com.vivo.push.model.a e;
        Context applicationContext = ContextDelegate.getContext(context).getApplicationContext();
        com.vivo.push.model.a c = c(applicationContext);
        if (c != null) {
            t.d("PushPackageUtils", "get system push info :".concat(String.valueOf(c)));
            return c;
        }
        List<String> a2 = bVar.a(applicationContext);
        com.vivo.push.model.a e2 = e(applicationContext, applicationContext.getPackageName());
        if (a2 != null && a2.size() > 0) {
            com.vivo.push.model.a aVar2 = null;
            String a3 = af.b(applicationContext).a("com.vivo.push.cur_pkg", null);
            if (TextUtils.isEmpty(a3) || !a(applicationContext, a3, "com.vivo.pushservice.action.METHOD") || (aVar = e(applicationContext, a3)) == null || !aVar.d()) {
                aVar = null;
            }
            if (e2 == null || !e2.d()) {
                e2 = null;
            }
            if (aVar == null) {
                aVar = null;
            }
            if (e2 == null || (aVar != null && (!e2.c() ? !(aVar.c() || e2.b() > aVar.b()) : !(aVar.c() && e2.b() > aVar.b())))) {
                e2 = aVar;
            }
            HashMap hashMap = new HashMap();
            if (e2 != null) {
                if (e2.c()) {
                    aVar2 = e2;
                    e2 = null;
                }
            } else {
                e2 = null;
            }
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                String str = a2.get(i);
                if (!TextUtils.isEmpty(str) && (e = e(applicationContext, str)) != null) {
                    hashMap.put(str, e);
                    if (e.d()) {
                        if (e.c()) {
                            if (aVar2 == null || e.b() > aVar2.b()) {
                                aVar2 = e;
                            }
                        } else if (e2 == null || e.b() > e2.b()) {
                            e2 = e;
                        }
                    }
                }
            }
            if (e2 == null) {
                t.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                e2 = aVar2;
            }
        } else {
            if (e2 != null && e2.d()) {
                c = e2;
            }
            t.a("PushPackageUtils", "findAllPushPackages error: find no package!");
            e2 = c;
        }
        if (e2 != null) {
            if (e2.c()) {
                t.a(applicationContext, "查找最优包为:" + e2.a() + "(" + e2.b() + ", Black)");
                t.d("PushPackageUtils", "finSuitablePushPackage" + e2.a() + "(" + e2.b() + ", Black)");
            } else {
                t.a(applicationContext, "查找最优包为:" + e2.a() + "(" + e2.b() + ")");
                t.d("PushPackageUtils", "finSuitablePushPackage" + e2.a() + "(" + e2.b() + ")");
            }
        } else {
            t.b(applicationContext, "查找最优包为空!");
            t.d("PushPackageUtils", "finSuitablePushPackage is null");
        }
        return e2;
    }

    private static boolean a(Context context, String str, String str2) {
        List<ResolveInfo> list;
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, TTVideoEngineInterface.PLAYER_OPTION_PRE_RENDER_BUFFERING_UPDATE_PRECENTAGE);
        } catch (Exception unused) {
            list = null;
        }
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            PackageInfo INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
            Intrinsics.checkNotNull(INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
        }
        x55.b bVar = x55.b.a;
        PackageInfo f = bVar.f(packageName, i);
        if (f != null) {
            return f;
        }
        PackageInfo INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
        Intrinsics.checkNotNull(INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i, INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
        return INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
    }

    @Proxy("getPackageInfo")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_vivo_push_util_aa_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i) {
        if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
            return null;
        }
        if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
            LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + Log.getStackTraceString(new Exception()), new Object[0]);
        }
        return packageManager.getPackageInfo(str, i);
    }
}
