package com.dragon.read.component.shortvideo.api.model;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class RecBookData implements Serializable {
    private final String bookId;
    private String bookName;
    private String bookType;
    private String recommendGroupId;
    private String recommendInfo;
    private String thumbUrl;

    static {
        Covode.recordClassIndex(598786);
    }

    public final String getBookId() {
        return this.bookId;
    }

    public final String getBookName() {
        return this.bookName;
    }

    public final String getBookType() {
        return this.bookType;
    }

    public final String getRecommendGroupId() {
        return this.recommendGroupId;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final String getThumbUrl() {
        return this.thumbUrl;
    }

    public final void setBookName(String str) {
        this.bookName = str;
    }

    public final void setBookType(String str) {
        this.bookType = str;
    }

    public final void setRecommendGroupId(String str) {
        this.recommendGroupId = str;
    }

    public final void setRecommendInfo(String str) {
        this.recommendInfo = str;
    }

    public final void setThumbUrl(String str) {
        this.thumbUrl = str;
    }

    public RecBookData(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        this.bookId = bookId;
    }
}
