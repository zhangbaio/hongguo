package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ResourceReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("common_params")
    public ReqCommonParams commonParams;

    @SerializedName("custom_attribute")
    public Map<String, String> customAttribute;

    @SerializedName("custom_variable")
    public Map<String, String> customVariable;

    @SerializedName("resource_key")
    public String resourceKey;

    @SerializedName("resource_type")
    public String resourceType;

    static {
        Covode.recordClassIndex(612231);
        fieldTypeClassRef = FieldType.class;
    }
}
