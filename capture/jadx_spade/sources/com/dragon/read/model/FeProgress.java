package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class FeProgress implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Map<String, List<FeContentElement>> meta;
    public List<Map<String, List<FeContentElement>>> nodes;

    static {
        Covode.recordClassIndex(612096);
        fieldTypeClassRef = FieldType.class;
    }
}
