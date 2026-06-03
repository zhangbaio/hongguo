package com.ss.ttvideoengine.selector;

import com.ss.ttvideoengine.model.IVideoModel;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface Selector {
    SelectedInfo select(IVideoModel iVideoModel, Map<Integer, Object> map);
}
