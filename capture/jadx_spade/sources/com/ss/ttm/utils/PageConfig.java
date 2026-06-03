package com.ss.ttm.utils;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PageConfig extends ReuseConfig {
    static {
        Covode.recordClassIndex(652237);
    }

    public PageConfig copy() {
        return new PageConfig(this);
    }

    private PageConfig(PageConfig pageConfig) {
        super(pageConfig, 1);
    }

    public PageConfig(UserConfig userConfig) {
        super(userConfig, 0);
    }
}
