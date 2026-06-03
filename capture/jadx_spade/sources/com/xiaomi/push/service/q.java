package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.DebugManager;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class q {
    private static p a;

    /* renamed from: a, reason: collision with other field name */
    private static a f1003a;

    public interface a {
        void a();
    }

    static {
        Covode.recordClassIndex(655732);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m748a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public static void a() {
        a aVar = f1003a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public static void a(a aVar) {
        f1003a = aVar;
    }

    private static int a(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m746a(Context context) {
        p m745a = m745a(context);
        if (m745a != null && !TextUtils.isEmpty(m745a.f1002a)) {
            String[] split = m745a.f1002a.split("@");
            if (split.length > 0) {
                return split[0];
            }
        }
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m747a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        a = null;
        a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized p m745a(Context context) {
        synchronized (q.class) {
            p pVar = a;
            if (pVar != null) {
                return pVar;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
            String string = sharedPreferences.getString("uuid", null);
            String string2 = sharedPreferences.getString("token", null);
            String string3 = sharedPreferences.getString("security", null);
            String string4 = sharedPreferences.getString("app_id", null);
            String string5 = sharedPreferences.getString("app_token", null);
            String string6 = sharedPreferences.getString("package_name", null);
            String string7 = sharedPreferences.getString("device_id", null);
            int i = sharedPreferences.getInt("env_type", 1);
            if (!TextUtils.isEmpty(string7) && com.xiaomi.push.i.a(string7)) {
                string7 = com.xiaomi.push.i.g(context);
                sharedPreferences.edit().putString("device_id", string7).commit();
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                return null;
            }
            String g = com.xiaomi.push.i.g(context);
            if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(g) && !TextUtils.isEmpty(string7) && !string7.equals(g)) {
                com.xiaomi.channel.commonutils.logger.b.m54a("read_phone_state permission changes.");
            }
            p pVar2 = new p(string, string2, string3, string4, string5, string6, i);
            a = pVar2;
            return pVar2;
        }
    }

    private static String a(Context context, boolean z) {
        String str;
        String a2 = b.a(context).a();
        if (z) {
            str = "/pass/v2/register/encrypt";
        } else {
            str = "/pass/v2/register";
        }
        if (com.xiaomi.push.w.b()) {
            return "http://10.38.162.35:9085" + str;
        }
        if (com.xiaomi.push.m.China.name().equals(a2)) {
            return "https://cn.register.xmpush.xiaomi.com" + str;
        }
        return null;
    }

    private static void a(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putInt("enc_req_fail_count", i);
        edit.commit();
    }

    public static void a(Context context, p pVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", pVar.f1002a);
        edit.putString("security", pVar.c);
        edit.putString("token", pVar.b);
        edit.putString("app_id", pVar.d);
        edit.putString("package_name", pVar.f);
        edit.putString("app_token", pVar.e);
        edit.putString("device_id", com.xiaomi.push.i.g(context));
        edit.putInt("env_type", pVar.a);
        edit.commit();
        a();
    }

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_service_q_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            PackageInfo INVOKEVIRTUAL_com_xiaomi_push_service_q_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_push_service_q_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
            Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_service_q_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return INVOKEVIRTUAL_com_xiaomi_push_service_q_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
        }
        x55.b bVar = x55.b.a;
        PackageInfo f = bVar.f(packageName, i);
        if (f != null) {
            return f;
        }
        PackageInfo INVOKEVIRTUAL_com_xiaomi_push_service_q_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_xiaomi_push_service_q_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
        Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_service_q_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i, INVOKEVIRTUAL_com_xiaomi_push_service_q_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
        return INVOKEVIRTUAL_com_xiaomi_push_service_q_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
    }

    @Proxy("getPackageInfo")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_service_q_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i) {
        if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
            return null;
        }
        if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
            LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + Log.getStackTraceString(new Exception()), new Object[0]);
        }
        return packageManager.getPackageInfo(str, i);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:3|4|(2:8|(24:10|11|(1:13)(1:118)|14|(1:16)(1:117)|17|(1:19)(1:116)|20|21|22|23|(1:25)(1:112)|26|(6:28|(1:30)|31|(1:35)|36|(1:38))|39|(1:41)|42|(6:45|46|47|49|50|43)|54|55|(3:60|61|(2:63|64)(9:(1:67)|68|69|(2:73|(4:75|76|77|(7:79|(1:81)|82|83|84|85|86)(6:88|89|(1:93)|94|95|96)))|106|(2:91|93)|94|95|96))|111|61|(0)(0)))|119|11|(0)(0)|14|(0)(0)|17|(0)(0)|20|21|22|23|(0)(0)|26|(0)|39|(0)|42|(1:43)|54|55|(4:57|60|61|(0)(0))|111|61|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0084, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0085, code lost:
    
        com.xiaomi.channel.commonutils.logger.b.a(r0);
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008d A[Catch: all -> 0x032a, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:11:0x0044, B:14:0x0057, B:17:0x0063, B:20:0x006f, B:22:0x0079, B:25:0x008d, B:26:0x0096, B:28:0x00be, B:30:0x00ca, B:31:0x00dd, B:33:0x00e7, B:35:0x00ed, B:36:0x0101, B:38:0x0107, B:39:0x010c, B:41:0x012f, B:42:0x0138, B:43:0x016f, B:45:0x0175, B:47:0x017c, B:52:0x018b, B:55:0x01bc, B:57:0x01dc, B:60:0x01e3, B:61:0x01fa, B:69:0x0209, B:71:0x0227, B:73:0x022d, B:101:0x02e4, B:91:0x0315, B:93:0x031b, B:94:0x0323, B:99:0x02fc, B:110:0x0210, B:115:0x0085), top: B:3:0x0005, inners: #2, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00be A[Catch: all -> 0x032a, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:11:0x0044, B:14:0x0057, B:17:0x0063, B:20:0x006f, B:22:0x0079, B:25:0x008d, B:26:0x0096, B:28:0x00be, B:30:0x00ca, B:31:0x00dd, B:33:0x00e7, B:35:0x00ed, B:36:0x0101, B:38:0x0107, B:39:0x010c, B:41:0x012f, B:42:0x0138, B:43:0x016f, B:45:0x0175, B:47:0x017c, B:52:0x018b, B:55:0x01bc, B:57:0x01dc, B:60:0x01e3, B:61:0x01fa, B:69:0x0209, B:71:0x0227, B:73:0x022d, B:101:0x02e4, B:91:0x0315, B:93:0x031b, B:94:0x0323, B:99:0x02fc, B:110:0x0210, B:115:0x0085), top: B:3:0x0005, inners: #2, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x012f A[Catch: all -> 0x032a, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:11:0x0044, B:14:0x0057, B:17:0x0063, B:20:0x006f, B:22:0x0079, B:25:0x008d, B:26:0x0096, B:28:0x00be, B:30:0x00ca, B:31:0x00dd, B:33:0x00e7, B:35:0x00ed, B:36:0x0101, B:38:0x0107, B:39:0x010c, B:41:0x012f, B:42:0x0138, B:43:0x016f, B:45:0x0175, B:47:0x017c, B:52:0x018b, B:55:0x01bc, B:57:0x01dc, B:60:0x01e3, B:61:0x01fa, B:69:0x0209, B:71:0x0227, B:73:0x022d, B:101:0x02e4, B:91:0x0315, B:93:0x031b, B:94:0x0323, B:99:0x02fc, B:110:0x0210, B:115:0x0085), top: B:3:0x0005, inners: #2, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0175 A[Catch: all -> 0x032a, TRY_LEAVE, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:11:0x0044, B:14:0x0057, B:17:0x0063, B:20:0x006f, B:22:0x0079, B:25:0x008d, B:26:0x0096, B:28:0x00be, B:30:0x00ca, B:31:0x00dd, B:33:0x00e7, B:35:0x00ed, B:36:0x0101, B:38:0x0107, B:39:0x010c, B:41:0x012f, B:42:0x0138, B:43:0x016f, B:45:0x0175, B:47:0x017c, B:52:0x018b, B:55:0x01bc, B:57:0x01dc, B:60:0x01e3, B:61:0x01fa, B:69:0x0209, B:71:0x0227, B:73:0x022d, B:101:0x02e4, B:91:0x0315, B:93:0x031b, B:94:0x0323, B:99:0x02fc, B:110:0x0210, B:115:0x0085), top: B:3:0x0005, inners: #2, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0204 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0315 A[Catch: all -> 0x032a, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:11:0x0044, B:14:0x0057, B:17:0x0063, B:20:0x006f, B:22:0x0079, B:25:0x008d, B:26:0x0096, B:28:0x00be, B:30:0x00ca, B:31:0x00dd, B:33:0x00e7, B:35:0x00ed, B:36:0x0101, B:38:0x0107, B:39:0x010c, B:41:0x012f, B:42:0x0138, B:43:0x016f, B:45:0x0175, B:47:0x017c, B:52:0x018b, B:55:0x01bc, B:57:0x01dc, B:60:0x01e3, B:61:0x01fa, B:69:0x0209, B:71:0x0227, B:73:0x022d, B:101:0x02e4, B:91:0x0315, B:93:0x031b, B:94:0x0323, B:99:0x02fc, B:110:0x0210, B:115:0x0085), top: B:3:0x0005, inners: #2, #4, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized com.xiaomi.push.service.p a(android.content.Context r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 813
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.q.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):com.xiaomi.push.service.p");
    }
}
