package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ShortArticleApplyUserInfoRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("author_address")
    public String authorAddress;

    @SerializedName("author_city")
    public String authorCity;

    @SerializedName("author_email")
    public String authorEmail;

    @SerializedName("author_id")
    public String authorID;

    @SerializedName("author_name")
    public String authorName;

    @SerializedName("author_phone")
    public String authorPhone;

    @SerializedName("author_province")
    public String authorProvince;

    @SerializedName("author_qq")
    public String authorQQ;

    @SerializedName("bank_account")
    public String bankAccount;

    @SerializedName("bank_address")
    public String bankAddress;

    @SerializedName("bank_code")
    public String bankCode;

    @SerializedName("bank_name")
    public String bankName;

    static {
        Covode.recordClassIndex(613431);
        fieldTypeClassRef = FieldType.class;
    }
}
