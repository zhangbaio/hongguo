package com.vivo.push.ups;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TokenResult extends CodeResult {
    String token;

    static {
        Covode.recordClassIndex(655160);
    }

    public String getToken() {
        return this.token;
    }

    public TokenResult(int i, String str) {
        super(i);
        this.token = str;
    }
}
