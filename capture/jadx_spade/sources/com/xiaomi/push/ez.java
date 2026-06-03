package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class ez {
    private static final AtomicInteger a;

    /* renamed from: a, reason: collision with other field name */
    public static boolean f426a;

    /* renamed from: a, reason: collision with other field name */
    protected fa f429a;

    /* renamed from: a, reason: collision with other field name */
    protected XMPushService f431a;

    /* renamed from: a, reason: collision with other field name */
    protected int f427a = 0;

    /* renamed from: a, reason: collision with other field name */
    protected long f428a = -1;

    /* renamed from: b, reason: collision with other field name */
    protected volatile long f436b = 0;

    /* renamed from: c, reason: collision with other field name */
    protected volatile long f439c = 0;

    /* renamed from: a, reason: collision with other field name */
    private LinkedList<Pair<Integer, Long>> f434a = new LinkedList<>();

    /* renamed from: a, reason: collision with other field name */
    private final Collection<fc> f433a = new CopyOnWriteArrayList();

    /* renamed from: a, reason: collision with other field name */
    protected final Map<fe, a> f435a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with other field name */
    protected final Map<fe, a> f438b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with other field name */
    protected fi f430a = null;

    /* renamed from: a, reason: collision with other field name */
    protected String f432a = "";

    /* renamed from: b, reason: collision with other field name */
    protected String f437b = "";
    private int c = 2;
    protected final int b = a.getAndIncrement();
    private long e = 0;
    protected long d = 0;

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    public abstract void a(fn fnVar);

    public abstract void a(am.b bVar);

    public abstract void a(String str, String str2);

    public abstract void a(eq[] eqVarArr);

    /* renamed from: a */
    public boolean mo411a() {
        return false;
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(eq eqVar);

    public abstract void b(boolean z);

    public int a() {
        return this.f427a;
    }

    public int b() {
        return this.c;
    }

    public void a(fe feVar, fj fjVar) {
        if (feVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f435a.put(feVar, new a(feVar, fjVar));
    }

    public synchronized void a(String str) {
        if (this.c == 0) {
            com.xiaomi.channel.commonutils.logger.b.m54a("setChallenge hash = " + az.a(str).substring(0, 8));
            this.f432a = str;
            a(1, 0, null);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m54a("ignore setChallenge because connection was disconnected");
        }
    }

    public synchronized boolean a(long j) {
        return this.e >= j;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m416a() {
        return this.f439c;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m420b() {
        return this.f429a.b();
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m423c() {
        if (this.c == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public fa m417a() {
        return this.f429a;
    }

    public synchronized void c() {
        this.e = SystemClock.elapsedRealtime();
    }

    public void d() {
        synchronized (this.f434a) {
            this.f434a.clear();
        }
    }

    static {
        Covode.recordClassIndex(655512);
        a = new AtomicInteger(0);
        f426a = false;
        try {
            f426a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        ff.m427a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String mo418a() {
        return this.f429a.c();
    }

    /* renamed from: b, reason: collision with other method in class */
    protected void m421b() {
        String str;
        if (this.f429a.m425a() && this.f430a == null) {
            Class cls = null;
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = l3.a.q(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (cls == null) {
                this.f430a = new ey(this);
                return;
            }
            try {
                this.f430a = (fi) cls.getConstructor(ez.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    protected Map<fe, a> m419a() {
        return this.f435a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m422b() {
        if (this.c == 0) {
            return true;
        }
        return false;
    }

    public static class a {
        private fe a;

        /* renamed from: a, reason: collision with other field name */
        private fj f440a;

        static {
            Covode.recordClassIndex(655513);
        }

        public void a(eq eqVar) {
            this.a.a(eqVar);
        }

        public void a(fn fnVar) {
            fj fjVar = this.f440a;
            if (fjVar == null || fjVar.mo244a(fnVar)) {
                this.a.a(fnVar);
            }
        }

        public a(fe feVar, fj fjVar) {
            this.a = feVar;
            this.f440a = fjVar;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private void m415a(int i) {
        synchronized (this.f434a) {
            if (i == 1) {
                this.f434a.clear();
            } else {
                this.f434a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f434a.size() > 6) {
                    this.f434a.remove(0);
                }
            }
        }
    }

    public void b(fc fcVar) {
        this.f433a.remove(fcVar);
    }

    public void b(fe feVar) {
        this.f438b.remove(feVar);
    }

    public void a(fc fcVar) {
        if (fcVar != null && !this.f433a.contains(fcVar)) {
            this.f433a.add(fcVar);
        }
    }

    public void a(fe feVar) {
        this.f435a.remove(feVar);
    }

    protected ez(XMPushService xMPushService, fa faVar) {
        this.f429a = faVar;
        this.f431a = xMPushService;
        m421b();
    }

    public void b(fe feVar, fj fjVar) {
        if (feVar != null) {
            this.f438b.put(feVar, new a(feVar, fjVar));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    public void a(int i, int i2, Exception exc) {
        Exception exc2;
        int i3 = this.c;
        if (i != i3) {
            com.xiaomi.channel.commonutils.logger.b.m54a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i3), a(i), com.xiaomi.push.service.an.a(i2)));
        }
        if (at.m155a((Context) this.f431a)) {
            m415a(i);
        }
        if (i == 1) {
            this.f431a.a(10);
            if (this.c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m54a("try set connected while not connecting.");
            }
            this.c = i;
            Iterator<fc> it2 = this.f433a.iterator();
            while (it2.hasNext()) {
                it2.next().b(this);
            }
            return;
        }
        if (i == 0) {
            if (this.c != 2) {
                com.xiaomi.channel.commonutils.logger.b.m54a("try set connecting while not disconnected.");
            }
            this.c = i;
            Iterator<fc> it4 = this.f433a.iterator();
            while (it4.hasNext()) {
                it4.next().a(this);
            }
            return;
        }
        if (i == 2) {
            this.f431a.a(10);
            int i4 = this.c;
            if (i4 == 0) {
                for (fc fcVar : this.f433a) {
                    if (exc == null) {
                        exc2 = new CancellationException("disconnect while connecting");
                    } else {
                        exc2 = exc;
                    }
                    fcVar.a(this, exc2);
                }
            } else if (i4 == 1) {
                Iterator<fc> it5 = this.f433a.iterator();
                while (it5.hasNext()) {
                    it5.next().a(this, i2, exc);
                }
            }
            this.c = i;
        }
    }
}
