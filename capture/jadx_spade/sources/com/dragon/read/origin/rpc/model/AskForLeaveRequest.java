package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AskForLeaveRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("attend_activity_id")
    public long attendActivityID;

    @SerializedName("book_id")
    public long bookID;
    public long date;

    static {
        Covode.recordClassIndex(612737);
        fieldTypeClassRef = FieldType.class;
    }
}
