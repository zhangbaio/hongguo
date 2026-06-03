package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetShortArticleDraftListRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_image_fmt_list")
    @RpcField(FieldType.QUERY)
    public List<String> bookImageFmtList;

    @SerializedName("image_fmt_list")
    public List<String> imageFmtList;

    @SerializedName("page_count")
    public short pageCount;

    @SerializedName("page_index")
    public short pageIndex;

    @SerializedName("time_sort")
    public ShortArticleTimeSortStatus timeSort;

    static {
        Covode.recordClassIndex(613156);
        fieldTypeClassRef = FieldType.class;
    }
}
