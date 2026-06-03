package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TakeCashBubble implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("icon_url")
    public String iconUrl;

    @SerializedName("icon_url_dark_mode")
    public String iconUrlDarkMode;

    @SerializedName("is_click_disappear")
    public boolean isClickDisappear;
    public String text;

    @SerializedName("top_bar_icon_url")
    public String topBarIconUrl;

    @SerializedName("top_bar_text")
    public String topBarText;

    static {
        Covode.recordClassIndex(612262);
        fieldTypeClassRef = FieldType.class;
    }
}
