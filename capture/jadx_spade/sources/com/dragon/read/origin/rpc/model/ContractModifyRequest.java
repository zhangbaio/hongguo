package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ContractModifyRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("author_guardian_phone")
    public String authorGuardianPhone;

    @SerializedName("author_phone")
    public String authorPhone;

    @SerializedName("book_id")
    public long bookID;

    @SerializedName("guardian_cert_list")
    public String guardianCertList;

    static {
        Covode.recordClassIndex(612845);
        fieldTypeClassRef = FieldType.class;
    }
}
