package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class Award implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String action;
    public int amount;

    @SerializedName("amount_type")
    public String amountType;
    public boolean completed;
    public String extra;

    @SerializedName("task_key")
    public String taskKey;
    public String url;

    static {
        Covode.recordClassIndex(612014);
        fieldTypeClassRef = FieldType.class;
    }
}
