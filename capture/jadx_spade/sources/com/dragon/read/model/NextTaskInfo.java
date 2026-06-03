package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NextTaskInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public ActionInfo action;

    @SerializedName("content_tips")
    public BaseInfo contentTips;

    @SerializedName("primary_button")
    public BaseInfo primaryButton;

    static {
        Covode.recordClassIndex(612166);
        fieldTypeClassRef = FieldType.class;
    }
}
