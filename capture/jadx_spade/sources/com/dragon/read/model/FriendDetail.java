package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class FriendDetail implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public UserAppearanceInfo appearance;
    public Reward reward;

    static {
        Covode.recordClassIndex(612104);
        fieldTypeClassRef = FieldType.class;
    }
}
