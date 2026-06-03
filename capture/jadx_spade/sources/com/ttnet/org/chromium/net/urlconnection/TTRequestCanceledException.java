package com.ttnet.org.chromium.net.urlconnection;

import com.bytedance.covode.number.Covode;
import java.io.IOException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTRequestCanceledException extends IOException {
    static {
        Covode.recordClassIndex(654695);
    }

    public int getCronetInternalErrorCode() {
        return -999;
    }

    public TTRequestCanceledException(String str) {
        super(str);
    }
}
