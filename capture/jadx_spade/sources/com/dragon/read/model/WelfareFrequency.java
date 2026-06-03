package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class WelfareFrequency implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("cache_key")
    public String cacheKey;
    public List<WelfareFrequencyRule> rules;

    static {
        Covode.recordClassIndex(612303);
        fieldTypeClassRef = FieldType.class;
    }
}
