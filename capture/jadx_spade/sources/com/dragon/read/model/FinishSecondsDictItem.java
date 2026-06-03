package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class FinishSecondsDictItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("finish_seconds_list")
    public List<Integer> finishSecondsList;

    @SerializedName("read_type")
    public String readType;

    static {
        Covode.recordClassIndex(612100);
        fieldTypeClassRef = FieldType.class;
    }
}
