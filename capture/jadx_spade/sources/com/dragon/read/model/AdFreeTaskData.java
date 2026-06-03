package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AdFreeTaskData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ad_free_card")
    public AdFreeCard adFreeCard;

    @SerializedName("status_extra")
    public String statusExtra;

    @SerializedName("task_list")
    public List<TaskDetail> taskList;

    static {
        Covode.recordClassIndex(612003);
        fieldTypeClassRef = FieldType.class;
    }
}
