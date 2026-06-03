package com.ttnet.org.chromium.net.impl;

import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.e0;
import com.ttnet.org.chromium.net.g;
import com.ttnet.org.chromium.net.g0;
import com.ttnet.org.chromium.net.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class y extends g.a {
    private static final String y;
    private final CronetEngineBase a;
    private final String b;
    private final g0.b c;
    private final Executor d;
    private String e;
    private boolean g;
    private boolean h;
    private Collection<Object> j;
    private e0 k;
    private Executor l;
    private boolean m;
    private boolean n;
    private int o;
    private boolean p;
    private int q;
    private t.a r;
    private int u;
    private int v;
    private int w;
    private int x;
    private final ArrayList<Pair<String, String>> f = new ArrayList<>();
    private int i = 3;
    private long s = -1;
    private int t = 0;

    @Override // com.ttnet.org.chromium.net.g.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public y g() {
        this.g = true;
        return this;
    }

    static {
        Covode.recordClassIndex(654664);
        y = y.class.getSimpleName();
    }

    @Override // com.ttnet.org.chromium.net.g.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public UrlRequestBase f() {
        UrlRequestBase X = this.a.X(this.b, this.c, this.d, this.i, this.j, this.g, this.h, this.m, this.n, this.o, this.p, this.q, this.r, this.t, this.s);
        String str = this.e;
        if (str != null) {
            X.r(str);
        }
        Iterator<Pair<String, String>> it2 = this.f.iterator();
        while (it2.hasNext()) {
            Pair<String, String> next = it2.next();
            X.p((String) next.first, (String) next.second);
        }
        e0 e0Var = this.k;
        if (e0Var != null) {
            X.w(e0Var, this.l);
        }
        X.t(this.u);
        X.u(this.v);
        X.v(this.w);
        X.s(this.x);
        return X;
    }

    @Override // com.ttnet.org.chromium.net.g.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public y i(int i) {
        this.i = i;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.g.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public y j(t.a aVar) {
        this.r = aVar;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.g0.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public y a(int i) {
        this.x = i;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.g0.a
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public y b(int i) {
        this.u = i;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.g0.a
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public y c(int i) {
        this.v = i;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.g0.a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public y d(int i) {
        this.w = i;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.g.a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public y k(int i) {
        this.n = true;
        this.o = i;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.g.a
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public y l(int i) {
        this.p = true;
        this.q = i;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.g.a
    public g.a h(String str) {
        if (str != null) {
            this.e = str;
            return this;
        }
        throw new NullPointerException("Method is required.");
    }

    @Override // com.ttnet.org.chromium.net.g.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public y e(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                this.f.add(Pair.create(str, str2));
                return this;
            }
            throw new NullPointerException("Invalid header value.");
        }
        throw new NullPointerException("Invalid header name.");
    }

    @Override // com.ttnet.org.chromium.net.g.a
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public y m(e0 e0Var, Executor executor) {
        if (e0Var != null) {
            if (executor != null) {
                if (this.e == null) {
                    this.e = "POST";
                }
                this.k = e0Var;
                this.l = executor;
                return this;
            }
            throw new NullPointerException("Invalid UploadDataProvider Executor.");
        }
        throw new NullPointerException("Invalid UploadDataProvider.");
    }

    y(String str, g0.b bVar, Executor executor, CronetEngineBase cronetEngineBase) {
        if (str != null) {
            if (bVar != null) {
                if (executor != null) {
                    if (cronetEngineBase != null) {
                        this.b = str;
                        this.c = bVar;
                        this.d = executor;
                        this.a = cronetEngineBase;
                        return;
                    }
                    throw new NullPointerException("CronetEngine is required.");
                }
                throw new NullPointerException("Executor is required.");
            }
            throw new NullPointerException("Callback is required.");
        }
        throw new NullPointerException("URL is required.");
    }
}
