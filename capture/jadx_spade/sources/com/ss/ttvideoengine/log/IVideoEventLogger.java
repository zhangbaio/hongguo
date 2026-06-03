package com.ss.ttvideoengine.log;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.bytedance.vcloud.networkpredictor.SpeedPredictorResultCollection;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.metrics.IMediaMetrics;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.ss.ttvideoengine.utils.Error;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IVideoEventLogger {
    public static final int LOGGER_OPTION_DISABLE_EVENTV3_ASYNC = 10;
    public static final int LOGGER_OPTION_ENABLE_PLAYER_DEGRADE = 51;
    public static final int LOGGER_OPTION_ENABLE_SR = 28;
    public static final int LOGGER_OPTION_IS_DEGRADE_RELEASE = 52;

    /* renamed from: com.ss.ttvideoengine.log.IVideoEventLogger$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$getIntOption(IVideoEventLogger iVideoEventLogger, int i) {
            return -1;
        }

        public static void $default$updateMultiNetworkSpeed(IVideoEventLogger iVideoEventLogger, String str) {
        }
    }

    static {
        Covode.recordClassIndex(652472);
    }

    void AVNoRenderEnd(int i);

    void AVNoRenderStart(int i, int i2);

    void AVOutSyncEnd(int i);

    void AVOutSyncStart(int i);

    void abrEventEnd(long j);

    void abrEventStart(long j, long j2);

    void accuBuffingTime(long j);

    void accumulateSize();

    void addFeature(String str, Object obj);

    void addLabelUsage(Map<String, Object> map);

    void addSubtitleSwitchTime();

    void addWatchedDuration(int i);

    void beginToPlay(String str, long j, String str2);

    void bufferDataSeconds(int i);

    IMediaMetrics buildMetrics(int i);

    void clockDiff(long j);

    void codecName(int i, int i2);

    void configResolution(String str, String str2);

    void containerFps(float f);

    void crosstalkHappen(int i, ArrayList arrayList);

    void curAudioDecodeError(int i);

    void curPlayBackTime(int i);

    void curVideoDecodeError(int i);

    void curVideoDecoderFps(int i);

    void curVideoOutputFps(float f);

    void curVideoRenderError(int i);

    void deviceStartTime(int i, long j);

    void devicedOpenedTime(int i, long j);

    void didSentEvent(int i);

    void dropCount(int i);

    void enableSharp(int i);

    void enableStartPlayAutomatically(boolean z);

    void engineState(int i);

    void fetchInfoComplete(IVideoModel iVideoModel, Error error);

    void fetchInfoComplete(VideoModel videoModel, Error error);

    void fetchedAndLeaveByUser(int i);

    void firstDNSFailed(Error error);

    int getAsyncInit();

    Map<String, Object> getCoreEventParam();

    long getCurDecoderBufferAccuT();

    int getCurDecoderBufferCount();

    String getEncryptKey();

    String getExtraInfo();

    Error getFirstError();

    int getIntOption(int i);

    long getLeaveWaitTime();

    int getMovieStalledType();

    long getStalledAudioBufferTime();

    long getStalledVideoBufferTime();

    String getStringOption(int i);

    String getTraceID();

    void hwCodecException(int i);

    void hwCodecName(String str);

    void initContentReporterIfNeeded(String str);

    boolean isUploadLogEnabled();

    void logFirstError(Error error);

    void logMessage(String str);

    void logPluginException(String str);

    void loopAgain();

    void mdlRetryResult(int i, String str, Error error);

    void movieBufferDidReachEnd();

    void movieFinish(int i);

    void movieFinish(int i, String str);

    void movieFinish(Error error, int i);

    void moviePreStalled(int i);

    void movieShouldRetry(Error error, int i, int i2);

    void movieStallEnd(int i);

    void movieStalled(int i, int i2);

    void needRetryToFetch(Error error, int i);

    void onAVBadInterlaced(long j);

    void onVideoInfoIdChanged(int i);

    void pause();

    void play(boolean z);

    void playbackBufferEnd();

    void playbackBufferStart();

    void prepareEnd();

    void prepareStart();

    void recordBlockReason(int i, boolean z);

    void renderSeekCompleted(int i);

    void reportBufferingMetrics();

    void reset();

    void retryFinish();

    void saveEvent();

    void seekCompleted();

    void seekTo(int i, int i2, boolean z);

    void setAbrGeneralInfo(Map<String, Object> map);

    void setAbrInfo(Map<String, Object> map);

    void setAudioBufferLength(long j);

    void setAudioDNSParseTime(long j, int i);

    void setAudioTranConnectTime(long j);

    void setAudioTranFirstPacketTime(long j);

    void setCDNTuningParam(String str);

    void setCheckHijack(int i);

    void setCurHost(String str);

    void setCurIP(String str);

    void setCurQuality(String str);

    void setCurResolution(String str);

    void setCurURL(String str);

    void setCurrentQualityDesc(String str);

    void setCustomInfo(VideoEventCustomInfo videoEventCustomInfo, Object obj);

    void setCustomP2PCDNType(int i);

    void setCustomStr(String str);

    void setDNSEndTime(long j);

    void setDNSParseTime(long j, int i);

    void setDNSStartTime(long j, int i);

    void setDashAudioCacheSize(long j);

    void setDashVideoCacheSize(long j);

    void setDecodeFirstAudioFrameTime(long j);

    void setDecodeFirstVideoFrameTime(long j);

    void setDisableAccurateStart(int i);

    void setDnsMode(int i);

    void setDrmTokenUrl(String str);

    void setDrmType(int i);

    void setDuration(int i);

    void setEffect(Bundle bundle);

    void setEnableBash(int i);

    void setEnableBmfSr(int i);

    void setEnableMDL(int i);

    void setEncryptKey(String str);

    void setFeed(IVideoModel iVideoModel);

    void setFeed(VideoModel videoModel);

    void setFirstPlayerFirstFrameTime(long j);

    void setFloatOption(int i, float f);

    void setFramesDropNum(int i);

    void setGearStrategyEvent(Map<String, Object> map);

    void setHijackCode(int i);

    void setHijackRetry(int i);

    void setInitialHost(String str);

    void setInitialIP(String str);

    void setInitialQuality(String str);

    void setInitialQualityType(int i);

    void setInitialResolution(String str);

    void setInitialURL(String str, String str2);

    void setIntOption(int i, int i2);

    void setIsEnableABR(int i);

    void setIsEnableSelectBitrate(int i);

    void setIsMultiDimensionsInput(int i);

    void setIsMultiDimensionsOut(int i);

    void setIsVideoModelCache(int i);

    void setLoggerTimes(int i);

    void setLongOption(int i, long j);

    void setLooping(boolean z);

    void setMDLHijackIP(String str);

    void setMDLHijackURL(String str);

    void setMaskErrorCode(int i);

    void setMaskUrl(String str);

    void setMediaCodecRender(int i);

    void setNetWorkTryCount(int i);

    void setNetworkSpeedFrom(double d, int i);

    void setP2PCDNType(int i);

    void setP2PSDKVersion(String str);

    void setP2PUrl(String str);

    void setPlayAPIVersion(int i, String str);

    void setPlayType(int i);

    void setPlaybackParams(PlaybackParams playbackParams);

    void setPlayerCreatedT(long j);

    void setPlayerHostAddr(String str);

    void setPlayerSurface(String str);

    void setPlayerViewSize(int i, int i2);

    void setPrivateFieldFlag(Map<String, String> map);

    void setProxyUrl(String str);

    void setReceiveFirstAudioFrameTime(long j);

    void setReceiveFirstVideoFrameTime(long j);

    void setSRPreloadInfo(Map<String, Object> map);

    void setSRStrategyInfo(SRStrategy sRStrategy);

    void setSelectResult(Map<String, String> map);

    void setSourceRefreshLog(JSONObject jSONObject);

    void setSourceType(int i, String str);

    void setSpeedPredictorAlgoType(int i);

    void setSrAlgorithm(int i);

    void setSrScaleType(int i);

    void setStartPlayHeight(int i);

    void setStartPlayWidth(int i);

    void setStartTime(int i);

    void setStringOption(int i, String str);

    void setSubTag(String str);

    void setSubtitleError(String str);

    void setSubtitleIdsCount(int i);

    void setSubtitleRequestUrl(String str);

    void setSurface(String str);

    void setSurfaceBegin();

    void setSurfaceEnd();

    void setSurfaceSourceType(String str);

    void setTag(String str);

    void setTextureRenderError(String str);

    void setTraceID(String str);

    void setTranConnectTime(long j);

    void setTranFirstPacketTime(long j);

    void setUploadLogEnabled(boolean z);

    void setVUArray(ArrayList arrayList);

    void setVideoBufferLength(long j);

    void setVideoCacheSize(long j);

    void setVrDisplayDistance(float f);

    void setVrDisplayFrameRate(float f);

    void setVrHeadMovementDelay(long j);

    void setVrScreenRefreshRate(int i);

    void showedFirstAVSyncVideoFrame(long j);

    void showedFirstFrame();

    void showedOneFrame();

    void stop(int i);

    void switchResolution();

    void switchResolution(String str, String str2, boolean z);

    void switchResolutionEnd(boolean z);

    void updateGlobalNetworkSpeed(long j, long j2, int i);

    void updateMultiNetworkSpeed(String str);

    void updateNetworkSpeedPredictorSampleMutiValue(SpeedPredictorResultCollection speedPredictorResultCollection, SpeedPredictorResultCollection speedPredictorResultCollection2, long j);

    void updateNetworkSpeedPredictorSampleValue(String str, String str2, float f, float f2, float f3, float f4, long j, Map<String, String> map, Map<String, String> map2);

    void updateVideoInfo(IVideoModel iVideoModel);

    void updateVideoInfo(VideoModel videoModel);

    void useAsyncInit(int i, int i2);

    void useCodecPool(int i);

    void useHardwareDecode(int i);

    void useTextureRender(int i);

    void validateVideoMetaInfoFail(Error error);

    void watchFinish();

    public enum MdlInitializeState {
        Default,
        Initializing,
        InitializeComplete,
        InitializeError;

        static {
            Covode.recordClassIndex(652473);
        }
    }

    public enum MdlInvalidCode {
        None,
        EmptyKey,
        EmptyFilepath,
        OptionNotSet,
        StateError,
        ProxyNotSupport,
        ParamsWrong;

        static {
            Covode.recordClassIndex(652474);
        }
    }

    public enum VideoEventCustomInfo {
        VIDEOEVENT_CUSTOM_INFO_FFTIME_CLICK,
        VIDEOEVENT_CUSTOM_INFO_FFTIME_VIDEOMODEL,
        VIDEOEVENT_CUSTOM_INFO_FFTIME_CUSTOMPLAY,
        VIDEOEVENT_CUSTOM_INFO_FFTIME_INITENGINE,
        VIDEOEVENT_CUSTOM_INFO_FFTIME_PLAYENGINE,
        VIDEOEVENT_CUSTOM_INFO_CAST_OBJECT,
        VIDEOEVENT_CUSTOM_INFO_OTT_PLUGIN_VERSION,
        VIDEOEVENT_CUSTOM_INFO_COMPANY_ID,
        VIDEOEVENT_CUSTOM_INFO_CUSTOM_PLAY_SESSION_ID;

        static {
            Covode.recordClassIndex(652475);
        }
    }
}
