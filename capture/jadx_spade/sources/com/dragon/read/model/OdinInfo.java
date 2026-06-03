package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class OdinInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("register_time")
    public long registerTime;
    public long uid;

    @SerializedName("uid_type")
    public int uidType;

    @SerializedName("user_is_auth")
    public int userIsAuth;

    static {
        Covode.recordClassIndex(612171);
        fieldTypeClassRef = FieldType.class;
    }
}
