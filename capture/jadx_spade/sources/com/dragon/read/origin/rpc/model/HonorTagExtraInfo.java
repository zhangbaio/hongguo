package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class HonorTagExtraInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("have_honor_book_count")
    public String haveHonorBookCount;

    @SerializedName("inner_info")
    public String innerInfo;

    @SerializedName("is_expanded")
    public boolean isExpanded;

    @SerializedName("outer_info")
    public String outerInfo;

    @SerializedName("tag_top_sub_info")
    public String tagTopSubInfo;

    @SerializedName("user_get_book_count")
    public String userGetBookCount;

    static {
        Covode.recordClassIndex(613188);
        fieldTypeClassRef = FieldType.class;
    }
}
