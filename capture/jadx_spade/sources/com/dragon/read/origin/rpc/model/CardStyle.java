package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CardStyle implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("abstract_line_num")
    public int abstractLineNum;

    @SerializedName("show_abstract")
    public boolean showAbstract;

    @SerializedName("show_title")
    public boolean showTitle;

    @SerializedName("tag_text")
    public String tagText;

    @SerializedName("tag_url")
    public String tagUrl;

    @SerializedName("title_line_num")
    public int titleLineNum;

    static {
        Covode.recordClassIndex(612786);
        fieldTypeClassRef = FieldType.class;
    }
}
