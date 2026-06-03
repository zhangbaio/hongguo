package com.ttnet.org.chromium.net;

import android.net.ConnectivityManager;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;

@JNINamespace("net")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class NetworkActiveNotifier implements ConnectivityManager.OnNetworkActiveListener {
    private final ConnectivityManager a = (ConnectivityManager) com.ttnet.org.chromium.base.c.f().getSystemService("connectivity");
    private final long b;
    private boolean c;

    interface a {
        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void a(long j);
    }

    static {
        Covode.recordClassIndex(654478);
    }

    public void fakeDefaultNetworkActive() {
        if (this.c) {
            onNetworkActive();
        }
    }

    public boolean isDefaultNetworkActive() {
        return this.a.isDefaultNetworkActive();
    }

    public void disableNotifications() {
        this.c = false;
        this.a.removeDefaultNetworkActiveListener(this);
    }

    public void enableNotifications() {
        this.c = true;
        this.a.addDefaultNetworkActiveListener(this);
    }

    @Override // android.net.ConnectivityManager.OnNetworkActiveListener
    public void onNetworkActive() {
        i.b().a(this.b);
    }

    public static NetworkActiveNotifier build(long j) {
        return new NetworkActiveNotifier(j);
    }

    private NetworkActiveNotifier(long j) {
        this.b = j;
    }
}
