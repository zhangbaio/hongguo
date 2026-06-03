package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.DebugManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class m {
    static {
        Covode.recordClassIndex(655311);
    }

    public static class a extends RuntimeException {
        static {
            Covode.recordClassIndex(655312);
        }

        public a(String str) {
            super(str);
        }
    }

    public static void a(final Context context) {
        new Thread(new Runnable() { // from class: com.xiaomi.mipush.sdk.m.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_m$1_com_dragon_read_resource_PackageManagerAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_mipush_sdk_m$1_com_dragon_read_resource_PackageManagerAop_getPackageInfo(context.getPackageManager(), context.getPackageName(), 4612);
                    m.c(context);
                    m.d(context, INVOKEVIRTUAL_com_xiaomi_mipush_sdk_m$1_com_dragon_read_resource_PackageManagerAop_getPackageInfo);
                    m.c(context, INVOKEVIRTUAL_com_xiaomi_mipush_sdk_m$1_com_dragon_read_resource_PackageManagerAop_getPackageInfo);
                } catch (Throwable th) {
                    Log.e("ManifestChecker", "", th);
                }
            }

            @Proxy("getPackageInfo")
            @TargetClass("android.content.pm.PackageManager")
            public static PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_m$1_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i) {
                Intrinsics.checkNotNullParameter(packageName, "packageName");
                if (x55.a.a()) {
                    PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_m$1_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_mipush_sdk_m$1_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
                    Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_mipush_sdk_m$1_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
                    return INVOKEVIRTUAL_com_xiaomi_mipush_sdk_m$1_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
                }
                x55.b bVar = x55.b.a;
                PackageInfo f = bVar.f(packageName, i);
                if (f != null) {
                    return f;
                }
                PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_m$1_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_xiaomi_mipush_sdk_m$1_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
                Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_mipush_sdk_m$1_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
                bVar.c(packageName, i, INVOKEVIRTUAL_com_xiaomi_mipush_sdk_m$1_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
                return INVOKEVIRTUAL_com_xiaomi_mipush_sdk_m$1_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
            }

            @Proxy("getPackageInfo")
            @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
            public static PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_m$1_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i) {
                if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
                    return null;
                }
                if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
                    LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + Log.getStackTraceString(new Exception()), new Object[0]);
                }
                return packageManager.getPackageInfo(str, i);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a2 A[EDGE_INSN: B:23:0x00a2->B:24:0x00a2 BREAK  A[LOOP:0: B:8:0x006e->B:37:0x006e], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(android.content.Context r8) {
        /*
            java.lang.String r0 = "com.xiaomi.push.service.receivers.PingReceiver"
            android.content.pm.PackageManager r1 = r8.getPackageManager()
            java.lang.String r2 = r8.getPackageName()
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = com.xiaomi.push.service.an.q
            r3.<init>(r4)
            r3.setPackage(r2)
            r4 = 1
            r5 = 0
            java.lang.Class r6 = com.xiaomi.push.q.a(r8, r0)     // Catch: java.lang.ClassNotFoundException -> L55
            android.content.pm.ActivityInfo r3 = a(r1, r3, r6)     // Catch: java.lang.ClassNotFoundException -> L55
            boolean r6 = com.xiaomi.mipush.sdk.MiPushClient.shouldUseMIUIPush(r8)     // Catch: java.lang.ClassNotFoundException -> L55
            r7 = 2
            if (r6 != 0) goto L45
            if (r3 == 0) goto L35
            java.lang.Boolean[] r0 = new java.lang.Boolean[r7]     // Catch: java.lang.ClassNotFoundException -> L55
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch: java.lang.ClassNotFoundException -> L55
            r0[r5] = r6     // Catch: java.lang.ClassNotFoundException -> L55
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch: java.lang.ClassNotFoundException -> L55
            r0[r4] = r6     // Catch: java.lang.ClassNotFoundException -> L55
            a(r3, r0)     // Catch: java.lang.ClassNotFoundException -> L55
            goto L59
        L35:
            com.xiaomi.mipush.sdk.m$a r3 = new com.xiaomi.mipush.sdk.m$a     // Catch: java.lang.ClassNotFoundException -> L55
            java.lang.String r6 = "<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest."
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch: java.lang.ClassNotFoundException -> L55
            r7[r5] = r0     // Catch: java.lang.ClassNotFoundException -> L55
            java.lang.String r0 = java.lang.String.format(r6, r7)     // Catch: java.lang.ClassNotFoundException -> L55
            r3.<init>(r0)     // Catch: java.lang.ClassNotFoundException -> L55
            throw r3     // Catch: java.lang.ClassNotFoundException -> L55
        L45:
            if (r3 == 0) goto L59
            java.lang.Boolean[] r0 = new java.lang.Boolean[r7]     // Catch: java.lang.ClassNotFoundException -> L55
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch: java.lang.ClassNotFoundException -> L55
            r0[r5] = r6     // Catch: java.lang.ClassNotFoundException -> L55
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch: java.lang.ClassNotFoundException -> L55
            r0[r4] = r6     // Catch: java.lang.ClassNotFoundException -> L55
            a(r3, r0)     // Catch: java.lang.ClassNotFoundException -> L55
            goto L59
        L55:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r0)
        L59:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r3 = "com.xiaomi.mipush.RECEIVE_MESSAGE"
            r0.<init>(r3)
            r0.setPackage(r2)
            r2 = 16384(0x4000, float:2.2959E-41)
            java.util.List r0 = r1.queryBroadcastReceivers(r0, r2)
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L6e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto La2
            java.lang.Object r2 = r0.next()
            android.content.pm.ResolveInfo r2 = (android.content.pm.ResolveInfo) r2
            android.content.pm.ActivityInfo r2 = r2.activityInfo
            if (r2 == 0) goto L9f
            java.lang.String r3 = r2.name     // Catch: java.lang.ClassNotFoundException -> L9a
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.ClassNotFoundException -> L9a
            if (r3 != 0) goto L9f
            java.lang.Class<com.xiaomi.mipush.sdk.PushMessageReceiver> r3 = com.xiaomi.mipush.sdk.PushMessageReceiver.class
            java.lang.String r6 = r2.name     // Catch: java.lang.ClassNotFoundException -> L9a
            java.lang.Class r6 = com.xiaomi.push.q.a(r8, r6)     // Catch: java.lang.ClassNotFoundException -> L9a
            boolean r3 = r3.isAssignableFrom(r6)     // Catch: java.lang.ClassNotFoundException -> L9a
            if (r3 == 0) goto L9f
            boolean r1 = r2.enabled     // Catch: java.lang.ClassNotFoundException -> L9a
            if (r1 == 0) goto L9f
            r1 = 1
            goto La0
        L9a:
            r2 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r2)
            goto L6e
        L9f:
            r1 = 0
        La0:
            if (r1 == 0) goto L6e
        La2:
            if (r1 == 0) goto Lc6
            boolean r0 = com.xiaomi.mipush.sdk.MiPushClient.getOpenHmsPush(r8)
            if (r0 == 0) goto Lb8
            java.lang.String r0 = "com.huawei.android.push.intent.RECEIVE"
            java.lang.String r1 = "com.xiaomi.assemble.control.HmsPushReceiver"
            a(r8, r0, r1)
            java.lang.String r0 = "com.huawei.intent.action.PUSH"
            java.lang.String r1 = "com.huawei.hms.support.api.push.PushEventReceiver"
            a(r8, r0, r1)
        Lb8:
            boolean r0 = com.xiaomi.mipush.sdk.MiPushClient.getOpenVIVOPush(r8)
            if (r0 == 0) goto Lc5
            java.lang.String r0 = "com.vivo.pushclient.action.RECEIVE"
            java.lang.String r1 = "com.xiaomi.assemble.control.FTOSPushMessageReceiver"
            a(r8, r0, r1)
        Lc5:
            return
        Lc6:
            com.xiaomi.mipush.sdk.m$a r8 = new com.xiaomi.mipush.sdk.m$a
            java.lang.String r0 = "Receiver: none of the subclasses of PushMessageReceiver is enabled or defined."
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.m.c(android.content.Context):void");
    }

    private static boolean a(PackageInfo packageInfo, String[] strArr) {
        for (ServiceInfo serviceInfo : packageInfo.services) {
            if (a(strArr, serviceInfo.name)) {
                return true;
            }
        }
        return false;
    }

    private static void a(ActivityInfo activityInfo, Boolean[] boolArr) {
        if (boolArr[0].booleanValue() == activityInfo.enabled) {
            if (boolArr[1].booleanValue() == activityInfo.exported) {
                return;
            } else {
                throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", activityInfo.name, boolArr[1]));
            }
        }
        throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", activityInfo.name, boolArr[0]));
    }

    private static boolean a(String[] strArr, String str) {
        if (strArr != null && str != null) {
            for (String str2 : strArr) {
                if (TextUtils.equals(str2, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, PackageInfo packageInfo) {
        boolean z;
        HashSet hashSet = new HashSet();
        String str = context.getPackageName() + ".permission.MIPUSH_RECEIVE";
        hashSet.addAll(Arrays.asList("android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", str, "android.permission.ACCESS_WIFI_STATE", "android.permission.VIBRATE"));
        PermissionInfo[] permissionInfoArr = packageInfo.permissions;
        if (permissionInfoArr != null) {
            for (PermissionInfo permissionInfo : permissionInfoArr) {
                if (str.equals(permissionInfo.name)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            String[] strArr = packageInfo.requestedPermissions;
            if (strArr != null) {
                for (String str2 : strArr) {
                    if (!TextUtils.isEmpty(str2) && hashSet.contains(str2)) {
                        hashSet.remove(str2);
                        if (hashSet.isEmpty()) {
                            break;
                        }
                    }
                }
            }
            if (hashSet.isEmpty()) {
                return;
            } else {
                throw new a(String.format("<uses-permission android:name=\"%1$s\"/> is missing in AndroidManifest.", hashSet.iterator().next()));
            }
        }
        throw new a(String.format("<permission android:name=\"%1$s\" .../> is undefined in AndroidManifest.", str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, PackageInfo packageInfo) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(PushMessageHandler.class.getCanonicalName(), new b(PushMessageHandler.class.getCanonicalName(), true, true, ""));
        hashMap2.put(MessageHandleService.class.getCanonicalName(), new b(MessageHandleService.class.getCanonicalName(), true, false, ""));
        if (!MiPushClient.shouldUseMIUIPush(context) || a(packageInfo, new String[]{"com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"})) {
            hashMap2.put("com.xiaomi.push.service.XMJobService", new b("com.xiaomi.push.service.XMJobService", true, false, "android.permission.BIND_JOB_SERVICE"));
            hashMap2.put("com.xiaomi.push.service.XMPushService", new b("com.xiaomi.push.service.XMPushService", true, false, ""));
        }
        if (MiPushClient.getOpenFCMPush(context)) {
            hashMap2.put("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", new b("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", true, false, ""));
            hashMap2.put("com.xiaomi.assemble.control.MiFirebaseMessagingService", new b("com.xiaomi.assemble.control.MiFirebaseMessagingService", true, false, ""));
        }
        if (MiPushClient.getOpenOPPOPush(context)) {
            hashMap2.put("com.xiaomi.assemble.control.COSPushMessageService", new b("com.xiaomi.assemble.control.COSPushMessageService", true, true, "com.coloros.mcs.permission.SEND_MCS_MESSAGE"));
        }
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (!TextUtils.isEmpty(serviceInfo.name) && hashMap2.containsKey(serviceInfo.name)) {
                    b bVar = (b) hashMap2.remove(serviceInfo.name);
                    boolean z = bVar.f58a;
                    boolean z2 = bVar.f59b;
                    String str = bVar.b;
                    if (z == serviceInfo.enabled) {
                        if (z2 == serviceInfo.exported) {
                            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, serviceInfo.permission)) {
                                throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong permission attribute, which should be android:permission=\"%2$s\".", serviceInfo.name, str));
                            }
                            hashMap.put(serviceInfo.name, serviceInfo.processName);
                            if (hashMap2.isEmpty()) {
                                break;
                            }
                        } else {
                            throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", serviceInfo.name, Boolean.valueOf(z2)));
                        }
                    } else {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", serviceInfo.name, Boolean.valueOf(z)));
                    }
                }
            }
        }
        if (hashMap2.isEmpty()) {
            if (TextUtils.equals((CharSequence) hashMap.get(PushMessageHandler.class.getCanonicalName()), (CharSequence) hashMap.get(MessageHandleService.class.getCanonicalName()))) {
                if (hashMap.containsKey("com.xiaomi.push.service.XMJobService") && hashMap.containsKey("com.xiaomi.push.service.XMPushService") && !TextUtils.equals((CharSequence) hashMap.get("com.xiaomi.push.service.XMJobService"), (CharSequence) hashMap.get("com.xiaomi.push.service.XMPushService"))) {
                    throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", "com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"));
                }
                return;
            }
            throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", PushMessageHandler.class.getCanonicalName(), MessageHandleService.class.getCanonicalName()));
        }
        throw new a(String.format("<service android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", hashMap2.keySet().iterator().next()));
    }

    private static ActivityInfo a(PackageManager packageManager, Intent intent, Class<?> cls) {
        Iterator<ResolveInfo> it2 = packageManager.queryBroadcastReceivers(intent, 16384).iterator();
        while (it2.hasNext()) {
            ActivityInfo activityInfo = it2.next().activityInfo;
            if (activityInfo != null && cls.getCanonicalName().equals(activityInfo.name)) {
                return activityInfo;
            }
        }
        return null;
    }

    private static void a(Context context, String str, String str2) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(str);
        intent.setPackage(packageName);
        Iterator<ResolveInfo> it2 = packageManager.queryBroadcastReceivers(intent, 16384).iterator();
        boolean z = false;
        while (it2.hasNext()) {
            ActivityInfo activityInfo = it2.next().activityInfo;
            if (activityInfo != null && !TextUtils.isEmpty(activityInfo.name) && activityInfo.name.equals(str2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                break;
            }
        }
        if (z) {
        } else {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", str2));
        }
    }

    public static class b {
        public String a;

        /* renamed from: a, reason: collision with other field name */
        public boolean f58a;
        public String b;

        /* renamed from: b, reason: collision with other field name */
        public boolean f59b;

        static {
            Covode.recordClassIndex(655313);
        }

        public b(String str, boolean z, boolean z2, String str2) {
            this.a = str;
            this.f58a = z;
            this.f59b = z2;
            this.b = str2;
        }
    }
}
