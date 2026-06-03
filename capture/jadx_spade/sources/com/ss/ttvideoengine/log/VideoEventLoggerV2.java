package com.ss.ttvideoengine.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.vcloud.networkpredictor.SpeedPredictorResultCollection;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.BaseAppInfo;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.EngineGlobalConfig;
import com.ss.ttvideoengine.ITTVideoEngineInternal;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.VideoInfoCollector;
import com.ss.ttvideoengine.log.DeviceMonitorUtils;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.ss.ttvideoengine.log.PortraitNetworkScore;
import com.ss.ttvideoengine.log.VideoEventLoggerV2;
import com.ss.ttvideoengine.metrics.IMediaMetrics;
import com.ss.ttvideoengine.metrics.MetricsFactory;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.model.VideoStyle;
import com.ss.ttvideoengine.net.DNSServerIP;
import com.ss.ttvideoengine.portrait.LabelUsage;
import com.ss.ttvideoengine.portrait.NetworkPortraitData;
import com.ss.ttvideoengine.setting.SettingsHelper;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import com.ss.ttvideoengine.utils.TimeService;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TimerTask;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoEventLoggerV2 implements IVideoEventLogger {
    public static boolean sEnableContentDataReport;
    private static Map sFeatures;
    public static int sIsColdStart;
    private String mAudioInitURL;
    private String mAuth;
    private PortraitNetworkScore.BitrateCalculationTask mBitrateCalculationTask;
    private BrightnessMonitor mBrightMonitor;
    private Context mContext;
    private String mCustomStr;
    private final EventLoggerSource mDataSource;
    private ArrayList mErrorInfo;
    private final VideoEventAbrEvent mEventAbrSwitch;
    private VideoEventBase mEventBase;
    private final VideoEventOneEvent mEventOneEvent;
    private final VideoEventOneNoRender mEventOneNoRender;
    private final VideoEventOneOpera mEventOneOpera;
    private final VideoEventOneOutSync mEventOneOutSync;
    private VideoEventSampleRecord mEventSample;
    private EventSaver mEventSaver;
    private FeatureConfigs mFeatureConfigs;
    private boolean mFetchComplete;
    private VideoFilterMonitor mFilterMonitor;
    private ArrayList mFirstDNSErrorInfo;
    private Error mFirstError;
    private final HeadsetStateHistory mHeadsetStateHistory;
    private final HeadsetStateMonitor mHeadsetStateMonitor;
    private String mInitialHost;
    private String mInitialIP;
    private String mInitialURL;
    private LabelUsage mLabelUsage;
    private boolean mLeave;
    private ArrayList<String> mMDLRetryInfo;
    private Map mMainError;
    private boolean mNetSpeedForAudio;
    private PortraitNetworkScore.NetworkQualityAlgorithm mNetworkQualityAlgorithm;
    private ArrayList mRetryFetchErrorInfo;
    private ArrayList<String> mSetSurfaceTimeList;
    private SuperResolutionMonitor mSrMonitor;
    private boolean mUploadLogEnabled;
    private VRTracker mVRTracker;
    private ArrayList mVUArray;
    private VegaCollector mVegaCollector;
    private IVideoModel mVideoModel;
    private ViewSizeMonitor mViewSizeMonitor;
    private boolean mIsLocal = false;
    private int mAsyncInit = Integer.MIN_VALUE;
    private int mUseCodecPool = Integer.MIN_VALUE;
    private String mInitialResolution = "";
    private String mInitialQuality = "";
    private int mInitialQualityType = Integer.MIN_VALUE;
    private String mProxyUrl = "";
    private String mMessage = "";
    private int mIsStartPlayAutomatically = Integer.MIN_VALUE;
    private int mBufferDataSeconds = Integer.MIN_VALUE;
    private int mLoopCount = 0;
    private boolean mLooping = false;
    private Map mPlaybackParams = null;
    private int mCustomP2PCDNType = Integer.MIN_VALUE;
    private String mP2PUrl = "";
    private String mP2PSDKVersion = "";
    private int mDuration = Integer.MIN_VALUE;
    private int mStartTime = Integer.MIN_VALUE;
    private int mWidth = Integer.MIN_VALUE;
    private int mHeight = Integer.MIN_VALUE;
    private int mDisableAccurateStart = Integer.MIN_VALUE;
    private long mSurfaceSetTime = -2147483648L;
    private String mSurfaceCode = null;
    private int mNetWorkTryCount = Integer.MIN_VALUE;
    private long mDecodeBufferingStartT = 0;
    private int mAsyncCodecId = Integer.MIN_VALUE;
    private int mEnableBash = Integer.MIN_VALUE;
    private int mPlayCount = 0;
    public int mCurDecoderBufferCount = 0;
    public long mCurDecoderBufferAccuT = 0;
    public int mCurBufferCount = 0;
    public int mNetBufferIndex = 0;
    public int mBreakCount = 0;
    private int mApiVer = Integer.MIN_VALUE;
    private int mSwitchResolutionCount = 0;
    private int mSeekCount = 0;
    private long mBlockBeginT = -2147483648L;
    private long mSeekBeginT = -2147483648L;
    private long mAccumVPS = 0;
    private long mAccumVDS = 0;
    private int mState = 0;
    private String mExtraInfo = "";
    private int mLeaveReason = -1002;
    private long mBitrate = -2147483648L;
    private long mAudioBitrate = -2147483648L;
    private int mFirstRangeSize = Integer.MIN_VALUE;
    private int mNetSpeedLevel = Integer.MIN_VALUE;
    private int mModelVersion = Integer.MIN_VALUE;
    public int mMediaCodecRender = Integer.MIN_VALUE;
    public int mBufferTimeout = Integer.MIN_VALUE;
    public int mNetworkTimeout = Integer.MIN_VALUE;
    private long prepare_before_play_t = -2147483648L;
    private long setds_t = -2147483648L;
    private long ps_t = -2147483648L;
    private int mRadioMode = Integer.MIN_VALUE;
    private boolean mVideoStreamDisabled = false;
    private boolean mAudioStreamDisabled = false;
    private int mIsReplay = Integer.MIN_VALUE;
    private int mEnableNNSR = Integer.MIN_VALUE;
    private int mReadCacheMode = Integer.MIN_VALUE;
    private int mPreRangeOff = Integer.MIN_VALUE;
    private boolean mIsEngineReuse = false;
    private boolean mEnableSpeedReport = false;
    private float mNetworkSpeedPredictSamplingRate = Float.MIN_VALUE;
    private String mPlayerSurfaceCode = null;
    private TimerTask mTimerTask = null;
    private int mNetLevelIntervalMs = 0;
    private int mNetLevelMaxCount = 100;
    private int mNetSpeedUpdateInterval = 0;
    private long mMDLDownloadSize = 0;
    private long mMDLDownloadTime = 0;
    private String mNetworkQualityVar = null;
    private int mReportLevel = 12;
    private String mMDLHijackURL = "";
    private String mMDLHijackIP = "";
    private Map mFeatures = new HashMap();
    private int mHardwareConfType = Integer.MIN_VALUE;
    private int mSubLanSwitchCount = 0;
    private int mSubIdsCount = Integer.MIN_VALUE;
    private int mEnableSub = Integer.MIN_VALUE;
    private int mEnableOptSubLoad = Integer.MIN_VALUE;
    private int mEnableSubThread = Integer.MIN_VALUE;
    private int mEnableMask = Integer.MIN_VALUE;
    private int mEnableMaskThread = Integer.MIN_VALUE;
    private String mSubReqURL = "";
    private String mMaskURL = "";
    private String mSubError = "";
    private int mMaskErrc = Integer.MIN_VALUE;
    private int mMaskRangeOpt = Integer.MIN_VALUE;
    private int mMaskEnableDataloader = Integer.MIN_VALUE;
    private int mMaskDelayLoading = Integer.MIN_VALUE;
    private String mMaskFileHash = "";
    private long mMaskFileSize = -2147483648L;
    private ArrayList<String> mPlayList = new ArrayList<>();
    private ArrayList<String> mPauseList = new ArrayList<>();
    private ArrayList<String> mResolutionList = new ArrayList<>();
    private ArrayList<String> mCDNTuningList = new ArrayList<>();
    private ArrayList<String> mPlaySpeedList = new ArrayList<>();
    private ArrayList<String> mRadiomodeList = new ArrayList<>();
    private ArrayList<String> mLoopList = new ArrayList<>();
    private ArrayList<String> mErrorList = new ArrayList<>();
    private ArrayList<Integer> mPowerList = new ArrayList<>();
    private ArrayList<Integer> mChargingList = new ArrayList<>();
    private ArrayList<String> mAVBadInterlacedList = new ArrayList<>();
    private boolean mAVOutSyncing = false;
    private Error mCurError = null;
    private int mRetryStrategy = -1;
    private long mRetryStartT = -2147483648L;
    public long mCustomClickT = -2147483648L;
    public long mCustomGetVideoModelT = -2147483648L;
    public long mCustomInitEngineT = -2147483648L;
    public long mCustomPlayEngineT = -2147483648L;
    public int mEngineHash = Integer.MIN_VALUE;
    private long mSetSurfaceBeginT = -2147483648L;
    private String mSetSurfaceType = null;
    private ArrayList<String> mVrDistanceList = new ArrayList<>();
    private float mVrFrameRate = Float.MIN_VALUE;
    private int mVrScreenRefreshRate = Integer.MIN_VALUE;
    private long mVrHeadMovementDelay = -2147483648L;
    private HashMap<String, Object> mCastObject = null;
    private int mOttPluginVersion = Integer.MIN_VALUE;
    private String mCompanyID = "";
    private ArrayList<String> mTrEffectList = new ArrayList<>();
    private String mTrPerEffectAverageTime = "";
    private String mTrEffectErrorCode = "";
    private ContentDataReporter mContentDataReporter = null;
    private boolean mUrlMatchCondition = false;
    private VideoEventOnePlay mEvent = new VideoEventOnePlay();

    private void contentReporterStartTaskIfNeeded() {
    }

    private static int getAppBits() {
        return 64;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void accuBuffingTime(long j) {
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void didSentEvent(int i) {
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void accumulateSize() {
        _accumulateVPS();
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public int getAsyncInit() {
        return this.mAsyncInit;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public long getCurDecoderBufferAccuT() {
        return this.mCurDecoderBufferAccuT;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public int getCurDecoderBufferCount() {
        return this.mCurDecoderBufferCount;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public String getExtraInfo() {
        return this.mExtraInfo;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public Error getFirstError() {
        return this.mFirstError;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public boolean isUploadLogEnabled() {
        return this.mUploadLogEnabled;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void addSubtitleSwitchTime() {
        this.mSubLanSwitchCount++;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public Map<String, Object> getCoreEventParam() {
        return this.mVegaCollector.get();
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void reportBufferingMetrics() {
        VideoEventOneEvent videoEventOneEvent = this.mEventOneEvent;
        if (videoEventOneEvent != null) {
            videoEventOneEvent.triggerBufferStartCb();
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public String getEncryptKey() {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null) {
            return videoEventOnePlay.encryptKey;
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public int getMovieStalledType() {
        VideoEventOneEvent videoEventOneEvent = this.mEventOneEvent;
        if (videoEventOneEvent != null) {
            return videoEventOneEvent.getMovieStalledType();
        }
        return -1;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public long getStalledAudioBufferTime() {
        VideoEventOneEvent videoEventOneEvent = this.mEventOneEvent;
        if (videoEventOneEvent != null) {
            return videoEventOneEvent.getStatlledAudioBufferTime();
        }
        return -1L;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public long getStalledVideoBufferTime() {
        VideoEventOneEvent videoEventOneEvent = this.mEventOneEvent;
        if (videoEventOneEvent != null) {
            return videoEventOneEvent.getStalledVideoBufferTime();
        }
        return -1L;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public String getTraceID() {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null) {
            return videoEventOnePlay.traceID;
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void watchFinish() {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.finish = 1;
    }

    static {
        Covode.recordClassIndex(652493);
        sIsColdStart = 1;
        sFeatures = new HashMap();
        sEnableContentDataReport = false;
    }

    private static int getOsBits() {
        String property = System.getProperty("os.arch");
        if (property != null && property.contains("64")) {
            return 64;
        }
        return 32;
    }

    private int getScreenHeight() {
        if (BaseAppInfo.mScreenHeight <= 0) {
            BaseAppInfo.mScreenHeight = ScreenUtils.getRealScreenSize(this.mContext).y;
        }
        return BaseAppInfo.mScreenHeight;
    }

    private int getScreenWidth() {
        if (BaseAppInfo.mScreenWidth <= 0) {
            BaseAppInfo.mScreenWidth = ScreenUtils.getRealScreenSize(this.mContext).x;
        }
        return BaseAppInfo.mScreenWidth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveEvent$0() {
        updateTimeConsumingEventData(this.mContext, this.mEvent, this.mEventBase, this.mNetworkQualityAlgorithm);
        this.mEventSaver.save(this.mEvent, this.mEventBase);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public long getLeaveWaitTime() {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null) {
            long j = videoEventOnePlay.pt_new;
            if (j > 0) {
                long j2 = videoEventOnePlay.lt;
                if (j2 > 0) {
                    return j2 - j;
                }
            }
        }
        return 0L;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void loopAgain() {
        this.mLoopCount++;
        TTVideoEngineUtils.addToList(this.mLoopList, String.valueOf(System.currentTimeMillis()));
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void movieBufferDidReachEnd() {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay.bft <= 0) {
            videoEventOnePlay.bft = System.currentTimeMillis();
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void playbackBufferEnd() {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay.playbackBufferEndT <= 0) {
            videoEventOnePlay.playbackBufferEndT = System.currentTimeMillis();
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void playbackBufferStart() {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay.playbackBufferStartT <= 0) {
            videoEventOnePlay.playbackBufferStartT = System.currentTimeMillis();
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void prepareEnd() {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay.vt <= 0) {
            videoEventOnePlay.prepare_end_time = System.currentTimeMillis();
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void prepareStart() {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay.vt <= 0) {
            videoEventOnePlay.prepare_start_time = System.currentTimeMillis();
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void seekCompleted() {
        if (this.mSeekBeginT > 0) {
            this.mSeekBeginT = -2147483648L;
            VideoEventOnePlay videoEventOnePlay = this.mEvent;
            if (videoEventOnePlay != null) {
                videoEventOnePlay.lastSeekEndT = System.currentTimeMillis();
            }
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setSurfaceBegin() {
        if (!TTVideoEngine.sBuryDataOptimize && this.mSetSurfaceTimeList.size() <= 20 && this.mSetSurfaceBeginT <= 0) {
            this.mSetSurfaceBeginT = System.currentTimeMillis();
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void showedFirstFrame() {
        if (this.mDataSource != null) {
            this.mDataSource.onInfo(2, _getFirstFrameSplitInfo());
            VideoEventOnePlay videoEventOnePlay = this.mEvent;
            if (videoEventOnePlay != null) {
                videoEventOnePlay.mStSpeed = TTVideoEngine.getNetworkSpeedFromPredictor();
            }
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void switchResolution() {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null) {
            videoEventOnePlay.lastResolutionStartT = System.currentTimeMillis();
        }
        _recordExitReason(-2005, true);
    }

    private static class StatisticDataRunnable implements Runnable {
        private final WeakReference<VideoEventOnePlay> rEvent;
        private final WeakReference<VideoEventBase> rEventBase;

        static {
            Covode.recordClassIndex(652497);
        }

        @Override // java.lang.Runnable
        public void run() {
            DeviceMonitorUtils.CPUInfo currentCPUInfo;
            VideoEventOnePlay videoEventOnePlay = this.rEvent.get();
            VideoEventBase videoEventBase = this.rEventBase.get();
            if (videoEventOnePlay != null && videoEventBase != null && (currentCPUInfo = videoEventBase.getCurrentCPUInfo()) != null) {
                double d = currentCPUInfo.cpuAppRate;
                double d2 = 1.401298464324817E-45d;
                if (d <= 0.0d) {
                    d = 1.401298464324817E-45d;
                }
                videoEventOnePlay.mCpuRateBegin = d;
                double d3 = currentCPUInfo.cpuAppSpeed;
                if (d3 > 0.0d) {
                    d2 = d3;
                }
                videoEventOnePlay.mCpuSpeedBegin = d2;
            }
        }

        public StatisticDataRunnable(VideoEventOnePlay videoEventOnePlay, VideoEventBase videoEventBase) {
            this.rEvent = new WeakReference<>(videoEventOnePlay);
            this.rEventBase = new WeakReference<>(videoEventBase);
        }
    }

    private static int getHostabiBits() {
        int appBits = getAppBits();
        int osBits = getOsBits();
        if (appBits != osBits) {
            TTVideoEngineLog.i("VideoEventLoggerV2", "appBits:" + appBits + " != osBits:" + osBits);
            return -1;
        }
        return appBits;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setSurfaceEnd() {
        if (!TTVideoEngine.sBuryDataOptimize && this.mSetSurfaceBeginT > 0 && !TextUtils.isEmpty(this.mSetSurfaceType)) {
            long currentTimeMillis = System.currentTimeMillis() - this.mSetSurfaceBeginT;
            HashMap hashMap = new HashMap(1);
            hashMap.put(this.mSetSurfaceType, Long.valueOf(currentTimeMillis));
            this.mSetSurfaceTimeList.add(hashMap.toString());
            this.mSetSurfaceBeginT = -2147483648L;
            this.mSetSurfaceType = null;
        }
    }

    /* renamed from: com.ss.ttvideoengine.log.VideoEventLoggerV2$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$ttvideoengine$log$IVideoEventLogger$VideoEventCustomInfo;

        static {
            int[] iArr = new int[IVideoEventLogger.VideoEventCustomInfo.values().length];
            $SwitchMap$com$ss$ttvideoengine$log$IVideoEventLogger$VideoEventCustomInfo = iArr;
            try {
                iArr[IVideoEventLogger.VideoEventCustomInfo.VIDEOEVENT_CUSTOM_INFO_FFTIME_CLICK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$ttvideoengine$log$IVideoEventLogger$VideoEventCustomInfo[IVideoEventLogger.VideoEventCustomInfo.VIDEOEVENT_CUSTOM_INFO_FFTIME_VIDEOMODEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$ttvideoengine$log$IVideoEventLogger$VideoEventCustomInfo[IVideoEventLogger.VideoEventCustomInfo.VIDEOEVENT_CUSTOM_INFO_FFTIME_CUSTOMPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$ttvideoengine$log$IVideoEventLogger$VideoEventCustomInfo[IVideoEventLogger.VideoEventCustomInfo.VIDEOEVENT_CUSTOM_INFO_FFTIME_INITENGINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$ttvideoengine$log$IVideoEventLogger$VideoEventCustomInfo[IVideoEventLogger.VideoEventCustomInfo.VIDEOEVENT_CUSTOM_INFO_FFTIME_PLAYENGINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ss$ttvideoengine$log$IVideoEventLogger$VideoEventCustomInfo[IVideoEventLogger.VideoEventCustomInfo.VIDEOEVENT_CUSTOM_INFO_CAST_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ss$ttvideoengine$log$IVideoEventLogger$VideoEventCustomInfo[IVideoEventLogger.VideoEventCustomInfo.VIDEOEVENT_CUSTOM_INFO_OTT_PLUGIN_VERSION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ss$ttvideoengine$log$IVideoEventLogger$VideoEventCustomInfo[IVideoEventLogger.VideoEventCustomInfo.VIDEOEVENT_CUSTOM_INFO_COMPANY_ID.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ss$ttvideoengine$log$IVideoEventLogger$VideoEventCustomInfo[IVideoEventLogger.VideoEventCustomInfo.VIDEOEVENT_CUSTOM_INFO_CUSTOM_PLAY_SESSION_ID.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class AsyncGetLogDataRunnable implements Runnable {
        private final Context rContext;
        private final VideoEventOnePlay rEvent;
        VideoEventBase rEventBase;
        EventSaver rEventSaver;
        private final Handler rHandler = new HandlerDelegate(Looper.getMainLooper());
        VideoEventLoggerV2 rLogger;
        PortraitNetworkScore.NetworkQualityAlgorithm rQualityAlg;

        static {
            Covode.recordClassIndex(652494);
        }

        @Override // java.lang.Runnable
        public void run() {
            TTVideoEngineLog.i("VideoEventLoggerV2", "AyncGetLogDataRunnable enter");
            VideoEventOnePlay videoEventOnePlay = this.rEvent;
            if (videoEventOnePlay == null) {
                TTVideoEngineLog.e("VideoEventLoggerV2", "rEvent is null, return.");
                return;
            }
            VideoEventLoggerV2.updateTimeConsumingEventData(this.rContext, videoEventOnePlay, this.rEventBase, this.rQualityAlg);
            final JSONObject jsonObject = this.rEvent.toJsonObject(this.rEventBase);
            final boolean z = this.rEventBase.isUploadLogEnabled;
            this.rEventSaver.remove(this.rEvent.mSessionID);
            this.rEventSaver.uploadIfExits(this.rEventBase.isUploadLogEnabled);
            this.rHandler.post(new Runnable() { // from class: com.ss.ttvideoengine.log.l
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEventLoggerV2.AsyncGetLogDataRunnable.lambda$run$0(z, jsonObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0(boolean z, JSONObject jSONObject) {
            VideoEventManager.instance.addEvent(z, jSONObject);
        }

        public AsyncGetLogDataRunnable(Context context, VideoEventOnePlay videoEventOnePlay, VideoEventLoggerV2 videoEventLoggerV2, VideoEventBase videoEventBase, PortraitNetworkScore.NetworkQualityAlgorithm networkQualityAlgorithm, EventSaver eventSaver) {
            this.rEvent = videoEventOnePlay;
            this.rContext = context;
            this.rLogger = videoEventLoggerV2;
            this.rEventBase = videoEventBase;
            this.rQualityAlg = networkQualityAlgorithm;
            this.rEventSaver = eventSaver;
        }
    }

    private void _accumulateVPS() {
        Map<String, Long> bytesInfo;
        EventLoggerSource eventLoggerSource = this.mDataSource;
        if (eventLoggerSource != null && (bytesInfo = eventLoggerSource.bytesInfo()) != null) {
            long safelyUnbox = TTHelper.safelyUnbox(bytesInfo.get("vps"));
            long safelyUnbox2 = TTHelper.safelyUnbox(bytesInfo.get("vds"));
            this.mAccumVPS += safelyUnbox;
            this.mAccumVDS += safelyUnbox2;
            TTVideoEngineLog.i("VideoEventLoggerV2", "_accumulateVPS accumVPS:" + this.mAccumVPS + ", accumVDS:" + this.mAccumVDS + ", vps:" + safelyUnbox + ", vds:" + safelyUnbox2);
        }
    }

    private Map _getFirstFrameSplitInfo() {
        HashMap hashMap = new HashMap(7);
        hashMap.put("format_open_input", Long.valueOf(this.mEvent.demuxer_create_t));
        hashMap.put("tran_connect", Long.valueOf(this.mEvent.tranConnectT));
        hashMap.put("http_response", Long.valueOf(this.mEvent.httpResponseT));
        hashMap.put("receive_first_video_frame", Long.valueOf(this.mEvent.receiveFirstVideoFrameT));
        hashMap.put("decode_first_video_frame", Long.valueOf(this.mEvent.decodeFirstVideoFrameT));
        hashMap.put("render_first_video_frame", Long.valueOf(this.mEvent.v_render_f_t));
        hashMap.put("prepared", Long.valueOf(this.mEvent.player_prepared_time));
        return hashMap;
    }

    private void _parseUrlLogID() {
        String str;
        String substring;
        if (!TextUtils.isEmpty(this.mInitialURL)) {
            str = this.mInitialURL;
        } else if (!TextUtils.isEmpty(this.mProxyUrl)) {
            str = this.mProxyUrl;
        } else if (!TextUtils.isEmpty(this.mAudioInitURL)) {
            str = this.mAudioInitURL;
        } else {
            return;
        }
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            TTVideoEngineLog.e("VideoEventLoggerV2", "exception:" + e.toString());
        } catch (IllegalArgumentException e2) {
            TTVideoEngineLog.e("VideoEventLoggerV2", "exception:" + e2.toString());
        }
        int indexOf = str.indexOf("&l=");
        if (indexOf > 0) {
            int indexOf2 = str.indexOf("&", indexOf + 1);
            if (indexOf2 > 0) {
                substring = str.substring(indexOf + 3, indexOf2);
            } else {
                substring = str.substring(indexOf + 3);
            }
            this.mEvent.log_id = substring;
        }
    }

    private void _sendEvent() {
        if (this.mEvent == null) {
            return;
        }
        TTVideoEngineLog.i("VideoEventLoggerV2", "sendEvent pt_new:" + this.mEvent.pt_new + ", mEvent:" + this.mEvent + ", eventBase:" + this.mEventBase);
        if (this.mEvent.pt_new <= 0 && this.ps_t <= 0) {
            return;
        }
        updateEventData();
        EngineThreadPool.addExecuteTask(new AsyncGetLogDataRunnable(this.mContext, this.mEvent, this, this.mEventBase, this.mNetworkQualityAlgorithm, this.mEventSaver));
        contentReporterStartTaskIfNeeded();
        _clear();
    }

    private void collectPowerStatistics() {
        int isPowerSaveMode;
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase.mEnablePowerReport) {
            double cPURate = videoEventBase.getCPURate();
            double cPUSpeed = this.mEventBase.getCPUSpeed();
            if (cPURate > 0.0d && cPUSpeed > 0.0d) {
                VideoEventOnePlay videoEventOnePlay = this.mEvent;
                videoEventOnePlay.mCpuRateBegin = cPURate;
                videoEventOnePlay.mCpuSpeedBegin = cPUSpeed;
            } else {
                EngineThreadPool.addExecuteTask(new StatisticDataRunnable(this.mEvent, this.mEventBase));
            }
            HashMap<String, Object> chargingState = this.mEventBase.getChargingState();
            if (chargingState != null) {
                this.mPowerList.add((Integer) chargingState.get("power"));
                this.mChargingList.add((Integer) chargingState.get("isCharging"));
            }
        }
        if (!TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 2L) && (isPowerSaveMode = DeviceMonitorUtils.isPowerSaveMode(this.mContext)) >= 0) {
            this.mEvent.mPowerSaveModeBegin = isPowerSaveMode;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void pause() {
        int i;
        EventLoggerSource eventLoggerSource = this.mDataSource;
        if (eventLoggerSource != null) {
            i = eventLoggerSource.getLogValueInt(67);
        } else {
            i = -1;
        }
        HashMap hashMap = new HashMap(2);
        long currentTimeMillis = System.currentTimeMillis();
        hashMap.put("p", Integer.valueOf(i));
        hashMap.put("t", Long.valueOf(currentTimeMillis));
        TTVideoEngineUtils.addToList(this.mPauseList, new JSONObject(hashMap).toString());
        this.mBrightMonitor.setPlaying(false);
        if (this.mAVOutSyncing && TTVideoEngine.sBuryDataOptimizeV2 == 0) {
            this.mEventOneOutSync.setLongValue(1, currentTimeMillis);
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void retryFinish() {
        int i;
        if (this.mCurError != null && this.mRetryStartT > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.mRetryStartT;
            HashMap hashMap = new HashMap(5);
            EventLoggerSource eventLoggerSource = this.mDataSource;
            if (eventLoggerSource != null) {
                i = eventLoggerSource.getLogValueInt(67);
            } else {
                i = -1;
            }
            hashMap.put("ec", Integer.valueOf(this.mCurError.code));
            hashMap.put("p", Integer.valueOf(i));
            hashMap.put("t", Long.valueOf(currentTimeMillis));
            hashMap.put("c", Long.valueOf(j));
            hashMap.put("st", Integer.valueOf(this.mRetryStrategy));
            TTVideoEngineUtils.addToList(this.mErrorList, new JSONObject(hashMap).toString(), 3);
        }
        this.mCurError = null;
        this.mRetryStartT = -2147483648L;
        this.mRetryStrategy = -1;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void saveEvent() {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        long j = videoEventOnePlay.pt_new;
        if (j <= 0 && this.ps_t <= 0) {
            return;
        }
        if (this.mLeave && j > 0 && videoEventOnePlay.vt <= 0) {
            if (videoEventOnePlay.lt <= 0) {
                videoEventOnePlay.lt = System.currentTimeMillis();
            }
        } else {
            videoEventOnePlay.et = System.currentTimeMillis();
        }
        this.mEventBase.updateVideoInfo(null);
        updateEventData();
        EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.log.k
            @Override // java.lang.Runnable
            public final void run() {
                VideoEventLoggerV2.this.lambda$saveEvent$0();
            }
        });
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void showedOneFrame() {
        if (this.mState != 4 || this.mLeave) {
            this.mState = 2;
            this.mLeave = false;
            if (this.mIsReplay == 1) {
                VideoEventOnePlay videoEventOnePlay = this.mEvent;
                if (videoEventOnePlay.prepare_end_time <= 0) {
                    videoEventOnePlay.prepare_end_time = System.currentTimeMillis();
                }
            }
            VideoEventOnePlay videoEventOnePlay2 = this.mEvent;
            if (videoEventOnePlay2.vt <= 0) {
                videoEventOnePlay2.vt = System.currentTimeMillis();
                VideoEventOneEvent videoEventOneEvent = this.mEventOneEvent;
                if (videoEventOneEvent != null) {
                    videoEventOneEvent.showedFirstFrame();
                }
                VideoEventOneOutSync videoEventOneOutSync = this.mEventOneOutSync;
                if (videoEventOneOutSync != null) {
                    videoEventOneOutSync.showedFirstFrame();
                }
                VideoEventOneNoRender videoEventOneNoRender = this.mEventOneNoRender;
                if (videoEventOneNoRender != null) {
                    videoEventOneNoRender.showedFirstFrame();
                }
                this.mEventBase.showedOneFrame();
                EventLoggerSource eventLoggerSource = this.mDataSource;
                if (eventLoggerSource != null) {
                    this.mEvent.mVideoCodecProfile = eventLoggerSource.getLogValueInt(63);
                    this.mEvent.mAudioCodecProfile = this.mDataSource.getLogValueInt(64);
                }
                if (this.mAsyncInit == 1 && this.mDataSource.getLogValueInt(97) == 0) {
                    this.mAsyncInit = -1;
                }
            }
            _recordExitReason(-2001, true);
        }
    }

    private void _getCastInfo() {
        HashMap<String, Object> hashMap = this.mCastObject;
        if (hashMap != null) {
            if (hashMap.containsKey("is_cast_live")) {
                this.mEvent.mCastinfoIsCastLive = ((Integer) this.mCastObject.get("is_cast_live")).intValue();
            }
            if (this.mCastObject.containsKey("cast_source_app_id")) {
                this.mEvent.mCastinfoSourceAppId = ((Integer) this.mCastObject.get("cast_source_app_id")).intValue();
            }
            if (this.mCastObject.containsKey("cast_scene_id")) {
                this.mEvent.mCastinfoSceneId = ((Integer) this.mCastObject.get("cast_scene_id")).intValue();
            }
            if (this.mCastObject.containsKey("cast_protocal")) {
                this.mEvent.mCastinfoProtocal = (String) this.mCastObject.get("cast_protocal");
            }
            TTVideoEngineLog.d("VideoEventLoggerV2", "get CastInfo, castLive:" + this.mEvent.mCastinfoIsCastLive + ", sourceAppId:" + this.mEvent.mCastinfoSourceAppId + ", sceneId:" + this.mEvent.mCastinfoSceneId + ", protocal:" + this.mEvent.mCastinfoProtocal);
        }
    }

    private void _getMaskEvents() {
        if (TTVideoEngine.sBuryDataOptimize && this.mEnableMask > 0) {
            HashMap hashMap = new HashMap(9);
            LoggerUtils.putToMap((Map) hashMap, "mask_enable", this.mEnableMask);
            LoggerUtils.putToMap((Map) hashMap, "mask_thread_enable", this.mEnableMaskThread);
            LoggerUtils.putToMap((Map) hashMap, "mask_range_opt", this.mMaskRangeOpt);
            LoggerUtils.putToMap((Map) hashMap, "mask_enable_mdl", this.mMaskEnableDataloader);
            LoggerUtils.putToMap((Map) hashMap, "mask_delay_loading", this.mMaskDelayLoading);
            LoggerUtils.putToMap((Map) hashMap, "mask_file_size", this.mMaskFileSize);
            int i = this.mMaskErrc;
            if (i < 0) {
                LoggerUtils.putToMap((Map) hashMap, "mask_errc", i);
                LoggerUtils.putToMap(hashMap, "mask_url", this.mMaskURL);
                LoggerUtils.putToMap(hashMap, "mask_file_hash", this.mMaskFileHash);
            }
            this.mEvent.maskEvents = hashMap;
            return;
        }
        HashMap hashMap2 = new HashMap(11);
        LoggerUtils.putToMap((Map) hashMap2, "mask_open_ts", this.mEvent.mask_open_t);
        LoggerUtils.putToMap((Map) hashMap2, "mask_opened_ts", this.mEvent.mask_opened_t);
        LoggerUtils.putToMap((Map) hashMap2, "mask_errc", this.mMaskErrc);
        LoggerUtils.putToMap((Map) hashMap2, "mask_enable", this.mEnableMask);
        LoggerUtils.putToMap((Map) hashMap2, "mask_thread_enable", this.mEnableMaskThread);
        LoggerUtils.putToMap(hashMap2, "mask_url", this.mMaskURL);
        LoggerUtils.putToMap((Map) hashMap2, "mask_range_opt", this.mMaskRangeOpt);
        LoggerUtils.putToMap((Map) hashMap2, "mask_enable_mdl", this.mMaskEnableDataloader);
        LoggerUtils.putToMap((Map) hashMap2, "mask_delay_loading", this.mMaskDelayLoading);
        LoggerUtils.putToMap(hashMap2, "mask_file_hash", this.mMaskFileHash);
        LoggerUtils.putToMap((Map) hashMap2, "mask_file_size", this.mMaskFileSize);
        this.mEvent.maskEvents = hashMap2;
    }

    private void _getSubEvents() {
        if (TTVideoEngine.sBuryDataOptimize && this.mEnableSub > 0) {
            HashMap hashMap = new HashMap(5);
            LoggerUtils.putToMap((Map) hashMap, "sub_enable", this.mEnableSub);
            LoggerUtils.putToMap((Map) hashMap, "sub_enable_opt_load", this.mEnableOptSubLoad);
            LoggerUtils.putToMap((Map) hashMap, "sub_thread_enable", this.mEnableSubThread);
            if (!TextUtils.isEmpty(this.mSubError)) {
                LoggerUtils.putToMap(hashMap, "sub_error", this.mSubError);
                LoggerUtils.putToMap(hashMap, "sub_req_url", this.mSubReqURL);
            }
            this.mEvent.subEvents = hashMap;
            return;
        }
        HashMap hashMap2 = new HashMap(9);
        LoggerUtils.putToMap((Map) hashMap2, "sub_langs_c", this.mSubIdsCount);
        LoggerUtils.putToMap((Map) hashMap2, "sub_req_fin_ts", this.mEvent.sub_req_finish_t);
        LoggerUtils.putToMap((Map) hashMap2, "sub_load_fin_ts", this.mEvent.sub_load_finish_t);
        LoggerUtils.putToMap((Map) hashMap2, "sub_switch_c", this.mSubLanSwitchCount);
        LoggerUtils.putToMap(hashMap2, "sub_error", this.mSubError);
        LoggerUtils.putToMap(hashMap2, "sub_req_url", this.mSubReqURL);
        LoggerUtils.putToMap((Map) hashMap2, "sub_enable", this.mEnableSub);
        LoggerUtils.putToMap((Map) hashMap2, "sub_enable_opt_load", this.mEnableOptSubLoad);
        LoggerUtils.putToMap((Map) hashMap2, "sub_thread_enable", this.mEnableSubThread);
        this.mEvent.subEvents = hashMap2;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void reset() {
        this.mIsLocal = false;
        this.mLeave = true;
        this.mRetryFetchErrorInfo = new ArrayList();
        this.mMDLRetryInfo = new ArrayList<>();
        this.mFirstDNSErrorInfo = new ArrayList();
        this.mErrorInfo = new ArrayList();
        this.mVUArray = new ArrayList();
        this.mCustomStr = null;
        this.mInitialURL = null;
        this.mAudioInitURL = null;
        this.mInitialHost = null;
        this.mInitialIP = null;
        this.mInitialResolution = null;
        this.mInitialQuality = null;
        this.mInitialQualityType = Integer.MIN_VALUE;
        this.mMessage = "";
        this.mBufferDataSeconds = Integer.MIN_VALUE;
        this.mPlaybackParams = null;
        this.mDuration = Integer.MIN_VALUE;
        this.mStartTime = Integer.MIN_VALUE;
        this.mCurBufferCount = 0;
        this.mNetBufferIndex = 0;
        this.mCurDecoderBufferCount = 0;
        this.mBreakCount = 0;
        this.mCurDecoderBufferAccuT = 0L;
        this.mSeekCount = 0;
        this.mSwitchResolutionCount = 0;
        this.mAccumVPS = 0L;
        this.mAccumVDS = 0L;
        this.mRadioMode = Integer.MIN_VALUE;
        this.mEnableNNSR = Integer.MIN_VALUE;
        this.mReadCacheMode = Integer.MIN_VALUE;
        this.mPreRangeOff = Integer.MIN_VALUE;
        this.mAudioStreamDisabled = false;
        this.mVideoStreamDisabled = false;
        this.mMediaCodecRender = Integer.MIN_VALUE;
        this.mWidth = Integer.MIN_VALUE;
        this.mHeight = Integer.MIN_VALUE;
        this.mProxyUrl = null;
        this.mFetchComplete = false;
        this.mEnableBash = Integer.MIN_VALUE;
        VideoEventBase videoEventBase = this.mEventBase;
        int i = videoEventBase.mEnableMDL;
        boolean z = videoEventBase.mEnablePowerReport;
        videoEventBase.unregisterNetwork();
        VideoEventBase videoEventBase2 = new VideoEventBase(this.mDataSource, this.mUploadLogEnabled, this.mContext);
        this.mEventBase = videoEventBase2;
        videoEventBase2.mEnableMDL = i;
        videoEventBase2.mEnablePowerReport = z;
        VideoEventSampleRecord videoEventSampleRecord = new VideoEventSampleRecord(this.mEventBase);
        this.mEventSample = videoEventSampleRecord;
        videoEventSampleRecord.mSampingRate = this.mNetworkSpeedPredictSamplingRate;
        VideoEventOneEvent videoEventOneEvent = this.mEventOneEvent;
        VideoEventBase videoEventBase3 = this.mEventBase;
        videoEventOneEvent.mEventBase = videoEventBase3;
        this.mEventOneOpera.mEventBase = videoEventBase3;
        this.mEventOneOutSync.mEventBase = videoEventBase3;
        this.mEventAbrSwitch.mEventBase = videoEventBase3;
        this.mEventOneNoRender.updateEventBase(videoEventBase3);
        this.mFeatureConfigs = new FeatureConfigs();
        this.mViewSizeMonitor = new ViewSizeMonitor();
        this.mLabelUsage = new LabelUsage();
        this.mFirstError = null;
        this.mUrlMatchCondition = false;
        this.mVegaCollector.reset();
        this.mVRTracker = new VRTracker();
    }

    private class MyTimerTask extends TimerTask {
        static {
            Covode.recordClassIndex(652496);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            float f;
            VideoEventBase videoEventBase = VideoEventLoggerV2.this.mEventBase;
            VideoEventOnePlay videoEventOnePlay = VideoEventLoggerV2.this.mEvent;
            NetworkPortraitData portraitData = PortraitNetworkScore.getInstance().getPortraitData();
            int networkRTTMS = PortraitNetworkScore.getInstance().getNetworkRTTMS();
            String netType = VideoEventBase.getNetType();
            String signalStrength = VideoEventBase.getSignalStrength();
            if (TTVideoEngine.sBuryDataOptimizeV2 == 0) {
                int i = videoEventBase.mCurrentConfigBitrate;
                String str = videoEventBase.mCurQuality;
                if (i < 0) {
                    i = (int) VideoEventLoggerV2.this.mDataSource.getLogValueLong(75);
                }
                if (i > 0) {
                    addIfChanged(videoEventOnePlay.mBitrateList, videoEventOnePlay.mNetQualityIndex, Integer.valueOf(i));
                }
                if (!TextUtils.isEmpty(str)) {
                    addIfChanged(videoEventOnePlay.mQualityList, videoEventOnePlay.mNetQualityIndex, str);
                }
                if (videoEventOnePlay.mCatowerRttList.isEmpty()) {
                    videoEventOnePlay.mCatowerRttList.addAll(portraitData.getRttHistoryData(0));
                }
                int size = videoEventOnePlay.mCatowerRttList.size();
                if (size >= VideoEventLoggerV2.this.mNetLevelMaxCount && size > 0) {
                    videoEventOnePlay.mCatowerRttList.remove(0);
                }
                videoEventOnePlay.mCatowerRttList.add(Integer.valueOf(PortraitNetworkScore.getInstance().getNetworkRTTLevel()));
            }
            if (videoEventOnePlay.mCatowerRttMsList.isEmpty()) {
                videoEventOnePlay.mCatowerRttMsList.addAll(portraitData.getRttMsHistoryData(0));
            }
            if (videoEventOnePlay.mMdlMultiSpeedList.isEmpty()) {
                videoEventOnePlay.mMdlMultiSpeedList.addAll(portraitData.getNetSpeedHistoryData(0));
            }
            int size2 = videoEventOnePlay.mCatowerRttMsList.size();
            if (size2 >= VideoEventLoggerV2.this.mNetLevelMaxCount && size2 > 0) {
                videoEventOnePlay.mCatowerRttMsList.remove(0);
            }
            videoEventOnePlay.mCatowerRttMsList.add(Integer.valueOf(networkRTTMS));
            synchronized ("VideoEventLoggerV2") {
                if (VideoEventLoggerV2.this.mMDLDownloadTime > 0) {
                    f = ((VideoEventLoggerV2.this.mMDLDownloadSize * 8) * 1000.0f) / VideoEventLoggerV2.this.mMDLDownloadTime;
                } else {
                    f = -1.0f;
                }
                VideoEventLoggerV2.this.mMDLDownloadTime = 0L;
                VideoEventLoggerV2.this.mMDLDownloadSize = 0L;
            }
            if (f > 0.0f || !VideoEventLoggerV2.this.mNetSpeedForAudio) {
                int size3 = videoEventOnePlay.mMdlMultiSpeedList.size();
                if (size3 >= VideoEventLoggerV2.this.mNetLevelMaxCount && size3 > 0) {
                    videoEventOnePlay.mMdlMultiSpeedList.remove(0);
                }
                videoEventOnePlay.mMdlMultiSpeedList.add(Float.valueOf(f));
            }
            portraitData.setNetSpeed(f);
            if (!TextUtils.isEmpty(netType)) {
                addIfChanged(videoEventOnePlay.mNetworkTypeList, videoEventOnePlay.mNetQualityIndex, netType);
            }
            if (!TextUtils.isEmpty(signalStrength)) {
                addIfChanged(videoEventOnePlay.mSignalStrengthList, videoEventOnePlay.mNetQualityIndex, signalStrength);
            }
            int size4 = videoEventOnePlay.mCurrentList.size();
            if (size4 >= VideoEventLoggerV2.this.mNetLevelMaxCount && size4 > 0) {
                videoEventOnePlay.mCurrentList.remove(0);
            }
            float batteryCurrent = VideoEventLoggerV2.this.mEventBase.getBatteryCurrent();
            if (batteryCurrent != -1.0f) {
                videoEventOnePlay.mCurrentList.add(Float.valueOf(batteryCurrent));
            }
            videoEventOnePlay.mNetQualityIndex++;
        }

        private MyTimerTask() {
        }

        private <T> void addIfChanged(LinkedHashMap<String, T> linkedHashMap, int i, T t) {
            int size = linkedHashMap.size();
            if (size > 0) {
                if (!t.equals(linkedHashMap.get((String) linkedHashMap.keySet().toArray()[size - 1]))) {
                    linkedHashMap.put(Integer.toString(i), t);
                    return;
                }
                return;
            }
            linkedHashMap.put(Integer.toString(i), t);
        }
    }

    private void _checkFirstFrameTimes() {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay.dnsT <= 0) {
            videoEventOnePlay.dnsModule = 1;
            videoEventOnePlay.dnsT = this.mDataSource.getLogValueLong(7);
        }
        if (this.mEvent.tranConnectT <= 0) {
            long logValueLong = this.mDataSource.getLogValueLong(10);
            if (logValueLong > this.ps_t) {
                this.mEvent.tranConnectT = logValueLong;
            }
        }
        if (this.mEvent.tranFirstPacketT <= 0) {
            long logValueLong2 = this.mDataSource.getLogValueLong(11);
            if (logValueLong2 > this.ps_t) {
                this.mEvent.tranFirstPacketT = logValueLong2;
            }
        }
        VideoEventOnePlay videoEventOnePlay2 = this.mEvent;
        if (videoEventOnePlay2.audioDnsT <= 0) {
            videoEventOnePlay2.audioDnsT = this.mDataSource.getLogValueLong(51);
        }
        if (this.mEvent.audioTranConnectT <= 0) {
            long logValueLong3 = this.mDataSource.getLogValueLong(52);
            if (logValueLong3 > this.ps_t) {
                this.mEvent.audioTranConnectT = logValueLong3;
            }
        }
        if (this.mEvent.audioTranFirstPacketT <= 0) {
            long logValueLong4 = this.mDataSource.getLogValueLong(53);
            if (logValueLong4 > this.ps_t) {
                this.mEvent.audioTranFirstPacketT = logValueLong4;
            }
        }
        VideoEventOnePlay videoEventOnePlay3 = this.mEvent;
        if (videoEventOnePlay3.receiveFirstVideoFrameT <= 0) {
            videoEventOnePlay3.receiveFirstVideoFrameT = this.mDataSource.getLogValueLong(12);
        }
        VideoEventOnePlay videoEventOnePlay4 = this.mEvent;
        if (videoEventOnePlay4.receiveFirstAudioFrameT <= 0) {
            videoEventOnePlay4.receiveFirstAudioFrameT = this.mDataSource.getLogValueLong(13);
        }
        VideoEventOnePlay videoEventOnePlay5 = this.mEvent;
        if (videoEventOnePlay5.decodeFirstVideoFrameT <= 0) {
            videoEventOnePlay5.decodeFirstVideoFrameT = this.mDataSource.getLogValueLong(14);
        }
        VideoEventOnePlay videoEventOnePlay6 = this.mEvent;
        if (videoEventOnePlay6.decodeFirstAudioFrameT <= 0) {
            videoEventOnePlay6.decodeFirstAudioFrameT = this.mDataSource.getLogValueLong(15);
        }
        VideoEventOnePlay videoEventOnePlay7 = this.mEvent;
        if (videoEventOnePlay7.videoDeviceStartTime <= 0) {
            videoEventOnePlay7.videoDeviceStartTime = this.mDataSource.getLogValueLong(17);
        }
        VideoEventOnePlay videoEventOnePlay8 = this.mEvent;
        if (videoEventOnePlay8.audioDeviceStartTime <= 0) {
            videoEventOnePlay8.audioDeviceStartTime = this.mDataSource.getLogValueLong(16);
        }
        VideoEventOnePlay videoEventOnePlay9 = this.mEvent;
        if (videoEventOnePlay9.videoDeviceOpenedTime <= 0) {
            videoEventOnePlay9.videoDeviceOpenedTime = this.mDataSource.getLogValueLong(19);
        }
        VideoEventOnePlay videoEventOnePlay10 = this.mEvent;
        if (videoEventOnePlay10.audioDeviceOpenedTime <= 0) {
            videoEventOnePlay10.audioDeviceOpenedTime = this.mDataSource.getLogValueLong(18);
        }
        VideoEventOnePlay videoEventOnePlay11 = this.mEvent;
        if (videoEventOnePlay11.playPreparedT <= 0) {
            videoEventOnePlay11.playPreparedT = this.mDataSource.getLogValueLong(38);
        }
        VideoEventOnePlay videoEventOnePlay12 = this.mEvent;
        if (videoEventOnePlay12.playStartedT <= 0) {
            videoEventOnePlay12.playStartedT = this.mDataSource.getLogValueLong(39);
        }
        VideoEventOnePlay videoEventOnePlay13 = this.mEvent;
        if (videoEventOnePlay13.v_http_open_t <= 0) {
            videoEventOnePlay13.v_http_open_t = this.mDataSource.getLogValueLong(115);
        }
        VideoEventOnePlay videoEventOnePlay14 = this.mEvent;
        if (videoEventOnePlay14.a_http_open_t <= 0) {
            videoEventOnePlay14.a_http_open_t = this.mDataSource.getLogValueLong(116);
        }
        VideoEventOnePlay videoEventOnePlay15 = this.mEvent;
        if (videoEventOnePlay15.v_tran_open_t <= 0) {
            videoEventOnePlay15.v_tran_open_t = this.mDataSource.getLogValueLong(117);
        }
        VideoEventOnePlay videoEventOnePlay16 = this.mEvent;
        if (videoEventOnePlay16.a_tran_open_t <= 0) {
            videoEventOnePlay16.a_tran_open_t = this.mDataSource.getLogValueLong(118);
        }
        VideoEventOnePlay videoEventOnePlay17 = this.mEvent;
        if (videoEventOnePlay17.v_sock_create_t <= 0) {
            videoEventOnePlay17.v_sock_create_t = this.mDataSource.getLogValueLong(119);
        }
        VideoEventOnePlay videoEventOnePlay18 = this.mEvent;
        if (videoEventOnePlay18.a_sock_create_t <= 0) {
            videoEventOnePlay18.a_sock_create_t = this.mDataSource.getLogValueLong(120);
        }
    }

    private void _clear() {
        this.mRetryFetchErrorInfo = new ArrayList();
        this.mMDLRetryInfo = new ArrayList<>();
        this.mFirstDNSErrorInfo = new ArrayList();
        this.mErrorInfo = new ArrayList();
        this.mEventOneNoRender.reset();
        this.mState = 0;
        this.mBlockBeginT = -2147483648L;
        this.mAccumVPS = 0L;
        this.mAccumVDS = 0L;
        this.mBitrate = -2147483648L;
        this.mAudioBitrate = -2147483648L;
        this.mLeave = true;
        this.mCurBufferCount = 0;
        this.mNetBufferIndex = 0;
        this.mCurDecoderBufferCount = 0;
        this.mBreakCount = 0;
        this.mCurDecoderBufferAccuT = 0L;
        this.mLoopCount = 0;
        this.mLooping = false;
        this.mSwitchResolutionCount = 0;
        this.mSeekCount = 0;
        this.mSeekBeginT = -2147483648L;
        this.prepare_before_play_t = -2147483648L;
        this.ps_t = -2147483648L;
        this.setds_t = -2147483648L;
        this.mRadioMode = Integer.MIN_VALUE;
        this.mAudioStreamDisabled = false;
        this.mVideoStreamDisabled = false;
        this.mIsReplay = Integer.MIN_VALUE;
        this.mSurfaceCode = null;
        this.mSurfaceSetTime = -2147483648L;
        this.mPlayList = new ArrayList<>();
        this.mCDNTuningList = new ArrayList<>();
        this.mPauseList = new ArrayList<>();
        this.mResolutionList = new ArrayList<>();
        this.mPlaySpeedList = new ArrayList<>();
        this.mRadiomodeList = new ArrayList<>();
        this.mLoopList = new ArrayList<>();
        this.mErrorList = new ArrayList<>();
        this.mPowerList = new ArrayList<>();
        this.mChargingList = new ArrayList<>();
        this.mAVBadInterlacedList = new ArrayList<>();
        this.mCurError = null;
        this.mRetryStartT = -2147483648L;
        this.mRetryStrategy = -1;
        this.mCustomClickT = -2147483648L;
        this.mCustomGetVideoModelT = -2147483648L;
        this.mCustomInitEngineT = -2147483648L;
        this.mCustomPlayEngineT = -2147483648L;
        this.mAVOutSyncing = false;
        this.mEnableSub = Integer.MIN_VALUE;
        this.mEnableOptSubLoad = Integer.MIN_VALUE;
        this.mEnableSubThread = Integer.MIN_VALUE;
        this.mEnableMask = Integer.MIN_VALUE;
        this.mEnableMaskThread = Integer.MIN_VALUE;
        this.mMaskURL = null;
        this.mSubReqURL = null;
        this.mSubError = null;
        this.mSubIdsCount = Integer.MIN_VALUE;
        this.mSubLanSwitchCount = 0;
        this.mMaskErrc = Integer.MIN_VALUE;
        this.mFeatureConfigs.mHDRType = 0;
        this.mFeatureConfigs.mEnableABRStartup = 0;
        this.mFeatureConfigs.mEnableThreadPriority = 0;
        this.mSrMonitor = new SuperResolutionMonitor();
        this.mFilterMonitor = new VideoFilterMonitor();
        this.mBrightMonitor.stop();
        this.mBrightMonitor = new BrightnessMonitor(this.mContext);
        this.mViewSizeMonitor.reset();
        this.mFeatures.clear();
        this.mHeadsetStateHistory.reset();
        this.mFeatureConfigs.mEnableGearStrategy = 0;
        this.mFeatureConfigs.mEnableSRStrategy = 0;
        this.mVrDistanceList = new ArrayList<>();
        this.mVrFrameRate = Float.MIN_VALUE;
        this.mVrScreenRefreshRate = Integer.MIN_VALUE;
        this.mVrHeadMovementDelay = -2147483648L;
        this.mSetSurfaceBeginT = -2147483648L;
        this.mSetSurfaceType = null;
        this.mSetSurfaceTimeList = new ArrayList<>();
        this.mPlayerSurfaceCode = null;
        this.mMaskFileSize = -2147483648L;
        this.mMaskDelayLoading = Integer.MIN_VALUE;
        this.mMaskFileHash = "";
        this.mMaskRangeOpt = Integer.MIN_VALUE;
        this.mMaskEnableDataloader = Integer.MIN_VALUE;
        this.mTrEffectList = new ArrayList<>();
        this.mTrPerEffectAverageTime = "";
        this.mTrEffectErrorCode = "";
        this.mOttPluginVersion = Integer.MIN_VALUE;
        this.mCompanyID = "";
        this.mVRTracker = new VRTracker();
    }

    private void _updateFeatures() {
        TreeMap treeMap = new TreeMap();
        treeMap.putAll(sFeatures);
        treeMap.putAll(this.mFeatures);
        int i = this.mEventBase.mVideoHW;
        if (i != 0) {
            treeMap.put("v_hw", Integer.valueOf(i));
        }
        int i2 = this.mEventBase.mAudioHwUser;
        if (i2 != 0) {
            treeMap.put("a_hw", Integer.valueOf(i2));
        }
        int i3 = this.mAsyncInit;
        if (i3 > 0) {
            treeMap.put("async_init", Integer.valueOf(i3));
        }
        int i4 = this.mUseCodecPool;
        if (i4 > 0) {
            treeMap.put("codec_pool", Integer.valueOf(i4));
        }
        if (this.mEventBase.codec_type.equals("bytevc1")) {
            treeMap.put("bytevc1", 1);
        } else if (this.mEventBase.codec_type.equals("bytevc2")) {
            treeMap.put("bytevc2", 1);
        }
        int i5 = this.mNetworkTimeout;
        if (i5 > 0) {
            treeMap.put("network_timeout", Integer.valueOf(i5));
        }
        int i6 = this.mBufferTimeout;
        if (i6 > 0) {
            treeMap.put("buffer_timeout", Integer.valueOf(i6));
        }
        if (this.mFeatureConfigs.mEnableBufferDirectly > 0) {
            treeMap.put("buffer_directly", Integer.valueOf(this.mFeatureConfigs.mEnableBufferDirectly));
        }
        if (this.mFeatureConfigs.mFirstBufEndMs > 0) {
            treeMap.put("first_buf_end_ms", Integer.valueOf(this.mFeatureConfigs.mFirstBufEndMs));
        }
        int i7 = this.mEvent.textureRender;
        if (i7 > 0) {
            treeMap.put("oes_texture", Integer.valueOf(i7));
        }
        int i8 = this.mEnableNNSR;
        if (i8 > 0) {
            treeMap.put("sr", Integer.valueOf(i8));
        }
        if (this.mFeatureConfigs.mEnableVolumeBalance > 0) {
            if (this.mFeatureConfigs.mAEType == 0) {
                treeMap.put("volume_balance", 1);
            } else if (this.mFeatureConfigs.mAEType == 1) {
                treeMap.put("volume_balancev2", 1);
            } else if (this.mFeatureConfigs.mAEType == 4) {
                treeMap.put("volume_balance_tob", 1);
            }
            if (this.mFeatureConfigs.mEnableVolumeBalanceStrategySC > 0) {
                treeMap.put("sc_volume_balance", 1);
            }
        }
        int i9 = this.mEnableBash;
        if (i9 > 0) {
            treeMap.put("bash", Integer.valueOf(i9));
        }
        int i10 = this.mEventBase.is_enable_abr;
        if (i10 > 0) {
            treeMap.put("abr", Integer.valueOf(i10));
        }
        int i11 = this.mEventBase.is_enable_select_bitrate;
        if (i11 > 0) {
            treeMap.put("select", Integer.valueOf(i11));
        }
        if (this.mFeatureConfigs.mEnableEngineLooper > 0) {
            treeMap.put("engine_looper", Integer.valueOf(this.mFeatureConfigs.mEnableEngineLooper));
        }
        if (this.mFeatureConfigs.mEnableAutoRange > 0) {
            treeMap.put("auto_range", Integer.valueOf(this.mFeatureConfigs.mEnableAutoRange));
        }
        if (this.mFeatureConfigs.mEnableHwDropNonRef > 0) {
            treeMap.put("hw_drop", Integer.valueOf(this.mFeatureConfigs.mEnableHwDropNonRef));
        }
        if (this.mFeatureConfigs.mEnableHttps > 0) {
            treeMap.put("enable_https", Integer.valueOf(this.mFeatureConfigs.mEnableHttps));
        }
        int i12 = this.mEvent.checkHijack;
        if (i12 > 0) {
            treeMap.put("enable_hijack", Integer.valueOf(i12));
        }
        int i13 = this.mEvent.hijackRetry;
        if (i13 > 0) {
            treeMap.put("hijack_retry", Integer.valueOf(i13));
        }
        if (this.mFeatureConfigs.mEnableFallbackApi > 0) {
            treeMap.put("fallback_api", Integer.valueOf(this.mFeatureConfigs.mEnableFallbackApi));
        }
        if (this.mFeatureConfigs.mEnableAsyncPosition > 0) {
            treeMap.put("async_pos", Integer.valueOf(this.mFeatureConfigs.mEnableAsyncPosition));
        }
        int i14 = this.mEventBase.mReuseSocket;
        if (i14 > 0) {
            treeMap.put("socket_reuse", Integer.valueOf(i14));
        }
        int i15 = this.mEventBase.mEnableMDL;
        if (i15 > 0) {
            treeMap.put("mdl_type", Integer.valueOf(i15));
        }
        if (this.mFeatureConfigs.mEnableLoadControl > 0) {
            treeMap.put("enable_loadcontrol", Integer.valueOf(this.mFeatureConfigs.mEnableLoadControl));
        }
        if (this.mFeatureConfigs.mRenderType == 5) {
            if (this.mEventBase.mVideoHW == 0) {
                treeMap.put("render_type", 5);
            } else {
                treeMap.put("render_type", 3);
            }
        } else if (this.mFeatureConfigs.mRenderType >= 0) {
            treeMap.put("render_type", Integer.valueOf(this.mFeatureConfigs.mRenderType));
        }
        treeMap.put("image_scale", Integer.valueOf(this.mFeatureConfigs.mImageScaleType));
        int i16 = this.mMediaCodecRender;
        if (i16 >= 0) {
            treeMap.put("mc_render", Integer.valueOf(i16));
        }
        if (this.mFeatureConfigs.mAudioRenderType >= 0) {
            treeMap.put("audio_render_type", Integer.valueOf(this.mFeatureConfigs.mAudioRenderType));
        }
        if (this.mFeatureConfigs.mSkipFindStreamInfo > 0) {
            treeMap.put("skip_find_stream", Integer.valueOf(this.mFeatureConfigs.mSkipFindStreamInfo));
        }
        if (this.mFeatureConfigs.mEnableAsyncPrepare > 0) {
            treeMap.put("async_prepare", Integer.valueOf(this.mFeatureConfigs.mEnableAsyncPrepare));
        }
        if (this.mFeatureConfigs.mCodecFrcLevel > 0) {
            treeMap.put("frc_level", Integer.valueOf(this.mFeatureConfigs.mCodecFrcLevel));
        }
        if (this.mFeatureConfigs.mEnableLazySeek > 0) {
            treeMap.put("lazy_seek", Integer.valueOf(this.mFeatureConfigs.mEnableLazySeek));
        }
        if (this.mFeatureConfigs.mKeepFormatThreadAlive > 0) {
            treeMap.put("keep_formater_alive", Integer.valueOf(this.mFeatureConfigs.mKeepFormatThreadAlive));
        }
        int i17 = this.mEvent.isDisableShortSeek;
        if (i17 > 0) {
            treeMap.put("dis_short_seek", Integer.valueOf(i17));
        }
        int i18 = this.mEvent.isPreferNearestSample;
        if (i18 > 0) {
            treeMap.put("pref_near_sample", Integer.valueOf(i18));
        }
        int i19 = this.mEnableSubThread;
        if (i19 > 0) {
            treeMap.put("sub_thread_enable", Integer.valueOf(i19));
        }
        int i20 = this.mEnableMaskThread;
        if (i20 > 0) {
            treeMap.put("mask_thread_enable", Integer.valueOf(i20));
        }
        if ((this.mFeatureConfigs.mHDRType & 1) == 1) {
            treeMap.put("hdr_pq", 1);
        }
        if ((this.mFeatureConfigs.mHDRType & 2) == 2) {
            treeMap.put("hdr_hlg", 1);
        }
        if (this.mFeatureConfigs.mEnableABRStartup > 0) {
            treeMap.put("abr_startup", 1);
        }
        if (this.mFeatureConfigs.mEnableGearStrategy > 0) {
            treeMap.put("gear_strategy", Integer.valueOf(this.mFeatureConfigs.mEnableGearStrategy));
        }
        if (this.mFeatureConfigs.mEnableSRStrategy > 0) {
            treeMap.put("sr_strategy", Integer.valueOf(this.mFeatureConfigs.mEnableSRStrategy));
        }
        if (this.mFeatureConfigs.mEnableThreadPriority > 0) {
            treeMap.put("thread_priority", 1);
        }
        if (this.mFeatureConfigs.mEnableSmoothClock > 0) {
            treeMap.put("smooth_clock", 1);
        }
        if (this.mFeatureConfigs.mDisableSplitVoice > 0) {
            treeMap.put("disable_split_voice", 1);
        }
        if (this.mEventBase.mVideoHW == 0 && this.mFeatureConfigs.mEnableNativeYV12 > 0) {
            treeMap.put("yv12", 1);
        }
        if (this.mEvent.mAudioCodecProfile == 28) {
            treeMap.put("heaacv2", 1);
        }
        if (this.mFeatureConfigs.mEnableStrategyCenter > 0) {
            treeMap.put("strategy_center", 1);
        } else {
            treeMap.put("strategy_center", 0);
        }
        if (this.mFeatureConfigs.mEnableOutletDropLimit >= 0) {
            treeMap.put("drop_limit", Integer.valueOf(this.mFeatureConfigs.mEnableOutletDropLimit));
        }
        int intValue = DataLoaderHelper.getDataLoader().getIntValue(8);
        if (intValue > 0) {
            treeMap.put("mdl_socket_reuse", Integer.valueOf(intValue));
        }
        int intValue2 = DataLoaderHelper.getDataLoader().getIntValue(1001);
        if (intValue2 > 0) {
            treeMap.put("mdl_preconn", Integer.valueOf(intValue2));
        }
        if (DataLoaderHelper.getDataLoader().getIntValue(7) > 0) {
            treeMap.put("mdl_externdns", 1);
            if (TextUtils.equals(this.mEventBase.mDNSType, "httpDNS_own") || TextUtils.equals(this.mEventBase.mDNSType, "httpDNS_google") || TextUtils.equals(this.mEventBase.mDNSType, "customDNSInnerByteDanceHTTPDNS")) {
                treeMap.put("mdl_httpdns", 1);
            }
        }
        int intValue3 = DataLoaderHelper.getDataLoader().getIntValue(114);
        if (intValue3 > 0) {
            treeMap.put("mdl_predns", Integer.valueOf(intValue3));
        }
        int intValue4 = DataLoaderHelper.getDataLoader().getIntValue(105);
        if (intValue4 > 0) {
            treeMap.put("mdl_dns_refresh", Integer.valueOf(intValue4));
        }
        int intValue5 = DataLoaderHelper.getDataLoader().getIntValue(103);
        if (intValue5 > 0) {
            treeMap.put("mdl_dns_parallel", Integer.valueOf(intValue5));
        }
        int intValue6 = DataLoaderHelper.getDataLoader().getIntValue(115);
        if (intValue6 > 0) {
            treeMap.put("mdl_backip", Integer.valueOf(intValue6));
        }
        int intValue7 = DataLoaderHelper.getDataLoader().getIntValue(101);
        if (intValue7 > 0) {
            treeMap.put("mdl_session_reuse", Integer.valueOf(intValue7));
        }
        int intValue8 = DataLoaderHelper.getDataLoader().getIntValue(100);
        if (intValue8 == 3) {
            treeMap.put("mdl_tls_ver", Integer.valueOf(intValue8));
        }
        long longValue = DataLoaderHelper.getDataLoader().getLongValue(1152);
        String stringValue = DataLoaderHelper.getDataLoader().getStringValue(9010);
        if (longValue > 0 && !TextUtils.isEmpty(stringValue)) {
            treeMap.put("mdl_socket_monitor", 1);
        }
        this.mEvent.mFeatures = treeMap;
    }

    private void updateEventData() {
        String str;
        String str2;
        EventLoggerSource eventLoggerSource = this.mDataSource;
        if (eventLoggerSource == null) {
            str = "";
        } else {
            Map<String, Long> bytesInfo = eventLoggerSource.bytesInfo();
            if (bytesInfo == null) {
                str = "";
            } else {
                long longValue = bytesInfo.get("vps").longValue();
                long longValue2 = bytesInfo.get("vds").longValue();
                long longValue3 = bytesInfo.get("single_vds").longValue();
                long longValue4 = bytesInfo.get("accu_vds").longValue();
                VideoEventOnePlay videoEventOnePlay = this.mEvent;
                str = "";
                videoEventOnePlay.vps = this.mAccumVPS + longValue;
                if (this.mLooping) {
                    videoEventOnePlay.vds = this.mAccumVDS + longValue3;
                } else {
                    videoEventOnePlay.vds = this.mAccumVDS + longValue2;
                }
                videoEventOnePlay.accu_vds = this.mAccumVDS + longValue4;
                TTVideoEngineLog.i("VideoEventLoggerV2", "_sendEvent accumVDS:" + this.mAccumVDS + ", vds:" + longValue2 + ", single_vds:" + longValue3 + ", mEvent.vds:" + this.mEvent.vds + ", accu_vds:" + longValue4);
                EngineThreadPool.addExecuteTask(new VideoInfoCollector.myVideoCollectorAddConsumeSize(this.mEvent.vps));
            }
            this.mEvent.render_type = this.mDataSource.getLogValueStr(1);
            this.mEvent.encode_user_tag = this.mDataSource.getLogValueStr(159);
            this.mEvent.ufq_info = this.mDataSource.getLogValueStr(162);
            logMessage(this.mDataSource.getLogValueStr(2));
            this.mEvent.apiString = this.mDataSource.getLogValueStr(3);
            this.mEvent.netClient = this.mDataSource.getLogValueStr(4);
            this.mEvent.engineState = this.mDataSource.getLogValueInt(23);
            this.mEvent.isPreferNearestSample = this.mDataSource.getLogValueInt(34);
            this.mEvent.networkTimeout = this.mDataSource.getLogValueInt(35);
            this.mEvent.isDisableShortSeek = this.mDataSource.getLogValueInt(36);
            if (this.mEvent.internalIP == null) {
                String logValueStr = this.mDataSource.getLogValueStr(5);
                if (logValueStr == null) {
                    logValueStr = str;
                }
                this.mEvent.internalIP = logValueStr;
            }
            String logValueStr2 = this.mDataSource.getLogValueStr(33);
            if (!TextUtils.isEmpty(logValueStr2)) {
                this.mEvent.loaderType = logValueStr2;
            }
            _checkFirstFrameTimes();
            this.mEvent.core_volume = this.mDataSource.getLogValueInt(61);
            this.mEvent.mute = this.mDataSource.getLogValueInt(27);
            this.mEvent.apiverFinal = this.mDataSource.getLogValueInt(30);
            this.mEvent.chipBoardName = this.mDataSource.getLogValueStr(31);
            this.mEvent.chipHardwareName = this.mDataSource.getLogValueStr(32);
            this.mEvent.chipHardwareNameNew = this.mDataSource.getLogValueStr(TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE);
            if (this.mFeatureConfigs.mEnableVolumeBalance > 0 && this.mFeatureConfigs.mAEType >= 0) {
                this.mEvent.ae_type = this.mFeatureConfigs.mAEType;
                int logValueInt = this.mDataSource.getLogValueInt(81);
                if (logValueInt >= 0) {
                    this.mEvent.ae_type = logValueInt;
                }
                if (this.mDataSource.getLogValueInt(158) == 0) {
                    VideoEventOnePlay videoEventOnePlay2 = this.mEvent;
                    videoEventOnePlay2.ae_type = -videoEventOnePlay2.ae_type;
                }
            }
            if (!TTVideoEngine.sColdStartOptimize || sIsColdStart == 0) {
                this.mEvent.videoAudioGap = this.mDataSource.getLogValueLong(54);
                this.mEvent.moovPos = this.mDataSource.getLogValueLong(57);
                this.mEvent.mdatPos = this.mDataSource.getLogValueLong(58);
            }
            int logValueInt2 = this.mDataSource.getLogValueInt(100);
            if (logValueInt2 != 0) {
                this.mEvent.textureRenderErrorCode = logValueInt2;
            }
            if (!TTVideoEngine.sBuryDataOptimize) {
                this.mEvent.minAudioFrameSize = this.mDataSource.getLogValueLong(140);
                this.mEvent.minVideoFrameSize = this.mDataSource.getLogValueLong(141);
                this.mEvent.feedInBeforeDecoded = this.mDataSource.getLogValueInt(142);
                this.mEvent.mPreloadGear = this.mDataSource.getLogValueStr(143);
                int logValueInt3 = this.mDataSource.getLogValueInt(145);
                float logValueFloat = this.mDataSource.getLogValueFloat(82);
                if (logValueInt3 > 0 && logValueFloat > 0.0f) {
                    this.mEvent.netblockBufferthreshold = (int) ((logValueInt3 / logValueFloat) * 1000.0d);
                }
            }
            VideoEventOnePlay videoEventOnePlay3 = this.mEvent;
            if (videoEventOnePlay3.mVideoCodecProfile == Integer.MIN_VALUE) {
                videoEventOnePlay3.mVideoCodecProfile = this.mDataSource.getLogValueInt(63);
            }
            VideoEventOnePlay videoEventOnePlay4 = this.mEvent;
            if (videoEventOnePlay4.mAudioCodecProfile == Integer.MIN_VALUE) {
                videoEventOnePlay4.mAudioCodecProfile = this.mDataSource.getLogValueInt(64);
            }
            this.mEvent.mVideoHWErrReason = this.mDataSource.getLogValueInt(77);
            this.mEvent.mMaxFramesInMediaCodec = this.mDataSource.getLogValueInt(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO);
            this.mEvent.mIsViewHidden = this.mDataSource.getLogValueInt(87);
            this.mEvent.mVideoRenderStallCount = this.mDataSource.getLogValueInt(156);
            this.mEvent.mVideoRenderStallList = this.mDataSource.getLogValueStr(157);
            HashMap<String, Object> chargingState = this.mEventBase.getChargingState();
            if (chargingState != null) {
                this.mPowerList.add((Integer) chargingState.get("power"));
                this.mChargingList.add((Integer) chargingState.get("isCharging"));
            }
            ArrayList forebackSwitchList = this.mDataSource.forebackSwitchList();
            if (forebackSwitchList != null) {
                this.mEvent.mForebackSwitchList = forebackSwitchList;
            }
            EventLoggerSource eventLoggerSource2 = this.mDataSource;
            if (eventLoggerSource2 != null) {
                this.mEvent.mMapAppLog = eventLoggerSource2.getLogValueMap(155);
            }
            this.mEvent.mNetworkConnectCount = this.mDataSource.getLogValueInt(114);
            long logValueLong = this.mDataSource.getLogValueLong(137);
            if (logValueLong > 0) {
                this.mEvent.mMaskDownloadSize = logValueLong;
            }
            long logValueLong2 = this.mDataSource.getLogValueLong(138);
            if (logValueLong2 > 0) {
                this.mEvent.mSubtitleDownloadSize = logValueLong2;
            }
            this.mEvent.mInBackgroundWhenStop = this.mDataSource.getLogValueInt(94);
        }
        int i = this.mDuration;
        if (i > 0) {
            this.mEventBase.vd = i;
        }
        Context context = this.mContext;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("VideoEventLogger", 0);
            str2 = str;
            this.mEvent.mLastSessionID = sharedPreferences.getString("playersessionid", str2);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("playersessionid", this.mEventBase.mSessionID);
            edit.apply();
        } else {
            str2 = str;
        }
        VideoEventOnePlay videoEventOnePlay5 = this.mEvent;
        VideoEventBase videoEventBase = this.mEventBase;
        videoEventOnePlay5.mSessionID = videoEventBase.mSessionID;
        videoEventOnePlay5.leave_reason = this.mLeaveReason;
        videoEventOnePlay5.apiver = this.mApiVer;
        videoEventOnePlay5.auth = this.mAuth;
        videoEventOnePlay5.startTime = this.mStartTime;
        videoEventOnePlay5.disableAccurateStart = this.mDisableAccurateStart;
        videoEventOnePlay5.vu = this.mVUArray;
        videoEventOnePlay5.lf = videoEventBase.mLastResolution;
        videoEventOnePlay5.df = videoEventBase.mCurrentResolution;
        videoEventOnePlay5.isStartPlayAutomatically = this.mIsStartPlayAutomatically;
        videoEventOnePlay5.bufferSeconds = this.mBufferDataSeconds;
        videoEventOnePlay5.loopcount = this.mLoopCount;
        videoEventOnePlay5.width = this.mWidth;
        videoEventOnePlay5.height = this.mHeight;
        videoEventOnePlay5.p2pUrl = this.mP2PUrl;
        videoEventOnePlay5.customP2PCDNType = this.mCustomP2PCDNType;
        videoEventOnePlay5.asyncInit = this.mAsyncInit;
        videoEventOnePlay5.asyncCodecId = this.mAsyncCodecId;
        videoEventOnePlay5.dns_server_ip = DNSServerIP.getDNSServerIP();
        VideoEventOnePlay videoEventOnePlay6 = this.mEvent;
        videoEventOnePlay6.bc = this.mCurBufferCount;
        videoEventOnePlay6.br = this.mBreakCount;
        videoEventOnePlay6.bitrate = this.mBitrate;
        videoEventOnePlay6.audioBitrate = this.mAudioBitrate;
        videoEventOnePlay6.firstRangeSize = this.mFirstRangeSize;
        videoEventOnePlay6.netSpeedLevel = this.mNetSpeedLevel;
        videoEventOnePlay6.modelVersion = this.mModelVersion;
        videoEventOnePlay6.mRadioMode = this.mRadioMode;
        videoEventOnePlay6.mAudioStreamDisabled = this.mAudioStreamDisabled;
        videoEventOnePlay6.mVideoStreamDisabled = this.mVideoStreamDisabled;
        videoEventOnePlay6.isReplay = this.mIsReplay;
        videoEventOnePlay6.mediaCodecRender = this.mMediaCodecRender;
        videoEventOnePlay6.codecPool = this.mUseCodecPool;
        long j = this.mSurfaceSetTime;
        if (j > 0) {
            videoEventOnePlay6.surfaceSetTime = j;
        }
        videoEventOnePlay6.surfaceCode = this.mSurfaceCode;
        videoEventOnePlay6.playerSurfaceCode = this.mPlayerSurfaceCode;
        VideoEventOneEvent videoEventOneEvent = this.mEventOneEvent;
        if (videoEventOneEvent != null) {
            videoEventOnePlay6.bufferAccuT = videoEventOneEvent.mAccuCostTime;
        }
        videoEventOnePlay6.decoderBufferAccuT = this.mCurDecoderBufferAccuT;
        videoEventOnePlay6.seekCount = this.mSeekCount;
        videoEventOnePlay6.switchResolutionCount = this.mSwitchResolutionCount;
        videoEventOnePlay6.mEnableNNSR = this.mEnableNNSR;
        videoEventOnePlay6.mReadCacheMode = this.mReadCacheMode;
        videoEventOnePlay6.mPreRangeOff = this.mPreRangeOff;
        videoEventOnePlay6.mBufferTimeout = this.mBufferTimeout;
        videoEventOnePlay6.mCustomPlayEngineT = this.mCustomPlayEngineT;
        videoEventOnePlay6.mCustomInitEngineT = this.mCustomInitEngineT;
        VideoEventOnePlay videoEventOnePlay7 = this.mEvent;
        videoEventOnePlay7.mCustomGetVideoModelT = this.mCustomGetVideoModelT;
        videoEventOnePlay7.mCustomClickT = this.mCustomClickT;
        videoEventOnePlay7.mHardwareConfType = this.mHardwareConfType;
        videoEventOnePlay7.mScreenWidth = getScreenWidth();
        this.mEvent.mScreenHeight = getScreenHeight();
        this.mEvent.mPixelDensity = ScreenUtils.getScreenPixelDensity();
        this.mEvent.xdpi = ScreenUtils.getScreenXdpi();
        this.mEvent.ydpi = ScreenUtils.getScreenYdpi();
        if (this.mSrMonitor.getWidthFactor() > 0.0f) {
            this.mEvent.mSrWidthFactor = this.mSrMonitor.getWidthFactor();
        }
        if (this.mSrMonitor.getHeightFactor() > 0.0f) {
            this.mEvent.mSrHeightFactor = this.mSrMonitor.getHeightFactor();
        }
        this.mEvent.mSrProccessSuccessRate = this.mSrMonitor.getProccessSuccessRate();
        this.mEvent.mSrProcessorCostTime = this.mSrMonitor.getProcessorAverageCostTime();
        this.mEvent.mSrAlgorithm = this.mSrMonitor.getSrAlgorithm();
        this.mEvent.mSrEnableBmf = this.mSrMonitor.getEnableBmf();
        this.mEvent.mVideoFilterList = this.mFilterMonitor.getList();
        this.mEvent.mBrightList = this.mBrightMonitor.getList();
        this.mEvent.mViewSizeList = this.mViewSizeMonitor.getHistory();
        VideoEventOnePlay videoEventOnePlay8 = this.mEvent;
        videoEventOnePlay8.mLabelUsage = this.mLabelUsage;
        videoEventOnePlay8.mEngineHash = this.mEngineHash;
        HashMap hashMap = new HashMap();
        String str3 = this.mMDLHijackURL;
        if (str3 != null && str3.length() > 0) {
            hashMap.put("MDLHijackUrl", this.mMDLHijackURL);
        }
        String str4 = this.mMDLHijackIP;
        if (str4 != null && str4.length() > 0) {
            hashMap.put("MDLHijackIP", this.mMDLHijackIP);
        }
        for (int i2 = 0; i2 < this.mRetryFetchErrorInfo.size() && i2 < 3; i2++) {
            try {
                hashMap.put(String.format("fetchretry%d", Integer.valueOf(i2)), this.mRetryFetchErrorInfo.get(i2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i3 = 0; i3 < this.mFirstDNSErrorInfo.size() && i3 < 3; i3++) {
            hashMap.put(String.format("ldns%d", Integer.valueOf(i3)), ((Error) this.mFirstDNSErrorInfo.get(i3)).toMap());
        }
        for (int i4 = 0; i4 < this.mErrorInfo.size(); i4++) {
            if (i4 < 2 || i4 == this.mErrorInfo.size() - 1) {
                hashMap.put(String.format("error%d", Integer.valueOf(i4)), this.mErrorInfo.get(i4));
            }
        }
        if (!TextUtils.isEmpty(this.mMessage)) {
            hashMap.put("log", this.mMessage);
        }
        if (!TextUtils.isEmpty(this.mEvent.textureRenderErrorMsg)) {
            hashMap.put("tr_err_msg", this.mEvent.textureRenderErrorMsg);
        }
        this.mMessage = str2;
        this.mEvent.ex = hashMap;
        this.mExtraInfo = hashMap.toString();
        String str5 = this.mCustomStr;
        if (str5 != null) {
            this.mEvent.mCustomStr = str5;
        }
        String str6 = this.mInitialURL;
        if (str6 != null) {
            this.mEvent.mInitialURL = str6;
        }
        String str7 = this.mAudioInitURL;
        if (str7 != null) {
            this.mEvent.mAudioInitUrl = str7;
        }
        String str8 = this.mInitialHost;
        if (str8 != null) {
            this.mEvent.mInitialHost = str8;
        }
        String str9 = this.mInitialIP;
        if (str9 != null) {
            this.mEvent.mInitialIP = str9;
        }
        String str10 = this.mInitialResolution;
        if (str10 != null) {
            this.mEvent.mInitialResolution = str10;
        }
        String str11 = this.mInitialQuality;
        if (str11 != null) {
            this.mEvent.mInitialQuality = str11;
        }
        VideoEventOnePlay videoEventOnePlay9 = this.mEvent;
        videoEventOnePlay9.mInitialQualityType = this.mInitialQualityType;
        Map map = this.mPlaybackParams;
        if (map != null) {
            videoEventOnePlay9.playbackparams = map;
        }
        String str12 = this.mSubReqURL;
        if (str12 != null) {
            videoEventOnePlay9.mSubReqURL = str12;
        }
        String str13 = this.mMaskURL;
        if (str13 != null) {
            videoEventOnePlay9.mMaskURL = str13;
        }
        String str14 = this.mSubError;
        if (str14 != null) {
            videoEventOnePlay9.mSubError = str14;
        }
        if (videoEventOnePlay9.mask_opened_t <= 0) {
            videoEventOnePlay9.mask_opened_t = -2147483648L;
        }
        if (videoEventOnePlay9.mask_open_t <= 0) {
            videoEventOnePlay9.mask_open_t = -2147483648L;
        }
        if (videoEventOnePlay9.sub_req_finish_t <= 0) {
            videoEventOnePlay9.sub_req_finish_t = -2147483648L;
        }
        if (videoEventOnePlay9.sub_load_finish_t <= 0) {
            videoEventOnePlay9.sub_load_finish_t = -2147483648L;
        }
        videoEventOnePlay9.enableSub = this.mEnableSub;
        videoEventOnePlay9.enableSubThread = this.mEnableSubThread;
        videoEventOnePlay9.enableMask = this.mEnableMask;
        videoEventOnePlay9.enableMaskThread = this.mEnableMaskThread;
        videoEventOnePlay9.maskErrc = this.mMaskErrc;
        videoEventOnePlay9.subLanSwichCount = this.mSubLanSwitchCount;
        videoEventOnePlay9.subIdsCount = this.mSubIdsCount;
        videoEventOnePlay9.enableBash = this.mEnableBash;
        videoEventOnePlay9.enableMDL = this.mEventBase.mEnableMDL;
        videoEventOnePlay9.netWorkTryCount = this.mNetWorkTryCount;
        videoEventOnePlay9.isColdStart = sIsColdStart;
        sIsColdStart = 0;
        if (videoEventOnePlay9.lastSeekEndT < videoEventOnePlay9.lastSeekStartT) {
            videoEventOnePlay9.lastSeekEndT = -2147483648L;
        }
        if (videoEventOnePlay9.lastResolutionEndT < videoEventOnePlay9.lastResolutionStartT) {
            videoEventOnePlay9.lastResolutionEndT = -2147483648L;
        }
        videoEventOnePlay9.prepare_before_play_t = this.prepare_before_play_t;
        videoEventOnePlay9.setds_t = this.setds_t;
        videoEventOnePlay9.pt = videoEventOnePlay9.pt_new;
        videoEventOnePlay9.ps_t = this.ps_t;
        if (videoEventOnePlay9.et <= 0 && videoEventOnePlay9.vt > 0) {
            videoEventOnePlay9.et = System.currentTimeMillis();
        }
        VideoEventOnePlay videoEventOnePlay10 = this.mEvent;
        videoEventOnePlay10.mPlayList = this.mPlayList;
        videoEventOnePlay10.mPauseList = this.mPauseList;
        videoEventOnePlay10.mCDNTuningList = this.mCDNTuningList;
        videoEventOnePlay10.mResolutionList = this.mResolutionList;
        videoEventOnePlay10.mPlaySpeedList = this.mPlaySpeedList;
        videoEventOnePlay10.mRadiomodeList = this.mRadiomodeList;
        videoEventOnePlay10.mLoopList = this.mLoopList;
        videoEventOnePlay10.mErrorList = this.mErrorList;
        videoEventOnePlay10.mRebufList = this.mEventOneEvent.mRebufList;
        videoEventOnePlay10.mSeekList = this.mEventOneOpera.mSeekList;
        videoEventOnePlay10.mHeadsetStateList = this.mHeadsetStateHistory.get();
        VideoEventOnePlay videoEventOnePlay11 = this.mEvent;
        VideoEventOneOutSync videoEventOneOutSync = this.mEventOneOutSync;
        videoEventOnePlay11.mAVOutsyncList = videoEventOneOutSync.mList;
        videoEventOnePlay11.mAVOutsyncCount = videoEventOneOutSync.mAVOutSyncCount;
        videoEventOnePlay11.mMDLRetryList = this.mMDLRetryInfo;
        videoEventOnePlay11.mPowerList = this.mPowerList;
        videoEventOnePlay11.mChargingList = this.mChargingList;
        videoEventOnePlay11.mAVBadInterlacedList = this.mAVBadInterlacedList;
        videoEventOnePlay11.mVrDistanceList = this.mVrDistanceList;
        videoEventOnePlay11.mVrFrameRate = this.mVrFrameRate;
        videoEventOnePlay11.mVrScreenRefreshRate = this.mVrScreenRefreshRate;
        videoEventOnePlay11.mVrHeadMovementDelay = this.mVrHeadMovementDelay;
        videoEventOnePlay11.mSetSurfaceTimeList = this.mSetSurfaceTimeList;
        if (this.mEventOneNoRender.isStarted()) {
            this.mEventOneNoRender.end(0, "exit");
            callbackNoRenderEnd(this.mEventOneNoRender.getType());
        }
        this.mEvent.mNoVideoRenderList = this.mEventOneNoRender.getVideoHistory();
        this.mEvent.mNoAudioRenderList = this.mEventOneNoRender.getAudioHistory();
        VideoEventOnePlay videoEventOnePlay12 = this.mEvent;
        videoEventOnePlay12.mTrEffectList = this.mTrEffectList;
        videoEventOnePlay12.mTrPerEffectAverageTime = this.mTrPerEffectAverageTime;
        videoEventOnePlay12.mTrEffectErrorCode = this.mTrEffectErrorCode;
        videoEventOnePlay12.mOttPluginVersion = this.mOttPluginVersion;
        videoEventOnePlay12.mCompanyID = this.mCompanyID;
        _getMaskEvents();
        _getSubEvents();
        if (TextUtils.isEmpty(this.mEvent.log_id)) {
            _parseUrlLogID();
        }
        if (this.mBlockBeginT > 0) {
            this.mEvent.leave_block_t = (int) (SystemClock.elapsedRealtime() - this.mBlockBeginT);
        }
        VideoEventOneOpera videoEventOneOpera = this.mEventOneOpera;
        if (videoEventOneOpera != null) {
            this.mEvent.seek_accu_t = videoEventOneOpera.mAccuCostTime;
        }
        if (TimeService.isUpdated()) {
            this.mEvent.server_local_diff = TimeService.currentTimeMillis() - System.currentTimeMillis();
        }
        _updateFeatures();
        _getCastInfo();
        IVideoModel iVideoModel = this.mVideoModel;
        if (iVideoModel != null) {
            VideoStyle videoStyle = iVideoModel.getVideoStyle();
            if (videoStyle != null && videoStyle.getValueInt(0) == 1) {
                VideoEventOnePlay videoEventOnePlay13 = this.mEvent;
                videoEventOnePlay13.mVideoStyle = 1;
                videoEventOnePlay13.mDimension = videoStyle.getValueInt(1);
                this.mEvent.mProjectionModel = videoStyle.getValueInt(2);
                this.mEvent.mViewSize = videoStyle.getValueInt(3);
            }
        } else {
            VRTracker vRTracker = this.mVRTracker;
            if (vRTracker != null) {
                this.mEvent.mVideoStyle = vRTracker.getVideoStyle();
                this.mEvent.mDimension = this.mVRTracker.getDimension();
                this.mEvent.mProjectionModel = this.mVRTracker.getProjectStyle();
                this.mEvent.mViewSize = this.mVRTracker.getViewSize();
            }
        }
        this.mVegaCollector.retrieveEventParam(this.mEventBase, this.mEvent);
    }

    class FeatureConfigs {
        private int mEnableBufferDirectly = 0;
        private int mFirstBufEndMs = 0;
        private int mEnableVolumeBalance = 0;
        private int mAEType = -1;
        private int mEnableEngineLooper = 0;
        private int mEnableAutoRange = 0;
        private int mEnableHwDropNonRef = 0;
        private int mEnableHttps = 0;
        private int mEnableFallbackApi = 0;
        private int mEnableAsyncPosition = 0;
        private int mEnableLoadControl = 0;
        private int mRenderType = Integer.MIN_VALUE;
        private int mImageScaleType = 0;
        private int mAudioRenderType = Integer.MIN_VALUE;
        private int mSkipFindStreamInfo = 0;
        private int mEnableAsyncPrepare = 0;
        private int mCodecFrcLevel = 0;
        private int mEnableLazySeek = 0;
        private int mKeepFormatThreadAlive = 0;
        private int mHDRType = 0;
        private int mEnableABRStartup = 0;
        private int mEnableThreadPriority = 0;
        private int mEnableSmoothClock = 0;
        private int mDisableSplitVoice = 0;
        private int mEnableNativeYV12 = 0;
        private int mEnableStrategyCenter = 0;
        private int mEnableOutletDropLimit = -1;
        private int mEnableGearStrategy = 0;
        private int mEnableSRStrategy = 0;
        private int mEnableVolumeBalanceStrategySC = 0;

        static {
            Covode.recordClassIndex(652495);
        }

        FeatureConfigs() {
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void bufferDataSeconds(int i) {
        this.mBufferDataSeconds = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void initContentReporterIfNeeded(String str) {
        TextUtils.isEmpty(str);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setCustomP2PCDNType(int i) {
        this.mCustomP2PCDNType = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setCustomStr(String str) {
        this.mCustomStr = str;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setDisableAccurateStart(int i) {
        this.mDisableAccurateStart = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setEnableBash(int i) {
        this.mEnableBash = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setFeed(VideoModel videoModel) {
        setFeed((IVideoModel) videoModel);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setInitialQuality(String str) {
        this.mInitialQuality = str;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setInitialQualityType(int i) {
        this.mInitialQualityType = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setLooping(boolean z) {
        this.mLooping = z;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setMaskErrorCode(int i) {
        this.mMaskErrc = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setMaskUrl(String str) {
        this.mMaskURL = str;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setMediaCodecRender(int i) {
        this.mMediaCodecRender = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setNetWorkTryCount(int i) {
        this.mNetWorkTryCount = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setProxyUrl(String str) {
        this.mProxyUrl = str;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setStartPlayHeight(int i) {
        this.mHeight = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setStartPlayWidth(int i) {
        this.mWidth = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setStartTime(int i) {
        this.mStartTime = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setSubtitleError(String str) {
        this.mSubError = str;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setSubtitleIdsCount(int i) {
        this.mSubIdsCount = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setSubtitleRequestUrl(String str) {
        this.mSubReqURL = str;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setVUArray(ArrayList arrayList) {
        this.mVUArray = arrayList;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setVrDisplayFrameRate(float f) {
        this.mVrFrameRate = f;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setVrHeadMovementDelay(long j) {
        this.mVrHeadMovementDelay = j;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setVrScreenRefreshRate(int i) {
        this.mVrScreenRefreshRate = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void updateVideoInfo(VideoModel videoModel) {
        updateVideoInfo((IVideoModel) videoModel);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void useCodecPool(int i) {
        this.mUseCodecPool = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void abrEventEnd(long j) {
        this.mEventAbrSwitch.abrSwitchEnd(j);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void addLabelUsage(Map<String, Object> map) {
        this.mLabelUsage.addUsage(map);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void addWatchedDuration(int i) {
        this.mEvent.watchduration = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public IMediaMetrics buildMetrics(int i) {
        return MetricsFactory.createMetrics(i, this.mEvent);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void clockDiff(long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.clockDiff = j;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void containerFps(float f) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.containerFps = f;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void curVideoDecoderFps(int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.curVideoDecoderFps = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void curVideoOutputFps(float f) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.curVideoOutputFps = f;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void dropCount(int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.dropCount = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void enableSharp(int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.enableSharp = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void engineState(int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.engineState = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void fetchedAndLeaveByUser(int i) {
        this.mEvent.fetchedAndLeaveByUser = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void firstDNSFailed(Error error) {
        this.mFirstDNSErrorInfo.add(error);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void hwCodecException(int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.hwCodecException = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void hwCodecName(String str) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.hwCodecName = str;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setAbrGeneralInfo(Map<String, Object> map) {
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null) {
            videoEventBase.abrGeneralInfo = map;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setAbrInfo(Map<String, Object> map) {
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null) {
            videoEventBase.abrInfo = map;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setAudioTranConnectTime(long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.audioTranConnectT = j;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setAudioTranFirstPacketTime(long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.audioTranFirstPacketT = j;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setCDNTuningParam(String str) {
        TTVideoEngineUtils.addToList(this.mCDNTuningList, str);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setCheckHijack(int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null) {
            videoEventOnePlay.checkHijack = i;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setCurQuality(String str) {
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null) {
            videoEventBase.setCurQuality(str);
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setCurResolution(String str) {
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null) {
            videoEventBase.setCurResolution(str);
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setCurrentQualityDesc(String str) {
        this.mEventBase.setCurrentQualityDesc(str);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setDashAudioCacheSize(long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null) {
            videoEventOnePlay.d_apls = j;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setDashVideoCacheSize(long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null) {
            videoEventOnePlay.d_vpls = j;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setDecodeFirstAudioFrameTime(long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.decodeFirstAudioFrameT = j;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setDecodeFirstVideoFrameTime(long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.decodeFirstVideoFrameT = j;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setDrmTokenUrl(String str) {
        this.mEventBase.mDrmTokenUrl = str;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setDrmType(int i) {
        this.mEventBase.mDrmType = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setDuration(int i) {
        this.mDuration = i;
        this.mEventBase.vd = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setEnableBmfSr(int i) {
        this.mSrMonitor.setEnableBmf(i);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setEnableMDL(int i) {
        this.mEventBase.mEnableMDL = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setEncryptKey(String str) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null) {
            videoEventOnePlay.encryptKey = str;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setFeed(IVideoModel iVideoModel) {
        if (iVideoModel == null) {
            return;
        }
        updateVideoInfo(iVideoModel);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setFramesDropNum(int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null) {
            videoEventOnePlay.mFramesSetDropNum = i;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setGearStrategyEvent(Map<String, Object> map) {
        this.mEvent.mGearStrategyInfo.putAll(map);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setHijackRetry(int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null) {
            videoEventOnePlay.hijackRetry = i;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setIsEnableABR(int i) {
        this.mEventBase.is_enable_abr = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setIsEnableSelectBitrate(int i) {
        this.mEventBase.is_enable_select_bitrate = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setIsMultiDimensionsInput(int i) {
        this.mEventBase.is_multi_dimensionsInput = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setIsMultiDimensionsOut(int i) {
        this.mEventBase.is_multi_dimensions = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setIsVideoModelCache(int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null) {
            videoEventOnePlay.useVideoModelCache = i;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setP2PCDNType(int i) {
        this.mEventBase.setP2PCDNType(i);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setP2PSDKVersion(String str) {
        if (str != null) {
            this.mP2PSDKVersion = str;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setP2PUrl(String str) {
        if (str != null) {
            this.mP2PUrl = str;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setPlayType(int i) {
        this.mEventBase.mPlayType = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setReceiveFirstAudioFrameTime(long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.receiveFirstAudioFrameT = j;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setReceiveFirstVideoFrameTime(long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.receiveFirstVideoFrameT = j;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setSRPreloadInfo(Map<String, Object> map) {
        this.mEvent.mSRPreloadInfo = map;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setSelectResult(Map<String, String> map) {
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null) {
            videoEventBase.selectResultInfo = map;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setSourceRefreshLog(JSONObject jSONObject) {
        this.mEvent.mSourceRefreshLog = jSONObject;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setSpeedPredictorAlgoType(int i) {
        this.mEventBase.speed_predict_type = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setSrAlgorithm(int i) {
        this.mSrMonitor.setAlgorithm(i);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setSrScaleType(int i) {
        this.mSrMonitor.setSrScaleType(i);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setTranConnectTime(long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.tranConnectT = j;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setTranFirstPacketTime(long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.tranFirstPacketT = j;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setUploadLogEnabled(boolean z) {
        this.mUploadLogEnabled = z;
        this.mEventBase.isUploadLogEnabled = z;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setVideoCacheSize(long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null) {
            videoEventOnePlay.vpls = j;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void useHardwareDecode(int i) {
        this.mEventBase.useVideoHW(i);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void useTextureRender(int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.textureRender = i;
    }

    private boolean enableReport(int i) {
        if ((i & this.mReportLevel) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void curAudioDecodeError(int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null && i > 0) {
            videoEventOnePlay.curAudioDecodeError = i;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void curPlayBackTime(int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.curPlayBackTime = i;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void curVideoDecodeError(int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null && i > 0) {
            videoEventOnePlay.curVideoDecodeError = i;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void curVideoRenderError(int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null && i >= 0) {
            videoEventOnePlay.curVideoRenderError = i;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void enableStartPlayAutomatically(boolean z) {
        if (z) {
            this.mIsStartPlayAutomatically = 1;
        } else {
            this.mIsStartPlayAutomatically = 0;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public int getIntOption(int i) {
        VideoEventBase videoEventBase;
        if (i == 49 && (videoEventBase = this.mEventBase) != null) {
            return videoEventBase.formatType;
        }
        return -1;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void moviePreStalled(int i) {
        TTVideoEngineLog.i("VideoEventLoggerV2", "movie may stall");
        this.mEventOneEvent.moviePreStalled(i);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setAudioBufferLength(long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.audioBufferLength = (int) j;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setFirstPlayerFirstFrameTime(long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null && videoEventOnePlay.playerFirstFrameT <= 0) {
            videoEventOnePlay.playerFirstFrameT = j;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setInitialHost(String str) {
        this.mInitialHost = str;
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null) {
            videoEventBase.mInitialHost = str;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setInitialIP(String str) {
        this.mInitialIP = str;
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null) {
            videoEventBase.mInitialIP = str;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setMDLHijackIP(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mMDLHijackIP = str;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setMDLHijackURL(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mMDLHijackURL = str;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setPlayerCreatedT(long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null && videoEventOnePlay.player_created_t <= 0) {
            videoEventOnePlay.player_created_t = j;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setPlayerHostAddr(String str) {
        if (this.mEvent != null && !TextUtils.isEmpty(str)) {
            this.mEvent.internalIP = str;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setPlayerSurface(String str) {
        if (TextUtils.isEmpty(this.mPlayerSurfaceCode)) {
            this.mPlayerSurfaceCode = str;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setSRStrategyInfo(SRStrategy sRStrategy) {
        this.mEvent.mSRStrategyInfo.putAll(sRStrategy.getStrategyInfo());
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setSurfaceSourceType(String str) {
        if (!TextUtils.isEmpty(str) && this.mSetSurfaceType == null) {
            this.mSetSurfaceType = str;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setTextureRenderError(String str) {
        if (this.mEvent != null && !TextUtils.isEmpty(str)) {
            this.mEvent.textureRenderErrorMsg = str;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setTraceID(String str) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null) {
            videoEventOnePlay.traceID = str;
        }
        this.mEventBase.mTraceID = str;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setVideoBufferLength(long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.videoBufferLength = (int) j;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void updateMultiNetworkSpeed(final String str) {
        EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.log.VideoEventLoggerV2.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized ("VideoEventLoggerV2") {
                    try {
                        JSONArray optJSONArray = new JSONObject(str).optJSONArray("data");
                        long j = 0;
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONArray optJSONArray2 = optJSONArray.getJSONObject(i).optJSONArray("downinfo");
                            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    JSONObject jSONObject = optJSONArray2.getJSONObject(i2);
                                    long optLong = jSONObject.optLong("size");
                                    long optLong2 = jSONObject.optLong("costTime");
                                    if (optLong != 0 || optLong2 != -1) {
                                        VideoEventLoggerV2.this.mMDLDownloadSize += optLong;
                                        j = Math.max(j, optLong2);
                                    }
                                }
                            }
                        }
                        VideoEventLoggerV2.this.mMDLDownloadTime = j;
                        TTVideoEngineLog.d("VideoEventLoggerV2", "update multi speed size:" + VideoEventLoggerV2.this.mMDLDownloadSize + ", time:" + VideoEventLoggerV2.this.mMDLDownloadTime);
                    } catch (Exception e) {
                        TTVideoEngineLog.e("VideoEventLoggerV2", "update networkspeed error " + e.toString());
                    }
                }
            }
        });
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void updateVideoInfo(IVideoModel iVideoModel) {
        if (iVideoModel == null) {
            return;
        }
        this.mEventBase.setVideoInfo(iVideoModel);
        this.mVideoModel = iVideoModel;
        this.mLabelUsage.updateByVideoModel(iVideoModel);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void validateVideoMetaInfoFail(Error error) {
        this.mEvent.hijack = 1;
        this.mErrorInfo.add(error);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void AVOutSyncEnd(int i) {
        this.mEventOneOutSync.AVOutSyncEnd(i, "wait");
        this.mAVOutSyncing = false;
        if (this.mState == 2) {
            _recordExitReason(-2006, false);
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public String getStringOption(int i) {
        String str;
        String str2 = "";
        try {
            if (i != 47) {
                if (i != 86) {
                    return "";
                }
                str = this.mEventBase.mSessionID;
            } else {
                str = this.mEventBase.mSourceTypeStr;
            }
            str2 = str;
            return str2;
        } catch (Throwable th) {
            TTVideoEngineLog.d(th);
            return str2;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void logMessage(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mMessage += str;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void logPluginException(String str) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null) {
            videoEventOnePlay.pluginException = 1;
            if (!TextUtils.isEmpty(str)) {
                this.mEvent.ownPlayerCreateException = str;
            }
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void renderSeekCompleted(int i) {
        _recordExitReason(-2002, false);
        this.mState = 2;
        this.mEventOneOpera.endSeek("wait", i);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setCurHost(String str) {
        if (this.mEventBase != null && str != null && !str.isEmpty()) {
            this.mEventBase.setCurHost(str);
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setCurIP(String str) {
        if (this.mEventBase != null && str != null && !str.isEmpty()) {
            this.mEventBase.setCurIP(str);
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setCurURL(String str) {
        if (this.mEventBase != null && str != null && !str.isEmpty()) {
            this.mEventBase.setCurURL(str);
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setDNSEndTime(long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null) {
            videoEventOnePlay.dns_end_t = j;
            if (this.mLeave && videoEventOnePlay.dnsModule == 0) {
                _recordExitReason(-1005, true);
            }
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setHijackCode(int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null && i != -1) {
            if (videoEventOnePlay.firstHijackCode == Integer.MIN_VALUE) {
                videoEventOnePlay.firstHijackCode = i;
            } else {
                videoEventOnePlay.lastHijackCode = i;
            }
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setPlaybackParams(PlaybackParams playbackParams) {
        if (this.mEvent == null) {
            return;
        }
        if (TTVideoEngine.sBuryDataOptimizeV2 == 0) {
            setPlaybackParamsOld(playbackParams);
        } else {
            setPlaybackParamsNew(playbackParams);
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setPrivateFieldFlag(Map<String, String> map) {
        int i;
        if (this.mEvent != null) {
            boolean containsKey = map.containsKey("Cookie");
            if (map.containsKey("X-Tt-Token")) {
                i = 2;
            } else {
                i = 0;
            }
            this.mEvent.privateFieldFlag = (containsKey ? 1 : 0) + i;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setSubTag(String str) {
        if (this.mEventBase != null && str != null && !str.isEmpty()) {
            this.mEventBase.mSubTag = str;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setSurface(String str) {
        if (TextUtils.isEmpty(this.mSurfaceCode)) {
            this.mSurfaceCode = str;
        }
        if (this.mSurfaceSetTime <= 0) {
            this.mSurfaceSetTime = System.currentTimeMillis();
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setTag(String str) {
        if (this.mEventBase != null && str != null && !str.isEmpty()) {
            this.mEventBase.mTag = str;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void showedFirstAVSyncVideoFrame(long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay.vt > 0 && videoEventOnePlay.v_first_sync_t <= 0) {
            videoEventOnePlay.v_first_sync_t = j;
        }
    }

    private void _setDefaultExitReason(int i) {
        if (i != 6 && i != 0) {
            if (i != 1 && i != 4 && i != 2 && i != 3 && i != 7) {
                if (i == 5) {
                    this.mLeaveReason = -1002;
                    return;
                }
                return;
            }
            this.mLeaveReason = -1004;
            return;
        }
        this.mLeaveReason = -1005;
    }

    private void callbackNoRenderEnd(int i) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("t", Long.valueOf(System.currentTimeMillis()));
        EventLoggerSource eventLoggerSource = this.mDataSource;
        if (eventLoggerSource != null) {
            eventLoggerSource.onInfo(6, hashMap);
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void AVOutSyncStart(int i) {
        long j;
        this.mAVOutSyncing = true;
        VideoEventOneEvent videoEventOneEvent = this.mEventOneEvent;
        long j2 = -1;
        if (videoEventOneEvent != null) {
            j = videoEventOneEvent.getLastRebufTime();
        } else {
            j = -1;
        }
        VideoEventOneOpera videoEventOneOpera = this.mEventOneOpera;
        if (videoEventOneOpera != null) {
            j2 = videoEventOneOpera.getLastSeekTime();
        }
        this.mEventOneOutSync.AVOutSyncStart(i, j, j2, this.mHeadsetStateHistory.getLastSwitchTime());
        if (this.mState == 2) {
            _recordExitReason(-2006, true);
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void logFirstError(Error error) {
        this.mFirstError = error;
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null && videoEventOnePlay.first_errc == Integer.MIN_VALUE && videoEventOnePlay.first_errt == Integer.MIN_VALUE && videoEventOnePlay.first_errc_internal == Integer.MIN_VALUE) {
            videoEventOnePlay.first_errt = error.getType();
            VideoEventOnePlay videoEventOnePlay2 = this.mEvent;
            videoEventOnePlay2.first_errc = error.code;
            videoEventOnePlay2.first_errc_internal = error.internalCode;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void onVideoInfoIdChanged(int i) {
        VideoInfo videoInfoByInfoId;
        IVideoModel iVideoModel = this.mVideoModel;
        if (iVideoModel != null && (videoInfoByInfoId = iVideoModel.getVideoInfoByInfoId(i)) != null) {
            int mediatype = videoInfoByInfoId.getMediatype();
            String valueStr = videoInfoByInfoId.getValueStr(6);
            if (mediatype == VideoRef.TYPE_AUDIO) {
                if ("dash".equals(valueStr) || "bash".equals(valueStr)) {
                    this.mEventBase.mCurDashAudioInfoId = i;
                }
            }
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setDnsMode(int i) {
        int i2;
        if (i != 1 && ((i == 0 || !this.mEventBase.mSourceTypeStr.equals("dir_url")) && (i2 = this.mEventBase.mEnableMDL) != 1 && i2 != 2)) {
            this.mEvent.dnsModule = 0;
        } else {
            this.mEvent.dnsModule = 1;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setVrDisplayDistance(float f) {
        HashMap hashMap = new HashMap(2);
        long currentTimeMillis = System.currentTimeMillis();
        hashMap.put("distc", Float.valueOf(f));
        hashMap.put("t", Long.valueOf(currentTimeMillis));
        this.mVrDistanceList.add(new JSONObject(hashMap).toString());
    }

    private void _upload(int i) {
        this.mEvent.leave_method = i;
        TimerTask timerTask = this.mTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.mTimerTask = null;
        }
        PortraitNetworkScore.BitrateCalculationTask bitrateCalculationTask = this.mBitrateCalculationTask;
        if (bitrateCalculationTask != null) {
            bitrateCalculationTask.cancel();
            this.mBitrateCalculationTask = null;
        }
        if (this.mEnableSpeedReport) {
            this.mEventSample.stopRecord();
        }
        _sendEvent();
        this.mEvent = new VideoEventOnePlay();
        this.mEventSample.mEventBase = this.mEventBase;
        this.mEventOneEvent.reset();
        this.mEventOneOpera.reset();
        this.mEventOneOutSync.reset();
        this.mEventAbrSwitch.reset();
    }

    private void setPlaybackParamsNew(PlaybackParams playbackParams) {
        int i;
        float speed = playbackParams.getSpeed();
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase.mPlaySpeed != speed) {
            videoEventBase.mPlaySpeed = speed;
            HashMap hashMap = new HashMap(3);
            EventLoggerSource eventLoggerSource = this.mDataSource;
            if (eventLoggerSource != null) {
                i = eventLoggerSource.getLogValueInt(67);
            } else {
                i = -1;
            }
            hashMap.put("to", Float.valueOf(this.mEventBase.mPlaySpeed));
            hashMap.put("p", Integer.valueOf(i));
            hashMap.put("t", Long.valueOf(System.currentTimeMillis()));
            TTVideoEngineUtils.addToList(this.mPlaySpeedList, new JSONObject(hashMap).toString());
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void AVNoRenderEnd(int i) {
        TTVideoEngineLog.d("VideoEventLoggerV2", "AVNoRenderEnd, type: " + i);
        if (!this.mEventOneNoRender.isStarted()) {
            TTVideoEngineLog.i("VideoEventLoggerV2", "AVNoRenderEnd, not started before, abort");
            return;
        }
        if (!this.mEventOneNoRender.isType(i)) {
            TTVideoEngineLog.i("VideoEventLoggerV2", "AVNoRenderEnd, type does not match, abort");
            return;
        }
        this.mEventOneNoRender.end(0, "wait");
        callbackNoRenderEnd(i);
        if (i == 0) {
            _recordExitReason(-2007, false);
        } else if (i == 1) {
            _recordExitReason(-2008, false);
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void movieFinish(int i) {
        long j;
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (i != 5) {
            if (this.mState == 4) {
                this.mEventOneOpera.endSeek("wait", 0);
                z = false;
            } else {
                z = true;
            }
            if (this.mState == 3) {
                this.mEventOneEvent.movieStallEnd("wait");
                this.mEvent.lastBufferEndT = currentTimeMillis;
                z = false;
            }
            if (z) {
                this.mEventBase.movieFinish();
            }
        }
        if (this.mAVOutSyncing) {
            EventLoggerSource eventLoggerSource = this.mDataSource;
            if (eventLoggerSource != null) {
                j = eventLoggerSource.getLogValueInt(67);
            } else {
                j = -1;
            }
            this.mEventOneOutSync.AVOutSyncEnd((int) j, "finish");
            this.mAVOutSyncing = false;
        }
        if (this.mLeave) {
            VideoEventOnePlay videoEventOnePlay = this.mEvent;
            if (videoEventOnePlay.vt <= 0) {
                videoEventOnePlay.lt = currentTimeMillis;
                _upload(i);
            }
        }
        this.mEvent.et = currentTimeMillis;
        _upload(i);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void movieStallEnd(int i) {
        if (i == 0 && this.mState == 3) {
            this.mState = 2;
            this.mEventOneEvent.movieStallEnd("wait");
        }
        if (this.mEvent == null) {
            return;
        }
        if (i == 0) {
            if (this.mState != 4) {
                _recordExitReason(-2003, false);
            }
        } else if (i == 1) {
            _recordExitReason(-2004, false);
        }
        long currentTimeMillis = System.currentTimeMillis();
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay.firstBufferEndT <= 0) {
            videoEventOnePlay.firstBufferEndT = currentTimeMillis;
        }
        if (i == 1) {
            long j = this.mDecodeBufferingStartT;
            if (j > 0 && currentTimeMillis >= j) {
                this.mCurDecoderBufferAccuT += currentTimeMillis - j;
                this.mDecodeBufferingStartT = 0L;
            }
        }
        videoEventOnePlay.lastBufferEndT = currentTimeMillis;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void onAVBadInterlaced(long j) {
        VideoEventOneEvent videoEventOneEvent = this.mEventOneEvent;
        if (videoEventOneEvent != null) {
            videoEventOneEvent.onAVBadInterlaced();
        }
        VideoEventOneOutSync videoEventOneOutSync = this.mEventOneOutSync;
        if (videoEventOneOutSync != null) {
            videoEventOneOutSync.onAVBadInterlaced();
        }
        VideoEventOneNoRender videoEventOneNoRender = this.mEventOneNoRender;
        if (videoEventOneNoRender != null) {
            videoEventOneNoRender.onAVBadInterlaced();
        }
        HashMap hashMap = new HashMap(3);
        hashMap.put("pts", "-1");
        hashMap.put("type", "non");
        hashMap.put("diff", Long.toString(j));
        TTVideoEngineUtils.addToList(this.mAVBadInterlacedList, new JSONObject(hashMap).toString());
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void play(boolean z) {
        int i;
        EventLoggerSource eventLoggerSource = this.mDataSource;
        if (eventLoggerSource != null) {
            i = eventLoggerSource.getLogValueInt(67);
        } else {
            i = -1;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("p", Integer.valueOf(i));
        hashMap.put("t", Long.valueOf(System.currentTimeMillis()));
        TTVideoEngineUtils.addToList(this.mPlayList, new JSONObject(hashMap).toString());
        if (z && enableReport(4)) {
            this.mBrightMonitor.setPlaying(true);
            this.mBrightMonitor.start();
        }
        this.mViewSizeMonitor.tryAddLastSizeToHistory();
        if (enableReport(8)) {
            this.mHeadsetStateMonitor.start();
            this.mHeadsetStateHistory.start();
        }
        if (z) {
            VideoEventOnePlay videoEventOnePlay = this.mEvent;
            if (videoEventOnePlay.mInBackgroundWhenPlay == Integer.MIN_VALUE) {
                videoEventOnePlay.mInBackgroundWhenPlay = this.mDataSource.getLogValueInt(94);
            }
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setEffect(Bundle bundle) {
        this.mFilterMonitor.setEffect(bundle);
        long currentTimeMillis = System.currentTimeMillis();
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putLong("time", currentTimeMillis);
        this.mTrEffectList.add(bundle2.toString());
        if (bundle != null && bundle.getInt("effect_type") == 8) {
            int i = bundle.getInt("vr_model");
            int i2 = bundle.getInt("view_size");
            int i3 = bundle.getInt("video_style");
            this.mVRTracker.setVideoStyle(1);
            this.mVRTracker.setViewSize(i2);
            this.mVRTracker.setDimension(i3);
            this.mVRTracker.setProjectStyle(i);
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setInitialResolution(String str) {
        this.mInitialResolution = str;
        HashMap hashMap = new HashMap(5);
        hashMap.put("to", str);
        hashMap.put("p", -1);
        hashMap.put("t", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("c", 0);
        hashMap.put("seam", Boolean.FALSE);
        TTVideoEngineUtils.addToList(this.mResolutionList, new JSONObject(hashMap).toString());
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setLoggerTimes(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        switch (i) {
            case 63:
                if (this.setds_t <= 0) {
                    this.setds_t = currentTimeMillis;
                    break;
                }
                break;
            case 64:
                VideoEventOnePlay videoEventOnePlay = this.mEvent;
                if (videoEventOnePlay.pt_new <= 0) {
                    videoEventOnePlay.pt_new = currentTimeMillis;
                    break;
                }
                break;
            case 65:
                if (this.prepare_before_play_t <= 0) {
                    this.prepare_before_play_t = currentTimeMillis;
                    break;
                }
                break;
            default:
                switch (i) {
                    case 169:
                        VideoEventOneOpera videoEventOneOpera = this.mEventOneOpera;
                        if (videoEventOneOpera != null) {
                            videoEventOneOpera.setSeekCompleteTime(currentTimeMillis);
                            break;
                        }
                        break;
                    case 170:
                        VideoEventOneOpera videoEventOneOpera2 = this.mEventOneOpera;
                        if (videoEventOneOpera2 != null) {
                            videoEventOneOpera2.setSeekLoadingBeginTime(currentTimeMillis);
                            break;
                        }
                        break;
                    case 171:
                        VideoEventOneOpera videoEventOneOpera3 = this.mEventOneOpera;
                        if (videoEventOneOpera3 != null) {
                            videoEventOneOpera3.setSeekLoadingEndTime(currentTimeMillis);
                            break;
                        }
                        break;
                }
        }
    }

    private void setPlaybackParamsOld(PlaybackParams playbackParams) {
        int i;
        float speed = playbackParams.getSpeed();
        HashMap hashMap = new HashMap(3);
        hashMap.put("AFMode", Integer.valueOf(playbackParams.getAudioFallbackMode()));
        hashMap.put("pitch", Float.valueOf(playbackParams.getPitch()));
        hashMap.put("speed", Float.valueOf(speed));
        this.mPlaybackParams = hashMap;
        if (this.mEventBase.mPlaySpeed != speed || this.mPlaySpeedList.isEmpty()) {
            this.mEventBase.mPlaySpeed = speed;
            HashMap hashMap2 = new HashMap(3);
            EventLoggerSource eventLoggerSource = this.mDataSource;
            if (eventLoggerSource != null) {
                i = eventLoggerSource.getLogValueInt(67);
            } else {
                i = -1;
            }
            hashMap2.put("to", Float.valueOf(this.mEventBase.mPlaySpeed));
            hashMap2.put("p", Integer.valueOf(i));
            hashMap2.put("t", Long.valueOf(System.currentTimeMillis()));
            TTVideoEngineUtils.addToList(this.mPlaySpeedList, new JSONObject(hashMap2).toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void stop(int r12) {
        /*
            r11 = this;
            com.ss.ttvideoengine.log.BrightnessMonitor r0 = r11.mBrightMonitor
            r0.stop()
            com.ss.ttvideoengine.log.HeadsetStateHistory r0 = r11.mHeadsetStateHistory
            r0.stop()
            int r0 = r11.mState
            if (r0 != 0) goto Lf
            return
        Lf:
            long r0 = java.lang.System.currentTimeMillis()
            int r2 = r11.mState
            r3 = 4
            java.lang.String r4 = "exit"
            r5 = 0
            if (r2 != r3) goto L22
            com.ss.ttvideoengine.log.VideoEventOneOpera r2 = r11.mEventOneOpera
            r2.endSeek(r4, r5)
            r2 = 0
            goto L23
        L22:
            r2 = 1
        L23:
            int r3 = r11.mState
            r6 = 3
            if (r3 != r6) goto L32
            com.ss.ttvideoengine.log.VideoEventOneEvent r2 = r11.mEventOneEvent
            r2.movieStallEnd(r4)
            com.ss.ttvideoengine.log.VideoEventOnePlay r2 = r11.mEvent
            r2.lastBufferEndT = r0
            r2 = 0
        L32:
            r11.mState = r5
            boolean r3 = r11.mLeave
            r6 = 0
            if (r3 == 0) goto L51
            com.ss.ttvideoengine.log.VideoEventOnePlay r3 = r11.mEvent
            long r8 = r3.pt_new
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 <= 0) goto L51
            long r8 = r3.vt
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 > 0) goto L51
            long r8 = r3.lt
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 > 0) goto L55
            r3.lt = r0
            goto L55
        L51:
            com.ss.ttvideoengine.log.VideoEventOnePlay r3 = r11.mEvent
            r3.et = r0
        L55:
            if (r2 == 0) goto L5c
            com.ss.ttvideoengine.log.VideoEventBase r0 = r11.mEventBase
            r0.movieFinish()
        L5c:
            boolean r0 = r11.mAVOutSyncing
            if (r0 == 0) goto L76
            com.ss.ttvideoengine.log.EventLoggerSource r0 = r11.mDataSource
            if (r0 == 0) goto L6c
            r1 = 67
            int r0 = r0.getLogValueInt(r1)
            long r0 = (long) r0
            goto L6e
        L6c:
            r0 = -1
        L6e:
            com.ss.ttvideoengine.log.VideoEventOneOutSync r2 = r11.mEventOneOutSync
            int r1 = (int) r0
            r2.AVOutSyncEnd(r1, r4)
            r11.mAVOutSyncing = r5
        L76:
            com.ss.ttvideoengine.log.VideoEventOnePlay r0 = r11.mEvent
            long r0 = r0.playerFirstFrameT
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 > 0) goto L88
            java.util.Map r0 = r11._getFirstFrameSplitInfo()
            com.ss.ttvideoengine.log.EventLoggerSource r1 = r11.mDataSource
            r2 = 2
            r1.onInfo(r2, r0)
        L88:
            r11._upload(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.log.VideoEventLoggerV2.stop(int):void");
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void switchResolutionEnd(boolean z) {
        int i;
        if (z) {
            if (this.mState == 4) {
                this.mEventOneOpera.endSeek("wait", 0);
            }
            if (this.mState == 3) {
                this.mState = 2;
            }
        }
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null) {
            videoEventOnePlay.lastResolutionEndT = System.currentTimeMillis();
            VideoEventOnePlay videoEventOnePlay2 = this.mEvent;
            long j = videoEventOnePlay2.lastResolutionStartT;
            if (j > 0) {
                long j2 = videoEventOnePlay2.lastResolutionEndT - j;
                EventLoggerSource eventLoggerSource = this.mDataSource;
                if (eventLoggerSource != null) {
                    i = eventLoggerSource.getLogValueInt(67);
                } else {
                    i = -1;
                }
                HashMap hashMap = new HashMap(5);
                hashMap.put("to", this.mEventBase.mCurrentResolution);
                hashMap.put("p", Integer.valueOf(i));
                hashMap.put("t", Long.valueOf(System.currentTimeMillis()));
                hashMap.put("c", Long.valueOf(j2));
                hashMap.put("seam", Boolean.valueOf(z));
                TTVideoEngineUtils.addToList(this.mResolutionList, new JSONObject(hashMap).toString());
            }
        }
        if (z) {
            _recordExitReason(-2005, false);
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void fetchInfoComplete(VideoModel videoModel, Error error) {
        fetchInfoComplete((IVideoModel) videoModel, error);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void abrEventStart(long j, long j2) {
        this.mEventAbrSwitch.abrSwitchStart(j, j2);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void configResolution(String str, String str2) {
        this.mEventBase.configResolution(str, str2);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setAudioDNSParseTime(long j, int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        videoEventOnePlay.audioDnsT = j;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setPlayAPIVersion(int i, String str) {
        this.mApiVer = i;
        this.mAuth = str;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setPlayerViewSize(int i, int i2) {
        this.mViewSizeMonitor.setSize(i, i2);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void useAsyncInit(int i, int i2) {
        this.mAsyncInit = i;
        this.mAsyncCodecId = i2;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void crosstalkHappen(int i, ArrayList arrayList) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        videoEventOnePlay.mCrosstalkCount = i;
        videoEventOnePlay.mCrosstalkInfoList = arrayList;
        _recordExitReason(-2009, true);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void codecName(int i, int i2) {
        if (this.mEvent == null) {
            return;
        }
        if (i != 0) {
            if (i == 1) {
                this.mEventBase.audioCodecNameId = i2;
                return;
            }
            return;
        }
        this.mEventBase.videoCodecNameId = i2;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void deviceStartTime(int i, long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        if (i != 0) {
            if (i == 1) {
                videoEventOnePlay.audioDeviceStartTime = j;
                return;
            }
            return;
        }
        videoEventOnePlay.videoDeviceStartTime = j;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void devicedOpenedTime(int i, long j) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        if (i != 0) {
            if (i == 1) {
                videoEventOnePlay.audioDeviceOpenedTime = j;
                return;
            }
            return;
        }
        videoEventOnePlay.videoDeviceOpenedTime = j;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void needRetryToFetch(Error error, int i) {
        HashMap map = error.toMap();
        map.put("apiver", Integer.valueOf(i));
        this.mRetryFetchErrorInfo.add(map);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void recordBlockReason(int i, boolean z) {
        if (this.mEvent == null) {
            return;
        }
        if (z) {
            this.mLeaveReason = i;
            this.mBlockBeginT = SystemClock.elapsedRealtime();
        } else {
            this.mLeaveReason = Integer.MIN_VALUE;
            this.mBlockBeginT = -2147483648L;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setDNSParseTime(long j, int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null && videoEventOnePlay.dnsT <= 0) {
            videoEventOnePlay.dnsT = j;
            videoEventOnePlay.dnsModule = i;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setDNSStartTime(long j, int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null) {
            videoEventOnePlay.dns_start_t = j;
            videoEventOnePlay.dnsModule = i;
            if (this.mLeave && i == 0) {
                _recordExitReason(-1004, true);
            }
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setNetworkSpeedFrom(double d, int i) {
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay == null) {
            return;
        }
        if (i != 0) {
            if (i == 1) {
                videoEventOnePlay.playEndSpeed = d;
                return;
            }
            return;
        }
        videoEventOnePlay.firstFrameSpeed = d;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setSourceType(int i, String str) {
        if (i == 0) {
            this.mIsLocal = true;
        }
        this.mEventBase.setSourceType(i, str);
        this.mPlayCount = 0;
        _setDefaultExitReason(i);
    }

    public static void addFeatureGlobal(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            sFeatures.put(str, obj);
            TTVideoEngineLog.d("VideoEventLoggerV2", "addFeatureGlobal, key:" + str + ", value:" + obj);
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void addFeature(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.mFeatures.put(str, obj);
            TTVideoEngineLog.d("VideoEventLoggerV2", "addFeature, key:" + str + ", value:" + obj);
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void fetchInfoComplete(IVideoModel iVideoModel, Error error) {
        if (iVideoModel != null) {
            updateVideoInfo(iVideoModel);
            VideoEventOnePlay videoEventOnePlay = this.mEvent;
            if (videoEventOnePlay.vt <= 0) {
                videoEventOnePlay.at = System.currentTimeMillis();
            }
            this.mFetchComplete = true;
            int i = this.mEvent.dnsModule;
            if (i == 1) {
                _recordExitReason(-1005, true);
            } else if (i == 0) {
                _recordExitReason(-1004, true);
            }
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void movieFinish(int i, String str) {
        boolean z;
        boolean z2 = false;
        if (this.mState == 4) {
            this.mEventOneOpera.endSeek("error", 0);
            z = false;
        } else {
            z = true;
        }
        if (this.mState == 3) {
            this.mEventOneEvent.movieStallEnd("error");
            this.mEvent.lastBufferEndT = System.currentTimeMillis();
        } else {
            z2 = z;
        }
        this.mState = 5;
        if (z2) {
            this.mEventBase.movieFinish();
        }
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        videoEventOnePlay.vsc = i;
        videoEventOnePlay.vscMessage = str;
        movieFinish(5);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setInitialURL(String str, String str2) {
        TTVideoEngineLog.d("VideoEventLoggerV2", "setInitialURL " + str);
        this.mInitialURL = str;
        VideoEventBase videoEventBase = this.mEventBase;
        if (videoEventBase != null) {
            videoEventBase.mInitialURL = str;
        }
        this.mAudioInitURL = str2;
    }

    public void _recordExitReason(int i, boolean z) {
        if (this.mEvent == null) {
            return;
        }
        if (z) {
            this.mLeaveReason = i;
            if (i != -1002 && i != -1003 && i != -1004 && i != -1005) {
                if (i != -2003 && i != -2002) {
                    this.mBlockBeginT = -2147483648L;
                    return;
                } else {
                    this.mBlockBeginT = SystemClock.elapsedRealtime();
                    return;
                }
            }
            if (this.mBlockBeginT <= 0) {
                this.mBlockBeginT = SystemClock.elapsedRealtime();
                return;
            }
            return;
        }
        this.mLeaveReason = -2001;
        this.mBlockBeginT = -2147483648L;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void movieStalled(int i, int i2) {
        TTVideoEngineLog.i("VideoEventLoggerV2", "movieStalled, type: " + i);
        if (i == 0) {
            int i3 = this.mState;
            if (i3 != 3 && i3 != 4) {
                this.mState = 3;
                int i4 = this.mNetBufferIndex + 1;
                this.mNetBufferIndex = i4;
                this.mEventOneEvent.movieStalled(i2, i4);
            }
            this.mCurBufferCount++;
            if (this.mState != 4) {
                _recordExitReason(-2003, true);
            }
        } else if (i == 1) {
            this.mCurDecoderBufferCount++;
            _recordExitReason(-2004, true);
        }
        if (this.mEvent == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay.firstBufferStartT <= 0) {
            videoEventOnePlay.firstBufferStartT = currentTimeMillis;
        }
        if (i == 1) {
            this.mDecodeBufferingStartT = currentTimeMillis;
        }
        videoEventOnePlay.lastBufferStartT = currentTimeMillis;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setFloatOption(int i, float f) {
        if (i != 20) {
            if (i != 162) {
                if (i != 164) {
                    if (i != 166) {
                        if (i != 167) {
                            switch (i) {
                                case 188:
                                    this.mEvent.mTargetLoudness = f;
                                    break;
                                case 189:
                                    this.mEvent.mSmallSplTargetLoudness = f;
                                    break;
                                case 190:
                                    this.mEvent.mMediumSplTargetLoudness = f;
                                    break;
                                case 191:
                                    this.mEvent.mLargeSplTargetLoudness = f;
                                    break;
                            }
                        }
                        this.mSrMonitor.setProccessSuccessRate(f);
                        return;
                    }
                    this.mSrMonitor.setProcessorAverageCostTime(f);
                    return;
                }
                this.mEvent.mTrEffectChainAverageTime = Float.valueOf(f);
                return;
            }
            this.mEvent.mTrFPS = Float.valueOf(f);
            return;
        }
        this.mNetworkSpeedPredictSamplingRate = f;
        this.mEventSample.setSamplingRate(f);
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setCustomInfo(IVideoEventLogger.VideoEventCustomInfo videoEventCustomInfo, Object obj) {
        TTVideoEngineLog.d("VideoEventLoggerV2", "brian setCustomInfo key:" + videoEventCustomInfo + ", value:" + obj);
        if (this.mEvent != null) {
            try {
                switch (AnonymousClass2.$SwitchMap$com$ss$ttvideoengine$log$IVideoEventLogger$VideoEventCustomInfo[videoEventCustomInfo.ordinal()]) {
                    case 1:
                        this.mCustomClickT = ((Long) obj).longValue();
                        break;
                    case 2:
                        this.mCustomGetVideoModelT = ((Long) obj).longValue();
                        break;
                    case 3:
                        break;
                    case 4:
                        this.mCustomInitEngineT = ((Long) obj).longValue();
                        break;
                    case 5:
                        this.mCustomPlayEngineT = ((Long) obj).longValue();
                        break;
                    case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                        if (obj instanceof HashMap) {
                            this.mCastObject = (HashMap) obj;
                            break;
                        }
                        break;
                    case 7:
                        this.mOttPluginVersion = ((Integer) obj).intValue();
                        break;
                    case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                        this.mCompanyID = (String) obj;
                        break;
                    case 9:
                        this.mEvent.mCustomPlaySessionId = (String) obj;
                        break;
                    default:
                        TTVideoEngineLog.e("VideoEventLoggerV2", "setCustomInfo invalid key:" + videoEventCustomInfo + ", value:" + obj);
                        break;
                }
            } catch (Exception e) {
                TTVideoEngineLog.e("VideoEventLoggerV2", "setCustomInfo fail:" + e.toString());
            }
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setStringOption(int i, String str) {
        switch (i) {
            case 15:
                this.mEvent.log_id = str;
                break;
            case ITTVideoEngineInternal.PLAYER_OPTION_GET_WATCHED_DUTATION /* 53 */:
                this.mEventBase.mOriginVid = str;
                break;
            case 86:
                this.mEventBase.mDNSType = str;
                break;
            case 113:
                PortraitNetworkScore.NetworkQualityAlgorithm networkQualityAlgorithm = this.mNetworkQualityAlgorithm;
                if (networkQualityAlgorithm != null) {
                    networkQualityAlgorithm.setStringOption(4, str);
                    break;
                } else {
                    this.mNetworkQualityVar = str;
                    break;
                }
            case 135:
                try {
                    this.mEvent.mSRStrategyInfo.put("sc", new JSONObject(str));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case 141:
                this.mEvent.mGearStrategyInfo.put("headers", str);
                break;
            case 146:
                this.mMaskFileHash = str;
                break;
            case 151:
                try {
                    this.mEvent.mSRStrategyInfo.put("smi", new JSONArray(str));
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case 152:
                this.mEvent.mVideoFileHash = str;
                break;
            case 153:
                this.mEvent.mAudioFileHash = str;
                break;
            case 154:
                this.mEventBase.mMediaID = str;
                break;
            case 156:
                this.mEvent.mMDLGroupId = str;
                break;
            case 161:
                this.mEvent.mTrVersion = str;
                break;
            case 163:
                this.mTrPerEffectAverageTime = str;
                break;
            case 165:
                this.mTrEffectErrorCode = str;
                break;
            case 176:
                this.mEvent.mMdlInitializeError = str;
                break;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void AVNoRenderStart(int i, int i2) {
        long j;
        long j2;
        TTVideoEngineLog.d("VideoEventLoggerV2", "AVNoRenderStart, type: " + i + ", reason: " + i2);
        if (this.mEventOneNoRender.isStarted()) {
            this.mEventOneNoRender.updateReason(i2);
            TTVideoEngineLog.d("VideoEventLoggerV2", "AVNoRenderStart event is already started, abort");
            return;
        }
        VideoEventOneEvent videoEventOneEvent = this.mEventOneEvent;
        long j3 = -1;
        if (videoEventOneEvent != null) {
            j = videoEventOneEvent.getLastRebufTime();
        } else {
            j = -1;
        }
        VideoEventOneOpera videoEventOneOpera = this.mEventOneOpera;
        if (videoEventOneOpera != null) {
            j2 = videoEventOneOpera.getLastSeekTime();
        } else {
            j2 = -1;
        }
        this.mEventOneNoRender.start(i, i2, 0, j, j2, this.mHeadsetStateHistory.getLastSwitchTime());
        String renderStageError = this.mEventOneNoRender.getRenderStageError();
        if (!TextUtils.isEmpty(renderStageError)) {
            this.mEvent.mRenderStageError = renderStageError;
        }
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        long j4 = videoEventOnePlay.vt;
        if (j4 > 0) {
            j3 = j4 - videoEventOnePlay.pt_new;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("t", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("codec", this.mEventBase.getCodecType());
        hashMap.put("resolution", this.mEventBase.getCurResolution());
        hashMap.put("quality_desc", this.mEventBase.mCurrentQualityDesc);
        hashMap.put("hw", Integer.valueOf(this.mEventBase.mVideoHW));
        hashMap.put("ps_t", Long.valueOf(this.ps_t));
        hashMap.put("first_frame_cost", Long.valueOf(j3));
        long j5 = this.mEvent.lastSeekStartT;
        if (j5 != -2147483648L) {
            hashMap.put("seek_t", Long.valueOf(j5));
        }
        EventLoggerSource eventLoggerSource = this.mDataSource;
        if (eventLoggerSource != null) {
            hashMap.put("enable_nnsr", Integer.valueOf(eventLoggerSource.getLogValueInt(101)));
            hashMap.put("surface_error_code", Integer.valueOf(this.mDataSource.getLogValueInt(100)));
            hashMap.put("switch_resolution_t", Long.valueOf(this.mDataSource.getLogValueLong(92)));
            this.mDataSource.onInfo(5, hashMap);
        }
        if (i == 0) {
            _recordExitReason(-2007, true);
        } else if (i == 1) {
            _recordExitReason(-2008, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void movieFinish(com.ss.ttvideoengine.utils.Error r17, int r18) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.log.VideoEventLoggerV2.movieFinish(com.ss.ttvideoengine.utils.Error, int):void");
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setLongOption(int i, long j) {
        if (i != 21) {
            if (i != 56) {
                if (i != 101) {
                    if (i != 103) {
                        if (i != 147) {
                            if (i != 87) {
                                if (i != 88) {
                                    if (i != 98) {
                                        if (i != 99) {
                                            if (i != 136) {
                                                if (i != 137) {
                                                    switch (i) {
                                                        case 66:
                                                            this.mEvent.a_dns_start_t = j;
                                                            break;
                                                        case 67:
                                                            this.mEvent.formater_create_t = j;
                                                            break;
                                                        case 68:
                                                            this.mEvent.avformat_open_t = j;
                                                            break;
                                                        case 69:
                                                            this.mEvent.demuxer_create_t = j;
                                                            break;
                                                        case 70:
                                                            this.mEvent.dec_create_t = j;
                                                            break;
                                                        case 71:
                                                            this.mEvent.outlet_create_t = j;
                                                            break;
                                                        case 72:
                                                            this.mEvent.v_dec_start_t = j;
                                                            break;
                                                        case 73:
                                                            this.mEvent.a_dec_start_t = j;
                                                            break;
                                                        case 74:
                                                            this.mEvent.v_dec_opened_t = j;
                                                            break;
                                                        case 75:
                                                            this.mEvent.a_dec_opened_t = j;
                                                            break;
                                                        case 76:
                                                            this.mEvent.v_render_f_t = j;
                                                            break;
                                                        case 77:
                                                            this.mEvent.a_render_f_t = j;
                                                            break;
                                                        case 78:
                                                            this.mEvent.demuxer_begin_t = j;
                                                            break;
                                                        default:
                                                            switch (i) {
                                                                case 82:
                                                                    this.mEvent.sub_load_finish_t = j;
                                                                    break;
                                                                case 83:
                                                                    this.mEvent.sub_req_finish_t = j;
                                                                    break;
                                                                case 84:
                                                                    this.mEvent.mask_open_t = j;
                                                                    break;
                                                                case 85:
                                                                    this.mEvent.mask_opened_t = j;
                                                                    break;
                                                                default:
                                                                    switch (i) {
                                                                        case 105:
                                                                            this.mEvent.mGearStrategyInfo.put("gs_select_begin", Long.valueOf(j));
                                                                            break;
                                                                        case 106:
                                                                            this.mEvent.mGearStrategyInfo.put("gs_select_end", Long.valueOf(j));
                                                                            break;
                                                                        case 107:
                                                                            this.mEvent.mGearStrategyInfo.put("gs_on_before_begin", Long.valueOf(j));
                                                                            break;
                                                                        case 108:
                                                                            this.mEvent.mGearStrategyInfo.put("gs_on_before_end", Long.valueOf(j));
                                                                            break;
                                                                        case 109:
                                                                            this.mEvent.mGearStrategyInfo.put("gs_on_after_begin", Long.valueOf(j));
                                                                            break;
                                                                        case 110:
                                                                            this.mEvent.mGearStrategyInfo.put("gs_on_after_end", Long.valueOf(j));
                                                                            break;
                                                                        default:
                                                                            switch (i) {
                                                                                case 120:
                                                                                    this.mEvent.v_http_open_t = j;
                                                                                    break;
                                                                                case 121:
                                                                                    this.mEvent.a_http_open_t = j;
                                                                                    break;
                                                                                case 122:
                                                                                    this.mEvent.v_tran_open_t = j;
                                                                                    break;
                                                                                case 123:
                                                                                    this.mEvent.a_tran_open_t = j;
                                                                                    break;
                                                                                case 124:
                                                                                    this.mEvent.v_sock_create_t = j;
                                                                                    break;
                                                                                case 125:
                                                                                    this.mEvent.a_sock_create_t = j;
                                                                                    break;
                                                                            }
                                                                    }
                                                            }
                                                    }
                                                }
                                                this.mEvent.mSRStrategyInfo.put("bad", Long.valueOf(j));
                                                return;
                                            }
                                            this.mEvent.mSRStrategyInfo.put("bbd", Long.valueOf(j));
                                            return;
                                        }
                                        this.mEvent.mAudioStreamDuration = j;
                                        this.mEventOneOutSync.mAudioStreamDuration = j;
                                        return;
                                    }
                                    this.mEvent.mVideoStreamDuration = j;
                                    this.mEventOneOutSync.mVideoStreamDuration = j;
                                    return;
                                }
                                this.mEvent.player_prepared_time = j;
                                return;
                            }
                            this.mEvent.httpResponseT = j;
                            return;
                        }
                        this.mMaskFileSize = j;
                        return;
                    }
                    this.mEvent.mGearStrategyInfo.put("gs_speed", Long.valueOf(j));
                    return;
                }
                this.mEvent.mGearStrategyInfo.put("gs_bitrate", Long.valueOf(j));
                return;
            }
            this.mAudioBitrate = j;
            return;
        }
        this.mBitrate = j;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void setIntOption(int i, int i2) {
        int i3;
        if (i == 54) {
            this.mFeatureConfigs.mAEType = i2;
            return;
        }
        if (i == 55) {
            this.mFeatureConfigs.mEnableNativeYV12 = i2;
            return;
        }
        if (i != 59) {
            if (i != 60) {
                if (i != 111) {
                    boolean z = false;
                    if (i != 112) {
                        if (i != 126) {
                            if (i == 127) {
                                this.mFeatureConfigs.mEnableGearStrategy = i2;
                                return;
                            }
                            switch (i) {
                                case 11:
                                    this.mRadioMode = i2;
                                    break;
                                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                                    if (i2 == 1) {
                                        z = true;
                                    }
                                    this.mVideoStreamDisabled = z;
                                    break;
                                case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                                    if (i2 == 1) {
                                        z = true;
                                    }
                                    this.mAudioStreamDisabled = z;
                                    break;
                                case 14:
                                    this.mIsReplay = i2;
                                    break;
                                default:
                                    switch (i) {
                                        case 16:
                                            this.mEventBase.mAudioHwUser = i2;
                                            break;
                                        case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                                            this.mEventSample.setInterval(i2);
                                            break;
                                        case 18:
                                            if (i2 != 0) {
                                                this.mEnableSpeedReport = true;
                                                this.mEventSample.startRecord();
                                                break;
                                            } else {
                                                this.mEnableSpeedReport = false;
                                                this.mEventSample.stopRecord();
                                                break;
                                            }
                                        case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                                            this.mEventSample.setMaxWindowSize(i2);
                                            break;
                                        default:
                                            switch (i) {
                                                case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                                                    this.mNetLevelIntervalMs = i2;
                                                    break;
                                                case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                                                    this.mNetLevelMaxCount = i2;
                                                    break;
                                                case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                                                    this.mBufferTimeout = i2;
                                                    break;
                                                case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                                                    this.mNetworkTimeout = i2;
                                                    break;
                                                case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                                                    this.mFeatureConfigs.mEnableBufferDirectly = i2;
                                                    break;
                                                case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                                                    this.mFeatureConfigs.mFirstBufEndMs = i2;
                                                    break;
                                                default:
                                                    switch (i) {
                                                        case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                                                            this.mFeatureConfigs.mEnableVolumeBalance = i2;
                                                            break;
                                                        case 30:
                                                            this.mFeatureConfigs.mEnableEngineLooper = i2;
                                                            break;
                                                        case 31:
                                                            this.mFeatureConfigs.mEnableAutoRange = i2;
                                                            break;
                                                        case ConstantsAPI.COMMAND_PRELOAD_MINI_PROGRAM_ENVIRONMENT /* 32 */:
                                                            this.mFeatureConfigs.mEnableHwDropNonRef = i2;
                                                            break;
                                                        case ConstantsAPI.COMMAND_FINDER_SHARE_VIDEO /* 33 */:
                                                            this.mFeatureConfigs.mEnableHttps = i2;
                                                            break;
                                                        case ConstantsAPI.COMMAND_FINDER_OPEN_PROFILE /* 34 */:
                                                            this.mFeatureConfigs.mEnableFallbackApi = i2;
                                                            break;
                                                        case ConstantsAPI.COMMAND_FINDER_OPEN_LIVE /* 35 */:
                                                            this.mFeatureConfigs.mEnableAsyncPosition = i2;
                                                            break;
                                                        case ConstantsAPI.COMMAND_FINDER_OPEN_FEED /* 36 */:
                                                            this.mFeatureConfigs.mEnableLoadControl = i2;
                                                            break;
                                                        case ConstantsAPI.COMMAND_OPEN_CUSTOMER_SERVICE_CHAT /* 37 */:
                                                            this.mFeatureConfigs.mRenderType = i2;
                                                            break;
                                                        case ConstantsAPI.COMMAND_OPEN_QRCODE_PAY /* 38 */:
                                                            this.mFeatureConfigs.mImageScaleType = i2;
                                                            break;
                                                        case ConstantsAPI.COMMAND_FINDER_START_LIVE /* 39 */:
                                                            this.mFeatureConfigs.mAudioRenderType = i2;
                                                            break;
                                                        case 40:
                                                            this.mFeatureConfigs.mSkipFindStreamInfo = i2;
                                                            break;
                                                        case ConstantsAPI.COMMAND_FINDER_OPEN_EVENT /* 41 */:
                                                            this.mFeatureConfigs.mEnableAsyncPrepare = i2;
                                                            break;
                                                        case 42:
                                                            this.mFeatureConfigs.mCodecFrcLevel = i2;
                                                            break;
                                                        case 43:
                                                            this.mFeatureConfigs.mEnableLazySeek = i2;
                                                            break;
                                                        case 44:
                                                            this.mFeatureConfigs.mKeepFormatThreadAlive = i2;
                                                            break;
                                                        case 45:
                                                            HashMap hashMap = new HashMap(3);
                                                            EventLoggerSource eventLoggerSource = this.mDataSource;
                                                            if (eventLoggerSource != null) {
                                                                i3 = eventLoggerSource.getLogValueInt(67);
                                                            } else {
                                                                i3 = -1;
                                                            }
                                                            hashMap.put("s", Integer.valueOf(i2));
                                                            hashMap.put("p", Integer.valueOf(i3));
                                                            hashMap.put("t", Long.valueOf(System.currentTimeMillis()));
                                                            TTVideoEngineUtils.addToList(this.mRadiomodeList, new JSONObject(hashMap).toString());
                                                            break;
                                                        case 46:
                                                            this.mEnableMaskThread = i2;
                                                            break;
                                                        case 47:
                                                            this.mEnableSubThread = i2;
                                                            break;
                                                        case 48:
                                                            this.mEnableMask = i2;
                                                            break;
                                                        case 49:
                                                            this.mEnableSub = i2;
                                                            break;
                                                        case 50:
                                                            this.mEnableOptSubLoad = i2;
                                                            break;
                                                        case 62:
                                                            this.mModelVersion = i2;
                                                            break;
                                                        case 100:
                                                            this.mReportLevel = i2;
                                                            this.mEventOneOpera.mReportSeek = enableReport(1);
                                                            break;
                                                        case 102:
                                                            this.mEvent.mGearStrategyInfo.put("gs_reason", Integer.valueOf(i2));
                                                            break;
                                                        case 104:
                                                            this.mEvent.mGearStrategyInfo.put("gs_error", Integer.valueOf(i2));
                                                            break;
                                                        case 132:
                                                            this.mEngineHash = i2;
                                                            break;
                                                        case 133:
                                                            this.mEvent.mSRStrategyInfo.put("ess", Integer.valueOf(i2));
                                                            this.mFeatureConfigs.mEnableSRStrategy = i2;
                                                            break;
                                                        case 134:
                                                            this.mEvent.mSRStrategyInfo.put("eas", Integer.valueOf(i2));
                                                            break;
                                                        case 138:
                                                            this.mEvent.mSRStrategyInfo.put("ss", Integer.valueOf(i2));
                                                            break;
                                                        case 139:
                                                            this.mEvent.mSRStrategyInfo.put("sfr", Integer.valueOf(i2));
                                                            break;
                                                        case 140:
                                                            this.mEvent.mSRStrategyInfo.put("sm", Integer.valueOf(i2));
                                                            break;
                                                        case 142:
                                                            this.mEvent.mExpirePlayCode = i2;
                                                            break;
                                                        case 143:
                                                            this.mMaskRangeOpt = i2;
                                                            break;
                                                        case 144:
                                                            this.mMaskEnableDataloader = i2;
                                                            break;
                                                        case 145:
                                                            this.mMaskDelayLoading = i2;
                                                            break;
                                                        case 148:
                                                            this.mEvent.mSRStrategyInfo.put("srs", Integer.valueOf(i2));
                                                            break;
                                                        case 149:
                                                            this.mEvent.mSRStrategyInfo.put("sut", Integer.valueOf(i2));
                                                            break;
                                                        case 150:
                                                            this.mEvent.mSRStrategyInfo.put("so", Integer.valueOf(i2));
                                                            break;
                                                        case 155:
                                                            VideoEventOneOpera videoEventOneOpera = this.mEventOneOpera;
                                                            if (videoEventOneOpera != null) {
                                                                videoEventOneOpera.setLoadTypeWhenSeek(i2);
                                                                break;
                                                            }
                                                            break;
                                                        case 172:
                                                            VideoEventOnePlay videoEventOnePlay = this.mEvent;
                                                            if (i2 == 1) {
                                                                z = true;
                                                            }
                                                            videoEventOnePlay.mVModelHasFallbackApi = z;
                                                            break;
                                                        case 173:
                                                            this.mEvent.enableMDLOnFirstPlay = i2;
                                                            break;
                                                        case 174:
                                                            this.mEvent.mMdlInvalidCode = i2;
                                                            break;
                                                        case 175:
                                                            this.mEvent.mMdlInitializeState = i2;
                                                            break;
                                                        case 177:
                                                            if (i2 > 0) {
                                                                z = true;
                                                            }
                                                            this.mNetSpeedForAudio = z;
                                                            break;
                                                        case 178:
                                                            this.mEvent.mVideoAbnormalCode = i2;
                                                            break;
                                                        case 179:
                                                            this.mEvent.mVideoAbnormalInterval = i2;
                                                            break;
                                                        case 180:
                                                            this.mEvent.mVideoAbnormalStrategy = i2;
                                                            break;
                                                        case 181:
                                                            this.mEvent.miss_reason = i2;
                                                            break;
                                                        case 182:
                                                            this.mEvent.miss_reason_dv = i2;
                                                            break;
                                                        case 183:
                                                            this.mEvent.miss_reason_da = i2;
                                                            break;
                                                        case 184:
                                                            this.mVRTracker.setVideoStyle(i2);
                                                            break;
                                                        case 185:
                                                            this.mVRTracker.setDimension(i2);
                                                            break;
                                                        case 186:
                                                            this.mVRTracker.setProjectStyle(i2);
                                                            break;
                                                        case 187:
                                                            this.mVRTracker.setViewSize(i2);
                                                            break;
                                                        case 192:
                                                            this.mFeatureConfigs.mEnableVolumeBalanceStrategySC = i2;
                                                            break;
                                                        default:
                                                            switch (i) {
                                                                case 79:
                                                                    this.mEnableNNSR = i2;
                                                                    break;
                                                                case 80:
                                                                    this.mReadCacheMode = i2;
                                                                    break;
                                                                case 81:
                                                                    this.mPreRangeOff = i2;
                                                                    break;
                                                                default:
                                                                    switch (i) {
                                                                        case 89:
                                                                            this.mEvent.color_trc = i2;
                                                                            break;
                                                                        case 90:
                                                                            if (i2 > 0) {
                                                                                FeatureConfigs featureConfigs = this.mFeatureConfigs;
                                                                                featureConfigs.mHDRType = i2 | featureConfigs.mHDRType;
                                                                                break;
                                                                            }
                                                                            break;
                                                                        case 91:
                                                                            this.mFeatureConfigs.mEnableABRStartup = i2;
                                                                            break;
                                                                        case 92:
                                                                            if (i2 > 0) {
                                                                                this.mFeatureConfigs.mEnableThreadPriority = i2;
                                                                                break;
                                                                            }
                                                                            break;
                                                                        case 93:
                                                                            this.mFeatureConfigs.mEnableSmoothClock = i2;
                                                                            break;
                                                                        case 94:
                                                                            this.mFeatureConfigs.mDisableSplitVoice = i2;
                                                                            break;
                                                                        case DataLoaderHelper.DATALOADER_KEY_INT_ENABLE_P2P_STRAGETY_CONTROL /* 95 */:
                                                                            this.mHardwareConfType = i2;
                                                                            break;
                                                                        case 96:
                                                                            this.mFeatureConfigs.mEnableStrategyCenter = i2;
                                                                            break;
                                                                        case 97:
                                                                            this.mFeatureConfigs.mEnableOutletDropLimit = i2;
                                                                            break;
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                            return;
                        }
                        VideoEventBase videoEventBase = this.mEventBase;
                        if (i2 == 1) {
                            z = true;
                        }
                        videoEventBase.mEnablePowerReport = z;
                        return;
                    }
                    VideoEventBase videoEventBase2 = this.mEventBase;
                    if (i2 == 1) {
                        z = true;
                    }
                    videoEventBase2.mEnableTmpLog = z;
                    return;
                }
                this.mEvent.mHasNoSurfaceWhenAudioRenderStart = i2;
                return;
            }
            this.mNetSpeedLevel = i2;
            return;
        }
        this.mFirstRangeSize = i2;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void updateNetworkSpeedPredictorSampleMutiValue(SpeedPredictorResultCollection speedPredictorResultCollection, SpeedPredictorResultCollection speedPredictorResultCollection2, long j) {
        VideoEventSampleRecord videoEventSampleRecord;
        if (speedPredictorResultCollection != null && speedPredictorResultCollection2 != null && (videoEventSampleRecord = this.mEventSample) != null) {
            videoEventSampleRecord.updateNetworkMutiSpeed(speedPredictorResultCollection, speedPredictorResultCollection2, j);
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void mdlRetryResult(int i, String str, Error error) {
        HashMap hashMap = new HashMap();
        if (error != null) {
            hashMap = error.toMap();
        }
        hashMap.put("result", Integer.valueOf(i));
        if (str != null) {
            hashMap.put("filehash", str);
        }
        TTVideoEngineUtils.addToList(this.mMDLRetryInfo, new JSONObject(hashMap).toString(), 2);
        if (i != 0) {
            this.mEvent.mExpirePlayCode = 3;
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void seekTo(int i, int i2, boolean z) {
        if (!this.mLeave) {
            if (!z) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.mState == 3) {
                    this.mEventOneEvent.movieStallEnd("seek");
                    this.mEvent.lastBufferEndT = currentTimeMillis;
                }
                if (this.mState == 4) {
                    this.mEventOneOpera.endSeek("seek", 0);
                }
                int i3 = this.mSeekCount + 1;
                this.mSeekCount = i3;
                this.mState = 4;
                this.mEventOneOpera.beginSeek(i, i2, i3);
                VideoEventOneOpera videoEventOneOpera = this.mEventOneOpera;
                VideoEventOnePlay videoEventOnePlay = this.mEvent;
                videoEventOneOpera.mLastBufferStartT = videoEventOnePlay.lastBufferStartT;
                videoEventOneOpera.mLastBufferEndT = videoEventOnePlay.lastBufferEndT;
                this.mSeekBeginT = currentTimeMillis;
                if (videoEventOnePlay != null) {
                    videoEventOnePlay.lastSeekStartT = currentTimeMillis;
                    videoEventOnePlay.lastSeekPosition = i2;
                }
                this.mSeekBeginT = SystemClock.elapsedRealtime();
                if (this.mAVOutSyncing) {
                    this.mEventOneOutSync.AVOutSyncEnd(i, "seek");
                    this.mAVOutSyncing = false;
                }
            }
            _recordExitReason(-2002, true);
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void switchResolution(String str, String str2, boolean z) {
        long j;
        if (z) {
            if (this.mState == 4) {
                this.mEventOneOpera.endSeek("switch", 0);
            }
            if (this.mState == 3) {
                this.mEventOneEvent.movieStallEnd("switch");
                this.mEvent.lastBufferEndT = System.currentTimeMillis();
            }
        }
        if (this.mAVOutSyncing) {
            EventLoggerSource eventLoggerSource = this.mDataSource;
            if (eventLoggerSource != null) {
                j = eventLoggerSource.getLogValueInt(67);
            } else {
                j = -1;
            }
            this.mEventOneOutSync.AVOutSyncEnd((int) j, "switch");
            this.mAVOutSyncing = false;
        }
        this.mEvent.et = System.currentTimeMillis();
        if (!str.equals(str2)) {
            this.mSwitchResolutionCount++;
        }
        this.mEventBase.configResolution(str, str2);
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        if (videoEventOnePlay != null) {
            videoEventOnePlay.lastResolutionStartT = System.currentTimeMillis();
        }
        if (z) {
            _recordExitReason(-2005, true);
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void updateGlobalNetworkSpeed(long j, long j2, int i) {
        if (i == this.mNetSpeedUpdateInterval || i == -1) {
            synchronized ("VideoEventLoggerV2") {
                TTVideoEngineLog.d("VideoEventLoggerV2", "global speed size:" + j + ", time:" + j2 + ", totalsize:" + this.mMDLDownloadSize + ", totaltime:" + this.mMDLDownloadTime);
                this.mMDLDownloadSize = this.mMDLDownloadSize + j;
                this.mMDLDownloadTime = this.mMDLDownloadTime + j2;
            }
        }
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void beginToPlay(String str, long j, String str2) {
        int optInt;
        this.mState = 1;
        this.mEventBase.beginToPlay(str, str2);
        if (!TTVideoEngine.sColdStartOptimize || sIsColdStart == 0) {
            this.mEventBase.registerNetwork();
        }
        if (this.mIsReplay == 1) {
            this.setds_t = j;
        }
        if (this.ps_t <= 0) {
            this.ps_t = j;
            collectPowerStatistics();
        }
        this.mLeave = true;
        VideoEventOnePlay videoEventOnePlay = this.mEvent;
        videoEventOnePlay.traceID = this.mEventBase.mSessionID;
        if (this.mIsReplay == 1) {
            videoEventOnePlay.prepare_start_time = j;
        } else {
            videoEventOnePlay.prepare_start_time = -2147483648L;
        }
        videoEventOnePlay.prepare_end_time = -2147483648L;
        videoEventOnePlay.dnsT = -2147483648L;
        videoEventOnePlay.tranConnectT = -2147483648L;
        videoEventOnePlay.tranFirstPacketT = -2147483648L;
        videoEventOnePlay.audioDnsT = -2147483648L;
        videoEventOnePlay.audioTranConnectT = -2147483648L;
        videoEventOnePlay.audioTranFirstPacketT = -2147483648L;
        videoEventOnePlay.receiveFirstVideoFrameT = -2147483648L;
        videoEventOnePlay.receiveFirstAudioFrameT = -2147483648L;
        videoEventOnePlay.decodeFirstVideoFrameT = -2147483648L;
        videoEventOnePlay.decodeFirstAudioFrameT = -2147483648L;
        videoEventOnePlay.videoDeviceStartTime = -2147483648L;
        videoEventOnePlay.audioDeviceStartTime = -2147483648L;
        videoEventOnePlay.videoDeviceOpenedTime = -2147483648L;
        videoEventOnePlay.audioDeviceOpenedTime = -2147483648L;
        this.mPlayCount++;
        videoEventOnePlay.lastSeekStartT = -2147483648L;
        videoEventOnePlay.lastSeekEndT = -2147483648L;
        videoEventOnePlay.lastBufferStartT = -2147483648L;
        videoEventOnePlay.lastBufferEndT = -2147483648L;
        videoEventOnePlay.lastResolutionStartT = -2147483648L;
        videoEventOnePlay.lastResolutionEndT = -2147483648L;
        videoEventOnePlay.lastSeekPosition = Integer.MIN_VALUE;
        videoEventOnePlay.mIsEngineReuse = this.mIsEngineReuse;
        this.mVegaCollector.reset();
        if (!this.mIsEngineReuse) {
            this.mIsEngineReuse = true;
        }
        if (this.mEventBase.mSourceTypeStr.equals("vid")) {
            _recordExitReason(-1002, true);
        } else if (this.mEventBase.mSourceTypeStr.equals("local_url")) {
            _recordExitReason(-1005, true);
        } else {
            int i = this.mEvent.dnsModule;
            if (i == 0) {
                _recordExitReason(-1003, true);
            } else if (i == 1) {
                _recordExitReason(-1005, true);
            }
        }
        if (this.mEnableSpeedReport) {
            this.mEventSample.startRecord();
        }
        TTVideoEngineLog.i("VideoEventLoggerV2", "netlevel interval:" + this.mNetLevelIntervalMs + ", max count:" + this.mNetLevelMaxCount);
        if (this.mNetLevelIntervalMs > 0 && this.mTimerTask == null) {
            NetworkPortraitData portraitData = PortraitNetworkScore.getInstance().getPortraitData();
            portraitData.setSampleInterval(this.mNetLevelIntervalMs);
            portraitData.setMaxCount(this.mNetLevelMaxCount);
            this.mTimerTask = new MyTimerTask();
            portraitData.start();
            portraitData.schedule(this.mTimerTask, this.mNetLevelIntervalMs);
            VideoEventOnePlay videoEventOnePlay2 = this.mEvent;
            int i2 = this.mNetLevelIntervalMs;
            videoEventOnePlay2.mNetQualityInterval = i2;
            int i3 = i2 / 3;
            this.mNetSpeedUpdateInterval = i3;
            this.mNetSpeedUpdateInterval = Math.max(i3, 200);
            synchronized ("VideoEventLoggerV2") {
                this.mMDLDownloadTime = 0L;
                this.mMDLDownloadSize = 0L;
            }
            this.mNetworkQualityAlgorithm = PortraitNetworkScore.getInstance().genNetworkQualityAlg();
            String str3 = this.mNetworkQualityVar;
            if (str3 != null && !str3.isEmpty()) {
                this.mNetworkQualityAlgorithm.setStringOption(4, this.mNetworkQualityVar);
                this.mNetworkQualityVar = null;
            }
            JSONObject vodJsonObject = SettingsHelper.helper().getVodJsonObject("net_quality");
            if (vodJsonObject == null) {
                optInt = 0;
            } else {
                optInt = vodJsonObject.optInt("calculate_interval");
            }
            if (this.mBitrateCalculationTask == null && optInt > 0) {
                PortraitNetworkScore.BitrateCalculationTask bitrateCalculationTask = new PortraitNetworkScore.BitrateCalculationTask(portraitData, this.mNetworkQualityAlgorithm);
                this.mBitrateCalculationTask = bitrateCalculationTask;
                portraitData.schedule(bitrateCalculationTask, optInt);
                TTVideoEngineLog.d("VideoEventLoggerV2", "bitrate calculate interval: " + optInt);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00e3  */
    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void movieShouldRetry(com.ss.ttvideoengine.utils.Error r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.log.VideoEventLoggerV2.movieShouldRetry(com.ss.ttvideoengine.utils.Error, int, int):void");
    }

    public VideoEventLoggerV2(Context context, EventLoggerSource eventLoggerSource, HeadsetStateMonitor headsetStateMonitor) {
        this.mFetchComplete = false;
        this.mSetSurfaceTimeList = null;
        this.mDataSource = eventLoggerSource;
        this.mEventBase = new VideoEventBase(eventLoggerSource, this.mUploadLogEnabled, context);
        VideoEventOneOpera videoEventOneOpera = new VideoEventOneOpera(this.mEventBase);
        this.mEventOneOpera = videoEventOneOpera;
        this.mEventOneEvent = new VideoEventOneEvent(this.mEventBase, videoEventOneOpera);
        this.mEventSample = new VideoEventSampleRecord(this.mEventBase);
        this.mEventOneOutSync = new VideoEventOneOutSync(this.mEventBase);
        this.mEventOneNoRender = new VideoEventOneNoRender(this.mEventBase);
        this.mEventAbrSwitch = new VideoEventAbrEvent(this.mEventBase);
        this.mEventSaver = EventSaver.getInstance(context);
        this.mFeatureConfigs = new FeatureConfigs();
        this.mRetryFetchErrorInfo = new ArrayList();
        this.mMDLRetryInfo = new ArrayList<>();
        this.mFirstDNSErrorInfo = new ArrayList();
        this.mErrorInfo = new ArrayList();
        this.mVUArray = new ArrayList();
        this.mLeave = true;
        this.mFetchComplete = false;
        this.mContext = context;
        this.mHeadsetStateMonitor = headsetStateMonitor;
        this.mHeadsetStateHistory = new HeadsetStateHistory(headsetStateMonitor);
        this.mSrMonitor = new SuperResolutionMonitor();
        this.mFilterMonitor = new VideoFilterMonitor();
        this.mBrightMonitor = new BrightnessMonitor(this.mContext);
        this.mViewSizeMonitor = new ViewSizeMonitor();
        this.mSetSurfaceTimeList = new ArrayList<>();
        this.mLabelUsage = new LabelUsage();
        this.mVegaCollector = new VegaCollector();
        this.mVRTracker = new VRTracker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateTimeConsumingEventData(Context context, VideoEventOnePlay videoEventOnePlay, VideoEventBase videoEventBase, PortraitNetworkScore.NetworkQualityAlgorithm networkQualityAlgorithm) {
        int isPowerSaveMode;
        IVideoModel iVideoModel;
        String str;
        if (videoEventOnePlay == null) {
            TTVideoEngineLog.e("VideoEventLoggerV2", "event is null, return.");
            return;
        }
        videoEventOnePlay.volume = (int) TTHelper.getVolume(context);
        if (videoEventBase != null) {
            videoEventBase.updateMDLInfo();
            ArrayList<String> arrayList = new ArrayList<>();
            if ((videoEventBase.mSourceTypeStr.equals("vid") || videoEventBase.mSourceTypeStr.equals("feed")) && (iVideoModel = videoEventBase.mVideoModel) != null) {
                for (VideoInfo videoInfo : iVideoModel.getVideoInfoList()) {
                    String valueStr = videoInfo.getValueStr(48);
                    String valueStr2 = videoInfo.getValueStr(18);
                    String valueStr3 = videoInfo.getValueStr(8);
                    valueStr3.hashCode();
                    switch (valueStr3) {
                        case "h264":
                            str = "0";
                            break;
                        case "bytevc1":
                            str = "1";
                            break;
                        case "bytevc2":
                            str = "2";
                            break;
                        default:
                            str = "-1";
                            break;
                    }
                    arrayList.add(valueStr2 + '_' + valueStr + '_' + str);
                }
                videoEventBase.mGearinfoList = arrayList;
            }
            videoEventBase.mNetworkType = VideoEventBase.getNetType();
            if (videoEventBase.mdlVideoInfo.mdl_cache_type == 2) {
                videoEventOnePlay.mFeatures.put("preload", 1);
            }
            Map map = videoEventBase.mdlFeatures;
            if (map != null && !map.isEmpty()) {
                videoEventOnePlay.mFeatures.putAll(videoEventBase.mdlFeatures);
                int i = videoEventBase.mdlP2pLoader;
                if (i >= 0) {
                    videoEventOnePlay.loaderType = String.valueOf(i);
                }
            }
        }
        videoEventOnePlay.mSensitiveMode = TTVideoEngineUtils.getSensitiveScene();
        if (videoEventBase.mEnablePowerReport) {
            double cPURate = videoEventBase.getCPURate();
            double cPUSpeed = videoEventBase.getCPUSpeed();
            double d = 0.0d;
            if (cPURate > 0.0d && cPUSpeed > 0.0d) {
                videoEventOnePlay.mCpuRateEnd = cPURate;
                videoEventOnePlay.mCpuSpeedEnd = cPUSpeed;
            } else {
                DeviceMonitorUtils.CPUInfo currentCPUInfo = videoEventBase.getCurrentCPUInfo();
                if (currentCPUInfo != null) {
                    double d2 = currentCPUInfo.cpuAppRate;
                    double d3 = 1.401298464324817E-45d;
                    if (d2 <= 0.0d) {
                        d2 = 1.401298464324817E-45d;
                    }
                    videoEventOnePlay.mCpuRateEnd = d2;
                    double d4 = currentCPUInfo.cpuAppSpeed;
                    if (d4 > 0.0d) {
                        d3 = d4;
                    }
                    videoEventOnePlay.mCpuSpeedEnd = d3;
                }
            }
            if (!videoEventOnePlay.mCurrentList.isEmpty()) {
                while (videoEventOnePlay.mCurrentList.iterator().hasNext()) {
                    d += r11.next().floatValue();
                }
                videoEventOnePlay.mAvgCurrent = (float) (d / videoEventOnePlay.mCurrentList.size());
            }
        }
        if (!TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 2L) && (isPowerSaveMode = DeviceMonitorUtils.isPowerSaveMode(context)) >= 0) {
            videoEventOnePlay.mPowerSaveModeEnd = isPowerSaveMode;
        }
        videoEventOnePlay.mNetworkScore = PortraitNetworkScore.getInstance().getPortraitResult();
        if (networkQualityAlgorithm != null) {
            videoEventOnePlay.mNetworkQualityBitrate = networkQualityAlgorithm.calculateTargetBitrate(new ArrayList(videoEventOnePlay.mCatowerRttMsList), new ArrayList(videoEventOnePlay.mMdlMultiSpeedList));
        }
        videoEventOnePlay.mHostAbiBits = getHostabiBits();
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventLogger
    public void updateNetworkSpeedPredictorSampleValue(String str, String str2, float f, float f2, float f3, float f4, long j, Map<String, String> map, Map<String, String> map2) {
        VideoEventSampleRecord videoEventSampleRecord = this.mEventSample;
        if (videoEventSampleRecord == null) {
            return;
        }
        videoEventSampleRecord.updateNetworkSpeed(str, str2, f, f2, f3, f4, j, map, map2);
    }
}
