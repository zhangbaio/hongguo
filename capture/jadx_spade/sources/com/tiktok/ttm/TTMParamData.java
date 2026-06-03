package com.tiktok.ttm;

import com.bytedance.covode.number.Covode;
import com.tiktok.ttm.ttmparam.ITTMParamData;
import com.tiktok.ttm.ttmparam.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TTMParamData {
    private ITTMParamData actualParamData;

    static {
        Covode.recordClassIndex(653997);
    }

    public ITTMParamData getActualParamData() {
        return this.actualParamData;
    }

    public TTMParamData(Map<String, Object> map) {
        this.actualParamData = a.k(map);
    }

    public TTMParamData(boolean z) {
        this.actualParamData = a.n(z);
    }

    public TTMParamData(int[] iArr) {
        this.actualParamData = a.q(iArr);
    }

    public TTMParamData(long[] jArr) {
        this.actualParamData = a.r(jArr);
    }

    public TTMParamData(double[] dArr) {
        this.actualParamData = a.o(dArr);
    }

    public TTMParamData(float[] fArr) {
        this.actualParamData = a.p(fArr);
    }

    public TTMParamData(Number[] numberArr) {
        this.actualParamData = a.s(numberArr);
    }

    public TTMParamData(List<Object> list) {
        this.actualParamData = a.j(list);
    }

    public TTMParamData(String[] strArr) {
        this.actualParamData = a.t(strArr);
    }

    public TTMParamData(JSONObject jSONObject) {
        this.actualParamData = a.m(jSONObject);
    }

    public TTMParamData(JSONArray jSONArray) {
        this.actualParamData = a.l(jSONArray);
    }

    public int getArraySize() {
        return GetArraySize();
    }

    public String[] getDictKeys() {
        return GetDictKeys();
    }

    private double[] jniGetDictDoubleValuesImmediate() {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return null;
            }
            return iTTMParamData.getDictDoubleValuesImmediate();
        } catch (Throwable unused) {
            return null;
        }
    }

    private long[] jniGetDictIntValuesImmediate() {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return null;
            }
            return iTTMParamData.getDictIntValuesImmediate();
        } catch (Throwable unused) {
            return null;
        }
    }

    private String[] jniGetDictStringValuesImmediate() {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return null;
            }
            return iTTMParamData.getDictStringValuesImmediate();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static TTMParamData newEmptyListData() {
        return new TTMParamData((List<Object>) new ArrayList());
    }

    public static TTMParamData newEmptyMapData() {
        return new TTMParamData((Map<String, Object>) new HashMap());
    }

    public int GetArraySize() {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return 0;
            }
            return iTTMParamData.getArraySize();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public String[] GetDictKeys() {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return null;
            }
            return iTTMParamData.getDictKeys();
        } catch (Throwable unused) {
            return null;
        }
    }

    public Object[] GetDictValuesImmediate() {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return null;
            }
            return iTTMParamData.getDictValuesImmediate();
        } catch (Throwable unused) {
            return null;
        }
    }

    public double GetDoubleValue() {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return Double.MAX_VALUE;
            }
            return iTTMParamData.getDoubleValue();
        } catch (Throwable unused) {
            return Double.MAX_VALUE;
        }
    }

    public long GetIntValue() {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return Long.MAX_VALUE;
            }
            return iTTMParamData.getIntValue();
        } catch (Throwable unused) {
            return Long.MAX_VALUE;
        }
    }

    public String GetStringValue() {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return null;
            }
            return iTTMParamData.getStringValue();
        } catch (Throwable unused) {
            return null;
        }
    }

    public Object getInputData() {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return null;
            }
            return iTTMParamData.getInputData();
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getType() {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return 13;
        }
        return iTTMParamData.getType();
    }

    public void setActualParamData(ITTMParamData iTTMParamData) {
        this.actualParamData = iTTMParamData;
    }

    public TTMParamData(ITTMParamData iTTMParamData) {
        this.actualParamData = iTTMParamData;
    }

    public TTMParamData getArrayItem(int i) {
        return GetArrayItem(i);
    }

    public TTMParamData getObjectItem(String str) {
        return GetObjectItem(str);
    }

    public TTMParamData(double d) {
        this.actualParamData = a.a(d);
    }

    private boolean jniDictContainsKey(String str) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return false;
            }
            return iTTMParamData.containsKey(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    private double[] jniGetAllDoubleValue(String str) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return null;
            }
            return iTTMParamData.getAllDoubleValue(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private long[] jniGetAllIntValue(String str) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return null;
            }
            return iTTMParamData.getAllIntValue(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private String[] jniGetAllStringValue(String str) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return null;
            }
            return iTTMParamData.getAllStringValue(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void AddArrayItem(TTMParamData tTMParamData) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return;
            }
            iTTMParamData.addArrayItem(tTMParamData.actualParamData);
        } catch (Throwable unused) {
        }
    }

    public boolean containsKey(String str) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return false;
            }
            return iTTMParamData.containsKey(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public double getDoubleValue(int i) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return Double.MAX_VALUE;
            }
            return iTTMParamData.getDoubleValue(null, i);
        } catch (Throwable unused) {
            return Double.MAX_VALUE;
        }
    }

    public long getIntValue(int i) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return Long.MAX_VALUE;
            }
            return iTTMParamData.getIntValue(null, i);
        } catch (Throwable unused) {
            return Long.MAX_VALUE;
        }
    }

    public String getStringValue(int i) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return null;
            }
            return iTTMParamData.getStringValue(null, i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void removeData(String str) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return;
            }
            iTTMParamData.removeData(str);
        } catch (Throwable unused) {
        }
    }

    public boolean removeKey(String str) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return false;
            }
            return iTTMParamData.removeValue(str, Integer.MAX_VALUE);
        } catch (Throwable unused) {
            return false;
        }
    }

    public TTMParamData(float f) {
        this.actualParamData = a.b(f);
    }

    public TTMParamData GetArrayItem(int i) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return null;
            }
            return new TTMParamData(iTTMParamData.getArrayItem(i));
        } catch (Throwable unused) {
            return null;
        }
    }

    public TTMParamData GetObjectItem(String str) {
        ITTMParamData objectItem;
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData != null && (objectItem = iTTMParamData.getObjectItem(str)) != null) {
                return new TTMParamData(objectItem);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public double getDoubleValue(String str) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return Double.MAX_VALUE;
            }
            return iTTMParamData.getDoubleValue(str, Integer.MAX_VALUE);
        } catch (Throwable unused) {
            return Double.MAX_VALUE;
        }
    }

    public long getIntValue(String str) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return Long.MAX_VALUE;
            }
            return iTTMParamData.getIntValue(str, Integer.MAX_VALUE);
        } catch (Throwable unused) {
            return Long.MAX_VALUE;
        }
    }

    public String getStringValue(String str) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return null;
            }
            return iTTMParamData.getStringValue(str, Integer.MAX_VALUE);
        } catch (Throwable unused) {
            return null;
        }
    }

    public TTMParamData(int i) {
        this.actualParamData = a.c(i);
    }

    public TTMParamData(long j) {
        this.actualParamData = a.d(j);
    }

    public TTMParamData(Boolean bool) {
        this.actualParamData = a.e(bool);
    }

    public TTMParamData(Object obj) {
        this.actualParamData = a.g(obj);
    }

    public TTMParamData(String str) {
        this.actualParamData = a.h(str);
    }

    public TTMParamData(Collection<Object> collection) {
        this.actualParamData = a.i(collection);
    }

    private double JniGetDoubleValue(String str, int i) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return Double.MAX_VALUE;
            }
            return iTTMParamData.getDoubleValue(str, i);
        } catch (Throwable unused) {
            return Double.MAX_VALUE;
        }
    }

    private long JniGetIntValue(String str, int i) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return Long.MAX_VALUE;
            }
            return iTTMParamData.getIntValue(str, i);
        } catch (Throwable unused) {
            return Long.MAX_VALUE;
        }
    }

    private String JniGetStringValue(String str, int i) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return null;
            }
            return iTTMParamData.getStringValue(str, i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean addValue(String str, Object obj) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return false;
            }
            return iTTMParamData.addValue(str, Integer.MAX_VALUE, obj);
        } catch (Throwable unused) {
            return false;
        }
    }

    public void mergeDataAsSubData(String str, TTMParamData tTMParamData) {
        try {
            ITTMParamData iTTMParamData = this.actualParamData;
            if (iTTMParamData == null) {
                return;
            }
            iTTMParamData.mergeDataAsSubData(str, tTMParamData.actualParamData);
        } catch (Throwable unused) {
        }
    }

    private boolean jniModifyData(String str, int i, double d, int i2) {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return false;
        }
        if (i2 != 0) {
            if (i2 == 1) {
                return iTTMParamData.addValue(str, i, Double.valueOf(d));
            }
            return false;
        }
        return iTTMParamData.replaceValue(str, i, Double.valueOf(d));
    }

    private boolean jniModifyData(String str, int i, long j, int i2) {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return false;
        }
        if (i2 != 0) {
            if (i2 == 1) {
                return iTTMParamData.addValue(str, i, Long.valueOf(j));
            }
            return false;
        }
        return iTTMParamData.replaceValue(str, i, Long.valueOf(j));
    }

    private boolean jniModifyData(String str, int i, Object obj, int i2) {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return false;
        }
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        if (obj instanceof TTMParamData) {
                            obj = ((TTMParamData) obj).getInputData();
                        }
                        return this.actualParamData.addValue(str, i, obj);
                    }
                    return false;
                }
                return iTTMParamData.removeValue(str, i);
            }
            return iTTMParamData.addValue(str, i, obj);
        }
        return iTTMParamData.replaceValue(str, i, obj);
    }
}
