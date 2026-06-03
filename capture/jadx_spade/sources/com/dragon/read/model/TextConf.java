package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TextConf implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String color;

    @SerializedName("font_size")
    public String fontSize;
    public String title;

    static {
        Covode.recordClassIndex(612277);
        fieldTypeClassRef = FieldType.class;
    }
}
