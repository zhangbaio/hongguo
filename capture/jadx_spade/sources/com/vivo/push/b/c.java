package com.vivo.push.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.util.aa;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c extends com.vivo.push.v {
    private String a;
    private String b;
    private long c;
    private int d;
    private int e;
    private String f;
    private String g;
    private String h;

    static {
        Covode.recordClassIndex(654984);
    }

    public final void f() {
        this.f = null;
    }

    @Override // com.vivo.push.v
    public String toString() {
        return "BaseAppCommand";
    }

    public final int e() {
        return this.e;
    }

    public final String g() {
        return this.a;
    }

    public final void b(int i) {
        this.e = i;
    }

    public final void c(String str) {
        this.h = str;
    }

    public final void d(String str) {
        this.g = str;
    }

    public final void b(String str) {
        this.a = str;
    }

    public final int a(Context context) {
        if (this.d == -1) {
            String str = this.b;
            if (TextUtils.isEmpty(str)) {
                com.vivo.push.util.t.a("BaseAppCommand", "pkg name is null");
                str = a();
                if (TextUtils.isEmpty(str)) {
                    com.vivo.push.util.t.a("BaseAppCommand", "src is null");
                    return -1;
                }
            }
            this.d = aa.b(context, str);
            if (!TextUtils.isEmpty(this.f)) {
                this.d = 2;
            }
        }
        return this.d;
    }

    @Override // com.vivo.push.v
    protected void c(com.vivo.push.d dVar) {
        dVar.a("req_id", this.a);
        dVar.a("package_name", this.b);
        dVar.a("sdk_version", 356L);
        dVar.a("PUSH_APP_STATUS", this.d);
        if (!TextUtils.isEmpty(this.f)) {
            dVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f);
        }
        dVar.a("BaseAppCommand.EXTRA_APPID", this.h);
        dVar.a("BaseAppCommand.EXTRA_APPKEY", this.g);
    }

    @Override // com.vivo.push.v
    protected void d(com.vivo.push.d dVar) {
        this.a = dVar.a("req_id");
        this.b = dVar.a("package_name");
        this.c = dVar.b("sdk_version", 0L);
        this.d = dVar.b("PUSH_APP_STATUS", 0);
        this.f = dVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
        this.h = dVar.a("BaseAppCommand.EXTRA_APPID");
        this.g = dVar.a("BaseAppCommand.EXTRA_APPKEY");
    }

    public c(int i, String str) {
        super(i);
        this.c = -1L;
        this.d = -1;
        this.a = null;
        this.b = str;
    }
}
