package com.ss.ttm.player;

import android.media.MediaCodecInfo;
import android.os.Build;
import com.bytedance.covode.number.Covode;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class MediaCodecHelper {
    private static final List<String> amlogicDecoderPrefixes;
    private static final List<String> exynosDecoderPrefixes;
    private static final List<String> kirinDecoderPrefixes;
    private static final List<String> qualcommDecoderPrefixes;

    static {
        Covode.recordClassIndex(652121);
        LinkedList linkedList = new LinkedList();
        qualcommDecoderPrefixes = linkedList;
        linkedList.add("omx.qcom");
        linkedList.add("c2.qti");
        LinkedList linkedList2 = new LinkedList();
        kirinDecoderPrefixes = linkedList2;
        linkedList2.add("omx.hisi");
        linkedList2.add("c2.hisi");
        LinkedList linkedList3 = new LinkedList();
        exynosDecoderPrefixes = linkedList3;
        linkedList3.add("omx.exynos");
        linkedList3.add("c2.exynos");
        LinkedList linkedList4 = new LinkedList();
        amlogicDecoderPrefixes = linkedList4;
        linkedList4.add("omx.amlogic");
        linkedList4.add("c2.amlogic");
    }

    public static void disableAllowFrameDrop(AJMediaFormat aJMediaFormat) {
        if (aJMediaFormat != null && Build.VERSION.SDK_INT >= 31) {
            aJMediaFormat.setInteger("allow-frame-drop", 0);
        }
    }

    public static void setMaxOperatingRate(AJMediaFormat aJMediaFormat) {
        if (aJMediaFormat != null && Build.VERSION.SDK_INT >= 23) {
            aJMediaFormat.setInteger("operating-rate", 32767);
        }
    }

    public static boolean decoderSupportsAndroidRLowLatency(MediaCodecInfo mediaCodecInfo, String str) {
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                if (mediaCodecInfo.getCapabilitiesForType(str).isFeatureSupported("low-latency")) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static void setHisiLowLatency(AJMediaFormat aJMediaFormat, String str) {
        if (aJMediaFormat != null && isDecoderInList(kirinDecoderPrefixes, str) && Build.VERSION.SDK_INT >= 26) {
            aJMediaFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-req", 1);
            aJMediaFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-rdy", -1);
        }
    }

    public static void setImportance(AJMediaFormat aJMediaFormat, int i) {
        if (aJMediaFormat != null && i >= 0 && Build.VERSION.SDK_INT >= 35) {
            aJMediaFormat.setInteger("importance", i);
            StringBuilder sb = new StringBuilder();
            sb.append("set importance, value:");
            sb.append(i);
        }
    }

    public static void setOperatingRateBeforeOpen(AJMediaFormat aJMediaFormat, int i) {
        if (aJMediaFormat != null && Build.VERSION.SDK_INT >= 23 && i >= 0) {
            aJMediaFormat.setInteger("operating-rate", i);
            StringBuilder sb = new StringBuilder();
            sb.append("set OperatingRate, rate:");
            sb.append(i);
        }
    }

    public static void setQcomOrder(AJMediaFormat aJMediaFormat, String str) {
        if (aJMediaFormat != null && isDecoderInList(qualcommDecoderPrefixes, str) && Build.VERSION.SDK_INT >= 26) {
            aJMediaFormat.setInteger("vendor.qti-ext-dec-picture-order.enable", 1);
        }
    }

    public static void setQcomSliceDeliveryMode(AJMediaFormat aJMediaFormat, String str) {
        if (aJMediaFormat != null && isDecoderInList(qualcommDecoderPrefixes, str) && Build.VERSION.SDK_INT >= 26) {
            aJMediaFormat.setFeatureEnabled("vendor.qti-ext-dec-slice-delivery-mode.value", true);
        }
    }

    public static void setQcomTimestampReorder(AJMediaFormat aJMediaFormat, String str) {
        if (aJMediaFormat != null && isDecoderInList(qualcommDecoderPrefixes, str) && Build.VERSION.SDK_INT >= 26) {
            aJMediaFormat.setFeatureEnabled("vendor.qti-ext-dec-timestamp-reorder.value", true);
        }
    }

    public static void debugEffect(AJMediaFormat aJMediaFormat, String str) {
        if (aJMediaFormat != null && isDecoderInList(qualcommDecoderPrefixes, str) && Build.VERSION.SDK_INT >= 26) {
            aJMediaFormat.setInteger("vendor.qti-ext-vpp-demo.process-percent", 50);
            StringBuilder sb = new StringBuilder();
            sb.append("mediaformat = ");
            sb.append(aJMediaFormat.toString());
        }
    }

    private static boolean isDecoderInList(List<String> list, String str) {
        for (String str2 : list) {
            if (str.length() >= str2.length() && str.substring(0, str2.length()).equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void setPriority(AJMediaFormat aJMediaFormat, int i) {
        if (aJMediaFormat != null && Build.VERSION.SDK_INT >= 23 && i >= 0 && i <= 1) {
            aJMediaFormat.setInteger("priority", i);
            StringBuilder sb = new StringBuilder();
            sb.append("set Priority:");
            sb.append(i);
        }
    }

    public static void setHisiFrequence(AJMediaFormat aJMediaFormat, int i, String str) {
        if (aJMediaFormat != null && isDecoderInList(kirinDecoderPrefixes, str) && i >= 0 && i <= 2 && Build.VERSION.SDK_INT >= 26) {
            aJMediaFormat.setInteger("vendor.hisi-ext-frequence-request-video-dec.video-scene-for-frequence-req", i);
            StringBuilder sb = new StringBuilder();
            sb.append("set Hisi frequence, value:");
            sb.append(i);
        }
    }

    public static void setQcomCpuAffinityMask(AJMediaFormat aJMediaFormat, int i, String str) {
        if (aJMediaFormat != null && isDecoderInList(qualcommDecoderPrefixes, str) && Build.VERSION.SDK_INT >= 26) {
            aJMediaFormat.setInteger("vendor.qti-ext-cpu-affinity-set-mask.value", i);
            StringBuilder sb = new StringBuilder();
            sb.append("set Qcom cpu affinity mask, value:");
            sb.append(i);
        }
    }

    public static void setQcomEarlyNotifyValue(AJMediaFormat aJMediaFormat, int i, String str) {
        if (aJMediaFormat != null && isDecoderInList(qualcommDecoderPrefixes, str) && Build.VERSION.SDK_INT >= 26) {
            aJMediaFormat.setInteger("vendor.qti-ext-dec-early-notify.value", i);
            StringBuilder sb = new StringBuilder();
            sb.append("set Qcom early notify, value:");
            sb.append(i);
        }
    }

    public static void setLowLatency(AJMediaFormat aJMediaFormat, MediaCodecInfo mediaCodecInfo, int i) {
        if (aJMediaFormat == null) {
            return;
        }
        aJMediaFormat.setInteger("low-latency", 1);
        if ((i & 1) > 0 && decoderSupportsAndroidRLowLatency(mediaCodecInfo, aJMediaFormat.getString("mime"))) {
            return;
        }
        if ((i & 2) > 0 && Build.VERSION.SDK_INT > 23) {
            aJMediaFormat.setInteger("vdec-lowlatency", 1);
        }
        if ((i & 4) > 0 && Build.VERSION.SDK_INT >= 26) {
            if (isDecoderInList(qualcommDecoderPrefixes, mediaCodecInfo.getName())) {
                aJMediaFormat.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
            } else if (isDecoderInList(exynosDecoderPrefixes, mediaCodecInfo.getName())) {
                aJMediaFormat.setInteger("vendor.rtc-ext-dec-low-latency.enable", 1);
            } else if (isDecoderInList(amlogicDecoderPrefixes, mediaCodecInfo.getName())) {
                aJMediaFormat.setInteger("vendor.low-latency.enable", 1);
            }
        }
    }

    public static void setupVpp(AJMediaFormat aJMediaFormat, int i, String str) {
        int i2;
        if (aJMediaFormat != null && isDecoderInList(qualcommDecoderPrefixes, str) && Build.VERSION.SDK_INT >= 26) {
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
            StringBuilder sb = new StringBuilder();
            sb.append("set vpp, level:");
            sb.append(i);
        }
    }
}
