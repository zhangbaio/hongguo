package com.ss.ttvideoengine;

import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.strategrycenter.StrategyCenter;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Locale;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class DataLoaderListener2ForStrategyCenter implements DataLoaderListener2 {
    static DataLoaderListener2ForStrategyCenter sInstance;

    DataLoaderListener2ForStrategyCenter() {
    }

    static {
        Covode.recordClassIndex(652275);
        sInstance = new DataLoaderListener2ForStrategyCenter();
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener2
    public void onNotify(int i, long j, long j2, String str) {
        ss1.b bVar = StrategyCenter.sNetSpeedPredictor;
        if (i == 2 && bVar != null) {
            bVar.update(j, j2, SystemClock.elapsedRealtime());
            if (j2 != 0) {
                TTVideoEngineLog.d("TTVideoEngine", String.format(Locale.US, "[IESSpeedPredictor]: speedRecord:%f", Double.valueOf(j / j2)));
            }
        }
    }
}
