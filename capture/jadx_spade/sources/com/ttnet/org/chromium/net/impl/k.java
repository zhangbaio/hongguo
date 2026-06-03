package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.impl.CronetWebsocketConnection;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class k implements CronetWebsocketConnection.f {
    public static final com.ttnet.org.chromium.base.g<CronetWebsocketConnection.f> a;

    class a implements com.ttnet.org.chromium.base.g<CronetWebsocketConnection.f> {
        a() {
        }
    }

    k() {
    }

    static {
        Covode.recordClassIndex(654621);
        a = new a();
    }

    public static CronetWebsocketConnection.f k() {
        com.ttnet.org.chromium.base.j.a(false);
        return new k();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.f
    public void i(long j, CronetWebsocketConnection cronetWebsocketConnection) {
        wj6.a.n1(j, cronetWebsocketConnection);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.f
    public void j(long j, CronetWebsocketConnection cronetWebsocketConnection) {
        wj6.a.s1(j, cronetWebsocketConnection);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.f
    public long f(CronetWebsocketConnection cronetWebsocketConnection, long j) {
        return wj6.a.m1(cronetWebsocketConnection, j);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.f
    public void c(long j, CronetWebsocketConnection cronetWebsocketConnection, String str) {
        wj6.a.p1(j, cronetWebsocketConnection, str);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.f
    public void e(long j, CronetWebsocketConnection cronetWebsocketConnection, boolean z) {
        wj6.a.r1(j, cronetWebsocketConnection, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.f
    public void g(long j, CronetWebsocketConnection cronetWebsocketConnection, ByteBuffer byteBuffer) {
        wj6.a.o1(j, cronetWebsocketConnection, byteBuffer);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.f
    public void h(long j, CronetWebsocketConnection cronetWebsocketConnection, String str) {
        wj6.a.l1(j, cronetWebsocketConnection, str);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.f
    public void a(long j, CronetWebsocketConnection cronetWebsocketConnection, String str, String str2) {
        wj6.a.k1(j, cronetWebsocketConnection, str, str2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.f
    public void d(long j, CronetWebsocketConnection cronetWebsocketConnection, String str, String str2) {
        wj6.a.j1(j, cronetWebsocketConnection, str, str2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.f
    public void b(long j, CronetWebsocketConnection cronetWebsocketConnection, int i, String str, long j2, int i2, long j3, String str2, int i3, String str3, boolean z) {
        wj6.a.q1(j, cronetWebsocketConnection, i, str, j2, i2, j3, str2, i3, str3, z);
    }
}
