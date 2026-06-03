package com.xiaomi.push;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class hw {
    public final byte a;

    /* renamed from: a, reason: collision with other field name */
    public final String f829a;

    /* renamed from: a, reason: collision with other field name */
    public final short f830a;

    static {
        Covode.recordClassIndex(655601);
    }

    public hw() {
        this("", (byte) 0, (short) 0);
    }

    public String toString() {
        return "<TField name:'" + this.f829a + "' type:" + ((int) this.a) + " field-id:" + ((int) this.f830a) + ">";
    }

    public hw(String str, byte b, short s) {
        this.f829a = str;
        this.a = b;
        this.f830a = s;
    }
}
