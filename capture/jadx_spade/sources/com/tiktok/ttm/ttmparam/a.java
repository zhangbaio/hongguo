package com.tiktok.ttm.ttmparam;

import com.bytedance.covode.number.Covode;
import com.tiktok.ttm.TTMParamData;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    static {
        Covode.recordClassIndex(654001);
    }

    public static ITTMParamData a(double d) {
        return new TTMNumberParam(d);
    }

    public static ITTMParamData b(float f) {
        return new TTMNumberParam(f);
    }

    public static ITTMParamData c(int i) {
        return new TTMNumberParam(i);
    }

    public static ITTMParamData d(long j) {
        return new TTMNumberParam(j);
    }

    public static ITTMParamData n(boolean z) {
        return new TTMNumberParam(z);
    }

    public static ITTMParamData e(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return new TTMNumberParam(bool);
    }

    public static ITTMParamData f(Number number) {
        if (number == null) {
            return null;
        }
        return new TTMNumberParam(number);
    }

    public static ITTMParamData h(String str) {
        if (str == null) {
            return null;
        }
        return new TTMStringParam(str);
    }

    public static ITTMParamData i(Collection<Object> collection) {
        if (collection == null) {
            return null;
        }
        return new TTMCollectionParam(collection);
    }

    public static ITTMParamData j(List<Object> list) {
        if (list == null) {
            return null;
        }
        return new TTMCollectionParam(list);
    }

    public static ITTMParamData k(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new TTMMapParam(map);
    }

    public static ITTMParamData l(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        return new TTMJSONArrayParam(jSONArray);
    }

    public static ITTMParamData m(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new TTMJSONObjectParam(jSONObject);
    }

    public static ITTMParamData o(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        return new TTMNumberArrayParam(dArr);
    }

    public static ITTMParamData p(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        return new TTMNumberArrayParam(fArr);
    }

    public static ITTMParamData q(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return new TTMNumberArrayParam(iArr);
    }

    public static ITTMParamData r(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        return new TTMNumberArrayParam(jArr);
    }

    public static ITTMParamData s(Number[] numberArr) {
        if (numberArr == null) {
            return null;
        }
        return new TTMNumberObjectArrayParam(numberArr);
    }

    public static ITTMParamData t(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        return new TTMStringArrayParam(strArr);
    }

    public static ITTMParamData g(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return new TTMMapParam((Map) obj);
        }
        if (obj instanceof List) {
            return new TTMCollectionParam((List<Object>) obj);
        }
        if (obj instanceof Collection) {
            return new TTMCollectionParam((Collection<Object>) obj);
        }
        if (obj instanceof String) {
            return new TTMStringParam((String) obj);
        }
        if (obj instanceof Number) {
            return new TTMNumberParam((Number) obj);
        }
        if (obj instanceof JSONObject) {
            return new TTMJSONObjectParam((JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            return new TTMJSONArrayParam((JSONArray) obj);
        }
        if (obj instanceof String[]) {
            return new TTMStringArrayParam((String[]) obj);
        }
        if (obj instanceof ITTMParamData) {
            return (ITTMParamData) obj;
        }
        if (obj instanceof TTMParamData) {
            return ((TTMParamData) obj).getActualParamData();
        }
        if (obj instanceof Number[]) {
            return new TTMNumberObjectArrayParam((Number[]) obj);
        }
        if (obj instanceof Boolean) {
            return new TTMNumberParam((Boolean) obj);
        }
        if (obj instanceof int[]) {
            return new TTMNumberArrayParam((int[]) obj);
        }
        if (obj instanceof long[]) {
            return new TTMNumberArrayParam((long[]) obj);
        }
        if (obj instanceof float[]) {
            return new TTMNumberArrayParam((float[]) obj);
        }
        if (obj instanceof double[]) {
            return new TTMNumberArrayParam((double[]) obj);
        }
        return new TTMDefaultParamData(obj);
    }
}
