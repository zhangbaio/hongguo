package com.ss.ttvideoengine.preRender;

import com.ss.ttvideoengine.source.Source;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface PreRenderAlgorithm {
    int getAutoRange();

    void shouldStartPreRender(Source source, PreRenderTriggerListener preRenderTriggerListener);

    void stop();
}
