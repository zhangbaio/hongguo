package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ESignCallBackRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("download_url")
    public String downloadURL;

    @SerializedName("result_code")
    public long resultCode;

    @SerializedName("transaction_id")
    public String transactionID;

    static {
        Covode.recordClassIndex(612901);
        fieldTypeClassRef = FieldType.class;
    }
}
