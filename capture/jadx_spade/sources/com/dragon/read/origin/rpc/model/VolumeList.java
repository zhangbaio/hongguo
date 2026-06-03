package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class VolumeList implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public String bookID;

    @SerializedName("can_delete")
    public boolean canDelete;
    public int index;

    @SerializedName("item_count")
    public int itemCount;

    @SerializedName("volume_id")
    public String volumeID;

    @SerializedName("volume_name")
    public String volumeName;

    static {
        Covode.recordClassIndex(613573);
        fieldTypeClassRef = FieldType.class;
    }
}
