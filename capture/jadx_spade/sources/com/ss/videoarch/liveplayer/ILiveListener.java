package com.ss.videoarch.liveplayer;

import android.view.Surface;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.liveplayer.log.LiveError;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface ILiveListener {

    public static class Stub implements ILiveListener {
        static {
            Covode.recordClassIndex(652916);
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onAbrSwitch(String str, int i) {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onAudioFrameRenderMetaInfo(q qVar) {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onAudioRenderStall(int i) {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onBinarySeiUpdate(ByteBuffer byteBuffer) {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onCacheFileCompletion() {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onCompletion() {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onError(LiveError liveError) {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onFirstFrame(boolean z) {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onHeadPoseUpdate(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onMonitorLog(JSONObject jSONObject, String str) {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onNetworkQualityChanged(int i, String str) {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onPrepared() {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onReportALog(int i, String str) {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onResolutionDegrade(String str) {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onResolutionSwitch(s sVar, t tVar, VeLivePlayerDef$VeLivePlayerResolutionSwitchReason veLivePlayerDef$VeLivePlayerResolutionSwitchReason) {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onResponseSmoothSwitch(boolean z, int i) {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onSeiUpdate(String str) {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onStallEnd() {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onStallStart() {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onTextureRenderDrawFrame(Surface surface) {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onVideoFrameRenderMetaInfo(y yVar) {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onVideoRenderStall(int i) {
        }

        @Override // com.ss.videoarch.liveplayer.ILiveListener
        public void onVideoSizeChanged(int i, int i2) {
        }
    }

    public interface a {
    }

    void onAbrSwitch(String str, int i);

    void onAudioFrameRenderMetaInfo(q qVar);

    void onAudioRenderStall(int i);

    void onBinarySeiUpdate(ByteBuffer byteBuffer);

    void onCacheFileCompletion();

    void onCompletion();

    void onError(LiveError liveError);

    void onFirstFrame(boolean z);

    void onHeadPoseUpdate(float f, float f2, float f3, float f4, float f5, float f6, float f7);

    void onMonitorLog(JSONObject jSONObject, String str);

    void onNetworkQualityChanged(int i, String str);

    void onPrepared();

    void onReportALog(int i, String str);

    void onResolutionDegrade(String str);

    void onResolutionSwitch(s sVar, t tVar, VeLivePlayerDef$VeLivePlayerResolutionSwitchReason veLivePlayerDef$VeLivePlayerResolutionSwitchReason);

    void onResponseSmoothSwitch(boolean z, int i);

    void onSeiUpdate(String str);

    void onStallEnd();

    void onStallStart();

    void onTextureRenderDrawFrame(Surface surface);

    void onVideoFrameRenderMetaInfo(y yVar);

    void onVideoRenderStall(int i);

    void onVideoSizeChanged(int i, int i2);
}
