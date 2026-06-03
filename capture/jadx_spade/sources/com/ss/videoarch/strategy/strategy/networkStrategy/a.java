package com.ss.videoarch.strategy.strategy.networkStrategy;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.LiveStrategyManager;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    String a;
    private JSONObject b;
    private JSONObject c;
    private ReentrantLock d;

    static {
        Covode.recordClassIndex(653182);
    }

    private static class b {
        private static final a a;

        static {
            Covode.recordClassIndex(653183);
            a = new a();
        }
    }

    public static a a() {
        return b.a;
    }

    private a() {
        this.a = "MultiPath";
        this.b = new JSONObject();
        this.c = new JSONObject();
        this.d = new ReentrantLock();
    }

    private void d() {
        JSONObject b2 = b(null);
        if (b2 != null) {
            LiveStrategyManager.inst().setConfigToLiveIO(b2.toString());
        } else {
            Log.d(this.a, "sendMultiPathInfoToLiveIO info is null");
        }
    }

    public JSONObject b(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            this.d.lock();
            jSONObject2 = this.b;
            this.d.unlock();
        } else {
            jSONObject2 = null;
        }
        Log.d(this.a, "getMultiPathInfo:" + jSONObject2);
        return jSONObject2;
    }

    public void c(JSONObject jSONObject) {
        Log.d(this.a, "notifyMultiPathChange:" + jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.d.lock();
        try {
            if (jSONObject.has("needAccess") && jSONObject.optInt("needAccess") == 1) {
                LiveStrategyManager.inst().fireNotifyToPlayer("MultiPathNeedAccess", null, "");
                this.b.put("multipath_need_access", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d.unlock();
        if (jSONObject.has("liveio_started") && jSONObject.optInt("liveio_started") == 1) {
            d();
        }
    }

    public void e(JSONObject jSONObject) {
        Log.d(this.a, "setMultiPathInfo:" + jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.d.lock();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.b.put(next, jSONObject.get(next));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d.unlock();
        d();
    }
}
