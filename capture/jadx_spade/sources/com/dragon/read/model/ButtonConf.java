package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ButtonConf implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public ActionInfo action;
    public String text;

    static {
        Covode.recordClassIndex(612049);
        fieldTypeClassRef = FieldType.class;
    }
}
