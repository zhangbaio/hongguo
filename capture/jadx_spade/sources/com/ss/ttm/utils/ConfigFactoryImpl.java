package com.ss.ttm.utils;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ConfigFactoryImpl implements ConfigFactory {
    static {
        Covode.recordClassIndex(652231);
    }

    @Override // com.ss.ttm.utils.ConfigFactory
    public ConfigAPI createConfig(long j, int i) {
        return new ConfigImpl(j, i);
    }
}
