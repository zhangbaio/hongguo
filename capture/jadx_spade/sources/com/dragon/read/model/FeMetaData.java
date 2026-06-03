package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class FeMetaData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("award_amount")
    public int awardAmount;

    @SerializedName("award_type")
    public String awardType;

    @SerializedName("page_key")
    public List<String> pageKey;

    @SerializedName("resp_type")
    public String respType;

    @SerializedName("strategy_key")
    public List<String> strategyKey;

    @SerializedName("task_id")
    public int taskId;

    @SerializedName("task_key")
    public String taskKey;

    @SerializedName("template_key")
    public String templateKey;

    static {
        Covode.recordClassIndex(612094);
        fieldTypeClassRef = FieldType.class;
    }
}
