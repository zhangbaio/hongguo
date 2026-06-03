package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class EcomBookShoppingEarnMoneyDetail implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("action_times")
    public int actionTimes;

    @SerializedName("cur_times")
    public int curTimes;

    @SerializedName("popup_desc")
    public String popupDesc;

    @SerializedName("popup_title")
    public String popupTitle;
    public List<EcomBookShoppingEarnMoneyReward> task;

    @SerializedName("task_event_param")
    public TaskEventParam taskEventParam;

    static {
        Covode.recordClassIndex(612076);
        fieldTypeClassRef = FieldType.class;
    }
}
