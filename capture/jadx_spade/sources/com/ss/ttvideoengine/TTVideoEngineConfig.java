package com.ss.ttvideoengine;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.IPluginLoader;
import com.ss.ttm.player.TTPlayerPluginLoader;
import com.ss.ttvideoengine.net.TTVNetClient;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTVideoEngineConfig {
    private static HashMap<Integer, ClassLoader> gClassLoaderMap;
    public static TTVNetClient gNetClient;
    private static IEnginePluginLoader gPluginLoader;
    public static boolean openPerformanceUtils;
    private static PlayerCreateErrorListener sPlayerCreateErrorListener;
    public static int setEGLBitDepth;
    public static long setSurfaceTimeoutForCreated;
    public static long setSurfaceTimeoutForDestroy;

    public static PlayerCreateErrorListener getPlayerCreateErrorListener() {
        return sPlayerCreateErrorListener;
    }

    static {
        Covode.recordClassIndex(652331);
        openPerformanceUtils = false;
        gNetClient = null;
        gPluginLoader = null;
        gClassLoaderMap = null;
        setSurfaceTimeoutForCreated = Long.MIN_VALUE;
        setSurfaceTimeoutForDestroy = Long.MIN_VALUE;
        setEGLBitDepth = 8;
    }

    public static void setPlayerCreateErrorListener(PlayerCreateErrorListener playerCreateErrorListener) {
        sPlayerCreateErrorListener = playerCreateErrorListener;
    }

    public static void setClassLoderCallback(IEnginePluginLoader iEnginePluginLoader) {
        if (iEnginePluginLoader == null) {
            return;
        }
        TTPlayerPluginLoader.setPluginLoader(new IPluginLoader() { // from class: com.ss.ttvideoengine.TTVideoEngineConfig.1
            @Override // com.ss.ttm.player.IPluginLoader
            public ClassLoader loadPlugin(int i) {
                return TTVideoEngineConfig.getClassLoader(i);
            }
        });
        gPluginLoader = iEnginePluginLoader;
    }

    public static ClassLoader getClassLoader(int i) {
        ClassLoader classLoader;
        HashMap<Integer, ClassLoader> hashMap = gClassLoaderMap;
        if (hashMap != null && (classLoader = hashMap.get(Integer.valueOf(i))) != null) {
            return classLoader;
        }
        IEnginePluginLoader iEnginePluginLoader = gPluginLoader;
        if (iEnginePluginLoader != null) {
            return iEnginePluginLoader.loadPlugin(i);
        }
        return null;
    }

    public static void setClassLoader(int i, ClassLoader classLoader) {
        if (gClassLoaderMap == null) {
            gClassLoaderMap = new HashMap<>();
            TTPlayerPluginLoader.setPluginLoader(new IPluginLoader() { // from class: com.ss.ttvideoengine.TTVideoEngineConfig.2
                @Override // com.ss.ttm.player.IPluginLoader
                public ClassLoader loadPlugin(int i2) {
                    return TTVideoEngineConfig.getClassLoader(i2);
                }
            });
        }
        gClassLoaderMap.put(Integer.valueOf(i), classLoader);
    }
}
