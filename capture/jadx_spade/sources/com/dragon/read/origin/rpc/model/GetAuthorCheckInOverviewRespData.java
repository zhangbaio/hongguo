package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetAuthorCheckInOverviewRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("days_check_in_year_count")
    @RpcField(FieldType.BODY)
    public int daysCheckInYearCount;

    @SerializedName("unused_check_in_ticket_count")
    @RpcField(FieldType.BODY)
    public int unusedCheckInTicketCount;

    @SerializedName("words_check_in_day_count")
    @RpcField(FieldType.BODY)
    public int wordsCheckInDayCount;

    static {
        Covode.recordClassIndex(613041);
        fieldTypeClassRef = FieldType.class;
    }
}
