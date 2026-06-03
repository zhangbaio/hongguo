package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetAttendActivityBookRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("attend_info")
    public List<AttendInfo> attendInfo;

    @SerializedName("last_attend_activity")
    public AttendActivityInfo lastAttendActivity;

    static {
        Covode.recordClassIndex(613032);
        fieldTypeClassRef = FieldType.class;
    }
}
