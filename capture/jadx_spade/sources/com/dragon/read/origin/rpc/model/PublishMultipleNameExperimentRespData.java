package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PublishMultipleNameExperimentRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("record_id")
    public String recordID;

    @SerializedName("repeat_hint")
    public Map<Short, String> repeatHint;

    static {
        Covode.recordClassIndex(613339);
        fieldTypeClassRef = FieldType.class;
    }
}
