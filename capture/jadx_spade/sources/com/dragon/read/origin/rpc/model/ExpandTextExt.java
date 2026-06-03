package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ExpandTextExt implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("bg_color")
    public List<String> bgColor;

    @SerializedName("dark_bg_color")
    public List<String> darkBgColor;

    @SerializedName("dark_text_color")
    public String darkTextColor;

    @SerializedName("divider_type")
    public DividerType dividerType;

    @SerializedName("icon_url")
    public String iconURL;
    public int priority;
    public String schema;
    public String text;

    @SerializedName("text_color")
    public String textColor;

    @SerializedName("text_ext")
    public TextExtType textExt;

    static {
        Covode.recordClassIndex(612923);
        fieldTypeClassRef = FieldType.class;
    }
}
