package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ImageFormatInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("backup_url")
    public String backupUrl;

    @SerializedName("main_url")
    public String mainUrl;
    public String size;

    static {
        Covode.recordClassIndex(613191);
        fieldTypeClassRef = FieldType.class;
    }
}
