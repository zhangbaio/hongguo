package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PageGuideInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;

    @SerializedName("first_day_tab_user")
    public boolean firstDayTabUser;

    @SerializedName("is_pop")
    public boolean isPop;

    static {
        Covode.recordClassIndex(612173);
        fieldTypeClassRef = FieldType.class;
    }
}
