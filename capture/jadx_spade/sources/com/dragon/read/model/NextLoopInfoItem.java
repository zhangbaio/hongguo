package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NextLoopInfoItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("loop_list")
    public List<LoopReward> loopList;

    @SerializedName("read_type")
    public String readType;

    static {
        Covode.recordClassIndex(612165);
        fieldTypeClassRef = FieldType.class;
    }
}
