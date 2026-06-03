package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.app.launch.task.c3;
import com.dragon.read.component.biz.api.NsPushService;
import com.ss.android.common.util.ToolUtils;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.vivo.push.util.ah;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i implements ServiceConnection {
    private static final Object a;
    private static Map<String, i> b;
    private boolean c;
    private String d;
    private Context e;
    private volatile IPCInvoke g;
    private String i;
    private Handler j;
    private Object h = new Object();
    private AtomicInteger f = new AtomicInteger(1);

    private void e() {
        this.j.removeMessages(1);
    }

    private void d() {
        this.j.removeMessages(1);
        this.j.sendEmptyMessageDelayed(1, 3000L);
    }

    static {
        Covode.recordClassIndex(655081);
        a = new Object();
        b = new HashMap();
    }

    private boolean c() {
        Intent intent = new Intent(this.i);
        intent.setPackage(this.d);
        try {
            return INVOKEVIRTUAL_com_vivo_push_i_com_dragon_read_aop_ContextAop_bindService(this.e, intent, this, 1);
        } catch (Exception e) {
            com.vivo.push.util.t.a("AidlManager", "bind core error", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            this.e.unbindService(this);
        } catch (Exception e) {
            com.vivo.push.util.t.a("AidlManager", "On unBindServiceException:" + e.getMessage());
        }
    }

    private void b() {
        int i = this.f.get();
        com.vivo.push.util.t.d("AidlManager", "Enter connect, Connection Status: ".concat(String.valueOf(i)));
        if (i != 4 && i != 2 && i != 3 && i != 5 && this.c) {
            a(2);
            if (!c()) {
                a(1);
                com.vivo.push.util.t.a("AidlManager", "bind core service fail");
            } else {
                d();
            }
        }
    }

    public final boolean a() {
        String a2 = com.vivo.push.util.aa.a(this.e);
        this.d = a2;
        boolean z = false;
        if (TextUtils.isEmpty(a2)) {
            com.vivo.push.util.t.c(this.e, "push pkgname is null");
            return false;
        }
        if (ah.a(this.e, this.d) >= 1260) {
            z = true;
        }
        this.c = z;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.f.set(i);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.g = null;
        a(1);
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        com.vivo.push.util.t.b("AidlManager", "onBindingDied : ".concat(String.valueOf(componentName)));
    }

    public final boolean a(Bundle bundle) {
        b();
        if (this.f.get() == 2) {
            synchronized (this.h) {
                try {
                    this.h.wait(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            int i = this.f.get();
            if (i == 4) {
                this.j.removeMessages(2);
                this.j.sendEmptyMessageDelayed(2, 30000L);
                this.g.asyncCall(bundle, null);
                return true;
            }
            com.vivo.push.util.t.d("AidlManager", "invoke error : connect status = ".concat(String.valueOf(i)));
            return false;
        } catch (Exception e2) {
            com.vivo.push.util.t.a("AidlManager", "invoke error ", e2);
            int i2 = this.f.get();
            com.vivo.push.util.t.d("AidlManager", "Enter disconnect, Connection Status: ".concat(String.valueOf(i2)));
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        a(1);
                        f();
                        return false;
                    }
                    return false;
                }
                a(1);
                return false;
            }
            e();
            a(1);
            return false;
        }
    }

    public static i a(Context context, String str) {
        i iVar;
        i iVar2 = b.get(str);
        if (iVar2 == null) {
            synchronized (a) {
                iVar = b.get(str);
                if (iVar == null) {
                    iVar = new i(context, str);
                    b.put(str, iVar);
                }
            }
            return iVar;
        }
        return iVar2;
    }

    private i(Context context, String str) {
        this.d = null;
        this.j = null;
        this.e = context;
        this.i = str;
        this.j = new HandlerDelegate(Looper.getMainLooper(), new j(this));
        String a2 = com.vivo.push.util.aa.a(context);
        this.d = a2;
        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(this.i)) {
            this.c = ah.a(context, this.d) >= 1260;
            b();
            return;
        }
        com.vivo.push.util.t.c(this.e, "init error : push pkgname is " + this.d + " ; action is " + this.i);
        this.c = false;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e();
        this.g = IPCInvoke.Stub.asInterface(iBinder);
        if (this.g == null) {
            com.vivo.push.util.t.d("AidlManager", "onServiceConnected error : aidl must not be null.");
            f();
            this.f.set(1);
            return;
        }
        if (this.f.get() == 2) {
            a(4);
        } else if (this.f.get() != 4) {
            f();
        }
        synchronized (this.h) {
            this.h.notifyAll();
        }
    }

    @Proxy("bindService")
    @TargetClass("android.content.Context")
    public static boolean INVOKEVIRTUAL_com_vivo_push_i_com_dragon_read_aop_ContextAop_bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
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
