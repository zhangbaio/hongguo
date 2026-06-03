package com.ss.ttvideoengine.log;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class LoggerUtils {
    private static final int[] caesar_key;

    public static float encryptFloatV1(float f) {
        return (f == Float.MIN_VALUE || f == Float.NaN) ? f : -f;
    }

    public static long encryptIntergerV1(long j) {
        if (j == -2147483648L) {
            return j;
        }
        return (j << 60) | (j >>> 4);
    }

    static {
        Covode.recordClassIndex(652477);
        caesar_key = new int[]{1, 5, -1, 6, -3};
    }

    static Map<String, Long> parsePlayerBufferString(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        String[] split = str.split(";|:");
        if (split != null && split.length != 0) {
            for (int i = 0; i < split.length - 1; i += 2) {
                try {
                    hashMap.put(split[i], Long.valueOf(Long.parseLong(split[i + 1])));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return hashMap;
    }

    public static String encryptStringV1(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = "";
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            int i3 = caesar_key[i2 % 5];
            if (charAt >= 'a' && charAt <= 'z') {
                charAt = (char) (charAt + i3);
                if (charAt < 'a') {
                    charAt = (char) (charAt + 26);
                }
                if (charAt <= 'z') {
                    str2 = str2 + charAt;
                }
                i = charAt - 26;
            } else {
                if (charAt >= 'A' && charAt <= 'Z') {
                    charAt = (char) (charAt + i3);
                    if (charAt < 'A') {
                        charAt = (char) (charAt + 26);
                    }
                    if (charAt <= 'Z') {
                    }
                    i = charAt - 26;
                } else if (charAt >= '0' && charAt <= '9') {
                    charAt = (char) (charAt + i3);
                    if (charAt < '0') {
                        charAt = (char) (charAt + '\n');
                    }
                    if (charAt > '9') {
                        i = charAt - '\n';
                    }
                }
                str2 = str2 + charAt;
            }
            charAt = (char) i;
            str2 = str2 + charAt;
        }
        return str2;
    }

    static Map<String, Long> parsePlayerStringToMap(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        String[] split = str.split(str2);
        if (split != null && split.length != 0) {
            for (int i = 0; i < split.length - 1; i += 2) {
                try {
                    hashMap.put(split[i], Long.valueOf(Long.parseLong(split[i + 1])));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return hashMap;
    }

    static void putToMap(Map map, String str, int i) {
        if (map != null && i != Integer.MIN_VALUE) {
            map.put(str, Integer.valueOf(i));
        }
    }

    static void putToMap(Map map, String str, float f) {
        if (map != null && f != Float.MIN_VALUE && f != Float.NaN) {
            map.put(str, Float.valueOf(f));
        }
    }

    static void putToMap(Map map, String str, long j) {
        if (map != null && j != -2147483648L) {
            map.put(str, Long.valueOf(j));
        }
    }

    static void putToMap(Map map, String str, String str2) {
        if (map != null && !TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    static void putToMap(Map map, String str, ArrayList arrayList) {
        if (map != null && arrayList != null && !arrayList.isEmpty()) {
            map.put(str, arrayList);
        }
    }

    static void putToMap(Map map, String str, Map map2) {
        if (map != null && map2 != null && !map2.isEmpty()) {
            map.put(str, map2);
        }
    }

    static void putToMap(Map map, String str, JSONObject jSONObject) {
        if (map != null && jSONObject != null) {
            map.put(str, jSONObject);
        }
    }
}
