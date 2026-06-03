package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GenerateAINamingRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ai_generate_naming_list")
    public List<AIGenerateNaming> aIGenerateNamingList;

    @SerializedName("generate_id")
    public String generateID;

    static {
        Covode.recordClassIndex(612970);
        fieldTypeClassRef = FieldType.class;
    }
}
