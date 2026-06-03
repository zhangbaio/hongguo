package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ReadDetailData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("action_desc")
    public String actionDesc;

    @SerializedName("base_amount")
    public int baseAmount;
    public String desc;

    @SerializedName("double_amount")
    public int doubleAmount;

    @SerializedName("show_reward")
    public Reward showReward;
    public String title;

    static {
        Covode.recordClassIndex(612206);
        fieldTypeClassRef = FieldType.class;
    }
}
