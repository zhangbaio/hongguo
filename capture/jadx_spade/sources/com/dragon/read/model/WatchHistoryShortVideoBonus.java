package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class WatchHistoryShortVideoBonus implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;

    @SerializedName("is_completed")
    public boolean isCompleted;
    public String type;

    @SerializedName("watch_seconds")
    public int watchSeconds;

    static {
        Covode.recordClassIndex(612295);
        fieldTypeClassRef = FieldType.class;
    }
}
