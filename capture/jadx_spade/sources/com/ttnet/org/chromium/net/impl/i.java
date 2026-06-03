package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.impl.CronetUrlRequest;
import com.ttnet.org.chromium.net.impl.VersionSafeCallbacks;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class i implements CronetUrlRequest.j {
    public static final com.ttnet.org.chromium.base.g<CronetUrlRequest.j> a;

    class a implements com.ttnet.org.chromium.base.g<CronetUrlRequest.j> {
        a() {
        }
    }

    i() {
    }

    static {
        Covode.recordClassIndex(654617);
        a = new a();
    }

    public static CronetUrlRequest.j r() {
        com.ttnet.org.chromium.base.j.a(false);
        return new i();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.j
    public void b(long j, CronetUrlRequest cronetUrlRequest) {
        wj6.a.b1(j, cronetUrlRequest);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.j
    public void e(long j, CronetUrlRequest cronetUrlRequest) {
        wj6.a.V0(j, cronetUrlRequest);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.j
    public void i(long j, CronetUrlRequest cronetUrlRequest) {
        wj6.a.S0(j, cronetUrlRequest);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.j
    public void j(long j, CronetUrlRequest cronetUrlRequest) {
        wj6.a.i1(j, cronetUrlRequest);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.j
    public void p(long j, CronetUrlRequest cronetUrlRequest) {
        wj6.a.Y0(j, cronetUrlRequest);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.j
    public void a(long j, CronetUrlRequest cronetUrlRequest, long j2) {
        wj6.a.h1(j, cronetUrlRequest, j2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.j
    public void d(long j, CronetUrlRequest cronetUrlRequest, int i) {
        wj6.a.f1(j, cronetUrlRequest, i);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.j
    public void h(long j, CronetUrlRequest cronetUrlRequest, boolean z) {
        wj6.a.X0(j, cronetUrlRequest, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.j
    public void o(long j, CronetUrlRequest cronetUrlRequest, VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener) {
        wj6.a.Z0(j, cronetUrlRequest, urlRequestStatusListener);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.j
    public void q(long j, CronetUrlRequest cronetUrlRequest, int i) {
        wj6.a.e1(j, cronetUrlRequest, i);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.j
    public boolean m(long j, CronetUrlRequest cronetUrlRequest, String str) {
        return wj6.a.d1(j, cronetUrlRequest, str);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.j
    public void k(long j, CronetUrlRequest cronetUrlRequest, String str, String str2) {
        wj6.a.T0(j, cronetUrlRequest, str, str2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.j
    public void l(long j, CronetUrlRequest cronetUrlRequest, String str, String str2) {
        wj6.a.c1(j, cronetUrlRequest, str, str2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.j
    public boolean g(long j, CronetUrlRequest cronetUrlRequest, String str, String str2) {
        return wj6.a.U0(j, cronetUrlRequest, str, str2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.j
    public void n(long j, CronetUrlRequest cronetUrlRequest, int i, int i2, int i3) {
        wj6.a.g1(j, cronetUrlRequest, i, i2, i3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.j
    public boolean c(long j, CronetUrlRequest cronetUrlRequest, ByteBuffer byteBuffer, int i, int i2) {
        return wj6.a.a1(j, cronetUrlRequest, byteBuffer, i, i2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.j
    public long f(CronetUrlRequest cronetUrlRequest, long j, String str, int i, int i2, boolean z, boolean z2, boolean z3, int i3, boolean z4, int i4, int i5, long j2) {
        return wj6.a.W0(cronetUrlRequest, j, str, i, i2, z, z2, z3, i3, z4, i4, i5, j2);
    }
}
