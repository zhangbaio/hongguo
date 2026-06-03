package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ExcitationAdSurpriseDetail implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public long amount;

    @SerializedName("amount_multiplier")
    public long amountMultiplier;

    @SerializedName("amount_type")
    public String amountType;

    @SerializedName("is_open")
    public boolean isOpen;

    @SerializedName("resource_key")
    public String resourceKey;

    static {
        Covode.recordClassIndex(612090);
        fieldTypeClassRef = FieldType.class;
    }
}
