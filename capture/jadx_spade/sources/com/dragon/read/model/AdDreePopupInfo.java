package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AdDreePopupInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Content contents;

    @SerializedName("primary_button")
    public TextInfo primaryButton;
    public String title;

    static {
        Covode.recordClassIndex(611994);
        fieldTypeClassRef = FieldType.class;
    }
}
