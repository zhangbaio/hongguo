package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.DebugManager;
import com.xiaomi.push.service.XMJobService;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class dy {
    private static int a;

    /* renamed from: a, reason: collision with other field name */
    private static a f349a;

    /* renamed from: a, reason: collision with other field name */
    private static final String f350a;

    interface a {
        void a();

        void a(boolean z);

        /* renamed from: a, reason: collision with other method in class */
        boolean mo376a();
    }

    static {
        Covode.recordClassIndex(655474);
        f350a = XMJobService.class.getCanonicalName();
        a = 0;
    }

    public static synchronized void a() {
        synchronized (dy.class) {
            if (f349a == null) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m54a("[Alarm] stop alarm.");
            f349a.a();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized boolean m375a() {
        synchronized (dy.class) {
            a aVar = f349a;
            if (aVar == null) {
                return false;
            }
            return aVar.mo376a();
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (dy.class) {
            if (f349a == null) {
                com.xiaomi.channel.commonutils.logger.b.m54a("timer is not initialized");
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m54a("[Alarm] register alarm. (" + z + ")");
            f349a.a(z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
    
        if (r6.equals(com.xiaomi.push.q.a(r9, r5.name).getSuperclass().getCanonicalName()) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r9) {
        /*
            java.lang.String r0 = "android.permission.BIND_JOB_SERVICE"
            android.content.Context r9 = r9.getApplicationContext()
            java.lang.String r1 = r9.getPackageName()
            java.lang.String r2 = "com.xiaomi.xmsf"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L1b
            com.xiaomi.push.dz r0 = new com.xiaomi.push.dz
            r0.<init>(r9)
            com.xiaomi.push.dy.f349a = r0
            goto Lcc
        L1b:
            android.content.pm.PackageManager r1 = r9.getPackageManager()
            r2 = 0
            java.lang.String r3 = r9.getPackageName()     // Catch: java.lang.Exception -> L7d
            r4 = 4
            android.content.pm.PackageInfo r1 = INVOKEVIRTUAL_com_xiaomi_push_dy_com_dragon_read_resource_PackageManagerAop_getPackageInfo(r1, r3, r4)     // Catch: java.lang.Exception -> L7d
            android.content.pm.ServiceInfo[] r1 = r1.services     // Catch: java.lang.Exception -> L7d
            if (r1 == 0) goto L96
            int r3 = r1.length     // Catch: java.lang.Exception -> L7d
            r4 = 0
        L2f:
            if (r2 >= r3) goto L7b
            r5 = r1[r2]     // Catch: java.lang.Exception -> L78
            java.lang.String r6 = r5.permission     // Catch: java.lang.Exception -> L78
            boolean r6 = r0.equals(r6)     // Catch: java.lang.Exception -> L78
            r7 = 1
            if (r6 == 0) goto L61
            java.lang.String r6 = com.xiaomi.push.dy.f350a     // Catch: java.lang.Exception -> L78
            java.lang.String r8 = r5.name     // Catch: java.lang.Exception -> L78
            boolean r8 = r6.equals(r8)     // Catch: java.lang.Exception -> L78
            if (r8 == 0) goto L48
        L46:
            r4 = 1
            goto L5e
        L48:
            java.lang.String r8 = r5.name     // Catch: java.lang.Exception -> L5d
            java.lang.Class r8 = com.xiaomi.push.q.a(r9, r8)     // Catch: java.lang.Exception -> L5d
            java.lang.Class r8 = r8.getSuperclass()     // Catch: java.lang.Exception -> L5d
            java.lang.String r8 = r8.getCanonicalName()     // Catch: java.lang.Exception -> L5d
            boolean r6 = r6.equals(r8)     // Catch: java.lang.Exception -> L5d
            if (r6 == 0) goto L5e
            goto L46
        L5d:
        L5e:
            if (r4 != r7) goto L61
            goto L7b
        L61:
            java.lang.String r6 = com.xiaomi.push.dy.f350a     // Catch: java.lang.Exception -> L78
            java.lang.String r8 = r5.name     // Catch: java.lang.Exception -> L78
            boolean r6 = r6.equals(r8)     // Catch: java.lang.Exception -> L78
            if (r6 == 0) goto L75
            java.lang.String r5 = r5.permission     // Catch: java.lang.Exception -> L78
            boolean r5 = r0.equals(r5)     // Catch: java.lang.Exception -> L78
            if (r5 == 0) goto L75
            r2 = 1
            goto L96
        L75:
            int r2 = r2 + 1
            goto L2f
        L78:
            r1 = move-exception
            r2 = r4
            goto L7e
        L7b:
            r2 = r4
            goto L96
        L7d:
            r1 = move-exception
        L7e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "check service err : "
            r3.append(r4)
            java.lang.String r1 = r1.getMessage()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.m54a(r1)
        L96:
            if (r2 != 0) goto Lc5
            boolean r1 = com.xiaomi.push.q.m643a(r9)
            if (r1 != 0) goto L9f
            goto Lc5
        L9f:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Should export service: "
            r1.append(r2)
            java.lang.String r2 = com.xiaomi.push.dy.f350a
            r1.append(r2)
            java.lang.String r2 = " with permission "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = " in AndroidManifest.xml file"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r9.<init>(r0)
            throw r9
        Lc5:
            com.xiaomi.push.dz r0 = new com.xiaomi.push.dz
            r0.<init>(r9)
            com.xiaomi.push.dy.f349a = r0
        Lcc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dy.a(android.content.Context):void");
    }

    public static synchronized void a(Context context, int i) {
        synchronized (dy.class) {
            int i2 = a;
            if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                if (i == 2) {
                    a = 2;
                } else {
                    a = 0;
                }
            }
            int i3 = a;
            if (i2 != i3 && i3 == 2) {
                a();
                f349a = new eb(context);
            }
        }
    }

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_dy_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            PackageInfo INVOKEVIRTUAL_com_xiaomi_push_dy_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_push_dy_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
            Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_dy_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return INVOKEVIRTUAL_com_xiaomi_push_dy_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
        }
        x55.b bVar = x55.b.a;
        PackageInfo f = bVar.f(packageName, i);
        if (f != null) {
            return f;
        }
        PackageInfo INVOKEVIRTUAL_com_xiaomi_push_dy_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_xiaomi_push_dy_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
        Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_dy_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i, INVOKEVIRTUAL_com_xiaomi_push_dy_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
        return INVOKEVIRTUAL_com_xiaomi_push_dy_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
    }

    @Proxy("getPackageInfo")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_dy_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i) {
        if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
            return null;
        }
        if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
            LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + Log.getStackTraceString(new Exception()), new Object[0]);
        }
        return packageManager.getPackageInfo(str, i);
    }
}
