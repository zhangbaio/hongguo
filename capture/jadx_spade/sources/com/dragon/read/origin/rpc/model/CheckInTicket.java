package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CheckInTicket implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("get_time")
    @RpcField(FieldType.BODY)
    public String getTime;

    @RpcField(FieldType.BODY)
    public CheckInTicketStatus status;

    @SerializedName("ticket_id")
    @RpcField(FieldType.BODY)
    public String ticketID;

    @RpcField(FieldType.BODY)
    public CheckInTicketType type;

    @SerializedName("valid_end_time")
    @RpcField(FieldType.BODY)
    public String validEndTime;

    @SerializedName("valid_start_time")
    @RpcField(FieldType.BODY)
    public String validStartTime;

    static {
        Covode.recordClassIndex(612813);
        fieldTypeClassRef = FieldType.class;
    }
}
