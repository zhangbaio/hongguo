package com.tencent.open.b;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.ss.ttm.player.MediaPlayer;
import com.tencent.open.log.SLog;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    protected static final Uri a;

    public static String b(Context context) {
        return "";
    }

    private static Cursor com_tencent_open_b_a_android_content_ContentResolver_query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Result preInvoke = new HeliosApiHook().preInvoke(240004, "android/content/ContentResolver", "query", contentResolver, new Object[]{uri, strArr, str, strArr2, str2}, "android.database.Cursor", new ExtraInfo(false, "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;"));
        return preInvoke.isIntercept() ? (Cursor) preInvoke.getReturnValue() : contentResolver.query(uri, strArr, str, strArr2, str2);
    }

    static {
        Covode.recordClassIndex(653513);
        a = Uri.parse("content://telephony/carriers/preferapn");
    }

    static NetworkInfo e(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(Context context) {
        int d = d(context);
        if (d == 2) {
            return "wifi";
        }
        if (d == 1) {
            return "cmwap";
        }
        if (d == 4) {
            return "cmnet";
        }
        if (d == 16) {
            return "uniwap";
        }
        if (d == 8) {
            return "uninet";
        }
        if (d == 64) {
            return "wap";
        }
        if (d == 32) {
            return "net";
        }
        if (d == 512) {
            return "ctwap";
        }
        if (d == 256) {
            return "ctnet";
        }
        if (d == 2048) {
            return "3gnet";
        }
        if (d == 1024) {
            return "3gwap";
        }
        String b = b(context);
        if (b != null && b.length() != 0) {
            return b;
        }
        return "none";
    }

    public static String c(Context context) {
        try {
            Cursor com_tencent_open_b_a_android_content_ContentResolver_query = com_tencent_open_b_a_android_content_ContentResolver_query(context.getContentResolver(), a, null, null, null, null);
            if (com_tencent_open_b_a_android_content_ContentResolver_query == null) {
                return null;
            }
            com_tencent_open_b_a_android_content_ContentResolver_query.moveToFirst();
            if (com_tencent_open_b_a_android_content_ContentResolver_query.isAfterLast()) {
                com_tencent_open_b_a_android_content_ContentResolver_query.close();
                return null;
            }
            String string = com_tencent_open_b_a_android_content_ContentResolver_query.getString(com_tencent_open_b_a_android_content_ContentResolver_query.getColumnIndex("proxy"));
            com_tencent_open_b_a_android_content_ContentResolver_query.close();
            return string;
        } catch (SecurityException e) {
            SLog.e("openSDK_LOG.APNUtil", "getApnProxy has exception: " + e.getMessage());
            return "";
        }
    }

    public static int d(Context context) {
        NetworkInfo e;
        try {
            e = e(context);
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.APNUtil", "getMProxyType has exception: " + e2.getMessage());
        }
        if (e == null) {
            return 128;
        }
        if (e.getTypeName().toUpperCase().equals("WIFI")) {
            return 2;
        }
        String lowerCase = l3.a.t(e).toLowerCase();
        if (lowerCase.startsWith("cmwap")) {
            return 1;
        }
        if (!lowerCase.startsWith("cmnet") && !lowerCase.startsWith("epc.tmobile.com")) {
            if (lowerCase.startsWith("uniwap")) {
                return 16;
            }
            if (lowerCase.startsWith("uninet")) {
                return 8;
            }
            if (lowerCase.startsWith("wap")) {
                return 64;
            }
            if (lowerCase.startsWith("net")) {
                return 32;
            }
            if (lowerCase.startsWith("ctwap")) {
                return MediaPlayer.MEDIA_PLAYER_OPTION_APPID;
            }
            if (lowerCase.startsWith("ctnet")) {
                return 256;
            }
            if (lowerCase.startsWith("3gwap")) {
                return 1024;
            }
            if (lowerCase.startsWith("3gnet")) {
                return 2048;
            }
            if (lowerCase.startsWith("#777")) {
                String c = c(context);
                if (c != null) {
                    if (c.length() > 0) {
                        return MediaPlayer.MEDIA_PLAYER_OPTION_APPID;
                    }
                }
                return 256;
            }
            return 128;
        }
        return 4;
    }
}
