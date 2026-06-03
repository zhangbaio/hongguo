package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class LogData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("resource_status")
    public List<String> resourceStatus;

    @SerializedName("resource_strategy")
    public List<String> resourceStrategy;

    static {
        Covode.recordClassIndex(612141);
        fieldTypeClassRef = FieldType.class;
    }
}
