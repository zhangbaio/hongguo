package com.ttnet.org.chromium.base.task;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.task.PostTask;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class h implements PostTask.a {
    public static final com.ttnet.org.chromium.base.g<PostTask.a> a;

    class a implements com.ttnet.org.chromium.base.g<PostTask.a> {
        a() {
        }
    }

    h() {
    }

    static {
        Covode.recordClassIndex(654403);
        a = new a();
    }

    public static PostTask.a b() {
        com.ttnet.org.chromium.base.j.a(false);
        return new h();
    }

    @Override // com.ttnet.org.chromium.base.task.PostTask.a
    public void a(int i, boolean z, boolean z2, byte b, byte[] bArr, Runnable runnable, long j, String str) {
        wj6.a.x(i, z, z2, b, bArr, runnable, j, str);
    }
}
