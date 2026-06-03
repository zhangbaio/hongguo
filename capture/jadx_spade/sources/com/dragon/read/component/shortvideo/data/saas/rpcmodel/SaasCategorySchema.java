package com.dragon.read.component.shortvideo.data.saas.rpcmodel;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SaasCategorySchema implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("category_id")
    public long categoryId;
    public String name;
    public String schema;

    static {
        Covode.recordClassIndex(599088);
        fieldTypeClassRef = FieldType.class;
    }
}
