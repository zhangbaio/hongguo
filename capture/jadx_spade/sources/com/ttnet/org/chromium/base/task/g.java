package com.ttnet.org.chromium.base.task;

import android.view.Choreographer;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.ThreadUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class g implements j {
    private final Map<o, k> a = new HashMap();

    static {
        Covode.recordClassIndex(654400);
    }

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c e() throws Exception {
        return new c(Choreographer.getInstance());
    }

    private synchronized c c() {
        return (c) ThreadUtils.j(new Callable() { // from class: com.ttnet.org.chromium.base.task.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                c e;
                e = g.e();
                return e;
            }
        });
    }

    public k d(o oVar) {
        if (oVar.f) {
            return c();
        }
        return new m(oVar);
    }

    @Override // com.ttnet.org.chromium.base.task.j
    public synchronized void a(o oVar, Runnable runnable, long j) {
        if (oVar.a()) {
            d(oVar).a(runnable, j);
        } else {
            k kVar = this.a.get(oVar);
            if (kVar == null) {
                kVar = d(oVar);
                this.a.put(oVar, kVar);
            }
            kVar.a(runnable, j);
        }
    }
}
