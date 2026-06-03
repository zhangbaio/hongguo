package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetBankDetailResData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("bank_detail_list")
    public List<BankDetailData> bankDetailList;

    static {
        Covode.recordClassIndex(613053);
        fieldTypeClassRef = FieldType.class;
    }
}
