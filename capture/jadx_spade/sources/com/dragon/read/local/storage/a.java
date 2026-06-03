package com.dragon.read.local.storage;

import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.local.KvCacheMgr;
import com.dragon.read.util.DebugManager;
import ob2.i;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class a {
    private static final boolean e;
    private static boolean f;
    private final int a = 1;
    private final int b = 2;
    private final int c = 3;
    private final int d = 4;

    public abstract JSONObject a(String str, boolean z, JSONObject jSONObject);

    public abstract JSONObject c(String str, boolean z, JSONObject jSONObject);

    public abstract JSONObject d(String str, String str2, boolean z, JSONObject jSONObject);

    static {
        Covode.recordClassIndex(611936);
        f = false;
        e = i.b().enableNewStorage;
    }

    private static boolean e() {
        if ((DebugManager.isDebugBuild() && DebugManager.inst().isNewJsStorage()) || e) {
            return true;
        }
        return false;
    }

    public static a b() {
        if (e()) {
            return JsStorageManagerV2.g;
        }
        if (!f) {
            f = true;
            KvCacheMgr.createSelfControl(App.context(), "js_storage_stats").edit().clear().apply();
        }
        return b.b();
    }
}
