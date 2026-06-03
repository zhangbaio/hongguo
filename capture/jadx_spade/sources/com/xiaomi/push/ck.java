package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ck implements fe, fj {
    private Context a;

    static {
        Covode.recordClassIndex(655416);
    }

    @Override // com.xiaomi.push.fj
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo244a(fn fnVar) {
        return true;
    }

    public ck(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.fe
    public void a(fn fnVar) {
        cs.b(this.a);
    }

    @Override // com.xiaomi.push.fe
    public void a(eq eqVar) {
        if (eqVar != null && eqVar.a() == 0 && "PING".equals(eqVar.m394a())) {
            cs.d(this.a);
        } else {
            cs.b(this.a);
        }
    }
}
