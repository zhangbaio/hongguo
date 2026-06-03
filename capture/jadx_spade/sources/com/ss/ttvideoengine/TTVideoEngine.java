package com.ss.ttvideoengine;

import al2.b0;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import com.bytedance.apm.util.TimeUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.base.ssconfig.model.PlayerOutputConfig;
import com.dragon.read.app.App;
import com.dragon.read.app.launch.task.r1;
import com.dragon.read.base.ssconfig.local.QualityOptExperiment;
import com.dragon.read.base.ssconfig.template.MdlOpt;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.nuwa.tools.monitor.NuwaObjectMonitor;
import com.dragon.read.nuwa.tools.monitor.ObjectMonitorException;
import com.dragon.read.util.DebugManager;
import com.ss.mediakit.fetcher.AVMDLNewFetcherMakerInterface;
import com.ss.mediakit.fetcher.AVMDLURLFetcherBridge;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.mediakit.medialoader.LoaderListener;
import com.ss.texturerender.VideoSurface;
import com.ss.texturerender.s;
import com.ss.ttm.player.AVThreadPool;
import com.ss.ttm.player.AudioProcessor;
import com.ss.ttm.player.ILibraryLoader;
import com.ss.ttm.player.IMediaDataSource;
import com.ss.ttm.player.LoadControl;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttm.player.TTAVWindowClient;
import com.ss.ttm.player.TraitObject;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.TTVideoEngineMonitor;
import com.ss.ttvideoengine.cache.CopyCacheItem;
import com.ss.ttvideoengine.dasp.DaspSignal;
import com.ss.ttvideoengine.database.IKVStorageProvider;
import com.ss.ttvideoengine.drm.DrmUtils;
import com.ss.ttvideoengine.fetcher.mdlfethcer.FetcherMakerNew;
import com.ss.ttvideoengine.httpdns.ByteDanceHttpDnsDepend;
import com.ss.ttvideoengine.httpdns.BytedanceHTTPDNSParser;
import com.ss.ttvideoengine.info.DeviceInfoVE;
import com.ss.ttvideoengine.info.HARInfo;
import com.ss.ttvideoengine.info.networkRTTLevelListener;
import com.ss.ttvideoengine.log.AppLogEngineUploader;
import com.ss.ttvideoengine.log.EventLoggerSource;
import com.ss.ttvideoengine.log.EventSaver;
import com.ss.ttvideoengine.log.ExternVideoLoggerListener;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.ss.ttvideoengine.log.IVideoEventUploader;
import com.ss.ttvideoengine.log.PortraitNetworkScore;
import com.ss.ttvideoengine.log.VideoEventBase;
import com.ss.ttvideoengine.log.VideoEventLoggerV2;
import com.ss.ttvideoengine.log.VideoEventManager;
import com.ss.ttvideoengine.metrics.IMediaMetrics;
import com.ss.ttvideoengine.model.DubbedInfo;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.SubInfo;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.net.HTTPDNS;
import com.ss.ttvideoengine.net.TTHTTPNetwork;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.playermetrcis.ThreadCPU;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import com.ss.ttvideoengine.preload.PreloadMedia;
import com.ss.ttvideoengine.preload.PreloadModelMedia;
import com.ss.ttvideoengine.preload.PreloadTaskConfig;
import com.ss.ttvideoengine.preload.PreloadURLMedia;
import com.ss.ttvideoengine.preloader.TTAVPreloaderItem;
import com.ss.ttvideoengine.selector.BestResolution;
import com.ss.ttvideoengine.selector.shift.SpeedShiftConfig;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConfig;
import com.ss.ttvideoengine.selector.strategy.IGearStrategyListener;
import com.ss.ttvideoengine.setting.ISettingsListener;
import com.ss.ttvideoengine.setting.SettingsHelper;
import com.ss.ttvideoengine.source.Source;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.ss.ttvideoengine.strategrycenter.IStrategyEventListener;
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import com.ss.ttvideoengine.strategrycenter.StrategyCenter;
import com.ss.ttvideoengine.strategrycenter.StrategyHelper;
import com.ss.ttvideoengine.strategrycenter.StrategyKeys;
import com.ss.ttvideoengine.strategy.EngineStrategyListener;
import com.ss.ttvideoengine.strategy.source.StrategySource;
import com.ss.ttvideoengine.superresolution.SRStrategyConfig;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.FormatProvider;
import com.ss.ttvideoengine.utils.Inspector;
import com.ss.ttvideoengine.utils.SessionIDGenerator;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import java.io.FileDescriptor;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import okhttp3.OkHttpClient;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTVideoEngine implements TTVideoEngineInterface {
    private static boolean HTTP_DNS_FIRST;
    private static boolean mFallbackUseExoPlayer;
    private static boolean mForceUseLitePlayer;
    private static boolean mForceUsePluginPlayer;
    private static HARInfo mHARInfo;
    private static String[] mQualityInfos;
    static int sABRAlgorithmType;
    static int sABRSpeedPredictInputType;
    public static boolean sBuryDataOptimize;
    public static int sBuryDataOptimizeV2;
    public static boolean sColdStartOptimize;
    static int sConfigCenterCheckDiff;
    private static int[] sDNSType;
    public static boolean sDetectPrivateField;
    static float sDeviceScore;
    static int sEnableEncryptBuryData;
    static int sEnableGloablMuteFeature;
    public static int sEnableSelectResultReport;
    public static boolean sEngineCrosstalkCheck;
    static List<VideoEngineStateListener> sEngineStateListeners;
    static int sGlobalMute;
    static int sIsReportTestSpeedInfo;
    static int sNetSpeedAbrPredictType;
    private static int sPlayerOutputLog;
    private static int sRefactorFlag;
    static int sReportSpeedInfoMaxWindowSize;
    static int sTestSpeedInterval;
    static int sTestSpeedSampleInterval;
    static int sUseConfigCenter;
    private final String mLogcatTag;
    private final TTVideoEngineInterface mVideoEngine;

    public static void addStrategySources(List<StrategySource> list) {
    }

    public static void clearAllStrategy() {
    }

    public static void enableEngineStrategy(int i, int i2) {
    }

    public static String getDeviceID() {
        return "";
    }

    public static String getEngineVersion() {
        return "1.10.252.100-novel";
    }

    public static TTVideoEngine getPreRenderEngine(StrategySource strategySource) {
        return null;
    }

    public static TTVideoEngine getPreRenderEngine(String str) {
        return null;
    }

    public static void initAppLog() {
    }

    public static boolean isExpiredIpEnable() {
        return false;
    }

    public static boolean isUsingTTNETHttpDns() {
        return false;
    }

    public static TTVideoEngine removePreRenderEngine(String str) {
        return null;
    }

    public static void setEngineStrategyListener(EngineStrategyListener engineStrategyListener) {
    }

    public static void setExpiredIpEnable(boolean z) {
    }

    public static void setSettingConfig(Context context, Map<String, Object> map) {
    }

    public static void setStrategySources(List<StrategySource> list) {
    }

    public static void setUsingTTNETHttpDns(boolean z) {
    }

    public static void startDataLoader(Context context) throws Exception {
        com_ss_ttvideoengine_TTVideoEngine_com_dragon_read_aop_TTVideoEngineAop_startDataLoader(context);
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void initEngine(Context context, int i) {
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public synchronized void release() {
        com_ss_ttvideoengine_TTVideoEngine_com_dragon_read_aop_TTVideoEngineAop_ttVideoEngineRelease(this);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public synchronized void releaseAsync() {
        com_ss_ttvideoengine_TTVideoEngine_com_dragon_read_aop_TTVideoEngineAop_ttVideoEngineReleaseAsync(this);
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void resetEngine() {
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDefaultFileCacheDir(String str) {
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setDirectURL(String str) {
        com_ss_ttvideoengine_TTVideoEngine_com_dragon_read_aop_TTVideoEngineAop_setDirectURL(this, str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDirectURL(String str, String str2) {
        com_ss_ttvideoengine_TTVideoEngine_com_dragon_read_aop_TTVideoEngineAop_setDirectURL(this, str, str2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setFileCacheDir(String str) {
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setLocalURL(String str) {
        com_ss_ttvideoengine_TTVideoEngine_com_dragon_read_aop_TTVideoEngineAop_setLocalURL(this, str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setTag(String str) {
        com_ss_ttvideoengine_TTVideoEngine_com_dragon_read_aop_TTVideoEngineAop_setTag(this, str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoID(String str) {
        com_ss_ttvideoengine_TTVideoEngine_com_dragon_read_aop_TTVideoEngineAop_setVideoID(this, str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoModel(IVideoModel iVideoModel) {
        com_ss_ttvideoengine_TTVideoEngine_com_dragon_read_aop_TTVideoEngineAop_setVideoModel(this, iVideoModel);
    }

    public static String[] getAllQualityInfos() {
        return mQualityInfos;
    }

    public static int[] getDNSType() {
        return sDNSType;
    }

    public static HARInfo getHARInfo() {
        return mHARInfo;
    }

    public static int getPlayerOutputLog() {
        return sPlayerOutputLog;
    }

    public static int getSpeedPredictorInputType() {
        return sABRSpeedPredictInputType;
    }

    public static boolean isFallbackUseExoPlayer() {
        return mFallbackUseExoPlayer;
    }

    public static boolean isForceUseLitePlayer() {
        return mForceUseLitePlayer;
    }

    public static boolean isForceUsePluginPlayer() {
        return mForceUsePluginPlayer;
    }

    public static boolean isHttpDnsFirst() {
        return HTTP_DNS_FIRST;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String logcatTag() {
        return this.mLogcatTag;
    }

    public static void addTask(String str, String str2, String str3, long j) {
        DataLoaderHelper.getDataLoader().addTask(str, str2, str3, j);
    }

    public static void addTask(String str, String str2, long j, String str3) {
        DataLoaderHelper.getDataLoader().addTask(str, str2, j, str3);
    }

    public static void addTask(String str, String str2, String[] strArr, long j) {
        DataLoaderHelper.getDataLoader().addTask(str, str2, strArr, j);
    }

    public static void addTask(String str, String str2, String[] strArr, long j, String str3) {
        DataLoaderHelper.getDataLoader().addTask(str, str2, strArr, j, str3);
    }

    public static void addTask(String[] strArr, String str, long j, String str2) {
        DataLoaderHelper.getDataLoader().addTask(strArr, str, j, str2);
    }

    public static void addTask(String str, String str2, VideoModel videoModel, Resolution resolution, long j) {
        DataLoaderHelper.getDataLoader().addTask(str, str2, videoModel, resolution, j);
    }

    public static void cancelAllWaitReqs() {
        DataLoaderHelper.getDataLoader().cancelAllWaitReqs();
    }

    public static void clearAllCaches() {
        DataLoaderHelper.getDataLoader().clearAllCaches();
    }

    public static void closeDataLoader() {
        DataLoaderHelper.getDataLoader().close();
    }

    public static GearStrategyConfig getGearStrategyConfig() {
        return GearStrategy.getGlobalConfig();
    }

    public static void onPause() {
        TTVideoEngineLog.d("TTVideoEngine", "onPause");
    }

    public static void onResume() {
        TTVideoEngineLog.d("TTVideoEngine", "onResume");
    }

    public static void removeAllPreloadMedia() {
        removeAllPreloadMedia(null, 1);
    }

    public static void switchToCellularNetwork() {
        DataLoaderHelper.getDataLoader().switchToCellularNetwork();
    }

    public static void switchToDefaultNetwork() {
        DataLoaderHelper.getDataLoader().switchToDefaultNetwork();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void clearTextureRef() {
        this.mVideoEngine.clearTextureRef();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void createPlayerAsync() {
        this.mVideoEngine.createPlayerAsync();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void forceDraw() {
        this.mVideoEngine.forceDraw();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getAPIString() {
        return this.mVideoEngine.getAPIString();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public int getAudioLatencyTime() {
        return this.mVideoEngine.getAudioLatencyTime();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public int getAudioLatencytime() {
        return this.mVideoEngine.getAudioLatencyTime();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getBufferingType() {
        return this.mVideoEngine.getBufferingType();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean getCacheControlEnabled() {
        return this.mVideoEngine.getCacheControlEnabled();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public List<String> getCacheKeys() {
        return this.mVideoEngine.getCacheKeys();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public Context getContext() {
        return this.mVideoEngine.getContext();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getCurrentPlayPath() {
        return this.mVideoEngine.getCurrentPlayPath();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getCurrentPlayUrl() {
        return this.mVideoEngine.getCurrentPlayUrl();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getCurrentPlaybackTime() {
        return this.mVideoEngine.getCurrentPlaybackTime();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getCurrentPlaybackTimeAsync() {
        return this.mVideoEngine.getCurrentPlaybackTimeAsync();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getCurrentQualityDesc() {
        return this.mVideoEngine.getCurrentQualityDesc();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public Resolution getCurrentResolution() {
        return this.mVideoEngine.getCurrentResolution();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getDirectUrl() {
        return this.mVideoEngine.getDirectUrl();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getDuration() {
        return this.mVideoEngine.getDuration();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public GearStrategyConfig getGearStrategyEngineConfig() {
        return this.mVideoEngine.getGearStrategyEngineConfig();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getHash() {
        return this.mVideoEngine.getHash();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public IVideoModel getIVideoModel() {
        return this.mVideoEngine.getIVideoModel();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getLoadState() {
        return this.mVideoEngine.getLoadState();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getLoadedProgress() {
        return this.mVideoEngine.getLoadedProgress();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public IVideoEventLogger getLogger() {
        return this.mVideoEngine.getLogger();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public float getMaxVolume() {
        return this.mVideoEngine.getMaxVolume();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public MediaPlayer getMediaPlayer() {
        return this.mVideoEngine.getMediaPlayer();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public MediaTrackInfoModel[] getMediaTrackInfos() {
        return this.mVideoEngine.getMediaTrackInfos();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean getMirrorHorizontal() {
        return this.mVideoEngine.getMirrorHorizontal();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean getMirrorVertical() {
        return this.mVideoEngine.getMirrorVertical();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public TTVNetClient getNetClientSetByUser() {
        return this.mVideoEngine.getNetClientSetByUser();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public int getPlayAPIVersion() {
        return this.mVideoEngine.getPlayAPIVersion();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public JSONObject getPlayErrorInfo() {
        return this.mVideoEngine.getPlayErrorInfo();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getPlaybackState() {
        return this.mVideoEngine.getPlaybackState();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getPlayerSessionId() {
        return this.mVideoEngine.getPlayerSessionId();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getQualityDescBeforeDowngrade() {
        return this.mVideoEngine.getQualityDescBeforeDowngrade();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public Resolution getResolutionBeforeDowngrade() {
        return this.mVideoEngine.getResolutionBeforeDowngrade();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public int getRotation() {
        return this.mVideoEngine.getRotation();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public int getStartTime() {
        return this.mVideoEngine.getStartTime();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public StrategySource getStrategySource() {
        return this.mVideoEngine.getStrategySource();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getSubTag() {
        return this.mVideoEngine.getSubTag();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public Surface getSurface() {
        return this.mVideoEngine.getSurface();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getTag() {
        return this.mVideoEngine.getTag();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public VideoSurface getTextureSurface() {
        return this.mVideoEngine.getTextureSurface();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getTraceId() {
        return this.mVideoEngine.getTraceId();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        return this.mVideoEngine.getTrackInfo();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public EventLoggerSource getVideoEngineDataSource() {
        return this.mVideoEngine.getVideoEngineDataSource();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public VideoFormatInfo getVideoFormatInfo() {
        return this.mVideoEngine.getVideoFormatInfo();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getVideoHeight() {
        return this.mVideoEngine.getVideoHeight();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getVideoID() {
        return this.mVideoEngine.getVideoID();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public VideoModel getVideoModel() {
        return this.mVideoEngine.getVideoModel();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getVideoWidth() {
        return this.mVideoEngine.getVideoWidth();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public float getVolume() {
        return this.mVideoEngine.getVolume();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getWatchedDuration() {
        return this.mVideoEngine.getWatchedDuration();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean isDashSource() {
        return this.mVideoEngine.isDashSource();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean isInHousePlayer() {
        return this.mVideoEngine.isInHousePlayer();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isLooping() {
        return this.mVideoEngine.isLooping();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isMute() {
        return this.mVideoEngine.isMute();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isOSPlayer() {
        return this.mVideoEngine.isOSPlayer();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean isPrepared() {
        return this.mVideoEngine.isPrepared();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean isReleased() {
        return this.mVideoEngine.isReleased();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean isReportLogEnable() {
        return this.mVideoEngine.isReportLogEnable();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isShouldPlay() {
        return this.mVideoEngine.isShouldPlay();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isStarted() {
        return this.mVideoEngine.isStarted();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean isSupportHDR() {
        return this.mVideoEngine.isSupportHDR();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean isSupportSR() {
        return this.mVideoEngine.isSupportSR();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean isSystemPlayer() {
        return this.mVideoEngine.isSystemPlayer();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean isplaybackUsedSR() {
        return this.mVideoEngine.isplaybackUsedSR();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void notifyCacheEnd() {
        this.mVideoEngine.notifyCacheEnd();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void pause() {
        this.mVideoEngine.pause();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void pauseByInterruption() {
        this.mVideoEngine.pauseByInterruption();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void play() {
        this.mVideoEngine.play();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void prepare() {
        this.mVideoEngine.prepare();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void saveEvent() {
        TTVideoEngineInterface tTVideoEngineInterface = this.mVideoEngine;
        if (tTVideoEngineInterface != null) {
            tTVideoEngineInterface.saveEvent();
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public Bitmap saveFrame() {
        return this.mVideoEngine.saveFrame();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void start() {
        this.mVideoEngine.start();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void stop() {
        this.mVideoEngine.stop();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean supportByteVC1Playback() {
        return this.mVideoEngine.supportByteVC1Playback();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean supportByteVC2Playback() {
        return this.mVideoEngine.supportByteVC2Playback();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String[] supportedQualityInfos() {
        return this.mVideoEngine.supportedQualityInfos();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public Resolution[] supportedResolutionTypes() {
        return this.mVideoEngine.supportedResolutionTypes();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public List<SubInfo> supportedSubInfoList() {
        return this.mVideoEngine.supportedSubInfoList();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public int[] supportedSubtitleLangs() {
        return this.mVideoEngine.supportedSubtitleLangs();
    }

    public String toString() {
        return super.toString();
    }

    public static void cancelAllPreloadTasks() {
        TTVideoEngineLog.d("TTVideoEngine", "<preload> cancel all preload task outside");
        DataLoaderHelper.getDataLoader().cancelAllTasks();
    }

    public static boolean dataLoaderIsRunning() {
        return DataLoaderHelper.getDataLoader().isRunning();
    }

    public static String getAppSessionID() {
        if (!TextUtils.isEmpty(VideoEventBase.appSessionId)) {
            return VideoEventBase.appSessionId;
        }
        return null;
    }

    public static JSONObject getBizPortraitJson() {
        return SettingsHelper.helper().getJsonObject(SettingsHelper.MODULE_BIZ_PORTRAIT);
    }

    public static int getProbeIntervalMS() {
        return DataLoaderHelper.getDataLoader().getProbeIntervalMS();
    }

    public static int getProbeType() {
        return DataLoaderHelper.getDataLoader().getProbeType();
    }

    public static boolean isStrategyCenterRunning() {
        return StrategyHelper.helper().isRunning();
    }

    public static float playTaskProgress() {
        return DataLoaderHelper.getDataLoader().playTaskProgress();
    }

    public static synchronized void releaseTextureRender() {
        synchronized (TTVideoEngine.class) {
            try {
                s.h().l();
            } catch (NullPointerException unused) {
            }
        }
    }

    public synchronized void TTVideoEngine__release$___twin___() {
        this.mVideoEngine.release();
    }

    public synchronized void TTVideoEngine__releaseAsync$___twin___() {
        this.mVideoEngine.releaseAsync();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public synchronized void createPlayer() {
        this.mVideoEngine.createPlayer();
    }

    public static void releaseStartAndSelectGearSpeedPredictor() {
        if (StrategyHelper.helper().moduleSwitch(803) != 0) {
            TTVideoEngineLog.i("TTVideoEngine", "releaseStartAndSelectGearSpeedPredictor, vod strategy speed predictor");
        } else {
            StrategyCenter.closeNewStartAndSelectGearSpeedPredictor();
        }
    }

    public static void setPredictorDataLoaderListener() {
        if (StrategyHelper.helper().moduleSwitch(803) != 0) {
            TTVideoEngineLog.i("TTVideoEngine", "setPredictorDataLoaderListener, vod strategy speed predictor");
        } else {
            DataLoaderHelper.getDataLoader().addListener(DataLoaderListener2ForStrategyCenter.sInstance);
        }
    }

    static {
        Covode.recordClassIndex(652329);
        HTTP_DNS_FIRST = false;
        mForceUseLitePlayer = false;
        mForceUsePluginPlayer = false;
        mHARInfo = null;
        sTestSpeedInterval = 0;
        sTestSpeedSampleInterval = 500;
        sIsReportTestSpeedInfo = 0;
        sReportSpeedInfoMaxWindowSize = 100;
        sNetSpeedAbrPredictType = 0;
        sABRAlgorithmType = 0;
        sABRSpeedPredictInputType = 0;
        mQualityInfos = new String[0];
        sEnableGloablMuteFeature = 0;
        sGlobalMute = 0;
        sDeviceScore = 0.0f;
        sUseConfigCenter = 0;
        sConfigCenterCheckDiff = 0;
        sEnableEncryptBuryData = 0;
        sBuryDataOptimize = false;
        sBuryDataOptimizeV2 = 0;
        sColdStartOptimize = false;
        sDetectPrivateField = false;
        sEngineCrosstalkCheck = true;
        sPlayerOutputLog = 0;
        sEnableSelectResultReport = 0;
        sEngineStateListeners = new CopyOnWriteArrayList();
    }

    public static float getNetworkSpeedFromPredictor() {
        if (StrategyHelper.helper().moduleSwitch(803) != 0) {
            float networkSpeed = StrategyHelper.helper().getNetworkSpeed();
            TTVideoEngineLog.i("TTVideoEngine", " get network speed from vod strategy. info = " + networkSpeed);
            return networkSpeed;
        }
        ss1.b bVar = StrategyCenter.sNetSpeedPredictor;
        if (bVar != null) {
            float b = bVar.b();
            TTVideoEngineLog.d("TTVideoEngine", "[IESSpeedPredictor] get network speed:" + new DecimalFormat("#.000000000").format(b));
            return b;
        }
        return -1.0f;
    }

    public static void configBoeSuffix(String str) {
        TTHelper.configBoeSuffix(str);
    }

    public static void enableTLSv1_2(boolean z) {
        TTHTTPNetwork.enableTLSv1_2(z);
    }

    public static void setAllQualityInfos(String[] strArr) {
        mQualityInfos = strArr;
    }

    public static void setDefaultABRAlgorithm(int i) {
        sABRAlgorithmType = i;
    }

    public static void setFallbackUseExoPlayer(boolean z) {
        mFallbackUseExoPlayer = z;
    }

    public static void setForceUseLitePlayer(boolean z) {
        mForceUseLitePlayer = z;
    }

    public static void setForceUsePluginPlayer(boolean z) {
        mForceUsePluginPlayer = z;
    }

    public static void setFormatProvider(FormatProvider formatProvider) {
        FormatProvider.FormatProviderHolder.set(formatProvider);
    }

    public static void setGlobalNetworkClient(TTVNetClient tTVNetClient) {
        TTVideoEngineConfig.gNetClient = tTVNetClient;
    }

    public static void setHTTPDNSFirst(boolean z) {
        HTTP_DNS_FIRST = z;
    }

    public static void setNativeThreadInterface(NativeThreadInterface nativeThreadInterface) {
        ThreadCPU.gNativeThreadInterface = nativeThreadInterface;
    }

    public static void setOkhttpCliet(OkHttpClient okHttpClient) {
        AVMDLDataLoader.setOkhttpClient(okHttpClient);
    }

    public static void setPlayerOutputLog(int i) {
        sPlayerOutputLog = i;
    }

    public static void setSpeedPredictorListener(ss1.e eVar) {
        StrategyCenter.setSpeedPredictorListener(eVar);
    }

    public static void setSpeedPredictorMlConfig(ss1.f fVar) {
        StrategyCenter.setSpeedPredictorMlConfig(fVar);
    }

    public static void setTTDNSServerHost(String str) {
        HTTPDNS.setTTDNSServerHost(str);
    }

    public static void setupNewSpeedPredictorConfigInfo(Map map) {
        StrategyCenter.setConfigInfo(map);
    }

    public TTVideoEngine(Context context) {
        this(context, 0);
    }

    public static void addEngineStateListener(VideoEngineStateListener videoEngineStateListener) {
        if (videoEngineStateListener != null) {
            sEngineStateListeners.add(videoEngineStateListener);
        }
    }

    public static void addListener(ISettingsListener iSettingsListener) {
        SettingsHelper.helper().addListener(iSettingsListener);
    }

    public static void addPreloadModelMedia(PreloadModelMedia preloadModelMedia) {
        DataLoaderHelper.getDataLoader().addPreloadModelMedia(preloadModelMedia);
    }

    public static void addPreloadURLMedia(PreloadURLMedia preloadURLMedia) {
        DataLoaderHelper.getDataLoader().addPreloadUrlMedia(preloadURLMedia);
    }

    public static void addPriorityPreloadTask(PreloadModelMedia preloadModelMedia) {
        DataLoaderHelper.getDataLoader().addPriorityPreloadTask(preloadModelMedia);
    }

    public static void addTask(PreloaderURLItem preloaderURLItem) {
        DataLoaderHelper.getDataLoader().addTask(preloaderURLItem);
    }

    public static void cancelPreloadTask(String str) {
        DataLoaderHelper.getDataLoader().cancelTask(str);
    }

    public static void cancelPreloadTaskByFilePath(String str) {
        DataLoaderHelper.getDataLoader().cancelTaskByFilePath(str);
    }

    public static void cancelPreloadTaskByVideoId(String str) {
        DataLoaderHelper.getDataLoader().cancelTaskByVideoId(str);
    }

    public static void cleanCacheDir(long j) {
        DataLoaderHelper.getDataLoader().cleanCacheDir(j);
    }

    public static void copyDataLoaderCache(CopyCacheItem copyCacheItem) {
        DataLoaderHelper.getDataLoader().copyCache(copyCacheItem);
    }

    public static void disableAutoTrim(String str) {
        DataLoaderHelper.getDataLoader().disableAutoTrim(str);
    }

    public static void enableAutoTrim(String str) {
        DataLoaderHelper.getDataLoader().enableAutoTrim(str);
    }

    public static VideoInfo findMaxCacheInfo(IVideoModel iVideoModel) {
        return BestResolution.findMaxCacheInfo(iVideoModel, -1);
    }

    public static void forceRemoveCacheFile(String str) {
        DataLoaderHelper.getDataLoader().forceRemoveCacheFile(str);
    }

    public static String getEngineUniqueId(Context context) {
        return DrmUtils.getEngineUniqueId(context);
    }

    public static void onlyUseMediaLoader(boolean z) {
        EngineGlobalConfig.getInstance().onlyUseMediaLoader(z);
    }

    public static void preConnect(String str) {
        DataLoaderHelper.getDataLoader().preConnect(str);
    }

    public static void removeCacheFile(String str) {
        DataLoaderHelper.getDataLoader().removeCacheFile(str);
    }

    public static void removeEngineStateListener(VideoEngineStateListener videoEngineStateListener) {
        sEngineStateListeners.remove(videoEngineStateListener);
    }

    public static void removePriorityPreloadTask(String str) {
        DataLoaderHelper.getDataLoader().removePriorityPreloadTask(str);
    }

    public static void setApplicationContext(Context context) {
        DataLoaderHelper.getDataLoader().setContext(context);
    }

    public static void setClassLoader(ClassLoader classLoader) {
        DataLoaderHelper.getDataLoader().setClassLoader(classLoader);
    }

    public static void setDataLoaderListener(DataLoaderListener dataLoaderListener) {
        DataLoaderHelper.getDataLoader().setListener(dataLoaderListener);
    }

    public static void setDataLoaderNetworkClient(TTVNetClient tTVNetClient) {
        DataLoaderHelper.getDataLoader().setNetworkClient(tTVNetClient);
    }

    public static void setKVStorageProvider(IKVStorageProvider iKVStorageProvider) {
        StrategyHelper.helper().setKVStorageProvider(iKVStorageProvider);
    }

    public static void setLoaderEventListener(LoaderListener loaderListener) {
        DataLoaderHelper.getDataLoader().setLoaderEventListener(loaderListener);
    }

    public static void setNetworkRTTLevelListener(networkRTTLevelListener networkrttlevellistener) {
        PortraitNetworkScore.getInstance().setNetworkRTTLevelListener(networkrttlevellistener);
    }

    public static void setPlayTaskProgress(float f) {
        DataLoaderHelper.getDataLoader().setPlayTaskProgress(f);
    }

    public static void setPortraitService(IPortraitService iPortraitService) {
        StrategyHelper.helper().setPortraitService(iPortraitService);
    }

    public static void setPreloadTaskConfigs(List<PreloadTaskConfig> list) {
        DataLoaderHelper.getDataLoader().setTaskConfigs(list);
    }

    public static void setProbeIntervalMS(int i) {
        DataLoaderHelper.getDataLoader().setProbeIntervalMS(i);
    }

    public static void setProbeType(int i) {
        DataLoaderHelper.getDataLoader().setProbeType(i);
    }

    public static void setProtectCacheDirsAvoidClear(String[] strArr) {
        DataLoaderHelper.getDataLoader().setProtectCacheDirsAvoidClear(strArr);
    }

    public static void setStrategyEventListener(IStrategyEventListener iStrategyEventListener) {
        StrategyHelper.helper().setEventListener(iStrategyEventListener);
    }

    public static void setStrategyStateSupplier(IStrategyStateSupplier iStrategyStateSupplier) {
        StrategyHelper.helper().setSupplier(iStrategyStateSupplier);
    }

    public static void setVideoEventUploader(IVideoEventUploader iVideoEventUploader) {
        VideoEventManager.instance.setUploader(iVideoEventUploader);
    }

    public static void setVodSettingsNetClient(TTVNetClient tTVNetClient) {
        SettingsHelper.helper().setNetClient(tTVNetClient);
    }

    public void TTVideoEngine__setDirectURL$___twin___(String str) {
        this.mVideoEngine.setDirectURL(str);
    }

    public void TTVideoEngine__setLocalURL$___twin___(String str) {
        this.mVideoEngine.setLocalURL(str);
    }

    public void TTVideoEngine__setTag$___twin___(String str) {
        this.mVideoEngine.setTag(str);
    }

    public void TTVideoEngine__setVideoID$___twin___(String str) {
        this.mVideoEngine.setVideoID(str);
    }

    public void TTVideoEngine__setVideoModel$___twin___(IVideoModel iVideoModel) {
        this.mVideoEngine.setVideoModel(iVideoModel);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void addVideoEngineCallback(VideoEngineCallback videoEngineCallback) {
        this.mVideoEngine.addVideoEngineCallback(videoEngineCallback);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void asyncInitSR(boolean z) {
        this.mVideoEngine.asyncInitSR(z);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void configResolution(Resolution resolution) {
        this.mVideoEngine.configResolution(resolution);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void dynamicControlSR(boolean z) {
        this.mVideoEngine.dynamicControlSR(z);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getDubbedMemUrl(List<DubbedInfo> list) {
        return this.mVideoEngine.getDubbedMemUrl(list);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public float getFloatOption(int i) {
        return this.mVideoEngine.getFloatOption(i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getIntOption(int i) {
        return this.mVideoEngine.getIntOption(i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public long getLongOption(int i) {
        return this.mVideoEngine.getLongOption(i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean getLooping(boolean z) {
        return this.mVideoEngine.getLooping(z);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public IMediaMetrics getMetrics(int i) {
        return this.mVideoEngine.getMetrics(i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public Map<String, Object> getStrategyLogData(String str) {
        return this.mVideoEngine.getStrategyLogData(str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public String getStringOption(int i) {
        return this.mVideoEngine.getStringOption(i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getSubtitleContentInfo(int i) {
        return this.mVideoEngine.getSubtitleContentInfo(i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void ignoreSRResolutionLimit(boolean z) {
        this.mVideoEngine.ignoreSRResolutionLimit(z);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void initSRStrategyConfig(SRStrategyConfig sRStrategyConfig) {
        this.mVideoEngine.initSRStrategyConfig(sRStrategyConfig);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isPlayerType(int i) {
        return this.mVideoEngine.isPlayerType(i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void putMediaExtraInfo(JSONObject jSONObject) {
        this.mVideoEngine.putMediaExtraInfo(jSONObject);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void removeVideoEngineCallback(VideoEngineCallback videoEngineCallback) {
        this.mVideoEngine.removeVideoEngineCallback(videoEngineCallback);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setABRListener(ABRListener aBRListener) {
        this.mVideoEngine.setABRListener(aBRListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setAIBarrageInfoListener(AIBarrageSimpleCallback aIBarrageSimpleCallback) {
        this.mVideoEngine.setAIBarrageInfoListener(aIBarrageSimpleCallback);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setAIBarrageUrl(String str) {
        this.mVideoEngine.setAIBarrageUrl(str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setAdditionSubModel(SubModelProvider subModelProvider) {
        this.mVideoEngine.setAdditionSubModel(subModelProvider);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setAudioProcessor(AudioProcessor audioProcessor) {
        this.mVideoEngine.setAudioProcessor(audioProcessor);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setBarrageMaskHeadLen(int i) {
        this.mVideoEngine.setBarrageMaskHeadLen(i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setBarrageMaskUrl(String str) {
        this.mVideoEngine.setBarrageMaskUrl(str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setCacheControlEnabled(boolean z) {
        this.mVideoEngine.setCacheControlEnabled(z);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setCacheFilePathListener(CacheFilePathListener cacheFilePathListener) {
        this.mVideoEngine.setCacheFilePathListener(cacheFilePathListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setCustomStr(String str) {
        this.mVideoEngine.setCustomStr(str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDaspPlaySignal(List<DaspSignal> list) {
        this.mVideoEngine.setDaspPlaySignal(list);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        this.mVideoEngine.setDataSource(iMediaDataSource);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDecryptionKey(String str) {
        this.mVideoEngine.setDecryptionKey(str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDirectUrlUseDataLoader(DirectUrlItem directUrlItem) {
        this.mVideoEngine.setDirectUrlUseDataLoader(directUrlItem);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setEffect(Bundle bundle) {
        this.mVideoEngine.setEffect(bundle);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setEncodedKey(String str) {
        this.mVideoEngine.setEncodedKey(str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setFFmpegProtocolObject(TTVideoEngineFFmpegProtocol tTVideoEngineFFmpegProtocol) {
        TTVideoEngineInterface tTVideoEngineInterface = this.mVideoEngine;
        if (tTVideoEngineInterface != null) {
            tTVideoEngineInterface.setFFmpegProtocolObject(tTVideoEngineFFmpegProtocol);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setGearStrategyEngineConfig(GearStrategyConfig gearStrategyConfig) {
        this.mVideoEngine.setGearStrategyEngineConfig(gearStrategyConfig);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setGearStrategyExtraParams(Map<String, Object> map) {
        this.mVideoEngine.setGearStrategyExtraParams(map);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setGroupID(String str) {
        this.mVideoEngine.setGroupID(str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setGroupIdUseDataLoader(String str) {
        this.mVideoEngine.setGroupIdUseDataLoader(str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setIsMute(boolean z) {
        this.mVideoEngine.setIsMute(z);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setLensParams(Bundle bundle) {
        this.mVideoEngine.setLensParams(bundle);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setListener(VideoEngineListener videoEngineListener) {
        this.mVideoEngine.setListener(videoEngineListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setLiveID(String str) {
        this.mVideoEngine.setVideoID(str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setLoadControl(LoadControl loadControl) {
        this.mVideoEngine.setLoadControl(loadControl);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setLooping(boolean z) {
        this.mVideoEngine.setLooping(z);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setMaskInfoListener(MaskInfoListener maskInfoListener) {
        this.mVideoEngine.setMaskInfoListener(maskInfoListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setMirrorHorizontal(boolean z) {
        this.mVideoEngine.setMirrorHorizontal(z);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setMirrorVertical(boolean z) {
        this.mVideoEngine.setMirrorVertical(z);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setNetworkClient(TTVNetClient tTVNetClient) {
        this.mVideoEngine.setNetworkClient(tTVNetClient);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setPlayAuthToken(String str) {
        this.mVideoEngine.setPlayAuthToken(str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setPlayItem(TTVideoEnginePlayItem tTVideoEnginePlayItem) {
        this.mVideoEngine.setPlayItem(tTVideoEnginePlayItem);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setPlaybackParams(PlaybackParams playbackParams) {
        this.mVideoEngine.setPlaybackParams(playbackParams);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setPlayerEventListener(PlayerEventSimpleListener playerEventSimpleListener) {
        this.mVideoEngine.setPlayerEventListener(playerEventSimpleListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setPreloaderItem(TTAVPreloaderItem tTAVPreloaderItem) {
        this.mVideoEngine.setPreloaderItem(tTAVPreloaderItem);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setRadioMode(boolean z) {
        this.mVideoEngine.setRadioMode(z);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setReportLogEnable(boolean z) {
        this.mVideoEngine.setReportLogEnable(z);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setResolutionMap(HashMap<String, Resolution> hashMap) {
        this.mVideoEngine.setResolutionMap(hashMap);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setRotation(int i) {
        this.mVideoEngine.setRotation(i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSARChangeListener(SARChangeListener sARChangeListener) {
        this.mVideoEngine.setSARChangeListener(sARChangeListener);
    }

    public void setSource(Source source) {
        this.mVideoEngine.setStrategySource((StrategySource) source);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSpeedShiftConfig(SpeedShiftConfig speedShiftConfig) {
        this.mVideoEngine.setSpeedShiftConfig(speedShiftConfig);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setStartTime(int i) {
        this.mVideoEngine.setStartTime(i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setStrategySource(StrategySource strategySource) {
        this.mVideoEngine.setStrategySource(strategySource);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setStreamInfoListener(StreamInfoListener streamInfoListener) {
        this.mVideoEngine.setStreamInfoListener(streamInfoListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSubAuthToken(String str) {
        this.mVideoEngine.setSubAuthToken(str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSubDesInfoModel(SubDesInfoModelProvider subDesInfoModelProvider) {
        this.mVideoEngine.setSubDesInfoModel(subDesInfoModelProvider);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSubInfoCallBack(SubInfoSimpleCallBack subInfoSimpleCallBack) {
        this.mVideoEngine.setSubInfoCallBack(subInfoSimpleCallBack);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSubInfoListener(SubInfoListener subInfoListener) {
        this.mVideoEngine.setSubInfoListener(subInfoListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setSubTag(String str) {
        this.mVideoEngine.setSubTag(str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setSurface(Surface surface) {
        this.mVideoEngine.setSurface(surface);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.mVideoEngine.setSurfaceHolder(surfaceHolder);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSurfaceHolderSync(SurfaceHolder surfaceHolder) {
        this.mVideoEngine.setSurfaceHolderSync(surfaceHolder);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSurfaceSync(Surface surface) {
        this.mVideoEngine.setSurfaceSync(surface);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setTTHlsDrmToken(String str) {
        this.mVideoEngine.setTTHlsDrmToken(str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setTokenUrlTemplate(String str) {
        this.mVideoEngine.setTokenUrlTemplate(str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setUnSupportSampleRates(int[] iArr) {
        this.mVideoEngine.setUnSupportSampleRates(iArr);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setUseEngineDisplayMode(boolean z) {
        this.mVideoEngine.setUseEngineDisplayMode(z);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoBufferDetailListener(VideoBufferDetailListener videoBufferDetailListener) {
        this.mVideoEngine.setVideoBufferDetailListener(videoBufferDetailListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoBufferListener(VideoBufferListener videoBufferListener) {
        this.mVideoEngine.setVideoBufferListener(videoBufferListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoEngineCallback(VideoEngineCallback videoEngineCallback) {
        this.mVideoEngine.setVideoEngineCallback(videoEngineCallback);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoEngineGetInfoListener(VideoEngineGetInfoListener videoEngineGetInfoListener) {
        this.mVideoEngine.setVideoEngineGetInfoListener(videoEngineGetInfoListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoEngineInfoListener(VideoEngineInfoListener videoEngineInfoListener) {
        this.mVideoEngine.setVideoEngineInfoListener(videoEngineInfoListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoEngineSimpleCallback(VideoEngineSimpleCallback videoEngineSimpleCallback) {
        this.mVideoEngine.setVideoEngineSimpleCallback(videoEngineSimpleCallback);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoInfoListener(VideoInfoListener videoInfoListener) {
        this.mVideoEngine.setVideoInfoListener(videoInfoListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoModel(VideoModel videoModel) {
        this.mVideoEngine.setVideoModel(videoModel);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoURLRouteListener(VideoURLRouteListener videoURLRouteListener) {
        this.mVideoEngine.setVideoURLRouteListener(videoURLRouteListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setWindowClient(TTAVWindowClient tTAVWindowClient) {
        this.mVideoEngine.setWindowClient(tTAVWindowClient);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void snapshot(SnapshotListener snapshotListener) {
        this.mVideoEngine.snapshot(snapshotListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void updateSRStrategyConfig(SRStrategyConfig sRStrategyConfig) {
        this.mVideoEngine.updateSRStrategyConfig(sRStrategyConfig);
    }

    public static void addPreloadMedias(List<PreloadMedia> list) {
        DataLoaderHelper.getDataLoader().addPreloadMedias(list, null);
    }

    public static void addTask(PreloaderVidItem preloaderVidItem) {
        DataLoaderHelper.getDataLoader().addTask(preloaderVidItem);
    }

    public static void clearAllCaches(boolean z) {
        DataLoaderHelper.getDataLoader().clearAllCaches(z);
    }

    public static long getCacheFileSizeByFilePath(String str) {
        return DataLoaderHelper.getDataLoader().getCacheSizeByFilePath(str);
    }

    public static DataLoaderHelper.DataLoaderCacheInfo getCacheInfo(String str) {
        return DataLoaderHelper.getDataLoader().getCacheInfo(str);
    }

    public static DataLoaderHelper.DataLoaderCacheInfo getCacheInfoByFilePath(String str) {
        return DataLoaderHelper.getDataLoader().getCacheInfoByFilePath(str);
    }

    public static long getIoWriteError(String str) {
        return DataLoaderHelper.getDataLoader().getIoWriteError(str);
    }

    public static int getModuleSwitch(int i) {
        return StrategyHelper.helper().moduleSwitch(i);
    }

    public static String getStringValue(int i) {
        return DataLoaderHelper.getDataLoader().getStringValue(i);
    }

    public static JSONObject getVodPreloadLabel(String str) {
        return SettingsHelper.helper().getVodJsonObject(str);
    }

    public static void removeMedia(String str) {
        DataLoaderHelper.getDataLoader().removeMedia(str, "");
    }

    public static void saveAllPlayEvent(Context context) {
        if (context == null) {
            return;
        }
        EventSaver.getInstance(context).saveAllPlayEvent();
    }

    public static void setDaspBusinessSignal(List<DaspSignal> list) {
        StrategyHelper.helper().setDaspNonPlaySignal(31223, list);
    }

    public static void setPlayerThreadPoolExecutor(ExecutorService executorService) {
        TTVideoEngineLog.i("TTVideoEngine", "set player threadpool");
        AVThreadPool.setExecutorInstance(executorService);
    }

    public static void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        TTVideoEngineLog.i("TTVideoEngine", "set threadpool");
        EngineThreadPool.setExecutorInstance(threadPoolExecutor);
    }

    public static long tryQuickQueryCacheFileSize(String str) {
        return DataLoaderHelper.getDataLoader().quickQueryCacheFileSize(str);
    }

    public static void uploadSavedEvent(Context context) {
        EventSaver.getInstance(context).uploadIfExits(true);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDataSource(DataSource dataSource) {
        this.mVideoEngine.setDataSource(dataSource);
    }

    public static void TTVideoEngine__startDataLoader$___twin___(Context context) throws Exception {
        DataLoaderHelper.getDataLoader().setContext(context);
        try {
            DataLoaderHelper.getDataLoader().start();
            TTVideoEngineLog.d("TTVideoEngine", "DataLoader Start");
        } catch (Exception e) {
            TTVideoEngineLog.d("TTVideoEngine", "DataLoader Start Fail");
            throw e;
        }
    }

    public static void addTask(PreloaderVideoModelItem preloaderVideoModelItem) {
        DataLoaderHelper.getDataLoader().addTask(preloaderVideoModelItem);
    }

    public static String computeMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (Exception unused) {
            return str;
        }
    }

    public static Map<String, String> getPlayerAbility(int i) {
        HashMap hashMap = new HashMap();
        if (i == 5 || i == 2) {
            hashMap.put("unsupport_bytevc2", "true");
            hashMap.put("unsupport_dash", "true");
        }
        return hashMap;
    }

    public static void openBytedanceHTTPDNS(ByteDanceHttpDnsDepend byteDanceHttpDnsDepend) {
        EngineGlobalConfig.getInstance().setDnsCustomType(new BytedanceHTTPDNSParser(byteDanceHttpDnsDepend).start());
    }

    public static long quickGetCacheFileSize(String str) {
        long tryQuickGetCacheFileSize = DataLoaderHelper.getDataLoader().tryQuickGetCacheFileSize(str);
        if (tryQuickGetCacheFileSize == 0) {
            return DataLoaderHelper.getDataLoader().getCacheSize(str);
        }
        return tryQuickGetCacheFileSize;
    }

    public static void setDeviceInfo(DeviceInfoVE deviceInfoVE) {
        if (deviceInfoVE == null) {
            return;
        }
        TTVideoEngineLog.d("TTVideoEngine", "DeviceInfoVE.overAllScore: " + DeviceInfoVE.overAllScore);
    }

    public static void setGearStrategyConfig(GearStrategyConfig gearStrategyConfig) {
        TTVideoEngineLog.i("TTVideoEngine", "[GearStrategy]setGearStrategyConfig config=" + gearStrategyConfig);
        GearStrategy.setGlobalConfig(gearStrategyConfig);
    }

    public static void setupSpeedPredictorInputType(int i) {
        sABRSpeedPredictInputType = i;
        if (i == 2) {
            DataLoaderHelper.getDataLoader().setIntValue(112, 500);
        } else {
            DataLoaderHelper.getDataLoader().setIntValue(112, 0);
        }
    }

    public static void startStartAndSelectGearSpeedPredictor(int i) {
        if (StrategyHelper.helper().moduleSwitch(803) != 0) {
            TTVideoEngineLog.i("TTVideoEngine", "startStartAndSelectGearSpeedPredictor ,vod strategy speed predictor");
        } else {
            if (StrategyCenter.sNetSpeedPredictor != null) {
                return;
            }
            StrategyCenter.createNewStartAndSelectGearSpeedPredictor(i);
            setPredictorDataLoaderListener();
        }
    }

    @TargetClass("com.ss.ttvideoengine.TTVideoEngine")
    @Insert("release")
    public static void com_ss_ttvideoengine_TTVideoEngine_com_dragon_read_aop_TTVideoEngineAop_ttVideoEngineRelease(TTVideoEngine tTVideoEngine) {
        tTVideoEngine.TTVideoEngine__release$___twin___();
        if (QualityOptExperiment.INSTANCE.getConfig().engineMonitorEnable) {
            NuwaObjectMonitor.INSTANCE.onDestroy(tTVideoEngine, null, "");
            LogWrapper.info("TT_PLAYER_MONITOR", "ttVideoEngineRelease:" + tTVideoEngine, new Object[0]);
        }
    }

    @TargetClass("com.ss.ttvideoengine.TTVideoEngine")
    @Insert("releaseAsync")
    public static void com_ss_ttvideoengine_TTVideoEngine_com_dragon_read_aop_TTVideoEngineAop_ttVideoEngineReleaseAsync(TTVideoEngine tTVideoEngine) {
        tTVideoEngine.TTVideoEngine__releaseAsync$___twin___();
        if (QualityOptExperiment.INSTANCE.getConfig().engineMonitorEnable) {
            NuwaObjectMonitor.INSTANCE.onDestroy(tTVideoEngine, null, "");
            LogWrapper.info("TT_PLAYER_MONITOR", "ttVideoEngineReleaseAsync:" + tTVideoEngine, new Object[0]);
        }
    }

    public static void enableNewMDLFetcher(boolean z) {
        try {
            if (z) {
                AVMDLURLFetcherBridge.setNewFetcherMaker(FetcherMakerNew.getInstance());
            } else {
                AVMDLURLFetcherBridge.setNewFetcherMaker((AVMDLNewFetcherMakerInterface) null);
            }
        } catch (Throwable th) {
            TTVideoEngineLog.i("TTVideoEngine", "setFetcherMakerNew exception " + th);
        }
    }

    public static void focusEngine(TTVideoEngine tTVideoEngine) {
        if (tTVideoEngine == null) {
            return;
        }
        TTVideoEngineLog.i("TTVideoEngine", "[strategy] focus engine" + tTVideoEngine.getVideoID());
        focusMedia(tTVideoEngine.getVideoID(), 1);
    }

    public static void removeCacheFile(IVideoModel iVideoModel) {
        List<VideoInfo> videoInfoList;
        if (iVideoModel != null && iVideoModel.hasData() && (videoInfoList = iVideoModel.getVideoInfoList()) != null && videoInfoList.size() > 0) {
            Iterator<VideoInfo> it2 = videoInfoList.iterator();
            while (it2.hasNext()) {
                DataLoaderHelper.getDataLoader().forceRemoveCacheFile(it2.next().getValueStr(15));
            }
        }
    }

    public static void setHARInfo(HARInfo hARInfo) {
        if (hARInfo == null) {
            TTVideoEngineLog.i("TTVideoEngine", "setHARInfo harInfo is null");
        } else {
            TTVideoEngineLog.i("TTVideoEngine", String.format("setHARInfo status=%d score=%d", Integer.valueOf(hARInfo.getHARStatus()), Integer.valueOf(hARInfo.getHARScore())));
            mHARInfo = hARInfo;
        }
    }

    public static synchronized void setPlayerLibraryLoader(ILibraryLoader iLibraryLoader) {
        synchronized (TTVideoEngine.class) {
            try {
                Class<?> clzUsingPluginLoader = TTHelper.getClzUsingPluginLoader(200, "com.ss.ttm.player.TTPlayerLibLoader");
                Method declaredMethod = clzUsingPluginLoader.getDeclaredMethod("setLibraryLoader", ILibraryLoader.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(clzUsingPluginLoader, iLibraryLoader);
            } catch (Throwable th) {
                TTVideoEngineLog.e("TTVideoEngine", "setPlayerLibraryLoader failed = " + th);
            }
        }
    }

    public static void startIESSpeedPredictor(int i) {
        if (!FeatureManager.hasPermission("net_speed")) {
            return;
        }
        if (StrategyHelper.helper().moduleSwitch(803) != 0) {
            TTVideoEngineLog.i("TTVideoEngine", "startIESSpeedPredictor, vod strategy speed predictor");
        } else {
            if (StrategyCenter.sNetSpeedPredictor != null) {
                return;
            }
            StrategyCenter.createSpeedPredictor(i);
            setPredictorDataLoaderListener();
        }
    }

    @TargetClass("com.ss.ttvideoengine.TTVideoEngine")
    @Insert("startDataLoader")
    public static void com_ss_ttvideoengine_TTVideoEngine_com_dragon_read_aop_TTVideoEngineAop_startDataLoader(Context context) throws Exception {
        r1.h();
        try {
            TTVideoEngine__startDataLoader$___twin___(context);
            if ((!x10.a.b(App.context()) || !DebugManager.inst().getEngineDebugSwitch()) && PlayerOutputConfig.b().vcStrategyLogLevel >= 0) {
                StrategyHelper.helper().setLogLevel(PlayerOutputConfig.b().vcStrategyLogLevel);
            }
        } catch (Throwable th) {
            LogWrapper.error("AudioCore-TTVideoEngineAops", "startDataLoader ,throwable = " + Log.getStackTraceString(th), new Object[0]);
        }
    }

    public static long getCacheFileSize(String str) {
        return DataLoaderHelper.getDataLoader().getCacheSize(str);
    }

    public static void addPreloadMedias(List<PreloadMedia> list, String str) {
        DataLoaderHelper.getDataLoader().addPreloadMedias(list, str);
    }

    public static void cleanSpecifiedCacheDir(String str, int i) {
        DataLoaderHelper.getDataLoader().cleanSpecifiedCacheDir(str, i);
    }

    public static Resolution findBestResolution(VideoModel videoModel, int i) {
        return findBestResolution(videoModel, Resolution.Standard, i, null);
    }

    public static Resolution findDefaultResolution(VideoModel videoModel, Resolution resolution) {
        return BestResolution.findDefaultResolution(videoModel, resolution);
    }

    public static Resolution findMaxCacheResolution(VideoModel videoModel, Resolution resolution) {
        return BestResolution.findMaxCacheResolution(videoModel, resolution);
    }

    public static Resolution findMaxQualityResolution(VideoModel videoModel, Resolution resolution) {
        return BestResolution.findMaxQualityResolution(videoModel, resolution);
    }

    public static long getCacheFileSize(IVideoModel iVideoModel, Resolution resolution) {
        return getCacheFileSize(iVideoModel, resolution, (Map<Integer, String>) null);
    }

    public static void removeMedia(String str, String str2) {
        DataLoaderHelper.getDataLoader().removeMedia(str, str2);
    }

    public static void removePreloadMedia(PreloadMedia preloadMedia, String str) {
        DataLoaderHelper.getDataLoader().removePreloadMedia(preloadMedia, str);
    }

    public static void setIntValueSync(int i, int i2) {
        DataLoaderHelper.getDataLoader().setIntValueSync(i, i2);
    }

    public static void setStringValueSync(int i, String str) {
        DataLoaderHelper.getDataLoader().setStringValueSync(i, str);
    }

    public static void startSpeedPredictor(int i, int i2) {
        startSpeedPredictor(i, i2, 0, 0);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean clearSurface(Surface surface, boolean z) {
        return this.mVideoEngine.clearSurface(surface, z);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void configParams(Resolution resolution, Map<Integer, String> map) {
        this.mVideoEngine.configParams(resolution, map);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public ArrayList<HashMap<String, Object>> crosstalkHappen(ArrayList<TTVideoEngine> arrayList, HashMap<String, TTVideoEngineMonitor.TTVideoEngineLivePlayerInfo> hashMap) {
        return this.mVideoEngine.crosstalkHappen(arrayList, hashMap);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void openTextureSR(boolean z, boolean z2) {
        this.mVideoEngine.openTextureSR(z, z2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void seekTo(int i, SeekCompletionListener seekCompletionListener) {
        this.mVideoEngine.seekTo(i, seekCompletionListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setAsyncInit(boolean z, int i) {
        this.mVideoEngine.setAsyncInit(z, i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setAutoRangeRead(int i, int i2) {
        this.mVideoEngine.setAutoRangeRead(i, i2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setBarrageMaskUrlUseDataLoader(String str, String str2) {
        this.mVideoEngine.setBarrageMaskUrlUseDataLoader(str, str2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setBufferThresholdControl(int i, int i2) {
        this.mVideoEngine.setBufferThresholdControl(i, i2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setCacheInfoLists(String[] strArr, long[] jArr) {
        this.mVideoEngine.setCacheInfoLists(strArr, jArr);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setCustomHeader(String str, String str2) {
        this.mVideoEngine.setCustomHeader(str, str2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setCustomHeaderSync(String str, String str2) {
        this.mVideoEngine.setCustomHeaderSync(str, str2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setCustomInfo(IVideoEventLogger.VideoEventCustomInfo videoEventCustomInfo, Object obj) {
        this.mVideoEngine.setCustomInfo(videoEventCustomInfo, obj);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDirectUrlUseDataLoaderByFilePath(String str, String str2) {
        this.mVideoEngine.setDirectUrlUseDataLoaderByFilePath(str, str2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDisplayMode(View view, int i) {
        this.mVideoEngine.setDisplayMode(view, i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setExpectedParams(Resolution resolution, Map<Integer, String> map) {
        this.mVideoEngine.setExpectedParams(resolution, map);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setExternLogListener(ExternVideoLoggerListener externVideoLoggerListener, String str) {
        this.mVideoEngine.setExternLogListener(externVideoLoggerListener, str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setExtraSurface(Surface surface, int i) {
        this.mVideoEngine.setExtraSurface(surface, i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setFloatOption(int i, float f) {
        this.mVideoEngine.setFloatOption(i, f);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setIntOption(int i, int i2) {
        this.mVideoEngine.setIntOption(i, i2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setLoggerIntOption(int i, int i2) {
        this.mVideoEngine.setLoggerIntOption(i, i2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setLoggerLongOption(int i, long j) {
        this.mVideoEngine.setLoggerLongOption(i, j);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setLongOption(int i, long j) {
        this.mVideoEngine.setLongOption(i, j);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setObjectOption(int i, Object obj) {
        this.mVideoEngine.setObjectOption(i, obj);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setPlayAPIVersion(int i, String str) {
        this.mVideoEngine.setPlayAPIVersion(i, str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setPlayInfo(int i, long j) {
        this.mVideoEngine.setPlayInfo(i, j);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setQcomVpp(boolean z, int i) {
        this.mVideoEngine.setQcomVpp(z, i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSrMaxTextureSize(int i, int i2) {
        this.mVideoEngine.setSrMaxTextureSize(i, i2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSrMaxTexureSize(int i, int i2) {
        this.mVideoEngine.setSrMaxTextureSize(i, i2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setStringOption(int i, String str) {
        this.mVideoEngine.setStringOption(i, str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setTestSpeedEnable(int i, TestNetSpeedListener testNetSpeedListener) {
        this.mVideoEngine.setTestSpeedEnable(i, testNetSpeedListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setTraitObject(int i, TraitObject traitObject) {
        this.mVideoEngine.setTraitObject(i, traitObject);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setVolume(float f, float f2) {
        this.mVideoEngine.setVolume(f, f2);
    }

    public static void addPreloadModelMedia(PreloadModelMedia preloadModelMedia, String str) {
        preloadModelMedia.mSceneId = str;
        DataLoaderHelper.getDataLoader().addPreloadModelMedia(preloadModelMedia);
    }

    public static void businessEvent(int i, int i2) {
        StrategyHelper.helper().getCenter().e(i, i2);
    }

    public static String encryptTimestamp(Context context, long j) {
        return JniUtils.encryptTimestamp(String.valueOf(j), getEngineUniqueId(context));
    }

    public static VideoInfo findMaxCacheInfo(IVideoModel iVideoModel, int i) {
        return BestResolution.findMaxCacheInfo(iVideoModel, i);
    }

    public static long getCacheFileSize(VideoModel videoModel, Resolution resolution) {
        return getCacheFileSize((IVideoModel) videoModel, resolution);
    }

    public static void removeAllPreloadMedia(String str, int i) {
        DataLoaderHelper.getDataLoader().removeAllPreloadMedia(str, i);
    }

    public void TTVideoEngine__setDirectURL$___twin___(String str, String str2) {
        this.mVideoEngine.setDirectURL(str, str2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDirectUrlUseDataLoader(String str, String str2) {
        this.mVideoEngine.setDirectUrlUseDataLoader(str, str2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDirectUrlUseDataLoaderByFilePath(String[] strArr, String str) {
        this.mVideoEngine.setDirectUrlUseDataLoaderByFilePath(strArr, str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setGearStrategyListener(IGearStrategyListener iGearStrategyListener, Object obj) {
        this.mVideoEngine.getGearStrategyEngineConfig().setGearStrategyListener(iGearStrategyListener).setUserData(obj);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setPlayAuthToken(String str, int i) {
        this.mVideoEngine.setPlayAuthToken(str, i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSurfaceHolder(SurfaceHolder surfaceHolder, boolean z) {
        this.mVideoEngine.setSurfaceHolder(surfaceHolder, z);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSurfaceSync(Surface surface, long j) {
        this.mVideoEngine.setSurfaceSync(surface, j);
    }

    @TargetClass("com.ss.ttvideoengine.TTVideoEngine")
    @Insert("setDirectURL")
    public static void com_ss_ttvideoengine_TTVideoEngine_com_dragon_read_aop_TTVideoEngineAop_setDirectURL(TTVideoEngine tTVideoEngine, String str) {
        if (MdlOpt.b().enableHook && !TextUtils.isEmpty(str)) {
            tTVideoEngine.setIntOption(160, 1);
            tTVideoEngine.setDirectUrlUseDataLoader(str, computeMD5(str));
        } else {
            tTVideoEngine.TTVideoEngine__setDirectURL$___twin___(str);
        }
    }

    @TargetClass("com.ss.ttvideoengine.TTVideoEngine")
    @Insert("setVideoID")
    public static void com_ss_ttvideoengine_TTVideoEngine_com_dragon_read_aop_TTVideoEngineAop_setVideoID(TTVideoEngine tTVideoEngine, String str) {
        if (MdlOpt.b().enableHook) {
            tTVideoEngine.setIntOption(160, 1);
            tTVideoEngine.setIntOption(21, 1);
        }
        tTVideoEngine.TTVideoEngine__setVideoID$___twin___(str);
    }

    public static void focusMedia(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.i("TTVideoEngine", "[strategy] focus media . videoId is null");
        } else {
            DataLoaderHelper.getDataLoader().focusMedia(str, i);
        }
    }

    public static void setLongValue(int i, long j) {
        if (i == 217) {
            EngineGlobalConfig.getInstance().setALogWriteAddr(j);
        } else if (i == 745) {
            EngineGlobalConfig.getInstance().setEngineOptimizeFlag(j);
        } else {
            DataLoaderHelper.getDataLoader().setLongValue(i, j);
        }
    }

    @TargetClass("com.ss.ttvideoengine.TTVideoEngine")
    @Insert("setTag")
    public static void com_ss_ttvideoengine_TTVideoEngine_com_dragon_read_aop_TTVideoEngineAop_setTag(TTVideoEngine tTVideoEngine, String str) {
        tTVideoEngine.TTVideoEngine__setTag$___twin___(str);
        try {
            boolean isSystemPlayer = tTVideoEngine.isSystemPlayer();
            b0.q(isSystemPlayer, str);
            LogWrapper.info("AudioCore-TTVideoEngineAops", "setTag ,systemPlayer = " + isSystemPlayer, new Object[0]);
        } catch (Throwable th) {
            LogWrapper.error("AudioCore-TTVideoEngineAops", "setTag ,exception = " + th.getMessage(), new Object[0]);
        }
    }

    public static void setAlgorithmJson(int i, String str) {
        TTVideoEngineLog.d("TTVideoEngine", "[strategy] setAlgorithmJson key=" + i + " jsonString" + str);
        StrategyHelper.helper().setAlgorithmJson(i, str);
    }

    public static void setDNSType(int i, int i2) {
        sDNSType = new int[]{i, i2};
        TTVideoEngineLog.i("TTVideoEngine", "setDNSType main:" + i + " backup:" + i2);
    }

    public static void setReportLogByEngine(boolean z, Context context) {
        TTVideoEngineLog.i("TTVideoEngine", "setReportLogByEngine " + z);
        if (context == null) {
            TTVideoEngineLog.e("TTVideoEngine", "setReportLogByEngine context is null");
        } else {
            AppLogEngineUploader.getInstance().setReportLogByEngine(z, context.getApplicationContext());
        }
    }

    public static void setStringValue(int i, String str) {
        if (i > 50000 && i <= 59999) {
            StrategyHelper.helper().setStringValue(i, str);
        }
        SettingsHelper.helper().setRegionHost(i, str);
        DataLoaderHelper.getDataLoader().setStringValue(i, str);
        if (i == 122) {
            Inspector.share().setHost(str);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDirectUrlUseDataLoader(String[] strArr, String str) {
        this.mVideoEngine.setDirectUrlUseDataLoader(strArr, str);
    }

    public TTVideoEngine(Context context, int i) {
        this(context, i, null);
        if (QualityOptExperiment.INSTANCE.getConfig().engineMonitorEnable) {
            NuwaObjectMonitor.INSTANCE.onLoad(this, new ObjectMonitorException("NuwaObjectMonitor onLoad: object=" + this + ", load_time= " + TimeUtils.getCurrentFormatTime()), false, "");
            StringBuilder sb = new StringBuilder();
            sb.append("ttVideoEngineExit1:");
            sb.append(this);
            LogWrapper.info("TT_PLAYER_MONITOR", sb.toString(), new Object[0]);
        }
    }

    public static void businessEvent(int i, String str) {
        StrategyHelper.helper().getCenter().h(i, str);
    }

    @TargetClass("com.ss.ttvideoengine.TTVideoEngine")
    @Insert("setLocalURL")
    public static void com_ss_ttvideoengine_TTVideoEngine_com_dragon_read_aop_TTVideoEngineAop_setLocalURL(TTVideoEngine tTVideoEngine, String str) {
        tTVideoEngine.TTVideoEngine__setLocalURL$___twin___(str);
        try {
            LogWrapper.info("AudioCore-TTVideoEngineAops", "setLocalURL ,TTVideoEngine = " + tTVideoEngine, new Object[0]);
            LogWrapper.info("AudioCore-TTVideoEngineAops", "setLocalURL " + str, new Object[0]);
        } catch (Throwable th) {
            LogWrapper.error("AudioCore-TTVideoEngineAops", "setLocalURL ,exception = " + th.getMessage(), new Object[0]);
        }
    }

    @TargetClass("com.ss.ttvideoengine.TTVideoEngine")
    @Insert("setVideoModel")
    public static void com_ss_ttvideoengine_TTVideoEngine_com_dragon_read_aop_TTVideoEngineAop_setVideoModel(TTVideoEngine tTVideoEngine, IVideoModel iVideoModel) {
        tTVideoEngine.TTVideoEngine__setVideoModel$___twin___(iVideoModel);
        try {
            LogWrapper.info("AudioCore-TTVideoEngineAops", "setVideoModel ,TTVideoEngine = " + tTVideoEngine, new Object[0]);
            if (iVideoModel instanceof VideoModel) {
                LogWrapper.info("AudioCore-TTVideoEngineAops", "setVideoModel " + ((VideoModel) iVideoModel).toMediaInfoJsonString(), new Object[0]);
            }
        } catch (Throwable th) {
            LogWrapper.error("AudioCore-TTVideoEngineAops", "setVideoModel ,exception = " + th.getMessage(), new Object[0]);
        }
    }

    public static List<Resolution> findCachedResolutionList(VideoModel videoModel, Map<Integer, String> map) {
        int i;
        ArrayList arrayList = new ArrayList();
        if (videoModel == null) {
            return arrayList;
        }
        Resolution[] supportResolutions = videoModel.getSupportResolutions();
        if (supportResolutions != null && supportResolutions.length >= 1) {
            String videoRefStr = videoModel.getVideoRefStr(7);
            if (TextUtils.isEmpty(videoRefStr) && videoRefStr.equals("audio")) {
                i = VideoRef.TYPE_AUDIO;
            } else {
                i = VideoRef.TYPE_VIDEO;
            }
            Resolution resolution = supportResolutions[0];
            for (Resolution resolution2 : supportResolutions) {
                VideoInfo videoInfo = videoModel.getVideoInfo(resolution2, i, map, false);
                if (videoInfo != null && DataLoaderHelper.getDataLoader().getCacheFileSize(videoInfo.getValueStr(15)) > 0 && videoInfo.getResolution() != null) {
                    arrayList.add(videoInfo.getResolution());
                }
            }
        }
        return arrayList;
    }

    public static void setFloatValue(int i, float f) {
        TTVideoEngineLog.i("TTVideoEngine", "TTVideoEngine.setFloatValue key=" + i + " value=" + f);
        if (i != 738) {
            if (i == 739) {
                businessEvent(1004, Float.toString(f));
            }
        } else if (f != Float.NaN && f > 0.0f) {
            sDeviceScore = f;
            PortraitEngine.getInstance().setLabel("device_score", Float.valueOf(f));
            DataLoaderHelper.getDataLoader().setIntValue(123, (int) (f * 10.0f));
        }
    }

    public static void setAppInfo(Context context, Map map) {
        if (map != null && map.size() > 0) {
            try {
                TTVideoEngineLog.d("TTVideoEngine", "setAppInfo:" + map.toString());
                BaseAppInfo.mContext = context;
                BaseAppInfo.mAppID = TTHelper.parseInt(map.get("appid"));
                BaseAppInfo.mAppName = (String) map.get("appname");
                BaseAppInfo.mAppChannel = (String) map.get("appchannel");
                BaseAppInfo.mAppVersion = (String) map.get("appversion");
                if (map.containsKey("screen_height")) {
                    BaseAppInfo.mScreenHeight = ((Integer) map.get("screen_height")).intValue();
                }
                if (map.containsKey("screen_width")) {
                    BaseAppInfo.mScreenWidth = ((Integer) map.get("screen_width")).intValue();
                }
                if (map.containsKey("deviceid")) {
                    BaseAppInfo.mDeviceId = (String) map.get("deviceid");
                }
                if (map.containsKey("region")) {
                    BaseAppInfo.mRegion = (String) map.get("region");
                }
                StrategyHelper.helper().configAppInfo(BaseAppInfo.toJsonString(), map);
                SettingsHelper.helper().config().load(SettingsHelper.MODULE_ALL);
                if (TextUtils.isEmpty(VideoEventBase.appSessionId)) {
                    VideoEventBase.appSessionId = SessionIDGenerator.generateSessionID(BaseAppInfo.mDeviceId);
                }
            } catch (Exception e) {
                TTVideoEngineLog.d("TTVideoEngine", e.toString());
            }
        }
    }

    public static void addTask(String str, PreloaderVidItem preloaderVidItem) {
        DataLoaderHelper.getDataLoader().addTask(str, preloaderVidItem);
    }

    public static void setIntValue(int i, int i2) {
        TTVideoEngineLog.i("TTVideoEngine", "TTVideoEngine.setIntValue key=" + i + " value=" + i2);
        if (i == 672) {
            TTVideoEngineLog.i("TTVideoEngine", "do set static render type, value = " + i2);
            EngineGlobalConfig.getInstance().setRenderType(i2);
            return;
        }
        if (i == 674) {
            TTVideoEngineLog.i("TTVideoEngine", "enable https for fetch");
            TTVideoEngineUtils.sEnableHTTPSForFetch = i2;
            return;
        }
        boolean z = false;
        if (i == 112) {
            if (i2 > 0) {
                sABRSpeedPredictInputType = 2;
                DataLoaderHelper.getDataLoader().setIntValue(112, i2);
                return;
            } else {
                sABRSpeedPredictInputType = 1;
                DataLoaderHelper.getDataLoader().setIntValue(112, 0);
                return;
            }
        }
        if (i == 676) {
            StrategyCenter.setSpeedQueueSize(i2);
            businessEvent(1002, i2);
            return;
        }
        if (i == 702) {
            EngineGlobalConfig.getInstance().setOutputLogLevel(i2);
            TTVideoEngineLog.d("TTVideoEngine", "set log level:" + i2);
            return;
        }
        if (i == 1303) {
            EngineGlobalConfig.getInstance().setOutputLogLevelPercise(i2);
            TTVideoEngineLog.d("TTVideoEngine", "set log level percise:" + i2);
            return;
        }
        if (i == 684) {
            sRefactorFlag = i2;
            return;
        }
        if (i == 960) {
            sEnableGloablMuteFeature = i2;
            MediaPlayerWrapper.setGlobalIntOptionForKey(1015, i2);
            return;
        }
        if (i == 961) {
            sGlobalMute = i2;
            MediaPlayerWrapper.setGlobalIntOptionForKey(1016, i2);
            return;
        }
        if (i == 973) {
            MediaPlayerWrapper.setGlobalIntOptionForKey(1359, i2);
            return;
        }
        if (i == 40003) {
            MediaPlayerWrapper.setGlobalIntOptionForKey(1360, i2);
            return;
        }
        if (i == 40004) {
            MediaPlayerWrapper.setGlobalIntOptionForKey(1361, i2);
            return;
        }
        if (i == 40005) {
            MediaPlayerWrapper.setGlobalIntOptionForKey(1306, i2);
            return;
        }
        if (i == 40006) {
            MediaPlayerWrapper.setGlobalIntOptionForKey(1307, i2);
            return;
        }
        if (i == 70003) {
            EngineGlobalConfig engineGlobalConfig = EngineGlobalConfig.getInstance();
            if (i2 == 1) {
                z = true;
            }
            engineGlobalConfig.setUseVideoInfoFetcherHandlerThread(z);
            TTVideoEngineLog.d("TTVideoEngine", "set videoinfo use handlerThread:" + i2);
            return;
        }
        if (i == 40034) {
            MediaPlayerWrapper.setGlobalIntOptionForKey(40034, i2);
            TTVideoEngineLog.d("TTVideoEngine", "enable ttmn logger refactor:" + i2);
            return;
        }
        if (i == 689) {
            TTVideoEngineLog.i("TTVideoEngine", "do set static enable cpp opt bvc1, value = " + i2);
            EngineGlobalConfig.getInstance().setEnableCPPBYTEVC1CodecOpt(i2);
            return;
        }
        if (i == 719) {
            EngineGlobalConfig.getInstance().setEnableBmf(i2);
            TTVideoEngineLog.d("TTVideoEngine", "enable bmf" + i2);
            return;
        }
        if (i == 720) {
            EngineGlobalConfig.getInstance().setEnableUseRealBitrate(i2);
            TTVideoEngineLog.d("TTVideoEngine", "set use realbitrate:" + i2);
            return;
        }
        if (i == 737) {
            EngineGlobalConfig.getInstance().setLazyLoadVideodec(i2);
            TTVideoEngineLog.d("TTVideoEngine", "set lazy load videodec:" + i2);
            return;
        }
        if (i == 750) {
            sUseConfigCenter = i2;
            return;
        }
        if (i == 749) {
            sConfigCenterCheckDiff = i2;
            return;
        }
        if (i == 964) {
            sEnableEncryptBuryData = i2;
            return;
        }
        if (i == 34) {
            EngineGlobalConfig.getInstance().setEnablePcdnAuto(i2);
            DataLoaderHelper.getDataLoader().setIntValue(i, i2);
            TTVideoEngineLog.d("TTVideoEngine", "set enablePcdnAuto:" + i2);
            return;
        }
        if (i == 965) {
            if (i2 == 1) {
                z = true;
            }
            VideoEventLoggerV2.sEnableContentDataReport = z;
            return;
        }
        if (i == 4027) {
            EngineGlobalConfig.getInstance().setEnableSelectStringMapMethod(i2);
            return;
        }
        if (i == 4026) {
            EngineGlobalConfig.getInstance().setEnableSelectUseObject(i2);
            return;
        }
        if (i == 966) {
            if (i2 > 0) {
                z = true;
            }
            EngineThreadPool.setOptimizeLock(z);
            return;
        }
        if (i == 967) {
            if (i2 > 0) {
                z = true;
            }
            EngineThreadPool.setOptimizeEnabled(z);
            return;
        }
        if (i == 968) {
            if (i2 == 1) {
                z = true;
            }
            sBuryDataOptimize = z;
            TTVideoEngineLog.d("TTVideoEngine", "sBuryDataOptimize:" + i2);
            return;
        }
        if (i == 70002) {
            sBuryDataOptimizeV2 = i2;
            TTVideoEngineLog.d("TTVideoEngine", "sBuryDataOptimizeV2:" + i2);
            return;
        }
        if (i == 969) {
            if (i2 == 1) {
                z = true;
            }
            sEngineCrosstalkCheck = z;
            return;
        }
        if (i == 751) {
            EngineGlobalConfig.getInstance().dataLoaderHelperLockType = i2;
            DataLoaderHelper.getDataLoader().updateLockType(i2);
            return;
        }
        if (i == 752) {
            EngineGlobalConfig.getInstance().enableMdlLockOptimizeV2 = i2;
            return;
        }
        if (i == 970) {
            if (i2 == 1) {
                z = true;
            }
            sColdStartOptimize = z;
            if (z) {
                sBuryDataOptimize = true;
                return;
            }
            return;
        }
        if (i == 70001) {
            if (i2 == 1) {
                z = true;
            }
            sDetectPrivateField = z;
            return;
        }
        if (i == 971) {
            if (i2 == 1) {
                z = true;
            }
            ThreadCPU.sCpuRefreshFix = z;
            TTVideoEngineLog.d("TTVideoEngine", "TTVideoEngine.sCpuRefreshFix key=" + z);
            return;
        }
        if (i == 972) {
            if (i2 == 1) {
                z = true;
            }
            ThreadCPU.sUseNativeThread = z;
            TTVideoEngineLog.d("TTVideoEngine", "TTVideoEngine.sUseNativeThread key=" + z);
            return;
        }
        if (i == 754) {
            sEnableSelectResultReport = i2;
            TTVideoEngineLog.d("TTVideoEngine", "TTVideoEngine.sEnableSelectResultReport key=" + sEnableSelectResultReport);
            return;
        }
        DataLoaderHelper.getDataLoader().setIntValue(i, i2);
        StrategyKeys.setIntValue(i, i2);
        StrategyHelper.helper().setIntValue(i, i2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void playUrlChanged(int i, String str, String str2) {
        this.mVideoEngine.playUrlChanged(i, str, str2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setPlayerSurface(Surface surface, int i, int i2) {
        this.mVideoEngine.setPlayerSurface(surface, i, i2);
    }

    public static Resolution findBestResolution(VideoModel videoModel, Resolution resolution, int i) {
        return findBestResolution(videoModel, resolution, i, null);
    }

    public static long getContinueCacheSize(String str, int i, long j) {
        return DataLoaderHelper.getDataLoader().getContinueCacheSize(str, i, j);
    }

    public static void businessEvent(int i, int i2, int i3) {
        StrategyHelper.helper().getCenter().f(i, i2, i3);
    }

    public static long getCacheFileSize(VideoModel videoModel, Resolution resolution, Map<Integer, String> map) {
        return getCacheFileSize((IVideoModel) videoModel, resolution, map);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) {
        this.mVideoEngine.setDataSource(fileDescriptor, j, j2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDirectUrlUseDataLoader(String str, String str2, String str3) {
        this.mVideoEngine.setDirectUrlUseDataLoader(str, str2, str3);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDirectUrlUseDataLoaderByFilePath(String[] strArr, String str, String str2) {
        this.mVideoEngine.setDirectUrlUseDataLoaderByFilePath(strArr, str, str2);
    }

    public static void addTask(IVideoModel iVideoModel, Resolution resolution, long j) {
        DataLoaderHelper.getDataLoader().addTask(iVideoModel, resolution, j);
    }

    public static void businessEvent(int i, int i2, String str) {
        StrategyHelper.helper().getCenter().g(i, i2, str);
    }

    @TargetClass("com.ss.ttvideoengine.TTVideoEngine")
    @Insert("setDirectURL")
    public static void com_ss_ttvideoengine_TTVideoEngine_com_dragon_read_aop_TTVideoEngineAop_setDirectURL(TTVideoEngine tTVideoEngine, String str, String str2) {
        if (MdlOpt.b().enableHook && !MdlOpt.b().without_custom_cache && !TextUtils.isEmpty(str)) {
            tTVideoEngine.setIntOption(160, 1);
            tTVideoEngine.setDirectUrlUseDataLoader(str, computeMD5(str));
        } else {
            tTVideoEngine.TTVideoEngine__setDirectURL$___twin___(str, str2);
        }
    }

    public static long getCacheFileSize(IVideoModel iVideoModel, Resolution resolution, Map<Integer, String> map) {
        long j = 0;
        if (iVideoModel == null || resolution == null) {
            return 0L;
        }
        VideoInfo videoInfo = iVideoModel.getVideoInfo(resolution, VideoRef.TYPE_VIDEO, map, false);
        if (videoInfo != null) {
            j = 0 + DataLoaderHelper.getDataLoader().getCacheFileSize(videoInfo.getValueStr(15));
        }
        VideoInfo videoInfo2 = iVideoModel.getVideoInfo(resolution, VideoRef.TYPE_AUDIO, map, true);
        if (videoInfo2 != null) {
            return j + DataLoaderHelper.getDataLoader().getCacheFileSize(videoInfo2.getValueStr(15));
        }
        return j;
    }

    public static void addTask(VideoModel videoModel, Resolution resolution, long j) {
        DataLoaderHelper.getDataLoader().addTask(videoModel, resolution, j);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDirectUrlUseDataLoader(String[] strArr, String str, String str2) {
        this.mVideoEngine.setDirectUrlUseDataLoader(strArr, str, str2);
    }

    public TTVideoEngine(Context context, int i, Map map) {
        String str = "TTVideoEngine@" + Integer.toHexString(hashCode());
        this.mLogcatTag = str;
        TTVideoEngineLog.i(str, "init2, type:" + i + ", this:" + this + ", version:1.10.252.100-novel");
        this.mVideoEngine = createEngine(context, i, map, this);
        if (QualityOptExperiment.INSTANCE.getConfig().engineMonitorEnable) {
            NuwaObjectMonitor.INSTANCE.onLoad(this, new ObjectMonitorException("NuwaObjectMonitor onLoad: object=" + this + ", load_time= " + TimeUtils.getCurrentFormatTime()), false, "");
            StringBuilder sb = new StringBuilder();
            sb.append("ttVideoEngineExit2:");
            sb.append(this);
            LogWrapper.info("TT_PLAYER_MONITOR", sb.toString(), new Object[0]);
        }
    }

    private static TTVideoEngineInterface createEngine(Context context, int i, Map map, TTVideoEngine tTVideoEngine) {
        return new TTVideoEngineImpl(context, i, map, tTVideoEngine);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSRInitConfig(int i, String str, String str2, String str3) {
        this.mVideoEngine.setSRInitConfig(i, str, str2, str3);
    }

    public static long getMissReason(int i, String str, String str2, String str3) {
        return DataLoaderHelper.getDataLoader().getMissReason(i, str, str2, str3);
    }

    protected static Resolution findBestResolution(IVideoModel iVideoModel, Resolution resolution, int i, SpeedShiftConfig speedShiftConfig) {
        double d;
        Resolution findDefaultResolution = BestResolution.findDefaultResolution(iVideoModel, resolution);
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return BestResolution.findByNetLevel(iVideoModel, findDefaultResolution);
                    }
                    return findDefaultResolution;
                }
                ss1.b bVar = StrategyCenter.sNetSpeedPredictor;
                if (bVar != null) {
                    d = (bVar.b() / 8.0f) / 1024.0f;
                } else {
                    d = -1.0d;
                }
                return BestResolution.findAwemeShiftResolution(iVideoModel, findDefaultResolution, d, speedShiftConfig);
            }
            return BestResolution.findMaxQualityResolution(iVideoModel, findDefaultResolution);
        }
        return BestResolution.findMaxCacheResolution(iVideoModel, findDefaultResolution);
    }

    public static void startSpeedPredictor(int i, int i2, int i3, int i4) {
        if (!FeatureManager.hasPermission("net_speed") || StrategyCenter.sNetAbrSpeedPredictor != null) {
            return;
        }
        sNetSpeedAbrPredictType = i;
        sIsReportTestSpeedInfo = i3;
        sReportSpeedInfoMaxWindowSize = i4;
        if (sABRSpeedPredictInputType == 0) {
            sABRSpeedPredictInputType = 1;
        }
        if (i2 > 0) {
            sTestSpeedInterval = i2;
            sTestSpeedSampleInterval = i2;
        }
        TTVideoEngineLog.d("TTVideoEngine", "[ABR] abrSpeedPredictUpdateIntervalMs:" + i2);
        StrategyCenter.createAbrSpeedPredictor(i, i2);
    }

    public static void addTask(VideoModel videoModel, Resolution resolution, Map<Integer, String> map, long j) {
        DataLoaderHelper.getDataLoader().addTask(videoModel, resolution, map, j);
    }

    public static void addTask(String str, String str2, long j, DataLoaderResourceProvider dataLoaderResourceProvider) {
        DataLoaderHelper.getDataLoader().addTask(str, str2, j, dataLoaderResourceProvider, (String) null);
    }

    public static String proxyUrl(String str, String str2, String[] strArr, Resolution resolution, String str3) {
        return DataLoaderHelper.getDataLoader().proxyUrl(str, str2, strArr, resolution, str3);
    }

    public static int writeDataToFile(String str, long j, long j2, int i, byte[] bArr) {
        return DataLoaderHelper.getDataLoader().writeDataToFile(str, j, j2, i, bArr);
    }

    public static void addTask(String str, String str2, long j, DataLoaderResourceProvider dataLoaderResourceProvider, String str3) {
        DataLoaderHelper.getDataLoader().addTask(str, str2, j, dataLoaderResourceProvider, str3);
    }

    public static String proxyUrl(String str, String str2, String[] strArr, Resolution resolution, String str3, String str4) {
        return DataLoaderHelper.getDataLoader().proxyUrl(str, str2, strArr, resolution, str3, str4);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSRInitConfig(int i, String str, String str2, String str3, int i2, int i3, int i4) {
        this.mVideoEngine.setSRInitConfig(i, str, str2, str3, i2, i3, i4);
    }
}
