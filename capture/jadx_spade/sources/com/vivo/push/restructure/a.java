package com.vivo.push.restructure;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.vivo.push.k;
import com.vivo.push.restructure.a.a.d;
import com.vivo.push.restructure.b.b;
import com.vivo.push.restructure.b.f;
import com.vivo.push.util.z;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    private Context a;
    private com.vivo.push.restructure.c.a b;
    private d c;
    private com.vivo.push.restructure.b.a d;
    private b e;
    private com.vivo.push.c.a f;
    private k g;

    static {
        Covode.recordClassIndex(655103);
    }

    private a() {
    }

    public static a a() {
        return C0127a.a;
    }

    public final com.vivo.push.restructure.c.a c() {
        return this.b;
    }

    public final d d() {
        return this.c;
    }

    public final b f() {
        return this.e;
    }

    public final com.vivo.push.c.a g() {
        return this.f;
    }

    public final k h() {
        return this.g;
    }

    public final synchronized Context b() {
        return this.a;
    }

    public final synchronized com.vivo.push.restructure.b.a e() {
        return this.d;
    }

    /* renamed from: com.vivo.push.restructure.a$a, reason: collision with other inner class name */
    private static class C0127a {
        static a a;

        static {
            Covode.recordClassIndex(655104);
            a = new a((byte) 0);
        }
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public final synchronized void a(Context context) {
        if (context == null) {
            return;
        }
        if (this.a == null) {
            this.a = context;
            this.d = new com.vivo.push.restructure.b.d(new z(context));
            this.b = new com.vivo.push.restructure.c.b(this.d);
            this.c = new d();
            this.e = new f();
            this.f = new com.vivo.push.c.a(context);
            this.g = new com.vivo.push.z(this.f, e());
        }
    }
}
