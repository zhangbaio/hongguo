package com.dragon.read.local.storage;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class StorageResp {

    @SerializedName("value")
    public final String data;

    @SerializedName("status")
    public final int status;

    static {
        Covode.recordClassIndex(611947);
    }

    public String toString() {
        return "StorageResp{status=" + this.status + ", data='" + this.data + "'}";
    }

    public StorageResp(int i, String str) {
        this.status = i;
        this.data = str;
    }
}
