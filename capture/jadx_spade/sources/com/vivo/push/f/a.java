package com.vivo.push.f;

import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.DebugManager;
import com.vivo.push.util.aa;
import com.vivo.push.util.t;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import x55.b;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    private volatile Boolean a = null;
    private volatile Boolean b = null;

    static {
        Covode.recordClassIndex(655037);
    }

    private synchronized boolean c(Context context) {
        if (this.b != null) {
            return this.b.booleanValue();
        }
        boolean z = true;
        if (context == null) {
            return true;
        }
        boolean d = aa.d(context, context.getPackageName());
        if (!aa.c(context, context.getPackageName()) && !d) {
            z = false;
        }
        this.b = Boolean.valueOf(z);
        return this.b.booleanValue();
    }

    public final synchronized byte[] a(Context context) {
        byte[] bArr;
        bArr = new byte[16];
        bArr[0] = 34;
        bArr[1] = 32;
        bArr[2] = 33;
        bArr[3] = 37;
        if (d(context)) {
            bArr[4] = 33;
            bArr[5] = 34;
            bArr[6] = 32;
            bArr[7] = 33;
        }
        bArr[8] = 33;
        bArr[9] = 33;
        bArr[10] = 34;
        bArr[11] = 41;
        if (c(context)) {
            bArr[12] = 35;
            bArr[13] = 32;
            bArr[14] = 32;
            bArr[15] = 32;
        }
        return bArr;
    }

    public final synchronized byte[] b(Context context) {
        byte[] bArr;
        bArr = new byte[16];
        bArr[0] = 33;
        bArr[1] = 34;
        bArr[2] = 35;
        bArr[3] = 36;
        if (d(context)) {
            bArr[4] = 37;
            bArr[5] = 38;
            bArr[6] = 39;
            bArr[7] = 40;
        }
        bArr[8] = 41;
        bArr[9] = 32;
        bArr[10] = 38;
        bArr[11] = 37;
        if (c(context)) {
            bArr[12] = 36;
            bArr[13] = 35;
            bArr[14] = 34;
            bArr[15] = 33;
        }
        return bArr;
    }

    private synchronized boolean d(Context context) {
        String str;
        if (this.a != null) {
            return this.a.booleanValue();
        }
        if (context == null) {
            t.c("ConfigSecureUtil", "checkHasService paramContext is empty ");
            return true;
        }
        try {
            if (aa.c(context, context.getPackageName())) {
                str = "com.vivo.push.sdk.service.CommandClientService";
            } else {
                str = "com.vivo.push.sdk.service.CommandService";
            }
            ServiceInfo[] serviceInfoArr = INVOKEVIRTUAL_com_vivo_push_f_a_com_dragon_read_resource_PackageManagerAop_getPackageInfo(context.getPackageManager(), context.getPackageName(), 4).services;
            if (serviceInfoArr == null) {
                t.c("ConfigSecureUtil", "checkHasService serviceInfos is empty ");
                this.a = Boolean.TRUE;
            }
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (str.equals(((ComponentInfo) serviceInfo).name)) {
                    this.a = Boolean.TRUE;
                    return this.a.booleanValue();
                }
            }
            this.a = Boolean.FALSE;
        } catch (Exception e) {
            t.a("ConfigSecureUtil", "checkHasService error " + e.getMessage());
            this.a = Boolean.TRUE;
        }
        return this.a.booleanValue();
    }

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_vivo_push_f_a_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            PackageInfo INVOKEVIRTUAL_com_vivo_push_f_a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_vivo_push_f_a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
            Intrinsics.checkNotNull(INVOKEVIRTUAL_com_vivo_push_f_a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return INVOKEVIRTUAL_com_vivo_push_f_a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
        }
        b bVar = b.a;
        PackageInfo f = bVar.f(packageName, i);
        if (f != null) {
            return f;
        }
        PackageInfo INVOKEVIRTUAL_com_vivo_push_f_a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_vivo_push_f_a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
        Intrinsics.checkNotNull(INVOKEVIRTUAL_com_vivo_push_f_a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i, INVOKEVIRTUAL_com_vivo_push_f_a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
        return INVOKEVIRTUAL_com_vivo_push_f_a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
    }

    @Proxy("getPackageInfo")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_vivo_push_f_a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i) {
        if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
            return null;
        }
        if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
            LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + Log.getStackTraceString(new Exception()), new Object[0]);
        }
        return packageManager.getPackageInfo(str, i);
    }
}
