package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CMarkElem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("begin")
    public int begin;

    @SerializedName("end")
    public int end;

    static {
        Covode.recordClassIndex(612785);
        fieldTypeClassRef = FieldType.class;
    }
}
