package com.ss.ttvideoengine.log;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class AppLogTOBVer2 implements IVideoEventUploader {
    static {
        Covode.recordClassIndex(652458);
    }

    public static String getDeviceID() {
        return "";
    }

    public static void init(Context context, String str, String str2, String str3) {
    }

    public static boolean isAppLogVer2Exist() {
        return false;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventUploader
    public void onUplaod(String str, JSONObject jSONObject) {
    }
}
