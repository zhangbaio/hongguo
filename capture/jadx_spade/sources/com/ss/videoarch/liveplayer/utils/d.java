package com.ss.videoarch.liveplayer.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.android.common.applog.AppLog;
import com.ss.videoarch.liveplayer.VideoLiveManager;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class d {
    private static String a;

    static {
        Covode.recordClassIndex(653100);
        a = "LiveUtils";
    }

    public static int g(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String[] split = str.split("\\.");
        if (split.length <= 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < split.length; i2++) {
            if (i2 == 0) {
                i = Integer.parseInt(split[i2]);
            } else {
                i = (i * 100) + Integer.parseInt(split[i2]);
            }
        }
        return i;
    }

    public static String c(String str) {
        int i;
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("stream-")) {
            int indexOf = str.indexOf("stream-");
            if (str.contains(".flv")) {
                i = str.indexOf(".flv");
            } else if (str.contains("/index.m3u8")) {
                i = str.indexOf("/index.m3u8");
            } else if (str.contains(".sdp")) {
                i = str.indexOf(".sdp");
            } else {
                i = -1;
            }
            if (i > indexOf) {
                String substring = str.substring(indexOf + 7, i);
                if (!TextUtils.isEmpty(substring)) {
                    if (!substring.contains("_")) {
                        str2 = "origin";
                    } else {
                        int indexOf2 = substring.indexOf("_");
                        if (indexOf2 != -1) {
                            str2 = substring.substring(indexOf2 + 1);
                        }
                    }
                }
            }
        }
        if (TextUtils.equals(str2, "origin") && str.contains("only_audio=1")) {
            return "ao";
        }
        return str2;
    }

    public static long f(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return j;
        }
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            i = split[i2].length() - split2[i2].length();
            if (i != 0 || (i = split[i2].compareTo(split2[i2])) != 0) {
                break;
            }
        }
        if (i == 0) {
            if (split.length - split2.length <= 0) {
                return false;
            }
            return true;
        }
        if (i <= 0) {
            return false;
        }
        return true;
    }

    public static void e(Context context, String str) {
        try {
            Class q = l3.a.q("com.ss.android.ugc.aweme.legoImp.task.publishtest.PublishDrillUtilities");
            if (q == null) {
                com.ss.videoarch.liveplayer.log.a.f("onNotReachHereStr", "onNotReachHereStr class not found");
                return;
            }
            Method declaredMethod = q.getDeclaredMethod("drillForVpass", Context.class, String.class);
            if (declaredMethod == null) {
                com.ss.videoarch.liveplayer.log.a.f("onNotReachHereStr", "onNotReachHereStr method not found");
            } else {
                declaredMethod.invoke(null, context, str);
            }
        } catch (Throwable th) {
            com.ss.videoarch.liveplayer.log.a.f("onNotReachHereStr", "onNotReachHereStr ex=" + th);
        }
    }

    public static String b(String str, int i) {
        String str2;
        if (i != 0 && i != 1) {
            str2 = str;
        } else {
            try {
                if (TextUtils.isEmpty(str)) {
                    str = UUID.randomUUID().toString().replace("-", "").toLowerCase(Locale.getDefault());
                }
                String str3 = str + "." + System.currentTimeMillis();
                if (i == 1) {
                    str2 = str3 + "." + UUID.randomUUID().toString().hashCode();
                } else {
                    str2 = str3;
                }
            } catch (Exception unused) {
                return str + "." + System.currentTimeMillis();
            }
        }
        if (i == 2) {
            return str + "." + VideoLiveManager.sAppSessionUUID + "." + VideoLiveManager.sPlaySessionIndex.incrementAndGet() + "." + AppLog.getAppId();
        }
        return str2;
    }

    public static Object d(JSONObject jSONObject, Object obj, String str) {
        if (jSONObject != null && jSONObject.has(str)) {
            if (obj == null) {
                return jSONObject.optString(str, (String) obj);
            }
            if (obj.getClass() == String.class) {
                return jSONObject.optString(str, (String) obj);
            }
            if (obj.getClass() == Integer.class) {
                return Integer.valueOf(jSONObject.optInt(str, ((Integer) obj).intValue()));
            }
            if (obj.getClass() == Float.class) {
                return Float.valueOf(Float.parseFloat(jSONObject.optString(str)));
            }
            if (obj.getClass() == Long.class) {
                return Long.valueOf(jSONObject.optLong(str, ((Long) obj).longValue()));
            }
            if (obj.getClass() == Double.class) {
                return Double.valueOf(jSONObject.optDouble(str, ((Double) obj).doubleValue()));
            }
            if (obj.getClass() == Boolean.class) {
                return Boolean.valueOf(jSONObject.optBoolean(str, false));
            }
            com.ss.videoarch.liveplayer.log.a.a(a, "Unknow type: " + str);
        }
        return obj;
    }
}
