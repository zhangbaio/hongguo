package com.vivo.push.restructure.request;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.i;
import com.vivo.push.util.t;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    private Map<Integer, b> a;
    private Integer b;
    private HandlerThread c;
    private Handler d;

    static {
        Covode.recordClassIndex(655143);
    }

    public static d a() {
        return a.a;
    }

    private static class a {
        static d a;

        static {
            Covode.recordClassIndex(655144);
            a = new d((byte) 0);
        }
    }

    private d() {
        this.a = new ConcurrentHashMap();
        this.b = null;
        HandlerThread handlerThread = new HandlerThread("request_timer_task——thread");
        this.c = handlerThread;
        handlerThread.start();
        this.d = new e(this, this.c.getLooper());
    }

    private synchronized Integer b() {
        Integer valueOf;
        if (this.b == null) {
            this.b = 0;
        }
        if (this.b.intValue() < 0 || this.b.intValue() >= Integer.MAX_VALUE) {
            this.b = 0;
        }
        valueOf = Integer.valueOf(this.b.intValue() + 1);
        this.b = valueOf;
        return new Integer(valueOf.intValue());
    }

    /* synthetic */ d(byte b) {
        this();
    }

    private static int a(Intent intent) {
        Context b = com.vivo.push.restructure.a.a().b();
        if (b == null) {
            return 8002;
        }
        i a2 = i.a(b, "com.vivo.vms.aidlservice");
        if (a2.a() && !"com.vivo.pushservice".equals(b.getPackageName())) {
            if (a2.a(intent.getExtras())) {
                return 0;
            }
            t.b("RequestManager", "send command error by aidl");
            t.c(b, "send command error by aidl");
        }
        String k = com.vivo.push.restructure.a.a().e().k();
        if (TextUtils.isEmpty(k)) {
            return 8001;
        }
        Intent intent2 = new Intent("com.vivo.pushservice.action.METHOD");
        intent2.setPackage(k);
        intent2.setClassName(k, "com.vivo.push.sdk.service.PushService");
        try {
            com.vivo.push.a.a.a(b, intent2);
        } catch (Exception e) {
            t.a("RequestManager", "CommandBridge startService exception: ", e);
        }
        return 0;
    }

    public final void a(com.vivo.push.restructure.a.a aVar) {
        com.vivo.push.restructure.request.a.a h;
        int b;
        com.vivo.push.restructure.request.a.a.a aVar2;
        if (aVar != null && aVar.g() && (b = (h = aVar.h()).b()) > 0) {
            this.d.removeMessages(b);
            b remove = this.a.remove(Integer.valueOf(b));
            if (remove != null && remove.b() != null && remove.a() != null) {
                if (h.c() == 0) {
                    try {
                        aVar2 = new com.vivo.push.restructure.request.a.a.a(aVar.i());
                    } catch (JSONException e) {
                        e.printStackTrace();
                        aVar2 = null;
                    }
                    if (aVar2 != null) {
                        remove.b().a((c) remove.a().a(aVar2));
                        return;
                    } else {
                        remove.b().a(8003);
                        return;
                    }
                }
                remove.b().a(h.c());
            }
        }
    }

    public final void a(b bVar) {
        Integer b = b();
        int a2 = a(bVar.a().a(b.intValue()));
        if (a2 == 0) {
            if (bVar.c() > 0 && bVar.b() != null) {
                this.a.put(b, bVar);
                this.d.sendEmptyMessageDelayed(b.intValue(), bVar.c());
                return;
            }
            return;
        }
        if (bVar.b() != null) {
            bVar.b().a(a2);
        }
    }
}
