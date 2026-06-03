package com.xiaomi.push;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class df {
    private static volatile df a;

    /* renamed from: a, reason: collision with other field name */
    private de f258a;

    static {
        Covode.recordClassIndex(655441);
    }

    /* renamed from: a, reason: collision with other method in class */
    public de m273a() {
        return this.f258a;
    }

    public static df a() {
        if (a == null) {
            synchronized (df.class) {
                if (a == null) {
                    a = new df();
                }
            }
        }
        return a;
    }

    public void a(de deVar) {
        this.f258a = deVar;
    }
}
