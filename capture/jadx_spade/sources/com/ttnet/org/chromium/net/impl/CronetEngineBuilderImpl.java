package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider$TTSlaSamplingSetting;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider$ThreadConfigInfo;
import com.ttnet.org.chromium.net.b0;
import com.ttnet.org.chromium.net.c;
import com.ttnet.org.chromium.net.impl.VersionSafeCallbacks;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class CronetEngineBuilderImpl extends com.ttnet.org.chromium.net.h {
    private static final Pattern T;
    private static String U;
    public boolean A;
    public boolean B;
    public long C;
    public String D;
    public boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public String I;
    public TTAppInfoProvider.AppInfo J;
    public boolean K;
    public boolean L;
    public boolean M;
    public long N;
    public ArrayList<TTThreadConfigInfoProvider$ThreadConfigInfo> O;
    public b0 P;
    public TTSamplingSettingProvider$TTSlaSamplingSetting Q;
    public boolean R;
    public String S;
    private final Context a;
    public boolean d;
    public String e;
    public String f;
    public boolean g;
    public boolean h;
    public boolean i;
    private HttpCacheMode j;
    public long k;
    public String l;
    public long m;
    public boolean n;
    public boolean p;
    public boolean q;
    public TTAppInfoProvider r;
    public com.ttnet.org.chromium.net.x s;
    public com.ttnet.org.chromium.net.w t;
    public String u;
    public ArrayList<byte[]> v;
    public Map<String[], Pair<byte[], byte[]>> w;
    public String x;
    public String y;
    public String z;
    public final List<c> b = new LinkedList();
    public final List<b> c = new LinkedList();
    private int o = 20;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpCacheSetting {
    }

    public static class b {
        final String a;
        final byte[][] b;
        final boolean c;
        final Date d;

        static {
            Covode.recordClassIndex(654584);
        }
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl k() {
        this.q = true;
        return this;
    }

    VersionSafeCallbacks.b c0() {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl x(c.a.b bVar) {
        return this;
    }

    enum HttpCacheMode {
        DISABLED(0, false),
        DISK(1, true),
        DISK_NO_HTTP(1, false),
        MEMORY(2, true);

        private final boolean mContentCacheEnabled;
        private final int mType;

        int getType() {
            return this.mType;
        }

        boolean isContentCacheEnabled() {
            return this.mContentCacheEnabled;
        }

        int toPublicBuilderCacheMode() {
            int i = a.a[ordinal()];
            if (i != 1) {
                int i2 = 2;
                if (i != 2) {
                    i2 = 3;
                    if (i != 3) {
                        if (i == 4) {
                            return 1;
                        }
                        throw new IllegalArgumentException("Unknown internal builder cache mode");
                    }
                }
                return i2;
            }
            return 0;
        }

        static {
            Covode.recordClassIndex(654582);
        }

        static HttpCacheMode fromPublicBuilderCacheMode(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return DISK;
                        }
                        throw new IllegalArgumentException("Unknown public builder cache mode");
                    }
                    return DISK_NO_HTTP;
                }
                return MEMORY;
            }
            return DISABLED;
        }

        HttpCacheMode(int i, boolean z) {
            this.mContentCacheEnabled = z;
            this.mType = i;
        }
    }

    Context getContext() {
        return this.a;
    }

    public String a0() {
        return a0.d(this.a);
    }

    int b0() {
        return this.j.getType();
    }

    int e0() {
        return this.j.toPublicBuilderCacheMode();
    }

    static {
        Covode.recordClassIndex(654581);
        T = Pattern.compile("^[0-9\\.]*$");
    }

    boolean O() {
        return !this.j.isContentCacheEnabled();
    }

    String Z() {
        if (this.g) {
            return a0.e(this.a);
        }
        return "";
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[HttpCacheMode.values().length];
            a = iArr;
            try {
                iArr[HttpCacheMode.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[HttpCacheMode.DISK_NO_HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[HttpCacheMode.DISK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[HttpCacheMode.MEMORY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl I(long j) {
        this.N = j;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl J(b0 b0Var) {
        this.P = b0Var;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl K(ArrayList<TTThreadConfigInfoProvider$ThreadConfigInfo> arrayList) {
        this.O = arrayList;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl M(String str) {
        this.e = str;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl c(boolean z) {
        this.A = z;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl d(boolean z) {
        this.i = z;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl e(boolean z) {
        this.h = z;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl g(boolean z) {
        this.p = z;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl h(boolean z) {
        this.n = z;
        return this;
    }

    public CronetEngineBuilderImpl V(boolean z) {
        this.d = z;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl i(boolean z) {
        this.g = z;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl j(boolean z) {
        this.B = z;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl l(boolean z) {
        this.E = z;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl m(long j) {
        this.C = j;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl n(TTAppInfoProvider tTAppInfoProvider) {
        this.r = tTAppInfoProvider;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl o(com.ttnet.org.chromium.net.x xVar) {
        this.s = xVar;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl p(int i) {
        this.F = i;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl q(String str) {
        this.x = str;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl r(Map<String[], Pair<byte[], byte[]>> map) {
        this.w = map;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl t(com.ttnet.org.chromium.net.w wVar) {
        this.t = wVar;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl u(String str) {
        this.u = str;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl v(boolean z) {
        this.G = z;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl w(boolean z) {
        this.H = z;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl y(ArrayList<byte[]> arrayList) {
        this.v = arrayList;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl z(boolean z) {
        this.K = z;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    public com.ttnet.org.chromium.net.h s(String str) {
        this.D = str;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl B(String str) {
        this.I = str;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl C(String str) {
        this.z = str;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl D(TTSamplingSettingProvider$TTSlaSamplingSetting tTSamplingSettingProvider$TTSlaSamplingSetting) {
        this.Q = tTSamplingSettingProvider$TTSlaSamplingSetting;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl G(String str) {
        this.y = str;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl H(TTAppInfoProvider.AppInfo appInfo) {
        this.J = appInfo;
        return this;
    }

    int F0(int i) {
        int i2 = this.o;
        if (i2 != 20) {
            return i2;
        }
        return i;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl L(int i) {
        if (i <= 19 && i >= -20) {
            this.o = i;
            return this;
        }
        throw new IllegalArgumentException("Thread priority invalid");
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl F(String str) {
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
        if (!polarisFileWrapper.exists() && !polarisFileWrapper.mkdirs()) {
            throw new IllegalArgumentException("create Storage path failed");
        }
        if (polarisFileWrapper.isDirectory()) {
            this.f = str;
            return this;
        }
        throw new IllegalArgumentException("Storage path must be set to existing directory");
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl A(boolean z, boolean z2) {
        this.L = z;
        this.M = z2;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl E(boolean z, String str) {
        this.R = z;
        this.S = str;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl f(int i, long j) {
        HttpCacheMode fromPublicBuilderCacheMode = HttpCacheMode.fromPublicBuilderCacheMode(i);
        if (fromPublicBuilderCacheMode.getType() == 1 && this.f == null) {
            throw new IllegalArgumentException("Storage path must be set");
        }
        this.j = fromPublicBuilderCacheMode;
        this.k = j;
        return this;
    }

    public CronetEngineBuilderImpl(Context context, boolean z) {
        this.a = context.getApplicationContext();
        i(true);
        e(true);
        d(false);
        f(0, 0L);
        h(false);
        V(true);
        g(false);
        l(false);
        if (!z) {
            U = CronetEngineBuilderImpl.class.getSimpleName();
        } else {
            U = "CronetEngineBuilderImpl";
        }
    }

    public static class c {
        final String a;
        final int b;
        final int c;

        static {
            Covode.recordClassIndex(654585);
        }

        c(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }
    }

    @Override // com.ttnet.org.chromium.net.h
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public CronetEngineBuilderImpl a(String str, int i, int i2) {
        if (!str.contains("/")) {
            this.b.add(new c(str, i, i2));
            return this;
        }
        throw new IllegalArgumentException("Illegal QUIC Hint Host: " + str);
    }
}
