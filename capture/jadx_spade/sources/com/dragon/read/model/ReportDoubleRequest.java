package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ReportDoubleRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("double_factor")
    public double doubleFactor;
    public String scene;

    @SerializedName("task_id")
    public int taskId;

    static {
        Covode.recordClassIndex(612223);
        fieldTypeClassRef = FieldType.class;
    }
}
