package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class HighlightItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("high_light_position")
    public List<List<Long>> highLightPosition;

    @SerializedName("rich_text")
    public String richText;

    @SerializedName("sug_type")
    public int sugType;
    public String text;

    static {
        Covode.recordClassIndex(613184);
        fieldTypeClassRef = FieldType.class;
    }
}
