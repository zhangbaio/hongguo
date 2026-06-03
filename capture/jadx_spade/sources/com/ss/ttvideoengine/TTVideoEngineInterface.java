package com.ss.ttvideoengine;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.ss.texturerender.VideoSurface;
import com.ss.ttm.player.AudioProcessor;
import com.ss.ttm.player.IMediaDataSource;
import com.ss.ttm.player.LoadControl;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttm.player.TTAVWindowClient;
import com.ss.ttm.player.TraitObject;
import com.ss.ttvideoengine.TTVideoEngineMonitor;
import com.ss.ttvideoengine.dasp.DaspSignal;
import com.ss.ttvideoengine.log.EventLoggerSource;
import com.ss.ttvideoengine.log.ExternVideoLoggerListener;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.ss.ttvideoengine.metrics.IMediaMetrics;
import com.ss.ttvideoengine.model.DubbedInfo;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.SubInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.preloader.TTAVPreloaderItem;
import com.ss.ttvideoengine.selector.shift.SpeedShiftConfig;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConfig;
import com.ss.ttvideoengine.selector.strategy.IGearStrategyListener;
import com.ss.ttvideoengine.setting.SettingsHelper;
import com.ss.ttvideoengine.strategy.source.StrategySource;
import com.ss.ttvideoengine.superresolution.SRStrategyConfig;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface TTVideoEngineInterface extends ITTVideoEngineInternal {
    public static final int ABR_4GMAX_RESOULUTION_MODEL_CUSTOM = 0;
    public static final int PLAYER_OPTION_ABR_4GMAX_RESOULUTION_MODE = 507;
    public static final int PLAYER_OPTION_CODECPOOL_RESPONSE = 1116;
    public static final int PLAYER_OPTION_DEFAULT_RENDER_TYPE = 414;
    public static final int PLAYER_OPTION_DISABLE_EVENTV3_ASYNC = 479;
    public static final int PLAYER_OPTION_ENABEL_HARDWARE_DECODE_AUDIO = 413;
    public static final int PLAYER_OPTION_ENABLE_PLAYER3_HARDWARE_DECODE = 31;
    public static final int PLAYER_OPTION_ENABLE_PLAYER_DEGRADE = 616;
    public static final int PLAYER_OPTION_FORBID_P2P_WHEN_SEEK = 418;
    public static final int PLAYER_OPTION_IS_DEGRADE_RELEASE = 617;
    public static final int PLAYER_OPTION_KERNAL_LOG_LEVER = 702;
    public static final int PLAYER_OPTION_MAX_FILE_CACHE_SIZE = 14;
    public static final int PLAYER_OPTION_OPEN_TEXTUER_AFTER_FIRST_FRAME = 661;
    public static final int PLAYER_OPTION_OPERA_EVENT_REPORT_LEVEL = 704;
    public static final int PLAYER_OPTION_PREFER_NEARESTSAMPLE = 311;
    public static final int PLAYER_OPTION_PRE_RENDER_BUFFERING_UPDATE_PRECENTAGE = 576;
    public static final int PLAYER_OPTION_SETSURFACESYNC_NOTUSEENGINELOOPER = 712;
    public static final int PLAYER_OPTION_SETSURFACESYNC_SENDATFRONTOFQUEUE = 711;
    public static final int PLAYER_OPTION_SET_NETSPEED_LEVEL = 487;
    public static final int PLAYER_OPTION_SET_SUPER_RES = 210;
    public static final int PLAYER_OPTION_SET_SUPER_RES_FXAA = 211;
    public static final int PLAYER_OPTION_SET_SUPER_RES_STRENGTH = 212;
    public static final int PLAYER_OPTION_SET_USE_PLAYER3 = 30;
    public static final int PLAYER_OPTION_SPEED_REPORT_SAMPLIING_RATE = 535;
    public static final int PLAYER_OPTION_SUB_LANG_IDS = 532;
    public static final int PLAYER_OPTION_USE_AJ_MEDIACODEC = 412;
    public static final int PLAYER_OPTION_USE_EXTERNAL_DIR = 15;
    public static final int PLAYER_OPTION_USE_PLAYER_SPADE = 111;
    public static final int PLAYER_OPTION_USE_THREAD_POOL = 411;
    public static final int PLAYER_REFACTOR_FLAG = 684;
    public static final int PLAYER_SPEED_PREDICT_INPUT_UNKNOW = 0;
    public static final String REGION_CN;
    public static final String REGION_SG;
    public static final String REGION_US;
    public static final int SEGMENT_FORMAT_UNKOWN = 0;

    /* renamed from: com.ss.ttvideoengine.TTVideoEngineInterface$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$setObjectOption(TTVideoEngineInterface tTVideoEngineInterface, int i, Object obj) {
        }

        public static void $default$setTraitObject(TTVideoEngineInterface tTVideoEngineInterface, int i, TraitObject traitObject) {
        }
    }

    void addVideoEngineCallback(VideoEngineCallback videoEngineCallback);

    void asyncInitSR(boolean z);

    boolean clearSurface(Surface surface, boolean z);

    void clearTextureRef();

    void configParams(Resolution resolution, Map<Integer, String> map);

    void configResolution(Resolution resolution);

    void createPlayer();

    void createPlayerAsync();

    ArrayList<HashMap<String, Object>> crosstalkHappen(ArrayList<TTVideoEngine> arrayList, HashMap<String, TTVideoEngineMonitor.TTVideoEngineLivePlayerInfo> hashMap);

    void dynamicControlSR(boolean z);

    void forceDraw();

    String getAPIString();

    int getAudioLatencyTime();

    int getAudioLatencytime();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    int getBufferingType();

    boolean getCacheControlEnabled();

    List<String> getCacheKeys();

    Context getContext();

    String getCurrentPlayPath();

    String getCurrentPlayUrl();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    int getCurrentPlaybackTime();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    int getCurrentPlaybackTimeAsync();

    String getCurrentQualityDesc();

    Resolution getCurrentResolution();

    String getDirectUrl();

    String getDubbedMemUrl(List<DubbedInfo> list);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    int getDuration();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    float getFloatOption(int i);

    GearStrategyConfig getGearStrategyEngineConfig();

    String getHash();

    IVideoModel getIVideoModel();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    int getIntOption(int i);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    int getLoadState();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    int getLoadedProgress();

    IVideoEventLogger getLogger();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    long getLongOption(int i);

    boolean getLooping(boolean z);

    float getMaxVolume();

    MediaPlayer getMediaPlayer();

    MediaTrackInfoModel[] getMediaTrackInfos();

    IMediaMetrics getMetrics(int i);

    boolean getMirrorHorizontal();

    boolean getMirrorVertical();

    TTVNetClient getNetClientSetByUser();

    int getPlayAPIVersion();

    JSONObject getPlayErrorInfo();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    int getPlaybackState();

    String getPlayerSessionId();

    String getQualityDescBeforeDowngrade();

    Resolution getResolutionBeforeDowngrade();

    int getRotation();

    int getStartTime();

    Map<String, Object> getStrategyLogData(String str);

    StrategySource getStrategySource();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    String getStringOption(int i);

    String getSubTag();

    String getSubtitleContentInfo(int i);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    Surface getSurface();

    String getTag();

    VideoSurface getTextureSurface();

    String getTraceId();

    MediaPlayer.TrackInfo[] getTrackInfo();

    EventLoggerSource getVideoEngineDataSource();

    VideoFormatInfo getVideoFormatInfo();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    int getVideoHeight();

    String getVideoID();

    VideoModel getVideoModel();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    int getVideoWidth();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    float getVolume();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    int getWatchedDuration();

    void ignoreSRResolutionLimit(boolean z);

    void initSRStrategyConfig(SRStrategyConfig sRStrategyConfig);

    boolean isDashSource();

    boolean isInHousePlayer();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    boolean isLooping();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    boolean isMute();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    boolean isOSPlayer();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    boolean isPlayerType(int i);

    boolean isPrepared();

    boolean isReleased();

    boolean isReportLogEnable();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    boolean isShouldPlay();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    boolean isStarted();

    boolean isSupportHDR();

    boolean isSupportSR();

    boolean isSystemPlayer();

    boolean isplaybackUsedSR();

    String logcatTag();

    void notifyCacheEnd();

    void openTextureSR(boolean z, boolean z2);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void pause();

    void pauseByInterruption();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void play();

    void playUrlChanged(int i, String str, String str2);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void prepare();

    void putMediaExtraInfo(JSONObject jSONObject);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void release();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void releaseAsync();

    void removeVideoEngineCallback(VideoEngineCallback videoEngineCallback);

    void saveEvent();

    Bitmap saveFrame();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void seekTo(int i, SeekCompletionListener seekCompletionListener);

    void setABRListener(ABRListener aBRListener);

    void setAIBarrageInfoListener(AIBarrageSimpleCallback aIBarrageSimpleCallback);

    void setAIBarrageUrl(String str);

    void setAdditionSubModel(SubModelProvider subModelProvider);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void setAsyncInit(boolean z, int i);

    void setAudioProcessor(AudioProcessor audioProcessor);

    void setAutoRangeRead(int i, int i2);

    void setBarrageMaskHeadLen(int i);

    void setBarrageMaskUrl(String str);

    void setBarrageMaskUrlUseDataLoader(String str, String str2);

    void setBufferThresholdControl(int i, int i2);

    void setCacheControlEnabled(boolean z);

    void setCacheFilePathListener(CacheFilePathListener cacheFilePathListener);

    void setCacheInfoLists(String[] strArr, long[] jArr);

    void setCustomHeader(String str, String str2);

    void setCustomHeaderSync(String str, String str2);

    void setCustomInfo(IVideoEventLogger.VideoEventCustomInfo videoEventCustomInfo, Object obj);

    void setCustomStr(String str);

    void setDaspPlaySignal(List<DaspSignal> list);

    void setDataSource(IMediaDataSource iMediaDataSource);

    void setDataSource(DataSource dataSource);

    void setDataSource(FileDescriptor fileDescriptor, long j, long j2);

    void setDecryptionKey(String str);

    void setDefaultFileCacheDir(String str);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void setDirectURL(String str);

    void setDirectURL(String str, String str2);

    void setDirectUrlUseDataLoader(DirectUrlItem directUrlItem);

    void setDirectUrlUseDataLoader(String str, String str2);

    void setDirectUrlUseDataLoader(String str, String str2, String str3);

    void setDirectUrlUseDataLoader(String[] strArr, String str);

    void setDirectUrlUseDataLoader(String[] strArr, String str, String str2);

    void setDirectUrlUseDataLoaderByFilePath(String str, String str2);

    void setDirectUrlUseDataLoaderByFilePath(String[] strArr, String str);

    void setDirectUrlUseDataLoaderByFilePath(String[] strArr, String str, String str2);

    void setDisplayMode(View view, int i);

    void setEffect(Bundle bundle);

    void setEncodedKey(String str);

    void setExpectedParams(Resolution resolution, Map<Integer, String> map);

    void setExternLogListener(ExternVideoLoggerListener externVideoLoggerListener, String str);

    void setExtraSurface(Surface surface, int i);

    void setFFmpegProtocolObject(TTVideoEngineFFmpegProtocol tTVideoEngineFFmpegProtocol);

    void setFileCacheDir(String str);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void setFloatOption(int i, float f);

    void setGearStrategyEngineConfig(GearStrategyConfig gearStrategyConfig);

    void setGearStrategyExtraParams(Map<String, Object> map);

    void setGearStrategyListener(IGearStrategyListener iGearStrategyListener, Object obj);

    void setGroupID(String str);

    void setGroupIdUseDataLoader(String str);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void setIntOption(int i, int i2);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void setIsMute(boolean z);

    void setLensParams(Bundle bundle);

    void setListener(VideoEngineListener videoEngineListener);

    void setLiveID(String str);

    void setLoadControl(LoadControl loadControl);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void setLocalURL(String str);

    void setLoggerIntOption(int i, int i2);

    void setLoggerLongOption(int i, long j);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void setLongOption(int i, long j);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void setLooping(boolean z);

    void setMaskInfoListener(MaskInfoListener maskInfoListener);

    void setMirrorHorizontal(boolean z);

    void setMirrorVertical(boolean z);

    void setNetworkClient(TTVNetClient tTVNetClient);

    void setObjectOption(int i, Object obj);

    void setPlayAPIVersion(int i, String str);

    void setPlayAuthToken(String str);

    void setPlayAuthToken(String str, int i);

    void setPlayInfo(int i, long j);

    void setPlayItem(TTVideoEnginePlayItem tTVideoEnginePlayItem);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void setPlaybackParams(PlaybackParams playbackParams);

    void setPlayerEventListener(PlayerEventSimpleListener playerEventSimpleListener);

    void setPlayerSurface(Surface surface, int i, int i2);

    void setPreloaderItem(TTAVPreloaderItem tTAVPreloaderItem);

    void setQcomVpp(boolean z, int i);

    void setRadioMode(boolean z);

    void setReportLogEnable(boolean z);

    void setResolutionMap(HashMap<String, Resolution> hashMap);

    void setRotation(int i);

    void setSARChangeListener(SARChangeListener sARChangeListener);

    void setSRInitConfig(int i, String str, String str2, String str3);

    void setSRInitConfig(int i, String str, String str2, String str3, int i2, int i3, int i4);

    void setSpeedShiftConfig(SpeedShiftConfig speedShiftConfig);

    void setSrMaxTextureSize(int i, int i2);

    void setSrMaxTexureSize(int i, int i2);

    void setStartTime(int i);

    void setStrategySource(StrategySource strategySource);

    void setStreamInfoListener(StreamInfoListener streamInfoListener);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void setStringOption(int i, String str);

    void setSubAuthToken(String str);

    void setSubDesInfoModel(SubDesInfoModelProvider subDesInfoModelProvider);

    void setSubInfoCallBack(SubInfoSimpleCallBack subInfoSimpleCallBack);

    void setSubInfoListener(SubInfoListener subInfoListener);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void setSubTag(String str);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void setSurface(Surface surface);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void setSurfaceHolder(SurfaceHolder surfaceHolder);

    void setSurfaceHolder(SurfaceHolder surfaceHolder, boolean z);

    void setSurfaceHolderSync(SurfaceHolder surfaceHolder);

    void setSurfaceSync(Surface surface);

    void setSurfaceSync(Surface surface, long j);

    void setTTHlsDrmToken(String str);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void setTag(String str);

    void setTestSpeedEnable(int i, TestNetSpeedListener testNetSpeedListener);

    void setTokenUrlTemplate(String str);

    void setTraitObject(int i, TraitObject traitObject);

    void setUnSupportSampleRates(int[] iArr);

    void setUseEngineDisplayMode(boolean z);

    void setVideoBufferDetailListener(VideoBufferDetailListener videoBufferDetailListener);

    void setVideoBufferListener(VideoBufferListener videoBufferListener);

    void setVideoEngineCallback(VideoEngineCallback videoEngineCallback);

    void setVideoEngineGetInfoListener(VideoEngineGetInfoListener videoEngineGetInfoListener);

    void setVideoEngineInfoListener(VideoEngineInfoListener videoEngineInfoListener);

    void setVideoEngineSimpleCallback(VideoEngineSimpleCallback videoEngineSimpleCallback);

    void setVideoID(String str);

    void setVideoInfoListener(VideoInfoListener videoInfoListener);

    void setVideoModel(IVideoModel iVideoModel);

    void setVideoModel(VideoModel videoModel);

    void setVideoURLRouteListener(VideoURLRouteListener videoURLRouteListener);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void setVolume(float f, float f2);

    void setWindowClient(TTAVWindowClient tTAVWindowClient);

    void snapshot(SnapshotListener snapshotListener);

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void start();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    void stop();

    boolean supportByteVC1Playback();

    boolean supportByteVC2Playback();

    String[] supportedQualityInfos();

    Resolution[] supportedResolutionTypes();

    List<SubInfo> supportedSubInfoList();

    int[] supportedSubtitleLangs();

    void updateSRStrategyConfig(SRStrategyConfig sRStrategyConfig);

    static {
        Covode.recordClassIndex(652356);
        REGION_CN = SettingsHelper.REGION_CN;
        REGION_US = SettingsHelper.REGION_US;
        REGION_SG = SettingsHelper.REGION_SG;
    }
}
