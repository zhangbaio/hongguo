package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.ByteArrayOutputStream;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class hr extends ByteArrayOutputStream {
    static {
        Covode.recordClassIndex(655595);
    }

    public hr() {
    }

    public int a() {
        return ((ByteArrayOutputStream) this).count;
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m603a() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public hr(int i) {
        super(i);
    }
}
