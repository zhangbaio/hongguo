package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetBookRecommendInfoRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public long bookID;

    @SerializedName("book_name")
    public String bookName;

    @SerializedName("book_name_reset_status")
    public BookNameResetStatus bookNameResetStatus;

    @SerializedName("confirm_status")
    public ConfirmStatus confirmStatus;

    @SerializedName("default_thumb_url")
    public boolean defaultThumbURL;

    @SerializedName("origin_app_level")
    public OriginAppLevel originAppLevel;

    @SerializedName("risk_rate")
    public short riskRate;

    @SerializedName("serial_days")
    public short serialDays;
    public BookStatus status;

    @SerializedName("thumb_url_list")
    public List<ImageFormatInfo> thumbUrlList;

    @SerializedName("verify_status")
    public BookAuditStatus verifyStatus;

    @SerializedName("word_count")
    public long wordCount;

    static {
        Covode.recordClassIndex(613071);
        fieldTypeClassRef = FieldType.class;
    }
}
