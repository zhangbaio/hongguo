package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ADDonePop implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Map<String, String> extra;
    public long id;
    public int sort;

    static {
        Covode.recordClassIndex(611990);
        fieldTypeClassRef = FieldType.class;
    }
}
