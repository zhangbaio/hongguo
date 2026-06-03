package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetAIRewriteRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;
    public boolean finished;

    @SerializedName("hit_sensitive")
    public boolean hitSensitive;

    @SerializedName("next_offset")
    public long nextOffset;

    static {
        Covode.recordClassIndex(613023);
        fieldTypeClassRef = FieldType.class;
    }
}
