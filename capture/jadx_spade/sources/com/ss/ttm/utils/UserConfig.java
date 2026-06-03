package com.ss.ttm.utils;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UserConfig extends ReuseConfig {
    static {
        Covode.recordClassIndex(652239);
    }

    public UserConfig() {
        super(null, 0);
    }

    public UserConfig copy() {
        return new UserConfig(this);
    }

    private UserConfig(UserConfig userConfig) {
        super(userConfig, 1);
    }
}
