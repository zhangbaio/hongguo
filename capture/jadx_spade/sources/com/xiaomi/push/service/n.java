package com.xiaomi.push.service;

import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class n {
    private static long a;
    private static long b;
    private static long c;

    /* renamed from: a, reason: collision with other field name */
    private final a f990a;

    /* renamed from: a, reason: collision with other field name */
    private final c f991a;

    public n() {
        this(false);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m735a() {
        return this.f991a.m739a();
    }

    static class d {
        int a;

        /* renamed from: a, reason: collision with other field name */
        long f996a;

        /* renamed from: a, reason: collision with other field name */
        b f997a;

        /* renamed from: a, reason: collision with other field name */
        final Object f998a = new Object();

        /* renamed from: a, reason: collision with other field name */
        boolean f999a;
        private long b;

        static {
            Covode.recordClassIndex(655729);
        }

        d() {
        }

        public boolean a() {
            boolean z;
            synchronized (this.f998a) {
                if (!this.f999a && this.f996a > 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.f999a = true;
            }
            return z;
        }

        void a(long j) {
            synchronized (this.f998a) {
                this.b = j;
            }
        }
    }

    private static synchronized long b() {
        long j;
        synchronized (n.class) {
            j = c;
            c = 1 + j;
        }
        return j;
    }

    private static final class c extends Thread {

        /* renamed from: b, reason: collision with other field name */
        private boolean f994b;
        private boolean c;
        private volatile long a = 0;

        /* renamed from: a, reason: collision with other field name */
        private volatile boolean f993a = false;
        private long b = 50;

        /* renamed from: a, reason: collision with other field name */
        private a f992a = new a();

        static {
            Covode.recordClassIndex(655727);
        }

        private static final class a {
            private int a;

            /* renamed from: a, reason: collision with other field name */
            private d[] f995a;
            private int b;
            private int c;

            static {
                Covode.recordClassIndex(655728);
            }

            private a() {
                this.a = 256;
                this.f995a = new d[256];
                this.b = 0;
                this.c = 0;
            }

            public d a() {
                return this.f995a[0];
            }

            public void b() {
                int i = 0;
                while (i < this.b) {
                    if (this.f995a[i].f999a) {
                        this.c++;
                        b(i);
                        i--;
                    }
                    i++;
                }
            }

            private void c() {
                int i = this.b - 1;
                int i2 = (i - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f995a;
                    d dVar = dVarArr[i];
                    long j = dVar.f996a;
                    d dVar2 = dVarArr[i2];
                    if (j < dVar2.f996a) {
                        dVarArr[i] = dVar2;
                        dVarArr[i2] = dVar;
                        int i3 = i2;
                        i2 = (i2 - 1) / 2;
                        i = i3;
                    } else {
                        return;
                    }
                }
            }

            /* renamed from: a, reason: collision with other method in class */
            public void m740a() {
                this.f995a = new d[this.a];
                this.b = 0;
            }

            /* renamed from: a, reason: collision with other method in class */
            public boolean m742a() {
                if (this.b == 0) {
                    return true;
                }
                return false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                int i = 0;
                while (true) {
                    d[] dVarArr = this.f995a;
                    if (i < dVarArr.length) {
                        if (dVarArr[i] == dVar) {
                            return i;
                        }
                        i++;
                    } else {
                        return -1;
                    }
                }
            }

            public void b(int i) {
                int i2;
                if (i >= 0 && i < (i2 = this.b)) {
                    d[] dVarArr = this.f995a;
                    int i3 = i2 - 1;
                    this.b = i3;
                    dVarArr[i] = dVarArr[i3];
                    dVarArr[i3] = null;
                    c(i);
                }
            }

            private void c(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.b;
                    if (i2 < i3 && i3 > 0) {
                        int i4 = i2 + 1;
                        if (i4 < i3) {
                            d[] dVarArr = this.f995a;
                            if (dVarArr[i4].f996a < dVarArr[i2].f996a) {
                                i2 = i4;
                            }
                        }
                        d[] dVarArr2 = this.f995a;
                        d dVar = dVarArr2[i];
                        long j = dVar.f996a;
                        d dVar2 = dVarArr2[i2];
                        if (j >= dVar2.f996a) {
                            dVarArr2[i] = dVar2;
                            dVarArr2[i2] = dVar;
                            int i5 = i2;
                            i2 = (i2 * 2) + 1;
                            i = i5;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }

            public void a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    d dVar = this.f995a[i2];
                    if (dVar.a == i) {
                        dVar.a();
                    }
                }
                b();
            }

            /* renamed from: a, reason: collision with other method in class */
            public void m741a(d dVar) {
                d[] dVarArr = this.f995a;
                int length = dVarArr.length;
                int i = this.b;
                if (length == i) {
                    d[] dVarArr2 = new d[i * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.f995a = dVarArr2;
                }
                d[] dVarArr3 = this.f995a;
                int i2 = this.b;
                this.b = i2 + 1;
                dVarArr3[i2] = dVar;
                c();
            }

            /* renamed from: a, reason: collision with other method in class */
            public boolean m743a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f995a[i2].a == i) {
                        return true;
                    }
                }
                return false;
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    d dVar = this.f995a[i2];
                    if (dVar.f997a == bVar) {
                        dVar.a();
                    }
                }
                b();
            }
        }

        public synchronized void a() {
            this.f994b = true;
            this.f992a.m740a();
            notify();
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m739a() {
            if (this.f993a && SystemClock.uptimeMillis() - this.a > 600000) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0092, code lost:
        
            r10.a = android.os.SystemClock.uptimeMillis();
            r10.f993a = true;
            r2.f997a.run();
            r10.f993a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00a3, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00a4, code lost:
        
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00a5, code lost:
        
            r10.f994b = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00a8, code lost:
        
            throw r1;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 181
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.n.c.run():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            this.f992a.m741a(dVar);
            notify();
        }

        c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }
    }

    private static final class a {
        private final c a;

        static {
            Covode.recordClassIndex(655725);
        }

        protected void finalize() {
            try {
                synchronized (this.a) {
                    this.a.c = true;
                    this.a.notify();
                }
            } finally {
                super.finalize();
            }
        }

        a(c cVar) {
            this.a = cVar;
        }
    }

    static {
        Covode.recordClassIndex(655724);
        long j = 0;
        if (SystemClock.elapsedRealtime() > 0) {
            j = SystemClock.elapsedRealtime();
        }
        a = j;
        b = j;
    }

    static synchronized long a() {
        long j;
        synchronized (n.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = b;
            if (elapsedRealtime > j2) {
                a += elapsedRealtime - j2;
            }
            b = elapsedRealtime;
            j = a;
        }
        return j;
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m737b() {
        synchronized (this.f991a) {
            this.f991a.f992a.m740a();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m734a() {
        com.xiaomi.channel.commonutils.logger.b.m54a("quit. finalizer:" + this.f990a);
        this.f991a.a();
    }

    public static abstract class b implements Runnable {
        protected int a;

        static {
            Covode.recordClassIndex(655726);
        }

        public b(int i) {
            this.a = i;
        }
    }

    public n(String str) {
        this(str, false);
    }

    public n(boolean z) {
        this("Timer-" + b(), z);
    }

    public void a(int i) {
        synchronized (this.f991a) {
            this.f991a.f992a.a(i);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() < 1 && Thread.currentThread() != this.f991a) {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
        bVar.run();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m736a(int i) {
        boolean m743a;
        synchronized (this.f991a) {
            m743a = this.f991a.f992a.m743a(i);
        }
        return m743a;
    }

    public n(String str, boolean z) {
        if (str != null) {
            c cVar = new c(str, z);
            this.f991a = cVar;
            this.f990a = new a(cVar);
            return;
        }
        throw new NullPointerException("name == null");
    }

    private void b(b bVar, long j) {
        synchronized (this.f991a) {
            if (!this.f991a.f994b) {
                long a2 = j + a();
                if (a2 >= 0) {
                    d dVar = new d();
                    dVar.a = bVar.a;
                    dVar.f997a = bVar;
                    dVar.f996a = a2;
                    this.f991a.a(dVar);
                } else {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
                }
            } else {
                throw new IllegalStateException("Timer was canceled");
            }
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f991a) {
            this.f991a.f992a.a(i, bVar);
        }
    }

    public void a(b bVar, long j) {
        if (j >= 0) {
            b(bVar, j);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j);
    }
}
