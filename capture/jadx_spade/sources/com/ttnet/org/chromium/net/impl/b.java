package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class b implements CronetFrontierClient.e {
    public static final com.ttnet.org.chromium.base.g<CronetFrontierClient.e> a;

    class a implements com.ttnet.org.chromium.base.g<CronetFrontierClient.e> {
        a() {
        }
    }

    b() {
    }

    static {
        Covode.recordClassIndex(654593);
        a = new a();
    }

    public static CronetFrontierClient.e i() {
        com.ttnet.org.chromium.base.j.a(false);
        return new b();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.e
    public long e(CronetFrontierClient cronetFrontierClient) {
        return wj6.a.W(cronetFrontierClient);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.e
    public void g(long j, CronetFrontierClient cronetFrontierClient) {
        wj6.a.X(j, cronetFrontierClient);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.e
    public void b(long j, CronetFrontierClient cronetFrontierClient, boolean z) {
        wj6.a.Z(j, cronetFrontierClient, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.e
    public void c(long j, CronetFrontierClient cronetFrontierClient, int i) {
        wj6.a.U(j, cronetFrontierClient, i);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.e
    public void h(long j, CronetFrontierClient cronetFrontierClient, String str, String str2) {
        wj6.a.T(j, cronetFrontierClient, str, str2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.e
    public void d(long j, CronetFrontierClient cronetFrontierClient, int i, String[] strArr, ByteBuffer byteBuffer) {
        wj6.a.a0(j, cronetFrontierClient, i, strArr, byteBuffer);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.e
    public void f(long j, CronetFrontierClient cronetFrontierClient, String[] strArr, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        wj6.a.Y(j, cronetFrontierClient, strArr, byteBuffer, i, i2, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.e
    public void a(long j, CronetFrontierClient cronetFrontierClient, int i, int i2, String str, int i3, String str2, String str3, String str4, String str5, int i4, int i5, int i6, boolean z, String str6, String str7) {
        wj6.a.V(j, cronetFrontierClient, i, i2, str, i3, str2, str3, str4, str5, i4, i5, i6, z, str6, str7);
    }
}
