package com.dragon.read.network;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ErrorCodeException extends Exception {
    private final int code;
    private final String error;

    static {
        Covode.recordClassIndex(612443);
    }

    public int getCode() {
        return this.code;
    }

    public String getError() {
        return this.error;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (TextUtils.isEmpty(message)) {
            return getError();
        }
        return message;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "ErrorCodeException{code=" + this.code + ", error='" + this.error + "'}";
    }

    public static ErrorCodeException create(String str) {
        return new ErrorCodeException(100000000, str);
    }

    public ErrorCodeException(int i, String str) {
        this.code = i;
        this.error = str;
    }
}
