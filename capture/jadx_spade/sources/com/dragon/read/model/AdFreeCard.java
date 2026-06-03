package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AdFreeCard implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String extra;
    public UserAdFreeItem listen;
    public UserAdFreeItem read;

    static {
        Covode.recordClassIndex(611995);
        fieldTypeClassRef = FieldType.class;
    }
}
