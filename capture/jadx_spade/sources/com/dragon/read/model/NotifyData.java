package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NotifyData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("button_text")
    public String buttonText;
    public String extra;
    public String message;
    public Reward reward;
    public String schema;

    static {
        Covode.recordClassIndex(612169);
        fieldTypeClassRef = FieldType.class;
    }
}
