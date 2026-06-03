package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.z;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class w extends z.a {
    private static final String i;
    private final CronetEngineBase a;
    private final Executor b;
    private final z.b c;
    private int d;
    private List<String> e;
    private int f;
    private int g;
    private int h;

    static {
        Covode.recordClassIndex(654657);
        i = w.class.getSimpleName();
    }

    @Override // com.ttnet.org.chromium.net.z.a
    public com.ttnet.org.chromium.net.z a() {
        return this.a.W(this.c, this.b, this.d, this.e, this.f, this.g, this.h);
    }

    @Override // com.ttnet.org.chromium.net.z.a
    public z.a b(int i2) {
        this.g = i2;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.z.a
    public z.a c(int i2) {
        this.f = i2;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.z.a
    public z.a d(int i2) {
        this.d = i2;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.z.a
    public z.a e(List<String> list) {
        this.e = list;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.z.a
    public z.a f(int i2) {
        this.h = i2;
        return this;
    }

    w(z.b bVar, Executor executor, CronetEngineBase cronetEngineBase) {
        this.a = cronetEngineBase;
        this.c = bVar;
        this.b = executor;
    }
}
