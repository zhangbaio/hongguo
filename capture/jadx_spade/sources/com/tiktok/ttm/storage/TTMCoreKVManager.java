package com.tiktok.ttm.storage;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTMCoreKVManager {
    Type listType = new a().getType();
    Type dictType = new b().getType();
    Gson gson = new Gson();

    static native boolean nativeInit();

    native boolean nativeContainKey(String str);

    native boolean nativeGetBoolValue(String str);

    native double nativeGetDoubleValue(String str);

    native long nativeGetLongValue(String str);

    native String nativeGetStringValue(String str);

    native void nativeRemoveKey(String str);

    native void nativeStoreDoubleValue(String str, double d);

    native void nativeStoreLongValue(String str, long j);

    native void nativeStoreStringValue(String str, String str2);

    public static void forceInit() {
        Log.d("TTM/TTMCore", "TTMCoreKVManager forceInit");
    }

    static {
        Covode.recordClassIndex(653999);
        Keva.forceInit();
        System.loadLibrary("TTMachineCore");
        nativeInit();
    }

    class a extends TypeToken<List<Object>> {
        a() {
        }
    }

    class b extends TypeToken<Map<String, Object>> {
        b() {
        }
    }

    public void removeKey(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            nativeRemoveKey(str + str2);
        }
    }

    public boolean containKey(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return nativeContainKey(str + str2);
        }
        return false;
    }

    public boolean getBoolValue(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return nativeGetBoolValue(str + str2);
        }
        return false;
    }

    public Map<String, Object> getDictValue(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String nativeGetStringValue = nativeGetStringValue(str + str2);
            if (TextUtils.isEmpty(nativeGetStringValue)) {
                return null;
            }
            try {
                return (Map) this.gson.fromJson(nativeGetStringValue, this.dictType);
            } catch (Exception e) {
                Log.d("TTM/TTMCore", e.toString());
            }
        }
        return null;
    }

    public double getDoubleValue(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return nativeGetDoubleValue(str + str2);
        }
        return 0.0d;
    }

    public List<Object> getListValue(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String nativeGetStringValue = nativeGetStringValue(str + str2);
            if (TextUtils.isEmpty(nativeGetStringValue)) {
                return null;
            }
            try {
                return (List) this.gson.fromJson(nativeGetStringValue, this.listType);
            } catch (Exception e) {
                Log.d("TTM/TTMCore", e.toString());
            }
        }
        return null;
    }

    public long getLongValue(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return nativeGetLongValue(str + str2);
        }
        return 0L;
    }

    public String getStringValue(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        String nativeGetStringValue = nativeGetStringValue(str + str2);
        if (nativeGetStringValue == null) {
            return "";
        }
        return nativeGetStringValue;
    }

    public void storeDoubleValue(String str, String str2, double d) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            nativeStoreDoubleValue(str + str2, d);
        }
    }

    public void storeLongValue(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            nativeStoreLongValue(str + str2, j);
        }
    }

    public void storeBoolValue(String str, String str2, boolean z) {
        long j;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = str + str2;
            if (z) {
                j = 1;
            } else {
                j = 0;
            }
            nativeStoreLongValue(str3, j);
        }
    }

    public void storeDictValue(String str, String str2, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && map != null) {
            try {
                String json = this.gson.toJson(map);
                if (json != null) {
                    nativeStoreStringValue(str + str2, json);
                }
            } catch (Exception e) {
                Log.d("TTM/TTMCore", e.toString());
            }
        }
    }

    public void storeListValue(String str, String str2, List<Object> list) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && list != null) {
            try {
                String json = this.gson.toJson(list);
                if (json != null) {
                    nativeStoreStringValue(str + str2, json);
                }
            } catch (Exception e) {
                Log.d("TTM/TTMCore", e.toString());
            }
        }
    }

    public void storeStringValue(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str3 != null) {
            nativeStoreStringValue(str + str2, str3);
        }
    }
}
