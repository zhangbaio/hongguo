package com.ttnet.org.chromium.net.impl;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.c0;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class x extends c0.a {
    private static final String q;
    private final CronetEngineBase a;
    private final c0.b b;
    private final Executor c;
    private List<String> d;
    private int e;
    private String f;
    private long g;
    private int h;
    private long i;
    private String j;
    private int k;
    private String l;
    private Map<String, String> m;
    private Map<String, String> n;
    private boolean o = true;
    private boolean p = true;

    static {
        Covode.recordClassIndex(654660);
        q = x.class.getSimpleName();
    }

    @Override // com.ttnet.org.chromium.net.c0.a
    public c0 a() {
        if (this.p) {
            return this.a.Y(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
        }
        return this.a.Z(this.b, this.c, this.d, this.m, this.n, this.o);
    }

    @Override // com.ttnet.org.chromium.net.c0.a
    public c0.a b(int i) {
        this.e = i;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.c0.a
    public c0.a c(String str) {
        this.f = str;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.c0.a
    public c0.a d(int i) {
        this.k = i;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.c0.a
    public c0.a e(Map<String, String> map) {
        this.n = map;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.c0.a
    public c0.a f(Map<String, String> map) {
        this.m = map;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.c0.a
    public c0.a g(long j) {
        this.g = j;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.c0.a
    public c0.a h(int i) {
        this.h = i;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.c0.a
    public c0.a i(long j) {
        this.i = j;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.c0.a
    public c0.a j(String str) {
        this.j = str;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.c0.a
    public c0.a k(boolean z) {
        this.o = z;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.c0.a
    public c0.a l(List<String> list) {
        this.d = list;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.c0.a
    public c0.a m(boolean z) {
        this.p = z;
        return this;
    }

    x(c0.b bVar, Executor executor, CronetEngineBase cronetEngineBase) {
        Log.e(q, "TTWebsocketConnectionBuilderImpl");
        this.a = cronetEngineBase;
        this.b = bVar;
        this.c = executor;
    }
}
