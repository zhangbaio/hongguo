package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AwardInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("action_type")
    public String actionType;

    @SerializedName("action_url")
    public String actionUrl;

    @SerializedName("bg_color")
    public String bgColor;

    @SerializedName("icon_position")
    public String iconPosition;

    @SerializedName("icon_url")
    public String iconUrl;
    public String text;

    @SerializedName("text_color")
    public String textColor;

    static {
        Covode.recordClassIndex(612015);
        fieldTypeClassRef = FieldType.class;
    }
}
