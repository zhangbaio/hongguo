package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UserStat implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("celebrity_work_cnt")
    public int celebrityWorkCnt;
    public Map<String, String> extra;

    static {
        Covode.recordClassIndex(613560);
        fieldTypeClassRef = FieldType.class;
    }
}
