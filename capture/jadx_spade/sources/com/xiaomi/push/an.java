package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
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
import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class an implements ah {
    private static boolean a;

    /* renamed from: a, reason: collision with other field name */
    private Context f120a;

    /* renamed from: a, reason: collision with other field name */
    private ServiceConnection f121a;

    /* renamed from: a, reason: collision with other field name */
    private volatile int f119a = 0;

    /* renamed from: a, reason: collision with other field name */
    private volatile a f122a = null;

    /* renamed from: a, reason: collision with other field name */
    private final Object f123a = new Object();

    static {
        Covode.recordClassIndex(655347);
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a */
    public boolean mo141a() {
        return a;
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a */
    public String mo140a() {
        a("getOAID");
        if (this.f122a == null) {
            return null;
        }
        return this.f122a.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: collision with other method in class */
    public void m147b() {
        ServiceConnection serviceConnection = this.f121a;
        if (serviceConnection != null) {
            try {
                this.f120a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        try {
            Signature[] signatureArr = INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_resource_PackageManagerAop_getPackageInfo(this.f120a.getPackageManager(), this.f120a.getPackageName(), 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            StringBuilder sb = new StringBuilder();
            for (byte b2 : messageDigest.digest(signatureArr[0].toByteArray())) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private void a() {
        boolean z;
        this.f121a = new b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        int i = 1;
        try {
            z = INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_aop_ContextAop_bindService(this.f120a, intent, this.f121a, 1);
        } catch (Exception unused) {
            z = false;
        }
        if (!z) {
            i = 2;
        }
        this.f119a = i;
    }

    private class b implements ServiceConnection {
        static {
            Covode.recordClassIndex(655349);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            if (an.this.f122a != null) {
                return;
            }
            new Thread(new Runnable() { // from class: com.xiaomi.push.an.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String packageName = an.this.f120a.getPackageName();
                        String b = an.this.b();
                        a aVar = new a();
                        aVar.b = c.a(iBinder, packageName, b, "OUID");
                        an.this.f122a = aVar;
                        an.this.m147b();
                        an.this.f119a = 2;
                        synchronized (an.this.f123a) {
                            try {
                                an.this.f123a.notifyAll();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        an.this.m147b();
                        an.this.f119a = 2;
                        synchronized (an.this.f123a) {
                            try {
                                an.this.f123a.notifyAll();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        an.this.m147b();
                        an.this.f119a = 2;
                        synchronized (an.this.f123a) {
                            try {
                                an.this.f123a.notifyAll();
                            } catch (Exception unused4) {
                            }
                            throw th;
                        }
                    }
                }
            }).start();
        }
    }

    private class a {

        /* renamed from: a, reason: collision with other field name */
        String f124a;
        String b;
        String c;
        String d;

        static {
            Covode.recordClassIndex(655348);
        }

        private a() {
            this.f124a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }
    }

    public an(Context context) {
        this.f120a = context;
        a();
    }

    private void a(String str) {
        if (this.f119a == 1 && Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (this.f123a) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.m54a("oppo's " + str + " wait...");
                    this.f123a.wait(3000L);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static boolean a(Context context) {
        long j;
        boolean z;
        boolean z2;
        try {
            PackageInfo INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_resource_PackageManagerAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_resource_PackageManagerAop_getPackageInfo(context.getPackageManager(), "com.heytap.openid", 128);
            if (INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_resource_PackageManagerAop_getPackageInfo != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    j = INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_resource_PackageManagerAop_getPackageInfo.getLongVersionCode();
                } else {
                    j = INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_resource_PackageManagerAop_getPackageInfo.versionCode;
                }
                if ((INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_resource_PackageManagerAop_getPackageInfo.applicationInfo.flags & 1) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (j >= 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                a = z2;
                if (z) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            PackageInfo INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
            Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
        }
        x55.b bVar = x55.b.a;
        PackageInfo f = bVar.f(packageName, i);
        if (f != null) {
            return f;
        }
        PackageInfo INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
        Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i, INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
        return INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
    }

    @Proxy("getPackageInfo")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i) {
        if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
            return null;
        }
        if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
            LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + Log.getStackTraceString(new Exception()), new Object[0]);
        }
        return packageManager.getPackageInfo(str, i);
    }

    private static class c {
        static {
            Covode.recordClassIndex(655350);
        }

        static String a(IBinder iBinder, String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    @Proxy("bindService")
    @TargetClass("android.content.Context")
    public static boolean INVOKEVIRTUAL_com_xiaomi_push_an_com_dragon_read_aop_ContextAop_bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
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
