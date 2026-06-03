package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class z extends c {
    private Context b;

    static {
        Covode.recordClassIndex(655211);
    }

    public final String c() {
        String str;
        Context context = this.b;
        String packageName = context.getPackageName();
        Object a = ah.a(context, packageName, "com.vivo.push.app_id");
        if (a != null) {
            str = a.toString();
        } else {
            Object a2 = ah.a(context, packageName, "app_id");
            if (a2 == null) {
                str = "";
            } else {
                str = a2.toString();
            }
        }
        if (TextUtils.isEmpty(str)) {
            return b("APP_APPID", "");
        }
        return str;
    }

    public final String d() {
        String str;
        Context context = this.b;
        String packageName = context.getPackageName();
        Object a = ah.a(context, packageName, "com.vivo.push.api_key");
        if (a != null) {
            str = a.toString();
        } else {
            Object a2 = ah.a(context, packageName, "api_key");
            if (a2 == null) {
                str = "";
            } else {
                str = a2.toString();
            }
        }
        if (TextUtils.isEmpty(str)) {
            return b("APP_APIKEY", "");
        }
        return str;
    }

    public z(Context context) {
        if (context != null) {
            this.b = context;
            a(context);
        }
    }

    private synchronized void a(Context context) {
        a(context, "com.vivo.push_preferences.appconfig_v1");
    }
}
