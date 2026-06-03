package com.xiaomi.push.service;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class an {
    public static String A;
    public static String B;
    public static String C;
    public static String D;
    public static String E;
    public static String F;
    public static String G;
    public static String H;
    public static String I;
    public static String J;
    public static String K;
    public static String L;
    public static String M;
    public static String N;
    public static String O;
    public static String P;
    public static String Q;
    public static String R;
    public static String a;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static String i;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public static String n;
    public static String o;
    public static String p;
    public static String q;
    public static String r;
    public static String s;
    public static String t;
    public static String u;
    public static String v;
    public static String w;
    public static String x;
    public static String y;
    public static String z;

    static {
        Covode.recordClassIndex(655683);
        a = "1";
        b = "2";
        c = "3";
        d = "com.xiaomi.push.OPEN_CHANNEL";
        e = "com.xiaomi.push.SEND_MESSAGE";
        f = "com.xiaomi.push.SEND_IQ";
        g = "com.xiaomi.push.BATCH_SEND_MESSAGE";
        h = "com.xiaomi.push.SEND_PRES";
        i = "com.xiaomi.push.CLOSE_CHANNEL";
        j = "com.xiaomi.push.FORCE_RECONN";
        k = "com.xiaomi.push.RESET_CONN";
        l = "com.xiaomi.push.UPDATE_CHANNEL_INFO";
        m = "com.xiaomi.push.SEND_STATS";
        n = "com.xiaomi.push.HANDLE_FCM_MSG";
        o = "com.xiaomi.push.APP_NOTIFY_MSG";
        p = "com.xiaomi.push.CHANGE_HOST";
        q = "com.xiaomi.push.PING_TIMER";
        r = "com.xiaomi.push.APP_CHANNEL_SWITCH";
        s = "ext_user_id";
        t = "ext_user_server";
        u = "ext_user_res";
        v = "ext_chid";
        w = "ext_receive_time";
        x = "ext_broadcast_time";
        y = "ext_sid";
        z = "ext_token";
        A = "ext_auth_method";
        B = "ext_security";
        C = "ext_kick";
        D = "ext_client_attr";
        E = "ext_cloud_attr";
        F = "ext_pkg_name";
        G = "ext_notify_id";
        H = "ext_clicked_button";
        I = "ext_notify_type";
        J = "ext_session";
        K = "sig";
        L = "ext_notify_title";
        M = "ext_notify_description";
        N = "ext_messenger";
        O = "title";
        P = "description";
        Q = "notifyId";
        R = "dump";
    }

    public static String a(int i2) {
        switch (i2) {
            case 0:
                return "ERROR_OK";
            case 1:
                return "ERROR_SERVICE_NOT_INSTALLED";
            case 2:
                return "ERROR_NETWORK_NOT_AVAILABLE";
            case 3:
                return "ERROR_NETWORK_FAILED";
            case 4:
                return "ERROR_ACCESS_DENIED";
            case 5:
                return "ERROR_AUTH_FAILED";
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return "ERROR_MULTI_LOGIN";
            case 7:
                return "ERROR_SERVER_ERROR";
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return "ERROR_RECEIVE_TIMEOUT";
            case 9:
                return "ERROR_READ_ERROR";
            case 10:
                return "ERROR_SEND_ERROR";
            case 11:
                return "ERROR_RESET";
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                return "ERROR_NO_CLIENT";
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return "ERROR_SERVER_STREAM";
            case 14:
                return "ERROR_THREAD_BLOCK";
            case 15:
                return "ERROR_SERVICE_DESTROY";
            case 16:
                return "ERROR_SESSION_CHANGED";
            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                return "ERROR_READ_TIMEOUT";
            case 18:
                return "ERROR_CONNECTIING_TIMEOUT";
            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                return "ERROR_USER_BLOCKED";
            case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                return "ERROR_REDIRECT";
            case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                return "ERROR_BIND_TIMEOUT";
            case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                return "ERROR_PING_TIMEOUT";
            default:
                return String.valueOf(i2);
        }
    }
}
