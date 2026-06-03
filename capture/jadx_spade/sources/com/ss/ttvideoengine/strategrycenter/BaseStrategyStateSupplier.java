package com.ss.ttvideoengine.strategrycenter;

import com.bytedance.covode.number.Covode;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BaseStrategyStateSupplier implements IStrategyStateSupplier {
    static {
        Covode.recordClassIndex(652705);
    }

    @Override // com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier
    public double getNetworkSpeed() {
        return 0.0d;
    }

    @Override // com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier
    public Map<String, Object> mediaInfo(String str) {
        return null;
    }

    @Override // com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier
    public Map<String, Integer> selectBitrate(StrategyMediaParam strategyMediaParam) {
        return null;
    }

    @Override // com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier
    public Map<String, Integer> selectBitrate(String str, int i) {
        return null;
    }
}
