package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BookEcomTreasurePopupData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;

    @SerializedName("amount_type")
    public String amountType;

    @SerializedName("amount_unit")
    public String amountUnit;

    @SerializedName("buttom_text")
    public String buttomText;

    @SerializedName("task_event_param")
    public TaskEventParam taskEventParam;
    public String title;

    static {
        Covode.recordClassIndex(612033);
        fieldTypeClassRef = FieldType.class;
    }
}
