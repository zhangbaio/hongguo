package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PostInviteCodeRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("invite_code")
    public String inviteCode;

    @SerializedName("is_from_page")
    public boolean isFromPage;

    @SerializedName("is_scan")
    public boolean isScan;
    public int type;

    static {
        Covode.recordClassIndex(612196);
        fieldTypeClassRef = FieldType.class;
    }
}
