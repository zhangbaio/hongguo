package mj6;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c {
    public String a = "";
    public int b = -1;
    public int c = -1;
    public int d = 300000;
    public int e = 1;
    public int f = -1;
    public int g = 10;
    public int h = 100;
    public int i = -1;
    public int j = 10;
    public int k = 300000;
    public int l = -1;
    private String m = "";
    private String n = "";
    private String o = "";

    static {
        Covode.recordClassIndex(653118);
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.b = jSONObject.optInt("enable");
            this.m = jSONObject.optString("node_table");
            this.n = jSONObject.optString("his_table");
            this.o = jSONObject.optString("config_table");
            if (!TextUtils.isEmpty(this.n)) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2 = new JSONObject(this.n);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.f = jSONObject2.optInt("enable");
                if (jSONObject2.has("update_limit")) {
                    this.g = jSONObject2.optInt("update_limit");
                }
                if (jSONObject2.has("record_limit")) {
                    this.h = jSONObject2.optInt("record_limit");
                }
            }
            if (!TextUtils.isEmpty(this.m)) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3 = new JSONObject(this.m);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                this.c = jSONObject3.optInt("enable");
                if (jSONObject3.has("cache_time")) {
                    this.d = jSONObject3.optInt("cache_time");
                }
                if (jSONObject3.has("update_limit")) {
                    this.e = jSONObject3.optInt("update_limit");
                }
            }
            if (!TextUtils.isEmpty(this.o)) {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4 = new JSONObject(this.o);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                this.i = jSONObject4.optInt("enable");
                if (jSONObject4.has("update_limit")) {
                    this.j = jSONObject4.optInt("update_limit");
                }
                if (jSONObject4.has("delay_time")) {
                    this.k = jSONObject4.optInt("delay_time");
                }
            }
        }
        Log.d("PersistenceConfig", "Enable:" + this.b + ",his_table:" + this.n + ",node_table:" + this.m + ",config_table:" + this.o);
    }
}
