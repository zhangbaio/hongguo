package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import com.bytedance.covode.number.Covode;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.push.hp;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class k {
    static {
        Covode.recordClassIndex(655309);
    }

    public static <T extends hp<T, ?>> void a(Context context, Config config) {
        if (config == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_cr_config");
        intent.putExtra("action_cr_event_switch", config.isEventUploadSwitchOpen());
        intent.putExtra("action_cr_event_frequency", config.getEventUploadFrequency());
        intent.putExtra("action_cr_perf_switch", config.isPerfUploadSwitchOpen());
        intent.putExtra("action_cr_perf_frequency", config.getPerfUploadFrequency());
        intent.putExtra("action_cr_event_en", config.isEventEncrypted());
        intent.putExtra("action_cr_max_file_size", config.getMaxFileLength());
        u.a(context).m123a(intent);
    }
}
