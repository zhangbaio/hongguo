package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PIT implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("CreateTime")
    public String createTime;

    @SerializedName("KeepAlive")
    public String keepAlive;

    @SerializedName("PID")
    public String pID;

    static {
        Covode.recordClassIndex(613273);
        fieldTypeClassRef = FieldType.class;
    }
}
