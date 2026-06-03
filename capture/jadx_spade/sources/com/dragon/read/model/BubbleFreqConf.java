package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BubbleFreqConf implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("daily_limit")
    public int dailyLimit;

    @SerializedName("time_interval")
    public int timeInterval;

    static {
        Covode.recordClassIndex(612048);
        fieldTypeClassRef = FieldType.class;
    }
}
