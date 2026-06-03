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
public class PublishArticleRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public long bookID;

    @SerializedName("chapter_ad_types")
    public String chapterAdTypes;

    @SerializedName("X-Real-Port")
    @RpcField(FieldType.HEADER)
    public String clientPort;
    public String content;

    @SerializedName("Http-X-Forwarded-For")
    @RpcField(FieldType.HEADER)
    public List<String> hTTPXForwardedFor;

    @SerializedName("has_chapter_ad")
    public boolean hasChapterAd;

    @SerializedName("item_id")
    public long itemID;

    @SerializedName("publish_status")
    public PublishStatus publishStatus;

    @SerializedName("speak_content")
    public String speakContent;

    @SerializedName("speak_delete")
    public short speakDelete;

    @SerializedName("speak_id")
    public long speakID;

    @SerializedName("speak_type")
    public SpeakType speakType;

    @SerializedName("timer_chapter_preview")
    public String timerChapterPreview;

    @SerializedName("timer_status")
    public TimerStatus timerStatus;

    @SerializedName("timer_time")
    public long timerTime;
    public String title;

    @SerializedName("use_ai")
    public short useAI;

    @SerializedName("User-Agent")
    @RpcField(FieldType.HEADER)
    public String userAgent;

    @SerializedName("volume_id")
    public long volumeID;

    @SerializedName("volume_name")
    public String volumeName;

    @SerializedName("X-Forwarded-For")
    @RpcField(FieldType.HEADER)
    public List<String> xForwardedFor;

    static {
        Covode.recordClassIndex(613331);
        fieldTypeClassRef = FieldType.class;
    }
}
