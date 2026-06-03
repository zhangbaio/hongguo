package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class StartPhoto implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("file_name")
    public String fileName;
    public String size;
    public String uri;
    public String url;

    static {
        Covode.recordClassIndex(613459);
        fieldTypeClassRef = FieldType.class;
    }
}
