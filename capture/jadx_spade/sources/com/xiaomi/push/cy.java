package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import java.io.File;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class cy {
    private static cx a;

    static {
        Covode.recordClassIndex(655430);
        a = null;
    }

    public static File a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("ERROR: Context cannot be null.");
            return null;
        }
        cx cxVar = a;
        if (cxVar != null) {
            return cxVar.a(context);
        }
        com.xiaomi.channel.commonutils.logger.b.d("ERROR: XMSF not configure the instance of LogAgent.");
        return null;
    }
}
