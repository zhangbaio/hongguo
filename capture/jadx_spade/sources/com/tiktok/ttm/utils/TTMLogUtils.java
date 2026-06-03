package com.tiktok.ttm.utils;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.tiktok.ttm.TTMContext;
import rj6.a;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTMLogUtils {
    public static a logCallBack;

    static {
        Covode.recordClassIndex(654018);
    }

    public static void receiveDebugLog(TTMContext tTMContext, String str) {
        Log.i("TTM/Log", str);
    }
}
