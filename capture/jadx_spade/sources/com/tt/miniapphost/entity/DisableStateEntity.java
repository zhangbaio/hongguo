package com.tt.miniapphost.entity;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DisableStateEntity {
    private final String mDisableHintMessage;
    private final String mDisableHintUrl;

    static {
        Covode.recordClassIndex(654124);
    }

    public String getHintMessage() {
        return this.mDisableHintMessage;
    }

    public String getHintUrl() {
        return this.mDisableHintUrl;
    }

    public DisableStateEntity(String str, String str2) {
        this.mDisableHintMessage = str;
        this.mDisableHintUrl = str2;
    }
}
