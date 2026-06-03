package com.tiktok.ttm.ttmparam;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c {
    static {
        Covode.recordClassIndex(654013);
    }

    public static String c(Object obj, String str) {
        try {
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof ITTMParamData) {
                return ((ITTMParamData) obj).getStringValue(str, Integer.MAX_VALUE);
            }
            if (obj instanceof Number) {
                return obj.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static double a(Object obj, String str) {
        try {
            if (obj instanceof Number) {
                return ((Number) obj).doubleValue();
            }
            if (obj instanceof Boolean) {
                if (((Boolean) obj).booleanValue()) {
                    return 1.0d;
                }
                return 0.0d;
            }
            if (obj instanceof String) {
                return Double.parseDouble((String) obj);
            }
            if (obj instanceof ITTMParamData) {
                return ((ITTMParamData) obj).getDoubleValue(str, Integer.MAX_VALUE);
            }
            return Double.MAX_VALUE;
        } catch (Exception unused) {
            return Double.MAX_VALUE;
        }
    }

    public static long b(Object obj, String str) {
        try {
            if (obj instanceof Number) {
                return ((Number) obj).longValue();
            }
            if (obj instanceof Boolean) {
                if (((Boolean) obj).booleanValue()) {
                    return 1L;
                }
                return 0L;
            }
            if (obj instanceof String) {
                return Long.parseLong((String) obj);
            }
            if (obj instanceof ITTMParamData) {
                return ((ITTMParamData) obj).getIntValue(str, Integer.MAX_VALUE);
            }
            return Long.MAX_VALUE;
        } catch (Exception unused) {
            return Long.MAX_VALUE;
        }
    }
}
