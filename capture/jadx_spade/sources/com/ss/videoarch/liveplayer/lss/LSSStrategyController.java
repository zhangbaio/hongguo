package com.ss.videoarch.liveplayer.lss;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.liveplayer.VideoLiveManager;
import com.ss.videoarch.liveplayer.utils.e;
import com.ss.videoarch.strategy.LiveStrategyManager;
import com.ss.videoarch.strategy.streamFeature.StreamFeature;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class LSSStrategyController extends e {
    private final HashMap<Integer, String> kStrategyNameMap;
    private long mHandler;
    private long mPlayStatisticsHandlingInterval;
    private long mPreviousPlayStatisticsHandlingTime;
    private boolean mReportStatisticsInfoEnabled;
    private String mRequiredReqParams;

    static {
        Covode.recordClassIndex(653052);
    }

    private native long nativeCreateHandler(String str);

    private native String nativeGetStringifiedStatisticsInfo(long j);

    private native void nativeHandleRTMSenderInfo(long j, String str);

    private native void nativeHandleStrategyResult(long j, String str);

    private native void nativeHandleTriggerEvent(long j, String str, String str2);

    private native void nativeRelease(long j);

    private native void nativeStart(long j);

    private native void nativeStop(long j);

    public String getRequiredReqParams() {
        return this.mRequiredReqParams;
    }

    public void handleCommonFeaturesUpdate() {
        handleTriggerEvent("common_features_update", null);
    }

    public void handleFirstFrame() {
        handleTriggerEvent("first_frame", null);
    }

    public void handlePreviewFlagChanged() {
        handleTriggerEvent("preview_flag_changed", null);
    }

    public void handleStallStart() {
        handleTriggerEvent("stall_start", null);
    }

    public void handleStartUpResolutionRequest() {
        handleTriggerEvent("start_up_resolution_request", null);
    }

    public synchronized void release() {
        nativeRelease(this.mHandler);
        this.mHandler = 0L;
    }

    void nativeCalledRequestStrategyResult(String str) {
        calledRequestStrategyResult(str);
    }

    public void handleRTMSenderInfoIfNeeded(String str) {
        nativeHandleRTMSenderInfo(this.mHandler, str);
    }

    public void handleAlgoSei(ByteBuffer byteBuffer) {
        try {
            JSONArray a = StreamFeature.a(byteBuffer);
            if (a == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("PLAY-StreamFeature", a);
            handleTriggerEvent("stream_feature_received", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleVideoRendering(boolean z) {
        int i;
        try {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            handleTriggerEvent("video_rendering", jSONObject.put("VideoRendering", i));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    void nativeCalledABRStrategyResultHandler(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                performVideoLiveManagerMethod("handleLSSStrategyResult", new JSONObject(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void nativeCalledStrategyReportInfoHandler(String str) {
        try {
            performVideoLiveManagerMethod("handleStrategyReportInfo", new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handlePlayStop(JSONObject jSONObject) {
        handleTriggerEvent("play_stop", null);
        nativeStop(this.mHandler);
        String nativeGetStringifiedStatisticsInfo = nativeGetStringifiedStatisticsInfo(this.mHandler);
        if (nativeGetStringifiedStatisticsInfo != null && this.mReportStatisticsInfoEnabled) {
            try {
                JSONObject jSONObject2 = new JSONObject(nativeGetStringifiedStatisticsInfo);
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.get(next));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    void nativeCalledPlayerSettingsHandler(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                VideoLiveManager videoLiveManager = videoLiveManager();
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("llash_req_params", null);
                if (optString == null) {
                    optString = jSONObject.optString("rtm_req_params", null);
                }
                if (optString != null) {
                    this.mRequiredReqParams = optString;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("low_latency_config");
                if (optJSONObject != null && videoLiveManager != null) {
                    performVideoLiveManagerMethod("updateLowLatencyConfig", optJSONObject);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    boolean nativeCalledStartUpStrategyResultHandler(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return ((Boolean) performVideoLiveManagerMethod("handleRecommendedStartUpResolution", jSONObject.optString("target_resolution", null), jSONObject)).booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    synchronized void calledRequestStrategyResult(String str) {
        JSONObject jSONObject;
        if (this.mHandler == 0) {
            return;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("PLAY-TriggerEvent", null);
        if (optString != null && !optString.isEmpty()) {
            if (videoLiveManager() == null) {
                return;
            }
            JSONObject jSONObject2 = (JSONObject) LiveStrategyManager.inst().getConfigAndStrategyByKeyInt(0, 23, null, jSONObject);
            if (jSONObject2 != null) {
                nativeHandleStrategyResult(this.mHandler, jSONObject2.toString());
            }
        }
    }

    public void handleRenderFrameInfo(String str) {
        if (str != null && !str.isEmpty() && str.contains("StatisticsInfo")) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.mPlayStatisticsHandlingInterval;
            if (j > 0) {
                long j2 = this.mPreviousPlayStatisticsHandlingTime;
                if (j2 <= 0 || currentTimeMillis - j2 >= j) {
                    this.mPreviousPlayStatisticsHandlingTime = currentTimeMillis;
                    try {
                        JSONObject jSONObject = new JSONObject(str).getJSONObject("StatisticsInfo");
                        JSONObject jSONObject2 = new JSONObject();
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject2.put("PLAY-" + next, jSONObject.get(next));
                        }
                        handleTriggerEvent("statistics_info_update", jSONObject2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    String nativeCalledFetchFeatureData(String str) {
        String str2 = "{}";
        if (str == null || str.length() <= 0) {
            return "{}";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("featuresBundleList", new JSONArray(str));
            jSONObject.put("featuresData", jSONObject2);
            performVideoLiveManagerMethod("getFeaturesData", jSONObject);
            str2 = jSONObject2.toString();
            Log.d("LSSStrategyController", "did get features data: " + str2);
            return str2;
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    private void handleStrategyTriggerEvent(String str, JSONObject jSONObject) throws Exception {
        if (str != null && !str.isEmpty()) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            nativeHandleTriggerEvent(this.mHandler, str, jSONObject.toString());
        }
    }

    public void handleTriggerEvent(String str, JSONObject jSONObject) {
        if (str != null && !str.isEmpty()) {
            try {
                handleStrategyTriggerEvent(str, jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public LSSStrategyController(VideoLiveManager videoLiveManager, JSONArray jSONArray, boolean z, long j) {
        super(videoLiveManager);
        String str;
        this.mHandler = 0L;
        this.mReportStatisticsInfoEnabled = false;
        this.mRequiredReqParams = null;
        this.mPlayStatisticsHandlingInterval = 0L;
        this.mPreviousPlayStatisticsHandlingTime = 0L;
        this.kStrategyNameMap = new HashMap<Integer, String>() { // from class: com.ss.videoarch.liveplayer.lss.LSSStrategyController.1
            {
                put(23, "live_stream_strategy_abr_predict_bitrate");
            }
        };
        this.mReportStatisticsInfoEnabled = z;
        this.mPlayStatisticsHandlingInterval = j;
        JSONObject jSONObject = new JSONObject();
        if (jSONArray != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        str = optJSONObject.optString("Name");
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        jSONObject2.put(str, optJSONObject);
                    }
                }
                jSONObject.put("StrategyList", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        long nativeCreateHandler = nativeCreateHandler(jSONObject.toString());
        this.mHandler = nativeCreateHandler;
        nativeStart(nativeCreateHandler);
    }
}
