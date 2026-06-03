package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UgcScrollBarV2 implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("color_dominate")
    public String colorDominate;
    public String content;
    public List<String> covers;

    @SerializedName("dark_image")
    public ImageData darkImage;
    public String header;
    public ImageData image;

    @SerializedName("relative_id")
    public String relativeID;

    @SerializedName("relative_type")
    public UgcRelativeType relativeType;

    @SerializedName("right_text")
    public String rightText;
    public String schema;
    public String title;

    static {
        Covode.recordClassIndex(613520);
        fieldTypeClassRef = FieldType.class;
    }
}
