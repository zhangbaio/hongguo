package com.dragon.read.component.shortvideo.data.saas.rpcmodel;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SaasVideoHighlightType {
    HighLightFragment(0),
    SkipOpening(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(599109);
    }

    public static SaasVideoHighlightType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return SkipOpening;
        }
        return HighLightFragment;
    }

    SaasVideoHighlightType(int i) {
        this.value = i;
    }
}
