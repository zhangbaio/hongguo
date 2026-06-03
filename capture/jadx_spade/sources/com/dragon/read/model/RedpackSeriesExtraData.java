package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class RedpackSeriesExtraData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("has_done_before")
    public boolean hasDoneBefore;

    @SerializedName("is_hit_libra")
    public boolean isHitLibra;

    @SerializedName("task_amount")
    public int taskAmount;

    @SerializedName("task_button_content")
    public String taskButtonContent;

    @SerializedName("task_button_key")
    public String taskButtonKey;

    static {
        Covode.recordClassIndex(612216);
        fieldTypeClassRef = FieldType.class;
    }
}
