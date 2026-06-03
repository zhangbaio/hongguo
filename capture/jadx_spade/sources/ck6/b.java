package ck6;

import android.app.Activity;
import android.provider.Settings;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    static {
        Covode.recordClassIndex(654964);
    }

    private static int a(Activity activity) {
        try {
            return (int) (((Settings.System.getFloat(activity.getContentResolver(), "screen_auto_brightness_adj") + 1.0f) / 2.0f) * 255.0f);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int b(Activity activity) {
        try {
            return Settings.System.getInt(activity.getContentResolver(), "screen_brightness");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static float c(Activity activity) {
        float b;
        int a;
        if (d(activity) && (a = a(activity)) != -1) {
            b = a;
        } else {
            b = b(activity);
        }
        return b / 255.0f;
    }

    public static boolean d(Activity activity) {
        try {
            if (Settings.System.getInt(activity.getContentResolver(), "screen_brightness_mode") != 1) {
                return false;
            }
            return true;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
