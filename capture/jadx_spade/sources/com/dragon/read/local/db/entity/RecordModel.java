package com.dragon.read.local.db.entity;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.impression.book.AbsBookImpressionItem;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.pages.bookshelf.model.BookType;
import com.dragon.read.pages.video.model.IRecordFilterData;
import com.dragon.read.recyler.i;
import com.dragon.read.util.NumberUtils;
import com.dragon.read.util.h6;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class RecordModel extends AbsBookImpressionItem implements i, IRecordFilterData {
    private String audioCover;
    private String author;
    private String authorizeType;
    private String bookId;
    private String bookName;
    private BookType bookType;
    private String categoryTags;
    private String chapterId;
    private int chapterIndex;
    private String chapterTitle;
    private String colorDominate;
    private String coverUrl;
    private int creationStatus;
    private String genre;
    private int genreType;
    private String historyBookName;
    private String historyCoverUrl;
    private String horizThumbUrl;
    private String iconTag;
    private boolean isExclusive;
    private boolean isFinish;
    private boolean isPubPay;
    private String lastChapterItemId;
    private String lastChapterTitle;
    private String lastChapterUpdateTime;
    private String lastSerialCount;
    private String lengthType;
    public String listenBookshelfName;
    private String opTag;
    private PageInfo pageInfo;
    private int payType;
    private String platform;
    private String posterId;
    private long readTime;
    private int recentReadCount;
    private Set<String> relativeAudioBookSet;
    private String relativeNovelBookId;
    private String relativePostId;
    private String relativePostSchema;
    private String score;
    private String serialCount;
    private boolean showVipTag;
    private String source;
    private String status;
    private int ttsStatus;
    private String updateStatus;
    private long updateTime;
    private float pagerProgressRatio = 0.0f;
    private boolean isDelete = false;
    private boolean hasSync = false;
    private boolean isShown = false;
    private boolean isSelected = false;
    private boolean isInBookshelf = false;
    private String platformBookId = "";
    private String userDigg = "";
    private String diggCnt = "";
    private long diggTime = 0;
    private String topRightTagDesc = "";
    private String filterTagName = "";
    private String filterTagType = "";

    static {
        Covode.recordClassIndex(611612);
    }

    public long getConsumeDuration() {
        return 0L;
    }

    public String getImpressionRecommendInfo() {
        return null;
    }

    public String getSpecificSubContentType() {
        return "";
    }

    public String getTag() {
        return "";
    }

    public void setShowCommentScoreGuide(boolean z, boolean z2) {
    }

    public void setShowContentTyeTag(boolean z) {
    }

    public void setShowSubTitle(boolean z) {
    }

    public void setShowVideoTag(boolean z) {
    }

    public String getAuthor() {
        return this.author;
    }

    public String getAuthorizeType() {
        return this.authorizeType;
    }

    public String getBookId() {
        return this.bookId;
    }

    public String getBookName() {
        return this.bookName;
    }

    public BookType getBookType() {
        return this.bookType;
    }

    public String getChapterId() {
        return this.chapterId;
    }

    public int getChapterIndex() {
        return this.chapterIndex;
    }

    public String getChapterTitle() {
        return this.chapterTitle;
    }

    public String getColorDominate() {
        return this.colorDominate;
    }

    public int getCreationStatus() {
        return this.creationStatus;
    }

    public String getDiggCnt() {
        return this.diggCnt;
    }

    public long getDiggTime() {
        return this.diggTime;
    }

    public String getFilterTagName() {
        return this.filterTagName;
    }

    public String getFilterTagType() {
        return this.filterTagType;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getGenreType() {
        return this.genreType;
    }

    public String getIconTag() {
        return this.iconTag;
    }

    public String getId() {
        return this.bookId;
    }

    public String getImpressionBookId() {
        return this.bookId;
    }

    public String getImpressionId() {
        return this.bookId;
    }

    public String getLastChapterItemId() {
        return this.lastChapterItemId;
    }

    public String getLastChapterTitle() {
        return this.lastChapterTitle;
    }

    public String getLastChapterUpdateTime() {
        return this.lastChapterUpdateTime;
    }

    public long getLastConsumeTime() {
        return this.readTime;
    }

    public String getLastSerialCount() {
        return this.lastSerialCount;
    }

    public String getLengthType() {
        return this.lengthType;
    }

    public String getListenBookshelfName() {
        return this.listenBookshelfName;
    }

    public String getOpTag() {
        return this.opTag;
    }

    public PageInfo getPageInfo() {
        return this.pageInfo;
    }

    public float getPagerProgressRatio() {
        return this.pagerProgressRatio;
    }

    public int getPayType() {
        return this.payType;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getPlatformBookId() {
        return this.platformBookId;
    }

    public String getPosterId() {
        return this.posterId;
    }

    public long getReadTime() {
        return this.readTime;
    }

    public int getRecentReadCount() {
        return this.recentReadCount;
    }

    public IRecordFilterData.RecordContentType getRecordContentType() {
        return IRecordFilterData.RecordContentType.Book;
    }

    public long getRecordIndex() {
        return this.readTime;
    }

    public Set<String> getRelativeAudioBookSet() {
        return this.relativeAudioBookSet;
    }

    public String getRelativeNovelBookId() {
        return this.relativeNovelBookId;
    }

    public String getRelativePostSchema() {
        return this.relativePostSchema;
    }

    public String getScore() {
        return this.score;
    }

    public boolean getSelectedStatus() {
        return this.isSelected;
    }

    public String getSerialCount() {
        return this.serialCount;
    }

    public String getSource() {
        return this.source;
    }

    public int getSpecificContentType() {
        return this.genreType;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTopRightTagDescReal() {
        return this.topRightTagDesc;
    }

    public int getTtsStatus() {
        return this.ttsStatus;
    }

    public String getUpdateStatus() {
        return this.updateStatus;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String getUserDigg() {
        return this.userDigg;
    }

    public boolean isDelete() {
        return this.isDelete;
    }

    public boolean isExclusive() {
        return this.isExclusive;
    }

    public boolean isFinish() {
        return this.isFinish;
    }

    public boolean isHasSync() {
        return this.hasSync;
    }

    public boolean isInBookshelf() {
        return this.isInBookshelf;
    }

    public boolean isPubPay() {
        return this.isPubPay;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean isShowVipTag() {
        return this.showVipTag;
    }

    public boolean isShown() {
        return this.isShown;
    }

    public String getAudioCover() {
        String str = this.audioCover;
        if (str == null) {
            return "";
        }
        return str;
    }

    public String getCoverUrl() {
        String str = this.coverUrl;
        if (str == null) {
            return "";
        }
        return str;
    }

    public String getHistoryBookName() {
        String str = this.historyBookName;
        if (str == null) {
            return "";
        }
        return str;
    }

    public String getHistoryCoverUrl() {
        String str = this.historyCoverUrl;
        if (str == null) {
            return "";
        }
        return str;
    }

    public int getLastConsumeIndex() {
        return this.chapterIndex - 1;
    }

    public String getHorizThumbUrl() {
        if (TextUtils.isEmpty(this.horizThumbUrl)) {
            return "";
        }
        return this.horizThumbUrl;
    }

    public String getRelativePostId() {
        if (h6.g(this.genreType)) {
            return this.bookId;
        }
        return this.relativePostId;
    }

    public String getTopRightTagDesc() {
        if (TextUtils.isEmpty(this.topRightTagDesc)) {
            return "无角标";
        }
        return this.topRightTagDesc;
    }

    public boolean isPlayCompleted() {
        if (getProgressPercent() >= 100) {
            return true;
        }
        return false;
    }

    public List<String> getCategoryTags() {
        if (!TextUtils.isEmpty(this.categoryTags)) {
            return Arrays.asList(this.categoryTags.split(","));
        }
        return null;
    }

    public int getItemViewType() {
        if (h6.c(this.genreType)) {
            return 3;
        }
        if (this.bookType == BookType.LISTEN) {
            return 2;
        }
        return 1;
    }

    public boolean isUpdate() {
        if (!this.isFinish && h6.b(getUpdateStatus())) {
            long parse = NumberUtils.parse(getLastSerialCount(), 0L);
            long parse2 = NumberUtils.parse(getSerialCount(), 0L);
            if (parse < parse2 && parse2 != 0 && parse != 0) {
                return true;
            }
        }
        return false;
    }

    public int getProgressPercent() {
        try {
            if (NumberUtils.parseInt(getSerialCount(), 0) == 0) {
                return 0;
            }
            return Math.max((int) Math.ceil(((getChapterIndex() * 1.0f) / r1) * 100.0f), 1);
        } catch (Exception e) {
            LogWrapper.e("RecordModel getProgressPercent fail, message:" + e.getMessage(), new Object[0]);
            return 0;
        }
    }

    public String toString() {
        return "RecordModel{author='" + this.author + "', bookId='" + this.bookId + "', bookType=" + this.bookType + ", bookName='" + this.bookName + "', chapterId='" + this.chapterId + "', chapterIndex=" + this.chapterIndex + ", chapterTitle='" + this.chapterTitle + "', lastChapterItemId='" + this.lastChapterItemId + "', coverUrl='" + this.coverUrl + "', audioCoverUrl='" + this.audioCover + "', genreType=" + this.genreType + ", genre='" + this.genre + "', lengthType='" + this.lengthType + "', ttsStatus=" + this.ttsStatus + ", isExclusive=" + this.isExclusive + ", iconTag='" + this.iconTag + "', status='" + this.status + "', listenBookshelfName='" + this.listenBookshelfName + "', relativeAudioBookSet=" + this.relativeAudioBookSet + ", updateTime=" + this.updateTime + ", readTime=" + this.readTime + ", isDelete=" + this.isDelete + ", hasSync=" + this.hasSync + ", isFinish=" + this.isFinish + ", isShown=" + this.isShown + ", isSelected=" + this.isSelected + ", isInBookshelf=" + this.isInBookshelf + ", colorDominate=" + this.colorDominate + ", horizThumbUrl=" + this.horizThumbUrl + ", serialCount='" + this.serialCount + "'}";
    }

    public void setAudioCover(String str) {
        this.audioCover = str;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public void setAuthorizeType(String str) {
        this.authorizeType = str;
    }

    public void setBookId(String str) {
        this.bookId = str;
    }

    public void setBookName(String str) {
        this.bookName = str;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public void setCategoryTags(String str) {
        this.categoryTags = str;
    }

    public void setChapterId(String str) {
        this.chapterId = str;
    }

    public void setChapterIndex(int i) {
        this.chapterIndex = i;
    }

    public void setChapterTitle(String str) {
        this.chapterTitle = str;
    }

    public void setColorDominate(String str) {
        this.colorDominate = str;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setCreationStatus(int i) {
        this.creationStatus = i;
    }

    public void setDataSelectStatus(boolean z) {
        this.isSelected = z;
    }

    public void setDelete(boolean z) {
        this.isDelete = z;
    }

    public void setDiggCnt(String str) {
        this.diggCnt = str;
    }

    public void setDiggTime(long j) {
        this.diggTime = j;
    }

    public void setExclusive(boolean z) {
        this.isExclusive = z;
    }

    public void setFilterTagName(String str) {
        this.filterTagName = str;
    }

    public void setFilterTagType(String str) {
        this.filterTagType = str;
    }

    public void setFinish(boolean z) {
        this.isFinish = z;
    }

    public void setGenre(String str) {
        this.genre = str;
    }

    public void setGenreType(int i) {
        this.genreType = i;
    }

    public void setHasSync(boolean z) {
        this.hasSync = z;
    }

    public void setHistoryBookName(String str) {
        this.historyBookName = str;
    }

    public void setHistoryCoverUrl(String str) {
        this.historyCoverUrl = str;
    }

    public void setHorizThumbUrl(String str) {
        this.horizThumbUrl = str;
    }

    public void setIconTag(String str) {
        this.iconTag = str;
    }

    public void setInBookshelf(boolean z) {
        this.isInBookshelf = z;
    }

    public void setLastChapterItemId(String str) {
        this.lastChapterItemId = str;
    }

    public void setLastChapterTitle(String str) {
        this.lastChapterTitle = str;
    }

    public void setLastChapterUpdateTime(String str) {
        this.lastChapterUpdateTime = str;
    }

    public void setLastSerialCount(String str) {
        this.lastSerialCount = str;
    }

    public void setLengthType(String str) {
        this.lengthType = str;
    }

    public void setListenBookshelfName(String str) {
        this.listenBookshelfName = str;
    }

    public void setOpTag(String str) {
        this.opTag = str;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public void setPagerProgressRatio(float f) {
        this.pagerProgressRatio = f;
    }

    public void setPayType(int i) {
        this.payType = i;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setPlatformBookId(String str) {
        this.platformBookId = str;
    }

    public void setPosterId(String str) {
        this.posterId = str;
    }

    public void setPubPay(boolean z) {
        this.isPubPay = z;
    }

    public void setReadTime(long j) {
        this.readTime = j;
    }

    public void setRecentReadCount(int i) {
        this.recentReadCount = i;
    }

    public void setRelativeAudioBookSet(Set<String> set) {
        this.relativeAudioBookSet = set;
    }

    public void setRelativeNovelBookId(String str) {
        this.relativeNovelBookId = str;
    }

    public void setRelativePostId(String str) {
        this.relativePostId = str;
    }

    public void setRelativePostSchema(String str) {
        this.relativePostSchema = str;
    }

    public void setScore(String str) {
        this.score = str;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setSerialCount(String str) {
        this.serialCount = str;
    }

    public void setShowVipTag(boolean z) {
        this.showVipTag = z;
    }

    public void setShown(boolean z) {
        this.isShown = z;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTopRightTagDesc(String str) {
        this.topRightTagDesc = str;
    }

    public void setTtsStatus(int i) {
        this.ttsStatus = i;
    }

    public void setUpdateStatus(String str) {
        this.updateStatus = str;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public void setUserDigg(String str) {
        this.userDigg = str;
    }

    public RecordModel(String str, BookType bookType) {
        this.bookId = str;
        this.bookType = bookType;
    }
}
