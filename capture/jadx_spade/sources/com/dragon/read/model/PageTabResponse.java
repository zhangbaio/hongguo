package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PageTabResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public PageTab data;

    @SerializedName("err_no")
    public int errNo;

    @SerializedName("err_tips")
    public String errTips;

    static {
        Covode.recordClassIndex(612182);
        fieldTypeClassRef = FieldType.class;
    }
}
