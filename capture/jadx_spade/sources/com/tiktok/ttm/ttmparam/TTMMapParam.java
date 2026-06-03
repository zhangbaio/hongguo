package com.tiktok.ttm.ttmparam;

import com.bytedance.covode.number.Covode;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTMMapParam extends ITTMParamData {
    private Map<String, Object> inputData;

    static {
        Covode.recordClassIndex(654008);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public int getType() {
        return 0;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public Object getInputData() {
        return this.inputData;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String[] getDictKeys() {
        Map<String, Object> map = this.inputData;
        if (map != null) {
            Set<String> keySet = map.keySet();
            return (String[]) keySet.toArray(new String[keySet.size()]);
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public Object[] getDictValuesImmediate() {
        Map<String, Object> map = this.inputData;
        if (map != null) {
            Collection<Object> values = map.values();
            return values.toArray(new Object[values.size()]);
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double[] getDictDoubleValuesImmediate() {
        Map<String, Object> map = this.inputData;
        if (map == null) {
            return null;
        }
        Collection<Object> values = map.values();
        double[] dArr = new double[values.size()];
        Iterator<Object> it2 = values.iterator();
        int i = 0;
        while (it2.hasNext()) {
            it2.next();
            dArr[i] = c.a(dArr, null);
            i++;
        }
        return dArr;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long[] getDictIntValuesImmediate() {
        Map<String, Object> map = this.inputData;
        if (map == null) {
            return null;
        }
        Collection<Object> values = map.values();
        long[] jArr = new long[values.size()];
        Iterator<Object> it2 = values.iterator();
        int i = 0;
        while (it2.hasNext()) {
            it2.next();
            jArr[i] = c.b(jArr, null);
            i++;
        }
        return jArr;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String[] getDictStringValuesImmediate() {
        Map<String, Object> map = this.inputData;
        if (map == null) {
            return null;
        }
        Collection<Object> values = map.values();
        String[] strArr = new String[values.size()];
        Iterator<Object> it2 = values.iterator();
        int i = 0;
        while (it2.hasNext()) {
            it2.next();
            strArr[i] = c.c(strArr, null);
            i++;
        }
        return strArr;
    }

    public TTMMapParam(Map<String, Object> map) {
        this.inputData = map;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public void removeData(String str) {
        Map<String, Object> map = this.inputData;
        if (map != null) {
            map.remove(str);
        }
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public boolean containsKey(String str) {
        Map<String, Object> map = this.inputData;
        if (map != null) {
            return map.containsKey(str);
        }
        return false;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public ITTMParamData getObjectItem(String str) {
        return a.g(this.inputData.get(str));
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double[] getAllDoubleValue(String str) {
        Map<String, Object> map;
        ITTMParamData g;
        if (str == null || (map = this.inputData) == null || (g = a.g(map.get(str))) == null) {
            return null;
        }
        return g.getAllDoubleValue(null);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long[] getAllIntValue(String str) {
        Map<String, Object> map;
        ITTMParamData g;
        if (str == null || (map = this.inputData) == null || (g = a.g(map.get(str))) == null) {
            return null;
        }
        return g.getAllIntValue(null);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String[] getAllStringValue(String str) {
        Map<String, Object> map;
        ITTMParamData g;
        if (str == null || (map = this.inputData) == null || (g = a.g(map.get(str))) == null) {
            return null;
        }
        return g.getAllStringValue(null);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public void mergeDataAsSubData(String str, ITTMParamData iTTMParamData) {
        Map<String, Object> map = this.inputData;
        if (map != null) {
            map.put(str, iTTMParamData.getInputData());
        }
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public boolean removeValue(String str, int i) {
        Map<String, Object> map;
        if (str != null && (map = this.inputData) != null) {
            map.remove(str);
            return true;
        }
        return false;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double getDoubleValue(String str, int i) {
        Map<String, Object> map;
        if (str != null && (map = this.inputData) != null) {
            return c.a(map.get(str), str);
        }
        return Double.MAX_VALUE;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long getIntValue(String str, int i) {
        Map<String, Object> map;
        if (str != null && (map = this.inputData) != null) {
            return c.b(map.get(str), str);
        }
        return Long.MAX_VALUE;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String getStringValue(String str, int i) {
        Map<String, Object> map;
        if (str != null && (map = this.inputData) != null) {
            return c.c(map.get(str), str);
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public boolean addValue(String str, int i, Object obj) {
        Map<String, Object> map;
        if (str != null && (map = this.inputData) != null) {
            map.put(str, obj);
            return true;
        }
        return false;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public boolean replaceValue(String str, int i, Object obj) {
        Map<String, Object> map;
        if (str != null && (map = this.inputData) != null && map.containsKey(str)) {
            this.inputData.put(str, obj);
            return true;
        }
        return false;
    }
}
