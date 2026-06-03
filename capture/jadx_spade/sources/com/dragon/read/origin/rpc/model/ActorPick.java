package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ActorPick implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Map<String, String> extra;

    @SerializedName("pick_time_stamp")
    public int pickTimeStamp;

    @SerializedName("pick_type")
    public ActorPickType pickType;
    public String style;

    static {
        Covode.recordClassIndex(612698);
        fieldTypeClassRef = FieldType.class;
    }
}
