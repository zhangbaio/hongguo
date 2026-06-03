package com.ss.ttvideoengine;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class AppInfo extends BaseAppInfo {
    static {
        Covode.recordClassIndex(652246);
    }

    public static String getDefaultVodTopHost() {
        throw new UnsupportedOperationException("tob only");
    }

    public static String getDefaultVodTopHostV2() {
        throw new UnsupportedOperationException("tob only");
    }

    public static String getSmartUrlApiHost() {
        throw new UnsupportedOperationException("tob only");
    }

    public static String getDeviceId() {
        if (BaseAppInfo.mDeviceId == null) {
            BaseAppInfo.mDeviceId = "";
        }
        return BaseAppInfo.mDeviceId;
    }
}
