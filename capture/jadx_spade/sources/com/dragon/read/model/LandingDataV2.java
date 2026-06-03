package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class LandingDataV2 implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("landing_key")
    public String landingKey;

    @SerializedName("scheme_list")
    public List<String> schemeList;

    static {
        Covode.recordClassIndex(612137);
        fieldTypeClassRef = FieldType.class;
    }
}
