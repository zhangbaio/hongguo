package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UserAdFreeItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String extra;
    public long seconds;
    public String subtitle;
    public String url;

    static {
        Covode.recordClassIndex(612283);
        fieldTypeClassRef = FieldType.class;
    }
}
