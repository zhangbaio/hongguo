package com.ss.ttm.player;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AVDrmCreater {
    static {
        Covode.recordClassIndex(652082);
    }

    public static synchronized long createDrm(int i) {
        synchronized (AVDrmCreater.class) {
            if (i == 1) {
                return createDrm(100, "com.ss.ttm.drm.intertrust.IntertrustDrm");
            }
            return 0L;
        }
    }

    private static long createDrm(int i, String str) {
        Class<?> q;
        try {
            ClassLoader loadPlugin = TTPlayerPluginLoader.loadPlugin(i);
            if (loadPlugin != null) {
                q = Class.forName(str, true, loadPlugin);
            } else {
                q = l3.a.q(str);
            }
            return Long.parseLong(String.valueOf(q.getMethod("createDrm", new Class[0]).invoke(null, new Object[0])));
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
