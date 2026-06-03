package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.du;
import com.xiaomi.push.ha;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class ab {
    static {
        Covode.recordClassIndex(655658);
    }

    abstract du a(Context context, int i, String str, Map<String, String> map);

    abstract void a(ha haVar, Map<String, String> map, int i, Notification notification);

    abstract void a(String str);

    /* renamed from: a, reason: collision with other method in class */
    abstract boolean m674a(Context context, int i, String str, Map<String, String> map);

    abstract boolean a(Map<String, String> map, int i, Notification notification);
}
