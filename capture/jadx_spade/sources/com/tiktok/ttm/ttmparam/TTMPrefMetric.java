package com.tiktok.ttm.ttmparam;

import android.util.Log;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class TTMPrefMetric {
    long end;
    long start;
    String tag;

    static {
        Covode.recordClassIndex(654014);
    }

    public void endAndPrint() {
        this.end = System.nanoTime();
        if (b.a) {
            Log.d("TTM/ParamData", "Java-> " + this.tag + " | >>>>>>>>>>>>>> cost: " + ((this.end - this.start) / 1000));
        }
    }

    private TTMPrefMetric(String str) {
        this.tag = str;
    }

    public static TTMPrefMetric createAndStart(String str) {
        if (!b.a) {
            return null;
        }
        TTMPrefMetric tTMPrefMetric = new TTMPrefMetric(str);
        tTMPrefMetric.start = System.nanoTime();
        return tTMPrefMetric;
    }
}
