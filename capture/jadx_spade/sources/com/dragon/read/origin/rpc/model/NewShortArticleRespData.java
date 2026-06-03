package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NewShortArticleRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("item_id")
    public String itemID;

    @SerializedName("latest_version")
    public int latestVersion;

    static {
        Covode.recordClassIndex(613255);
        fieldTypeClassRef = FieldType.class;
    }
}
