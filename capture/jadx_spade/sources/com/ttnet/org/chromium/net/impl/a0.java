package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
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
public final class a0 {
    private static final Object a;
    private static int b;

    static {
        Covode.recordClassIndex(654668);
        a = new Object();
        b = 0;
    }

    private static void c(StringBuilder sb) {
        sb.append(" Cronet/");
        sb.append("TTNetVersion:04657795 2026-01-23 QuicVersion:c67e9834 2025-09-08");
    }

    static String e(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        c(sb);
        return sb.toString();
    }

    private static int f(Context context) {
        int i;
        synchronized (a) {
            if (b == 0) {
                try {
                    b = b(context.getPackageManager(), context.getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            i = b;
        }
        return i;
    }

    public static String d(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append('/');
        sb.append(f(context));
        sb.append(" (Linux; U; Android ");
        sb.append(Build.VERSION.RELEASE);
        sb.append("; ");
        sb.append(Locale.getDefault().toString());
        String str = Build.MODEL;
        if (str.length() > 0) {
            sb.append("; ");
            sb.append(str);
        }
        String str2 = Build.ID;
        if (str2.length() > 0) {
            sb.append("; Build/");
            sb.append(str2);
        }
        sb.append(";");
        c(sb);
        sb.append(')');
        return sb.toString();
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
