package com.ss.videoarch.strategy.strategy.nodeOptimizer;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.android.ugc.bytex.taskmonitor.proxy.PThreadPoolExecutorDelegate;
import com.ss.videoarch.strategy.INodeListener;
import com.ss.videoarch.strategy.LiveStrategyManager;
import com.ss.videoarch.strategy.network.LSNetworkManager;
import com.ss.videoarch.strategy.network.VeLSNetworkManagerImpl;
import com.ss.videoarch.strategy.strategy.networkStrategy.NetworkProber;
import com.ss.videoarch.strategy.strategy.smartStrategy.TopNHostStrategy;
import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.smartStrategy.PitayaWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DnsOptimizer {
    private static volatile DnsOptimizer X;
    private static final Map<String, com.ss.videoarch.strategy.strategy.nodeOptimizer.a> Y;
    private static List<String> Z;
    public static HashMap<String, JSONObject> a0;
    private boolean C;
    public volatile n a;
    public volatile m b;
    private final ThreadPoolExecutor c;
    private final ThreadPoolExecutor d;
    private qj6.b f;
    private qj6.a g;
    public qj6.d h;
    public qj6.c i;
    private Handler k;
    private INodeListener l;
    public Set<String> r;
    public Set<String> s;
    public Set<String> t;
    private Map<String, Integer> u;
    private ReentrantLock e = new ReentrantLock();
    public Handler j = new HandlerDelegate(Looper.getMainLooper());
    private final List<com.ss.videoarch.strategy.strategy.nodeOptimizer.b> m = new LinkedList();
    private final List<String> n = new ArrayList();
    public boolean o = false;
    private boolean p = false;
    public boolean q = false;
    private int v = 0;
    private int w = 0;
    private int x = 0;
    private int y = 0;
    private boolean z = false;
    public int A = -1;
    private boolean B = false;
    public long D = 0;
    public int E = -1;
    public boolean F = false;
    public int G = -1;
    private final int H = 0;
    public boolean I = false;
    public int J = -1;
    private boolean K = false;
    public boolean L = false;
    public int M = -1;
    public int N = -1;
    public int O = -1;
    public boolean P = false;
    public boolean Q = false;
    private long R = 0;
    private long S = 0;
    public int T = com.ss.videoarch.strategy.network.d.e().c();
    private boolean U = true;
    private long V = 0;
    private String W = "none";

    public interface m {
        void a(String str, String str2);
    }

    public interface n {
        void a(String str);
    }

    private native String nativeGetNodeOptimizerInfoByHostList(List<String> list);

    private native String nativeGetNodeOptimizerInfos(String str);

    private native String nativeGetPreferedIP(String str);

    private native void nativeResolveLocalDns(Set<String> set);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeStartIPRace(String str);

    class a implements Runnable {
        final /* synthetic */ String a;

        @Override // java.lang.Runnable
        public void run() {
            DnsOptimizer.this.nativeStartIPRace(this.a);
        }

        a(String str) {
            this.a = str;
        }
    }

    class d implements Runnable {
        final /* synthetic */ String a;

        @Override // java.lang.Runnable
        public void run() {
            DnsOptimizer dnsOptimizer = DnsOptimizer.this;
            dnsOptimizer.U(dnsOptimizer.a, this.a);
        }

        d(String str) {
            this.a = str;
        }
    }

    class g implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            DnsOptimizer dnsOptimizer = DnsOptimizer.this;
            dnsOptimizer.U(dnsOptimizer.a, null);
        }

        g() {
        }
    }

    class h implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            DnsOptimizer dnsOptimizer = DnsOptimizer.this;
            dnsOptimizer.U(dnsOptimizer.a, null);
        }

        h() {
        }
    }

    static {
        Covode.recordClassIndex(653192);
        X = null;
        Y = new ConcurrentHashMap();
        Z = new ArrayList();
        a0 = new HashMap<>();
    }

    public static DnsOptimizer O() {
        if (X == null) {
            synchronized (DnsOptimizer.class) {
                if (X == null) {
                    X = new DnsOptimizer();
                }
            }
        }
        return X;
    }

    public void V() {
        if (!this.p) {
            return;
        }
        this.l = null;
        this.m.clear();
        Y.clear();
        this.p = false;
    }

    class c implements Runnable {
        final /* synthetic */ List a;

        class a implements Runnable {
            final /* synthetic */ com.ss.videoarch.strategy.strategy.nodeOptimizer.b a;
            final /* synthetic */ com.ss.videoarch.strategy.strategy.nodeOptimizer.a b;

            @Override // java.lang.Runnable
            public void run() {
                List<String> a = this.a.a();
                if (a != null && a.size() > 0) {
                    if (lj6.a.m().r.e.mEnableUseNewOptRecordStruct == 1) {
                        this.b.p(a, 3, DnsOptimizer.this.T);
                    }
                    this.b.r(a);
                }
            }

            a(com.ss.videoarch.strategy.strategy.nodeOptimizer.b bVar, com.ss.videoarch.strategy.strategy.nodeOptimizer.a aVar) {
                this.a = bVar;
                this.b = aVar;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            List list = this.a;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.a.size(); i++) {
                    String str = (String) this.a.get(i);
                    com.ss.videoarch.strategy.strategy.nodeOptimizer.a aVar = (com.ss.videoarch.strategy.strategy.nodeOptimizer.a) DnsOptimizer.Y.get(str);
                    if (aVar == null) {
                        aVar = new com.ss.videoarch.strategy.strategy.nodeOptimizer.a(str, 0);
                        DnsOptimizer.Y.put(str, aVar);
                    }
                    DnsOptimizer.this.c.submit(new a(new com.ss.videoarch.strategy.strategy.nodeOptimizer.b(aVar.a), aVar));
                }
            }
        }

        c(List list) {
            this.a = list;
        }
    }

    class e implements Runnable {
        final /* synthetic */ String a;

        @Override // java.lang.Runnable
        public void run() {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            DnsOptimizer.this.k = new HandlerDelegate(Looper.myLooper());
            DnsOptimizer.this.k.postDelayed(new a(), DnsOptimizer.this.V);
            Looper.loop();
        }

        class a implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject;
                Looper.myLooper().quit();
                if (DnsOptimizer.this.l != null && !DnsOptimizer.this.W.equals("none")) {
                    try {
                        jSONObject = new JSONObject().put("host", e.this.a);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        jSONObject = null;
                    }
                    DnsOptimizer.this.l.onMessage(DnsOptimizer.this.N(jSONObject, null));
                    DnsOptimizer.this.W = "none";
                    DnsOptimizer.this.U = true;
                }
            }

            a() {
            }
        }

        e(String str) {
            this.a = str;
        }
    }

    class f implements Runnable {
        final /* synthetic */ JSONObject a;

        @Override // java.lang.Runnable
        public void run() {
            Looper.myLooper().quit();
            if (DnsOptimizer.this.l != null) {
                DnsOptimizer.this.l.onMessage(this.a);
                DnsOptimizer.this.W = "none";
                DnsOptimizer.this.U = true;
            }
        }

        f(JSONObject jSONObject) {
            this.a = jSONObject;
        }
    }

    private static class k implements ThreadFactory {
        private final ThreadGroup a;
        private final AtomicInteger b;
        private final String c;

        static {
            Covode.recordClassIndex(653193);
        }

        private k() {
            ThreadGroup threadGroup;
            this.b = new AtomicInteger(1);
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.a = threadGroup;
            this.c = "dns-optimizer-listen-";
        }

        /* synthetic */ k(b bVar) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.a, runnable, this.c + this.b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 1) {
                thread.setPriority(1);
            }
            return thread;
        }
    }

    private static class l implements ThreadFactory {
        private final ThreadGroup a;
        private final AtomicInteger b;
        private final String c;

        static {
            Covode.recordClassIndex(653194);
        }

        private l() {
            ThreadGroup threadGroup;
            this.b = new AtomicInteger(1);
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.a = threadGroup;
            this.c = "dns-optimizer-";
        }

        /* synthetic */ l(b bVar) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.a, runnable, this.c + this.b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 1) {
                thread.setPriority(1);
            }
            return thread;
        }
    }

    public void P() {
        Set<String> set = this.r;
        if (set != null && set.size() != 0) {
            Iterator<String> it2 = this.r.iterator();
            while (it2.hasNext()) {
                com.ss.videoarch.strategy.strategy.nodeOptimizer.a aVar = Y.get(it2.next());
                if (aVar != null) {
                    aVar.s(null);
                    aVar.r(null);
                    aVar.q(null);
                }
            }
            return;
        }
        Y.clear();
    }

    public boolean S() {
        if (lj6.a.m().r.e.mEnableIPv6ProbeLoop == 1) {
            if (lj6.a.m().r.e.mEnableUseIpv6 != 1 || lj6.a.m().r.e.mEnableIPV6Probe != 1 || this.G != 0) {
                return false;
            }
            return true;
        }
        if (lj6.a.m().r.e.mEnableUseIpv6 != 1) {
            return false;
        }
        if (lj6.a.m().r.e.mEnableIPV6Probe != 0 && this.G != 0) {
            return false;
        }
        return true;
    }

    class b implements Runnable {
        final /* synthetic */ com.ss.videoarch.strategy.strategy.nodeOptimizer.b a;
        final /* synthetic */ com.ss.videoarch.strategy.strategy.nodeOptimizer.a b;

        @Override // java.lang.Runnable
        public void run() {
            List<String> a = this.a.a();
            if (a != null && a.size() > 0) {
                if (lj6.a.m().r.e.mEnableUseNewOptRecordStruct == 1) {
                    this.b.p(a, 3, DnsOptimizer.this.T);
                }
                this.b.r(a);
            }
            DnsOptimizer.v(DnsOptimizer.this);
            if (DnsOptimizer.this.v == DnsOptimizer.this.w) {
                DnsOptimizer.this.i.b = System.currentTimeMillis() - DnsOptimizer.this.S;
                DnsOptimizer dnsOptimizer = DnsOptimizer.this;
                qj6.c cVar = dnsOptimizer.i;
                cVar.a = 1;
                cVar.c = dnsOptimizer.t;
                cVar.uploadMonitorLog();
                Log.d("DnsOptimizer", "upload pre dns log:" + DnsOptimizer.this.i.b + "," + DnsOptimizer.this.i.c);
            }
        }

        b(com.ss.videoarch.strategy.strategy.nodeOptimizer.b bVar, com.ss.videoarch.strategy.strategy.nodeOptimizer.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }
    }

    class j implements Runnable {
        final /* synthetic */ Future a;
        final /* synthetic */ com.ss.videoarch.strategy.strategy.nodeOptimizer.a b;
        final /* synthetic */ n c;
        final /* synthetic */ String d;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.get(lj6.a.m().r.e.mLocalDnsTimeOut, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                this.a.cancel(true);
                DnsOptimizer dnsOptimizer = DnsOptimizer.this;
                dnsOptimizer.q = true;
                if (!dnsOptimizer.K) {
                    Log.w("DnsOptimizer", "post request when host " + this.b.a + "localdns timeout");
                    this.c.a(this.d);
                }
                DnsOptimizer.this.K = true;
                DnsOptimizer.this.g.h = "dns_time_out";
                DnsOptimizer.this.g.e = this.b.a;
                DnsOptimizer.this.g.f = DnsOptimizer.this.f.h;
                DnsOptimizer.this.g.g = lj6.a.m().h;
                DnsOptimizer.this.g.uploadMonitorLog();
                DnsOptimizer dnsOptimizer2 = DnsOptimizer.this;
                if (dnsOptimizer2.s != null && dnsOptimizer2.y == DnsOptimizer.this.s.size()) {
                    DnsOptimizer.this.f.a = System.currentTimeMillis() - DnsOptimizer.this.R;
                    DnsOptimizer.this.f.c = DnsOptimizer.this.x;
                    DnsOptimizer.this.f.b = DnsOptimizer.this.s.size();
                    DnsOptimizer.this.f.k = lj6.a.m().h;
                    DnsOptimizer.this.f.i = DnsOptimizer.this.K ? 1 : 0;
                    DnsOptimizer.this.f.uploadMonitorLog();
                }
                e.printStackTrace();
            }
        }

        j(Future future, com.ss.videoarch.strategy.strategy.nodeOptimizer.a aVar, n nVar, String str) {
            this.a = future;
            this.b = aVar;
            this.c = nVar;
            this.d = str;
        }
    }

    public DnsOptimizer() {
        this.C = true;
        ThreadPoolExecutor customThreadPool = LSNetworkManager.inst().customThreadPool();
        b bVar = null;
        if (customThreadPool == null) {
            PThreadPoolExecutorDelegate pThreadPoolExecutorDelegate = new PThreadPoolExecutorDelegate(1, 2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new l(bVar));
            this.c = pThreadPoolExecutorDelegate;
            if (lj6.a.m().A == 1) {
                pThreadPoolExecutorDelegate.allowCoreThreadTimeOut(true);
            }
        } else {
            this.c = customThreadPool;
        }
        PThreadPoolExecutorDelegate pThreadPoolExecutorDelegate2 = new PThreadPoolExecutorDelegate(2, 2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new k(bVar));
        this.d = pThreadPoolExecutorDelegate2;
        if (lj6.a.m().A == 1) {
            pThreadPoolExecutorDelegate2.allowCoreThreadTimeOut(true);
        }
        this.f = new qj6.b();
        this.h = new qj6.d();
        this.g = new qj6.a();
        this.i = new qj6.c();
        if (lj6.a.m().X == 1) {
            this.C = false;
        }
    }

    class i implements Runnable {
        final /* synthetic */ com.ss.videoarch.strategy.strategy.nodeOptimizer.b a;
        final /* synthetic */ String b;
        final /* synthetic */ com.ss.videoarch.strategy.strategy.nodeOptimizer.a c;
        final /* synthetic */ n d;

        /* JADX WARN: Code restructure failed: missing block: B:115:0x02b5, code lost:
        
            if (r0.x == r9.e.s.size()) goto L108;
         */
        /* JADX WARN: Code restructure failed: missing block: B:116:0x02bb, code lost:
        
            r9.e.q = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:0x02c9, code lost:
        
            if (lj6.a.m().r.e.mEnableHttpDns != 1) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:119:0x02d1, code lost:
        
            if (r9.e.K != false) goto L117;
         */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x02ee, code lost:
        
            if (r9.d == null) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x02f0, code lost:
        
            r0 = r9.e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:123:0x02f4, code lost:
        
            if (r0.s == null) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:0x0302, code lost:
        
            if (r0.y != r9.e.s.size()) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x0306, code lost:
        
            if (r9.b != null) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x0308, code lost:
        
            r9.e.f.a = java.lang.System.currentTimeMillis() - r9.e.R;
            r9.e.f.c = r9.e.x;
            r9.e.f.b = r9.e.s.size();
            r9.e.f.k = lj6.a.m().h;
            r9.e.f.i = r9.e.K ? 1 : 0;
            r9.e.f.uploadMonitorLog();
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:131:0x0361, code lost:
        
            if (r9.d == null) goto L159;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x0365, code lost:
        
            if (r9.b == null) goto L160;
         */
        /* JADX WARN: Code restructure failed: missing block: B:134:0x0367, code lost:
        
            r9.e.g.h = "force_refresh";
            r9.e.g.f = r9.e.f.h;
            r9.e.g.g = lj6.a.m().h;
            r9.e.g.e = r9.b;
            r9.e.g.uploadMonitorLog();
         */
        /* JADX WARN: Code restructure failed: missing block: B:135:0x03a2, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:137:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:139:0x02d9, code lost:
        
            if (lj6.a.m().D != 1) goto L116;
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x02e3, code lost:
        
            if (r9.e.f.h == 0) goto L117;
         */
        /* JADX WARN: Code restructure failed: missing block: B:142:0x02e5, code lost:
        
            r9.d.a(r9.b);
         */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x02b9, code lost:
        
            if (r9.b != null) goto L108;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 937
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.strategy.strategy.nodeOptimizer.DnsOptimizer.i.run():void");
        }

        i(com.ss.videoarch.strategy.strategy.nodeOptimizer.b bVar, String str, com.ss.videoarch.strategy.strategy.nodeOptimizer.a aVar, n nVar) {
            this.a = bVar;
            this.b = str;
            this.c = aVar;
            this.d = nVar;
        }
    }

    static /* synthetic */ int l(DnsOptimizer dnsOptimizer) {
        int i2 = dnsOptimizer.y;
        dnsOptimizer.y = i2 + 1;
        return i2;
    }

    static /* synthetic */ int p(DnsOptimizer dnsOptimizer) {
        int i2 = dnsOptimizer.x;
        dnsOptimizer.x = i2 + 1;
        return i2;
    }

    static /* synthetic */ int v(DnsOptimizer dnsOptimizer) {
        int i2 = dnsOptimizer.v;
        dnsOptimizer.v = i2 + 1;
        return i2;
    }

    private void I(List<String> list) {
        this.j.post(new c(list));
    }

    public JSONObject M(JSONArray jSONArray) {
        if (lj6.a.m().W == 1) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(jSONArray.optString(i2));
            }
            String nativeGetNodeOptimizerInfoByHostList = nativeGetNodeOptimizerInfoByHostList(arrayList);
            try {
                if (TextUtils.isEmpty(nativeGetNodeOptimizerInfoByHostList)) {
                    return null;
                }
                return new JSONObject(nativeGetNodeOptimizerInfoByHostList);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return c(jSONArray);
    }

    public void T(String str) {
        if (lj6.a.m().r.e.mEnableIpRace != 1) {
            Log.d("DnsOptimizer", "startIPRace: toggle off");
        } else if (TextUtils.isEmpty(str)) {
            Log.d("DnsOptimizer", "startIPRace: empty host");
        } else {
            this.c.execute(new a(str));
        }
    }

    public void W(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject != null && jSONObject.has("host") && jSONObject.has("ip")) {
            String optString = jSONObject.optString("host");
            String optString2 = jSONObject.optString("ip");
            com.ss.videoarch.strategy.strategy.nodeOptimizer.a aVar = Y.get(optString);
            if (aVar != null && optString2 != null) {
                aVar.t(optString2);
            }
        }
    }

    public JSONObject E(JSONObject jSONObject) {
        String jSONObject2;
        try {
            jSONObject.put("StartStrategySDKCost", com.ss.videoarch.strategy.log.strategyMonitor.a.a().a);
            jSONObject.put("LSSResponseCost", this.N);
            jSONObject.put("FirstResponseCost", this.M);
            jSONObject.put("LSSResponseStatusCode", this.O);
            if (!this.p && !lj6.a.m().u) {
                jSONObject.put("HasSendFirstRequest", this.L);
                jSONObject.put("IsRemoteSorted", lj6.a.m().u);
            }
            jSONObject.put("RequestId", lj6.a.m().h);
            if (lj6.a.m().c == null) {
                jSONObject2 = "";
            } else {
                jSONObject2 = lj6.a.m().c.toString();
            }
            jSONObject.put("ClientInfo", jSONObject2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void J(JSONObject jSONObject) {
        if (lj6.a.m().W == 1) {
            if (jSONObject != null && jSONObject.has("host_name")) {
                Log.d("DnsOptimizer", "start native doPreDnsOperate");
                JSONArray optJSONArray = jSONObject.optJSONArray("host_name");
                HashSet hashSet = new HashSet();
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        hashSet.add(optJSONArray.optString(i2));
                    }
                }
                if (!hashSet.isEmpty()) {
                    nativeResolveLocalDns(hashSet);
                    Iterator<String> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        T(it2.next());
                    }
                    return;
                }
                return;
            }
            return;
        }
        b(jSONObject);
    }

    public JSONObject c(JSONArray jSONArray) {
        String str;
        String str2 = null;
        if (jSONArray == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String optString = jSONArray.optString(i2);
            com.ss.videoarch.strategy.strategy.nodeOptimizer.a aVar = Y.get(optString);
            if (aVar != null) {
                if (lj6.a.m().r.e.mEnableUseNewOptRecordStruct == 1) {
                    str2 = aVar.o(S(), this.T, -1);
                } else {
                    str2 = aVar.l(S(), -1);
                }
                if (str2 == null) {
                    arrayList.add(optString);
                }
            } else {
                arrayList.add(optString);
            }
            if (str2 == null) {
                str = "none";
            } else {
                str = str2;
            }
            try {
                jSONObject.put(optString, str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            T(optString);
        }
        if (arrayList.size() > 0) {
            I(arrayList);
        }
        this.h.j = arrayList;
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ad, code lost:
    
        if (android.text.TextUtils.equals(r1, r3) != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String F(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.lang.String r2 = "\""
            if (r7 != 0) goto L73
            java.lang.String r7 = "\"HTTPDNSRequest\":{\"Enabled\":true,\"DomainNames\":["
            r0.append(r7)
            java.util.concurrent.locks.ReentrantLock r7 = r6.e
            r7.lock()
            java.util.ArrayList r7 = new java.util.ArrayList
            java.util.List<java.lang.String> r3 = com.ss.videoarch.strategy.strategy.nodeOptimizer.DnsOptimizer.Z
            r7.<init>(r3)
            java.util.concurrent.locks.ReentrantLock r3 = r6.e
            r3.unlock()
            java.util.Iterator r7 = r7.iterator()
        L24:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L55
            java.lang.Object r3 = r7.next()
            java.lang.String r3 = (java.lang.String) r3
            if (r1 == 0) goto L37
            java.lang.String r4 = ","
            r0.append(r4)
        L37:
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L52
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r3)
            r4.append(r2)
            java.lang.String r3 = r4.toString()
            r0.append(r3)
        L52:
            int r1 = r1 + 1
            goto L24
        L55:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "],\"IsNeedIPV6\":"
            r7.append(r1)
            boolean r1 = r6.S()
            r7.append(r1)
            java.lang.String r1 = "}"
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            r0.append(r7)
            goto Le6
        L73:
            java.util.Map<java.lang.String, com.ss.videoarch.strategy.strategy.nodeOptimizer.a> r3 = com.ss.videoarch.strategy.strategy.nodeOptimizer.DnsOptimizer.Y
            java.lang.Object r4 = r3.get(r7)
            if (r4 == 0) goto Le6
            java.lang.Object r3 = r3.get(r7)
            com.ss.videoarch.strategy.strategy.nodeOptimizer.a r3 = (com.ss.videoarch.strategy.strategy.nodeOptimizer.a) r3
            int r3 = r3.b
            r4 = 1
            if (r3 != r4) goto Le6
            lj6.a r3 = lj6.a.m()
            mj6.a r3 = r3.r
            com.ss.videoarch.strategy.dataCenter.config.model.settingsmodel.LSStrategySDKSettings r3 = r3.e
            int r3 = r3.mEnableDomainType
            r5 = 2
            if (r3 == r5) goto Laf
            r3 = 4
            java.lang.String r1 = r7.substring(r1, r3)
            lj6.a r3 = lj6.a.m()
            mj6.a r3 = r3.r
            com.ss.videoarch.strategy.dataCenter.config.model.settingsmodel.LSStrategySDKSettings r3 = r3.e
            int r3 = r3.mEnableDomainType
            if (r3 != r4) goto La7
            java.lang.String r3 = "pull"
            goto La9
        La7:
            java.lang.String r3 = "push"
        La9:
            boolean r1 = android.text.TextUtils.equals(r1, r3)
            if (r1 == 0) goto Le6
        Laf:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "\"HTTPDNSRequest\":{\"Enabled\":true,\"IsNeedIPV6\":"
            r1.append(r3)
            boolean r3 = r6.S()
            r1.append(r3)
            java.lang.String r3 = ",\"DomainNames\":["
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r7)
            r1.append(r2)
            java.lang.String r7 = r1.toString()
            r0.append(r7)
            java.lang.String r7 = "]}"
            r0.append(r7)
        Le6:
            java.lang.String r7 = r0.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.strategy.strategy.nodeOptimizer.DnsOptimizer.F(java.lang.String):java.lang.String");
    }

    private void a(List<String> list) {
        int i2;
        String j2 = lj6.a.m().j("push_day_7d", "AnchorFeatureParam");
        if (j2 == null) {
            return;
        }
        int i3 = lj6.a.m().r.e.mPreferParsingPushNodeByPushDaysIn7Days;
        int i4 = lj6.a.m().r.e.mPreferParsingPullNodeByPushDaysIn7Days;
        try {
            i2 = Integer.parseInt(j2);
        } catch (NumberFormatException e2) {
            System.out.println("Failed to parse integer: " + e2.getMessage());
            i2 = -1;
        }
        if (lj6.a.m().r.e.mEnablePreferParsingPushNode == 1 && i2 >= i3) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (String str : list) {
                if (str.startsWith("push")) {
                    arrayList2.add(str);
                } else {
                    arrayList.add(str);
                }
            }
            arrayList2.addAll(arrayList);
            list = arrayList2;
        }
        if (lj6.a.m().r.e.mEnablePreferParsingPullNode == 1 && i2 < i4) {
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (String str2 : list) {
                if (str2.startsWith("push")) {
                    arrayList4.add(str2);
                } else {
                    arrayList3.add(str2);
                }
            }
            arrayList3.addAll(arrayList4);
        }
    }

    public JSONObject R(String str) {
        JSONObject sendDnsRequestByHosts;
        JSONObject optJSONObject;
        Log.d("DnsOptimizer", "sendDnsRequestByHost: " + str);
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            sendDnsRequestByHosts = VeLSNetworkManagerImpl.getInstance().sendDnsRequestByHosts(Collections.singletonList(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (sendDnsRequestByHosts == null) {
            return jSONObject;
        }
        if (sendDnsRequestByHosts.has("ResponseMetadata") && (optJSONObject = sendDnsRequestByHosts.optJSONObject("ResponseMetadata")) != null && optJSONObject.has("RequestId")) {
            String optString = optJSONObject.optString("RequestId");
            Log.d("DnsOptimizer", "sendDnsRequestByHost: requestId: " + optString);
            jSONObject.put("RequestId", optString);
        }
        if (!sendDnsRequestByHosts.has("Result")) {
            return jSONObject;
        }
        JSONObject optJSONObject2 = sendDnsRequestByHosts.optJSONObject("Result");
        if (optJSONObject2 != null && optJSONObject2.has("NodeInfos")) {
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("NodeInfos");
            if (optJSONObject3 != null && optJSONObject3.has(str)) {
                JSONArray jSONArray = optJSONObject3.getJSONArray(str);
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (jSONObject2 != null && jSONObject2.has("IP")) {
                        jSONArray2.put(jSONObject2.optString("IP"));
                    }
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("http_dns", jSONArray2);
                jSONObject.put("EvaluatorSymbol", jSONObject3);
            }
            jSONObject.put("LSSResponseCost", (int) (System.currentTimeMillis() - currentTimeMillis));
            return jSONObject;
        }
        return jSONObject;
    }

    public void b(JSONObject jSONObject) {
        JSONArray optJSONArray;
        Log.d("DnsOptimizer", "start doPreDnsOperate");
        this.v = 0;
        this.S = System.currentTimeMillis();
        if (jSONObject != null && jSONObject.has("host_name") && (optJSONArray = jSONObject.optJSONArray("host_name")) != null && optJSONArray.length() > 0) {
            this.w = optJSONArray.length();
            this.t = new HashSet();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                String optString = optJSONArray.optString(i2);
                this.t.add(optString);
                Map<String, com.ss.videoarch.strategy.strategy.nodeOptimizer.a> map = Y;
                com.ss.videoarch.strategy.strategy.nodeOptimizer.a aVar = map.get(optString);
                if (aVar == null) {
                    aVar = new com.ss.videoarch.strategy.strategy.nodeOptimizer.a(optString, 0);
                }
                map.put(optString, aVar);
                this.c.submit(new b(new com.ss.videoarch.strategy.strategy.nodeOptimizer.b(aVar.a), aVar));
            }
            Iterator<String> it2 = this.t.iterator();
            while (it2.hasNext()) {
                T(it2.next());
            }
        }
    }

    private String H(String str) {
        com.ss.videoarch.strategy.strategy.nodeOptimizer.a aVar;
        List<String> list;
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            Set<String> set = this.s;
            if (set != null && set.size() != 0) {
                sb.append("\"SelectNodeRequest\":{\"Enabled\":true,\"IsNeedIPV6\":" + S() + ",\"IPs\":{");
                int i2 = 0;
                for (String str2 : this.s) {
                    Map<String, com.ss.videoarch.strategy.strategy.nodeOptimizer.a> map = Y;
                    if (map != null && map.containsKey(str2) && (aVar = map.get(str2)) != null && (list = aVar.d) != null && list.size() != 0) {
                        if (i2 != 0) {
                            sb.append(",");
                        }
                        sb.append("\"" + aVar.a + "\":[");
                        for (int i3 = 0; i3 < list.size(); i3++) {
                            if (i3 != 0) {
                                sb.append(",");
                            }
                            sb.append("\"" + list.get(i3) + "\"");
                        }
                        sb.append("]");
                        i2++;
                    }
                }
                sb.append("}}");
            }
        } else {
            Map<String, com.ss.videoarch.strategy.strategy.nodeOptimizer.a> map2 = Y;
            if (map2 != null && map2.size() != 0) {
                sb.append("\"SelectNodeRequest\":{\"Enabled\":true,\"IsNeedIPV6\":" + S() + ",\"IPs\":{");
                sb.append("\"" + str + "\":[");
                com.ss.videoarch.strategy.strategy.nodeOptimizer.a aVar2 = map2.get(str);
                List arrayList = new ArrayList();
                if (aVar2 != null) {
                    arrayList = aVar2.d;
                }
                if (arrayList != null && arrayList.size() != 0) {
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        if (i4 != 0) {
                            sb.append(",");
                        }
                        sb.append("\"" + ((String) arrayList.get(i4)) + "\"");
                    }
                }
                sb.append("]}}");
            }
        }
        return sb.toString();
    }

    public void X(String str) {
        boolean z;
        long j2;
        boolean z2;
        long j3;
        boolean z3;
        long j4;
        String l2;
        boolean z4 = false;
        if (lj6.a.m().r.e.mPerfOptNotExeFunc == 1) {
            z = true;
        } else {
            z = false;
        }
        this.p = true;
        String valueOf = String.valueOf(this.T);
        if (this.r == null || !this.B) {
            this.r = lj6.a.m().d();
            this.u = lj6.a.m().k;
            if (!z && lj6.a.m().s.b == 1 && lj6.a.m().s.c == 1) {
                Set<String> set = this.r;
                if (set != null && set.size() != 0) {
                    nj6.d.h(this.r);
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    Set<String> g2 = nj6.d.g();
                    this.r = g2;
                    nj6.e eVar = nj6.d.g;
                    String str2 = nj6.d.a;
                    String str3 = com.ss.videoarch.strategy.log.strategyMonitor.b.MONITOR_QUERY_OPERATE;
                    if (g2.size() != 0) {
                        j2 = 1;
                    } else {
                        j2 = 0;
                    }
                    eVar.a(str2, str3, "DnsOptimizer", j2, currentTimeMillis, "Query domain");
                    nj6.d.g.uploadMonitorLog();
                }
            }
            this.s = this.r;
        }
        Set<String> set2 = this.r;
        if (set2 != null && set2.size() != 0) {
            Set hashSet = new HashSet();
            if (str == null) {
                hashSet = this.r;
            } else {
                hashSet.add(str);
            }
            if (lj6.a.m().X == 1) {
                hashSet.addAll(lj6.a.m().g());
            }
            ArrayList arrayList = new ArrayList(hashSet);
            if (lj6.a.m().r.e.mEnablePreferParsingPushNode == 1) {
                a(arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            for (String str4 : arrayList) {
                com.ss.videoarch.strategy.strategy.nodeOptimizer.a aVar = Y.get(str4);
                if (aVar == null) {
                    aVar = this.u.get(str4) != null ? new com.ss.videoarch.strategy.strategy.nodeOptimizer.a(str4, this.u.get(str4).intValue()) : new com.ss.videoarch.strategy.strategy.nodeOptimizer.a(str4, z4 ? 1 : 0);
                } else if (this.u.get(str4) != null) {
                    aVar.b = this.u.get(str4).intValue();
                }
                com.ss.videoarch.strategy.strategy.nodeOptimizer.a aVar2 = aVar;
                JSONArray f2 = lj6.a.m().f(str4);
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                if (lj6.a.m().r.e.mCheckIPValid == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (f2 != null) {
                    int i2 = 0;
                    while (i2 < f2.length()) {
                        JSONObject optJSONObject = f2.optJSONObject(i2);
                        if (optJSONObject.has("IP")) {
                            String optString = optJSONObject.optString("IP");
                            if ((!z3 || com.ss.videoarch.strategy.strategy.nodeOptimizer.a.j(optString, z4) || com.ss.videoarch.strategy.strategy.nodeOptimizer.a.k(optString, z4)) && optJSONObject.has("DomainParseType")) {
                                if (optJSONObject.optInt("DomainParseType") == 0) {
                                    arrayList4.add(optString);
                                } else {
                                    arrayList3.add(optString);
                                }
                            }
                        }
                        i2++;
                        z4 = false;
                    }
                }
                if (arrayList3.size() > 0) {
                    if (lj6.a.m().r.e.mEnableUseNewOptRecordStruct == 1) {
                        aVar2.p(arrayList3, 1, this.T);
                    }
                    aVar2.q(arrayList3);
                }
                if (arrayList4.size() > 0) {
                    if (lj6.a.m().r.e.mEnableUseNewOptRecordStruct == 1) {
                        aVar2.p(arrayList4, 2, this.T);
                    }
                    aVar2.s(arrayList4);
                }
                aVar2.m = lj6.a.m().j;
                if (!this.U && !this.W.equals("none") && TextUtils.equals(aVar2.a, this.W) && !aVar2.b().isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject = new JSONObject().put("host", str4);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    JSONObject N = N(jSONObject, null);
                    Handler handler = this.k;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        this.k.post(new f(N));
                    }
                }
                Y.put(str4, aVar2);
                if (lj6.a.m().w == 1) {
                    if (lj6.a.m().r.e.mEnableUseNewOptRecordStruct == 1) {
                        l2 = aVar2.o(S(), Integer.valueOf(valueOf).intValue(), -1);
                    } else {
                        l2 = aVar2.l(S(), -1);
                    }
                    if (!TextUtils.isEmpty(l2) && this.b != null) {
                        this.b.a(str4, l2);
                    }
                }
                if (!z && lj6.a.m().s.b == 1 && lj6.a.m().s.c == 1) {
                    if (!this.o) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        a0 = nj6.d.f(null, null, null, null, null);
                        this.o = true;
                        nj6.e eVar2 = nj6.d.g;
                        String str5 = nj6.d.a;
                        String str6 = com.ss.videoarch.strategy.log.strategyMonitor.b.MONITOR_QUERY_OPERATE;
                        if (a0.size() > 0) {
                            j4 = 1;
                        } else {
                            j4 = 0;
                        }
                        eVar2.a(str5, str6, "DnsOptimizer", j4, currentTimeMillis2, "Query all data");
                        nj6.d.g.uploadMonitorLog();
                    }
                    String obj = aVar2.b().toString();
                    String c2 = nj6.a.c();
                    JSONObject jSONObject2 = new JSONObject();
                    com.ss.videoarch.strategy.dataCenter.strategyData.model.b bVar = new com.ss.videoarch.strategy.dataCenter.strategyData.model.b();
                    if (obj.length() > 2) {
                        bVar.c = obj.substring(1, obj.length() - 1);
                        bVar.a = str4;
                        bVar.b = valueOf;
                        bVar.e = c2;
                        if (a0.containsKey(str4)) {
                            jSONObject2 = a0.get(str4);
                        }
                        try {
                            jSONObject2.put(bVar.b, bVar);
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        a0.put(str4, jSONObject2);
                        arrayList2.add(bVar);
                    }
                }
                z4 = false;
            }
            if (!z) {
                NetworkProber.e().d();
                if (lj6.a.m().s.b == 1 && lj6.a.m().s.c == 1 && arrayList2.size() != 0 && lj6.a.m().s.e != 0 && LiveStrategyManager.inst().mReceiveMessage % lj6.a.m().s.e == 0) {
                    Log.d("DnsOptimizer", "update db");
                    nj6.d.g.a(nj6.d.a, com.ss.videoarch.strategy.log.strategyMonitor.b.MONITOR_UPDATE_OPERATE, "DnsOptimizer", nj6.d.i(arrayList2), System.currentTimeMillis(), "Update ip result");
                    nj6.d.g.uploadMonitorLog();
                }
            }
            if (!this.B) {
                if (this.C) {
                    this.B = true;
                }
                this.C = true;
                if (!z) {
                    if (com.ss.videoarch.strategy.strategy.smartStrategy.e.a().a && lj6.a.m().r.e.mEnableUsePTY == 1 && PitayaWrapper.f().d()) {
                        com.ss.videoarch.strategy.strategy.smartStrategy.e.a().a = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    JSONObject runStrategy = com.ss.videoarch.strategy.strategy.smartStrategy.e.a().runStrategy();
                    com.ss.videoarch.strategy.strategy.smartStrategy.e.a().uploadPredictValue(runStrategy);
                    if (z2) {
                        com.ss.videoarch.strategy.strategy.smartStrategy.e.a().b(-1L);
                    }
                    if (runStrategy != null && runStrategy.optInt("result", -1) != -1) {
                        j3 = lj6.a.m().r.e.mDelayTimeForFirstDns;
                    } else {
                        j3 = 0;
                    }
                    this.j.postDelayed(new g(), j3);
                    return;
                }
                this.j.postDelayed(new h(), lj6.a.m().r.e.mFirstDnsDelay * 1000);
                return;
            }
            return;
        }
        Y.clear();
    }

    public int K(int i2, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                return i3;
            }
            return this.J;
        }
        return this.G;
    }

    public void U(n nVar, String str) {
        Set<String> set;
        if (lj6.a.m().W == 1) {
            if (nVar != null && (set = this.r) != null) {
                nativeResolveLocalDns(set);
                nVar.a(str);
                this.q = true;
                return;
            }
            return;
        }
        e(nVar, str);
    }

    public JSONObject N(JSONObject jSONObject, INodeListener iNodeListener) {
        if (jSONObject == null) {
            return null;
        }
        if (lj6.a.m().W == 1) {
            Log.d("DnsOptimizer", "mEnableNativeDns getNodeOptimizerInfo");
            try {
                JSONObject jSONObject2 = new JSONObject();
                String nativeGetNodeOptimizerInfos = nativeGetNodeOptimizerInfos(jSONObject.toString());
                if (!TextUtils.isEmpty(nativeGetNodeOptimizerInfos)) {
                    jSONObject2 = new JSONObject(nativeGetNodeOptimizerInfos);
                }
                return E(jSONObject2);
            } catch (Exception unused) {
                return null;
            }
        }
        return d(jSONObject, iNodeListener);
    }

    public List<String> L(int i2, String str) {
        int i3;
        List<String> arrayList = new ArrayList<>();
        int i4 = 0;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    i3 = 0;
                } else {
                    i3 = 10;
                }
            } else {
                i3 = lj6.a.m().r.e.mRequiredIpv6IpCount;
            }
        } else {
            i3 = lj6.a.m().r.e.mRequiredIpv4IpCount;
        }
        if (this.p && lj6.a.m().u && i3 > 0) {
            com.ss.videoarch.strategy.strategy.nodeOptimizer.a aVar = Y.get(str);
            if (aVar != null) {
                if (i2 == 2) {
                    arrayList = aVar.a();
                } else {
                    if (lj6.a.m().r.e.mEnableSupportIpOnlyMode != 1 || ((i2 != 0 || aVar.o != 1) && (i2 != 1 || aVar.o != 0))) {
                        i4 = i3;
                    }
                    if (lj6.a.m().r.e.mEnableUseNewOptRecordStruct == 1) {
                        arrayList = aVar.g(i2, i4, this.T);
                    } else {
                        arrayList = aVar.f(i2, i4);
                    }
                }
            }
            Log.d("DnsOptimizer", "getNodeListWithHostByKey:" + arrayList);
        }
        return arrayList;
    }

    public void e(n nVar, String str) {
        Set<String> set;
        String str2;
        Log.i("DnsOptimizer", "_startLocalDns");
        if (nVar == null) {
            return;
        }
        if (str == null) {
            Map<String, com.ss.videoarch.strategy.strategy.nodeOptimizer.a> map = Y;
            if (map != null && map.size() != 0 && (set = this.r) != null && set.size() != 0 && this.s != null) {
                this.y = 0;
                this.x = 0;
                this.R = System.currentTimeMillis();
                qj6.b bVar = this.f;
                bVar.h++;
                bVar.e = lj6.a.m().r.e.mSendHttpDnsByLocalDnsTimeout;
                this.f.d = lj6.a.m().r.e.mEnableRefresh;
                this.f.f = lj6.a.m().r.e.mEnableHttpDns;
                this.f.g = lj6.a.m().r.e.mEnableDomainType;
                this.f.j = TopNHostStrategy.f().f;
                this.f.m = this.s;
                this.g.b = lj6.a.m().r.e.mSendHttpDnsByLocalDnsTimeout;
                this.g.a = lj6.a.m().r.e.mEnableRefresh;
                this.g.c = lj6.a.m().r.e.mEnableHttpDns;
                this.g.d = lj6.a.m().r.e.mEnableDomainType;
                this.e.lock();
                Z.clear();
                this.e.unlock();
                Set<String> set2 = this.r;
                if (set2 != null) {
                    for (String str3 : set2) {
                        com.ss.videoarch.strategy.strategy.nodeOptimizer.a aVar = Y.get(str3);
                        if (lj6.a.m().r.e.mEnableHttpDns == 1 && aVar != null && aVar.b == 1) {
                            if (lj6.a.m().r.e.mEnableDomainType != 2) {
                                if (str3.length() >= 4) {
                                    String substring = str3.substring(0, 4);
                                    if (lj6.a.m().r.e.mEnableDomainType == 1) {
                                        str2 = "pull";
                                    } else {
                                        str2 = "push";
                                    }
                                    if (TextUtils.equals(substring, str2)) {
                                    }
                                }
                            }
                            this.e.lock();
                            Z.add(aVar.a);
                            this.e.unlock();
                        }
                    }
                }
                this.K = false;
                if (this.s != null) {
                    ArrayList arrayList = new ArrayList(this.s);
                    if (lj6.a.m().r.e.mEnablePreferParsingPushNode == 1) {
                        a(arrayList);
                    }
                    Iterator<String> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        com.ss.videoarch.strategy.strategy.nodeOptimizer.a aVar2 = Y.get(it2.next());
                        if (aVar2 != null) {
                            Q(aVar2, nVar, str);
                        }
                    }
                }
                this.P = false;
                return;
            }
            nVar.a(str);
            return;
        }
        Q(Y.get(str), nVar, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.json.JSONObject d(org.json.JSONObject r28, com.ss.videoarch.strategy.INodeListener r29) {
        /*
            Method dump skipped, instructions count: 797
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.strategy.strategy.nodeOptimizer.DnsOptimizer.d(org.json.JSONObject, com.ss.videoarch.strategy.INodeListener):org.json.JSONObject");
    }

    private void Q(com.ss.videoarch.strategy.strategy.nodeOptimizer.a aVar, n nVar, String str) {
        if (!this.p) {
            return;
        }
        com.ss.videoarch.strategy.strategy.nodeOptimizer.b bVar = new com.ss.videoarch.strategy.strategy.nodeOptimizer.b(aVar.a);
        synchronized (this.m) {
            this.m.add(bVar);
        }
        Future<?> submit = this.c.submit(new i(bVar, str, aVar, nVar));
        if (lj6.a.m().r.e.mEnableHttpDns == 1 && lj6.a.m().r.e.mEnableListenerThread == 1) {
            this.d.submit(new j(submit, aVar, nVar, str));
        }
    }

    public String G(boolean z, boolean z2, String str) {
        String str2;
        String str3;
        String str4;
        if (TextUtils.equals(str, null)) {
            if (lj6.a.m().r.e.mEnableHttpDns != 1 || !z || (lj6.a.m().r.e.mSendHttpDnsByLocalDnsTimeout == 1 && (lj6.a.m().r.e.mSendHttpDnsByLocalDnsTimeout != 1 || !this.K))) {
                str4 = "";
            } else {
                str4 = F(null);
            }
            if (!lj6.a.m().u || !z2) {
                str3 = "";
            } else {
                str3 = H(null);
            }
            if (!str3.equals("")) {
                if (!str4.equals("")) {
                    return str3 + "," + str4;
                }
            } else {
                return str4;
            }
        } else {
            if (lj6.a.m().r.e.mEnableHttpDns != 1) {
                str2 = "";
            } else {
                str2 = F(str);
            }
            if (!lj6.a.m().u) {
                str3 = "";
            } else {
                str3 = H(str);
            }
            if (!str3.equals("")) {
                if (!str2.equals("")) {
                    return str3 + "," + str2;
                }
            } else {
                return str2;
            }
        }
        return str3;
    }
}
