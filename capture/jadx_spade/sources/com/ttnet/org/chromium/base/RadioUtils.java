package com.ttnet.org.chromium.base;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Process;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

@JNINamespace("base::android")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class RadioUtils {
    private static Boolean a;
    private static Boolean b;

    private RadioUtils() {
    }

    static {
        Covode.recordClassIndex(654255);
    }

    private static boolean isSupported() {
        if (Build.VERSION.SDK_INT >= 28 && a() && b()) {
            return true;
        }
        return false;
    }

    private static boolean a() {
        boolean z;
        if (a == null) {
            if (a.a(c.f(), "android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) == 0) {
                z = true;
            } else {
                z = false;
            }
            a = Boolean.valueOf(z);
        }
        return a.booleanValue();
    }

    private static boolean b() {
        boolean z;
        if (b == null) {
            if (a.a(c.f(), "android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) == 0) {
                z = true;
            } else {
                z = false;
            }
            b = Boolean.valueOf(z);
        }
        return b.booleanValue();
    }

    private static int getCellDataActivity() {
        TraceEvent k = TraceEvent.k("RadioUtils::getCellDataActivity");
        try {
            try {
                int dataActivity = ((TelephonyManager) c.f().getSystemService("phone")).getDataActivity();
                if (k != null) {
                    k.close();
                }
                return dataActivity;
            } catch (SecurityException unused) {
                if (k != null) {
                    k.close();
                    return -1;
                }
                return -1;
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

    private static int getCellSignalLevel() {
        TraceEvent k = TraceEvent.k("RadioUtils::getCellSignalLevel");
        try {
            int i = -1;
            try {
                SignalStrength c = vj6.d.c((TelephonyManager) c.f().getSystemService("phone"));
                if (c != null) {
                    i = c.getLevel();
                }
            } catch (SecurityException unused) {
            }
            if (k != null) {
                k.close();
            }
            return i;
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

    private static boolean isWifiConnected() {
        TraceEvent k = TraceEvent.k("RadioUtils::isWifiConnected");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) c.f().getSystemService("connectivity");
            Network a2 = vj6.a.a(connectivityManager);
            if (a2 == null) {
                if (k != null) {
                    k.close();
                }
                return false;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(a2);
            if (networkCapabilities == null) {
                if (k != null) {
                    k.close();
                }
                return false;
            }
            boolean hasTransport = networkCapabilities.hasTransport(1);
            if (k != null) {
                k.close();
            }
            return hasTransport;
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
