package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ShortVideo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("button_text")
    public String buttonText;

    @SerializedName("color_dominate")
    public String colorDominate;
    public String cover;

    @SerializedName("horiz_cover")
    public String horizCover;
    public String schema;

    @SerializedName("series_id")
    public String seriesId;

    @SerializedName("sub_title")
    public String subTitle;
    public VideoTagInfo tag;
    public String title;

    static {
        Covode.recordClassIndex(612246);
        fieldTypeClassRef = FieldType.class;
    }
}
