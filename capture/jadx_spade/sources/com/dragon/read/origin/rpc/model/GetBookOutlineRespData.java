package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetBookOutlineRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;

    @SerializedName("is_exist")
    public boolean isExist;

    static {
        Covode.recordClassIndex(613068);
        fieldTypeClassRef = FieldType.class;
    }
}
