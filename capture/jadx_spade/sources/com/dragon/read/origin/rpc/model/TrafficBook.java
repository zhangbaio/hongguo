package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TrafficBook implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public String bookID;

    @SerializedName("book_name")
    public String bookName;

    @SerializedName("category_name")
    public String categoryName;
    public String score;

    @SerializedName("thumb_url_list")
    public List<ImageFormatInfo> thumbUrlList;

    static {
        Covode.recordClassIndex(613485);
        fieldTypeClassRef = FieldType.class;
    }
}
