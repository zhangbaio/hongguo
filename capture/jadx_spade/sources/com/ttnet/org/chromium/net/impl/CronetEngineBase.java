package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.c0;
import com.ttnet.org.chromium.net.g;
import com.ttnet.org.chromium.net.g0;
import com.ttnet.org.chromium.net.t;
import com.ttnet.org.chromium.net.z;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class CronetEngineBase extends com.ttnet.org.chromium.net.f {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Idempotency {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RequestPriority {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamPriority {
    }

    static {
        Covode.recordClassIndex(654577);
    }

    protected abstract com.ttnet.org.chromium.net.z W(z.b bVar, Executor executor, int i, List<String> list, int i2, int i3, int i4);

    protected abstract UrlRequestBase X(String str, g0.b bVar, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, t.a aVar, int i4, long j);

    protected abstract c0 Y(c0.b bVar, Executor executor, List<String> list, int i, String str, long j, int i2, long j2, String str2, int i3, String str3, Map<String, String> map, Map<String, String> map2, boolean z);

    protected abstract c0 Z(c0.b bVar, Executor executor, List<String> list, Map<String, String> map, Map<String, String> map2, boolean z);

    @Override // com.ttnet.org.chromium.net.c
    public z.a b(z.b bVar, Executor executor) {
        return new w(bVar, executor, this);
    }

    @Override // com.ttnet.org.chromium.net.c
    public c0.a d(c0.b bVar, Executor executor) {
        return new x(bVar, executor, this);
    }

    @Override // com.ttnet.org.chromium.net.f, com.ttnet.org.chromium.net.c
    /* renamed from: z */
    public g.a c(String str, g0.b bVar, Executor executor) {
        return new y(str, bVar, executor, this);
    }
}
