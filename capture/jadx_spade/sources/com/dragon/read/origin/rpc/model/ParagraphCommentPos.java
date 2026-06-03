package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ParagraphCommentPos implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("end_media_index")
    public int endMediaIndex;

    @SerializedName("end_para_index")
    public int endParaIndex;

    @SerializedName("end_word_pos")
    public int endWordPos;

    @SerializedName("start_media_index")
    public int startMediaIndex;

    @SerializedName("start_para_index")
    public int startParaIndex;

    @SerializedName("start_word_pos")
    public int startWordPos;

    static {
        Covode.recordClassIndex(613276);
        fieldTypeClassRef = FieldType.class;
    }
}
