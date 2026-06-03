package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UgcUserSticker implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("expire_time")
    public int expireTime;

    @SerializedName("is_worn")
    public boolean isWorn;
    public UgcSticker sticker;

    static {
        Covode.recordClassIndex(613533);
        fieldTypeClassRef = FieldType.class;
    }
}
