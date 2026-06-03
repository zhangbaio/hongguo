package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class DraftList implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int index;

    @SerializedName("item_id")
    public String itemID;

    @SerializedName("modify_time")
    public String modifyTime;
    public String title;

    @SerializedName("volume_id")
    public String volumeID;

    @SerializedName("volume_name")
    public String volumeName;

    @SerializedName("word_number")
    public long wordNumber;

    static {
        Covode.recordClassIndex(612896);
        fieldTypeClassRef = FieldType.class;
    }
}
