package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ExcitationAdData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;
    public ExcitationAdExtraData extraData;
    public String taskKey;

    static {
        Covode.recordClassIndex(612087);
        fieldTypeClassRef = FieldType.class;
    }
}
