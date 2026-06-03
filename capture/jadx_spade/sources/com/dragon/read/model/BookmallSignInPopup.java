package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BookmallSignInPopup implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("cold_start_times")
    public int coldStartTimes;
    public String schema;

    @SerializedName("today_completed")
    public boolean todayCompleted;

    static {
        Covode.recordClassIndex(612042);
        fieldTypeClassRef = FieldType.class;
    }
}
