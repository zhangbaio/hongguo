package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ContractApplyRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("author_address")
    public String authorAddress;

    @SerializedName("author_city")
    public String authorCity;

    @SerializedName("author_email")
    public String authorEmail;

    @SerializedName("author_guardian_phone")
    public String authorGuardianPhone;

    @SerializedName("author_id")
    public String authorID;

    @SerializedName("author_id_back_uri")
    public String authorIDBackURI;

    @SerializedName("author_id_front_uri")
    public String authorIDFrontURI;

    @SerializedName("author_nick_name")
    public String authorNickName;

    @SerializedName("author_phone")
    public String authorPhone;

    @SerializedName("author_province")
    public String authorProvince;

    @SerializedName("author_qq")
    public String authorQQ;

    @SerializedName("author_real_name")
    public String authorRealName;

    @SerializedName("bank_account")
    public String bankAccount;

    @SerializedName("bank_address")
    public String bankAddress;

    @SerializedName("bank_city")
    public String bankCity;

    @SerializedName("bank_code")
    public String bankCode;

    @SerializedName("bank_name")
    public String bankName;

    @SerializedName("bank_province")
    public String bankProvince;

    @SerializedName("book_id")
    public long bookID;

    @SerializedName("guardian_cert_list")
    public String guardianCertList;

    static {
        Covode.recordClassIndex(612839);
        fieldTypeClassRef = FieldType.class;
    }
}
