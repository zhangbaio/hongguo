package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class RedpackResult implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;

    @SerializedName("amount_type")
    public String amountType;
    public BroadcastInfo broadcast;
    public Map<String, String> extra;

    @SerializedName("fake_amounts")
    public List<Integer> fakeAmounts;

    @SerializedName("next_task_info")
    public NextTaskInfo nextTaskInfo;

    @SerializedName("redpack_series_extra_data")
    public RedpackSeriesExtraData redpackSeriesExtraData;

    @SerializedName("ui_style")
    public String uiStyle;

    static {
        Covode.recordClassIndex(612215);
        fieldTypeClassRef = FieldType.class;
    }
}
