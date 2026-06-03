package vj6;

import android.content.Context;
import android.net.NetworkCapabilities;
import android.net.TransportInfo;
import android.os.PowerManager;
import android.provider.MediaStore;
import com.bytedance.covode.number.Covode;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e {
    static {
        Covode.recordClassIndex(654315);
    }

    public static int a(PowerManager powerManager) {
        return powerManager.getCurrentThermalStatus();
    }

    public static Set<String> b(Context context) {
        return MediaStore.getExternalVolumeNames(context);
    }

    public static TransportInfo c(NetworkCapabilities networkCapabilities) {
        return networkCapabilities.getTransportInfo();
    }
}
