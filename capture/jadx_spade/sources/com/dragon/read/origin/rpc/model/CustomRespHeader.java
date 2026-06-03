package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CustomRespHeader implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("X-Reading-Response")
    public String signRes;

    @SerializedName("X-Reading-Request")
    public String signSalt;

    @SerializedName("tt_stable")
    public String ttStable;

    @SerializedName("X-Reading-Verify-Code")
    public String verifyCode;

    static {
        Covode.recordClassIndex(612864);
        fieldTypeClassRef = FieldType.class;
    }
}
