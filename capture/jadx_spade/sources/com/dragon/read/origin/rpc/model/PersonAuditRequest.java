package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PersonAuditRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("author_id")
    public String authorID;

    @SerializedName("author_name")
    public String authorName;

    @SerializedName("author_phone")
    public String authorPhone;
    public PersonAuditType type;

    static {
        Covode.recordClassIndex(613280);
        fieldTypeClassRef = FieldType.class;
    }
}
