package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.h0;
import com.ttnet.org.chromium.net.t;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class RequestFinishedInfoImpl extends com.ttnet.org.chromium.net.t {
    private final String a;
    private final Collection<Object> b;
    private final t.b c;
    private final int d;
    private final h0 e;
    private final CronetException f;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FinishedReason {
    }

    static {
        Covode.recordClassIndex(654648);
    }

    @Override // com.ttnet.org.chromium.net.t
    public t.b a() {
        return this.c;
    }

    public RequestFinishedInfoImpl(String str, Collection<Object> collection, t.b bVar, int i, h0 h0Var, CronetException cronetException) {
        this.a = str;
        this.b = collection;
        this.c = bVar;
        this.d = i;
        this.e = h0Var;
        this.f = cronetException;
    }
}
