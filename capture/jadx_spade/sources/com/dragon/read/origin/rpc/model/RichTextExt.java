package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class RichTextExt implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Map<String, String> extra;
    public UgcCloudStatus status;
    public String style;

    @SerializedName("sub_text_ext")
    public List<RichTextExt> subTextExt;
    public String text;

    @SerializedName("text_ext")
    public TextExtType textExt;

    @SerializedName("uri")
    public String uRI;

    static {
        Covode.recordClassIndex(613374);
        fieldTypeClassRef = FieldType.class;
    }
}
