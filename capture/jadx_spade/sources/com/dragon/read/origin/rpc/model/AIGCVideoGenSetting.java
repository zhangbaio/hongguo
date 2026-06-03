package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AIGCVideoGenSetting implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public long bookID;

    @SerializedName("book_quote_data")
    public String bookQuoteData;

    @SerializedName("commit_source")
    public UgcCommentCommitSourceEnum commitSource;
    public String description;

    @SerializedName("forum_id")
    public long forumID;

    @SerializedName("image_data_list")
    public List<ImageData> imageDataList;

    @SerializedName("item_id")
    public long itemID;

    @SerializedName("item_order")
    public int itemOrder;

    @SerializedName("item_version")
    public String itemVersion;

    @SerializedName("novel_content")
    public String novelContent;
    public PositionInfoV2 pos;
    public String text;

    @SerializedName("video_detail")
    public UgcVideoDetail videoDetail;

    @SerializedName("video_type")
    public AIGCVideoType videoType;

    static {
        Covode.recordClassIndex(612682);
        fieldTypeClassRef = FieldType.class;
    }
}
