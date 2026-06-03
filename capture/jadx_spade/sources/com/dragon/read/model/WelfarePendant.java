package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class WelfarePendant implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("end_time")
    public long endTime;
    public WelfareFrequency frequency;

    @SerializedName("show_seconds")
    public long showSeconds;

    @SerializedName("start_time")
    public long startTime;
    public String strategy;
    public String text;

    @SerializedName("text_color")
    public String textColor;

    @SerializedName("whole_background_url")
    public String wholeBackgroundUrl;

    static {
        Covode.recordClassIndex(612305);
        fieldTypeClassRef = FieldType.class;
    }
}
