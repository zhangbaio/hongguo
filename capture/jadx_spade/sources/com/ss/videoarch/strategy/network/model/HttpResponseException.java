package com.ss.videoarch.strategy.network.model;

import com.bytedance.covode.number.Covode;
import java.io.IOException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class HttpResponseException extends IOException {
    public final int statusCode;

    static {
        Covode.recordClassIndex(653162);
    }

    public HttpResponseException(int i) {
        this.statusCode = i;
    }
}
