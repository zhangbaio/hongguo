package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BankNameData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("bank_code")
    public String bankCode;

    @SerializedName("bank_name")
    public String bankName;

    static {
        Covode.recordClassIndex(612763);
        fieldTypeClassRef = FieldType.class;
    }
}
