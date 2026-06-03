package com.xiaomi.mipush.sdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.agent.instrumentation.ThreadMonitor;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.app.launch.task.c3;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.biz.api.NsPushService;
import com.dragon.read.util.DebugManager;
import com.ss.android.common.util.ToolUtils;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.xiaomi.push.at;
import com.xiaomi.push.av;
import com.xiaomi.push.az;
import com.xiaomi.push.cr;
import com.xiaomi.push.ds;
import com.xiaomi.push.ge;
import com.xiaomi.push.gf;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.go;
import com.xiaomi.push.gr;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import com.xiaomi.push.he;
import com.xiaomi.push.hk;
import com.xiaomi.push.ho;
import com.xiaomi.push.hp;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class u {
    private static u a;

    /* renamed from: a, reason: collision with other field name */
    private static final ArrayList<a> f68a;
    private static boolean b;

    /* renamed from: a, reason: collision with other field name */
    private long f69a;

    /* renamed from: a, reason: collision with other field name */
    private Context f70a;

    /* renamed from: a, reason: collision with other field name */
    private Handler f72a;

    /* renamed from: a, reason: collision with other field name */
    private Messenger f73a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f77a;

    /* renamed from: a, reason: collision with other field name */
    private List<Message> f76a = new ArrayList();
    private boolean c = false;

    /* renamed from: b, reason: collision with other field name */
    private String f78b = null;

    /* renamed from: a, reason: collision with other field name */
    private Intent f71a = null;

    /* renamed from: a, reason: collision with other field name */
    private Integer f74a = null;

    /* renamed from: a, reason: collision with other field name */
    private String f75a = null;

    static class a<T extends hp<T, ?>> {
        ge a;

        /* renamed from: a, reason: collision with other field name */
        T f79a;

        /* renamed from: a, reason: collision with other field name */
        boolean f80a;

        static {
            Covode.recordClassIndex(655322);
        }

        a() {
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m120a() {
        return this.f69a;
    }

    public final void a(he heVar, boolean z) {
        ds.a(this.f70a.getApplicationContext()).a(this.f70a.getPackageName(), "E100003", heVar.a(), 6001, null);
        this.f71a = null;
        b.m79a(this.f70a).f43a = heVar.a();
        Intent m112a = m112a();
        byte[] a2 = ho.a(r.a(this.f70a, heVar, ge.Registration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("register fail, because msgBytes is null.");
            return;
        }
        m112a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m112a.putExtra("mipush_app_id", b.m79a(this.f70a).m80a());
        m112a.putExtra("mipush_payload", a2);
        m112a.putExtra("mipush_session", this.f75a);
        m112a.putExtra("mipush_env_chanage", z);
        m112a.putExtra("mipush_env_type", b.m79a(this.f70a).a());
        if (at.m155a(this.f70a) && m127b()) {
            g();
            c(m112a);
        } else {
            this.f71a = m112a;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m121a() {
        b(m112a());
    }

    public final void a(hk hkVar) {
        byte[] a2 = ho.a(r.a(this.f70a, hkVar, ge.UnRegistration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent m112a = m112a();
        m112a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m112a.putExtra("mipush_app_id", b.m79a(this.f70a).m80a());
        m112a.putExtra("mipush_payload", a2);
        c(m112a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        if (z) {
            p a2 = p.a(this.f70a);
            v vVar = v.DISABLE_PUSH;
            a2.a(vVar, "syncing");
            p.a(this.f70a).a(v.ENABLE_PUSH, "");
            a(str, vVar, true, (HashMap<String, String>) null);
            return;
        }
        p a3 = p.a(this.f70a);
        v vVar2 = v.ENABLE_PUSH;
        a3.a(vVar2, "syncing");
        p.a(this.f70a).a(v.DISABLE_PUSH, "");
        a(str, vVar2, true, (HashMap<String, String>) null);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m122a(Context context) {
        if (com.xiaomi.push.j.m630a()) {
            return;
        }
        q a2 = h.a(context);
        if (q.HUAWEI.equals(a2)) {
            a((String) null, v.UPLOAD_HUAWEI_TOKEN, d.ASSEMBLE_PUSH_HUAWEI, "update");
        }
        if (q.OPPO.equals(a2)) {
            a((String) null, v.UPLOAD_COS_TOKEN, d.ASSEMBLE_PUSH_COS, "update");
        }
        if (q.VIVO.equals(a2)) {
            a((String) null, v.UPLOAD_FTOS_TOKEN, d.ASSEMBLE_PUSH_FTOS, "update");
        }
    }

    public final void a(String str, v vVar, d dVar, String str2) {
        p.a(this.f70a).a(vVar, "syncing");
        HashMap<String, String> m98a = f.m98a(this.f70a, dVar);
        m98a.put("third_sync_reason", str2);
        a(str, vVar, false, m98a);
    }

    void a(int i, String str) {
        Intent m112a = m112a();
        m112a.setAction("com.xiaomi.mipush.thirdparty");
        m112a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        m112a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(m112a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, v vVar, boolean z, HashMap<String, String> hashMap) {
        hd hdVar;
        String str2 = str;
        if (b.m79a(this.f70a).m86b() && at.m155a(this.f70a)) {
            hd hdVar2 = new hd();
            hdVar2.a(true);
            Intent m112a = m112a();
            if (TextUtils.isEmpty(str)) {
                str2 = aj.a();
                hdVar2.a(str2);
                hdVar = z ? new hd(str2, true) : null;
                synchronized (p.class) {
                    p.a(this.f70a).m108a(str2);
                }
            } else {
                hdVar2.a(str2);
                hdVar = z ? new hd(str2, true) : null;
            }
            switch (AnonymousClass5.a[vVar.ordinal()]) {
                case 1:
                    go goVar = go.DisablePushMessage;
                    hdVar2.c(goVar.f529a);
                    hdVar.c(goVar.f529a);
                    if (hashMap != null) {
                        hdVar2.a(hashMap);
                        hdVar.a(hashMap);
                    }
                    m112a.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    go goVar2 = go.EnablePushMessage;
                    hdVar2.c(goVar2.f529a);
                    hdVar.c(goVar2.f529a);
                    if (hashMap != null) {
                        hdVar2.a(hashMap);
                        hdVar.a(hashMap);
                    }
                    m112a.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    hdVar2.c(go.ThirdPartyRegUpdate.f529a);
                    if (hashMap != null) {
                        hdVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            com.xiaomi.channel.commonutils.logger.b.e("type:" + vVar + ", " + str2);
            hdVar2.b(b.m79a(this.f70a).m80a());
            hdVar2.d(this.f70a.getPackageName());
            ge geVar = ge.Notification;
            a((u) hdVar2, geVar, false, (gr) null);
            if (z) {
                hdVar.b(b.m79a(this.f70a).m80a());
                hdVar.d(this.f70a.getPackageName());
                Context context = this.f70a;
                byte[] a2 = ho.a(r.a(context, hdVar, geVar, false, context.getPackageName(), b.m79a(this.f70a).m80a()));
                if (a2 != null) {
                    cr.a(this.f70a.getPackageName(), this.f70a, hdVar, geVar, a2.length);
                    m112a.putExtra("mipush_payload", a2);
                    m112a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m112a.putExtra("mipush_app_id", b.m79a(this.f70a).m80a());
                    m112a.putExtra("mipush_app_token", b.m79a(this.f70a).b());
                    c(m112a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = vVar.ordinal();
            obtain.obj = str2;
            obtain.arg1 = ordinal;
            if (hashMap != null && hashMap.get("third_sync_reason") != null) {
                Bundle bundle = new Bundle();
                bundle.putString("third_sync_reason", hashMap.get("third_sync_reason"));
                obtain.setData(bundle);
            }
            this.f72a.sendMessageDelayed(obtain, 5000L);
        }
    }

    public final <T extends hp<T, ?>> void a(T t, ge geVar, gr grVar) {
        a((u) t, geVar, !geVar.equals(ge.Registration), grVar);
    }

    public final <T extends hp<T, ?>> void a(T t, ge geVar, boolean z, gr grVar, boolean z2) {
        a(t, geVar, z, true, grVar, z2);
    }

    public final <T extends hp<T, ?>> void a(T t, ge geVar, boolean z, gr grVar) {
        a(t, geVar, z, true, grVar, true);
    }

    public final <T extends hp<T, ?>> void a(T t, ge geVar, boolean z, boolean z2, gr grVar, boolean z3) {
        a(t, geVar, z, z2, grVar, z3, this.f70a.getPackageName(), b.m79a(this.f70a).m80a());
    }

    public final <T extends hp<T, ?>> void a(T t, ge geVar, boolean z, boolean z2, gr grVar, boolean z3, String str, String str2) {
        a(t, geVar, z, z2, grVar, z3, str, str2, true);
    }

    public final <T extends hp<T, ?>> void a(T t, ge geVar, boolean z, boolean z2, gr grVar, boolean z3, String str, String str2, boolean z4) {
        a(t, geVar, z, z2, grVar, z3, str, str2, z4, true);
    }

    public final <T extends hp<T, ?>> void a(T t, ge geVar, boolean z, boolean z2, gr grVar, boolean z3, String str, String str2, boolean z4, boolean z5) {
        ha b2;
        if (z5 && !b.m79a(this.f70a).m88c()) {
            if (z2) {
                a((u) t, geVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m54a("drop the message before initialization.");
                return;
            }
        }
        if (z4) {
            b2 = r.a(this.f70a, t, geVar, z, str, str2);
        } else {
            b2 = r.b(this.f70a, t, geVar, z, str, str2);
        }
        if (grVar != null) {
            b2.a(grVar);
        }
        byte[] a2 = ho.a(b2);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("send message fail, because msgBytes is null.");
            return;
        }
        cr.a(this.f70a.getPackageName(), this.f70a, t, geVar, a2.length);
        Intent m112a = m112a();
        m112a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m112a.putExtra("mipush_payload", a2);
        m112a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(m112a);
    }

    public final void a(gi giVar) {
        Intent m112a = m112a();
        byte[] a2 = ho.a(giVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m112a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m112a.putExtra("mipush_payload", a2);
        b(m112a);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m124a() {
        return this.f77a && 1 == b.m79a(this.f70a).a();
    }

    public <T extends hp<T, ?>> void a(T t, ge geVar, boolean z) {
        a aVar = new a();
        aVar.f79a = t;
        aVar.a = geVar;
        aVar.f80a = z;
        ArrayList<a> arrayList = f68a;
        synchronized (arrayList) {
            arrayList.add(aVar);
            if (arrayList.size() > 10) {
                arrayList.remove(0);
            }
        }
    }

    public void a(int i) {
        a(i, 0);
    }

    void a(int i, int i2) {
        Intent m112a = m112a();
        m112a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m112a.putExtra(an.F, this.f70a.getPackageName());
        m112a.putExtra(an.G, i);
        m112a.putExtra(an.H, i2);
        c(m112a);
    }

    public void a(String str, String str2) {
        Intent m112a = m112a();
        m112a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m112a.putExtra(an.F, this.f70a.getPackageName());
        m112a.putExtra(an.L, str);
        m112a.putExtra(an.M, str2);
        c(m112a);
    }

    /* renamed from: a, reason: collision with other method in class */
    void m123a(Intent intent) {
        intent.fillIn(m112a(), 24);
        c(intent);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m125a(int i) {
        if (!b.m79a(this.f70a).m86b()) {
            return false;
        }
        c(i);
        hd hdVar = new hd();
        hdVar.a(aj.a());
        hdVar.b(b.m79a(this.f70a).m80a());
        hdVar.d(this.f70a.getPackageName());
        hdVar.c(go.ClientABTest.f529a);
        HashMap hashMap = new HashMap();
        hdVar.f668a = hashMap;
        hashMap.put("boot_mode", i + "");
        a(this.f70a).a((u) hdVar, ge.Notification, false, (gr) null);
        return true;
    }

    private void g() {
        this.f69a = SystemClock.elapsedRealtime();
    }

    /* renamed from: b, reason: collision with other method in class */
    public final void m126b() {
        Intent m112a = m112a();
        m112a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(m112a);
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m128c() {
        if (this.f71a != null) {
            g();
            c(this.f71a);
            this.f71a = null;
        }
    }

    static {
        Covode.recordClassIndex(655321);
        b = false;
        f68a = new ArrayList<>();
    }

    private synchronized int a() {
        return this.f70a.getSharedPreferences("mipush_extra", 0).getInt("service_boot_mode", -1);
    }

    private Intent b() {
        if (!"com.xiaomi.xmsf".equals(this.f70a.getPackageName())) {
            return c();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
        return e();
    }

    private Intent c() {
        if (m124a()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    private Intent d() {
        Intent intent = new Intent();
        String packageName = this.f70a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m115a());
        intent.putExtra("mipush_app_package", packageName);
        h();
        return intent;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f70a.getPackageName();
        i();
        intent.setComponent(new ComponentName(this.f70a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    private void h() {
        try {
            PackageManager packageManager = this.f70a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f70a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable unused) {
        }
    }

    private void i() {
        try {
            PackageManager packageManager = this.f70a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f70a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private Intent m112a() {
        if (m124a() && !"com.xiaomi.xmsf".equals(this.f70a.getPackageName())) {
            return d();
        }
        return e();
    }

    /* renamed from: d, reason: collision with other method in class */
    private boolean m118d() {
        if (m124a()) {
            try {
                if (INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_resource_PackageManagerAop_getPackageInfo(this.f70a.getPackageManager(), "com.xiaomi.xmsf", 4).versionCode >= 108) {
                    return true;
                }
                return false;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    /* renamed from: e, reason: collision with other method in class */
    private boolean m119e() {
        String packageName = this.f70a.getPackageName();
        if (packageName.contains("miui") || packageName.contains("xiaomi") || (this.f70a.getApplicationInfo().flags & 1) != 0) {
            return true;
        }
        return false;
    }

    public void f() {
        Intent m112a = m112a();
        m112a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m112a.putExtra(an.F, this.f70a.getPackageName());
        m112a.putExtra(an.K, az.b(this.f70a.getPackageName()));
        c(m112a);
    }

    /* renamed from: com.xiaomi.mipush.sdk.u$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[v.values().length];
            a = iArr;
            try {
                iArr[v.DISABLE_PUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[v.ENABLE_PUSH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[v.UPLOAD_HUAWEI_TOKEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[v.UPLOAD_FCM_TOKEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[v.UPLOAD_COS_TOKEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[v.UPLOAD_FTOS_TOKEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: e, reason: collision with other method in class */
    public void m130e() {
        String str;
        Intent m112a = m112a();
        m112a.setAction("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION");
        Application application = (Application) av.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        if (application != null && application.getApplicationContext() != null) {
            str = application.getApplicationContext().getPackageName();
        } else {
            str = null;
        }
        String packageName = this.f70a.getPackageName();
        if (!TextUtils.isEmpty(str) && !str.equals(packageName)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("application package name: " + str + ", not equals context package name: " + packageName);
        } else {
            str = packageName;
        }
        m112a.putExtra(an.F, str);
        c(m112a);
    }

    /* renamed from: c, reason: collision with other method in class */
    private boolean m117c() {
        try {
            PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_resource_PackageManagerAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_resource_PackageManagerAop_getPackageInfo(this.f70a.getPackageManager(), "com.xiaomi.xmsf", 4);
            if (INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_resource_PackageManagerAop_getPackageInfo == null) {
                return false;
            }
            if (INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_resource_PackageManagerAop_getPackageInfo.versionCode < 105) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m127b() {
        if (!m124a() || !m119e()) {
            return true;
        }
        if (this.f74a == null) {
            Integer valueOf = Integer.valueOf(ap.a(this.f70a).a());
            this.f74a = valueOf;
            if (valueOf.intValue() == 0) {
                this.f70a.getContentResolver().registerContentObserver(ap.a(this.f70a).m704a(), false, new ContentObserver(new HandlerDelegate(Looper.getMainLooper())) { // from class: com.xiaomi.mipush.sdk.u.3
                    @Override // android.database.ContentObserver
                    public void onChange(boolean z) {
                        u uVar = u.this;
                        uVar.f74a = Integer.valueOf(ap.a(uVar.f70a).a());
                        if (u.this.f74a.intValue() != 0) {
                            u.this.f70a.getContentResolver().unregisterContentObserver(this);
                            if (at.m155a(u.this.f70a)) {
                                u.this.m128c();
                            }
                        }
                    }
                });
            }
        }
        if (this.f74a.intValue() != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: d, reason: collision with other method in class */
    public void m129d() {
        boolean z;
        ArrayList<a> arrayList = f68a;
        synchronized (arrayList) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                z = true;
            } else {
                z = false;
            }
            Iterator<a> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                a(next.f79a, next.a, next.f80a, false, null, true);
                if (!z) {
                    try {
                        ThreadMonitor.sleepMonitor(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            f68a.clear();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private String m115a() {
        String str = this.f78b;
        if (str != null) {
            return str;
        }
        try {
            if (INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_resource_PackageManagerAop_getPackageInfo(this.f70a.getPackageManager(), "com.xiaomi.xmsf", 4).versionCode >= 106) {
                this.f78b = "com.xiaomi.push.service.XMPushService";
                return "com.xiaomi.push.service.XMPushService";
            }
        } catch (Exception unused) {
        }
        this.f78b = "com.xiaomi.xmsf.push.service.XMPushService";
        return "com.xiaomi.xmsf.push.service.XMPushService";
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    private void b(Intent intent) {
        try {
            if (!com.xiaomi.push.j.m630a() && Build.VERSION.SDK_INT >= 26) {
                d(intent);
            } else {
                INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_aop_ContextAop_startService(this.f70a, intent);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private synchronized void c(int i) {
        this.f70a.getSharedPreferences("mipush_extra", 0).edit().putInt("service_boot_mode", i).commit();
    }

    private u(Context context) {
        this.f77a = false;
        this.f72a = null;
        this.f70a = context.getApplicationContext();
        this.f77a = m117c();
        b = m118d();
        this.f72a = new HandlerDelegate(Looper.getMainLooper()) { // from class: com.xiaomi.mipush.sdk.u.1
            public void dispatchMessage(Message message) {
                if (message.what == 19) {
                    String str = (String) message.obj;
                    int i = message.arg1;
                    synchronized (p.class) {
                        if (p.a(u.this.f70a).m109a(str)) {
                            if (p.a(u.this.f70a).a(str) < 10) {
                                String str2 = "";
                                if (message.getData() != null) {
                                    str2 = message.getData().getString("third_sync_reason");
                                }
                                v vVar = v.DISABLE_PUSH;
                                if (vVar.ordinal() == i && "syncing".equals(p.a(u.this.f70a).a(vVar))) {
                                    u.this.a(str, vVar, true, (HashMap<String, String>) null);
                                } else {
                                    v vVar2 = v.ENABLE_PUSH;
                                    if (vVar2.ordinal() == i && "syncing".equals(p.a(u.this.f70a).a(vVar2))) {
                                        u.this.a(str, vVar2, true, (HashMap<String, String>) null);
                                    } else {
                                        v vVar3 = v.UPLOAD_HUAWEI_TOKEN;
                                        if (vVar3.ordinal() == i && "syncing".equals(p.a(u.this.f70a).a(vVar3))) {
                                            HashMap<String, String> m98a = f.m98a(u.this.f70a, d.ASSEMBLE_PUSH_HUAWEI);
                                            m98a.put("third_sync_reason", str2);
                                            u.this.a(str, vVar3, false, m98a);
                                        } else {
                                            v vVar4 = v.UPLOAD_FCM_TOKEN;
                                            if (vVar4.ordinal() == i && "syncing".equals(p.a(u.this.f70a).a(vVar4))) {
                                                u uVar = u.this;
                                                uVar.a(str, vVar4, false, f.m98a(uVar.f70a, d.ASSEMBLE_PUSH_FCM));
                                            } else {
                                                v vVar5 = v.UPLOAD_COS_TOKEN;
                                                if (vVar5.ordinal() == i && "syncing".equals(p.a(u.this.f70a).a(vVar5))) {
                                                    HashMap<String, String> m98a2 = f.m98a(u.this.f70a, d.ASSEMBLE_PUSH_COS);
                                                    m98a2.put("third_sync_reason", str2);
                                                    u.this.a(str, vVar5, false, m98a2);
                                                } else {
                                                    v vVar6 = v.UPLOAD_FTOS_TOKEN;
                                                    if (vVar6.ordinal() == i && "syncing".equals(p.a(u.this.f70a).a(vVar6))) {
                                                        HashMap<String, String> m98a3 = f.m98a(u.this.f70a, d.ASSEMBLE_PUSH_FTOS);
                                                        m98a3.put("third_sync_reason", str2);
                                                        u.this.a(str, vVar6, false, m98a3);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                p.a(u.this.f70a).b(str);
                            } else {
                                p.a(u.this.f70a).c(str);
                            }
                        }
                    }
                }
            }
        };
        if (com.xiaomi.push.j.m631a(context)) {
            com.xiaomi.push.service.g.a(new g.b() { // from class: com.xiaomi.mipush.sdk.u.2
            });
        }
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private void c(Intent intent) {
        boolean z;
        int a2;
        ah a3 = ah.a(this.f70a);
        int a4 = gj.ServiceBootMode.a();
        gf gfVar = gf.START;
        int a5 = a3.a(a4, gfVar.a());
        int a6 = a();
        gf gfVar2 = gf.BIND;
        if (a5 == gfVar2.a() && b) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            a2 = gfVar2.a();
        } else {
            a2 = gfVar.a();
        }
        if (a2 != a6) {
            m125a(a2);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    private synchronized void d(Intent intent) {
        if (this.c) {
            Message a2 = a(intent);
            if (this.f76a.size() >= 50) {
                this.f76a.remove(0);
            }
            this.f76a.add(a2);
            return;
        }
        if (this.f73a == null) {
            INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_aop_ContextAop_bindService(this.f70a, intent, new ServiceConnection() { // from class: com.xiaomi.mipush.sdk.u.4
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    u.this.f73a = null;
                    u.this.c = false;
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    synchronized (u.this) {
                        u.this.f73a = new Messenger(iBinder);
                        u.this.c = false;
                        Iterator it2 = u.this.f76a.iterator();
                        while (it2.hasNext()) {
                            try {
                                u.this.f73a.send((Message) it2.next());
                            } catch (RemoteException e) {
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                            }
                        }
                        u.this.f76a.clear();
                    }
                }
            }, 1);
            this.c = true;
            this.f76a.clear();
            this.f76a.add(a(intent));
        } else {
            try {
                this.f73a.send(a(intent));
            } catch (RemoteException unused) {
                this.f73a = null;
                this.c = false;
            }
        }
    }

    public void b(int i) {
        Intent m112a = m112a();
        m112a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m112a.putExtra(an.F, this.f70a.getPackageName());
        m112a.putExtra(an.I, i);
        m112a.putExtra(an.K, az.b(this.f70a.getPackageName() + i));
        c(m112a);
    }

    public static synchronized u a(Context context) {
        u uVar;
        synchronized (u.class) {
            if (a == null) {
                a = new u(context);
            }
            uVar = a;
        }
        return uVar;
    }

    @Proxy("startService")
    @TargetClass("android.content.Context")
    public static ComponentName INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_aop_ContextAop_startService(Context context, Intent intent) {
        if (!(context instanceof Context)) {
            return context.startService(intent);
        }
        if (lz4.b.a()) {
            lz4.b.b(context, intent);
        } else if (ToolUtils.isMainProcess(App.context()) && c3.g() && NsPushService.IMPL.isInterceptStartPushStart(context, intent)) {
            return null;
        }
        return context.startService(intent);
    }

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
            Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
        }
        x55.b bVar = x55.b.a;
        PackageInfo f = bVar.f(packageName, i);
        if (f != null) {
            return f;
        }
        PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
        Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i, INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
        return INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
    }

    @Proxy("getPackageInfo")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i) {
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
    public static boolean INVOKEVIRTUAL_com_xiaomi_mipush_sdk_u_com_dragon_read_aop_ContextAop_bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
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
