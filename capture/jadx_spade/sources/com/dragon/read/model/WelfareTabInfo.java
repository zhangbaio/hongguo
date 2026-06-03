package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class WelfareTabInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public List<WelfarePendant> bubble;
    public String id;
    public String name;
    public List<WelfarePendant> point;
    public String schema;

    static {
        Covode.recordClassIndex(612306);
        fieldTypeClassRef = FieldType.class;
    }
}
