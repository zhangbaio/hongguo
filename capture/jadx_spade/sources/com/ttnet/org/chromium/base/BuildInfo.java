package com.ttnet.org.chromium.base;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.DebugManager;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BuildInfo {
    private static PackageInfo n;
    private static ApplicationInfo o;
    private static boolean p;
    private static String q;
    public String a;
    public long b;
    public String c;
    public long d;
    public String e;
    public String f;
    public String h;
    public String i;
    public String k;
    public boolean l;
    public boolean m;
    public String g = "";
    public String j = "";

    private static class a {
        private static BuildInfo a;

        static {
            Covode.recordClassIndex(654157);
            a = new BuildInfo();
        }
    }

    public static BuildInfo d() {
        return a.a;
    }

    static {
        Covode.recordClassIndex(654156);
        q = "";
    }

    private static String[] getAll() {
        return d().c();
    }

    public static boolean f() {
        if (Build.VERSION.SDK_INT >= 32 && e("Tiramisu", Build.VERSION.CODENAME)) {
            return true;
        }
        return false;
    }

    public static boolean g() {
        String str = Build.TYPE;
        if (!"eng".equals(str) && !"userdebug".equals(str)) {
            return false;
        }
        return true;
    }

    BuildInfo() {
        this.a = "";
        this.c = "";
        this.e = "";
        this.f = "";
        this.h = "";
        this.i = "";
        this.k = "";
        boolean z = true;
        p = true;
        try {
            Context f = c.f();
            String packageName = f.getPackageName();
            PackageManager packageManager = f.getPackageManager();
            PackageInfo b = b(packageManager, packageName, 0);
            long i = i(b);
            this.b = i;
            PackageInfo packageInfo = n;
            if (packageInfo != null) {
                this.c = packageInfo.packageName;
                this.d = i(packageInfo);
                this.e = h(n.versionName);
                o = n.applicationInfo;
                n = null;
            } else {
                this.c = packageName;
                this.d = i;
                this.e = h(b.versionName);
                o = f.getApplicationInfo();
            }
            this.a = h(packageManager.getApplicationLabel(b.applicationInfo));
            this.f = h(packageManager.getInstallerPackageName(this.c));
            String str = "Not Enabled";
            if (xj6.a.b != 0) {
                try {
                    str = c.f().getString(xj6.a.b);
                } catch (Exception unused) {
                    str = "Not found";
                }
            }
            this.k = str;
            this.h = TextUtils.join(", ", Build.SUPPORTED_ABIS);
            String str2 = Build.FINGERPRINT;
            this.i = str2.substring(0, Math.min(str2.length(), 128));
            UiModeManager uiModeManager = (UiModeManager) f.getSystemService("uimode");
            if (uiModeManager == null || uiModeManager.getCurrentModeType() != 4) {
                z = false;
            }
            this.l = z;
            this.m = f.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
        } catch (Exception e) {
            h.b("BuildInfo", "NameNotFoundException: " + e, new Object[0]);
        }
    }

    String[] c() {
        String str;
        String str2;
        String str3;
        String packageName = c.f().getPackageName();
        String[] strArr = new String[28];
        strArr[0] = Build.BRAND;
        strArr[1] = Build.DEVICE;
        strArr[2] = Build.ID;
        strArr[3] = Build.MANUFACTURER;
        strArr[4] = Build.MODEL;
        strArr[5] = String.valueOf(Build.VERSION.SDK_INT);
        strArr[6] = Build.TYPE;
        strArr[7] = Build.BOARD;
        strArr[8] = packageName;
        strArr[9] = String.valueOf(this.b);
        strArr[10] = this.a;
        strArr[11] = this.c;
        strArr[12] = String.valueOf(this.d);
        strArr[13] = this.e;
        strArr[14] = this.i;
        strArr[15] = this.g;
        strArr[16] = this.f;
        strArr[17] = this.h;
        strArr[18] = q;
        strArr[19] = this.j;
        strArr[20] = this.k;
        strArr[21] = String.valueOf(c.f().getApplicationInfo().targetSdkVersion);
        String str4 = "1";
        if (g()) {
            str = "1";
        } else {
            str = "0";
        }
        strArr[22] = str;
        if (this.l) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        strArr[23] = str2;
        strArr[24] = Build.VERSION.INCREMENTAL;
        strArr[25] = Build.HARDWARE;
        if (f()) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        strArr[26] = str3;
        if (!this.m) {
            str4 = "0";
        }
        strArr[27] = str4;
        return strArr;
    }

    private static String h(CharSequence charSequence) {
        if (charSequence == null) {
            return "";
        }
        return charSequence.toString();
    }

    public static long i(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return vj6.d.a(packageInfo);
        }
        return packageInfo.versionCode;
    }

    private static boolean e(String str, String str2) {
        if ("REL".equals(str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        if (str2.toUpperCase(locale).compareTo(str.toUpperCase(locale)) < 0) {
            return false;
        }
        return true;
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
