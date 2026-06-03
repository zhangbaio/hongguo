package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CategoryMetaData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("category_id")
    public long categoryID;

    @SerializedName("cover_uri")
    public String coverURI;
    public String description;
    public String label;
    public String name;

    static {
        Covode.recordClassIndex(612788);
        fieldTypeClassRef = FieldType.class;
    }
}
