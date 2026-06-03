package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ShortArticleDraftList implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_thumb_uri")
    @RpcField(FieldType.BODY)
    public String bookThumbURI;

    @SerializedName("book_thumb_url_list")
    @RpcField(FieldType.BODY)
    public List<ImageFormatInfo> bookThumbUrlList;
    public List<CategoryMetaData> category;

    @SerializedName("create_time")
    public String createTime;

    @SerializedName("item_id")
    public String itemID;

    @SerializedName("modify_time")
    public String modifyTime;

    @SerializedName("multi_title")
    public List<String> multiTitle;

    @SerializedName("thumb_uri")
    public String thumbURI;

    @SerializedName("thumb_url_list")
    public List<ImageFormatInfo> thumbUrlList;

    @SerializedName("word_number")
    public long wordNumber;

    static {
        Covode.recordClassIndex(613446);
        fieldTypeClassRef = FieldType.class;
    }
}
