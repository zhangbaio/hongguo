package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class MallTaskRedpack implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("is_completed")
    public boolean isCompleted;
    public String name;

    @SerializedName("task_key")
    public String taskKey;

    static {
        Covode.recordClassIndex(612151);
        fieldTypeClassRef = FieldType.class;
    }
}
