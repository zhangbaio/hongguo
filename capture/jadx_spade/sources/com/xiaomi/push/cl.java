package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class cl implements fe, fj {
    private Context a;

    static {
        Covode.recordClassIndex(655417);
    }

    @Override // com.xiaomi.push.fj
    /* renamed from: a */
    public boolean mo244a(fn fnVar) {
        return true;
    }

    public cl(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.fe
    public void a(fn fnVar) {
        cs.a(this.a);
    }

    @Override // com.xiaomi.push.fe
    public void a(eq eqVar) {
        if (eqVar != null && eqVar.a() == 0 && "PING".equals(eqVar.m394a())) {
            cs.c(this.a);
        } else {
            cs.a(this.a);
        }
    }
}
