package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ReportBusinessParam implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("extra_data")
    public Map<String, String> extraData;

    @SerializedName("rich_text")
    public List<RichTextExt> richText;

    static {
        Covode.recordClassIndex(613366);
        fieldTypeClassRef = FieldType.class;
    }
}
