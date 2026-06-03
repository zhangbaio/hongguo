package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.de;
import com.xiaomi.push.ge;
import com.xiaomi.push.gr;
import com.xiaomi.push.hd;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class i implements de {
    private Context a;

    static {
        Covode.recordClassIndex(655307);
    }

    @Override // com.xiaomi.push.de
    public String a() {
        return b.m79a(this.a).d();
    }

    public i(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.de
    public void a(hd hdVar, ge geVar, gr grVar) {
        u.a(this.a).a((u) hdVar, geVar, grVar);
    }
}
