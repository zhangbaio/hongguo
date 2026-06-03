package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TaskInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;

    @SerializedName("is_open")
    public boolean isOpen;

    @SerializedName("task_key")
    public String taskKey;
    public String type;

    static {
        Covode.recordClassIndex(612272);
        fieldTypeClassRef = FieldType.class;
    }
}
