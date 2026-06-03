package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ItemInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("item_id")
    public long itemID;
    public String title;

    @SerializedName("volume_id")
    public long volumeID;

    @SerializedName("volume_name")
    public String volumeName;

    static {
        Covode.recordClassIndex(613209);
        fieldTypeClassRef = FieldType.class;
    }
}
