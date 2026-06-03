package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AdFreePopupInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_list")
    public List<RecommendBook> bookList;
    public Content contents;
    public AdFreePopupExtra extra;
    public int hours;

    @SerializedName("popup_name")
    public String popupName;
    public String premise;

    @SerializedName("primary_button")
    public TextInfo primaryButton;

    @SerializedName("sub_title")
    public String subTitle;

    @SerializedName("task_key")
    public String taskKey;
    public String title;
    public String type;

    static {
        Covode.recordClassIndex(611998);
        fieldTypeClassRef = FieldType.class;
    }
}
