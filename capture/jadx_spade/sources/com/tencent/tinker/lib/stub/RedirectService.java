package com.tencent.tinker.lib.stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.utils.IntentUtil;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class RedirectService extends Service {

    public static final class CodeConst {
        static {
            Covode.recordClassIndex(653827);
        }
    }

    static {
        Covode.recordClassIndex(653826);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Intent intent2;
        if (intent != null && (intent2 = (Intent) intent.getParcelableExtra("mute_target_intent")) != null) {
            try {
                IntentUtil.safeRemoveUnSafeFlags(intent2);
                startService(intent2);
            } catch (IllegalStateException e) {
                MuteLog.e("Mute.RedirectService", RedirectService.class.getName(), e);
            }
        }
        stopSelf();
        return 2;
    }
}
