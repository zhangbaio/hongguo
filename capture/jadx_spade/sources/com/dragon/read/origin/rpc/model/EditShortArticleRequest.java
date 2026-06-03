package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class EditShortArticleRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_image_fmt_list")
    public List<String> bookImageFmtList;

    @SerializedName("image_fmt_list")
    public List<String> imageFmtList;

    @SerializedName("item_id")
    public long itemID;

    static {
        Covode.recordClassIndex(612914);
        fieldTypeClassRef = FieldType.class;
    }
}
