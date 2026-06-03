package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ExcitationContent implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;
    public String icon;

    @SerializedName("read_type")
    public String readType;

    @SerializedName("reward_type")
    public String rewardType;

    @SerializedName("stage_duration")
    public int stageDuration;

    @SerializedName("task_desc")
    public String taskDesc;

    @SerializedName("task_key")
    public String taskKey;
    public String text;
    public String url;

    static {
        Covode.recordClassIndex(612092);
        fieldTypeClassRef = FieldType.class;
    }
}
