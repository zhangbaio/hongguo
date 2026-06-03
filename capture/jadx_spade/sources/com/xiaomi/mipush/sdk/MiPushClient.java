package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.agent.instrumentation.ThreadMonitor;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.DebugManager;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.ad;
import com.xiaomi.push.am;
import com.xiaomi.push.at;
import com.xiaomi.push.ba;
import com.xiaomi.push.cw;
import com.xiaomi.push.df;
import com.xiaomi.push.dg;
import com.xiaomi.push.dp;
import com.xiaomi.push.dq;
import com.xiaomi.push.dr;
import com.xiaomi.push.ec;
import com.xiaomi.push.ge;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.go;
import com.xiaomi.push.gr;
import com.xiaomi.push.gs;
import com.xiaomi.push.gy;
import com.xiaomi.push.hd;
import com.xiaomi.push.he;
import com.xiaomi.push.hi;
import com.xiaomi.push.hk;
import com.xiaomi.push.hm;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class MiPushClient {
    private static Context sContext;
    private static long sCurMsgId;

    public interface ICallbackResult<R> {
        void onResult(R r);
    }

    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    public static void syncAssembleCOSPushToken(Context context) {
    }

    public static void syncAssembleFTOSPushToken(Context context) {
    }

    public static void syncAssemblePushToken(Context context) {
    }

    public static class CodeResult {
        private long resultCode = -1;

        static {
            Covode.recordClassIndex(655270);
        }

        public long getResultCode() {
            return this.resultCode;
        }

        protected void setResultCode(long j) {
            this.resultCode = j;
        }
    }

    public static abstract class MiPushClientCallback {
        private String category;

        static {
            Covode.recordClassIndex(655272);
        }

        public void onCommandResult(String str, long j, String str2, List<String> list) {
        }

        public void onInitializeResult(long j, String str, String str2) {
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        }

        public void onSubscribeResult(long j, String str, String str2) {
        }

        public void onUnsubscribeResult(long j, String str, String str2) {
        }

        protected String getCategory() {
            return this.category;
        }

        protected void setCategory(String str) {
            this.category = str;
        }
    }

    public static class TokenResult {
        private String token = null;
        private long resultCode = -1;

        static {
            Covode.recordClassIndex(655273);
        }

        public long getResultCode() {
            return this.resultCode;
        }

        public String getToken() {
            return this.token;
        }

        protected void setResultCode(long j) {
            this.resultCode = j;
        }

        protected void setToken(String str) {
            this.token = str;
        }
    }

    private static boolean getDefaultSwitch() {
        return com.xiaomi.push.j.m634b();
    }

    static {
        Covode.recordClassIndex(655269);
        sCurMsgId = System.currentTimeMillis();
    }

    private static void updateImeiOrOaid() {
        new Thread(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.3
            @Override // java.lang.Runnable
            public void run() {
                if (!com.xiaomi.push.j.m636d()) {
                    if (com.xiaomi.push.i.c(MiPushClient.sContext) != null || am.a(MiPushClient.sContext).mo141a()) {
                        hd hdVar = new hd();
                        hdVar.b(b.m79a(MiPushClient.sContext).m80a());
                        hdVar.c(go.ClientInfoUpdate.f529a);
                        hdVar.a(aj.a());
                        hdVar.a(new HashMap());
                        String c = com.xiaomi.push.i.c(MiPushClient.sContext);
                        String str = "";
                        if (!TextUtils.isEmpty(c)) {
                            str = "" + ba.a(c);
                        }
                        String e = com.xiaomi.push.i.e(MiPushClient.sContext);
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(e)) {
                            str = str + "," + e;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            hdVar.m549a().put("imei_md5", str);
                        }
                        am.a(MiPushClient.sContext).a(hdVar.m549a());
                        int a = com.xiaomi.push.i.a();
                        if (a >= 0) {
                            hdVar.m549a().put("space_id", Integer.toString(a));
                        }
                        u.a(MiPushClient.sContext).a((u) hdVar, ge.Notification, false, (gr) null);
                    }
                }
            }
        }).start();
    }

    private static void scheduleOcVersionCheckJob() {
        ad.a(sContext).a(new o(sContext), ah.a(sContext).a(gj.OcVersionCheckFrequency.a(), 86400), 5);
    }

    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    public static void clearLocalNotificationType(Context context) {
        u.a(context).f();
    }

    public static void removeWindow(Context context) {
        u.a(context).m130e();
    }

    public static void clearNotification(Context context) {
        u.a(context).a(-1);
    }

    public static void disablePush(Context context) {
        u.a(context).a(true);
    }

    public static void enablePush(Context context) {
        u.a(context).a(false);
    }

    protected static String getAcceptTime(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString("accept_time", "00:00-23:59");
    }

    protected static boolean getOpenFCMPush(Context context) {
        checkNotNull(context, "context");
        return e.a(context).b(d.ASSEMBLE_PUSH_FCM);
    }

    protected static boolean getOpenHmsPush(Context context) {
        checkNotNull(context, "context");
        return e.a(context).b(d.ASSEMBLE_PUSH_HUAWEI);
    }

    protected static boolean getOpenOPPOPush(Context context) {
        checkNotNull(context, "context");
        return e.a(context).b(d.ASSEMBLE_PUSH_COS);
    }

    protected static boolean getOpenVIVOPush(Context context) {
        return e.a(context).b(d.ASSEMBLE_PUSH_FTOS);
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return u.a(context).m124a();
    }

    public static void syncAssembleFCMPushToken(Context context) {
        u.a(context).a((String) null, v.UPLOAD_FCM_TOKEN, d.ASSEMBLE_PUSH_FCM, "");
    }

    private static void addPullNotificationTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", System.currentTimeMillis());
        com.xiaomi.push.o.a(edit);
    }

    private static void addRegRequestTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        com.xiaomi.push.o.a(edit);
    }

    protected static void clearExtras(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    public static String getAppRegion(Context context) {
        if (b.m79a(context).m88c()) {
            return b.m79a(context).f();
        }
        return null;
    }

    public static String getRegId(Context context) {
        if (b.m79a(context).m88c()) {
            return b.m79a(context).m87c();
        }
        return null;
    }

    static synchronized void removeAcceptTime(Context context) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("accept_time");
            com.xiaomi.push.o.a(edit);
        }
    }

    static synchronized void removeAllAccounts(Context context) {
        synchronized (MiPushClient.class) {
            Iterator<String> it2 = getAllUserAccount(context).iterator();
            while (it2.hasNext()) {
                removeAccount(context, it2.next());
            }
        }
    }

    static synchronized void removeAllAliases(Context context) {
        synchronized (MiPushClient.class) {
            Iterator<String> it2 = getAllAlias(context).iterator();
            while (it2.hasNext()) {
                removeAlias(context, it2.next());
            }
        }
    }

    static synchronized void removeAllTopics(Context context) {
        synchronized (MiPushClient.class) {
            Iterator<String> it2 = getAllTopic(context).iterator();
            while (it2.hasNext()) {
                removeTopic(context, it2.next());
            }
        }
    }

    private static boolean shouldSendRegRequest(Context context) {
        if (Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) <= 5000) {
            return false;
        }
        return true;
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring(8));
            }
        }
        return arrayList;
    }

    private static void initEventPerfLogic(final Context context) {
        dr.a(new dr.a() { // from class: com.xiaomi.mipush.sdk.MiPushClient.5
            @Override // com.xiaomi.push.dr.a
            public void uploader(Context context2, gi giVar) {
                MiTinyDataClient.upload(context2, giVar);
            }
        });
        Config a = dr.a(context);
        com.xiaomi.clientreport.manager.a.a(context).a(BuildConfig.VERSION_NAME);
        ClientReportClient.init(context, a, new dp(context), new dq(context));
        a.a(context);
        k.a(context, a);
        ah.a(context).a(new ah.a(100, "perf event job update") { // from class: com.xiaomi.mipush.sdk.MiPushClient.6
            @Override // com.xiaomi.push.service.ah.a
            protected void onCallback() {
                dr.m362a(context);
            }
        });
    }

    private static void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            com.xiaomi.push.l.a(context.getApplicationContext(), new NetworkStatusReceiver(null), intentFilter, 2);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m54a("dynamic register network status receiver failed:" + th);
        }
        at.m150a(sContext);
    }

    private static void scheduleDataCollectionJobs(Context context) {
        if (ah.a(sContext).a(gj.DataCollectionSwitch.a(), getDefaultSwitch())) {
            df.a().a(new i(context));
            ad.a(sContext).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.2
                @Override // java.lang.Runnable
                public void run() {
                    dg.a(MiPushClient.sContext);
                }
            }, 10);
        }
    }

    private static boolean shouldPullNotification(Context context) {
        if (Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) <= 300000) {
            return false;
        }
        return true;
    }

    public static void unregisterPush(Context context) {
        f.c(context);
        ah.a(context).a();
        if (!b.m79a(context).m86b()) {
            return;
        }
        hk hkVar = new hk();
        hkVar.a(aj.a());
        hkVar.b(b.m79a(context).m80a());
        hkVar.c(b.m79a(context).m87c());
        hkVar.e(b.m79a(context).b());
        hkVar.d(context.getPackageName());
        u.a(context).a(hkVar);
        PushMessageHandler.a();
        PushMessageHandler.b();
        b.m79a(context).m85b();
        clearLocalNotificationType(context);
        clearNotification(context);
        clearExtras(context);
    }

    private static void clearExtrasForInitialize(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        Iterator<String> it2 = getAllAlias(context).iterator();
        while (it2.hasNext()) {
            edit.remove("alias_" + it2.next());
        }
        Iterator<String> it4 = getAllUserAccount(context).iterator();
        while (it4.hasNext()) {
            edit.remove("account_" + it4.next());
        }
        Iterator<String> it5 = getAllTopic(context).iterator();
        while (it5.hasNext()) {
            edit.remove("topic_" + it5.next());
        }
        edit.remove("accept_time");
        edit.commit();
    }

    private static void operateSyncAction(Context context) {
        if ("syncing".equals(p.a(sContext).a(v.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(p.a(sContext).a(v.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        p a = p.a(sContext);
        v vVar = v.UPLOAD_HUAWEI_TOKEN;
        if ("syncing".equals(a.a(vVar))) {
            u.a(sContext).a((String) null, vVar, d.ASSEMBLE_PUSH_HUAWEI, "init");
        }
        if ("syncing".equals(p.a(sContext).a(v.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        p a2 = p.a(sContext);
        v vVar2 = v.UPLOAD_COS_TOKEN;
        if ("syncing".equals(a2.a(vVar2))) {
            u.a(sContext).a((String) null, vVar2, d.ASSEMBLE_PUSH_COS, "init");
        }
        p a3 = p.a(sContext);
        v vVar3 = v.UPLOAD_FTOS_TOKEN;
        if ("syncing".equals(a3.a(vVar3))) {
            u.a(context).a((String) null, vVar3, d.ASSEMBLE_PUSH_FTOS, "init");
        }
    }

    public static void clearNotification(Context context, int i) {
        u.a(context).a(i);
    }

    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    public static void awakeApps(final Context context, final String[] strArr) {
        ad.a(context).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.4
            @Override // java.lang.Runnable
            public void run() {
                PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiPushClient$4_com_dragon_read_resource_PackageManagerAop_getPackageInfo;
                try {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str) && (INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiPushClient$4_com_dragon_read_resource_PackageManagerAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiPushClient$4_com_dragon_read_resource_PackageManagerAop_getPackageInfo(context.getPackageManager(), str, 4)) != null) {
                            MiPushClient.awakePushServiceByPackageInfo(context, INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiPushClient$4_com_dragon_read_resource_PackageManagerAop_getPackageInfo);
                        }
                    }
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.a(th);
                }
            }

            @Proxy("getPackageInfo")
            @TargetClass("android.content.pm.PackageManager")
            public static PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiPushClient$4_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i) {
                Intrinsics.checkNotNullParameter(packageName, "packageName");
                if (x55.a.a()) {
                    PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiPushClient$4_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiPushClient$4_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
                    Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiPushClient$4_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
                    return INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiPushClient$4_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
                }
                x55.b bVar = x55.b.a;
                PackageInfo f = bVar.f(packageName, i);
                if (f != null) {
                    return f;
                }
                PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiPushClient$4_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiPushClient$4_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
                Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiPushClient$4_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
                bVar.c(packageName, i, INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiPushClient$4_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
                return INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiPushClient$4_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
            }

            @Proxy("getPackageInfo")
            @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
            public static PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiPushClient$4_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i) {
                if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
                    return null;
                }
                if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
                    LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + Log.getStackTraceString(new Exception()), new Object[0]);
                }
                return packageManager.getPackageInfo(str, i);
            }
        });
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    public static void setLocalNotificationType(Context context, int i) {
        u.a(context).b(i & (-1));
    }

    public static long accountSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("account_" + str, -1L);
    }

    public static long aliasSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("alias_" + str, -1L);
    }

    private static void checkNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalArgumentException("param " + str + " is not nullable");
    }

    public static long topicSubscribedTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("topic_" + str, -1L);
    }

    public static void turnOffPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        disablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void turnOnPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        enablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        unregisterPush(context);
        if (uPSUnRegisterCallBack != null) {
            TokenResult tokenResult = new TokenResult();
            tokenResult.setToken(null);
            tokenResult.getToken();
            tokenResult.setResultCode(0L);
            tokenResult.getResultCode();
            uPSUnRegisterCallBack.onResult(tokenResult);
        }
    }

    static synchronized void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    static synchronized void addAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    static synchronized void addTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    static synchronized void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("account_" + str).commit();
        }
    }

    static synchronized void removeAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("alias_" + str).commit();
        }
    }

    static synchronized void removeTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("topic_" + str).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void awakePushServiceByPackageInfo(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        ThreadMonitor.sleepMonitor(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                        intent.putExtra("waker_pkgname", context.getPackageName());
                        PushMessageHandler.a(context, intent);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
        }
    }

    public static void reportAppRunInBackground(Context context, boolean z) {
        go goVar;
        if (!b.m79a(context).m86b()) {
            return;
        }
        if (z) {
            goVar = go.APP_SLEEP;
        } else {
            goVar = go.APP_WAKEUP;
        }
        hd hdVar = new hd();
        hdVar.b(b.m79a(context).m80a());
        hdVar.c(goVar.f529a);
        hdVar.d(context.getPackageName());
        hdVar.a(aj.a());
        hdVar.a(false);
        u.a(context).a((u) hdVar, ge.Notification, false, (gr) null, false);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        gr grVar = new gr();
        grVar.a(miPushMessage.getMessageId());
        grVar.b(miPushMessage.getTopic());
        grVar.d(miPushMessage.getDescription());
        grVar.c(miPushMessage.getTitle());
        grVar.c(miPushMessage.getNotifyId());
        grVar.a(miPushMessage.getNotifyType());
        grVar.b(miPushMessage.getPassThrough());
        grVar.a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), grVar, null);
    }

    static void reInitialize(Context context, gs gsVar) {
        com.xiaomi.channel.commonutils.logger.b.e("re-register reason: " + gsVar);
        String a = ba.a(6);
        String m80a = b.m79a(context).m80a();
        String b = b.m79a(context).b();
        b.m79a(context).m81a();
        clearExtrasForInitialize(context);
        clearNotification(context);
        b.m79a(context).a(Constants.a());
        b.m79a(context).a(m80a, b, a);
        he heVar = new he();
        heVar.a(aj.b());
        heVar.b(m80a);
        heVar.e(b);
        heVar.f(a);
        heVar.d(context.getPackageName());
        heVar.c(com.xiaomi.push.g.m456a(context, context.getPackageName()));
        heVar.b(com.xiaomi.push.g.a(context, context.getPackageName()));
        heVar.h(BuildConfig.VERSION_NAME);
        heVar.a(50906);
        heVar.a(gsVar);
        int a2 = com.xiaomi.push.i.a();
        if (a2 >= 0) {
            heVar.c(a2);
        }
        u.a(context).a(heVar, false);
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, ec.COMMAND_UNSET_ALIAS.f356a, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, ec.COMMAND_UNSET_ACCOUNT.f356a, str, str2);
    }

    public static void registerPush(Context context, String str, String str2) {
        registerPush(context, str, str2, new PushConfiguration());
    }

    public static void setAlias(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, ec.COMMAND_SET_ALIAS.f356a, str, str2);
        }
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, ec.COMMAND_SET_ACCOUNT.f356a, str, str2);
        }
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        return TextUtils.equals(getAcceptTime(context), str + "," + str2);
    }

    public static void clearNotification(Context context, String str, String str2) {
        u.a(context).a(str, str2);
    }

    static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString("accept_time", str + "," + str2);
            com.xiaomi.push.o.a(edit);
        }
    }

    public static void subscribe(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(b.m79a(context).m80a()) && !TextUtils.isEmpty(str)) {
            if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) > 86400000) {
                hi hiVar = new hi();
                String a = aj.a();
                hiVar.a(a);
                hiVar.b(b.m79a(context).m80a());
                hiVar.c(str);
                hiVar.d(context.getPackageName());
                hiVar.e(str2);
                com.xiaomi.channel.commonutils.logger.b.e("cmd:" + ec.COMMAND_SUBSCRIBE_TOPIC + ", " + a);
                u.a(context).a((u) hiVar, ge.Subscription, (gr) null);
                return;
            }
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ec.COMMAND_SUBSCRIBE_TOPIC.f356a, arrayList, 0L, null, null, null));
        }
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (!b.m79a(context).m86b()) {
            return;
        }
        if (topicSubscribedTime(context, str) < 0) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Don't cancel subscribe for " + ba.a(str, 3) + " is unsubscribed");
            return;
        }
        hm hmVar = new hm();
        String a = aj.a();
        hmVar.a(a);
        hmVar.b(b.m79a(context).m80a());
        hmVar.c(str);
        hmVar.d(context.getPackageName());
        hmVar.e(str2);
        com.xiaomi.channel.commonutils.logger.b.e("cmd:" + ec.COMMAND_UNSUBSCRIBE_TOPIC + ", " + a);
        u.a(context).a((u) hmVar, ge.UnSubscription, (gr) null);
    }

    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        initialize(context, str, str2, miPushClientCallback, null, null);
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration) {
        registerPush(context, str, str2, pushConfiguration, null, null);
    }

    static void reportMessageClicked(Context context, String str, gr grVar, String str2) {
        hd hdVar = new hd();
        if (TextUtils.isEmpty(str2)) {
            if (b.m79a(context).m86b()) {
                hdVar.b(b.m79a(context).m80a());
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
                return;
            }
        } else {
            hdVar.b(str2);
        }
        hdVar.c("bar:click");
        hdVar.a(str);
        hdVar.a(false);
        u.a(context).a((u) hdVar, ge.Notification, false, grVar);
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        registerPush(context, str, str2, new PushConfiguration(), str3, null);
    }

    protected static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (TextUtils.isEmpty(b.m79a(context).m80a())) {
            return;
        }
        gy gyVar = new gy();
        String a = aj.a();
        gyVar.a(a);
        gyVar.b(b.m79a(context).m80a());
        gyVar.c(str);
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            gyVar.m524a(it2.next());
        }
        gyVar.e(str2);
        gyVar.d(context.getPackageName());
        com.xiaomi.channel.commonutils.logger.b.e("cmd:" + str + ", " + a);
        u.a(context).a((u) gyVar, ge.Command, (gr) null);
    }

    protected static void setCommand(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        ec ecVar = ec.COMMAND_SET_ALIAS;
        if (ecVar.f356a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) < 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
                return;
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ecVar.f356a, arrayList, 0L, null, str3, null));
                return;
            }
        }
        if (ec.COMMAND_UNSET_ALIAS.f356a.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Don't cancel alias for " + ba.a(arrayList.toString(), 3) + " is unseted");
            return;
        }
        ec ecVar2 = ec.COMMAND_SET_ACCOUNT;
        if (ecVar2.f356a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) < 3600000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
                return;
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ecVar2.f356a, arrayList, 0L, null, str3, null));
                return;
            }
        }
        if (ec.COMMAND_UNSET_ACCOUNT.f356a.equalsIgnoreCase(str) && accountSetTime(context, str2) < 0) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Don't cancel account for " + ba.a(arrayList.toString(), 3) + " is unseted");
            return;
        }
        setCommand(context, str, (ArrayList<String>) arrayList, str3);
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        registerPush(context, str, str2, new PushConfiguration(), null, uPSRegisterCallBack);
    }

    static void reportIgnoreRegMessageClicked(Context context, String str, gr grVar, String str2, String str3) {
        hd hdVar = new hd();
        if (TextUtils.isEmpty(str3)) {
            com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
            return;
        }
        hdVar.b(str3);
        hdVar.c("bar:click");
        hdVar.a(str);
        hdVar.a(false);
        u.a(context).a(hdVar, ge.Notification, false, true, grVar, true, str2, str3);
    }

    private static void registerPush(Context context, final String str, final String str2, PushConfiguration pushConfiguration, final String str3, final ICallbackResult iCallbackResult) {
        checkNotNull(context, "context");
        checkNotNull(str, "appID");
        checkNotNull(str2, "appToken");
        Context applicationContext = context.getApplicationContext();
        sContext = applicationContext;
        if (applicationContext == null) {
            sContext = context;
        }
        Context context2 = sContext;
        com.xiaomi.push.q.a(context2);
        if (!NetworkStatusReceiver.a()) {
            registerNetworkReceiver(sContext);
        }
        e.a(sContext).a(pushConfiguration);
        ad.a(context2).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.1
            @Override // java.lang.Runnable
            public void run() {
                MiPushClient.initialize(MiPushClient.sContext, str, str2, null, str3, iCallbackResult);
            }
        });
    }

    public static void setAcceptTime(Context context, int i, int i2, int i3, int i4, String str) {
        if (i >= 0 && i < 24 && i3 >= 0 && i3 < 24 && i2 >= 0 && i2 < 60 && i4 >= 0 && i4 < 60) {
            long rawOffset = ((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60;
            long j = ((((i * 60) + i2) + rawOffset) + 1440) % 1440;
            long j2 = ((((i3 * 60) + i4) + rawOffset) + 1440) % 1440;
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
            arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i), Integer.valueOf(i2)));
            arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i3), Integer.valueOf(i4)));
            if (acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
                if (1 == PushMessageHelper.getPushMode(context)) {
                    PushMessageHandler.a(context, str, ec.COMMAND_SET_ACCEPT_TIME.f356a, 0L, null, arrayList2);
                    return;
                } else {
                    PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ec.COMMAND_SET_ACCEPT_TIME.f356a, arrayList2, 0L, null, null, null));
                    return;
                }
            }
            setCommand(context, ec.COMMAND_SET_ACCEPT_TIME.f356a, (ArrayList<String>) arrayList, str);
            return;
        }
        throw new IllegalArgumentException("the input parameter is not valid.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback, String str3, ICallbackResult iCallbackResult) {
        boolean z;
        try {
            com.xiaomi.channel.commonutils.logger.b.a(context.getApplicationContext());
            com.xiaomi.channel.commonutils.logger.b.e("sdk_version = 5_9_6-C");
            am.a(context).a();
            cw.a(context);
            if (miPushClientCallback != null) {
                PushMessageHandler.a(miPushClientCallback);
            }
            if (iCallbackResult != null) {
                PushMessageHandler.a(iCallbackResult);
            }
            if (com.xiaomi.push.q.m643a(sContext)) {
                m.a(sContext);
            }
            if (b.m79a(sContext).a() != Constants.a()) {
                z = true;
            } else {
                z = false;
            }
            if (!z && !shouldSendRegRequest(sContext)) {
                u.a(sContext).m121a();
                com.xiaomi.channel.commonutils.logger.b.m54a("Could not send  register message within 5s repeatly .");
                return;
            }
            if (!z && b.m79a(sContext).a(str, str2) && !b.m79a(sContext).m91f()) {
                if (1 == PushMessageHelper.getPushMode(sContext)) {
                    checkNotNull(miPushClientCallback, "callback");
                    miPushClientCallback.onInitializeResult(0L, null, b.m79a(sContext).m87c());
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(b.m79a(sContext).m87c());
                    PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(ec.COMMAND_REGISTER.f356a, arrayList, 0L, null, null, null));
                }
                u.a(sContext).m121a();
                if (b.m79a(sContext).m83a()) {
                    hd hdVar = new hd();
                    hdVar.b(b.m79a(sContext).m80a());
                    hdVar.c(go.ClientInfoUpdate.f529a);
                    hdVar.a(aj.a());
                    HashMap hashMap = new HashMap();
                    hdVar.f668a = hashMap;
                    Context context2 = sContext;
                    hashMap.put("app_version", com.xiaomi.push.g.m456a(context2, context2.getPackageName()));
                    Map<String, String> map = hdVar.f668a;
                    Context context3 = sContext;
                    map.put("app_version_code", Integer.toString(com.xiaomi.push.g.a(context3, context3.getPackageName())));
                    hdVar.f668a.put("push_sdk_vn", BuildConfig.VERSION_NAME);
                    hdVar.f668a.put("push_sdk_vc", Integer.toString(50906));
                    String e = b.m79a(sContext).e();
                    if (!TextUtils.isEmpty(e)) {
                        hdVar.f668a.put("deviceid", e);
                    }
                    u.a(sContext).a((u) hdVar, ge.Notification, false, (gr) null);
                    u.a(sContext).m122a(sContext);
                }
                if (!com.xiaomi.push.k.m638a(sContext, "update_devId", false)) {
                    updateImeiOrOaid();
                    com.xiaomi.push.k.a(sContext, "update_devId", true);
                }
                if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                    hd hdVar2 = new hd();
                    hdVar2.b(b.m79a(sContext).m80a());
                    hdVar2.c(go.PullOfflineMessage.f529a);
                    hdVar2.a(aj.a());
                    hdVar2.a(false);
                    u.a(sContext).a((u) hdVar2, ge.Notification, false, (gr) null, false);
                    addPullNotificationTime(sContext);
                }
            } else {
                String a = ba.a(6);
                b.m79a(sContext).m81a();
                b.m79a(sContext).a(Constants.a());
                b.m79a(sContext).a(str, str2, a);
                MiTinyDataClient.a.a().b("com.xiaomi.xmpushsdk.tinydataPending.appId");
                clearExtras(sContext);
                clearNotification(context);
                he heVar = new he();
                heVar.a(aj.b());
                heVar.b(str);
                heVar.e(str2);
                heVar.d(sContext.getPackageName());
                heVar.f(a);
                Context context4 = sContext;
                heVar.c(com.xiaomi.push.g.m456a(context4, context4.getPackageName()));
                Context context5 = sContext;
                heVar.b(com.xiaomi.push.g.a(context5, context5.getPackageName()));
                heVar.h(BuildConfig.VERSION_NAME);
                heVar.a(50906);
                heVar.a(gs.Init);
                if (!TextUtils.isEmpty(str3)) {
                    heVar.g(str3);
                }
                if (!com.xiaomi.push.j.m636d()) {
                    String d = com.xiaomi.push.i.d(sContext);
                    if (!TextUtils.isEmpty(d)) {
                        heVar.i(ba.a(d) + "," + com.xiaomi.push.i.f(sContext));
                    }
                }
                int a2 = com.xiaomi.push.i.a();
                if (a2 >= 0) {
                    heVar.c(a2);
                }
                u.a(sContext).a(heVar, z);
                sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
            }
            addRegRequestTime(sContext);
            scheduleOcVersionCheckJob();
            scheduleDataCollectionJobs(sContext);
            initEventPerfLogic(sContext);
            w.a(sContext);
            if (!sContext.getPackageName().equals("com.xiaomi.xmsf")) {
                if (Logger.getUserLogger() != null) {
                    Logger.setLogger(sContext, Logger.getUserLogger());
                }
                com.xiaomi.channel.commonutils.logger.b.a(2);
            }
            operateSyncAction(context);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }
}
