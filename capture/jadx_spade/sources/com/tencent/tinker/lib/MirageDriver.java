package com.tencent.tinker.lib;

import android.content.Context;
import android.content.Intent;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MirageDriver {
    static {
        Covode.recordClassIndex(653696);
    }

    public static boolean init(Intent intent, Context context, ClassLoader classLoader) {
        int intExtra = intent.getIntExtra("host_uvc", 0);
        int intExtra2 = intent.getIntExtra("last_uvc", 0);
        int intExtra3 = intent.getIntExtra("mute_uvc", 0);
        int intExtra4 = intent.getIntExtra("mute_rid", 0);
        boolean booleanExtra = intent.getBooleanExtra("adex_install", true);
        boolean booleanExtra2 = intent.getBooleanExtra("lock_version", false);
        boolean booleanExtra3 = intent.getBooleanExtra("main_process", true);
        intent.getBooleanExtra("odex_install", false);
        MuteMaxLoader.sOriginCL = classLoader;
        MuteMaxLoader.sBaseCtx = context;
        return new MuteMaxLoader(null, intent, intExtra, intExtra2, intExtra3, intExtra4, booleanExtra, booleanExtra2, booleanExtra3).maxLoad();
    }
}
