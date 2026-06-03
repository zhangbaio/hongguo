package com.dragon.read.local.storage;

import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dragon.base.ssconfig.model.JsStorageConfigModel;
import com.dragon.read.app.App;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.base.util.ThreadUtils;
import com.dragon.read.local.KvCacheMgr;
import com.tencent.mmkv.MMKV;
import java.util.HashMap;
import java.util.Map;
import ob2.i;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class b extends com.dragon.read.local.storage.a {
    private static volatile com.dragon.read.local.storage.a t;
    private Map<String, String> k;
    private int o;
    private int p;
    private int q;
    private volatile boolean r;
    private final int g = 1;
    private final int h = 2;
    private final int i = 3;
    private final int j = 4;
    private final Object l = new Object();
    private final int m = 0;
    private volatile int n = 0;
    private LogHelper s = new LogHelper("js_storage_v1");

    static {
        Covode.recordClassIndex(611937);
    }

    private void n() {
        ThreadUtils.postInBackground(new a());
    }

    public static com.dragon.read.local.storage.a b() {
        if (t == null) {
            synchronized (b.class) {
                if (t == null) {
                    t = new b();
                }
            }
        }
        return t;
    }

    private Map<String, String> k() {
        if (this.k == null) {
            this.k = new HashMap();
            this.o = 0;
        }
        return this.k;
    }

    private void o() {
        JsStorageConfigModel b = i.b();
        boolean z = true;
        if (b.openJsStorage != 1) {
            z = false;
        }
        this.r = z;
        this.p = b.maxDiskOccupy;
        this.q = b.maxMemoryOccupy;
    }

    private b() {
        o();
        n();
    }

    class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(MMKV.getRootDir());
            int i = 0;
            for (int i2 = 0; i2 < 29; i2++) {
                PolarisFileWrapper polarisFileWrapper2 = new PolarisFileWrapper(polarisFileWrapper, "js_storage" + i2);
                if (polarisFileWrapper2.exists()) {
                    i += (int) polarisFileWrapper2.length();
                    b.this.s.d(i2 + " total disk occupy " + i, new Object[0]);
                }
            }
            b bVar = b.this;
            bVar.s(bVar.n + i);
        }

        a() {
        }
    }

    private boolean r(JSONObject jSONObject) {
        if (!this.r) {
            p(jSONObject, 3);
        }
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i) {
        synchronized (this.l) {
            this.n = i;
        }
    }

    private SharedPreferences l(String str) {
        int abs = Math.abs(str.hashCode()) % 29;
        return KvCacheMgr.createSelfControl(App.context(), "js_storage" + abs);
    }

    private boolean m(String str, JSONObject jSONObject) {
        if (!r(jSONObject)) {
            return false;
        }
        return j(str, jSONObject);
    }

    private void p(JSONObject jSONObject, int i) {
        if (jSONObject != null) {
            try {
                jSONObject.put("status", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private int i(String str, String str2) {
        int length;
        int i = 0;
        if (str == null) {
            length = 0;
        } else {
            length = str.length() * 2;
        }
        if (str2 != null) {
            i = str2.length() * 2;
        }
        return i - length;
    }

    private boolean j(String str, JSONObject jSONObject) {
        if (str == null) {
            this.s.i("key is null", new Object[0]);
            p(jSONObject, 2);
            return false;
        }
        return true;
    }

    private int q(String str, String str2) {
        int i = 0;
        if (str != null) {
            i = 0 + str.length();
        }
        if (str2 != null) {
            i += str2.length();
        }
        return i * 2;
    }

    @Override // com.dragon.read.local.storage.a
    public JSONObject a(String str, boolean z, JSONObject jSONObject) {
        boolean z2 = true;
        this.s.i("[getStorage], key = %s", new Object[]{str});
        if (!m(str, jSONObject)) {
            this.s.e("hasStorageConditions = false", new Object[0]);
            return jSONObject;
        }
        String str2 = null;
        if (z) {
            SharedPreferences l = l(str);
            if (l != null && l.contains(str)) {
                str2 = l.getString(str, null);
            }
            z2 = false;
        } else {
            Map<String, String> k = k();
            if (k.containsKey(str)) {
                str2 = k.get(str);
            }
            z2 = false;
        }
        if (z2) {
            try {
                p(jSONObject, 0);
                jSONObject.put("value", str2);
                this.s.e("[getStorage] success", new Object[0]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            this.s.e("[getStorage] key does not exist, isDiskStorage = " + z, new Object[0]);
            p(jSONObject, 4);
        }
        return jSONObject;
    }

    @Override // com.dragon.read.local.storage.a
    public JSONObject c(String str, boolean z, JSONObject jSONObject) {
        boolean z2;
        this.s.i("[removeStorage], key = %s", new Object[]{str});
        if (!m(str, jSONObject)) {
            return jSONObject;
        }
        if (z) {
            SharedPreferences l = l(str);
            if (l != null && l.contains(str)) {
                s(this.n - q(str, l.getString(str, null)));
                l.edit().remove(str).putInt("disk_occupy", this.n).apply();
                z2 = true;
            }
            z2 = false;
        } else {
            Map<String, String> k = k();
            if (k.containsKey(str)) {
                this.o -= q(str, k.get(str));
                k.remove(str);
                z2 = true;
            }
            z2 = false;
        }
        if (z2) {
            p(jSONObject, 0);
            this.s.e("[removeStorage] success", new Object[0]);
        } else {
            this.s.e("[removeStorage] key does not exist,iisDiskStorage = %s", new Object[]{Boolean.valueOf(z)});
            p(jSONObject, 4);
        }
        return jSONObject;
    }

    @Override // com.dragon.read.local.storage.a
    public JSONObject d(String str, String str2, boolean z, JSONObject jSONObject) {
        int q;
        boolean z2;
        int q2;
        this.s.i("[setStorage] key = %s", new Object[]{str});
        if (!m(str, jSONObject)) {
            this.s.e("hasStorageConditions = false", new Object[0]);
            return jSONObject;
        }
        if (z) {
            SharedPreferences l = l(str);
            if (l != null) {
                if (l.contains(str)) {
                    q2 = i(l.getString(str, null), str2);
                } else {
                    q2 = q(str, str2);
                }
                if (this.n == 0) {
                    this.n = l.getInt("disk_occupy", 0);
                }
                int i = q2 + this.n;
                if (i <= this.p) {
                    s(i);
                    l.edit().putString(str, str2).putInt("disk_occupy", this.n).apply();
                    z2 = true;
                }
            }
            z2 = false;
        } else {
            Map<String, String> k = k();
            if (k.containsKey(str)) {
                q = i(k.get(str), str2);
            } else {
                q = q(str, str2);
            }
            int i2 = q + this.o;
            if (i2 <= this.q) {
                k.put(str, str2);
                this.o = i2;
                z2 = true;
            } else {
                k.clear();
                z2 = false;
            }
        }
        if (z2) {
            this.s.e("[setStorage] success", new Object[0]);
            p(jSONObject, 0);
        } else {
            this.s.e("[setStorage] storage beyond occupy, isDiskStorage = " + z, new Object[0]);
            p(jSONObject, 1);
        }
        return jSONObject;
    }
}
