package vj6;

import android.content.pm.PackageInfo;
import android.net.LinkProperties;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    static {
        Covode.recordClassIndex(654314);
    }

    public static long a(PackageInfo packageInfo) {
        return packageInfo.getLongVersionCode();
    }

    public static String b(LinkProperties linkProperties) {
        return linkProperties.getPrivateDnsServerName();
    }

    public static SignalStrength c(TelephonyManager telephonyManager) {
        return telephonyManager.getSignalStrength();
    }

    public static boolean d(LinkProperties linkProperties) {
        return linkProperties.isPrivateDnsActive();
    }
}
