package com.dragon.read.local.db.entity;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.DateUtils;
import com.dragon.read.base.util.LogWrapper;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class AddShelfDialogControlModel implements Serializable {
    public static final int $stable;
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private String bookId = "";
    private String dateTime = "";
    private int lastReadCount;
    private int readCount;
    private int todayShowCount;

    public static final class a {
        static {
            Covode.recordClassIndex(611547);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(611546);
        Companion = new a(null);
        $stable = 8;
    }

    public final String getBookId() {
        return this.bookId;
    }

    public final String getDateTime() {
        return this.dateTime;
    }

    public final int getLastReadCount() {
        return this.lastReadCount;
    }

    public final int getReadCount() {
        return this.readCount;
    }

    public final void updateAfterShow() {
        setLastReadCount(this.readCount);
        setTodayShowCount(getTodayShowCount() + 1);
    }

    public final void addReadCount() {
        this.readCount++;
        LogWrapper.info("AddShelfDialogControlModel", "[addReadCount]bookId = " + this.bookId + ",readCount = " + this.readCount, new Object[0]);
    }

    public final int getTodayShowCount() {
        if (!Intrinsics.areEqual(this.dateTime, DateUtils.getCurrentDate())) {
            LogWrapper.info("AddShelfDialogControlModel", "[getTodayShowCount]set todayShowCount = 0,bookId = " + this.bookId + ",dateTime = " + this.dateTime, new Object[0]);
            String currentDate = DateUtils.getCurrentDate();
            Intrinsics.checkNotNullExpressionValue(currentDate, "getCurrentDate(...)");
            this.dateTime = currentDate;
            this.todayShowCount = 0;
        }
        return this.todayShowCount;
    }

    public String toString() {
        return "ShelfControlModel(bookId='" + this.bookId + "', dateTime='" + this.dateTime + "', lastReadCount=" + this.lastReadCount + ", readCount=" + this.readCount + ", todayShowCount=" + getTodayShowCount() + ')';
    }

    public final void setReadCount(int i) {
        this.readCount = i;
    }

    public final void setBookId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bookId = str;
    }

    public final void setDateTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dateTime = str;
    }

    public final void setLastReadCount(int i) {
        LogWrapper.info("AddShelfDialogControlModel", "[lastReadCount]bookId = " + this.bookId + ",lastReadCount = " + i, new Object[0]);
        this.lastReadCount = i;
    }

    public final void setTodayShowCount(int i) {
        LogWrapper.info("AddShelfDialogControlModel", "[setTodayShowCount]bookId = " + this.bookId + ",todayShowCount = " + i, new Object[0]);
        this.todayShowCount = i;
    }
}
