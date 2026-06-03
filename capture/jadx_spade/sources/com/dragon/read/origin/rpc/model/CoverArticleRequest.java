package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CoverArticleRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public long bookID;
    public String content;

    @SerializedName("item_id")
    public long itemID;

    @SerializedName("item_version")
    public int itemVersion;
    public String title;

    @SerializedName("volume_id")
    public long volumeID;

    @SerializedName("volume_name")
    public String volumeName;

    static {
        Covode.recordClassIndex(612848);
        fieldTypeClassRef = FieldType.class;
    }
}
