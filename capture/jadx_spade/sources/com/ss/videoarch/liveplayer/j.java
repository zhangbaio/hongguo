package com.ss.videoarch.liveplayer;

import com.bytedance.covode.number.Covode;
import com.ss.videoarch.liveplayer.k;
import com.ss.videoarch.liveplayer.l;
import com.ss.videoarch.strategy.strategy.networkStrategy.LSPreconnManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class j {
    private fj6.c a;
    private final Object b;
    private HashMap<String, d> c;
    private LSPreconnManager.e d;

    public interface c {
        void a(String str, String str2, String str3, String str4, k.a aVar);
    }

    static {
        Covode.recordClassIndex(652937);
    }

    private static class e {
        private static final j a;

        static {
            Covode.recordClassIndex(652940);
            a = new j(null);
        }
    }

    public static j d() {
        return e.a;
    }

    private j() {
        this.a = null;
        this.b = new Object();
        this.c = new HashMap<>();
        this.d = new a();
        LSPreconnManager.h().h = this.d;
    }

    /* synthetic */ j(a aVar) {
        this();
    }

    class a implements LSPreconnManager.e {
        a() {
        }

        @Override // com.ss.videoarch.strategy.strategy.networkStrategy.LSPreconnManager.e
        public void a(LSPreconnManager.e.a aVar) {
            if (j.this.a == null) {
                return;
            }
            com.ss.videoarch.liveplayer.log.a.c("VLDNSParse", "PreconnResultCallBack, host: " + aVar.a + "ip: " + aVar.c + " ret: " + aVar.b);
            j.this.a.Zf = aVar.b;
            j.this.a.ag = aVar.a;
            j.this.a.bg = aVar.c;
        }
    }

    class b implements l.b {
        b() {
        }

        @Override // com.ss.videoarch.liveplayer.l.b
        public void a(String str, String str2, String str3, String str4, k.a aVar) {
            if (!j.this.c.containsKey(str4)) {
                com.ss.videoarch.liveplayer.log.a.b("VLDNSParse", "No host record: " + str4);
                return;
            }
            List<c> list = ((d) j.this.c.get(str4)).b;
            for (int i = 0; i < list.size(); i++) {
                c cVar = list.get(i);
                if (cVar != null) {
                    cVar.a(str, str2, str3, str4, aVar);
                }
            }
            j.this.g(str4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        if (!this.c.containsKey(str)) {
            return;
        }
        this.c.get(str).b.clear();
    }

    private void f(String str, c cVar) {
        if (!this.c.containsKey(str)) {
            return;
        }
        this.c.get(str).b.add(cVar);
    }

    public void e(k kVar, c cVar) {
        l lVar;
        l.b bVar;
        if (this.a == null) {
            this.a = kVar.c.b;
        }
        String str = kVar.b;
        synchronized (this.b) {
            if (this.c.containsKey(str)) {
                f(str, cVar);
                lVar = this.c.get(str).a;
                bVar = lVar.b;
            } else {
                com.ss.videoarch.liveplayer.log.a.c("VLDNSParse", "New for: " + str + "-->" + this.c.size());
                l lVar2 = new l();
                b bVar2 = new b();
                this.c.put(str, new d(lVar2, cVar));
                lVar = lVar2;
                bVar = bVar2;
            }
        }
        lVar.p(kVar, bVar);
        if (com.ss.videoarch.liveplayer.utils.b.g()) {
            com.ss.videoarch.liveplayer.utils.b.c(lVar);
        } else {
            com.ss.videoarch.liveplayer.utils.c.d(lVar);
        }
    }

    private class d {
        l a;
        List<c> b;

        static {
            Covode.recordClassIndex(652939);
        }

        d(l lVar, c cVar) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            this.a = lVar;
            arrayList.add(cVar);
        }
    }
}
