package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetAIExpandRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("filter_sensitive")
    public boolean filterSensitive;

    @SerializedName("generate_id")
    public long generateID;
    public long offset;

    static {
        Covode.recordClassIndex(613013);
        fieldTypeClassRef = FieldType.class;
    }
}
