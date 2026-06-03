package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ReportResourceReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String action;
    public String extra;
    public String key;
    public String type;

    static {
        Covode.recordClassIndex(612225);
        fieldTypeClassRef = FieldType.class;
    }
}
