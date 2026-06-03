package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ew extends eq {
    static {
        Covode.recordClassIndex(655508);
    }

    @Override // com.xiaomi.push.eq
    public int c() {
        if (m398a().length == 0) {
            return 0;
        }
        return super.c();
    }

    public ew() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    @Override // com.xiaomi.push.eq
    /* renamed from: a */
    ByteBuffer mo395a(ByteBuffer byteBuffer) {
        if (m398a().length == 0) {
            return byteBuffer;
        }
        return super.mo395a(byteBuffer);
    }
}
