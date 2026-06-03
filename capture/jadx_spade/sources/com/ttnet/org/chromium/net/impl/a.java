package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.impl.CronetBidirectionalStream;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class a implements CronetBidirectionalStream.f {
    public static final com.ttnet.org.chromium.base.g<CronetBidirectionalStream.f> a;

    /* renamed from: com.ttnet.org.chromium.net.impl.a$a, reason: collision with other inner class name */
    class C0121a implements com.ttnet.org.chromium.base.g<CronetBidirectionalStream.f> {
        C0121a() {
        }
    }

    a() {
    }

    static {
        Covode.recordClassIndex(654576);
        a = new C0121a();
    }

    public static CronetBidirectionalStream.f c() {
        com.ttnet.org.chromium.base.j.a(false);
        return new a();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.f
    public void b(long j, CronetBidirectionalStream cronetBidirectionalStream, boolean z) {
        wj6.a.R(j, cronetBidirectionalStream, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.f
    public boolean a(long j, CronetBidirectionalStream cronetBidirectionalStream, ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z) {
        return wj6.a.S(j, cronetBidirectionalStream, byteBufferArr, iArr, iArr2, z);
    }
}
