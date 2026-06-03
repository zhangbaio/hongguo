package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UserTitleV2 implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("en_title")
    public String enTitle;
    public String extra;
    public String icon;
    public String intro;

    @SerializedName("is_author_title")
    public boolean isAuthorTitle;

    @SerializedName("is_vip_title")
    public boolean isVipTitle;
    public String label;

    @SerializedName("zh_title")
    public String zhTitle;

    static {
        Covode.recordClassIndex(613562);
        fieldTypeClassRef = FieldType.class;
    }
}
