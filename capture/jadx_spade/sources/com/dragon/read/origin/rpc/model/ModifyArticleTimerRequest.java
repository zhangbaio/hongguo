package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ModifyArticleTimerRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public long bookID;

    @SerializedName("item_id")
    public long itemID;

    @SerializedName("preview_content")
    public String previewContent;

    @SerializedName("preview_type")
    public short previewType;

    @SerializedName("timer_time")
    public long timerTime;

    @SerializedName("timer_type")
    public ArticleTimerType timerType;

    static {
        Covode.recordClassIndex(613227);
        fieldTypeClassRef = FieldType.class;
    }
}
