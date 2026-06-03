package com.ss.ttvideoengine.utils;

import android.content.Context;
import android.media.AudioManager;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTVideoEngineInternalHelper {
    static {
        Covode.recordClassIndex(652760);
    }

    public static float getVolume(Context context) {
        int i;
        if (context == null) {
            return 0.0f;
        }
        int i2 = 0;
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager != null) {
                i = audioManager.getStreamVolume(3);
            } else {
                i = 0;
            }
            if (i >= 0) {
                i2 = i;
            }
        } catch (Exception unused) {
        }
        return i2;
    }
}
