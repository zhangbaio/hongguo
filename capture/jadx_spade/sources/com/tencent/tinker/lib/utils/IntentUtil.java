package com.tencent.tinker.lib.utils;

import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.MuteLog;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class IntentUtil {
    static {
        Covode.recordClassIndex(653928);
    }

    public static Throwable getIntentPatchException(Intent intent) {
        Serializable serializableExtra = getSerializableExtra(intent, "intent_patch_exception");
        if (serializableExtra != null) {
            return (Throwable) serializableExtra;
        }
        return null;
    }

    public static void safeRemoveUnSafeFlags(Intent intent) {
        if (intent == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            safeRemoveUnSafeFlagsCompatV1(intent, 195);
        } else {
            safeRemoveUnSafeFlagsCompatV2(intent, 195);
        }
    }

    public static Serializable getSerializableExtra(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        try {
            return intent.getSerializableExtra(str);
        } catch (Exception e) {
            MuteLog.e("Mute.IntentUtil", "getSerializableExtra exception:" + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static String getStringExtra(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        try {
            return intent.getStringExtra(str);
        } catch (Exception e) {
            MuteLog.e("Mute.IntentUtil", "getStringExtra exception:" + e.getMessage(), new Object[0]);
            return null;
        }
    }

    private static void safeRemoveUnSafeFlagsCompatV1(Intent intent, int i) {
        try {
            intent.removeFlags(i);
        } catch (Exception e) {
            MuteLog.e("Mute.IntentUtil", " safeRemoveUnSafeFlagsCompatV1 fail!!! >>> intent=" + intent + " >>> error=" + Log.getStackTraceString(e), new Object[0]);
        }
    }

    private static void safeRemoveUnSafeFlagsCompatV2(Intent intent, int i) {
        try {
            FieldUtils.writeField(intent, "mFlags", Integer.valueOf((~i) & intent.getFlags()));
        } catch (Exception e) {
            MuteLog.e("Mute.IntentUtil", " safeRemoveUnSafeFlagsCompatV2 fail!!! >>> intent=" + intent + " >>> error=" + Log.getStackTraceString(e), new Object[0]);
        }
    }
}
