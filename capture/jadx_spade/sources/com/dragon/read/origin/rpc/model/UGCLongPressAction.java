package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UGCLongPressAction implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("action_type")
    public UGCLongPressActionType actionType;

    @SerializedName("dislike_report_extra")
    public Map<String, String> dislikeReportExtra;
    public String toast;

    static {
        Covode.recordClassIndex(613486);
        fieldTypeClassRef = FieldType.class;
    }
}
