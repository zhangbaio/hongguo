package com.dragon.read.local.file;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class JsonCache {

    @SerializedName("json_string")
    public String json;

    @SerializedName("survival_second")
    public long survivalSeconds;

    @SerializedName(Constants.VERSION)
    public long version;

    static {
        Covode.recordClassIndex(611933);
    }

    public JsonCache() {
        this("", -1L);
    }

    public String toString() {
        return "JsonCache{survivalSeconds=" + this.survivalSeconds + ", json='" + this.json + "', version='" + this.version + "'}";
    }

    public JsonCache(String str, long j) {
        this.version = 0L;
        this.json = str;
        this.survivalSeconds = j;
    }
}
