package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BookEcomTreasurePendantData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("button_pic_url")
    public String buttonPicUrl;

    @SerializedName("button_size")
    public String buttonSize;

    @SerializedName("button_text")
    public String buttonText;

    @SerializedName("cur_time")
    public long curTime;

    @SerializedName("icon_size")
    public String iconSize;

    @SerializedName("icon_url")
    public String iconUrl;

    @SerializedName("next_time")
    public long nextTime;

    @SerializedName("task_event_param")
    public TaskEventParam taskEventParam;

    static {
        Covode.recordClassIndex(612032);
        fieldTypeClassRef = FieldType.class;
    }
}
