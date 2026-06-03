package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BookmallBubbleResult implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("bubble_list")
    public List<BookmallBubble> bubbleList;

    static {
        Covode.recordClassIndex(612041);
        fieldTypeClassRef = FieldType.class;
    }
}
