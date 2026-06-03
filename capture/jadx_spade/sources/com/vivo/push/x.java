package com.vivo.push;

import android.net.Uri;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class x {
    public static final Uri a;
    public static final Uri b;
    public static final Uri c;
    public static final Uri d;
    public static final Uri e;
    public static final Uri f;

    public static String a(int i) {
        switch (i) {
            case 2002:
                return "method_alias_bind";
            case 2003:
                return "method_alias_unbind";
            case 2004:
                return "method_tag_bind";
            case 2005:
                return "method_tag_unbind";
            case 2006:
                return "method_sdk_bind";
            case 2007:
                return "method_sdk_unbind";
            case 2008:
                return "method_stop";
            default:
                return null;
        }
    }

    static {
        Covode.recordClassIndex(655214);
        a = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/config");
        b = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/permission");
        c = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/clientState");
        d = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/debugInfo");
        e = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/agreePrivacyStatement");
        f = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/queryAppState");
    }
}
