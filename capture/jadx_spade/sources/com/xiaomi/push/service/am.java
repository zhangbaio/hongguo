package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class am {
    private static am a;

    /* renamed from: a, reason: collision with other field name */
    private ConcurrentHashMap<String, HashMap<String, b>> f924a = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with other field name */
    private List<a> f923a = new ArrayList();

    public interface a {
        void a();
    }

    static {
        Covode.recordClassIndex(655676);
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> hashMap = this.f924a.get(bVar.g);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f924a.put(bVar.g, hashMap);
        }
        hashMap.put(a(bVar.f936b), bVar);
        com.xiaomi.channel.commonutils.logger.b.m54a("add active client. " + bVar.f933a);
        Iterator<a> it2 = this.f923a.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m701a(String str, String str2) {
        HashMap<String, b> hashMap = this.f924a.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(a(str2));
            if (bVar != null) {
                bVar.m703a();
            }
            hashMap.remove(a(str2));
            if (hashMap.isEmpty()) {
                this.f924a.remove(str);
            }
        }
        Iterator<a> it2 = this.f923a.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m700a(String str) {
        HashMap<String, b> hashMap = this.f924a.get(str);
        if (hashMap != null) {
            Iterator<b> it2 = hashMap.values().iterator();
            while (it2.hasNext()) {
                it2.next().m703a();
            }
            hashMap.clear();
            this.f924a.remove(str);
        }
        Iterator<a> it4 = this.f923a.iterator();
        while (it4.hasNext()) {
            it4.next().a();
        }
    }

    public synchronized void a(Context context, int i) {
        Iterator<HashMap<String, b>> it2 = this.f924a.values().iterator();
        while (it2.hasNext()) {
            Iterator<b> it4 = it2.next().values().iterator();
            while (it4.hasNext()) {
                it4.next().a(c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context) {
        Iterator<HashMap<String, b>> it2 = this.f924a.values().iterator();
        while (it2.hasNext()) {
            Iterator<b> it4 = it2.next().values().iterator();
            while (it4.hasNext()) {
                it4.next().a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with other field name */
        public Context f925a;

        /* renamed from: a, reason: collision with other field name */
        Messenger f927a;

        /* renamed from: a, reason: collision with other field name */
        private XMPushService f929a;

        /* renamed from: a, reason: collision with other field name */
        public h f932a;

        /* renamed from: a, reason: collision with other field name */
        public String f933a;

        /* renamed from: a, reason: collision with other field name */
        public boolean f935a;

        /* renamed from: b, reason: collision with other field name */
        public String f936b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        /* renamed from: a, reason: collision with other field name */
        c f931a = c.unbind;
        private int a = 0;

        /* renamed from: a, reason: collision with other field name */
        private final CopyOnWriteArrayList<a> f934a = new CopyOnWriteArrayList<>();
        c b = null;

        /* renamed from: b, reason: collision with other field name */
        private boolean f937b = false;

        /* renamed from: a, reason: collision with other field name */
        private XMPushService.c f928a = new XMPushService.c(this);

        /* renamed from: a, reason: collision with other field name */
        IBinder.DeathRecipient f926a = null;

        /* renamed from: a, reason: collision with other field name */
        final C0132b f930a = new C0132b();

        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        static {
            Covode.recordClassIndex(655678);
        }

        public String a(int i) {
            return i != 1 ? i != 2 ? i != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        void a(Messenger messenger) {
            m703a();
            try {
                if (messenger != null) {
                    this.f927a = messenger;
                    this.f937b = true;
                    this.f926a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f926a, 0);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.g);
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e.getMessage());
                this.f927a = null;
                this.f937b = false;
            }
        }

        public void a(c cVar, int i, int i2, String str, String str2) {
            boolean z;
            Iterator<a> it2 = this.f934a.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                if (next != null) {
                    next.a(this.f931a, cVar, i2);
                }
            }
            c cVar2 = this.f931a;
            int i3 = 0;
            if (cVar2 != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m54a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i), an.a(i2), str, str2, this.g));
                this.f931a = cVar;
            }
            if (this.f932a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
                return;
            }
            if (cVar == c.binding) {
                return;
            }
            if (this.b != null && (z = this.f937b)) {
                i3 = (this.f927a == null || !z) ? 10100 : 1000;
            }
            this.f929a.b(this.f930a);
            if (b(i, i2, str2)) {
                a(i, i2, str, str2);
            } else {
                this.f929a.a(this.f930a.a(i, i2, str, str2), i3);
            }
        }

        public void a(a aVar) {
            this.f934a.add(aVar);
        }

        /* renamed from: com.xiaomi.push.service.am$b$b, reason: collision with other inner class name */
        class C0132b extends XMPushService.j {

            /* renamed from: a, reason: collision with other field name */
            String f938a;
            int b;

            /* renamed from: b, reason: collision with other field name */
            String f939b;
            int c;

            static {
                Covode.recordClassIndex(655680);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo383a() {
                if (!b.this.a(this.b, this.c, this.f939b)) {
                    com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.g);
                    return;
                }
                b.this.a(this.b, this.c, this.f938a, this.f939b);
            }

            public C0132b() {
                super(0);
            }

            public XMPushService.j a(int i, int i2, String str, String str2) {
                this.b = i;
                this.c = i2;
                this.f939b = str2;
                this.f938a = str;
                return this;
            }
        }

        public b() {
        }

        class c implements IBinder.DeathRecipient {
            final Messenger a;

            /* renamed from: a, reason: collision with other field name */
            final b f940a;

            static {
                Covode.recordClassIndex(655681);
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f940a.g);
                int i = 0;
                b.this.f929a.a(new XMPushService.j(i) { // from class: com.xiaomi.push.service.am.b.c.1
                    @Override // com.xiaomi.push.service.XMPushService.j
                    public String a() {
                        return "clear peer job";
                    }

                    @Override // com.xiaomi.push.service.XMPushService.j
                    /* renamed from: a */
                    public void mo383a() {
                        c cVar = c.this;
                        if (cVar.a == cVar.f940a.f927a) {
                            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + c.this.f940a.g);
                            c.this.f940a.f927a = null;
                        }
                    }
                }, 0L);
                if ("9".equals(this.f940a.g) && "com.xiaomi.xmsf".equals(b.this.f929a.getPackageName())) {
                    b.this.f929a.a(new XMPushService.j(i) { // from class: com.xiaomi.push.service.am.b.c.2
                        @Override // com.xiaomi.push.service.XMPushService.j
                        public String a() {
                            return "check peer job";
                        }

                        @Override // com.xiaomi.push.service.XMPushService.j
                        /* renamed from: a */
                        public void mo383a() {
                            am a = am.a();
                            b bVar = c.this.f940a;
                            if (a.a(bVar.g, bVar.f936b).f927a != null) {
                                return;
                            }
                            XMPushService xMPushService = b.this.f929a;
                            b bVar2 = c.this.f940a;
                            xMPushService.a(bVar2.g, bVar2.f936b, 2, null, null);
                        }
                    }, 60000L);
                }
            }

            c(b bVar, Messenger messenger) {
                this.f940a = bVar;
                this.a = messenger;
            }
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.a + 1) * 15)) * 1000;
        }

        /* renamed from: a, reason: collision with other method in class */
        void m703a() {
            try {
                Messenger messenger = this.f927a;
                if (messenger != null && this.f926a != null) {
                    messenger.getBinder().unlinkToDeath(this.f926a, 0);
                }
            } catch (Exception unused) {
            }
            this.b = null;
        }

        public void b(a aVar) {
            this.f934a.remove(aVar);
        }

        public static String a(String str) {
            int lastIndexOf;
            if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) {
                return "";
            }
            return str.substring(lastIndexOf + 1);
        }

        public b(XMPushService xMPushService) {
            this.f929a = xMPushService;
            a(new a() { // from class: com.xiaomi.push.service.am.b.1
                @Override // com.xiaomi.push.service.am.b.a
                public void a(c cVar, c cVar2, int i) {
                    if (cVar2 == c.binding) {
                        b.this.f929a.a(b.this.f928a, 60000L);
                    } else {
                        b.this.f929a.b(b.this.f928a);
                    }
                }
            });
        }

        private boolean b(int i, int i2, String str) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return !"wait".equals(str);
                }
                return this.f929a.m672c();
            }
            if (this.f931a != c.binded && this.f929a.m672c() && i2 != 21 && (i2 != 7 || !"wait".equals(str))) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i, int i2, String str) {
            boolean z;
            c cVar = this.b;
            if (cVar == null || !(z = this.f937b)) {
                return true;
            }
            if (cVar == this.f931a) {
                com.xiaomi.channel.commonutils.logger.b.b(" status recovered, don't notify client:" + this.g);
                return false;
            }
            if (this.f927a != null && z) {
                com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + this.g);
                return true;
            }
            com.xiaomi.channel.commonutils.logger.b.b("peer died, ignore notify " + this.g);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, String str, String str2) {
            boolean z;
            c cVar = this.f931a;
            this.b = cVar;
            if (i == 2) {
                this.f932a.a(this.f925a, this, i2);
                return;
            }
            if (i == 3) {
                this.f932a.a(this.f925a, this, str2, str);
                return;
            }
            if (i == 1) {
                if (cVar == c.binded) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z && "wait".equals(str2)) {
                    this.a++;
                } else if (z) {
                    this.a = 0;
                    if (this.f927a != null) {
                        try {
                            this.f927a.send(Message.obtain(null, 16, this.f929a.f870a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f932a.a(this.f929a, this, z, i2, str);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.f923a.add(aVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized int m695a() {
        return this.f924a.size();
    }

    public synchronized void b() {
        this.f923a.clear();
    }

    private am() {
    }

    public static synchronized am a() {
        am amVar;
        synchronized (am.class) {
            if (a == null) {
                a = new am();
            }
            amVar = a;
        }
        return amVar;
    }

    public enum c {
        unbind,
        binding,
        binded;

        static {
            Covode.recordClassIndex(655682);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized ArrayList<b> m696a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        Iterator<HashMap<String, b>> it2 = this.f924a.values().iterator();
        while (it2.hasNext()) {
            arrayList.addAll(it2.next().values());
        }
        return arrayList;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m699a() {
        Iterator<b> it2 = m696a().iterator();
        while (it2.hasNext()) {
            it2.next().m703a();
        }
        this.f924a.clear();
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        if (indexOf > 0) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized Collection<b> m697a(String str) {
        if (!this.f924a.containsKey(str)) {
            return new ArrayList();
        }
        return ((HashMap) this.f924a.get(str).clone()).values();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized List<String> m698a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<HashMap<String, b>> it2 = this.f924a.values().iterator();
        while (it2.hasNext()) {
            for (b bVar : it2.next().values()) {
                if (str.equals(bVar.f933a)) {
                    arrayList.add(bVar.g);
                }
            }
        }
        return arrayList;
    }

    public synchronized b a(String str, String str2) {
        HashMap<String, b> hashMap = this.f924a.get(str);
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(a(str2));
    }
}
