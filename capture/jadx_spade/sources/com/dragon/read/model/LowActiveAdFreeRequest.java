package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class LowActiveAdFreeRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("custom_attribute")
    public Map<String, String> customAttribute;

    @SerializedName("has_watched_excitation_ad")
    public boolean hasWatchedExcitationAd;

    @SerializedName("is_ad_finished")
    public boolean isAdFinished;

    static {
        Covode.recordClassIndex(612144);
        fieldTypeClassRef = FieldType.class;
    }
}
