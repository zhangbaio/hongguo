package com.tiktok.ttm.action;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.tiktok.ttm.TTMCore;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTMAppLog {
    private static TTMCore.SendAppLog appLogCallBack;

    static {
        Covode.recordClassIndex(653998);
        appLogCallBack = null;
    }

    public static void initAppLogCallBack(TTMCore.SendAppLog sendAppLog) {
        appLogCallBack = sendAppLog;
    }

    public static void sendAppLog(String str, JSONObject jSONObject) {
        TTMCore.SendAppLog sendAppLog = appLogCallBack;
        if (sendAppLog != null) {
            sendAppLog.sendAppLog(str, jSONObject);
        }
    }

    private static boolean jniSendAppLog(String str, Map<String, Object> map) {
        try {
            if (!TextUtils.isEmpty(str) && map != null) {
                sendAppLog(str, new JSONObject(map));
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
