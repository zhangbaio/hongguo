package com.dragon.read.local.db.entity;

import com.bytedance.covode.number.Covode;
import com.dragon.read.util.NumberUtils;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class Book {

    @SerializedName("abstraction")
    public String abstraction;

    @SerializedName("audioThumbUri")
    public String audioThumbUri;

    @SerializedName("audio_thumb_url_hd")
    public String audioThumbUrlHd;

    @SerializedName("author")
    public String author;

    @SerializedName("authorId")
    public String authorId;

    @SerializedName("authorizeType")
    public String authorizeType;

    @SerializedName("book_id")
    public final String bookId;

    @SerializedName("name")
    public String bookName;

    @SerializedName("book_only_tts")
    public boolean bookOnlyTts;

    @SerializedName("bookRankInfoList")
    public String bookRankInfoList;

    @SerializedName("book_short_name")
    public String bookShortName;

    @SerializedName("book_status")
    public String bookStatus;

    @SerializedName("category")
    public String category;

    @SerializedName("categorySchema")
    public String categorySchema;

    @SerializedName("color_audio_dominate")
    public String colorAudioDominate;

    @SerializedName("color_dominate")
    public String colorDominate;

    @SerializedName("cover_url")
    public String coverUrl;

    @SerializedName("create_time")
    public long createTime = System.currentTimeMillis();

    @SerializedName("creationStatus")
    public int creationStatus;

    @SerializedName("firstChapterId")
    public String firstChapterId;

    @SerializedName("flight_user_selected")
    public boolean flightUserSelected;

    @SerializedName("gender")
    public String gender;

    @SerializedName("genre")
    public String genre;

    @SerializedName("genre_type")
    public int genreType;

    @SerializedName("horiz_thumb_url")
    public String horizThumbUrl;

    @SerializedName("icon_tag")
    public String iconTag;

    @SerializedName("isEbook")
    public String isEbook;

    @SerializedName("is_exclusive")
    public boolean isExclusive;

    @SerializedName("is_finish")
    public boolean isFinish;

    @SerializedName("is_in_bookshelf")
    public boolean isInBookshelf;

    @SerializedName("is_pub_pay")
    public boolean isPubPay;

    @SerializedName("last_chapter_title")
    public String lastChapterTitle;

    @SerializedName("last_chapter_update_time")
    public String lastChapterUpdateTime;

    @SerializedName("last_serial_count")
    public String lastSerialCount;

    @SerializedName("length_type")
    public String lengthType;

    @SerializedName("listen_bookshelf_name")
    public String listenBookshelfName;

    @SerializedName("listenCount")
    public String listenCount;

    @SerializedName("op_tag")
    public String opTag;

    @SerializedName("pay_type")
    public int payType;

    @SerializedName("platform")
    public String platform;

    @SerializedName("poster_id")
    public String posterId;

    @SerializedName("readCount")
    public String readCount;

    @SerializedName("recommend_group_id")
    public String recommendGroupId;

    @SerializedName("recommend_info")
    public String recommendInfo;

    @SerializedName("relative_post_id")
    public String relativePostId;

    @SerializedName("relative_post_schema")
    public String relativePostSchema;

    @SerializedName("score")
    public String score;

    @SerializedName("serial_count")
    public String serialCount;

    @SerializedName("show_vip_tag")
    public boolean showVipTag;

    @SerializedName("small_cover_url")
    public String smallCoverUrl;

    @SerializedName("source")
    public String source;

    @SerializedName("tags")
    public String tags;

    @SerializedName("titlePageTags")
    public String titlePageTags;

    @SerializedName("tts_status")
    public int ttsStatus;

    @SerializedName("update_status")
    public String updateStatus;

    @SerializedName("update_time")
    public long updateTime;

    @SerializedName("valid_in_cn_region")
    public boolean validInCnRegion;

    @SerializedName("wordNumber")
    public int wordNumber;

    static {
        Covode.recordClassIndex(611552);
    }

    public int hashCode() {
        return Arrays.hashCode(new String[]{this.bookId});
    }

    public String toString() {
        return "Book{author='" + this.author + "', bookId='" + this.bookId + "', bookName='" + this.bookName + "', listenBookshelfName='" + this.listenBookshelfName + "', coverUrl='" + this.coverUrl + "', createTime=" + this.createTime + ", genreType=" + this.genreType + ", genre='" + this.genre + "', lengthType='" + this.lengthType + "', isFinish=" + this.isFinish + ", lastSerialCount='" + this.lastSerialCount + "', serialCount='" + this.serialCount + "', ttsStatus=" + this.ttsStatus + ", updateStatus='" + this.updateStatus + "', updateTime=" + this.updateTime + ", isExclusive=" + this.isExclusive + ", iconTag='" + this.iconTag + "', recommendInfo='" + this.recommendInfo + "', recommendGroupId='" + this.recommendGroupId + "', bookStatus='" + this.bookStatus + "', lastChapterTitle='" + this.lastChapterTitle + "', lastChapterUpdateTime='" + this.lastChapterUpdateTime + "', authorId='" + this.authorId + "', abstraction='" + this.abstraction + "', readCount='" + this.readCount + "', score='" + this.score + "', creationStatus=" + this.creationStatus + ", authorizeType='" + this.authorizeType + "', firstChapterId='" + this.firstChapterId + "', bookRankInfoList='" + this.bookRankInfoList + "', categorySchema='" + this.categorySchema + "', titlePageTags='" + this.titlePageTags + "', source='" + this.source + "', isEbook='" + this.isEbook + "', audioThumbUri='" + this.audioThumbUri + "', tags='" + this.tags + "', listenCount='" + this.listenCount + "', horizThumbUrl='" + this.horizThumbUrl + "', flight_user_selected='" + this.flightUserSelected + "', relativePostSchema='" + this.relativePostSchema + "', relativePostId='" + this.relativePostId + "', bookOnlyTts='" + this.bookOnlyTts + "'}";
    }

    public void a(String str) {
        this.wordNumber = NumberUtils.parseInt(str, 0);
    }

    public Book(String str) {
        this.bookId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.bookId.equals(((Book) obj).bookId);
        }
        return false;
    }
}
