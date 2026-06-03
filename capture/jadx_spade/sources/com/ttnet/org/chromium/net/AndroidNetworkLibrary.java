package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.RouteInfo;
import android.net.TrafficStats;
import android.net.TransportInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.dragon.read.app.AppLifecycleMonitor;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.ttnet.org.chromium.base.CollectionUtil;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.URLConnection;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

@MainDex
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class AndroidNetworkLibrary {
    private static Boolean a;
    private static Boolean b;
    private static Boolean c;

    interface b {
        void a(boolean z, int i);
    }

    static {
        Covode.recordClassIndex(654426);
    }

    AndroidNetworkLibrary() {
    }

    private static String g(TelephonyManager telephonyManager) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(102021, "android/telephony/TelephonyManager", "getSimOperator", telephonyManager, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(102021, "android/telephony/TelephonyManager", "getSimOperator", telephonyManager, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String simOperator = telephonyManager.getSimOperator();
        heliosApiHook.postInvoke(102021, "android/telephony/TelephonyManager", "getSimOperator", telephonyManager, objArr, simOperator, extraInfo, true);
        return simOperator;
    }

    public static String getWifiSSID() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Enumeration h() throws SocketException {
        Result preInvoke = new HeliosApiHook().preInvoke(100016, "java/net/NetworkInterface", "getNetworkInterfaces", NetworkInterface.class, new Object[0], "java.util.Enumeration", new ExtraInfo(false, "()Ljava/util/Enumeration;"));
        return preInvoke.isIntercept() ? (Enumeration) preInvoke.getReturnValue() : NetworkInterface.getNetworkInterfaces();
    }

    public static class c {
        private static c a;

        public static c a() {
            return a;
        }

        static {
            Covode.recordClassIndex(654428);
            a = new c();
        }

        public boolean b() {
            if (Build.VERSION.SDK_INT < 23) {
                return true;
            }
            return vj6.a.d();
        }

        public boolean c(String str) {
            if (Build.VERSION.SDK_INT < 24) {
                return b();
            }
            return vj6.b.a(str);
        }
    }

    public static void clearTestRootCertificates() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        i0.d();
    }

    private static class e extends Socket {
        static {
            Covode.recordClassIndex(654430);
        }

        private static class a extends SocketImpl {
            static {
                Covode.recordClassIndex(654431);
            }

            @Override // java.net.SocketImpl
            protected void close() {
            }

            @Override // java.net.SocketImpl
            protected void create(boolean z) {
            }

            @Override // java.net.SocketImpl
            protected int available() {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            protected InputStream getInputStream() {
                throw new RuntimeException("getInputStream not implemented");
            }

            @Override // java.net.SocketImpl
            protected OutputStream getOutputStream() {
                throw new RuntimeException("getOutputStream not implemented");
            }

            a(FileDescriptor fileDescriptor) {
                ((SocketImpl) this).fd = fileDescriptor;
            }

            @Override // java.net.SocketImpl
            protected void accept(SocketImpl socketImpl) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketOptions
            public Object getOption(int i) {
                throw new RuntimeException("getOption not implemented");
            }

            @Override // java.net.SocketImpl
            protected void listen(int i) {
                throw new RuntimeException("listen not implemented");
            }

            @Override // java.net.SocketImpl
            protected void sendUrgentData(int i) {
                throw new RuntimeException("sendUrgentData not implemented");
            }

            @Override // java.net.SocketImpl
            protected void bind(InetAddress inetAddress, int i) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            protected void connect(String str, int i) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketOptions
            public void setOption(int i, Object obj) {
                throw new RuntimeException("setOption not implemented");
            }

            @Override // java.net.SocketImpl
            protected void connect(InetAddress inetAddress, int i) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            protected void connect(SocketAddress socketAddress, int i) {
                throw new RuntimeException("connect not implemented");
            }
        }

        e(FileDescriptor fileDescriptor) throws IOException {
            super(new a(fileDescriptor));
        }
    }

    public static DnsStatus getCurrentDnsStatus() {
        return j(null);
    }

    @Proxy("getNetworkInterfaces")
    @TargetClass("java.net.NetworkInterface")
    public static Enumeration a() throws SocketException {
        if (ko2.e.a()) {
            return Collections.emptyEnumeration();
        }
        return h();
    }

    private static boolean n() {
        if (a == null) {
            a = Boolean.valueOf(l(com.ttnet.org.chromium.base.c.f(), "android.permission.ACCESS_NETWORK_STATE"));
        }
        return a.booleanValue();
    }

    private static boolean o() {
        if (b == null) {
            b = Boolean.valueOf(l(com.ttnet.org.chromium.base.c.f(), "android.permission.ACCESS_WIFI_STATE"));
        }
        return b.booleanValue();
    }

    private static boolean reportBadDefaultNetwork() {
        ConnectivityManager connectivityManager;
        if (Build.VERSION.SDK_INT < 23 || (connectivityManager = (ConnectivityManager) com.ttnet.org.chromium.base.c.f().getSystemService("connectivity")) == null) {
            return false;
        }
        vj6.a.e(connectivityManager, null, false);
        return true;
    }

    private static class d {
        private static final Method a;

        private static Object a(Method method, Object obj, Object[] objArr) {
            Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
            return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
        }

        static {
            Covode.recordClassIndex(654429);
            try {
                a = FileDescriptor.class.getMethod("setInt$", Integer.TYPE);
            } catch (NoSuchMethodException | SecurityException e) {
                throw new RuntimeException("Unable to get FileDescriptor.setInt$", e);
            }
        }

        public static FileDescriptor b(int i) {
            try {
                FileDescriptor fileDescriptor = new FileDescriptor();
                a(a, fileDescriptor, new Object[]{Integer.valueOf(i)});
                return fileDescriptor;
            } catch (IllegalAccessException e) {
                throw new RuntimeException("FileDescriptor.setInt$() failed", e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("FileDescriptor.setInt$() failed", e2);
            }
        }
    }

    private static boolean checkIsVpnOn() {
        ConnectivityManager connectivityManager = (ConnectivityManager) com.ttnet.org.chromium.base.c.f().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        Network[] allNetworks = connectivityManager.getAllNetworks();
        for (int i = 0; i < allNetworks.length; i++) {
            if (connectivityManager.getNetworkInfo(allNetworks[i]).isConnected() && connectivityManager.getNetworkCapabilities(allNetworks[i]).hasTransport(4)) {
                return true;
            }
        }
        return false;
    }

    public static int getCurrentAccessPointChannel() {
        if (u.a().f()) {
            return i(u.a().d());
        }
        WifiInfo k = k();
        if (k == null) {
            return -1;
        }
        return i(k.getFrequency());
    }

    public static int[] getDhcpInfo() {
        DhcpInfo d2;
        if (u.a().g()) {
            return new int[0];
        }
        try {
            WifiManager wifiManager = (WifiManager) com.ttnet.org.chromium.base.c.f().getSystemService("wifi");
            if (wifiManager != null && (d2 = d(wifiManager)) != null) {
                return new int[]{d2.ipAddress, d2.gateway};
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new int[0];
    }

    private static boolean getIsCaptivePortal() {
        ConnectivityManager connectivityManager;
        Network a2;
        NetworkCapabilities networkCapabilities;
        if (Build.VERSION.SDK_INT < 23 || (connectivityManager = (ConnectivityManager) com.ttnet.org.chromium.base.c.f().getSystemService("connectivity")) == null || (a2 = vj6.a.a(connectivityManager)) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(a2)) == null || !networkCapabilities.hasCapability(17)) {
            return false;
        }
        return true;
    }

    private static String getNetworkOperator() {
        if (u.a().f()) {
            return u.a().b();
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) com.ttnet.org.chromium.base.c.f().getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            return telephonyManager.getNetworkOperator();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static String getSimOperator() {
        if (u.a().f()) {
            return u.a().c();
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) com.ttnet.org.chromium.base.c.f().getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            return g(telephonyManager);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean haveOnlyLoopbackAddresses() {
        try {
            Enumeration a2 = a();
            if (a2 == null) {
                return false;
            }
            while (a2.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) a2.nextElement();
                try {
                    if (networkInterface.isUp() && !networkInterface.isLoopback()) {
                        return false;
                    }
                } catch (SocketException unused) {
                }
            }
            return true;
        } catch (Exception e2) {
            Log.w("AndroidNetworkLibrary", "could not get network interfaces: " + e2);
            return false;
        }
    }

    private static void alwaysUpCellularOnThreadPool() {
        ConnectivityManager connectivityManager = (ConnectivityManager) com.ttnet.org.chromium.base.c.f().getSystemService("connectivity");
        if (connectivityManager == null) {
            com.ttnet.org.chromium.net.a.b().a(false, 7);
            return;
        }
        try {
            connectivityManager.requestNetwork(new NetworkRequest.Builder().addCapability(12).addTransportType(0).build(), new a(connectivityManager));
        } catch (Exception e2) {
            e2.printStackTrace();
            com.ttnet.org.chromium.net.a.b().a(false, 9);
        }
    }

    public static int[] getAllAccessPointChannels() {
        if (m() && o()) {
            WifiManager wifiManager = (WifiManager) com.ttnet.org.chromium.base.c.f().getSystemService("wifi");
            if (wifiManager == null) {
                return new int[0];
            }
            List e2 = e(wifiManager);
            if (e2 != null && !e2.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator it2 = e2.iterator();
                while (it2.hasNext()) {
                    arrayList.add(Integer.valueOf(i(((ScanResult) it2.next()).frequency)));
                }
                return CollectionUtil.a(arrayList);
            }
            return new int[0];
        }
        return new int[0];
    }

    private static WifiInfo k() {
        TransportInfo c2;
        if (o()) {
            if (Build.VERSION.SDK_INT >= 31) {
                ConnectivityManager connectivityManager = (ConnectivityManager) com.ttnet.org.chromium.base.c.f().getSystemService("connectivity");
                for (Network network : connectivityManager.getAllNetworks()) {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                    if (networkCapabilities != null && networkCapabilities.hasTransport(1) && (c2 = vj6.e.c(networkCapabilities)) != null && (c2 instanceof WifiInfo)) {
                        return (WifiInfo) c2;
                    }
                }
                return null;
            }
            return l3.a.s((WifiManager) com.ttnet.org.chromium.base.c.f().getSystemService("wifi"));
        }
        Intent c3 = c(com.ttnet.org.chromium.base.c.f(), null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        if (c3 == null) {
            return null;
        }
        return (WifiInfo) c3.getParcelableExtra("wifiInfo");
    }

    private static boolean m() {
        boolean z;
        if (c == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                c = Boolean.valueOf(l(com.ttnet.org.chromium.base.c.f(), "android.permission.ACCESS_FINE_LOCATION"));
            } else {
                if (!l(com.ttnet.org.chromium.base.c.f(), "android.permission.ACCESS_COARSE_LOCATION") && !l(com.ttnet.org.chromium.base.c.f(), "android.permission.ACCESS_FINE_LOCATION")) {
                    z = false;
                } else {
                    z = true;
                }
                c = Boolean.valueOf(z);
            }
        }
        return c.booleanValue();
    }

    public static String[][] getAllRouteInfo() {
        if (!n()) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) com.ttnet.org.chromium.base.c.f().getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            Network[] allNetworks = connectivityManager.getAllNetworks();
            ArrayList arrayList = new ArrayList();
            for (Network network : allNetworks) {
                LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
                if (linkProperties != null) {
                    for (RouteInfo routeInfo : linkProperties.getRoutes()) {
                        String[] strArr = new String[4];
                        if (routeInfo.getDestination() != null) {
                            strArr[0] = routeInfo.getDestination().getAddress().getHostAddress();
                            strArr[1] = Integer.toString(routeInfo.getDestination().getPrefixLength());
                        }
                        if (routeInfo.getGateway() != null) {
                            strArr[2] = routeInfo.getGateway().getHostAddress();
                        }
                        strArr[3] = routeInfo.getInterface();
                        arrayList.add(strArr);
                    }
                }
            }
            return (String[][]) arrayList.toArray((String[][]) Array.newInstance((Class<?>) String.class, 0, 0));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void addTestRootCertificate(byte[] bArr) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        i0.b(bArr);
    }

    class a extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ ConnectivityManager a;

        a(ConnectivityManager connectivityManager) {
            this.a = connectivityManager;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            NetworkCapabilities networkCapabilities = this.a.getNetworkCapabilities(network);
            if (networkCapabilities != null && networkCapabilities.hasTransport(0) && networkCapabilities.hasCapability(12)) {
                com.ttnet.org.chromium.net.a.b().a(true, -1);
            } else {
                com.ttnet.org.chromium.net.a.b().a(false, 8);
            }
        }
    }

    public static DnsStatus getDnsStatusForNetwork(long j) {
        try {
            return j(Network.fromNetworkHandle(j));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static void setWifiEnabled(boolean z) {
        ((WifiManager) com.ttnet.org.chromium.base.c.f().getSystemService("wifi")).setWifiEnabled(z);
    }

    @Proxy("getScanResults")
    @TargetClass("android.net.wifi.WifiManager")
    public static List e(WifiManager wifiManager) {
        LogWrapper.warn("WifiManagerAop", Log.getStackTraceString(new Exception("WifiManagerAop")), new Object[0]);
        return Collections.emptyList();
    }

    public static String getMimeTypeFromExtension(String str) {
        return URLConnection.guessContentTypeFromName("foo." + str);
    }

    private static boolean isCleartextPermitted(String str) {
        try {
            return c.a().c(str);
        } catch (IllegalArgumentException unused) {
            return c.a().b();
        }
    }

    @Proxy("getDhcpInfo")
    @TargetClass("android.net.wifi.WifiManager")
    public static DhcpInfo d(WifiManager wifiManager) {
        if (PrivacyMgr.inst().hasConfirmed() && AppLifecycleMonitor.getInstance().isForeground()) {
            LogWrapper.info("WifiManagerAop", "pass WifiManager.getDhcpInfo", new Object[0]);
            return wifiManager.getDhcpInfo();
        }
        LogWrapper.error("WifiManagerAop", "intercept WifiManager.getDhcpInfo", new Object[0]);
        return null;
    }

    public static int getWifiSignalLevel(int i) {
        int intExtra;
        int calculateSignalLevel;
        if (com.ttnet.org.chromium.base.c.f() == null || com.ttnet.org.chromium.base.c.f().getContentResolver() == null) {
            return -1;
        }
        if (u.a().f()) {
            intExtra = u.a().e();
        } else if (o()) {
            WifiInfo k = k();
            if (k == null) {
                return -1;
            }
            intExtra = k.getRssi();
        } else {
            try {
                Intent c2 = c(com.ttnet.org.chromium.base.c.f(), null, new IntentFilter("android.net.wifi.RSSI_CHANGED"));
                if (c2 == null) {
                    return -1;
                }
                intExtra = c2.getIntExtra("newRssi", Integer.MIN_VALUE);
            } catch (IllegalArgumentException unused) {
            }
        }
        if (intExtra == Integer.MIN_VALUE || (calculateSignalLevel = WifiManager.calculateSignalLevel(intExtra, i)) < 0 || calculateSignalLevel >= i) {
            return -1;
        }
        return calculateSignalLevel;
    }

    private static int i(int i) {
        if (i == 2484) {
            return 14;
        }
        if (i < 2484) {
            return (i - 2407) / 5;
        }
        if (i >= 4910 && i <= 4980) {
            return (i - 4000) / 5;
        }
        if (i < 5925) {
            return (i - 5000) / 5;
        }
        if (i == 5935) {
            return 2;
        }
        if (i <= 45000) {
            return (i - 5950) / 5;
        }
        if (i >= 58320 && i <= 70200) {
            return (i - 56160) / 2160;
        }
        return -1;
    }

    public static DnsStatus j(Network network) {
        ConnectivityManager connectivityManager;
        if (!n() || (connectivityManager = (ConnectivityManager) com.ttnet.org.chromium.base.c.f().getSystemService("connectivity")) == null) {
            return null;
        }
        if (network == null) {
            network = vj6.a.a(connectivityManager);
        }
        if (network == null) {
            return null;
        }
        try {
            LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
            if (linkProperties == null) {
                return null;
            }
            List<InetAddress> dnsServers = linkProperties.getDnsServers();
            String domains = linkProperties.getDomains();
            if (Build.VERSION.SDK_INT >= 28) {
                return new DnsStatus(dnsServers, vj6.d.d(linkProperties), vj6.d.b(linkProperties), domains);
            }
            return new DnsStatus(dnsServers, false, "", domains);
        } catch (RuntimeException unused) {
            return null;
        }
    }

    private static boolean l(Context context, String str) {
        if (com.ttnet.org.chromium.base.a.a(context, str, Process.myPid(), Process.myUid()) == 0) {
            return true;
        }
        return false;
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2) {
        try {
            return i0.n(bArr, str, str2);
        } catch (IllegalArgumentException unused) {
            return new AndroidCertVerifyResult(-1);
        } catch (KeyStoreException unused2) {
            return new AndroidCertVerifyResult(-1);
        } catch (NoSuchAlgorithmException unused3) {
            return new AndroidCertVerifyResult(-1);
        }
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
    public static Intent c(Context context, BroadcastReceiver broadcastReceiver, IntentFilter filter) {
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

    private static void tagSocket(int i, int i2, int i3) throws IOException {
        ParcelFileDescriptor adoptFd;
        FileDescriptor fileDescriptor;
        int threadStatsTag = TrafficStats.getThreadStatsTag();
        if (i3 != threadStatsTag) {
            TrafficStats.setThreadStatsTag(i3);
        }
        if (i2 != -1) {
            d0.c(i2);
        }
        if (Build.VERSION.SDK_INT < 23) {
            fileDescriptor = d.b(i);
            adoptFd = null;
        } else {
            adoptFd = ParcelFileDescriptor.adoptFd(i);
            fileDescriptor = adoptFd.getFileDescriptor();
        }
        e eVar = new e(fileDescriptor);
        TrafficStats.tagSocket(eVar);
        eVar.close();
        if (adoptFd != null) {
            adoptFd.detachFd();
        }
        if (i3 != threadStatsTag) {
            TrafficStats.setThreadStatsTag(threadStatsTag);
        }
        if (i2 != -1) {
            d0.a();
        }
    }
}
