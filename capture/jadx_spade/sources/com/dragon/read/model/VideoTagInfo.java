package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class VideoTagInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("bg_color")
    public List<String> bgColor;

    @SerializedName("bg_color_orientation")
    public long bgColorOrientation;

    @SerializedName("can_use_brand_color")
    public boolean canUseBrandColor;

    @SerializedName("dark_bg_color")
    public List<String> darkBgColor;

    @SerializedName("dark_icon_url")
    public String darkIconUrl;

    @SerializedName("dark_text_color")
    public String darkTextColor;

    @SerializedName("icon_url")
    public String iconUrl;
    public long mode;
    public String text;

    @SerializedName("text_color")
    public String textColor;

    static {
        Covode.recordClassIndex(612291);
        fieldTypeClassRef = FieldType.class;
    }
}
