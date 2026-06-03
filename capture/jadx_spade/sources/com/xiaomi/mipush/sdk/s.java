package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.mipush.sdk.g;
import com.xiaomi.push.av;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class s {
    static {
        Covode.recordClassIndex(655319);
    }

    public static AbstractPushManager a(Context context, d dVar) {
        return b(context, dVar);
    }

    private static AbstractPushManager b(Context context, d dVar) {
        g.a a = g.a(dVar);
        if (a != null && !TextUtils.isEmpty(a.a) && !TextUtils.isEmpty(a.b)) {
            return (AbstractPushManager) av.a(a.a, a.b, context);
        }
        return null;
    }
}
