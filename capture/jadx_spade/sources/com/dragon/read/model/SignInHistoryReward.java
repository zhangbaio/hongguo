package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SignInHistoryReward implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int days;

    @SerializedName("history_reward_list")
    public List<Integer> historyRewardList;

    @SerializedName("is_hit")
    public boolean isHit;

    static {
        Covode.recordClassIndex(612254);
        fieldTypeClassRef = FieldType.class;
    }
}
