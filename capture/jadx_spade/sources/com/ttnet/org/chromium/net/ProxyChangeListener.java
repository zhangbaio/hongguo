package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ProxyInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.ProxyChangeListener;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

@JNINamespace("net")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ProxyChangeListener {
    private static boolean f;
    private final Looper a;
    private final Handler b;
    private long c;
    private ProxyReceiver d;
    private BroadcastReceiver e;

    interface b {
        @NativeClassQualifiedName("ProxyConfigServiceAndroid::JNIDelegate")
        void a(long j, ProxyChangeListener proxyChangeListener);

        @NativeClassQualifiedName("ProxyConfigServiceAndroid::JNIDelegate")
        void b(long j, ProxyChangeListener proxyChangeListener, String str, int i, String str2, String[] strArr);
    }

    public static ProxyChangeListener create() {
        return new ProxyChangeListener();
    }

    static {
        Covode.recordClassIndex(654502);
        f = true;
    }

    private boolean j() {
        if (this.a == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public void stop() {
        f();
        this.c = 0L;
        unregisterReceiver();
    }

    private static class c {
        public static final c e;
        public final String a;
        public final int b;
        public final String c;
        public final String[] d;

        static {
            Covode.recordClassIndex(654505);
            e = new c("", 0, "", new String[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c b(ProxyInfo proxyInfo) {
            String str = null;
            if (proxyInfo == null) {
                return null;
            }
            String host = proxyInfo.getHost();
            Uri pacFileUrl = proxyInfo.getPacFileUrl();
            if (host == null) {
                host = "";
            }
            int port = proxyInfo.getPort();
            if (!Uri.EMPTY.equals(pacFileUrl)) {
                str = pacFileUrl.toString();
            }
            return new c(host, port, str, proxyInfo.getExclusionList());
        }

        public c(String str, int i, String str2, String[] strArr) {
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = strArr;
        }
    }

    private ProxyChangeListener() {
        Looper myLooper = Looper.myLooper();
        this.a = myLooper;
        this.b = new HandlerDelegate(myLooper);
    }

    private void f() {
        if (xj6.a.a && !j()) {
            throw new IllegalStateException("Must be called on ProxyChangeListener thread.");
        }
    }

    private void unregisterReceiver() {
        f();
        b(com.ttnet.org.chromium.base.c.f(), this.d);
        if (this.e != null) {
            b(com.ttnet.org.chromium.base.c.f(), this.e);
        }
        this.d = null;
        this.e = null;
    }

    private void registerReceiver() {
        f();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PROXY_CHANGE");
        this.d = new ProxyReceiver();
        if (Build.VERSION.SDK_INT < 23) {
            com.ttnet.org.chromium.base.c.j(com.ttnet.org.chromium.base.c.f(), this.d, intentFilter);
            return;
        }
        com.ttnet.org.chromium.base.c.j(com.ttnet.org.chromium.base.c.f(), this.d, new IntentFilter());
        this.e = new n(this);
        com.ttnet.org.chromium.base.c.j(com.ttnet.org.chromium.base.c.f(), this.e, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ProxyReceiver extends BroadcastReceiver {
        static {
            Covode.recordClassIndex(654506);
        }

        private ProxyReceiver() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Intent intent) {
            ProxyChangeListener.this.k(ProxyChangeListener.g(intent));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent.getAction().equals("android.intent.action.PROXY_CHANGE")) {
                ProxyChangeListener.this.b.postDelayed(new Runnable() { // from class: com.ttnet.org.chromium.net.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProxyChangeListener.ProxyReceiver.this.b(intent);
                    }
                }, 1000L);
            }
        }
    }

    public static String getProperty(String str) {
        return System.getProperty(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(Intent intent) {
        k(h(intent));
    }

    void l(final Intent intent) {
        this.b.postDelayed(new Runnable() { // from class: com.ttnet.org.chromium.net.o
            @Override // java.lang.Runnable
            public final void run() {
                ProxyChangeListener.this.i(intent);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c g(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return c.b((ProxyInfo) extras.get("android.intent.extra.PROXY_INFO"));
        }
        return null;
    }

    public void start(long j) {
        TraceEvent k = TraceEvent.k("ProxyChangeListener.start");
        try {
            f();
            this.c = j;
            registerReceiver();
            if (k != null) {
                k.close();
            }
        } catch (Throwable th) {
            if (k != null) {
                try {
                    k.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private c h(Intent intent) {
        ProxyInfo defaultProxy = ((ConnectivityManager) com.ttnet.org.chromium.base.c.f().getSystemService("connectivity")).getDefaultProxy();
        if (defaultProxy == null) {
            return c.e;
        }
        if (Build.VERSION.SDK_INT < 29 || !"localhost".equals(defaultProxy.getHost()) || defaultProxy.getPort() != -1) {
            return c.b(defaultProxy);
        }
        return g(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(c cVar) {
        f();
        if (!f || this.c == 0) {
            return;
        }
        if (cVar != null) {
            q.c().b(this.c, this, cVar.a, cVar.b, cVar.c, cVar.d);
        } else {
            q.c().a(this.c, this);
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static void b(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}
