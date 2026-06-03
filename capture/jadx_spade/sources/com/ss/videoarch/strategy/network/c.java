package com.ss.videoarch.strategy.network;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.videoarch.strategy.strategy.networkStrategy.SettingsManager;
import com.ss.videoarch.strategy.strategy.nodeOptimizer.DnsOptimizer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c {
    private final e f;
    private long a = 10000;
    private int b = 5;
    private SettingsManager c = SettingsManager.getInstance();
    private final Set<d> d = new HashSet();
    public Handler e = new HandlerDelegate(Looper.getMainLooper());
    private long g = -1;
    private long h = -1;
    private boolean i = true;
    private boolean j = false;
    private int k = 0;

    public interface d {
        void a(String str);
    }

    static {
        Covode.recordClassIndex(653152);
    }

    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ boolean b;

        @Override // java.lang.Runnable
        public void run() {
            c.this.h(this.a, this.b);
        }

        a(String str, boolean z) {
            this.a = str;
            this.b = z;
        }
    }

    /* renamed from: com.ss.videoarch.strategy.network.c$c, reason: collision with other inner class name */
    class RunnableC0102c implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ boolean b;

        @Override // java.lang.Runnable
        public void run() {
            c.this.e(this.a, this.b);
        }

        RunnableC0102c(String str, boolean z) {
            this.a = str;
            this.b = z;
        }
    }

    class b implements Runnable {
        final /* synthetic */ boolean[] a;
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;

        @Override // java.lang.Runnable
        public void run() {
            c.this.j = false;
            c.this.d(this.a, this.b, this.c);
        }

        b(boolean[] zArr, String str, boolean z) {
            this.a = zArr;
            this.b = str;
            this.c = z;
        }
    }

    public void c(d dVar) {
        this.d.add(dVar);
    }

    public void f(d dVar) {
        this.d.remove(dVar);
    }

    public void e(String str, boolean z) {
        if (this.j) {
            return;
        }
        this.j = true;
        if (z) {
            h(str, z);
        } else {
            this.f.a(new a(str, z));
        }
    }

    c(e eVar, com.ss.videoarch.strategy.network.a aVar) {
        this.f = eVar;
    }

    public void h(String str, boolean z) {
        this.a = lj6.a.m().U;
        this.b = lj6.a.m().T;
        Log.d("VeLSSettingsManager", "INTERVAL:" + this.a + ", retryTimes:" + this.b);
        boolean[] zArr = {false};
        this.h = System.currentTimeMillis();
        SettingsManager.ResponseData sendRequest = this.c.sendRequest(str);
        DnsOptimizer.O().O = sendRequest.statusCode;
        DnsOptimizer.O().N = (int) (System.currentTimeMillis() - this.h);
        sendRequest.responseCost = (int) (System.currentTimeMillis() - this.h);
        zArr[0] = lj6.a.m().k(sendRequest);
        if (z) {
            this.j = false;
            d(zArr, str, z);
        } else {
            this.e.post(new b(zArr, str, z));
        }
    }

    private void g(long j, String str, boolean z) {
        this.e.removeCallbacksAndMessages(null);
        this.e.postDelayed(new RunnableC0102c(str, z), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean[] zArr, String str, boolean z) {
        if (!zArr[0]) {
            int i = this.k + 1;
            this.k = i;
            if (i > this.b) {
                DnsOptimizer.O().Q = true;
                return;
            } else {
                g(this.a, str, z);
                return;
            }
        }
        if (this.i) {
            DnsOptimizer.O().M = (int) (System.currentTimeMillis() - this.g);
            this.i = false;
            if (lj6.a.m().X == 1) {
                g(lj6.a.m().r.e.mHotDomainTTL * 1000, str, z);
            }
        }
        this.k = 0;
        Iterator<d> it2 = this.d.iterator();
        while (it2.hasNext()) {
            it2.next().a(str);
        }
    }
}
