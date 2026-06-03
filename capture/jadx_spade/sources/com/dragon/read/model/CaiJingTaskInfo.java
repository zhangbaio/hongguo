package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CaiJingTaskInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("is_completed")
    public boolean isCompleted;
    public long priority;
    public long reward;

    @SerializedName("task_id")
    public long taskId;
    public String text;
    public String url;

    static {
        Covode.recordClassIndex(612051);
        fieldTypeClassRef = FieldType.class;
    }
}
