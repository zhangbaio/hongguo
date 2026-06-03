package com.dragon.read.component.shortvideo.api.model;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.report.PageRecorder;
import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoListLaunchArgs implements Serializable {
    public static final a Companion;
    private static final LogHelper logHelper;
    private static final long serialVersionUID = 0;
    private long bookstoreId;
    private Map<String, ? extends Serializable> extraMap;
    private String openSchema;
    private PageRecorder pageRecorder;
    private int tabType;
    private int targetIndex;
    private String postId = "";
    private String recommendInfo = "";
    private String recommendGroupId = "";

    public static final class a {
        static {
            Covode.recordClassIndex(598814);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final long getBookstoreId() {
        return this.bookstoreId;
    }

    public final Map<String, Serializable> getExtraMap() {
        return this.extraMap;
    }

    public final String getOpenSchema() {
        return this.openSchema;
    }

    public final PageRecorder getPageRecorder() {
        return this.pageRecorder;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final String getRecommendGroupId() {
        return this.recommendGroupId;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final int getTabType() {
        return this.tabType;
    }

    public final int getTargetIndex() {
        return this.targetIndex;
    }

    static {
        Covode.recordClassIndex(598813);
        Companion = new a(null);
        logHelper = new LogHelper("VideoListLaunchArgs");
    }

    public final void setBookStoreId(long j) {
        this.bookstoreId = j;
    }

    public final void setExtraMap(Map<String, ? extends Serializable> map) {
        this.extraMap = map;
    }

    public final void setOpenSchema(String str) {
        this.openSchema = str;
    }

    public final void setPageRecorder(PageRecorder pageRecorder) {
        this.pageRecorder = pageRecorder;
    }

    public final void setTabType(int i) {
        this.tabType = i;
    }

    public final void setPostId(String postId) {
        Intrinsics.checkNotNullParameter(postId, "postId");
        this.postId = postId;
    }

    public final VideoListLaunchArgs setRecommendGroupId(String recommendGroupId) {
        Intrinsics.checkNotNullParameter(recommendGroupId, "recommendGroupId");
        this.recommendGroupId = recommendGroupId;
        return this;
    }

    public final VideoListLaunchArgs setRecommendInfo(String recommendInfo) {
        Intrinsics.checkNotNullParameter(recommendInfo, "recommendInfo");
        this.recommendInfo = recommendInfo;
        return this;
    }

    public final void setBookStoreId(String bookstoreIdStr) {
        Long longOrNull;
        long j;
        Intrinsics.checkNotNullParameter(bookstoreIdStr, "bookstoreIdStr");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(bookstoreIdStr);
        if (longOrNull != null) {
            j = longOrNull.longValue();
        } else {
            j = 0;
        }
        this.bookstoreId = j;
    }

    public final void setTabType(String tabTypeStr) {
        Integer intOrNull;
        int i;
        Intrinsics.checkNotNullParameter(tabTypeStr, "tabTypeStr");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(tabTypeStr);
        if (intOrNull != null) {
            i = intOrNull.intValue();
        } else {
            i = 0;
        }
        this.tabType = i;
    }

    public final void setTargetIndex(String indexStr) {
        Integer intOrNull;
        int i;
        Intrinsics.checkNotNullParameter(indexStr, "indexStr");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(indexStr);
        if (intOrNull != null) {
            i = intOrNull.intValue();
        } else {
            i = 0;
        }
        this.targetIndex = i;
    }
}
