package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ExchangeConditionInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("done_times")
    public int doneTimes;
    public int duration;
    public int id;
    public String key;

    @SerializedName("need_times")
    public int needTimes;

    @SerializedName("subject_type")
    public String subjectType;

    static {
        Covode.recordClassIndex(612084);
        fieldTypeClassRef = FieldType.class;
    }
}
