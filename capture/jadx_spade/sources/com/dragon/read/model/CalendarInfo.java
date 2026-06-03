package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CalendarInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String info;
    public List<Long> time;

    static {
        Covode.recordClassIndex(612052);
        fieldTypeClassRef = FieldType.class;
    }
}
