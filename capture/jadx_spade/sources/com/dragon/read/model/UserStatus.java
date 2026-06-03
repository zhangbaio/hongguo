package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UserStatus implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("has_low_activity_signin")
    public boolean hasLowActivitySignin;

    @SerializedName("inactive_info")
    public InactiveInfo inactiveInfo;
    public String status;

    static {
        Covode.recordClassIndex(612287);
        fieldTypeClassRef = FieldType.class;
    }
}
