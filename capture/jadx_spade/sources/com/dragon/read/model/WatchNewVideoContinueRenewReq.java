package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class WatchNewVideoContinueRenewReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("consume_time")
    public long consumeTime;

    static {
        Covode.recordClassIndex(612300);
        fieldTypeClassRef = FieldType.class;
    }
}
