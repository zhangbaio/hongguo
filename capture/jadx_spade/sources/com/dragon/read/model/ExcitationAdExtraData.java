package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ExcitationAdExtraData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("is_staged")
    public boolean isStaged;

    @SerializedName("stage_amounts")
    public List<Integer> stageAmounts;

    static {
        Covode.recordClassIndex(612088);
        fieldTypeClassRef = FieldType.class;
    }
}
