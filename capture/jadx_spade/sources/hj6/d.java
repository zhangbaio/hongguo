package hj6;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class d {
    private static boolean a;
    private static ConnectivityManager b;
    private static Network c;

    static class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (network == null) {
                return;
            }
            NetworkInfo networkInfo = d.b.getNetworkInfo(network);
            if (networkInfo != null) {
                Log.i("NetUtils", "network info: " + networkInfo);
            }
            NetworkCapabilities networkCapabilities = d.b.getNetworkCapabilities(network);
            if (networkCapabilities != null && networkCapabilities.hasTransport(0) && networkCapabilities.hasCapability(12)) {
                d.o(network);
            } else {
                Log.e("NetUtils", "fake cellular network");
            }
            d.n();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            if (network != null && d.b != null && d.c != null) {
                NetworkInfo networkInfo = d.b.getNetworkInfo(network);
                if (networkInfo != null) {
                    Log.i("NetUtils", "network info: " + networkInfo);
                }
                if (d.h(network) == d.h(d.c)) {
                    d.o(null);
                }
                d.n();
            }
        }
    }

    static {
        Covode.recordClassIndex(653078);
        a = false;
    }

    public static long g() {
        try {
            if (!m()) {
                Log.e("NetUtils", "preCheck failed!");
                return -1L;
            }
            Network network = c;
            if (network == null) {
                return -1L;
            }
            return h(network);
        } catch (Throwable th) {
            Log.e("NetUtils", "exception when getCellularNetId");
            th.printStackTrace();
            return -1L;
        }
    }

    private static boolean m() {
        try {
            int i = Build.VERSION.SDK_INT;
            if (i < 24) {
                Log.e("NetUtils", "Low sdk_version " + i);
                return false;
            }
            if (b == null) {
                Log.e("NetUtils", "ConnectivityManager is null");
                return false;
            }
            return true;
        } catch (Throwable th) {
            Log.e("NetUtils", "exception when preCheck");
            th.printStackTrace();
            return false;
        }
    }

    public static boolean f() {
        try {
            if (!m()) {
                Log.e("NetUtils", "preCheck failed!");
                return false;
            }
            if (a) {
                Log.i("NetUtils", "Already active cellular");
                return true;
            }
            try {
                b.requestNetwork(new NetworkRequest.Builder().addTransportType(0).addCapability(12).build(), new a());
                a = true;
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        } catch (Throwable th2) {
            Log.e("NetUtils", "exception when alwaysActiveCellularOn");
            th2.printStackTrace();
            return false;
        }
    }

    public static String k() {
        NetworkCapabilities networkCapabilities;
        try {
            if (!m()) {
                Log.e("NetUtils", "preCheck failed!");
                return "invalid";
            }
            Network activeNetwork = b.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = b.getNetworkCapabilities(activeNetwork)) != null && networkCapabilities.hasCapability(12)) {
                if (networkCapabilities.hasTransport(0)) {
                    return "cellular";
                }
                if (networkCapabilities.hasTransport(1)) {
                    return "wifi";
                }
                return "unknown";
            }
            Log.e("NetUtils", "no active network");
            return "none";
        } catch (Throwable th) {
            Log.e("NetUtils", "exception when getTransportType");
            th.printStackTrace();
            return "none";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        try {
            if (!m()) {
                Log.e("NetUtils", "preCheck failed!");
                return;
            }
            Network[] allNetworks = b.getAllNetworks();
            Log.i("NetUtils", "print all networks");
            for (Network network : allNetworks) {
                NetworkInfo networkInfo = b.getNetworkInfo(network);
                if (networkInfo != null) {
                    Log.i("NetUtils", "network info: " + networkInfo.toString());
                }
            }
        } catch (Throwable th) {
            Log.e("NetUtils", "exception when printAllNetworks");
            th.printStackTrace();
        }
    }

    public static NetworkInfo j(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int i(Context context) {
        try {
            NetworkInfo j = j(context);
            if (j != null && j.isAvailable()) {
                return j.getType();
            }
        } catch (Throwable unused) {
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long h(Network network) {
        if (network == null) {
            return 0L;
        }
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                return network.getNetworkHandle();
            }
            return Integer.parseInt(network.toString());
        } catch (Throwable th) {
            Log.e("NetUtils", "exception when getNetId");
            th.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(Network network) {
        try {
            if (network == null) {
                Log.i("NetUtils", "cellular is gone");
            } else {
                Log.i("NetUtils", "cellular is on");
            }
            synchronized (d.class) {
                c = network;
            }
        } catch (Throwable th) {
            Log.e("NetUtils", "exception when setCellularNetwork");
            th.printStackTrace();
        }
    }

    public static boolean l(Context context) {
        try {
            if (context == null) {
                Log.e("NetUtils", "Invalid context");
                return false;
            }
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") != 0) {
                Log.e("NetUtils", "Permission Denied for ACCESS_NETWORK_STATE");
                return false;
            }
            int i = Build.VERSION.SDK_INT;
            if (i < 24) {
                Log.e("NetUtils", "Low sdk_version " + i);
                return false;
            }
            if (b == null) {
                b = (ConnectivityManager) context.getSystemService("connectivity");
                return true;
            }
            return true;
        } catch (Throwable th) {
            Log.e("NetUtils", "exception when init");
            th.printStackTrace();
            return false;
        }
    }
}
