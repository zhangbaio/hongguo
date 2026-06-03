package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GameData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String subtitle;
    public String tips;
    public String title;
    public String url;

    static {
        Covode.recordClassIndex(612106);
        fieldTypeClassRef = FieldType.class;
    }
}
