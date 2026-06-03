package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class FeContentElement implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("content_info")
    public String contentInfo;

    @SerializedName("task_status")
    public List<String> taskStatus;

    static {
        Covode.recordClassIndex(612093);
        fieldTypeClassRef = FieldType.class;
    }
}
