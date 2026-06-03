package com.ss.ttvideoengine.log;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngine;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class EngineInstanceHolder {
    private static volatile EngineInstanceHolder sInstance;
    private Map<Integer, WeakReference<TTVideoEngine>> mEngineMap = new ConcurrentHashMap();

    static {
        Covode.recordClassIndex(652463);
    }

    public Map<Integer, WeakReference<TTVideoEngine>> get() {
        return this.mEngineMap;
    }

    private EngineInstanceHolder() {
    }

    public static EngineInstanceHolder getInstance() {
        if (sInstance == null) {
            synchronized (EngineInstanceHolder.class) {
                if (sInstance == null) {
                    sInstance = new EngineInstanceHolder();
                }
            }
        }
        return sInstance;
    }

    public void remove(TTVideoEngine tTVideoEngine) {
        if (tTVideoEngine == null) {
            return;
        }
        this.mEngineMap.remove(Integer.valueOf(tTVideoEngine.hashCode()));
    }

    public void add(TTVideoEngine tTVideoEngine) {
        if (tTVideoEngine != null && !this.mEngineMap.containsKey(Integer.valueOf(tTVideoEngine.hashCode()))) {
            this.mEngineMap.put(Integer.valueOf(tTVideoEngine.hashCode()), new WeakReference<>(tTVideoEngine));
        }
    }
}
