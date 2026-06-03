package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class WatchHistoryShortVideoDetailReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("enter_from")
    public String enterFrom;

    static {
        Covode.recordClassIndex(612297);
        fieldTypeClassRef = FieldType.class;
    }
}
