package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class DowngradeConf implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String detailed;

    @SerializedName("open_recover")
    public boolean openRecover;

    @SerializedName("open_schema")
    public String openSchema;

    @SerializedName("task_module")
    public TaskPageDowngradeConf taskModule;
    public int type;

    static {
        Covode.recordClassIndex(612074);
        fieldTypeClassRef = FieldType.class;
    }
}
