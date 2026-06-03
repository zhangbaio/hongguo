package com.ss.ttvideoengine.strategrycenter;

import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IStrategyStateSupplier {

    /* renamed from: com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Map $default$selectBitrate(IStrategyStateSupplier iStrategyStateSupplier, StrategyMediaParam strategyMediaParam) {
            return null;
        }
    }

    double getNetworkSpeed();

    Map<String, Object> mediaInfo(String str);

    Map<String, Integer> selectBitrate(StrategyMediaParam strategyMediaParam);

    Map<String, Integer> selectBitrate(String str, int i);
}
