package com.xiaomi.push;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class aq implements as {
    private final String a;
    private final String b;

    static {
        Covode.recordClassIndex(655353);
    }

    @Override // com.xiaomi.push.as
    public String a() {
        return this.a;
    }

    @Override // com.xiaomi.push.as
    public String b() {
        return this.b;
    }

    public aq(String str, String str2) {
        if (str != null) {
            this.a = str;
            this.b = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }
}
