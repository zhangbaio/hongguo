package com.ttnet.org.chromium.base.task;

import android.os.Process;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@JNINamespace("base")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class m implements k {
    private static final ReferenceQueue<Object> j;
    private static final Set<b> k;
    private final o a;
    private final String b;
    private final int c;
    private volatile long d;
    protected final Runnable e;
    private final Object f;
    private boolean g;
    private LinkedList<Runnable> h;
    private List<Pair<Runnable, Long>> i;

    interface a {
        void a(long j);

        void b(long j, Runnable runnable, long j2, String str);

        long c(int i, int i2, boolean z, boolean z2, byte b, byte[] bArr);
    }

    private static class b extends WeakReference<m> {
        final long a;

        static {
            Covode.recordClassIndex(654415);
        }

        void a() {
            n.d().a(this.a);
        }

        b(m mVar) {
            super(mVar, m.j);
            this.a = mVar.d;
        }
    }

    protected void h() {
        PostTask.b().execute(this.e);
    }

    static {
        Covode.recordClassIndex(654413);
        j = new ReferenceQueue<>();
        k = new HashSet();
    }

    private static void d() {
        while (true) {
            b bVar = (b) j.poll();
            if (bVar == null) {
                return;
            }
            bVar.a();
            Set<b> set = k;
            synchronized (set) {
                set.remove(bVar);
            }
        }
    }

    private void f() {
        if (this.g) {
            return;
        }
        this.g = true;
        if (!PostTask.f(this)) {
            e();
        } else {
            this.h = new LinkedList<>();
            this.i = new ArrayList();
        }
    }

    protected void g() {
        TraceEvent k2 = TraceEvent.k(this.b);
        try {
            synchronized (this.f) {
                LinkedList<Runnable> linkedList = this.h;
                if (linkedList == null) {
                    if (k2 != null) {
                        k2.close();
                        return;
                    }
                    return;
                }
                Runnable poll = linkedList.poll();
                int i = this.a.a;
                if (i != 1) {
                    if (i != 2) {
                        Process.setThreadPriority(10);
                    } else {
                        Process.setThreadPriority(-1);
                    }
                } else {
                    Process.setThreadPriority(0);
                }
                poll.run();
                if (k2 != null) {
                    k2.close();
                }
            }
        } catch (Throwable th) {
            if (k2 != null) {
                try {
                    k2.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    void e() {
        a d = n.d();
        int i = this.c;
        o oVar = this.a;
        long c = d.c(i, oVar.a, oVar.b, oVar.c, oVar.d, oVar.e);
        synchronized (this.f) {
            LinkedList<Runnable> linkedList = this.h;
            if (linkedList != null) {
                Iterator<Runnable> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    Runnable next = it2.next();
                    n.d().b(c, next, 0L, next.getClass().getName());
                }
                this.h = null;
            }
            List<Pair<Runnable, Long>> list = this.i;
            if (list != null) {
                for (Pair<Runnable, Long> pair : list) {
                    n.d().b(c, (Runnable) pair.first, ((Long) pair.second).longValue(), pair.getClass().getName());
                }
                this.i = null;
            }
            this.d = c;
        }
        Set<b> set = k;
        synchronized (set) {
            set.add(new b(this));
        }
        d();
    }

    m(o oVar) {
        this(oVar, "TaskRunnerImpl", 0);
        d();
    }

    @Override // com.ttnet.org.chromium.base.task.k
    public void a(Runnable runnable, long j2) {
        if (this.d != 0) {
            n.d().b(this.d, runnable, j2, runnable.getClass().getName());
            return;
        }
        synchronized (this.f) {
            f();
            if (this.d != 0) {
                n.d().b(this.d, runnable, j2, runnable.getClass().getName());
                return;
            }
            if (j2 == 0) {
                this.h.add(runnable);
                h();
            } else {
                this.i.add(new Pair<>(runnable, Long.valueOf(j2)));
            }
        }
    }

    protected m(o oVar, String str, int i) {
        this.e = new Runnable() { // from class: com.ttnet.org.chromium.base.task.l
            @Override // java.lang.Runnable
            public final void run() {
                m.this.g();
            }
        };
        this.f = new Object();
        this.a = oVar.e();
        this.b = str + ".PreNativeTask.run";
        this.c = i;
    }
}
