package com.ss.ttvideoengine;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BaseAppInfo {
    public static String mAppChannel;
    public static int mAppID;
    public static String mAppName;
    public static String mAppVersion;
    public static Context mContext;
    public static String mDeviceId;
    public static String mOpenApiHostName;
    public static String mRegion;
    public static int mScreenHeight;
    public static int mScreenWidth;
    public static String mSmartUrlApiHostName;

    static {
        Covode.recordClassIndex(652247);
        mAppID = -1;
    }

    public static String toJsonString() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", Integer.valueOf(mAppID));
        hashMap.put("app_name", mAppName);
        hashMap.put("screen_width", Integer.valueOf(mScreenWidth));
        hashMap.put("screen_height", Integer.valueOf(mScreenHeight));
        String str = mDeviceId;
        if (str != null && !str.isEmpty()) {
            hashMap.put("did", mDeviceId);
        }
        String str2 = mAppVersion;
        if (str2 != null && !str2.isEmpty()) {
            hashMap.put("app_version", mAppVersion);
        }
        return new JSONObject(hashMap).toString();
    }
}
