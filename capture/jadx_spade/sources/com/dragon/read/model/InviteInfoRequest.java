package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class InviteInfoRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("invite_code")
    public String inviteCode;

    @SerializedName("is_scan")
    public boolean isScan;

    static {
        Covode.recordClassIndex(612128);
        fieldTypeClassRef = FieldType.class;
    }
}
