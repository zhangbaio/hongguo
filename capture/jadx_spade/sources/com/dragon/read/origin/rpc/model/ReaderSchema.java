package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ReaderSchema implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("authorize_type")
    public String authorizeType;

    @SerializedName("category_schema")
    public String categorySchema;

    @SerializedName("first_chapter_item_id")
    public String firstChapterItemID;

    @SerializedName("read_count")
    public String readCount;

    @SerializedName("title_page_tags")
    public String titlePagTagsStr;

    @SerializedName("word_number")
    public String wordNumber;

    static {
        Covode.recordClassIndex(613357);
        fieldTypeClassRef = FieldType.class;
    }
}
