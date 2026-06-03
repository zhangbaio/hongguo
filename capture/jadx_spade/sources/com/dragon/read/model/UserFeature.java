package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UserFeature implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("is_incentive_new")
    public short isIncentiveNew;

    @SerializedName("is_incentive_preference")
    public short isIncentivePreference;

    @SerializedName("is_incentive_reactive")
    public short isIncentiveReactive;

    @SerializedName("word_style")
    public short wordStyle;

    static {
        Covode.recordClassIndex(612286);
        fieldTypeClassRef = FieldType.class;
    }
}
