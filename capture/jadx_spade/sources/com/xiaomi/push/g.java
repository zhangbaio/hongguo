package com.xiaomi.push;

import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.DebugManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class g {
    private static a a;

    public interface a {
        Map<String, String> a(Context context, String str);

        /* renamed from: a, reason: collision with other method in class */
        boolean m462a(Context context, String str);

        boolean b(Context context, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String com_xiaomi_push_g_android_provider_Settings$Secure_getString(ContentResolver contentResolver, String str) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = {contentResolver, str};
        ExtraInfo extraInfo = new ExtraInfo(false, "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String string = Settings.Secure.getString(contentResolver, str);
        heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, string, extraInfo, true);
        return string;
    }

    public enum b {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);


        /* renamed from: a, reason: collision with other field name */
        private final int f487a;

        public int a() {
            return this.f487a;
        }

        static {
            Covode.recordClassIndex(655548);
        }

        b(int i) {
            this.f487a = i;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m456a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getPackageInfo(context.getPackageManager(), str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : com.ss.ttm.ttvideodecode.BuildConfig.VERSION_NAME;
    }

    public static void a(Context context, ApplicationInfo applicationInfo, boolean z) {
        Object systemService;
        int i = Build.VERSION.SDK_INT;
        if (b.ALLOWED != a(context, applicationInfo)) {
            try {
                if (i >= 29) {
                    systemService = av.a(context.getSystemService("notification"), "getService", new Object[0]);
                } else {
                    systemService = context.getSystemService("security");
                }
                if (systemService != null) {
                    av.b(systemService, "setNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid), Boolean.valueOf(z));
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m54a("set notifications enabled error " + e);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m459a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (!j.m630a()) {
            return context.getPackageName().equals(str);
        }
        a aVar = a;
        return aVar != null && aVar.m462a(context, str);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m458a(Context context) {
        String a2 = a();
        if (TextUtils.isEmpty(a2) || context == null) {
            return false;
        }
        return a2.equals(context.getPackageName());
    }

    static {
        Covode.recordClassIndex(655546);
        a = null;
    }

    public static String a() {
        String str;
        if (Build.VERSION.SDK_INT >= 28) {
            str = Application.getProcessName();
        } else {
            str = (String) av.a("android.app.ActivityThread", "currentProcessName", new Object[0]);
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return "";
    }

    public static int a(Context context) {
        Bundle bundle;
        if (context != null) {
            try {
                ApplicationInfo INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getApplicationInfo = INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getApplicationInfo(context.getPackageManager(), "com.android.systemui", 128);
                if (INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getApplicationInfo != null && (bundle = INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getApplicationInfo.metaData) != null) {
                    return bundle.getInt("SupportForPushVersionCode");
                }
                return 0;
            } catch (PackageManager.NameNotFoundException unused) {
                return 0;
            }
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Map<String, String> m457a(Context context, String str) {
        a aVar = a;
        if (aVar == null) {
            return null;
        }
        return aVar.a(context, str);
    }

    public static int b(Context context, String str) {
        ApplicationInfo m454a = m454a(context, str);
        if (m454a != null) {
            int i = m454a.icon;
            if (i == 0) {
                return m454a.logo;
            }
            return i;
        }
        return 0;
    }

    public static boolean c(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getPackageInfo(context.getPackageManager(), str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        }
        return true;
    }

    @Proxy("getString")
    @TargetClass(scope = Scope.SELF, value = "android.provider.Settings$Secure")
    public static String INVOKESTATIC_com_xiaomi_push_g_com_dragon_read_base_lancet_PrivacyAop_getStringSecure(ContentResolver contentResolver, String str) {
        if (TextUtils.equals(str, "android_id") && !PrivacyMgr.inst().hasConfirmedAndNotBasic()) {
            return null;
        }
        return com_xiaomi_push_g_android_provider_Settings$Secure_getString(contentResolver, str);
    }

    /* renamed from: b, reason: collision with other method in class */
    public static String m460b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getPackageInfo(packageManager, str, 0);
            if (INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getPackageInfo != null && (applicationInfo = INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getPackageInfo.applicationInfo) != null) {
                return packageManager.getApplicationLabel(applicationInfo).toString();
            }
            return str;
        } catch (PackageManager.NameNotFoundException unused) {
            return str;
        }
    }

    public static int a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getPackageInfo(context.getPackageManager(), str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m461b(Context context, String str) {
        a aVar = a;
        if (aVar != null && aVar.b(context, str)) {
            return true;
        }
        return false;
    }

    public static boolean d(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), "freeform_window_state", -1) >= 0) {
                    return str.equals(INVOKESTATIC_com_xiaomi_push_g_com_dragon_read_base_lancet_PrivacyAop_getStringSecure(context.getContentResolver(), "freeform_package_name"));
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static ApplicationInfo m454a(Context context, String str) {
        if (str.equals(context.getPackageName())) {
            return context.getApplicationInfo();
        }
        try {
            return INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getApplicationInfo(context.getPackageManager(), str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            com.xiaomi.channel.commonutils.logger.b.m54a("not found app info " + str);
            return null;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Drawable m455a(Context context, String str) {
        ApplicationInfo m454a = m454a(context, str);
        Drawable drawable = null;
        if (m454a != null) {
            try {
                drawable = m454a.loadIcon(context.getPackageManager());
                if (drawable == null) {
                    drawable = m454a.loadLogo(context.getPackageManager());
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m54a("get app icon drawable failed, " + e);
            }
        }
        if (drawable == null) {
            return new ColorDrawable(0);
        }
        return drawable;
    }

    private static b a(Context context, ApplicationInfo applicationInfo) {
        Object systemService;
        Boolean bool;
        int i = Build.VERSION.SDK_INT;
        if (applicationInfo != null && i >= 24) {
            try {
                if (applicationInfo.packageName.equals(context.getPackageName())) {
                    bool = Boolean.valueOf(((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled());
                } else {
                    if (i >= 29) {
                        systemService = av.a(context.getSystemService("notification"), "getService", new Object[0]);
                    } else {
                        systemService = context.getSystemService("security");
                    }
                    if (systemService != null) {
                        bool = (Boolean) av.b(systemService, "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid));
                    } else {
                        bool = null;
                    }
                }
                if (bool != null) {
                    if (bool.booleanValue()) {
                        return b.ALLOWED;
                    }
                    return b.NOT_ALLOWED;
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m54a("are notifications enabled error " + e);
            }
            return b.UNKNOWN;
        }
        return b.UNKNOWN;
    }

    @Proxy("getApplicationInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static ApplicationInfo INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getApplicationInfo(PackageManager packageManager, String packageName, int i) {
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

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            PackageInfo INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
            Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
        }
        x55.b bVar = x55.b.a;
        PackageInfo f = bVar.f(packageName, i);
        if (f != null) {
            return f;
        }
        PackageInfo INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
        Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i, INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
        return INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
    }

    @Proxy("getPackageInfo")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i) {
        if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
            return null;
        }
        if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
            LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + Log.getStackTraceString(new Exception()), new Object[0]);
        }
        return packageManager.getPackageInfo(str, i);
    }

    public static b a(Context context, String str, boolean z) {
        ApplicationInfo INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getApplicationInfo;
        b a2;
        b bVar;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (str.equals(context.getPackageName())) {
                    INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getApplicationInfo = context.getApplicationInfo();
                } else {
                    INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getApplicationInfo = INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getApplicationInfo(context.getPackageManager(), str, 0);
                }
                a2 = a(context, INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getApplicationInfo);
                bVar = b.UNKNOWN;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m54a("get app op error " + th);
            }
            if (a2 != bVar) {
                return a2;
            }
            Integer num = (Integer) av.a((Class<? extends Object>) AppOpsManager.class, "OP_POST_NOTIFICATION");
            if (num == null) {
                return bVar;
            }
            Integer num2 = (Integer) av.a(context.getSystemService("appops"), "checkOpNoThrow", num, Integer.valueOf(INVOKEVIRTUAL_com_xiaomi_push_g_com_dragon_read_resource_PackageManagerAop_getApplicationInfo.uid), str);
            int i = (Integer) av.a((Class<? extends Object>) AppOpsManager.class, "MODE_ALLOWED");
            int i2 = (Integer) av.a((Class<? extends Object>) AppOpsManager.class, "MODE_IGNORED");
            com.xiaomi.channel.commonutils.logger.b.b(String.format("get app mode %s|%s|%s", num2, i, i2));
            if (i == null) {
                i = 0;
            }
            if (i2 == null) {
                i2 = 1;
            }
            if (num2 != null) {
                if (z) {
                    if (!num2.equals(i2)) {
                        return b.ALLOWED;
                    }
                    return b.NOT_ALLOWED;
                }
                if (num2.equals(i)) {
                    return b.ALLOWED;
                }
                return b.NOT_ALLOWED;
            }
            return b.UNKNOWN;
        }
        return b.UNKNOWN;
    }
}
