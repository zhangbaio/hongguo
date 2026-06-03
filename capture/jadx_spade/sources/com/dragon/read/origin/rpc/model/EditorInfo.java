package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class EditorInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("editor_name")
    public String editorName;

    @SerializedName("qq")
    public String qQ;

    static {
        Covode.recordClassIndex(612917);
        fieldTypeClassRef = FieldType.class;
    }
}
