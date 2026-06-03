package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AdvertInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("class_name")
    public String className;

    @SerializedName("industry_id")
    public int industryID;
    public String name;
    public ChapterAdType type;

    static {
        Covode.recordClassIndex(612725);
        fieldTypeClassRef = FieldType.class;
    }
}
