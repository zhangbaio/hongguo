package com.ss.videoarch.strategy.network;

import com.bytedance.covode.number.Covode;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class NetworkMonitor implements b {
    static {
        Covode.recordClassIndex(653154);
    }

    @Override // com.ss.videoarch.strategy.network.b
    public int getNetworkType() {
        com.ss.videoarch.strategy.log.strategyMonitor.a.a();
        return SDKMonitorUtils.getInstance(com.ss.videoarch.strategy.log.strategyMonitor.a.b).getNetWorkType();
    }

    public String getStringNetworkType() {
        String str;
        int networkType = getNetworkType();
        if (networkType != 1) {
            if (networkType != 2) {
                if (networkType != 3) {
                    if (networkType != 4) {
                        if (networkType != 5) {
                            str = "NONE";
                        } else {
                            str = "4g";
                        }
                    } else {
                        str = "wifi";
                    }
                } else {
                    str = "3g";
                }
            } else {
                str = "2g";
            }
        } else {
            str = "mobile";
        }
        return str.toUpperCase();
    }
}
