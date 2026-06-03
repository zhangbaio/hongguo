package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.xiaomi.push.ae;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class fx {
    private static ae a;

    static {
        Covode.recordClassIndex(655542);
        a = new ae(true, 20);
    }

    public static void a(ae.b bVar) {
        a.a(bVar);
    }

    public static void a(final Runnable runnable) {
        a.a(new ae.b() { // from class: com.xiaomi.push.fx.1
            @Override // com.xiaomi.push.ae.b
            public void b() {
                runnable.run();
            }
        });
    }

    public static void a(ae.b bVar, long j) {
        a.a(bVar, j);
    }
}
