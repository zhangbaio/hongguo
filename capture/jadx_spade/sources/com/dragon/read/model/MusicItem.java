package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class MusicItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("cover_url")
    public String coverUrl;
    public String schema;

    @SerializedName("sub_title")
    public String subTitle;
    public String title;
    public String zlink;

    static {
        Covode.recordClassIndex(612157);
        fieldTypeClassRef = FieldType.class;
    }
}
