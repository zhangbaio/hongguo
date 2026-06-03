package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UgcLynxDataV2 implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String config;

    @SerializedName("content_id")
    public String contentID;
    public String data;

    @SerializedName("url")
    public String uRL;

    static {
        Covode.recordClassIndex(613513);
        fieldTypeClassRef = FieldType.class;
    }
}
