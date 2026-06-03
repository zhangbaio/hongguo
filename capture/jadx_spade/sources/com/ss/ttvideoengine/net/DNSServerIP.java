package com.ss.ttvideoengine.net;

import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DNSServerIP {
    private static volatile String mServerIP;
    private static volatile long mServerIPTime;

    static {
        Covode.recordClassIndex(652579);
    }

    public static String getDNSServerIP() {
        updateDNSServerIP();
        return mServerIP;
    }

    public static void updateDNSServerIP() {
        if (SystemClock.elapsedRealtime() - mServerIPTime < 300000) {
            return;
        }
        EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.net.DNSServerIP.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InetAddress byName = InetAddress.getByName("whoami.akamai.net");
                    if (byName == null) {
                        return;
                    }
                    String unused = DNSServerIP.mServerIP = byName.getHostAddress();
                    long unused2 = DNSServerIP.mServerIPTime = SystemClock.elapsedRealtime();
                    TTVideoEngineLog.i("DNSServerIP", "update dns server ip:" + DNSServerIP.mServerIP);
                } catch (UnknownHostException unused3) {
                }
            }
        });
    }
}
