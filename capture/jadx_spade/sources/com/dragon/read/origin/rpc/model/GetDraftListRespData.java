package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetDraftListRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("creation_status")
    public CreationStatus creationStatus;

    @SerializedName("draft_list")
    public List<DraftList> draftList;

    @SerializedName("total_count")
    public int totalCount;

    static {
        Covode.recordClassIndex(613110);
        fieldTypeClassRef = FieldType.class;
    }
}
