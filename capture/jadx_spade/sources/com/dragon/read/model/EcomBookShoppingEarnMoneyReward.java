package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class EcomBookShoppingEarnMoneyReward implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;
    public long duration;
    public String type;

    static {
        Covode.recordClassIndex(612078);
        fieldTypeClassRef = FieldType.class;
    }
}
