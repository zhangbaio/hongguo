package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class RoundIncrease implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("current_round_increase")
    public boolean currentRoundIncrease;

    @SerializedName("increase_label")
    public List<Integer> increaseLabel;

    @SerializedName("last_round_reward")
    public Map<Long, Long> lastRoundReward;

    @SerializedName("next_round_increase")
    public boolean nextRoundIncrease;

    static {
        Covode.recordClassIndex(612238);
        fieldTypeClassRef = FieldType.class;
    }
}
