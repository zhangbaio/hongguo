package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AIGCImageData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String description;
    public Map<String, String> extra;

    @SerializedName("image_data")
    public ImageData imageData;
    public String title;

    static {
        Covode.recordClassIndex(612675);
        fieldTypeClassRef = FieldType.class;
    }
}
