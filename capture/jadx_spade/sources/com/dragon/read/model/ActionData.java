package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ActionData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;

    @SerializedName("amount_type")
    public String amountType;
    public BroadcastInfo broadcast;

    @SerializedName("done_redelivery")
    public DoneRedelivery doneRedelivery;

    @SerializedName("excitation_ad")
    public ExcitationAd excitationAd;
    public Map<String, String> extra;

    @SerializedName("have_toast")
    public boolean haveToast;

    @SerializedName("pop_list")
    public List<ADDonePop> popList;

    @SerializedName("reward_request_info")
    public List<RewardRequestInfo> rewardRequestInfo;

    @SerializedName("task_event_param")
    public TaskEventParam taskEventParam;

    static {
        Covode.recordClassIndex(611991);
        fieldTypeClassRef = FieldType.class;
    }
}
