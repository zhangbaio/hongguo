package com.ss.ttvideoengine.selector.shift;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BitrateNotMatchException extends Exception {
    private final int code;

    static {
        Covode.recordClassIndex(652650);
    }

    public int getCode() {
        return this.code;
    }

    public BitrateNotMatchException(int i, String str) {
        super(str);
        this.code = i;
    }
}
