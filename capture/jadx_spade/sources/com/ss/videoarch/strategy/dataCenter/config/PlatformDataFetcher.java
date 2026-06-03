package com.ss.videoarch.strategy.dataCenter.config;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.IAppInfoBundle;
import com.ss.videoarch.strategy.utils.JNINamespace;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PlatformDataFetcher {
    private IAppInfoBundle mAppInfoBundle = null;

    static {
        Covode.recordClassIndex(653114);
    }

    private static class a {
        private static final PlatformDataFetcher a;

        static {
            Covode.recordClassIndex(653115);
            a = new PlatformDataFetcher();
        }
    }

    public static PlatformDataFetcher getInstance() {
        return a.a;
    }

    public static void init(IAppInfoBundle iAppInfoBundle) {
        getInstance().mAppInfoBundle = iAppInfoBundle;
    }

    public String GetDolphinSettings_string(String str, String str2) {
        return (String) getDolphinSettings(str, str2);
    }

    public int GetDolphinSettings_int(String str, int i) {
        return ((Integer) getDolphinSettings(str, Integer.valueOf(i))).intValue();
    }

    private <T> T getDolphinSettings(String str, T t) {
        IAppInfoBundle iAppInfoBundle = this.mAppInfoBundle;
        if (iAppInfoBundle == null) {
            Log.d("PlatformDataFetcher", "mAppInfoBundle == null");
            return t;
        }
        T t2 = (T) iAppInfoBundle.getAppInfoForKey(str, t);
        Log.d("PlatformDataFetcher", "getDolphinSettings: " + str + ",value: " + t2);
        return t2;
    }
}
