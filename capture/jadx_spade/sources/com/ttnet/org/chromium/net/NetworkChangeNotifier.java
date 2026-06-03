package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect;
import java.util.ArrayList;
import java.util.Iterator;

@JNINamespace("net")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class NetworkChangeNotifier {
    private static NetworkChangeNotifier f;
    private NetworkChangeNotifierAutoDetect c;
    private int d = 0;
    private int e = 0;
    private final ArrayList<Long> a = new ArrayList<>();
    private final com.ttnet.org.chromium.base.k<c> b = new com.ttnet.org.chromium.base.k<>();

    public interface c {
        void a(int i);
    }

    interface d {
        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void a(long j, NetworkChangeNotifier networkChangeNotifier, long[] jArr);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void b(long j, NetworkChangeNotifier networkChangeNotifier, boolean z, long j2);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void c(long j, NetworkChangeNotifier networkChangeNotifier, int i);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void d(long j, NetworkChangeNotifier networkChangeNotifier, int i);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void e(long j, NetworkChangeNotifier networkChangeNotifier, int i, long j2);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void f(long j, NetworkChangeNotifier networkChangeNotifier, long j2);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void g(long j, NetworkChangeNotifier networkChangeNotifier, long j2, boolean z, int i);
    }

    public static NetworkChangeNotifier f() {
        return f;
    }

    public int getCurrentConnectionCost() {
        return this.e;
    }

    public int getCurrentConnectionType() {
        return this.d;
    }

    public static void forceUpdateNetworkTypeInfo() {
        f().e();
    }

    class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            NetworkChangeNotifier networkChangeNotifier = NetworkChangeNotifier.this;
            networkChangeNotifier.i(networkChangeNotifier.d);
        }

        b() {
        }
    }

    static {
        Covode.recordClassIndex(654481);
    }

    private void c() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.c;
        if (networkChangeNotifierAutoDetect != null) {
            networkChangeNotifierAutoDetect.s();
            this.c = null;
        }
    }

    public static NetworkChangeNotifier init() {
        if (f == null) {
            f = new NetworkChangeNotifier();
        }
        return f;
    }

    public static void o() {
        f().p(true, new r());
    }

    public int getCurrentConnectionSubtype() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.c;
        if (networkChangeNotifierAutoDetect == null) {
            return 0;
        }
        return networkChangeNotifierAutoDetect.u().b();
    }

    public long getCurrentDefaultNetId() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.c;
        if (networkChangeNotifierAutoDetect == null) {
            return -1L;
        }
        return networkChangeNotifierAutoDetect.v();
    }

    public long[] getCurrentNetworksAndTypes() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.c;
        if (networkChangeNotifierAutoDetect == null) {
            return new long[0];
        }
        return networkChangeNotifierAutoDetect.w();
    }

    public long getCurrentVpnNetId() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.c;
        if (networkChangeNotifierAutoDetect == null) {
            return -1L;
        }
        return networkChangeNotifierAutoDetect.x();
    }

    public boolean registerNetworkCallbackFailed() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.c;
        if (networkChangeNotifierAutoDetect == null) {
            return false;
        }
        return networkChangeNotifierAutoDetect.o;
    }

    protected NetworkChangeNotifier() {
    }

    private void e() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.c;
        if (networkChangeNotifierAutoDetect != null) {
            NetworkChangeNotifierAutoDetect.f u = networkChangeNotifierAutoDetect.u();
            if (this.d != u.c()) {
                this.d = u.c();
                this.c.C(new b());
            }
        }
    }

    class a implements NetworkChangeNotifierAutoDetect.g {
        a() {
        }

        @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.g
        public void a(int i) {
            NetworkChangeNotifier.this.r(i);
        }

        @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.g
        public void c(long j) {
            NetworkChangeNotifier.this.m(j);
        }

        @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.g
        public void d(int i) {
            NetworkChangeNotifier.this.h(i);
        }

        @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.g
        public void e(int i) {
            NetworkChangeNotifier.this.g(i);
        }

        @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.g
        public void g(long[] jArr) {
            NetworkChangeNotifier.this.n(jArr);
        }

        @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.g
        public void b(long j, boolean z) {
            NetworkChangeNotifier.this.l(j, z);
        }

        @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.g
        public void f(long j, int i, boolean z) {
            NetworkChangeNotifier.this.k(j, i, z);
        }
    }

    private void q(int i) {
        this.e = i;
        g(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i) {
        this.d = i;
        i(i);
    }

    void i(int i) {
        j(i, getCurrentDefaultNetId());
    }

    public static void fakeConnectionCostChanged(int i) {
        setAutoDetectConnectivityState(false);
        f().g(i);
    }

    public static void fakeConnectionSubtypeChanged(int i) {
        setAutoDetectConnectivityState(false);
        f().h(i);
    }

    public static void fakeNetworkDisconnected(long j) {
        setAutoDetectConnectivityState(false);
        f().l(j, false);
    }

    public static void fakeNetworkSoonToBeDisconnected(long j) {
        setAutoDetectConnectivityState(false);
        f().m(j);
    }

    public static void fakePurgeActiveNetworkList(long[] jArr) {
        setAutoDetectConnectivityState(false);
        f().n(jArr);
    }

    public static void forceConnectivityState(boolean z) {
        setAutoDetectConnectivityState(false);
        f().d(z);
    }

    public static void setAutoDetectConnectivityState(boolean z) {
        f().p(z, new s());
    }

    public void addNativeObserver(long j) {
        this.a.add(Long.valueOf(j));
    }

    public void removeNativeObserver(long j) {
        this.a.remove(Long.valueOf(j));
    }

    private void d(boolean z) {
        boolean z2;
        int i = 0;
        if (this.d != 6) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 != z) {
            if (!z) {
                i = 6;
            }
            r(i);
            h(!z ? 1 : 0);
        }
    }

    void g(int i) {
        Iterator<Long> it2 = this.a.iterator();
        while (it2.hasNext()) {
            k.h().d(it2.next().longValue(), this, i);
        }
    }

    void h(int i) {
        Iterator<Long> it2 = this.a.iterator();
        while (it2.hasNext()) {
            k.h().c(it2.next().longValue(), this, i);
        }
    }

    void n(long[] jArr) {
        Iterator<Long> it2 = this.a.iterator();
        while (it2.hasNext()) {
            k.h().a(it2.next().longValue(), this, jArr);
        }
    }

    void m(long j) {
        Iterator<Long> it2 = this.a.iterator();
        while (it2.hasNext()) {
            k.h().f(it2.next().longValue(), this, j);
        }
    }

    public static void fakeDefaultNetwork(long j, int i) {
        setAutoDetectConnectivityState(false);
        f().j(i, j);
    }

    public static void fakeNetworkConnected(long j, int i) {
        setAutoDetectConnectivityState(false);
        f().k(j, i, false);
    }

    private void j(int i, long j) {
        Iterator<Long> it2 = this.a.iterator();
        while (it2.hasNext()) {
            k.h().e(it2.next().longValue(), this, i, j);
        }
        Iterator<c> it4 = this.b.iterator();
        while (it4.hasNext()) {
            it4.next().a(i);
        }
    }

    private void p(boolean z, NetworkChangeNotifierAutoDetect.h hVar) {
        if (z) {
            if (this.c == null) {
                NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = new NetworkChangeNotifierAutoDetect(new a(), hVar);
                this.c = networkChangeNotifierAutoDetect;
                NetworkChangeNotifierAutoDetect.f u = networkChangeNotifierAutoDetect.u();
                r(u.c());
                q(u.a());
                h(u.b());
                return;
            }
            return;
        }
        c();
    }

    void l(long j, boolean z) {
        Iterator<Long> it2 = this.a.iterator();
        while (it2.hasNext()) {
            k.h().b(it2.next().longValue(), this, z, j);
        }
    }

    void k(long j, int i, boolean z) {
        Iterator<Long> it2 = this.a.iterator();
        while (it2.hasNext()) {
            k.h().g(it2.next().longValue(), this, j, z, i);
        }
    }
}
