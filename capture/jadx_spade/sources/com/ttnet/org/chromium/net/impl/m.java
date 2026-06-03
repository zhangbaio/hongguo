package com.ttnet.org.chromium.net.impl;

import android.net.TrafficStats;
import android.os.Build;
import android.util.Log;
import com.bytedance.apm.agent.instrumentation.HttpInstrumentation;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.InlineExecutionProhibitedException;
import com.ttnet.org.chromium.net.d0;
import com.ttnet.org.chromium.net.e0;
import com.ttnet.org.chromium.net.g0;
import com.ttnet.org.chromium.net.h0;
import com.ttnet.org.chromium.net.impl.CronetLogger;
import com.ttnet.org.chromium.net.impl.VersionSafeCallbacks;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.time.Duration;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class m extends UrlRequestBase {
    private static final String u;
    private final n a;
    private final Executor b;
    private final String c;
    private final boolean h;
    private String i;
    private VersionSafeCallbacks.f j;
    private Executor k;
    private String m;
    private ReadableByteChannel n;
    private z o;
    private String p;
    private HttpURLConnection q;
    private o r;
    private final int s;
    private final CronetLogger t;
    private final Map<String, String> d = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private final List<String> e = new ArrayList();
    private final AtomicInteger f = new AtomicInteger(0);
    private final AtomicBoolean g = new AtomicBoolean(false);
    private volatile int l = -1;

    @Override // com.ttnet.org.chromium.net.g0
    public void a(String str, String str2) {
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void b() {
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void h(long j2) {
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void i(String str, String str2) {
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void j(int i2) {
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void l(int i2) {
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void m(long j2) {
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void n(long j2) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void s(int i2) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void t(int i2) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void u(int i2) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void v(int i2) {
    }

    private final class n {
        final VersionSafeCallbacks.g a;
        final Executor b;
        final Executor c;

        class a implements com.ttnet.org.chromium.net.impl.o {
            final /* synthetic */ h0 a;
            final /* synthetic */ String b;

            @Override // com.ttnet.org.chromium.net.impl.o
            public void run() throws Exception {
                n nVar = n.this;
                nVar.a.d(m.this, this.a, this.b, "");
            }

            a(h0 h0Var, String str) {
                this.a = h0Var;
                this.b = str;
            }
        }

        static {
            Covode.recordClassIndex(654632);
        }

        class b implements com.ttnet.org.chromium.net.impl.o {
            @Override // com.ttnet.org.chromium.net.impl.o
            public void run() throws Exception {
                if (m.this.f.compareAndSet(1, 4)) {
                    n nVar = n.this;
                    VersionSafeCallbacks.g gVar = nVar.a;
                    m mVar = m.this;
                    gVar.e(mVar, mVar.o, "");
                }
            }

            b() {
            }
        }

        class c implements com.ttnet.org.chromium.net.impl.o {
            final /* synthetic */ h0 a;
            final /* synthetic */ ByteBuffer b;

            @Override // com.ttnet.org.chromium.net.impl.o
            public void run() throws Exception {
                if (m.this.f.compareAndSet(5, 4)) {
                    n nVar = n.this;
                    nVar.a.c(m.this, this.a, this.b);
                }
            }

            c(h0 h0Var, ByteBuffer byteBuffer) {
                this.a = h0Var;
                this.b = byteBuffer;
            }
        }

        class d implements Runnable {
            final /* synthetic */ h0 a;

            @Override // java.lang.Runnable
            public void run() {
                try {
                    n nVar = n.this;
                    nVar.a.a(m.this, this.a);
                    n.this.d();
                } catch (Exception e) {
                    Log.e(m.u, "Exception in onCanceled method", e);
                }
            }

            d(h0 h0Var) {
                this.a = h0Var;
            }
        }

        class e implements Runnable {
            final /* synthetic */ h0 a;

            @Override // java.lang.Runnable
            public void run() {
                try {
                    n nVar = n.this;
                    nVar.a.f(m.this, this.a);
                    n.this.d();
                } catch (Exception e) {
                    Log.e(m.u, "Exception in onSucceeded method", e);
                }
            }

            e(h0 h0Var) {
                this.a = h0Var;
            }
        }

        class f implements Runnable {
            final /* synthetic */ h0 a;
            final /* synthetic */ CronetException b;

            @Override // java.lang.Runnable
            public void run() {
                try {
                    n nVar = n.this;
                    nVar.a.b(m.this, this.a, this.b);
                    n.this.d();
                } catch (Exception e) {
                    Log.e(m.u, "Exception in onFailed method", e);
                }
            }

            f(h0 h0Var, CronetException cronetException) {
                this.a = h0Var;
                this.b = cronetException;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    m.this.t.b(m.this.s, b());
                } catch (RuntimeException e2) {
                    Log.e(m.u, "Error while trying to log CronetTrafficInfo: ", e2);
                }
            }
        }

        private CronetLogger.b b() {
            Map<String, List<String>> emptyMap;
            String str;
            boolean z;
            int i;
            long u0;
            long j;
            long v0;
            long j2;
            if (m.this.o != null) {
                emptyMap = m.this.o.a();
                String g = m.this.o.g();
                int c2 = m.this.o.c();
                z = m.this.o.k();
                str = g;
                i = c2;
            } else {
                emptyMap = Collections.emptyMap();
                str = "";
                z = false;
                i = 0;
            }
            if (z) {
                u0 = 0;
                j = 0;
            } else {
                u0 = m.u0(m.this.d);
                j = -1;
            }
            if (z) {
                j2 = 0;
                v0 = 0;
            } else {
                v0 = m.v0(emptyMap);
                if (!emptyMap.containsKey("Content-Length")) {
                    j2 = -1;
                } else {
                    j2 = m.C0(emptyMap.get("Content-Length").get(0));
                }
            }
            return new CronetLogger.b(u0, j, v0, j2, i, Duration.ofSeconds(0L), Duration.ofSeconds(0L), str, false, false);
        }

        void e(h0 h0Var) {
            m.this.o0();
            this.b.execute(new d(h0Var));
        }

        void i(h0 h0Var) {
            c(new b());
        }

        void j(h0 h0Var) {
            this.b.execute(new e(h0Var));
        }

        void c(com.ttnet.org.chromium.net.impl.o oVar) {
            try {
                this.b.execute(m.this.H0(oVar));
            } catch (RejectedExecutionException e2) {
                m.this.q0(new CronetExceptionImpl("Exception posting task to executor", e2));
            }
        }

        void g(h0 h0Var, ByteBuffer byteBuffer) {
            c(new c(h0Var, byteBuffer));
        }

        void h(h0 h0Var, String str) {
            c(new a(h0Var, str));
        }

        void f(h0 h0Var, CronetException cronetException) {
            m.this.o0();
            f fVar = new f(h0Var, cronetException);
            try {
                this.b.execute(fVar);
            } catch (InlineExecutionProhibitedException unused) {
                Executor executor = this.c;
                if (executor != null) {
                    executor.execute(fVar);
                }
            }
        }

        n(g0.b bVar, Executor executor) {
            this.a = new VersionSafeCallbacks.g(bVar);
            if (m.this.h) {
                this.b = executor;
                this.c = null;
            } else {
                this.b = new com.ttnet.org.chromium.net.impl.p(executor);
                this.c = executor;
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ com.ttnet.org.chromium.net.impl.o a;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } catch (Throwable th) {
                m.this.r0(th);
            }
        }

        b(com.ttnet.org.chromium.net.impl.o oVar) {
            this.a = oVar;
        }
    }

    class i implements com.ttnet.org.chromium.net.impl.o {
        @Override // com.ttnet.org.chromium.net.impl.o
        public void run() throws Exception {
            m.this.j.close();
        }

        i() {
        }
    }

    class l implements Runnable {
        final /* synthetic */ com.ttnet.org.chromium.net.impl.o a;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } catch (Throwable th) {
                m.this.p0(th);
            }
        }

        l(com.ttnet.org.chromium.net.impl.o oVar) {
            this.a = oVar;
        }
    }

    /* renamed from: com.ttnet.org.chromium.net.impl.m$m, reason: collision with other inner class name */
    class RunnableC0123m implements Runnable {
        final /* synthetic */ com.ttnet.org.chromium.net.impl.o a;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } catch (Throwable th) {
                m.this.s0(th);
            }
        }

        RunnableC0123m(com.ttnet.org.chromium.net.impl.o oVar) {
            this.a = oVar;
        }
    }

    private final class o extends JavaUploadDataSinkBase {
        private final HttpURLConnection h;
        private final AtomicBoolean i;
        private WritableByteChannel j;
        private OutputStream k;

        static {
            Covode.recordClassIndex(654633);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected void o() throws IOException {
            x();
            m.this.y0();
        }

        void x() throws IOException {
            if (this.j != null && this.i.compareAndSet(false, true)) {
                this.j.close();
            }
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected void r() throws IOException {
            if (this.j != null) {
                return;
            }
            m.this.l = 10;
            this.h.setDoOutput(true);
            this.h.connect();
            m.this.l = 12;
            OutputStream outputStream = this.h.getOutputStream();
            this.k = outputStream;
            this.j = Channels.newChannel(outputStream);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected Runnable p(com.ttnet.org.chromium.net.impl.o oVar) {
            return m.this.t0(oVar);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected Runnable q(com.ttnet.org.chromium.net.impl.o oVar) {
            return m.this.G0(oVar);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected void u(Throwable th) {
            m.this.r0(th);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected void s(long j) {
            if (j > 0) {
                this.h.setFixedLengthStreamingMode(j);
            } else {
                this.h.setChunkedStreamingMode(8192);
            }
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected int t(ByteBuffer byteBuffer) throws IOException {
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                i += this.j.write(byteBuffer);
            }
            this.k.flush();
            return i;
        }

        o(Executor executor, Executor executor2, HttpURLConnection httpURLConnection, VersionSafeCallbacks.f fVar) {
            super(executor, executor2, fVar);
            this.i = new AtomicBoolean(false);
            this.h = httpURLConnection;
        }
    }

    static {
        Covode.recordClassIndex(654631);
        u = m.class.getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        this.b.execute(new e());
    }

    private void x0() {
        this.b.execute(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        this.b.execute(t0(new k()));
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void f() {
        F0(3, 1, new g());
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void o() {
        this.l = 10;
        F0(0, 1, new f());
    }

    class j implements Runnable {
        final /* synthetic */ String a;

        class a implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                m.this.a.h(m.this.o, m.this.p);
            }

            a() {
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            m mVar = m.this;
            mVar.p = URI.create(mVar.m).resolve(this.a).toString();
            m.this.e.add(m.this.p);
            m.this.F0(2, 3, new a());
        }

        j(String str) {
            this.a = str;
        }
    }

    class c implements Runnable {
        final /* synthetic */ ByteBuffer a;

        @Override // java.lang.Runnable
        public void run() {
            m.this.b.execute(m.this.t0(new a()));
        }

        class a implements com.ttnet.org.chromium.net.impl.o {
            @Override // com.ttnet.org.chromium.net.impl.o
            public void run() throws Exception {
                int read;
                if (m.this.n == null) {
                    read = -1;
                } else {
                    read = m.this.n.read(c.this.a);
                }
                c cVar = c.this;
                m.this.D0(read, cVar.a);
            }

            a() {
            }
        }

        c(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
        }
    }

    class e implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (m.this.n != null) {
                try {
                    m.this.n.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                m.this.n = null;
            }
        }

        e() {
        }
    }

    class f implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            m.this.e.add(m.this.m);
            m.this.z0();
        }

        f() {
        }
    }

    class g implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            m mVar = m.this;
            mVar.m = mVar.p;
            m.this.p = null;
            m.this.z0();
        }

        g() {
        }
    }

    private void n0() {
        int i2 = this.f.get();
        if (i2 == 0) {
            return;
        }
        throw new IllegalStateException("Request is already started. State is: " + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        this.l = 13;
        this.b.execute(t0(new h()));
    }

    class a implements Executor {
        final /* synthetic */ Executor a;
        final /* synthetic */ int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ int d;

        /* renamed from: com.ttnet.org.chromium.net.impl.m$a$a, reason: collision with other inner class name */
        class RunnableC0122a implements Runnable {
            final /* synthetic */ Runnable a;

            @Override // java.lang.Runnable
            public void run() {
                int threadStatsTag = TrafficStats.getThreadStatsTag();
                TrafficStats.setThreadStatsTag(a.this.b);
                a aVar = a.this;
                if (aVar.c) {
                    d0.c(aVar.d);
                }
                try {
                    this.a.run();
                } finally {
                    if (a.this.c) {
                        d0.a();
                    }
                    TrafficStats.setThreadStatsTag(threadStatsTag);
                }
            }

            RunnableC0122a(Runnable runnable) {
                this.a = runnable;
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.a.execute(new RunnableC0122a(runnable));
        }

        a(Executor executor, int i, boolean z, int i2) {
            this.a = executor;
            this.b = i;
            this.c = z;
            this.d = i2;
        }
    }

    class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (m.this.r != null) {
                try {
                    m.this.r.x();
                } catch (IOException e) {
                    Log.e(m.u, "Exception when closing OutputChannel", e);
                }
            }
            if (m.this.q != null) {
                m.this.q.disconnect();
                m.this.q = null;
            }
        }

        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        if (this.j != null && this.g.compareAndSet(false, true)) {
            try {
                this.k.execute(G0(new i()));
            } catch (RejectedExecutionException e2) {
                Log.e(u, "Exception when closing uploadDataProvider", e2);
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void d() {
        int andSet = this.f.getAndSet(8);
        if (andSet == 1 || andSet == 2 || andSet == 3 || andSet == 4 || andSet == 5) {
            x0();
            w0();
            this.a.e(this.o);
        }
    }

    private static final class p implements Executor {
        private final Executor a;
        private final Runnable b = new a();
        private final ArrayDeque<Runnable> c = new ArrayDeque<>();
        private boolean d;

        static {
            Covode.recordClassIndex(654634);
        }

        class a implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                boolean z2;
                synchronized (p.this.c) {
                    if (p.this.d) {
                        return;
                    }
                    Runnable runnable = (Runnable) p.this.c.pollFirst();
                    p pVar = p.this;
                    if (runnable != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    pVar.d = z;
                    while (runnable != null) {
                        try {
                            runnable.run();
                            synchronized (p.this.c) {
                                runnable = (Runnable) p.this.c.pollFirst();
                                p pVar2 = p.this;
                                if (runnable != null) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                pVar2.d = z2;
                            }
                        } catch (Throwable th) {
                            synchronized (p.this.c) {
                                p.this.d = false;
                                try {
                                    p.this.a.execute(p.this.b);
                                } catch (RejectedExecutionException unused) {
                                }
                                throw th;
                            }
                        }
                    }
                }
            }

            a() {
            }
        }

        p(Executor executor) {
            this.a = executor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            synchronized (this.c) {
                this.c.addLast(runnable);
                try {
                    this.a.execute(this.b);
                } catch (RejectedExecutionException unused) {
                    this.c.removeLast();
                }
            }
        }
    }

    class h implements com.ttnet.org.chromium.net.impl.o {
        @Override // com.ttnet.org.chromium.net.impl.o
        public void run() throws Exception {
            ReadableByteChannel a;
            List<String> list;
            if (m.this.q == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            String str = "http/1.1";
            int i = 0;
            while (true) {
                String headerFieldKey = m.this.q.getHeaderFieldKey(i);
                if (headerFieldKey == null) {
                    break;
                }
                if ("X-Android-Selected-Transport".equalsIgnoreCase(headerFieldKey)) {
                    str = m.this.q.getHeaderField(i);
                }
                if (!headerFieldKey.startsWith("X-Android")) {
                    arrayList.add(new AbstractMap.SimpleEntry(headerFieldKey, m.this.q.getHeaderField(i)));
                }
                i++;
            }
            int responseCode = m.this.q.getResponseCode();
            m.this.o = new z(new ArrayList(m.this.e), responseCode, m.this.q.getResponseMessage(), Collections.unmodifiableList(arrayList), false, str, "", 0L);
            if (responseCode < 300 || responseCode >= 400 || (list = m.this.o.a().get("location")) == null) {
                m.this.w0();
                if (responseCode >= 400) {
                    InputStream errorStream = m.this.q.getErrorStream();
                    m mVar = m.this;
                    if (errorStream == null) {
                        a = null;
                    } else {
                        a = com.ttnet.org.chromium.net.impl.l.a(errorStream);
                    }
                    mVar.n = a;
                    m.this.a.i(m.this.o);
                    return;
                }
                m mVar2 = m.this;
                mVar2.n = com.ttnet.org.chromium.net.impl.l.a(mVar2.q.getInputStream());
                m.this.a.i(m.this.o);
                return;
            }
            m.this.A0(list.get(0));
        }

        h() {
        }
    }

    class k implements com.ttnet.org.chromium.net.impl.o {
        @Override // com.ttnet.org.chromium.net.impl.o
        public void run() throws Exception {
            if (m.this.f.get() == 8) {
                return;
            }
            URL url = new URL(m.this.m);
            if (m.this.q != null) {
                m.this.q.disconnect();
                m.this.q = null;
            }
            m.this.q = (HttpURLConnection) HttpInstrumentation.openConnection(a(url));
            boolean z = false;
            m.this.q.setInstanceFollowRedirects(false);
            if (!m.this.d.containsKey("User-Agent")) {
                m.this.d.put("User-Agent", m.this.c);
            }
            for (Map.Entry entry : m.this.d.entrySet()) {
                m.this.q.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            if (m.this.i == null) {
                m.this.i = "GET";
            }
            m.this.q.setRequestMethod(m.this.i);
            if (m.this.j != null) {
                m mVar = m.this;
                m mVar2 = m.this;
                mVar.r = mVar2.new o(mVar2.k, m.this.b, m.this.q, m.this.j);
                o oVar = m.this.r;
                if (m.this.e.size() == 1) {
                    z = true;
                }
                oVar.v(z);
                return;
            }
            m.this.l = 10;
            m.this.q.connect();
            m.this.y0();
        }

        k() {
        }

        @Proxy("openConnection")
        @TargetClass("java.net.URL")
        @Skip({"com.bytedance.crash.upload.CrashUploader"})
        public static URLConnection a(URL url) throws IOException {
            URLConnection openConnection = url.openConnection();
            if (!u55.k.o()) {
                return openConnection;
            }
            return u55.b.a(openConnection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long C0(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable G0(com.ttnet.org.chromium.net.impl.o oVar) {
        return new b(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable H0(com.ttnet.org.chromium.net.impl.o oVar) {
        return new RunnableC0123m(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable t0(com.ttnet.org.chromium.net.impl.o oVar) {
        return new l(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(String str) {
        F0(1, 2, new j(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(Throwable th) {
        q0(new CronetExceptionImpl("System error", th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(Throwable th) {
        q0(new CallbackExceptionImpl("Exception received from UploadDataProvider", th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(Throwable th) {
        q0(new CallbackExceptionImpl("Exception received from UrlRequest.Callback", th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(CronetException cronetException) {
        if (E0(6)) {
            x0();
            w0();
            this.a.f(this.o, cronetException);
        }
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void g(ByteBuffer byteBuffer) {
        t.a(byteBuffer);
        t.b(byteBuffer);
        F0(4, 5, new c(byteBuffer));
    }

    private boolean E0(int i2) {
        int i3;
        do {
            i3 = this.f.get();
            if (i3 != 0) {
                if (i3 == 6 || i3 == 7 || i3 == 8) {
                    return false;
                }
            } else {
                throw new IllegalStateException("Can't enter error state before start");
            }
        } while (!this.f.compareAndSet(i3, i2));
        return true;
    }

    static long u0(Map<String, String> map) {
        long j2 = 0;
        if (map == null) {
            return 0L;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                j2 += r3.length();
            }
            if (entry.getValue() != null) {
                j2 += r2.length();
            }
        }
        return j2;
    }

    private boolean B0(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt != ',' && charAt != '/' && charAt != '{' && charAt != '}') {
                switch (charAt) {
                    case ConstantsAPI.COMMAND_FINDER_START_LIVE /* 39 */:
                    case '(':
                    case ConstantsAPI.COMMAND_FINDER_OPEN_EVENT /* 41 */:
                        break;
                    default:
                        switch (charAt) {
                            case ':':
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                            case '?':
                            case '@':
                                break;
                            default:
                                switch (charAt) {
                                    case '[':
                                    case '\\':
                                    case ']':
                                        break;
                                    default:
                                        if (!Character.isISOControl(charAt) && !Character.isWhitespace(charAt)) {
                                        }
                                        break;
                                }
                        }
                }
            }
            return false;
        }
        return true;
    }

    static long v0(Map<String, List<String>> map) {
        long j2 = 0;
        if (map == null) {
            return 0L;
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                j2 += r3.length();
            }
            if (entry.getValue() != null) {
                Iterator<String> it2 = entry.getValue().iterator();
                while (it2.hasNext()) {
                    if (it2.next() != null) {
                        j2 += r3.length();
                    }
                }
            }
        }
        return j2;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void r(String str) {
        n0();
        if (str != null) {
            if (!"OPTIONS".equalsIgnoreCase(str) && !"GET".equalsIgnoreCase(str) && !"HEAD".equalsIgnoreCase(str) && !"POST".equalsIgnoreCase(str) && !"PUT".equalsIgnoreCase(str) && !"DELETE".equalsIgnoreCase(str) && !"TRACE".equalsIgnoreCase(str) && !"PATCH".equalsIgnoreCase(str)) {
                throw new IllegalArgumentException("Invalid http method " + str);
            }
            this.i = str;
            return;
        }
        throw new NullPointerException("Method is required.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(int i2, ByteBuffer byteBuffer) throws IOException {
        if (i2 != -1) {
            this.a.g(this.o, byteBuffer);
            return;
        }
        ReadableByteChannel readableByteChannel = this.n;
        if (readableByteChannel != null) {
            readableByteChannel.close();
        }
        if (this.f.compareAndSet(5, 7)) {
            x0();
            this.a.j(this.o);
        }
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void w(e0 e0Var, Executor executor) {
        if (e0Var != null) {
            if (this.d.containsKey("Content-Type")) {
                n0();
                if (this.i == null) {
                    this.i = "POST";
                }
                this.j = new VersionSafeCallbacks.f(e0Var);
                if (this.h) {
                    this.k = executor;
                    return;
                } else {
                    this.k = new com.ttnet.org.chromium.net.impl.p(executor);
                    return;
                }
            }
            throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
        }
        throw new NullPointerException("Invalid UploadDataProvider.");
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void p(String str, String str2) {
        n0();
        if (B0(str) && !str2.contains("\r\n")) {
            if (this.d.containsKey(str)) {
                this.d.remove(str);
            }
            this.d.put(str, str2);
        } else {
            throw new IllegalArgumentException("Invalid header " + str + "=" + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(int i2, int i3, Runnable runnable) {
        if (!this.f.compareAndSet(i2, i3)) {
            int i4 = this.f.get();
            if (i4 != 8 && i4 != 6) {
                throw new IllegalStateException("Invalid state transition - expected " + i2 + " but was " + i4);
            }
            return;
        }
        runnable.run();
    }

    m(JavaCronetEngine javaCronetEngine, g0.b bVar, Executor executor, Executor executor2, String str, String str2, boolean z, boolean z2, int i2, boolean z3, int i3) {
        int threadStatsTag;
        if (str != null) {
            if (bVar != null) {
                if (executor != null) {
                    if (executor2 != null) {
                        this.h = z;
                        this.a = new n(bVar, executor2);
                        if (z2) {
                            threadStatsTag = i2;
                        } else {
                            threadStatsTag = TrafficStats.getThreadStatsTag();
                        }
                        this.b = new p(new a(executor, threadStatsTag, z3, i3));
                        this.s = javaCronetEngine.d;
                        this.t = javaCronetEngine.e;
                        this.m = str;
                        this.c = str2;
                        return;
                    }
                    throw new NullPointerException("userExecutor is required");
                }
                throw new NullPointerException("Executor is required");
            }
            throw new NullPointerException("Listener is required");
        }
        throw new NullPointerException("URL is required");
    }
}
