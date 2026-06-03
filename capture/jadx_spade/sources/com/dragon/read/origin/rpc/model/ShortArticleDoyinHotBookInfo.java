package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ShortArticleDoyinHotBookInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String author;

    @SerializedName("book_id")
    public String bookID;

    @SerializedName("book_name")
    public String bookName;
    public List<CategoryMetaData> category;
    public String content;
    public int module;

    @SerializedName("thumb_url")
    public String thumbURL;

    @SerializedName("video_url")
    public String videoURL;

    @SerializedName("word_number")
    public int wordNumber;

    static {
        Covode.recordClassIndex(613444);
        fieldTypeClassRef = FieldType.class;
    }
}
