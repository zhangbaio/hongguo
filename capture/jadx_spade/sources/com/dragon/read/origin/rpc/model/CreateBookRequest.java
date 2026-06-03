package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CreateBookRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID)
    public long activityID;

    @SerializedName("book_name")
    public String bookName;
    public String category;
    public Gender gender;

    @SerializedName("group_category_id")
    public long groupCategoryID;

    @SerializedName("group_name")
    public String groupName;

    @SerializedName("is_default_book")
    public short isDefaultBook;

    @SerializedName("is_self_pic")
    public short isSelfPic;
    public String roles;
    public String summary;

    @SerializedName("thumb_uri")
    public String thumbURI;

    @SerializedName("User-Agent")
    @RpcField(FieldType.HEADER)
    public String userAgent;

    static {
        Covode.recordClassIndex(612855);
        fieldTypeClassRef = FieldType.class;
    }
}
