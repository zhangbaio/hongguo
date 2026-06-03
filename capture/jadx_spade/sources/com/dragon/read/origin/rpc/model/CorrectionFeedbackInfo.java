package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CorrectionFeedbackInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("correct_word")
    public String correctWord;

    @SerializedName("paragraph_idx")
    public int paragraphIdx;

    @SerializedName("word_offset")
    public int wordOffset;

    @SerializedName("wrong_word")
    public String wrongWord;

    static {
        Covode.recordClassIndex(612847);
        fieldTypeClassRef = FieldType.class;
    }
}
