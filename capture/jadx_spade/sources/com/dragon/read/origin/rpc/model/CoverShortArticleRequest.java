package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CoverShortArticleRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_thumb_uri")
    public String bookThumbURI;
    public String category;
    public String content;

    @SerializedName("item_id")
    public long itemID;

    @SerializedName("item_version")
    public int itemVersion;

    @SerializedName("multi_title")
    public String multiTitle;

    @SerializedName("sign_type")
    public short signType;

    @SerializedName("thumb_uri")
    public String thumbURI;

    static {
        Covode.recordClassIndex(612851);
        fieldTypeClassRef = FieldType.class;
    }
}
