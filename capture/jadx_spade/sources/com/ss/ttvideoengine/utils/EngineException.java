package com.ss.ttvideoengine.utils;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class EngineException extends Exception {
    private final Error mError;

    static {
        Covode.recordClassIndex(652741);
    }

    public Error getError() {
        return this.mError;
    }

    public EngineException(Error error) {
        super(error.toString());
        this.mError = error;
    }

    public EngineException(Error error, Throwable th) {
        super(error.toString(), th);
        this.mError = error;
    }
}
