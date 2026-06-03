package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ModifyBookRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID)
    public long activityID;

    @SerializedName("book_id")
    public long bookID;

    @SerializedName("book_name")
    public String bookName;
    public String category;
    public Gender gender;

    @SerializedName("gift_word")
    public String giftWord;

    @SerializedName("group_category_id")
    public long groupCategoryID;

    @SerializedName("is_self_pic")
    public short isSelfPic;
    public String roles;

    @SerializedName("special_judge")
    public short specialJudge;
    public String summary;

    @SerializedName("thumb_uri")
    public String thumbURI;

    static {
        Covode.recordClassIndex(613229);
        fieldTypeClassRef = FieldType.class;
    }
}
