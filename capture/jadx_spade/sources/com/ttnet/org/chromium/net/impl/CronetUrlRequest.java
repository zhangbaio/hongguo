package com.ttnet.org.chromium.net.impl;

import android.os.Build;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.InlineExecutionProhibitedException;
import com.ttnet.org.chromium.net.e0;
import com.ttnet.org.chromium.net.g0;
import com.ttnet.org.chromium.net.impl.CronetLogger;
import com.ttnet.org.chromium.net.impl.VersionSafeCallbacks;
import com.ttnet.org.chromium.net.t;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

@JNINamespace("cronet")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CronetUrlRequest extends UrlRequestBase {
    private CronetUploadDataStream A;
    private z B;
    private int C;
    private CronetException D;
    private com.ttnet.org.chromium.net.impl.f E;
    private boolean F;
    private boolean G;
    private String H;
    private int I;
    private String J;
    private int K;
    private int L;
    private int M;
    private int N;
    private long O;
    private int P;
    private String Q;
    private String R;
    private long S;
    private long T;
    private int U;
    private k V;
    private Runnable W;
    private final boolean a;
    private long b;
    private boolean c;
    private boolean d;
    private boolean e;
    private final Object f = new Object();
    private final CronetUrlRequestContext g;
    private final Executor h;
    private final List<String> i;
    private final VersionSafeCallbacks.g j;
    private final String k;
    private final int l;
    private final int m;
    private String n;
    private final HeadersList o;
    private final Collection<Object> p;
    private final boolean q;
    private final boolean r;
    private final boolean s;
    private final int t;
    private final boolean u;
    private final int v;
    private final VersionSafeCallbacks.e w;
    private final long x;
    private final int y;
    private final CronetLogger z;

    interface j {
        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void a(long j, CronetUrlRequest cronetUrlRequest, long j2);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void b(long j, CronetUrlRequest cronetUrlRequest);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean c(long j, CronetUrlRequest cronetUrlRequest, ByteBuffer byteBuffer, int i, int i2);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void d(long j, CronetUrlRequest cronetUrlRequest, int i);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void e(long j, CronetUrlRequest cronetUrlRequest);

        long f(CronetUrlRequest cronetUrlRequest, long j, String str, int i, int i2, boolean z, boolean z2, boolean z3, int i3, boolean z4, int i4, int i5, long j2);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean g(long j, CronetUrlRequest cronetUrlRequest, String str, String str2);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void h(long j, CronetUrlRequest cronetUrlRequest, boolean z);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void i(long j, CronetUrlRequest cronetUrlRequest);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void j(long j, CronetUrlRequest cronetUrlRequest);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void k(long j, CronetUrlRequest cronetUrlRequest, String str, String str2);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void l(long j, CronetUrlRequest cronetUrlRequest, String str, String str2);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean m(long j, CronetUrlRequest cronetUrlRequest, String str);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void n(long j, CronetUrlRequest cronetUrlRequest, int i, int i2, int i3);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void o(long j, CronetUrlRequest cronetUrlRequest, VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void p(long j, CronetUrlRequest cronetUrlRequest);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void q(long j, CronetUrlRequest cronetUrlRequest, int i);
    }

    private static int O(int i2) {
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2) {
                return 0;
            }
        }
        return i3;
    }

    private static int P(int i2) {
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return i2 != 4 ? 4 : 5;
        }
        return 3;
    }

    static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        static {
            Covode.recordClassIndex(654611);
        }

        HeadersList() {
        }
    }

    class b implements Runnable {
        final /* synthetic */ VersionSafeCallbacks.UrlRequestStatusListener a;

        @Override // java.lang.Runnable
        public void run() {
            this.a.onStatus(-1);
        }

        b(VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener) {
            this.a = urlRequestStatusListener;
        }
    }

    class g implements Runnable {
        final /* synthetic */ VersionSafeCallbacks.UrlRequestStatusListener a;
        final /* synthetic */ int b;

        @Override // java.lang.Runnable
        public void run() {
            this.a.onStatus(UrlRequestBase.q(this.b));
        }

        g(VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener, int i) {
            this.a = urlRequestStatusListener;
            this.b = i;
        }
    }

    class i implements Runnable {
        final /* synthetic */ com.ttnet.org.chromium.net.t a;

        @Override // java.lang.Runnable
        public void run() {
            CronetUrlRequest.this.w.b(this.a);
        }

        i(com.ttnet.org.chromium.net.t tVar) {
            this.a = tVar;
        }
    }

    static {
        Covode.recordClassIndex(654610);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean V() {
        if (this.c && this.b == 0) {
            return true;
        }
        return false;
    }

    private void onCanceled() {
        com.ttnet.org.chromium.net.impl.j.c(this.H);
        a0(new f());
    }

    private void N() {
        synchronized (this.f) {
            if (this.c || V()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        String str = this.H;
        if (str != null) {
            com.ttnet.org.chromium.net.impl.j.a(str, this);
        }
        com.ttnet.org.chromium.net.impl.i.r().j(this.b, this);
    }

    void M() {
        if (!this.a && this.g.n0(Thread.currentThread())) {
            throw new InlineExecutionProhibitedException();
        }
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void b() {
        synchronized (this.f) {
            if (this.b == 0) {
                return;
            }
            com.ttnet.org.chromium.net.impl.i.r().b(this.b, this);
        }
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void c() {
        com.ttnet.org.chromium.net.impl.j.c(this.H);
        synchronized (this.f) {
            if (this.b == 0) {
                return;
            }
            com.ttnet.org.chromium.net.impl.i.r().e(this.b, this);
        }
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void d() {
        synchronized (this.f) {
            if (!V() && this.c) {
                Q(2);
            }
        }
    }

    class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            CronetUrlRequest.this.A.s();
            synchronized (CronetUrlRequest.this.f) {
                if (CronetUrlRequest.this.V()) {
                    return;
                }
                CronetUrlRequest.this.A.n(CronetUrlRequest.this.b);
                CronetUrlRequest.this.c0();
            }
        }

        a() {
        }
    }

    class c implements Runnable {
        final /* synthetic */ z a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        @Override // java.lang.Runnable
        public void run() {
            CronetUrlRequest.this.M();
            synchronized (CronetUrlRequest.this.f) {
                if (CronetUrlRequest.this.V()) {
                    return;
                }
                CronetUrlRequest.this.d = true;
                try {
                    CronetUrlRequest.this.j.d(CronetUrlRequest.this, this.a, this.b, this.c);
                } catch (Exception e) {
                    CronetUrlRequest.this.Y(e);
                }
            }
        }

        c(z zVar, String str, String str2) {
            this.a = zVar;
            this.b = str;
            this.c = str2;
        }
    }

    class d implements Runnable {
        final /* synthetic */ String a;

        @Override // java.lang.Runnable
        public void run() {
            CronetUrlRequest.this.M();
            synchronized (CronetUrlRequest.this.f) {
                if (CronetUrlRequest.this.V()) {
                    return;
                }
                CronetUrlRequest.this.e = true;
                try {
                    VersionSafeCallbacks.g gVar = CronetUrlRequest.this.j;
                    CronetUrlRequest cronetUrlRequest = CronetUrlRequest.this;
                    gVar.e(cronetUrlRequest, cronetUrlRequest.B, this.a);
                } catch (Exception e) {
                    CronetUrlRequest.this.Y(e);
                }
            }
        }

        d(String str) {
            this.a = str;
        }
    }

    class e implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUrlRequest.this.f) {
                if (CronetUrlRequest.this.V()) {
                    return;
                }
                CronetUrlRequest.this.Q(0);
                try {
                    VersionSafeCallbacks.g gVar = CronetUrlRequest.this.j;
                    CronetUrlRequest cronetUrlRequest = CronetUrlRequest.this;
                    gVar.f(cronetUrlRequest, cronetUrlRequest.B);
                    CronetUrlRequest.this.X();
                } catch (Exception e) {
                    com.ttnet.org.chromium.base.h.b(CronetUrlRequestContext.Q, "Exception in onSucceeded method", e);
                }
            }
        }

        e() {
        }
    }

    class f implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                VersionSafeCallbacks.g gVar = CronetUrlRequest.this.j;
                CronetUrlRequest cronetUrlRequest = CronetUrlRequest.this;
                gVar.a(cronetUrlRequest, cronetUrlRequest.B);
                CronetUrlRequest.this.X();
            } catch (Exception e) {
                com.ttnet.org.chromium.base.h.b(CronetUrlRequestContext.Q, "Exception in onCanceled method", e);
            }
        }

        f() {
        }
    }

    class h implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                VersionSafeCallbacks.g gVar = CronetUrlRequest.this.j;
                CronetUrlRequest cronetUrlRequest = CronetUrlRequest.this;
                gVar.b(cronetUrlRequest, cronetUrlRequest.B, CronetUrlRequest.this.D);
                CronetUrlRequest.this.X();
            } catch (Exception e) {
                com.ttnet.org.chromium.base.h.b(CronetUrlRequestContext.Q, "Exception in onFailed method", e);
            }
        }

        h() {
        }
    }

    private final class k implements Runnable {
        ByteBuffer a;

        static {
            Covode.recordClassIndex(654613);
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetUrlRequest.this.M();
            ByteBuffer byteBuffer = this.a;
            this.a = null;
            try {
                synchronized (CronetUrlRequest.this.f) {
                    if (CronetUrlRequest.this.V()) {
                        return;
                    }
                    CronetUrlRequest.this.e = true;
                    VersionSafeCallbacks.g gVar = CronetUrlRequest.this.j;
                    CronetUrlRequest cronetUrlRequest = CronetUrlRequest.this;
                    gVar.c(cronetUrlRequest, cronetUrlRequest.B, byteBuffer);
                }
            } catch (Exception e) {
                CronetUrlRequest.this.Y(e);
            }
        }

        private k() {
        }

        /* synthetic */ k(CronetUrlRequest cronetUrlRequest, a aVar) {
            this();
        }
    }

    private void onNativeAdapterDestroyed() {
        synchronized (this.f) {
            Runnable runnable = this.W;
            if (runnable != null) {
                runnable.run();
            }
            if (this.D == null) {
                return;
            }
            try {
                this.h.execute(new h());
            } catch (RejectedExecutionException e2) {
                com.ttnet.org.chromium.base.h.b(CronetUrlRequestContext.Q, "Exception posting task to executor", e2);
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void f() {
        synchronized (this.f) {
            if (this.d) {
                this.d = false;
                if (V()) {
                    return;
                }
                com.ttnet.org.chromium.net.impl.i.r().p(this.b, this);
                return;
            }
            throw new IllegalStateException("No redirect to follow.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        if (this.E != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    this.z.b(this.y, L());
                } catch (RuntimeException e2) {
                    com.ttnet.org.chromium.base.h.b(CronetUrlRequestContext.Q, "Error while trying to log CronetTrafficInfo: ", e2);
                }
            }
            RequestFinishedInfoImpl requestFinishedInfoImpl = new RequestFinishedInfoImpl(this.k, this.p, this.E, this.C, this.B, this.D);
            this.g.s0(requestFinishedInfoImpl);
            VersionSafeCallbacks.e eVar = this.w;
            if (eVar != null) {
                try {
                    eVar.a().execute(new i(requestFinishedInfoImpl));
                } catch (RejectedExecutionException e3) {
                    com.ttnet.org.chromium.base.h.b(CronetUrlRequestContext.Q, "Exception posting task to executor", e3);
                }
            }
        }
    }

    private CronetLogger.b L() {
        Map<String, List<String>> emptyMap;
        String str;
        boolean z;
        int i2;
        long R;
        long max;
        long S;
        long max2;
        Duration ofSeconds;
        Duration ofSeconds2;
        z zVar = this.B;
        if (zVar != null) {
            emptyMap = zVar.a();
            String g2 = this.B.g();
            int c2 = this.B.c();
            z = this.B.k();
            str = g2;
            i2 = c2;
        } else {
            emptyMap = Collections.emptyMap();
            str = "";
            z = false;
            i2 = 0;
        }
        long longValue = this.E.x().longValue();
        if (z && longValue == 0) {
            R = 0;
            max = 0;
        } else {
            R = R(this.o);
            max = Math.max(0L, longValue - R);
        }
        long longValue2 = this.E.l().longValue();
        if (z && longValue2 == 0) {
            S = 0;
            max2 = 0;
        } else {
            S = S(emptyMap);
            max2 = Math.max(0L, longValue2 - S);
        }
        if (this.E.q() != null && this.E.s() != null) {
            ofSeconds = Duration.ofMillis(this.E.s().getTime() - this.E.q().getTime());
        } else {
            ofSeconds = Duration.ofSeconds(0L);
        }
        if (this.E.q() != null && this.E.n() != null) {
            ofSeconds2 = Duration.ofMillis(this.E.n().getTime() - this.E.q().getTime());
        } else {
            ofSeconds2 = Duration.ofSeconds(0L);
        }
        return new CronetLogger.b(R, max, S, max2, i2, ofSeconds, ofSeconds2, str, this.F, this.G);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ttnet.org.chromium.net.g0
    public void o() {
        Object obj;
        CronetUrlRequest cronetUrlRequest;
        int i2;
        Object obj2 = this.f;
        synchronized (obj2) {
            try {
                try {
                    N();
                    try {
                        try {
                            obj = obj2;
                        } catch (RuntimeException e2) {
                            e = e2;
                            cronetUrlRequest = this;
                        } catch (Throwable th) {
                            th = th;
                            obj = obj2;
                        }
                    } catch (RuntimeException e3) {
                        e = e3;
                        cronetUrlRequest = this;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obj = obj2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            try {
                cronetUrlRequest = this;
                try {
                    cronetUrlRequest.b = com.ttnet.org.chromium.net.impl.i.r().f(this, this.g.j0(), this.k, this.l, this.I, this.q, this.r, this.s, this.t, this.u, this.v, this.m, this.x);
                    cronetUrlRequest.g.q0();
                    if (cronetUrlRequest.n != null && !com.ttnet.org.chromium.net.impl.i.r().m(cronetUrlRequest.b, cronetUrlRequest, cronetUrlRequest.n)) {
                        throw new IllegalArgumentException("Invalid http method " + cronetUrlRequest.n);
                    }
                    Iterator<Map.Entry<String, String>> it2 = cronetUrlRequest.o.iterator();
                    boolean z = false;
                    while (it2.hasNext()) {
                        Map.Entry<String, String> next = it2.next();
                        if (next.getKey().equalsIgnoreCase("Content-Type") && !next.getValue().isEmpty()) {
                            z = true;
                        }
                        if (next.getKey().equalsIgnoreCase("Tt-Map-Key") && !next.getValue().isEmpty()) {
                            cronetUrlRequest.H = next.getValue();
                        }
                        if (!com.ttnet.org.chromium.net.impl.i.r().g(cronetUrlRequest.b, this, next.getKey(), next.getValue())) {
                            throw new IllegalArgumentException("Invalid header " + next.getKey() + "=" + next.getValue());
                        }
                    }
                    com.ttnet.org.chromium.net.impl.i.r().n(cronetUrlRequest.b, this, cronetUrlRequest.K, cronetUrlRequest.L, cronetUrlRequest.M);
                    j r = com.ttnet.org.chromium.net.impl.i.r();
                    long j2 = cronetUrlRequest.b;
                    r.q(j2, cronetUrlRequest, cronetUrlRequest.N);
                    int i3 = j2;
                    if (cronetUrlRequest.O > 0) {
                        j r2 = com.ttnet.org.chromium.net.impl.i.r();
                        r2.a(cronetUrlRequest.b, this, cronetUrlRequest.O);
                        i3 = r2;
                    }
                    int i4 = i3;
                    if (cronetUrlRequest.P > 0) {
                        j r3 = com.ttnet.org.chromium.net.impl.i.r();
                        long j3 = cronetUrlRequest.b;
                        r3.d(j3, cronetUrlRequest, cronetUrlRequest.P);
                        i4 = j3;
                    }
                    i2 = i4;
                    if (cronetUrlRequest.Q != null) {
                        i2 = i4;
                        if (cronetUrlRequest.R != null) {
                            j r4 = com.ttnet.org.chromium.net.impl.i.r();
                            r4.l(cronetUrlRequest.b, this, cronetUrlRequest.Q, cronetUrlRequest.R);
                            i2 = r4;
                        }
                    }
                    CronetUploadDataStream cronetUploadDataStream = cronetUrlRequest.A;
                    if (cronetUploadDataStream != null) {
                        try {
                            if (z) {
                                cronetUrlRequest.c = true;
                                cronetUploadDataStream.u(cronetUrlRequest.new a());
                                return;
                            }
                            throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                        } catch (RuntimeException e4) {
                            e = e4;
                            cronetUrlRequest.Q(i2);
                            throw e;
                        }
                    }
                    cronetUrlRequest.c = true;
                    c0();
                } catch (RuntimeException e5) {
                    e = e5;
                    cronetUrlRequest = cronetUrlRequest;
                    i2 = 1;
                    cronetUrlRequest.Q(i2);
                    throw e;
                }
            } catch (RuntimeException e6) {
                e = e6;
                i2 = 1;
                cronetUrlRequest = this;
            } catch (Throwable th4) {
                th = th4;
                throw th;
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void h(long j2) {
        this.S = j2;
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void j(int i2) {
        this.U = i2;
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void k(int i2) {
        this.I = i2;
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void m(long j2) {
        this.T = j2;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void s(int i2) {
        this.N = i2;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void t(int i2) {
        this.K = i2;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void u(int i2) {
        this.L = i2;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void v(int i2) {
        this.M = i2;
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void l(int i2) {
        this.P = i2 | this.P;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void r(String str) {
        N();
        if (str != null) {
            this.n = str;
            return;
        }
        throw new NullPointerException("Method is required.");
    }

    private void T(CronetException cronetException) {
        synchronized (this.f) {
            if (V()) {
                return;
            }
            this.D = cronetException;
            Q(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Exception exc) {
        CallbackExceptionImpl callbackExceptionImpl = new CallbackExceptionImpl("Exception received from UrlRequest.Callback", exc);
        com.ttnet.org.chromium.base.h.b(CronetUrlRequestContext.Q, "Exception in CalledByNative method", exc);
        T(callbackExceptionImpl);
    }

    private void a0(Runnable runnable) {
        try {
            this.h.execute(runnable);
        } catch (RejectedExecutionException e2) {
            com.ttnet.org.chromium.base.h.b(CronetUrlRequestContext.Q, "Exception posting task to executor", e2);
            T(new CronetExceptionImpl("Exception posting task to executor", e2));
        }
    }

    private void onSucceeded(long j2) {
        this.B.j(j2);
        com.ttnet.org.chromium.net.impl.j.c(this.H);
        a0(new e());
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void n(long j2) {
        synchronized (this.f) {
            this.O = j2;
            if (this.b != 0) {
                com.ttnet.org.chromium.net.impl.i.r().a(this.b, this, j2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i2) {
        boolean z;
        this.C = i2;
        if (this.b == 0) {
            return;
        }
        this.g.p0();
        j r = com.ttnet.org.chromium.net.impl.i.r();
        long j2 = this.b;
        if (i2 == 2) {
            z = true;
        } else {
            z = false;
        }
        r.h(j2, this, z);
        this.b = 0L;
    }

    static long R(HeadersList headersList) {
        long j2 = 0;
        if (headersList == null) {
            return 0L;
        }
        Iterator<Map.Entry<String, String>> it2 = headersList.iterator();
        while (it2.hasNext()) {
            Map.Entry<String, String> next = it2.next();
            if (next.getKey() != null) {
                j2 += r3.length();
            }
            if (next.getValue() != null) {
                j2 += next.getValue().length();
            }
        }
        return j2;
    }

    public void U(g0.c cVar) {
        VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener = new VersionSafeCallbacks.UrlRequestStatusListener(cVar);
        synchronized (this.f) {
            if (this.b != 0) {
                com.ttnet.org.chromium.net.impl.i.r().o(this.b, this, urlRequestStatusListener);
            } else {
                a0(new b(urlRequestStatusListener));
            }
        }
    }

    void Z(Throwable th) {
        com.ttnet.org.chromium.base.h.b(CronetUrlRequestContext.Q, "Exception in upload method", th);
        synchronized (this.f) {
            if (this.b == 0) {
                return;
            }
            com.ttnet.org.chromium.net.impl.i.r().i(this.b, this);
        }
    }

    static long S(Map<String, List<String>> map) {
        long j2 = 0;
        if (map == null) {
            return 0L;
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                j2 += r3.length();
            }
            if (entry.getValue() != null) {
                while (entry.getValue().iterator().hasNext()) {
                    j2 += r2.next().length();
                }
            }
        }
        return j2;
    }

    private int W(int i2) {
        switch (i2) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return 6;
            case 7:
                return 7;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return 8;
            case 9:
                return 9;
            case 10:
                return 10;
            case 11:
                return 11;
            default:
                com.ttnet.org.chromium.base.h.b(CronetUrlRequestContext.Q, "Unknown error code: " + i2, new Object[0]);
                return i2;
        }
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void g(ByteBuffer byteBuffer) {
        t.b(byteBuffer);
        t.a(byteBuffer);
        synchronized (this.f) {
            if (this.e) {
                this.e = false;
                if (V()) {
                    return;
                }
                if (com.ttnet.org.chromium.net.impl.i.r().c(this.b, this, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    return;
                }
                this.e = true;
                throw new IllegalArgumentException("Unable to call native read");
            }
            throw new IllegalStateException("Unexpected read attempt.");
        }
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void i(String str, String str2) {
        this.Q = str;
        this.R = str2;
    }

    private void onStatus(VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener, int i2) {
        a0(new g(urlRequestStatusListener, i2));
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void e(String str, Throwable th) {
        T(new CronetExceptionImpl(str, th));
    }

    @Override // com.ttnet.org.chromium.net.g0
    public void a(String str, String str2) {
        synchronized (this.f) {
            if (this.b == 0) {
                return;
            }
            com.ttnet.org.chromium.net.impl.i.r().k(this.b, this, str, str2);
        }
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void w(e0 e0Var, Executor executor) {
        if (e0Var != null) {
            if (this.n == null) {
                this.n = "POST";
            }
            this.A = new CronetUploadDataStream(e0Var, executor, this);
            return;
        }
        throw new NullPointerException("Invalid UploadDataProvider.");
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void p(String str, String str2) {
        N();
        if (str != null) {
            if (str2 != null) {
                this.o.add(new AbstractMap.SimpleImmutableEntry(str, str2));
                return;
            }
            throw new NullPointerException("Invalid header value.");
        }
        throw new NullPointerException("Invalid header name.");
    }

    private String[] addSecurityFactor(String str, String[] strArr) {
        HashMap hashMap = new HashMap();
        int i2 = 0;
        for (int i3 = 0; i3 < strArr.length; i3 += 2) {
            hashMap.put(strArr[i3].toLowerCase(Locale.US), strArr[i3 + 1]);
        }
        Map<String, String> o0 = this.g.o0(str, hashMap);
        if (o0 == null) {
            return null;
        }
        String[] strArr2 = new String[o0.size() * 2];
        for (Map.Entry<String, String> entry : o0.entrySet()) {
            strArr2[i2] = entry.getKey();
            strArr2[i2 + 1] = entry.getValue();
            i2 += 2;
        }
        return strArr2;
    }

    private void onReadCompleted(ByteBuffer byteBuffer, int i2, int i3, int i4, long j2) {
        this.B.j(j2);
        a aVar = null;
        if (byteBuffer.position() == i3 && byteBuffer.limit() == i4) {
            if (this.V == null) {
                this.V = new k(this, aVar);
            }
            byteBuffer.position(i3 + i2);
            k kVar = this.V;
            kVar.a = byteBuffer;
            a0(kVar);
            return;
        }
        T(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
    }

    private void onError(int i2, int i3, int i4, String str, long j2) {
        z zVar = this.B;
        if (zVar != null) {
            zVar.j(j2);
        }
        com.ttnet.org.chromium.net.impl.j.c(this.H);
        if (i2 != 10 && i2 != 3) {
            T(new NetworkExceptionImpl("Exception in CronetUrlRequest: " + str, W(i2), i3));
            return;
        }
        T(new QuicExceptionImpl("Exception in CronetUrlRequest: " + str, i2, i3, i4));
    }

    private z b0(int i2, String str, String[] strArr, boolean z, String str2, String str3, long j2) {
        HeadersList headersList = new HeadersList();
        for (int i3 = 0; i3 < strArr.length; i3 += 2) {
            headersList.add(new AbstractMap.SimpleImmutableEntry(strArr[i3], strArr[i3 + 1]));
        }
        return new z(new ArrayList(this.i), i2, str, headersList, z, str2, str3, j2);
    }

    private void onResponseStarted(int i2, String str, String[] strArr, boolean z, String str2, String str3, long j2, String str4) {
        this.B = b0(i2, str, strArr, z, str2, str3, j2);
        a0(new d(str4));
    }

    private void onRedirectReceived(String str, int i2, String str2, String[] strArr, boolean z, String str3, String str4, long j2, String str5) {
        z b0 = b0(i2, str2, strArr, z, str3, str4, j2);
        this.B = b0;
        this.i.add(str);
        a0(new c(b0, str, str5));
    }

    CronetUrlRequest(CronetUrlRequestContext cronetUrlRequestContext, String str, int i2, g0.b bVar, Executor executor, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i3, boolean z5, int i4, t.a aVar, int i5, long j2) {
        VersionSafeCallbacks.e eVar;
        ArrayList arrayList = new ArrayList();
        this.i = arrayList;
        this.o = new HeadersList();
        if (str != null) {
            if (bVar != null) {
                if (executor != null) {
                    this.a = z3;
                    this.g = cronetUrlRequestContext;
                    this.y = cronetUrlRequestContext.N;
                    this.z = cronetUrlRequestContext.P;
                    this.k = str;
                    arrayList.add(str);
                    this.l = P(i2);
                    this.j = new VersionSafeCallbacks.g(bVar);
                    this.h = executor;
                    this.p = collection;
                    this.q = z;
                    this.r = z2;
                    this.s = z4;
                    this.t = i3;
                    this.u = z5;
                    this.v = i4;
                    if (aVar != null) {
                        eVar = new VersionSafeCallbacks.e(aVar);
                    } else {
                        eVar = null;
                    }
                    this.w = eVar;
                    this.m = O(i5);
                    this.x = j2;
                    return;
                }
                throw new NullPointerException("Executor is required");
            }
            throw new NullPointerException("Listener is required");
        }
        throw new NullPointerException("URL is required");
    }

    private void onMetricsCollected(long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, boolean z, long j15, long j16, String str, long j17, long j18, String str2, String str3, String str4, String str5, boolean z2, boolean z3, int i2, boolean z4, boolean z5) {
        synchronized (this.f) {
            if (this.E == null) {
                com.ttnet.org.chromium.net.impl.f fVar = new com.ttnet.org.chromium.net.impl.f(j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, z, j15, j16, str, j17, j18, str2, str3, this.S, this.T, this.U, z2, z3, i2);
                this.E = fVar;
                fVar.D = str5;
                this.J = str4;
                this.F = z4;
                this.G = z5;
            } else {
                throw new IllegalStateException("Metrics collection should only happen once.");
            }
        }
    }
}
