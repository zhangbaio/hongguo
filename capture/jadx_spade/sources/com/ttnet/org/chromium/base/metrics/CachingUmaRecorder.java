package com.ttnet.org.chromium.base.metrics;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class CachingUmaRecorder implements b {
    private final ReentrantReadWriteLock a = new ReentrantReadWriteLock(false);
    private Map<String, Histogram> b = new HashMap();
    private AtomicInteger c = new AtomicInteger();
    private List<Object> d = new ArrayList();
    private b e;

    static class Histogram {
        private final int a;
        private final String b;
        private final int c;
        private final int d;
        private final int e;
        private final List<Integer> f = new ArrayList(1);

        @Retention(RetentionPolicy.SOURCE)
        @interface Type {
        }

        static {
            Covode.recordClassIndex(654363);
        }

        Histogram(int i, String str, int i2, int i3, int i4) {
            this.a = i;
            this.b = str;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        synchronized boolean a(int i, String str, int i2, int i3, int i4, int i5) {
            if (this.f.size() >= 256) {
                return false;
            }
            this.f.add(Integer.valueOf(i2));
            return true;
        }
    }

    static {
        Covode.recordClassIndex(654362);
    }

    CachingUmaRecorder() {
    }

    @Override // com.ttnet.org.chromium.base.metrics.b
    public void b(String str, int i) {
        f(4, str, i, 0, 0, 0);
    }

    @Override // com.ttnet.org.chromium.base.metrics.b
    public void c(String str, boolean z) {
        f(1, str, z ? 1 : 0, 0, 0, 0);
    }

    @Override // com.ttnet.org.chromium.base.metrics.b
    public void a(String str, int i, int i2, int i3, int i4) {
        f(3, str, i, i2, i3, i4);
    }

    @Override // com.ttnet.org.chromium.base.metrics.b
    public void d(String str, int i, int i2, int i3, int i4) {
        f(2, str, i, i2, i3, i4);
    }

    private void e(int i, String str, int i2, int i3, int i4, int i5) {
        Histogram histogram = this.b.get(str);
        if (histogram == null) {
            if (this.b.size() >= 256) {
                this.c.incrementAndGet();
                return;
            } else {
                Histogram histogram2 = new Histogram(i, str, i3, i4, i5);
                this.b.put(str, histogram2);
                histogram = histogram2;
            }
        }
        if (!histogram.a(i, str, i2, i3, i4, i5)) {
            this.c.incrementAndGet();
        }
    }

    private void f(int i, String str, int i2, int i3, int i4, int i5) {
        if (h(i, str, i2, i3, i4, i5)) {
            return;
        }
        this.a.writeLock().lock();
        try {
            if (this.e == null) {
                e(i, str, i2, i3, i4, i5);
                return;
            }
            this.a.readLock().lock();
            try {
                g(i, str, i2, i3, i4, i5);
            } finally {
                this.a.readLock().unlock();
            }
        } finally {
            this.a.writeLock().unlock();
        }
    }

    private void g(int i, String str, int i2, int i3, int i4, int i5) {
        boolean z = true;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        this.e.b(str, i2);
                        return;
                    }
                    throw new UnsupportedOperationException("Unknown histogram type " + i);
                }
                this.e.a(str, i2, i3, i4, i5);
                return;
            }
            this.e.d(str, i2, i3, i4, i5);
            return;
        }
        b bVar = this.e;
        if (i2 == 0) {
            z = false;
        }
        bVar.c(str, z);
    }

    private boolean h(int i, String str, int i2, int i3, int i4, int i5) {
        this.a.readLock().lock();
        try {
            if (this.e != null) {
                g(i, str, i2, i3, i4, i5);
            } else {
                Histogram histogram = this.b.get(str);
                if (histogram == null) {
                    this.a.readLock().unlock();
                    return false;
                }
                if (!histogram.a(i, str, i2, i3, i4, i5)) {
                    this.c.incrementAndGet();
                }
            }
            return true;
        } finally {
            this.a.readLock().unlock();
        }
    }
}
