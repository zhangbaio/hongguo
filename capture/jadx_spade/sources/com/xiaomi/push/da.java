package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.xiaomi.push.ae;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class da {
    private static volatile da a;

    /* renamed from: a, reason: collision with other field name */
    private Context f236a;

    /* renamed from: a, reason: collision with other field name */
    private final ConcurrentLinkedQueue<b> f237a;

    class a extends b {
        static {
            Covode.recordClassIndex(655434);
        }

        @Override // com.xiaomi.push.da.b, com.xiaomi.push.ae.b
        public void b() {
            da.this.b();
        }

        a() {
            super();
        }
    }

    static {
        Covode.recordClassIndex(655433);
        a = null;
    }

    class b extends ae.b {
        long a = System.currentTimeMillis();

        static {
            Covode.recordClassIndex(655435);
        }

        public boolean a() {
            return true;
        }

        @Override // com.xiaomi.push.ae.b
        public void b() {
        }

        /* renamed from: b, reason: collision with other method in class */
        final boolean m268b() {
            if (System.currentTimeMillis() - this.a > 172800000) {
                return true;
            }
            return false;
        }

        b() {
        }
    }

    class c extends b {
        int a;

        /* renamed from: a, reason: collision with other field name */
        File f246a;

        /* renamed from: a, reason: collision with other field name */
        String f247a;

        /* renamed from: a, reason: collision with other field name */
        boolean f248a;
        String b;

        /* renamed from: b, reason: collision with other field name */
        boolean f249b;

        static {
            Covode.recordClassIndex(655436);
        }

        @Override // com.xiaomi.push.da.b
        public boolean a() {
            if (!at.d(da.this.f236a) && (!this.f249b || !at.m155a(da.this.f236a))) {
                return false;
            }
            return true;
        }

        @Override // com.xiaomi.push.da.b, com.xiaomi.push.ae.b
        public void b() {
            try {
                if (c()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", com.xiaomi.push.service.ax.m709a());
                    hashMap.put("token", this.b);
                    hashMap.put("net", at.m151a(da.this.f236a));
                    at.a(this.f247a, hashMap, this.f246a, "file");
                }
                this.f248a = true;
            } catch (IOException unused) {
            }
        }

        @Override // com.xiaomi.push.ae.b
        /* renamed from: c, reason: collision with other method in class */
        public void mo269c() {
            if (!this.f248a) {
                int i = this.a + 1;
                this.a = i;
                if (i < 3) {
                    da.this.f237a.add(this);
                }
            }
            if (this.f248a || this.a >= 3) {
                this.f246a.delete();
            }
            da.this.a((1 << this.a) * 1000);
        }

        private boolean c() {
            int i;
            int i2 = 0;
            SharedPreferences sharedPreferences = da.this.f236a.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong("time");
                i = jSONObject.getInt("times");
            } catch (JSONException unused) {
                i = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis < 86400000) {
                if (i > 10) {
                    return false;
                }
                i2 = i;
            } else {
                currentTimeMillis = System.currentTimeMillis();
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis);
                jSONObject2.put("times", i2 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e) {
                com.xiaomi.channel.commonutils.logger.b.c("JSONException on put " + e.getMessage());
            }
            return true;
        }

        c(String str, String str2, File file, boolean z) {
            super();
            this.f247a = str;
            this.b = str2;
            this.f246a = file;
            this.f249b = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(this.f236a.getFilesDir() + "/.logcache");
            if (polarisFileWrapper.exists() && polarisFileWrapper.isDirectory()) {
                for (File file : polarisFileWrapper.listFiles()) {
                    file.delete();
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    private void c() {
        while (!this.f237a.isEmpty()) {
            b peek = this.f237a.peek();
            if (peek != null) {
                if (peek.m268b() || this.f237a.size() > 6) {
                    com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                    this.f237a.remove(peek);
                } else {
                    return;
                }
            }
        }
    }

    public void a() {
        c();
        a(0L);
    }

    private da(Context context) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f237a = concurrentLinkedQueue;
        this.f236a = context;
        concurrentLinkedQueue.add(new a());
        b(0L);
    }

    public static da a(Context context) {
        if (a == null) {
            synchronized (da.class) {
                if (a == null) {
                    a = new da(context);
                }
            }
        }
        a.f236a = context;
        return a;
    }

    private void b(long j) {
        if (!this.f237a.isEmpty()) {
            fx.a(new ae.b() { // from class: com.xiaomi.push.da.2
                ae.b a;

                @Override // com.xiaomi.push.ae.b
                /* renamed from: c */
                public void mo269c() {
                    ae.b bVar = this.a;
                    if (bVar != null) {
                        bVar.mo269c();
                    }
                }

                @Override // com.xiaomi.push.ae.b
                public void b() {
                    b bVar = (b) da.this.f237a.peek();
                    if (bVar != null && bVar.a()) {
                        if (da.this.f237a.remove(bVar)) {
                            this.a = bVar;
                        }
                        ae.b bVar2 = this.a;
                        if (bVar2 != null) {
                            bVar2.b();
                        }
                    }
                }
            }, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        b peek = this.f237a.peek();
        if (peek != null && peek.a()) {
            b(j);
        }
    }

    public void a(final String str, final String str2, final Date date, final Date date2, final int i, final boolean z) {
        this.f237a.add(new b() { // from class: com.xiaomi.push.da.1

            /* renamed from: a, reason: collision with other field name */
            File f239a;

            @Override // com.xiaomi.push.ae.b
            /* renamed from: c */
            public void mo269c() {
                File file = this.f239a;
                if (file != null && file.exists()) {
                    da.this.f237a.add(da.this.new c(str, str2, this.f239a, z));
                }
                da.this.a(0L);
            }

            @Override // com.xiaomi.push.da.b, com.xiaomi.push.ae.b
            public void b() {
                try {
                    File polarisFileWrapper = new PolarisFileWrapper(da.this.f236a.getFilesDir() + "/.logcache");
                    if (!u.m768a(polarisFileWrapper)) {
                        return;
                    }
                    polarisFileWrapper.mkdirs();
                    if (polarisFileWrapper.isDirectory()) {
                        cz czVar = new cz();
                        czVar.a(i);
                        this.f239a = czVar.a(da.this.f236a, date, date2, polarisFileWrapper);
                    }
                } catch (NullPointerException unused) {
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }
        });
        b(0L);
    }
}
