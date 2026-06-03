package com.vivo.push.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.security.PublicKey;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class b {
    protected String a;
    protected long b;
    protected Context c;
    protected NotifyArriveCallbackByUser d;

    static {
        Covode.recordClassIndex(655187);
    }

    protected abstract int a();

    protected abstract PendingIntent a(Context context, Intent intent);

    protected abstract Intent a(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser);

    public final long b() {
        return this.b;
    }

    protected static void a(Intent intent, Context context) {
        String a;
        try {
            String a2 = com.vivo.push.g.b.a().a(context).a("com.vivo.pushservice");
            PublicKey a3 = com.vivo.push.g.b.a().a(context).a();
            if (TextUtils.isEmpty(a2)) {
                a2 = "com.vivo.pushservice";
            }
            intent.putExtra("security_avoid_pull_rsa", a2);
            if (a3 == null) {
                a = "com.vivo.pushservice";
            } else {
                a = ab.a(a3);
            }
            intent.putExtra("security_avoid_rsa_public_key", a);
        } catch (Exception e) {
            t.a("BaseNotifyClickIntentParam", "pushNotificationBySystem encrypt ：" + e.getMessage());
            intent.putExtra("security_avoid_pull_rsa", "com.vivo.pushservice");
            intent.putExtra("security_avoid_rsa_public_key", "com.vivo.pushservice");
        }
    }

    public static Intent a(Context context, String str, long j, Intent intent, InsideNotificationItem insideNotificationItem) {
        Intent intent2 = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent2.setPackage(context.getPackageName());
        intent2.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
        intent2.putExtra("command_type", "reflect_receiver");
        intent2.putExtras(intent.getExtras());
        a(intent2, context);
        com.vivo.push.b.p pVar = new com.vivo.push.b.p(str, j, insideNotificationItem);
        pVar.b(intent.getAction());
        if (intent.getComponent() != null) {
            pVar.c(intent.getComponent().getPackageName());
            pVar.d(intent.getComponent().getClassName());
        }
        if (intent.getData() != null) {
            pVar.a(intent.getData());
        }
        pVar.b(intent2);
        return intent2;
    }

    public final Intent a(Context context, String str, long j, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        this.b = j;
        this.a = str;
        this.c = context;
        this.d = notifyArriveCallbackByUser;
        Intent a = a(context, insideNotificationItem, notifyArriveCallbackByUser);
        int a2 = a();
        if (a2 > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("messageID", String.valueOf(this.b));
            String a3 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a3)) {
                hashMap.put("remoteAppId", a3);
            }
            hashMap.put("ap", this.a);
            hashMap.put("clientsdkver", String.valueOf(ah.c(this.c, this.a)));
            f.a(a2, (HashMap<String, String>) hashMap);
            return null;
        }
        return a;
    }
}
