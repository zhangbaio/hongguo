package com.ss.videoarch.liveplayer.abr;

import com.bytedance.covode.number.Covode;
import com.ss.videoarch.liveplayer.VideoLiveManager;
import com.ss.videoarch.liveplayer.abr.ABRSwitchController;
import com.ss.videoarch.liveplayer.utils.e;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ABRSwitchController extends e {
    private long mHandler;
    private boolean mReportStatisticsInfoEnabled;

    public interface PermissionRequest {
        int apply(String str);
    }

    public interface RequestRejected {
        void with(int i, String str);
    }

    public interface SwitchPerforming {
        int apply(String str);
    }

    static {
        Covode.recordClassIndex(653015);
    }

    private native long nativeCreateHandler();

    private native String nativeDecisionInfoWithIdentifier(long j, int i);

    private native String nativeGetStringifiedStatisticsInfo(long j, boolean z);

    private native void nativeHandleABRStrategyDecision(long j, String str, PermissionRequest permissionRequest, RequestRejected requestRejected, SwitchPerforming switchPerforming);

    private native void nativeRelease(long j);

    public void release() {
        nativeRelease(this.mHandler);
    }

    public JSONObject getDecisionInfo(int i) {
        String nativeDecisionInfoWithIdentifier = nativeDecisionInfoWithIdentifier(this.mHandler, i);
        if (nativeDecisionInfoWithIdentifier == null || nativeDecisionInfoWithIdentifier.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(nativeDecisionInfoWithIdentifier);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void handleABRStrategyDecision(final JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.optInt("target_bitrate", -1) <= 0) {
            return;
        }
        final String optString = jSONObject.optString("source_resolution");
        final String optString2 = jSONObject.optString("target_resolution");
        nativeHandleABRStrategyDecision(this.mHandler, jSONObject.toString(), new PermissionRequest() { // from class: aj6.a
            @Override // com.ss.videoarch.liveplayer.abr.ABRSwitchController.PermissionRequest
            public final int apply(String str) {
                int lambda$handleABRStrategyDecision$0;
                lambda$handleABRStrategyDecision$0 = ABRSwitchController.this.lambda$handleABRStrategyDecision$0(optString, optString2, jSONObject, str);
                return lambda$handleABRStrategyDecision$0;
            }
        }, new RequestRejected() { // from class: aj6.b
            @Override // com.ss.videoarch.liveplayer.abr.ABRSwitchController.RequestRejected
            public final void with(int i, String str) {
                ABRSwitchController.this.lambda$handleABRStrategyDecision$1(jSONObject, i, str);
            }
        }, new SwitchPerforming() { // from class: aj6.c
            @Override // com.ss.videoarch.liveplayer.abr.ABRSwitchController.SwitchPerforming
            public final int apply(String str) {
                int lambda$handleABRStrategyDecision$2;
                lambda$handleABRStrategyDecision$2 = ABRSwitchController.this.lambda$handleABRStrategyDecision$2(jSONObject, str);
                return lambda$handleABRStrategyDecision$2;
            }
        });
    }

    public void handlePlayStop(JSONObject jSONObject) {
        String nativeGetStringifiedStatisticsInfo = nativeGetStringifiedStatisticsInfo(this.mHandler, this.mReportStatisticsInfoEnabled);
        if (nativeGetStringifiedStatisticsInfo != null) {
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

    public ABRSwitchController(VideoLiveManager videoLiveManager, boolean z) {
        super(videoLiveManager);
        this.mReportStatisticsInfoEnabled = false;
        this.mHandler = nativeCreateHandler();
        this.mReportStatisticsInfoEnabled = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$handleABRStrategyDecision$2(JSONObject jSONObject, String str) {
        try {
            Object performVideoLiveManagerMethod = performVideoLiveManagerMethod("handleABRSwitchPerforming", jSONObject);
            if (performVideoLiveManagerMethod == null) {
                return -1;
            }
            return ((Integer) performVideoLiveManagerMethod).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleABRStrategyDecision$1(JSONObject jSONObject, int i, String str) {
        try {
            performVideoLiveManagerMethod("handleABRSwitchRequestRejected", Integer.valueOf(i), jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$handleABRStrategyDecision$0(String str, String str2, JSONObject jSONObject, String str3) {
        try {
            Object performVideoLiveManagerMethod = performVideoLiveManagerMethod("handleABRSwitchPermissionRequest", str, str2, jSONObject);
            if (performVideoLiveManagerMethod == null) {
                return 0;
            }
            return ((Integer) performVideoLiveManagerMethod).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
