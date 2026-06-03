package com.dragon.read.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum Scene {
    PushValidClick(1),
    ClickWidget(10);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612240);
    }

    public static Scene findByValue(int i) {
        if (i != 1) {
            if (i != 10) {
                return null;
            }
            return ClickWidget;
        }
        return PushValidClick;
    }

    Scene(int i) {
        this.value = i;
    }
}
