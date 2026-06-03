package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AvatarInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("avatar_url")
    public String avatarUrl;

    @SerializedName("banner_text_map")
    public Map<String, String> bannerTextMap;

    @SerializedName("role_name")
    public String roleName;

    static {
        Covode.recordClassIndex(612011);
        fieldTypeClassRef = FieldType.class;
    }
}
