package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AttendActivityInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID)
    public long activityID;

    @SerializedName("activity_name")
    public String activityName;

    @SerializedName("leave_date")
    public List<String> leaveDate;

    @SerializedName("leave_ticket")
    public int leaveTicket;

    @SerializedName("start_date")
    public String startDate;

    @SerializedName("Status")
    public short status;
    public short type;

    static {
        Covode.recordClassIndex(612739);
        fieldTypeClassRef = FieldType.class;
    }
}
