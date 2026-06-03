package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class WelfareTaskData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("button_text")
    public String buttonText;
    public String subtitle;

    @SerializedName("task_detail")
    public TaskDetail taskDetail;
    public String title;

    static {
        Covode.recordClassIndex(612307);
        fieldTypeClassRef = FieldType.class;
    }
}
