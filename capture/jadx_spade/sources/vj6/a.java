package vj6;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.security.NetworkSecurityPolicy;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    static {
        Covode.recordClassIndex(654310);
    }

    public static boolean d() {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    public static Network a(ConnectivityManager connectivityManager) {
        return connectivityManager.getActiveNetwork();
    }

    public static long b(Network network) {
        if (network == null) {
            return 0L;
        }
        return network.getNetworkHandle();
    }

    public static <T> T c(Context context, Class<T> cls) {
        return (T) context.getSystemService(cls);
    }

    public static void e(ConnectivityManager connectivityManager, Network network, boolean z) {
        connectivityManager.reportNetworkConnectivity(network, z);
    }
}
