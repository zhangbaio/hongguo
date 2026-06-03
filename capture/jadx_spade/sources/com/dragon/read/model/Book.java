package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class Book implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public String bookId;

    @SerializedName("book_name")
    public String bookName;

    @SerializedName("book_type")
    public String bookType;
    public String category;
    public String score;

    @SerializedName("thumb_url")
    public String thumbUrl;

    static {
        Covode.recordClassIndex(612027);
        fieldTypeClassRef = FieldType.class;
    }
}
