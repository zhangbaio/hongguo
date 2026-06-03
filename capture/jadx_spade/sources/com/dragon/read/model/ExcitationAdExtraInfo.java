package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ExcitationAdExtraInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("bubble_text")
    public String bubbleText;

    @SerializedName("button_text")
    public String buttonText;

    static {
        Covode.recordClassIndex(612089);
        fieldTypeClassRef = FieldType.class;
    }
}
