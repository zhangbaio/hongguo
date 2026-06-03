package com.tiktok.ttm.ttmparam;

import com.bytedance.covode.number.Covode;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTMJSONObjectParam extends ITTMParamData {
    private JSONObject value;

    static {
        Covode.recordClassIndex(654007);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public int getType() {
        return 10;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public Object getInputData() {
        return this.value;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double[] getDictDoubleValuesImmediate() {
        try {
            JSONObject jSONObject = this.value;
            if (jSONObject != null) {
                double[] dArr = new double[jSONObject.length()];
                Iterator<String> keys = this.value.keys();
                int i = 0;
                while (keys.hasNext()) {
                    int i2 = i + 1;
                    dArr[i] = c.a(this.value.get(keys.next()), null);
                    i = i2;
                }
                return dArr;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long[] getDictIntValuesImmediate() {
        try {
            JSONObject jSONObject = this.value;
            if (jSONObject != null) {
                long[] jArr = new long[jSONObject.length()];
                Iterator<String> keys = this.value.keys();
                int i = 0;
                while (keys.hasNext()) {
                    int i2 = i + 1;
                    jArr[i] = c.b(this.value.get(keys.next()), null);
                    i = i2;
                }
                return jArr;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String[] getDictKeys() {
        try {
            JSONObject jSONObject = this.value;
            if (jSONObject != null) {
                String[] strArr = new String[jSONObject.length()];
                Iterator<String> keys = this.value.keys();
                int i = 0;
                while (keys.hasNext()) {
                    int i2 = i + 1;
                    strArr[i] = keys.next();
                    i = i2;
                }
                return strArr;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String[] getDictStringValuesImmediate() {
        try {
            JSONObject jSONObject = this.value;
            if (jSONObject != null) {
                String[] strArr = new String[jSONObject.length()];
                Iterator<String> keys = this.value.keys();
                int i = 0;
                while (keys.hasNext()) {
                    int i2 = i + 1;
                    strArr[i] = c.c(this.value.get(keys.next()), null);
                    i = i2;
                }
                return strArr;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public Object[] getDictValuesImmediate() {
        try {
            JSONObject jSONObject = this.value;
            if (jSONObject != null) {
                Object[] objArr = new Object[jSONObject.length()];
                Iterator<String> keys = this.value.keys();
                int i = 0;
                while (keys.hasNext()) {
                    int i2 = i + 1;
                    objArr[i] = this.value.get(keys.next());
                    i = i2;
                }
                return objArr;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public TTMJSONObjectParam(JSONObject jSONObject) {
        this.value = jSONObject;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public void removeData(String str) {
        JSONObject jSONObject;
        if (str != null && (jSONObject = this.value) != null) {
            try {
                jSONObject.remove(str);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public boolean containsKey(String str) {
        JSONObject jSONObject = this.value;
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                if (Objects.equals(keys.next(), str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double[] getAllDoubleValue(String str) {
        JSONObject jSONObject;
        if (str != null && (jSONObject = this.value) != null) {
            try {
                ITTMParamData g = a.g(jSONObject.get(str));
                if (g != null) {
                    return g.getAllDoubleValue(null);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long[] getAllIntValue(String str) {
        JSONObject jSONObject;
        if (str != null && (jSONObject = this.value) != null) {
            try {
                ITTMParamData g = a.g(jSONObject.get(str));
                if (g != null) {
                    return g.getAllIntValue(null);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String[] getAllStringValue(String str) {
        JSONObject jSONObject;
        if (str != null && (jSONObject = this.value) != null) {
            try {
                ITTMParamData g = a.g(jSONObject.get(str));
                if (g != null) {
                    return g.getAllStringValue(null);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public ITTMParamData getObjectItem(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = this.value;
                if (jSONObject != null) {
                    return a.g(jSONObject.get(str));
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public void mergeDataAsSubData(String str, ITTMParamData iTTMParamData) {
        JSONObject jSONObject;
        if (str != null && iTTMParamData != null && (jSONObject = this.value) != null) {
            try {
                jSONObject.put(str, iTTMParamData.getInputData());
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public boolean removeValue(String str, int i) {
        JSONObject jSONObject;
        if (str != null && (jSONObject = this.value) != null) {
            jSONObject.remove(str);
            return true;
        }
        return false;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double getDoubleValue(String str, int i) {
        JSONObject jSONObject;
        if (str != null && (jSONObject = this.value) != null) {
            try {
                return c.a(jSONObject.get(str), str);
            } catch (Exception unused) {
                return Double.MAX_VALUE;
            }
        }
        return Double.MAX_VALUE;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long getIntValue(String str, int i) {
        JSONObject jSONObject;
        if (str != null && (jSONObject = this.value) != null) {
            try {
                return c.b(jSONObject.get(str), str);
            } catch (Exception unused) {
                return Long.MAX_VALUE;
            }
        }
        return Long.MAX_VALUE;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String getStringValue(String str, int i) {
        JSONObject jSONObject;
        if (str != null && (jSONObject = this.value) != null) {
            try {
                return c.c(jSONObject.get(str), str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public boolean addValue(String str, int i, Object obj) {
        JSONObject jSONObject;
        if (str != null && (jSONObject = this.value) != null) {
            try {
                if (obj instanceof Map) {
                    jSONObject.put(str, new JSONObject((Map) obj));
                    return true;
                }
                if (obj instanceof Collection) {
                    jSONObject.put(str, new JSONArray((Collection) obj));
                    return true;
                }
                jSONObject.put(str, obj);
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public boolean replaceValue(String str, int i, Object obj) {
        if (str != null && this.value != null) {
            try {
                if (containsKey(str)) {
                    if (obj instanceof Map) {
                        this.value.put(str, new JSONObject((Map) obj));
                    } else if (obj instanceof Collection) {
                        this.value.put(str, new JSONArray((Collection) obj));
                    } else {
                        this.value.put(str, obj);
                    }
                }
                return true;
            } catch (JSONException unused) {
            }
        }
        return false;
    }
}
