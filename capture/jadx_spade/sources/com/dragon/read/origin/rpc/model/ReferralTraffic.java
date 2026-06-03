package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ReferralTraffic implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;

    @SerializedName("new_book_id")
    public String newBookID;

    @SerializedName("new_book_name")
    public String newBookName;

    @SerializedName("referral_traffic_id")
    public String referralTrafficID;

    @SerializedName("verify_status")
    public ReferralTrafficVerifyStatus verifyStatus;

    static {
        Covode.recordClassIndex(613362);
        fieldTypeClassRef = FieldType.class;
    }
}
