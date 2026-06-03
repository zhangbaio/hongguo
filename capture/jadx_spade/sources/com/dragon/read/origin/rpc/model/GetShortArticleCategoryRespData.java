package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetShortArticleCategoryRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("category_list")
    public List<CategoryMetaData> categoryList;

    @SerializedName("wide_category_list")
    public List<CategoryMetaData> wideCategoryList;

    static {
        Covode.recordClassIndex(613148);
        fieldTypeClassRef = FieldType.class;
    }
}
