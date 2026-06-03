package com.ss.ttm.player;

import android.util.Log;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class VendorQTI {
    static {
        Covode.recordClassIndex(652211);
    }

    public static void enableLowLatency(AJMediaFormat aJMediaFormat) {
        if (aJMediaFormat == null) {
            return;
        }
        aJMediaFormat.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
    }

    public static void debugEffect(AJMediaFormat aJMediaFormat) {
        if (aJMediaFormat == null) {
            return;
        }
        aJMediaFormat.setInteger("vendor.qti-ext-vpp-demo.process-percent", 50);
        Log.d("VendorQTI", "mediaformat = " + aJMediaFormat.toString());
    }

    public static void setupVpp(AJMediaFormat aJMediaFormat, int i) {
        int i2;
        if (aJMediaFormat == null) {
            return;
        }
        aJMediaFormat.setString("vendor.qti-ext-vpp.mode", "HQV_MODE_MANUAL");
        if (i != 0 && i != 1) {
            if (i != 2) {
                return;
            }
            aJMediaFormat.setInteger("vendor.qti-ext-vpp-cade.cade-level", 15);
            aJMediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-gain", 70);
            aJMediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-offset", 70);
            aJMediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-str", 50);
        } else {
            if (i == 0) {
                i2 = 10;
            } else {
                i2 = 20;
            }
            aJMediaFormat.setInteger("vendor.qti-ext-vpp-cade.cade-level", i2);
            aJMediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-gain", 65);
            aJMediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-offset", 60);
            aJMediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-str", 50);
        }
        aJMediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-brightness-low", 20);
        aJMediaFormat.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-brightness-high", 20);
    }
}
