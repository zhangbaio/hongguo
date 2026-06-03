package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.NetworkChangeNotifier;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class k implements NetworkChangeNotifier.d {
    public static final com.ttnet.org.chromium.base.g<NetworkChangeNotifier.d> a;

    class a implements com.ttnet.org.chromium.base.g<NetworkChangeNotifier.d> {
        a() {
        }
    }

    k() {
    }

    static {
        Covode.recordClassIndex(654494);
        a = new a();
    }

    public static NetworkChangeNotifier.d h() {
        com.ttnet.org.chromium.base.j.a(false);
        return new k();
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.d
    public void a(long j, NetworkChangeNotifier networkChangeNotifier, long[] jArr) {
        wj6.a.J(j, networkChangeNotifier, jArr);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.d
    public void c(long j, NetworkChangeNotifier networkChangeNotifier, int i) {
        wj6.a.F(j, networkChangeNotifier, i);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.d
    public void d(long j, NetworkChangeNotifier networkChangeNotifier, int i) {
        wj6.a.D(j, networkChangeNotifier, i);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.d
    public void f(long j, NetworkChangeNotifier networkChangeNotifier, long j2) {
        wj6.a.I(j, networkChangeNotifier, j2);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.d
    public void b(long j, NetworkChangeNotifier networkChangeNotifier, boolean z, long j2) {
        wj6.a.H(j, networkChangeNotifier, z, j2);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.d
    public void e(long j, NetworkChangeNotifier networkChangeNotifier, int i, long j2) {
        wj6.a.E(j, networkChangeNotifier, i, j2);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.d
    public void g(long j, NetworkChangeNotifier networkChangeNotifier, long j2, boolean z, int i) {
        wj6.a.G(j, networkChangeNotifier, j2, z, i);
    }
}
