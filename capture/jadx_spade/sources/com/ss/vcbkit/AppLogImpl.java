package com.ss.vcbkit;

import com.bytedance.applog.AppLog;
import com.bytedance.covode.number.Covode;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.common.util.i;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class AppLogImpl {
    private static boolean a;
    private static boolean b;

    private AppLogImpl() {
    }

    static {
        Covode.recordClassIndex(652841);
        a = false;
        b = false;
        a();
    }

    public static void a() {
        if (a) {
            return;
        }
        try {
            AppLog.getAppId();
            a = true;
        } catch (Throwable unused) {
            a = false;
        }
        try {
            i.b("applog");
            b = true;
        } catch (Throwable unused2) {
            b = false;
        }
    }

    public static void onEvent(String str, String str2) {
        if (!a && !b) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (a && AppLog.hasStarted()) {
                AppLog.onEventV3(str, jSONObject);
            } else if (b) {
                AppLogNewUtils.onEventV3(str, jSONObject);
            }
        } catch (Throwable th) {
            a.e("vcbkit", "jsonErr:" + th.getMessage());
        }
    }
}
