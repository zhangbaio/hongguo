package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class v implements TTCronetNetExpRequest.b {
    public static final com.ttnet.org.chromium.base.g<TTCronetNetExpRequest.b> a;

    class a implements com.ttnet.org.chromium.base.g<TTCronetNetExpRequest.b> {
        a() {
        }
    }

    v() {
    }

    static {
        Covode.recordClassIndex(654656);
        a = new a();
    }

    public static TTCronetNetExpRequest.b e() {
        com.ttnet.org.chromium.base.j.a(false);
        return new v();
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.b
    public void c(long j, TTCronetNetExpRequest tTCronetNetExpRequest) {
        wj6.a.w1(j, tTCronetNetExpRequest);
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.b
    public void d(long j, TTCronetNetExpRequest tTCronetNetExpRequest) {
        wj6.a.u1(j, tTCronetNetExpRequest);
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.b
    public void a(long j, TTCronetNetExpRequest tTCronetNetExpRequest, String str, String str2) {
        wj6.a.v1(j, tTCronetNetExpRequest, str, str2);
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.b
    public long b(TTCronetNetExpRequest tTCronetNetExpRequest, long j, int i, String[] strArr, int i2, int i3, int i4) {
        return wj6.a.t1(tTCronetNetExpRequest, j, i, strArr, i2, i3, i4);
    }
}
