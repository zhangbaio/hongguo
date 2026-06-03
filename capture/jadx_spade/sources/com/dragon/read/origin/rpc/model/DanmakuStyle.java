package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class DanmakuStyle implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("avatar_bg_image")
    public String avatarBGImage;

    @SerializedName("background_image")
    public String backgroundImage;
    public String icon;

    @SerializedName("username_color")
    public String usernameColor;

    static {
        Covode.recordClassIndex(612867);
        fieldTypeClassRef = FieldType.class;
    }
}
