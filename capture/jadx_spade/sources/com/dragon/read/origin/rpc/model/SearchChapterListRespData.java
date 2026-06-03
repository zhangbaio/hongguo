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
public class SearchChapterListRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("creation_status")
    @RpcField(FieldType.BODY)
    public CreationStatus creationStatus;

    @SerializedName("search_chapter_list")
    @RpcField(FieldType.BODY)
    public List<ChapterList> searchChapterList;

    @SerializedName("total_count")
    @RpcField(FieldType.BODY)
    public int totalCount;

    static {
        Covode.recordClassIndex(613403);
        fieldTypeClassRef = FieldType.class;
    }
}
