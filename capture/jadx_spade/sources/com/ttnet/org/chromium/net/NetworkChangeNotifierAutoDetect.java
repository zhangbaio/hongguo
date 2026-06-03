package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.dragon.read.base.util.LogWrapper;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.TraceEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class NetworkChangeNotifierAutoDetect extends BroadcastReceiver {
    private static final String p;
    private final Looper a;
    private final Handler b;
    private final NetworkConnectivityIntentFilter c;
    private final g d;
    public final h e;
    private ConnectivityManager.NetworkCallback f;
    public c g;
    public i h;
    private e i;
    private NetworkRequest j;
    public boolean k;
    private f l;
    private boolean m;
    private boolean n;
    public boolean o;

    public interface g {
        void a(int i);

        void b(long j, boolean z);

        void c(long j);

        void d(int i);

        void e(int i);

        void f(long j, int i, boolean z);

        void g(long[] jArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int r(int i2, int i3) {
        if (i2 != 0) {
            if (i2 == 1) {
                return 2;
            }
            if (i2 != 4 && i2 != 5) {
                if (i2 == 6) {
                    return 5;
                }
                if (i2 != 7) {
                    return i2 != 9 ? 0 : 1;
                }
                return 7;
            }
        }
        if (i3 == 20) {
            return 8;
        }
        switch (i3) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 3;
            case 3:
            case 5:
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
            case 9:
            case 10:
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
            case 14:
            case 15:
                return 4;
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return 5;
            default:
                return 0;
        }
    }

    public static class f {
        public final boolean a;
        public final int b;
        public final int c;
        public final boolean d;
        public final String e;
        public final List<InetAddress> f;
        public final boolean g;
        public final String h;

        static {
            Covode.recordClassIndex(654490);
        }

        public int a() {
            if (this.d) {
                return 2;
            }
            return 1;
        }

        public int c() {
            if (!this.a) {
                return 6;
            }
            return NetworkChangeNotifierAutoDetect.r(this.b, this.c);
        }

        public int b() {
            if (!this.a) {
                return 1;
            }
            int i = this.b;
            if (i == 0 || i == 4 || i == 5) {
                switch (this.c) {
                }
                return 0;
            }
            return 0;
        }

        public f(boolean z, int i, int i2, boolean z2, String str, List<InetAddress> list, boolean z3, String str2) {
            this.a = z;
            this.b = i;
            this.c = i2;
            this.d = z2;
            this.e = str == null ? "" : str;
            this.f = list == null ? new ArrayList<>() : list;
            this.g = z3;
            this.h = str2 == null ? "" : str2;
        }
    }

    public static abstract class h {
        private NetworkChangeNotifierAutoDetect a;

        protected abstract void a();

        protected final void c() {
            this.a.B();
        }

        protected final void d() {
            this.a.D();
        }

        static {
            Covode.recordClassIndex(654492);
        }

        protected void b(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
            this.a = networkChangeNotifierAutoDetect;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        q(u());
    }

    private class e extends ConnectivityManager.NetworkCallback {
        private Network a;

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            b(this, network);
        }

        class c implements Runnable {
            final /* synthetic */ long a;

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.this.d.c(this.a);
            }

            c(long j) {
                this.a = j;
            }
        }

        /* renamed from: com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$e$e, reason: collision with other inner class name */
        class RunnableC0118e implements Runnable {
            final /* synthetic */ int a;

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.this.d.a(this.a);
            }

            RunnableC0118e(int i) {
                this.a = i;
            }
        }

        static {
            Covode.recordClassIndex(654488);
        }

        public long c() {
            Network network = this.a;
            if (network == null) {
                return -1L;
            }
            return NetworkChangeNotifierAutoDetect.z(network);
        }

        class b implements Runnable {
            final /* synthetic */ long a;
            final /* synthetic */ int b;
            final /* synthetic */ boolean c;

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.this.d.f(this.a, this.b, this.c);
            }

            b(long j, int i, boolean z) {
                this.a = j;
                this.b = i;
                this.c = z;
            }
        }

        class d implements Runnable {
            final /* synthetic */ Network a;
            final /* synthetic */ boolean b;

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.this.d.b(NetworkChangeNotifierAutoDetect.z(this.a), this.b);
            }

            d(Network network, boolean z) {
                this.a = network;
                this.b = z;
            }
        }

        class a implements Runnable {
            final /* synthetic */ long a;
            final /* synthetic */ int b;
            final /* synthetic */ boolean c;

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.this.d.f(this.a, this.b, this.c);
                if (this.c) {
                    NetworkChangeNotifierAutoDetect.this.d.a(this.b);
                    NetworkChangeNotifierAutoDetect.this.d.g(new long[]{this.a});
                }
            }

            a(long j, int i, boolean z) {
                this.a = j;
                this.b = i;
                this.c = z;
            }
        }

        void g() {
            NetworkCapabilities d2;
            Network[] t = NetworkChangeNotifierAutoDetect.t(NetworkChangeNotifierAutoDetect.this.g, null);
            this.a = null;
            if (t.length == 1 && (d2 = NetworkChangeNotifierAutoDetect.this.g.d(t[0])) != null && d2.hasTransport(4)) {
                this.a = t[0];
            }
        }

        private e() {
        }

        private boolean f(Network network) {
            Network network2 = this.a;
            if (network2 != null && !network2.equals(network)) {
                return true;
            }
            return false;
        }

        public void a(Network network) {
            boolean z;
            Network network2;
            TraceEvent k = TraceEvent.k("NetworkChangeNotifierCallback::onAvailable");
            try {
                NetworkCapabilities d2 = NetworkChangeNotifierAutoDetect.this.g.d(network);
                if (e(network, d2)) {
                    if (k != null) {
                        k.close();
                        return;
                    }
                    return;
                }
                boolean z2 = false;
                if (d2 != null) {
                    if (d2.hasTransport(4) && ((network2 = this.a) == null || !network.equals(network2))) {
                        z2 = true;
                    }
                    z = z2;
                } else {
                    z = false;
                }
                if (z) {
                    this.a = network;
                }
                NetworkChangeNotifierAutoDetect.this.C(new a(NetworkChangeNotifierAutoDetect.z(network), NetworkChangeNotifierAutoDetect.this.g.b(network), z));
                if (k != null) {
                    k.close();
                }
            } catch (Throwable th) {
                if (k != null) {
                    try {
                        k.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            boolean z;
            TraceEvent k = TraceEvent.k("NetworkChangeNotifierCallback::onLost");
            try {
                if (f(network)) {
                    if (k != null) {
                        k.close();
                        return;
                    }
                    return;
                }
                Network network2 = this.a;
                if (network2 != null && network2.equals(network)) {
                    z = true;
                } else {
                    z = false;
                }
                NetworkChangeNotifierAutoDetect.this.C(new d(network, z));
                if (this.a != null) {
                    this.a = null;
                    for (Network network3 : NetworkChangeNotifierAutoDetect.t(NetworkChangeNotifierAutoDetect.this.g, network)) {
                        onAvailable(network3);
                    }
                    NetworkChangeNotifierAutoDetect.this.C(new RunnableC0118e(NetworkChangeNotifierAutoDetect.this.u().c()));
                }
                if (k != null) {
                    k.close();
                }
            } catch (Throwable th) {
                if (k != null) {
                    try {
                        k.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        /* synthetic */ e(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect, a aVar) {
            this();
        }

        @TargetClass("com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$MyNetworkCallback")
        @Insert("onAvailable")
        public static void b(e eVar, Network network) {
            try {
                eVar.a(network);
            } catch (Throwable th) {
                LogWrapper.e("onAvailable throwable:%s", new Object[]{Log.getStackTraceString(th)});
            }
        }

        private boolean e(Network network, NetworkCapabilities networkCapabilities) {
            if (!f(network) && !d(network, networkCapabilities)) {
                return false;
            }
            return true;
        }

        private boolean d(Network network, NetworkCapabilities networkCapabilities) {
            if (networkCapabilities == null) {
                networkCapabilities = NetworkChangeNotifierAutoDetect.this.g.d(network);
            }
            if (networkCapabilities != null && (!networkCapabilities.hasTransport(4) || NetworkChangeNotifierAutoDetect.this.g.l(network))) {
                return false;
            }
            return true;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i) {
            TraceEvent k = TraceEvent.k("NetworkChangeNotifierCallback::onLosing");
            try {
                if (e(network, null)) {
                    if (k != null) {
                        k.close();
                    }
                } else {
                    NetworkChangeNotifierAutoDetect.this.C(new c(NetworkChangeNotifierAutoDetect.z(network)));
                    if (k != null) {
                        k.close();
                    }
                }
            } catch (Throwable th) {
                if (k != null) {
                    try {
                        k.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            boolean z;
            TraceEvent k = TraceEvent.k("NetworkChangeNotifierCallback::onCapabilitiesChanged");
            try {
                if (e(network, networkCapabilities)) {
                    if (k != null) {
                        k.close();
                        return;
                    }
                    return;
                }
                long z2 = NetworkChangeNotifierAutoDetect.z(network);
                int b2 = NetworkChangeNotifierAutoDetect.this.g.b(network);
                Network network2 = this.a;
                if (network2 != null && network2.equals(network)) {
                    z = true;
                } else {
                    z = false;
                }
                NetworkChangeNotifierAutoDetect.this.C(new b(z2, b2, z));
                if (k != null) {
                    k.close();
                }
            } catch (Throwable th) {
                if (k != null) {
                    try {
                        k.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    private static class NetworkConnectivityIntentFilter extends IntentFilter {
        static {
            Covode.recordClassIndex(654489);
        }

        NetworkConnectivityIntentFilter() {
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
    }

    static class c {
        private final ConnectivityManager a;

        static {
            Covode.recordClassIndex(654486);
        }

        protected Network[] a() {
            Network[] networkArr;
            try {
                networkArr = this.a.getAllNetworks();
            } catch (Throwable unused) {
                networkArr = null;
            }
            if (networkArr == null) {
                return new Network[0];
            }
            return networkArr;
        }

        Network c() {
            Network network;
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    network = vj6.a.a(this.a);
                } catch (Throwable unused) {
                    network = null;
                }
                if (network != null) {
                    return network;
                }
            } else {
                network = null;
            }
            try {
                NetworkInfo activeNetworkInfo = this.a.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return null;
                }
                for (Network network2 : NetworkChangeNotifierAutoDetect.t(this, null)) {
                    NetworkInfo g = g(network2);
                    if (g != null && (g.getType() == activeNetworkInfo.getType() || g.getType() == 17)) {
                        if (network != null && Build.VERSION.SDK_INT >= 29) {
                            if (g.getDetailedState() != NetworkInfo.DetailedState.CONNECTING) {
                                NetworkInfo g2 = g(network);
                                if (g2 != null && g2.getDetailedState() == NetworkInfo.DetailedState.CONNECTING) {
                                    network = null;
                                }
                            }
                        }
                        if (network != null) {
                            com.ttnet.org.chromium.base.h.b(NetworkChangeNotifierAutoDetect.p, "defaultNetwork != null", new Object[0]);
                        }
                        network = network2;
                    }
                }
                return network;
            } catch (Throwable unused2) {
                return null;
            }
        }

        void k(ConnectivityManager.NetworkCallback networkCallback) {
            try {
                this.a.unregisterNetworkCallback(networkCallback);
            } catch (Throwable unused) {
            }
        }

        c(Context context) {
            this.a = (ConnectivityManager) context.getSystemService("connectivity");
        }

        protected NetworkCapabilities d(Network network) {
            for (int i = 0; i < 2; i++) {
                try {
                    return this.a.getNetworkCapabilities(network);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        NetworkInfo g(Network network) {
            try {
                try {
                    return this.a.getNetworkInfo(network);
                } catch (Throwable unused) {
                    return this.a.getNetworkInfo(network);
                }
            } catch (Throwable unused2) {
                return null;
            }
        }

        private NetworkInfo h(NetworkInfo networkInfo) {
            if (networkInfo == null) {
                return null;
            }
            if (networkInfo.isConnected()) {
                return networkInfo;
            }
            if (networkInfo.getDetailedState() != NetworkInfo.DetailedState.BLOCKED || ApplicationStatus.getStateForApplication() != 1) {
                return null;
            }
            return networkInfo;
        }

        int b(Network network) {
            NetworkInfo e = e(network);
            if (e == null || !e.isConnected()) {
                return 6;
            }
            return NetworkChangeNotifierAutoDetect.r(e.getType(), e.getSubtype());
        }

        NetworkInfo e(Network network) {
            NetworkInfo g = g(network);
            if (g != null && g.getType() == 17) {
                try {
                    return this.a.getActiveNetworkInfo();
                } catch (Throwable unused) {
                    return null;
                }
            }
            return g;
        }

        protected boolean l(Network network) {
            Socket socket = new Socket();
            try {
                try {
                    com.ttnet.org.chromium.base.o a = com.ttnet.org.chromium.base.o.a();
                    try {
                        network.bindSocket(socket);
                        if (a != null) {
                            a.close();
                        }
                        try {
                            socket.close();
                            return true;
                        } catch (IOException unused) {
                            return true;
                        }
                    } catch (Throwable th) {
                        if (a != null) {
                            try {
                                a.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused2) {
                    return false;
                }
            } catch (IOException unused3) {
                socket.close();
                return false;
            } catch (Throwable th3) {
                try {
                    socket.close();
                } catch (IOException unused4) {
                }
                throw th3;
            }
        }

        f f(i iVar) {
            Network network;
            boolean z;
            NetworkInfo activeNetworkInfo;
            NetworkInfo networkInfo = null;
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    network = c();
                    try {
                        NetworkInfo e = e(network);
                        if (e != null && e.getType() == 17) {
                            activeNetworkInfo = this.a.getActiveNetworkInfo();
                            networkInfo = network;
                        } else {
                            networkInfo = network;
                            activeNetworkInfo = e;
                        }
                    } catch (Throwable unused) {
                    }
                } else {
                    activeNetworkInfo = this.a.getActiveNetworkInfo();
                }
                NetworkInfo networkInfo2 = activeNetworkInfo;
                network = networkInfo;
                networkInfo = networkInfo2;
            } catch (Throwable unused2) {
                network = null;
            }
            NetworkInfo h = h(networkInfo);
            if (h == null) {
                return new f(false, -1, -1, false, null, null, false, "");
            }
            if (network != null) {
                NetworkCapabilities d = d(network);
                if (d != null && !d.hasCapability(11)) {
                    z = true;
                } else {
                    z = false;
                }
                DnsStatus j = AndroidNetworkLibrary.j(network);
                if (j == null) {
                    return new f(true, h.getType(), h.getSubtype(), z, String.valueOf(NetworkChangeNotifierAutoDetect.z(network)), null, false, "");
                }
                ArrayList arrayList = new ArrayList();
                try {
                    for (byte[] bArr : j.getDnsServers()) {
                        arrayList.add(InetAddress.getByAddress(bArr));
                    }
                } catch (UnknownHostException unused3) {
                }
                return new f(true, h.getType(), h.getSubtype(), z, String.valueOf(NetworkChangeNotifierAutoDetect.z(network)), arrayList, j.getPrivateDnsActive(), j.getPrivateDnsServerName());
            }
            if (h.getType() == 1 && Build.VERSION.SDK_INT < 23 && iVar != null) {
                if (l3.a.t(h) != null && !"".equals(l3.a.t(h))) {
                    return new f(true, h.getType(), h.getSubtype(), false, l3.a.t(h), null, false, "");
                }
                return new f(true, h.getType(), h.getSubtype(), false, iVar.a(), null, false, "");
            }
            return new f(true, h.getType(), h.getSubtype(), false, null, null, false, "");
        }

        void i(ConnectivityManager.NetworkCallback networkCallback, Handler handler) {
            try {
                vj6.c.c(this.a, networkCallback, handler);
            } catch (Throwable unused) {
            }
        }

        void j(NetworkRequest networkRequest, ConnectivityManager.NetworkCallback networkCallback, Handler handler) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    vj6.c.d(this.a, networkRequest, networkCallback, handler);
                } else {
                    this.a.registerNetworkCallback(networkRequest, networkCallback);
                }
            } catch (Throwable unused) {
            }
        }
    }

    static class i {
        private final Context a;
        private final Object b = new Object();

        String a() {
            return "";
        }

        static {
            Covode.recordClassIndex(654493);
        }

        i(Context context) {
            this.a = context;
        }
    }

    static {
        Covode.recordClassIndex(654484);
        p = NetworkChangeNotifierAutoDetect.class.getSimpleName();
    }

    private boolean A() {
        if (this.a == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public void s() {
        o();
        this.e.a();
        D();
    }

    public f u() {
        return this.g.f(this.h);
    }

    public long v() {
        Network c2 = this.g.c();
        if (c2 == null) {
            return -1L;
        }
        return z(c2);
    }

    public long x() {
        e eVar = this.i;
        if (eVar == null) {
            return -1L;
        }
        return eVar.c();
    }

    class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (!NetworkChangeNotifierAutoDetect.this.m) {
                NetworkChangeNotifierAutoDetect.this.p();
            } else {
                NetworkChangeNotifierAutoDetect.this.m = false;
            }
        }

        a() {
        }
    }

    private void o() {
        if (xj6.a.a && !A()) {
            throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
        }
    }

    public void D() {
        o();
        if (!this.k) {
            return;
        }
        this.k = false;
        e eVar = this.i;
        if (eVar != null) {
            this.g.k(eVar);
        }
        ConnectivityManager.NetworkCallback networkCallback = this.f;
        if (networkCallback != null) {
            this.g.k(networkCallback);
        } else {
            c(com.ttnet.org.chromium.base.c.f(), this);
        }
    }

    public long[] w() {
        Network[] t = t(this.g, null);
        long[] jArr = new long[t.length * 2];
        int i2 = 0;
        for (Network network : t) {
            int i3 = i2 + 1;
            jArr[i2] = z(network);
            i2 = i3 + 1;
            jArr[i3] = this.g.b(r5);
        }
        return jArr;
    }

    public void B() {
        boolean z;
        o();
        if (this.k) {
            p();
            return;
        }
        if (this.n) {
            p();
        }
        ConnectivityManager.NetworkCallback networkCallback = this.f;
        if (networkCallback != null) {
            try {
                this.g.i(networkCallback, this.b);
            } catch (RuntimeException unused) {
                this.f = null;
            }
        }
        if (this.f == null) {
            try {
                if (d(com.ttnet.org.chromium.base.c.f(), this, this.c) != null) {
                    z = true;
                } else {
                    z = false;
                }
                this.m = z;
            } catch (RuntimeException unused2) {
                this.m = false;
            }
        }
        this.k = true;
        e eVar = this.i;
        if (eVar != null) {
            eVar.g();
            try {
                this.g.j(this.j, this.i, this.b);
            } catch (RuntimeException unused3) {
                this.o = true;
                this.i = null;
            }
            if (!this.o && this.n) {
                Network[] t = t(this.g, null);
                long[] jArr = new long[t.length];
                for (int i2 = 0; i2 < t.length; i2++) {
                    jArr[i2] = z(t[i2]);
                }
                this.d.g(jArr);
            }
        }
    }

    private class b extends ConnectivityManager.NetworkCallback {
        LinkProperties a;
        NetworkCapabilities b;

        static {
            Covode.recordClassIndex(654485);
        }

        private b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            this.a = null;
            this.b = null;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            this.a = null;
            this.b = null;
            if (!NetworkChangeNotifierAutoDetect.this.k) {
                return;
            }
            NetworkChangeNotifierAutoDetect.this.q(new f(false, -1, -1, false, null, null, false, ""));
        }

        private f a(Network network) {
            int i;
            int i2;
            int i3;
            int i4 = -1;
            if (!this.b.hasTransport(1) && !this.b.hasTransport(5)) {
                if (this.b.hasTransport(0)) {
                    NetworkInfo g = NetworkChangeNotifierAutoDetect.this.g.g(network);
                    if (g != null) {
                        i4 = g.getSubtype();
                    }
                    i2 = i4;
                    i = 0;
                    return new f(true, i, i2, !this.b.hasCapability(11), String.valueOf(NetworkChangeNotifierAutoDetect.z(network)), null, vj6.d.d(this.a), vj6.d.b(this.a));
                }
                if (this.b.hasTransport(3)) {
                    i = 9;
                } else if (this.b.hasTransport(2)) {
                    i = 7;
                } else if (this.b.hasTransport(4)) {
                    NetworkInfo e = NetworkChangeNotifierAutoDetect.this.g.e(network);
                    if (e != null) {
                        i3 = e.getType();
                    } else {
                        i3 = 17;
                    }
                    i = i3;
                } else {
                    i = -1;
                }
            } else {
                i = 1;
            }
            i2 = -1;
            return new f(true, i, i2, !this.b.hasCapability(11), String.valueOf(NetworkChangeNotifierAutoDetect.z(network)), null, vj6.d.d(this.a), vj6.d.b(this.a));
        }

        /* synthetic */ b(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect, a aVar) {
            this();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            this.b = networkCapabilities;
            if (NetworkChangeNotifierAutoDetect.this.k && this.a != null && this.b != null) {
                NetworkChangeNotifierAutoDetect.this.q(a(network));
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            this.a = linkProperties;
            if (NetworkChangeNotifierAutoDetect.this.k && this.a != null && this.b != null) {
                NetworkChangeNotifierAutoDetect.this.q(a(network));
            }
        }
    }

    private class d extends ConnectivityManager.NetworkCallback {
        static {
            Covode.recordClassIndex(654487);
        }

        private d() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            onAvailable(null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (NetworkChangeNotifierAutoDetect.this.k) {
                NetworkChangeNotifierAutoDetect.this.p();
            }
        }

        /* synthetic */ d(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect, a aVar) {
            this();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            onAvailable(null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            onAvailable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(Runnable runnable) {
        if (this.k) {
            runnable.run();
        }
    }

    public static long z(Network network) {
        if (Build.VERSION.SDK_INT >= 23) {
            return vj6.a.b(network);
        }
        return Integer.parseInt(network.toString());
    }

    public void C(final Runnable runnable) {
        if (A()) {
            runnable.run();
        } else {
            this.b.post(new Runnable() { // from class: com.ttnet.org.chromium.net.j
                @Override // java.lang.Runnable
                public final void run() {
                    NetworkChangeNotifierAutoDetect.this.y(runnable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
    
        if (r4.h.equals(r1.h) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q(com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.f r4) {
        /*
            r3 = this;
            int r0 = r4.c()
            com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$f r1 = r3.l
            int r1 = r1.c()
            if (r0 != r1) goto L36
            java.lang.String r0 = r4.e
            com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$f r1 = r3.l
            java.lang.String r1 = r1.e
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L36
            java.util.List<java.net.InetAddress> r0 = r4.f
            com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$f r1 = r3.l
            java.util.List<java.net.InetAddress> r1 = r1.f
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L36
            boolean r0 = r4.g
            com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$f r1 = r3.l
            boolean r2 = r1.g
            if (r0 != r2) goto L36
            java.lang.String r0 = r4.h
            java.lang.String r1 = r1.h
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3f
        L36:
            com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$g r0 = r3.d
            int r1 = r4.c()
            r0.a(r1)
        L3f:
            int r0 = r4.c()
            com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$f r1 = r3.l
            int r1 = r1.c()
            if (r0 != r1) goto L57
            int r0 = r4.b()
            com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$f r1 = r3.l
            int r1 = r1.b()
            if (r0 == r1) goto L60
        L57:
            com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$g r0 = r3.d
            int r1 = r4.b()
            r0.d(r1)
        L60:
            int r0 = r4.a()
            com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$f r1 = r3.l
            int r1 = r1.a()
            if (r0 == r1) goto L75
            com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$g r0 = r3.d
            int r1 = r4.a()
            r0.e(r1)
        L75:
            r3.l = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.q(com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$f):void");
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static void c(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NetworkChangeNotifierAutoDetect(g gVar, h hVar) {
        Looper myLooper = Looper.myLooper();
        this.a = myLooper;
        this.b = new HandlerDelegate(myLooper);
        this.d = gVar;
        this.g = new c(com.ttnet.org.chromium.base.c.f());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            this.h = new i(com.ttnet.org.chromium.base.c.f());
        }
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        this.i = new e(this, 0 == true ? 1 : 0);
        this.j = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();
        if (i2 >= 30) {
            this.f = new b(this, objArr2 == true ? 1 : 0);
        } else {
            this.f = i2 >= 28 ? new d(this, objArr == true ? 1 : 0) : null;
        }
        this.l = u();
        this.c = new NetworkConnectivityIntentFilter();
        this.m = false;
        this.n = false;
        this.e = hVar;
        hVar.b(this);
        this.n = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Network[] t(c cVar, Network network) {
        NetworkCapabilities d2;
        Network[] a2 = cVar.a();
        int i2 = 0;
        for (Network network2 : a2) {
            if (network2 != null && !network2.equals(network) && (d2 = cVar.d(network2)) != null && d2.hasCapability(12)) {
                if (d2.hasTransport(4)) {
                    if (cVar.l(network2)) {
                        return new Network[]{network2};
                    }
                } else {
                    a2[i2] = network2;
                    i2++;
                }
            }
        }
        return (Network[]) Arrays.copyOf(a2, i2);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    public static Intent b(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e2) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
                return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
            }
            throw e2;
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static Intent d(Context context, BroadcastReceiver broadcastReceiver, IntentFilter filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (Build.VERSION.SDK_INT >= 34) {
            if (!(context instanceof Context)) {
                context = null;
            }
            if (context == null) {
                return null;
            }
            LogWrapper.error("BroadcastAop", "registerReceiver 要传flag参数啦！", new Object[0]);
            return ContextCompat.registerReceiver(context, broadcastReceiver, filter, 2);
        }
        return b(context, broadcastReceiver, filter);
    }
}
