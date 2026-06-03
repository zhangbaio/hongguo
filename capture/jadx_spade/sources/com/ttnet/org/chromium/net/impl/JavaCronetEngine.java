package com.ttnet.org.chromium.net.impl;

import com.bytedance.apm.agent.instrumentation.HttpInstrumentation;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.c0;
import com.ttnet.org.chromium.net.g0;
import com.ttnet.org.chromium.net.t;
import com.ttnet.org.chromium.net.z;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class JavaCronetEngine extends CronetEngineBase {
    private static final String f;
    private final String b;
    private final ExecutorService c;
    public final int d;
    public final CronetLogger e;

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    protected com.ttnet.org.chromium.net.z W(z.b bVar, Executor executor, int i, List<String> list, int i2, int i3, int i4) {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public c0 Y(c0.b bVar, Executor executor, List<String> list, int i, String str, long j, int i2, long j2, String str2, int i3, String str3, Map<String, String> map, Map<String, String> map2, boolean z) {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public c0 Z(c0.b bVar, Executor executor, List<String> list, Map<String, String> map, Map<String, String> map2, boolean z) {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.c
    public com.ttnet.org.chromium.net.y a() {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.f
    public int n() {
        return -1;
    }

    @Override // com.ttnet.org.chromium.net.f
    public int o() {
        return 0;
    }

    @Override // com.ttnet.org.chromium.net.f
    public int t() {
        return -1;
    }

    @Override // com.ttnet.org.chromium.net.f
    public int w() {
        return -1;
    }

    static {
        Covode.recordClassIndex(654626);
        f = JavaCronetEngine.class.getSimpleName();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase, com.ttnet.org.chromium.net.f, com.ttnet.org.chromium.net.c
    public /* bridge */ /* synthetic */ g0.a c(String str, g0.b bVar, Executor executor) {
        return super.c(str, bVar, executor);
    }

    @Override // com.ttnet.org.chromium.net.c
    public URLConnection e(URL url, Proxy proxy, boolean z) throws IOException {
        return HttpInstrumentation.openConnectionWithProxy(url.openConnection(proxy));
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public UrlRequestBase X(String str, g0.b bVar, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, t.a aVar, int i4, long j) {
        if (j == -1) {
            return new m(this, bVar, this.c, executor, str, this.b, z3, z4, i2, z5, i3);
        }
        throw new UnsupportedOperationException("The multi-network API is not supported by the Java implementation of Cronet Engine");
    }
}
