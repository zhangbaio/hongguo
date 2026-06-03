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
public class AuthorCheckInInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("date")
    @RpcField(FieldType.BODY)
    public String attendDate;

    @SerializedName("book_check_in_infos")
    @RpcField(FieldType.BODY)
    public List<BookCheckInInfo> bookCheckInInfos;

    @SerializedName("check_in_amount")
    @RpcField(FieldType.BODY)
    public int checkInAmount;

    @SerializedName("check_in_status")
    @RpcField(FieldType.BODY)
    public AuthorCheckInStatus checkInStatus;

    @SerializedName("use_check_in_ticket")
    @RpcField(FieldType.BODY)
    public boolean useCheckInTicket;

    static {
        Covode.recordClassIndex(612751);
        fieldTypeClassRef = FieldType.class;
    }
}
