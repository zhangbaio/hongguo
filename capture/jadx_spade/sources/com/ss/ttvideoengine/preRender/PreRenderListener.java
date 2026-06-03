package com.ss.ttvideoengine.preRender;

import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.source.Source;
import com.ss.ttvideoengine.utils.Error;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface PreRenderListener {

    /* renamed from: com.ss.ttvideoengine.preRender.PreRenderListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onPreRenderError(PreRenderListener preRenderListener, TTVideoEngine tTVideoEngine, Source source, int i, Error error) {
        }

        public static boolean $default$onPreRenderPause(PreRenderListener preRenderListener, TTVideoEngine tTVideoEngine, Source source) {
            return false;
        }

        public static void $default$onPreRenderStart(PreRenderListener preRenderListener, TTVideoEngine tTVideoEngine, Source source) {
        }

        public static void $default$onPreRenderSuccess(PreRenderListener preRenderListener, TTVideoEngine tTVideoEngine, Source source) {
        }
    }

    void onPreRenderError(TTVideoEngine tTVideoEngine, Source source, int i, Error error);

    boolean onPreRenderPause(TTVideoEngine tTVideoEngine, Source source);

    void onPreRenderStart(TTVideoEngine tTVideoEngine, Source source);

    void onPreRenderSuccess(TTVideoEngine tTVideoEngine, Source source);
}
