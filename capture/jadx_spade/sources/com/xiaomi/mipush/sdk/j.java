package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.ge;
import com.xiaomi.push.go;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class j {
    private static volatile j a;

    /* renamed from: a, reason: collision with other field name */
    private final Context f57a;

    static {
        Covode.recordClassIndex(655308);
    }

    private j(Context context) {
        this.f57a = context.getApplicationContext();
    }

    private static j a(Context context) {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j(context);
                }
            }
        }
        return a;
    }

    public static void a(Context context, ha haVar) {
        a(context).a(haVar, 0, true);
    }

    public static void b(Context context, ha haVar, boolean z) {
        a(context).a(haVar, 2, z);
    }

    public static void c(Context context, ha haVar, boolean z) {
        a(context).a(haVar, 3, z);
    }

    public static void d(Context context, ha haVar, boolean z) {
        a(context).a(haVar, 4, z);
    }

    public static void a(Context context, ha haVar, boolean z) {
        a(context).a(haVar, 1, z);
    }

    public static void e(Context context, ha haVar, boolean z) {
        b m79a = b.m79a(context);
        if (!TextUtils.isEmpty(m79a.m87c()) && !TextUtils.isEmpty(m79a.d())) {
            if (m79a.m91f()) {
                a(context).a(haVar, 7, z);
                return;
            } else {
                a(context).a(haVar, 5, z);
                return;
            }
        }
        a(context).a(haVar, 6, z);
    }

    private void a(ha haVar, int i, boolean z) {
        if (!com.xiaomi.push.j.m631a(this.f57a) && com.xiaomi.push.j.m630a() && haVar != null && haVar.f649a == ge.SendMessage && haVar.m533a() != null && z) {
            com.xiaomi.channel.commonutils.logger.b.m54a("click to start activity result:" + String.valueOf(i));
            hd hdVar = new hd(haVar.m533a().m499a(), false);
            hdVar.c(go.SDK_START_ACTIVITY.f529a);
            hdVar.b(haVar.m534a());
            hdVar.d(haVar.f656b);
            HashMap hashMap = new HashMap();
            hdVar.f668a = hashMap;
            hashMap.put("result", String.valueOf(i));
            u.a(this.f57a).a(hdVar, ge.Notification, false, false, null, true, haVar.f656b, haVar.f652a, true, false);
        }
    }
}
