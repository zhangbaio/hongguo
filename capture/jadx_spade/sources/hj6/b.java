package hj6;

import com.bytedance.covode.number.Covode;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    private static int c;
    private static String d;
    private static b e;
    private ConcurrentHashMap<String, a> a = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, List<String>> b = new ConcurrentHashMap<>();

    static class a {
        public String a;
        public long b;
        public boolean c;

        static {
            Covode.recordClassIndex(653075);
        }

        a() {
        }
    }

    public int d() {
        return c;
    }

    static {
        Covode.recordClassIndex(653074);
        c = -1;
        d = null;
    }

    public void a() {
        ConcurrentHashMap<String, a> concurrentHashMap = this.a;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.b.clear();
        }
    }

    private b() {
    }

    public static b e() {
        if (e == null) {
            synchronized (b.class) {
                if (e == null) {
                    e = new b();
                }
            }
        }
        return e;
    }

    public void i(int i) {
        c = i;
    }

    public a c(String str) {
        ConcurrentHashMap<String, a> concurrentHashMap = this.a;
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(str);
        }
        return null;
    }

    public List<String> f(String str) {
        ConcurrentHashMap<String, List<String>> concurrentHashMap = this.b;
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(str);
        }
        return null;
    }

    public void b(String str) {
        a aVar;
        if (str == null) {
            return;
        }
        ConcurrentHashMap<String, a> concurrentHashMap = this.a;
        if (concurrentHashMap != null) {
            aVar = concurrentHashMap.get(str);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.c = true;
        }
    }

    public void g(String str, a aVar) {
        ConcurrentHashMap<String, a> concurrentHashMap = this.a;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(str, aVar);
        }
    }

    public void h(String str, List<String> list) {
        ConcurrentHashMap<String, List<String>> concurrentHashMap = this.b;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(str, list);
        }
    }
}
