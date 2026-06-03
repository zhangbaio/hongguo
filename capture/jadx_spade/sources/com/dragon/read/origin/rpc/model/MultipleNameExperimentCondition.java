package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class MultipleNameExperimentCondition implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public boolean completed;
    public String description;
    public short type;

    static {
        Covode.recordClassIndex(613244);
        fieldTypeClassRef = FieldType.class;
    }
}
