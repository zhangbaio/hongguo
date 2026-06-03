package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TabIcon implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("icon_style")
    public int iconStyle;

    @SerializedName("icon_url")
    public String iconUrl;

    @SerializedName("night_icon_url")
    public String nightIconUrl;

    static {
        Covode.recordClassIndex(612261);
        fieldTypeClassRef = FieldType.class;
    }
}
