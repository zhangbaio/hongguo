package com.ss.videoarch.liveplayer.smoothswitch;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.videoarch.liveplayer.VideoLiveManager;
import com.ss.videoarch.liveplayer.smoothswitch.SmoothSwitchController;
import com.ss.videoarch.liveplayer.utils.e;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SmoothSwitchController extends e {
    private long mHandler;
    private boolean mReportStatisticsInfoEnabled;
    private int mSessionInitialBitrate;

    public interface SwitchFailedHandler {
        void with(String str, int i);
    }

    public interface SwitchFinished {
        void with(String str, String str2);
    }

    public interface SwitchPerforming {
        void apply(long j, int i, String str, String str2);
    }

    public interface SwitchSucceededHandler {
        void with(String str);
    }

    static {
        Covode.recordClassIndex(653086);
    }

    private native long nativeCreateHandler();

    private native int nativeGetCurrentBitrate(long j);

    private native long nativeGetLatestFinishedSwitchFinishedTimestamp(long j);

    private native String nativeGetStringifiedStatisticsInfo(long j);

    private native int nativeGetTargetBitrate(long j);

    private native void nativeHandleSwitchPerformed(long j, String str, SwitchFinished switchFinished, SwitchSucceededHandler switchSucceededHandler, SwitchFailedHandler switchFailedHandler);

    private native void nativePerformSwitch(long j, int i, int i2, String str, int i3, String str2, String str3, boolean z, SwitchPerforming switchPerforming);

    private native void nativeRelease(long j);

    private native void nativeRemoveAllSwitches(long j);

    public long getLatestFinishedSwitchFinishedTimestamp() {
        return nativeGetLatestFinishedSwitchFinishedTimestamp(this.mHandler);
    }

    public int getTargetBitrate() {
        return nativeGetTargetBitrate(this.mHandler);
    }

    public void release() {
        nativeRelease(this.mHandler);
    }

    public int getCurrentBitrate() {
        int nativeGetCurrentBitrate = nativeGetCurrentBitrate(this.mHandler);
        if (nativeGetCurrentBitrate <= 0) {
            return this.mSessionInitialBitrate;
        }
        return nativeGetCurrentBitrate;
    }

    public void removeAllSwitches() {
        nativeRemoveAllSwitches(this.mHandler);
        VideoLiveManager videoLiveManager = videoLiveManager();
        if (videoLiveManager != null) {
            videoLiveManager.setLongOption(TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES, 0L);
        }
    }

    public void initSession(int i) {
        this.mSessionInitialBitrate = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSwitchPerformedIfNeeded$2(String str) {
        try {
            performVideoLiveManagerMethod("handleCurrentTemplateDidChange", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleSwitchPerformedIfNeeded(String str) {
        if (str != null && !str.isEmpty()) {
            nativeHandleSwitchPerformed(this.mHandler, str, new SwitchFinished() { // from class: kj6.b
                @Override // com.ss.videoarch.liveplayer.smoothswitch.SmoothSwitchController.SwitchFinished
                public final void with(String str2, String str3) {
                    SmoothSwitchController.this.lambda$handleSwitchPerformedIfNeeded$1(str2, str3);
                }
            }, new SwitchSucceededHandler() { // from class: kj6.c
                @Override // com.ss.videoarch.liveplayer.smoothswitch.SmoothSwitchController.SwitchSucceededHandler
                public final void with(String str2) {
                    SmoothSwitchController.this.lambda$handleSwitchPerformedIfNeeded$2(str2);
                }
            }, new SwitchFailedHandler() { // from class: kj6.d
                @Override // com.ss.videoarch.liveplayer.smoothswitch.SmoothSwitchController.SwitchFailedHandler
                public final void with(String str2, int i) {
                    SmoothSwitchController.this.lambda$handleSwitchPerformedIfNeeded$3(str2, i);
                }
            });
        }
    }

    public void handlePlayStop(JSONObject jSONObject) {
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

    public SmoothSwitchController(VideoLiveManager videoLiveManager, boolean z) {
        super(videoLiveManager);
        this.mReportStatisticsInfoEnabled = false;
        this.mSessionInitialBitrate = -1;
        this.mHandler = nativeCreateHandler();
        this.mReportStatisticsInfoEnabled = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSwitchPerformedIfNeeded$1(String str, String str2) {
        try {
            performVideoLiveManagerMethod("handleSmoothSwitchPerformed", str, new JSONObject(str2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSwitchPerformedIfNeeded$3(String str, int i) {
        try {
            performVideoLiveManagerMethod("handleSmoothSwitchFailed", str, Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int performSwitch(int i, int i2, final String str, int i3, String str2, final String str3, boolean z) {
        final AtomicInteger atomicInteger = new AtomicInteger(-1);
        nativePerformSwitch(this.mHandler, i, i2, str, i3, str2, str3, z, new SwitchPerforming() { // from class: kj6.a
            @Override // com.ss.videoarch.liveplayer.smoothswitch.SmoothSwitchController.SwitchPerforming
            public final void apply(long j, int i4, String str4, String str5) {
                SmoothSwitchController.this.lambda$performSwitch$0(str, str3, atomicInteger, j, i4, str4, str5);
            }
        });
        return atomicInteger.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSwitch$0(String str, String str2, AtomicInteger atomicInteger, long j, int i, String str3, String str4) {
        VideoLiveManager videoLiveManager = videoLiveManager();
        videoLiveManager.setLongOption(TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES, (i << 32) | j);
        videoLiveManager.setStringOption(209, str4);
        String format = String.format("seq=%d", Long.valueOf(j));
        String format2 = String.format("abr=%s", str);
        for (String str5 : str2.split("&")) {
            if (str5.length() > 4 && str5.startsWith("abr=")) {
                format2 = str5;
            }
        }
        videoLiveManager.setStringOption(216, String.format("%s&%s", format2, format));
        atomicInteger.set((int) j);
    }
}
