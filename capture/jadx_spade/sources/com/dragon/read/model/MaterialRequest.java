package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class MaterialRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("cold_start_attribute_info")
    public ColdStartAttributeInfo coldStartAttributeInfo;

    @SerializedName("is_kouling")
    public boolean isKouling;

    @SerializedName("is_lynx")
    public boolean isLynx;
    public int platform;
    public List<String> scene;

    static {
        Covode.recordClassIndex(612153);
        fieldTypeClassRef = FieldType.class;
    }
}
