package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BookPopup implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("button_text")
    public String buttonText;

    @SerializedName("calendar_info")
    public List<CalendarInfo> calendarInfo;

    @SerializedName("is_pop")
    public boolean isPop;

    @SerializedName("main_title")
    public String mainTitle;

    @SerializedName("sub_title")
    public String subTitle;

    @SerializedName("task_key")
    public String taskKey;
    public String title;

    static {
        Covode.recordClassIndex(612037);
        fieldTypeClassRef = FieldType.class;
    }
}
