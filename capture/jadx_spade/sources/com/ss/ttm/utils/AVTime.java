package com.ss.ttm.utils;

import com.bytedance.covode.number.Covode;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AVTime {
    static {
        Covode.recordClassIndex(652226);
    }

    public static String getFormatNow() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm ss:SSS").format(new Date());
    }
}
