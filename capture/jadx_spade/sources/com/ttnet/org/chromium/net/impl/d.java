package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.os.Build;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.impl.CronetLogger;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    private static final CronetLogger a;
    private static CronetLogger b;

    private d() {
    }

    public static CronetLogger b() {
        return a;
    }

    static {
        Covode.recordClassIndex(654602);
        a = new s();
    }

    private static Class<? extends CronetLogger> c() {
        try {
            return d.class.getClassLoader().loadClass("com.google.net.cronet.telemetry.CronetLoggerImpl").asSubclass(CronetLogger.class);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static CronetLogger a(Context context, CronetLogger.CronetSource cronetSource) {
        CronetLogger cronetLogger = b;
        if (cronetLogger != null) {
            return cronetLogger;
        }
        if (e.b(context, cronetSource) && Build.VERSION.SDK_INT >= 30) {
            Class<? extends CronetLogger> c = c();
            if (c == null) {
                return a;
            }
            try {
                return c.getConstructor(Integer.TYPE).newInstance(1);
            } catch (Exception unused) {
                return a;
            }
        }
        return a;
    }
}
