package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetBookRecommendInfoV1RespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    @RpcField(FieldType.BODY)
    public String bookID;

    @SerializedName("book_name")
    @RpcField(FieldType.BODY)
    public String bookName;

    @SerializedName("book_name_reset_status")
    @RpcField(FieldType.BODY)
    public BookNameResetStatus bookNameResetStatus;

    @SerializedName("cold_start_audit_failed_times")
    @RpcField(FieldType.BODY)
    public short coldStartAuditFailedTimes;

    @SerializedName("cold_start_audit_status")
    @RpcField(FieldType.BODY)
    public ColdStartAuditStatus coldStartAuditStatus;

    @SerializedName("cold_start_show_status")
    @RpcField(FieldType.BODY)
    public ColdStartShowStatus coldStartShowStatus;

    @SerializedName("confirm_status")
    @RpcField(FieldType.BODY)
    public ConfirmStatus confirmStatus;

    @SerializedName("default_thumb_url")
    @RpcField(FieldType.BODY)
    public boolean defaultThumbURL;

    @SerializedName("origin_app_level")
    @RpcField(FieldType.BODY)
    public OriginAppLevel originAppLevel;

    @SerializedName("re_content")
    @RpcField(FieldType.BODY)
    public String reContent;

    @SerializedName("re_title")
    @RpcField(FieldType.BODY)
    public String reTitle;

    @SerializedName("risk_rate")
    @RpcField(FieldType.BODY)
    public short riskRate;

    @SerializedName("serial_days")
    @RpcField(FieldType.BODY)
    public short serialDays;

    @RpcField(FieldType.BODY)
    public BookStatus status;

    @SerializedName("thumb_url_list")
    @RpcField(FieldType.BODY)
    public List<ImageFormatInfo> thumbUrlList;

    @SerializedName("verify_status")
    @RpcField(FieldType.BODY)
    public BookAuditStatus verifyStatus;

    @SerializedName("word_count")
    @RpcField(FieldType.BODY)
    public long wordCount;

    static {
        Covode.recordClassIndex(613074);
        fieldTypeClassRef = FieldType.class;
    }
}
