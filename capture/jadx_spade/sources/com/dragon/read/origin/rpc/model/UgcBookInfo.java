package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UgcBookInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("audio_icon_control")
    public boolean audioIconControl;

    @SerializedName("audio_thumb_uri")
    public String audioThumbUri;
    public String author;

    @SerializedName("author_avatar")
    public String authorAvatar;

    @SerializedName("author_id")
    public String authorID;

    @SerializedName("book_id")
    public String bookID;

    @SerializedName("book_name")
    public String bookName;

    @SerializedName("book_short_name")
    public String bookShortName;

    @SerializedName("book_type")
    public String bookType;

    @SerializedName("card_abstract")
    public String cardAbstract;

    @SerializedName("color_dominate")
    public String colorDominate;

    @SerializedName("content_classification_tag")
    public String contentClassificationTag;

    @SerializedName("creation_status")
    public String creationStatus;
    public String genre;

    @SerializedName("genre_type")
    public String genreType;

    @SerializedName("has_read_before")
    public boolean hasReadBefore;

    @SerializedName("has_tts")
    public boolean hasTTS;

    @SerializedName("horiz_thumb_url")
    public String horizThumbUrl;

    @SerializedName("listen_count")
    public String listenCount;

    @SerializedName("long_press_action")
    public UGCLongPressAction longPressAction;

    @SerializedName("abstract")
    public String mAbstract;
    public String platform;

    @SerializedName("poster_id")
    public String posterID;

    @SerializedName("pure_category_tags")
    public String pureCategoryTags;

    @SerializedName("quit_msg")
    public UgcEnterMsg quitMsg;

    @SerializedName("read_count")
    public String readCount;

    @SerializedName("read_count_text")
    public String readCountText;

    @SerializedName("reader_schema")
    public ReaderSchema readerSchema;

    @SerializedName("recommend_story_cover_id")
    public String recommendStoryCoverID;

    @SerializedName("relate_post_id")
    public String relatePostId;

    @SerializedName("relate_post_schema")
    public String relatePostSchema;
    public String score;

    @SerializedName("secondary_info_list")
    public List<UgcEnterMsg> secondaryInfoList;

    @SerializedName("serial_count")
    public String serialCount;

    @SerializedName("super_category")
    public String superCategory;
    public String tags;

    @SerializedName("thumb_url")
    public String thumbUrl;

    @SerializedName("tomato_book_status")
    public String tomatoBookStatus;

    static {
        Covode.recordClassIndex(613494);
        fieldTypeClassRef = FieldType.class;
    }
}
