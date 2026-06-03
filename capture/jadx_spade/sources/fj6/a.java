package fj6;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private int a = -1;
    public int b = -1;
    public int c = -1;
    public long d = -1;
    private final List<C0153a> e = new ArrayList();
    private final List<C0153a> f = new ArrayList();

    static {
        Covode.recordClassIndex(653037);
    }

    public boolean i() {
        if (this.a > 0 && this.b > 0) {
            return true;
        }
        return false;
    }

    public void b() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1L;
        synchronized (this.e) {
            this.e.clear();
        }
        synchronized (this.f) {
            this.f.clear();
        }
    }

    /* renamed from: fj6.a$a, reason: collision with other inner class name */
    public static class C0153a {
        public long a;
        public long b;

        static {
            Covode.recordClassIndex(653038);
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0153a) {
                C0153a c0153a = (C0153a) obj;
                if (this.a == c0153a.a && this.b == c0153a.b) {
                    return true;
                }
            }
            return false;
        }

        public C0153a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }
    }

    public int e(boolean z) {
        List<C0153a> list;
        int i = this.b;
        if (i <= 0) {
            return 0;
        }
        if (z) {
            list = this.e;
        } else {
            list = this.f;
        }
        return g(list, i);
    }

    public long f(boolean z) {
        List<C0153a> list;
        int i = this.b;
        if (i <= 0) {
            return 0L;
        }
        if (z) {
            list = this.e;
        } else {
            list = this.f;
        }
        return h(list, i);
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt("enable", -1);
        this.b = jSONObject.optInt("period", -1);
        this.c = jSONObject.optInt("count", -1);
        this.d = jSONObject.optLong("time", -1L);
    }

    private static int g(List<C0153a> list, int i) {
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        Objects.requireNonNull(list);
        synchronized (list) {
            Iterator<C0153a> it2 = list.iterator();
            i2 = 0;
            while (it2.hasNext()) {
                if (currentTimeMillis - it2.next().b <= i) {
                    i2++;
                }
            }
        }
        return i2;
    }

    private static long h(List<C0153a> list, int i) {
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        Objects.requireNonNull(list);
        synchronized (list) {
            j = 0;
            for (C0153a c0153a : list) {
                if (currentTimeMillis - c0153a.b <= i) {
                    j += c0153a.a;
                }
            }
        }
        return j;
    }

    private static void c(List<C0153a> list, long j, int i) {
        if (list.isEmpty()) {
            return;
        }
        ListIterator<C0153a> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious() && j - listIterator.previous().b > i) {
            listIterator.remove();
        }
    }

    public void a(long j, long j2, boolean z) {
        if (this.b <= 0) {
            return;
        }
        if (z) {
            synchronized (this.e) {
                c(this.e, j2, this.b);
                this.e.add(new C0153a(j, j2));
            }
            return;
        }
        synchronized (this.f) {
            c(this.f, j2, this.b);
            this.f.add(new C0153a(j, j2));
        }
    }
}
