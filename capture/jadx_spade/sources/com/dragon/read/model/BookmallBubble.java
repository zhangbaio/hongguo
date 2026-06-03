package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BookmallBubble implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("bubble_tips")
    public String bubbleTips;
    public String key;

    @SerializedName("reward_cold_days")
    public int rewardColdDays;

    @SerializedName("reward_tips")
    public String rewardTips;

    @SerializedName("reward_type")
    public String rewardType;

    @SerializedName("task_key")
    public String taskKey;

    static {
        Covode.recordClassIndex(612039);
        fieldTypeClassRef = FieldType.class;
    }
}
