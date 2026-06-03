package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TaskEventParam implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("cn_task_name")
    public String cnTaskName;

    @SerializedName("from_task_name")
    public String fromTaskName;

    @SerializedName("merge_task_id")
    public int mergeTaskId;

    @SerializedName("task_desc")
    public String taskDesc;

    @SerializedName("task_id")
    public int taskId;

    @SerializedName("task_key")
    public String taskKey;

    @SerializedName("task_name")
    public String taskName;

    static {
        Covode.recordClassIndex(612271);
        fieldTypeClassRef = FieldType.class;
    }
}
