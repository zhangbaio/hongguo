package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class InviteCarouselSummary implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("avatar_url")
    public String avatarUrl;
    public String name;
    public String text;

    static {
        Covode.recordClassIndex(612126);
        fieldTypeClassRef = FieldType.class;
    }
}
