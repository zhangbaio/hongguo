package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class URLDispatch {
    private static final String g;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    private com.ttnet.org.chromium.net.urlconnection.g f = new com.ttnet.org.chromium.net.urlconnection.g();

    public void a() {
        this.f.quit();
    }

    static {
        Covode.recordClassIndex(654661);
        g = URLDispatch.class.getSimpleName();
    }

    public URLDispatch(String str) {
        this.a = str;
    }

    public void c(int i) throws IOException {
        com.ttnet.org.chromium.net.urlconnection.g gVar = this.f;
        if (i <= 0) {
            i = 300;
        }
        gVar.a(i);
    }

    public void b(Runnable runnable) {
        try {
            this.f.execute(runnable);
        } catch (RejectedExecutionException e) {
            com.ttnet.org.chromium.base.h.b(g, "Exception URLDispatch resume ", e);
        }
    }

    public void setResult(String str, String str2, String str3, String str4) {
        this.b = str;
        this.d = str2;
        this.c = str3;
        this.e = str4;
    }
}
