package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.c0;
import com.ttnet.org.chromium.net.g0;
import com.ttnet.org.chromium.net.z;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class c {
    private static final String a;

    public abstract y a();

    public abstract z.a b(z.b bVar, Executor executor);

    public abstract g0.a c(String str, g0.b bVar, Executor executor);

    public abstract c0.a d(c0.b bVar, Executor executor);

    public abstract URLConnection e(URL url, Proxy proxy, boolean z) throws IOException;

    public static class a {
        public final h a;

        public static abstract class b {
            static {
                Covode.recordClassIndex(654447);
            }

            public abstract void loadLibrary(String str);
        }

        static {
            Covode.recordClassIndex(654446);
        }

        public a k() {
            this.a.k();
            return this;
        }

        public a A(boolean z) {
            this.a.z(z);
            return this;
        }

        public a C(String str) {
            this.a.B(str);
            return this;
        }

        public a D(String str) {
            this.a.C(str);
            return this;
        }

        public a E(TTSamplingSettingProvider$TTSlaSamplingSetting tTSamplingSettingProvider$TTSlaSamplingSetting) {
            this.a.D(tTSamplingSettingProvider$TTSlaSamplingSetting);
            return this;
        }

        public a G(String str) {
            this.a.F(str);
            return this;
        }

        public a H(String str) {
            this.a.G(str);
            return this;
        }

        public a I(TTAppInfoProvider.AppInfo appInfo) {
            this.a.H(appInfo);
            return this;
        }

        public a J(long j) {
            this.a.I(j);
            return this;
        }

        public a K(b0 b0Var) {
            this.a.J(b0Var);
            return this;
        }

        public a L(ArrayList<TTThreadConfigInfoProvider$ThreadConfigInfo> arrayList) {
            this.a.K(arrayList);
            return this;
        }

        public a M(String str) {
            this.a.M(str);
            return this;
        }

        public a d(boolean z) {
            this.a.c(z);
            return this;
        }

        public a e(boolean z) {
            this.a.d(z);
            return this;
        }

        public a f(boolean z) {
            this.a.e(z);
            return this;
        }

        public a h(boolean z) {
            this.a.g(z);
            return this;
        }

        public a i(boolean z) {
            this.a.i(z);
            return this;
        }

        public a j(boolean z) {
            this.a.j(z);
            return this;
        }

        public a m(boolean z) {
            this.a.l(z);
            return this;
        }

        public a n(long j) {
            this.a.m(j);
            return this;
        }

        public a o(TTAppInfoProvider tTAppInfoProvider) {
            this.a.n(tTAppInfoProvider);
            return this;
        }

        public a p(x xVar) {
            this.a.o(xVar);
            return this;
        }

        public a q(int i) {
            this.a.p(i);
            return this;
        }

        public a r(String str) {
            this.a.q(str);
            return this;
        }

        public a s(Map<String[], Pair<byte[], byte[]>> map) {
            this.a.r(map);
            return this;
        }

        public a t(String str) {
            this.a.s(str);
            return this;
        }

        public a u(w wVar) {
            this.a.t(wVar);
            return this;
        }

        public a v(String str) {
            this.a.u(str);
            return this;
        }

        public a w(boolean z) {
            this.a.v(z);
            return this;
        }

        public a x(boolean z) {
            this.a.w(z);
            return this;
        }

        public a y(b bVar) {
            this.a.x(bVar);
            return this;
        }

        public a z(ArrayList<byte[]> arrayList) {
            this.a.y(arrayList);
            return this;
        }

        public a(h hVar) {
            this.a = hVar;
        }

        public a(Context context, boolean z) {
            this(c(context, z));
        }

        public a B(boolean z, boolean z2) {
            this.a.A(z, z2);
            return this;
        }

        public a F(boolean z, String str) {
            this.a.E(z, str);
            return this;
        }

        public a g(int i, long j) {
            this.a.f(i, j);
            return this;
        }

        /* renamed from: com.ttnet.org.chromium.net.c$a$a, reason: collision with other inner class name */
        class C0120a implements Comparator<d> {
            C0120a() {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(d dVar, d dVar2) {
                if ("Fallback-Cronet-Provider".equals(dVar.d())) {
                    return 1;
                }
                if ("Fallback-Cronet-Provider".equals(dVar2.d())) {
                    return -1;
                }
                return -a.b(dVar.e(), dVar2.e());
            }
        }

        private static h c(Context context, boolean z) {
            d dVar = l(context, new ArrayList(d.c(context))).get(0);
            if (Log.isLoggable("CronetEngine.Builder", 3)) {
                Log.d("CronetEngine.Builder", String.format("Using '%s' provider for creating CronetEngine.Builder.", dVar));
            }
            return dVar.b(z).a;
        }

        static List<d> l(Context context, List<d> list) {
            if (list.size() != 0) {
                Iterator<d> it2 = list.iterator();
                while (it2.hasNext()) {
                    if (!it2.next().f()) {
                        it2.remove();
                    }
                }
                if (list.size() != 0) {
                    Collections.sort(list, new C0120a());
                    return list;
                }
                throw new RuntimeException("All available Cronet providers are disabled. A provider should be enabled before it can be used.");
            }
            throw new RuntimeException("Unable to find any Cronet provider. Have you included all necessary jars?");
        }

        static int b(String str, String str2) {
            if (str != null && str2 != null) {
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                for (int i = 0; i < split.length && i < split2.length; i++) {
                    try {
                        int parseInt = Integer.parseInt(split[i]);
                        int parseInt2 = Integer.parseInt(split2[i]);
                        if (parseInt != parseInt2) {
                            return Integer.signum(parseInt - parseInt2);
                        }
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Unable to convert version segments into integers: " + split[i] + " & " + split2[i], e);
                    }
                }
                return Integer.signum(split.length - split2.length);
            }
            throw new IllegalArgumentException("The input values cannot be null");
        }

        public a a(String str, int i, int i2) {
            this.a.a(str, i, i2);
            return this;
        }
    }

    static {
        Covode.recordClassIndex(654445);
        a = c.class.getSimpleName();
    }
}
