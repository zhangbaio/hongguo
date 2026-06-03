package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CheckTrafficedBookResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int code;
    public CheckTrafficedBookRespData data;

    @SerializedName("log_id")
    public String logID;
    public String message;

    static {
        Covode.recordClassIndex(612824);
        fieldTypeClassRef = FieldType.class;
    }
}
