package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class al {
    static int a;

    static {
        Covode.recordClassIndex(655345);
    }

    public static ah a(Context context) {
        if (j.m630a()) {
            a = 1;
            return new ak(context);
        }
        if (ag.a(context)) {
            a = 2;
            return new ag(context);
        }
        if (an.a(context)) {
            a = 4;
            return new an(context);
        }
        if (ap.a(context)) {
            a = 5;
            return new ap(context);
        }
        if (aj.a(context)) {
            a = 3;
            return new ai(context);
        }
        a = 0;
        return new ao();
    }
}
