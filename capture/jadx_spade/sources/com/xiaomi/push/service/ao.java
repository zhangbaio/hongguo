package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.cb;
import com.xiaomi.push.ce;
import com.xiaomi.push.cf;
import com.xiaomi.push.dn;
import com.xiaomi.push.eh;
import com.xiaomi.push.en;
import com.xiaomi.push.eo;
import com.xiaomi.push.ez;
import com.xiaomi.push.fw;
import com.xiaomi.push.service.ax;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ao extends ax.a implements cf.a {
    private long a;

    /* renamed from: a, reason: collision with other field name */
    private XMPushService f942a;

    static {
        Covode.recordClassIndex(655684);
    }

    @Override // com.xiaomi.push.service.ax.a
    public void a(dn.a aVar) {
    }

    ao(XMPushService xMPushService) {
        this.f942a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        ao aoVar = new ao(xMPushService);
        ax.a().a(aoVar);
        synchronized (cf.class) {
            cf.a(aoVar);
            cf.a(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    static class a implements cf.b {
        static {
            Covode.recordClassIndex(655685);
        }

        a() {
        }

        @Override // com.xiaomi.push.cf.b
        public String a(String str) {
            int port;
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(48));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", fw.a(Build.MODEL + ":" + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(com.xiaomi.push.q.a()));
            String builder = buildUpon.toString();
            com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            if (url.getPort() == -1) {
                port = 80;
            } else {
                port = url.getPort();
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a = com.xiaomi.push.at.a(com.xiaomi.push.q.m640a(), url);
                eo.a(url.getHost() + ":" + port, (int) (System.currentTimeMillis() - currentTimeMillis), null);
                return a;
            } catch (IOException e) {
                eo.a(url.getHost() + ":" + port, -1, e);
                throw e;
            }
        }
    }

    @Override // com.xiaomi.push.service.ax.a
    public void a(Cdo.b bVar) {
        cb b2;
        boolean z;
        if (bVar.m302b() && bVar.m301a() && System.currentTimeMillis() - this.a > 3600000) {
            com.xiaomi.channel.commonutils.logger.b.m54a("fetch bucket :" + bVar.m301a());
            this.a = System.currentTimeMillis();
            cf a2 = cf.a();
            a2.m235a();
            a2.m238b();
            ez m664a = this.f942a.m664a();
            if (m664a != null && (b2 = a2.b(m664a.m417a().c())) != null) {
                ArrayList<String> m222a = b2.m222a();
                Iterator<String> it2 = m222a.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().equals(m664a.mo418a())) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z && !m222a.isEmpty()) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("bucket changed, force reconnect");
                    this.f942a.a(0, (Exception) null);
                    this.f942a.a(false);
                }
            }
        }
    }

    static class b extends cf {
        static {
            Covode.recordClassIndex(655686);
        }

        protected b(Context context, ce ceVar, cf.b bVar, String str) {
            super(context, ceVar, bVar, str);
        }

        @Override // com.xiaomi.push.cf
        protected String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                if (en.m386a().m391a()) {
                    str2 = ax.m709a();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e) {
                eo.a(0, eh.GSLB_ERR.a(), 1, null, com.xiaomi.push.at.b(cf.a) ? 1 : 0);
                throw e;
            }
        }
    }

    @Override // com.xiaomi.push.cf.a
    public cf a(Context context, ce ceVar, cf.b bVar, String str) {
        return new b(context, ceVar, bVar, str);
    }
}
