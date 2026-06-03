package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SignLevelStatus implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("expect_word_number")
    public int expectWordNumber;

    @SerializedName("sign_level")
    public short signLevel;

    static {
        Covode.recordClassIndex(613452);
        fieldTypeClassRef = FieldType.class;
    }
}
