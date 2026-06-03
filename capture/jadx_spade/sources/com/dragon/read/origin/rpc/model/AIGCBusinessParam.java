package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AIGCBusinessParam implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("after_novel_content")
    public String afterNovelContent;

    @SerializedName("before_novel_content")
    public String beforeNovelContent;

    @SerializedName("book_id")
    public long bookID;
    public Map<String, String> extra;

    @SerializedName("forum_id")
    public long forumID;

    @SerializedName("gen_style")
    public String genStyle;

    @SerializedName("image_data_list")
    public List<ImageData> imageDataList;

    @SerializedName("image_type")
    public AIGCImageType imageType;

    @SerializedName("item_id")
    public long itemID;

    @SerializedName("item_order")
    public int itemOrder;

    @SerializedName("item_version")
    public String itemVersion;

    @SerializedName("log_extra")
    public UgcLogExtra logExtra;

    @SerializedName("novel_content")
    public String novelContent;
    public PositionInfoV2 pos;

    @SerializedName("post_id")
    public long postID;
    public AIGCImageSize size;
    public AIGCImageStyle style;

    @SerializedName("style_v2")
    public String styleV2;
    public String text;

    @SerializedName("use_async")
    public boolean useAsync;

    @SerializedName("use_llm_rephraser")
    public boolean useLLMRephraser;

    @SerializedName("video_type")
    public AIGCVideoType videoType;

    static {
        Covode.recordClassIndex(612671);
        fieldTypeClassRef = FieldType.class;
    }
}
