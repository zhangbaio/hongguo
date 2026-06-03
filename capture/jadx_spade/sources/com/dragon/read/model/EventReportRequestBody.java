package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class EventReportRequestBody implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("active_tag")
    public String activeTag;
    public String body;

    @SerializedName("rule_id")
    public String ruleId;
    public int scene;

    @SerializedName("session_id")
    public String sessionId;

    static {
        Covode.recordClassIndex(612082);
        fieldTypeClassRef = FieldType.class;
    }
}
