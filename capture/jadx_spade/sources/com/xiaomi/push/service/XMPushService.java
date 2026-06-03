package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.agent.instrumentation.ThreadMonitor;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.DebugManager;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.bg;
import com.xiaomi.push.cf;
import com.xiaomi.push.cm;
import com.xiaomi.push.cs;
import com.xiaomi.push.cw;
import com.xiaomi.push.da;
import com.xiaomi.push.ds;
import com.xiaomi.push.dy;
import com.xiaomi.push.en;
import com.xiaomi.push.eo;
import com.xiaomi.push.eq;
import com.xiaomi.push.ex;
import com.xiaomi.push.ez;
import com.xiaomi.push.fa;
import com.xiaomi.push.fc;
import com.xiaomi.push.fe;
import com.xiaomi.push.ff;
import com.xiaomi.push.fh;
import com.xiaomi.push.fj;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fy;
import com.xiaomi.push.fz;
import com.xiaomi.push.gc;
import com.xiaomi.push.ge;
import com.xiaomi.push.gj;
import com.xiaomi.push.ha;
import com.xiaomi.push.he;
import com.xiaomi.push.ho;
import com.xiaomi.push.ht;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.n;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class XMPushService extends Service implements fc {
    private static boolean b;

    /* renamed from: a, reason: collision with other field name */
    private ContentObserver f869a;

    /* renamed from: a, reason: collision with other field name */
    private ex f871a;

    /* renamed from: a, reason: collision with other field name */
    private ez f872a;

    /* renamed from: a, reason: collision with other field name */
    private fa f873a;

    /* renamed from: a, reason: collision with other field name */
    private a f875a;

    /* renamed from: a, reason: collision with other field name */
    private f f876a;

    /* renamed from: a, reason: collision with other field name */
    private k f877a;

    /* renamed from: a, reason: collision with other field name */
    private r f878a;

    /* renamed from: a, reason: collision with other field name */
    private t f879a;

    /* renamed from: a, reason: collision with other field name */
    private as f881a;

    /* renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.service.h f882a;

    /* renamed from: a, reason: collision with other field name */
    private Object f885a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f888a = false;
    private int a = 0;

    /* renamed from: b, reason: collision with other field name */
    private int f889b = 0;

    /* renamed from: a, reason: collision with other field name */
    private long f868a = 0;

    /* renamed from: a, reason: collision with other field name */
    protected Class f884a = XMJobService.class;
    private int c = -1;

    /* renamed from: a, reason: collision with other field name */
    private ak f880a = null;

    /* renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.service.n f883a = null;

    /* renamed from: a, reason: collision with other field name */
    Messenger f870a = null;

    /* renamed from: a, reason: collision with other field name */
    private Collection<aa> f887a = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: a, reason: collision with other field name */
    private ArrayList<n> f886a = new ArrayList<>();

    /* renamed from: a, reason: collision with other field name */
    private fe f874a = new fe() { // from class: com.xiaomi.push.service.XMPushService.1
        @Override // com.xiaomi.push.fe
        public void a(fn fnVar) {
            XMPushService.this.a(XMPushService.this.new m(fnVar));
        }

        @Override // com.xiaomi.push.fe
        public void a(eq eqVar) {
            if (com.xiaomi.push.service.e.a(eqVar)) {
                at.a().a(eqVar.e(), SystemClock.elapsedRealtime(), XMPushService.this.m663a());
            }
            XMPushService.this.a(XMPushService.this.new d(eqVar));
        }
    };

    public interface n {
        /* renamed from: a */
        void mo453a();
    }

    private void h() {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return com_xiaomi_push_service_XMPushService_com_dragon_read_base_lancet_ServiceAop_onStartCommand(this, intent, i2, i3);
    }

    /* renamed from: e, reason: collision with other method in class */
    public static boolean m658e() {
        return b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public int m663a() {
        if (this.c < 0) {
            this.c = com.xiaomi.push.g.a((Context) this, "com.xiaomi.xmsf");
        }
        return this.c;
    }

    /* renamed from: a, reason: collision with other method in class */
    private int[] m656a() {
        String[] split;
        String a2 = ah.a(getApplicationContext()).a(gj.FallDownTimeRange.a(), "");
        if (!TextUtils.isEmpty(a2) && (split = a2.split(",")) != null && split.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(split[0]).intValue();
                int intValue = Integer.valueOf(split[1]).intValue();
                iArr[1] = intValue;
                int i2 = iArr[0];
                if (i2 >= 0 && i2 <= 23 && intValue >= 0 && intValue <= 23 && i2 != intValue) {
                    return iArr;
                }
            } catch (NumberFormatException e2) {
                com.xiaomi.channel.commonutils.logger.b.d("parse falldown time range failure: " + e2);
            }
        }
        return null;
    }

    private static void a(String str) {
        if (com.xiaomi.push.m.China.name().equals(str)) {
            cf.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
            cf.a("cn.app.chat.xiaomi.net", "111.13.141.211:443");
            cf.a("cn.app.chat.xiaomi.net", "39.156.81.172:443");
            cf.a("cn.app.chat.xiaomi.net", "111.202.1.250:443");
            cf.a("cn.app.chat.xiaomi.net", "123.125.102.213:443");
            cf.a("resolver.msg.xiaomi.net", "111.13.142.153:443");
            cf.a("resolver.msg.xiaomi.net", "111.202.1.252:443");
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    void m666a() {
        if (SystemClock.elapsedRealtime() - this.f868a >= ff.a() && com.xiaomi.push.at.c(this)) {
            b(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(android.content.Intent r17) {
        /*
            Method dump skipped, instructions count: 2277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.d(android.content.Intent):void");
    }

    void a(final String str, final byte[] bArr, boolean z) {
        Collection<am.b> m697a = am.a().m697a("5");
        if (m697a.isEmpty()) {
            if (z) {
                com.xiaomi.push.service.t.b(str, bArr);
            }
        } else if (m697a.iterator().next().f931a == am.c.binded) {
            a(new j(4) { // from class: com.xiaomi.push.service.XMPushService.3
                @Override // com.xiaomi.push.service.XMPushService.j
                public String a() {
                    return "send mi push message";
                }

                @Override // com.xiaomi.push.service.XMPushService.j
                /* renamed from: a */
                public void mo383a() {
                    try {
                        w.a(XMPushService.this, str, bArr);
                    } catch (fh e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                        XMPushService.this.a(10, e2);
                    }
                }
            });
        } else if (z) {
            com.xiaomi.push.service.t.b(str, bArr);
        }
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            com.xiaomi.push.service.t.a(this, str, bArr, 70000003, "null payload");
            com.xiaomi.channel.commonutils.logger.b.m54a("register request without payload");
            return;
        }
        ha haVar = new ha();
        try {
            ho.a(haVar, bArr);
            if (haVar.f649a == ge.Registration) {
                he heVar = new he();
                try {
                    ho.a(heVar, haVar.m539a());
                    a(new com.xiaomi.push.service.s(this, haVar.b(), heVar.b(), heVar.c(), bArr));
                    ds.a(getApplicationContext()).a(haVar.b(), "E100003", heVar.a(), 6002, null);
                } catch (ht e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("app register error. " + e2);
                    com.xiaomi.push.service.t.a(this, str, bArr, 70000003, " data action error.");
                }
            } else {
                com.xiaomi.push.service.t.a(this, str, bArr, 70000003, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.m54a("register request with invalid payload");
            }
        } catch (ht e3) {
            com.xiaomi.channel.commonutils.logger.b.d("app register fail. " + e3);
            com.xiaomi.push.service.t.a(this, str, bArr, 70000003, " data container error.");
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m655a(String str, Intent intent) {
        am.b a2 = am.a().a(str, intent.getStringExtra(an.s));
        boolean z = false;
        if (a2 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(an.J);
        String stringExtra2 = intent.getStringExtra(an.B);
        if (!TextUtils.isEmpty(a2.i) && !TextUtils.equals(stringExtra, a2.i)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("session changed. old session=" + a2.i + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(a2.h)) {
            return z;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("security changed. chid = " + str + " sechash = " + com.xiaomi.push.az.a(stringExtra2));
        return true;
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        am.b a2 = am.a().a(str, str2);
        if (a2 != null) {
            a(new s(a2, i2, str4, str3));
        }
        am.a().m701a(str, str2);
    }

    private void a(String str, int i2) {
        Collection<am.b> m697a = am.a().m697a(str);
        if (m697a != null) {
            for (am.b bVar : m697a) {
                if (bVar != null) {
                    a(new s(bVar, i2, null, null));
                }
            }
        }
        am.a().m700a(str);
    }

    public void a(j jVar) {
        a(jVar, 0L);
    }

    public void a(j jVar, long j2) {
        try {
            this.f883a.a(jVar, j2);
        } catch (IllegalStateException e2) {
            com.xiaomi.channel.commonutils.logger.b.m54a("can't execute job err = " + e2.getMessage());
        }
    }

    public void a(eq eqVar) {
        ez ezVar = this.f872a;
        if (ezVar != null) {
            ezVar.b(eqVar);
            return;
        }
        throw new fh("try send msg while connection is null.");
    }

    public void a(eq[] eqVarArr) {
        ez ezVar = this.f872a;
        if (ezVar != null) {
            ezVar.a(eqVarArr);
            return;
        }
        throw new fh("try send msg while connection is null.");
    }

    public void a(boolean z) {
        this.f881a.a(z);
    }

    public void a(am.b bVar) {
        if (bVar != null) {
            long a2 = bVar.a();
            com.xiaomi.channel.commonutils.logger.b.m54a("schedule rebind job in " + (a2 / 1000));
            a(new b(bVar), a2);
        }
    }

    public void a(int i2, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect ");
        sb.append(hashCode());
        sb.append(", ");
        ez ezVar = this.f872a;
        sb.append(ezVar == null ? null : Integer.valueOf(ezVar.hashCode()));
        com.xiaomi.channel.commonutils.logger.b.m54a(sb.toString());
        ez ezVar2 = this.f872a;
        if (ezVar2 != null) {
            ezVar2.b(i2, exc);
            this.f872a = null;
        }
        a(7);
        a(4);
        am.a().a(this, i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m667a() {
        boolean m155a = com.xiaomi.push.at.m155a((Context) this);
        boolean z = am.a().m695a() > 0;
        boolean z2 = !m671b();
        boolean m661h = m661h();
        boolean z3 = !m660g();
        boolean z4 = m155a && z && z2 && m661h && z3;
        if (!z4) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", Boolean.valueOf(m155a), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(m661h), Boolean.valueOf(z3)));
        }
        return z4;
    }

    /* renamed from: a, reason: collision with other method in class */
    public com.xiaomi.push.service.h m665a() {
        return new com.xiaomi.push.service.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        try {
            com.xiaomi.push.af.a();
            for (int i2 = 100; i2 > 0; i2--) {
                if (com.xiaomi.push.at.b(context)) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("network connectivity ok.");
                    return true;
                }
                try {
                    ThreadMonitor.sleepMonitor(100L);
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return true;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public ez m664a() {
        return this.f872a;
    }

    public void a(int i2) {
        this.f883a.a(i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m668a(int i2) {
        return this.f883a.m736a(i2);
    }

    @Override // com.xiaomi.push.fc
    public void a(ez ezVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        en.a().a(ezVar);
    }

    @Override // com.xiaomi.push.fc
    public void a(ez ezVar, int i2, Exception exc) {
        en.a().a(ezVar, i2, exc);
        if (m662i()) {
            return;
        }
        a(false);
    }

    @Override // com.xiaomi.push.fc
    public void a(ez ezVar, Exception exc) {
        en.a().a(ezVar, exc);
        c(false);
        if (m662i()) {
            return;
        }
        a(false);
    }

    public void a(n nVar) {
        synchronized (this.f886a) {
            this.f886a.add(nVar);
        }
    }

    class h extends j {
        static {
            Covode.recordClassIndex(655643);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "Init Job";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo383a() {
            XMPushService.this.c();
        }

        h() {
            super(65535);
        }
    }

    class i extends j {
        private Intent a;

        static {
            Covode.recordClassIndex(655644);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo383a() {
            XMPushService.this.d(this.a);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "Handle intent action = " + this.a.getAction();
        }

        public i(Intent intent) {
            super(15);
            this.a = intent;
        }
    }

    static class c extends j {
        private final am.b a;

        static {
            Covode.recordClassIndex(655638);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo383a() {
            this.a.a(am.c.unbind, 1, 21, (String) null, (String) null);
        }

        public int hashCode() {
            return this.a.g.hashCode();
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "bind time out. chid=" + this.a.g;
        }

        public c(am.b bVar) {
            super(12);
            this.a = bVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            return TextUtils.equals(((c) obj).a.g, this.a.g);
        }
    }

    public class g extends j {

        /* renamed from: a, reason: collision with other field name */
        public Exception f898a;
        public int b;

        static {
            Covode.recordClassIndex(655642);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo383a() {
            XMPushService.this.a(this.b, this.f898a);
        }

        g(int i, Exception exc) {
            super(2);
            this.b = i;
            this.f898a = exc;
        }
    }

    class l extends j {
        static {
            Covode.recordClassIndex(655647);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "ask the job queue to quit";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo383a() {
            XMPushService.this.f883a.m734a();
        }

        public l() {
            super(5);
        }
    }

    class m extends j {
        private fn a;

        static {
            Covode.recordClassIndex(655648);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo383a() {
            XMPushService.this.f880a.a(this.a);
        }

        public m(fn fnVar) {
            super(8);
            this.a = fnVar;
        }
    }

    static {
        Covode.recordClassIndex(655635);
        b = false;
    }

    private void i() {
        synchronized (this.f886a) {
            this.f886a.clear();
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public com.xiaomi.push.service.h m669b() {
        return this.f882a;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m672c() {
        ez ezVar = this.f872a;
        if (ezVar != null && ezVar.m423c()) {
            return true;
        }
        return false;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m673d() {
        ez ezVar = this.f872a;
        if (ezVar != null && ezVar.m422b()) {
            return true;
        }
        return false;
    }

    class b extends j {

        /* renamed from: a, reason: collision with other field name */
        am.b f896a;

        static {
            Covode.recordClassIndex(655637);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "bind the client. " + this.f896a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo383a() {
            try {
                if (!XMPushService.this.m672c()) {
                    com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                } else {
                    am a = am.a();
                    am.b bVar = this.f896a;
                    am.b a2 = a.a(bVar.g, bVar.f936b);
                    if (a2 == null) {
                        com.xiaomi.channel.commonutils.logger.b.m54a("ignore bind because the channel " + this.f896a.g + " is removed ");
                    } else if (a2.f931a == am.c.unbind) {
                        a2.a(am.c.binding, 0, 0, (String) null, (String) null);
                        XMPushService.this.f872a.a(a2);
                        eo.a(XMPushService.this, a2);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.m54a("trying duplicate bind, ingore! " + a2.f931a);
                    }
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("Meet error when trying to bind. " + e);
                XMPushService.this.a(10, e);
            } catch (Throwable unused) {
            }
        }

        public b(am.b bVar) {
            super(9);
            this.f896a = bVar;
        }
    }

    class d extends j {
        private eq a;

        static {
            Covode.recordClassIndex(655639);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo383a() {
            XMPushService.this.f880a.a(this.a);
            if (com.xiaomi.push.service.e.a(this.a)) {
                XMPushService.this.a(new at.a(), 15000L);
            }
        }

        public d(eq eqVar) {
            super(8);
            this.a = eqVar;
        }
    }

    public class e extends j {
        static {
            Covode.recordClassIndex(655640);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "do reconnect..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo383a() {
            if (XMPushService.this.m667a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                    return;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m54a("should not connect. quit the job.");
        }

        e() {
            super(1);
        }
    }

    public static abstract class j extends n.b {
        static {
            Covode.recordClassIndex(655645);
        }

        public abstract String a();

        /* renamed from: a */
        public abstract void mo383a();

        @Override // java.lang.Runnable
        public void run() {
            int i = this.a;
            if (i != 4 && i != 8) {
                com.xiaomi.channel.commonutils.logger.b.m55a(com.xiaomi.channel.commonutils.logger.a.a, a());
            }
            mo383a();
        }

        public j(int i) {
            super(i);
        }
    }

    class p extends j {

        /* renamed from: a, reason: collision with other field name */
        am.b f902a;

        static {
            Covode.recordClassIndex(655651);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "rebind the client. " + this.f902a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo383a() {
            try {
                this.f902a.a(am.c.unbind, 1, 16, (String) null, (String) null);
                ez ezVar = XMPushService.this.f872a;
                am.b bVar = this.f902a;
                ezVar.a(bVar.g, bVar.f936b);
                XMPushService.this.a(XMPushService.this.new b(this.f902a), 300L);
            } catch (fh e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                XMPushService.this.a(10, e);
            }
        }

        public p(am.b bVar) {
            super(4);
            this.f902a = bVar;
        }
    }

    class s extends j {

        /* renamed from: a, reason: collision with other field name */
        am.b f903a;

        /* renamed from: a, reason: collision with other field name */
        String f904a;
        int b;

        /* renamed from: b, reason: collision with other field name */
        String f905b;

        static {
            Covode.recordClassIndex(655654);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "unbind the channel. " + this.f903a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo383a() {
            if (this.f903a.f931a != am.c.unbind && XMPushService.this.f872a != null) {
                try {
                    ez ezVar = XMPushService.this.f872a;
                    am.b bVar = this.f903a;
                    ezVar.a(bVar.g, bVar.f936b);
                } catch (fh e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
            this.f903a.a(am.c.unbind, this.b, 0, this.f905b, this.f904a);
        }

        public s(am.b bVar, int i, String str, String str2) {
            super(9);
            this.f903a = bVar;
            this.b = i;
            this.f904a = str;
            this.f905b = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (m667a()) {
            if (!dy.m375a()) {
                dy.a(true);
                return;
            }
            return;
        }
        dy.a();
    }

    /* renamed from: f, reason: collision with other method in class */
    private boolean m659f() {
        if (SystemClock.elapsedRealtime() - this.f868a < 30000) {
            return false;
        }
        return com.xiaomi.push.at.c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: collision with other method in class */
    public boolean m660g() {
        if (!"com.xiaomi.xmsf".equals(getPackageName()) || Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) != 1) {
            return false;
        }
        return true;
    }

    private boolean k() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return ah.a(this).a(gj.ForegroundServiceSwitch.a(), false);
    }

    private class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with other field name */
        private final Object f895a;

        static {
            Covode.recordClassIndex(655636);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (this.f895a) {
                try {
                    this.f895a.notifyAll();
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("[Alarm] notify lock. " + e);
                }
            }
        }

        private a() {
            this.f895a = new Object();
        }

        private void a(long j) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.wait in the UI thread!");
                return;
            }
            synchronized (this.f895a) {
                try {
                    this.f895a.wait(j);
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("[Alarm] interrupt from waiting state. " + e);
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long currentTimeMillis = System.currentTimeMillis();
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] heartbeat alarm has been triggered.");
            if (an.q.equals(intent.getAction())) {
                if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                    com.xiaomi.channel.commonutils.logger.b.c("[Alarm] Ping XMChannelService on timer");
                    try {
                        Intent intent2 = new Intent(context, (Class<?>) XMPushService.class);
                        intent2.putExtra("time_stamp", System.currentTimeMillis());
                        intent2.setAction("com.xiaomi.push.timer");
                        ServiceClient.getInstance(context).startServiceSafely(intent2);
                        a(3000L);
                        com.xiaomi.channel.commonutils.logger.b.m54a("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - currentTimeMillis));
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m54a("[Alarm] cancel the old ping timer");
            dy.a();
        }
    }

    class o extends j {

        /* renamed from: a, reason: collision with other field name */
        boolean f901a;

        static {
            Covode.recordClassIndex(655650);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo383a() {
            if (XMPushService.this.m672c()) {
                try {
                    if (!this.f901a) {
                        eo.a();
                    }
                    XMPushService.this.f872a.b(this.f901a);
                } catch (fh e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
        }

        public o(boolean z) {
            super(4);
            this.f901a = z;
        }
    }

    class q extends j {
        static {
            Covode.recordClassIndex(655652);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "reset the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo383a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.m667a()) {
                XMPushService xMPushService = XMPushService.this;
                if (!xMPushService.a(xMPushService.getApplicationContext())) {
                    return;
                }
                XMPushService.this.f();
            }
        }

        q() {
            super(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ez ezVar = this.f872a;
        if (ezVar != null && ezVar.m422b()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while connecting.");
            return;
        }
        ez ezVar2 = this.f872a;
        if (ezVar2 != null && ezVar2.m423c()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while is connected.");
            return;
        }
        this.f873a.b(com.xiaomi.push.at.m151a((Context) this));
        g();
        if (this.f872a == null) {
            am.a().a(this);
            c(false);
        }
    }

    private void g() {
        try {
            this.f871a.a(this.f874a, new fj() { // from class: com.xiaomi.push.service.XMPushService.5
                @Override // com.xiaomi.push.fj
                /* renamed from: a */
                public boolean mo244a(fn fnVar) {
                    return true;
                }
            });
            this.f871a.e();
            this.f872a = this.f871a;
        } catch (fh e2) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
            this.f871a.b(3, e2);
        }
    }

    /* renamed from: i, reason: collision with other method in class */
    private boolean m662i() {
        if (getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !com.xiaomi.push.i.m624b((Context) this) && !com.xiaomi.push.i.m621a(getApplicationContext())) {
            return true;
        }
        return false;
    }

    private boolean j() {
        int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i2 = this.a;
        int i3 = this.f889b;
        if (i2 > i3) {
            if (intValue >= i2 || intValue < i3) {
                return true;
            }
        } else if (i2 < i3 && intValue >= i2 && intValue < i3) {
            return true;
        }
        return false;
    }

    private String a() {
        String m628a = com.xiaomi.push.j.m628a("ro.miui.region");
        if (TextUtils.isEmpty(m628a)) {
            return com.xiaomi.push.j.m628a("ro.product.locale.region");
        }
        return m628a;
    }

    private String b() {
        String str;
        com.xiaomi.push.af.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        int i2 = 0;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            ap a2 = ap.a(this);
            String str2 = null;
            while (true) {
                if (!TextUtils.isEmpty(str2) && a2.a() != 0) {
                    str = a();
                    break;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = a();
                }
                try {
                    synchronized (obj) {
                        if (i2 < 30) {
                            obj.wait(1000L);
                        } else {
                            obj.wait(30000L);
                        }
                    }
                } catch (InterruptedException unused) {
                }
                i2++;
            }
        } else {
            str = "CN";
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("wait coutrycode :" + str + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " , count = " + i2);
        return str;
    }

    /* renamed from: h, reason: collision with other method in class */
    private boolean m661h() {
        boolean z;
        String packageName = getPackageName();
        if ("com.xiaomi.xmsf".equals(packageName)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("current sdk expect region is cn");
            z = com.xiaomi.push.m.China.name().equals(com.xiaomi.push.service.b.a(getApplicationContext()).a());
        } else {
            z = !com.xiaomi.push.service.r.a(this).m750b(packageName);
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m56a("XMPushService", "-->isPushEnabled(): isEnabled=", Boolean.valueOf(z), ", package=", packageName, ", region=", com.xiaomi.push.service.b.a(getApplicationContext()).a());
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(15:0|1|(1:3)(1:37)|4|(2:29|(3:31|(1:33)(1:35)|34)(10:36|10|(1:12)|13|(1:15)|16|17|(1:19)|21|(2:23|24)(1:26)))(1:8)|9|10|(0)|13|(0)|16|17|(0)|21|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e5, code lost:
    
        com.xiaomi.channel.commonutils.logger.b.a(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00de A[Catch: Exception -> 0x00e4, TRY_LEAVE, TryCatch #0 {Exception -> 0x00e4, blocks: (B:17:0x00d8, B:19:0x00de), top: B:16:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c() {
        /*
            r10 = this;
            com.xiaomi.push.cf r0 = com.xiaomi.push.cf.a()
            r0.m241d()
            android.content.Context r0 = r10.getApplicationContext()
            com.xiaomi.push.service.m r0 = com.xiaomi.push.service.m.a(r0)
            r0.m728a()
            android.content.Context r0 = r10.getApplicationContext()
            com.xiaomi.push.service.b r0 = com.xiaomi.push.service.b.a(r0)
            java.lang.String r1 = r0.a()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "region of cache is "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "XMPushService"
            com.xiaomi.channel.commonutils.logger.b.m55a(r3, r2)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r4 = ""
            if (r2 == 0) goto L4c
            java.lang.String r1 = r10.b()
            com.xiaomi.push.m r2 = com.xiaomi.push.j.a(r1)
            java.lang.String r2 = r2.name()
            r9 = r2
            r2 = r1
            r1 = r9
            goto L4d
        L4c:
            r2 = r4
        L4d:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r6 = "CN"
            java.lang.String r7 = "com.xiaomi.xmsf"
            r8 = 1
            if (r5 != 0) goto L6c
            com.xiaomi.push.m r5 = com.xiaomi.push.m.China
            java.lang.String r5 = r5.name()
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L6c
            r0.a(r1, r8)
            r0.b(r6, r8)
        L6a:
            r2 = r6
            goto L92
        L6c:
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L8c
            java.lang.String r1 = r10.getPackageName()
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L7e
            r6 = r4
            goto L84
        L7e:
            com.xiaomi.push.m r1 = com.xiaomi.push.m.China
            java.lang.String r4 = r1.name()
        L84:
            r0.a(r4, r8)
            r0.b(r6, r8)
            r1 = r4
            goto L6a
        L8c:
            com.xiaomi.push.m r0 = com.xiaomi.push.m.China
            java.lang.String r1 = r0.name()
        L92:
            r0 = 4
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r4 = 0
            java.lang.String r5 = "after check, appRegion is "
            r0[r4] = r5
            r0[r8] = r1
            r4 = 2
            java.lang.String r5 = ", countryCode="
            r0[r4] = r5
            r4 = 3
            r0[r4] = r2
            com.xiaomi.channel.commonutils.logger.b.m56a(r3, r0)
            com.xiaomi.push.m r0 = com.xiaomi.push.m.China
            java.lang.String r0 = r0.name()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lb8
            java.lang.String r0 = "cn.app.chat.xiaomi.net"
            com.xiaomi.push.fa.a(r0)
        Lb8:
            a(r1)
            boolean r0 = r10.m661h()
            if (r0 == 0) goto Ld8
            java.lang.String r0 = "-->postOnCreate(): try trigger connect now"
            com.xiaomi.channel.commonutils.logger.b.m55a(r3, r0)
            com.xiaomi.push.service.XMPushService$13 r0 = new com.xiaomi.push.service.XMPushService$13
            r1 = 11
            r0.<init>(r1)
            r10.a(r0)
            com.xiaomi.push.service.XMPushService$14 r1 = new com.xiaomi.push.service.XMPushService$14
            r1.<init>()
            com.xiaomi.push.service.q.a(r1)
        Ld8:
            boolean r0 = com.xiaomi.push.q.m642a()     // Catch: java.lang.Exception -> Le4
            if (r0 == 0) goto Le8
            com.xiaomi.push.service.h r0 = r10.f882a     // Catch: java.lang.Exception -> Le4
            r0.a(r10)     // Catch: java.lang.Exception -> Le4
            goto Le8
        Le4:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r0)
        Le8:
            java.lang.String r0 = r10.getPackageName()
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto Lf9
            android.content.pm.ApplicationInfo r0 = r10.getApplicationInfo()
            com.xiaomi.push.g.a(r10, r0, r8)
        Lf9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.c():void");
    }

    private void d() {
        com.xiaomi.push.au m148a = com.xiaomi.push.at.m148a();
        com.xiaomi.push.service.m.a(getApplicationContext()).a(m148a);
        if (m148a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("network changed,");
            sb.append("[type: " + m148a.m158a() + "[" + m148a.m160b() + "], state: " + m148a.m157a() + "/" + m148a.m156a());
            com.xiaomi.channel.commonutils.logger.b.m55a("XMPushService", sb.toString());
            NetworkInfo.State m157a = m148a.m157a();
            if (m157a == NetworkInfo.State.SUSPENDED || m157a == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m55a("XMPushService", "network changed, no active network");
        }
        if (en.a() != null) {
            en.a().m385a();
        }
        fy.m451a((Context) this);
        this.f871a.d();
        if (com.xiaomi.push.at.m155a((Context) this)) {
            if (m672c() && m659f()) {
                b(false);
            }
            if (!m672c() && !m673d()) {
                this.f883a.a(1);
                a(new e());
            }
            da.a(this).a();
        } else {
            a(new g(2, null));
        }
        e();
    }

    @Override // android.app.Service
    public void onDestroy() {
        f fVar = this.f876a;
        if (fVar != null) {
            a(fVar);
            this.f876a = null;
        }
        Object obj = this.f885a;
        if (obj != null) {
            com.xiaomi.push.at.a(this, obj);
            this.f885a = null;
        }
        t tVar = this.f879a;
        if (tVar != null) {
            a(tVar);
            this.f879a = null;
        }
        k kVar = this.f877a;
        if (kVar != null) {
            a(kVar);
            this.f877a = null;
        }
        r rVar = this.f878a;
        if (rVar != null) {
            a(rVar);
            this.f878a = null;
        }
        a aVar = this.f875a;
        if (aVar != null) {
            a(aVar);
            this.f875a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f869a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f869a);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th.getMessage());
            }
        }
        this.f887a.clear();
        this.f883a.m737b();
        a(new j(2) { // from class: com.xiaomi.push.service.XMPushService.4
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "disconnect for service destroy.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo383a() {
                if (XMPushService.this.f872a != null) {
                    XMPushService.this.f872a.b(15, (Exception) null);
                    XMPushService.this.f872a = null;
                }
            }
        });
        a(new l());
        am.a().b();
        am.a().a(this, 15);
        am.a().m699a();
        this.f871a.b(this);
        ax.a().m714a();
        dy.a();
        i();
        cm.b(this, this.f871a);
        cs.b(this, this.f871a);
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.m54a("Service destroyed");
    }

    /* renamed from: b, reason: collision with other method in class */
    void m670b() {
        com.xiaomi.push.service.m.a(getApplicationContext()).m733d();
        Iterator it2 = new ArrayList(this.f886a).iterator();
        while (it2.hasNext()) {
            ((n) it2.next()).mo453a();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        String[] split;
        super.onCreate();
        com.xiaomi.channel.commonutils.logger.b.a(getApplicationContext());
        com.xiaomi.push.q.a((Context) this);
        com.xiaomi.push.service.p m745a = com.xiaomi.push.service.q.m745a((Context) this);
        if (m745a != null) {
            com.xiaomi.push.w.a(m745a.a);
        }
        if (com.xiaomi.push.j.m631a(getApplicationContext())) {
            HandlerThread handlerThread = new HandlerThread("hb-alarm");
            handlerThread.start();
            HandlerDelegate handlerDelegate = new HandlerDelegate(handlerThread.getLooper());
            this.f875a = new a();
            com.xiaomi.push.l.a(this, this.f875a, new IntentFilter(an.q), "com.xiaomi.xmsf.permission.MIPUSH_RECEIVE", handlerDelegate, 4);
            b = true;
            handlerDelegate.post(new Runnable() { // from class: com.xiaomi.push.service.XMPushService.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PackageManager packageManager = XMPushService.this.getApplicationContext().getPackageManager();
                        ComponentName componentName = new ComponentName(XMPushService.this.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
                        if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                            packageManager.setComponentEnabledSetting(componentName, 2, 1);
                        }
                    } catch (Throwable th) {
                        com.xiaomi.channel.commonutils.logger.b.m54a("[Alarm] disable ping receiver may be failure. " + th);
                    }
                }
            });
        }
        this.f870a = new Messenger((Handler) new HandlerDelegate() { // from class: com.xiaomi.push.service.XMPushService.8
            /* JADX WARN: Multi-variable type inference failed */
            public void handleMessage(Message message) {
                super/*android.os.Handler*/.handleMessage(message);
                if (message != null) {
                    try {
                        int i2 = message.what;
                        if (i2 != 17) {
                            if (i2 == 18) {
                                Message obtain = Message.obtain((Handler) null, 0);
                                obtain.what = 18;
                                Bundle bundle = new Bundle();
                                bundle.putString("xmsf_region", com.xiaomi.push.service.b.a(XMPushService.this.getApplicationContext()).a());
                                obtain.setData(bundle);
                                message.replyTo.send(obtain);
                            }
                        } else {
                            Object obj = message.obj;
                            if (obj != null) {
                                XMPushService.this.onStart((Intent) obj, 1);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
        ao.a(this);
        fa faVar = new fa(null, 5222, "xiaomi.com", null) { // from class: com.xiaomi.push.service.XMPushService.9
            @Override // com.xiaomi.push.fa
            /* renamed from: a */
            public byte[] mo426a() {
                try {
                    Cdo.b bVar = new Cdo.b();
                    bVar.a(ax.a().m712a());
                    return bVar.m378a();
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("getOBBString err: " + e2.toString());
                    return null;
                }
            }
        };
        this.f873a = faVar;
        faVar.a(true);
        this.f871a = new ex(this, this.f873a);
        this.f882a = m665a();
        dy.a(this);
        this.f871a.a(this);
        this.f880a = new ak(this);
        this.f881a = new as(this);
        new com.xiaomi.push.service.i().a();
        en.m386a().a(this);
        this.f883a = new com.xiaomi.push.service.n("Connection Controller Thread");
        am a2 = am.a();
        a2.b();
        a2.a(new am.a() { // from class: com.xiaomi.push.service.XMPushService.10
            @Override // com.xiaomi.push.service.am.a
            public void a() {
                XMPushService.this.e();
                if (am.a().m695a() <= 0) {
                    XMPushService.this.a(XMPushService.this.new g(12, null));
                }
            }
        });
        if (k()) {
            h();
        }
        gc.a(this).a(new com.xiaomi.push.service.o(this), "UPLOADER_PUSH_CHANNEL");
        a(new fz(this));
        a(new bd(this));
        if (com.xiaomi.push.j.m631a((Context) this)) {
            a(new al());
            if (com.xiaomi.push.i.m620a()) {
                a(new n() { // from class: com.xiaomi.push.service.XMPushService.11
                    @Override // com.xiaomi.push.service.XMPushService.n
                    /* renamed from: a */
                    public void mo453a() {
                        bg.a(XMPushService.this.getApplicationContext());
                    }
                });
            }
        }
        a(new h());
        this.f887a.add(ay.a(this));
        if (m661h()) {
            this.f876a = new f();
            com.xiaomi.push.l.a(this, this.f876a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), (String) null, (Handler) null);
            this.f885a = com.xiaomi.push.at.m150a((Context) this);
        }
        if (com.xiaomi.push.j.m631a(getApplicationContext())) {
            this.f879a = new t();
            com.xiaomi.push.l.a(this, this.f879a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null, 2);
            k kVar = new k();
            this.f877a = kVar;
            com.xiaomi.push.l.a(this, kVar, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null, 2);
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor != null) {
                this.f869a = new ContentObserver(new HandlerDelegate(Looper.getMainLooper())) { // from class: com.xiaomi.push.service.XMPushService.12
                    @Override // android.database.ContentObserver
                    public void onChange(boolean z) {
                        super.onChange(z);
                        boolean m660g = XMPushService.this.m660g();
                        com.xiaomi.channel.commonutils.logger.b.m54a("SuperPowerMode:" + m660g);
                        XMPushService.this.e();
                        if (m660g) {
                            XMPushService.this.a(XMPushService.this.new g(24, null));
                        } else {
                            XMPushService.this.a(true);
                        }
                    }
                };
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f869a);
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th.getMessage());
                }
            }
            int[] m656a = m656a();
            if (m656a != null) {
                this.f878a = new r();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                com.xiaomi.push.l.a(this, this.f878a, intentFilter, (String) null, (Handler) null);
                this.a = m656a[0];
                this.f889b = m656a[1];
                com.xiaomi.channel.commonutils.logger.b.m54a("falldown initialized: " + this.a + "," + this.f889b);
            }
        }
        cm.a(this, this.f871a);
        cs.a(this, this.f871a);
        String str = "";
        if (m745a != null) {
            try {
                if (!TextUtils.isEmpty(m745a.f1002a) && (split = m745a.f1002a.split("@")) != null && split.length > 0) {
                    str = split[0];
                }
            } catch (Exception unused) {
            }
        }
        cw.a(this);
        com.xiaomi.channel.commonutils.logger.b.e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", vc=" + com.xiaomi.push.g.a(getApplicationContext(), getPackageName()) + ", uuid=" + str);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m671b() {
        try {
            Class<?> a2 = com.xiaomi.push.q.a(this, "miui.os.Build");
            Field field = a2.getField("IS_CM_CUSTOMIZATION_TEST");
            Field field2 = a2.getField("IS_CU_CUSTOMIZATION_TEST");
            Field field3 = a2.getField("IS_CT_CUSTOMIZATION_TEST");
            if (!field.getBoolean(null) && !field2.getBoolean(null)) {
                if (!field3.getBoolean(null)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    class f extends BroadcastReceiver {
        static {
            Covode.recordClassIndex(655641);
        }

        f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.push.at.m154a();
            XMPushService.this.onStart(intent, 1);
        }
    }

    class k extends BroadcastReceiver {
        static {
            Covode.recordClassIndex(655646);
        }

        k() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.channel.commonutils.logger.b.m54a("[HB] hold short heartbeat, " + com.xiaomi.push.j.a(intent));
            if (intent != null && intent.getExtras() != null) {
                XMPushService.this.onStart(intent, 1);
            }
        }
    }

    class r extends BroadcastReceiver {
        static {
            Covode.recordClassIndex(655653);
        }

        r() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    class t extends BroadcastReceiver {
        static {
            Covode.recordClassIndex(655655);
        }

        t() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!XMPushService.this.f888a) {
                XMPushService.this.f888a = true;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    private void c(j jVar) {
        this.f883a.a(jVar);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f870a.getBinder();
    }

    public void b(j jVar) {
        this.f883a.a(jVar.a, jVar);
    }

    private void b(boolean z) {
        this.f868a = SystemClock.elapsedRealtime();
        if (!m672c()) {
            a(true);
        } else if (com.xiaomi.push.at.m155a((Context) this)) {
            c(new o(z));
        } else {
            c(new g(17, null));
            a(true);
        }
    }

    private void c(Intent intent) {
        String stringExtra = intent.getStringExtra(an.F);
        String stringExtra2 = intent.getStringExtra(an.J);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        fm[] fmVarArr = new fm[length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            fm fmVar = new fm((Bundle) parcelableArrayExtra[i2]);
            fmVarArr[i2] = fmVar;
            fm fmVar2 = (fm) a(fmVar, stringExtra, stringExtra2);
            fmVarArr[i2] = fmVar2;
            if (fmVar2 == null) {
                return;
            }
        }
        am a2 = am.a();
        eq[] eqVarArr = new eq[length];
        for (int i3 = 0; i3 < length; i3++) {
            fm fmVar3 = fmVarArr[i3];
            eqVarArr[i3] = eq.a(fmVar3, a2.a(fmVar3.k(), fmVar3.m()).h);
        }
        c(new com.xiaomi.push.service.c(this, eqVarArr));
    }

    private void b(Intent intent) {
        long j2;
        eq eqVar;
        String stringExtra = intent.getStringExtra(an.F);
        String stringExtra2 = intent.getStringExtra(an.J);
        Bundle INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra = INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(intent, "ext_packet");
        am a2 = am.a();
        if (INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra != null) {
            fm fmVar = (fm) a(new fm(INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra), stringExtra, stringExtra2);
            if (fmVar == null) {
                return;
            } else {
                eqVar = eq.a(fmVar, a2.a(fmVar.k(), fmVar.m()).h);
            }
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j2 = Long.parseLong(intent.getStringExtra(an.s));
                } catch (NumberFormatException unused) {
                    j2 = 0;
                }
                String stringExtra3 = intent.getStringExtra(an.t);
                String stringExtra4 = intent.getStringExtra(an.u);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                am.b a3 = a2.a(stringExtra5, String.valueOf(j2));
                if (a3 != null) {
                    eq eqVar2 = new eq();
                    try {
                        eqVar2.a(Integer.parseInt(stringExtra5));
                    } catch (NumberFormatException unused2) {
                    }
                    eqVar2.a("SECMSG", (String) null);
                    if (TextUtils.isEmpty(stringExtra3)) {
                        stringExtra3 = "xiaomi.com";
                    }
                    eqVar2.a(j2, stringExtra3, stringExtra4);
                    eqVar2.a(intent.getStringExtra("ext_pkt_id"));
                    eqVar2.a(byteArrayExtra, a3.h);
                    com.xiaomi.channel.commonutils.logger.b.m54a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                    eqVar = eqVar2;
                }
            }
            eqVar = null;
        }
        if (eqVar != null) {
            c(new aw(this, eqVar));
        }
    }

    private void c(boolean z) {
        try {
            if (com.xiaomi.push.q.m642a()) {
                if (z) {
                    if (com.xiaomi.push.j.m631a((Context) this)) {
                        Intent intent = new Intent("miui.intent.action.NETWORK_CONNECTED");
                        intent.addFlags(1073741824);
                        sendBroadcast(intent);
                    }
                    for (aa aaVar : (aa[]) this.f887a.toArray(new aa[0])) {
                        aaVar.mo716a();
                    }
                    return;
                }
                if (com.xiaomi.push.j.m631a((Context) this)) {
                    Intent intent2 = new Intent("miui.intent.action.NETWORK_BLOCKED");
                    intent2.addFlags(1073741824);
                    sendBroadcast(intent2);
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(this, broadcastReceiver);
            } catch (IllegalArgumentException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    @Override // com.xiaomi.push.fc
    public void b(ez ezVar) {
        en.a().b(ezVar);
        c(true);
        this.f881a.m707a();
        if (!dy.m375a() && !m662i()) {
            com.xiaomi.channel.commonutils.logger.b.m54a("reconnection successful, reactivate alarm.");
            dy.a(true);
        }
        Iterator<am.b> it2 = am.a().m696a().iterator();
        while (it2.hasNext()) {
            a(new b(it2.next()));
        }
        if (!this.f888a && com.xiaomi.push.j.m631a(getApplicationContext())) {
            com.xiaomi.push.ad.a(getApplicationContext()).a(new Runnable() { // from class: com.xiaomi.push.service.XMPushService.6
                @Override // java.lang.Runnable
                public void run() {
                    XMPushService.this.f888a = true;
                    try {
                        com.xiaomi.channel.commonutils.logger.b.m54a("try to trigger the wifi digest broadcast.");
                        Object systemService = XMPushService.this.getApplicationContext().getSystemService("MiuiWifiService");
                        if (systemService != null) {
                            com.xiaomi.push.av.b(systemService, "sendCurrentWifiDigestInfo", new Object[0]);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private void a(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null) {
            String string = extras.getString("digest");
            com.xiaomi.push.service.m.a(getApplicationContext()).m729a(string);
            cm.a(this, string);
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static void INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(XMPushService xMPushService, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        xMPushService.unregisterReceiver(broadcastReceiver);
    }

    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    public static Bundle INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(Intent intent, String str) {
        Bundle bundleExtra = intent.getBundleExtra(str);
        Context context = BadParcelableCrashOptimizer.getContext();
        if (bundleExtra != null && context != null) {
            bundleExtra.setClassLoader(context.getClassLoader());
        }
        return bundleExtra;
    }

    private am.b a(String str, Intent intent) {
        am.b a2 = am.a().a(str, intent.getStringExtra(an.s));
        if (a2 == null) {
            a2 = new am.b(this);
        }
        a2.g = intent.getStringExtra(an.v);
        a2.f936b = intent.getStringExtra(an.s);
        a2.c = intent.getStringExtra(an.z);
        a2.f933a = intent.getStringExtra(an.F);
        a2.e = intent.getStringExtra(an.D);
        a2.f = intent.getStringExtra(an.E);
        a2.f935a = intent.getBooleanExtra(an.C, false);
        a2.h = intent.getStringExtra(an.B);
        a2.i = intent.getStringExtra(an.J);
        a2.d = intent.getStringExtra(an.A);
        a2.f932a = this.f882a;
        a2.a((Messenger) intent.getParcelableExtra(an.N));
        a2.f925a = getApplicationContext();
        am.a().a(a2);
        return a2;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            try {
                String stringExtra = intent.getStringExtra(an.v);
                String stringExtra2 = intent.getStringExtra(an.F);
                String stringExtra3 = intent.getStringExtra("mipush_app_package");
                if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && !"miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(intent.getAction())) {
                    com.xiaomi.channel.commonutils.logger.b.m55a("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), stringExtra, stringExtra2, stringExtra3));
                }
                com.xiaomi.channel.commonutils.logger.b.m55a("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s, intent = %s", intent.getAction(), stringExtra, stringExtra2, stringExtra3, com.xiaomi.push.j.a(intent)));
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("onStart() cause error: " + th.getMessage());
                return;
            }
        }
        if (intent != null && intent.getAction() != null) {
            if (!"com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) && !"com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                    a(new i(intent));
                }
            } else if (this.f883a.m735a()) {
                com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                am.a().a(this, 14);
                stopSelf();
            } else {
                a(new i(intent));
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            com.xiaomi.channel.commonutils.logger.b.c("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    public int XMPushService__onStartCommand$___twin___(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        if (com.xiaomi.push.j.m631a((Context) this)) {
            return 1;
        }
        return 2;
    }

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i2) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            PackageInfo INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i2);
            Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
        }
        x55.b bVar = x55.b.a;
        PackageInfo f2 = bVar.f(packageName, i2);
        if (f2 != null) {
            return f2;
        }
        PackageInfo INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i2);
        Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i2, INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
        return INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
    }

    @Proxy("getPackageInfo")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_service_XMPushService_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i2) {
        if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
            return null;
        }
        if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
            LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + Log.getStackTraceString(new Exception()), new Object[0]);
        }
        return packageManager.getPackageInfo(str, i2);
    }

    private fn a(fn fnVar, String str, String str2) {
        am a2 = am.a();
        List<String> m698a = a2.m698a(str);
        if (m698a.isEmpty()) {
            com.xiaomi.channel.commonutils.logger.b.m54a("open channel should be called first before sending a packet, pkg=" + str);
            return null;
        }
        fnVar.o(str);
        String k2 = fnVar.k();
        if (TextUtils.isEmpty(k2)) {
            k2 = m698a.get(0);
            fnVar.l(k2);
        }
        am.b a3 = a2.a(k2, fnVar.m());
        if (!m672c()) {
            com.xiaomi.channel.commonutils.logger.b.m54a("drop a packet as the channel is not connected, chid=" + k2);
            return null;
        }
        if (a3 != null && a3.f931a == am.c.binded) {
            if (!TextUtils.equals(str2, a3.i)) {
                com.xiaomi.channel.commonutils.logger.b.m54a("invalid session. " + str2);
                return null;
            }
            return fnVar;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("drop a packet as the channel is not opened, chid=" + k2);
        return null;
    }

    @TargetClass(scope = Scope.ALL, value = "android.app.Service")
    @Insert(mayCreateSuper = true, value = "onStartCommand")
    public static int com_xiaomi_push_service_XMPushService_com_dragon_read_base_lancet_ServiceAop_onStartCommand(XMPushService xMPushService, Intent intent, int i2, int i3) {
        int XMPushService__onStartCommand$___twin___ = xMPushService.XMPushService__onStartCommand$___twin___(intent, i2, i3);
        boolean a2 = ko2.u.a(XMPushService__onStartCommand$___twin___, xMPushService);
        if (a2) {
            String name = xMPushService.getClass().getName();
            xo2.j.a("intercept_sticky_service", "class_name", name);
            LogWrapper.info("ServiceAop", "intercept service onStartCommand " + name, new Object[0]);
        }
        if (a2) {
            return 2;
        }
        return XMPushService__onStartCommand$___twin___;
    }
}
