package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ScoreSubdimension implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int score;

    @SerializedName("subdimension_id")
    public String subdimensionId;

    @SerializedName("subdimension_name")
    public String subdimensionName;

    static {
        Covode.recordClassIndex(613398);
        fieldTypeClassRef = FieldType.class;
    }
}
