package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ExchangeFrequencyInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("allow_times")
    public int allowTimes;

    @SerializedName("done_times")
    public int doneTimes;

    static {
        Covode.recordClassIndex(612085);
        fieldTypeClassRef = FieldType.class;
    }
}
