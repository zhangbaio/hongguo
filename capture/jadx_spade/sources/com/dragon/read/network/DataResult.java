package com.dragon.read.network;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class DataResult<T> implements Serializable {

    @SerializedName("code")
    public final int code;

    @SerializedName("data")
    public final T data;

    @SerializedName("message")
    public final String msg;

    static {
        Covode.recordClassIndex(612442);
    }

    public boolean isSuccess() {
        if (this.code == 0) {
            return true;
        }
        return false;
    }

    public String getCodeMsg() {
        return "code=" + this.code + ",msg=" + this.msg;
    }

    public String toString() {
        return "DataResult{code=" + this.code + ", data=" + this.data + ", msg='" + this.msg + "'}";
    }

    public static <T> DataResult<T> success(T t) {
        return new DataResult<>(0, t, "SUCCESS");
    }

    public static <T> DataResult<T> error(int i, String str) {
        return new DataResult<>(i, null, str);
    }

    public DataResult(int i, T t, String str) {
        this.code = i;
        this.data = t;
        this.msg = str;
    }
}
