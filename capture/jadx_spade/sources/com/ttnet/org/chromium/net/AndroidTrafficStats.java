package com.ttnet.org.chromium.net;

import android.net.TrafficStats;
import android.os.Process;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

@JNINamespace("net::android::traffic_stats")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class AndroidTrafficStats {
    static {
        Covode.recordClassIndex(654433);
    }

    private AndroidTrafficStats() {
    }

    private static long getTotalRxBytes() {
        long totalRxBytes = TrafficStats.getTotalRxBytes();
        if (totalRxBytes == -1) {
            return 0L;
        }
        return totalRxBytes;
    }

    private static long getTotalTxBytes() {
        long totalTxBytes = TrafficStats.getTotalTxBytes();
        if (totalTxBytes == -1) {
            return 0L;
        }
        return totalTxBytes;
    }

    private static long getCurrentUidRxBytes() {
        long uidRxBytes = TrafficStats.getUidRxBytes(Process.myUid());
        if (uidRxBytes == -1) {
            return 0L;
        }
        return uidRxBytes;
    }

    private static long getCurrentUidTxBytes() {
        long uidTxBytes = TrafficStats.getUidTxBytes(Process.myUid());
        if (uidTxBytes == -1) {
            return 0L;
        }
        return uidTxBytes;
    }
}
