package com.xiaomi.push.service;

import android.content.SharedPreferences;
import android.util.Base64;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.ae;
import com.xiaomi.push.ch;
import com.xiaomi.push.dn;
import com.xiaomi.push.fx;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ax {
    private static ax a;

    /* renamed from: a, reason: collision with other field name */
    private static String f950a;

    /* renamed from: a, reason: collision with other field name */
    private ae.b f951a;

    /* renamed from: a, reason: collision with other field name */
    private dn.a f952a;

    /* renamed from: a, reason: collision with other field name */
    private List<a> f953a = new ArrayList();

    public static abstract class a {
        static {
            Covode.recordClassIndex(655699);
        }

        public void a(dn.a aVar) {
        }

        public void a(Cdo.b bVar) {
        }
    }

    public synchronized void a(a aVar) {
        this.f953a.add(aVar);
    }

    void a(Cdo.b bVar) {
        a[] aVarArr;
        if (bVar.m304d() && bVar.d() > m712a()) {
            c();
        }
        synchronized (this) {
            List<a> list = this.f953a;
            aVarArr = (a[]) list.toArray(new a[list.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    private void b() {
        if (this.f952a == null) {
            d();
        }
    }

    static {
        Covode.recordClassIndex(655698);
        a = new ax();
    }

    private ax() {
    }

    private void c() {
        if (this.f951a != null) {
            return;
        }
        ae.b bVar = new ae.b() { // from class: com.xiaomi.push.service.ax.1

            /* renamed from: a, reason: collision with other field name */
            boolean f954a = false;

            @Override // com.xiaomi.push.ae.b
            public void b() {
                try {
                    dn.a a2 = dn.a.a(Base64.decode(ch.a(com.xiaomi.push.q.m640a(), "https://resolver.msg.xiaomi.net/psc/?t=a", (List<com.xiaomi.push.as>) null), 10));
                    if (a2 == null) {
                        return;
                    }
                    ax.this.f952a = a2;
                    this.f954a = true;
                    ax.this.e();
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("fetch config failure: " + e.getMessage());
                }
            }

            @Override // com.xiaomi.push.ae.b
            /* renamed from: c */
            public void mo269c() {
                a[] aVarArr;
                ax.this.f951a = null;
                if (this.f954a) {
                    synchronized (ax.this) {
                        aVarArr = (a[]) ax.this.f953a.toArray(new a[ax.this.f953a.size()]);
                    }
                    for (a aVar : aVarArr) {
                        aVar.a(ax.this.f952a);
                    }
                }
            }
        };
        this.f951a = bVar;
        fx.a(bVar);
    }

    public static ax a() {
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized String m709a() {
        String str;
        synchronized (ax.class) {
            if (f950a == null) {
                SharedPreferences sharedPreferences = com.xiaomi.push.q.m640a().getSharedPreferences("XMPushServiceConfig", 0);
                String string = sharedPreferences.getString("DeviceUUID", null);
                f950a = string;
                if (string == null) {
                    String a2 = com.xiaomi.push.i.a(com.xiaomi.push.q.m640a(), false);
                    f950a = a2;
                    if (a2 != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f950a).commit();
                    }
                }
            }
            str = f950a;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.f952a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.q.m640a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c a2 = com.xiaomi.push.c.a(bufferedOutputStream);
                this.f952a.a(a2);
                a2.m200a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a("save config failure: " + e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.xiaomi.push.q.m640a()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            java.lang.String r2 = "XMCloudCfg"
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            com.xiaomi.push.b r0 = com.xiaomi.push.b.a(r2)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
            com.xiaomi.push.dn$a r0 = com.xiaomi.push.dn.a.b(r0)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
            r4.f952a = r0     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
            r2.close()     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
        L1d:
            com.xiaomi.push.v.a(r2)
            goto L43
        L21:
            r0 = move-exception
            goto L2a
        L23:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L50
        L27:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L2a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
            r1.<init>()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r3 = "load config failure: "
            r1.append(r3)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L4f
            r1.append(r0)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L4f
            com.xiaomi.channel.commonutils.logger.b.m54a(r0)     // Catch: java.lang.Throwable -> L4f
            goto L1d
        L43:
            com.xiaomi.push.dn$a r0 = r4.f952a
            if (r0 != 0) goto L4e
            com.xiaomi.push.dn$a r0 = new com.xiaomi.push.dn$a
            r0.<init>()
            r4.f952a = r0
        L4e:
            return
        L4f:
            r0 = move-exception
        L50:
            com.xiaomi.push.v.a(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ax.d():void");
    }

    /* renamed from: a, reason: collision with other method in class */
    int m712a() {
        b();
        dn.a aVar = this.f952a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public dn.a m713a() {
        b();
        return this.f952a;
    }

    /* renamed from: a, reason: collision with other method in class */
    synchronized void m714a() {
        this.f953a.clear();
    }
}
