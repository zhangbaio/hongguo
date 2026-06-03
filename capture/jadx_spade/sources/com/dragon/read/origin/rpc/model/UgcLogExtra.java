package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UgcLogExtra implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("recommend_group_id")
    public String recommendGroupId;

    @SerializedName("recommend_info")
    public String recommendInfo;

    @SerializedName("request_info")
    public String requestInfo;

    static {
        Covode.recordClassIndex(613512);
        fieldTypeClassRef = FieldType.class;
    }
}
