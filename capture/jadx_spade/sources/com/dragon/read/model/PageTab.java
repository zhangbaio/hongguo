package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PageTab implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String extra;

    @SerializedName("image_url")
    public String imageUrl;
    public String key;

    @SerializedName("reward_amount")
    public int rewardAmount;

    @SerializedName("reward_type")
    public String rewardType;

    @SerializedName("task_id")
    public int taskId;
    public String text;
    public String url;

    static {
        Covode.recordClassIndex(612179);
        fieldTypeClassRef = FieldType.class;
    }
}
