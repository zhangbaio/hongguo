package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.ge;
import com.xiaomi.push.go;
import com.xiaomi.push.gr;
import com.xiaomi.push.hd;
import com.xiaomi.push.service.aj;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MiPushClient4VR {
    static {
        Covode.recordClassIndex(655279);
    }

    public static void uploadData(Context context, String str) {
        hd hdVar = new hd();
        hdVar.c(go.VRUpload.f529a);
        hdVar.b(b.m79a(context).m80a());
        hdVar.d(context.getPackageName());
        hdVar.a("data", str);
        hdVar.a(aj.a());
        u.a(context).a((u) hdVar, ge.Notification, (gr) null);
    }
}
