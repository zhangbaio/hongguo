package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class RecordDetail implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("flight_id")
    public String flightID;

    @SerializedName("flight_status")
    public short flightStatus;

    @SerializedName("group_list")
    public List<FlightGroup> groupList;

    @SerializedName("record_id")
    public String recordID;

    @SerializedName("start_time")
    public String startTime;

    static {
        Covode.recordClassIndex(613361);
        fieldTypeClassRef = FieldType.class;
    }
}
