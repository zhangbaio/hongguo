package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetContractDetailResData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ai_contract_status")
    public short aIContractStatus;

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

    @SerializedName("bank_name")
    public String bankName;

    @SerializedName("bank_province")
    public String bankProvince;

    @SerializedName("book_id")
    public String bookID;

    @SerializedName("book_name")
    public String bookName;

    @SerializedName("contract_life")
    public int contractLife;

    @SerializedName("contract_type")
    public short contractType;

    @SerializedName("contract_valid_time_deprecated")
    public String contractValidTime;

    @SerializedName("editor_info")
    public String editorInfo;

    @SerializedName("group_id")
    public short groupID;

    @SerializedName("guardian_audit_status")
    public short guardianAuditStatus;

    @SerializedName("guardian_cert_uri_list")
    public String guardianCertUriList;

    @SerializedName("guardian_cert_url_list")
    public List<String> guardianCertUrlList;

    @SerializedName("guardian_identify_code")
    public String guardianIdentifyCode;

    @SerializedName("guardian_identify_name")
    public String guardianIdentifyName;

    @SerializedName("is_under_age_sign")
    public short isUnderAgeSign;

    @SerializedName("media_id")
    public String mediaID;

    @SerializedName("minimum_amount")
    public int minimumAmount;

    @SerializedName("minumum_amount")
    public int minumumAmount;

    @SerializedName("platform_rate")
    public int platformRate;

    @SerializedName("thumb_uri")
    public String thumbURI;

    @SerializedName("thumb_url_list")
    public List<ImageFormatInfo> thumbUrlList;

    @SerializedName("contract_valid_time")
    public String validStartTime;

    static {
        Covode.recordClassIndex(613091);
        fieldTypeClassRef = FieldType.class;
    }
}
