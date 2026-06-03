package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class Range implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public long max;
    public long min;

    static {
        Covode.recordClassIndex(613351);
        fieldTypeClassRef = FieldType.class;
    }
}
