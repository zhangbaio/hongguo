package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CommonPopupData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public CommonPopupDataExtra extra;
    public String subtitle;
    public String title;
    public String type;

    static {
        Covode.recordClassIndex(612062);
        fieldTypeClassRef = FieldType.class;
    }
}
