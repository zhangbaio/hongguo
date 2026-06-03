package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.xiaomi.push.hv;
import java.io.ByteArrayOutputStream;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class hu {
    private hz a;

    /* renamed from: a, reason: collision with other field name */
    private final ig f821a;

    /* renamed from: a, reason: collision with other field name */
    private final ByteArrayOutputStream f822a;

    static {
        Covode.recordClassIndex(655598);
    }

    public hu() {
        this(new hv.a());
    }

    public hu(ib ibVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f822a = byteArrayOutputStream;
        ig igVar = new ig(byteArrayOutputStream);
        this.f821a = igVar;
        this.a = ibVar.a(igVar);
    }

    public byte[] a(hp hpVar) {
        this.f822a.reset();
        hpVar.b(this.a);
        return this.f822a.toByteArray();
    }
}
