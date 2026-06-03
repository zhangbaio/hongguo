package com.unionpay.utils;

import com.bytedance.covode.number.Covode;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i {
    static {
        Covode.recordClassIndex(654939);
    }

    public static Object a(JSONArray jSONArray, int i) {
        if (jSONArray != null && i < jSONArray.length() && i >= 0) {
            try {
                return jSONArray.get(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String b(JSONObject jSONObject, String str) {
        if (d(jSONObject, str)) {
            try {
                return jSONObject.getString(str);
            } catch (Exception unused) {
                j.d("uppay", i.class.toString() + " get " + str + " failed!!");
            }
        }
        return "";
    }

    public static JSONArray c(JSONObject jSONObject, String str) {
        if (d(jSONObject, str)) {
            try {
                return jSONObject.getJSONArray(str);
            } catch (Exception unused) {
                j.d("uppay", i.class.toString() + " get " + str + " failed!!");
            }
        }
        return null;
    }

    private static boolean d(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }
}
