package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class RedpackPopup implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("count_down_time")
    public long countDownTime;

    @SerializedName("is_pop")
    public boolean isPop;
    public String schema;
    public String title;

    static {
        Covode.recordClassIndex(612211);
        fieldTypeClassRef = FieldType.class;
    }
}
