package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TaskPageDowngradeConf implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public ButtonConf button;

    @SerializedName("open_recover")
    public boolean openRecover;
    public String subtitle;
    public String title;

    static {
        Covode.recordClassIndex(612275);
        fieldTypeClassRef = FieldType.class;
    }
}
