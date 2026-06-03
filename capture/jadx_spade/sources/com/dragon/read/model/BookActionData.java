package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BookActionData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;

    @SerializedName("amount_type")
    public String amountType;

    @SerializedName("calendar_info")
    public List<CalendarInfo> calendarInfo;

    static {
        Covode.recordClassIndex(612028);
        fieldTypeClassRef = FieldType.class;
    }
}
