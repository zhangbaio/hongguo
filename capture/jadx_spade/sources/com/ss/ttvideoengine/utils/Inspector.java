package com.ss.ttvideoengine.utils;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.net.TTHTTPNetwork;
import com.ss.ttvideoengine.strategrycenter.StrategyHelper;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Inspector {
    private String mHost;
    private final TTHTTPNetwork mNetworkSession = new TTHTTPNetwork();

    static {
        Covode.recordClassIndex(652750);
    }

    public void inspectEvent(String str, JSONObject jSONObject) {
    }

    private static class Holder {
        private static final Inspector instance;

        private Holder() {
        }

        static {
            Covode.recordClassIndex(652751);
            instance = new Inspector();
        }
    }

    public String getHost() {
        return this.mHost;
    }

    public static Inspector share() {
        return Holder.instance;
    }

    public void setHost(String str) {
        this.mHost = str;
        if (StrategyHelper.helper().isRunning()) {
            StrategyHelper.helper().getCenter().h(31207, this.mHost);
        }
    }
}
