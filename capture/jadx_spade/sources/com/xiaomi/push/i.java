package com.xiaomi.push;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.DebugManager;
import com.ss.ttm.player.MediaPlayer;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class i {
    private static String a;

    /* renamed from: a, reason: collision with other field name */
    private static final Set<String> f833a;

    /* renamed from: a, reason: collision with other field name */
    private static boolean f834a;

    /* renamed from: a, reason: collision with other field name */
    private static final String[] f835a;
    private static String b;
    private static String c;
    private static String d;
    private static String e;
    private static final String f;

    private static double a(double d2) {
        int i = 1;
        while (true) {
            double d3 = i;
            if (d3 >= d2) {
                return d3;
            }
            i <<= 1;
        }
    }

    public static String a(Context context) {
        return null;
    }

    public static String b(Context context) {
        String n = ke6.g.n(context);
        b = n;
        return n;
    }

    public static String c(Context context) {
        return null;
    }

    public static String d(Context context) {
        return null;
    }

    public static String e(Context context) {
        return null;
    }

    public static String f(Context context) {
        return "";
    }

    private static String j(Context context) {
        return "";
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = f835a;
            if (i >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m621a(Context context) {
        Intent a2 = l.a(context, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), (String) null, (Handler) null);
        if (a2 == null) {
            return false;
        }
        int intExtra = a2.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m620a() {
        return a() <= 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m622a(Context context, String str) {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo = (PackageInfo) av.a((Object) context.getPackageManager(), "getPackageInfoAsUser", str, 0, 999);
        return packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 8388608) != 8388608;
    }

    public static String c() {
        return b() + "KB";
    }

    public static String d() {
        return (a(Environment.getDataDirectory()) / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) + "KB";
    }

    public static int a() {
        Object a2 = av.a("android.os.UserHandle", "myUserId", new Object[0]);
        if (a2 == null) {
            return -1;
        }
        return ((Integer) Integer.class.cast(a2)).intValue();
    }

    /* renamed from: b, reason: collision with other method in class */
    public static String m623b() {
        return a(((a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d) + "GB";
    }

    static {
        Covode.recordClassIndex(655605);
        a = null;
        b = null;
        c = "";
        d = null;
        e = null;
        f = String.valueOf((char) 2);
        f835a = new String[]{"--", "a-", "u-", "v-", "o-", "g-", "d-"};
        HashSet hashSet = new HashSet();
        f833a = hashSet;
        hashSet.add("com.xiaomi.xmsf");
        hashSet.add("com.xiaomi.finddevice");
        hashSet.add("com.miui.securitycenter");
        f834a = true;
    }

    public static int b() {
        BufferedReader bufferedReader;
        Throwable th;
        String[] split;
        int i = 0;
        if (new PolarisFileWrapper("/proc/meminfo").exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new PolarisFileReaderWrapper("/proc/meminfo"), 8192);
                } catch (IOException unused) {
                }
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine) && (split = readLine.split("\\s+")) != null && split.length >= 2 && TextUtils.isDigitsOnly(split[1])) {
                        i = Integer.parseInt(split[1]);
                    }
                    bufferedReader.close();
                } catch (Exception unused2) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused4) {
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        }
        return i;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m618a() {
        return a(b()) + "GB";
    }

    public static String i(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    private static float a(int i) {
        float f2 = ((((((i + 102400) / 524288) + 1) * MediaPlayer.MEDIA_PLAYER_OPTION_APPID) * 1024) / 1024.0f) / 1024.0f;
        double d2 = f2;
        if (d2 > 0.5d) {
            return (float) Math.ceil(d2);
        }
        return f2;
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m624b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null && !powerManager.isScreenOn()) {
            return false;
        }
        return true;
    }

    public static synchronized String h(Context context) {
        String b2;
        synchronized (i.class) {
            b2 = ba.b(b(context) + ((String) null));
        }
        return b2;
    }

    private static String k(Context context) {
        String string = context.getSharedPreferences("device_info", 0).getString("default_id", null);
        if (TextUtils.isEmpty(string)) {
            String l = l(context);
            a(context, l);
            return l;
        }
        return string;
    }

    public static synchronized String g(Context context) {
        synchronized (i.class) {
            String str = e;
            if (str != null) {
                return str;
            }
            String b2 = ba.b(b(context) + a(context));
            e = b2;
            return b2;
        }
    }

    private static long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    private static String l(Context context) {
        return ax.a(Build.BRAND + "_" + Build.MODEL + "_" + Build.VERSION.SDK_INT + "_" + Build.VERSION.RELEASE + "_" + Build.VERSION.INCREMENTAL + "_" + a() + "_" + context.getPackageName() + "_" + System.currentTimeMillis() + "_" + ba.a(16));
    }

    private static boolean b(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        if (trim.length() == 0 || trim.equalsIgnoreCase("null") || trim.equalsIgnoreCase("unknown")) {
            return true;
        }
        return false;
    }

    /* renamed from: c, reason: collision with other method in class */
    private static boolean m625c(Context context) {
        Bundle bundle;
        ApplicationInfo applicationInfo;
        Bundle bundle2;
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            return true;
        }
        try {
            PackageInfo INVOKEVIRTUAL_com_xiaomi_push_i_com_dragon_read_resource_PackageManagerAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_push_i_com_dragon_read_resource_PackageManagerAop_getPackageInfo(context.getPackageManager(), context.getPackageName(), 128);
            if (INVOKEVIRTUAL_com_xiaomi_push_i_com_dragon_read_resource_PackageManagerAop_getPackageInfo != null && (applicationInfo = INVOKEVIRTUAL_com_xiaomi_push_i_com_dragon_read_resource_PackageManagerAop_getPackageInfo.applicationInfo) != null && (bundle2 = applicationInfo.metaData) != null && bundle2.containsKey("supportGetAndroidID")) {
                boolean z = INVOKEVIRTUAL_com_xiaomi_push_i_com_dragon_read_resource_PackageManagerAop_getPackageInfo.applicationInfo.metaData.getBoolean("supportGetAndroidID", true);
                com.xiaomi.channel.commonutils.logger.b.m59b("DeviceInfo", "Get supportGetAndroidID from app metaData: " + z);
                return z;
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.c("DeviceInfo", "Check supportGetAndroidID from app metaData error: " + e2.getMessage());
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName(context.getPackageName(), "com.xiaomi.push.service.XMPushService");
            intent.setComponent(componentName);
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(componentName, 128);
            if (serviceInfo != null && (bundle = serviceInfo.metaData) != null && bundle.containsKey("supportGetAndroidID")) {
                com.xiaomi.channel.commonutils.logger.b.m59b("DeviceInfo", "The metaData of XMPushService contains key supportGetAndroidID,so return false.");
                return false;
            }
        } catch (Exception e3) {
            com.xiaomi.channel.commonutils.logger.b.c("DeviceInfo", "Check supportGetAndroidID from XMPushService metaData error: " + e3.getMessage());
        }
        com.xiaomi.channel.commonutils.logger.b.m59b("DeviceInfo", "Not configure the metaData key of supportGetAndroidID，return true by default.");
        return true;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static String m619a(int i) {
        if (i > 0) {
            String[] strArr = f835a;
            if (i < strArr.length) {
                return strArr[i];
            }
        }
        return f835a[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ab A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x0015, B:11:0x001a, B:12:0x001f, B:16:0x002f, B:18:0x0035, B:21:0x003c, B:23:0x004a, B:24:0x0094, B:26:0x00ab, B:27:0x00ae, B:28:0x005b, B:30:0x0069, B:33:0x0074, B:36:0x007c, B:37:0x0082, B:39:0x00c7), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ae A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x0015, B:11:0x001a, B:12:0x001f, B:16:0x002f, B:18:0x0035, B:21:0x003c, B:23:0x004a, B:24:0x0094, B:26:0x00ab, B:27:0x00ae, B:28:0x005b, B:30:0x0069, B:33:0x0074, B:36:0x007c, B:37:0x0082, B:39:0x00c7), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized java.lang.String a(android.content.Context r6, boolean r7) {
        /*
            java.lang.Class<com.xiaomi.push.i> r0 = com.xiaomi.push.i.class
            monitor-enter(r0)
            java.lang.String r1 = com.xiaomi.push.i.d     // Catch: java.lang.Throwable -> Lcb
            if (r1 != 0) goto Lc7
            java.lang.String r1 = b(r6)     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r2 = ""
            boolean r3 = com.xiaomi.push.j.m636d()     // Catch: java.lang.Throwable -> Lcb
            if (r3 != 0) goto L1f
            if (r7 == 0) goto L1a
            java.lang.String r7 = c(r6)     // Catch: java.lang.Throwable -> Lcb
            goto L1e
        L1a:
            java.lang.String r7 = j(r6)     // Catch: java.lang.Throwable -> Lcb
        L1e:
            r2 = r7
        L1f:
            java.lang.String r7 = a(r6)     // Catch: java.lang.Throwable -> Lcb
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lcb
            r4 = 26
            r5 = 1
            if (r3 >= r4) goto L2c
            r3 = 1
            goto L2d
        L2c:
            r3 = 0
        L2d:
            if (r3 != 0) goto L82
            boolean r3 = b(r2)     // Catch: java.lang.Throwable -> Lcb
            if (r3 == 0) goto L82
            boolean r3 = b(r7)     // Catch: java.lang.Throwable -> Lcb
            if (r3 != 0) goto L3c
            goto L82
        L3c:
            com.xiaomi.push.am r7 = com.xiaomi.push.am.a(r6)     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r7 = r7.b()     // Catch: java.lang.Throwable -> Lcb
            boolean r2 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> Lcb
            if (r2 != 0) goto L5b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcb
            r6.<init>()     // Catch: java.lang.Throwable -> Lcb
            r6.append(r7)     // Catch: java.lang.Throwable -> Lcb
            r6.append(r1)     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r1 = r6.toString()     // Catch: java.lang.Throwable -> Lcb
            r5 = 2
            goto L94
        L5b:
            com.xiaomi.push.am r7 = com.xiaomi.push.am.a(r6)     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r7 = r7.mo140a()     // Catch: java.lang.Throwable -> Lcb
            boolean r2 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> Lcb
            if (r2 != 0) goto L74
            java.lang.String r2 = "00000000-0000-0000-0000-000000000000"
            boolean r2 = r7.startsWith(r2)     // Catch: java.lang.Throwable -> Lcb
            if (r2 != 0) goto L74
            r5 = 4
            r1 = r7
            goto L94
        L74:
            boolean r7 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lcb
            if (r7 != 0) goto L7c
            r5 = 5
            goto L94
        L7c:
            java.lang.String r1 = k(r6)     // Catch: java.lang.Throwable -> Lcb
            r5 = 6
            goto L94
        L82:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcb
            r6.<init>()     // Catch: java.lang.Throwable -> Lcb
            r6.append(r2)     // Catch: java.lang.Throwable -> Lcb
            r6.append(r1)     // Catch: java.lang.Throwable -> Lcb
            r6.append(r7)     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r1 = r6.toString()     // Catch: java.lang.Throwable -> Lcb
        L94:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcb
            r6.<init>()     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r7 = "devid rule select:"
            r6.append(r7)     // Catch: java.lang.Throwable -> Lcb
            r6.append(r5)     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Lcb
            com.xiaomi.channel.commonutils.logger.b.b(r6)     // Catch: java.lang.Throwable -> Lcb
            r6 = 3
            if (r5 != r6) goto Lae
            com.xiaomi.push.i.d = r1     // Catch: java.lang.Throwable -> Lcb
            goto Lc7
        Lae:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcb
            r6.<init>()     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r7 = m619a(r5)     // Catch: java.lang.Throwable -> Lcb
            r6.append(r7)     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r7 = com.xiaomi.push.ba.b(r1)     // Catch: java.lang.Throwable -> Lcb
            r6.append(r7)     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Lcb
            com.xiaomi.push.i.d = r6     // Catch: java.lang.Throwable -> Lcb
        Lc7:
            java.lang.String r6 = com.xiaomi.push.i.d     // Catch: java.lang.Throwable -> Lcb
            monitor-exit(r0)
            return r6
        Lcb:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.i.a(android.content.Context, boolean):java.lang.String");
    }

    private static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info", 0);
        if (TextUtils.isEmpty(sharedPreferences.getString("default_id", null))) {
            sharedPreferences.edit().putString("default_id", str).apply();
        } else {
            com.xiaomi.channel.commonutils.logger.b.m54a("default_id exist,do not change it.");
        }
    }

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_i_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            PackageInfo INVOKEVIRTUAL_com_xiaomi_push_i_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_push_i_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
            Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_i_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return INVOKEVIRTUAL_com_xiaomi_push_i_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
        }
        x55.b bVar = x55.b.a;
        PackageInfo f2 = bVar.f(packageName, i);
        if (f2 != null) {
            return f2;
        }
        PackageInfo INVOKEVIRTUAL_com_xiaomi_push_i_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_xiaomi_push_i_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
        Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_i_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i, INVOKEVIRTUAL_com_xiaomi_push_i_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
        return INVOKEVIRTUAL_com_xiaomi_push_i_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
    }

    @Proxy("getPackageInfo")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_i_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i) {
        if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
            return null;
        }
        if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
            LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + Log.getStackTraceString(new Exception()), new Object[0]);
        }
        return packageManager.getPackageInfo(str, i);
    }
}
