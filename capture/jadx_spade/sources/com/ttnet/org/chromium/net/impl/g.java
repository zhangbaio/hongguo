package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.impl.CronetUploadDataStream;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class g implements CronetUploadDataStream.d {
    public static final com.ttnet.org.chromium.base.g<CronetUploadDataStream.d> a;

    class a implements com.ttnet.org.chromium.base.g<CronetUploadDataStream.d> {
        a() {
        }
    }

    g() {
    }

    static {
        Covode.recordClassIndex(654609);
        a = new a();
    }

    public static CronetUploadDataStream.d e() {
        com.ttnet.org.chromium.base.j.a(false);
        return new g();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.d
    public void a(long j) {
        wj6.a.f0(j);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.d
    public void d(long j, CronetUploadDataStream cronetUploadDataStream) {
        wj6.a.h0(j, cronetUploadDataStream);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.d
    public long b(CronetUploadDataStream cronetUploadDataStream, long j, long j2) {
        return wj6.a.e0(cronetUploadDataStream, j, j2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.d
    public void c(long j, CronetUploadDataStream cronetUploadDataStream, int i, boolean z) {
        wj6.a.g0(j, cronetUploadDataStream, i, z);
    }
}
