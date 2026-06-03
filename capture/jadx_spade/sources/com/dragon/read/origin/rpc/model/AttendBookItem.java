package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AttendBookItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("attend_day")
    public int attendDay;

    @SerializedName("book_id")
    public String bookID;

    @SerializedName("book_name")
    public String bookName;

    @SerializedName("can_leave")
    public boolean canLeave;

    @SerializedName("days_attend_month_count")
    public int daysAttendMonthCount;

    @SerializedName("in_attend_activity")
    public short inAttendActivity;

    @SerializedName("last_chapter_title")
    public String lastChapterTitle;

    @SerializedName("leave_date")
    public String leaveDate;

    @SerializedName("leave_limit")
    public int leaveLimit;

    @SerializedName("thumb_uri")
    public String thumbURI;

    @SerializedName("thumb_url_list")
    public List<ImageFormatInfo> thumbUrlList;

    @SerializedName("words_attend_count_monthly")
    public int wordsAttendCountMonthly;

    @SerializedName("words_attend_day_count")
    public int wordsAttendDayCount;

    static {
        Covode.recordClassIndex(612740);
        fieldTypeClassRef = FieldType.class;
    }
}
