package com.ss.ttm.utils;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class OnceConfig extends InitConfig {
    static {
        Covode.recordClassIndex(652236);
    }

    @Override // com.ss.ttm.utils.InitConfig
    void commit() {
    }

    public OnceConfig copy() {
        return new OnceConfig(this);
    }

    private OnceConfig(OnceConfig onceConfig) {
        super(onceConfig.nativeHandle(), 1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public OnceConfig(com.ss.ttm.utils.ReuseConfig r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L5
            r0 = 0
            goto L9
        L5:
            long r0 = r3.nativeHandle()
        L9:
            r3 = 0
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.utils.OnceConfig.<init>(com.ss.ttm.utils.ReuseConfig):void");
    }
}
