package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.List;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PublishShortArticleRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID)
    public int activityID;

    @SerializedName("book_thumb_uri")
    public String bookThumbURI;
    public String category;

    @SerializedName("X-Real-Port")
    @RpcField(FieldType.HEADER)
    public String clientPort;
    public String content;

    @SerializedName("Http-X-Forwarded-For")
    @RpcField(FieldType.HEADER)
    public List<String> hTTPXForwardedFor;

    @SerializedName("item_id")
    public long itemID;

    @SerializedName("multi_title")
    public String multiTitle;

    @SerializedName("sign_type")
    public short signType;

    @SerializedName("story_origin_divided_chapters")
    @RpcField(FieldType.BODY)
    public short storyOriginDividedChapters;

    @SerializedName("thumb_uri")
    public String thumbURI;

    @SerializedName("use_ai")
    @RpcField(FieldType.BODY)
    public short useAI;

    @SerializedName("User-Agent")
    @RpcField(FieldType.HEADER)
    public String userAgent;

    @SerializedName("X-Forwarded-For")
    @RpcField(FieldType.HEADER)
    public List<String> xForwardedFor;

    static {
        Covode.recordClassIndex(613345);
        fieldTypeClassRef = FieldType.class;
    }
}
