package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PublishAuthorSpeakRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;

    @SerializedName("is_draft")
    public short isDraft;

    @SerializedName("item_id")
    public long itemID;

    @SerializedName("speak_id")
    public long speakID;

    @SerializedName("speak_type")
    public SpeakType speakType;

    static {
        Covode.recordClassIndex(613334);
        fieldTypeClassRef = FieldType.class;
    }
}
