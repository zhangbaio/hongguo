package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ChapterAdjustRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public short direction;

    @SerializedName("item_id")
    public long itemID;

    @SerializedName("origin_volume_id")
    public long originVolumeID;

    @SerializedName("target_order")
    public int targetOrder;

    @SerializedName("target_volume_id")
    public long targetVolumeID;

    static {
        Covode.recordClassIndex(612797);
        fieldTypeClassRef = FieldType.class;
    }
}
