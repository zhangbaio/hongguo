package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum GenDataType {
    AIVideoGen(1001),
    AIVideoScriptGen(1002);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612933);
    }

    public static GenDataType findByValue(int i) {
        if (i != 1001) {
            if (i != 1002) {
                return null;
            }
            return AIVideoScriptGen;
        }
        return AIVideoGen;
    }

    GenDataType(int i) {
        this.value = i;
    }
}
