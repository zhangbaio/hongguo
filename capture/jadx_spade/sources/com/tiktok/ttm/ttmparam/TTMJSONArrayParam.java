package com.tiktok.ttm.ttmparam;

import com.bytedance.covode.number.Covode;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTMJSONArrayParam extends ITTMParamData {
    private JSONArray value;

    static {
        Covode.recordClassIndex(654006);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public int getType() {
        return 11;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public Object getInputData() {
        return this.value;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public int getArraySize() {
        JSONArray jSONArray = this.value;
        if (jSONArray != null) {
            return jSONArray.length();
        }
        return 0;
    }

    public TTMJSONArrayParam(JSONArray jSONArray) {
        this.value = jSONArray;
    }

    private Object getObjectValue(int i) {
        int realIndex = getRealIndex(i);
        if (realIndex == -1) {
            return null;
        }
        try {
            return this.value.get(realIndex);
        } catch (JSONException unused) {
            return null;
        }
    }

    private int getRealIndex(int i) {
        if (i < 0) {
            i += this.value.length();
        }
        if (i >= 0 && i < this.value.length()) {
            return i;
        }
        return -1;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public ITTMParamData getArrayItem(int i) {
        if (this.value != null) {
            try {
                int realIndex = getRealIndex(i);
                if (realIndex == -1) {
                    return null;
                }
                return a.g(this.value.get(realIndex));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double[] getAllDoubleValue(String str) {
        JSONArray jSONArray = this.value;
        if (jSONArray != null) {
            double[] dArr = new double[jSONArray.length()];
            int i = 0;
            for (int i2 = 0; i2 < this.value.length(); i2++) {
                try {
                    int i3 = i + 1;
                    try {
                        dArr[i] = c.a(this.value.get(i2), str);
                        i = i3;
                    } catch (JSONException unused) {
                        i = i3;
                        dArr[i] = Double.MAX_VALUE;
                        i++;
                    }
                } catch (JSONException unused2) {
                }
            }
            return dArr;
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long[] getAllIntValue(String str) {
        JSONArray jSONArray = this.value;
        if (jSONArray != null) {
            long[] jArr = new long[jSONArray.length()];
            int i = 0;
            for (int i2 = 0; i2 < this.value.length(); i2++) {
                try {
                    int i3 = i + 1;
                    try {
                        jArr[i] = c.b(this.value.get(i2), str);
                        i = i3;
                    } catch (JSONException unused) {
                        i = i3;
                        jArr[i] = Long.MAX_VALUE;
                        i++;
                    }
                } catch (JSONException unused2) {
                }
            }
            return jArr;
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String[] getAllStringValue(String str) {
        JSONArray jSONArray = this.value;
        if (jSONArray == null || str != null) {
            return null;
        }
        String[] strArr = new String[jSONArray.length()];
        int i = 0;
        for (int i2 = 0; i2 < this.value.length(); i2++) {
            try {
                int i3 = i + 1;
                try {
                    strArr[i] = c.c(this.value.get(i2), str);
                    i = i3;
                } catch (JSONException unused) {
                    i = i3;
                    strArr[i] = null;
                    i++;
                }
            } catch (JSONException unused2) {
            }
        }
        return strArr;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double getDoubleValue(String str, int i) {
        return c.a(getObjectValue(i), str);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long getIntValue(String str, int i) {
        return c.b(getObjectValue(i), str);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String getStringValue(String str, int i) {
        return c.c(getObjectValue(i), str);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public boolean removeValue(String str, int i) {
        int realIndex;
        if (i == Integer.MAX_VALUE || this.value == null || (realIndex = getRealIndex(i)) == -1) {
            return false;
        }
        this.value.remove(realIndex);
        return true;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public boolean replaceValue(String str, int i, Object obj) {
        if (i != Integer.MAX_VALUE && this.value != null) {
            long realIndex = getRealIndex(i);
            if (realIndex == -1) {
                return false;
            }
            try {
                this.value.put((int) realIndex, obj);
                return true;
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public boolean addValue(String str, int i, Object obj) {
        JSONArray jSONArray = this.value;
        if (jSONArray != null) {
            try {
                if (obj instanceof Map) {
                    jSONArray.put(new JSONObject((Map) obj));
                    return true;
                }
                if (jSONArray instanceof Collection) {
                    jSONArray.put(new JSONArray((Collection) obj));
                    return true;
                }
                jSONArray.put(obj);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
