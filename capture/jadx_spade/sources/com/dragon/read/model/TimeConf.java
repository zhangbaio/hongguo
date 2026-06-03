package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TimeConf implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("begin_timestamp")
    public String beginTimestamp;

    @SerializedName("end_timestamp")
    public String endTimestamp;

    @SerializedName("show_duration")
    public String showDuration;

    static {
        Covode.recordClassIndex(612279);
        fieldTypeClassRef = FieldType.class;
    }
}
