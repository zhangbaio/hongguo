package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PublishReferralTrafficRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public String bookID;
    public String content;

    @SerializedName("new_book_id")
    public String newBookID;

    @SerializedName("referral_traffic_id")
    public String referralTrafficID;

    static {
        Covode.recordClassIndex(613341);
        fieldTypeClassRef = FieldType.class;
    }
}
