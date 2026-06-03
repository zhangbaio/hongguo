package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.ad;
import com.xiaomi.push.at;
import com.xiaomi.push.av;
import com.xiaomi.push.az;
import com.xiaomi.push.ha;
import com.xiaomi.push.r;
import com.xiaomi.push.service.ah;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class f {
    static {
        Covode.recordClassIndex(655303);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m101a(Context context, d dVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int a = a(context, dVar, str);
        if (a != 0) {
            com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : send token upload, check:" + a);
            a(context, str);
            v m105a = g.m105a(dVar);
            if (m105a == null) {
                return;
            }
            u.a(context).a((String) null, m105a, dVar, "upload");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : do not need to send token");
    }

    public static boolean a(ha haVar, d dVar) {
        if (haVar == null || haVar.m533a() == null || haVar.m533a().m500a() == null) {
            return false;
        }
        return (dVar == d.ASSEMBLE_PUSH_FCM ? "FCM" : "").equalsIgnoreCase(haVar.m533a().m500a().get("assemble_push_type"));
    }

    public static byte[] a(Context context, ha haVar, d dVar) {
        if (a(haVar, dVar)) {
            return az.m166a(a(context, dVar));
        }
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    static void m99a(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a = a(d.ASSEMBLE_PUSH_HUAWEI);
        String a2 = a(d.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(a, "")) && TextUtils.isEmpty(sharedPreferences.getString(a2, ""))) {
            z = true;
        }
        if (z) {
            u.a(context).a(2, a);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m100a(Context context, d dVar) {
        String a = a(dVar);
        if (TextUtils.isEmpty(a)) {
            return;
        }
        com.xiaomi.push.o.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a, ""));
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m103a(Context context, d dVar) {
        if (g.m106a(dVar) != null) {
            return ah.a(context).a(g.m106a(dVar).a(), true);
        }
        return false;
    }

    public static void a(String str, int i) {
        MiTinyDataClient.upload("hms_push_error", str, 1L, "error code = " + i);
    }

    private static synchronized void a(Context context, String str) {
        synchronized (f.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString("syncingToken", str);
            edit.apply();
        }
    }

    public static void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("pushMsg")) {
            return;
        }
        intent.putExtra("key_message", a(extras.getString("pushMsg")));
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m104a(d dVar) {
        return dVar == d.ASSEMBLE_PUSH_FTOS || dVar == d.ASSEMBLE_PUSH_FCM;
    }

    public static int a() {
        Integer num = (Integer) av.a("com.xiaomi.assemble.control.AssembleConstants", "ASSEMBLE_VERSION_CODE");
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* renamed from: com.xiaomi.mipush.sdk.f$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            a = iArr;
            try {
                iArr[d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void b(Context context) {
        e.a(context).register();
    }

    public static void c(Context context) {
        e.a(context).unregister();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m102a(Context context) {
        if (context == null) {
            return false;
        }
        return at.m155a(context);
    }

    public static String b(d dVar) {
        return a(dVar) + "_version";
    }

    public static String c(d dVar) {
        int i = AnonymousClass2.a[dVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return "ftos_push_error";
                }
                return "cos_push_error";
            }
            return "fcm_push_error";
        }
        return "hms_push_error";
    }

    protected static PushMessageReceiver a(Context context) {
        ResolveInfo resolveInfo;
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                Iterator<ResolveInfo> it2 = queryBroadcastReceivers.iterator();
                while (it2.hasNext()) {
                    resolveInfo = it2.next();
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (activityInfo != null && activityInfo.packageName.equals(context.getPackageName())) {
                        break;
                    }
                }
            }
            resolveInfo = null;
            if (resolveInfo == null) {
                return null;
            }
            return (PushMessageReceiver) com.xiaomi.push.q.a(context, resolveInfo.activityInfo.name).newInstance();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            return null;
        }
    }

    public static MiPushMessage a(String str) {
        MiPushMessage miPushMessage = new MiPushMessage();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("messageId")) {
                    miPushMessage.setMessageId(jSONObject.getString("messageId"));
                }
                if (jSONObject.has("description")) {
                    miPushMessage.setDescription(jSONObject.getString("description"));
                }
                if (jSONObject.has("title")) {
                    miPushMessage.setTitle(jSONObject.getString("title"));
                }
                if (jSONObject.has("content")) {
                    miPushMessage.setContent(jSONObject.getString("content"));
                }
                if (jSONObject.has("passThrough")) {
                    miPushMessage.setPassThrough(jSONObject.getInt("passThrough"));
                }
                if (jSONObject.has("notifyType")) {
                    miPushMessage.setNotifyType(jSONObject.getInt("notifyType"));
                }
                if (jSONObject.has("messageType")) {
                    miPushMessage.setMessageType(jSONObject.getInt("messageType"));
                }
                if (jSONObject.has("alias")) {
                    miPushMessage.setAlias(jSONObject.getString("alias"));
                }
                if (jSONObject.has("topic")) {
                    miPushMessage.setTopic(jSONObject.getString("topic"));
                }
                if (jSONObject.has("user_account")) {
                    miPushMessage.setUserAccount(jSONObject.getString("user_account"));
                }
                if (jSONObject.has("notifyId")) {
                    miPushMessage.setNotifyId(jSONObject.getInt("notifyId"));
                }
                if (jSONObject.has("category")) {
                    miPushMessage.setCategory(jSONObject.getString("category"));
                }
                if (jSONObject.has("isNotified")) {
                    miPushMessage.setNotified(jSONObject.getBoolean("isNotified"));
                }
                if (jSONObject.has("extra")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("extra");
                    Iterator<String> keys = jSONObject2.keys();
                    HashMap hashMap = new HashMap();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.getString(next));
                    }
                    if (hashMap.size() > 0) {
                        miPushMessage.setExtra(hashMap);
                    }
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            }
        }
        return miPushMessage;
    }

    public static String a(d dVar) {
        int i = AnonymousClass2.a[dVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return "ftos_push_token";
                }
                return "cos_push_token";
            }
            return "fcm_push_token_v2";
        }
        return "hms_push_token";
    }

    static String a(Context context, d dVar) {
        return a(context, dVar, false);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static HashMap<String, String> m98a(Context context, d dVar) {
        int i;
        HashMap<String, String> hashMap = new HashMap<>();
        int i2 = AnonymousClass2.a[dVar.ordinal()];
        String str = null;
        ApplicationInfo applicationInfo = null;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        r.a a = new r.a(":", "~").a("brand", q.VIVO.name()).a("token", a(context, dVar, true)).a("package_name", context.getPackageName());
                        int a2 = a();
                        if (a2 != 0) {
                            a.a(Constants.VERSION, Integer.valueOf(a2));
                        }
                        str = a.toString();
                    }
                } else {
                    str = new r.a(":", "~").a("brand", q.OPPO.name()).a("token", a(context, dVar, true)).a("package_name", context.getPackageName()).toString();
                }
            } else {
                r.a a3 = new r.a(":", "~").a("brand", q.FCM.name()).a("token", a(context, dVar, false)).a("package_name", context.getPackageName());
                int a4 = a();
                if (a4 != 0) {
                    a3.a(Constants.VERSION, Integer.valueOf(a4));
                } else {
                    a3.a(Constants.VERSION, 50906);
                }
                str = a3.toString();
            }
        } else {
            try {
                applicationInfo = INVOKEVIRTUAL_com_xiaomi_mipush_sdk_f_com_dragon_read_resource_PackageManagerAop_getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            }
            if (applicationInfo != null) {
                i = applicationInfo.metaData.getInt("com.huawei.hms.client.appid");
            } else {
                i = -1;
            }
            str = new r.a(":", "~").a("brand", q.HUAWEI.name()).a("token", a(context, dVar, true)).a("package_name", context.getPackageName()).a("app_id", Integer.valueOf(i)).toString();
        }
        hashMap.put("RegInfo", str);
        return hashMap;
    }

    public static void b(final Context context, final d dVar, final String str) {
        ad.a(context).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.f.1
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                if (!TextUtils.isEmpty(str)) {
                    String[] split = str.split("~");
                    int length = split.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            String str3 = split[i];
                            if (!TextUtils.isEmpty(str3) && str3.startsWith("token:")) {
                                str2 = str3.substring(str3.indexOf(":") + 1);
                                break;
                            }
                            i++;
                        } else {
                            str2 = "";
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : receive correct token");
                        f.d(context, dVar, str2);
                        f.m99a(context);
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : receive incorrect token");
                }
            }
        });
    }

    @Proxy("getApplicationInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static ApplicationInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_f_com_dragon_read_resource_PackageManagerAop_getApplicationInfo(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, i);
            Intrinsics.checkNotNull(applicationInfo, "null cannot be cast to non-null type android.content.pm.ApplicationInfo");
            return applicationInfo;
        }
        x55.b bVar = x55.b.a;
        ApplicationInfo d = bVar.d(packageName, i);
        if (d != null) {
            return d;
        }
        ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo(packageName, i);
        Intrinsics.checkNotNull(applicationInfo2, "null cannot be cast to non-null type android.content.pm.ApplicationInfo");
        bVar.a(packageName, i, applicationInfo2);
        return applicationInfo2;
    }

    protected static synchronized String a(Context context, d dVar, boolean z) {
        synchronized (f.class) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            if (z) {
                String string = sharedPreferences.getString("syncingToken", "");
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
            }
            String a = a(dVar);
            if (!TextUtils.isEmpty(a)) {
                return sharedPreferences.getString(a, "");
            }
            return "";
        }
    }

    private static int a(Context context, d dVar, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a = a(dVar);
        String string = sharedPreferences.getString(a, "");
        String m87c = b.m79a(context).m87c();
        String string2 = sharedPreferences.getString("last_check_token", "");
        if (TextUtils.isEmpty(a)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return 0;
        }
        if (TextUtils.isEmpty(string)) {
            return 1;
        }
        if (!string.equals(str)) {
            return 2;
        }
        if (!TextUtils.equals(m87c, string2)) {
            return 3;
        }
        if (m104a(dVar)) {
            if (a() != sharedPreferences.getInt(b(dVar), 0)) {
                return 4;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void d(Context context, d dVar, String str) {
        synchronized (f.class) {
            String a = a(dVar);
            if (TextUtils.isEmpty(a)) {
                com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(a, str).putString("last_check_token", b.m79a(context).m87c());
            if (m104a(dVar)) {
                edit.putInt(b(dVar), a());
            }
            edit.putString("syncingToken", "");
            com.xiaomi.push.o.a(edit);
            com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : update sp file success!  " + str);
        }
    }
}
