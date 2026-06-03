package com.ttnet.org.chromium.base.task;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.task.m;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class n implements m.a {
    public static final com.ttnet.org.chromium.base.g<m.a> a;

    class a implements com.ttnet.org.chromium.base.g<m.a> {
        a() {
        }
    }

    n() {
    }

    static {
        Covode.recordClassIndex(654416);
        a = new a();
    }

    public static m.a d() {
        com.ttnet.org.chromium.base.j.a(false);
        return new n();
    }

    @Override // com.ttnet.org.chromium.base.task.m.a
    public void a(long j) {
        wj6.a.y(j);
    }

    @Override // com.ttnet.org.chromium.base.task.m.a
    public void b(long j, Runnable runnable, long j2, String str) {
        wj6.a.A(j, runnable, j2, str);
    }

    @Override // com.ttnet.org.chromium.base.task.m.a
    public long c(int i, int i2, boolean z, boolean z2, byte b, byte[] bArr) {
        return wj6.a.z(i, i2, z, z2, b, bArr);
    }
}
