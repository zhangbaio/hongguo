package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TopicTag implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Map<String, String> extra;

    @SerializedName("forum_id")
    public String forumId;

    @SerializedName("other_ids")
    public Map<OtherAttachID, String> otherIds;

    @SerializedName("pic_url")
    public String picUrl;
    public String schema;
    public UgcTagStatus status;
    public String tag;

    @SerializedName("tag_id")
    public String tagId;

    @SerializedName("tag_suffix")
    public String tagSuffix;

    @SerializedName("tag_topic_id")
    public String tagTopicId;

    @SerializedName("tag_type")
    public UgcTagType tagType;

    static {
        Covode.recordClassIndex(613484);
        fieldTypeClassRef = FieldType.class;
    }
}
