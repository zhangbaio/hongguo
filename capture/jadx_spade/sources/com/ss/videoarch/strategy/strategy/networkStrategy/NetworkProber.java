package com.ss.videoarch.strategy.strategy.networkStrategy;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.NativeObject;
import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.b;
import org.json.JSONArray;
import org.json.JSONException;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class NetworkProber extends NativeObject {
    private static volatile NetworkProber h;
    private boolean a = false;
    private boolean b = false;
    private final String c = "probe_udp";
    private final String d = "probe_quic";
    private final String e = "udp";
    private final String f = "tcp";
    public final int g = 2;

    static {
        Covode.recordClassIndex(653184);
    }

    private native void nativeDestoryProbe();

    private native String nativeGetUdpProbeInfo(String str, int i);

    private native int nativeNetworkReachableProbe(String str, String str2, int i);

    private native void nativeSetProbePackageSize(int i);

    private native void nativeSetProbeResultVaildTime(int i);

    private native void nativeUpdateProbeParamsFromSettings(String str);

    public void a() {
        if (!b.a()) {
            return;
        }
        nativeDestoryProbe();
    }

    public static NetworkProber e() {
        if (h == null) {
            synchronized (NetworkProber.class) {
                if (h == null) {
                    h = new NetworkProber();
                }
            }
        }
        return h;
    }

    public String b() {
        JSONArray jSONArray = lj6.a.m().r.e.mUDPProbeInfos;
        if (jSONArray != null) {
            return jSONArray.toString();
        }
        return "";
    }

    public void d() {
        Log.e("NetworkProber", "RTM Probe: initUdpProbe: " + lj6.a.m().r.e.mEnableRtmProbe);
        if (lj6.a.m().r.e.mEnableRtmProbe == -1) {
            Log.e("NetworkProber", "RTM Probe: udp probe not start");
            return;
        }
        if (lj6.a.m().r.e.mEnableRtmProbe == 0) {
            Log.e("NetworkProber", "RTM Probe: clear probe tasks and stop udp probe!!!");
            e().a();
        } else {
            e().g(lj6.a.m().r.e.mUDPProbePackageSize);
            e().h(lj6.a.m().r.e.mUDPProbeResultVaildTime);
            e().i(b());
        }
    }

    public void g(int i) {
        if (!b.a()) {
            return;
        }
        nativeSetProbePackageSize(i);
    }

    public void h(int i) {
        if (!b.a()) {
            return;
        }
        nativeSetProbeResultVaildTime(i);
    }

    public void i(String str) {
        if (!b.a()) {
            return;
        }
        nativeUpdateProbeParamsFromSettings(str);
    }

    public JSONArray c(String str, int i) {
        if (TextUtils.isEmpty(str) || !b.a() || lj6.a.m().r.e.mEnableRtmProbe != 1) {
            return null;
        }
        try {
            return new JSONArray(nativeGetUdpProbeInfo(str, i));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public long f(int i, String str, int i2, String str2) {
        if (!b.a() || i != 0) {
            return -1L;
        }
        return nativeNetworkReachableProbe(str, "tcp", i2);
    }
}
