package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UgcItemInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("audio_thumb_uri")
    public String audioThumbURI;
    public String author;

    @SerializedName("book_id")
    public String bookID;

    @SerializedName("book_name")
    public String bookName;
    public String content;

    @SerializedName("creation_status")
    public String creationStatus;

    @SerializedName("genre_type")
    public String genreType;

    @SerializedName("group_id")
    public String groupID;

    @SerializedName("item_id")
    public String itemID;

    @SerializedName("item_status")
    public String itemStatus;

    @SerializedName("abstract")
    public String mAbstract;

    @SerializedName("paragraph_id")
    public String paragraphID;

    @SerializedName("real_chapter_order")
    public String realChapterOrder;

    @SerializedName("thumb_url")
    public String thumbUrl;
    public String title;

    @SerializedName("tomato_book_status")
    public String tomatoBookStatus;

    @SerializedName("word_number")
    public String wordNumber;

    static {
        Covode.recordClassIndex(613511);
        fieldTypeClassRef = FieldType.class;
    }
}
