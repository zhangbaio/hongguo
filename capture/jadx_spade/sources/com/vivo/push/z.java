package com.vivo.push;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class z implements k {
    private y a = new y();
    private y b = new y();
    private com.vivo.push.c.a c;
    private volatile String d;
    private com.vivo.push.restructure.b.a e;

    static {
        Covode.recordClassIndex(655216);
    }

    @Override // com.vivo.push.k
    public final int a() {
        return c();
    }

    @Override // com.vivo.push.k
    public final String b() {
        if (!TextUtils.isEmpty(this.d)) {
            return this.d;
        }
        String d = d();
        if (TextUtils.isEmpty(d)) {
            d = this.e.f();
            t.b(new aa(this, d));
        }
        this.d = d;
        com.vivo.push.util.t.d("SubscribeImpl", "getRegidByCoreSdk code = ".concat(String.valueOf(d)));
        return d;
    }

    private int c() {
        if (!this.c.d()) {
            return 8013;
        }
        if (this.b.a()) {
            com.vivo.push.util.t.d("SubscribeImpl", "isAppSubscribe 两秒内重复调用  ");
            return 1002;
        }
        int i = 1;
        try {
            String a = new e(1, com.vivo.push.restructure.a.a().b().getPackageName(), "", "", com.vivo.push.restructure.a.a().e().f()).a();
            com.vivo.push.util.t.d("SubscribeImpl", "isAppSubscribe parameter = ".concat(String.valueOf(a)));
            String a2 = com.vivo.push.c.a.a(com.vivo.push.restructure.a.a().b(), a);
            com.vivo.push.util.t.d("SubscribeImpl", "isAppSubscribe isSubscribe = ".concat(String.valueOf(a2)));
            if (!TextUtils.isEmpty(a2)) {
                i = 1 ^ (Boolean.parseBoolean(((g) g.a.a(a2)).b()) ? 1 : 0);
            }
        } catch (Exception e) {
            com.vivo.push.util.t.a("SubscribeImpl", "isAppSubscribe", e);
        }
        com.vivo.push.util.t.d("SubscribeImpl", "isAppSubscribe code = ".concat(String.valueOf(i)));
        return i;
    }

    private String d() {
        String str = "";
        if (!this.c.d()) {
            com.vivo.push.util.t.d("SubscribeImpl", "getRegidByCoreSdk 系统不支持查询regid  ");
            return "";
        }
        if (this.a.a()) {
            com.vivo.push.util.t.d("SubscribeImpl", "getRegidByCoreSdk 两秒内重复调用  ");
            return "";
        }
        try {
            String a = new e(2, com.vivo.push.restructure.a.a().b().getPackageName(), "", "", com.vivo.push.restructure.a.a().e().f()).a();
            com.vivo.push.util.t.d("SubscribeImpl", "getRegidByCoreSdk parameter = ".concat(String.valueOf(a)));
            String a2 = com.vivo.push.c.a.a(com.vivo.push.restructure.a.a().b(), a);
            com.vivo.push.util.t.d("SubscribeImpl", "getRegidByCoreSdk isSubscribe = ".concat(String.valueOf(a2)));
            if (!TextUtils.isEmpty(a2)) {
                str = ((g) g.a.a(a2)).b();
            }
        } catch (Exception e) {
            com.vivo.push.util.t.a("SubscribeImpl", "getRegidByCoreSdk", e);
        }
        com.vivo.push.util.t.d("SubscribeImpl", "getRegidByCoreSdk code = ".concat(String.valueOf(str)));
        return str;
    }

    @Override // com.vivo.push.k
    public final void c(String str) {
        d(str);
    }

    private void d(String str) {
        this.d = str;
        this.e.c(this.d);
    }

    @Override // com.vivo.push.k
    public final void a(String str) {
        d(str);
        this.e.d();
        this.e.b();
    }

    @Override // com.vivo.push.k
    public final void b(String str) {
        d(str);
        m.a().e();
        this.e.h();
        this.e.d();
        this.e.b();
    }

    public z(com.vivo.push.c.a aVar, com.vivo.push.restructure.b.a aVar2) {
        this.c = aVar;
        this.e = aVar2;
    }

    @Override // com.vivo.push.k
    public final void a(IPushActionListener iPushActionListener, String str, String str2) {
        if (!this.c.c() && iPushActionListener != null) {
            iPushActionListener.onStateChanged(8012);
        } else {
            m.a().b(iPushActionListener, str, str2);
        }
    }

    @Override // com.vivo.push.k
    public final void a(String str, String str2, String str3) {
        d(str);
        this.e.a(str2);
        this.e.b(str3);
    }
}
