package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UgcEnterMsg implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("attach_msgs")
    public List<String> attachMsgs;

    @SerializedName("can_click")
    public boolean canClick;

    @SerializedName("enter_msg")
    public String enterMsg;

    @SerializedName("high_light")
    public boolean highLight;

    @SerializedName("msg_type")
    public String msgType;

    @SerializedName("rec_reason_style")
    public RecReasonStyle recReasonStyle;

    @SerializedName("report_param")
    public Map<String, String> reportParam;

    @SerializedName("reserve_msg")
    public String reserveMsg;
    public String schema;

    @SerializedName("show_red_spot")
    public boolean showRedSpot;

    static {
        Covode.recordClassIndex(613507);
        fieldTypeClassRef = FieldType.class;
    }
}
