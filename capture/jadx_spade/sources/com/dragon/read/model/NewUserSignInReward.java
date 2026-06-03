package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NewUserSignInReward implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("bg_url")
    public String bgUrl;

    @SerializedName("hide_mode")
    public int hideMode;

    @SerializedName("icon_type")
    public int iconType;

    @SerializedName("icon_url_dark_mode")
    public String iconUrlDarkMode;

    @SerializedName("image_url")
    public String imageUrl;

    @SerializedName("reward_title")
    public String rewardTitle;

    @SerializedName("reward_type")
    public String rewardType;
    public int status;
    public String tag;
    public String text;

    static {
        Covode.recordClassIndex(612161);
        fieldTypeClassRef = FieldType.class;
    }
}
