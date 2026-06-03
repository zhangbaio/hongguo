package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class LimitReadDetail implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("award_amount")
    public int awardAmount;

    @SerializedName("award_type")
    public String awardType;

    @SerializedName("end_time")
    public long endTime;

    @SerializedName("read_time")
    public int readTime;

    static {
        Covode.recordClassIndex(612138);
        fieldTypeClassRef = FieldType.class;
    }
}
