package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class HonorTagBriefInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("honor_tag_detail_list")
    public List<HonorTagDetail> honorTagDetailList;
    public String schema;

    static {
        Covode.recordClassIndex(613186);
        fieldTypeClassRef = FieldType.class;
    }
}
