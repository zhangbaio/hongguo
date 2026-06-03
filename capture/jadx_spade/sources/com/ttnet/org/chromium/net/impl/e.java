package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.impl.CronetLogger;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e {
    static {
        Covode.recordClassIndex(654604);
    }

    public static boolean b(Context context, CronetLogger.CronetSource cronetSource) {
        try {
            Bundle bundle = a(context.getPackageManager(), context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return false;
            }
            return bundle.getBoolean("com.ttnet.org.chromium.net.CronetMetricsOptIn");
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Proxy("getApplicationInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static ApplicationInfo a(PackageManager packageManager, String packageName, int i) {
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
}
