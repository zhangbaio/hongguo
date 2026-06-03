package com.ss.videoarch.strategy.utils.smartStrategy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.pitaya.api.IPitayaCore;
import com.bytedance.pitaya.api.PTYCustomURLHost;
import com.bytedance.pitaya.api.PTYDIDCallback;
import com.bytedance.pitaya.api.PTYNormalCallback;
import com.bytedance.pitaya.api.PTYPackageFilterCallback;
import com.bytedance.pitaya.api.PTYPyBinderCallback;
import com.bytedance.pitaya.api.PTYSettingsCallback;
import com.bytedance.pitaya.api.PTYSetupCallback;
import com.bytedance.pitaya.api.PTYTaskResultCallback;
import com.bytedance.pitaya.api.PTYUIDCallback;
import com.bytedance.pitaya.api.PitayaCoreFactory;
import com.bytedance.pitaya.api.bean.PTYError;
import com.bytedance.pitaya.api.bean.PTYSetupInfo;
import com.bytedance.pitaya.api.bean.PTYTaskConfig;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import com.bytedance.pitaya.api.feature.store.PTYFeatureProducer;
import com.bytedance.pitaya.api.feature.store.PTYFeatureStoreInstance;
import com.bytedance.pitaya.api.mutilinstance.HostSetupListener;
import com.bytedance.pitaya.api.mutilinstance.HostSetupWatcher;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.videoarch.strategy.featureCenter.FeatureFactory;
import com.ss.videoarch.strategy.log.strategyMonitor.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PitayaWrapper {
    private static volatile PitayaWrapper l;
    public StreamStrategyFeatureProducer j;
    public Handler a = new HandlerDelegate(Looper.getMainLooper());
    private final String b = "PitayaWrapper";
    private String c = "330361";
    private JSONObject d = null;
    private String e = "";
    private String f = "";
    private String g = "";
    public long h = 180000;
    public int i = -1;
    private PitayaBridge k = new PitayaBridge();

    static class StreamStrategyFeatureProducer extends PTYFeatureProducer {
        private final String FEATURE_GROUP_NAME = "live_stream_strategy_feature_group";

        static {
            Covode.recordClassIndex(653232);
        }

        public String getGroupName() {
            return "live_stream_strategy_feature_group";
        }

        public float getNumericFeature(String str, JSONObject jSONObject) {
            return 0.0f;
        }

        public JSONArray getSeqFeature(String str, JSONObject jSONObject) {
            return null;
        }

        public String getStringFeature(String str, JSONObject jSONObject) {
            return null;
        }

        StreamStrategyFeatureProducer() {
        }

        public JSONObject getDictFeature(String str, JSONObject jSONObject) {
            return FeatureFactory.inst().featureFetch(jSONObject, "2", "");
        }
    }

    static {
        Covode.recordClassIndex(653231);
        l = null;
    }

    public boolean d() {
        return PitayaCoreFactory.getCore(this.c).isReady();
    }

    public static PitayaWrapper f() {
        if (l == null) {
            synchronized (PitayaWrapper.class) {
                if (l == null) {
                    l = new PitayaWrapper();
                }
            }
        }
        return l;
    }

    public void g() {
        this.j = new StreamStrategyFeatureProducer();
        PTYFeatureStoreInstance.INSTANCE.getFeatureStore().registerFeatureProducer(this.j, new PTYNormalCallback() { // from class: com.ss.videoarch.strategy.utils.smartStrategy.PitayaWrapper.6
            public void onResult(boolean z, PTYError pTYError) {
                if (z) {
                    Log.d("PitayaWrapper", "register feature producer success");
                    return;
                }
                Log.d("PitayaWrapper", "register feature producer fail, error:" + pTYError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Context context) {
        IPitayaCore core = PitayaCoreFactory.getCore(this.c);
        String str = this.c;
        a.a();
        core.setup(context, new PTYSetupInfo(str, "1.10.205.2", this.g, new PTYDIDCallback() { // from class: com.ss.videoarch.strategy.utils.smartStrategy.PitayaWrapper.2
            public String getDid() {
                return PitayaWrapper.this.e;
            }
        }, new PTYUIDCallback() { // from class: com.ss.videoarch.strategy.utils.smartStrategy.PitayaWrapper.3
            public String getUid() {
                return PitayaWrapper.this.f;
            }
        }, (PTYPackageFilterCallback) null, new PTYSettingsCallback() { // from class: com.ss.videoarch.strategy.utils.smartStrategy.PitayaWrapper.4
            public JSONObject getSettings(String str2) {
                String str3 = lj6.a.m().r.e.mPitayaABSettingsParams;
                Log.d("PitayaWrapper", "pitayaABSettingsParams:" + str3);
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        return new JSONObject().put("content", new JSONObject(str3));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        }, 2, true, (String) null, 2, (PTYPyBinderCallback) null, false, false, (PTYCustomURLHost) null), new PTYSetupCallback() { // from class: com.ss.videoarch.strategy.utils.smartStrategy.PitayaWrapper.5
            public void onResult(boolean z, PTYError pTYError) {
                Log.e("PitayaWrapper", "pty init result:" + z + ",error:" + pTYError);
                Handler handler = PitayaWrapper.this.a;
                if (handler != null && z) {
                    handler.removeMessages(1028);
                    PitayaWrapper.this.a.sendEmptyMessage(1028);
                }
            }
        });
    }

    public boolean h(String str, JSONObject jSONObject, PTYTaskResultCallback pTYTaskResultCallback) {
        if (d()) {
            PitayaCoreFactory.getCore(this.c).runTask(str, new PTYTaskData(jSONObject), new PTYTaskConfig(true, (String) null, (float) lj6.a.m().r.e.mRunPtyPackageWaitTime), pTYTaskResultCallback);
            return true;
        }
        Log.e("PitayaWrapper", "pty not initialized");
        return false;
    }

    public void e(final Context context, JSONObject jSONObject, String str) {
        Handler handler;
        this.d = jSONObject;
        this.c = str;
        if (jSONObject != null) {
            if (jSONObject.has("device_id")) {
                this.e = this.d.optString("device_id");
            }
            if (this.d.has("user_id")) {
                this.f = this.d.optString("user_id");
            }
            if (this.d.has("channel")) {
                this.g = this.d.optString("channel");
            }
        }
        HostSetupWatcher hostSetupWatcher = HostSetupWatcher.INSTANCE;
        if (hostSetupWatcher.isHostSetup()) {
            i(context);
            return;
        }
        hostSetupWatcher.registerHostSetupListener(new HostSetupListener() { // from class: com.ss.videoarch.strategy.utils.smartStrategy.PitayaWrapper.1
            public void onHostSetup(boolean z) {
                Handler handler2;
                PitayaWrapper pitayaWrapper = PitayaWrapper.this;
                if (pitayaWrapper.i == 1 && (handler2 = pitayaWrapper.a) != null) {
                    handler2.removeMessages(1026);
                }
                if (!z) {
                    return;
                }
                PitayaWrapper.this.i(context);
            }
        });
        if (this.i == 1 && (handler = this.a) != null) {
            handler.sendEmptyMessageDelayed(1026, this.h);
        }
    }
}
