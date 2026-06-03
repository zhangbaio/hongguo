package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetAICategoryListRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_category_id")
    public String bookCategoryID;

    @SerializedName("category_list")
    public List<Category> categoryList;

    static {
        Covode.recordClassIndex(612984);
        fieldTypeClassRef = FieldType.class;
    }
}
