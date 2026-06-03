package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UgcFilterTag implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public long count;

    @SerializedName("is_fade")
    public boolean isFade;

    @SerializedName("tag_id")
    public String tagID;

    @SerializedName("tag_name")
    public String tagName;

    @SerializedName("tag_type")
    public UgcHighlightTagType tagType;

    static {
        Covode.recordClassIndex(613508);
        fieldTypeClassRef = FieldType.class;
    }
}
