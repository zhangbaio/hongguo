package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ProblemMarkInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("mark_list")
    public List<CMarkElem> markList;
    public String problem;

    static {
        Covode.recordClassIndex(613325);
        fieldTypeClassRef = FieldType.class;
    }
}
