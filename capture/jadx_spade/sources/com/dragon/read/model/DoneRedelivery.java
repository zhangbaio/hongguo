package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class DoneRedelivery implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("action_desc")
    public String actionDesc;

    @SerializedName("action_url")
    public String actionUrl;

    @SerializedName("req_id")
    public String reqId;
    public Reward reward;

    @SerializedName("task_id")
    public int taskId;

    @SerializedName("task_name")
    public String taskName;
    public String type;

    static {
        Covode.recordClassIndex(612073);
        fieldTypeClassRef = FieldType.class;
    }
}
