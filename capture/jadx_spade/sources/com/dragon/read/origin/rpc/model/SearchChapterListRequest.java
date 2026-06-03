package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SearchChapterListRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    @RpcField(FieldType.QUERY)
    public long bookID;

    @SerializedName("page_count")
    @RpcField(FieldType.QUERY)
    public int pageCount;

    @SerializedName("page_index")
    @RpcField(FieldType.QUERY)
    public int pageIndex;

    @SerializedName("query_word")
    @RpcField(FieldType.QUERY)
    public String queryWord;

    static {
        Covode.recordClassIndex(613402);
        fieldTypeClassRef = FieldType.class;
    }
}
