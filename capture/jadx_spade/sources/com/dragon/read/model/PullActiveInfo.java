package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PullActiveInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("gd_label")
    public String gdLabel;
    public String landing;
    public String material;
    public String type;

    static {
        Covode.recordClassIndex(612201);
        fieldTypeClassRef = FieldType.class;
    }
}
