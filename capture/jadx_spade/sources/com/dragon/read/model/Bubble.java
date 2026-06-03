package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class Bubble implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("earliest_show_time")
    public long earliestShowTime;

    @SerializedName("exit_days")
    public int exitDays;
    public String title;

    static {
        Covode.recordClassIndex(612045);
        fieldTypeClassRef = FieldType.class;
    }
}
