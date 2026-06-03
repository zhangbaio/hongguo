package com.ttnet.org.chromium.net.impl;

import android.os.ConditionVariable;
import android.os.Process;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.PowerMonitor;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider$TTSlaSamplingSetting;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider$BindCore;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider$ThreadConfigInfo;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider$ThreadType;
import com.ttnet.org.chromium.net.b0;
import com.ttnet.org.chromium.net.c0;
import com.ttnet.org.chromium.net.g0;
import com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl;
import com.ttnet.org.chromium.net.impl.CronetLogger;
import com.ttnet.org.chromium.net.impl.VersionSafeCallbacks;
import com.ttnet.org.chromium.net.t;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import com.ttnet.org.chromium.net.z;
import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@JNINamespace("cronet")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class CronetUrlRequestContext extends CronetEngineBase {
    static final String Q;
    private static final HashSet<String> R;
    private double[] A;
    private double[] B;
    private TTAppInfoProvider C;
    private com.ttnet.org.chromium.net.x D;
    private com.ttnet.org.chromium.net.w E;
    private boolean F;
    private final Object G;
    private b0 H;
    private Map<TTThreadConfigInfoProvider$ThreadType, Integer> I;
    private Map<TTThreadConfigInfoProvider$ThreadType, TTThreadConfigInfoProvider$BindCore> J;
    private final ConditionVariable K;
    private final String L;
    private long M;
    public final int N;
    private final boolean O;
    public final CronetLogger P;
    private final Object b;
    private final ConditionVariable c;
    private final AtomicInteger d;
    private long e;
    private Thread f;
    private final boolean g;
    private final Object h;
    private final Object i;
    private int j;
    private int k;
    private int l;
    private int m;
    private final com.ttnet.org.chromium.base.k<VersionSafeCallbacks.c> n;
    private final com.ttnet.org.chromium.base.k<VersionSafeCallbacks.d> o;
    private final Map<t.a, VersionSafeCallbacks.e> p;
    private final Object q;
    private int r;
    private int s;
    private int t;
    private int u;
    private String[] v;
    private int[] w;
    private int[] x;
    private double[] y;
    private double[] z;

    interface g {
        void A(long j, String str, byte[][] bArr, boolean z, long j2);

        void B(long j, String[] strArr, byte[] bArr, byte[] bArr2);

        void C(long j, String str, int i, int i2);

        @NativeClassQualifiedName("CronetContextAdapter")
        void D(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11);

        void E(long j, int i, boolean z, boolean z2, String str, String str2, String str3, boolean z3, String str4, String str5, byte[][] bArr, TTThreadConfigInfoProvider$ThreadConfigInfo[] tTThreadConfigInfoProvider$ThreadConfigInfoArr, boolean z4, boolean z5, boolean z6, String str6, TTAppInfoProvider.AppInfo appInfo, long j2, boolean z7, boolean z8, boolean z9, TTSamplingSettingProvider$TTSlaSamplingSetting tTSamplingSettingProvider$TTSlaSamplingSetting, boolean z10, String str7);

        @NativeClassQualifiedName("CronetContextAdapter")
        boolean F(long j, CronetUrlRequestContext cronetUrlRequestContext);

        @NativeClassQualifiedName("CronetContextAdapter")
        void G(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, String str2, String str3, String str4, String str5, String str6);

        @NativeClassQualifiedName("CronetContextAdapter")
        void H(long j, CronetUrlRequestContext cronetUrlRequestContext, int i);

        int I(int i);

        @NativeClassQualifiedName("CronetContextAdapter")
        void J(long j, CronetUrlRequestContext cronetUrlRequestContext);

        @NativeClassQualifiedName("CronetContextAdapter")
        void a(long j, CronetUrlRequestContext cronetUrlRequestContext, URLDispatch uRLDispatch, String str, boolean z);

        long b(long j);

        @NativeClassQualifiedName("CronetContextAdapter")
        void c(long j, CronetUrlRequestContext cronetUrlRequestContext);

        @NativeClassQualifiedName("CronetContextAdapter")
        void d(long j, CronetUrlRequestContext cronetUrlRequestContext);

        @NativeClassQualifiedName("CronetContextAdapter")
        void e(long j, CronetUrlRequestContext cronetUrlRequestContext, String[] strArr, int i);

        @NativeClassQualifiedName("CronetContextAdapter")
        void f(long j, CronetUrlRequestContext cronetUrlRequestContext, String str);

        @NativeClassQualifiedName("CronetContextAdapter")
        void g(long j, CronetUrlRequestContext cronetUrlRequestContext);

        @NativeClassQualifiedName("CronetContextAdapter")
        void h(long j, CronetUrlRequestContext cronetUrlRequestContext, String str);

        long i(String str, String str2, boolean z, String str3, boolean z2, boolean z3, boolean z4, int i, long j, String str4, long j2, boolean z5, boolean z6, int i2);

        @NativeClassQualifiedName("CronetContextAdapter")
        void j(long j, CronetUrlRequestContext cronetUrlRequestContext, boolean z, String str, String str2, String str3, boolean z2, String str4);

        void k(long j);

        @NativeClassQualifiedName("CronetContextAdapter")
        void l(long j, CronetUrlRequestContext cronetUrlRequestContext, long j2);

        @NativeClassQualifiedName("CronetContextAdapter")
        void m(long j, CronetUrlRequestContext cronetUrlRequestContext, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9);

        @NativeClassQualifiedName("CronetContextAdapter")
        void n(long j, CronetUrlRequestContext cronetUrlRequestContext, String[] strArr, byte[] bArr, byte[] bArr2, long j2, long j3);

        @NativeClassQualifiedName("CronetContextAdapter")
        void o(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, int i, String str2, String str3);

        long[] p();

        @NativeClassQualifiedName("CronetContextAdapter")
        void q(long j, CronetUrlRequestContext cronetUrlRequestContext, TTSamplingSettingProvider$TTSlaSamplingSetting tTSamplingSettingProvider$TTSlaSamplingSetting);

        @NativeClassQualifiedName("CronetContextAdapter")
        void r(long j, CronetUrlRequestContext cronetUrlRequestContext, String str);

        @NativeClassQualifiedName("CronetContextAdapter")
        void s(long j, CronetUrlRequestContext cronetUrlRequestContext, boolean z);

        @NativeClassQualifiedName("CronetContextAdapter")
        void t(long j, CronetUrlRequestContext cronetUrlRequestContext, String str);

        @NativeClassQualifiedName("CronetContextAdapter")
        void u(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, String str2);

        @NativeClassQualifiedName("CronetContextAdapter")
        void v(long j, CronetUrlRequestContext cronetUrlRequestContext, String[] strArr, int i, long j2);

        @NativeClassQualifiedName("CronetContextAdapter")
        void w(long j, CronetUrlRequestContext cronetUrlRequestContext, boolean z);

        @NativeClassQualifiedName("CronetContextAdapter")
        void x(long j, CronetUrlRequestContext cronetUrlRequestContext, boolean z);

        @NativeClassQualifiedName("CronetContextAdapter")
        void y(long j, CronetUrlRequestContext cronetUrlRequestContext, String[] strArr, int i, int i2);

        @NativeClassQualifiedName("CronetContextAdapter")
        void z(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, int i, String str2);
    }

    class b implements Runnable {
        final /* synthetic */ URLDispatch a;

        @Override // java.lang.Runnable
        public void run() {
            this.a.a();
        }

        b(URLDispatch uRLDispatch) {
            this.a = uRLDispatch;
        }
    }

    class e implements Runnable {
        final /* synthetic */ VersionSafeCallbacks.e a;
        final /* synthetic */ com.ttnet.org.chromium.net.t b;

        @Override // java.lang.Runnable
        public void run() {
            this.a.b(this.b);
        }

        e(VersionSafeCallbacks.e eVar, com.ttnet.org.chromium.net.t tVar) {
            this.a = eVar;
            this.b = tVar;
        }
    }

    private void onColdStartFinish() {
        com.ttnet.org.chromium.net.w wVar = this.E;
        if (wVar != null) {
            wVar.c();
        }
    }

    private void onTLBDecompressFail() {
        com.ttnet.org.chromium.net.w wVar = this.E;
        if (wVar != null) {
            wVar.t();
        }
    }

    @Override // com.ttnet.org.chromium.net.c
    public com.ttnet.org.chromium.net.y a() {
        return new TTCronetMpaService(this);
    }

    void p0() {
        this.d.decrementAndGet();
    }

    void q0() {
        this.d.incrementAndGet();
    }

    public void stopNetLogCompleted() {
        this.K.open();
    }

    class c implements Runnable {
        final /* synthetic */ VersionSafeCallbacks.c a;
        final /* synthetic */ int b;
        final /* synthetic */ long c;
        final /* synthetic */ int d;

        @Override // java.lang.Runnable
        public void run() {
            this.a.b(this.b, this.c, this.d);
        }

        c(VersionSafeCallbacks.c cVar, int i, long j, int i2) {
            this.a = cVar;
            this.b = i;
            this.c = j;
            this.d = i2;
        }
    }

    class d implements Runnable {
        final /* synthetic */ VersionSafeCallbacks.d a;
        final /* synthetic */ int b;
        final /* synthetic */ long c;
        final /* synthetic */ int d;

        @Override // java.lang.Runnable
        public void run() {
            this.a.b(this.b, this.c, this.d);
        }

        d(VersionSafeCallbacks.d dVar, int i, long j, int i2) {
            this.a = dVar;
            this.b = i;
            this.c = j;
            this.d = i2;
        }
    }

    private void e0() throws IllegalStateException {
        if (m0()) {
        } else {
            throw new IllegalStateException("Engine is shut down.");
        }
    }

    private boolean m0() {
        if (this.e != 0) {
            return true;
        }
        return false;
    }

    private TTAppInfoProvider.AppInfo onGetAppInfo() {
        TTAppInfoProvider tTAppInfoProvider = this.C;
        if (tTAppInfoProvider != null) {
            return tTAppInfoProvider.a();
        }
        return null;
    }

    public long j0() {
        long j;
        synchronized (this.b) {
            e0();
            j = this.e;
        }
        return j;
    }

    @Override // com.ttnet.org.chromium.net.f
    public int p() {
        int i;
        synchronized (this.q) {
            i = this.s;
        }
        return i;
    }

    @Override // com.ttnet.org.chromium.net.f
    public int q() {
        int i;
        synchronized (this.q) {
            i = this.u;
        }
        return i;
    }

    @Override // com.ttnet.org.chromium.net.f
    public int r() {
        int i;
        synchronized (this.q) {
            i = this.t;
        }
        return i;
    }

    @Override // com.ttnet.org.chromium.net.f
    public int u() {
        int i;
        synchronized (this.q) {
            i = this.r;
        }
        return i;
    }

    static {
        Covode.recordClassIndex(654614);
        Q = CronetUrlRequestContext.class.getSimpleName();
        R = new HashSet<>();
    }

    private CronetLogger.c d0() {
        return new CronetLogger.c(k0().split("/")[1].split("@")[0]);
    }

    static CronetLogger.CronetSource h0() {
        if (com.ttnet.org.chromium.net.c.class.getClassLoader().equals(CronetUrlRequest.class.getClassLoader())) {
            return CronetLogger.CronetSource.CRONET_SOURCE_STATICALLY_LINKED;
        }
        return CronetLogger.CronetSource.CRONET_SOURCE_PLAY_SERVICES;
    }

    private int i0() {
        String str = Q;
        if (com.ttnet.org.chromium.base.h.j(str, 2)) {
            return -2;
        }
        if (com.ttnet.org.chromium.base.h.j(str, 3)) {
            return -1;
        }
        return 3;
    }

    @Override // com.ttnet.org.chromium.net.f
    public void J() {
        synchronized (this.b) {
            h.K().c(this.e, this);
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void R() {
        synchronized (this.b) {
            h.K().g(this.e, this);
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void j() {
        synchronized (this.b) {
            h.K().d(this.e, this);
        }
    }

    public String k0() {
        return "Cronet/" + ImplVersion.b();
    }

    @Override // com.ttnet.org.chromium.net.f
    public int n() {
        int i;
        if (this.g) {
            synchronized (this.h) {
                i = this.m;
                if (i == -1) {
                    i = -1;
                }
            }
            return i;
        }
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.f
    public int o() {
        int i;
        if (this.g) {
            synchronized (this.h) {
                i = this.j;
            }
            return i;
        }
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.f
    public int t() {
        int i;
        if (this.g) {
            synchronized (this.h) {
                i = this.k;
                if (i == -1) {
                    i = -1;
                }
            }
            return i;
        }
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.f
    public int w() {
        int i;
        if (this.g) {
            synchronized (this.h) {
                i = this.l;
                if (i == -1) {
                    i = -1;
                }
            }
            return i;
        }
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            CronetLibraryLoader.c();
            CronetLibraryLoader.a();
            PowerMonitor.q(CronetUrlRequestContext.this.F);
            PowerMonitor.n();
            synchronized (CronetUrlRequestContext.this.b) {
                h.K().J(CronetUrlRequestContext.this.e, CronetUrlRequestContext.this);
            }
        }

        a() {
        }
    }

    static /* synthetic */ class f {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TTThreadConfigInfoProvider$BindCore.values().length];
            a = iArr;
            try {
                iArr[TTThreadConfigInfoProvider$BindCore.BIG_CORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TTThreadConfigInfoProvider$BindCore.LITTLE_CORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TTThreadConfigInfoProvider$BindCore.CANCEL_BIND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void initNetworkThread() {
        this.f = Thread.currentThread();
        this.c.open();
        Thread.currentThread().setName("ChromiumNet" + Process.getThreadPriority(0));
        com.ttnet.org.chromium.net.w wVar = this.E;
        if (wVar != null) {
            wVar.e();
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public Map<String, int[]> s() {
        if (this.g) {
            HashMap hashMap = new HashMap();
            synchronized (this.h) {
                if (this.v == null) {
                    return hashMap;
                }
                int i = 0;
                while (true) {
                    String[] strArr = this.v;
                    if (i < strArr.length) {
                        hashMap.put(strArr[i], new int[]{this.w[i], this.x[i]});
                        i++;
                    } else {
                        return hashMap;
                    }
                }
            }
        } else {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public List<Long> v() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.b) {
            for (long j : h.K().p()) {
                arrayList.add(Long.valueOf(j));
            }
        }
        return arrayList;
    }

    private void onClientIPChanged(String str) {
        com.ttnet.org.chromium.net.w wVar = this.E;
        if (wVar != null) {
            wVar.b(str);
        }
    }

    private void onNetworkQualityTypeChangedV3(int i) {
        com.ttnet.org.chromium.net.w wVar = this.E;
        if (wVar != null) {
            wVar.l(i);
        }
    }

    private void onTTNetDetectInfoChanged(String str) {
        com.ttnet.org.chromium.net.w wVar = this.E;
        if (wVar != null) {
            wVar.w(str);
        }
    }

    private void onUserSpecifiedNetworkEnabled(boolean z) {
        com.ttnet.org.chromium.net.w wVar = this.E;
        if (wVar != null) {
            wVar.y(z);
        }
    }

    public boolean n0(Thread thread) {
        if (thread == this.f) {
            return true;
        }
        return false;
    }

    @Override // com.ttnet.org.chromium.net.f
    public double l(int i) {
        double d2;
        l0(i);
        synchronized (this.h) {
            d2 = this.y[i];
        }
        return d2;
    }

    @Override // com.ttnet.org.chromium.net.f
    public double m(int i) {
        double d2;
        l0(i);
        synchronized (this.h) {
            d2 = this.B[i];
        }
        return d2;
    }

    @Override // com.ttnet.org.chromium.net.f
    public double x(int i) {
        double d2;
        l0(i);
        synchronized (this.h) {
            d2 = this.y[i];
        }
        return d2;
    }

    @Override // com.ttnet.org.chromium.net.f
    public double y(int i) {
        double d2;
        l0(i);
        synchronized (this.h) {
            d2 = this.z[i];
        }
        return d2;
    }

    private void onEffectiveConnectionTypeChanged(int i) {
        synchronized (this.h) {
            this.j = i;
            com.ttnet.org.chromium.net.w wVar = this.E;
            if (wVar != null) {
                wVar.g(i);
            }
        }
    }

    private void onNQLChanged(int i) {
        synchronized (this.q) {
            this.r = i;
            com.ttnet.org.chromium.net.w wVar = this.E;
            if (wVar != null) {
                wVar.j(i);
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void A(boolean z) {
        synchronized (this.b) {
            h.K().s(this.e, this, z);
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void D(String str) {
        synchronized (this.b) {
            h.K().t(this.e, this, str);
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void E(String str) {
        synchronized (this.b) {
            h.K().r(this.e, this, str);
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void G(boolean z) {
        synchronized (this.b) {
            h.K().x(this.e, this, z);
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void I(int i) {
        synchronized (this.b) {
            h.K().H(this.e, this, i);
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void K(String str) {
        synchronized (this.b) {
            e0();
            h.K().f(this.e, this, str);
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void L(String str) {
        synchronized (this.b) {
            h.K().h(this.e, this, str);
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void Q(boolean z) {
        synchronized (this.b) {
            h.K().w(this.e, this, z);
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void g(TTSamplingSettingProvider$TTSlaSamplingSetting tTSamplingSettingProvider$TTSlaSamplingSetting) {
        synchronized (this.b) {
            e0();
            h.K().q(this.e, this, tTSamplingSettingProvider$TTSlaSamplingSetting);
        }
    }

    private void l0(int i) {
        if (this.g) {
            if (i != 0 && i != 1) {
                throw new IllegalStateException("Error protocol: " + i);
            }
            return;
        }
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.f
    public void F(int i) {
        synchronized (this.G) {
            if (this.H == null) {
                return;
            }
            TTThreadConfigInfoProvider$ThreadType tTThreadConfigInfoProvider$ThreadType = TTThreadConfigInfoProvider$ThreadType.values()[i];
            if (this.I.containsKey(tTThreadConfigInfoProvider$ThreadType)) {
                this.H.resetCoreBind(this.I.get(tTThreadConfigInfoProvider$ThreadType).intValue());
            } else {
                this.J.put(tTThreadConfigInfoProvider$ThreadType, TTThreadConfigInfoProvider$BindCore.CANCEL_BIND);
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void H(long j) {
        synchronized (this.b) {
            e0();
            com.ttnet.org.chromium.base.h.b(Q, "Set alog func addr: " + j, new Object[0]);
            h.K().l(this.e, this, j);
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void h(int i) {
        synchronized (this.G) {
            if (this.H == null) {
                return;
            }
            TTThreadConfigInfoProvider$ThreadType tTThreadConfigInfoProvider$ThreadType = TTThreadConfigInfoProvider$ThreadType.values()[i];
            if (this.I.containsKey(tTThreadConfigInfoProvider$ThreadType)) {
                this.H.bindBigCore(this.I.get(tTThreadConfigInfoProvider$ThreadType).intValue());
            } else {
                this.J.put(tTThreadConfigInfoProvider$ThreadType, TTThreadConfigInfoProvider$BindCore.BIG_CORE);
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void i(int i) {
        synchronized (this.G) {
            if (this.H == null) {
                return;
            }
            TTThreadConfigInfoProvider$ThreadType tTThreadConfigInfoProvider$ThreadType = TTThreadConfigInfoProvider$ThreadType.values()[i];
            if (this.I.containsKey(tTThreadConfigInfoProvider$ThreadType)) {
                this.H.bindLittleCore(this.I.get(tTThreadConfigInfoProvider$ThreadType).intValue());
            } else {
                this.J.put(tTThreadConfigInfoProvider$ThreadType, TTThreadConfigInfoProvider$BindCore.LITTLE_CORE);
            }
        }
    }

    void s0(com.ttnet.org.chromium.net.t tVar) {
        synchronized (this.i) {
            if (this.p.isEmpty()) {
                return;
            }
            Iterator it2 = new ArrayList(this.p.values()).iterator();
            while (it2.hasNext()) {
                VersionSafeCallbacks.e eVar = (VersionSafeCallbacks.e) it2.next();
                r0(eVar.a(), new e(eVar, tVar));
            }
        }
    }

    private String f0(Map<String, String> map) {
        String str = "";
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!key.isEmpty() && !value.isEmpty()) {
                    str = key + ":" + value + "\r\n" + str;
                }
            }
        }
        return str;
    }

    private void onThreadIdChanged(int[] iArr) {
        synchronized (this.G) {
            for (int i = 0; i < iArr.length - 1; i += 2) {
                TTThreadConfigInfoProvider$ThreadType tTThreadConfigInfoProvider$ThreadType = TTThreadConfigInfoProvider$ThreadType.values()[iArr[i]];
                int i2 = iArr[i + 1];
                this.I.put(tTThreadConfigInfoProvider$ThreadType, Integer.valueOf(i2));
                if (this.J.containsKey(tTThreadConfigInfoProvider$ThreadType) && this.H != null) {
                    int i3 = f.a[this.J.get(tTThreadConfigInfoProvider$ThreadType).ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                this.H.resetCoreBind(i2);
                            }
                        } else {
                            this.H.bindLittleCore(i2);
                        }
                    } else {
                        this.H.bindBigCore(i2);
                    }
                }
            }
        }
    }

    public CronetUrlRequestContext(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        boolean F;
        Object obj = new Object();
        this.b = obj;
        this.c = new ConditionVariable(false);
        this.d = new AtomicInteger(0);
        this.h = new Object();
        this.i = new Object();
        this.j = 0;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        com.ttnet.org.chromium.base.k<VersionSafeCallbacks.c> kVar = new com.ttnet.org.chromium.base.k<>();
        this.n = kVar;
        com.ttnet.org.chromium.base.k<VersionSafeCallbacks.d> kVar2 = new com.ttnet.org.chromium.base.k<>();
        this.o = kVar2;
        this.p = new HashMap();
        this.q = new Object();
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.y = new double[]{-1.0d, -1.0d};
        this.z = new double[]{-1.0d, -1.0d};
        this.A = new double[]{-1.0d, -1.0d};
        this.B = new double[]{-1.0d, -1.0d};
        Object obj2 = new Object();
        this.G = obj2;
        this.I = new HashMap();
        this.J = new HashMap();
        this.K = new ConditionVariable();
        this.M = -1L;
        int hashCode = hashCode();
        this.N = hashCode;
        kVar.s();
        kVar2.s();
        this.g = cronetEngineBuilderImpl.n;
        CronetLibraryLoader.b(cronetEngineBuilderImpl.getContext(), cronetEngineBuilderImpl);
        h.K().I(i0());
        if (cronetEngineBuilderImpl.b0() == 1) {
            String str = cronetEngineBuilderImpl.f;
            this.L = str;
            HashSet<String> hashSet = R;
            synchronized (hashSet) {
                if (!hashSet.add(str)) {
                    throw new IllegalStateException("Disk cache storage path already in use");
                }
            }
        } else {
            this.L = null;
        }
        this.C = cronetEngineBuilderImpl.r;
        this.D = cronetEngineBuilderImpl.s;
        this.E = cronetEngineBuilderImpl.t;
        this.F = cronetEngineBuilderImpl.E;
        synchronized (obj2) {
            this.H = cronetEngineBuilderImpl.P;
        }
        synchronized (obj) {
            long b2 = h.K().b(g0(cronetEngineBuilderImpl));
            this.e = b2;
            if (b2 != 0) {
                F = h.K().F(this.e, this);
                this.O = F;
            } else {
                throw new NullPointerException("Context Adapter creation failed.");
            }
        }
        if (F) {
            this.P = com.ttnet.org.chromium.net.impl.d.b();
        } else {
            this.P = com.ttnet.org.chromium.net.impl.d.a(cronetEngineBuilderImpl.getContext(), h0());
        }
        try {
            this.P.a(hashCode, new CronetLogger.a(cronetEngineBuilderImpl), d0(), h0());
        } catch (RuntimeException e2) {
            com.ttnet.org.chromium.base.h.b(Q, "Error while trying to log CronetEngine creation: ", e2);
        }
        CronetLibraryLoader.f(new a());
    }

    public static long g0(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        byte[][] bArr;
        TTThreadConfigInfoProvider$ThreadConfigInfo[] tTThreadConfigInfoProvider$ThreadConfigInfoArr;
        String str = "";
        try {
            File filesDir = cronetEngineBuilderImpl.getContext().getFilesDir();
            if (filesDir != null) {
                str = filesDir.getAbsolutePath();
            }
        } catch (Throwable unused) {
        }
        String str2 = str;
        long i = h.K().i(cronetEngineBuilderImpl.e, cronetEngineBuilderImpl.f, cronetEngineBuilderImpl.g, cronetEngineBuilderImpl.Z(), cronetEngineBuilderImpl.h, cronetEngineBuilderImpl.i, cronetEngineBuilderImpl.O(), cronetEngineBuilderImpl.b0(), cronetEngineBuilderImpl.k, cronetEngineBuilderImpl.l, cronetEngineBuilderImpl.m, cronetEngineBuilderImpl.n, cronetEngineBuilderImpl.d, cronetEngineBuilderImpl.F0(0));
        if (i != 0) {
            for (CronetEngineBuilderImpl.c cVar : cronetEngineBuilderImpl.b) {
                h.K().C(i, cVar.a, cVar.b, cVar.c);
            }
            for (CronetEngineBuilderImpl.b bVar : cronetEngineBuilderImpl.c) {
                h.K().A(i, bVar.a, bVar.b, bVar.c, bVar.d.getTime());
            }
            ArrayList<byte[]> arrayList = cronetEngineBuilderImpl.v;
            if (arrayList != null && !arrayList.isEmpty()) {
                bArr = (byte[][]) arrayList.toArray(new byte[arrayList.size()][]);
            } else {
                bArr = null;
            }
            ArrayList<TTThreadConfigInfoProvider$ThreadConfigInfo> arrayList2 = cronetEngineBuilderImpl.O;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                tTThreadConfigInfoProvider$ThreadConfigInfoArr = (TTThreadConfigInfoProvider$ThreadConfigInfo[]) arrayList2.toArray(new TTThreadConfigInfoProvider$ThreadConfigInfo[arrayList2.size()]);
            } else {
                tTThreadConfigInfoProvider$ThreadConfigInfoArr = null;
            }
            h.K().E(i, cronetEngineBuilderImpl.F, cronetEngineBuilderImpl.p, cronetEngineBuilderImpl.q, str2, cronetEngineBuilderImpl.z, cronetEngineBuilderImpl.u, cronetEngineBuilderImpl.A, cronetEngineBuilderImpl.x, cronetEngineBuilderImpl.y, bArr, tTThreadConfigInfoProvider$ThreadConfigInfoArr, cronetEngineBuilderImpl.B, cronetEngineBuilderImpl.G, cronetEngineBuilderImpl.H, cronetEngineBuilderImpl.I, cronetEngineBuilderImpl.J, cronetEngineBuilderImpl.N, cronetEngineBuilderImpl.K, cronetEngineBuilderImpl.L, cronetEngineBuilderImpl.M, cronetEngineBuilderImpl.Q, cronetEngineBuilderImpl.R, cronetEngineBuilderImpl.S);
            Map<String[], Pair<byte[], byte[]>> map = cronetEngineBuilderImpl.w;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String[], Pair<byte[], byte[]>> entry : map.entrySet()) {
                    h.K().B(i, entry.getKey(), (byte[]) entry.getValue().first, (byte[]) entry.getValue().second);
                }
            }
            h.K().k(cronetEngineBuilderImpl.C);
            return i;
        }
        throw new IllegalArgumentException("Experimental options parsing failed.");
    }

    private void onMultiNetStateChanged(int i, int i2) {
        com.ttnet.org.chromium.net.w wVar = this.E;
        if (wVar != null) {
            wVar.h(i, i2);
        }
    }

    private void onSendAppMonitorEvent(String str, String str2) {
        com.ttnet.org.chromium.net.x xVar = this.D;
        if (xVar != null) {
            xVar.c(str, str2);
        }
    }

    private void onTNCUpdateFailed(String[] strArr, String str) {
        com.ttnet.org.chromium.net.w wVar = this.E;
        if (wVar != null) {
            wVar.u(strArr, str);
        }
    }

    private void onWiFiToCellStateChanged(int i, int i2) {
        com.ttnet.org.chromium.net.w wVar = this.E;
        if (wVar != null) {
            wVar.i(i, i2);
        }
    }

    private boolean handleApiSample(String str, String str2) {
        com.ttnet.org.chromium.net.x xVar = this.D;
        if (xVar != null) {
            return xVar.b(str, str2);
        }
        return false;
    }

    Map<String, String> o0(String str, Map<String, String> map) {
        com.ttnet.org.chromium.net.w wVar = this.E;
        if (wVar == null) {
            return null;
        }
        return wVar.a(str, map);
    }

    private void onPublicIPsChanged(String[] strArr, String[] strArr2) {
        if (this.E != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            ArrayList arrayList2 = new ArrayList(strArr2.length);
            Collections.addAll(arrayList, strArr);
            Collections.addAll(arrayList2, strArr2);
            this.E.n(arrayList, arrayList2);
        }
    }

    private static void r0(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (RejectedExecutionException e2) {
            com.ttnet.org.chromium.base.h.b(Q, "Exception posting task to executor", e2);
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void M(String str, String str2) {
        synchronized (this.b) {
            h.K().u(this.e, this, str, str2);
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void P(String[] strArr, int i) {
        synchronized (this.b) {
            e0();
            h.K().e(this.e, this, strArr, i);
        }
    }

    private void onDropReasonChanged(boolean z, int[] iArr) {
        if (this.E != null) {
            List<Integer> arrayList = new ArrayList<>();
            if (iArr != null) {
                arrayList = (List) Arrays.stream(iArr).boxed().collect(Collectors.toList());
            }
            this.E.f(z, arrayList);
        }
    }

    private String[] addSecurityFactor(String str, String[] strArr) {
        HashMap hashMap = new HashMap();
        int i = 0;
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            hashMap.put(strArr[i2].toLowerCase(Locale.US), strArr[i2 + 1]);
        }
        Map<String, String> o0 = o0(str, hashMap);
        if (o0 == null) {
            return null;
        }
        String[] strArr2 = new String[o0.size() * 2];
        for (Map.Entry<String, String> entry : o0.entrySet()) {
            strArr2[i] = entry.getKey();
            strArr2[i + 1] = entry.getValue();
            i += 2;
        }
        return strArr2;
    }

    private void onTNCConfigChanged(String str, String str2, String str3) {
        com.ttnet.org.chromium.net.w wVar = this.E;
        if (wVar != null) {
            wVar.r(str, str2, str3);
        }
    }

    private void onTNCRequestSucceeded(boolean z, boolean z2, int i) {
        com.ttnet.org.chromium.net.w wVar = this.E;
        if (wVar != null) {
            wVar.x(z, z2, i);
        }
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase, com.ttnet.org.chromium.net.f, com.ttnet.org.chromium.net.c
    public /* bridge */ /* synthetic */ g0.a c(String str, g0.b bVar, Executor executor) {
        return super.c(str, bVar, executor);
    }

    private void onGroupRTTOrThroughputEstimatesComputed(String[] strArr, int[] iArr, int[] iArr2) {
        synchronized (this.h) {
            this.v = strArr;
            this.w = iArr;
            this.x = iArr2;
        }
    }

    private void onNetworkQualityRttAndThroughputNotified(int i, int i2, int i3) {
        synchronized (this.q) {
            this.s = i;
            this.t = i2;
            this.u = i3;
            com.ttnet.org.chromium.net.w wVar = this.E;
            if (wVar != null) {
                wVar.k(i, i2, i3);
            }
        }
    }

    private void onRTTOrThroughputEstimatesComputed(int i, int i2, int i3) {
        synchronized (this.h) {
            this.k = i;
            this.l = i2;
            this.m = i3;
            com.ttnet.org.chromium.net.w wVar = this.E;
            if (wVar != null) {
                wVar.o(i, i2, i3);
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void C(String str, int i, Map<String, String> map) {
        synchronized (this.b) {
            e0();
            h.K().z(this.e, this, str, i, f0(map));
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void O(String[] strArr, int i, long j) {
        synchronized (this.b) {
            e0();
            h.K().v(this.e, this, strArr, i, j);
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void S(String[] strArr, int i, int i2) {
        synchronized (this.b) {
            h.K().y(this.e, this, strArr, i, i2);
        }
    }

    private void onRttObservation(int i, long j, int i2) {
        synchronized (this.h) {
            Iterator<VersionSafeCallbacks.c> it2 = this.n.iterator();
            while (it2.hasNext()) {
                VersionSafeCallbacks.c next = it2.next();
                r0(next.a(), new c(next, i, j, i2));
            }
        }
    }

    private void onThroughputObservation(int i, long j, int i2) {
        synchronized (this.h) {
            Iterator<VersionSafeCallbacks.d> it2 = this.o.iterator();
            while (it2.hasNext()) {
                VersionSafeCallbacks.d next = it2.next();
                r0(next.a(), new d(next, i, j, i2));
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.c
    public URLConnection e(URL url, Proxy proxy, boolean z) {
        if (proxy.type() == Proxy.Type.DIRECT) {
            String protocol = url.getProtocol();
            if (!"http".equals(protocol) && !"https".equals(protocol)) {
                throw new UnsupportedOperationException("Unexpected protocol:" + protocol);
            }
            return new CronetHttpURLConnection(url, this, z);
        }
        throw new UnsupportedOperationException();
    }

    String onRequestInterceptorToStart(String str, String[] strArr, String[] strArr2) {
        if (this.E == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < strArr.length; i += 2) {
            hashMap.put(strArr[i].toLowerCase(Locale.US), strArr[i + 1]);
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr2) {
            arrayList.add(str2);
        }
        return this.E.p(str, hashMap, arrayList);
    }

    @Override // com.ttnet.org.chromium.net.f
    public Map<String, String> U(String str, int i, boolean z) throws IOException {
        URLDispatch uRLDispatch = new URLDispatch(str);
        synchronized (this.b) {
            e0();
            h.K().a(this.e, this, uRLDispatch, str, z);
        }
        uRLDispatch.c(i);
        HashMap hashMap = new HashMap();
        hashMap.put("final_url", uRLDispatch.b);
        hashMap.put("epoch", uRLDispatch.c);
        hashMap.put("etag", uRLDispatch.d);
        hashMap.put("ttnet_origin_host", uRLDispatch.e);
        return hashMap;
    }

    String onResponseInterceptorToStart(String str, String[] strArr, int i) {
        if (this.E == null) {
            return null;
        }
        ArrayList<Map.Entry> arrayList = new ArrayList();
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            arrayList.add(new AbstractMap.SimpleImmutableEntry(strArr[i2].toLowerCase(Locale.US), strArr[i2 + 1]));
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry entry : arrayList) {
            ArrayList arrayList2 = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList2.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList2.add((String) entry.getValue());
            treeMap.put((String) entry.getKey(), Collections.unmodifiableList(arrayList2));
        }
        return this.E.q(str, treeMap, i);
    }

    @Override // com.ttnet.org.chromium.net.f
    public void T(String str, int i, String str2, Map<String, String> map) {
        synchronized (this.b) {
            h.K().o(this.e, this, str, i, str2, f0(map));
        }
    }

    private void onUrlDispatchComplete(URLDispatch uRLDispatch, String str, String str2, String str3, String str4) {
        uRLDispatch.setResult(str, str2, str3, str4);
        uRLDispatch.b(new b(uRLDispatch));
    }

    @Override // com.ttnet.org.chromium.net.f
    public void f(String[] strArr, byte[] bArr, byte[] bArr2, long j, long j2) {
        synchronized (this.b) {
            h.K().n(this.e, this, strArr, bArr, bArr2, j, j2);
        }
    }

    private void onPacketLossComputed(int i, double d2, double d3, double d4, double d5) {
        synchronized (this.h) {
            if (i != 0 && i != 1) {
                com.ttnet.org.chromium.base.h.b(Q, "Error protocol from native. Protocol: " + i, new Object[0]);
                return;
            }
            this.y[i] = d2;
            this.z[i] = d3;
            this.A[i] = d4;
            this.B[i] = d5;
            com.ttnet.org.chromium.net.w wVar = this.E;
            if (wVar != null) {
                wVar.m(i, d2, d3, d4, d5);
            }
        }
    }

    private void onStoreIdcChanged(String str, String str2, String str3, String str4, String str5, String str6) {
        com.ttnet.org.chromium.net.w wVar = this.E;
        if (wVar != null) {
            wVar.s(str, str2, str3, str4, str5, str6);
        }
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public c0 Z(c0.b bVar, Executor executor, List<String> list, Map<String, String> map, Map<String, String> map2, boolean z) {
        return new CronetWebsocketConnection(this, bVar, executor, list, map, map2, z);
    }

    @Override // com.ttnet.org.chromium.net.f
    public void B(String str, String str2, String str3, String str4, String str5, String str6) {
        synchronized (this.b) {
            h.K().G(this.e, this, str, str2, str3, str4, str5, str6);
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void k(boolean z, String str, String str2, String str3, boolean z2, String str4) {
        synchronized (this.b) {
            h.K().j(this.e, this, z, str, str2, str3, z2, str4);
        }
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    protected com.ttnet.org.chromium.net.z W(z.b bVar, Executor executor, int i, List<String> list, int i2, int i3, int i4) {
        return new TTCronetNetExpRequest(this, bVar, executor, i, list, i2, i3, i4);
    }

    private void onTTDnsResolveResult(String str, String str2, int i, int i2, int i3, String[] strArr, String str3) {
        com.ttnet.org.chromium.base.h.a(Q, " onTTDnsResolveResult, uuid: " + str + " host: " + str2 + " ret: " + i + " ips: " + strArr.length, new Object[0]);
        ArrayList arrayList = new ArrayList(strArr.length);
        Collections.addAll(arrayList, strArr);
        com.ttnet.org.chromium.net.w wVar = this.E;
        if (wVar != null) {
            wVar.v(str, str2, i, i2, i3, arrayList, str3);
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void N(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        synchronized (this.b) {
            try {
                try {
                    e0();
                    h.K().m(this.e, this, j, j2, j3, j4, j5, j6, j7, j8);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.f
    public void V(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        synchronized (this.b) {
            try {
                try {
                    h.K().D(this.e, this, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public c0 Y(c0.b bVar, Executor executor, List<String> list, int i, String str, long j, int i2, long j2, String str2, int i3, String str3, Map<String, String> map, Map<String, String> map2, boolean z) {
        return new CronetWebsocketConnection(this, bVar, executor, list, i, str, j, i2, j2, str2, i3, str3, map, map2, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public UrlRequestBase X(String str, g0.b bVar, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, t.a aVar, int i4, long j) {
        long j2;
        if (j == -1) {
            j2 = this.M;
        } else {
            j2 = j;
        }
        synchronized (this.b) {
            try {
                try {
                    e0();
                    return new CronetUrlRequest(this, str, i, bVar, executor, collection, z, z2, z3, z4, i2, z5, i3, aVar, i4, j2);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    private void onContextInitCompleted(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, String str, String str2) {
        u.e = str;
        u.f = str2;
        this.c.open();
        com.ttnet.org.chromium.net.w wVar = this.E;
        if (wVar != null) {
            wVar.d(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16);
        }
    }

    private void handleApiResult(boolean z, String str, String str2, String str3, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, boolean z2, long j11, long j12, String str4, String str5, String str6, int i, int i2, String str7) {
        com.ttnet.org.chromium.net.x xVar = this.D;
        if (xVar != null) {
            xVar.a(z, str, str2, str3, j, j2, j3, j4, j5, j6, j7, j8, j9, j10, z2, j11, j12, str4, str5, str6, i, i2, str7);
        }
    }
}
