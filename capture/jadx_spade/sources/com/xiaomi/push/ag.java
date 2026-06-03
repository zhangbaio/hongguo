package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.app.launch.task.c3;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.biz.api.NsPushService;
import com.dragon.read.util.DebugManager;
import com.ss.android.common.util.ToolUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class ag implements ah {
    private static boolean a;

    /* renamed from: a, reason: collision with other field name */
    private Context f98a;

    /* renamed from: a, reason: collision with other field name */
    private ServiceConnection f99a;

    /* renamed from: a, reason: collision with other field name */
    private volatile int f97a = 0;

    /* renamed from: a, reason: collision with other field name */
    private volatile String f101a = null;

    /* renamed from: b, reason: collision with other field name */
    private volatile boolean f102b = false;
    private volatile String b = null;

    /* renamed from: a, reason: collision with other field name */
    private final Object f100a = new Object();

    static {
        Covode.recordClassIndex(655337);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ServiceConnection serviceConnection = this.f99a;
        if (serviceConnection != null) {
            try {
                this.f98a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    private void a() {
        boolean z;
        this.f99a = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        int i = 1;
        try {
            z = INVOKEVIRTUAL_com_xiaomi_push_ag_com_dragon_read_aop_ContextAop_bindService(this.f98a, intent, this.f99a, 1);
        } catch (Exception unused) {
            z = false;
        }
        if (!z) {
            i = 2;
        }
        this.f97a = i;
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a, reason: collision with other method in class */
    public String mo140a() {
        a("getOAID");
        return this.f101a;
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo141a() {
        return a;
    }

    private class a implements ServiceConnection {
        static {
            Covode.recordClassIndex(655338);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            new Thread(new Runnable() { // from class: com.xiaomi.push.ag.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ag.this.f101a = b.a(iBinder);
                        ag.this.f102b = b.m142a(iBinder);
                        ag.this.b();
                        ag.this.f97a = 2;
                        synchronized (ag.this.f100a) {
                            try {
                                ag.this.f100a.notifyAll();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        ag.this.b();
                        ag.this.f97a = 2;
                        synchronized (ag.this.f100a) {
                            try {
                                ag.this.f100a.notifyAll();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        ag.this.b();
                        ag.this.f97a = 2;
                        synchronized (ag.this.f100a) {
                            try {
                                ag.this.f100a.notifyAll();
                            } catch (Exception unused4) {
                            }
                            throw th;
                        }
                    }
                }
            }).start();
        }
    }

    public ag(Context context) {
        this.f98a = context;
        a();
    }

    private static class b {
        static {
            Covode.recordClassIndex(655339);
        }

        static String a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* renamed from: a, reason: collision with other method in class */
        static boolean m142a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                boolean z = false;
                iBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z = true;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    private void a(String str) {
        if (this.f97a == 1 && Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (this.f100a) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.m54a("huawei's " + str + " wait...");
                    this.f100a.wait(3000L);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static boolean a(Context context) {
        boolean z;
        boolean z2;
        try {
            PackageInfo INVOKEVIRTUAL_com_xiaomi_push_ag_com_dragon_read_resource_PackageManagerAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_push_ag_com_dragon_read_resource_PackageManagerAop_getPackageInfo(context.getPackageManager(), "com.huawei.hwid", 128);
            if ((INVOKEVIRTUAL_com_xiaomi_push_ag_com_dragon_read_resource_PackageManagerAop_getPackageInfo.applicationInfo.flags & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (INVOKEVIRTUAL_com_xiaomi_push_ag_com_dragon_read_resource_PackageManagerAop_getPackageInfo.versionCode >= 20602000) {
                z2 = true;
            } else {
                z2 = false;
            }
            a = z2;
        } catch (Exception unused) {
        }
        if (!z) {
            return false;
        }
        return true;
    }

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_ag_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            PackageInfo INVOKEVIRTUAL_com_xiaomi_push_ag_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_push_ag_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
            Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_ag_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return INVOKEVIRTUAL_com_xiaomi_push_ag_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
        }
        x55.b bVar = x55.b.a;
        PackageInfo f = bVar.f(packageName, i);
        if (f != null) {
            return f;
        }
        PackageInfo INVOKEVIRTUAL_com_xiaomi_push_ag_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_xiaomi_push_ag_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
        Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_ag_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i, INVOKEVIRTUAL_com_xiaomi_push_ag_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
        return INVOKEVIRTUAL_com_xiaomi_push_ag_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
    }

    @Proxy("getPackageInfo")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_ag_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i) {
        if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
            return null;
        }
        if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
            LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + Log.getStackTraceString(new Exception()), new Object[0]);
        }
        return packageManager.getPackageInfo(str, i);
    }

    @Proxy("bindService")
    @TargetClass("android.content.Context")
    public static boolean INVOKEVIRTUAL_com_xiaomi_push_ag_com_dragon_read_aop_ContextAop_bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        if (ko2.e.a() && intent != null && "com.google.android.gms.ads.identifier.service.START".equals(intent.getAction())) {
            return true;
        }
        if (!(context instanceof Context)) {
            return context.bindService(intent, serviceConnection, i);
        }
        if (lz4.b.a()) {
            lz4.b.b(context, intent);
        } else if (ToolUtils.isMainProcess(App.context()) && c3.g() && NsPushService.IMPL.isInterceptStartPushBind(context, intent, serviceConnection, i)) {
            return true;
        }
        return context.bindService(intent, serviceConnection, i);
    }
}
