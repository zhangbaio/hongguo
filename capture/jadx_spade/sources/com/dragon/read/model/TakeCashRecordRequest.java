package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TakeCashRecordRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("take_cash_record_id")
    public long takeCashRecordId;

    @SerializedName("take_cash_scene")
    public String takeCashScene;

    static {
        Covode.recordClassIndex(612266);
        fieldTypeClassRef = FieldType.class;
    }
}
