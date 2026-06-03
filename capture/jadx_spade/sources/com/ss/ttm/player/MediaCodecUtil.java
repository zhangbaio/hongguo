package com.ss.ttm.player;

import android.util.Log;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class MediaCodecUtil {
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_LEVEL;
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_PROFILE;
    private static final Pattern PROFILE_PATTERN;

    static {
        Covode.recordClassIndex(652122);
        PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
        HashMap hashMap = new HashMap();
        DOLBY_VISION_STRING_TO_LEVEL = hashMap;
        hashMap.put("01", 1);
        hashMap.put("02", 2);
        hashMap.put("03", 4);
        hashMap.put("04", 8);
        hashMap.put("05", 16);
        hashMap.put("06", 32);
        hashMap.put("07", 64);
        hashMap.put("08", 128);
        hashMap.put("09", 256);
        HashMap hashMap2 = new HashMap();
        DOLBY_VISION_STRING_TO_PROFILE = hashMap2;
        hashMap2.put("00", 1);
        hashMap2.put("01", 2);
        hashMap2.put("02", 4);
        hashMap2.put("03", 8);
        hashMap2.put("04", 16);
        hashMap2.put("05", 32);
        hashMap2.put("06", 64);
        hashMap2.put("07", 128);
        hashMap2.put("08", 256);
        hashMap2.put("09", Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_APPID));
    }

    public static String getDolbyCodecs(int i, int i2) {
        String str;
        if (i != 4 && i != 5 && i != 7) {
            if (i == 8) {
                str = "hev1";
            } else if (i == 9) {
                str = "avc3";
            } else {
                return null;
            }
        } else {
            str = "dvhe";
        }
        return str + ".0" + i + ".0" + i2;
    }

    public static Pair<Integer, Integer> getDolbyVisionProfileAndLevel(String str, String[] strArr) {
        if (strArr != null && strArr.length >= 3) {
            try {
                Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
                if (!matcher.matches()) {
                    Log.w("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
                    return null;
                }
                String group = matcher.group(1);
                Integer num = DOLBY_VISION_STRING_TO_PROFILE.get(group);
                if (num == null) {
                    Log.w("MediaCodecUtil", "Unknown Dolby Vision profile string: " + group);
                    return null;
                }
                String str2 = strArr[2];
                Integer num2 = DOLBY_VISION_STRING_TO_LEVEL.get(str2);
                if (num2 == null) {
                    Log.w("MediaCodecUtil", "Unknown Dolby Vision level string: " + str2);
                    return null;
                }
                return new Pair<>(num, num2);
            } catch (Exception e) {
                e.printStackTrace();
                Log.w("MediaCodecUtil", "profile pattern match error");
                return null;
            }
        }
        Log.w("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
        return null;
    }
}
