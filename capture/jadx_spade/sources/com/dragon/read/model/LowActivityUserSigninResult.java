package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class LowActivityUserSigninResult implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;

    @SerializedName("amount_type")
    public String amountType;
    public BroadcastInfo broadcast;

    @SerializedName("signed_days")
    public int signedDays;
    public String text;

    @SerializedName("top_bar")
    public NewUserSignInTopBar topBar;

    static {
        Covode.recordClassIndex(612147);
        fieldTypeClassRef = FieldType.class;
    }
}
