package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CollectTaskAutoAddResult implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;

    @SerializedName("amount_type")
    public String amountType;

    @SerializedName("award_list")
    public List<MixTaskAwardNode> awardList;

    @SerializedName("collect_completed")
    public boolean collectCompleted;

    @SerializedName("device_collect_times")
    public int deviceCollectTimes;

    @SerializedName("finish_seconds_dict")
    public List<FinishSecondsDictItem> finishSecondsDict;

    @SerializedName("next_loop_info")
    public List<NextLoopInfoItem> nextLoopInfo;

    static {
        Covode.recordClassIndex(612060);
        fieldTypeClassRef = FieldType.class;
    }
}
