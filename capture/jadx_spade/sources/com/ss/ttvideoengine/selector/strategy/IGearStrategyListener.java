package com.ss.ttvideoengine.selector.strategy;

import com.ss.ttvideoengine.model.IVideoModel;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IGearStrategyListener {

    /* renamed from: com.ss.ttvideoengine.selector.strategy.IGearStrategyListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onAfterSelect(IGearStrategyListener iGearStrategyListener, IVideoModel iVideoModel, Map map, int i, Object obj) {
        }

        public static void $default$onBeforeSelect(IGearStrategyListener iGearStrategyListener, IVideoModel iVideoModel, Map map, int i, Object obj) {
        }

        public static Map $default$selectBitrate(IGearStrategyListener iGearStrategyListener, IVideoModel iVideoModel, Map map, int i) {
            return null;
        }
    }

    void onAfterSelect(IVideoModel iVideoModel, Map<String, String> map, int i, Object obj);

    void onBeforeSelect(IVideoModel iVideoModel, Map<String, String> map, int i, Object obj);

    Map<String, Integer> selectBitrate(IVideoModel iVideoModel, Map<String, String> map, int i);
}
