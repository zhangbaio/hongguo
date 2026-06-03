package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AIGCImageGenSetting implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public long bookID;

    @SerializedName("commit_source")
    public UgcCommentCommitSourceEnum commitSource;
    public String description;
    public Map<String, String> extra;

    @SerializedName("forum_id")
    public long forumID;

    @SerializedName("gen_style")
    public String genStyle;

    @SerializedName("image_data")
    public ImageData imageData;

    @SerializedName("image_type")
    public AIGCImageType imageType;

    @SerializedName("item_id")
    public long itemID;

    @SerializedName("item_order")
    public int itemOrder;

    @SerializedName("item_version")
    public String itemVersion;

    @SerializedName("no_watermark_uri")
    public String noWatermarkUri;

    @SerializedName("novel_content")
    public String novelContent;
    public PositionInfoV2 pos;
    public AIGCImageSize size;
    public AIGCImageStyle style;

    @SerializedName("style_v2")
    public String styleV2;

    @SerializedName("use_llm_rephraser")
    public boolean useLLMRephraser;

    @SerializedName("user_input")
    public String userInput;

    static {
        Covode.recordClassIndex(612676);
        fieldTypeClassRef = FieldType.class;
    }
}
