package com.ttnet.org.chromium.base;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.p;

@JNINamespace("base::android")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PowerMonitor implements p.c {
    private static PowerMonitor b;
    private static final String c;
    private static p d;
    private static b e;
    private static String f;
    private static String g;
    private static String h;
    private static String i;
    private static String j;
    private static long k;
    private static long l;
    private static boolean m;
    private boolean a;

    interface c {
        void a();

        void b();

        void c();

        void d();

        void onResume();
    }

    private PowerMonitor() {
    }

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PowerMonitor.p(intent.getAction().equals("android.intent.action.ACTION_POWER_DISCONNECTED"));
        }
    }

    @Override // com.ttnet.org.chromium.base.p.c
    public void c() {
        m.e().c();
    }

    @Override // com.ttnet.org.chromium.base.p.c
    public void d() {
        m.e().a();
    }

    private static int getRemainingBatteryCapacity() {
        if (b == null) {
            n();
        }
        return o();
    }

    private static boolean isBatteryPower() {
        if (b == null) {
            n();
        }
        return b.a;
    }

    static {
        Covode.recordClassIndex(654245);
        c = PowerMonitor.class.getSimpleName();
        d = new p();
    }

    private static int o() {
        return ((BatteryManager) com.ttnet.org.chromium.base.c.f().getSystemService("batterymanager")).getIntProperty(1);
    }

    private static int getCurrentThermalStatus() {
        if (Build.VERSION.SDK_INT < 29) {
            return -1;
        }
        if (b == null) {
            n();
        }
        PowerManager powerManager = (PowerManager) com.ttnet.org.chromium.base.c.f().getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        return vj6.e.a(powerManager);
    }

    @Override // com.ttnet.org.chromium.base.p.c
    public void a() {
        Context f2 = com.ttnet.org.chromium.base.c.f();
        if (q.f(f2)) {
            Intent intent = new Intent();
            intent.setAction(g);
            if (!TextUtils.isEmpty(j)) {
                intent.setPackage(j);
            }
            try {
                f2.sendBroadcast(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        m.e().d();
    }

    @Override // com.ttnet.org.chromium.base.p.c
    public void b() {
        Context f2 = com.ttnet.org.chromium.base.c.f();
        if (q.f(f2)) {
            Intent intent = new Intent();
            intent.setAction(f);
            if (!TextUtils.isEmpty(j)) {
                intent.setPackage(j);
            }
            try {
                f2.sendBroadcast(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        m.e().onResume();
    }

    public static void n() {
        if (b != null) {
            return;
        }
        Context f2 = com.ttnet.org.chromium.base.c.f();
        b = new PowerMonitor();
        Intent j2 = com.ttnet.org.chromium.base.c.j(f2, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (j2 != null) {
            boolean z = false;
            if (j2.getIntExtra("plugged", 0) == 0) {
                z = true;
            }
            p(z);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        com.ttnet.org.chromium.base.c.j(f2, new a(), intentFilter);
        j = f2.getPackageName();
        g = j + ".cronet.APP_BACKGROUND";
        f = j + ".cronet.APP_FOREGROUND";
        i = j + ".wschannel.APP_BACKGROUND";
        h = j + ".wschannel.APP_FOREGROUND";
        if (!q.f(f2) && !m) {
            e = new b();
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction(g);
            intentFilter2.addAction(f);
            intentFilter2.addAction(i);
            intentFilter2.addAction(h);
            com.ttnet.org.chromium.base.c.j(f2, e, intentFilter2);
            return;
        }
        if (f2 instanceof Application) {
            p pVar = d;
            pVar.b = b;
            ((Application) f2).registerActivityLifecycleCallbacks(pVar);
        }
    }

    public static void q(boolean z) {
        m = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(boolean z) {
        b.a = z;
        m.e().b();
    }

    public static class b extends BroadcastReceiver {
        static {
            Covode.recordClassIndex(654246);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long currentTimeMillis = System.currentTimeMillis();
            String action = intent.getAction();
            if (!action.equals(PowerMonitor.f) && !action.equals(PowerMonitor.h)) {
                if (action.equals(PowerMonitor.g) || action.equals(PowerMonitor.i)) {
                    long j = currentTimeMillis - PowerMonitor.l;
                    long unused = PowerMonitor.l = currentTimeMillis;
                    if (j > 10000) {
                        m.e().d();
                        return;
                    }
                    return;
                }
                return;
            }
            long j2 = currentTimeMillis - PowerMonitor.k;
            long unused2 = PowerMonitor.k = currentTimeMillis;
            if (j2 > 10000) {
                m.e().onResume();
            }
        }
    }
}
