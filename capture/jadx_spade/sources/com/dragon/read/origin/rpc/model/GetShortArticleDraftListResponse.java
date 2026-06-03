package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetShortArticleDraftListResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int code;

    @SerializedName("Data")
    public GetShortArticleDraftListRespData data;

    @SerializedName("log_id")
    public String logID;
    public String message;

    static {
        Covode.recordClassIndex(613158);
        fieldTypeClassRef = FieldType.class;
    }
}
