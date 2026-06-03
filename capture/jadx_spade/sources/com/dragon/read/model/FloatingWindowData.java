package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class FloatingWindowData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("can_show")
    public boolean canShow;
    public String icon;

    @SerializedName("natural_expand_frequency_control")
    public int naturalExpandFrequencyControl;

    @SerializedName("next_refresh_timestamp")
    public long nextRefreshTimestamp;
    public String schema;
    public String status;
    public String style;

    @SerializedName("sub_title")
    public String subTitle;

    @SerializedName("task_id")
    public String taskId;

    @SerializedName("task_key")
    public String taskKey;
    public String title;

    static {
        Covode.recordClassIndex(612101);
        fieldTypeClassRef = FieldType.class;
    }
}
