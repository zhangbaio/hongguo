package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class InnerCommonListInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String cursor;

    @SerializedName("has_more")
    public boolean hasMore;

    @SerializedName("log_extra")
    public UgcLogExtra logExtra;

    @SerializedName("prev_has_more")
    public boolean prevHasMore;
    public int total;

    static {
        Covode.recordClassIndex(613195);
        fieldTypeClassRef = FieldType.class;
    }
}
