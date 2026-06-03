package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ResourceWithPositioning implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("client_async_rules")
    public String clientAsyncRules;
    public ResourceData data;

    @SerializedName("log_data")
    public LogData logData;

    @SerializedName("resource_key")
    public String resourceKey;

    @SerializedName("resource_type")
    public String resourceType;
    public Map<String, RuleContent> rules;

    static {
        Covode.recordClassIndex(612233);
        fieldTypeClassRef = FieldType.class;
    }
}
