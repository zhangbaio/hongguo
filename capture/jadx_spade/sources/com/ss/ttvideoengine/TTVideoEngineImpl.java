package com.ss.ttvideoengine;

import al2.b0;
import al2.i0;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.webkit.URLUtil;
import com.bytedance.covode.number.Covode;
import com.bytedance.crash.Npth;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.vcloud.abrmodule.ABRResult;
import com.bytedance.vcloud.abrmodule.DefaultABRModule;
import com.bytedance.vcloud.abrmodule.IPlayStateSupplier;
import com.dragon.base.ssconfig.template.EngineNetReport;
import com.dragon.base.ssconfig.template.PlayerGlobalConfig;
import com.dragon.read.base.ssconfig.local.QualityOptExperiment;
import com.dragon.read.base.ssconfig.template.EngineMsgOptConfig;
import com.dragon.read.base.ssconfig.template.HiJackConfig;
import com.dragon.read.base.ssconfig.template.MdlNative;
import com.dragon.read.base.ssconfig.template.MediacodecAsyncConfig;
import com.dragon.read.base.ssconfig.template.TTVideoEngineLogOptV689;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.base.util.ThreadUtils;
import com.dragon.read.component.audio.api.NsAudioModuleApi;
import com.dragon.read.component.audio.data.setting.AudioPtsOpt;
import com.dragon.read.util.ToastUtils;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.mediakit.fetcher.AVMDLURLFetcherBridge;
import com.ss.texturerender.VideoSurface;
import com.ss.texturerender.o;
import com.ss.texturerender.r;
import com.ss.texturerender.s;
import com.ss.ttm.player.ABRStrategy;
import com.ss.ttm.player.AudioProcessor;
import com.ss.ttm.player.FrameMetadataListener;
import com.ss.ttm.player.IMediaDataSource;
import com.ss.ttm.player.LoadControl;
import com.ss.ttm.player.MaskInfo;
import com.ss.ttm.player.MediaFormat;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.player.NativeAudioProcessor;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttm.player.RenderTrait;
import com.ss.ttm.player.SubInfo;
import com.ss.ttm.player.TTAVWindowClient;
import com.ss.ttm.player.TTPlayerConfiger;
import com.ss.ttm.player.TraitObject;
import com.ss.ttvideoengine.TTVideoEngineImpl;
import com.ss.ttvideoengine.TTVideoEngineMonitor;
import com.ss.ttvideoengine.VideoInfoCollector;
import com.ss.ttvideoengine.VideoModelCache;
import com.ss.ttvideoengine.abr.SegmentInfo;
import com.ss.ttvideoengine.configcenter.ConfigItemFactory;
import com.ss.ttvideoengine.configcenter.EngineConfig;
import com.ss.ttvideoengine.configcenter.IEngineConfig;
import com.ss.ttvideoengine.configcenter.OptionHolder;
import com.ss.ttvideoengine.configcenter.PlayerConfigExecutor;
import com.ss.ttvideoengine.dasp.DaspSignal;
import com.ss.ttvideoengine.fetcher.FetcherMaker;
import com.ss.ttvideoengine.fetcher.SubInfoFetcher;
import com.ss.ttvideoengine.fetcher.VideoInfoFetcher;
import com.ss.ttvideoengine.fetcher.mdlfethcer.FetcherMakerNew;
import com.ss.ttvideoengine.fetcher.mdlfethcer.MDLFetcherListener;
import com.ss.ttvideoengine.log.EngineInstanceHolder;
import com.ss.ttvideoengine.log.EventLoggerSource;
import com.ss.ttvideoengine.log.ExternVideoLoggerListener;
import com.ss.ttvideoengine.log.HeadsetStateMonitor;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.ss.ttvideoengine.log.PortraitNetworkScore;
import com.ss.ttvideoengine.log.VideoEventBase;
import com.ss.ttvideoengine.log.VideoEventLoggerV2;
import com.ss.ttvideoengine.log.VideoEventManager;
import com.ss.ttvideoengine.log.VideoEventOneNoRender;
import com.ss.ttvideoengine.metrics.IMediaMetrics;
import com.ss.ttvideoengine.model.DubbedInfo;
import com.ss.ttvideoengine.model.IVideoInfo;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.IntertrustDrmHelper;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.net.DNSCompletionListener;
import com.ss.ttvideoengine.net.DNSParser;
import com.ss.ttvideoengine.net.NetUtils;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.playermetrcis.PlayerMetrics;
import com.ss.ttvideoengine.preloader.TTAVPreloaderItem;
import com.ss.ttvideoengine.selector.shift.SpeedShiftConfig;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConfig;
import com.ss.ttvideoengine.selector.strategy.GearStrategySC;
import com.ss.ttvideoengine.selector.strategy.IGearStrategyListener;
import com.ss.ttvideoengine.setting.SettingsHelper;
import com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter;
import com.ss.ttvideoengine.source.strategy.SmartUrlFetcher;
import com.ss.ttvideoengine.strategrycenter.StrategyCenter;
import com.ss.ttvideoengine.strategrycenter.StrategyHelper;
import com.ss.ttvideoengine.strategy.StrategyManager;
import com.ss.ttvideoengine.strategy.refresh.TTVideoEngineSourceRefreshStrategy;
import com.ss.ttvideoengine.strategy.source.StrategySource;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.ss.ttvideoengine.superresolution.SRStrategyConfig;
import com.ss.ttvideoengine.utils.DisplayMode;
import com.ss.ttvideoengine.utils.EngineException;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.FormatProvider;
import com.ss.ttvideoengine.utils.IPlayDurationManager;
import com.ss.ttvideoengine.utils.PlayDurationManager;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import com.ss.ttvideoengine.utils.TimeService;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.xs.fm.player.base.play.address.PlayAddress;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u55.q;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTVideoEngineImpl extends TTVideoEngineInternal implements TTVideoEngineInterface {
    private static String mAppPath;
    private static String mChipBoardName;
    private static Lock mCreatCacheFileLock;
    private static boolean mHasRegisterMdlProto;
    private static boolean mHasRegisterMdlProtoForExo;
    private static boolean mIsFirstOpenEngine;
    private static Context mSettingConfig;
    private static final Map<Surface, Boolean> mSurfaceHashMap;
    private static r.b mTextureLogListenerExt;
    private static FetcherMaker sFetcherMaker;
    private String currentHost;
    private Resolution currentResolution;
    private VideoInfo currentVideoInfo;
    private Map<Integer, String> dashAudioUrlMap;
    private Map<Integer, String> dashUrlMap;
    private Map<Resolution, String> dashVideoUrlMap;
    private Set<Integer> effectTypeSet;
    private Resolution expectedResolution;
    private Resolution lastResolution;
    private int mABR4GMaxResolutionIndex;
    private int mABR4GMaxResolutionMode;
    private String mABR4GMaxResolutionQuality;
    private float mABRBandwidthParameter;
    private int mABRCurrentDownloadedAudioBitrate;
    private int mABREnableAggressivePortraitLowBit;
    private rs1.g mABRModule;
    private int mABRProbeMode;
    private int mABRSpeedPredictOutType;
    private float mABRStallPenaltyParameter;
    private float mABRStartupBandwidthParameter;
    private float mABRSwitchPenaltyParameter;
    private int mABRWithSR;
    private boolean mAEEnableReadAudioSDKAPI2InfoFromStream;
    private MaskInfo mAIBarrageInfoInterface;
    AIBarrageSimpleCallback mAIBarrageInfoListener;
    private String mAIBarrageUrl;
    private String mAPIString;
    private int mAVsyncRefined;
    private int mAnRenderRefreshSurface;
    private boolean mAsyncInitSR;
    private int mAsyncManageResource;
    private MediaPlayer mAsyncPlayer;
    private int mAsyncSetWindow;
    private int mAudioCodecProfile;
    private int mAudioDecoderGraphMerged;
    private int mAudioGraphRefactor;
    private int mAudioPtsCalibrationType;
    private int mAudioUseDirectBuffer;
    private int mAutoAddMedia;
    private int mAutoDisconnectedCpu;
    private int mAutoRangeOffset;
    private int mBT601CloseCodecAsync;
    private String mBarrageMaskUrl;
    private HashMap<String, String> mBashDashDefaultMDLKeys;
    private boolean mBashRetryRestartPlayer;
    private int mBindCore;
    private long mBitrate;
    private int mBytevc2NalsizeCheck;
    CacheFilePathListener mCacheFilePathListener;
    private int mCalibrationAudioPts;
    private int mChangeRecBufferSpeed;
    private int mCheckSilenceInterval;
    private String mClassLoaderState;
    private int mClipHEAACV2FirstPtsPacket;
    private int mCloseCodecPool;
    private boolean mCloseRenderStartMsgOnSwitchResolutionDone;
    private int mCodecAndSurfaceReuse;
    private int mCodecHistoryLength;
    private int mCodecMaxUsedCount;
    private int mCodecPoolSupportDynamicExtend;
    private int mCodecPoolVersion;
    private CodecStrategyAdapter mCodecStrategyAdapter;
    private float mContainerFPS;
    private int mCreateAudioTrackEarly;
    private int mCurPosition;
    private int mCustomBitrate;
    private DNSParser mDNSParser;
    private int mDangerBufferThreshold;
    private final List<DaspSignal> mDaspSignals;
    private DataSource mDataSource;
    private int mDecoderRenderClearSurface;
    private int mDecoderRenderClearTextureRenderRef;
    private int mDecoderRenderContinueRetry;
    private int mDecoderRenderVC2RenderLatencyGeneral;
    private int mDecoderRenderVC2RenderLatencySR;
    private int mDisablePlayerStayAwake;
    private int mDisableSpiltVoiceWrite;
    private int mDiscardCodecStrategy1;
    private int mDiscardCodecStrategy2;
    private DisplayMode mDisplayMode;
    private int mDowngradeResolutionIndex;
    private String mDowngradeResolutionQuality;
    private int mDummySurfaceForbid;
    private VideoInfo mDynamicAudioInfo;
    private boolean mDynamicControlSR;
    private int mDynamicExtendCodecNums;
    private int mDynamicThreadPriorityValue;
    private VideoInfo mDynamicVideoInfo;
    private int mEnableAIBarrage;
    private int mEnableAIBarrageThread;
    private int mEnableAsyncDownload;
    private int mEnableAsyncProbe;
    private int mEnableAudioMemIntergration;
    private boolean mEnableAudioSDKReportOpt;
    private int mEnableAudioTrackSmoothClock;
    private int mEnableBarrageMask;
    private int mEnableBufferingLowerCapacity;
    private int mEnableCPPBYTEVC1CodecOpt;
    private int mEnableCPPBYTEVC2CodecOpt;
    private int mEnableCacheInfo;
    private int mEnableClearTextureRefAsync;
    private int mEnableClockResumeResetEof;
    private int mEnableCodecRecycle;
    private int mEnableDecoderRenderVC2RenderLatency;
    private int mEnableDemuxNonBlockRead;
    private int mEnableDowngradeAsyncCodec;
    private boolean mEnableExchangeUrlWhenRetry;
    private int mEnableFallbackInMaxInstanceErr;
    private int mEnableFastStop;
    private int mEnableHChipAdaptiveWorkAround;
    private int mEnableHEAACV2PtsMSCorrection;
    private boolean mEnableHeartBeat;
    private boolean mEnableLooperThread;
    private int mEnableMCRenderHandleSAR;
    private int mEnableMChipSkipAdaptiveWorkAround;
    private int mEnableMaskThread;
    private int mEnableMediaCodecDeathCheck;
    private int mEnableMediaCodecFairMutex;
    private int mEnableMediaCodecPipeline;
    private int mEnableMediaCodecRealtime;
    private int mEnableMediaCodecSyncClose;
    private int mEnableMp4Check;
    private int mEnableNativeYV12Render;
    private int mEnableNetLevel;
    private int mEnableOptInaccurateStart;
    private int mEnableOptSeekClk;
    private int mEnableOptSubSearch;
    private int mEnableOptimizeAsyncDownload;
    private int mEnableOptimizeDashSeek;
    private int mEnableOptimizeHWDec2SWDec;
    private int mEnableOptimizeIO;
    private int mEnableOptimizeMp4Abr;
    private int mEnableOptimizePrerender;
    private int mEnableOptimizeRadioMode;
    private boolean mEnableOutletDropLimit;
    private int mEnablePreRenderBufferingUpdate;
    private int mEnablePreloadGear;
    private int mEnableRangeOptimize;
    private int mEnableRecreateSubIfDetached;
    private boolean mEnableRefreashCodecStatus;
    private int mEnableRefreshByTime;
    private int mEnableReportFirstAVSyncFrame;
    private boolean mEnableReportPreloadTraceId;
    private boolean mEnableSCABRStrategy;
    private int mEnableSeekBuffering;
    private boolean mEnableSetupMediaCodec;
    private boolean mEnableSourceRefreshStrategy;
    private boolean mEnableSpeedReport;
    private int mEnableStartPlaySync;
    private int mEnableSub;
    private int mEnableSubThread;
    private int mEnableTextureRenderNoRenderCheck;
    private int mEnableThreadPriority;
    private int mEnableTmpLog;
    private int mEnableVC1BlockList;
    private int mEnableVideoSecondFrame;
    private int mEnableVideoTimestampMonotonic;
    private int mEnableVodVideoRenderStall;
    private int mEnbalePreDemux;
    private String mEngineHash;
    private int mEngineRetryNotify;
    private TTVideoEngineMonitor mEngineStateMonitor;
    private final TTVideoEngine mEngineWrapper;
    private boolean mErrorRetryOpt;
    private boolean mErrorThrowOptEnable;
    private String mExternLogKey;
    ExternVideoLoggerListener mExternVideoLoggerListener;
    private TTVideoEngineFFmpegProtocol mFFmpegProtocol;
    private String mFallbackAPI;
    private int mFeedPacketUntilEmpty;
    private boolean mFetchWithAbilityOption;
    private VideoInfoFetcher mFetcher;
    private List<String> mFileHashs;
    private int mFilePlayNoBuffering;
    private boolean mFixDashInitUrlLog;
    private boolean mFixSetDisplayModeSARBug;
    private int mFlushWhenSetSurface;
    private int mForbidBufferingNotFinished;
    private int mForbidFallbackNativeRender;
    private int mForceCloseCodec;
    private String mForceCodec;
    private int mForceShutDownOldSource;
    private String mFormat;
    private int mFrameCount;
    private int mFrameNumsInMediaCodec;
    private boolean mGetPositionSkipLooper;
    private int mGiveBackCodecEarly;
    private Handler mHandler;
    private int mHardwareCodecerFlushClose;
    private Map<String, String> mHeaders;
    private HeadsetStateMonitor mHeadsetMonitor;
    private int mHeartBeatInterval;
    private boolean mHeartBeatStarted;
    private int mHlsSubDemuxerProbeType;
    private int mIgnoreAudioRenderEOSDelayMs;
    private int mIgnoreDirectlyBuffering;
    private int mIgnoreSurfaceCreated;
    private String mInitialUrlBeforeMdlProxy;
    private IntertrustDrmHelper mIntertrustDrmHelper;
    private int mIsEnabelUsedRefactorSurfaceView;
    private int mIsEnableHijackReportOpt;
    private int mIsHijackRetryStragy;
    private boolean mIsNewPlayerViewUsedExternal;
    private String mKeyseed;
    private int mLiveStartIndex;
    private LoadControl mLoadControlInterface;
    private IVideoEventLogger mLogger;
    private TTVideoEngineLooperThread2 mLooperThread;
    private int mMCMaxHeight;
    private int mMCMaxWidth;
    private MDLFetcherListener mMDLFetcherListener;
    private String mMDLGroupId;
    private String mMaskFileHash;
    private long mMaskFileSize;
    private MaskInfo mMaskInfoInterface;
    MaskInfoListener mMaskInfoListener;
    private int mMaxCodecNumsInPool;
    private int mMdlEnableSeekReopen;
    private int mMdlUseOriginalUrlEncode;
    private int mMediaCodecAsyncModeEnable;
    private int mMediaCodecDeathCheckInterval;
    private int mMediaCodecDeathTimeout;
    private JSONObject mMediaExtraInfo;
    private Map<String, Object> mMediaInfoMap;
    private int mMediacodecStopTimeout;
    private int mMetrcisAbility;
    private int mMetrcisInterVal;
    private int mNativeCallAbr;
    private int mNativeRenderRotationAdapt;
    private TTVNetClient mNetClient;
    private int mNetSpeedInterval;
    private float mNetworkSpeedReportSamplingRate;
    private int mNoBufferUpdate;
    private int mOnlyPlayAudioForBothStream;
    private int mOpenSubRetryTimes;
    private int mOptAudioRenderTimeReport;
    private OptionHolder mOptionHolder;
    private int mOverlayMode;
    private boolean mPlayBackUsedSR;
    private boolean mPlayDurationExcludePlayerMethod;
    private long mPlayStartTimestamp;
    PlayerEventListener mPlayerEventListener;
    private int mPlayerViewHeight;
    private int mPlayerViewWidth;
    private int mPosUpdateInterval;
    private int mPreRenderBufferingUpdatePercentage;
    private int mPreciseCache;
    private long mPrecisePausePts;
    private int mPreferNearestMaxPosOffset;
    private ArrayList<String> mPrivCodecName;
    private int mQueryAdaptivePlayback;
    private int mQueryWinEnable;
    private boolean mQuickGetFileCache;
    private int mReadCacheMode;
    private int mRecBufferThresh;
    private int mRecBufferType;
    private Surface mRefactorSurface;
    private boolean mRefreshSurfaceDone;
    private boolean mRefreshSurfaceFlag;
    private boolean mRefreshTextureSurface;
    private int mRenderStallThreshold;
    private int mReportFirstFrameFrameBufferOnly;
    private int mRetryErrCnt;
    private boolean mSRIgnoreRes;
    private int mSRNotUseReason;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mSecureBufferThreshold;
    private long mSendEngineMsgTimeout;
    private int mSetSurfaceDirectly;
    private int mSetSurfaceRetryCount;
    private int mSetSurfaceRetryInterval;
    private int mSettingCodecName;
    private boolean mSkipStartWhenPrepared;
    private TTVideoEngineSourceRefreshStrategy mSourceRefreshStrategy;
    private SpeedShiftConfig mSpeedShiftConfig;
    private int mStartupMaxBitRateIndex;
    private String mStartupMaxBitRateQuality;
    private SubInfoFetcher mSubFetcher;
    SubInfoSimpleCallBack mSubInfoCallBack;
    private SubInfo mSubInfoInterface;
    SubInfoListener mSubInfoListener;
    private String mSubPathInfo;
    private Surface mSurfaceRecord;
    private TTTestSpeedListener mTTSpeedListener;
    private Handler mTestNetSpeedHandler;
    private TestNetSpeedListener mTestNetSpeedListener;
    private Runnable mTestNetSpeedRunable;
    private int mTextureRenderError;
    private s mTextureRenderer;
    private String mTextureSRBinPath;
    private String mTextureSRDspModuleName;
    private String mTextureSROclModuleName;
    private VideoSurface mTextureSurface;
    private int mThreadName2CharSuffix;
    private int mThreadPriorityValue;
    private int mThreadSafeRefSwitcher;
    private int mTlsLog;
    protected String mTraceId;
    private String[] mURLs;
    private int mUnsupportedSampleRatesInBinary;
    private boolean mUseEngineDisplayMode;
    private boolean mUseFallbackAPI;
    private boolean mUseSRTexture;
    private int mUseVdpDisk;
    private int mUserExitTimeMs;
    private int mVideoCodecProfile;
    private int mVideoHeight;
    private String mVideoID;
    private IVideoModel mVideoModel;
    private VideoModelCache mVideoModelCache;
    private int mVideoModelVersion;
    private int mVideoWidth;
    private int mWaitingCodecMs;
    private int mWifiDefaultResolutionIndex;
    private String mWifiDefaultResolutionQuality;
    private TTAVWindowClient mWindowClient;
    private TTAVWindowClient.ExternalInterface mWindowClientExternal;
    private int mWindowHeight;
    private int mWindowWidth;
    private Map<String, IpInfo> urlIPMap;
    private Map<Resolution, Integer> urlIndexMap;
    private Set<Integer> mSettedKeys = new HashSet();
    private int mTestNetSpeedDiff = 500;
    private int mTestNetSpeed = -1;
    private int mPlayerCache = 0;
    private boolean mHttpsEnabled = false;
    private String mCodecType = "h264";
    private boolean mDashEnabled = false;
    private boolean mBashEnabled = false;
    private boolean mHLSSeamlessSwitch = false;
    private int mHlsEnabled = 0;
    private int mEncryptEnabled = 0;
    private boolean mDirectUrlBashEnabled = false;
    private boolean mIsDashSource = false;
    private boolean mHasSetHardWare = false;
    private boolean mUseServerDecodingMode = false;
    private boolean mHasSetAESrcLoudness = false;
    private boolean mHasSetAESrcPeak = false;
    private boolean mVideoFetcherHandlerThread = false;
    private boolean mAEForbidCompressor = false;
    private int mSeekEndEnabled = 0;
    private int mEnableMarkOffscreenRendering = 0;
    private int mAVSyncInterruptEnable = 0;
    private int mEnhancementType = 0;
    private int mEnableCheckUnbindAudioProcessor = 0;
    private int mEnableSetAudioProcessorAfterPlay = 0;
    private int mScaleType = 0;
    private int mLayoutType = 0;
    private int mBmfIgnoreFps = 0;
    private int mRenderType = 3;
    private int mEnableHardwareBufferRender = 0;
    private int mRotation = 0;
    private boolean mIsMirrorHorizontal = false;
    private boolean mIsMirrorVertical = false;
    private int mForbidByteVC1SoftwareDecode = 1;
    private int mHardwareDropNonRef = 0;
    private int mP2PCDNType = 0;
    private int mForbidP2P = 0;
    private int mTestAction = 0;
    private int mDecoderType = 0;
    private int mOpenVoiceEarly = 0;
    private int mBufferDataMiliSeconds = 0;
    private int mNetworkTryCount = -1;
    private int mPlayAPIVersion = 0;
    private String mAuthorization = "";
    private String mSubAuthToken = "";
    private int mDisableAccurateStart = 0;
    private int mEnableSharp = 0;
    private int mEGLNeedWorkAround = 1;
    private int mOriginalRetry = 1;
    private int mStopCloseIO = 0;
    private int mAudioTrackContentType = -1;
    private int mMovPreferNearestSample = 0;
    private int mSkipFfmpegFindStreamInfo = 0;
    private int mMaxFps = 0;
    private int mEnableDynamicFrameDropping = 0;
    private int mFrameDroppingMultiple = 10;
    private int mFrameDroppingCheckPeriod = 300;
    private int mFrameDroppingCheckCount = 3;
    private int mHWMaxFps = 0;
    private int mHWEnableDynamicFrameDropping = 0;
    private int mHWFrameDroppingMultiple = 10;
    private int mHWFrameDroppingCheckPeriod = 300;
    private int mHWFrameDroppingCheckCount = 3;
    private int mEnableHWDropFrameWhenVOIsInDropState = 0;
    private int mEnableHWDropFrameWhenAVOutSyncing = 0;
    private int mCodecFramesDrop = -1;
    private int mFrameDropNum = 2;
    private int mKsyFrameWait = 1;
    private int mLoopReferVideo = 0;
    private int mSkipAudioGraph = 0;
    private int mMediaCodecRender = 1;
    private int mUseMediacodecAudio = 0;
    private int mNotifyBufferingDirectly = 0;
    private int mSetNotifyBufferingDirectlynBeforeRePlay = 0;
    private int mMediaCodecSkipNonRef = 0;
    private int mUseQcomLowLatency = 0;
    private int mUseQcomVpp = 0;
    private int mQcomVppLevel = -1;
    private int mEnableVolumeBalance = 0;
    private float mAEPreGain = 0.25f;
    private float mAEThreshold = -18.0f;
    private float mAERatio = 8.0f;
    private float mAEPredelay = 0.007f;
    private float mSrcLoudness = 0.0f;
    private float mSrcPeak = 0.0f;
    private float mTarLoudness = 0.0f;
    private float mReleaseTime = 200.0f;
    private float mLookAheadTime = 3.0f;
    private int mAEType = 0;
    private float mLuRange = 0.0f;
    private float mLuStart = 0.0f;
    private float mLuEnd = 0.0f;
    private float mMaxMomLu = 0.0f;
    private float mMaxShortermLu = 0.0f;
    private int mVolumInfoVer = 0;
    private int mDeviceAEPlayAbility = 0;
    private boolean mHasSetAEVolumeInfo = false;
    private String mAEConfigJson = "";
    private String mVolumeInfoJson = "";
    private String mAEGraphConfig = "";
    private boolean mClearShutDown = false;
    private int mAudioStreamType = -2;
    private int mAudioTrackSessionId = -1;
    private int mAudioChannelType = 0;
    private int mSeekMode = 0;
    private int mDisablePlayerTimeOut = 0;
    private int mEnableSeekInterrupt = 0;
    private int mMaxBufferDataMilliSeconds = 5000;
    private int mMediaCodecSyncMode = 0;
    private int mOutputLog = 0;
    private int mExposeSignal = 0;
    private int mBufferTimeout = 30;
    private int mNetworkTimeout = 5;
    private boolean mWaitForFetchInfoResult = true;
    private int mSpeedXDrop = 0;
    private float mSpeedXDropFPSLimit = 50.0f;
    private int mEnableLoadControlBufferingTimeout = 0;
    private int mEnableDebugUINotify = 0;
    private int mGetMasterClockByPts = 0;
    private int mAlwaysDoAVSync = 0;
    private int mEnableFallbackSWDec = 1;
    private int mAudioInfoId = -1;
    private int mEnableDeinterlace = 0;
    private int mTextureRenderForbidReuseVideoSurfaceTexture = 0;
    private int mTextureRenderForbidForbidReuseTexture = 0;
    private int mDecoderRenderVC2PreCreateRender = 0;
    private int mVC2LowerRenderCapacity = 0;
    private int mVC2LowerRenderCapacityNOSR = 0;
    private int mVC2DecodecLowLatency = 0;
    private int mVC2WppMode = 0;
    private int mVC2DynamicControl = 0;
    private int mAudioPtsMSCorrectionExtension = 0;
    private int mLowerAudioMemCapacity = 0;
    private int mVC2ThreadNum = 4;
    private int mSetPlayerSurfaceWithLock = 0;
    private int mEnableSurfaceHashmapJudgement = 0;
    private int mEnableTextureRenderNativeWindow = 0;
    private int mEnableFrameCallbackInRenderThread = 0;
    private int mEnableNotifyRenderException = 0;
    private int mEnableVolumeBalanceStrategySC = 0;
    private boolean mHaveSetSpeedTest = false;
    private int mPlayType = 0;
    private SubDesInfoModelProvider mSubDesInfoModel = null;
    final ListenerCompact mListenerCompact = new ListenerCompact();
    private VideoEngineGetInfoListener mVideoEngineGetInfoListener = null;
    private LinkedList<Pair<Surface, Integer>> mExtraSurfaceQueue = new LinkedList<>();
    private TTVideoEngineSurfaceCallback mSurfaceCallback = null;
    private long mPlayStartTime = -1;
    private long mRenderStartTime = -1;
    private long currentBitrate = -1;
    private int mStartupDowngradeType = 0;
    private Resolution mResolutionBeforeDowngrade = null;
    private String mQualityDescBeforeDowngrade = "";
    private long mLastSwitchResolutionTime = 0;
    private boolean mSeamSwitchingResolution = false;
    private boolean mResolutionSwitching = false;
    private long mResolutionSwitchingStartTime = 0;
    private boolean mHasFetchedSubtitle = false;
    private boolean mHasAudioFirstFrameShown = false;
    private int mStartTime = 0;
    private int mLoopStartTime = 0;
    private int mLoopEndTime = 0;
    private int mLoopCount = 0;
    private int mEnableOppoControl = 0;
    private int mReuseSocket = 0;
    private int mDrmType = 0;
    private int mDrmDowngrade = 0;
    private int mDrmCloseRootCheck = 0;
    private boolean mDrmRetry = true;
    private String mFileKey = null;
    private String mDecryptionKey = "";
    private String mSpadea = "";
    private String mTokenUrlTemplate = "";
    private String mGroupID = "";
    private boolean mIsPreloaderItem = false;
    private TTAVPreloaderItem mPreloaderItem = null;
    private String mSubLanIds = "";
    private String mSubIds = "";
    private String mSubFormat = "";
    private String mSubHostName = "";
    private String mSubVersions = "";
    private String mFormatType = "";
    private boolean mIsFeedInfo = false;
    private boolean mIsPlayItem = false;
    private TTVideoEnginePlayItem mPlayItem = null;
    private boolean mFirstURL = true;
    private boolean mFirstHost = true;
    private boolean mFirstIP = true;
    private boolean mFirstQuality = true;
    private boolean mFirstQualityType = true;
    private boolean mFirstResolution = true;
    private boolean mCacheControlEnabled = false;
    private boolean mIsPreDecodeAutoPause = true;
    private boolean mIsPrepareDecodeOnly = false;
    private boolean mOSPlayerIgnoreHeaders = false;
    private long mBufferingStartT = 0;
    private long mPauseStartT = 0;
    private FileDescriptor mPlayFd = null;
    private long mPipeOffset = 0;
    private long mPipeLength = 0;
    private IMediaDataSource mMediaDataSource = null;
    private boolean mUseDNSCache = false;
    private int mDNSExpiredTime = 0;
    private boolean mUseVideoModelCache = false;
    private boolean mUseVideoModelCacheForce = false;
    private int mIsUsePlayerDNS = -1;
    private boolean mIsFetchingInfo = false;
    private int mDataLoaderEnable = 0;
    private int mHlsProxyVVEnable = 0;
    private HashMap<String, Resolution> mResolutionMap = null;
    private boolean mIsUseBoe = false;
    private int mLimitMDLCacheSize = 0;
    private ArrayList<String> mUsingDataLoaderPlayTaskKeys = new ArrayList<>();
    private ArrayList<String> mUsingDataLoaderPlayFilePaths = new ArrayList<>();
    private String mUsingDataLoaderPlayRawKey = null;
    private boolean mAllowedExpiredModel = false;
    private int mIsDisableShortSeek = 0;
    private int mEnableStartTimeSkipAvSkipSerial = 0;
    private AudioProcessor mAudioProcessor = null;
    private int mAsyncSetAudioProcessor = 0;
    private TraitObjectManager mTraitObjManager = new TraitObjectManager();
    private int mUseTextureRender = 0;
    private int mCleanSurfaceWhenReset = 0;
    private int mFirstFrameOpenTexture = 0;
    private boolean mTextureFirstFrame = false;
    private boolean mPlayerFirstFrame = false;
    private String mTextureRenderErrorMsg = null;
    private boolean mDecodedVideoFirstFrame = false;
    private int mTextureSrOpen = 0;
    private TextureRenderStrategy mTRSrategy = new TextureRenderStrategy();
    private int mOldTextureAlgType = -1;
    private int mTextureAlgType = -1;
    private int mSrBackend = 0;
    private int mSrScaleType = 0;
    private int mSrPoolSize = 0;
    private String mProgramCacheDir = "";
    private int mUseBmfComponent = 0;
    private int mUseBmfDirectInvoke = 0;
    private Bundle mBmfInitConfigBundle = null;
    private Bundle mBmfSrProcessParam = null;
    private int mMaxTextureWidth = 0;
    private int mMaxTextureHeight = 0;
    private String mSRLibPath = "";
    private Bundle mLensBundle = null;
    private boolean mAsyncInitEffect = false;
    private boolean mEnableSRStrategy = false;
    private SRStrategy mSRStrategy = new SRStrategy();
    private int mEnableVideoFrameMetaCallback = 0;
    private int mNoAVSync = 0;
    private int mRenderHDR2SDR = 0;
    private int mSyncUpdateSurface = 0;
    private Queue<Bundle> mEffectBundle = new LinkedList();
    private Map<Integer, String> currentParams = null;
    private Map<Integer, String> expectedParams = null;
    private String mCurrentQuality = "";
    private String mCurrentQualityDesc = "";
    private int mCurrentQualityType = 0;
    private boolean mAsyncPlayHitVMCache = false;
    private boolean mIsUseServerDns = false;
    private int mUseAudioHWDec = 0;
    private int mDefaultRenderType = 3;
    private boolean mEnableHttps = false;
    private boolean mRetryEnableHttps = false;
    private boolean mCheckHijack = false;
    private boolean mHijackRetry = true;
    private int mHijackRetryCount = 0;
    private int mHijackRetryMainDNSType = 2;
    private int mHijackRetryBackupDNSType = 0;
    private String mCheckInfoString = null;
    private int mEnableFlushSeek = 0;
    private int mSoloPlayEnable = 1;
    private int mCurrentSubId = 0;
    private int mEnableOptSubLoadTime = 0;
    private int mEnableSubtitleSenseBuffering = 0;
    private int mEnableSubtitleLazyLoading = 0;
    private int mMaskDelayLoading = 0;
    private int mMaskEnableDataloader = 0;
    private int mMaskRangeOpt = 0;
    private int mMaskHeaderLen = 0;
    private int mEnablexHEAACSupport = 0;
    private int mDecodeAACThroughFDKAAC = 0;
    private int mEnableAudioSeekingNoAccurate = 0;
    private int mEnableSetPlayInfoToP2P = 1;
    private int mFirstRangeSize = 0;
    private int mNetSpeedLevel = -1;
    private int mSupportPlayWhenNoSurface = 0;
    private int mEnableGetPlayerReqOffset = 1;
    private boolean mShouldUseAudioRenderStart = false;
    private long mLastSetSurfaceNullTime = 0;
    private int mSetValidSurfaceTimeout = 0;
    private int mDelayBufferingUpdate = 0;
    private int mPostPrepare = 0;
    private int mStopSourceAsync = 0;
    private int mDisableHWDecSeamless = 0;
    private int mEnableVideoCodecPixelAlign = 0;
    private int mDisableMcReuse = 0;
    private int mCodecFrcLevel = 0;
    private int mPrepareCacheMs = 1000;
    private float mFirstFrameSecOffset = 0.0f;
    private int mEnableCacheTimeStamp = 0;
    private int mKeepFormatThreadAlive = 0;
    private int mSkipBufferTimeout = 0;
    private final long mSerial = System.currentTimeMillis();
    private int mCacheJFrameField = 0;
    private int mTimeBarPercentage = 0;
    private int mBestResolutionType = 0;
    private int mEnableIndexCache = 0;
    private int mEnableAsync = 0;
    private int mEnableFragRange = 0;
    private int mLazySeek = 1;
    private int mFFCodecerHeaacV2Compat = 0;
    private int mRangeMode = 0;
    private int mReadMode = 0;
    private int mUpdateTimestampMode = 1;
    private int mEnableOpenTimeout = 1;
    private int mSegmentFormatFlag = 2;
    private int mVideoRangeSize = 1048576;
    private int mAudioRangeSize = 409600;
    private int mVideoRangeTime = 5000;
    private int mAudioRangeTime = 10000;
    private int mSeekExact = 0;
    private int mEnableDirectUrlCheck = 0;
    private int mFindStreamInfoProbeSize = 5000000;
    private int mFindStreamInfoProbDuration = 0;
    private int mNetworkReconnectCount = 0;
    private int mDummyAudioSleep = 1;
    private long mVVTime = 0;
    private long mVideoPreloadSize = 0;
    private URLInfo mURLInfo = new URLInfo();
    private int mIsTTHlsDrm = 0;
    private String mTTHlsDrmToken = "";
    private int mVoiceType = -1;
    private int mAccurateLayout = 0;
    private int mFallbackApiRetry = 0;
    private boolean mEnableForceDisableOESRender = false;
    private boolean mForceDisableOESRender = false;
    private int mResumeFileIOBlockThresMs = 0;
    private int mUseCodecPool = 0;
    private int mNeedAdaptiveWorkaround = 0;
    private int mEnableClearMDLCache = 0;
    private int mEglVersion = 2;
    private int mStartupSwitchCSModel = -1;
    private int mStartupModel = -1;
    private long mStartUpBitrate = -1;
    private long mPredictStartBitrate = -1;
    private long mUserExpectedBitrate = -1;
    private long mDowngradeBitrate = -1;
    private long mMaxCacheBitrate = -1;
    private long mAbrStartupBitrateBeforeFitScreen = -1;
    private float mAbrStartUpSpeed = -1.0f;
    private float mAbrStartUpPredictSpeed = -1.0f;
    private float mAbrStartUpAverageSpeed = -1.0f;
    private float mAbrUserQualitySensitivity = -1.0f;
    private int mAbrUserEnterFullScreen = -1;
    private String mAbrVer = null;
    private String mNetVer = null;
    String mStartUpResolution = "";
    private String mAbrSrInfo = "";
    private String mAbrStartupInfo = "";
    private int mEnableGearStrategyV2 = 0;
    private Map<String, Object> mGearStrategyExtraParams = null;
    private Map<String, String> mSelectBitrateResult = null;
    private int mGearStrategyEnabled = 0;
    private GearStrategyConfig mGearStrategyConfig = new GearStrategyConfig();
    private Map mGearStrategyEvent = new HashMap();
    private int mEnableABR = 0;
    private boolean mABRUsed = false;
    private int mStandAlongAbrStartUp = 0;
    private int mABRTimerIntervalMilliseconds = 500;
    private int mABRSwitchMode = 0;
    private int mABRSwitchSensitivity = 0;
    private int mABRSwitchCSModel = 1;
    private int mABRStartupModel = 0;
    private int mABROnceType = 0;
    private int mABRFixedLevel = 2;
    private int mABRStartupSpeedType = 4;

    /* JADX INFO: Access modifiers changed from: private */
    public void _playInternal(String str, Map map) {
        com_ss_ttvideoengine_TTVideoEngineImpl_com_dragon_read_aop_TTVideoEngineAop__playInternal(this, str, map);
    }

    private void addCDNTuningHeader(Map<String, String> map) {
    }

    private int clearByErrcode(Error error, boolean z) {
        return com_ss_ttvideoengine_TTVideoEngineImpl_com_dragon_read_aop_TTVideoEngineAop_clearByErrcode(this, error, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchedVideoInfo(IVideoModel iVideoModel) {
    }

    private void initEngine(Context context, int i, Map map) {
        com_ss_ttvideoengine_TTVideoEngineImpl_com_dragon_read_aop_TTVideoEngineAop_initEngine(this, context, i, map);
    }

    public static void setNativeMDLRegister() {
        mHasRegisterMdlProto = true;
    }

    void _doPlay() {
        com_ss_ttvideoengine_TTVideoEngineImpl_com_dragon_read_aop_TTVideoEngineAop_doPlay(this);
    }

    void _doPrepare() {
        com_ss_ttvideoengine_TTVideoEngineImpl_com_dragon_read_aop_TTVideoEngineAop__doPrepare(this);
    }

    void _doReleaseAsync() {
        com_ss_ttvideoengine_TTVideoEngineImpl_com_dragon_read_aop_TTVideoEngineAop_doReleaseAsync(this);
    }

    void _doReleaseCommon() {
        com_ss_ttvideoengine_TTVideoEngineImpl_com_dragon_read_aop_TTVideoEngineAop_doReleaseCommon(this);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected MediaPlayer createMediaPlayer() {
        return com_ss_ttvideoengine_TTVideoEngineImpl_com_dragon_read_aop_TTVideoEngineAop_createMediaPlayer(this);
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void play() {
        com_ss_ttvideoengine_TTVideoEngineImpl_com_dragon_read_aop_NetworkTrafficAop_play(this);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDefaultFileCacheDir(String str) {
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setFileCacheDir(String str) {
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setStrategySource(StrategySource strategySource) {
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean getCacheControlEnabled() {
        return this.mCacheControlEnabled;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getCurrentPlayUrl() {
        return this.mCurrentUrl;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getCurrentQualityDesc() {
        return this.mCurrentQualityDesc;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public Resolution getCurrentResolution() {
        return this.currentResolution;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getDirectUrl() {
        return this.mDirectURL;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public GearStrategyConfig getGearStrategyEngineConfig() {
        return this.mGearStrategyConfig;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getHash() {
        return this.mEngineHash;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public IVideoModel getIVideoModel() {
        return this.mVideoModel;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public IVideoEventLogger getLogger() {
        return this.mLogger;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public MediaPlayer getMediaPlayer() {
        return this.mMediaPlayer;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean getMirrorHorizontal() {
        return this.mIsMirrorHorizontal;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean getMirrorVertical() {
        return this.mIsMirrorVertical;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public int getPlayAPIVersion() {
        return this.mPlayAPIVersion;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getQualityDescBeforeDowngrade() {
        return this.mQualityDescBeforeDowngrade;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public Resolution getResolutionBeforeDowngrade() {
        return this.mResolutionBeforeDowngrade;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public int getRotation() {
        return this.mRotation;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public int getStartTime() {
        return this.mStartTime;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getSubTag() {
        return this.mSubTag;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getTag() {
        return this.mTag;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public VideoSurface getTextureSurface() {
        return this.mTextureSurface;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getTraceId() {
        return this.mTraceId;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getVideoID() {
        return this.mVideoID;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean isDashSource() {
        return this.mIsDashSource;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean isPrepared() {
        return this.mPrepared;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean isReleased() {
        return this.mReleased;
    }

    public TTVideoEngineImpl(Context context, int i, Map map, TTVideoEngine tTVideoEngine) {
        Resolution resolution = Resolution.Undefine;
        this.mABR4GMaxResolutionIndex = resolution.getIndex();
        Resolution resolution2 = Resolution.SuperHigh;
        this.mWifiDefaultResolutionIndex = resolution2.getIndex();
        this.mStartupMaxBitRateIndex = resolution2.getIndex();
        this.mABRWithSR = 1;
        this.mABR4GMaxResolutionQuality = null;
        this.mWifiDefaultResolutionQuality = null;
        this.mStartupMaxBitRateQuality = null;
        this.mClassLoaderState = null;
        this.mDowngradeResolutionIndex = resolution.getIndex();
        this.mDowngradeResolutionQuality = null;
        this.mNativeCallAbr = 0;
        this.mABR4GMaxResolutionMode = 0;
        this.mABRSpeedPredictOutType = 0;
        this.mABRStartupBandwidthParameter = 0.9f;
        this.mABRStallPenaltyParameter = 9.0f;
        this.mABRSwitchPenaltyParameter = 2.0f;
        this.mABRBandwidthParameter = 1.0f;
        this.mABRProbeMode = 0;
        this.mABREnableAggressivePortraitLowBit = 0;
        this.mScreenWidth = -1;
        this.mScreenHeight = -1;
        this.mPlayerViewWidth = -1;
        this.mPlayerViewHeight = -1;
        this.mDisablePlayerStayAwake = 0;
        this.mEnableSpeedReport = false;
        this.mNetworkSpeedReportSamplingRate = 0.0f;
        this.mEnableNativeYV12Render = 0;
        this.mForceCloseCodec = 0;
        this.mFilePlayNoBuffering = 0;
        this.mNoBufferUpdate = 0;
        this.mClipHEAACV2FirstPtsPacket = 0;
        this.mEnableVideoTimestampMonotonic = 0;
        this.mFeedPacketUntilEmpty = 0;
        this.mEnableDemuxNonBlockRead = 0;
        this.mEnableThreadPriority = 0;
        this.mThreadPriorityValue = 0;
        this.mEnableVodVideoRenderStall = 0;
        this.mRenderStallThreshold = 0;
        this.mEnableOptInaccurateStart = 0;
        this.mEnableOptSeekClk = 0;
        this.mEnableAudioTrackSmoothClock = 0;
        this.mDisableSpiltVoiceWrite = 0;
        this.mIgnoreDirectlyBuffering = 0;
        this.mDynamicThreadPriorityValue = 0;
        this.mEnableMediaCodecRealtime = 1;
        this.mEnablePreRenderBufferingUpdate = 0;
        this.mPreRenderBufferingUpdatePercentage = 0;
        this.mEnableHEAACV2PtsMSCorrection = 0;
        this.mEnableVC1BlockList = 1;
        this.mEnableHChipAdaptiveWorkAround = 0;
        this.mEnableMChipSkipAdaptiveWorkAround = 0;
        this.mEnableCPPBYTEVC1CodecOpt = 0;
        this.mQuickGetFileCache = false;
        this.mReportFirstFrameFrameBufferOnly = 0;
        this.mEnbalePreDemux = 0;
        this.mEnableCPPBYTEVC2CodecOpt = 0;
        this.mEnableAudioMemIntergration = 0;
        this.mEnableBufferingLowerCapacity = 0;
        this.mEnableDowngradeAsyncCodec = 0;
        this.mEnableMediaCodecSyncClose = 0;
        this.mEnableSeekBuffering = 0;
        this.mBytevc2NalsizeCheck = 0;
        this.mHardwareCodecerFlushClose = 0;
        this.mOptAudioRenderTimeReport = 0;
        this.mBT601CloseCodecAsync = 0;
        this.mForbidFallbackNativeRender = 0;
        this.mDecoderRenderContinueRetry = 0;
        this.mDecoderRenderClearSurface = 0;
        this.mDecoderRenderClearTextureRenderRef = 0;
        this.mEnableDecoderRenderVC2RenderLatency = 0;
        this.mDecoderRenderVC2RenderLatencyGeneral = 0;
        this.mDecoderRenderVC2RenderLatencySR = 0;
        this.mTraceId = "";
        this.mEnableLooperThread = false;
        this.mBashDashDefaultMDLKeys = new HashMap<>();
        this.mSubPathInfo = null;
        this.mFileHashs = new ArrayList();
        this.mReadCacheMode = 0;
        this.mBindCore = 0;
        this.mCheckSilenceInterval = -1;
        this.mEnableBarrageMask = 0;
        this.mEnableMaskThread = 0;
        this.mEnableAIBarrageThread = 0;
        this.mEnableAIBarrage = 0;
        this.mLiveStartIndex = -3;
        this.mEnableRefreshByTime = 0;
        this.mEnableSub = 0;
        this.mEnableSubThread = 0;
        this.mOpenSubRetryTimes = -1;
        this.mEnableOptSubSearch = 0;
        this.mEnableRecreateSubIfDetached = 0;
        this.mCurPosition = -1;
        this.mPosUpdateInterval = 0;
        this.mAudioCodecProfile = -1;
        this.mVideoCodecProfile = -1;
        this.mBitrate = -1L;
        this.mContainerFPS = 0.0f;
        this.mThreadSafeRefSwitcher = 0;
        this.mEnableNetLevel = 0;
        this.mNetSpeedInterval = 0;
        this.mCloseRenderStartMsgOnSwitchResolutionDone = false;
        this.mEnableFastStop = 0;
        this.mEnableCodecRecycle = 0;
        this.mTlsLog = 0;
        this.mIntertrustDrmHelper = null;
        this.mFrameCount = 0;
        this.mHeartBeatStarted = false;
        this.mEnableHeartBeat = false;
        this.mGetPositionSkipLooper = false;
        this.mPlayDurationExcludePlayerMethod = false;
        this.mHeartBeatInterval = 300;
        this.mSRNotUseReason = 0;
        this.mSendEngineMsgTimeout = 0L;
        this.mMediacodecStopTimeout = 0;
        this.mQueryWinEnable = -1;
        this.mPreferNearestMaxPosOffset = -1;
        this.mMediaCodecAsyncModeEnable = -1;
        this.mSettingCodecName = -1;
        this.mPrivCodecName = new ArrayList<>();
        this.mAVsyncRefined = -1;
        this.mOnlyPlayAudioForBothStream = -1;
        this.mIgnoreSurfaceCreated = -1;
        this.mNativeRenderRotationAdapt = 0;
        this.mEnableOutletDropLimit = false;
        this.mPreciseCache = 0;
        this.mMediaInfoMap = new ConcurrentHashMap();
        this.mEnableClockResumeResetEof = 0;
        this.mMdlEnableSeekReopen = 0;
        this.mIgnoreAudioRenderEOSDelayMs = 0;
        this.mAutoAddMedia = 1;
        this.mEnableOptimizeMp4Abr = 0;
        this.mEnableMediaCodecFairMutex = 0;
        this.mEnableRangeOptimize = 0;
        this.mThreadName2CharSuffix = 0;
        this.mEnableOptimizePrerender = 0;
        this.mEnableAsyncDownload = 0;
        this.mEnablePreloadGear = 0;
        this.mEnableAsyncProbe = 0;
        this.mEnableOptimizeAsyncDownload = 0;
        this.mMetrcisAbility = 0;
        this.mMetrcisInterVal = 60;
        this.mEnableCacheInfo = 0;
        this.mEnableOptimizeRadioMode = 0;
        this.mEnableOptimizeIO = 0;
        this.mEnableOptimizeDashSeek = 0;
        this.mAnRenderRefreshSurface = 0;
        this.mSurfaceRecord = null;
        this.mFFmpegProtocol = null;
        this.mForceCodec = null;
        this.mSkipStartWhenPrepared = false;
        this.mEnableMp4Check = 0;
        this.mPrecisePausePts = 0L;
        this.mHlsSubDemuxerProbeType = -1;
        this.mEnableTmpLog = 0;
        this.mCodecAndSurfaceReuse = -1;
        this.mMCMaxWidth = -1;
        this.mMCMaxHeight = -1;
        this.mAsyncManageResource = -1;
        this.mAudioUseDirectBuffer = -1;
        this.mCloseCodecPool = -1;
        this.mMaxCodecNumsInPool = -1;
        this.mDummySurfaceForbid = -1;
        this.mCalibrationAudioPts = -1;
        this.mAudioPtsCalibrationType = -1;
        this.mSetSurfaceRetryCount = -1;
        this.mSetSurfaceRetryInterval = -1;
        this.mChangeRecBufferSpeed = -1;
        this.mEnableVideoSecondFrame = -1;
        this.mGiveBackCodecEarly = -1;
        this.mWaitingCodecMs = -1;
        this.mAsyncSetWindow = -1;
        this.mAutoDisconnectedCpu = -1;
        this.mRetryErrCnt = -1;
        this.mForbidBufferingNotFinished = -1;
        this.mUseVdpDisk = -1;
        this.mMdlUseOriginalUrlEncode = -1;
        this.mEnableReportFirstAVSyncFrame = 1;
        this.mQueryAdaptivePlayback = -1;
        this.mFlushWhenSetSurface = -1;
        this.mEnableMediaCodecDeathCheck = -1;
        this.mMediaCodecDeathCheckInterval = -1;
        this.mMediaCodecDeathTimeout = -1;
        this.mCodecPoolSupportDynamicExtend = -1;
        this.mDynamicExtendCodecNums = -1;
        this.mEnableOptimizeHWDec2SWDec = -1;
        this.mCreateAudioTrackEarly = -1;
        this.mEnableMediaCodecPipeline = -1;
        this.mFrameNumsInMediaCodec = -1;
        this.mEnableMCRenderHandleSAR = -1;
        this.mRecBufferThresh = -1;
        this.mRecBufferType = -1;
        this.mUserExitTimeMs = -1;
        this.mAudioGraphRefactor = -1;
        this.mAudioDecoderGraphMerged = -1;
        this.mCodecPoolVersion = -1;
        this.mDiscardCodecStrategy1 = -1;
        this.mDiscardCodecStrategy2 = -1;
        this.mCodecHistoryLength = -1;
        this.mCodecMaxUsedCount = -1;
        this.mEnableFallbackInMaxInstanceErr = -1;
        this.mSetSurfaceDirectly = -1;
        this.mEnableStartPlaySync = -1;
        this.mEnableClearTextureRefAsync = 0;
        this.mEnableSetupMediaCodec = false;
        this.mEnableSCABRStrategy = false;
        this.mFixDashInitUrlLog = false;
        this.mRefreshSurfaceFlag = false;
        this.mRefreshSurfaceDone = false;
        this.mRefreshTextureSurface = false;
        this.effectTypeSet = new CopyOnWriteArraySet();
        this.mEnableReportPreloadTraceId = false;
        this.mErrorThrowOptEnable = false;
        this.mErrorRetryOpt = false;
        this.mMDLGroupId = null;
        this.mInitialUrlBeforeMdlProxy = null;
        this.mBashRetryRestartPlayer = false;
        this.mForceShutDownOldSource = 0;
        this.mFormat = null;
        this.mCustomBitrate = -1;
        this.mEnableExchangeUrlWhenRetry = false;
        this.mEnableRefreashCodecStatus = false;
        this.mAEEnableReadAudioSDKAPI2InfoFromStream = false;
        this.mEnableAudioSDKReportOpt = false;
        this.mRefactorSurface = null;
        this.mWindowWidth = 0;
        this.mWindowHeight = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mWindowClient = null;
        this.mWindowClientExternal = null;
        this.mIsEnabelUsedRefactorSurfaceView = 0;
        this.mIsNewPlayerViewUsedExternal = false;
        this.mIsHijackRetryStragy = -2;
        this.mIsEnableHijackReportOpt = -1;
        this.mDaspSignals = new ArrayList();
        this.mEngineWrapper = tTVideoEngine;
        if (EngineGlobalConfig.getInstance().getLazyLoadVideodec() != 1) {
            TTVideoEngineLog.d(logcatTag(), "JniUtils.loadLibrary in TTVideoEngineImpl new");
            JniUtils.loadLibrary();
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "init2, type:" + i + ", this:" + this + ", version:1.10.252.100-novel");
        }
        initEngine(context, i, map);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0880  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0982  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void TTVideoEngineImpl___playInternal$___twin___(java.lang.String r42, java.util.Map<java.lang.String, java.lang.String> r43) {
        /*
            Method dump skipped, instructions count: 4644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.TTVideoEngineImpl.TTVideoEngineImpl___playInternal$___twin___(java.lang.String, java.util.Map):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:202)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:61)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.processFallThroughCases(SwitchRegionMaker.java:105)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    void _doSetIntOption(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 6962
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.TTVideoEngineImpl._doSetIntOption(int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:407:0x11f1  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x1251  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x1260  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x11e0 A[LOOP:6: B:443:0x11dd->B:445:0x11e0, LOOP_END] */
    /* JADX WARN: Type inference failed for: r1v46, types: [com.ss.ttvideoengine.configcenter.IEngineConfig] */
    /* JADX WARN: Type inference failed for: r51v0, types: [com.ss.ttvideoengine.TTVideoEngineImpl, com.ss.ttvideoengine.TTVideoEngineInternal] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void _doParseIPAddress(com.ss.ttvideoengine.model.IVideoModel r52, com.ss.ttvideoengine.utils.Error r53) {
        /*
            Method dump skipped, instructions count: 4829
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.TTVideoEngineImpl._doParseIPAddress(com.ss.ttvideoengine.model.IVideoModel, com.ss.ttvideoengine.utils.Error):void");
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void setMediaPlayerOptions() {
        super.setMediaPlayerOptions();
        this.mMediaPlayer.setIntOption(1073, this.mEnableSetAudioProcessorAfterPlay);
        this.mMediaPlayer.setIntOption(1092, this.mEnableCheckUnbindAudioProcessor);
        this.mMediaPlayer.setIntOption(823, this.mEnableFlushSeek);
        this.mMediaPlayer.setIntOption(619, this.mCurrentSubId);
        this.mMediaPlayer.setIntOption(828, this.mEnableOptSubLoadTime);
        this.mMediaPlayer.setIntOption(1601, this.mEnableSubtitleSenseBuffering);
        this.mMediaPlayer.setIntOption(1602, this.mEnableSubtitleLazyLoading);
        this.mMediaPlayer.setIntOption(1800, this.mMaskDelayLoading);
        this.mMediaPlayer.setIntOption(1900, this.mEnablexHEAACSupport);
        this.mMediaPlayer.setIntOption(1901, this.mDecodeAACThroughFDKAAC);
        this.mMediaPlayer.setIntOption(1902, this.mEnableAudioSeekingNoAccurate);
        this.mMediaPlayer.setIntOption(870, this.mThreadSafeRefSwitcher);
        this.mMediaPlayer.setIntOption(853, this.mOpenSubRetryTimes);
        this.mMediaPlayer.setIntOption(829, this.mEnableOptSubSearch);
        this.mMediaPlayer.setIntOption(854, this.mEnableRecreateSubIfDetached);
        this.mMediaPlayer.setIntOption(185, this.mSoloPlayEnable);
        this.mMediaPlayer.setIntOption(201, this.mIsDisableShortSeek);
        this.mMediaPlayer.setIntOption(95, this.mMovPreferNearestSample);
        this.mMediaPlayer.setIntOption(96, this.mSkipFfmpegFindStreamInfo);
        this.mMediaPlayer.setIntOption(133, this.mDisableAccurateStart);
        this.mMediaPlayer.setIntOption(81, this.mBufferTimeout);
        this.mMediaPlayer.setIntOption(9, this.mNetworkTimeout * 1000000);
        this.mMediaPlayer.setIntOption(197, this.mOriginalRetry);
        this.mMediaPlayer.setIntOption(253, this.mAccurateLayout);
        int i = this.mEGLNeedWorkAround;
        if (i == 0) {
            this.mMediaPlayer.setIntOption(183, i);
        }
        this.mMediaPlayer.setIntOption(827, this.mOpenVoiceEarly);
        this.mMediaPlayer.setIntOption(67, this.mDecoderType);
        this.mMediaPlayer.setIntOption(86, this.mBufferDataMiliSeconds);
        this.mMediaPlayer.setIntOption(110, this.mMaxBufferDataMilliSeconds);
        this.mMediaPlayer.setIntOption(TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE, this.mUnsupportedSampleRatesInBinary);
        this.mMediaPlayer.setIntOption(159, this.mFrameDropNum);
        this.mMediaPlayer.setIntOption(195, this.mLoopReferVideo);
        this.mMediaPlayer.setIntOption(79, this.mTestNetSpeed);
        this.mMediaPlayer.setIntOption(66, this.mTestNetSpeedDiff);
        int i2 = this.mPlayerCache;
        if (i2 != 0 && this.mCacheControlEnabled) {
            this.mMediaPlayer.setIntOption(24, i2);
        }
        this.mMediaPlayer.setIntOption(83, this.mTestAction);
        this.mMediaPlayer.setIntOption(37, this.mEnhancementType);
        this.mMediaPlayer.setIntOption(38, this.mScaleType);
        this.mMediaPlayer.setIntOption(36, this.mLayoutType);
        int renderType = EngineGlobalConfig.getInstance().getRenderType();
        if (renderType != -1) {
            this.mMediaPlayer.setIntOption(56, renderType);
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "set renderType from static context, renderType:" + renderType);
            }
        } else {
            this.mMediaPlayer.setIntOption(56, this.mRenderType);
        }
        this.mMediaPlayer.setIntOption(301, this.mExposeSignal);
        this.mMediaPlayer.setIntOption(TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES_FXAA, this.mNotifyBufferingDirectly);
        this.mMediaPlayer.setIntOption(247, this.mDisablePlayerTimeOut);
        this.mMediaPlayer.setIntOption(248, this.mEnableSeekInterrupt);
        this.mMediaPlayer.setIntOption(134, this.mMaxFps);
        this.mMediaPlayer.setIntOption(1010, this.mEnableDynamicFrameDropping);
        this.mMediaPlayer.setIntOption(1011, this.mFrameDroppingMultiple);
        this.mMediaPlayer.setIntOption(1012, this.mFrameDroppingCheckPeriod);
        this.mMediaPlayer.setIntOption(1014, this.mFrameDroppingCheckCount);
        this.mMediaPlayer.setIntOption(50302, this.mHWMaxFps);
        this.mMediaPlayer.setIntOption(50303, this.mHWEnableDynamicFrameDropping);
        this.mMediaPlayer.setIntOption(50304, this.mHWFrameDroppingMultiple);
        this.mMediaPlayer.setIntOption(50305, this.mHWFrameDroppingCheckPeriod);
        this.mMediaPlayer.setIntOption(50306, this.mHWFrameDroppingCheckCount);
        this.mMediaPlayer.setIntOption(1055, this.mEnableHWDropFrameWhenVOIsInDropState);
        this.mMediaPlayer.setIntOption(1056, this.mEnableHWDropFrameWhenAVOutSyncing);
        int i3 = this.mCodecFramesDrop;
        if (i3 != -1) {
            this.mMediaPlayer.setIntOption(1057, i3);
        }
        this.mMediaPlayer.setIntOption(192, this.mKsyFrameWait);
        this.mMediaPlayer.setIntOption(358, this.mSpeedXDrop);
        this.mMediaPlayer.setIntOption(278, this.mStopSourceAsync);
        this.mMediaPlayer.setIntOption(276, this.mPostPrepare);
        this.mMediaPlayer.setIntOption(263, this.mDelayBufferingUpdate);
        this.mMediaPlayer.setIntOption(199, this.mSkipAudioGraph);
        this.mMediaPlayer.setIntOption(256, this.mEglVersion);
        this.mMediaPlayer.setIntOption(285, this.mCodecFrcLevel);
        this.mMediaPlayer.setIntOption(286, this.mPrepareCacheMs);
        this.mMediaPlayer.setIntOption(292, this.mEnableCacheTimeStamp);
        this.mMediaPlayer.setIntOption(293, this.mKeepFormatThreadAlive);
        this.mMediaPlayer.setIntOption(297, this.mSkipBufferTimeout);
        this.mMediaPlayer.setIntOption(647, this.mPosUpdateInterval);
        _configNativeRenderRotationAdapt();
        this.mMediaPlayer.setIntOption(565, this.mNativeRenderRotationAdapt);
        this.mMediaPlayer.setIntOption(664, this.mIgnoreAudioRenderEOSDelayMs);
        this.mMediaPlayer.setIntOption(666, this.mEnableMp4Check);
        this.mMediaPlayer.setIntOption(1004, this.mEnableDeinterlace);
        this.mMediaPlayer.setLongOption(668, this.mPrecisePausePts);
        int i4 = this.mMaxCodecNumsInPool;
        if (i4 != -1) {
            this.mMediaPlayer.setIntOption(1041, i4);
        }
        this.mMediaPlayer.setIntOption(42141, this.mOptionHolder.getIntOption(42141, 0));
        this.mMediaPlayer.setIntOption(10001, this.mBindCore);
        this.mMediaPlayer.setIntOption(339, this.mCheckSilenceInterval);
        if (this.mHardwareDecodeEnablePlayer2 == 1) {
            this.mMediaPlayer.setIntOption(254, this.mNeedAdaptiveWorkaround);
            this.mMediaPlayer.setIntOption(400, this.mUseCodecPool);
            this.mMediaPlayer.setIntOption(90, this.mMediaCodecSyncMode);
            this.mMediaPlayer.setIntOption(215, this.mUseQcomLowLatency);
            this.mMediaPlayer.setIntOption(216, this.mMediaCodecSkipNonRef);
            int i5 = this.mUseQcomVpp;
            if (i5 == 1) {
                this.mMediaPlayer.setIntOption(TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES_STRENGTH, i5);
                this.mMediaPlayer.setIntOption(213, this.mQcomVppLevel);
            }
            if (this.mEnableOppoControl == 1) {
                this.mMediaPlayer.setIntOption(184, 1);
            }
            this.mMediaPlayer.setIntOption(279, this.mDisableHWDecSeamless);
            int i6 = this.mEnableVideoCodecPixelAlign;
            if (i6 == 1) {
                this.mMediaPlayer.setIntOption(280, i6);
            }
            this.mMediaPlayer.setIntOption(401, this.mDisableMcReuse);
        }
        this.mMediaPlayer.setIntOption(1744, this.mAudioTrackContentType);
        if (this.mEnableSharp == 1) {
            this.mMediaPlayer.setIntOption(189, 1);
        }
        if (this.mTimeBarPercentage == 1) {
            this.mMediaPlayer.setIntOption(312, 1);
        }
        if (EngineGlobalConfig.getInstance().getALogWriteAddr() > 0) {
            this.mMediaPlayer.setLongOption(231, EngineGlobalConfig.getInstance().getALogWriteAddr());
        }
        this.mMediaPlayer.setIntOption(223, this.mOutputLog);
        if (EngineGlobalConfig.getInstance().getOutputLogLevelPercise() >= 0) {
            this.mMediaPlayer.setIntOption(1501, EngineGlobalConfig.getInstance().getOutputLogLevelPercise());
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d(logcatTag(), "set media Player percise loglever:" + EngineGlobalConfig.getInstance().getOutputLogLevelPercise());
            }
        } else {
            this.mMediaPlayer.setIntOption(984, EngineGlobalConfig.getInstance().getOutputLogLevel());
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d(logcatTag(), "set media Player loglever:" + EngineGlobalConfig.getInstance().getOutputLogLevel());
            }
        }
        AudioProcessor audioProcessor = this.mAudioProcessor;
        if (audioProcessor != null) {
            ((MediaPlayerWrapper) this.mMediaPlayer).setAudioProcessor(audioProcessor);
        }
        for (Map.Entry<Integer, TraitObject> entry : this.mTraitObjManager.getAll().entrySet()) {
            ((MediaPlayerWrapper) this.mMediaPlayer).setTraitObject(entry.getKey().intValue(), entry.getValue());
        }
        this.mMediaPlayer.setIntOption(48, this.mVoiceType);
        int i7 = this.mHardwareDropNonRef;
        if (i7 > 0) {
            this.mMediaPlayer.setIntOption(252, i7);
        }
        this.mMediaPlayer.setIntOption(88, this.mMediaCodecRender);
        this.mMediaPlayer.setIntOption(97, this.mUseMediacodecAudio);
        this.mMediaPlayer.setIntOption(536, this.mFindStreamInfoProbeSize);
        this.mMediaPlayer.setIntOption(537, this.mFindStreamInfoProbDuration);
        this.mMediaPlayer.setIntOption(538, this.mNetworkReconnectCount);
        this.mMediaPlayer.setIntOption(539, this.mDummyAudioSleep);
        this.mMediaPlayer.setIntOption(5003, this.mDisablePlayerStayAwake);
        _configNativeYV12Render();
        this.mMediaPlayer.setIntOption(542, this.mEnableNativeYV12Render);
        this.mMediaPlayer.setIntOption(550, this.mForceCloseCodec);
        this.mMediaPlayer.setIntOption(551, this.mFilePlayNoBuffering);
        this.mMediaPlayer.setIntOption(552, this.mNoBufferUpdate);
        this.mMediaPlayer.setIntOption(556, this.mEnableDebugUINotify);
        this.mMediaPlayer.setIntOption(654, this.mGetMasterClockByPts);
        this.mMediaPlayer.setIntOption(348, this.mAlwaysDoAVSync);
        this.mMediaPlayer.setIntOption(557, this.mClipHEAACV2FirstPtsPacket);
        this.mMediaPlayer.setIntOption(558, this.mEnableVideoTimestampMonotonic);
        this.mMediaPlayer.setIntOption(559, this.mFeedPacketUntilEmpty);
        this.mMediaPlayer.setIntOption(257, this.mEnableFallbackSWDec);
        this.mMediaPlayer.setIntOption(560, this.mEnableDemuxNonBlockRead);
        this.mMediaPlayer.setIntOption(952, this.mMediacodecStopTimeout);
        this.mMediaPlayer.setIntOption(561, this.mEnableThreadPriority);
        this.mMediaPlayer.setIntOption(562, this.mThreadPriorityValue);
        this.mMediaPlayer.setIntOption(322, this.mRenderStallThreshold);
        this.mMediaPlayer.setIntOption(761, this.mEnableOptInaccurateStart);
        this.mMediaPlayer.setIntOption(762, this.mEnableOptSeekClk);
        this.mMediaPlayer.setIntOption(563, this.mEnableAudioTrackSmoothClock);
        this.mMediaPlayer.setIntOption(564, this.mDisableSpiltVoiceWrite);
        this.mMediaPlayer.setIntOption(566, this.mIgnoreDirectlyBuffering);
        this.mMediaPlayer.setIntOption(149, this.mEnableOutletDropLimit ? 1 : 0);
        this.mMediaPlayer.setIntOption(164, this.mEnableMediaCodecRealtime);
        this.mMediaPlayer.setIntOption(571, this.mEnablePreRenderBufferingUpdate);
        this.mMediaPlayer.setIntOption(572, this.mPreRenderBufferingUpdatePercentage);
        this.mMediaPlayer.setIntOption(573, this.mEnableHEAACV2PtsMSCorrection);
        this.mMediaPlayer.setIntOption(574, this.mEnableVC1BlockList);
        this.mMediaPlayer.setIntOption(575, this.mEnableHChipAdaptiveWorkAround);
        this.mMediaPlayer.setIntOption(TTVideoEngineInterface.PLAYER_OPTION_PRE_RENDER_BUFFERING_UPDATE_PRECENTAGE, this.mEnableMChipSkipAdaptiveWorkAround);
        int enableCPPBYTEVC1CodecOpt = EngineGlobalConfig.getInstance().getEnableCPPBYTEVC1CodecOpt();
        if (enableCPPBYTEVC1CodecOpt > 0) {
            this.mMediaPlayer.setIntOption(580, enableCPPBYTEVC1CodecOpt);
        } else {
            this.mMediaPlayer.setIntOption(580, this.mEnableCPPBYTEVC1CodecOpt);
        }
        this.mMediaPlayer.setIntOption(582, this.mReportFirstFrameFrameBufferOnly);
        this.mMediaPlayer.setIntOption(587, this.mEnbalePreDemux);
        this.mMediaPlayer.setIntOption(1050, this.mEnableFastStop);
        this.mMediaPlayer.setIntOption(1052, this.mEnableCodecRecycle);
        this.mMediaPlayer.setIntOption(480, this.mTlsLog);
        this.mMediaPlayer.setIntOption(672, this.mStopCloseIO);
        this.mMediaPlayer.setIntOption(591, this.mEnableCPPBYTEVC2CodecOpt);
        this.mMediaPlayer.setIntOption(673, this.mEnableAudioMemIntergration);
        this.mMediaPlayer.setIntOption(674, this.mEnableBufferingLowerCapacity);
        this.mMediaPlayer.setIntOption(675, this.mEnableDowngradeAsyncCodec);
        this.mMediaPlayer.setIntOption(676, this.mEnableMediaCodecSyncClose);
        this.mMediaPlayer.setIntOption(677, this.mEnableSeekBuffering);
        this.mMediaPlayer.setIntOption(592, this.mBytevc2NalsizeCheck);
        this.mMediaPlayer.setIntOption(593, this.mHardwareCodecerFlushClose);
        this.mMediaPlayer.setIntOption(594, this.mOptAudioRenderTimeReport);
        this.mMediaPlayer.setIntOption(595, this.mBT601CloseCodecAsync);
        this.mMediaPlayer.setIntOption(4001, this.mForbidFallbackNativeRender);
        this.mMediaPlayer.setIntOption(4002, this.mDecoderRenderContinueRetry);
        this.mMediaPlayer.setIntOption(4003, this.mDecoderRenderClearSurface);
        this.mMediaPlayer.setIntOption(4005, this.mEnableDecoderRenderVC2RenderLatency);
        this.mMediaPlayer.setIntOption(1071, this.mEnableOptimizeMp4Abr);
        this.mMediaPlayer.setIntOption(1072, this.mEnableMediaCodecFairMutex);
        this.mMediaPlayer.setIntOption(1074, this.mEnableRangeOptimize);
        this.mMediaPlayer.setIntOption(1075, this.mThreadName2CharSuffix);
        this.mMediaPlayer.setIntOption(1076, this.mEnableOptimizePrerender);
        this.mMediaPlayer.setIntOption(581, this.mVC2DecodecLowLatency);
        this.mMediaPlayer.setIntOption(4008, this.mVC2WppMode);
        this.mMediaPlayer.setIntOption(1079, this.mEnableAsyncDownload);
        this.mMediaPlayer.setIntOption(756, this.mEnablePreloadGear);
        this.mMediaPlayer.setIntOption(1094, this.mEnableAsyncProbe);
        this.mMediaPlayer.setIntOption(1096, this.mEnableOptimizeAsyncDownload);
        this.mMediaPlayer.setIntOption(598, this.mAudioPtsMSCorrectionExtension);
        this.mMediaPlayer.setIntOption(1084, this.mEnableCacheInfo);
        this.mMediaPlayer.setIntOption(1098, this.mEnableOptimizeRadioMode);
        this.mMediaPlayer.setIntOption(1086, this.mEnableOptimizeIO);
        this.mMediaPlayer.setIntOption(42005, this.mEnableOptimizeDashSeek);
        this.mMediaPlayer.setIntOption(42016, this.mAnRenderRefreshSurface);
        this.mMediaPlayer.setIntOption(4009, this.mLowerAudioMemCapacity);
        this.mMediaPlayer.setIntOption(4010, this.mVC2ThreadNum);
        this.mMediaPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_USE_TARGET_WINDOW, this.mSetPlayerSurfaceWithLock);
        this.mMediaPlayer.setIntOption(42049, this.mEnableNotifyRenderException);
        this.mMediaPlayer.setIntOption(42141, this.mOptionHolder.getIntOption(42141, 0));
        this.mMediaPlayer.setIntOption(10001, this.mBindCore);
        this.mMediaPlayer.setIntOption(339, this.mCheckSilenceInterval);
        if (this.mHardwareDecodeEnablePlayer2 <= 0) {
            this.mMediaPlayer.setIntOption(4007, this.mDecoderRenderVC2PreCreateRender);
        }
        int i8 = this.mQueryWinEnable;
        if (i8 != -1) {
            this.mMediaPlayer.setIntOption(982, i8);
        }
        int i9 = this.mPreferNearestMaxPosOffset;
        if (i9 != -1) {
            this.mMediaPlayer.setIntOption(985, i9);
        }
        int i10 = this.mMediaCodecAsyncModeEnable;
        if (i10 != -1) {
            this.mMediaPlayer.setIntOption(1000, i10);
        }
        int i11 = this.mHlsSubDemuxerProbeType;
        if (i11 != -1) {
            this.mMediaPlayer.setIntOption(1070, i11);
        }
        IVideoModel iVideoModel = this.mVideoModel;
        if (iVideoModel != null) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            int i12 = this.mAudioInfoId;
            if (i12 == -1) {
                i12 = iVideoModel.getVideoRefInt(230);
            }
            mediaPlayer.setIntOption(662, i12);
        } else {
            this.mMediaPlayer.setIntOption(662, this.mAudioInfoId);
        }
        _setLoggerOptions();
        int i13 = this.mSettingCodecName;
        if (i13 != -1) {
            this.mMediaPlayer.setIntOption(1003, i13);
            for (int i14 = 0; i14 < this.mPrivCodecName.size(); i14++) {
                this.mMediaPlayer.setStringOption(1002, this.mPrivCodecName.get(i14));
            }
        }
        int i15 = this.mAVsyncRefined;
        if (i15 != -1) {
            this.mMediaPlayer.setIntOption(1005, i15);
        }
        int i16 = this.mOnlyPlayAudioForBothStream;
        if (i16 != -1) {
            this.mMediaPlayer.setIntOption(1020, i16);
        }
        int i17 = this.mCodecAndSurfaceReuse;
        if (i17 != -1) {
            this.mMediaPlayer.setIntOption(1007, i17);
        }
        int i18 = this.mMCMaxWidth;
        if (i18 != -1) {
            this.mMediaPlayer.setIntOption(1008, i18);
        }
        int i19 = this.mMCMaxHeight;
        if (i19 != -1) {
            this.mMediaPlayer.setIntOption(1009, i19);
        }
        int i20 = this.mIgnoreSurfaceCreated;
        if (i20 != -1) {
            this.mMediaPlayer.setIntOption(1036, i20);
        }
        int i21 = this.mForbidBufferingNotFinished;
        if (i21 != -1) {
            this.mMediaPlayer.setIntOption(1035, i21);
        }
        if (this.mIsPrepareDecodeOnly) {
            this.mMediaPlayer.setIntOption(1063, 1);
        }
        int i22 = this.mAsyncManageResource;
        if (i22 != -1) {
            this.mMediaPlayer.setIntOption(1038, i22);
        }
        int i23 = this.mAudioUseDirectBuffer;
        if (i23 != -1) {
            this.mMediaPlayer.setIntOption(1039, i23);
        }
        int i24 = this.mCloseCodecPool;
        if (i24 != -1) {
            this.mMediaPlayer.setIntOption(1040, i24);
        }
        int i25 = this.mDummySurfaceForbid;
        if (i25 != -1) {
            this.mMediaPlayer.setIntOption(1034, i25);
        }
        int i26 = this.mCalibrationAudioPts;
        if (i26 != -1) {
            this.mMediaPlayer.setIntOption(1043, i26);
        }
        int i27 = this.mAudioPtsCalibrationType;
        if (i27 != -1) {
            this.mMediaPlayer.setIntOption(1311, i27);
        }
        int i28 = this.mSetSurfaceRetryCount;
        if (i28 != -1) {
            this.mMediaPlayer.setIntOption(1044, i28);
        }
        int i29 = this.mSetSurfaceRetryInterval;
        if (i29 != -1) {
            this.mMediaPlayer.setIntOption(1045, i29);
        }
        int i30 = this.mChangeRecBufferSpeed;
        if (i30 != -1) {
            this.mMediaPlayer.setIntOption(1046, i30);
        }
        int i31 = this.mEnableVideoSecondFrame;
        if (i31 != -1) {
            this.mMediaPlayer.setIntOption(1049, i31);
        }
        int i32 = this.mGiveBackCodecEarly;
        if (i32 != -1) {
            this.mMediaPlayer.setIntOption(1047, i32);
        }
        int i33 = this.mWaitingCodecMs;
        if (i33 != -1) {
            this.mMediaPlayer.setIntOption(1048, i33);
        }
        int i34 = this.mAsyncSetWindow;
        if (i34 != -1) {
            this.mMediaPlayer.setIntOption(1316, i34);
        }
        int i35 = this.mAutoDisconnectedCpu;
        if (i35 != -1) {
            this.mMediaPlayer.setIntOption(1310, i35);
        }
        int i36 = this.mEnableReportFirstAVSyncFrame;
        if (i36 == 1) {
            this.mMediaPlayer.setIntOption(475, i36);
        }
        int i37 = this.mQueryAdaptivePlayback;
        if (i37 != -1) {
            this.mMediaPlayer.setIntOption(1313, i37);
        }
        int i38 = this.mFlushWhenSetSurface;
        if (i38 != -1) {
            this.mMediaPlayer.setIntOption(1321, i38);
        }
        int i39 = this.mEnableMediaCodecDeathCheck;
        if (i39 != -1) {
            this.mMediaPlayer.setIntOption(1326, i39);
        }
        int i40 = this.mMediaCodecDeathCheckInterval;
        if (i40 != -1) {
            this.mMediaPlayer.setIntOption(1327, i40);
        }
        int i41 = this.mMediaCodecDeathTimeout;
        if (i41 != -1) {
            this.mMediaPlayer.setIntOption(1328, i41);
        }
        int i42 = this.mCodecPoolSupportDynamicExtend;
        if (i42 != -1) {
            this.mMediaPlayer.setIntOption(1329, i42);
        }
        int i43 = this.mDynamicExtendCodecNums;
        if (i43 != -1) {
            this.mMediaPlayer.setIntOption(1330, i43);
        }
        int i44 = this.mEnableOptimizeHWDec2SWDec;
        if (i44 != -1) {
            this.mMediaPlayer.setIntOption(1332, i44);
        }
        int i45 = this.mCreateAudioTrackEarly;
        if (i45 != -1) {
            this.mMediaPlayer.setIntOption(1325, i45);
        }
        int i46 = this.mEnableMediaCodecPipeline;
        if (i46 != -1) {
            this.mMediaPlayer.setIntOption(1333, i46);
        }
        int i47 = this.mFrameNumsInMediaCodec;
        if (i47 != -1) {
            this.mMediaPlayer.setIntOption(1334, i47);
        }
        int i48 = this.mEnableMCRenderHandleSAR;
        if (i48 != -1) {
            this.mMediaPlayer.setIntOption(1336, i48);
        }
        int i49 = this.mRecBufferThresh;
        if (i49 != -1) {
            this.mMediaPlayer.setIntOption(1312, i49);
        }
        int i50 = this.mRecBufferType;
        if (i50 != -1) {
            this.mMediaPlayer.setIntOption(1341, i50);
        }
        int i51 = this.mUserExitTimeMs;
        if (i51 != -1) {
            this.mMediaPlayer.setIntOption(1340, i51);
        }
        int i52 = this.mAudioGraphRefactor;
        if (i52 != -1) {
            this.mMediaPlayer.setIntOption(1337, i52);
        }
        int i53 = this.mAudioDecoderGraphMerged;
        if (i53 != -1) {
            this.mMediaPlayer.setIntOption(1338, i53);
        }
        int i54 = this.mCodecPoolVersion;
        if (i54 != -1) {
            this.mMediaPlayer.setIntOption(1344, i54);
        }
        int i55 = this.mDiscardCodecStrategy1;
        if (i55 != -1) {
            this.mMediaPlayer.setIntOption(1345, i55);
        }
        int i56 = this.mDiscardCodecStrategy2;
        if (i56 != -1) {
            this.mMediaPlayer.setIntOption(1346, i56);
        }
        int i57 = this.mCodecHistoryLength;
        if (i57 != -1) {
            this.mMediaPlayer.setIntOption(1347, i57);
        }
        int i58 = this.mCodecMaxUsedCount;
        if (i58 != -1) {
            this.mMediaPlayer.setIntOption(1348, i58);
        }
        int i59 = this.mEnableFallbackInMaxInstanceErr;
        if (i59 != -1) {
            this.mMediaPlayer.setIntOption(1355, i59);
        }
        int i60 = this.mEnableStartPlaySync;
        if (i60 != -1) {
            this.mMediaPlayer.setIntOption(1317, i60);
        }
        int i61 = this.mOverlayMode;
        if ((i61 == 2 || i61 == 4) && this.mTextureSurface != null) {
            this.mNoAVSync = 1;
            this.mEnableVideoFrameMetaCallback = 1;
            this.mMediaPlayer.setIntOption(820, 1);
            if (this.mOverlayMode == 4) {
                this.mIsMute = true;
            }
        }
        this.mMediaPlayer.setIntOption(333, this.mEnableVideoFrameMetaCallback);
        MediaPlayer mediaPlayer2 = this.mMediaPlayer;
        if (mediaPlayer2 instanceof MediaPlayerWrapper) {
            ((MediaPlayerWrapper) mediaPlayer2).setFrameMetadataListener(new MyFrameMetadataListener());
        }
        this.mOptionHolder.apply(this.mMediaPlayer);
    }

    private static class DeleteBeforeDirFileRunnable implements Runnable {
        private Context context;

        static {
            Covode.recordClassIndex(652335);
        }

        @Override // java.lang.Runnable
        public void run() {
            TTHelper.deleteBeforeDirFiles(this.context);
        }

        public DeleteBeforeDirFileRunnable(Context context) {
            this.context = context;
        }
    }

    private static class RecursionDeleteFileRunnable implements Runnable {
        private File mNeedDeleteFile;

        static {
            Covode.recordClassIndex(652349);
        }

        @Override // java.lang.Runnable
        public void run() {
            TTHelper.recursionDeleteFile(this.mNeedDeleteFile);
        }

        public RecursionDeleteFileRunnable(File file) {
            this.mNeedDeleteFile = file;
        }
    }

    public class TTVideoEngineLooperThread2 {
        private boolean isLastHandlerThreadNull;
        private List<Condition> mCondList;
        private TTVideoEngineImpl mEngine;
        private Lock mEngineMsgLock;
        Parcel mEngineMsgRetValue;
        private Lock mMainMsgLock;
        Parcel mMainMsgRetValue;
        private HandlerThread mMessageThread;
        private Handler mEngineMsgHandler = null;
        private Handler mMainLooperHandler = null;
        private boolean mIsHandlingMainMsg = false;
        boolean mInjectedMsgThread = false;
        boolean mInjectedMsgNotAllowDestroy = false;
        private String lastHandlerThreadStr = "";
        private String lastCallbackLooperStr = "";

        static {
            Covode.recordClassIndex(652351);
        }

        void postMainLooperMessage(int i, int i2, int i3, Object obj, Object obj2) {
            com_ss_ttvideoengine_TTVideoEngineImpl$TTVideoEngineLooperThread2_com_dragon_read_aop_TTVideoEngineAop_postMainLooperMessage(this, i, i2, i3, obj, obj2);
        }

        public boolean isStarted() {
            if (this.mEngineMsgHandler != null) {
                return true;
            }
            return false;
        }

        private class RunnableMsgHandler implements Runnable {
            Message msg;
            WeakReference<Handler> msgHandler;

            static {
                Covode.recordClassIndex(652354);
            }

            @Override // java.lang.Runnable
            public void run() {
                Handler handler;
                WeakReference<Handler> weakReference = this.msgHandler;
                if (weakReference != null && (handler = weakReference.get()) != null) {
                    handler.handleMessage(this.msg);
                }
            }

            RunnableMsgHandler(Handler handler, Message message) {
                this.msgHandler = new WeakReference<>(handler);
                this.msg = message;
            }
        }

        boolean checkSendMainLooper() {
            Looper mainLooper;
            if (this.mEngineMsgHandler == null) {
                return false;
            }
            Handler handler = this.mMainLooperHandler;
            if (handler != null && handler.getLooper() != null && this.mMainLooperHandler.getLooper().getThread() != null && !this.mMainLooperHandler.getLooper().getThread().isAlive()) {
                TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "main looper thread is not alive, return false");
                return false;
            }
            if (Looper.myLooper() != null) {
                mainLooper = Looper.myLooper();
            } else {
                mainLooper = Looper.getMainLooper();
            }
            Handler handler2 = this.mMainLooperHandler;
            if (handler2 != null && handler2.getLooper() != mainLooper) {
                return true;
            }
            if (this.mMainLooperHandler != null && TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d(TTVideoEngineImpl.this.logcatTag(), "mainHandler looper:" + this.mMainLooperHandler.getLooper());
            }
            return false;
        }

        void closeEngineLooperThread() {
            Lock lock = this.mEngineMsgLock;
            if (lock != null) {
                lock.lock();
                List<Condition> list = this.mCondList;
                if (list != null && !list.isEmpty()) {
                    for (int i = 0; i < this.mCondList.size(); i++) {
                        this.mCondList.get(i).signalAll();
                    }
                    this.mCondList.clear();
                }
                Handler handler = this.mEngineMsgHandler;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                    Looper looper = this.mEngineMsgHandler.getLooper();
                    if (!this.mInjectedMsgThread || !this.mInjectedMsgNotAllowDestroy) {
                        looper.quit();
                    }
                    this.mEngineMsgHandler = null;
                }
                this.mEngineMsgLock.unlock();
            }
        }

        void postEngineMessage(int i) {
            postEngineMessage(i, 0, 0, null);
        }

        void runOnLooperThread(Runnable runnable) {
            Handler handler;
            if (checkEngineLooperThread(false)) {
                if (this.mEngine.mState != 5 && (handler = this.mEngineMsgHandler) != null) {
                    handler.post(runnable);
                    return;
                }
                return;
            }
            runnable.run();
        }

        boolean checkEngineLooperThread(boolean z) {
            if (this.mIsHandlingMainMsg && z) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                    TTVideoEngineLog.i(TTVideoEngineImpl.this.logcatTag(), "mIsHandlingMainMsg return false, thread:" + Looper.myLooper().getThread());
                }
                return false;
            }
            Lock lock = this.mEngineMsgLock;
            if (lock != null) {
                lock.lock();
                if (this.mEngineMsgHandler != null && Looper.myLooper() != this.mEngineMsgHandler.getLooper()) {
                    this.mEngineMsgLock.unlock();
                    return true;
                }
                this.mEngineMsgLock.unlock();
            }
            return false;
        }

        private class MyMainLooperHandler extends HandlerDelegate {
            private WeakReference<TTVideoEngineImpl> mEngineRef;

            static {
                Covode.recordClassIndex(652353);
            }

            public void handleMessage(Message message) {
                Map map;
                Condition condition;
                Object obj;
                TTVideoEngineImpl tTVideoEngineImpl = this.mEngineRef.get();
                if (tTVideoEngineImpl == null) {
                    TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "engine is null, return.");
                    return;
                }
                Object obj2 = message.obj;
                String str = null;
                if (obj2 != null) {
                    map = (Map) obj2;
                    if (map.containsKey("msgCond")) {
                        condition = (Condition) map.get("msgCond");
                    } else {
                        condition = null;
                    }
                    if (map.containsKey("paramObj")) {
                        obj = map.get("paramObj");
                    } else {
                        obj = null;
                    }
                } else {
                    map = null;
                    condition = null;
                    obj = null;
                }
                int i = message.what;
                if (i != 600) {
                    boolean z = false;
                    switch (i) {
                        case 400:
                            tTVideoEngineImpl.mListenerCompact.onPlaybackStateChanged(tTVideoEngineImpl.mEngineWrapper, message.arg1);
                            break;
                        case 401:
                            int i2 = message.arg1;
                            if (message.arg2 == 1) {
                                z = true;
                            }
                            if (z || i2 != 3) {
                                tTVideoEngineImpl.mListenerCompact.onLoadStateChanged(tTVideoEngineImpl.mEngineWrapper, i2);
                                break;
                            }
                            break;
                        case 402:
                            tTVideoEngineImpl.mListenerCompact.onVideoSizeChanged(tTVideoEngineImpl.mEngineWrapper, message.arg1, message.arg2);
                            break;
                        case 403:
                            tTVideoEngineImpl.mListenerCompact.onBufferingUpdate(tTVideoEngineImpl.mEngineWrapper, message.arg1);
                            break;
                        case 404:
                            tTVideoEngineImpl.mListenerCompact.onPrepare(tTVideoEngineImpl.mEngineWrapper);
                            break;
                        case 405:
                            tTVideoEngineImpl.mListenerCompact.onPrepared(tTVideoEngineImpl.mEngineWrapper);
                            break;
                        case 406:
                            if (obj instanceof String) {
                                String str2 = (String) obj;
                                if (!str2.equals(tTVideoEngineImpl.mTraceId)) {
                                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(5)) {
                                        TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "MSG_NOTIFY_RENDER_START engine:" + tTVideoEngineImpl + ", traceId not same, should be:" + str2 + ", now:" + tTVideoEngineImpl.mTraceId);
                                        break;
                                    }
                                } else {
                                    tTVideoEngineImpl.mListenerCompact.onRenderStart(tTVideoEngineImpl.mEngineWrapper);
                                    break;
                                }
                            }
                            break;
                        case 407:
                            tTVideoEngineImpl.mListenerCompact.onStreamChanged(tTVideoEngineImpl.mEngineWrapper, message.arg1);
                            break;
                        case 408:
                            tTVideoEngineImpl.mListenerCompact.onCompletion(tTVideoEngineImpl.mEngineWrapper);
                            break;
                        case 409:
                            tTVideoEngineImpl.mListenerCompact.onError((Error) obj);
                            break;
                        case 410:
                            tTVideoEngineImpl.mListenerCompact.onVideoStatusException(message.arg1);
                            break;
                        case TTVideoEngineInterface.PLAYER_OPTION_USE_THREAD_POOL /* 411 */:
                            VideoModel videoModel = (VideoModel) obj;
                            ListenerCompact listenerCompact = tTVideoEngineImpl.mListenerCompact;
                            if (listenerCompact != null) {
                                boolean onFetchedVideoInfo = listenerCompact.onFetchedVideoInfo(videoModel);
                                TTVideoEngineLooperThread2.this.mMainMsgRetValue.setDataPosition(0);
                                TTVideoEngineLooperThread2.this.mMainMsgRetValue.writeInt(onFetchedVideoInfo ? 1 : 0);
                                break;
                            }
                            break;
                        case TTVideoEngineInterface.PLAYER_OPTION_USE_AJ_MEDIACODEC /* 412 */:
                            tTVideoEngineImpl.mListenerCompact.onVideoEngineInfos((VideoEngineInfos) obj);
                            break;
                        case TTVideoEngineInterface.PLAYER_OPTION_ENABEL_HARDWARE_DECODE_AUDIO /* 413 */:
                            Error error = (Error) obj;
                            if (map != null && map.containsKey("paramObj1")) {
                                str = (String) map.get("paramObj1");
                            }
                            tTVideoEngineImpl.mListenerCompact.onVideoURLRouteFailed(error, str);
                            break;
                        case TTVideoEngineInterface.PLAYER_OPTION_DEFAULT_RENDER_TYPE /* 414 */:
                            if (message.arg1 == 1) {
                                z = true;
                            }
                            SeekCompletionListener seekCompletionListener = tTVideoEngineImpl.mSeekCompletionListener;
                            if (seekCompletionListener != null) {
                                seekCompletionListener.onCompletion(z);
                                tTVideoEngineImpl.mSeekCompletionListener = null;
                                break;
                            }
                            break;
                        case 415:
                            if (obj instanceof Map) {
                                Map map2 = (Map) obj;
                                int intValue = ((Integer) map2.get("bufferStartAction")).intValue();
                                String str3 = (String) map2.get("traceid");
                                if (str3 != tTVideoEngineImpl.mTraceId) {
                                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(5)) {
                                        TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "MSG_NOTIFY_BUFFER_START engine:" + tTVideoEngineImpl + ", traceId not same, should be:" + str3 + ", now:" + tTVideoEngineImpl.mTraceId);
                                        break;
                                    }
                                } else {
                                    tTVideoEngineImpl.mListenerCompact.onBufferStart(message.arg1, message.arg2, intValue);
                                    break;
                                }
                            }
                            break;
                        case 416:
                            tTVideoEngineImpl.mListenerCompact.onBufferEnd(message.arg1);
                            break;
                        case 417:
                            tTVideoEngineImpl.mListenerCompact.onVideoStreamBitrateChanged((Resolution) obj, message.arg1);
                            break;
                        case TTVideoEngineInterface.PLAYER_OPTION_FORBID_P2P_WHEN_SEEK /* 418 */:
                            tTVideoEngineImpl.mListenerCompact.onSARChanged(message.arg1, message.arg2);
                            break;
                        case 419:
                            tTVideoEngineImpl.mListenerCompact.onReadyForDisplay(tTVideoEngineImpl.mEngineWrapper);
                            break;
                        case 420:
                            tTVideoEngineImpl.mListenerCompact.onAVBadInterlaced((Map) obj);
                            break;
                        case 421:
                            Map map3 = (Map) obj;
                            tTVideoEngineImpl.mListenerCompact.onFrameAboutToBeRendered(tTVideoEngineImpl.mEngineWrapper, ((Integer) map3.get("type")).intValue(), ((Long) map3.get("pts")).longValue(), ((Long) map3.get("wallClockTime")).longValue(), (HashMap) map3.get("frameData"));
                            break;
                        case 422:
                            if (obj instanceof String) {
                                String str4 = (String) obj;
                                if (!str4.equals(tTVideoEngineImpl.mTraceId)) {
                                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(5)) {
                                        TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "MSG_NOTIFY_VIDEO_SECOND_FRAME engine:" + tTVideoEngineImpl + ", traceId not same, should be:" + str4 + ", now:" + tTVideoEngineImpl.mTraceId);
                                        break;
                                    }
                                } else {
                                    tTVideoEngineImpl.mListenerCompact.onVideoSecondFrame(tTVideoEngineImpl.mEngineWrapper);
                                    break;
                                }
                            }
                            break;
                        case 423:
                            tTVideoEngineImpl.mLogger.showedFirstAVSyncVideoFrame(((Long) obj).longValue());
                            tTVideoEngineImpl.mListenerCompact.onFirstAVSyncFrame(TTVideoEngineImpl.this.mEngineWrapper);
                            break;
                        case 424:
                            tTVideoEngineImpl.mListenerCompact.onRefreshSurface(TTVideoEngineImpl.this.mEngineWrapper);
                            break;
                        case 425:
                            ListenerCompact listenerCompact2 = tTVideoEngineImpl.mListenerCompact;
                            if (listenerCompact2 != null) {
                                listenerCompact2.onCurrentPlaybackTimeUpdate(TTVideoEngineImpl.this.mEngineWrapper, message.arg1);
                                break;
                            }
                            break;
                        case 426:
                            if (obj instanceof String) {
                                String str5 = (String) obj;
                                if (!str5.equals(tTVideoEngineImpl.mTraceId)) {
                                    TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "MSG_NOTIFY_SILENCE_DETECTED engine:" + tTVideoEngineImpl + ", traceId not same, should be:" + str5 + ", now:" + tTVideoEngineImpl.mTraceId);
                                    break;
                                } else {
                                    tTVideoEngineImpl.mListenerCompact.onSilenceDetected(tTVideoEngineImpl.mEngineWrapper);
                                    break;
                                }
                            }
                            break;
                        case 427:
                            tTVideoEngineImpl.mListenerCompact.OnFirstFrameAfterSurfaceChange(TTVideoEngineImpl.this.mEngineWrapper);
                            break;
                        default:
                            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(5)) {
                                TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "unknown message: " + message.what);
                                break;
                            }
                            break;
                    }
                } else {
                    tTVideoEngineImpl.mListenerCompact.onABRPredictBitrate(message.arg1, message.arg2);
                }
                TTVideoEngineLooperThread2 tTVideoEngineLooperThread2 = TTVideoEngineLooperThread2.this;
                tTVideoEngineLooperThread2.notifyMsgComplete(tTVideoEngineLooperThread2.mMainMsgLock, condition);
            }

            public MyMainLooperHandler(TTVideoEngineImpl tTVideoEngineImpl, Looper looper) {
                super(looper);
                this.mEngineRef = null;
                this.mEngineRef = new WeakReference<>(tTVideoEngineImpl);
            }
        }

        private class MessageHandler extends HandlerDelegate {
            private WeakReference<TTVideoEngineImpl> mEngineRef;

            static {
                Covode.recordClassIndex(652352);
            }

            public void handleMessage(Message message) {
                Map map;
                Object obj;
                Condition condition;
                String str;
                String str2;
                Condition condition2;
                TTVideoEngineImpl tTVideoEngineImpl = this.mEngineRef.get();
                if (tTVideoEngineImpl == null) {
                    TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "engine is null, return.");
                    return;
                }
                Object obj2 = message.obj;
                Error error = null;
                String str3 = null;
                r2 = null;
                String str4 = null;
                r2 = null;
                String str5 = null;
                r2 = null;
                Map<Integer, String> map2 = null;
                if (obj2 != null) {
                    map = (Map) obj2;
                    if (map.containsKey("msgCond")) {
                        condition2 = (Condition) map.get("msgCond");
                    } else {
                        condition2 = null;
                    }
                    if (map.containsKey("paramObj")) {
                        obj = map.get("paramObj");
                    } else {
                        obj = null;
                    }
                    condition = condition2;
                } else {
                    map = null;
                    obj = null;
                    condition = null;
                }
                int i = message.what;
                if (i == 34) {
                    tTVideoEngineImpl._createPlayerAsync();
                } else if (i != 35) {
                    if (i != 111) {
                        if (i != 300) {
                            if (i != 301) {
                                boolean z = true;
                                switch (i) {
                                    case 1:
                                        tTVideoEngineImpl._doPlay();
                                        break;
                                    case 2:
                                        tTVideoEngineImpl._doPause();
                                        break;
                                    case 3:
                                        tTVideoEngineImpl._doStop();
                                        break;
                                    case 4:
                                        tTVideoEngineImpl._doRelease();
                                        break;
                                    case 5:
                                        tTVideoEngineImpl._doReleaseAsync();
                                        break;
                                    case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                                        if (message.arg1 != 1) {
                                            z = false;
                                        }
                                        tTVideoEngineImpl._doSetLooping(z);
                                        break;
                                    case 7:
                                        tTVideoEngineImpl._seekTo(message.arg1, false);
                                        break;
                                    case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                                        if (obj != null) {
                                            Resolution resolution = (Resolution) obj;
                                            if (map != null && map.containsKey("paramObj1")) {
                                                map2 = (Map) map.get("paramObj1");
                                            }
                                            tTVideoEngineImpl._switchToResolution(resolution, map2);
                                            break;
                                        } else {
                                            TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "_configResolution invalid param");
                                            break;
                                        }
                                        break;
                                    case 9:
                                        if (obj != null) {
                                            float floatValue = ((Float) obj).floatValue();
                                            if (map != null && map.containsKey("paramObj1")) {
                                                tTVideoEngineImpl.setPlayerVolume(floatValue, ((Float) map.get("paramObj1")).floatValue());
                                                break;
                                            } else {
                                                tTVideoEngineImpl.setPlayerVolume(floatValue, floatValue);
                                                break;
                                            }
                                        } else {
                                            TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "_setPlayerVolume invalid param");
                                            break;
                                        }
                                        break;
                                    case 10:
                                        if (message.arg1 != 1) {
                                            z = false;
                                        }
                                        tTVideoEngineImpl._setPlayerMute(z);
                                        break;
                                    case 11:
                                        tTVideoEngineImpl._pauseByInterruption();
                                        break;
                                    case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                                        if (obj != null) {
                                            tTVideoEngineImpl._doSetDataSource((FileDescriptor) obj);
                                            break;
                                        } else {
                                            TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "_doSetDataSource invalid param");
                                            break;
                                        }
                                    case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                                        if (obj != null) {
                                            tTVideoEngineImpl._doSetDataSource((IMediaDataSource) obj);
                                            break;
                                        } else {
                                            TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "_doSetDataSource invalid param");
                                            break;
                                        }
                                    case 14:
                                        if (obj != null) {
                                            tTVideoEngineImpl._doSetVideoID((String) obj);
                                            break;
                                        } else {
                                            TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "_doSetVideoID invalid param");
                                            break;
                                        }
                                    case 15:
                                        if (obj != null) {
                                            tTVideoEngineImpl._doSetPreloaderItem((TTAVPreloaderItem) obj);
                                            break;
                                        } else {
                                            TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "_doSetVideoID invalid param");
                                            break;
                                        }
                                    case 16:
                                        if (obj != null) {
                                            tTVideoEngineImpl._doSetVideoModel((IVideoModel) obj);
                                            break;
                                        } else {
                                            TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "_doSetVideoModel invalid param");
                                            break;
                                        }
                                    case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                                        if (obj != null) {
                                            tTVideoEngineImpl._doSetPlayItem((TTVideoEnginePlayItem) obj);
                                            break;
                                        } else {
                                            TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "_doSetPlayItem invalid param");
                                            break;
                                        }
                                    case 18:
                                        if (obj != null) {
                                            tTVideoEngineImpl._doSetLocalURL((String) obj);
                                            break;
                                        } else {
                                            TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "_doSetLocalURL invalid param");
                                            break;
                                        }
                                    case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                                        if (obj != null) {
                                            String str6 = (String) obj;
                                            if (map != null && map.containsKey("paramObj1")) {
                                                tTVideoEngineImpl._doSetDirectURL(str6, (String) map.get("paramObj1"));
                                                break;
                                            } else {
                                                tTVideoEngineImpl._doSetDirectURL(str6, new String[]{str6});
                                                break;
                                            }
                                        } else {
                                            TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "_doSetDirectURL invalid param");
                                            break;
                                        }
                                        break;
                                    case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                                        if (obj != null) {
                                            String[] strArr = obj;
                                            if (map != null) {
                                                if (map.containsKey("paramObj1")) {
                                                    str = (String) map.get("paramObj1");
                                                } else {
                                                    str = null;
                                                }
                                                if (map.containsKey("paramObj2")) {
                                                    str2 = (String) map.get("paramObj2");
                                                } else {
                                                    str2 = null;
                                                }
                                            } else {
                                                str = null;
                                                str2 = null;
                                            }
                                            tTVideoEngineImpl._doSetDirectUrlUseDataLoader(strArr, str, str2, 0L, null);
                                            break;
                                        } else {
                                            TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "setDirectUrlUseDataLoader invalid param");
                                            break;
                                        }
                                    case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                                        if (obj != null) {
                                            String str7 = (String) obj;
                                            if (map != null && map.containsKey("paramObj1")) {
                                                str5 = (String) map.get("paramObj1");
                                            }
                                            tTVideoEngineImpl.setDirectUrlUseDataLoaderByFilePath(new String[]{str7}, str5);
                                            break;
                                        } else {
                                            TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "setDirectUrlUseDataLoader invalid param");
                                            break;
                                        }
                                    case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                                        tTVideoEngineImpl._doPrepare();
                                        break;
                                    case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                                        tTVideoEngineImpl._doStart();
                                        break;
                                    case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                                        tTVideoEngineImpl._doHeartBeatThings();
                                        break;
                                    default:
                                        switch (i) {
                                            case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                                                if (obj != null) {
                                                    TTVideoEngineLog.d(TTVideoEngineImpl.this.logcatTag(), "looper setStrategySource");
                                                    tTVideoEngineImpl.doSetStrategySource((StrategySource) obj);
                                                    break;
                                                } else {
                                                    TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "setStrategySource invalid param");
                                                    break;
                                                }
                                            case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                                                TTVideoEngineLog.d(TTVideoEngineImpl.this.logcatTag(), "looper forceDraw");
                                                tTVideoEngineImpl.doForceDraw();
                                                break;
                                            case 28:
                                                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                                    TTVideoEngineLog.d(TTVideoEngineImpl.this.logcatTag(), "looper setRotation " + message.arg1);
                                                }
                                                tTVideoEngineImpl.doSetRotation(message.arg1);
                                                break;
                                            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                                                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                                    TTVideoEngineLog.d(TTVideoEngineImpl.this.logcatTag(), "looper setMirrorHorizontal " + message.arg1);
                                                }
                                                if (message.arg1 <= 0) {
                                                    z = false;
                                                }
                                                tTVideoEngineImpl.doSetMirrorHorizontal(z);
                                                break;
                                            case 30:
                                                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                                    TTVideoEngineLog.d(TTVideoEngineImpl.this.logcatTag(), "looper setMirrorVertical " + message.arg1);
                                                }
                                                if (message.arg1 <= 0) {
                                                    z = false;
                                                }
                                                tTVideoEngineImpl.doSetMirrorVertical(z);
                                                break;
                                            case 31:
                                                if (obj != null) {
                                                    TTVideoEngineLog.d(TTVideoEngineImpl.this.logcatTag(), "looper setPlayAuthToken");
                                                    tTVideoEngineImpl.doSetPlayAuthToken((String) obj);
                                                    break;
                                                } else {
                                                    TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "doSetPlayAuthToken invalid param");
                                                    break;
                                                }
                                            case ConstantsAPI.COMMAND_PRELOAD_MINI_PROGRAM_ENVIRONMENT /* 32 */:
                                                if (obj != null) {
                                                    DirectUrlItem directUrlItem = (DirectUrlItem) obj;
                                                    tTVideoEngineImpl._doSetDirectUrlUseDataLoader(directUrlItem.allUrls(), directUrlItem.fileKey(), directUrlItem.vid(), directUrlItem.cdnExpiredTime(), directUrlItem.urlExpireTimes());
                                                    break;
                                                } else {
                                                    TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "setDirectUrlUseDataLoader invalid param");
                                                    break;
                                                }
                                            default:
                                                switch (i) {
                                                    case 50:
                                                        if (message.arg1 != 1) {
                                                            z = false;
                                                        }
                                                        tTVideoEngineImpl._doSetAsyncInit(z, message.arg2);
                                                        break;
                                                    case IVideoEventLogger.LOGGER_OPTION_ENABLE_PLAYER_DEGRADE /* 51 */:
                                                        if (obj != null) {
                                                            tTVideoEngineImpl._setUnSupportSampleRates((int[]) obj);
                                                            break;
                                                        } else {
                                                            TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "_setUnSupportSampleRates invalid param");
                                                            break;
                                                        }
                                                    case IVideoEventLogger.LOGGER_OPTION_IS_DEGRADE_RELEASE /* 52 */:
                                                        tTVideoEngineImpl._doSetTestSpeedEnable(message.arg1);
                                                        break;
                                                    case ITTVideoEngineInternal.PLAYER_OPTION_GET_WATCHED_DUTATION /* 53 */:
                                                        if (obj != null) {
                                                            tTVideoEngineImpl._doSetPlaybackParams((PlaybackParams) obj);
                                                            break;
                                                        } else {
                                                            TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "_doSetPlaybackParams invalid param");
                                                            break;
                                                        }
                                                    case 54:
                                                        tTVideoEngineImpl.lambda$_setSurfaceSync$5((Surface) obj);
                                                        break;
                                                    case 55:
                                                        SurfaceHolder surfaceHolder = (SurfaceHolder) obj;
                                                        if (message.arg1 != 1) {
                                                            z = false;
                                                        }
                                                        tTVideoEngineImpl._doSetSurfaceHolder(surfaceHolder, z);
                                                        break;
                                                    case 56:
                                                        tTVideoEngineImpl._doSetPlayerSurface((Surface) obj, message.arg1);
                                                        break;
                                                    case 57:
                                                        String str8 = (String) obj;
                                                        if (map != null && map.containsKey("paramObj1")) {
                                                            str4 = (String) map.get("paramObj1");
                                                        }
                                                        tTVideoEngineImpl._doSetCustomHeader(str8, str4);
                                                        break;
                                                    case 58:
                                                        tTVideoEngineImpl._doSetWindowClient((TTAVWindowClient) obj);
                                                        break;
                                                    default:
                                                        switch (i) {
                                                            case 101:
                                                                tTVideoEngineImpl._doSetIntOption(message.arg1, message.arg2);
                                                                break;
                                                            case 102:
                                                                if (obj != null) {
                                                                    tTVideoEngineImpl._doSetLongOption(message.arg1, ((Long) obj).longValue());
                                                                    break;
                                                                } else if (TTVideoEngineLog.isPredicateLoglevelTurnOn(5)) {
                                                                    TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "_doSetLongOption invalid param for key:" + message.arg1);
                                                                    break;
                                                                }
                                                                break;
                                                            case 103:
                                                                int _doGetIntOption = tTVideoEngineImpl._doGetIntOption(message.arg1);
                                                                TTVideoEngineLooperThread2.this.mEngineMsgRetValue.setDataPosition(0);
                                                                TTVideoEngineLooperThread2.this.mEngineMsgRetValue.writeInt(_doGetIntOption);
                                                                break;
                                                            case 104:
                                                                long _doGetLongOption = tTVideoEngineImpl._doGetLongOption(message.arg1);
                                                                TTVideoEngineLooperThread2.this.mEngineMsgRetValue.setDataPosition(0);
                                                                TTVideoEngineLooperThread2.this.mEngineMsgRetValue.writeLong(_doGetLongOption);
                                                                break;
                                                            default:
                                                                switch (i) {
                                                                    case 106:
                                                                        float _doGetFloatOption = tTVideoEngineImpl._doGetFloatOption(message.arg1);
                                                                        TTVideoEngineLooperThread2.this.mEngineMsgRetValue.setDataPosition(0);
                                                                        TTVideoEngineLooperThread2.this.mEngineMsgRetValue.writeFloat(_doGetFloatOption);
                                                                        break;
                                                                    case 107:
                                                                        String _doGetStringOption = tTVideoEngineImpl._doGetStringOption(message.arg1);
                                                                        TTVideoEngineLooperThread2.this.mEngineMsgRetValue.setDataPosition(0);
                                                                        TTVideoEngineLooperThread2.this.mEngineMsgRetValue.writeString(_doGetStringOption);
                                                                        break;
                                                                    case 108:
                                                                        if (obj != null) {
                                                                            tTVideoEngineImpl._doSetStringOption(message.arg1, (String) obj);
                                                                            break;
                                                                        } else if (TTVideoEngineLog.isPredicateLoglevelTurnOn(5)) {
                                                                            TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "_doSetStrungOption invalid param for key:" + message.arg1);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 109:
                                                                        if (obj != null) {
                                                                            tTVideoEngineImpl._doSetObjectOption(message.arg1, obj);
                                                                            break;
                                                                        } else if (TTVideoEngineLog.isPredicateLoglevelTurnOn(5)) {
                                                                            TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "_doSetObjectOption invalid param for key:" + message.arg1);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    default:
                                                                        switch (i) {
                                                                            case 150:
                                                                                boolean _doIsSystemPlayer = tTVideoEngineImpl._doIsSystemPlayer();
                                                                                TTVideoEngineLooperThread2.this.mEngineMsgRetValue.setDataPosition(0);
                                                                                TTVideoEngineLooperThread2.this.mEngineMsgRetValue.writeInt(_doIsSystemPlayer ? 1 : 0);
                                                                                break;
                                                                            case 151:
                                                                                int _doGetCurrentPlaybackTime = tTVideoEngineImpl._doGetCurrentPlaybackTime();
                                                                                TTVideoEngineLooperThread2.this.mEngineMsgRetValue.setDataPosition(0);
                                                                                TTVideoEngineLooperThread2.this.mEngineMsgRetValue.writeInt(_doGetCurrentPlaybackTime);
                                                                                break;
                                                                            case 152:
                                                                                int videoWidth = tTVideoEngineImpl.getVideoWidth();
                                                                                TTVideoEngineLooperThread2.this.mEngineMsgRetValue.setDataPosition(0);
                                                                                TTVideoEngineLooperThread2.this.mEngineMsgRetValue.writeInt(videoWidth);
                                                                                break;
                                                                            case 153:
                                                                                int videoHeight = tTVideoEngineImpl.getVideoHeight();
                                                                                TTVideoEngineLooperThread2.this.mEngineMsgRetValue.setDataPosition(0);
                                                                                TTVideoEngineLooperThread2.this.mEngineMsgRetValue.writeInt(videoHeight);
                                                                                break;
                                                                            case 154:
                                                                                JSONObject _doGetPlayErrorInfo = tTVideoEngineImpl._doGetPlayErrorInfo();
                                                                                if (_doGetPlayErrorInfo != null) {
                                                                                    str3 = _doGetPlayErrorInfo.toString();
                                                                                }
                                                                                TTVideoEngineLooperThread2.this.mEngineMsgRetValue.setDataPosition(0);
                                                                                TTVideoEngineLooperThread2.this.mEngineMsgRetValue.writeValue(str3);
                                                                                break;
                                                                            case 155:
                                                                                boolean _doIsMute = tTVideoEngineImpl._doIsMute();
                                                                                TTVideoEngineLooperThread2.this.mEngineMsgRetValue.setDataPosition(0);
                                                                                TTVideoEngineLooperThread2.this.mEngineMsgRetValue.writeInt(_doIsMute ? 1 : 0);
                                                                                break;
                                                                            case 156:
                                                                                TTVideoEngineLooperThread2.this.mEngineMsgRetValue.writeInt(tTVideoEngineImpl._doSupportByteVC1Playback() ? 1 : 0);
                                                                                break;
                                                                            case 157:
                                                                                TTVideoEngineLooperThread2.this.mEngineMsgRetValue.writeInt(tTVideoEngineImpl._doSupportByteVC2Playback() ? 1 : 0);
                                                                                break;
                                                                            default:
                                                                                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(5)) {
                                                                                    TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "unknown message: " + message.what);
                                                                                    break;
                                                                                }
                                                                                break;
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                            } else if (obj != null) {
                                IVideoModel iVideoModel = (IVideoModel) obj;
                                if (map.get("paramObj1") != null) {
                                    error = (Error) map.get("paramObj1");
                                }
                                tTVideoEngineImpl._doParseIPAddress(iVideoModel, error);
                            } else {
                                TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "_doParseDNSComplete no model");
                            }
                        } else if (obj != null) {
                            tTVideoEngineImpl._doParseDNSComplete((String) obj);
                        } else {
                            TTVideoEngineLog.w(TTVideoEngineImpl.this.logcatTag(), "_doParseDNSComplete invalid param");
                        }
                    } else {
                        TTVideoEngineImpl.this._doSetTraitObject(message.arg1, (TraitObject) obj);
                    }
                } else {
                    tTVideoEngineImpl._doClearTextureRef();
                }
                TTVideoEngineLooperThread2 tTVideoEngineLooperThread2 = TTVideoEngineLooperThread2.this;
                tTVideoEngineLooperThread2.notifyMsgComplete(tTVideoEngineLooperThread2.mEngineMsgLock, condition);
            }

            public MessageHandler(TTVideoEngineImpl tTVideoEngineImpl) {
                this.mEngineRef = null;
                this.mEngineRef = new WeakReference<>(tTVideoEngineImpl);
            }

            public MessageHandler(TTVideoEngineImpl tTVideoEngineImpl, Looper looper) {
                super(looper);
                this.mEngineRef = null;
                this.mEngineRef = new WeakReference<>(tTVideoEngineImpl);
            }
        }

        void notifyMsgComplete(Lock lock, Condition condition) {
            if (condition != null) {
                lock.lock();
                condition.signal();
                lock.unlock();
            }
        }

        void postEngineMessage(int i, int i2) {
            postEngineMessage(i, i2, 0, null);
        }

        void postEngineMessageDelay(int i, int i2) {
            postEngineMessageDelay(i, 0, 0, null, null, i2);
        }

        boolean sendEngineMessage(int i, long j) {
            return sendEngineMessage(i, j, 0, 0, null);
        }

        public void setIntValue(int i, int i2) {
            boolean z;
            if (i == 0) {
                if (i2 != 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.mInjectedMsgNotAllowDestroy = z;
            }
        }

        TTVideoEngineLooperThread2(TTVideoEngineImpl tTVideoEngineImpl) {
            this.mEngine = tTVideoEngineImpl;
        }

        public void start(HandlerThread handlerThread, Looper looper) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(TTVideoEngineImpl.this.logcatTag(), "start, handlerThread:" + handlerThread);
            }
            this.lastHandlerThreadStr = handlerThread + "";
            this.lastCallbackLooperStr = looper + "";
            this.mEngineMsgLock = new ReentrantLock();
            this.mCondList = new ArrayList();
            this.mEngineMsgRetValue = Parcel.obtain();
            if (handlerThread != null) {
                this.mMessageThread = handlerThread;
                this.mInjectedMsgThread = true;
                this.isLastHandlerThreadNull = false;
            } else {
                this.mMessageThread = new HandlerThread("engineMsgLooper");
                this.isLastHandlerThreadNull = true;
            }
            if (this.mMessageThread.getLooper() == null) {
                this.mMessageThread.start();
            }
            this.mEngineMsgHandler = new MessageHandler(this.mEngine, this.mMessageThread.getLooper());
            this.mMainMsgLock = new ReentrantLock();
            this.mMainMsgRetValue = Parcel.obtain();
            if (looper == null) {
                if (Looper.myLooper() == null) {
                    looper = Looper.getMainLooper();
                } else {
                    looper = Looper.myLooper();
                }
            }
            this.mMainLooperHandler = new MyMainLooperHandler(this.mEngine, looper);
            TTVideoEngineLog.i(TTVideoEngineImpl.this.logcatTag(), "enable engine looper thread");
        }

        void postEngineMessage(int i, int i2, int i3) {
            postEngineMessage(i, i2, i3, null);
        }

        boolean sendEngineMessage(int i, long j, int i2) {
            return sendEngineMessage(i, j, i2, 0, null);
        }

        void postMainLooperMessage(int i, int i2, int i3, Object obj) {
            postMainLooperMessage(i, i2, i3, obj, null);
        }

        void postEngineMessage(int i, int i2, int i3, Object obj) {
            postEngineMessage(i, i2, i3, obj, null);
        }

        boolean sendEngineMessage(int i, long j, int i2, int i3) {
            return sendEngineMessage(i, j, i2, i3, null);
        }

        void sendMainLooperMessage(int i, int i2, int i3, Object obj) {
            if (this.mMainLooperHandler != null) {
                HashMap hashMap = new HashMap();
                Condition newCondition = this.mMainMsgLock.newCondition();
                Message obtainMessage = this.mMainLooperHandler.obtainMessage(i, i2, i3);
                hashMap.put("paramObj", obj);
                hashMap.put("msgCond", newCondition);
                try {
                    try {
                        this.mMainMsgLock.lock();
                        this.mIsHandlingMainMsg = true;
                        obtainMessage.obj = hashMap;
                        obtainMessage.sendToTarget();
                        newCondition.await();
                        this.mIsHandlingMainMsg = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    this.mMainMsgLock.unlock();
                }
            }
        }

        public void TTVideoEngineImpl$TTVideoEngineLooperThread2__postMainLooperMessage$___twin___(int i, int i2, int i3, Object obj, Object obj2) {
            if (this.mMainLooperHandler != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("paramObj", obj);
                if (obj2 != null) {
                    hashMap.put("paramObj1", obj2);
                }
                Message obtainMessage = this.mMainLooperHandler.obtainMessage(i, i2, i3);
                obtainMessage.obj = hashMap;
                obtainMessage.sendToTarget();
            }
        }

        void postEngineMessage(int i, int i2, int i3, Object obj, Object obj2) {
            postEngineMessage(i, i2, i3, obj, obj2, null);
        }

        boolean sendEngineMessage(int i, long j, int i2, int i3, Object obj) {
            return sendEngineMessage(i, j, i2, i3, obj, null);
        }

        @TargetClass("com.ss.ttvideoengine.TTVideoEngineImpl$TTVideoEngineLooperThread2")
        @Insert("postMainLooperMessage")
        public static void com_ss_ttvideoengine_TTVideoEngineImpl$TTVideoEngineLooperThread2_com_dragon_read_aop_TTVideoEngineAop_postMainLooperMessage(TTVideoEngineLooperThread2 tTVideoEngineLooperThread2, int i, int i2, int i3, Object obj, Object obj2) {
            Handler handler;
            if (EngineMsgOptConfig.d().enable) {
                try {
                    handler = tTVideoEngineLooperThread2.mMainLooperHandler;
                } catch (Exception unused) {
                    handler = null;
                }
                if (handler instanceof Handler) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("paramObj", obj);
                    if (obj2 != null) {
                        hashMap.put("paramObj1", obj2);
                    }
                    Message obtainMessage = handler.obtainMessage(i, i2, i3);
                    obtainMessage.obj = hashMap;
                    handler.sendMessageAtTime(obtainMessage, 1L);
                    return;
                }
                tTVideoEngineLooperThread2.TTVideoEngineImpl$TTVideoEngineLooperThread2__postMainLooperMessage$___twin___(i, i2, i3, obj, obj2);
                return;
            }
            tTVideoEngineLooperThread2.TTVideoEngineImpl$TTVideoEngineLooperThread2__postMainLooperMessage$___twin___(i, i2, i3, obj, obj2);
        }

        void postEngineMessageDelay(int i, int i2, int i3, Object obj, Object obj2, int i4) {
            Handler handler;
            if (this.mEngine.mState != 5 && (handler = this.mEngineMsgHandler) != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("paramObj", obj);
                if (obj2 != null) {
                    hashMap.put("paramObj1", obj2);
                }
                Message obtainMessage = handler.obtainMessage(i, i2, i3);
                obtainMessage.obj = hashMap;
                handler.postDelayed(new RunnableMsgHandler(handler, obtainMessage), i4);
            }
        }

        void postEngineMessage(int i, int i2, int i3, Object obj, Object obj2, Object obj3) {
            Handler handler;
            if (this.mEngine.mState != 5 && (handler = this.mEngineMsgHandler) != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("paramObj", obj);
                if (obj2 != null) {
                    hashMap.put("paramObj1", obj2);
                }
                if (obj3 != null) {
                    hashMap.put("paramObj2", obj3);
                }
                Message obtainMessage = handler.obtainMessage(i, i2, i3);
                obtainMessage.obj = hashMap;
                obtainMessage.sendToTarget();
            }
        }

        boolean sendEngineMessage(int i, long j, int i2, int i3, Object obj, Object obj2) {
            return sendEngineMessage(i, j, i2, i3, obj, obj2, false);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x00a4, code lost:
        
            if (r5.mEngine.mState == 5) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00b4, code lost:
        
            r1 = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00b5, code lost:
        
            r5.mCondList.remove(r4);
            r5.mEngineMsgLock.unlock();
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00b1, code lost:
        
            if (r5.mEngine.mState != 5) goto L45;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        boolean sendEngineMessage(int r6, long r7, int r9, int r10, java.lang.Object r11, java.lang.Object r12, boolean r13) {
            /*
                r5 = this;
                com.ss.ttvideoengine.TTVideoEngineImpl r0 = r5.mEngine
                int r0 = r0.mState
                r1 = 0
                r2 = 5
                if (r0 != r2) goto L9
                return r1
            L9:
                android.os.Handler r0 = r5.mEngineMsgHandler
                if (r0 == 0) goto Lcf
                java.util.concurrent.locks.Lock r3 = r5.mEngineMsgLock
                if (r3 == 0) goto Lcf
                java.util.HashMap r3 = new java.util.HashMap
                r3.<init>()
                java.util.concurrent.locks.Lock r4 = r5.mEngineMsgLock
                java.util.concurrent.locks.Condition r4 = r4.newCondition()
                android.os.Message r9 = r0.obtainMessage(r6, r9, r10)
                java.lang.String r10 = "paramObj"
                r3.put(r10, r11)
                java.lang.String r10 = "msgCond"
                r3.put(r10, r4)
                if (r12 == 0) goto L31
                java.lang.String r10 = "paramObj1"
                r3.put(r10, r12)
            L31:
                r10 = 1
                java.util.concurrent.locks.Lock r11 = r5.mEngineMsgLock     // Catch: java.lang.Throwable -> La7 java.lang.InterruptedException -> La9
                r11.lock()     // Catch: java.lang.Throwable -> La7 java.lang.InterruptedException -> La9
                com.ss.ttvideoengine.TTVideoEngineImpl r11 = r5.mEngine     // Catch: java.lang.Throwable -> La7 java.lang.InterruptedException -> La9
                int r11 = r11.mState     // Catch: java.lang.Throwable -> La7 java.lang.InterruptedException -> La9
                if (r11 != r2) goto L48
                java.util.List<java.util.concurrent.locks.Condition> r6 = r5.mCondList
                r6.remove(r4)
                java.util.concurrent.locks.Lock r6 = r5.mEngineMsgLock
                r6.unlock()
                return r1
            L48:
                java.util.List<java.util.concurrent.locks.Condition> r11 = r5.mCondList     // Catch: java.lang.Throwable -> La7 java.lang.InterruptedException -> La9
                r11.add(r4)     // Catch: java.lang.Throwable -> La7 java.lang.InterruptedException -> La9
                r9.obj = r3     // Catch: java.lang.Throwable -> La7 java.lang.InterruptedException -> La9
                if (r13 == 0) goto L55
                r0.sendMessageAtFrontOfQueue(r9)     // Catch: java.lang.Throwable -> La7 java.lang.InterruptedException -> La9
                goto L58
            L55:
                r9.sendToTarget()     // Catch: java.lang.Throwable -> La7 java.lang.InterruptedException -> La9
            L58:
                r11 = 0
                int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
                if (r9 <= 0) goto L9d
                java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> La7 java.lang.InterruptedException -> La9
                boolean r9 = r4.await(r7, r9)     // Catch: java.lang.Throwable -> La7 java.lang.InterruptedException -> La9
                if (r9 != 0) goto La0
                boolean r11 = r0.hasMessages(r6)     // Catch: java.lang.InterruptedException -> L9a java.lang.Throwable -> La7
                if (r11 == 0) goto La0
                r10 = 2
                boolean r10 = com.ss.ttvideoengine.utils.TTVideoEngineLog.isPredicateLoglevelTurnOn(r10)     // Catch: java.lang.InterruptedException -> L9a java.lang.Throwable -> La7
                if (r10 == 0) goto L95
                com.ss.ttvideoengine.TTVideoEngineImpl r10 = com.ss.ttvideoengine.TTVideoEngineImpl.this     // Catch: java.lang.InterruptedException -> L9a java.lang.Throwable -> La7
                java.lang.String r10 = r10.logcatTag()     // Catch: java.lang.InterruptedException -> L9a java.lang.Throwable -> La7
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.InterruptedException -> L9a java.lang.Throwable -> La7
                r11.<init>()     // Catch: java.lang.InterruptedException -> L9a java.lang.Throwable -> La7
                java.lang.String r12 = "handle message "
                r11.append(r12)     // Catch: java.lang.InterruptedException -> L9a java.lang.Throwable -> La7
                r11.append(r6)     // Catch: java.lang.InterruptedException -> L9a java.lang.Throwable -> La7
                java.lang.String r12 = " timeout "
                r11.append(r12)     // Catch: java.lang.InterruptedException -> L9a java.lang.Throwable -> La7
                r11.append(r7)     // Catch: java.lang.InterruptedException -> L9a java.lang.Throwable -> La7
                java.lang.String r7 = r11.toString()     // Catch: java.lang.InterruptedException -> L9a java.lang.Throwable -> La7
                com.ss.ttvideoengine.utils.TTVideoEngineLog.i(r10, r7)     // Catch: java.lang.InterruptedException -> L9a java.lang.Throwable -> La7
            L95:
                r0.removeMessages(r6)     // Catch: java.lang.InterruptedException -> L9a java.lang.Throwable -> La7
                r10 = 0
                goto La0
            L9a:
                r6 = move-exception
                r10 = r9
                goto Laa
            L9d:
                r4.await()     // Catch: java.lang.Throwable -> La7 java.lang.InterruptedException -> La9
            La0:
                com.ss.ttvideoengine.TTVideoEngineImpl r6 = r5.mEngine
                int r6 = r6.mState
                if (r6 != r2) goto Lb4
                goto Lb5
            La7:
                r6 = move-exception
                goto Lc0
            La9:
                r6 = move-exception
            Laa:
                r6.printStackTrace()     // Catch: java.lang.Throwable -> La7
                com.ss.ttvideoengine.TTVideoEngineImpl r6 = r5.mEngine
                int r6 = r6.mState
                if (r6 != r2) goto Lb4
                goto Lb5
            Lb4:
                r1 = r10
            Lb5:
                java.util.List<java.util.concurrent.locks.Condition> r6 = r5.mCondList
                r6.remove(r4)
                java.util.concurrent.locks.Lock r6 = r5.mEngineMsgLock
                r6.unlock()
                goto Lcf
            Lc0:
                com.ss.ttvideoengine.TTVideoEngineImpl r7 = r5.mEngine
                int r7 = r7.mState
                java.util.List<java.util.concurrent.locks.Condition> r7 = r5.mCondList
                r7.remove(r4)
                java.util.concurrent.locks.Lock r7 = r5.mEngineMsgLock
                r7.unlock()
                throw r6
            Lcf:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.TTVideoEngineImpl.TTVideoEngineLooperThread2.sendEngineMessage(int, long, int, int, java.lang.Object, java.lang.Object, boolean):boolean");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$_fetchVideoInfo$7() {
        _parseIPAddress(this.mVideoModel);
    }

    boolean _doIsMute() {
        return super.isMute();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public int getAudioLatencytime() {
        return getAudioLatencyTime();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public List<String> getCacheKeys() {
        return new ArrayList(this.mUsingDataLoaderPlayTaskKeys);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public StrategySource getStrategySource() {
        return this.mCodecStrategyAdapter.getStrategySource();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public EventLoggerSource getVideoEngineDataSource() {
        return new MyLoggerDataSource(this);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean isReportLogEnable() {
        return this.mLogger.isUploadLogEnabled();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean isSupportHDR() {
        return InfoWrapper.isHDREnable();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean isSupportSR() {
        return InfoWrapper.isSREnable();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean isSystemPlayer() {
        return _doIsSystemPlayer();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal, com.ss.ttvideoengine.TTVideoEngineInterface
    public String logcatTag() {
        return this.mEngineWrapper.logcatTag();
    }

    /* renamed from: com.ss.ttvideoengine.TTVideoEngineImpl$8, reason: invalid class name */
    class AnonymousClass8 implements TTAVWindowClient.ExternalInterface {
        final /* synthetic */ MediaPlayer val$mediaplayer;

        @Override // com.ss.ttm.player.TTAVWindowClient.ExternalInterface
        public void onWindowDestroyed() {
            TTVideoEngineImpl.this._doExternalWindowUseSurface(null);
            TTVideoEngineImpl.this.mRefactorSurface = null;
        }

        @Override // com.ss.ttm.player.TTAVWindowClient.ExternalInterface
        public void onNewWindowAvailable(Surface surface) {
            TTVideoEngineImpl.this._doExternalWindowUseSurface(surface);
            TTVideoEngineImpl.this.mRefactorSurface = surface;
        }

        @Override // com.ss.ttm.player.TTAVWindowClient.ExternalInterface
        public void snapshotBitmap(final TTAVWindowClient.SnapshotListener snapshotListener) {
            TTVideoEngineImpl.this.snapshot(new SnapshotListener() { // from class: com.ss.ttvideoengine.l
                @Override // com.ss.ttvideoengine.SnapshotListener
                public final void onSnapShot(Bitmap bitmap, int i, int i2) {
                    TTVideoEngineImpl.AnonymousClass8.lambda$snapshotBitmap$0(TTAVWindowClient.SnapshotListener.this, bitmap, i, i2);
                }
            });
        }

        AnonymousClass8(MediaPlayer mediaPlayer) {
            this.val$mediaplayer = mediaPlayer;
        }

        @Override // com.ss.ttm.player.TTAVWindowClient.ExternalInterface
        public void onWindowChanged(int i, int i2) {
            TTVideoEngineImpl.this.mWindowWidth = i;
            TTVideoEngineImpl.this.mWindowHeight = i2;
            VideoSurface videoSurface = TTVideoEngineImpl.this.mTextureSurface;
            if (videoSurface != null) {
                videoSurface.setSurfaceDimensions(i, i2);
                if (!this.val$mediaplayer.isPlaying()) {
                    videoSurface.setIntOption(25, 1);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$snapshotBitmap$0(TTAVWindowClient.SnapshotListener snapshotListener, Bitmap bitmap, int i, int i2) {
            int i3;
            if (snapshotListener != null) {
                if (bitmap != null) {
                    i3 = 0;
                } else {
                    i3 = -1;
                }
                snapshotListener.onResult(i3, bitmap);
            }
        }
    }

    private static class MyPlayStateSupplier implements IPlayStateSupplier {
        private final WeakReference<TTVideoEngineImpl> mVideoEngineRef;
        private int mSidxVideoWindowSize = -1;
        private int mSidxAudioWindowSize = -1;

        static {
            Covode.recordClassIndex(652344);
        }

        public Queue<Object> getTimelineNetworkSpeed() {
            return null;
        }

        public int getNetworkState() {
            return TTNetWorkListener.getInstance().getCurrentAccessType();
        }

        public int getCurrentDownloadAudioBitrate() {
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null) {
                return -1;
            }
            return tTVideoEngineImpl.mABRCurrentDownloadedAudioBitrate;
        }

        public int getCurrentDownloadAudioSegmentIndex() {
            MediaPlayer mediaPlayer;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null || (mediaPlayer = tTVideoEngineImpl.mMediaPlayer) == null) {
                return -1;
            }
            return mediaPlayer.getIntOption(519, -1);
        }

        public int getCurrentDownloadVideoBitrate() {
            MediaPlayer mediaPlayer;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null || (mediaPlayer = tTVideoEngineImpl.mMediaPlayer) == null) {
                return -1;
            }
            return mediaPlayer.getIntOption(601, -1);
        }

        public int getCurrentDownloadVideoSegmentIndex() {
            MediaPlayer mediaPlayer;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null || (mediaPlayer = tTVideoEngineImpl.mMediaPlayer) == null) {
                return -1;
            }
            return mediaPlayer.getIntOption(520, -1);
        }

        public int getCurrentPlaybackTime() {
            MediaPlayer mediaPlayer;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null || (mediaPlayer = tTVideoEngineImpl.mMediaPlayer) == null) {
                return -1;
            }
            return mediaPlayer.getCurrentPosition();
        }

        public int getMaxCacheAudioTime() {
            MediaPlayer mediaPlayer;
            int intOption;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null || (mediaPlayer = tTVideoEngineImpl.mMediaPlayer) == null || (intOption = mediaPlayer.getIntOption(24, -1)) <= 0) {
                return 30000;
            }
            return intOption * 1000;
        }

        public int getMaxCacheVideoTime() {
            MediaPlayer mediaPlayer;
            int intOption;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null || (mediaPlayer = tTVideoEngineImpl.mMediaPlayer) == null || (intOption = mediaPlayer.getIntOption(24, -1)) <= 0) {
                return 30000;
            }
            return intOption * 1000;
        }

        public float getPlaySpeed() {
            PlaybackParams playbackParams;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null || (playbackParams = tTVideoEngineImpl.mPlaybackParams) == null) {
                return 1.0f;
            }
            return playbackParams.getSpeed();
        }

        public int getPlayerAudioCacheTime() {
            MediaPlayer mediaPlayer;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null || (mediaPlayer = tTVideoEngineImpl.mMediaPlayer) == null) {
                return -1;
            }
            return (int) mediaPlayer.getLongOption(73, -1L);
        }

        public int getPlayerVideoCacheTime() {
            MediaPlayer mediaPlayer;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null || (mediaPlayer = tTVideoEngineImpl.mMediaPlayer) == null) {
                return -1;
            }
            return (int) mediaPlayer.getLongOption(72, -1L);
        }

        public float getDownloadSpeed() {
            Map f;
            ss1.b bVar = StrategyCenter.sNetAbrSpeedPredictor;
            if (bVar != null && (f = bVar.f(VideoRef.TYPE_VIDEO)) != null && f.get("download_speed") != null) {
                return Float.parseFloat((String) f.get("download_speed"));
            }
            return -1.0f;
        }

        public int getLoaderType() {
            MediaPlayer mediaPlayer;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null || (mediaPlayer = tTVideoEngineImpl.mMediaPlayer) == null) {
                return -1;
            }
            try {
                return Integer.parseInt(mediaPlayer.getStringOption(200));
            } catch (Exception e) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(e);
                }
                return -1;
            }
        }

        public float getNetworkSpeed() {
            ss1.b bVar = StrategyCenter.sNetAbrSpeedPredictor;
            if (bVar != null) {
                float d = bVar.d(0);
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(TTVideoEngineInternal.logcatTag(this.mVideoEngineRef.get()), "[ABR] get network speed:" + d);
                }
                return d;
            }
            return -1.0f;
        }

        public float getSpeedConfidence() {
            ss1.b bVar = StrategyCenter.sNetAbrSpeedPredictor;
            if (bVar != null) {
                float a = bVar.a();
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(TTVideoEngineInternal.logcatTag(this.mVideoEngineRef.get()), "[ABR] get network confidence:" + a);
                }
                return a;
            }
            return -1.0f;
        }

        public Map<String, Object> getAudioBufferInfo() {
            List<VideoInfo> videoInfoList;
            HashMap hashMap = new HashMap();
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl != null && tTVideoEngineImpl.mVideoModel != null && (videoInfoList = tTVideoEngineImpl.mVideoModel.getVideoInfoList()) != null && videoInfoList.size() != 0) {
                for (VideoInfo videoInfo : videoInfoList) {
                    if (videoInfo != null && videoInfo.getMediatype() == VideoRef.TYPE_AUDIO) {
                        rs1.b bVar = new rs1.b();
                        String valueStr = videoInfo.getValueStr(15);
                        bVar.a = valueStr;
                        bVar.c = TTVideoEngine.getCacheFileSize(valueStr);
                        if (videoInfo.getBitrateFitterInfo() != null) {
                            bVar.d = r4.getHeaderSize();
                        }
                        hashMap.put("" + videoInfo.getValueInt(3), bVar);
                    }
                }
            }
            return hashMap;
        }

        public Map<String, Object> getVideoBufferInfo() {
            List<VideoInfo> videoInfoList;
            HashMap hashMap = new HashMap();
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl != null && tTVideoEngineImpl.mVideoModel != null && (videoInfoList = tTVideoEngineImpl.mVideoModel.getVideoInfoList()) != null && videoInfoList.size() != 0) {
                for (VideoInfo videoInfo : videoInfoList) {
                    if (videoInfo != null && videoInfo.getMediatype() == VideoRef.TYPE_VIDEO) {
                        rs1.b bVar = new rs1.b();
                        String valueStr = videoInfo.getValueStr(15);
                        bVar.a = valueStr;
                        bVar.c = TTVideoEngine.getCacheFileSize(valueStr);
                        if (videoInfo.getBitrateFitterInfo() != null) {
                            bVar.d = r4.getHeaderSize();
                        }
                        hashMap.put("" + videoInfo.getValueInt(3), bVar);
                    }
                }
            }
            return hashMap;
        }

        public MyPlayStateSupplier(TTVideoEngineImpl tTVideoEngineImpl) {
            this.mVideoEngineRef = new WeakReference<>(tTVideoEngineImpl);
        }

        public List<Object> getSegmentInfoList(int i, int i2) {
            MediaPlayer mediaPlayer;
            Object objectOption;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null || (mediaPlayer = tTVideoEngineImpl.mMediaPlayer) == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (i != this.mSidxVideoWindowSize) {
                this.mSidxVideoWindowSize = i;
                mediaPlayer.setIntOption(522, i);
            }
            if (i2 != this.mSidxAudioWindowSize) {
                this.mSidxAudioWindowSize = i2;
                mediaPlayer.setIntOption(523, i2);
            }
            if ((mediaPlayer instanceof MediaPlayerWrapper) && (objectOption = ((MediaPlayerWrapper) mediaPlayer).getObjectOption(521)) != null) {
                for (Object obj : (Object[]) objectOption) {
                    arrayList.add(new SegmentInfo(obj));
                }
            }
            return arrayList;
        }

        public float getAverageDownloadSpeed(int i, int i2, boolean z) {
            ss1.b bVar = StrategyCenter.sNetAbrSpeedPredictor;
            if (bVar != null) {
                return bVar.c(i, i2, z);
            }
            return -1.0f;
        }
    }

    private class URLInfo {
        public String hostURL;
        public String ipURL;
        public boolean isIp;

        static {
            Covode.recordClassIndex(652355);
        }

        public String getCurrentURL() {
            if (this.isIp) {
                return this.ipURL;
            }
            return this.hostURL;
        }

        public void reset() {
            this.hostURL = null;
            this.ipURL = null;
            this.isIp = false;
        }

        public void setHostURL(String str) {
            this.hostURL = str;
            this.isIp = false;
        }

        public void setIpURL(String str) {
            this.ipURL = str;
            this.isIp = true;
        }

        private URLInfo() {
            this.isIp = false;
        }
    }

    private boolean _checkRefreshSurface() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || mediaPlayer.getIntOption(1320, 0) != 1) {
            return false;
        }
        return true;
    }

    private void _dataLoaderAddEngineRef() {
        DataLoaderHelper.getDataLoader()._addEngine(this.mEngineWrapper, this.mUsingDataLoaderPlayRawKey);
    }

    private int _getPlayerTime() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getCurrentPosition();
    }

    void _doStart() {
        this.mShouldPlay = true;
        this.mShouldStop = false;
        this.mUserStopped = false;
        this.mAccumulatedErrorCount = 0;
        _play(true);
        this.mIsPlayComplete = false;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public synchronized void createPlayer() {
        if (this.mAsyncPlayer == null) {
            this.mAsyncPlayer = createMediaPlayer();
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public int getAudioLatencyTime() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getIntOption(567, 0);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getCurrentPlayPath() {
        if (this.mIsLocal) {
            return this.mLocalURL;
        }
        return this.mURLInfo.hostURL;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public TTVNetClient getNetClientSetByUser() {
        TTVNetClient tTVNetClient = this.mNetClient;
        if (tTVNetClient != null) {
            return tTVNetClient;
        }
        TTVNetClient tTVNetClient2 = TTVideoEngineConfig.gNetClient;
        if (tTVNetClient2 != null) {
            return tTVNetClient2;
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getPlayerSessionId() {
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            return iVideoEventLogger.getStringOption(86);
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return null;
        }
        return mediaPlayer.getTrackInfo();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public VideoModel getVideoModel() {
        IVideoModel iVideoModel = this.mVideoModel;
        if (iVideoModel instanceof VideoModel) {
            return (VideoModel) iVideoModel;
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void saveEvent() {
        this.mLooperThread.runOnLooperThread(new Runnable() { // from class: com.ss.ttvideoengine.a
            @Override // java.lang.Runnable
            public final void run() {
                TTVideoEngineImpl.this.lambda$saveEvent$6();
            }
        });
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public Bitmap saveFrame() {
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface == null) {
            return null;
        }
        try {
            return videoSurface.saveFrame();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String[] supportedQualityInfos() {
        IVideoModel iVideoModel = this.mVideoModel;
        if (iVideoModel != null) {
            return iVideoModel.getSupportQualityInfos();
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public List<com.ss.ttvideoengine.model.SubInfo> supportedSubInfoList() {
        IVideoModel iVideoModel = this.mVideoModel;
        if (iVideoModel != null) {
            return iVideoModel.getSubInfoList();
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public int[] supportedSubtitleLangs() {
        IVideoModel iVideoModel = this.mVideoModel;
        if (iVideoModel != null) {
            return iVideoModel.getSupportSubtitleLangs();
        }
        return null;
    }

    private static class MyDNSCompletionListener implements DNSCompletionListener {
        private final WeakReference<TTVideoEngineImpl> mVideoEngineRef;

        static {
            Covode.recordClassIndex(652339);
        }

        @Override // com.ss.ttvideoengine.net.DNSCompletionListener
        public void onCancelled() {
            TTVideoEngineLog.i(TTVideoEngineInternal.logcatTag(this.mVideoEngineRef.get()), "dns cancelled");
        }

        public MyDNSCompletionListener(TTVideoEngineImpl tTVideoEngineImpl) {
            this.mVideoEngineRef = new WeakReference<>(tTVideoEngineImpl);
        }

        @Override // com.ss.ttvideoengine.net.DNSCompletionListener
        public void onRetry(Error error) {
            if (error != null) {
                return;
            }
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                TTVideoEngineLog.e(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "fetcher should retry, error:" + error.toString());
            }
            if (tTVideoEngineImpl == null) {
                return;
            }
            tTVideoEngineImpl.mLogger.firstDNSFailed(error);
        }

        @Override // com.ss.ttvideoengine.net.DNSCompletionListener
        public void onCompletion(JSONObject jSONObject, Error error) {
            String str;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null) {
                return;
            }
            if (tTVideoEngineImpl.mShouldStop) {
                TTVideoEngineLog.w(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "MyDNSCompletionListener should stop");
                return;
            }
            if (error != null) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                    TTVideoEngineLog.e(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "dns failed:" + error.toString());
                }
                tTVideoEngineImpl.receivedError(error);
                return;
            }
            if (jSONObject != null) {
                str = jSONObject.optString("ip");
                long optLong = jSONObject.optLong("time");
                String optString = jSONObject.optString("dns_type");
                if (tTVideoEngineImpl.mLogger != null) {
                    tTVideoEngineImpl.mLogger.setDNSEndTime(optLong);
                    tTVideoEngineImpl.mLogger.setStringOption(86, optString);
                }
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                tTVideoEngineImpl._parseDNSComplete(str);
            } else {
                tTVideoEngineImpl.receivedError(new Error("", -9997, "DNS result empty"));
                TTVideoEngineLog.e(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "dns parse empty");
            }
        }
    }

    private static class MyRenderTrait extends RenderTrait {
        private final String TAG;
        private int mRenderDirectly;
        private WeakReference<TTVideoEngineImpl> mVideoEngineRef;
        private VideoSurface mVideoSurface;

        static {
            Covode.recordClassIndex(652346);
        }

        @Override // com.ss.ttm.player.RenderTrait
        public void onClose() {
            TTVideoEngineLog.i(this.TAG, "close, videoSurface = " + this.mVideoSurface);
            if (this.mVideoSurface != null) {
                this.mVideoSurface = null;
            }
        }

        @Override // com.ss.ttm.player.RenderTrait
        public int onOpen() {
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null) {
                TTVideoEngineLog.e(this.TAG, "videoEngine invalid");
                return -1;
            }
            this.mVideoSurface = tTVideoEngineImpl.mTextureSurface;
            TTVideoEngineLog.i(this.TAG, "open, videoSurface = " + this.mVideoSurface);
            if (this.mVideoSurface == null) {
                return -1;
            }
            return 0;
        }

        @Override // com.ss.ttm.player.RenderTrait
        public int onOpen(int i) {
            return onOpen();
        }

        MyRenderTrait(int i, TTVideoEngineImpl tTVideoEngineImpl, int i2) {
            super(i);
            String str = "MyRenderTrait@0x" + Integer.toHexString(hashCode());
            this.TAG = str;
            this.mVideoEngineRef = new WeakReference<>(tTVideoEngineImpl);
            this.mRenderDirectly = i2;
            TTVideoEngineLog.i(str, "version = " + i + " videoEngine = " + tTVideoEngineImpl + " renderDirectly = " + this.mRenderDirectly);
        }

        @Override // com.ss.ttm.player.RenderTrait
        public int onDrawFrame(HardwareBuffer hardwareBuffer, int[] iArr, int i) {
            try {
                try {
                    TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
                    boolean z = false;
                    if (tTVideoEngineImpl != null && !tTVideoEngineImpl.mShouldStop) {
                        if (this.mVideoSurface != null) {
                            int i2 = i + tTVideoEngineImpl.mRotation;
                            if (i2 != 0) {
                                this.mVideoSurface.setIntOption(29, i2);
                            }
                            int drawFrame = this.mVideoSurface.drawFrame(hardwareBuffer, iArr);
                            if (tTVideoEngineImpl.mRotation != 0) {
                                this.mVideoSurface.setIntOption(29, tTVideoEngineImpl.mRotation);
                            }
                            if (drawFrame != 0 || this.mRenderDirectly != 2) {
                                z = true;
                            }
                            if (z && hardwareBuffer != null && !hardwareBuffer.isClosed()) {
                                hardwareBuffer.close();
                            }
                            return drawFrame;
                        }
                        TTVideoEngineLog.w(this.TAG, "HardwareBuffer render failed");
                        if (hardwareBuffer != null && !hardwareBuffer.isClosed()) {
                            hardwareBuffer.close();
                        }
                        return -1;
                    }
                    TTVideoEngineLog.i(this.TAG, "ignore HardwareBuffer render");
                    if (hardwareBuffer != null && !hardwareBuffer.isClosed()) {
                        hardwareBuffer.close();
                    }
                    return 0;
                } catch (Exception e) {
                    TTVideoEngineLog.e(this.TAG, "HardwareBuffer render exp = " + e);
                    if (hardwareBuffer != null && !hardwareBuffer.isClosed()) {
                        hardwareBuffer.close();
                    }
                    return -1;
                }
            } catch (Throwable th) {
                if (hardwareBuffer != null && !hardwareBuffer.isClosed()) {
                    hardwareBuffer.close();
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _createPlayerAsync() {
        TTVideoEngineLog.i("TTVideoEngine", "create player async");
        if (this.mAsyncPlayer == null) {
            this.mAsyncPlayer = createMediaPlayer();
        }
    }

    private void _initUsingHandle() {
        if (this.mHandler != null) {
            return;
        }
        this.mHandler = new HandlerDelegate(TTHelper.getLooper()) { // from class: com.ss.ttvideoengine.TTVideoEngineImpl.7
            /* JADX WARN: Multi-variable type inference failed */
            public void handleMessage(Message message) {
                String str;
                String str2;
                super/*android.os.Handler*/.handleMessage(message);
                if (message.what == 10) {
                    String str3 = (String) message.obj;
                    long j = message.arg1;
                    int i = message.arg2;
                    String str4 = (String) TTVideoEngineImpl.this.mBashDashDefaultMDLKeys.get("video");
                    String str5 = (String) TTVideoEngineImpl.this.mBashDashDefaultMDLKeys.get("audio");
                    if (TTVideoEngineImpl.this.mState == 5) {
                        return;
                    }
                    if (!TextUtils.isEmpty(str5) && str5.equals(str3)) {
                        if (TTVideoEngineImpl.this.mLogger != null) {
                            TTVideoEngineImpl.this.mLogger.setDashAudioCacheSize(j);
                            TTVideoEngineImpl.this.mLogger.setIntOption(183, i);
                        }
                    } else if (!TextUtils.isEmpty(str4) && str4.equals(str3) && TTVideoEngineImpl.this.mLogger != null) {
                        TTVideoEngineImpl.this.mLogger.setDashVideoCacheSize(j);
                        TTVideoEngineImpl.this.mLogger.setIntOption(182, i);
                    }
                    String str6 = "";
                    if (TTVideoEngineImpl.this.mUsingDataLoaderPlayFilePaths != null && TTVideoEngineImpl.this.mUsingDataLoaderPlayFilePaths.contains(str3)) {
                        TTVideoEngineImpl.this.mVideoPreloadSize += j;
                        if (TTVideoEngineImpl.this.mLogger != null) {
                            TTVideoEngineImpl.this.mLogger.setVideoCacheSize(TTVideoEngineImpl.this.mVideoPreloadSize);
                            TTVideoEngineImpl.this.mLogger.setIntOption(181, i);
                        }
                        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                            String logcatTag = TTVideoEngineImpl.this.logcatTag();
                            StringBuilder sb = new StringBuilder();
                            sb.append("using mdl cache, key :");
                            sb.append(str3);
                            sb.append(" size = ");
                            sb.append(j);
                            sb.append(" vid = ");
                            if (!TextUtils.isEmpty(TTVideoEngineImpl.this.mVideoID)) {
                                str2 = TTVideoEngineImpl.this.mVideoID;
                            } else {
                                str2 = "";
                            }
                            sb.append(str2);
                            sb.append(" groupid = ");
                            if (!TextUtils.isEmpty(TTVideoEngineImpl.this.mMDLGroupId)) {
                                str6 = TTVideoEngineImpl.this.mMDLGroupId;
                            }
                            sb.append(str6);
                            sb.append(" miss reason = ");
                            sb.append(i);
                            TTVideoEngineLog.i(logcatTag, sb.toString());
                        }
                        if ((TTVideoEngineImpl.this.mBashDashDefaultMDLKeys.size() < 2 || TTVideoEngineImpl.this.mBashDashDefaultMDLKeys.containsValue(str3)) && TTVideoEngineImpl.this.mListenerCompact.getVideoEngineInfoListener() != null) {
                            VideoEngineInfos videoEngineInfos = new VideoEngineInfos();
                            videoEngineInfos.setKey("mdlfilepathhitcachesize");
                            videoEngineInfos.mUsingMDLPlayFilePath = str3;
                            videoEngineInfos.mHitCacheSize = j;
                            TTVideoEngineImpl.this.notifyEngineInfo(videoEngineInfos, true);
                            return;
                        }
                        return;
                    }
                    if (TTVideoEngineImpl.this.mUsingDataLoaderPlayTaskKeys != null && TTVideoEngineImpl.this.mUsingDataLoaderPlayTaskKeys.contains(str3)) {
                        TTVideoEngineImpl.this.mVideoPreloadSize += j;
                        if (TTVideoEngineImpl.this.mLogger != null) {
                            TTVideoEngineImpl.this.mLogger.setVideoCacheSize(TTVideoEngineImpl.this.mVideoPreloadSize);
                            TTVideoEngineImpl.this.mLogger.setIntOption(181, i);
                        }
                        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                            String logcatTag2 = TTVideoEngineImpl.this.logcatTag();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("using mdl cache, key :");
                            sb2.append(str3);
                            sb2.append(" size = ");
                            sb2.append(j);
                            sb2.append(" vid = ");
                            if (!TextUtils.isEmpty(TTVideoEngineImpl.this.mVideoID)) {
                                str = TTVideoEngineImpl.this.mVideoID;
                            } else {
                                str = "";
                            }
                            sb2.append(str);
                            sb2.append(" groupid = ");
                            if (!TextUtils.isEmpty(TTVideoEngineImpl.this.mMDLGroupId)) {
                                str6 = TTVideoEngineImpl.this.mMDLGroupId;
                            }
                            sb2.append(str6);
                            sb2.append(" miss reason = ");
                            sb2.append(i);
                            TTVideoEngineLog.i(logcatTag2, sb2.toString());
                        }
                        if ((TTVideoEngineImpl.this.mBashDashDefaultMDLKeys.size() < 2 || TTVideoEngineImpl.this.mBashDashDefaultMDLKeys.containsValue(str3)) && TTVideoEngineImpl.this.mListenerCompact.getVideoEngineInfoListener() != null) {
                            VideoEngineInfos videoEngineInfos2 = new VideoEngineInfos();
                            videoEngineInfos2.setKey("mdlhitcachesize");
                            videoEngineInfos2.mUsingMDLPlayTaskKey = str3;
                            videoEngineInfos2.mHitCacheSize = j;
                            TTVideoEngineImpl.this.notifyEngineInfo(videoEngineInfos2, true);
                        }
                    }
                }
            }
        };
    }

    private void _resetUrlIndexMap() {
        for (Resolution resolution : Resolution.getAllResolutions()) {
            this.urlIndexMap.put(resolution, 0);
            this.dashVideoUrlMap.put(resolution, "");
        }
    }

    private void _resetUsingDataLoaderField() {
        this.mUsingDataLoaderPlayTaskKeys.clear();
        this.mUsingDataLoaderPlayFilePaths.clear();
        this.mUsingDataLoaderPlayRawKey = null;
        this.mMediaInfoMap.clear();
    }

    private void _silenceDetected() {
        if (this.mLooperThread.checkSendMainLooper()) {
            this.mLooperThread.postMainLooperMessage(426, 0, 0, this.mTraceId);
        } else {
            this.mListenerCompact.onSilenceDetected(this.mEngineWrapper);
        }
    }

    private void fetchSmartUrlInfo() {
        this.mState = 1;
        this.mIsFetchingInfo = true;
        TTVideoEngineLog.d(logcatTag(), "start to fetch smart url info.");
        _resetUrlIndexMap();
        CodecStrategyAdapter codecStrategyAdapter = this.mCodecStrategyAdapter;
        if (codecStrategyAdapter != null) {
            codecStrategyAdapter.fetchSmartUrlInfo(new SmartUrlInfoCallback(this));
        }
    }

    private int getBufferStartAction() {
        boolean z = this.mSeeking;
        if (z && this.mResolutionSwitching) {
            if (this.mSeekingStartTime <= this.mResolutionSwitchingStartTime) {
                return 2;
            }
            return 1;
        }
        if (z) {
            return 1;
        }
        if (this.mResolutionSwitching) {
            return 2;
        }
        return 0;
    }

    private String getFilePath() {
        if (this.mIsLocal || this.mIsPlayItem || this.mIsPreloaderItem || !this.mIsDirectURL) {
            return null;
        }
        return this.mFileKey;
    }

    private boolean isPcdnNeedPlayInfo() {
        if (EngineGlobalConfig.getInstance().getPcdnAuto() == 1) {
            if (this.mEnableSetPlayInfoToP2P != 1) {
                return false;
            }
            return true;
        }
        if (this.mP2PCDNType <= 0) {
            return false;
        }
        return true;
    }

    private boolean isPlayerSupportSeekMode() {
        if (!isPlayerType(0) && !isPlayerType(1) && !isPlayerType(3) && !isPlayerType(4)) {
            return false;
        }
        return true;
    }

    private boolean shouldStartTextureRenderCheck() {
        if (this.mTextureSurface != null && this.mRadioModeEnable != 1 && this.mEnableTextureRenderNoRenderCheck == 1 && !this.mSeeking && !this.mSeamSwitchingResolution && this.mLoadState == 1 && this.mPlaybackState == 1) {
            return true;
        }
        return false;
    }

    void _doClearTextureRef() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            if (1 == this.mIsEnabelUsedRefactorSurfaceView) {
                _doExternalWindowSetSurfaceNull(mediaPlayer, true);
            } else {
                mediaPlayer.setSurface(null);
            }
        }
        releaseTextureRenderRef();
    }

    int _doGetCurrentPlaybackTime() {
        int i;
        if (!this.mSeamSwitchingResolution && (this.mSeekMode != 0 || !this.mSeeking)) {
            i = _getPlayerTime();
        } else {
            i = this.mLastPlaybackTime;
        }
        _updateCurrentInfoToMDL(i);
        return i;
    }

    boolean _doIsSystemPlayer() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            int i = this.mPlayerType;
            if (i != 2 && i != 5) {
                return false;
            }
            return true;
        }
        if (!mediaPlayer.isOSPlayer() && mediaPlayer.getPlayerType() != 5) {
            return false;
        }
        return true;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void createPlayerAsync() {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(34);
        } else {
            _createPlayerAsync();
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void forceDraw() {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(27);
        } else {
            doForceDraw();
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal, com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getCurrentPlaybackTimeAsync() {
        int i = this.mPlayerType;
        if (i != 2 && i != 5 && getConfigInt(602, this.mPosUpdateInterval) > 0) {
            return this.mCurPosition;
        }
        return getCurrentPlaybackTime();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public float getMaxVolume() {
        int i;
        Context context = this.mContext;
        if (context == null) {
            return 0.0f;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int i2 = 0;
        if (audioManager != null) {
            i = audioManager.getStreamMaxVolume(3);
        } else {
            i = 0;
        }
        if (i >= 0) {
            i2 = i;
        }
        return i2;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void notifyCompletion() {
        if (this.mLooperThread.checkSendMainLooper()) {
            this.mLooperThread.postMainLooperMessage(408, 0, 0, null);
        } else {
            this.mListenerCompact.onCompletion(this.mEngineWrapper);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void notifyPrepare() {
        if (this.mLooperThread.checkSendMainLooper()) {
            this.mLooperThread.postMainLooperMessage(404, 0, 0, null);
        } else {
            this.mListenerCompact.onPrepare(this.mEngineWrapper);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void notifyPrepared() {
        if (this.mLooperThread.checkSendMainLooper()) {
            this.mLooperThread.postMainLooperMessage(405, 0, 0, null);
        } else {
            this.mListenerCompact.onPrepared(this.mEngineWrapper);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void notifyReadyForDisplay() {
        if (this.mLooperThread.checkSendMainLooper()) {
            this.mLooperThread.postMainLooperMessage(419, 0, 0, null);
        } else {
            this.mListenerCompact.onReadyForDisplay(this.mEngineWrapper);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void notifyRenderStart() {
        if (this.mLooperThread.checkSendMainLooper()) {
            this.mLooperThread.postMainLooperMessage(406, 0, 0, this.mTraceId);
        } else {
            this.mListenerCompact.onRenderStart(this.mEngineWrapper);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void pauseByInterruption() {
        TTVideoEngineLog.i(logcatTag(), "pause by interruption");
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(11);
        } else {
            _pauseByInterruption();
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public Resolution[] supportedResolutionTypes() {
        TTAVPreloaderItem tTAVPreloaderItem;
        if (this.mIsPreloaderItem && (tTAVPreloaderItem = this.mPreloaderItem) != null) {
            return tTAVPreloaderItem.supportResolutions();
        }
        IVideoModel iVideoModel = this.mVideoModel;
        if (iVideoModel != null) {
            return iVideoModel.getSupportResolutions();
        }
        return new Resolution[0];
    }

    private static class MyLoggerDataSource implements EventLoggerSource {
        private final WeakReference<TTVideoEngineImpl> mVideoEngineRef;

        static {
            Covode.recordClassIndex(652343);
        }

        @Override // com.ss.ttvideoengine.log.EventLoggerSource
        public ArrayList forebackSwitchList() {
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl != null && tTVideoEngineImpl.mVideoEngineGetInfoListener != null) {
                Object info = tTVideoEngineImpl.mVideoEngineGetInfoListener.getInfo(2);
                if (info instanceof ArrayList) {
                    return (ArrayList) info;
                }
            }
            return null;
        }

        @Override // com.ss.ttvideoengine.log.EventLoggerSource
        public String getMediaLoaderInfo() {
            int i;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl != null && tTVideoEngineImpl.getConfigInt(160, tTVideoEngineImpl.mDataLoaderEnable) != 0) {
                return DataLoaderHelper.getDataLoader().getPlayLog(tTVideoEngineImpl.mTraceId);
            }
            if (tTVideoEngineImpl != null) {
                i = tTVideoEngineImpl.getConfigInt(160, tTVideoEngineImpl.mDataLoaderEnable);
            } else {
                i = 0;
            }
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                TTVideoEngineLog.e(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "videoEngine is:" + tTVideoEngineImpl + ", dataloader enable:" + i);
                return null;
            }
            return null;
        }

        private String getFfmpegVersion() {
            try {
                return (String) l3.a.q("com.ss.mffmpeg.FFmpegLibLoaderWrapper").getMethod("getFFmpegVersion", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable th) {
                TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(5)) {
                    TTVideoEngineLog.w(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "get ffmpeg version error: " + th.toString());
                }
                try {
                    return (String) l3.a.q("com.ss.ttffmpeg.FFmpegLibLoaderWrapper").getMethod("getFFmpegVersion", new Class[0]).invoke(null, new Object[0]);
                } catch (Throwable th2) {
                    TTVideoEngineImpl tTVideoEngineImpl2 = this.mVideoEngineRef.get();
                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(5)) {
                        TTVideoEngineLog.w(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl2), "get ffmpeg version error: " + th2.toString());
                    }
                    return null;
                }
            }
        }

        @Override // com.ss.ttvideoengine.log.EventLoggerSource
        public Map<String, Long> bytesInfo() {
            MediaPlayer mediaPlayer;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null || (mediaPlayer = tTVideoEngineImpl.mMediaPlayer) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("vds", Long.valueOf(mediaPlayer.getLongOption(45, 0L)));
            hashMap.put("vps", Long.valueOf(mediaPlayer.getLongOption(46, 0L)));
            hashMap.put("download_speed", Long.valueOf(mediaPlayer.getLongOption(63, -1L)));
            hashMap.put("vlen", Long.valueOf(mediaPlayer.getLongOption(72, -1L)));
            hashMap.put("alen", Long.valueOf(mediaPlayer.getLongOption(73, -1L)));
            hashMap.put("vDecLen", Long.valueOf(mediaPlayer.getLongOption(602, -1L)));
            hashMap.put("aDecLen", Long.valueOf(mediaPlayer.getLongOption(603, -1L)));
            hashMap.put("vBaseLen", Long.valueOf(mediaPlayer.getLongOption(604, -1L)));
            hashMap.put("aBaseLen", Long.valueOf(mediaPlayer.getLongOption(605, -1L)));
            hashMap.put("avGap", Long.valueOf(mediaPlayer.getLongOption(606, -1L)));
            hashMap.put("single_vds", Long.valueOf(mediaPlayer.getLongOption(145, 0L)));
            hashMap.put("accu_vds", Long.valueOf(mediaPlayer.getLongOption(476, 0L)));
            return hashMap;
        }

        @Override // com.ss.ttvideoengine.log.EventLoggerSource
        public Map<String, String> versionInfo() {
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            String value = TTPlayerConfiger.getValue(14, "");
            int i = tTVideoEngineImpl.mPlayerType;
            if (i != 0 && i != 1) {
                if (i == 2) {
                    hashMap.put("sv", "5.6");
                    hashMap.put("pv", com.ss.ttm.ttvideodecode.BuildConfig.VERSION_NAME);
                    hashMap.put("pc", "0");
                    hashMap.put("sdk_version", "1.10.252.100-novel");
                } else if (i == 5) {
                    hashMap.put("sv", "5.6");
                    hashMap.put("pv", "5.0");
                    hashMap.put("pc", "5");
                    hashMap.put("sdk_version", "1.10.252.100-novel");
                } else {
                    hashMap.put("sv", "5.6");
                    hashMap.put("pv", "4.0");
                    hashMap.put("pc", value);
                    hashMap.put("sdk_version", "1.10.252.100-novel");
                }
            } else {
                hashMap.put("sv", "5.6");
                MediaPlayer mediaPlayer = tTVideoEngineImpl.mMediaPlayer;
                if (mediaPlayer != null) {
                    String stringOption = mediaPlayer.getStringOption(1095);
                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                        TTVideoEngineLog.i(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "playerLibName:" + stringOption);
                    }
                    if ("ttmplayerbeta" == stringOption) {
                        hashMap.put("pv", "3.0-beta");
                    } else {
                        hashMap.put("pv", "3.0");
                    }
                } else {
                    hashMap.put("pv", "3.0");
                }
                hashMap.put("pc", value);
                hashMap.put("sdk_version", "1.10.252.100-novel");
            }
            hashMap.put("trv", o.b(24));
            String ffmpegVersion = getFfmpegVersion();
            if (!TextUtils.isEmpty(ffmpegVersion)) {
                hashMap.put("ffv", ffmpegVersion);
            }
            return hashMap;
        }

        public MyLoggerDataSource(TTVideoEngineImpl tTVideoEngineImpl) {
            this.mVideoEngineRef = new WeakReference<>(tTVideoEngineImpl);
        }

        @Override // com.ss.ttvideoengine.log.EventLoggerSource
        public float getLogValueFloat(int i) {
            MediaPlayer mediaPlayer;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null || (mediaPlayer = tTVideoEngineImpl.mMediaPlayer) == null) {
                return -1.0f;
            }
            if (i != 82) {
                if (i != 83) {
                    return -1.0f;
                }
                return mediaPlayer.getFloatOption(150, -1.0f);
            }
            return mediaPlayer.getFloatOption(151, -1.0f);
        }

        @Override // com.ss.ttvideoengine.log.EventLoggerSource
        public Map<String, Object> getLogValueMap(int i) {
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null || i != 155 || tTVideoEngineImpl.mVideoEngineGetInfoListener == null) {
                return null;
            }
            return tTVideoEngineImpl.mVideoEngineGetInfoListener.getInfoMap(4);
        }

        @Override // com.ss.ttvideoengine.log.EventLoggerSource
        public int getLogValueInt(int i) {
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null) {
                return -1;
            }
            switch (i) {
                case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                    break;
                case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                    break;
                case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                    break;
                case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                    MediaPlayer mediaPlayer = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer != null) {
                        if (tTVideoEngineImpl.mVideoCodecType < 0) {
                            tTVideoEngineImpl.mVideoCodecType = mediaPlayer.getIntOption(157, -1);
                        }
                        break;
                    }
                    break;
                case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                    MediaPlayer mediaPlayer2 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer2 != null) {
                        if (tTVideoEngineImpl.mAudioCodecType < 0) {
                            tTVideoEngineImpl.mAudioCodecType = mediaPlayer2.getIntOption(158, -1);
                        }
                        break;
                    }
                    break;
                case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                    break;
                case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                    MediaPlayer mediaPlayer3 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer3 != null) {
                        if (mediaPlayer3.isMute()) {
                        }
                    }
                    break;
                case 30:
                    break;
                case ConstantsAPI.COMMAND_FINDER_OPEN_PROFILE /* 34 */:
                    break;
                case ConstantsAPI.COMMAND_FINDER_OPEN_LIVE /* 35 */:
                    break;
                case ConstantsAPI.COMMAND_FINDER_OPEN_FEED /* 36 */:
                    break;
                case 42:
                    MediaPlayer mediaPlayer4 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer4 != null) {
                        break;
                    }
                    break;
                case 43:
                    MediaPlayer mediaPlayer5 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer5 != null) {
                        break;
                    }
                    break;
                case 44:
                    MediaPlayer mediaPlayer6 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer6 != null) {
                        break;
                    }
                    break;
                case 49:
                    MediaPlayer mediaPlayer7 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer7 != null) {
                        break;
                    }
                    break;
                case 61:
                    MediaPlayer mediaPlayer8 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer8 != null) {
                        break;
                    }
                    break;
                case 63:
                    if (tTVideoEngineImpl.mVideoCodecProfile == -1) {
                        MediaPlayer mediaPlayer9 = tTVideoEngineImpl.mMediaPlayer;
                        if (mediaPlayer9 != null) {
                            tTVideoEngineImpl.mVideoCodecProfile = mediaPlayer9.getIntOption(403, -1);
                        }
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (tTVideoEngineImpl.mAudioCodecProfile == -1) {
                        MediaPlayer mediaPlayer10 = tTVideoEngineImpl.mMediaPlayer;
                        if (mediaPlayer10 != null) {
                            tTVideoEngineImpl.mAudioCodecProfile = mediaPlayer10.getIntOption(402, -1);
                        }
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (tTVideoEngineImpl.mCurPosition <= 0) {
                        MediaPlayer mediaPlayer11 = tTVideoEngineImpl.mMediaPlayer;
                        if (mediaPlayer11 != null) {
                            break;
                        }
                    } else {
                        break;
                    }
                    break;
                case 69:
                    MediaPlayer mediaPlayer12 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer12 != null) {
                        break;
                    }
                    break;
                case 77:
                    MediaPlayer mediaPlayer13 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer13 != null) {
                        break;
                    }
                    break;
                case 79:
                    MediaPlayer mediaPlayer14 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer14 != null) {
                        break;
                    }
                    break;
                case 81:
                    if (tTVideoEngineImpl.mMediaPlayer != null && tTVideoEngineImpl.mEnableAudioSDKReportOpt) {
                        break;
                    }
                    break;
                case 84:
                    MediaPlayer mediaPlayer15 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer15 != null) {
                        break;
                    }
                    break;
                case 85:
                    break;
                case 87:
                    if (tTVideoEngineImpl.mSurface != null || tTVideoEngineImpl.mWindowClient != null) {
                    }
                    break;
                case 88:
                    break;
                case 89:
                    HeadsetStateMonitor headsetStateMonitor = tTVideoEngineImpl.mHeadsetMonitor;
                    if (headsetStateMonitor != null) {
                        break;
                    }
                    break;
                case 90:
                    HeadsetStateMonitor headsetStateMonitor2 = tTVideoEngineImpl.mHeadsetMonitor;
                    if (headsetStateMonitor2 != null) {
                        break;
                    }
                    break;
                case 94:
                    if (tTVideoEngineImpl.mVideoEngineGetInfoListener != null) {
                        Object info = tTVideoEngineImpl.mVideoEngineGetInfoListener.getInfo(1);
                        if (info instanceof Integer) {
                            break;
                        }
                    }
                    break;
                case 97:
                    MediaPlayer mediaPlayer16 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer16 != null) {
                        break;
                    }
                    break;
                case 100:
                    break;
                case 101:
                    break;
                case 103:
                    MediaPlayer mediaPlayer17 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer17 != null) {
                        break;
                    }
                    break;
                case 109:
                    rs1.g gVar = tTVideoEngineImpl.mABRModule;
                    if (gVar != null) {
                        break;
                    }
                    break;
                case 113:
                    int i2 = tTVideoEngineImpl.mSetValidSurfaceTimeout;
                    tTVideoEngineImpl.mSetValidSurfaceTimeout = 0;
                    break;
                case 114:
                    MediaPlayer mediaPlayer18 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer18 != null) {
                        break;
                    }
                    break;
                case 121:
                    break;
                case 122:
                    break;
                case 142:
                    MediaPlayer mediaPlayer19 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer19 != null) {
                        break;
                    }
                    break;
                case 145:
                    MediaPlayer mediaPlayer20 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer20 != null) {
                        break;
                    }
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO /* 147 */:
                    MediaPlayer mediaPlayer21 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer21 != null) {
                        break;
                    }
                    break;
                case 148:
                    break;
                case 154:
                    MediaPlayer mediaPlayer22 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer22 != null) {
                        break;
                    }
                    break;
                case 156:
                    MediaPlayer mediaPlayer23 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer23 != null) {
                        break;
                    }
                    break;
                case 158:
                    if (tTVideoEngineImpl.mMediaPlayer != null && tTVideoEngineImpl.mEnableAudioSDKReportOpt) {
                        break;
                    }
                    break;
            }
            return -1;
        }

        @Override // com.ss.ttvideoengine.log.EventLoggerSource
        public long getLogValueLong(int i) {
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null) {
                return -1L;
            }
            if (i != 95) {
                MediaPlayer mediaPlayer = tTVideoEngineImpl.mMediaPlayer;
                if (mediaPlayer == null) {
                    return -1L;
                }
                if (i != 91) {
                    if (i == 92) {
                        return tTVideoEngineImpl.mLastSwitchResolutionTime;
                    }
                    if (i != 137) {
                        if (i != 138) {
                            if (i != 140) {
                                if (i != 141) {
                                    int i2 = -1;
                                    switch (i) {
                                        case 7:
                                            break;
                                        case 10:
                                            break;
                                        case 11:
                                            break;
                                        case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                                            break;
                                        case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                                            break;
                                        case 14:
                                            break;
                                        case 15:
                                            break;
                                        case 16:
                                            break;
                                        case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                                            break;
                                        case 18:
                                            break;
                                        case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                                            break;
                                        case 45:
                                            break;
                                        case 66:
                                            break;
                                        case 68:
                                            break;
                                        case 75:
                                            break;
                                        case 96:
                                            break;
                                        case 112:
                                            break;
                                        case 144:
                                            if (tTVideoEngineImpl.getConfigInt(742, tTVideoEngineImpl.mEnableGetPlayerReqOffset) != 0) {
                                                i2 = -2;
                                            }
                                            break;
                                        case 149:
                                            if (tTVideoEngineImpl.getConfigInt(742, tTVideoEngineImpl.mEnableGetPlayerReqOffset) != 0) {
                                                i2 = -3;
                                            }
                                            break;
                                        case 150:
                                            break;
                                        case 152:
                                            break;
                                        case 153:
                                            break;
                                        default:
                                            switch (i) {
                                                case ConstantsAPI.COMMAND_OPEN_QRCODE_PAY /* 38 */:
                                                    break;
                                                case ConstantsAPI.COMMAND_FINDER_START_LIVE /* 39 */:
                                                    break;
                                                case 40:
                                                    break;
                                                case ConstantsAPI.COMMAND_FINDER_OPEN_EVENT /* 41 */:
                                                    break;
                                                default:
                                                    switch (i) {
                                                        case IVideoEventLogger.LOGGER_OPTION_ENABLE_PLAYER_DEGRADE /* 51 */:
                                                            break;
                                                        case IVideoEventLogger.LOGGER_OPTION_IS_DEGRADE_RELEASE /* 52 */:
                                                            break;
                                                        case ITTVideoEngineInternal.PLAYER_OPTION_GET_WATCHED_DUTATION /* 53 */:
                                                            break;
                                                        case 54:
                                                            break;
                                                        default:
                                                            switch (i) {
                                                                case 56:
                                                                    break;
                                                                case 57:
                                                                    break;
                                                                case 58:
                                                                    break;
                                                                default:
                                                                    switch (i) {
                                                                        case 70:
                                                                            break;
                                                                        case 71:
                                                                            break;
                                                                        case 72:
                                                                            break;
                                                                        case 73:
                                                                            break;
                                                                        default:
                                                                            switch (i) {
                                                                                case 104:
                                                                                    break;
                                                                                case 105:
                                                                                    break;
                                                                                case 106:
                                                                                    break;
                                                                                case 107:
                                                                                    break;
                                                                                case 108:
                                                                                    break;
                                                                                default:
                                                                                    switch (i) {
                                                                                    }
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                                    return -1L;
                                }
                                return mediaPlayer.getLongOption(753, -1L);
                            }
                            return mediaPlayer.getLongOption(752, -1L);
                        }
                        return mediaPlayer.getLongOption(856, -1L);
                    }
                    return mediaPlayer.getLongOption(1801, -1L);
                }
                return tTVideoEngineImpl.mLastSwitchRadioModeTime;
            }
            if (tTVideoEngineImpl.mVideoEngineGetInfoListener == null) {
                return -1L;
            }
            Object info = tTVideoEngineImpl.mVideoEngineGetInfoListener.getInfo(3);
            if (!(info instanceof Long)) {
                return -1L;
            }
            return ((Long) info).longValue();
        }

        @Override // com.ss.ttvideoengine.log.EventLoggerSource
        public String getLogValueStr(int i) {
            String str;
            MediaPlayer mediaPlayer;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            String str2 = "";
            if (tTVideoEngineImpl == null) {
                return "";
            }
            String str3 = "unknown_codec";
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return tTVideoEngineImpl.mAPIString;
                        }
                        if (i != 4) {
                            if (i != 5) {
                                if (i != 110) {
                                    if (i != 111) {
                                        switch (i) {
                                            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                                                return tTVideoEngineImpl.mAuthorization;
                                            case ConstantsAPI.COMMAND_OPEN_CUSTOMER_SERVICE_CHAT /* 37 */:
                                                return DataLoaderHelper.getDataLoader().getStringValue(6);
                                            case 46:
                                                if (tTVideoEngineImpl.mLogger == null) {
                                                    return "";
                                                }
                                                return tTVideoEngineImpl.mLogger.getExtraInfo();
                                            case 55:
                                                MediaPlayer mediaPlayer2 = tTVideoEngineImpl.mMediaPlayer;
                                                if (mediaPlayer2 != null) {
                                                    return mediaPlayer2.getStringOption(609);
                                                }
                                            case 65:
                                                MediaPlayer mediaPlayer3 = tTVideoEngineImpl.mMediaPlayer;
                                                if (mediaPlayer3 != null) {
                                                    return mediaPlayer3.getStringOption(516);
                                                }
                                            case 76:
                                                if (tTVideoEngineImpl.currentVideoInfo == null) {
                                                    return "";
                                                }
                                                return tTVideoEngineImpl.currentVideoInfo.getValueStr(7);
                                            case 78:
                                                MediaPlayer mediaPlayer4 = tTVideoEngineImpl.mMediaPlayer;
                                                if (mediaPlayer4 != null) {
                                                    return mediaPlayer4.getStringOption(825);
                                                }
                                            case 80:
                                                MediaPlayer mediaPlayer5 = tTVideoEngineImpl.mMediaPlayer;
                                                if (mediaPlayer5 != null) {
                                                    return mediaPlayer5.getStringOption(824);
                                                }
                                            case 102:
                                                return tTVideoEngineImpl.mAbrVer;
                                            case 139:
                                                if (tTVideoEngineImpl.getConfigInt(1402, tTVideoEngineImpl.mEnableReportPreloadTraceId ? 1 : 0) == 1) {
                                                    String str4 = tTVideoEngineImpl.mVideoID;
                                                    String str5 = tTVideoEngineImpl.mMDLGroupId;
                                                    DataLoaderHelper dataLoader = DataLoaderHelper.getDataLoader();
                                                    if (TextUtils.isEmpty(str5)) {
                                                        str = str4;
                                                    } else {
                                                        str = str5;
                                                    }
                                                    String preloadTraceId = dataLoader.getPreloadTraceId(str);
                                                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                                                        TTVideoEngineLog.i(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "get preloadTraceId = " + preloadTraceId + ", groupId = " + str5 + ", videoID = " + str4 + ", engine = " + tTVideoEngineImpl);
                                                    }
                                                    if (!TextUtils.isEmpty(preloadTraceId)) {
                                                        DataLoaderHelper.getDataLoader().resetPreloadTraceId(str4);
                                                        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                                                            TTVideoEngineLog.i(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "reset preloadTraceId = " + preloadTraceId);
                                                            return preloadTraceId;
                                                        }
                                                        return preloadTraceId;
                                                    }
                                                    return preloadTraceId;
                                                }
                                                return null;
                                            case 143:
                                                if (tTVideoEngineImpl.getConfigInt(1215, tTVideoEngineImpl.mEnablePreloadGear) != 1 || (mediaPlayer = tTVideoEngineImpl.mMediaPlayer) == null) {
                                                    return "";
                                                }
                                                return mediaPlayer.getStringOption(755);
                                            case 146:
                                                MediaPlayer mediaPlayer6 = tTVideoEngineImpl.mMediaPlayer;
                                                if (mediaPlayer6 != null) {
                                                    String stringOption = mediaPlayer6.getStringOption(TTVideoEngineInterface.PLAYER_OPTION_DISABLE_EVENTV3_ASYNC);
                                                    if (!TextUtils.isEmpty(stringOption)) {
                                                        str3 = stringOption;
                                                    }
                                                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                                                        TTVideoEngineLog.i(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "audio codec: " + str3);
                                                    }
                                                    return str3;
                                                }
                                            case 151:
                                                MediaPlayer mediaPlayer7 = tTVideoEngineImpl.mMediaPlayer;
                                                if (mediaPlayer7 != null) {
                                                    return mediaPlayer7.getStringOption(481);
                                                }
                                            case 157:
                                                MediaPlayer mediaPlayer8 = tTVideoEngineImpl.mMediaPlayer;
                                                if (mediaPlayer8 != null) {
                                                    return mediaPlayer8.getStringOption(848);
                                                }
                                            case 159:
                                                if (tTVideoEngineImpl.currentVideoInfo == null) {
                                                    return "";
                                                }
                                                return tTVideoEngineImpl.currentVideoInfo.getValueStr(54);
                                            case 162:
                                                if (tTVideoEngineImpl.currentVideoInfo == null) {
                                                    return "";
                                                }
                                                return tTVideoEngineImpl.currentVideoInfo.getValueStr(56);
                                            default:
                                                switch (i) {
                                                    case 31:
                                                        try {
                                                            return Build.BOARD;
                                                        } catch (Exception e) {
                                                            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                                                TTVideoEngineLog.d(e);
                                                            }
                                                            return "";
                                                        }
                                                    case ConstantsAPI.COMMAND_PRELOAD_MINI_PROGRAM_ENVIRONMENT /* 32 */:
                                                        try {
                                                            return Build.HARDWARE;
                                                        } catch (Exception e2) {
                                                            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                                                TTVideoEngineLog.d(e2);
                                                            }
                                                            return "";
                                                        }
                                                    case ConstantsAPI.COMMAND_FINDER_SHARE_VIDEO /* 33 */:
                                                        MediaPlayer mediaPlayer9 = tTVideoEngineImpl.mMediaPlayer;
                                                        if (mediaPlayer9 != null) {
                                                            return mediaPlayer9.getStringOption(200);
                                                        }
                                                    default:
                                                        return "";
                                                }
                                        }
                                    } else {
                                        if (TTVideoEngineImpl.mChipBoardName == null) {
                                            try {
                                                BufferedReader bufferedReader = new BufferedReader(new PolarisFileReaderWrapper("proc/cpuinfo"));
                                                String readLine = bufferedReader.readLine();
                                                while (true) {
                                                    if (readLine == null) {
                                                        break;
                                                    }
                                                    if (readLine.contains("Hardware")) {
                                                        String[] split = readLine.split(":");
                                                        if (split.length > 1) {
                                                            str2 = split[1];
                                                        }
                                                    } else {
                                                        readLine = bufferedReader.readLine();
                                                    }
                                                }
                                                String unused = TTVideoEngineImpl.mChipBoardName = str2.trim();
                                            } catch (Exception e3) {
                                                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                                    TTVideoEngineLog.d(e3);
                                                }
                                            }
                                        }
                                        return TTVideoEngineImpl.mChipBoardName;
                                    }
                                } else {
                                    MediaPlayer mediaPlayer10 = tTVideoEngineImpl.mMediaPlayer;
                                    if (mediaPlayer10 != null) {
                                        return mediaPlayer10.getStringOption(467);
                                    }
                                }
                            } else {
                                MediaPlayer mediaPlayer11 = tTVideoEngineImpl.mMediaPlayer;
                                if (mediaPlayer11 != null) {
                                    return mediaPlayer11.getStringOption(71);
                                }
                            }
                        } else {
                            if (tTVideoEngineImpl.getNetClientSetByUser() == null) {
                                return "own";
                            }
                            return "user";
                        }
                    } else {
                        MediaPlayer mediaPlayer12 = tTVideoEngineImpl.mMediaPlayer;
                        if (mediaPlayer12 != null) {
                            return mediaPlayer12.getStringOption(5002);
                        }
                    }
                } else {
                    MediaPlayer mediaPlayer13 = tTVideoEngineImpl.mMediaPlayer;
                    if (mediaPlayer13 != null) {
                        int intOption = mediaPlayer13.getIntOption(139, -1);
                        if (intOption != 0) {
                            if (intOption != 1) {
                                if (intOption != 4) {
                                    if (intOption != 100) {
                                        return "invalid";
                                    }
                                    return "output";
                                }
                                return "mediacodec";
                            }
                            return "nativewindow";
                        }
                        return "opengl";
                    }
                }
            } else {
                MediaPlayer mediaPlayer14 = tTVideoEngineImpl.mMediaPlayer;
                if (mediaPlayer14 != null) {
                    String stringOption2 = mediaPlayer14.getStringOption(478);
                    int intOption2 = tTVideoEngineImpl.mMediaPlayer.getIntOption(141, -1);
                    if (intOption2 == 1) {
                        stringOption2 = "bytevc1";
                    } else if (intOption2 == 33) {
                        stringOption2 = "bytevc2";
                    }
                    if (!tTVideoEngineImpl.isInHousePlayer() && intOption2 == 0) {
                        stringOption2 = "h264";
                    }
                    if (!TextUtils.isEmpty(stringOption2)) {
                        str3 = stringOption2;
                    }
                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                        TTVideoEngineLog.i(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "video codec: " + str3);
                    }
                    return str3;
                }
            }
            return "";
        }

        @Override // com.ss.ttvideoengine.log.EventLoggerSource
        public void onInfo(int i, Map map) {
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            switch (i) {
                case 0:
                    if (tTVideoEngineImpl != null && tTVideoEngineImpl.mListenerCompact.getVideoEngineInfoListener() != null) {
                        VideoEngineInfos videoEngineInfos = new VideoEngineInfos();
                        videoEngineInfos.setKey("bufferStartInfos");
                        videoEngineInfos.setObject(map);
                        tTVideoEngineImpl.notifyEngineInfo(videoEngineInfos, false);
                        break;
                    }
                    break;
                case 1:
                    if (tTVideoEngineImpl != null && tTVideoEngineImpl.mListenerCompact.getVideoEngineInfoListener() != null) {
                        VideoEngineInfos videoEngineInfos2 = new VideoEngineInfos();
                        videoEngineInfos2.setKey("bufferEndInfos");
                        videoEngineInfos2.setObject(map);
                        tTVideoEngineImpl.notifyEngineInfo(videoEngineInfos2, false);
                        break;
                    }
                    break;
                case 2:
                    if (tTVideoEngineImpl != null && tTVideoEngineImpl.mListenerCompact.getVideoEngineInfoListener() != null) {
                        JSONObject jSONObject = new JSONObject(map);
                        VideoEngineInfos videoEngineInfos3 = new VideoEngineInfos();
                        videoEngineInfos3.setKey("firstframe_split");
                        videoEngineInfos3.setObject(jSONObject);
                        videoEngineInfos3.setGroupID(tTVideoEngineImpl.mGroupID);
                        tTVideoEngineImpl.notifyEngineInfo(videoEngineInfos3, true);
                        break;
                    }
                    break;
                case 3:
                    if (tTVideoEngineImpl != null && tTVideoEngineImpl.mListenerCompact.getVideoEngineInfoListener() != null) {
                        VideoEngineInfos videoEngineInfos4 = new VideoEngineInfos();
                        videoEngineInfos4.setKey("outsyncStartInfos");
                        videoEngineInfos4.setObject(map);
                        tTVideoEngineImpl.notifyEngineInfo(videoEngineInfos4, false);
                        break;
                    }
                    break;
                case 4:
                    if (tTVideoEngineImpl != null && tTVideoEngineImpl.mListenerCompact.getVideoEngineInfoListener() != null) {
                        VideoEngineInfos videoEngineInfos5 = new VideoEngineInfos();
                        videoEngineInfos5.setKey("outsyncEndInfos");
                        videoEngineInfos5.setObject(map);
                        tTVideoEngineImpl.notifyEngineInfo(videoEngineInfos5, false);
                        break;
                    }
                    break;
                case 5:
                    if (tTVideoEngineImpl != null && tTVideoEngineImpl.mListenerCompact.getVideoEngineInfoListener() != null) {
                        VideoEngineInfos videoEngineInfos6 = new VideoEngineInfos();
                        videoEngineInfos6.setKey("noRenderStartInfos");
                        videoEngineInfos6.setObject(map);
                        tTVideoEngineImpl.notifyEngineInfo(videoEngineInfos6, false);
                        break;
                    }
                    break;
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    if (tTVideoEngineImpl != null && tTVideoEngineImpl.mListenerCompact.getVideoEngineInfoListener() != null) {
                        VideoEngineInfos videoEngineInfos7 = new VideoEngineInfos();
                        videoEngineInfos7.setKey("noRenderEndInfos");
                        videoEngineInfos7.setObject(map);
                        tTVideoEngineImpl.notifyEngineInfo(videoEngineInfos7, false);
                        break;
                    }
                    break;
            }
        }
    }

    static {
        Covode.recordClassIndex(652334);
        mIsFirstOpenEngine = true;
        mAppPath = null;
        mCreatCacheFileLock = new ReentrantLock();
        mTextureLogListenerExt = null;
        mHasRegisterMdlProto = false;
        mHasRegisterMdlProtoForExo = false;
        mSurfaceHashMap = new ConcurrentHashMap(15);
        mChipBoardName = null;
    }

    private void _clearSurface() {
        Surface surface;
        if (getConfigInt(520, this.mClearShutDown ? 1 : 0) == 0) {
            return;
        }
        if (1 == this.mIsEnabelUsedRefactorSurfaceView) {
            clearSurface(this.mRefactorSurface, false);
            return;
        }
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surface = surfaceHolder.getSurface();
        } else {
            surface = this.mSurface;
        }
        clearSurface(surface, false);
    }

    private void _configNativeRenderRotationAdapt() {
        int vodInt = SettingsHelper.helper().getVodInt("native_render_rotation_adapt", getConfigInt(566, this.mNativeRenderRotationAdapt));
        if (this.mConfigCenterVersion > 0) {
            this.mEngineConfig.setIntOption(566, vodInt);
        } else {
            this.mNativeRenderRotationAdapt = vodInt;
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "native render rotation adapt: " + vodInt);
        }
    }

    private void _configNativeYV12Render() {
        int vodInt = SettingsHelper.helper().getVodInt("native_yv12_render", getConfigInt(543, this.mEnableNativeYV12Render));
        if (this.mConfigCenterVersion > 0) {
            this.mEngineConfig.setIntOption(543, vodInt);
        } else {
            this.mEnableNativeYV12Render = vodInt;
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "enabled native YV12: " + vodInt);
        }
    }

    private void _dataLoaderRemoveEngineRef() {
        DataLoaderHelper.getDataLoader()._removeEngine(this.mEngineWrapper, this.mUsingDataLoaderPlayRawKey);
        if (this.mUsingDataLoaderPlayTaskKeys != null) {
            for (int i = 0; i < this.mUsingDataLoaderPlayTaskKeys.size(); i++) {
                DataLoaderHelper.getDataLoader()._removePlayTask(this.mUsingDataLoaderPlayTaskKeys.get(i));
            }
            DataLoaderHelper.getDataLoader().getIntValue(9016);
        }
        _resetUsingDataLoaderField();
        this.mBashDashDefaultMDLKeys.clear();
    }

    private void _doRecordSurface() {
        if (this.mSurfaceRecord != null) {
            Map<Surface, Boolean> map = mSurfaceHashMap;
            if (map.size() >= 15) {
                map.clear();
            }
            if (getIntOption(1071) == 1) {
                map.put(this.mSurfaceRecord, Boolean.TRUE);
            } else {
                map.put(this.mSurfaceRecord, Boolean.FALSE);
            }
        }
    }

    private void _doUnbindAudioProcessor() {
        if (this.mMediaPlayer != null) {
            TTVideoEngineLog.i(logcatTag(), "unbindAudioProcessor");
            this.mMediaPlayer.setIntOption(1093, 1);
            this.mMediaPlayer.setIntOption(378, -1);
            this.mMediaPlayer.setIntOption(539, 1);
        }
    }

    private void _firstAVSyncFrame() {
        TTVideoEngineLog.i(logcatTag(), "player callback first av sync frame");
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mLooperThread.checkSendMainLooper()) {
            this.mLooperThread.postMainLooperMessage(423, 0, 0, Long.valueOf(currentTimeMillis));
        } else {
            this.mLogger.showedFirstAVSyncVideoFrame(currentTimeMillis);
            this.mListenerCompact.onFirstAVSyncFrame(this.mEngineWrapper);
        }
    }

    private void _formaterStart() {
        PlayerEventListener playerEventListener = this.mPlayerEventListener;
        if (getConfigInt(664, this.mEnableDebugUINotify) != 0 && playerEventListener != null && this.mMediaPlayer != null) {
            playerEventListener.onMediaOpened(getVideoFormatInfo(), this.mMediaPlayer.getLongOption(621, 0L), this.mMediaPlayer.getLongOption(625, 0L));
        }
    }

    private Map _getCommentInfo() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return null;
        }
        String stringOption = mediaPlayer.getStringOption(47);
        HashMap hashMap = new HashMap();
        if (stringOption != null) {
            for (String str : stringOption.replaceAll(" ", "").split(",")) {
                String[] split = str.split(":");
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
        }
        return hashMap;
    }

    private void _pause() {
        TTVideoEngineLog.i(logcatTag(), "_pause");
        if (!this.mPrepared) {
            this.mPausedBeforePrepared = true;
            updatePlaybackState(2);
            return;
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            TTVideoEngineLog.d(logcatTag(), "player will pause");
            mediaPlayer.pause();
            updatePlaybackState(2);
            _updateTextureState(2);
        }
        rs1.g gVar = this.mABRModule;
        if (gVar != null) {
            gVar.stop();
            this.mLogger.setIsEnableABR(0);
        }
    }

    private void _refreshSurface() {
        TTVideoEngineLog.i(logcatTag(), "refresh surface");
        if (this.mRefreshSurfaceDone) {
            return;
        }
        this.mRefreshSurfaceDone = true;
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface == null) {
            TTVideoEngineLooperThread2 tTVideoEngineLooperThread2 = this.mLooperThread;
            if (tTVideoEngineLooperThread2 != null && tTVideoEngineLooperThread2.checkSendMainLooper()) {
                this.mLooperThread.postMainLooperMessage(424, 0, 0, null);
                return;
            }
            ListenerCompact listenerCompact = this.mListenerCompact;
            if (listenerCompact != null) {
                listenerCompact.onRefreshSurface(this.mEngineWrapper);
                return;
            }
            return;
        }
        this.mRefreshTextureSurface = true;
        videoSurface.setIntOption(133, 1);
    }

    private void _secondFrame() {
        TTVideoEngineLog.i(logcatTag(), "player callback the second frame");
        if (getConfigInt(TTVideoEngineInterface.PLAYER_OPTION_OPEN_TEXTUER_AFTER_FIRST_FRAME, this.mFirstFrameOpenTexture) == 0 && this.mTextureSurface == null) {
            if (this.mLooperThread.checkSendMainLooper()) {
                this.mLooperThread.postMainLooperMessage(422, 0, 0, this.mTraceId);
            } else {
                this.mListenerCompact.onVideoSecondFrame(this.mEngineWrapper);
            }
        }
    }

    private void _setExtraSurface() {
        if (this.mTextureSurface != null) {
            while (this.mExtraSurfaceQueue.peek() != null) {
                Pair<Surface, Integer> poll = this.mExtraSurfaceQueue.poll();
                this.mTextureSurface.setExtraRenderSurface((Surface) poll.first, ((Integer) poll.second).intValue());
            }
        }
    }

    private void _settingThirdPartyProtocol() {
        if (this.mFFmpegProtocol != null && isInHousePlayer()) {
            String stringOption = this.mMediaPlayer.getStringOption(1027);
            String protocolName = this.mFFmpegProtocol.getProtocolName();
            if (stringOption != null && !stringOption.equals(protocolName)) {
                this.mMediaPlayer.setLongOption(1026, this.mFFmpegProtocol.getURLProtocol());
            }
            this.mMediaPlayer.setLongOption(1028, this.mFFmpegProtocol.getAVDictionary());
        }
    }

    private void _videoRenderStartNotify() {
        MediaPlayer mediaPlayer;
        PlayerEventListener playerEventListener = this.mPlayerEventListener;
        if (getConfigInt(664, this.mEnableDebugUINotify) != 0 && (mediaPlayer = this.mMediaPlayer) != null && playerEventListener != null) {
            playerEventListener.onVideoRenderOpened(mediaPlayer.getIntOption(139, -1), this.mMediaPlayer.getLongOption(155, -1L), this.mMediaPlayer.getLongOption(162, -1L));
        }
    }

    private int clearMdlCache() {
        for (String str : this.mFileHashs) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "clear mdl cache by filekey: " + str);
            }
            TTVideoEngine.forceRemoveCacheFile(str);
        }
        return 0;
    }

    private boolean deleteCacheFile() {
        String filePath = getFilePath();
        if (filePath == null || filePath.length() == 0) {
            return true;
        }
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(filePath);
        try {
            if (polarisFileWrapper.isFile()) {
                if (polarisFileWrapper.delete()) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d(th);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doForceDraw() {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "forceDraw " + this.mTextureSurface);
        }
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface != null) {
            videoSurface.setIntOption(25, 1);
        }
    }

    private void fallbackOSPlayer() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && mediaPlayer.getPlayerType() != 0) {
            this.mMediaPlayer.releaseAsync();
            this.mMediaPlayer = null;
        }
        MediaPlayer mediaPlayer2 = this.mAsyncPlayer;
        if (mediaPlayer2 != null && mediaPlayer2.getPlayerType() != 0) {
            this.mAsyncPlayer.releaseAsync();
            this.mAsyncPlayer = null;
        }
        TTVideoEngineLog.d(logcatTag(), "license invalid fallback to os player");
        this.mPlayerType = 2;
    }

    private String getDefaultCacheFileDirPath() {
        String appFilesPath = TTHelper.getAppFilesPath(this.mContext);
        if (appFilesPath != null) {
            return appFilesPath + File.separator + "mediattmp";
        }
        return null;
    }

    private void loggerSetMdlInitializeState() {
        int mdlInitializeState = DataLoaderHelper.getDataLoader().getMdlInitializeState();
        if (mdlInitializeState == IVideoEventLogger.MdlInitializeState.InitializeError.ordinal()) {
            this.mLogger.setStringOption(176, DataLoaderHelper.getDataLoader().getMdlInitializeErrorString());
        }
        this.mLogger.setIntOption(175, mdlInitializeState);
    }

    private void mdlFetcherRemove() {
        FetcherMaker.remove(this.mVideoID);
        try {
            FetcherMakerNew.removeListener(this.mMDLFetcherListener);
        } catch (Throwable th) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "fetcherMakerNew exception " + th);
            }
        }
        this.mMDLFetcherListener = null;
    }

    private void mdlFetcherStore() {
        FetcherMaker.store(this.mVideoID, this.mKeyseed, this.mFallbackAPI, this.mVideoModelVersion);
        if (this.mMDLFetcherListener == null) {
            this.mMDLFetcherListener = new EngineMDLFetcherListener(this.mEngineWrapper);
        }
        try {
            FetcherMakerNew.storeListener(this.mMDLFetcherListener);
        } catch (Throwable th) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "fetcherMakerNew exception " + th);
            }
        }
    }

    private void notifyStrategyCenterDaspEvent() {
        String str = (String) get("tag");
        String str2 = (String) get("subtag");
        if (str != null) {
            this.mDaspSignals.add(new DaspSignal("play_tag", str));
        }
        if (str2 != null) {
            this.mDaspSignals.add(new DaspSignal("play_subtag", str2));
        }
        StrategyHelper.helper().setDaspPlaySignal(this.mTraceId, this.mDaspSignals);
        this.mDaspSignals.clear();
    }

    private String produceUserAgentString() {
        String str;
        int i = BaseAppInfo.mAppID;
        String traceID = this.mLogger.getTraceID();
        if (TextUtils.isEmpty(traceID)) {
            traceID = "null";
        }
        String str2 = VideoEventBase.appSessionId;
        if (TextUtils.isEmpty(this.mTag)) {
            str = "default";
        } else {
            str = this.mTag;
        }
        return String.format("appId:%d,os:Android,traceId:%s,appSessionId:%s,tag:%s", Integer.valueOf(i), traceID, str2, str);
    }

    private void resetTexture() {
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface == null) {
            return;
        }
        videoSurface.setIntOption(29, 0);
        this.mTextureSurface.setIntOption(31, 0);
        this.mTextureSurface.setIntOption(30, 0);
        setTextureLayoutMode(this.mLayoutType);
        if (this.mRotation != 0 || this.mIsMirrorVertical || this.mIsMirrorHorizontal) {
            this.mTextureSurface.setIntOption(25, 1);
        }
    }

    public void TTVideoEngineImpl___doPrepare$___twin___() {
        this.mIsStartPlayAutomatically = false;
        this.mShouldPlay = false;
        this.mShouldStop = false;
        this.mUserStopped = false;
        this.mAccumulatedErrorCount = 0;
        IVideoModel iVideoModel = this.mVideoModel;
        if (iVideoModel != null) {
            iVideoModel.setUpResolution(this.mResolutionMap);
        }
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            iVideoEventLogger.setLoggerTimes(65);
        }
        _play(false);
        this.mIsPlayComplete = false;
    }

    JSONObject _doGetPlayErrorInfo() {
        String str;
        try {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null && mediaPlayer.getIntOption(5000, 0) != 0) {
                JSONObject jSONObject = new JSONObject();
                String stringOption = this.mMediaPlayer.getStringOption(5001);
                if (this.mMediaPlayer.getIntOption(26, 1) == 1) {
                    str = "breakpad crash";
                } else {
                    str = "simple crash";
                }
                jSONObject.put(str, stringOption);
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    void _doHeartBeatThings() {
        _syncPlayInfoToMdl();
        if (getConfigInt(160, this.mDataLoaderEnable) > 0) {
            DataLoaderHelper.getDataLoader().updateCurrentNetStatus();
        }
        this.mLooperThread.postEngineMessageDelay(24, getConfigInt(657, this.mHeartBeatInterval));
    }

    void _doMetrics() {
        int configInt;
        if ((!TTVideoEngine.sColdStartOptimize || this.mIsColdStart != 1) && (configInt = getConfigInt(1218, this.mMetrcisAbility)) > 0) {
            PlayerMetrics playerMetrics = PlayerMetrics.getInstance();
            playerMetrics.setMetricsAbilityOption(configInt);
            playerMetrics.setMetricsIntervalOption(getConfigInt(1219, this.mMetrcisInterVal));
            playerMetrics.startMetric(this.mContext);
            IVideoEventLogger iVideoEventLogger = this.mLogger;
            if (iVideoEventLogger != null) {
                iVideoEventLogger.addFeature("metrics", 1);
            }
        }
    }

    void _doPause() {
        this.mShouldPlay = false;
        this.mLogger.pause();
        _pause();
        this.mPauseStartT = SystemClock.elapsedRealtime();
        IPlayDurationManager iPlayDurationManager = this.mPlayDuration;
        if (iPlayDurationManager != null) {
            iPlayDurationManager.stop();
        }
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface != null) {
            videoSurface.setIntOption(33, 0);
        }
    }

    void _doRefreshCpu() {
        if ((!TTVideoEngine.sColdStartOptimize || this.mIsColdStart != 1) && getConfigInt(1218, this.mMetrcisAbility) > 0) {
            PlayerMetrics playerMetrics = PlayerMetrics.getInstance();
            playerMetrics.setMetricsAbilityOption(getConfigInt(1218, this.mMetrcisAbility));
            playerMetrics.setMetricsIntervalOption(getConfigInt(1219, this.mMetrcisInterVal));
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                playerMetrics.beginCpuRefresh(mediaPlayer.getStringOption(1804));
                playerMetrics.refreshWhenBegin();
            }
        }
    }

    void _doRelease() {
        EngineThreadPool.addExecuteTask(new VideoInfoCollector.myVideoCollectorUnregister(this.mSerial));
        this.mShouldPlay = false;
        _stop(false, 1);
        releaseTextureRenderRef();
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.mMediaPlayer = null;
                throw th;
            }
            this.mMediaPlayer = null;
            _clearSurface();
        }
        rs1.g gVar = this.mABRModule;
        if (gVar != null) {
            gVar.release();
            this.mABRModule = null;
        }
        _doReleaseCommon();
    }

    void _pauseByInterruption() {
        TTVideoEngineLog.i(logcatTag(), "_pause ");
        if (!this.mPrepared) {
            this.mPausedBeforePrepared = true;
            return;
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            TTVideoEngineLog.i(logcatTag(), "player will pause by interruption");
            mediaPlayer.pause();
            this.mPlaybackState = 2;
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void clearTextureRef() {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "clearTextureRef," + this);
        }
        if (getConfigInt(1414, this.mEnableClearTextureRefAsync) == 1 && this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(35);
        } else {
            _doClearTextureRef();
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal, com.ss.ttvideoengine.ITTVideoEngineInternal
    public Surface getSurface() {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "getSurface:" + this.mSurface + ", this:" + this);
        }
        return this.mSurface;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal, com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isMute() {
        boolean z = this.mIsMute;
        if (this.mState == 3 && (this.mShouldPlay || this.mPlaybackState == 2)) {
            if (this.mLooperThread.checkEngineLooperThread(true)) {
                this.mLooperThread.sendEngineMessage(155, -1L);
                this.mLooperThread.mEngineMsgRetValue.setDataPosition(0);
                if (this.mLooperThread.mEngineMsgRetValue.readInt() == 1) {
                    return true;
                }
                return false;
            }
            return _doIsMute();
        }
        return z;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void notifyCacheEnd() {
        if (this.mListenerCompact.getVideoEngineInfoListener() != null) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "notify cache end. source id: " + this.mUsingDataLoaderPlayRawKey);
            }
            VideoEngineInfos videoEngineInfos = new VideoEngineInfos();
            videoEngineInfos.setKey("mdlcacheend");
            notifyEngineInfo(videoEngineInfos, true);
        }
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void pause() {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "pause," + this);
        }
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(2);
        } else {
            _doPause();
        }
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void prepare() {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "prepare," + this);
        }
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(22);
        } else {
            _doPrepare();
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean supportByteVC1Playback() {
        if (this.mLooperThread.checkEngineLooperThread(true)) {
            this.mLooperThread.sendEngineMessage(156, -1L);
            this.mLooperThread.mEngineMsgRetValue.setDataPosition(0);
            if (this.mLooperThread.mEngineMsgRetValue.readInt() == 1) {
                return true;
            }
            return false;
        }
        return _doSupportByteVC1Playback();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean supportByteVC2Playback() {
        if (this.mLooperThread.checkEngineLooperThread(true)) {
            this.mLooperThread.sendEngineMessage(157, -1L);
            this.mLooperThread.mEngineMsgRetValue.setDataPosition(0);
            if (this.mLooperThread.mEngineMsgRetValue.readInt() == 1) {
                return true;
            }
            return false;
        }
        return _doSupportByteVC2Playback();
    }

    private static class MDLCacheSizeRunnable implements Runnable {
        private WeakReference<TTVideoEngineImpl> mVideoEngineRef;
        private ArrayList<String> temFilePaths;
        private ArrayList<String> temKeys;

        static {
            Covode.recordClassIndex(652337);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null || tTVideoEngineImpl.mState == 5) {
                return;
            }
            String str = tTVideoEngineImpl.mVideoID;
            String str2 = tTVideoEngineImpl.mMDLGroupId;
            ArrayList<String> arrayList = this.temKeys;
            if (arrayList != null && arrayList.size() > 0) {
                for (int i2 = 0; i2 < this.temKeys.size(); i2++) {
                    String str3 = this.temKeys.get(i2);
                    long cacheFileSize = TTVideoEngine.getCacheFileSize(str3);
                    if (cacheFileSize == 0) {
                        i = (int) TTVideoEngine.getMissReason(1, str3, str, str2);
                    } else {
                        i = 0;
                    }
                    if (tTVideoEngineImpl.mHandler != null) {
                        tTVideoEngineImpl.mHandler.sendMessage(Message.obtain(tTVideoEngineImpl.mHandler, 10, (int) cacheFileSize, i, str3));
                    }
                }
            }
        }

        public MDLCacheSizeRunnable(TTVideoEngineImpl tTVideoEngineImpl, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
            this.mVideoEngineRef = new WeakReference<>(tTVideoEngineImpl);
            this.temKeys = arrayList;
            this.temFilePaths = arrayList2;
        }
    }

    private static class MyReleaseRunnable implements Runnable {
        private rs1.g mABRModule;
        private WeakReference<TTVideoEngineImpl> mEngineRef;
        private MediaPlayer mPlayer;

        static {
            Covode.recordClassIndex(652345);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mPlayer != null) {
                try {
                    TTVideoEngineLog.i(TTVideoEngineInternal.logcatTag(this.mEngineRef.get()), "MyReleaseRunnable release");
                    this.mPlayer.release();
                    this.mPlayer = null;
                    rs1.g gVar = this.mABRModule;
                    if (gVar != null) {
                        gVar.release();
                        this.mABRModule = null;
                    }
                } catch (Exception e) {
                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                        TTVideoEngineLog.e(TTVideoEngineInternal.logcatTag(this.mEngineRef.get()), e.toString());
                    }
                }
            }
        }

        public MyReleaseRunnable(TTVideoEngineImpl tTVideoEngineImpl, MediaPlayer mediaPlayer, rs1.g gVar) {
            this.mEngineRef = new WeakReference<>(tTVideoEngineImpl);
            this.mPlayer = mediaPlayer;
            this.mABRModule = gVar;
        }
    }

    private void _fetchSubInfo() {
        String _getSubApiString = _getSubApiString();
        if (getConfigInt(400, this.mIsUseBoe ? 1 : 0) == 1) {
            _getSubApiString = TTHelper.buildBoeUrl(_getSubApiString);
        }
        String BuildHttpsApi = TTVideoEngineUtils.BuildHttpsApi(_getSubApiString);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "start to fetch sub info:" + BuildHttpsApi);
        }
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            iVideoEventLogger.setSubtitleRequestUrl(BuildHttpsApi);
        }
        SubInfoFetcher subInfoFetcher = new SubInfoFetcher(this.mContext, getNetClientSetByUser());
        this.mSubFetcher = subInfoFetcher;
        subInfoFetcher.setListener(new MySubFetcherListener(this));
        this.mSubFetcher.fetchInfo(BuildHttpsApi);
    }

    private void _logFirstFrame() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (!this.mHasFirstFrameShown) {
            _updateLogTime();
            IVideoEventLogger iVideoEventLogger = this.mLogger;
            if (iVideoEventLogger != null) {
                iVideoEventLogger.showedFirstFrame();
            }
            this.mHasFirstFrameShown = true;
        } else if (mediaPlayer != null) {
            this.mVideoCodecID = mediaPlayer.getIntOption(141, -1);
            this.mAudioCodecProfile = mediaPlayer.getIntOption(402, -1);
            this.mVideoCodecProfile = mediaPlayer.getIntOption(403, -1);
        }
        if (mediaPlayer != null) {
            this.mVideoCodecType = mediaPlayer.getIntOption(157, -1);
            this.mAudioCodecType = mediaPlayer.getIntOption(158, -1);
            this.mAudioCodecID = mediaPlayer.getIntOption(140, -1);
            this.mBitrate = mediaPlayer.getLongOption(171, -1L);
            this.mContainerFPS = mediaPlayer.getFloatOption(151, 0.0f);
        }
    }

    private void _logRenderStartTime() {
        if (!this.mHasFirstFrameShown && this.mLogger != null) {
            this.mVVTime = System.currentTimeMillis();
            this.mRenderStartTime = SystemClock.elapsedRealtime();
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "mRenderStartTime:" + this.mRenderStartTime + ", curT:" + this.mVVTime);
            }
            this.mLogger.showedOneFrame();
        }
    }

    private void _sendMdlCacheMsg() {
        ArrayList arrayList;
        VideoInfo videoInfo;
        if (getConfigInt(160, this.mDataLoaderEnable) > 0) {
            ArrayList arrayList2 = new ArrayList(this.mUsingDataLoaderPlayFilePaths);
            this.mVideoPreloadSize = 0L;
            if (this.mBashDashDefaultMDLKeys.size() == 2) {
                arrayList = new ArrayList(this.mBashDashDefaultMDLKeys.values());
            } else if (!this.mIsLocal && !this.mIsPlayItem && !this.mIsPreloaderItem && !this.mIsDirectURL && (videoInfo = this.currentVideoInfo) != null && !TextUtils.isEmpty(videoInfo.getValueStr(15))) {
                arrayList = new ArrayList();
                arrayList.add(this.currentVideoInfo.getValueStr(15));
            } else {
                arrayList = new ArrayList(this.mUsingDataLoaderPlayTaskKeys);
            }
            EngineThreadPool.addExecuteTask(new MDLCacheSizeRunnable(this, arrayList, arrayList2));
        }
    }

    private void _syncPlayInfoToMdl() {
        long max;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            if (isPcdnNeedPlayInfo() || DataLoaderHelper.getDataLoader().isNeedPlayInfo()) {
                if (!this.mIsPlayComplete && !this.mErrorEnd) {
                    long longOption = mediaPlayer.getLongOption(73, -1L);
                    long longOption2 = mediaPlayer.getLongOption(72, -1L);
                    int intOption = mediaPlayer.getIntOption(62, 0);
                    int intOption2 = mediaPlayer.getIntOption(61, 0);
                    if (intOption == 1 && intOption2 == 1) {
                        max = Math.max(0L, Math.min(longOption, longOption2));
                    } else if (intOption2 == 1) {
                        max = Math.max(0L, longOption);
                    } else if (intOption == 1) {
                        max = Math.max(0L, longOption2);
                    } else {
                        return;
                    }
                    setPlayInfo(5, max);
                    return;
                }
                TTVideoEngineLog.d(logcatTag(), "_syncPlayInfoToMdl complete");
            }
        }
    }

    private boolean _validateVideo() {
        boolean z;
        if (this.mPlayAPIVersion >= 2) {
            return true;
        }
        try {
            String videoRefStr = this.mVideoModel.getVideoRefStr(105);
            if (!TextUtils.isEmpty(videoRefStr) && !"0".equals(videoRefStr) && !isOSPlayer()) {
                z = !this.mVideoID.equals(_getCommentInfo().get("vid"));
            } else {
                z = false;
            }
            if (z) {
                this.mLogger.validateVideoMetaInfoFail(new Error("kTTVideoErrorDomainVideoOwnPlayer", -9991, "header meta validate failed"));
            }
        } catch (NullPointerException unused) {
            TTVideoEngineLog.e(logcatTag(), "fetcher video model null");
        }
        return true;
    }

    private void createDefaultCacheFileDirectory() {
        if (mCreatCacheFileLock.tryLock()) {
            if (!mIsFirstOpenEngine) {
                mCreatCacheFileLock.unlock();
                return;
            }
            mIsFirstOpenEngine = false;
            String defaultCacheFileDirPath = getDefaultCacheFileDirPath();
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(defaultCacheFileDirPath);
            if (polarisFileWrapper.exists()) {
                if (polarisFileWrapper.list() != null) {
                    PolarisFileWrapper polarisFileWrapper2 = new PolarisFileWrapper(defaultCacheFileDirPath + "tem");
                    polarisFileWrapper.renameTo(polarisFileWrapper2);
                    polarisFileWrapper.mkdirs();
                    EngineThreadPool.addExecuteTask(new RecursionDeleteFileRunnable(polarisFileWrapper2));
                }
            } else {
                polarisFileWrapper.mkdirs();
            }
            EngineThreadPool.addExecuteTask(new DeleteBeforeDirFileRunnable(this.mContext.getApplicationContext()));
            mCreatCacheFileLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveEvent$6() {
        int i = this.mState;
        if (i != 0 && i != 4 && i != 5) {
            _updateLogger();
            this.mLogger.addWatchedDuration(this.mPlayDuration.getPlayedDuration());
            this.mLogger.saveEvent();
        } else if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
            TTVideoEngineLog.e(logcatTag(), "invalid state: " + this.mState);
        }
    }

    private void releaseTextureRenderRef() {
        if (this.mTextureRenderer == null) {
            return;
        }
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface != null) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "release video surface : " + videoSurface);
            }
            doOpenSR(0, -7880);
            videoSurface.release();
            this.mTextureSurface = null;
        }
        this.mTextureRenderer = null;
        this.mRenderHDR2SDR = 0;
        this.mEngineConfig.remove(652);
        this.mSyncUpdateSurface = 0;
        this.mTextureRenderError = 0;
        TTVideoEngineLog.i(logcatTag(), "mTextureRenderer become to null");
    }

    private void setSpeedTest() {
        if (this.mHaveSetSpeedTest) {
            return;
        }
        this.mTTSpeedListener = new TTTestSpeedListener(this.mEngineWrapper, StrategyCenter.sNetSpeedPredictor, StrategyCenter.sNetAbrSpeedPredictor);
        DataLoaderHelper.getDataLoader().setTestSpeedListener(this.mTTSpeedListener);
        this.mHaveSetSpeedTest = true;
        this.mLogger.setIntOption(17, TTVideoEngine.sTestSpeedSampleInterval);
        this.mLogger.setIntOption(18, TTVideoEngine.sIsReportTestSpeedInfo);
        this.mLogger.setIntOption(19, TTVideoEngine.sReportSpeedInfoMaxWindowSize);
        this.mLogger.setSpeedPredictorAlgoType(TTVideoEngine.sNetSpeedAbrPredictType);
    }

    private void setSurfaceDimensionsToTextureRender() {
        int i;
        int i2;
        if (1 == this.mIsEnabelUsedRefactorSurfaceView) {
            VideoSurface videoSurface = this.mTextureSurface;
            if (videoSurface != null && (i = this.mWindowWidth) > 0 && (i2 = this.mWindowHeight) > 0) {
                videoSurface.setSurfaceDimensions(i, i2);
                return;
            }
            return;
        }
        VideoSurface videoSurface2 = this.mTextureSurface;
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null && videoSurface2 != null) {
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            if (surfaceFrame != null && TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i("TTVideoEngine", "setSurfaceDimensionsToTextureRender vs:" + videoSurface2);
            }
            videoSurface2.setSurfaceDimensions(surfaceFrame.right - surfaceFrame.left, surfaceFrame.bottom - surfaceFrame.top);
        }
    }

    public void TTVideoEngineImpl___doPlay$___twin___() {
        _initUsingHandle();
        boolean z = true;
        this.mShouldPlay = true;
        this.mShouldStop = false;
        this.mUserStopped = false;
        this.mAccumulatedErrorCount = 0;
        IVideoModel iVideoModel = this.mVideoModel;
        if (iVideoModel != null) {
            iVideoModel.setUpResolution(this.mResolutionMap);
        }
        if (this.mHasComplete) {
            this.mLogger.setIntOption(14, 1);
            this.mHasComplete = false;
        }
        EngineInstanceHolder.getInstance().add(this.mEngineWrapper);
        if (!this.mIsStartPlayAutomatically && this.mPlayTime <= 0 && !this.mPrepared) {
            z = false;
        }
        _play(z);
        this.mIsPlayComplete = false;
    }

    public void TTVideoEngineImpl___doReleaseAsync$___twin___() {
        if (!isInHousePlayer()) {
            release();
            return;
        }
        EngineThreadPool.addExecuteTask(new VideoInfoCollector.myVideoCollectorUnregister(this.mSerial));
        this.mShouldPlay = false;
        _stop(false, 2);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            if (1 == this.mIsEnabelUsedRefactorSurfaceView) {
                MediaPlayer mediaPlayer2 = this.mAsyncPlayer;
                if (mediaPlayer2 != null) {
                    mediaPlayer = mediaPlayer2;
                }
                _doExternalWindowSetSurfaceNull(mediaPlayer, false);
            } else if (getConfigInt(951, this.mSurfaceHolderByKernel) != 0) {
                if (this.mSurfaceHolder != null) {
                    this.mMediaPlayer.setDisplay(null);
                }
                if (this.mSurface != null) {
                    setSurfaceHook(null);
                }
            } else if (this.mSurfaceHolder != null || this.mSurface != null) {
                setSurfaceHook(null);
            }
            releaseTextureRenderRef();
        }
        MediaPlayer mediaPlayer3 = this.mAsyncPlayer;
        if (mediaPlayer3 != null) {
            mediaPlayer3.release();
            this.mAsyncPlayer = null;
        }
        MediaPlayer mediaPlayer4 = this.mMediaPlayer;
        rs1.g gVar = this.mABRModule;
        this.mMediaPlayer = null;
        this.mABRModule = null;
        if (mediaPlayer4 != null) {
            EngineThreadPool.addExecuteTask(new MyReleaseRunnable(this, mediaPlayer4, gVar));
        }
        _doReleaseCommon();
    }

    public void TTVideoEngineImpl___doReleaseCommon$___twin___() {
        TTVideoEngineMonitor tTVideoEngineMonitor = this.mEngineStateMonitor;
        if (tTVideoEngineMonitor != null) {
            tTVideoEngineMonitor.stopObserve(hashCode());
        }
        EngineInstanceHolder.getInstance().remove(this.mEngineWrapper);
        NetUtils.release(this.mContext);
        mdlFetcherRemove();
        IPlayDurationManager iPlayDurationManager = this.mPlayDuration;
        if (iPlayDurationManager != null) {
            iPlayDurationManager.release();
        }
        this.mTraitObjManager.removeAll();
        this.mAudioProcessor = null;
        this.mPreloaderItem = null;
        this.mIsPreloaderItem = false;
        this.mFileKey = null;
        this.mMaskInfoInterface = null;
        this.mAIBarrageInfoInterface = null;
        this.mSubInfoInterface = null;
        this.mSubPathInfo = null;
        this.mHasSetAESrcPeak = false;
        this.mHasSetAESrcLoudness = false;
        this.mHasSetAEVolumeInfo = false;
        this.mSRNotUseReason = 0;
        this.mDisplayMode = null;
        _dataLoaderRemoveEngineRef();
        IntertrustDrmHelper intertrustDrmHelper = this.mIntertrustDrmHelper;
        if (intertrustDrmHelper != null) {
            intertrustDrmHelper.release();
            this.mIntertrustDrmHelper = null;
        }
        this.mState = 5;
        this.mLooperThread.closeEngineLooperThread();
    }

    public void TTVideoEngineImpl__play$___twin___() {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "play:" + this);
        }
        if (this.mState == 5) {
            TTVideoEngineLog.e(logcatTag(), "already released, return");
            return;
        }
        Iterator<VideoEngineStateListener> it2 = TTVideoEngine.sEngineStateListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onEnginePlay(this.mEngineWrapper);
        }
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(1);
        } else {
            _doPlay();
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public MediaTrackInfoModel[] getMediaTrackInfos() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            String stringOption = mediaPlayer.getStringOption(473);
            if (!TextUtils.isEmpty(stringOption)) {
                ArrayList arrayList = new ArrayList();
                MediaTrackInfoModel[] mediaTrackInfoModelArr = null;
                try {
                    try {
                        JSONArray jSONArray = new JSONArray(stringOption);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            JSONObject jSONObject = new JSONObject(optJSONObject.getString("media_track_info"));
                            jSONObject.put("index", optJSONObject.getInt("index"));
                            jSONObject.put("type", Integer.parseInt(jSONObject.getString("type")));
                            arrayList.add(new MediaTrackInfoModel(jSONObject));
                        }
                        mediaTrackInfoModelArr = new MediaTrackInfoModel[arrayList.size()];
                        arrayList.toArray(mediaTrackInfoModelArr);
                        return mediaTrackInfoModelArr;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return mediaTrackInfoModelArr;
                    }
                } catch (Throwable unused) {
                    return mediaTrackInfoModelArr;
                }
            }
        }
        return new MediaTrackInfoModel[0];
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public JSONObject getPlayErrorInfo() {
        if (this.mLooperThread.checkEngineLooperThread(true)) {
            this.mLooperThread.sendEngineMessage(154, -1L);
            this.mLooperThread.mEngineMsgRetValue.setDataPosition(0);
            String str = (String) this.mLooperThread.mEngineMsgRetValue.readValue(getClass().getClassLoader());
            if (!TextUtils.isEmpty(str)) {
                try {
                    return new JSONObject(str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return _doGetPlayErrorInfo();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean isplaybackUsedSR() {
        VideoSurface videoSurface = this.mTextureSurface;
        boolean z = false;
        if (videoSurface != null && videoSurface.getIntOption(6) == 1) {
            z = true;
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "isplaybackUsedSR ,mPlayBackUsedSR = " + this.mPlayBackUsedSR + ", mTextureSrOpen = " + this.mTextureSrOpen + ", ret = " + z);
        }
        return z;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void release() {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "release," + this);
        }
        Iterator<VideoEngineStateListener> it2 = TTVideoEngine.sEngineStateListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onEngineStop(this.mEngineWrapper);
        }
        this.mShouldStop = true;
        this.mPrepared = false;
        this.mReleased = true;
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(4);
        } else {
            _doRelease();
        }
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void releaseAsync() {
        PlayerMetrics.getInstance().refreshWhenEnd();
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "releaseAsync," + this);
        }
        Iterator<VideoEngineStateListener> it2 = TTVideoEngine.sEngineStateListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onEngineStop(this.mEngineWrapper);
        }
        this.mShouldStop = true;
        this.mPrepared = false;
        this.mReleased = true;
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(5);
        } else {
            _doReleaseAsync();
        }
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void start() {
        TTVideoEngineLog.i(logcatTag(), "start:" + this);
        Iterator<VideoEngineStateListener> it2 = TTVideoEngine.sEngineStateListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onEnginePlay(this.mEngineWrapper);
        }
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(23);
        } else {
            _doStart();
        }
    }

    private void _ShutdownOldSource() {
        this.mIsLocal = false;
        this.mIsDirectURL = false;
        this.mIsPreloaderItem = false;
        this.mIsPlayItem = false;
        this.mIsFeedInfo = false;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && mediaPlayer.getPlayerType() == 0) {
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
        _reset();
        _resetUrlIndexMap();
        this.mTraitObjManager.removeAll();
        this.mMediaDataSource = null;
        mdlFetcherRemove();
        this.mState = 0;
        this.currentVideoInfo = null;
        this.mDynamicAudioInfo = null;
        this.mDynamicVideoInfo = null;
        this.mVideoModel = null;
        this.mOriginalUrls = null;
        this.mLocalURL = null;
        this.mVideoID = null;
        this.mPlayFd = null;
        this.mDirectURL = null;
        this.mTextureFirstFrame = false;
        this.mTexNotifyFirstFrame = false;
        this.mHasFirstFrameShown = false;
        this.mHasFetchedSubtitle = false;
        this.mHasAudioFirstFrameShown = false;
        this.mPlayDuration.reset();
        this.mIsPlayComplete = false;
        this.mDecodedVideoFirstFrame = false;
        this.mPlayStartTimestamp = 0L;
        this.mHasComplete = false;
        this.mPlayTime = 0L;
        this.mRetryingNotHandleError = false;
        this.dashAudioUrlMap.clear();
        this.dashUrlMap.clear();
        this.mCurPosition = -1;
        this.mVideoCodecType = -1;
        this.mAudioCodecType = -1;
        this.mVideoCodecID = -1;
        this.mAudioCodecID = -1;
        this.mAudioCodecProfile = -1;
        this.mVideoCodecProfile = -1;
        this.mBitrate = -1L;
        this.mContainerFPS = 0.0f;
        this.mAudioProcessor = null;
        this.mHasSetAESrcPeak = false;
        this.mHasSetAESrcLoudness = false;
        this.mHasSetAEVolumeInfo = false;
        this.mSubDesInfoModel = null;
        this.mSeeking = false;
        this.mPrecisePausePts = 0L;
        this.mEngineConfig.remove(709);
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            iVideoEventLogger.setLoggerTimes(63);
        }
        this.mFileHashs.clear();
        this.urlIPMap.clear();
        this.mMDLGroupId = null;
        this.mFormat = null;
        this.mCustomBitrate = -1;
    }

    private void _audioRenderStart() {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "_audioRenderStart,this:" + this);
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        PlayerEventListener playerEventListener = this.mPlayerEventListener;
        if (getConfigInt(664, this.mEnableDebugUINotify) != 0 && playerEventListener != null) {
            playerEventListener.onAudioRenderOpened(mediaPlayer.getIntOption(48, -1), mediaPlayer.getLongOption(156, -1L), mediaPlayer.getLongOption(163, -1L));
        }
        if (!this.mHasAudioFirstFrameShown) {
            this.mHasAudioFirstFrameShown = true;
            this.mLogger.setLongOption(77, mediaPlayer.getLongOption(628, -1L));
            if (this.mSurface == null && this.mSurfaceHolder == null && this.mWindowClient == null && this.mRadioModeEnable == 0 && mediaPlayer.getIntOption(62, -100) != 0) {
                this.mLogger.setIntOption(TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE, 1);
            }
        }
        if (this.mHasFirstFrameShown && !this.mSeamSwitchingResolution) {
            return;
        }
        if (mediaPlayer.getIntOption(62, -100) == 0 || this.mRadioModeEnable != 0 || this.mShouldUseAudioRenderStart || (getConfigInt(707, this.mSupportPlayWhenNoSurface) == 1 && this.mSurface == null && this.mSurfaceHolder == null && this.mWindowClient == null)) {
            _renderStart();
        }
    }

    private void _configWithAppSettings() {
        int i = 1;
        if (!this.mSettedKeys.contains(11) && !this.mEngineConfig.isKeySet(11)) {
            this.mBufferTimeout = InfoWrapper.getBufferTimeOut();
            this.mEngineConfig.setIntOption(11, InfoWrapper.getBufferTimeOut());
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d(logcatTag(), "==========mBufferTimeout:" + getConfigInt(11, this.mBufferTimeout));
            }
        }
        int byteVC1SoftwareCapabilityEnable = InfoWrapper.getByteVC1SoftwareCapabilityEnable();
        if (!this.mSettedKeys.contains(7)) {
            this.mHardwareDecodeEnablePlayer2 = InfoWrapper.getHardwareEnable();
            if (byteVC1SoftwareCapabilityEnable == 0 && !this.mCodecStrategyAdapter.isCodecStrategyValid() && this.mErrorCount <= 0) {
                this.mHardwareDecodeEnablePlayer2 = 1;
            }
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d(logcatTag(), "==========mHardwareDecodeEnablePlayer2:" + this.mHardwareDecodeEnablePlayer2);
            }
        }
        if (byteVC1SoftwareCapabilityEnable != 0) {
            i = 0;
        }
        this.mForbidByteVC1SoftwareDecode = i;
    }

    private HashMap<String, Integer> _getMdlErrorInfo() {
        String playLog;
        JSONObject jSONObject = null;
        if (getConfigInt(160, this.mDataLoaderEnable) == 0) {
            return null;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        synchronized (this) {
            playLog = DataLoaderHelper.getDataLoader().getPlayLog(this.mTraceId);
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "get mdl info: " + playLog);
        }
        if (playLog != null && !TextUtils.isEmpty(playLog)) {
            try {
                jSONObject = new JSONObject(playLog);
            } catch (JSONException e) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                    TTVideoEngineLog.e(logcatTag(), e.toString());
                }
            }
        }
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("err_code")) {
                    hashMap.put("mdl_err_code", Integer.valueOf(((Number) jSONObject.get("err_code")).intValue()));
                }
                if (!jSONObject.isNull("sub_err_code")) {
                    hashMap.put("mdl_sub_err_code", Integer.valueOf(((Number) jSONObject.get("sub_err_code")).intValue()));
                }
            } catch (Exception e2) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(e2);
                }
            }
        }
        return hashMap;
    }

    private String _getSubApiString() {
        if (this.mVideoModel != null && this.currentVideoInfo != null) {
            StringBuilder sb = new StringBuilder();
            String valueStr = this.currentVideoInfo.getValueStr(28);
            if (valueStr == null) {
                valueStr = "";
            }
            String configString = getConfigString(531, this.mSubHostName);
            String configString2 = getConfigString(546, this.mSubIds);
            String configString3 = getConfigString(547, this.mSubFormat);
            if (!TextUtils.isEmpty(configString)) {
                if (!configString.startsWith("http://") && !configString.startsWith("https://")) {
                    sb.append(String.format("https://%s/video/subtitle/v1/%s/%s?", configString, this.mVideoID, valueStr));
                } else {
                    sb.append(String.format("%s/video/subtitle/v1/%s/%s?", configString, this.mVideoID, valueStr));
                }
                if (!TextUtils.isEmpty(configString2)) {
                    sb.append(String.format("sub_ids=%s&language_ids=%s&versions=%s", configString2, this.mSubLanIds, this.mSubVersions));
                }
                if (!TextUtils.isEmpty(configString3)) {
                    if (!TextUtils.isEmpty(configString2)) {
                        sb.append("&");
                    }
                    sb.append(String.format("format=%s", configString3));
                }
            }
            return sb.toString();
        }
        return null;
    }

    private boolean _initIntertrustDrm() {
        IntertrustDrmHelper intertrustDrmHelper = this.mIntertrustDrmHelper;
        if (intertrustDrmHelper != null) {
            intertrustDrmHelper.stop();
        } else {
            this.mIntertrustDrmHelper = new IntertrustDrmHelper();
        }
        int init = this.mIntertrustDrmHelper.init(this.mContext, getConfigInt(38, this.mDrmCloseRootCheck));
        if (init != 0) {
            if (init == -1000) {
                receivedError(new Error("kTTVideoErrorDomainIntertrustDRM", -9939));
                return false;
            }
            if (init == -1) {
                receivedError(new Error("kTTVideoErrorDomainIntertrustDRM", -9938));
                return false;
            }
            if (init == -1002) {
                receivedError(new Error("kTTVideoErrorDomainIntertrustDRM", -9933));
                return false;
            }
            receivedError(new Error("kTTVideoErrorDomainIntertrustDRM", -9938, init));
            return false;
        }
        if (this.mIntertrustDrmHelper.start() == -1) {
            receivedError(new Error("kTTVideoErrorDomainIntertrustDRM", -9938));
            return false;
        }
        this.mIntertrustDrmHelper.setListener(new MyDrmTokenProcessedListener(this));
        if (!TextUtils.isEmpty(this.mTokenUrlTemplate)) {
            this.mIntertrustDrmHelper.setTokenUrlTemplate(this.mTokenUrlTemplate);
            return true;
        }
        return true;
    }

    private void _prepareToPlay() {
        String str;
        String str2;
        boolean z;
        IPlayDurationManager iPlayDurationManager = this.mPlayDuration;
        if (iPlayDurationManager != null) {
            iPlayDurationManager.clear();
        }
        this.mLogger.setTag(this.mTag);
        this.mLogger.setSubTag(this.mSubTag);
        if (this.mPlayStartTimestamp == 0) {
            this.mPlayStartTimestamp = System.currentTimeMillis();
        }
        if (!this.mIsLocal && !this.mIsDirectURL && this.mPlayFd == null && this.mMediaDataSource == null) {
            if (this.mIsPreloaderItem) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                long j = this.mPreloaderItem.mUrlTime;
                if (j > 0 && currentTimeMillis - j > 2400) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    _fetchVideoInfo();
                }
                _logFirstURL(this.mPreloaderItem.mUrl);
                _logBeginToPlay(this.mPreloaderItem.mVideoID);
                _singleURLParseAndPlay(this.mPreloaderItem.mUrl, this.mHeaders);
            } else if (this.mIsPlayItem) {
                _logBeginToPlay(this.mVideoID);
                _logFirstURL(this.mPlayItem.playURL);
                _singleURLParseAndPlay(this.mPlayItem.playURL, this.mHeaders);
            } else if (this.mIsFeedInfo) {
                _logBeginToPlay(this.mVideoID);
                _parseIPAddress(this.mVideoModel);
            } else {
                _logBeginToPlay(this.mVideoID);
                _fetchVideoInfo();
            }
        } else {
            _logBeginToPlay(this.mVideoID);
            if (this.mIsLocal) {
                str = this.mLocalURL;
            } else {
                str = this.mDirectURL;
            }
            _logFirstURL(str);
            if (this.mIsLocal) {
                str2 = this.mLocalURL;
            } else {
                str2 = this.mDirectURL;
            }
            _singleURLParseAndPlay(str2, this.mHeaders);
        }
        if (this.mMediaPlayer != null && isPcdnNeedPlayInfo()) {
            setPlayInfo(5, 0L);
        }
    }

    private void _resumeVideo() {
        IVideoModel iVideoModel;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "resumed video, shouldplay:" + this.mShouldPlay + ", mediaplayer:" + this.mMediaPlayer + ", prepared:" + this.mPrepared);
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && this.mShouldPlay) {
            mediaPlayer.setScreenOnWhilePlaying(true);
            if (this.mPrepared) {
                if (this.mPlaybackState == 0 || this.mIsPlayComplete) {
                    fetchedVideoInfo(this.mVideoModel);
                    if (!TextUtils.isEmpty(this.mVideoID) && !this.mIsFeedInfo && (iVideoModel = this.mVideoModel) != null) {
                        notifyFetchedVideoInfo(iVideoModel);
                    }
                }
                mediaPlayer.setIntOption(100, this.mStartTime);
                mediaPlayer.start();
                _dumpSurface("_renderVideo");
                _updateTextureState(1);
                if (this.mHasFirstFrameShown) {
                    IPlayDurationManager iPlayDurationManager = this.mPlayDuration;
                    if (iPlayDurationManager != null) {
                        iPlayDurationManager.start();
                    }
                    updatePlaybackState(1);
                }
                if (this.mABRModule != null && this.mEnableABR > 0 && isSupportSeamlessSwitch(this.mVideoModel)) {
                    this.mABRModule.b(TTVideoEngine.sABRAlgorithmType, getConfigInt(500, this.mABRTimerIntervalMilliseconds));
                    this.mLogger.setIsEnableABR(1);
                }
                if (shouldStartTextureRenderCheck()) {
                    this.mTextureSurface.setIntOption(33, 1);
                    return;
                }
                return;
            }
            this.mPausedBeforePrepared = false;
        }
    }

    private void _sendUrlInfoMsg() {
        String str;
        boolean z;
        ArrayList arrayList = new ArrayList();
        IVideoModel iVideoModel = this.mVideoModel;
        if (iVideoModel == null) {
            str = "";
        } else {
            str = iVideoModel.getDynamicType();
        }
        VideoEngineInfos videoEngineInfos = new VideoEngineInfos();
        if (this.mConfigCenterVersion > 0) {
            if (this.mEngineConfig.getIntOption(17) == 1) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = this.mDashEnabled;
        }
        if (z && !TextUtils.isEmpty(str) && str.equals("segment_base")) {
            VideoInfo _videoInfoForResolution = _videoInfoForResolution(this.currentResolution, VideoRef.TYPE_VIDEO, this.currentParams);
            Map<Integer, String> map = this.currentParams;
            if (map == null) {
                map = new HashMap<>();
            }
            int i = this.mAudioInfoId;
            if (i == -1) {
                i = this.mVideoModel.getVideoRefInt(230);
            }
            if (i >= 0) {
                map.put(42, "" + i);
            }
            VideoInfo _videoInfoForResolution2 = _videoInfoForResolution(this.currentResolution, VideoRef.TYPE_AUDIO, map);
            if (_videoInfoForResolution != null) {
                arrayList.add(_videoInfoForResolution);
                String valueStr = _videoInfoForResolution.getValueStr(15);
                if (valueStr != null) {
                    this.mBashDashDefaultMDLKeys.put("video", valueStr);
                }
                this.mDynamicVideoInfo = _videoInfoForResolution;
            }
            if (_videoInfoForResolution2 != null) {
                arrayList.add(_videoInfoForResolution2);
                String valueStr2 = _videoInfoForResolution2.getValueStr(15);
                if (valueStr2 != null) {
                    this.mBashDashDefaultMDLKeys.put("audio", valueStr2);
                }
                this.mABRCurrentDownloadedAudioBitrate = _videoInfoForResolution2.getValueInt(3);
                this.mDynamicAudioInfo = _videoInfoForResolution2;
            }
            videoEngineInfos.setKey("usingUrlInfos");
            videoEngineInfos.setUrlInfos(arrayList);
            notifyEngineInfo(videoEngineInfos, true);
            return;
        }
        VideoInfo videoInfo = this.currentVideoInfo;
        if (videoInfo != null) {
            arrayList.add(videoInfo);
            videoEngineInfos.setKey("usingUrlInfos");
            videoEngineInfos.setUrlInfos(arrayList);
            notifyEngineInfo(videoEngineInfos, true);
        }
    }

    private void _setRenderTraitIfNeed() {
        if (this.mMediaPlayer == null) {
            return;
        }
        int i = this.mEnableHardwareBufferRender;
        if (i == 0) {
            TTVideoEngineLog.i(logcatTag(), "HardwareBuffer render disable");
            return;
        }
        if (i == 1 && Build.VERSION.SDK_INT < 29) {
            TTVideoEngineLog.e(logcatTag(), "HardwareBuffer render unsupported");
            return;
        }
        int i2 = this.mTextureAlgType;
        if (i2 != 20 && i2 != 22 && i2 != 23) {
            TTVideoEngineLog.e(logcatTag(), "HardwareBuffer render unsupported, algType = " + this.mTextureAlgType);
            return;
        }
        if (this.mEnableCPPBYTEVC2CodecOpt != 0 && this.mRenderType != 0) {
            MyRenderTrait myRenderTrait = new MyRenderTrait(0, this, 0);
            TTVideoEngineLog.i(logcatTag(), "set MyRenderTrait@0x" + Integer.toHexString(myRenderTrait.hashCode()));
            this.mMediaPlayer.setTraitObject(6, myRenderTrait);
            this.mMediaPlayer.setIntOption(49, this.mDefaultRenderType);
            this.mMediaPlayer.setIntOption(56, 8);
            return;
        }
        TTVideoEngineLog.e(logcatTag(), "HardwareBuffer render unavailable, renderType = " + this.mRenderType);
    }

    private void _updateEffectLog() {
        if (this.mTextureSurface != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Integer num : this.effectTypeSet) {
                float floatOption = this.mTextureSurface.getFloatOption(124, num.intValue());
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("type", num);
                linkedHashMap.put("avrtime", Float.valueOf(floatOption));
                arrayList.add(linkedHashMap.toString());
                int intOption = this.mTextureSurface.getIntOption(126, num.intValue());
                if (intOption > 0) {
                    String stringOption = this.mTextureSurface.getStringOption(127, num.intValue());
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("type", num);
                    linkedHashMap2.put("errc", Integer.valueOf(intOption));
                    linkedHashMap2.put("errmsg", stringOption);
                    arrayList2.add(linkedHashMap2.toString());
                }
            }
            IVideoEventLogger iVideoEventLogger = this.mLogger;
            if (iVideoEventLogger != null) {
                iVideoEventLogger.setFloatOption(162, this.mTextureSurface.getFloatOption(120));
                this.mLogger.setStringOption(163, arrayList.toString());
                this.mLogger.setFloatOption(164, this.mTextureSurface.getFloatOption(125));
                if (!arrayList2.isEmpty()) {
                    this.mLogger.setStringOption(165, arrayList2.toString());
                }
                float floatOption2 = this.mTextureSurface.getFloatOption(131);
                float floatOption3 = this.mTextureSurface.getFloatOption(132);
                this.mLogger.setFloatOption(167, floatOption2);
                this.mLogger.setFloatOption(166, floatOption3);
            }
        }
    }

    private void _updateVU() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, IpInfo> entry : this.urlIPMap.entrySet()) {
            String key = entry.getKey();
            IpInfo value = entry.getValue();
            if (key != null && value != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("url", key);
                hashMap.put("ip", value.ip);
                hashMap.put("dns", value.dns);
                hashMap.put("dns_cache_open", Integer.valueOf(value.isDNSCacheOpen));
                hashMap.put("server_dns_open", Integer.valueOf(value.isServerDNSOpen));
                hashMap.put("url_desc", value.urlDesc);
                if (this.mIsDirectURL && !TextUtils.isEmpty(this.mGroupID)) {
                    hashMap.put("gid", this.mGroupID);
                }
                arrayList.add(hashMap);
            }
        }
        if (!this.mIsDirectURL) {
            this.mLogger.setVUArray(arrayList);
        }
    }

    private String getMediaFileKey() {
        String str;
        String str2;
        String str3;
        long j;
        if (!this.mIsLocal && !this.mIsPlayItem && !this.mIsPreloaderItem) {
            if (this.mIsDirectURL) {
                return this.mFileKey;
            }
            if (this.mVideoModel == null) {
                return null;
            }
            VideoInfo videoInfo = this.currentVideoInfo;
            if (videoInfo != null) {
                str = videoInfo.getValueStr(26);
                j = this.currentVideoInfo.getValueLong(12);
                str2 = this.currentVideoInfo.getValueStr(5);
                str3 = this.currentVideoInfo.getValueStr(15);
            } else {
                str = null;
                str2 = null;
                str3 = null;
                j = 0;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && j != 0) {
                if (!TextUtils.isEmpty(str2)) {
                    return String.format("%s_%s_%s_%d_%s", this.mVideoID, str, str3, Long.valueOf(j), TTHelper.customBase64Encode(str2));
                }
                return String.format("%s_%s_%s_%d", this.mVideoID, str, str3, Long.valueOf(j));
            }
        }
        return null;
    }

    public MediaPlayer TTVideoEngineImpl__createMediaPlayer$___twin___() {
        updateConfigParams(this.mConfigParams);
        MediaPlayer create = MediaPlayerWrapper.create(this.mContext, this.mPlayerDegradeMode, this.mConfigParams);
        if (create == null) {
            return null;
        }
        MediaPlayerWrapper mediaPlayerWrapper = (MediaPlayerWrapper) create;
        if (mediaPlayerWrapper.hasException() && this.mLogger != null) {
            this.mLogger.logPluginException(mediaPlayerWrapper.getExceptionStr() + ",customState:" + this.mClassLoaderState);
        }
        if (mediaPlayerWrapper.getPlayerClient() == null) {
            return null;
        }
        TTVideoEngineLog.i(logcatTag(), String.format(Locale.US, "createMediaPlayer, NativeHandle:%x", Long.valueOf(create.getLongOption(50, 0L))));
        _setupMediaCodec(create);
        _tryRegisterMdlHandle(create);
        DataLoaderHelper.getDataLoader().getIntValue(9016);
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            iVideoEventLogger.setPlayerCreatedT(System.currentTimeMillis());
        }
        this.mPlayerConfigExecutor.setMediaPlayer(create);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "_playInternal MediaPlayerWrapper.create done videoId = " + this.mVideoID);
        }
        return create;
    }

    void _doStop() {
        int i;
        _stop(true, 0);
        int configInt = getConfigInt(991, this.mAutoDisconnectedCpu);
        if (configInt == 1) {
            boolean _checkRefreshSurface = _checkRefreshSurface();
            this.mRefreshSurfaceFlag = _checkRefreshSurface;
            if (_checkRefreshSurface) {
                _refreshSurface();
            } else {
                this.mRefreshSurfaceDone = false;
            }
        }
        if (getConfigInt(27, this.mCleanWhenStop) > 0) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.reset();
                this.mPrepared = false;
            }
            int configInt2 = getConfigInt(542, this.mCleanSurfaceWhenReset);
            MediaPlayer mediaPlayer2 = this.mMediaPlayer;
            if (mediaPlayer2 != null && this.mTextureSurface != null && (configInt2 > 0 || (configInt == 1 && this.mRefreshTextureSurface))) {
                if (1 == this.mIsEnabelUsedRefactorSurfaceView) {
                    _doExternalWindowSetSurfaceNull(mediaPlayer2, true);
                } else {
                    mediaPlayer2.setSurface(null);
                }
            }
            if (getConfigInt(4004, this.mDecoderRenderClearTextureRenderRef) > 0 && (i = this.mVideoCodecType) > 0 && i != 2) {
                releaseTextureRenderRef();
            }
            if (configInt == 1 && this.mRefreshTextureSurface) {
                releaseTextureRenderRef();
                this.mRefreshTextureSurface = false;
            }
            MediaPlayer mediaPlayer3 = this.mMediaPlayer;
            if (mediaPlayer3 != null && mediaPlayer3.getPlayerType() == 0) {
                this.mMediaPlayer.release();
                this.mMediaPlayer = null;
            }
            MediaPlayer mediaPlayer4 = this.mAsyncPlayer;
            if (mediaPlayer4 != null) {
                mediaPlayer4.release();
                this.mAsyncPlayer = null;
            }
            this.mState = 0;
        }
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface != null && videoSurface.getIntOption(133) == 1) {
            MediaPlayer mediaPlayer5 = this.mAsyncPlayer;
            if (mediaPlayer5 == null) {
                mediaPlayer5 = this.mMediaPlayer;
            }
            if (mediaPlayer5 != null) {
                if (1 == this.mIsEnabelUsedRefactorSurfaceView) {
                    _doExternalWindowSetSurfaceNull(mediaPlayer5, true);
                } else {
                    mediaPlayer5.setSurface(null);
                }
            }
            releaseTextureRenderRef();
            TTVideoEngineLog.i(logcatTag(), "texturerender connected cpu,reset");
        }
        Handler handler = this.mTestNetSpeedHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mTestNetSpeedRunable);
        }
        _dataLoaderRemoveEngineRef();
        this.mSRStrategy.resetAll();
        this.mSRNotUseReason = 0;
        this.mGearStrategyEnabled = 0;
        this.mGearStrategyConfig = new GearStrategyConfig();
        this.mEngineConfig.remove(583);
        this.mEnableGearStrategyV2 = 0;
        this.mGearStrategyExtraParams = null;
    }

    boolean _doSupportByteVC1Playback() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return true;
        }
        try {
            int currentPosition = mediaPlayer.getCurrentPosition();
            int duration = this.mMediaPlayer.getDuration();
            long longOption = this.mMediaPlayer.getLongOption(72, -1L);
            if (this.mMediaPlayer.getIntOption(157, -1) == 5 && this.mPlaybackState == 1 && this.mLoadState == 1 && currentPosition >= 1000 && duration - currentPosition >= 1000 && longOption >= 500) {
                int intOption = this.mMediaPlayer.getIntOption(160, 100);
                long longOption2 = this.mMediaPlayer.getLongOption(152, -1L);
                int intOption2 = this.mMediaPlayer.getIntOption(153, -1);
                float floatOption = this.mMediaPlayer.getFloatOption(151, 0.0f);
                if (floatOption > getConfigInt(205, this.mMaxFps)) {
                    floatOption /= 2.0f;
                }
                int configInt = getConfigInt(207, this.mFrameDropNum);
                int i = (((int) floatOption) * configInt) / (configInt + 1);
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(logcatTag(), "cd = " + longOption2 + ", dc = " + intOption2 + ", mdps = " + i + ", vs =" + intOption);
                }
                if (longOption2 <= -350) {
                    if (intOption2 >= (i * 2) / 3 && intOption > 2) {
                        return false;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return true;
    }

    boolean _doSupportByteVC2Playback() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return true;
        }
        try {
            int currentPosition = mediaPlayer.getCurrentPosition();
            int duration = this.mMediaPlayer.getDuration();
            long longOption = this.mMediaPlayer.getLongOption(72, -1L);
            if (this.mMediaPlayer.getIntOption(157, -1) == 7 && this.mPlaybackState == 1 && this.mLoadState == 1 && currentPosition >= 1000 && duration - currentPosition >= 1000 && longOption >= 500) {
                int intOption = this.mMediaPlayer.getIntOption(160, 100);
                long longOption2 = this.mMediaPlayer.getLongOption(152, -1L);
                int intOption2 = this.mMediaPlayer.getIntOption(153, -1);
                float floatOption = this.mMediaPlayer.getFloatOption(151, 0.0f);
                if (floatOption > getConfigInt(205, this.mMaxFps)) {
                    floatOption /= 2.0f;
                }
                int configInt = getConfigInt(207, this.mFrameDropNum);
                int i = (((int) floatOption) * configInt) / (configInt + 1);
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(logcatTag(), "cd = " + longOption2 + ", dc = " + intOption2 + ", mdps = " + i + ", vs =" + intOption);
                }
                if (longOption2 <= -350) {
                    if (intOption2 >= (i * 2) / 3 && intOption > 2) {
                        return false;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return true;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getCurrentPlaybackTime() {
        int i = this.mState;
        int i2 = -1;
        if (i != 3) {
            if (this.mSeamSwitchingResolution || i == 4) {
                i2 = this.mLastPlaybackTime;
            }
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "state not correct return:" + this.mState);
            }
            return i2;
        }
        int i3 = this.mPlaybackState;
        if ((i3 != 1 && i3 != 2 && !this.mPrepared) || this.mShouldStop) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "playbackstate not correct return:" + this.mPlaybackState);
            }
            return -1;
        }
        if (this.mHasComplete) {
            int i4 = this.mDuration;
            if (i4 <= 0) {
                return -1;
            }
            return i4;
        }
        if (getConfigInt(663, this.mGetPositionSkipLooper ? 1 : 0) != 1 && this.mLooperThread.checkEngineLooperThread(true)) {
            if (!this.mLooperThread.sendEngineMessage(151, getConfigInt(950, (int) this.mSendEngineMsgTimeout))) {
                return -1;
            }
            this.mLooperThread.mEngineMsgRetValue.setDataPosition(0);
            return this.mLooperThread.mEngineMsgRetValue.readInt();
        }
        return _doGetCurrentPlaybackTime();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public VideoFormatInfo getVideoFormatInfo() {
        VideoFormatInfo videoFormatInfo = new VideoFormatInfo();
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            String stringOption = mediaPlayer.getStringOption(516);
            if (!TextUtils.isEmpty(stringOption)) {
                if (stringOption.indexOf("mp4") > 0) {
                    videoFormatInfo.fileFormat = "mp4";
                } else {
                    int indexOf = stringOption.indexOf(",");
                    if (indexOf < 0) {
                        videoFormatInfo.fileFormat = stringOption;
                    } else {
                        videoFormatInfo.fileFormat = stringOption.substring(0, indexOf);
                    }
                }
            }
            videoFormatInfo.bitrate = this.mMediaPlayer.getLongOption(171, 0L);
            videoFormatInfo.videoCodecName = this.mMediaPlayer.getIntOption(157, -1);
            videoFormatInfo.videoProfile = this.mMediaPlayer.getIntOption(403, -1);
            videoFormatInfo.width = this.mMediaPlayer.getVideoWidth();
            videoFormatInfo.height = this.mMediaPlayer.getVideoHeight();
            videoFormatInfo.rotation = this.mMediaPlayer.getIntOption(555, -1);
            videoFormatInfo.containerFps = this.mMediaPlayer.getFloatOption(151, 0.0f);
            videoFormatInfo.audioCodecName = this.mMediaPlayer.getIntOption(158, -1);
            videoFormatInfo.audioProfile = this.mMediaPlayer.getIntOption(402, -1);
            videoFormatInfo.channels = this.mMediaPlayer.getIntOption(553, -1);
            videoFormatInfo.sampleRate = this.mMediaPlayer.getIntOption(554, -1);
        }
        return videoFormatInfo;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void stop() {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "stop:" + this);
        }
        Iterator<VideoEngineStateListener> it2 = TTVideoEngine.sEngineStateListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onEngineStop(this.mEngineWrapper);
        }
        this.mMediaExtraInfo = null;
        this.mShouldPlay = false;
        this.mIsFetchingInfo = false;
        this.mTextureFirstFrame = false;
        this.mTexNotifyFirstFrame = false;
        this.mShouldStop = true;
        this.mRenderHDR2SDR = 0;
        this.mEngineConfig.remove(652);
        this.mSyncUpdateSurface = 0;
        this.mLoopStartTime = 0;
        this.mEngineConfig.remove(24);
        this.mLoopEndTime = 0;
        this.mEngineConfig.remove(25);
        this.mIsPrepareDecodeOnly = false;
        this.mEngineConfig.remove(984);
        this.mOSPlayerIgnoreHeaders = false;
        this.mEngineConfig.remove(4022);
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(3);
        } else {
            _doStop();
        }
    }

    private void _fetchVideoInfo() {
        boolean z;
        String str;
        VideoModelCache.VideoModelCacheInfo videoModelCacheInfo;
        Handler handler;
        this.mState = 1;
        _resetUrlIndexMap();
        String aPIString = getAPIString();
        if (getConfigInt(400, this.mIsUseBoe ? 1 : 0) == 1) {
            aPIString = TTHelper.buildBoeUrl(aPIString);
        }
        this.mAPIString = TTVideoEngineUtils.BuildHttpsApi(aPIString);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "start to fetch video info:" + this.mAPIString);
        }
        boolean z2 = false;
        if (getConfigInt(299, this.mUseVideoModelCacheForce ? 1 : 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (this.mVideoModelCache != null && !TextUtils.isEmpty(this.mVideoID) && this.mUseVideoModelCache) {
            boolean isNetAvailable = NetUtils.isNetAvailable(this.mContext);
            if ((this.mErrorCount <= 1 || !isNetAvailable) && (videoModelCacheInfo = this.mVideoModelCache.get(this.mVideoID, this.mAPIString)) != null && (!videoModelCacheInfo.isExpired || z || (!isNetAvailable && DataLoaderHelper.getDataLoader().isRunning() && getConfigInt(160, this.mDataLoaderEnable) > 0))) {
                TTVideoEngineLog.i(logcatTag(), "using videomodel cache");
                this.mLogger.setIsVideoModelCache(1);
                VideoModel videoModel = videoModelCacheInfo.model;
                this.mVideoModel = videoModel;
                _logFetchedVideoInfo(videoModel);
                fetchedVideoInfo(this.mVideoModel);
                if (this.mListenerCompact != null) {
                    if (this.mLooperThread.checkSendMainLooper()) {
                        if (getConfigInt(558, this.mWaitForFetchInfoResult ? 1 : 0) != 0) {
                            this.mLooperThread.sendMainLooperMessage(TTVideoEngineInterface.PLAYER_OPTION_USE_THREAD_POOL, 0, 0, this.mVideoModel);
                            this.mLooperThread.mMainMsgRetValue.setDataPosition(0);
                            if (this.mLooperThread.mMainMsgRetValue.readInt() == 1) {
                                z2 = true;
                            }
                        } else {
                            this.mLooperThread.postMainLooperMessage(TTVideoEngineInterface.PLAYER_OPTION_USE_THREAD_POOL, 0, 0, this.mVideoModel);
                        }
                    } else {
                        IVideoModel iVideoModel = this.mVideoModel;
                        if (iVideoModel instanceof VideoModel) {
                            z2 = this.mListenerCompact.onFetchedVideoInfo((VideoModel) iVideoModel);
                        }
                    }
                    if (z2) {
                        return;
                    }
                }
                if (getConfigInt(410, this.mAsyncPlayHitVMCache ? 1 : 0) == 1 && (handler = this.mHandler) != null) {
                    try {
                        handler.post(new Runnable() { // from class: com.ss.ttvideoengine.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                TTVideoEngineImpl.this.lambda$_fetchVideoInfo$7();
                            }
                        });
                        return;
                    } catch (Exception e) {
                        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                            TTVideoEngineLog.e(logcatTag(), e.toString());
                        }
                        _parseIPAddress(this.mVideoModel);
                        return;
                    }
                }
                _parseIPAddress(this.mVideoModel);
                return;
            }
        }
        if (this.mUseVideoModelCache) {
            this.mLogger.setIsVideoModelCache(0);
        }
        this.mIsFetchingInfo = true;
        VideoInfoFetcher videoInfoFetcher = new VideoInfoFetcher(this.mContext, getNetClientSetByUser(), this.mTag);
        this.mFetcher = videoInfoFetcher;
        videoInfoFetcher.setVideoID(this.mVideoID);
        this.mFetcher.setUseVideoModelCache(this.mUseVideoModelCache);
        this.mFetcher.setUseVideoModelCacheForce(z);
        this.mFetcher.setPlayType(this.mPlayType);
        if (getConfigInt(492, this.mUseFallbackAPI ? 1 : 0) > 0 && this.mFallbackAPI != null) {
            this.mFetcher.setUseFallbakApi(Boolean.TRUE);
        }
        this.mFetcher.setListener(new MyFetcherListener(this));
        VideoInfoFetcher videoInfoFetcher2 = this.mFetcher;
        String str2 = this.mAPIString;
        int i = this.mPlayAPIVersion;
        if (i != 2 && i != 4) {
            str = this.mAuthorization;
        } else {
            str = null;
        }
        videoInfoFetcher2.fetchInfo(str2, str, i, this.mKeyseed);
        this.mFetcher.setResolutionMap(this.mResolutionMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void _renderStart() {
        /*
            Method dump skipped, instructions count: 472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.TTVideoEngineImpl._renderStart():void");
    }

    private void _replayOrResume() {
        String str;
        IpInfo ipInfo;
        if (shouldPrepare()) {
            if (!this.mIsLocal && !this.mIsDirectURL && this.mPlayFd == null && this.mMediaDataSource == null) {
                if (this.mIsPreloaderItem) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    long j = this.mPreloaderItem.mUrlTime;
                    if (j > 0 && currentTimeMillis - j > 2400) {
                        _fetchVideoInfo();
                    }
                    _logBeginToPlay(this.mPreloaderItem.mVideoID);
                    _singleURLParseAndPlay(this.mPreloaderItem.mUrl, this.mHeaders);
                    return;
                }
                if (this.mIsPlayItem) {
                    _logBeginToPlay(this.mVideoID);
                    _singleURLParseAndPlay(this.mPlayItem.playURL, this.mHeaders);
                    return;
                }
                _logBeginToPlay(this.mVideoID);
                Map<String, IpInfo> map = this.urlIPMap;
                if (map != null && (ipInfo = map.get(this.mURLInfo.hostURL)) != null) {
                    ipInfo.dns = "FromCache";
                    this.urlIPMap.put(this.mURLInfo.hostURL, ipInfo);
                    _updateVU();
                }
                _playInternal(this.mURLInfo.getCurrentURL(), this.mHeaders);
                return;
            }
            _logBeginToPlay(this.mVideoID);
            if (this.mIsLocal) {
                str = this.mLocalURL;
            } else {
                str = this.mDirectURL;
            }
            _singleURLParseAndPlay(str, this.mHeaders);
            return;
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "_replayOrResume state:" + this.mPlaybackState + ", playtime:" + this.mPlayTime);
        }
        if (this.mIsPlayComplete || (this.mPlaybackState == 0 && this.mPlayTime == 0)) {
            _sendUrlInfoMsg();
            _sendMdlCacheMsg();
            _logBeginToPlay(this.mVideoID);
            Map<String, String> map2 = this.mHeaders;
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (map2 != null && mediaPlayer != null) {
                map2.put("X-Tt-Traceid", this.mTraceId);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : map2.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append(": ");
                    sb.append(entry.getValue());
                    sb.append("\r\n");
                }
                this.mMediaPlayer.setStringOption(20, sb.toString());
            }
            IPlayDurationManager iPlayDurationManager = this.mPlayDuration;
            if (iPlayDurationManager != null) {
                iPlayDurationManager.clear();
            }
        }
        _resumeVideo();
    }

    private void _reset() {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "reset, this:" + this);
        }
        this.mShouldPlay = false;
        this.mPrepared = false;
        this.mIsFetchingInfo = false;
        this.mABRUsed = false;
        TTTestSpeedListener tTTestSpeedListener = this.mTTSpeedListener;
        if (tTTestSpeedListener != null) {
            tTTestSpeedListener.mAverageDownloadSpeed = 0.0f;
            tTTestSpeedListener.mAveragePredictSpeed = 0.0f;
            tTTestSpeedListener.mSpeedAverageCount = 0;
        }
        this.mHeaders.clear();
        _stop(true, 6);
        if (this.mMediaPlayer != null) {
            if (this.mHardwareDecodeEnablePlayer2 == 1 && getConfigInt(977, this.mCodecAndSurfaceReuse) == -1) {
                if (1 == this.mIsEnabelUsedRefactorSurfaceView) {
                    MediaPlayer mediaPlayer = this.mAsyncPlayer;
                    if (mediaPlayer == null) {
                        mediaPlayer = this.mMediaPlayer;
                    }
                    _doExternalWindowSetSurfaceNull(mediaPlayer, false);
                } else {
                    setSurfaceHook(null);
                }
            }
            if (this.mTextureSrOpen == 1 && this.mPlayBackUsedSR && this.mTextureSurface != null) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                    TTVideoEngineLog.i(logcatTag(), "disable sr while _ShutdownOldSource = " + this.mTextureSrOpen);
                }
                doOpenSR(0, -7880);
            }
            this.mTRSrategy.reset(this.mTextureSurface, this.mHasFirstFrameShown);
            VideoSurface videoSurface = this.mTextureSurface;
            if (videoSurface != null) {
                videoSurface.pause(false);
            }
            this.mMediaPlayer.reset();
            _clearSurface();
        }
        this.mPlayerFirstFrame = false;
        this.mHasFirstFrameShown = false;
        this.mHasFetchedSubtitle = false;
        this.mHasAudioFirstFrameShown = false;
        this.mHttpsEnabled = false;
        this.mRetryEnableHttps = false;
        this.mKeyseed = null;
        this.mFallbackAPI = null;
        this.mHijackRetryCount = 0;
        this.mRetrying = false;
        this.mLogger.reset();
        this.mFirstResolution = true;
        this.mFirstGetWidthHeight = true;
        this.mSeamSwitchingResolution = false;
        this.mFrameCount = 0;
        this.mPlayStartTime = -1L;
        this.mRenderStartTime = -1L;
        this.mStartupSwitchCSModel = -1;
        this.mStartupModel = -1;
        this.mStartUpBitrate = -1L;
        this.mCheckInfoString = null;
        rs1.g gVar = this.mABRModule;
        if (gVar != null) {
            gVar.release();
            this.mABRModule = null;
        }
        this.mForceCodec = null;
        this.mShouldUseAudioRenderStart = false;
        this.mAudioInfoId = -1;
        this.mEngineConfig.remove(675);
        this.mLastSwitchRadioModeTime = 0L;
        this.mLastSwitchResolutionTime = 0L;
        this.mTextureRenderError = 0;
        this.mLastSetSurfaceNullTime = 0L;
        this.mMaskFileSize = 0L;
        this.effectTypeSet = new CopyOnWriteArraySet();
    }

    private void _setupSubtitleInfo() {
        SubDesInfoModelProvider subDesInfoModelProvider;
        IVideoModel iVideoModel = this.mVideoModel;
        int i = 0;
        if (iVideoModel != null && iVideoModel.getSubInfoList() != null && this.mEnableSubThread > 0) {
            int size = this.mVideoModel.getSubInfoList().size();
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d(logcatTag(), "subtitle num: " + size);
            }
            if (!TextUtils.isEmpty(getConfigString(546, this.mSubIds))) {
                String[] split = getConfigString(546, this.mSubIds).split(",");
                if (TextUtils.isEmpty(this.mSubLanIds) || TextUtils.isEmpty(this.mSubVersions)) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (com.ss.ttvideoengine.model.SubInfo subInfo : this.mVideoModel.getSubInfoList()) {
                        if (subInfo != null) {
                            for (String str : split) {
                                if (!TextUtils.isEmpty(str) && str.equals(Integer.toString(subInfo.getValueInt(0)))) {
                                    arrayList.add(Integer.toString(subInfo.getValueInt(1)));
                                    arrayList2.add(subInfo.getValueStr(3));
                                }
                            }
                        }
                    }
                    this.mSubLanIds = TextUtils.join(",", arrayList);
                    this.mSubVersions = TextUtils.join(",", arrayList2);
                }
            }
            i = size;
        }
        TTVideoEngineLog.d(logcatTag(), "_setup subtitle info in");
        int i2 = this.mEnableSubThread;
        if (i2 > 0 && (subDesInfoModelProvider = this.mSubDesInfoModel) != null) {
            String subDesInfoModelProvider2 = subDesInfoModelProvider.toString();
            if (subDesInfoModelProvider2 == null || subDesInfoModelProvider2.length() <= 0 || this.mSubDesInfoModel.subtitleCount() <= 0) {
                return;
            }
            IVideoEventLogger iVideoEventLogger = this.mLogger;
            if (iVideoEventLogger != null) {
                iVideoEventLogger.setSubtitleIdsCount(i);
            }
            TTVideoEngineLog.d(logcatTag(), "using subtitle description info for setup subtitle");
            _setSubInfoToMediaPlayer(subDesInfoModelProvider2);
            return;
        }
        if (i2 > 0 && !this.mHasFetchedSubtitle && i > 0) {
            IVideoEventLogger iVideoEventLogger2 = this.mLogger;
            if (iVideoEventLogger2 != null) {
                iVideoEventLogger2.setSubtitleIdsCount(i);
            }
            TTVideoEngineLog.d(logcatTag(), "start fetch subtitle info");
            _fetchSubInfo();
            this.mHasFetchedSubtitle = true;
        }
    }

    private void setupTextureRender() {
        int i;
        int i2;
        TTVideoEngineLog.i(logcatTag(), "[SRLog]setupTextureRender");
        int i3 = 0;
        this.mTextureRenderError = 0;
        this.mTextureRenderer = s.h();
        TTVideoEngineLog.i(logcatTag(), "get texture renderer start");
        s sVar = this.mTextureRenderer;
        if (sVar == null) {
            this.mUseTextureRender = 0;
            TTVideoEngineLog.e(logcatTag(), "couldn't get rendererManager");
            return;
        }
        sVar.n(this.mContext);
        if (mTextureLogListenerExt == null) {
            MyTextureLogListenerExt myTextureLogListenerExt = new MyTextureLogListenerExt();
            mTextureLogListenerExt = myTextureLogListenerExt;
            r.h(0, myTextureLogListenerExt);
        }
        boolean z = this.mUseSRTexture;
        this.mPlayBackUsedSR = z;
        ji6.d dVar = new ji6.d();
        TextureRenderStrategy textureRenderStrategy = this.mTRSrategy;
        if (textureRenderStrategy != null) {
            this.mAsyncInitEffect = textureRenderStrategy.getAsyncEffect(dVar);
        }
        if (this.mEffectBundle.isEmpty() && this.mAsyncInitEffect) {
            if (z && this.mAsyncInitSR) {
                dVar.d(5, 1);
            }
            if (!this.mTextureRenderer.j(dVar, 0)) {
                if (z) {
                    this.mUseSRTexture = false;
                    return;
                }
                return;
            }
        } else if (this.mEffectBundle.isEmpty() && z && this.mAsyncInitSR && !this.mTextureRenderer.k(0)) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i("TTVideoEngine", "sr instance not exist, useSR:" + z + ", asyncInitSR:" + this.mAsyncInitSR);
            }
            this.mUseSRTexture = false;
            this.mSRStrategy.onSRStatus(2, -7877);
            return;
        }
        this.mAsyncInitSR = false;
        this.mAsyncInitEffect = false;
        if (this.mTextureRenderer.k(0) && (this.mUseSRTexture || this.mPlayBackUsedSR)) {
            this.mPlayBackUsedSR = true;
            z = true;
        }
        VideoSurface initTextureRender = initTextureRender(z);
        if (initTextureRender == null) {
            this.mUseTextureRender = 0;
            this.mTextureRenderErrorMsg = this.mTextureRenderer.d;
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                TTVideoEngineLog.e(logcatTag(), "genOffscreenSurface failed = " + this.mTextureRenderErrorMsg);
                return;
            }
            return;
        }
        initTextureRender.ignoreSRResolutionCheck(this.mSRIgnoreRes);
        initTextureRender.setOnDrawFrameListener(new VideoSurface.b() { // from class: com.ss.ttvideoengine.TTVideoEngineImpl.1
            private int mUsingSr = 0;
            private int mUsingSharpe = 0;

            public void onDraw(long j) {
                if (TTVideoEngineImpl.this.mDecodedVideoFirstFrame) {
                    TTVideoEngineImpl.access$308(TTVideoEngineImpl.this);
                    if (TTVideoEngineImpl.this.mTextureSurface != null) {
                        int intOption = TTVideoEngineImpl.this.mTextureSurface.getIntOption(6);
                        int intOption2 = TTVideoEngineImpl.this.mTextureSurface.getIntOption(15);
                        if (this.mUsingSr != intOption || this.mUsingSharpe != intOption2) {
                            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                TTVideoEngineLog.d(TTVideoEngineImpl.this.logcatTag(), "[SRLog]using sr:" + intOption + " frameCount:" + TTVideoEngineImpl.this.mFrameCount + "usingSharpe:" + intOption2);
                            }
                            this.mUsingSr = intOption;
                            this.mUsingSharpe = intOption2;
                            TTVideoEngineImpl tTVideoEngineImpl = TTVideoEngineImpl.this;
                            if (tTVideoEngineImpl.getConfigInt(4005, tTVideoEngineImpl.mEnableDecoderRenderVC2RenderLatency) > 0) {
                                if (this.mUsingSr <= 0 && this.mUsingSharpe <= 0) {
                                    TTVideoEngineLog.d(TTVideoEngineImpl.this.logcatTag(), "non sr latency mode");
                                    TTVideoEngineImpl.this.setIntOption(4006, 1);
                                } else {
                                    TTVideoEngineLog.d(TTVideoEngineImpl.this.logcatTag(), "sr latency mode");
                                    TTVideoEngineImpl.this.setIntOption(4006, 0);
                                }
                            }
                            TTVideoEngineImpl.this.mSRStrategy.onSRStatus(intOption, 0);
                        }
                    }
                    TTVideoEngineImpl tTVideoEngineImpl2 = TTVideoEngineImpl.this;
                    ListenerCompact listenerCompact = tTVideoEngineImpl2.mListenerCompact;
                    if (listenerCompact != null) {
                        listenerCompact.onFrameDraw(tTVideoEngineImpl2.mFrameCount, null);
                    }
                }
                if (!TTVideoEngineImpl.this.mTextureFirstFrame && TTVideoEngineImpl.this.mDecodedVideoFirstFrame) {
                    TTVideoEngineLog.d(TTVideoEngineImpl.this.logcatTag(), "recive first frame render from texture");
                    TTVideoEngineImpl.this.mTextureFirstFrame = true;
                }
                if (TTVideoEngineImpl.this.mPlayerFirstFrame) {
                    TTVideoEngineImpl tTVideoEngineImpl3 = TTVideoEngineImpl.this;
                    if (!tTVideoEngineImpl3.mTexNotifyFirstFrame && tTVideoEngineImpl3.mShouldPlay && tTVideoEngineImpl3.getConfigInt(TTVideoEngineInterface.PLAYER_OPTION_OPEN_TEXTUER_AFTER_FIRST_FRAME, tTVideoEngineImpl3.mFirstFrameOpenTexture) != 1) {
                        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                            TTVideoEngineLog.d(TTVideoEngineImpl.this.logcatTag(), "render start by texture, state =" + TTVideoEngineImpl.this.mPlaybackState);
                        }
                        TTVideoEngineImpl.this._renderStart();
                    }
                }
            }
        });
        initTextureRender.setOnErrorListener(new VideoSurface.c() { // from class: com.ss.ttvideoengine.i
            public final void onError(int i4) {
                TTVideoEngineImpl.this.lambda$setupTextureRender$2(i4);
            }
        });
        initTextureRender.setIntOption(34, this.mEnableTextureRenderNoRenderCheck);
        if (getConfigInt(4009, this.mTextureRenderForbidReuseVideoSurfaceTexture) > 0) {
            if (this.mHardwareDecodeEnablePlayer2 <= 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            initTextureRender.setIntOption(116, i2);
        }
        if (getConfigInt(4010, this.mTextureRenderForbidForbidReuseTexture) > 0) {
            if (this.mHardwareDecodeEnablePlayer2 <= 0) {
                i = 1;
            } else {
                i = 0;
            }
            initTextureRender.setIntOption(117, i);
        }
        initTextureRender.setNoRenderListener(new VideoSurface.g() { // from class: com.ss.ttvideoengine.TTVideoEngineImpl.2
            public void onNoRenderEnd(int i4) {
                if (TTVideoEngineImpl.this.mLogger != null) {
                    TTVideoEngineImpl.this.mLogger.AVNoRenderEnd(0);
                }
            }

            public void onNoRenderStart(int i4) {
                if (TTVideoEngineImpl.this.mLogger != null) {
                    TTVideoEngineImpl.this.mLogger.AVNoRenderStart(0, VideoEventOneNoRender.unifyReason(i4));
                }
            }
        });
        initTextureRender.setOnSetSurfaceListener(new VideoSurface.h() { // from class: com.ss.ttvideoengine.j
            public final int a(VideoSurface videoSurface, Surface surface) {
                int lambda$setupTextureRender$3;
                lambda$setupTextureRender$3 = TTVideoEngineImpl.this.lambda$setupTextureRender$3(videoSurface, surface);
                return lambda$setupTextureRender$3;
            }
        });
        initTextureRender.setIntOption(3, 1);
        if (getConfigInt(650, this.mOverlayMode) == 2) {
            i3 = 1;
        }
        initTextureRender.setIntOption(2, i3);
        initTextureRender.setIntOption(150, this.mEnableTextureRenderNativeWindow);
        initTextureRender.setIntOption(149, this.mEnableFrameCallbackInRenderThread);
        while (!this.mEffectBundle.isEmpty()) {
            initTextureRender.setEffect(this.mEffectBundle.poll());
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "get a surface = " + initTextureRender);
        }
        this.mTextureSurface = initTextureRender;
        String stringOption = initTextureRender.getStringOption(119);
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            iVideoEventLogger.setStringOption(161, stringOption);
        }
        this.mTextureSurface.setIntOption(41, this.mIsEnabelUsedRefactorSurfaceView);
        if (1 == this.mIsEnabelUsedRefactorSurfaceView) {
            this.mTextureSurface.setIntOption(26, 2);
        }
        if (shouldStartTextureRenderCheck()) {
            initTextureRender.setIntOption(33, 1);
        }
        setSurfaceDimensionsToTextureRender();
        resetTexture();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getAPIString() {
        int i;
        boolean z;
        String str;
        if (!TextUtils.isEmpty(this.mFallbackAPI)) {
            try {
                i = JniUtils.getDecodeMethod();
            } catch (Exception unused) {
                i = 0;
            }
            StringBuilder sb = new StringBuilder(this.mFallbackAPI);
            sb.append(String.format("&method=%d", Integer.valueOf(i)));
            if (!TextUtils.isEmpty(this.mForceCodec)) {
                sb.append(String.format("&%s=%s", "force_codec", this.mForceCodec));
            }
            String sb2 = sb.toString();
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "api string from fallback api:" + sb2);
            }
            return sb2;
        }
        if (this.mDataSource == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        boolean tryLoadPlayerPlugin = MediaPlayerWrapper.tryLoadPlayerPlugin();
        String value = TTPlayerConfiger.getValue(14, "");
        if (this.mConfigCenterVersion > 0) {
            if (this.mEngineConfig.getIntOption(17) == 1) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = this.mDashEnabled;
        }
        if (tryLoadPlayerPlugin) {
            if (z) {
                hashMap.put("format_type", "dash");
            }
            if (this.mConfigCenterVersion > 0) {
                str = this.mEngineConfig.getStringOption(1000);
            } else {
                str = this.mCodecType;
            }
            if (str.equals("bytevc2")) {
                hashMap.put("codec_type", "4");
            } else if (str.equals("bytevc1")) {
                hashMap.put("codec_type", "3");
            }
        } else {
            this.mHardwareDecodeEnablePlayer2 = 0;
        }
        if (this.mPlayerType == 2 && getConfigInt(34, this.mDrmType) == 2) {
            hashMap.put("format_type", "mpd");
        }
        if (getConfigInt(312, this.mEnableHttps ? 1 : 0) != 1 && !this.mRetryEnableHttps) {
            this.mHttpsEnabled = false;
        } else {
            this.mHttpsEnabled = true;
            hashMap.put("ssl", "1");
        }
        hashMap.put("player_version", value);
        if (this.mEnableMaskThread > 1) {
            hashMap.put("barragemask", "1");
        }
        hashMap.put("cdn_type", String.valueOf(this.mP2PCDNType));
        int lastPortraitResult = PortraitNetworkScore.getInstance().getLastPortraitResult();
        if (lastPortraitResult != -1) {
            hashMap.put("network_score", String.valueOf(lastPortraitResult));
        }
        if (!TextUtils.isEmpty(this.mForceCodec)) {
            hashMap.put("force_codec", this.mForceCodec);
        }
        Map<String, String> playerAbility = TTVideoEngine.getPlayerAbility(this.mPlayerType);
        if (this.mFetchWithAbilityOption && !playerAbility.isEmpty()) {
            try {
                hashMap.put("TtPlayerSdkOptions", new JSONObject(playerAbility).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), hashMap.toString());
        }
        String apiForFetcher = this.mDataSource.apiForFetcher(hashMap, this.mPlayAPIVersion);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "api string from apiForFetcher:" + apiForFetcher);
        }
        return apiForFetcher;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void resetMediaPlayerOptions() {
        int i;
        super.resetMediaPlayerOptions();
        if (this.mEnableVolumeBalance == 1) {
            this.mMediaPlayer.setFloatOption(303, this.mAEPreGain);
            this.mMediaPlayer.setFloatOption(304, this.mAEThreshold);
            this.mMediaPlayer.setFloatOption(306, this.mAEPredelay);
            this.mMediaPlayer.setFloatOption(305, this.mAERatio);
            this.mMediaPlayer.setIntOption(643, this.mAEType);
            this.mMediaPlayer.setFloatOption(644, this.mSrcLoudness);
            this.mMediaPlayer.setFloatOption(645, this.mTarLoudness);
            this.mMediaPlayer.setFloatOption(646, this.mSrcPeak);
            this.mMediaPlayer.setFloatOption(1151, this.mReleaseTime);
            this.mMediaPlayer.setFloatOption(1152, this.mLookAheadTime);
            this.mMediaPlayer.setFloatOption(1153, this.mLuRange);
            this.mMediaPlayer.setFloatOption(1154, this.mLuStart);
            this.mMediaPlayer.setFloatOption(1155, this.mLuEnd);
            this.mMediaPlayer.setFloatOption(1156, this.mMaxMomLu);
            this.mMediaPlayer.setFloatOption(1157, this.mMaxShortermLu);
            this.mMediaPlayer.setIntOption(1159, this.mVolumInfoVer);
            this.mMediaPlayer.setIntOption(1160, this.mDeviceAEPlayAbility);
            this.mMediaPlayer.setStringOption(1158, this.mAEConfigJson);
            this.mMediaPlayer.setStringOption(1161, this.mVolumeInfoJson);
            this.mMediaPlayer.setStringOption(1162, this.mAEGraphConfig);
        }
        this.mMediaPlayer.setIntOption(224, this.mEnableClockResumeResetEof);
        this.mMediaPlayer.setIntOption(302, this.mEnableVolumeBalance);
        this.mMediaPlayer.setIntOption(370, this.mEnableLoadControlBufferingTimeout);
        this.mMediaPlayer.setIntOption(570, this.mMdlEnableSeekReopen);
        this.mMediaPlayer.setIntOption(855, this.mAVSyncInterruptEnable);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        int i2 = 0;
        if (this.mIsStartPlayAutomatically && this.mIsPreDecodeAutoPause) {
            i = 0;
        } else {
            i = 1;
        }
        mediaPlayer.setIntOption(196, i);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "pre decode auto pause : " + this.mIsPreDecodeAutoPause);
            TTVideoEngineLog.i(logcatTag(), "read cache mode : " + this.mIsStartPlayAutomatically + "start time skip: " + this.mEnableStartTimeSkipAvSkipSerial);
        }
        MediaPlayer mediaPlayer2 = this.mMediaPlayer;
        if (!this.mIsStartPlayAutomatically) {
            i2 = this.mReadCacheMode;
        }
        mediaPlayer2.setIntOption(289, i2);
        this.mMediaPlayer.setIntOption(290, this.mAutoRangeOffset);
        this.mMediaPlayer.setIntOption(1013, this.mEnableStartTimeSkipAvSkipSerial);
        if (this.mDangerBufferThreshold > 0) {
            TTVideoEngineLog.i(logcatTag(), "buffer threshold enable");
            this.mMediaPlayer.setIntOption(296, 1);
            this.mMediaPlayer.setIntOption(294, this.mDangerBufferThreshold);
            this.mMediaPlayer.setIntOption(295, this.mSecureBufferThreshold);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void _configHardwareDecode() {
        /*
            Method dump skipped, instructions count: 535
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.TTVideoEngineImpl._configHardwareDecode():void");
    }

    private void _setLoggerOptions() {
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger == null) {
            return;
        }
        iVideoEventLogger.setIntOption(97, this.mEnableOutletDropLimit ? 1 : 0);
        this.mLogger.setIntOption(93, this.mEnableAudioTrackSmoothClock);
        this.mLogger.setIntOption(94, this.mDisableSpiltVoiceWrite);
        this.mLogger.setIntOption(55, this.mEnableNativeYV12Render);
        this.mLogger.setIntOption(96, StrategyHelper.helper().isRunning() ? 1 : 0);
        int enableCPPBYTEVC1CodecOpt = EngineGlobalConfig.getInstance().getEnableCPPBYTEVC1CodecOpt();
        int i = this.mEnableCPPBYTEVC1CodecOpt;
        if (i > 0 || enableCPPBYTEVC1CodecOpt > 0) {
            IVideoEventLogger iVideoEventLogger2 = this.mLogger;
            if (i > 0) {
                enableCPPBYTEVC1CodecOpt = i;
            }
            iVideoEventLogger2.addFeature("bytevc1_decoder_opt", Integer.valueOf(enableCPPBYTEVC1CodecOpt));
        }
        int i2 = this.mOpenVoiceEarly;
        if (i2 > 0) {
            this.mLogger.addFeature("open_voice_early", Integer.valueOf(i2));
        }
        int i3 = this.mMaskDelayLoading;
        if (i3 > 0) {
            this.mLogger.addFeature("mask_delay_loading", Integer.valueOf(i3));
        }
        int i4 = this.mMaskRangeOpt;
        if (i4 > 0) {
            this.mLogger.addFeature("mask_range_req", Integer.valueOf(i4));
        }
        int i5 = this.mEnablePreloadGear;
        if (i5 > 0) {
            this.mLogger.addFeature("preload_gear", Integer.valueOf(i5));
        }
        if (this.mIsPrepareDecodeOnly) {
            this.mLogger.addFeature("pre_decode", 1);
        }
        int i6 = this.mAsyncManageResource;
        if (i6 > 0) {
            this.mLogger.addFeature("async_res", Integer.valueOf(i6));
        }
        int i7 = this.mAudioUseDirectBuffer;
        if (i7 > 0) {
            this.mLogger.addFeature("a_directbuf", Integer.valueOf(i7));
        }
        int i8 = this.mAutoDisconnectedCpu;
        if (i8 > 0) {
            this.mLogger.addFeature("auto_disconnect_cpu", Integer.valueOf(i8));
        }
        int i9 = this.mEnableVideoSecondFrame;
        if (i9 > 0) {
            this.mLogger.addFeature("v_2nd_frame", Integer.valueOf(i9));
        }
        int i10 = this.mGiveBackCodecEarly;
        if (i10 > 0) {
            this.mLogger.addFeature("giveback_codec_early", Integer.valueOf(i10));
        }
        int i11 = this.mQueryAdaptivePlayback;
        if (i11 > 0) {
            this.mLogger.addFeature("query_adapt_playback", Integer.valueOf(i11));
        }
        int i12 = this.mCodecPoolSupportDynamicExtend;
        if (i12 > 0) {
            this.mLogger.addFeature("codecpool_extend", Integer.valueOf(i12));
        }
        int i13 = this.mEnableOptimizeHWDec2SWDec;
        if (i13 > 0) {
            this.mLogger.addFeature("opti_hwdec2swdec", Integer.valueOf(i13));
        }
        int i14 = this.mCodecAndSurfaceReuse;
        if (i14 > 0) {
            this.mLogger.addFeature("codec_surface_reuse", Integer.valueOf(i14));
        }
        if (this.mEnableDynamicFrameDropping > 0) {
            this.mLogger.addFeature("decoder_drop", 2);
        } else if (this.mMaxFps > 0) {
            this.mLogger.addFeature("decoder_drop", 1);
        }
        if (1 == this.mHWEnableDynamicFrameDropping) {
            this.mLogger.addFeature("hw_decoder_drop", 3);
        } else if (1 == this.mEnableHWDropFrameWhenVOIsInDropState) {
            this.mLogger.addFeature("hw_decoder_drop", 1);
        } else if (1 == this.mEnableHWDropFrameWhenAVOutSyncing) {
            this.mLogger.addFeature("hw_decoder_drop", 2);
        }
        int i15 = this.mSkipAudioGraph;
        if (i15 > 0) {
            this.mLogger.addFeature("skip_audio_out", Integer.valueOf(i15));
        }
        int i16 = this.mEnableAIBarrageThread;
        if (i16 > 0) {
            this.mLogger.addFeature("ai_barrage", Integer.valueOf(i16));
        }
        if (this.mPrecisePausePts > 0) {
            this.mLogger.addFeature("precise_pause", 1);
        }
        if (this.mEnbalePreDemux > 0) {
            this.mLogger.addFeature("pre_demux", 1);
        }
        int i17 = this.mEnableDemuxNonBlockRead;
        if (i17 > 0) {
            this.mLogger.addFeature("demux_nonblock_read", Integer.valueOf(i17));
        }
        int i18 = this.mEnableMp4Check;
        if (i18 > 0) {
            this.mLogger.addFeature("av_interlaced_check", Integer.valueOf(i18));
        }
        int i19 = this.mEnableClearMDLCache;
        if (i19 > 0) {
            this.mLogger.addFeature("clear_mdl_cache", Integer.valueOf(i19));
        }
        int i20 = this.mEnablexHEAACSupport;
        if (i20 > 0) {
            this.mLogger.addFeature("xHEAAC_audio_support", Integer.valueOf(i20));
        }
        int i21 = this.mNoBufferUpdate;
        if (i21 > 0) {
            this.mLogger.addFeature(" no_buffer_update", Integer.valueOf(i21));
        }
        int i22 = this.mQueryWinEnable;
        if (i22 > 0) {
            this.mLogger.addFeature("query_win", Integer.valueOf(i22));
        }
        int i23 = this.mMediaCodecAsyncModeEnable;
        if (i23 > 0) {
            this.mLogger.addFeature("mediacodec_async", Integer.valueOf(i23));
        }
        if (this.mEnableForceDisableOESRender && this.mForceDisableOESRender) {
            this.mLogger.addFeature("force_disable_oes_render", 1);
        }
        if (this.mEnableCPPBYTEVC2CodecOpt > 0) {
            this.mLogger.addFeature("bytevc2_opt", 1);
        }
        if (this.mEnableAudioMemIntergration > 0) {
            this.mLogger.addFeature("audiomem_intergration", 1);
        }
        if (this.mEnableBufferingLowerCapacity > 0) {
            this.mLogger.addFeature("lower_buffering_capacity", 1);
        }
        if (this.mEnableDowngradeAsyncCodec > 0) {
            this.mLogger.addFeature("downgrade_asynccodec", 1);
        }
        if (this.mEnableMediaCodecSyncClose > 0) {
            this.mLogger.addFeature("mediacodec_sync_clode", 1);
        }
        if (this.mEnableSeekBuffering > 0) {
            this.mLogger.addFeature("seek_buffering", 1);
        }
        if (this.mAsyncSetWindow > 0) {
            this.mLogger.addFeature("async_set_surface", 1);
        }
        int i24 = this.mPlayerCache;
        if (i24 > 0) {
            this.mLogger.addFeature("cache", Integer.valueOf(i24));
        }
        OptionHolder optionHolder = this.mOptionHolder;
        if (optionHolder != null && optionHolder.getIntOption(42027, 0) > 0) {
            this.mLogger.addFeature("out_thread_optimize", 1);
        }
        IVideoModel iVideoModel = this.mVideoModel;
        if (iVideoModel != null && iVideoModel.getVideoRefBool(253)) {
            this.mLogger.addFeature("mb_refactor", 1);
        }
        if (this.mEnableSourceRefreshStrategy) {
            this.mLogger.addFeature("source_refresh", 1);
        }
    }

    private void _updateLogTime() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (this.mLogger != null && mediaPlayer != null && !this.mHasFirstFrameShown) {
            if (getConfigInt(1301, this.mMaskEnableDataloader) > 0) {
                this.mLogger.addFeature("mask_loader", Integer.valueOf(getConfigInt(1301, this.mMaskEnableDataloader)));
            }
            this.mLogger.addFeature("change_rec_buf_speed", Integer.valueOf(getConfigInt(990, this.mChangeRecBufferSpeed)));
            this.mLogger.addFeature("reuse_codec", Integer.valueOf(mediaPlayer.getIntOption(1042, -1)));
            this.mLogger.addFeature("mc_monitor", Integer.valueOf(getConfigInt(1111, this.mEnableMediaCodecDeathCheck)));
            this.mLogger.addFeature("create_audiotrack_early", Integer.valueOf(getConfigInt(1110, this.mCreateAudioTrackEarly)));
            long longOption = mediaPlayer.getLongOption(68, -1L);
            this.mLogger.setDNSParseTime(longOption, 1);
            this.mLogger.setTranConnectTime(mediaPlayer.getLongOption(69, -1L));
            this.mLogger.setTranFirstPacketTime(mediaPlayer.getLongOption(70, -1L));
            this.mLogger.setAudioDNSParseTime(mediaPlayer.getLongOption(267, -1L), 1);
            this.mLogger.setAudioTranConnectTime(mediaPlayer.getLongOption(268, -1L));
            this.mLogger.setAudioTranFirstPacketTime(mediaPlayer.getLongOption(269, -1L));
            this.mLogger.setReceiveFirstVideoFrameTime(mediaPlayer.getLongOption(75, -1L));
            this.mLogger.setReceiveFirstAudioFrameTime(mediaPlayer.getLongOption(76, -1L));
            this.mLogger.setDecodeFirstVideoFrameTime(mediaPlayer.getLongOption(77, -1L));
            this.mLogger.setDecodeFirstAudioFrameTime(mediaPlayer.getLongOption(78, -1L));
            this.mLogger.setPlayerHostAddr(mediaPlayer.getStringOption(71));
            this.mLogger.deviceStartTime(1, mediaPlayer.getLongOption(156, -1L));
            this.mLogger.deviceStartTime(0, mediaPlayer.getLongOption(155, -1L));
            this.mLogger.devicedOpenedTime(1, mediaPlayer.getLongOption(163, -1L));
            this.mLogger.devicedOpenedTime(0, mediaPlayer.getLongOption(162, -1L));
            long longOption2 = mediaPlayer.getLongOption(TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES, -1L);
            this.mLogger.setFirstPlayerFirstFrameTime(longOption2);
            if (longOption > 0) {
                this.mLogger.setDNSEndTime(longOption);
            }
            long longOption3 = mediaPlayer.getLongOption(622, -1L);
            if (longOption3 > 0) {
                this.mLogger.setDNSStartTime(longOption3, 1);
            }
            long longOption4 = mediaPlayer.getLongOption(623, -1L);
            if (longOption4 > 0) {
                this.mLogger.setLongOption(66, longOption4);
            }
            this.mLogger.setLongOption(67, mediaPlayer.getLongOption(620, -1L));
            this.mLogger.setLongOption(68, mediaPlayer.getLongOption(624, -1L));
            this.mLogger.setLongOption(78, mediaPlayer.getLongOption(621, -1L));
            this.mLogger.setLongOption(69, mediaPlayer.getLongOption(625, -1L));
            this.mLogger.setLongOption(70, mediaPlayer.getLongOption(626, -1L));
            this.mLogger.setLongOption(71, mediaPlayer.getLongOption(627, -1L));
            this.mLogger.setLongOption(72, mediaPlayer.getLongOption(629, -1L));
            this.mLogger.setLongOption(73, mediaPlayer.getLongOption(631, -1L));
            this.mLogger.setLongOption(74, mediaPlayer.getLongOption(630, -1L));
            this.mLogger.setLongOption(75, mediaPlayer.getLongOption(632, -1L));
            this.mLogger.setLongOption(76, longOption2);
            this.mLogger.setLongOption(77, mediaPlayer.getLongOption(628, -1L));
            this.mLogger.setLongOption(87, mediaPlayer.getLongOption(822, -1L));
            this.mLogger.setLongOption(88, mediaPlayer.getLongOption(307, -1L));
            this.mLogger.setLongOption(120, mediaPlayer.getLongOption(583, -1L));
            this.mLogger.setLongOption(121, mediaPlayer.getLongOption(588, -1L));
            this.mLogger.setLongOption(122, mediaPlayer.getLongOption(584, -1L));
            this.mLogger.setLongOption(123, mediaPlayer.getLongOption(589, -1L));
            this.mLogger.setLongOption(124, mediaPlayer.getLongOption(585, -1L));
            this.mLogger.setLongOption(125, mediaPlayer.getLongOption(590, -1L));
        }
    }

    private void _updateLogger() {
        int i;
        float f;
        float f2;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            String str = "";
            int i2 = -1;
            if (mediaPlayer != null) {
                iVideoEventLogger.curVideoOutputFps(mediaPlayer.getFloatOption(150, -1.0f));
                this.mLogger.containerFps(mediaPlayer.getFloatOption(151, -1.0f));
                this.mLogger.curVideoDecoderFps(mediaPlayer.getIntOption(186, -1));
                this.mLogger.clockDiff(mediaPlayer.getLongOption(152, -1L));
                this.mLogger.dropCount(mediaPlayer.getIntOption(153, -1));
                this.mLogger.enableSharp(mediaPlayer.getIntOption(189, -1));
                this.mLogger.curVideoDecodeError(mediaPlayer.getIntOption(221, -1));
                this.mLogger.curAudioDecodeError(mediaPlayer.getIntOption(222, -1));
                this.mLogger.curVideoRenderError(mediaPlayer.getIntOption(245, -1));
                if (this.mHardwareDecodeEnablePlayer2 > 0) {
                    this.mLogger.hwCodecName(mediaPlayer.getStringOption(187));
                    this.mLogger.hwCodecException(mediaPlayer.getIntOption(188, -1));
                }
                if (this.mPlaybackState != 0) {
                    this.mLogger.setAudioBufferLength(mediaPlayer.getLongOption(73, -1L));
                    this.mLogger.setVideoBufferLength(mediaPlayer.getLongOption(72, -1L));
                }
                this.mLogger.setTextureRenderError(this.mTextureRenderErrorMsg);
                this.mLogger.setLongOption(21, mediaPlayer.getLongOption(171, -1L));
                this.mLogger.setLongOption(56, mediaPlayer.getLongOption(468, -1L));
                this.mLogger.setLongOption(82, mediaPlayer.getLongOption(850, -1L));
                this.mLogger.setLongOption(84, mediaPlayer.getLongOption(851, -1L));
                this.mLogger.setLongOption(85, mediaPlayer.getLongOption(852, -1L));
                int intOption = mediaPlayer.getIntOption(62, -1);
                int intOption2 = mediaPlayer.getIntOption(61, -1);
                if (intOption == 0) {
                    this.mLogger.setIntOption(12, 1);
                } else {
                    this.mLogger.setIntOption(12, 0);
                }
                if (intOption2 == 0) {
                    this.mLogger.setIntOption(13, 1);
                } else {
                    this.mLogger.setIntOption(13, 0);
                }
                this.mLogger.setIntOption(89, mediaPlayer.getIntOption(912, -1));
                _updateLogTime();
                HashMap hashMap = new HashMap();
                hashMap.put("abrv", this.mAbrVer);
                ss1.b bVar = StrategyCenter.sNetAbrSpeedPredictor;
                if (bVar != null) {
                    this.mNetVer = bVar.getVersion();
                }
                hashMap.put("netv", this.mNetVer);
                hashMap.put("used", Integer.valueOf(this.mABRUsed ? 1 : 0));
                hashMap.put("pcnt", Integer.valueOf(mediaPlayer.getIntOption(179, 0)));
                hashMap.put("scnt", Integer.valueOf(mediaPlayer.getIntOption(173, 0)));
                hashMap.put("apbr", Integer.valueOf(mediaPlayer.getIntOption(174, 0)));
                hashMap.put("apsp", Float.valueOf(mediaPlayer.getFloatOption(175, 0.0f)));
                hashMap.put("adbr", Integer.valueOf(mediaPlayer.getIntOption(610, 0)));
                TTTestSpeedListener tTTestSpeedListener = this.mTTSpeedListener;
                if (tTTestSpeedListener == null) {
                    f = 0.0f;
                } else {
                    f = tTTestSpeedListener.mAverageDownloadSpeed;
                }
                hashMap.put("npad", Float.valueOf(f));
                TTTestSpeedListener tTTestSpeedListener2 = this.mTTSpeedListener;
                if (tTTestSpeedListener2 == null) {
                    f2 = 0.0f;
                } else {
                    f2 = tTTestSpeedListener2.mAveragePredictSpeed;
                }
                hashMap.put("npap", Float.valueOf(f2));
                hashMap.put("adob", Integer.valueOf(mediaPlayer.getIntOption(615, 0)));
                hashMap.put("aplb", Integer.valueOf(mediaPlayer.getIntOption(614, 0)));
                hashMap.put("avbl", Float.valueOf(mediaPlayer.getFloatOption(TTVideoEngineInterface.PLAYER_OPTION_ENABLE_PLAYER_DEGRADE, 0.0f)));
                hashMap.put("iast", Integer.valueOf(this.mStandAlongAbrStartUp));
                hashMap.put("acsm", Integer.valueOf(this.mStartupSwitchCSModel));
                hashMap.put("stbr", Long.valueOf(this.mStartUpBitrate));
                hashMap.put("uebr", Long.valueOf(this.mUserExpectedBitrate));
                hashMap.put("stre", this.mStartUpResolution);
                hashMap.put("dgbt", Long.valueOf(this.mDowngradeBitrate));
                if (TTVideoEngine.sBuryDataOptimizeV2 == 0) {
                    this.mLogger.setAbrInfo(hashMap);
                } else if (this.mABRUsed || this.mStandAlongAbrStartUp > 0) {
                    this.mLogger.setAbrInfo(hashMap);
                }
                if (this.mABRUsed || this.mStandAlongAbrStartUp > 0 || getConfigInt(583, this.mGearStrategyEnabled) > 0) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("adtp", Integer.valueOf(TTVideoEngine.sABRAlgorithmType));
                    hashMap2.put("sptp", Integer.valueOf(TTVideoEngine.sNetSpeedAbrPredictType));
                    hashMap2.put("astp", Integer.valueOf(this.mStartupModel));
                    hashMap2.put("mcbr", Long.valueOf(this.mMaxCacheBitrate));
                    hashMap2.put("stsp", Float.valueOf(this.mAbrStartUpSpeed));
                    hashMap2.put("spsp", Float.valueOf(this.mAbrStartUpPredictSpeed));
                    hashMap2.put("sasp", Float.valueOf(this.mAbrStartUpAverageSpeed));
                    hashMap2.put("stfs", Long.valueOf(this.mAbrStartupBitrateBeforeFitScreen));
                    hashMap2.put("suqs", Float.valueOf(this.mAbrUserQualitySensitivity));
                    hashMap2.put("suef", Integer.valueOf(this.mAbrUserEnterFullScreen));
                    hashMap2.put("srif", this.mAbrSrInfo);
                    hashMap2.put("stif", this.mAbrStartupInfo);
                    rs1.g gVar = this.mABRModule;
                    if (gVar != null) {
                        hashMap2.put("abif", gVar.k(81, ""));
                    }
                    ArrayList arrayList = new ArrayList();
                    IVideoModel iVideoModel = this.mVideoModel;
                    if (iVideoModel != null) {
                        List<VideoInfo> videoInfoList = iVideoModel.getVideoInfoList();
                        if (videoInfoList == null) {
                            videoInfoList = Collections.emptyList();
                        }
                        for (VideoInfo videoInfo : videoInfoList) {
                            if (videoInfo != null) {
                                HashMap hashMap3 = new HashMap();
                                hashMap3.put("br", Integer.valueOf(videoInfo.getValueInt(3)));
                                String valueStr = videoInfo.getValueStr(32);
                                if (!TextUtils.isEmpty(valueStr)) {
                                    hashMap3.put("def", valueStr);
                                } else {
                                    hashMap3.put("def", _resolutionToString(videoInfo.getResolution()));
                                }
                                arrayList.add(hashMap3);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        hashMap2.put("brs", arrayList.toArray());
                    }
                    this.mLogger.setAbrGeneralInfo(hashMap2);
                }
            }
            Map<String, String> map = this.mSelectBitrateResult;
            if (map != null && TTVideoEngine.sEnableSelectResultReport == 1) {
                this.mLogger.setSelectResult(map);
            }
            this.mLogger.setIntOption(11, this.mRadioModeEnable);
            this.mLogger.setIntOption(79, isplaybackUsedSR() ? 1 : 0);
            this.mLogger.setIntOption(80, this.mReadCacheMode);
            this.mLogger.setIntOption(81, this.mAutoRangeOffset);
            this.mLogger.setIntOption(133, this.mEnableSRStrategy ? 1 : 0);
            SRStrategy sRStrategy = this.mSRStrategy;
            sRStrategy.setStrategyInfo("ss", Integer.valueOf(sRStrategy.getSRStatus()));
            this.mSRStrategy.setStrategyInfo("ess", Integer.valueOf(this.mEnableSRStrategy ? 1 : 0));
            this.mSRStrategy.setStrategyInfo("eas", Integer.valueOf(getConfigInt(571, this.mABRWithSR)));
            SRStrategy sRStrategy2 = this.mSRStrategy;
            Resolution resolution = this.currentResolution;
            if (resolution != null) {
                i = resolution.getIndex();
            } else {
                i = -1;
            }
            sRStrategy2.setStrategyInfo("cr", Integer.valueOf(i));
            SRStrategy sRStrategy3 = this.mSRStrategy;
            String str2 = this.mCurrentQualityDesc;
            if (str2 == null) {
                str2 = "";
            }
            sRStrategy3.setStrategyInfo("cqd", str2);
            SRStrategy sRStrategy4 = this.mSRStrategy;
            Resolution resolution2 = this.mResolutionBeforeDowngrade;
            if (resolution2 != null) {
                i2 = resolution2.getIndex();
            }
            sRStrategy4.setStrategyInfo("or", Integer.valueOf(i2));
            SRStrategy sRStrategy5 = this.mSRStrategy;
            String str3 = this.mQualityDescBeforeDowngrade;
            if (str3 != null) {
                str = str3;
            }
            sRStrategy5.setStrategyInfo("oqd", str);
            if (TTVideoEngine.sBuryDataOptimizeV2 == 0) {
                this.mLogger.setSRStrategyInfo(this.mSRStrategy);
                this.mLogger.setGearStrategyEvent(this.mGearStrategyEvent);
            } else {
                if (this.mEnableSRStrategy) {
                    this.mLogger.setSRStrategyInfo(this.mSRStrategy);
                }
                int configInt = getConfigInt(583, this.mGearStrategyEnabled);
                if ((this.mEnableABR == 0 && configInt == 0 && this.mStandAlongAbrStartUp > 0) || configInt > 0) {
                    this.mLogger.setGearStrategyEvent(this.mGearStrategyEvent);
                }
            }
        }
        _updateEffectLog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSubDesInfoModel$4(SubDesInfoModelProvider subDesInfoModelProvider) {
        this.mSubDesInfoModel = subDesInfoModelProvider;
    }

    void _setPlayerMute(boolean z) {
        super.setIsMute(z);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean getLooping(boolean z) {
        return this.mLooping;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void notifyError(Error error) {
        _notifyError(error);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void putMediaExtraInfo(JSONObject jSONObject) {
        this.mMediaExtraInfo = jSONObject;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setCacheControlEnabled(boolean z) {
        this.mCacheControlEnabled = z;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setCacheFilePathListener(CacheFilePathListener cacheFilePathListener) {
        this.mCacheFilePathListener = cacheFilePathListener;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDataSource(DataSource dataSource) {
        this.mDataSource = dataSource;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setFFmpegProtocolObject(TTVideoEngineFFmpegProtocol tTVideoEngineFFmpegProtocol) {
        this.mFFmpegProtocol = tTVideoEngineFFmpegProtocol;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setGearStrategyExtraParams(Map<String, Object> map) {
        this.mGearStrategyExtraParams = map;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setGroupID(String str) {
        this.mGroupID = str;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setLensParams(Bundle bundle) {
        this.mLensBundle = bundle;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setLoadControl(LoadControl loadControl) {
        this.mLoadControlInterface = loadControl;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setNetworkClient(TTVNetClient tTVNetClient) {
        this.mNetClient = tTVNetClient;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setPlayerEventListener(PlayerEventSimpleListener playerEventSimpleListener) {
        this.mPlayerEventListener = playerEventSimpleListener;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setTTHlsDrmToken(String str) {
        this.mTTHlsDrmToken = str;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoEngineGetInfoListener(VideoEngineGetInfoListener videoEngineGetInfoListener) {
        this.mVideoEngineGetInfoListener = videoEngineGetInfoListener;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoEngineSimpleCallback(VideoEngineSimpleCallback videoEngineSimpleCallback) {
        setVideoEngineCallback(videoEngineSimpleCallback);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoModel(VideoModel videoModel) {
        setVideoModel((IVideoModel) videoModel);
    }

    private boolean _isDashSource(String str) {
        return FormatProvider.FormatProviderHolder.isMpd(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _logFetchedFailed(Error error) {
        this.mLogger.fetchInfoComplete((VideoModel) null, error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _logFetchedVideoInfo(IVideoModel iVideoModel) {
        this.mLogger.fetchInfoComplete(iVideoModel, (Error) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _logMessage(String str) {
        this.mLogger.logMessage(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _parseIPAddress(IVideoModel iVideoModel) {
        _parseIPAddress(iVideoModel, null);
    }

    static /* synthetic */ int access$308(TTVideoEngineImpl tTVideoEngineImpl) {
        int i = tTVideoEngineImpl.mFrameCount;
        tTVideoEngineImpl.mFrameCount = i + 1;
        return i;
    }

    private void setSurfaceHook(Surface surface) {
        setSurfaceHookTimeOut(surface, 0);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void addVideoEngineCallback(VideoEngineCallback videoEngineCallback) {
        this.mListenerCompact.addVideoEngineCallback(videoEngineCallback);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal, com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getIntOption(int i) {
        return _doGetIntOption(i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal, com.ss.ttvideoengine.ITTVideoEngineInternal
    public long getLongOption(int i) {
        return _doGetLongOption(i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal, com.ss.ttvideoengine.ITTVideoEngineInternal
    public String getStringOption(int i) {
        return _doGetStringOption(i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void removeVideoEngineCallback(VideoEngineCallback videoEngineCallback) {
        this.mListenerCompact.removeVideoEngineCallback(videoEngineCallback);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setABRListener(ABRListener aBRListener) {
        this.mListenerCompact.setABRListener(aBRListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDaspPlaySignal(List<DaspSignal> list) {
        this.mDaspSignals.addAll(list);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setGearStrategyEngineConfig(GearStrategyConfig gearStrategyConfig) {
        if (gearStrategyConfig == null) {
            return;
        }
        this.mGearStrategyConfig = gearStrategyConfig;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setRadioMode(boolean z) {
        setIntOption(480, z ? 1 : 0);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSARChangeListener(SARChangeListener sARChangeListener) {
        this.mListenerCompact.setSARChangeListener(sARChangeListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setStreamInfoListener(StreamInfoListener streamInfoListener) {
        this.mListenerCompact.setStreamInfoListener(streamInfoListener);
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        setSurfaceHolder(surfaceHolder, false);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoBufferDetailListener(VideoBufferDetailListener videoBufferDetailListener) {
        this.mListenerCompact.setVideoBufferDetailListener(videoBufferDetailListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoEngineInfoListener(VideoEngineInfoListener videoEngineInfoListener) {
        this.mListenerCompact.setVideoEngineInfoListener(videoEngineInfoListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoURLRouteListener(VideoURLRouteListener videoURLRouteListener) {
        this.mListenerCompact.setVideoURLRouteListener(videoURLRouteListener);
    }

    private static class MyABRStrategy extends ABRStrategy {
        private final WeakReference<TTVideoEngineImpl> mVideoEngineRef;

        static {
            Covode.recordClassIndex(652338);
        }

        private MyABRStrategy(TTVideoEngineImpl tTVideoEngineImpl) {
            this.mVideoEngineRef = new WeakReference<>(tTVideoEngineImpl);
        }

        @Override // com.ss.ttm.player.ABRStrategy
        public int probeBitrate(int i) {
            ABRResult n;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl != null && tTVideoEngineImpl.mABRModule != null && (n = tTVideoEngineImpl.mABRModule.n()) != null && n.b() > 0) {
                int i2 = (int) n.a(0).a;
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "[ABR] predict next segment bitrate:" + i2 + "bps, this:" + tTVideoEngineImpl);
                }
                return i2;
            }
            return -1;
        }

        @Override // com.ss.ttm.player.ABRStrategy
        public String probeBitrate(String str) {
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl != null && tTVideoEngineImpl.mABRModule != null) {
                String c = tTVideoEngineImpl.mABRModule.c(str);
                if (!TextUtils.isEmpty(c) && TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "[ABR] predict next segment result:" + c + ", this:" + tTVideoEngineImpl);
                }
                return c;
            }
            return null;
        }
    }

    private static class MyDrmTokenProcessedListener implements IntertrustDrmHelper.IntertrustDrmHelperListener {
        private final WeakReference<TTVideoEngineImpl> mVideoEngineRef;

        static {
            Covode.recordClassIndex(652340);
        }

        public MyDrmTokenProcessedListener(TTVideoEngineImpl tTVideoEngineImpl) {
            this.mVideoEngineRef = new WeakReference<>(tTVideoEngineImpl);
        }

        @Override // com.ss.ttvideoengine.model.IntertrustDrmHelper.IntertrustDrmHelperListener
        public void onError(Error error) {
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl != null && error != null) {
                tTVideoEngineImpl.receivedError(error);
            }
        }

        @Override // com.ss.ttvideoengine.model.IntertrustDrmHelper.IntertrustDrmHelperListener
        public void onTokenProcessed(Error error) {
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null || tTVideoEngineImpl.mUserStopped) {
                return;
            }
            if (error != null) {
                tTVideoEngineImpl.receivedError(error);
            }
            int i = 2;
            if (tTVideoEngineImpl.mVideoModel != null) {
                String vType = tTVideoEngineImpl.mVideoModel.getVType();
                vType.hashCode();
                switch (vType) {
                    case "hls":
                        i = 1;
                        break;
                    case "mpd":
                    case "dash":
                        break;
                    default:
                        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(5)) {
                            TTVideoEngineLog.w(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "intertrust drm unsupported vtype:" + tTVideoEngineImpl.mVideoModel.getVType());
                            break;
                        }
                        break;
                }
            }
            IntertrustDrmHelper intertrustDrmHelper = tTVideoEngineImpl.mIntertrustDrmHelper;
            if (intertrustDrmHelper == null) {
                TTVideoEngineLog.e(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "mIntertrustDrmHelper is null, return.");
                return;
            }
            String makeUrl = intertrustDrmHelper.makeUrl(tTVideoEngineImpl.mURLInfo.hostURL, i);
            if (TextUtils.isEmpty(makeUrl)) {
                tTVideoEngineImpl.receivedError(new Error("kTTVideoErrorDomainIntertrustDRM", -9936));
            } else {
                tTVideoEngineImpl._playInternal(makeUrl, tTVideoEngineImpl.mHeaders);
            }
        }
    }

    private static class MyFetcherListener implements VideoInfoFetcher.FetcherListener {
        private final WeakReference<TTVideoEngineImpl> mVideoEngineRef;

        static {
            Covode.recordClassIndex(652341);
        }

        public MyFetcherListener(TTVideoEngineImpl tTVideoEngineImpl) {
            this.mVideoEngineRef = new WeakReference<>(tTVideoEngineImpl);
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onLog(String str) {
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            TTVideoEngineLog.i(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "fetcher cancelled");
            if (tTVideoEngineImpl == null) {
                return;
            }
            tTVideoEngineImpl._logMessage(str);
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onRetry(Error error) {
            if (error == null) {
                return;
            }
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                TTVideoEngineLog.e(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "fetcher should retry, error:" + error.toString());
            }
            if (tTVideoEngineImpl == null) {
                return;
            }
            tTVideoEngineImpl.mLogger.needRetryToFetch(error, tTVideoEngineImpl.mPlayAPIVersion);
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onStatusException(int i, String str) {
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null) {
                return;
            }
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                TTVideoEngineLog.e(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "video status exception:" + i);
            }
            tTVideoEngineImpl.mIsFetchingInfo = false;
            if (tTVideoEngineImpl.mLogger != null) {
                tTVideoEngineImpl.mLogger.movieFinish(i, str);
            }
            if (tTVideoEngineImpl.mLooperThread.checkSendMainLooper()) {
                tTVideoEngineImpl.mLooperThread.postMainLooperMessage(410, i, 0, null);
            } else {
                tTVideoEngineImpl.mListenerCompact.onVideoStatusException(i);
            }
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onCompletion(VideoModel videoModel, Error error) {
            boolean onFetchedVideoInfo;
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl != null) {
                tTVideoEngineImpl.mIsFetchingInfo = false;
                if (videoModel != null && error == null) {
                    tTVideoEngineImpl.mVideoModel = videoModel;
                    TTVideoEngineLog.i(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "fetch info success");
                    tTVideoEngineImpl._logFetchedVideoInfo(videoModel);
                    if (tTVideoEngineImpl.mEnableTmpLog == 1) {
                        tTVideoEngineImpl.showLongLog(tTVideoEngineImpl.mVideoModel.toMediaInfoJsonString());
                    }
                    tTVideoEngineImpl.mIsDashSource = videoModel.isDashSource();
                    tTVideoEngineImpl.mDashEnabled = tTVideoEngineImpl.mIsDashSource;
                    tTVideoEngineImpl.mEngineConfig.setIntOption(17, tTVideoEngineImpl.mIsDashSource ? 1 : 0);
                    if (!tTVideoEngineImpl.mIsPreloaderItem) {
                        tTVideoEngineImpl.fetchedVideoInfo(videoModel);
                        if (tTVideoEngineImpl.mListenerCompact != null) {
                            if (tTVideoEngineImpl.mLooperThread.checkSendMainLooper()) {
                                if (tTVideoEngineImpl.getConfigInt(558, tTVideoEngineImpl.mWaitForFetchInfoResult ? 1 : 0) != 0) {
                                    tTVideoEngineImpl.mLooperThread.sendMainLooperMessage(TTVideoEngineInterface.PLAYER_OPTION_USE_THREAD_POOL, 0, 0, tTVideoEngineImpl.mVideoModel);
                                    if (tTVideoEngineImpl.mLooperThread.mMainMsgRetValue.readInt() == 1) {
                                        onFetchedVideoInfo = true;
                                    }
                                } else {
                                    tTVideoEngineImpl.mLooperThread.postMainLooperMessage(TTVideoEngineInterface.PLAYER_OPTION_USE_THREAD_POOL, 0, 0, tTVideoEngineImpl.mVideoModel);
                                }
                                onFetchedVideoInfo = false;
                            } else {
                                onFetchedVideoInfo = tTVideoEngineImpl.mListenerCompact.onFetchedVideoInfo(videoModel);
                            }
                            if (onFetchedVideoInfo) {
                                tTVideoEngineImpl.mLogger.fetchedAndLeaveByUser(1);
                                return;
                            }
                            tTVideoEngineImpl.mLogger.fetchedAndLeaveByUser(0);
                        }
                        tTVideoEngineImpl._parseIPAddress(videoModel);
                        return;
                    }
                    return;
                }
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                    TTVideoEngineLog.e(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "fetch info failed:" + error.toString());
                }
                if (error == null) {
                    tTVideoEngineImpl._logFetchedFailed(new Error("kTTVideoErrorDomainFetchingInfo", -9997, "fetch empty"));
                    tTVideoEngineImpl.receivedError(new Error("kTTVideoErrorDomainFetchingInfo", -9997, "fetch empty"));
                } else {
                    if (error.parameters.containsKey("log_id")) {
                        tTVideoEngineImpl.mLogger.setStringOption(15, (String) error.parameters.get("log_id"));
                    }
                    tTVideoEngineImpl._logFetchedFailed(error);
                    tTVideoEngineImpl.receivedError(error);
                }
            }
        }
    }

    private static class MyFrameMetadataListener implements FrameMetadataListener {
        private final WeakReference<TTVideoEngineImpl> mVideoEngineRef;

        static {
            Covode.recordClassIndex(652342);
        }

        @Override // com.ss.ttm.player.FrameMetadataListener
        public /* synthetic */ void didReceivePacket(int i, long j, long j2, Map map) {
            FrameMetadataListener.CC.$default$didReceivePacket(this, i, j, j2, map);
        }

        @Override // com.ss.ttm.player.FrameMetadataListener
        public void frameDTSNotify(int i, long j, long j2) {
        }

        @Override // com.ss.ttm.player.FrameMetadataListener
        public /* synthetic */ void onAbrDecisionInfo(long j, String str) {
            FrameMetadataListener.CC.$default$onAbrDecisionInfo(this, j, str);
        }

        @Override // com.ss.ttm.player.FrameMetadataListener
        public void receiveBinarySei(ByteBuffer byteBuffer) {
        }

        @Override // com.ss.ttm.player.FrameMetadataListener
        public void updateFrameTerminatedDTS(int i, long j, long j2) {
        }

        @Override // com.ss.ttm.player.FrameMetadataListener
        public /* synthetic */ void willRenderFrame(int i, long j, long j2, String str) {
            FrameMetadataListener.CC.$default$willRenderFrame(this, i, j, j2, str);
        }

        private MyFrameMetadataListener(TTVideoEngineImpl tTVideoEngineImpl) {
            this.mVideoEngineRef = new WeakReference<>(tTVideoEngineImpl);
        }

        @Override // com.ss.ttm.player.FrameMetadataListener
        public void onFrameAboutToBeRendered(int i, long j, long j2, Map<Integer, String> map) {
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl != null && tTVideoEngineImpl.mTextureSurface != null) {
                tTVideoEngineImpl.mTextureSurface.frameMetaCallback(j, j2, map);
            }
            if (tTVideoEngineImpl.mLooperThread.checkSendMainLooper()) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", Integer.valueOf(i));
                hashMap.put("pts", Long.valueOf(j));
                hashMap.put("wallClockTime", Long.valueOf(j2));
                hashMap.put("frameData", map);
                tTVideoEngineImpl.mLooperThread.postMainLooperMessage(421, 0, 0, hashMap);
                return;
            }
            tTVideoEngineImpl.mListenerCompact.onFrameAboutToBeRendered(tTVideoEngineImpl.mEngineWrapper, i, j, j2, map);
        }
    }

    private static class MySubFetcherListener implements SubInfoFetcher.FetcherListener {
        private final WeakReference<TTVideoEngineImpl> mVideoEngineRef;

        static {
            Covode.recordClassIndex(652347);
        }

        public MySubFetcherListener(TTVideoEngineImpl tTVideoEngineImpl) {
            this.mVideoEngineRef = new WeakReference<>(tTVideoEngineImpl);
        }

        @Override // com.ss.ttvideoengine.fetcher.SubInfoFetcher.FetcherListener
        public void onLog(String str) {
            TTVideoEngineLog.i(TTVideoEngineInternal.logcatTag(this.mVideoEngineRef.get()), "sub fetcher cancelled");
        }

        @Override // com.ss.ttvideoengine.fetcher.SubInfoFetcher.FetcherListener
        public void onCompletion(String str, Error error) {
            TTVideoEngineImpl tTVideoEngineImpl = this.mVideoEngineRef.get();
            if (tTVideoEngineImpl == null) {
                return;
            }
            SubInfoListener subInfoListener = tTVideoEngineImpl.mSubInfoListener;
            SubInfoSimpleCallBack subInfoSimpleCallBack = tTVideoEngineImpl.mSubInfoCallBack;
            if (subInfoListener != null && tTVideoEngineImpl.mEnableSub > 0) {
                subInfoListener.onSubPathInfo(str, error);
            } else if (subInfoSimpleCallBack != null && tTVideoEngineImpl.mEnableSub > 0) {
                subInfoSimpleCallBack.onSubPathInfo(str, error);
            } else {
                TTVideoEngineLog.e(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "mSubInfoListener is null");
            }
            if (str != null && error == null) {
                if (tTVideoEngineImpl.mMediaPlayer != null && tTVideoEngineImpl.mLogger != null) {
                    tTVideoEngineImpl._setSubInfoToMediaPlayer(str);
                    return;
                }
                return;
            }
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                TTVideoEngineLog.e(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "sub fetch info failed:" + error.toString());
            }
            if (error != null && tTVideoEngineImpl.mLogger != null) {
                tTVideoEngineImpl.mLogger.setSubtitleError(error.toString());
            }
        }
    }

    private void _logFirstQualityType(int i) {
        if (this.mFirstQualityType) {
            this.mFirstQualityType = false;
            this.mLogger.setInitialQualityType(i);
        }
    }

    private void _updateTextureState(int i) {
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface != null) {
            videoSurface.setIntOption(1, i);
        }
    }

    @TargetClass(scope = Scope.SELF, value = "com.ss.ttvideoengine.TTVideoEngineImpl")
    @Insert("play")
    public static void com_ss_ttvideoengine_TTVideoEngineImpl_com_dragon_read_aop_NetworkTrafficAop_play(TTVideoEngineImpl tTVideoEngineImpl) {
        tTVideoEngineImpl.TTVideoEngineImpl__play$___twin___();
        if (!u55.k.o()) {
            return;
        }
        q.e(tTVideoEngineImpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSetMirrorHorizontal(boolean z) {
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface == null) {
            return;
        }
        this.mIsMirrorHorizontal = z;
        videoSurface.setIntOption(30, z ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSetMirrorVertical(boolean z) {
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface == null) {
            return;
        }
        this.mIsMirrorVertical = z;
        videoSurface.setIntOption(31, z ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSetStrategySource(StrategySource strategySource) {
        _ShutdownOldSource();
        try {
            this.mCodecStrategyAdapter.setStrategySource(strategySource);
        } catch (EngineException e) {
            e.printStackTrace();
        }
    }

    private static String generateCrosstalkStr(Map map) {
        try {
            return new JSONObject(map).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    void _doSetDataSource(IMediaDataSource iMediaDataSource) {
        _ShutdownOldSource();
        this.mMediaDataSource = iMediaDataSource;
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            iVideoEventLogger.setSourceType(7, null);
        }
    }

    void _doSetLooping(boolean z) {
        super.setLooping(z);
        this.mLogger.setLooping(z);
    }

    void _doSetTestSpeedEnable(int i) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setIntOption(79, i);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public IMediaMetrics getMetrics(int i) {
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger == null) {
            return null;
        }
        return iVideoEventLogger.buildMetrics(i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public Map<String, Object> getStrategyLogData(String str) {
        return StrategyHelper.helper().getLogData(this.mVideoID, str);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void notifyInfoIdChanged(int i) {
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            iVideoEventLogger.onVideoInfoIdChanged(i);
        }
        this.mListenerCompact.onInfoIdChanged(i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDecryptionKey(String str) {
        TTVideoEngineLog.i(logcatTag(), "setDecryptionKey");
        this.mDecryptionKey = str;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setLiveID(String str) {
        setVideoID(str);
        this.mLogger.setPlayType(1);
        this.mPlayType = 1;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setMaskInfoListener(MaskInfoListener maskInfoListener) {
        this.mMaskInfoListener = maskInfoListener;
        if (this.mMaskInfoInterface == null) {
            this.mMaskInfoInterface = new MaskInfo() { // from class: com.ss.ttvideoengine.TTVideoEngineImpl.3
                @Override // com.ss.ttm.player.MaskInfo
                protected void onMaskInfoCallback(int i, int i2, String str) {
                    TTVideoEngineImpl tTVideoEngineImpl = TTVideoEngineImpl.this;
                    if (tTVideoEngineImpl.mMaskInfoListener != null && tTVideoEngineImpl.getConfigInt(499, tTVideoEngineImpl.mEnableBarrageMask) > 0) {
                        TTVideoEngineImpl.this.mMaskInfoListener.onMaskInfoCallback(i, i2, str);
                    }
                }
            };
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setResolutionMap(HashMap<String, Resolution> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            this.mResolutionMap = hashMap;
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSpeedShiftConfig(SpeedShiftConfig speedShiftConfig) {
        this.mSpeedShiftConfig = speedShiftConfig;
        this.mBestResolutionType = 3;
        this.mEngineConfig.setIntOption(419, 3);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setTokenUrlTemplate(String str) {
        this.mTokenUrlTemplate = str;
        IntertrustDrmHelper intertrustDrmHelper = this.mIntertrustDrmHelper;
        if (intertrustDrmHelper != null) {
            intertrustDrmHelper.setTokenUrlTemplate(str);
        }
    }

    private static class SmartUrlInfoCallback implements SmartUrlFetcher.Callback {
        private WeakReference<TTVideoEngineImpl> mEngineRef;
        private MyFetcherListener mListener;

        static {
            Covode.recordClassIndex(652350);
        }

        public SmartUrlInfoCallback(TTVideoEngineImpl tTVideoEngineImpl) {
            this.mEngineRef = new WeakReference<>(tTVideoEngineImpl);
            this.mListener = new MyFetcherListener(tTVideoEngineImpl);
        }

        @Override // com.ss.ttvideoengine.source.strategy.SmartUrlFetcher.Callback
        public void onError(SmartUrlFetcher.RequestParams requestParams, Error error) {
            TTVideoEngineImpl tTVideoEngineImpl = this.mEngineRef.get();
            if (tTVideoEngineImpl == null) {
                return;
            }
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                TTVideoEngineLog.e(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), String.format("fetchSmartUrlInfo failed:%s", error.toString()));
            }
            if (error.parameters.containsKey("log_id")) {
                tTVideoEngineImpl.mLogger.setStringOption(15, (String) error.parameters.get("log_id"));
            }
            tTVideoEngineImpl._logFetchedFailed(error);
            tTVideoEngineImpl.mCodecStrategyAdapter.fallbackToDirectUrl();
        }

        @Override // com.ss.ttvideoengine.source.strategy.SmartUrlFetcher.Callback
        public void onComplete(SmartUrlFetcher.RequestParams requestParams, int i, SmartUrlFetcher.Result result) {
            TTVideoEngineImpl tTVideoEngineImpl = this.mEngineRef.get();
            if (tTVideoEngineImpl == null) {
                return;
            }
            int i2 = 1;
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d(TTVideoEngineInternal.logcatTag(tTVideoEngineImpl), "fetchSmartUrlInfo success " + result);
            }
            IVideoEventLogger iVideoEventLogger = tTVideoEngineImpl.mLogger;
            if (i != 1) {
                i2 = 0;
            }
            iVideoEventLogger.setIsVideoModelCache(i2);
            if (result.isEncodeStream()) {
                this.mListener.onCompletion((VideoModel) result.videoModel, null);
            } else if (tTVideoEngineImpl.mCodecStrategyAdapter != null) {
                tTVideoEngineImpl.mCodecStrategyAdapter.fallbackToDirectUrl();
            }
        }
    }

    private String _addThirdPartyProtocolHead(String str) {
        TTVideoEngineFFmpegProtocol tTVideoEngineFFmpegProtocol;
        if (str != null && (tTVideoEngineFFmpegProtocol = this.mFFmpegProtocol) != null) {
            return tTVideoEngineFFmpegProtocol.getProtocolName() + ":" + str;
        }
        return str;
    }

    private boolean _isDashSource(VideoInfo videoInfo) {
        String valueStr = videoInfo.getValueStr(6);
        if (!TextUtils.isEmpty(valueStr) && (valueStr.equals("dash") || valueStr.equals("mpd"))) {
            return true;
        }
        return false;
    }

    private void _logFirstHost(String str) {
        if (this.mFirstHost) {
            this.mFirstHost = false;
            this.mLogger.setInitialHost(str);
        }
        this.mLogger.setCurHost(str);
    }

    private void _logFirstIP(String str) {
        if (this.mFirstIP) {
            this.mFirstIP = false;
            this.mLogger.setInitialIP(str);
        }
        this.mLogger.setCurIP(str);
    }

    private void _logFirstQuality(String str) {
        if (this.mFirstQuality) {
            this.mFirstQuality = false;
            this.mLogger.setInitialQuality(str);
        }
        this.mLogger.setCurQuality(str);
    }

    private void _logFirstResolution(Resolution resolution) {
        boolean z;
        String _resolutionToString = _resolutionToString(resolution);
        if (this.mFirstResolution) {
            if (resolution == Resolution.Auto) {
                z = true;
            } else {
                z = false;
            }
            this.mFirstResolution = z;
            this.mLogger.setInitialResolution(_resolutionToString);
        }
        this.mLogger.setCurResolution(_resolutionToString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _parseDNSComplete(String str) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(300, 0, 0, str);
        } else {
            _doParseDNSComplete(str);
        }
    }

    private String _resolutionToString(Resolution resolution) {
        if (resolution == null) {
            return "nil";
        }
        IVideoModel iVideoModel = this.mVideoModel;
        if (iVideoModel != null) {
            return iVideoModel.resolutionToString(resolution);
        }
        return resolution.toString(VideoRef.TYPE_VIDEO);
    }

    private boolean _usePlayerDNS(boolean z) {
        IVideoEventLogger iVideoEventLogger;
        int configInt = getConfigInt(110, this.mIsUsePlayerDNS);
        if ((configInt == 1 || z) && (iVideoEventLogger = this.mLogger) != null) {
            iVideoEventLogger.setStringOption(86, "localDNS");
        }
        if (configInt == 1) {
            return true;
        }
        if (configInt == 0) {
            return false;
        }
        return z;
    }

    private void changeResolutionSwitchingState(boolean z) {
        if (z) {
            this.mResolutionSwitching = true;
            this.mResolutionSwitchingStartTime = SystemClock.currentThreadTimeMillis();
        } else {
            this.mResolutionSwitching = false;
            this.mResolutionSwitchingStartTime = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSetRotation(int i) {
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface == null) {
            return;
        }
        if (i != 0 && i != 90 && i != 180 && i != 270) {
            i = 0;
        }
        this.mRotation = i;
        videoSurface.setIntOption(29, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doSetUseEngineDisplayMode, reason: merged with bridge method [inline-methods] */
    public void lambda$setUseEngineDisplayMode$0(boolean z) {
        this.mUseEngineDisplayMode = z;
        if (z) {
            if (this.mLayoutType != 1) {
                _doSetIntOption(4, 1);
            }
            DisplayMode displayMode = this.mDisplayMode;
            if (displayMode != null) {
                displayMode.setEnable(true);
            }
        }
    }

    private void initMDLFetcher(Context context) {
        if (sFetcherMaker == null) {
            sFetcherMaker = new FetcherMaker(context.getApplicationContext());
        }
        AVMDLURLFetcherBridge.setFetcherMaker(sFetcherMaker);
    }

    private boolean isSupportBash(int i) {
        if (((getConfigInt(489, this.mSegmentFormatFlag) >> i) & 1) == 1) {
            return true;
        }
        return false;
    }

    private boolean isSupportHLSSeamlessSwitch(IVideoModel iVideoModel) {
        if (iVideoModel == null || !iVideoModel.hasFormat(IVideoModel.Format.HLS)) {
            return false;
        }
        return iVideoModel.isSupportHLSSeamlessSwitch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$_playInternal$8(Looper looper) {
        setupTextureRender();
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface != null) {
            videoSurface.setLooper(looper);
        }
        TTVideoEngineLog.d(logcatTag(), "[SRLog]setupTextureRender in child thread");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$_renderStart$9(boolean z) {
        this.mTRSrategy.setIsInitForEffect(1, z);
        VideoSurface initTextureRender = initTextureRender(true);
        if (initTextureRender != null) {
            initTextureRender.release();
        }
        this.mAsyncInitSR = false;
        this.mAsyncInitEffect = false;
    }

    private void setTextureLayoutMode(int i) {
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface == null) {
            return;
        }
        int i2 = 0;
        int i3 = 2;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    i2 = 2;
                }
            } else {
                i2 = 1;
            }
        }
        if (1 != this.mIsEnabelUsedRefactorSurfaceView) {
            i3 = i2;
        }
        videoSurface.setIntOption(26, i3);
    }

    void _doSetDataSource(FileDescriptor fileDescriptor) {
        _ShutdownOldSource();
        this.mPlayFd = fileDescriptor;
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            iVideoEventLogger.setSourceType(6, null);
        }
    }

    synchronized void addSurfaceCallback(SurfaceHolder surfaceHolder) {
        if (this.mSurfaceCallback == null) {
            TTVideoEngineSurfaceCallback tTVideoEngineSurfaceCallback = new TTVideoEngineSurfaceCallback(this.mEngineWrapper);
            this.mSurfaceCallback = tTVideoEngineSurfaceCallback;
            surfaceHolder.addCallback(tTVideoEngineSurfaceCallback);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal, com.ss.ttvideoengine.ITTVideoEngineInternal
    public float getFloatOption(int i) {
        if (i != 474) {
            return _doGetFloatOption(i);
        }
        TTTestSpeedListener tTTestSpeedListener = this.mTTSpeedListener;
        if (tTTestSpeedListener == null) {
            return 0.0f;
        }
        return tTTestSpeedListener.mAverageDownloadSpeed;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getSubtitleContentInfo(int i) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !(mediaPlayer instanceof MediaPlayerWrapper)) {
            return null;
        }
        return ((MediaPlayerWrapper) mediaPlayer).getSubtitleContent(i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void notifyBufferEnd(int i) {
        TTVideoEngineLooperThread2 tTVideoEngineLooperThread2 = this.mLooperThread;
        if (tTVideoEngineLooperThread2 != null && tTVideoEngineLooperThread2.checkSendMainLooper()) {
            this.mLooperThread.postMainLooperMessage(416, i, 0, null);
            return;
        }
        ListenerCompact listenerCompact = this.mListenerCompact;
        if (listenerCompact != null) {
            listenerCompact.onBufferEnd(i);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void notifyBufferingUpdate(int i) {
        if (this.mLooperThread.checkSendMainLooper()) {
            this.mLooperThread.postMainLooperMessage(403, i, 0, null);
        } else {
            this.mListenerCompact.onBufferingUpdate(this.mEngineWrapper, i);
        }
        _doMetrics();
    }

    protected void notifyFetchedVideoInfo(IVideoModel iVideoModel) {
        if (this.mListenerCompact == null) {
            return;
        }
        if (this.mLooperThread.checkSendMainLooper()) {
            this.mLooperThread.postMainLooperMessage(TTVideoEngineInterface.PLAYER_OPTION_USE_THREAD_POOL, 0, 0, iVideoModel);
        } else {
            this.mListenerCompact.onFetchedVideoInfo((VideoModel) iVideoModel);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void notifyPlaybackStateChanged(int i) {
        if (this.mLooperThread.checkSendMainLooper()) {
            this.mLooperThread.postMainLooperMessage(400, this.mPlaybackState, 0, null);
        } else {
            this.mListenerCompact.onPlaybackStateChanged(this.mEngineWrapper, this.mPlaybackState);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void notifySeekCompletion(boolean z) {
        if (this.mSeekCompletionListener == null) {
            return;
        }
        if (this.mLooperThread.checkSendMainLooper()) {
            this.mLooperThread.postMainLooperMessage(TTVideoEngineInterface.PLAYER_OPTION_DEFAULT_RENDER_TYPE, z ? 1 : 0, 0, null);
        } else {
            this.mSeekCompletionListener.onCompletion(z);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void notifyStreamChanged(int i) {
        if (this.mLooperThread.checkSendMainLooper()) {
            this.mLooperThread.postMainLooperMessage(407, i, 0, null);
        } else {
            this.mListenerCompact.onStreamChanged(this.mEngineWrapper, i);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(13, 0, 0, iMediaDataSource);
        } else {
            _doSetDataSource(iMediaDataSource);
        }
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setDirectURL(String str) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(19, 0, 0, str);
        } else {
            _doSetDirectURL(str, new String[]{str});
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setEncodedKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TTVideoEngineLog.i(logcatTag(), "setEncodedKey");
        this.mSpadea = str;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setLocalURL(String str) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(18, 0, 0, str);
        } else {
            _doSetLocalURL(str);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setMirrorHorizontal(boolean z) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(29, z ? 1 : 0);
        } else {
            doSetMirrorHorizontal(z);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setMirrorVertical(boolean z) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(30, z ? 1 : 0);
        } else {
            doSetMirrorVertical(z);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setPlayAuthToken(String str) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(31, 0, 0, str);
        } else {
            doSetPlayAuthToken(str);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setPlayItem(TTVideoEnginePlayItem tTVideoEnginePlayItem) {
        if (tTVideoEnginePlayItem == null) {
            return;
        }
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(17, 0, 0, tTVideoEnginePlayItem);
        } else {
            _doSetPlayItem(tTVideoEnginePlayItem);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setRotation(int i) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(28, i);
        } else {
            doSetRotation(i);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setUnSupportSampleRates(int[] iArr) {
        if (!isInHousePlayer()) {
            return;
        }
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(51, 0, 0, iArr);
        } else {
            _setUnSupportSampleRates(iArr);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoID(String str) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(14, 0, 0, str);
        } else {
            _doSetVideoID(str);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoModel(IVideoModel iVideoModel) {
        if (iVideoModel == null) {
            return;
        }
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(16, 0, 0, iVideoModel);
        } else {
            _doSetVideoModel(iVideoModel);
        }
    }

    private boolean _isNeedNotifyMdlErrorCode(Error error) {
        if (getConfigInt(160, this.mDataLoaderEnable) == 0 || DataLoaderHelper.getDataLoader().getIntValue(9018) == 0) {
            return false;
        }
        if (DataLoaderHelper.getDataLoader().getIntValue(9020) == 0 && !DataLoaderHelper.getDataLoader().isNotifyNetworkErrorCodes(error.code)) {
            return false;
        }
        return true;
    }

    private void _judgeSurfaceHashMap(Surface surface) {
        if (surface != null) {
            Map<Surface, Boolean> map = mSurfaceHashMap;
            if (map.get(surface) != null && map.get(surface).booleanValue()) {
                TTVideoEngineLog.i("TTVideoEngine", "remain native render from surface hashmap");
                this.mRenderType = 5;
                MediaPlayer mediaPlayer = this.mMediaPlayer;
                if (mediaPlayer != null) {
                    mediaPlayer.setIntOption(56, 5);
                }
            }
        }
    }

    private void _logBeginToPlay(String str) {
        if (this.mLogger != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.mPlayTime = currentTimeMillis;
            this.mLogger.setDnsMode(getConfigInt(110, this.mIsUsePlayerDNS));
            this.mLogger.beginToPlay(str, currentTimeMillis, BaseAppInfo.mDeviceId);
            this.mTraceId = this.mLogger.getTraceID();
        }
    }

    private void _preBuffering(int i) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "preBuffering start,this:" + this + ", code:" + i);
        }
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            iVideoEventLogger.moviePreStalled(i);
        }
    }

    private boolean _removeThirdPartyProtocolHead(String[] strArr) {
        TTVideoEngineFFmpegProtocol tTVideoEngineFFmpegProtocol;
        if (strArr == null || (tTVideoEngineFFmpegProtocol = this.mFFmpegProtocol) == null) {
            return false;
        }
        String protocolName = tTVideoEngineFFmpegProtocol.getProtocolName();
        boolean z = false;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].substring(0, protocolName.length()).equals(protocolName)) {
                strArr[i] = strArr[i].substring(protocolName.length() + 1);
                z = true;
            }
        }
        return z;
    }

    private void _tryNextURL(Error error) {
        Integer num;
        Map<Resolution, Integer> map = this.urlIndexMap;
        if (map != null && (num = map.get(this.currentResolution)) != null) {
            this.urlIndexMap.put(this.currentResolution, Integer.valueOf(num.intValue() + 1));
            _parseIPAddress(this.mVideoModel, error);
        }
    }

    @TargetClass("com.ss.ttvideoengine.TTVideoEngineImpl")
    @Insert("_doReleaseCommon")
    public static void com_ss_ttvideoengine_TTVideoEngineImpl_com_dragon_read_aop_TTVideoEngineAop_doReleaseCommon(TTVideoEngineImpl tTVideoEngineImpl) {
        tTVideoEngineImpl.TTVideoEngineImpl___doReleaseCommon$___twin___();
        LogWrapper.info("EngineHandlerThreadPool", "[doReleaseCommon] ,TTVideoEngine = " + tTVideoEngineImpl + " thread " + Thread.currentThread().getName(), new Object[0]);
    }

    private boolean isSupportBash(IVideoModel iVideoModel) {
        if (iVideoModel == null) {
            return false;
        }
        if ((!iVideoModel.hasFormat(IVideoModel.Format.DASH) || !isSupportBash(1)) && (!iVideoModel.hasFormat(IVideoModel.Format.MP4) || !isSupportBash(2))) {
            return false;
        }
        return iVideoModel.isSupportBash();
    }

    private static boolean isSupportSeamlessSwitch(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (!lowerCase.startsWith("mem://bash") && !lowerCase.startsWith("mem://hls") && !FormatProvider.FormatProviderHolder.isM3u8(str) && !FormatProvider.FormatProviderHolder.isMpd(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$_renderStart$10(int i) {
        TestNetSpeedListener testNetSpeedListener;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            long longOption = mediaPlayer.getLongOption(63, 0L);
            if (longOption >= 0 && (testNetSpeedListener = this.mTestNetSpeedListener) != null) {
                testNetSpeedListener.onSpeedReceive(longOption);
            }
            int i2 = this.mTestNetSpeed;
            if ((i2 == 1 || (i2 == 0 && longOption < 0)) && i > 0) {
                this.mTestNetSpeedHandler.postDelayed(this.mTestNetSpeedRunable, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupTextureRender$2(int i) {
        int i2;
        this.mTextureRenderError = i;
        if (getConfigInt(1504, this.mEnableNotifyRenderException) > 0) {
            Error error = new Error("kTTVideoErrorTextureRender", -8000, i);
            if (this.mLooperThread.checkSendMainLooper()) {
                this.mLooperThread.postMainLooperMessage(409, 0, 0, error);
            } else {
                this.mListenerCompact.onError(error);
            }
        }
        if (i == 1 || i == 2) {
            if (i == 1) {
                i2 = -7896;
            } else {
                i2 = -7895;
            }
            this.mSRStrategy.onSRStatus(2, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLongLog(String str) {
        if (this.mEnableTmpLog != 1) {
            return;
        }
        if (str != null) {
            int i = 3900;
            if (str.length() > 3900) {
                int length = str.length();
                int i2 = 0;
                while (i < length) {
                    TTVideoEngineLog.d(logcatTag(), str.substring(i2, i));
                    i2 += 3900;
                    i = Math.min(i + 3900, length);
                }
                TTVideoEngineLog.i(logcatTag(), str.substring(i2, i));
                return;
            }
        }
        TTVideoEngineLog.i(logcatTag(), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: _doSetSurface, reason: merged with bridge method [inline-methods] */
    public void lambda$_setSurfaceSync$5(Surface surface) {
        IVideoEventLogger iVideoEventLogger;
        this.mSurface = surface;
        if (surface != null && (iVideoEventLogger = this.mLogger) != null && !this.mHasFirstFrameShown) {
            iVideoEventLogger.setSurface(surface.toString());
        }
        MediaPlayer mediaPlayer = this.mAsyncPlayer;
        if (mediaPlayer == null) {
            mediaPlayer = this.mMediaPlayer;
        }
        if (mediaPlayer != null) {
            setSurfaceHook(this.mSurface);
        }
    }

    void _setUnSupportSampleRates(int[] iArr) {
        if (iArr.length <= 0) {
            return;
        }
        int length = MediaPlayer.MEDIA_PLAYER_SUPPORT_SAMPLERATES.length;
        this.mUnsupportedSampleRatesInBinary = 0;
        for (int i : iArr) {
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (MediaPlayer.MEDIA_PLAYER_SUPPORT_SAMPLERATES[i2] == i) {
                    this.mUnsupportedSampleRatesInBinary = (1 << i2) | this.mUnsupportedSampleRatesInBinary;
                    break;
                }
                i2++;
            }
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setIntOption(TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE, this.mUnsupportedSampleRatesInBinary);
        }
    }

    void _updateCurrentInfoToMDL(int i) {
        setPlayInfo(1, i);
        if (getConfigInt(656, this.mEnableHeartBeat ? 1 : 0) != 1) {
            _syncPlayInfoToMdl();
            if (getConfigInt(160, this.mDataLoaderEnable) > 0) {
                DataLoaderHelper.getDataLoader().updateCurrentNetStatus();
            }
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void asyncInitSR(boolean z) {
        this.mAsyncInitSR = z;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "[SRLog]asyncInitSR = " + z);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void configResolution(Resolution resolution) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "configResolution " + resolution);
        }
        if (resolution == null) {
            return;
        }
        _configResolution(resolution, null);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void dynamicControlSR(boolean z) {
        this.mDynamicControlSR = z;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "[SRLog]dynamicControlSR = " + z);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void ignoreSRResolutionLimit(boolean z) {
        this.mSRIgnoreRes = z;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "[SRLog]ignoreSRResolutionLimit ignore=" + z);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void initSRStrategyConfig(SRStrategyConfig sRStrategyConfig) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "[SRLog]initSRStrategyConfig mSRStrategy=" + this.mSRStrategy + " config=" + sRStrategyConfig);
        }
        if (sRStrategyConfig == null) {
            return;
        }
        this.mEnableSRStrategy = true;
        sRStrategyConfig.setStrategyType(1);
        this.mSRStrategy.setSRStrategyMode(0);
        this.mSRStrategy.updateConfig(sRStrategyConfig);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void notifyLoadStateChanged(int i) {
        if (this.mLooperThread.checkSendMainLooper()) {
            this.mLooperThread.postMainLooperMessage(401, i, this.mShouldPlay ? 1 : 0, null);
        } else if (this.mShouldPlay || i != 3) {
            this.mListenerCompact.onLoadStateChanged(this.mEngineWrapper, i);
        }
    }

    int parseP2PCDNType(String str) {
        int indexOf;
        int i;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf("cdn_type=")) == -1 || (i = indexOf + 9) >= str.length()) {
            return 0;
        }
        char charAt = str.charAt(i);
        if (!Character.isDigit(charAt)) {
            return 0;
        }
        return Character.getNumericValue(charAt);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setAIBarrageInfoListener(AIBarrageSimpleCallback aIBarrageSimpleCallback) {
        int i;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            String logcatTag = logcatTag();
            StringBuilder sb = new StringBuilder();
            sb.append("AIBarrage: set listen exist: ");
            if (aIBarrageSimpleCallback != null) {
                i = 1;
            } else {
                i = 0;
            }
            sb.append(i);
            TTVideoEngineLog.i(logcatTag, sb.toString());
        }
        this.mAIBarrageInfoListener = aIBarrageSimpleCallback;
        if (this.mAIBarrageInfoInterface == null) {
            this.mAIBarrageInfoInterface = new MaskInfo() { // from class: com.ss.ttvideoengine.TTVideoEngineImpl.4
                @Override // com.ss.ttm.player.MaskInfo
                protected void onMaskInfoCallback(int i2, int i3, String str) {
                    TTVideoEngineImpl tTVideoEngineImpl = TTVideoEngineImpl.this;
                    if (tTVideoEngineImpl.mAIBarrageInfoListener != null && tTVideoEngineImpl.getConfigInt(MediaPlayer.MEDIA_PLAYER_OPTION_APPID, tTVideoEngineImpl.mEnableAIBarrage) > 0) {
                        TTVideoEngineImpl.this.mAIBarrageInfoListener.onBarrageInfoCallBack(i2, i3, str);
                    } else {
                        TTVideoEngineLog.e(TTVideoEngineImpl.this.logcatTag(), "AIBarrage listener is null or switcher is off");
                    }
                }
            };
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setAIBarrageUrl(String str) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "AIBarrage: setUrl " + str);
        }
        this.mAIBarrageUrl = str;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setAdditionSubModel(SubModelProvider subModelProvider) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "subtitle: set addition sub model: " + subModelProvider.toString());
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setStringOption(1600, subModelProvider.toString());
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setAudioProcessor(AudioProcessor audioProcessor) {
        if (this.mAsyncSetAudioProcessor == 1 && this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(109, 441, 0, audioProcessor);
            return;
        }
        this.mAudioProcessor = audioProcessor;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            ((MediaPlayerWrapper) mediaPlayer).setAudioProcessor(audioProcessor);
            if (audioProcessor == null && this.mEnableCheckUnbindAudioProcessor > 0) {
                _doUnbindAudioProcessor();
            }
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setBarrageMaskHeadLen(int i) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "setBarrageMaskHeadLen " + i);
        }
        this.mMaskHeaderLen = i;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setBarrageMaskUrl(String str) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "setBarrageMaskUrl " + str);
        }
        this.mBarrageMaskUrl = str;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setCustomStr(String str) {
        if (this.mLogger != null && !TextUtils.isEmpty(str)) {
            if (str.length() > 512) {
                str = str.substring(0, MediaPlayer.MEDIA_PLAYER_OPTION_APPID);
                TTVideoEngineLog.i(logcatTag(), "customStr too long to be truncated!");
            }
            this.mLogger.setCustomStr(str);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDirectUrlUseDataLoader(DirectUrlItem directUrlItem) {
        if (directUrlItem != null) {
            this.mFormat = directUrlItem.getFormat();
            this.mCustomBitrate = directUrlItem.getBitrate();
        }
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(32, 0, 0, directUrlItem);
        } else {
            _doSetDirectUrlUseDataLoader(directUrlItem.allUrls(), directUrlItem.fileKey(), directUrlItem.vid(), directUrlItem.cdnExpiredTime(), directUrlItem.urlExpireTimes());
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setGroupIdUseDataLoader(String str) {
        this.mMDLGroupId = str;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "set groupID: " + this.mMDLGroupId);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setIsMute(boolean z) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "setIsMute:" + z);
        }
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(10, z ? 1 : 0);
        } else {
            _setPlayerMute(z);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setListener(VideoEngineListener videoEngineListener) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "setListener " + videoEngineListener);
        }
        this.mListenerCompact.setVideoEngineListener(videoEngineListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setPreloaderItem(TTAVPreloaderItem tTAVPreloaderItem) {
        if (tTAVPreloaderItem == null) {
            this.mIsPreloaderItem = false;
            return;
        }
        if (TextUtils.isEmpty(tTAVPreloaderItem.mUrl)) {
            setVideoID(tTAVPreloaderItem.mVideoID);
        } else if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(15, 0, 0, tTAVPreloaderItem);
        } else {
            _doSetPreloaderItem(tTAVPreloaderItem);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setReportLogEnable(boolean z) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "setReportLogEnable " + z);
        }
        this.mLogger.setUploadLogEnabled(z);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setStartTime(int i) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "setStartTime:" + i);
        }
        this.mStartTime = i;
        this.mLogger.setStartTime(i);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSubDesInfoModel(final SubDesInfoModelProvider subDesInfoModelProvider) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "subtitle: set subtitle description info: " + subDesInfoModelProvider.toString());
        }
        this.mLooperThread.runOnLooperThread(new Runnable() { // from class: com.ss.ttvideoengine.g
            @Override // java.lang.Runnable
            public final void run() {
                TTVideoEngineImpl.this.lambda$setSubDesInfoModel$4(subDesInfoModelProvider);
            }
        });
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSubInfoCallBack(SubInfoSimpleCallBack subInfoSimpleCallBack) {
        this.mSubInfoCallBack = subInfoSimpleCallBack;
        int i = 1;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            String logcatTag = logcatTag();
            StringBuilder sb = new StringBuilder();
            sb.append("subtitle: set callback, null: %d");
            if (subInfoSimpleCallBack != null) {
                i = 0;
            }
            sb.append(i);
            TTVideoEngineLog.d(logcatTag, sb.toString());
        }
        if (this.mSubInfoInterface == null) {
            this.mSubInfoInterface = new SubInfo() { // from class: com.ss.ttvideoengine.TTVideoEngineImpl.6
                @Override // com.ss.ttm.player.SubInfo
                protected void onSubLoadFinished(int i2) {
                    int i3;
                    TTVideoEngineImpl tTVideoEngineImpl = TTVideoEngineImpl.this;
                    SubInfoSimpleCallBack subInfoSimpleCallBack2 = tTVideoEngineImpl.mSubInfoCallBack;
                    if (subInfoSimpleCallBack2 != null && tTVideoEngineImpl.mEnableSub > 0) {
                        TTVideoEngineLog.d(TTVideoEngineImpl.this.logcatTag(), "subtitle call back: finished old did call back");
                        if (i2 >= 0) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        subInfoSimpleCallBack2.onSubLoadFinished(i3);
                        return;
                    }
                    TTVideoEngineLog.e(TTVideoEngineImpl.this.logcatTag(), "mSubInfoCallBack is null or mEnableSub == 0");
                }

                @Override // com.ss.ttm.player.SubInfo
                protected void onSubSwitchCompleted(int i2, int i3) {
                    TTVideoEngineImpl tTVideoEngineImpl = TTVideoEngineImpl.this;
                    SubInfoSimpleCallBack subInfoSimpleCallBack2 = tTVideoEngineImpl.mSubInfoCallBack;
                    if (subInfoSimpleCallBack2 != null && tTVideoEngineImpl.mEnableSub > 0) {
                        subInfoSimpleCallBack2.onSubSwitchCompleted(i2, i3);
                    } else {
                        TTVideoEngineLog.e(TTVideoEngineImpl.this.logcatTag(), "mSubInfoCallBack is null");
                    }
                }

                @Override // com.ss.ttm.player.SubInfo
                protected void onSubInfoCallback2(int i2, String str) {
                    TTVideoEngineImpl tTVideoEngineImpl = TTVideoEngineImpl.this;
                    SubInfoSimpleCallBack subInfoSimpleCallBack2 = tTVideoEngineImpl.mSubInfoCallBack;
                    if (subInfoSimpleCallBack2 != null && tTVideoEngineImpl.mEnableSub > 0) {
                        subInfoSimpleCallBack2.onSubInfoCallback(i2, str);
                        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                            TTVideoEngineLog.d(TTVideoEngineImpl.this.logcatTag(), "subtitle: callback2: " + str);
                            return;
                        }
                        return;
                    }
                    TTVideoEngineLog.e(TTVideoEngineImpl.this.logcatTag(), "mSubInfoCallBack is null or mEnableSub == 0");
                }

                @Override // com.ss.ttm.player.SubInfo
                protected void onSubLoadFinished2(int i2, String str) {
                    int i3;
                    TTVideoEngineImpl tTVideoEngineImpl = TTVideoEngineImpl.this;
                    SubInfoSimpleCallBack subInfoSimpleCallBack2 = tTVideoEngineImpl.mSubInfoCallBack;
                    if (subInfoSimpleCallBack2 != null && tTVideoEngineImpl.mEnableSub > 0) {
                        TTVideoEngineLog.d(TTVideoEngineImpl.this.logcatTag(), "subtitle: call back: finished did call back");
                        if (i2 >= 0) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (i3 == 1) {
                                i2 = 0;
                            }
                            jSONObject.put("code", i2);
                            str = jSONObject.toString();
                        } catch (JSONException unused) {
                        }
                        subInfoSimpleCallBack2.onSubLoadFinished2(i3, str);
                        return;
                    }
                    TTVideoEngineLog.e(TTVideoEngineImpl.this.logcatTag(), "mSubInfoCallBack is null or mEnableSub == 0");
                }

                @Override // com.ss.ttm.player.SubInfo
                protected void onSubInfoCallback(int i2, int i3, String str) {
                    TTVideoEngineImpl tTVideoEngineImpl = TTVideoEngineImpl.this;
                    SubInfoSimpleCallBack subInfoSimpleCallBack2 = tTVideoEngineImpl.mSubInfoCallBack;
                    if (subInfoSimpleCallBack2 != null && tTVideoEngineImpl.mEnableSub > 0) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("info", str);
                            jSONObject.put("pts", i3);
                            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                TTVideoEngineLog.d(TTVideoEngineImpl.this.logcatTag(), "subtitle: callback: " + str);
                            }
                            subInfoSimpleCallBack2.onSubInfoCallback(i2, jSONObject.toString());
                            return;
                        } catch (JSONException unused) {
                            TTVideoEngineLog.e(TTVideoEngineImpl.this.logcatTag(), "put content field failed");
                            return;
                        }
                    }
                    TTVideoEngineLog.e(TTVideoEngineImpl.this.logcatTag(), "mSubInfoCallBack is null");
                }
            };
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSubInfoListener(SubInfoListener subInfoListener) {
        int i = 1;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            String logcatTag = logcatTag();
            StringBuilder sb = new StringBuilder();
            sb.append("subtitle: set info listener, null: %d");
            if (subInfoListener != null) {
                i = 0;
            }
            sb.append(i);
            TTVideoEngineLog.d(logcatTag, sb.toString());
        }
        this.mSubInfoListener = subInfoListener;
        if (this.mSubInfoInterface == null) {
            this.mSubInfoInterface = new SubInfo() { // from class: com.ss.ttvideoengine.TTVideoEngineImpl.5
                @Override // com.ss.ttm.player.SubInfo
                protected void onSubLoadFinished(int i2) {
                }

                @Override // com.ss.ttm.player.SubInfo
                protected void onSubLoadFinished2(int i2, String str) {
                }

                @Override // com.ss.ttm.player.SubInfo
                protected void onSubSwitchCompleted(int i2, int i3) {
                }

                @Override // com.ss.ttm.player.SubInfo
                protected void onSubInfoCallback2(int i2, String str) {
                    TTVideoEngineImpl tTVideoEngineImpl = TTVideoEngineImpl.this;
                    if (tTVideoEngineImpl.mSubInfoListener != null && tTVideoEngineImpl.mEnableSub > 0) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            String optString = jSONObject.optString("info");
                            TTVideoEngineImpl.this.mSubInfoListener.onSubInfoCallback(i2, jSONObject.optInt("pts"), optString);
                            return;
                        } catch (JSONException unused) {
                            TTVideoEngineLog.e(TTVideoEngineImpl.this.logcatTag(), "construct json failed");
                            return;
                        }
                    }
                    TTVideoEngineLog.e(TTVideoEngineImpl.this.logcatTag(), "mSubInfoListener is null");
                }

                @Override // com.ss.ttm.player.SubInfo
                protected void onSubInfoCallback(int i2, int i3, String str) {
                    TTVideoEngineImpl tTVideoEngineImpl = TTVideoEngineImpl.this;
                    if (tTVideoEngineImpl.mSubInfoListener != null && tTVideoEngineImpl.mEnableSub > 0) {
                        TTVideoEngineImpl.this.mSubInfoListener.onSubInfoCallback(i2, i3, str);
                        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                            TTVideoEngineLog.d(TTVideoEngineImpl.this.logcatTag(), "subtitle: listener: " + str);
                            return;
                        }
                        return;
                    }
                    TTVideoEngineLog.e(TTVideoEngineImpl.this.logcatTag(), "mSubInfoListener is null");
                }
            };
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSurfaceSync(Surface surface) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "setSurfaceSync = " + surface + ",this:" + this);
        }
        _setSurfaceSync(surface, getConfigInt(950, (int) this.mSendEngineMsgTimeout), false);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setUseEngineDisplayMode(final boolean z) {
        TTVideoEngineLog.d("TTVideoEngine", "setUseEngineDisplayMode " + z);
        this.mLooperThread.runOnLooperThread(new Runnable() { // from class: com.ss.ttvideoengine.f
            @Override // java.lang.Runnable
            public final void run() {
                TTVideoEngineImpl.this.lambda$setUseEngineDisplayMode$0(z);
            }
        });
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoBufferListener(VideoBufferListener videoBufferListener) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "setVideoBufferListener " + videoBufferListener);
        }
        this.mListenerCompact.setVideoBufferListener(videoBufferListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoEngineCallback(VideoEngineCallback videoEngineCallback) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "setVideoEngineSimpleCallback " + videoEngineCallback);
        }
        this.mListenerCompact.setVideoEngineCallback(videoEngineCallback);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setVideoInfoListener(VideoInfoListener videoInfoListener) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "setVideoInfoListener " + videoInfoListener);
        }
        this.mListenerCompact.setVideoInfoListener(videoInfoListener);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setWindowClient(TTAVWindowClient tTAVWindowClient) {
        TTVideoEngineLog.i(logcatTag(), "setWindowClient = " + tTAVWindowClient + ", pre-client:" + this.mWindowClient + ",this:" + this);
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(58, 0, 0, tTAVWindowClient);
        } else {
            _doSetWindowClient(tTAVWindowClient);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void snapshot(SnapshotListener snapshotListener) {
        if (snapshotListener == null) {
            TTVideoEngineLog.d(logcatTag(), "snapshotListener is null");
            return;
        }
        if (this.mTextureSurface == null) {
            TTVideoEngineLog.d(logcatTag(), "TextureSurface is null");
            snapshotListener.onSnapShot(null, 0, 0);
        } else {
            Bundle bundle = new Bundle();
            bundle.putBoolean("origin_video", true);
            this.mTextureSurface.saveFrame(bundle, new c(snapshotListener));
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void updateSRStrategyConfig(SRStrategyConfig sRStrategyConfig) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "[SRLog]updateSRStrategyConfig mSRStrategy=" + this.mSRStrategy + " config=" + sRStrategyConfig);
        }
        this.mSRStrategy.updateConfig(sRStrategyConfig);
    }

    private void _abnormalOccured(int i) {
        int i2;
        if (this.mLogger != null) {
            OptionHolder optionHolder = this.mOptionHolder;
            int i3 = -1;
            if (optionHolder != null) {
                i3 = getConfigInt(42303, optionHolder.getIntOption(42303, 0));
                i2 = getConfigInt(42302, this.mOptionHolder.getIntOption(42302, -1));
            } else {
                i2 = -1;
            }
            this.mLogger.setIntOption(178, i);
            this.mLogger.setIntOption(180, i3);
            this.mLogger.setIntOption(179, i2);
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i("TTVideoEngine", "abnormalOccured: " + i + " strategy: " + i3 + " interval: " + i2);
            }
        }
    }

    private void _bufferStart(int i) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "buffering start,this:" + this + ", code:" + i);
        }
        IPlayDurationManager iPlayDurationManager = this.mPlayDuration;
        if (iPlayDurationManager != null) {
            iPlayDurationManager.stop();
        }
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface != null) {
            videoSurface.setIntOption(33, 0);
        }
        boolean z = this.mTexNotifyFirstFrame;
        int bufferStartAction = getBufferStartAction();
        if (this.mNotifyBufferingDirectly == 1 && !this.mHasFirstFrameShown) {
            this.mLogger.playbackBufferStart();
        }
        if (this.mHasFirstFrameShown && !this.mSeeking && this.mLoadState != 3 && i == 0) {
            this.mLogger.reportBufferingMetrics();
        }
        notifyBufferStart(i, z ? 1 : 0, bufferStartAction);
        updateLoadState(2, i);
        _updateTextureState(4);
    }

    private void _decoderStart(int i) {
        PlayerEventListener playerEventListener = this.mPlayerEventListener;
        if (this.mMediaPlayer != null && getConfigInt(664, this.mEnableDebugUINotify) != 0 && playerEventListener != null) {
            if (i == 0) {
                playerEventListener.onVideoDecoderOpened(this.mMediaPlayer.getIntOption(157, -1), this.mMediaPlayer.getLongOption(629, -1L), this.mMediaPlayer.getLongOption(630, -1L));
                playerEventListener.onVideoDecodedFirstFrame(this.mMediaPlayer.getLongOption(77, -1L));
            } else if (i == 1) {
                playerEventListener.onAudioDecoderOpened(this.mMediaPlayer.getIntOption(158, -1), this.mMediaPlayer.getLongOption(631, -1L), this.mMediaPlayer.getLongOption(632, -1L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _doExternalWindowUseSurface(Surface surface) {
        Surface surface2;
        int i;
        MediaPlayer mediaPlayer = this.mAsyncPlayer;
        if (mediaPlayer == null) {
            mediaPlayer = this.mMediaPlayer;
        }
        if (mediaPlayer == null) {
            return;
        }
        if ((getConfigInt(TTVideoEngineInterface.PLAYER_OPTION_OPEN_TEXTUER_AFTER_FIRST_FRAME, this.mFirstFrameOpenTexture) == 1 && this.mSurfaceHolder == null && !this.mPlayerFirstFrame) || (getConfigInt(587, this.mEnableForceDisableOESRender ? 1 : 0) == 1 && getConfigInt(588, this.mForceDisableOESRender ? 1 : 0) == 1)) {
            mediaPlayer.setSurfaceTimeOut(surface, 0);
            return;
        }
        Surface surface3 = this.mTextureSurface;
        if (this.mEnableMarkOffscreenRendering == 1) {
            if (surface3 != null) {
                i = 1;
            } else {
                i = 0;
            }
            mediaPlayer.setIntOption(4024, i);
        }
        if (surface3 != null) {
            surface2 = surface3;
        } else {
            surface2 = surface;
        }
        mediaPlayer.setSurfaceTimeOut(surface2, 0);
        if (surface3 != null) {
            if (surface == null) {
                int intOption = surface3.getIntOption(9);
                surface3.setIntOption(9, 1);
                surface3.updateRenderSurface((Surface) null);
                surface3.setIntOption(9, intOption);
                return;
            }
            surface3.updateRenderSurface(surface);
        }
    }

    private void _notifyError(Error error) {
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            IPlayDurationManager iPlayDurationManager = this.mPlayDuration;
            if (iPlayDurationManager != null) {
                iVideoEventLogger.addWatchedDuration(iPlayDurationManager.getPlayedDuration());
            }
            this.mLogger.movieFinish(error, this.mPlayAPIVersion);
        }
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface != null) {
            videoSurface.setIntOption(33, 0);
        }
        this.mStarted = false;
        this.mIsStartPlayAutomatically = true;
        if (_isNeedNotifyMdlErrorCode(error)) {
            error.parameters.putAll(_getMdlErrorInfo());
        }
        if (this.mLooperThread.checkSendMainLooper()) {
            this.mLooperThread.postMainLooperMessage(409, 0, 0, error);
        } else {
            this.mListenerCompact.onError(error);
        }
        this.mErrorCount = 0;
        this.mAccumulatedErrorCount = 0;
        this.mErrorEnd = true;
    }

    private void _onABRGetPredictResult(int i) {
        if (this.mABRModule != null && i >= 0) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d(logcatTag(), "[ABR] predict next segment bitrate:" + i + "bps, this:" + this);
            }
            if (this.mLooperThread.checkSendMainLooper()) {
                this.mLooperThread.postMainLooperMessage(600, 0, i, null);
            } else {
                this.mListenerCompact.onABRPredictBitrate(0, i);
            }
            long j = this.currentBitrate;
            long j2 = i;
            if (j != j2) {
                this.mLogger.abrEventStart(j, j2);
                this.currentBitrate = j2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _setSubInfoToMediaPlayer(String str) {
        this.mSubPathInfo = str;
        if (!TextUtils.isEmpty(str) && this.mEnableSubThread > 0) {
            this.mMediaPlayer.setIntOption(618, this.mEnableSub);
            this.mMediaPlayer.setStringOption(TTVideoEngineInterface.PLAYER_OPTION_IS_DEGRADE_RELEASE, this.mSubPathInfo);
            this.mLogger.setLongOption(83, System.currentTimeMillis());
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "sub option: " + this.mEnableSub + "sub thread: " + this.mEnableSubThread + " url:" + this.mSubPathInfo);
        }
    }

    @TargetClass("com.ss.ttvideoengine.TTVideoEngineImpl")
    @Insert("_doPrepare")
    public static void com_ss_ttvideoengine_TTVideoEngineImpl_com_dragon_read_aop_TTVideoEngineAop__doPrepare(TTVideoEngineImpl tTVideoEngineImpl) {
        Surface surface;
        String str = (String) tTVideoEngineImpl.get("tag");
        LogWrapper.info("AudioCore-TTVideoEngineAops", "_doPrepare ,currentTag = " + str + ", subTag = " + ((String) tTVideoEngineImpl.get("subtag")), new Object[0]);
        if ("ShortPlay".equals(str) && ((surface = tTVideoEngineImpl.getSurface()) == null || !surface.isValid())) {
            LogWrapper.error("AudioCore-TTVideoEngineAops", "_doPrepare , ShortPlay without invalid surface", new Object[0]);
        }
        b0.e(tTVideoEngineImpl, Boolean.FALSE);
        tTVideoEngineImpl.TTVideoEngineImpl___doPrepare$___twin___();
    }

    @TargetClass("com.ss.ttvideoengine.TTVideoEngineImpl")
    @Insert("_doReleaseAsync")
    public static void com_ss_ttvideoengine_TTVideoEngineImpl_com_dragon_read_aop_TTVideoEngineAop_doReleaseAsync(TTVideoEngineImpl tTVideoEngineImpl) {
        tTVideoEngineImpl.TTVideoEngineImpl___doReleaseAsync$___twin___();
        try {
            String currentPlayPath = tTVideoEngineImpl.getCurrentPlayPath();
            LogWrapper.info("AudioCore-TTVideoEngineAops", "_doReleaseAsync ,TTVideoEngine = " + tTVideoEngineImpl, new Object[0]);
            LogWrapper.info("AudioCore-TTVideoEngineAops", "_doReleaseAsync ,playPath = " + currentPlayPath, new Object[0]);
        } catch (Throwable th) {
            LogWrapper.error("AudioCore-TTVideoEngineAops", "_doReleaseAsync ,exception = " + th.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void doSetPlayAuthToken(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = com.ss.ttvideoengine.utils.TTHelper.base64Decode(r4)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L2c
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L26
            r1.<init>(r0)     // Catch: org.json.JSONException -> L26
            java.lang.String r2 = "GetPlayInfoToken"
            java.lang.String r2 = r1.optString(r2)     // Catch: org.json.JSONException -> L26
            r3.mAuthorization = r2     // Catch: org.json.JSONException -> L26
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: org.json.JSONException -> L26
            if (r2 == 0) goto L1f
            r3.mAuthorization = r0     // Catch: org.json.JSONException -> L26
        L1f:
            java.lang.String r2 = "TokenVersion"
            java.lang.String r0 = r1.optString(r2)     // Catch: org.json.JSONException -> L26
            goto L2e
        L26:
            r1 = move-exception
            r1.printStackTrace()
            r3.mAuthorization = r0
        L2c:
            java.lang.String r0 = ""
        L2e:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L40
            java.lang.String r1 = "V2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L40
            r0 = 4
            r3.mPlayAPIVersion = r0
            goto L43
        L40:
            r0 = 2
            r3.mPlayAPIVersion = r0
        L43:
            r0 = 1
            boolean r0 = com.ss.ttvideoengine.utils.TTVideoEngineLog.isPredicateLoglevelTurnOn(r0)
            if (r0 == 0) goto L6c
            java.lang.String r0 = r3.logcatTag()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "setPlayAuthToken "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = " version = "
            r1.append(r2)
            int r2 = r3.mPlayAPIVersion
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.ss.ttvideoengine.utils.TTVideoEngineLog.d(r0, r1)
        L6c:
            com.ss.ttvideoengine.log.IVideoEventLogger r0 = r3.mLogger
            if (r0 == 0) goto L75
            int r1 = r3.mPlayAPIVersion
            r0.setPlayAPIVersion(r1, r4)
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.TTVideoEngineImpl.doSetPlayAuthToken(java.lang.String):void");
    }

    private VideoSurface initTextureRender(boolean z) {
        int i;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "use sr tex = " + z);
        }
        s sVar = this.mTextureRenderer;
        if (sVar == null) {
            return null;
        }
        boolean z2 = false;
        if (getConfigInt(650, this.mOverlayMode) != 0) {
            i = 4;
        } else {
            i = 0;
        }
        int i2 = i | 0;
        ji6.d dVar = new ji6.d();
        dVar.d(5, z ? 1 : 0);
        if (this.mTRSrategy.isInitForEffect(1)) {
            dVar.d(1, 1);
        }
        dVar.g = TTVideoEngineConfig.setEGLBitDepth;
        if (this.mEnableHardwareBufferRender == 1) {
            z2 = true;
        }
        VideoSurface f = sVar.f(dVar, i2, z2);
        if (f != null) {
            if (z) {
                initSr(f);
            }
            this.mTRSrategy.didInitTextureRender(f);
            if (1 == this.mIsEnabelUsedRefactorSurfaceView) {
                f.setIntOption(26, 2);
            } else {
                f.setIntOption(26, this.mLayoutType);
            }
        }
        return f;
    }

    private boolean isSupportBash(String str) {
        if (!TextUtils.isEmpty(str) && isSupportBash(2)) {
            String lowerCase = str.toLowerCase();
            if (!lowerCase.startsWith("file://") && !lowerCase.startsWith("/") && !FormatProvider.FormatProviderHolder.isM3u8(str) && !FormatProvider.FormatProviderHolder.isMpd(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSupportSeamlessSwitch(IVideoModel iVideoModel) {
        boolean z;
        boolean z2;
        if (iVideoModel == null) {
            return false;
        }
        if (this.mConfigCenterVersion > 0) {
            if (this.mEngineConfig.getIntOption(33) == 1) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = this.mBashEnabled;
        }
        if (this.mConfigCenterVersion > 0) {
            if (this.mEngineConfig.getIntOption(671) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = this.mHLSSeamlessSwitch;
        }
        if (iVideoModel.hasFormat(IVideoModel.Format.DASH)) {
            return true;
        }
        if (iVideoModel.hasFormat(IVideoModel.Format.MP4)) {
            if (!z || !isSupportBash(iVideoModel)) {
                return false;
            }
            return true;
        }
        if (!iVideoModel.hasFormat(IVideoModel.Format.HLS) || !z2 || !isSupportHLSSeamlessSwitch(iVideoModel)) {
            return false;
        }
        return true;
    }

    private void resetFallbackApi(Error error) {
        String str = this.mFallbackAPI;
        if (str != null && "dash".equals(TTHelper.getParam(str, "format_type")) && (-9993 == error.code || !isInHousePlayer())) {
            this.mFallbackAPI = TTHelper.overrideUrlParam(this.mFallbackAPI, "format_type", "mp4");
        }
        if (this.mFallbackAPI != null) {
            if (-9993 == error.code || !isInHousePlayer()) {
                this.mFallbackAPI = TTHelper.overrideUrlParam(this.mFallbackAPI, "codec_type", "0");
            }
        }
    }

    float _doGetFloatOption(int i) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        try {
            if (i != 70) {
                if (i != 71) {
                    if (i != 344) {
                        if (i != 474) {
                            return super.getFloatOption(i);
                        }
                        TTTestSpeedListener tTTestSpeedListener = this.mTTSpeedListener;
                        if (tTTestSpeedListener == null) {
                            return 0.0f;
                        }
                        return tTTestSpeedListener.mAverageDownloadSpeed;
                    }
                    return this.mTarLoudness;
                }
                if (mediaPlayer == null) {
                    return 0.0f;
                }
                return mediaPlayer.getFloatOption(150, 0.0f);
            }
            if ((this.mContainerFPS <= 0.0f || this.mEnableRefreashCodecStatus) && mediaPlayer != null) {
                this.mContainerFPS = mediaPlayer.getFloatOption(151, 0.0f);
            }
            return this.mContainerFPS;
        } catch (Throwable th) {
            if (!TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                return 0.0f;
            }
            TTVideoEngineLog.d(th);
            return 0.0f;
        }
    }

    void _doSetLocalURL(String str) {
        if ((str != null && !str.equals(this.mLocalURL) && (!TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 1L) || this.mEngineHasUsed)) || this.mForceShutDownOldSource == 1) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "set local url:" + str);
            }
            _ShutdownOldSource();
            this.mState = 0;
            this.mUserStopped = false;
            this.mLastPlaybackTime = 0;
            this.mFirstURL = true;
            this.mAPIString = null;
        }
        this.mEngineHasUsed = true;
        this.mStarted = false;
        this.mIsLocal = true;
        this.mLocalURL = str;
        this.mBufferingStartT = 0L;
        this.mLogger.setSourceType(0, "");
        this.mFileKey = null;
        Resolution resolution = Resolution.Undefine;
        this.currentResolution = resolution;
        this.mLogger.configResolution(_resolutionToString(resolution), "");
    }

    void _doSetPlayItem(TTVideoEnginePlayItem tTVideoEnginePlayItem) {
        boolean isExpired = tTVideoEnginePlayItem.isExpired();
        if (!TextUtils.isEmpty(tTVideoEnginePlayItem.playURL) && !isExpired) {
            _ShutdownOldSource();
            if (!tTVideoEnginePlayItem.equals(this.mPlayItem)) {
                if (this.mPlayItem != null) {
                    _reset();
                }
                this.mIsPlayItem = true;
                this.mFirstURL = true;
                this.mFirstIP = true;
                this.mFirstHost = true;
                this.mState = 0;
                this.mUserStopped = false;
                this.mLastPlaybackTime = 0;
                this.mAPIString = null;
            }
            this.mStarted = false;
            this.mPlayItem = tTVideoEnginePlayItem;
            this.mBufferingStartT = 0L;
            Resolution resolution = tTVideoEnginePlayItem.resolution;
            if (resolution != null) {
                this.currentResolution = resolution;
            }
            String str = tTVideoEnginePlayItem.vid;
            this.mVideoID = str;
            this.mLogger.setSourceType(2, str);
            this.mFileKey = null;
            return;
        }
        setVideoID(tTVideoEnginePlayItem.vid);
    }

    void _doSetPlaybackParams(PlaybackParams playbackParams) {
        boolean z;
        super.setPlaybackParams(playbackParams);
        if (playbackParams != null && playbackParams.getSpeed() != -1.0f) {
            SRStrategy sRStrategy = this.mSRStrategy;
            SRStrategyConfig newConfig = SRStrategyConfig.newConfig();
            if (((int) (playbackParams.getSpeed() * 100.0f)) != 100) {
                z = true;
            } else {
                z = false;
            }
            sRStrategy.updateConfig(newConfig.setIsSpeed(z));
        }
        if (this.mMediaPlayer != null && this.mSRStrategy.getSRStrategyMode() == 0 && this.mHasFirstFrameShown) {
            this.mTextureSrOpen = this.mSRStrategy.isSRSatisfied() ? 1 : 0;
            int sRNotUseReason = this.mSRStrategy.getSRNotUseReason();
            this.mSRNotUseReason = sRNotUseReason;
            doOpenSR(this.mTextureSrOpen, sRNotUseReason);
        }
        if (playbackParams != null) {
            this.mLogger.setPlaybackParams(playbackParams);
        }
    }

    void _doSetPreloaderItem(TTAVPreloaderItem tTAVPreloaderItem) {
        int i = tTAVPreloaderItem.mResolution;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            setVideoID(tTAVPreloaderItem.mVideoID);
                            return;
                        }
                        this.currentResolution = Resolution.FourK;
                    } else {
                        this.currentResolution = Resolution.ExtremelyHigh;
                    }
                } else {
                    this.currentResolution = Resolution.SuperHigh;
                }
            } else {
                this.currentResolution = Resolution.High;
            }
        } else {
            this.currentResolution = Resolution.Standard;
        }
        _ShutdownOldSource();
        TTAVPreloaderItem tTAVPreloaderItem2 = this.mPreloaderItem;
        if (tTAVPreloaderItem2 != null && !tTAVPreloaderItem2.equals(tTAVPreloaderItem)) {
            _reset();
            this.mIsLocal = false;
            this.mFirstURL = true;
            this.mFirstIP = true;
            this.mFirstHost = true;
            this.mState = 0;
            this.mUserStopped = false;
            this.mLastPlaybackTime = 0;
            this.mFetcher = null;
            this.mAPIString = null;
        }
        this.mStarted = false;
        this.mIsPreloaderItem = true;
        this.mPreloaderItem = tTAVPreloaderItem;
        this.mBufferingStartT = 0L;
        String str = tTAVPreloaderItem.mVideoID;
        this.mVideoID = str;
        this.mLogger.setSourceType(3, str);
        this.mFileKey = null;
        TTVideoEngineLog.i(logcatTag(), "set preloaderitem");
    }

    void _doSetVideoID(String str) {
        if ((str != null && !str.equals(this.mVideoID) && (!TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 1L) || this.mEngineHasUsed)) || this.mForceShutDownOldSource == 1) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "set video id:" + str);
            }
            _ShutdownOldSource();
            this.mIsLocal = false;
            this.mFirstURL = true;
            this.mFirstIP = true;
            this.mFirstHost = true;
            this.mState = 0;
            this.mUserStopped = false;
            this.mLastPlaybackTime = 0;
            this.mAPIString = null;
        }
        this.mEngineHasUsed = true;
        this.mStarted = false;
        this.mVideoID = str;
        this.mBufferingStartT = 0L;
        this.mLogger.setSourceType(5, str);
        this.mFileKey = null;
    }

    void _dumpSurface(String str) {
        if (!TTVideoEngineLog.d()) {
            return;
        }
        Surface surface = this.mSurface;
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append(" -> ");
        sb.append(str);
        sb.append(" dumpSurface: ");
        sb.append("mSurface = ");
        sb.append(surface);
        if (surface != null) {
            sb.append(" isValid = ");
            sb.append(surface.isValid());
        }
        sb.append(", mSurfaceHolder = ");
        sb.append(surfaceHolder);
        if (surfaceHolder != null) {
            Surface surface2 = surfaceHolder.getSurface();
            sb.append(" surface = ");
            sb.append(surface2);
            if (surface2 != null) {
                sb.append(" isValid = ");
                sb.append(surface2.isValid());
            }
        }
        VideoSurface videoSurface = this.mTextureSurface;
        sb.append(", mTextureSurface = ");
        sb.append(videoSurface);
        if (videoSurface != null) {
            sb.append(" isValid = ");
            sb.append(videoSurface.isValid());
        }
        TTVideoEngineLog.d(logcatTag(), sb.toString());
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setLooping(boolean z) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "setLooping:" + z);
        }
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(6, z ? 1 : 0);
        } else {
            _doSetLooping(z);
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "set looping value:" + (z ? 1 : 0));
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setPlaybackParams(PlaybackParams playbackParams) {
        if (playbackParams != null && TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "setPlaybackParams:" + playbackParams + ", speed:" + playbackParams.getSpeed() + ", pitch:" + playbackParams.getPitch());
        }
        this.mPlaybackParams = playbackParams;
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(53, 0, 0, playbackParams);
        } else {
            _doSetPlaybackParams(playbackParams);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSubAuthToken(String str) {
        String base64Decode = TTHelper.base64Decode(str);
        if (!TextUtils.isEmpty(base64Decode)) {
            try {
                String optString = new JSONObject(base64Decode).optString("GetSubtitleAuthToken");
                this.mSubAuthToken = optString;
                if (TextUtils.isEmpty(optString)) {
                    this.mSubAuthToken = base64Decode;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "setSubAuthToken " + str);
        }
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setSurface(Surface surface) {
        TTVideoEngineLog.i(logcatTag(), "setsurface = " + surface + ", pre-surface:" + this.mSurface + ",this:" + this);
        if (surface == null) {
            this.mLastSetSurfaceNullTime = System.currentTimeMillis();
        }
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(54, 0, 0, surface);
        } else {
            lambda$_setSurfaceSync$5(surface);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSurfaceHolderSync(SurfaceHolder surfaceHolder) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "setSurfaceHolderSync = " + surfaceHolder + ", this:" + this);
        }
        if (surfaceHolder == null) {
            this.mLastSetSurfaceNullTime = System.currentTimeMillis();
        }
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            if (!this.mLooperThread.sendEngineMessage(55, getConfigInt(950, (int) this.mSendEngineMsgTimeout), 0, 0, surfaceHolder) && surfaceHolder != null) {
                this.mSetValidSurfaceTimeout = 1;
                return;
            }
            return;
        }
        _doSetSurfaceHolder(surfaceHolder, false);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void updatePlaybackState(int i) {
        if (this.mPlaybackState != i) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "playback state changed, prev:" + this.mPlaybackState + ", current:" + i);
            }
            this.mPlaybackState = i;
            notifyPlaybackStateChanged(i);
            TTVideoEngineMonitor tTVideoEngineMonitor = this.mEngineStateMonitor;
            if (tTVideoEngineMonitor != null) {
                if (i == 1) {
                    tTVideoEngineMonitor.engineStateChange(hashCode(), true);
                } else {
                    tTVideoEngineMonitor.engineStateChange(hashCode(), false);
                }
            }
        }
    }

    private void _bufferEnd(int i) {
        IVideoEventLogger iVideoEventLogger;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "buffering end,this:" + this + ", code:" + i);
        }
        IPlayDurationManager iPlayDurationManager = this.mPlayDuration;
        if (iPlayDurationManager != null && this.mPlaybackState == 1) {
            iPlayDurationManager.start();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.mBufferingStartT;
        if (j > 0 && elapsedRealtime >= j) {
            IVideoEventLogger iVideoEventLogger2 = this.mLogger;
            if (iVideoEventLogger2 != null) {
                iVideoEventLogger2.movieStallEnd(i);
            }
            if (i == 0) {
                setPlayInfo(4, 1L);
            }
            int configInt = getConfigInt(668, this.mResumeFileIOBlockThresMs);
            if (configInt > 0 && elapsedRealtime - this.mBufferingStartT > configInt && TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d(logcatTag(), "resume io thres:" + configInt + " cur block:" + (elapsedRealtime - this.mBufferingStartT));
            }
            this.mBufferingStartT = 0L;
        } else if (this.mNotifyBufferingDirectly == 1 && (iVideoEventLogger = this.mLogger) != null) {
            iVideoEventLogger.playbackBufferEnd();
        }
        this.mBufferingType = -1;
        notifyBufferEnd(i);
        updateLoadState(1, i);
        _updateTextureState(1);
        if (shouldStartTextureRenderCheck()) {
            this.mTextureSurface.setIntOption(33, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _doSetWindowClient(TTAVWindowClient tTAVWindowClient) {
        int i;
        int i2;
        MediaPlayer mediaPlayer = this.mAsyncPlayer;
        if (mediaPlayer == null) {
            mediaPlayer = this.mMediaPlayer;
        }
        if (mediaPlayer == null) {
            this.mWindowClient = tTAVWindowClient;
            return;
        }
        int i3 = this.mPlayerType;
        boolean z = true;
        if ((i3 == 0 || i3 == 2) && ((getConfigInt(TTVideoEngineInterface.PLAYER_OPTION_OPEN_TEXTUER_AFTER_FIRST_FRAME, this.mFirstFrameOpenTexture) == 1 && this.mSurfaceHolder == null && !this.mPlayerFirstFrame) || ((getConfigInt(587, this.mEnableForceDisableOESRender ? 1 : 0) == 1 && getConfigInt(588, this.mForceDisableOESRender ? 1 : 0) == 1) || this.mTextureSurface == null))) {
            z = false;
        }
        this.mIsNewPlayerViewUsedExternal = z;
        if (!z) {
            this.mLogger.setSurfaceSourceType("external");
            this.mLogger.setSurfaceBegin();
            mediaPlayer.setWindowClient(tTAVWindowClient);
            this.mLogger.setSurfaceEnd();
        } else {
            if (this.mWindowClientExternal == null) {
                this.mWindowClientExternal = new AnonymousClass8(mediaPlayer);
            }
            TTAVWindowClient tTAVWindowClient2 = this.mWindowClient;
            if (tTAVWindowClient2 != null && tTAVWindowClient2 != tTAVWindowClient) {
                tTAVWindowClient2.unbindExternal(this.mWindowClientExternal);
            }
            if (tTAVWindowClient != null) {
                tTAVWindowClient.bindExternal(this.mWindowClientExternal);
                if (this.mWindowClient != tTAVWindowClient && (i = this.mVideoWidth) > 0 && (i2 = this.mVideoHeight) > 0) {
                    tTAVWindowClient.updateVideoSize(i, i2);
                }
            }
        }
        this.mWindowClient = tTAVWindowClient;
    }

    private void _parseDNS(String str) {
        int i;
        boolean z;
        int i2;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "hostnameURL:" + str);
        }
        if (this.mShouldStop) {
            TTVideoEngineLog.w(logcatTag(), "_parseDNS should stop");
            return;
        }
        this.mState = 2;
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        boolean z2 = false;
        if (iVideoEventLogger != null) {
            iVideoEventLogger.setDNSStartTime(System.currentTimeMillis(), 0);
        }
        try {
            DNSParser dNSParser = new DNSParser(this.mContext, new URL(str).getHost(), getNetClientSetByUser());
            this.mDNSParser = dNSParser;
            dNSParser.setCompletionListener(new MyDNSCompletionListener(this));
            if (this.mErrorCount != 0) {
                this.mDNSParser.setForceReparse();
            }
            DNSParser dNSParser2 = this.mDNSParser;
            if (this.mUseDNSCache) {
                i = 1;
            } else {
                i = 0;
            }
            if (getConfigInt(18, i) == 1) {
                z = true;
            } else {
                z = false;
            }
            dNSParser2.setIsUseDNSCache(z);
            int configInt = getConfigInt(19, this.mDNSExpiredTime);
            if (configInt > 0) {
                this.mDNSParser.setDNSExpiredTimeInS(configInt);
            }
            if (this.mIsUseServerDns) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (getConfigInt(403, i2) == 1) {
                z2 = true;
            }
            if (z2 && this.mVideoModel != null) {
                this.mDNSParser.setIsUseServerDNS(z2);
                this.mDNSParser.setDnsInfo(this.mVideoModel.getDnsInfo(), Long.valueOf(this.mVideoModel.getVideoRefLong(216)));
            }
            this.mDNSParser.start();
        } catch (Exception e) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d(e);
            }
        }
    }

    private void _renderSeekComplete(int i) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "render seek complete:" + i);
        }
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            iVideoEventLogger.renderSeekCompleted(i);
            this.mLogger.showedOneFrame();
        }
        if (this.mSeeking) {
            this.mSeeking = false;
            this.mSeekingStartTime = 0L;
            IVideoEventLogger iVideoEventLogger2 = this.mLogger;
            if (iVideoEventLogger2 != null) {
                iVideoEventLogger2.seekCompleted();
                this.mLogger.showedOneFrame();
            }
        }
        if (shouldStartTextureRenderCheck()) {
            this.mTextureSurface.setIntOption(33, 1);
        }
        if (this.mListenerCompact.getVideoEngineInfoListener() != null) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "render seek complete call back " + i);
            }
            VideoEngineInfos videoEngineInfos = new VideoEngineInfos();
            videoEngineInfos.setKey("renderSeekComplete");
            videoEngineInfos.setObject(Integer.valueOf(i));
            notifyEngineInfo(videoEngineInfos, true);
        }
    }

    private void _seekComplete(boolean z) {
        long max;
        IVideoEventLogger iVideoEventLogger;
        TTVideoEngineLog.i(logcatTag(), "seek complete");
        if (z && (iVideoEventLogger = this.mLogger) != null) {
            iVideoEventLogger.setLoggerTimes(169);
        }
        if (!isInHousePlayer()) {
            this.mSeeking = false;
            this.mSeekingStartTime = 0L;
            IVideoEventLogger iVideoEventLogger2 = this.mLogger;
            if (iVideoEventLogger2 != null) {
                iVideoEventLogger2.seekCompleted();
                this.mLogger.showedOneFrame();
            }
        }
        if (this.mSeamSwitchingResolution) {
            this.mSeamSwitchingResolution = false;
            changeResolutionSwitchingState(false);
            IVideoEventLogger iVideoEventLogger3 = this.mLogger;
            if (iVideoEventLogger3 != null) {
                iVideoEventLogger3.switchResolutionEnd(true);
            }
        }
        if (shouldStartTextureRenderCheck()) {
            this.mTextureSurface.setIntOption(33, 1);
        }
        notifySeekCompletion(z);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && isPcdnNeedPlayInfo()) {
            long longOption = mediaPlayer.getLongOption(73, -1L);
            long longOption2 = mediaPlayer.getLongOption(72, -1L);
            int intOption = mediaPlayer.getIntOption(62, 0);
            int intOption2 = mediaPlayer.getIntOption(61, 0);
            if (intOption == 1 && intOption2 == 1) {
                max = Math.max(0L, Math.min(longOption, longOption2));
            } else if (intOption2 == 1) {
                max = Math.max(0L, longOption);
            } else if (intOption == 1) {
                max = Math.max(0L, longOption2);
            } else {
                return;
            }
            setPlayInfo(5, max);
        }
    }

    private void _streamChanged(int i) {
        int intOption;
        int i2;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "stream " + i + " changed, state:" + this.mPlaybackState + ", mPrepared:" + (this.mPrepared ? 1 : 0) + ", mLoadState:" + this.mLoadState);
        }
        int i3 = 0;
        if (this.mSeeking) {
            this.mSeeking = false;
            this.mSeekingStartTime = 0L;
        }
        PlayerEventListener playerEventListener = this.mPlayerEventListener;
        if (getConfigInt(664, this.mEnableDebugUINotify) != 0 && playerEventListener != null && this.mMediaPlayer != null) {
            if (i == 0) {
                playerEventListener.onVideoInputFormatChanged(getVideoFormatInfo());
            } else if (i == 1) {
                playerEventListener.onAudioInputFormatChanged(getVideoFormatInfo());
            }
        }
        if (i == 0 && !this.mDecodedVideoFirstFrame) {
            this.mDecodedVideoFirstFrame = true;
        }
        if (this.mPrepared && this.mPlaybackState != 0 && this.mLoadState != 0) {
            notifyStreamChanged(i);
            if (i == 0 && this.mMediaPlayer != null && this.mTextureSurface != null) {
                if ((getConfigInt(4009, this.mTextureRenderForbidReuseVideoSurfaceTexture) > 0 || getConfigInt(4010, this.mTextureRenderForbidForbidReuseTexture) > 0) && (intOption = this.mMediaPlayer.getIntOption(157, -1)) > 0) {
                    if (getConfigInt(4009, this.mTextureRenderForbidReuseVideoSurfaceTexture) > 0) {
                        VideoSurface videoSurface = this.mTextureSurface;
                        if (intOption != 2) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        videoSurface.setIntOption(116, i2);
                    }
                    if (getConfigInt(4010, this.mTextureRenderForbidForbidReuseTexture) > 0) {
                        VideoSurface videoSurface2 = this.mTextureSurface;
                        if (intOption != 2) {
                            i3 = 1;
                        }
                        videoSurface2.setIntOption(117, i3);
                    }
                }
            }
        }
    }

    private void _tryRegisterMdlHandle(MediaPlayer mediaPlayer) {
        boolean z;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "_tryRegisterMdlHandle, player type:" + mediaPlayer.getPlayerType());
        }
        boolean z2 = true;
        if ((!mHasRegisterMdlProto && mediaPlayer.getPlayerType() == 1) || (getConfigInt(5010, this.mExoEnableNativeMdl ? 1 : 0) != 0 && !mHasRegisterMdlProtoForExo && mediaPlayer.getPlayerType() == 5)) {
            long longValue = DataLoaderHelper.getDataLoader().getLongValue(1003);
            if (longValue != -1) {
                DataLoaderHelper.getDataLoader().setIntValue(1004, (int) mediaPlayer.setLongOption(500, longValue));
                if (mediaPlayer.getPlayerType() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                mHasRegisterMdlProto = z;
                if (mediaPlayer.getPlayerType() != 5) {
                    z2 = false;
                }
                mHasRegisterMdlProtoForExo = z2;
            }
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "get handle: " + longValue);
            }
        }
    }

    private void _videoBitrateChanged(int i) {
        Resolution resolution = Resolution.Undefine;
        IVideoModel iVideoModel = this.mVideoModel;
        if (iVideoModel != null && iVideoModel.hasData()) {
            Resolution[] allResolutions = Resolution.getAllResolutions();
            int i2 = 0;
            while (true) {
                if (i2 < allResolutions.length) {
                    VideoInfo videoInfo = this.mVideoModel.getVideoInfo(allResolutions[i2], VideoRef.TYPE_VIDEO, (Map<Integer, String>) null);
                    if (videoInfo != null && videoInfo.getValueInt(3) == i) {
                        resolution = allResolutions[i2];
                        this.lastResolution = this.currentResolution;
                        this.currentBitrate = i;
                        this.currentResolution = resolution;
                        this.mCurrentQualityDesc = videoInfo.getValueStr(32);
                        _logFirstResolution(this.currentResolution);
                        this.mLogger.configResolution(_resolutionToString(this.currentResolution), _resolutionToString(this.lastResolution));
                        this.mLogger.setCurrentQualityDesc(this.mCurrentQualityDesc);
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "video bitrate changed:" + i + ", resoluton:" + resolution.toString(VideoRef.TYPE_VIDEO));
        }
        if (this.mPlaybackState == 2 && this.mSeamSwitchingResolution) {
            this.mSeamSwitchingResolution = false;
            changeResolutionSwitchingState(false);
            IVideoEventLogger iVideoEventLogger = this.mLogger;
            if (iVideoEventLogger != null) {
                iVideoEventLogger.switchResolutionEnd(true);
            }
        } else {
            if (this.mResolutionSwitching) {
                this.mLogger.switchResolutionEnd(false);
            }
            changeResolutionSwitchingState(false);
        }
        if (this.mLooperThread.checkSendMainLooper()) {
            this.mLooperThread.postMainLooperMessage(417, i, 0, resolution);
        } else {
            this.mListenerCompact.onVideoStreamBitrateChanged(resolution, i);
        }
        if (this.mEnableABR == 1) {
            this.mLogger.abrEventEnd(i);
        }
    }

    @TargetClass("com.ss.ttvideoengine.TTVideoEngineImpl")
    @Insert("createMediaPlayer")
    public static MediaPlayer com_ss_ttvideoengine_TTVideoEngineImpl_com_dragon_read_aop_TTVideoEngineAop_createMediaPlayer(TTVideoEngineImpl tTVideoEngineImpl) {
        MediaPlayer TTVideoEngineImpl__createMediaPlayer$___twin___ = tTVideoEngineImpl.TTVideoEngineImpl__createMediaPlayer$___twin___();
        if (TTVideoEngineImpl__createMediaPlayer$___twin___ != null && com.dragon.read.base.ssconfig.c.v().enableMediaPlayerDegradeFix) {
            String str = (String) tTVideoEngineImpl.get("tag");
            LogWrapper.info("AudioCore-TTVideoEngineAops", "createMediaPlayer playerType = " + TTVideoEngineImpl__createMediaPlayer$___twin___.getPlayerType() + ", tag = " + str, new Object[0]);
            if (TTVideoEngineImpl__createMediaPlayer$___twin___.isOSPlayer() && (str.equals("AudioPlayer-SDK") || str.equals("AudioPlayer"))) {
                PlayAddress currentPlayAddress = il6.a.B().getCurrentPlayAddress();
                dt2.b F0 = NsAudioModuleApi.IMPL.audioCoreContextApi().F0();
                String currentChapterId = F0.getCurrentChapterId();
                long f = F0.f();
                if (currentPlayAddress != null && currentPlayAddress.isEncrypt) {
                    try {
                        if (b0.c) {
                            LogWrapper.info("AudioCore-TTVideoEngineAops", "osPlayer play encrypt but hasRetry", new Object[0]);
                            il6.a.B().stop();
                            ToastUtils.showCommonToastSafely("播放器异常，请检测网络或尝试重启应用");
                            return TTVideoEngineImpl__createMediaPlayer$___twin___;
                        }
                        b0.c = true;
                        LogWrapper.info("AudioCore-TTVideoEngineAops", "stop last because osPlayer play encrypt", new Object[0]);
                        il6.a.B().stop();
                        ThreadUtils.postInForegroundAtFrontOfQueue(new b0.c(currentChapterId, f));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        return TTVideoEngineImpl__createMediaPlayer$___twin___;
    }

    @TargetClass("com.ss.ttvideoengine.TTVideoEngineImpl")
    @Insert("_doPlay")
    public static void com_ss_ttvideoengine_TTVideoEngineImpl_com_dragon_read_aop_TTVideoEngineAop_doPlay(TTVideoEngineImpl tTVideoEngineImpl) {
        LogWrapper.info("AudioCore-TTVideoEngineAops", "_doPlay ,currentTag = " + ((String) tTVideoEngineImpl.get("tag")) + ", subTag = " + ((String) tTVideoEngineImpl.get("subtag")), new Object[0]);
        b0.e(tTVideoEngineImpl, Boolean.TRUE);
        i0.a();
        tTVideoEngineImpl.TTVideoEngineImpl___doPlay$___twin___();
        try {
            LogWrapper.info("AudioCore-TTVideoEngineAops", "_doPlay ,TTVideoEngine = " + tTVideoEngineImpl, new Object[0]);
            LogWrapper.info("AudioCore-TTVideoEngineAops", "_doPlay ,playPath = " + tTVideoEngineImpl.getCurrentPlayPath(), new Object[0]);
        } catch (Throwable th) {
            LogWrapper.error("AudioCore-TTVideoEngineAops", "_doPlay ,exception = " + th.getMessage(), new Object[0]);
        }
        Npth.addTag("last_player_vid", a54.e.e(tTVideoEngineImpl));
    }

    private void initSr(VideoSurface videoSurface) {
        Bundle bundle;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "initSr,mTextureAlgType:" + this.mTextureAlgType);
        }
        if (this.mTextureAlgType != -1 && videoSurface != null) {
            if (this.mLensBundle != null) {
                bundle = new Bundle(this.mLensBundle);
            } else {
                bundle = new Bundle();
            }
            bundle.putInt("effect_type", 5);
            bundle.putInt("action", 21);
            bundle.putInt("srAlgType", this.mTextureAlgType);
            bundle.putInt("srMaxSizeWidth", this.mMaxTextureWidth);
            bundle.putInt("srMaxSizeHeight", this.mMaxTextureHeight);
            bundle.putInt("enable_bmf", EngineGlobalConfig.getInstance().getEnableBmf());
            bundle.putInt("sr_backend", this.mSrBackend);
            bundle.putInt("scale_type", this.mSrScaleType);
            bundle.putInt("pool_size", this.mSrPoolSize);
            bundle.putString("kernelBinPath", this.mTextureSRBinPath);
            bundle.putString("oclModleName", this.mTextureSROclModuleName);
            bundle.putString("dspModleName", this.mTextureSRDspModuleName);
            bundle.putString("moduleName", FeatureManager.getModuleName());
            bundle.putString("programCacheDir", this.mProgramCacheDir);
            bundle.putInt("use_bmf_component", this.mUseBmfComponent);
            bundle.putString("lib_path", this.mSRLibPath);
            bundle.putInt("bmf_direct_invoke", this.mUseBmfDirectInvoke);
            bundle.putBundle("init_config_bundle", this.mBmfInitConfigBundle);
            bundle.putBundle("pro_config_bun", this.mBmfSrProcessParam);
            videoSurface.setEffect(bundle);
        }
    }

    private void setSRInitConfigWithBundle(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int i = bundle.getInt("srAlgType");
        String string = bundle.getString("kernelBinPath");
        String string2 = bundle.getString("oclModleName");
        String string3 = bundle.getString("dspModleName");
        int i2 = bundle.getInt("sr_backend");
        int i3 = bundle.getInt("scale_type");
        int i4 = bundle.getInt("pool_size");
        String string4 = bundle.getString("programCacheDir");
        int i5 = bundle.getInt("use_bmf_component");
        String string5 = bundle.getString("lib_path");
        int i6 = bundle.getInt("bmf_direct_invoke");
        Bundle bundle2 = bundle.getBundle("init_config_bundle");
        Bundle bundle3 = bundle.getBundle("pro_config_bun");
        this.mOldTextureAlgType = this.mTextureAlgType;
        this.mTextureAlgType = i;
        this.mTextureSRBinPath = string;
        this.mTextureSROclModuleName = string2;
        this.mTextureSRDspModuleName = string3;
        this.mSrBackend = i2;
        this.mSrScaleType = i3;
        this.mSrPoolSize = i4;
        this.mProgramCacheDir = string4;
        this.mUseBmfComponent = i5;
        this.mSRLibPath = string5;
        this.mUseBmfDirectInvoke = i6;
        this.mBmfInitConfigBundle = bundle2;
        this.mBmfSrProcessParam = bundle3;
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            iVideoEventLogger.setSrAlgorithm(i);
            this.mLogger.setSrScaleType(i3);
            this.mLogger.setEnableBmfSr(EngineGlobalConfig.getInstance().getEnableBmf());
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "[SRLog]sr init config = " + this.mTextureAlgType + "," + this.mTextureSRBinPath + "," + this.mTextureSROclModuleName + ", " + this.mTextureSRDspModuleName);
        }
    }

    long _doGetLongOption(int i) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        try {
            if (i != 81) {
                if (i != 315) {
                    if (i != 461) {
                        if (i != 950) {
                            if (i != 614) {
                                if (i != 615) {
                                    switch (i) {
                                        case 60:
                                            if ((this.mBitrate < 0 || this.mEnableRefreashCodecStatus) && mediaPlayer != null) {
                                                this.mBitrate = mediaPlayer.getLongOption(171, 0L);
                                            }
                                            return this.mBitrate;
                                        case 61:
                                            if (mediaPlayer == null) {
                                                return -1L;
                                            }
                                            return mediaPlayer.getLongOption(73, 0L);
                                        case 62:
                                            if (mediaPlayer == null) {
                                                return -1L;
                                            }
                                            return mediaPlayer.getLongOption(72, 0L);
                                        case 63:
                                            if (mediaPlayer == null) {
                                                return -1L;
                                            }
                                            return mediaPlayer.getLongOption(63, -1L);
                                        case 64:
                                            if (mediaPlayer == null) {
                                                return -1L;
                                            }
                                            return mediaPlayer.getLongOption(468, -1L);
                                        default:
                                            return super.getLongOption(i);
                                    }
                                }
                                long j = this.mRenderStartTime;
                                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                                    TTVideoEngineLog.i(logcatTag(), "get mRenderStartTime:" + j);
                                    return j;
                                }
                                return j;
                            }
                            long j2 = this.mPlayStartTime;
                            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                                TTVideoEngineLog.i(logcatTag(), "get mPlayStartTime:" + j2);
                                return j2;
                            }
                            return j2;
                        }
                        return this.mSendEngineMsgTimeout;
                    }
                    return this.mVideoPreloadSize;
                }
                if (mediaPlayer == null) {
                    return -1L;
                }
                return mediaPlayer.getLongOption(46, 0L);
            }
            if (mediaPlayer == null) {
                return -1L;
            }
            long longOption = mediaPlayer.getLongOption(240, 0L);
            TTVideoEngineLog.i(logcatTag(), "get value of KeyIsLastBufferSizeU64: " + longOption);
            return longOption;
        } catch (Throwable th) {
            if (!TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                return -1L;
            }
            TTVideoEngineLog.d(th);
            return -1L;
        }
    }

    String _doGetStringOption(int i) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        String str = "";
        try {
            if (i != 80) {
                if (i != 82) {
                    if (i != 462) {
                        if (i != 477) {
                            if (i != 716) {
                                if (i != 957) {
                                    return super.getStringOption(i);
                                }
                                if (mediaPlayer == null) {
                                    return "";
                                }
                                return mediaPlayer.getStringOption(1002);
                            }
                            if (mediaPlayer == null) {
                                return "";
                            }
                            return mediaPlayer.getStringOption(473);
                        }
                        IVideoEventLogger iVideoEventLogger = this.mLogger;
                        if (iVideoEventLogger == null) {
                            return "";
                        }
                        return iVideoEventLogger.getStringOption(47);
                    }
                    Map<String, IpInfo> map = this.urlIPMap;
                    if (map == null) {
                        return "";
                    }
                    for (Map.Entry<String, IpInfo> entry : map.entrySet()) {
                        String key = entry.getKey();
                        IpInfo value = entry.getValue();
                        if (key != null && value != null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("ip", value.ip);
                            hashMap.put("dns", value.dns);
                            hashMap.put("dns_cache_open", Integer.valueOf(value.isDNSCacheOpen));
                            hashMap.put("server_dns_open", Integer.valueOf(value.isServerDNSOpen));
                            hashMap.put("url_desc", value.urlDesc);
                            str = hashMap.toString();
                        }
                    }
                    return str;
                }
                if (TTVideoEngine.isForceUsePluginPlayer()) {
                    return MediaPlayerWrapper.getPluginVersion();
                }
                return TTPlayerConfiger.getValue(14, "");
            }
            if (mediaPlayer == null) {
                return "";
            }
            return mediaPlayer.getStringOption(142);
        } catch (Throwable th) {
            if (!TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                return "";
            }
            TTVideoEngineLog.d(th);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void _doParseDNSComplete(java.lang.String r13) {
        /*
            r12 = this;
            boolean r0 = r12.mShouldStop
            if (r0 == 0) goto Le
            java.lang.String r13 = r12.logcatTag()
            java.lang.String r0 = "_doParseDNSComplete should stop"
            com.ss.ttvideoengine.utils.TTVideoEngineLog.w(r13, r0)
            return
        Le:
            com.ss.ttvideoengine.log.IVideoEventLogger r0 = r12.mLogger
            if (r0 == 0) goto L1a
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 0
            r0.setDNSParseTime(r1, r3)
        L1a:
            com.ss.ttvideoengine.TTVideoEngineImpl$URLInfo r0 = r12.mURLInfo
            java.lang.String r0 = r0.hostURL
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.String r0 = r0.getHost()
            r1 = 2
            boolean r1 = com.ss.ttvideoengine.utils.TTVideoEngineLog.isPredicateLoglevelTurnOn(r1)
            if (r1 == 0) goto L4d
            java.lang.String r1 = r12.logcatTag()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "dns success, host:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = ", ip:"
            r2.append(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            com.ss.ttvideoengine.utils.TTVideoEngineLog.i(r1, r2)
        L4d:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = ""
            if (r1 != 0) goto L73
            com.ss.ttvideoengine.TTVideoEngineImpl$URLInfo r1 = r12.mURLInfo     // Catch: java.lang.Exception -> L60
            java.lang.String r1 = r1.hostURL     // Catch: java.lang.Exception -> L60
            if (r1 == 0) goto L73
            java.lang.String r1 = r1.replaceFirst(r0, r13)     // Catch: java.lang.Exception -> L60
            goto L74
        L60:
            r1 = move-exception
            r3 = 6
            boolean r3 = com.ss.ttvideoengine.utils.TTVideoEngineLog.isPredicateLoglevelTurnOn(r3)
            if (r3 == 0) goto L73
            java.lang.String r3 = r12.logcatTag()
            java.lang.String r1 = r1.toString()
            com.ss.ttvideoengine.utils.TTVideoEngineLog.e(r3, r1)
        L73:
            r1 = r2
        L74:
            com.ss.ttvideoengine.net.DNSParser r3 = r12.mDNSParser
            if (r3 == 0) goto L7c
            java.lang.String r2 = r3.getTypeStr()
        L7c:
            r6 = r2
            java.util.Map<java.lang.String, com.ss.ttvideoengine.TTVideoEngineImpl$IpInfo> r2 = r12.urlIPMap
            com.ss.ttvideoengine.TTVideoEngineImpl$URLInfo r3 = r12.mURLInfo
            java.lang.String r3 = r3.hostURL
            java.lang.Object r2 = r2.get(r3)
            com.ss.ttvideoengine.TTVideoEngineImpl$IpInfo r2 = (com.ss.ttvideoengine.TTVideoEngineImpl.IpInfo) r2
            if (r2 == 0) goto L90
            r2.ip = r13
            r2.dns = r6
            goto Laf
        L90:
            java.util.Map<java.lang.String, com.ss.ttvideoengine.TTVideoEngineImpl$IpInfo> r2 = r12.urlIPMap
            com.ss.ttvideoengine.TTVideoEngineImpl$URLInfo r3 = r12.mURLInfo
            java.lang.String r10 = r3.hostURL
            com.ss.ttvideoengine.TTVideoEngineImpl$IpInfo r11 = new com.ss.ttvideoengine.TTVideoEngineImpl$IpInfo
            com.ss.ttvideoengine.net.DNSParser r3 = r12.mDNSParser
            boolean r7 = r3.getIsUseDNSCache()
            com.ss.ttvideoengine.net.DNSParser r3 = r12.mDNSParser
            boolean r8 = r3.getIsUseServerDNS()
            java.lang.String r9 = ""
            r3 = r11
            r4 = r12
            r5 = r13
            r3.<init>(r5, r6, r7, r8, r9)
            r2.put(r10, r11)
        Laf:
            r12._updateVU()
            com.ss.ttvideoengine.TTVideoEngineImpl$URLInfo r2 = r12.mURLInfo
            java.lang.String r2 = r2.hostURL
            r12._logFirstURL(r2)
            r12._logFirstHost(r0)
            r12._logFirstIP(r13)
            r12._playVideo(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.TTVideoEngineImpl._doParseDNSComplete(java.lang.String):void");
    }

    void _doSetVideoModel(IVideoModel iVideoModel) {
        String videoRefStr = iVideoModel.getVideoRefStr(2);
        if (TextUtils.isEmpty(videoRefStr)) {
            TTVideoEngineLog.i(logcatTag(), "_doSetVideoModel vid is empty");
            return;
        }
        if ((!iVideoModel.equals(this.mVideoModel) && (!TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 1L) || this.mEngineHasUsed)) || this.mForceShutDownOldSource == 1) {
            TTVideoEngineLog.i(logcatTag(), "_doSetVideoModel VideoModel is new");
            _ShutdownOldSource();
            this.mIsLocal = false;
            this.mFirstURL = true;
            this.mFirstIP = true;
            this.mFirstHost = true;
            this.mState = 0;
            this.mUserStopped = false;
            this.mLastPlaybackTime = 0;
            this.mFetcher = null;
            this.mAPIString = null;
        }
        this.mEngineHasUsed = true;
        this.mStarted = false;
        this.mVideoModel = iVideoModel;
        this.mKeyseed = iVideoModel.getVideoRefStr(218);
        String videoRefStr2 = this.mVideoModel.getVideoRefStr(217);
        this.mFallbackAPI = videoRefStr2;
        if (!TextUtils.isEmpty(videoRefStr2)) {
            this.mLogger.setIntOption(172, 1);
        }
        this.mVideoModelVersion = this.mVideoModel.getVideoRefInt(9);
        this.mVideoModel.setUpResolution(this.mResolutionMap);
        this.mVideoID = videoRefStr;
        boolean hasFormat = this.mVideoModel.hasFormat(IVideoModel.Format.DASH);
        this.mIsDashSource = hasFormat;
        this.mDashEnabled = hasFormat;
        this.mEngineConfig.setIntOption(17, hasFormat ? 1 : 0);
        mdlFetcherStore();
        this.mIsFeedInfo = true;
        this.mBufferingStartT = 0L;
        this.mLogger.setSourceType(4, this.mVideoID);
        this.mLogger.setFeed(iVideoModel);
        this.mFileKey = null;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "set video model, fallback api:" + this.mFallbackAPI + ",keyseed:" + this.mKeyseed);
        }
        if (this.mEnableTmpLog == 1) {
            showLongLog(this.mVideoModel.toMediaInfoJsonString());
        }
    }

    void _play(boolean z) {
        TTAVPreloaderItem tTAVPreloaderItem;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "_play, mState:" + this.mState + ", byPlay:" + z + ", this:" + this);
        }
        this.mStarted = true;
        this.mPausedBeforePrepared = false;
        if (z) {
            setSpeedTest();
        }
        _initUsingHandle();
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            if (z) {
                iVideoEventLogger.setLoggerTimes(64);
                if (this.mPlayStartTime < 0) {
                    this.mPlayStartTime = SystemClock.elapsedRealtime();
                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                        TTVideoEngineLog.i(logcatTag(), "mPlayStartTime:" + this.mPlayStartTime + ", curT:" + System.currentTimeMillis());
                    }
                }
            } else {
                iVideoEventLogger.setIntOption(31, 1);
                this.mLogger.setLoggerTimes(65);
            }
            this.mLogger.play(z);
        }
        int i = this.mState;
        if (i != 0) {
            if (i != 1) {
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                } else {
                    _replayOrResume();
                    return;
                }
            } else if (this.mVideoModel == null) {
                if (!this.mIsFetchingInfo) {
                    _prepareToPlay();
                    return;
                }
                return;
            } else {
                if (this.mIsPreloaderItem && (tTAVPreloaderItem = this.mPreloaderItem) != null) {
                    _logBeginToPlay(tTAVPreloaderItem.mVideoID);
                } else {
                    _logBeginToPlay(this.mVideoID);
                }
                _parseIPAddress(this.mVideoModel);
                return;
            }
        }
        _prepareToPlay();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public String getDubbedMemUrl(List<DubbedInfo> list) {
        JSONArray jSONArray;
        DubbedInfo dubbedInfo;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        TTVideoEngineImpl tTVideoEngineImpl = this;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray5 = new JSONArray();
                    JSONArray jSONArray6 = new JSONArray();
                    for (DubbedInfo dubbedInfo2 : list) {
                        if (dubbedInfo2 != null) {
                            if (!TextUtils.isEmpty(dubbedInfo2.mFileKey)) {
                                jSONArray = jSONArray6;
                                jSONArray2 = jSONArray5;
                                String _mdlUrl = _mdlUrl(dubbedInfo2.mFileKey, null, tTVideoEngineImpl.getConfigInt(161, tTVideoEngineImpl.mLimitMDLCacheSize), dubbedInfo2.getUrls(), Resolution.Undefine, null, null, null, null, 0L, null, -1);
                                if (!TextUtils.isEmpty(_mdlUrl)) {
                                    dubbedInfo = dubbedInfo2;
                                    dubbedInfo.mMainUrl = _mdlUrl;
                                    dubbedInfo.mBackupUrl1 = _mdlUrl;
                                } else {
                                    dubbedInfo = dubbedInfo2;
                                }
                            } else {
                                jSONArray = jSONArray6;
                                dubbedInfo = dubbedInfo2;
                                jSONArray2 = jSONArray5;
                            }
                            JSONObject bashJsonObject = dubbedInfo.toBashJsonObject();
                            if (bashJsonObject == null) {
                                tTVideoEngineImpl = this;
                                jSONArray6 = jSONArray;
                                jSONArray5 = jSONArray2;
                            } else {
                                int i = dubbedInfo.mMediaType;
                                if (i == 0) {
                                    jSONArray3 = jSONArray2;
                                    jSONArray3.put(bashJsonObject);
                                } else {
                                    jSONArray3 = jSONArray2;
                                    if (i == 1) {
                                        jSONArray4 = jSONArray;
                                        jSONArray4.put(bashJsonObject);
                                        tTVideoEngineImpl = this;
                                        jSONArray6 = jSONArray4;
                                        jSONArray5 = jSONArray3;
                                    }
                                }
                                jSONArray4 = jSONArray;
                                tTVideoEngineImpl = this;
                                jSONArray6 = jSONArray4;
                                jSONArray5 = jSONArray3;
                            }
                        }
                    }
                    jSONObject.put("dynamic_video_list", jSONArray5);
                    jSONObject.put("dynamic_audio_list", jSONArray6);
                    return "mem://bash/url_index:0/segment_format:1/" + jSONObject.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void onMediaPlayerCompletion(MediaPlayer mediaPlayer) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "receive onCompletion,this:" + this);
        }
        this.mLogger.watchFinish();
        if (!this.mLooping) {
            this.mIsPlayComplete = true;
            updatePlaybackState(0);
            IPlayDurationManager iPlayDurationManager = this.mPlayDuration;
            if (iPlayDurationManager != null) {
                iPlayDurationManager.stop();
                this.mLogger.addWatchedDuration(this.mPlayDuration.getPlayedDuration());
            }
            _updateCurrentPlaybackPosition(this.mDuration, true);
            this.mLogger.curPlayBackTime(this.mDuration);
            _updateLogger();
            this.mLogger.movieFinish(3);
            this.mHasFirstFrameShown = false;
            this.mHasFetchedSubtitle = false;
            this.mPlayStartTime = -1L;
            this.mRenderStartTime = -1L;
            this.mHasAudioFirstFrameShown = false;
            this.mSeamSwitchingResolution = false;
            changeResolutionSwitchingState(false);
            this.mLastPlaybackTime = 0;
            this.mRetrying = false;
            this.mStarted = false;
            this.mHasComplete = true;
            this.mSeeking = false;
            _updateTextureState(3);
            VideoSurface videoSurface = this.mTextureSurface;
            if (videoSurface != null) {
                videoSurface.setIntOption(33, 0);
            }
        } else {
            this.mLogger.loopAgain();
        }
        notifyCompletion();
        if (mediaPlayer.isOSPlayer()) {
            this.mPrepared = false;
        }
        this.mStartTime = 0;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setEffect(Bundle bundle) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "setEffect:" + bundle.toString() + " TextureSurface:" + this.mTextureSurface);
        }
        if (bundle != null && bundle.getInt("action") == 21 && bundle.getInt("effect_type") == 5) {
            setSRInitConfigWithBundle(bundle);
        } else if (bundle != null && bundle.getInt("effect_type") == 1) {
            bundle.putBoolean("HasFirstFrameShown", this.mHasFirstFrameShown);
            this.mTRSrategy.setEffect(bundle, this.mTextureSurface);
        } else {
            VideoSurface videoSurface = this.mTextureSurface;
            if (videoSurface != null) {
                videoSurface.setEffect(bundle);
            } else {
                this.mEffectBundle.offer(bundle);
            }
        }
        this.mLogger.setEffect(bundle);
        if (bundle != null) {
            try {
                if (bundle.containsKey("effect_type")) {
                    this.effectTypeSet.add(Integer.valueOf(bundle.getInt("effect_type")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private rs1.g _initABRModule(IVideoModel iVideoModel) {
        boolean z;
        float f;
        float f2;
        float f3;
        float f4;
        DefaultABRModule defaultABRModule = null;
        if (iVideoModel != null && (this.mEnableABR != 0 || this.mStandAlongAbrStartUp != 0)) {
            if (!isSupportSeamlessSwitch(iVideoModel) && this.mStandAlongAbrStartUp <= 0) {
                return null;
            }
            if (this.mEnableABR != 1 && !this.mABRUsed) {
                z = false;
            } else {
                z = true;
            }
            this.mABRUsed = z;
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d(logcatTag(), "[ABR] init ABR, algorithm type:" + TTVideoEngine.sABRAlgorithmType);
            }
            rs1.c.J(getConfigInt(501, this.mABRSwitchSensitivity));
            rs1.c.z(getConfigFloat(527, this.mABRStallPenaltyParameter));
            rs1.c.I(getConfigFloat(528, this.mABRSwitchPenaltyParameter));
            rs1.c.v(getConfigFloat(529, this.mABRBandwidthParameter));
            defaultABRModule = new DefaultABRModule();
            defaultABRModule.f(new MyPlayStateSupplier(this));
            defaultABRModule.h(34, getConfigInt(334, this.mScreenWidth));
            defaultABRModule.h(35, getConfigInt(335, this.mScreenHeight));
            defaultABRModule.h(6, this.mPlayerViewWidth);
            defaultABRModule.h(7, this.mPlayerViewHeight);
            defaultABRModule.i(26, this.mPlayStartTimestamp);
            ss1.b bVar = StrategyCenter.sNetAbrSpeedPredictor;
            float f5 = 0.0f;
            if (bVar != null) {
                Map f6 = bVar.f(VideoRef.TYPE_VIDEO);
                if (f6 != null && f6.get("download_speed") != null) {
                    f5 = Float.parseFloat((String) f6.get("download_speed"));
                }
                f3 = StrategyCenter.sNetAbrSpeedPredictor.d(0);
                f4 = StrategyCenter.sNetAbrSpeedPredictor.a();
                f2 = StrategyCenter.sNetAbrSpeedPredictor.c(VideoRef.TYPE_VIDEO, 1, true);
                f = StrategyCenter.sNetAbrSpeedPredictor.c(VideoRef.TYPE_VIDEO, this.mABRStartupSpeedType, false);
            } else {
                f = 0.0f;
                f2 = 0.0f;
                f3 = 0.0f;
                f4 = 0.0f;
            }
            defaultABRModule.m(25, f5);
            defaultABRModule.m(23, f3);
            defaultABRModule.m(24, f4);
            defaultABRModule.m(27, f2);
            defaultABRModule.m(28, f);
            defaultABRModule.h(21, TTNetWorkListener.getInstance().getCurrentAccessType());
            setMediaInfo2Abr(defaultABRModule, iVideoModel);
        }
        return defaultABRModule;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void _logFirstURL(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.TTVideoEngineImpl._logFirstURL(java.lang.String):void");
    }

    private void _setupMediaCodec(MediaPlayer mediaPlayer) {
        TTVideoEngineLog.i("TTVideoEngine", "start to setup mediacodec");
        if (!this.mEnableSetupMediaCodec) {
            TTVideoEngineLog.d("TTVideoEngine", "disable setup mediacodec");
            return;
        }
        if (mediaPlayer == null) {
            TTVideoEngineLog.i("TTVideoEngine", "async player is null");
            return;
        }
        if (this.mHardwareDecodeEnablePlayer2 <= 0) {
            TTVideoEngineLog.d("TTVideoEngine", "not be hardware decoder");
            return;
        }
        if (getConfigInt(332, this.mUseCodecPool) <= 0) {
            TTVideoEngineLog.d("TTVideoEngine", "codec pool is not used");
            return;
        }
        if (getConfigInt(1125, this.mCodecPoolVersion) != 2) {
            TTVideoEngineLog.d("TTVideoEngine", "codec pool version is not 2.0");
            return;
        }
        mediaPlayer.setIntOption(59, 1);
        mediaPlayer.setIntOption(400, 1);
        mediaPlayer.setIntOption(1344, 2);
        mediaPlayer.setIntOption(181, 1);
        mediaPlayer.setIntOption(182, this.mCodecId);
        mediaPlayer.setIntOption(88, getConfigInt(215, this.mMediaCodecRender));
        mediaPlayer.setIntOption(285, getConfigInt(490, this.mCodecFrcLevel));
        mediaPlayer.setIntOption(574, getConfigInt(578, this.mEnableVC1BlockList));
        mediaPlayer.setIntOption(575, getConfigInt(579, this.mEnableHChipAdaptiveWorkAround));
        mediaPlayer.setIntOption(TTVideoEngineInterface.PLAYER_OPTION_PRE_RENDER_BUFFERING_UPDATE_PRECENTAGE, getConfigInt(580, this.mEnableMChipSkipAdaptiveWorkAround));
        mediaPlayer.setIntOption(164, getConfigInt(572, this.mEnableMediaCodecRealtime));
        mediaPlayer.setIntOption(254, getConfigInt(333, this.mNeedAdaptiveWorkaround));
        mediaPlayer.setIntOption(1055, getConfigInt(854, this.mEnableHWDropFrameWhenVOIsInDropState));
        mediaPlayer.setIntOption(1056, getConfigInt(855, this.mEnableHWDropFrameWhenAVOutSyncing));
        mediaPlayer.setIntOption(1072, getConfigInt(1210, this.mEnableMediaCodecFairMutex));
        if (getConfigInt(979, this.mMCMaxHeight) <= 0 || getConfigInt(978, this.mMCMaxWidth) <= 0) {
            this.mEngineConfig.setIntOption(979, 1080);
            this.mEngineConfig.setIntOption(978, 1920);
        }
        mediaPlayer.setIntOption(1009, getConfigInt(979, this.mMCMaxHeight));
        mediaPlayer.setIntOption(1008, getConfigInt(978, this.mMCMaxWidth));
        if (this.mMaxCodecNumsInPool != -1 || this.mEngineConfig.isKeySet(986)) {
            mediaPlayer.setIntOption(1041, getConfigInt(986, this.mMaxCodecNumsInPool));
        }
        if (this.mDiscardCodecStrategy1 != -1 || this.mEngineConfig.isKeySet(1126)) {
            mediaPlayer.setIntOption(1345, getConfigInt(1126, this.mDiscardCodecStrategy1));
        }
        if (this.mDiscardCodecStrategy2 != -1 || this.mEngineConfig.isKeySet(1127)) {
            mediaPlayer.setIntOption(1346, getConfigInt(1127, this.mDiscardCodecStrategy2));
        }
        if (this.mCodecHistoryLength != -1 || this.mEngineConfig.isKeySet(1128)) {
            mediaPlayer.setIntOption(1347, getConfigInt(1128, this.mCodecHistoryLength));
        }
        if (this.mCodecMaxUsedCount != -1 || this.mEngineConfig.isKeySet(1129)) {
            mediaPlayer.setIntOption(1348, getConfigInt(1129, this.mCodecMaxUsedCount));
        }
        if (this.mDummySurfaceForbid != -1 || this.mEngineConfig.isKeySet(976)) {
            mediaPlayer.setIntOption(1034, getConfigInt(976, this.mDummySurfaceForbid));
        }
        if (this.mSettingCodecName != -1 || this.mEngineConfig.isKeySet(956)) {
            mediaPlayer.setIntOption(1003, getConfigInt(956, this.mSettingCodecName));
            for (int i = 0; i < this.mPrivCodecName.size(); i++) {
                try {
                    mediaPlayer.setStringOption(1002, this.mPrivCodecName.get(i));
                } catch (IndexOutOfBoundsException unused) {
                    TTVideoEngineLog.w("TTVideoEngine", "failed to set codec name");
                    mediaPlayer.setIntOption(1003, 0);
                }
            }
        }
        if (this.mMediaCodecAsyncModeEnable != -1 || this.mEngineConfig.isKeySet(955)) {
            mediaPlayer.setIntOption(1000, getConfigInt(955, this.mMediaCodecAsyncModeEnable));
        }
        if (this.mCodecFramesDrop != -1 || this.mEngineConfig.isKeySet(856)) {
            mediaPlayer.setIntOption(1057, getConfigInt(856, this.mCodecFramesDrop));
        }
        if (this.mEnableMediaCodecDeathCheck != -1 || this.mEngineConfig.isKeySet(1111)) {
            mediaPlayer.setIntOption(1326, getConfigInt(1111, this.mEnableMediaCodecDeathCheck));
        }
        if (this.mMediaCodecDeathCheckInterval != -1 || this.mEngineConfig.isKeySet(1112)) {
            mediaPlayer.setIntOption(1327, getConfigInt(1112, this.mMediaCodecDeathCheckInterval));
        }
        if (this.mMediaCodecDeathTimeout != -1 || this.mEngineConfig.isKeySet(1113)) {
            mediaPlayer.setIntOption(1328, getConfigInt(1113, this.mMediaCodecDeathTimeout));
        }
        if (this.mEnableMediaCodecPipeline != -1 || this.mEngineConfig.isKeySet(1118)) {
            mediaPlayer.setIntOption(1333, getConfigInt(1118, this.mEnableMediaCodecPipeline));
        }
        if (this.mFrameNumsInMediaCodec != -1 || this.mEngineConfig.isKeySet(1119)) {
            mediaPlayer.setIntOption(1334, getConfigInt(1119, this.mFrameNumsInMediaCodec));
        }
        if (this.mQueryAdaptivePlayback != -1 || this.mEngineConfig.isKeySet(998)) {
            mediaPlayer.setIntOption(1313, getConfigInt(998, this.mQueryAdaptivePlayback));
        }
        int i2 = this.mUseQcomVpp;
        if (i2 == 1) {
            mediaPlayer.setIntOption(TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES_STRENGTH, i2);
            mediaPlayer.setIntOption(213, this.mQcomVppLevel);
        }
        if (this.mEnableVideoCodecPixelAlign == 1 || this.mEngineConfig.isKeySet(339)) {
            mediaPlayer.setIntOption(280, getConfigInt(339, this.mEnableVideoCodecPixelAlign));
        }
        OptionHolder optionHolder = this.mOptionHolder;
        if (optionHolder != null) {
            mediaPlayer.setIntOption(42039, getConfigInt(42039, optionHolder.getIntOption(42039, 0)));
        }
        ((MediaPlayerWrapper) mediaPlayer).setupMediaCodec();
        this.mEnableSetupMediaCodec = false;
        TTVideoEngineLog.i(logcatTag(), "success to setup mediacodec");
    }

    /* JADX WARN: Multi-variable type inference failed */
    int _doGetIntOption(int i) {
        int i2;
        long wiredPlayedDuration;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        try {
        } catch (Throwable th) {
            if (!TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                return -1;
            }
            TTVideoEngineLog.d(th);
            return -1;
        }
        if (i != 0) {
            if (i != 4) {
                if (i != 58) {
                    if (i != 59) {
                        if (i != 83) {
                            if (i != 84) {
                                if (i != 301) {
                                    if (i != 302) {
                                        if (i != 424) {
                                            if (i != 425) {
                                                if (i != 700) {
                                                    if (i != 701) {
                                                        if (i != 1416) {
                                                            if (i != 1417) {
                                                                int i3 = 0;
                                                                switch (i) {
                                                                    case 4:
                                                                        break;
                                                                    case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                                                                        i2 = this.mReuseSocket;
                                                                        break;
                                                                    case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                                                                    case 494:
                                                                        i2 = this.mEnableABR;
                                                                        break;
                                                                    case ConstantsAPI.COMMAND_FINDER_SHARE_VIDEO /* 33 */:
                                                                        i2 = this.mBashEnabled;
                                                                        break;
                                                                    case IVideoEventLogger.LOGGER_OPTION_IS_DEGRADE_RELEASE /* 52 */:
                                                                        if (this.mSeamSwitchingResolution) {
                                                                            i2 = this.mLastPlaybackTime;
                                                                            break;
                                                                        } else {
                                                                            i2 = _getPlayerTime();
                                                                            break;
                                                                        }
                                                                    case 160:
                                                                        i2 = this.mDataLoaderEnable;
                                                                        break;
                                                                    case 199:
                                                                        i2 = this.mUseTextureRender;
                                                                        break;
                                                                    case 313:
                                                                        i2 = this.mCheckHijack;
                                                                        break;
                                                                    case 343:
                                                                        if (mediaPlayer != null) {
                                                                            i2 = mediaPlayer.getIntOption(643, 0);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 371:
                                                                        if (mediaPlayer != null) {
                                                                            i2 = mediaPlayer.getIntOption(540, -1);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 499:
                                                                        i2 = this.mEnableBarrageMask;
                                                                        break;
                                                                    case MediaPlayer.MEDIA_PLAYER_OPTION_APPID /* 512 */:
                                                                        i2 = this.mEnableAIBarrage;
                                                                        break;
                                                                    case 525:
                                                                        i2 = this.mABRSpeedPredictOutType;
                                                                        break;
                                                                    case 530:
                                                                        i2 = this.mCurrentSubId;
                                                                        break;
                                                                    case 533:
                                                                        i2 = this.mEnableSub;
                                                                        break;
                                                                    case 596:
                                                                        i2 = this.mSeekMode;
                                                                        break;
                                                                    case 650:
                                                                        i2 = this.mOverlayMode;
                                                                        break;
                                                                    case 655:
                                                                        if (mediaPlayer != null) {
                                                                            i2 = mediaPlayer.getIntOption(541, 0);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 660:
                                                                        int i4 = this.mSRNotUseReason;
                                                                        i2 = i4;
                                                                        if (i4 >= 0) {
                                                                            VideoSurface videoSurface = this.mTextureSurface;
                                                                            if (videoSurface == null) {
                                                                                if (this.mStarted) {
                                                                                    i2 = -7893;
                                                                                    break;
                                                                                } else {
                                                                                    i2 = -7897;
                                                                                    break;
                                                                                }
                                                                            } else if (videoSurface.getIntOption(10) != 1) {
                                                                                s sVar = this.mTextureRenderer;
                                                                                if (sVar != null && sVar.k(0)) {
                                                                                    break;
                                                                                } else {
                                                                                    break;
                                                                                }
                                                                            } else {
                                                                                if (this.mTextureSurface.getIntOption(6) != 1) {
                                                                                    i3 = -7899;
                                                                                }
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 667:
                                                                        IVideoModel iVideoModel = this.mVideoModel;
                                                                        if (iVideoModel != null) {
                                                                            VideoInfo videoInfo = iVideoModel.getVideoInfo(this.currentResolution, 0, (Map<Integer, String>) null);
                                                                            if (videoInfo != null) {
                                                                                i3 = videoInfo.getValueInt(41);
                                                                            }
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 1071:
                                                                        if (this.mTextureSurface == null) {
                                                                            if (mediaPlayer != null) {
                                                                                i2 = mediaPlayer.getIntOption(139, -1);
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 1403:
                                                                        IVideoEventLogger iVideoEventLogger = this.mLogger;
                                                                        if (iVideoEventLogger != null) {
                                                                            i2 = iVideoEventLogger.getIntOption(49);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 1405:
                                                                        i2 = this.mAllowAllExtensions;
                                                                        break;
                                                                    case 1420:
                                                                        i2 = this.mEnableSourceRefreshStrategy;
                                                                        break;
                                                                    case 5022:
                                                                        i2 = this.mHlsProxyVVEnable;
                                                                        break;
                                                                    default:
                                                                        switch (i) {
                                                                            case 40:
                                                                                IVideoEventLogger iVideoEventLogger2 = this.mLogger;
                                                                                if (iVideoEventLogger2 != null) {
                                                                                    i2 = iVideoEventLogger2.getCurDecoderBufferCount();
                                                                                    break;
                                                                                }
                                                                                break;
                                                                            case ConstantsAPI.COMMAND_FINDER_OPEN_EVENT /* 41 */:
                                                                                IVideoEventLogger iVideoEventLogger3 = this.mLogger;
                                                                                if (iVideoEventLogger3 != null) {
                                                                                    wiredPlayedDuration = iVideoEventLogger3.getCurDecoderBufferAccuT();
                                                                                    break;
                                                                                }
                                                                                break;
                                                                            case 42:
                                                                                if (mediaPlayer != null) {
                                                                                    i2 = mediaPlayer.getIntOption(153, -1);
                                                                                    break;
                                                                                }
                                                                                break;
                                                                            case 43:
                                                                                if ((this.mVideoCodecType < 0 || this.mEnableRefreashCodecStatus) && mediaPlayer != null) {
                                                                                    this.mVideoCodecType = mediaPlayer.getIntOption(157, -1);
                                                                                }
                                                                                i2 = this.mVideoCodecType;
                                                                                break;
                                                                            case 44:
                                                                                if ((this.mAudioCodecType < 0 || this.mEnableRefreashCodecStatus) && mediaPlayer != null) {
                                                                                    this.mAudioCodecType = mediaPlayer.getIntOption(158, -1);
                                                                                }
                                                                                i2 = this.mAudioCodecType;
                                                                                break;
                                                                            case 45:
                                                                                if ((this.mVideoCodecID < 0 || this.mEnableRefreashCodecStatus) && mediaPlayer != null) {
                                                                                    this.mVideoCodecID = mediaPlayer.getIntOption(141, -1);
                                                                                }
                                                                                i2 = this.mVideoCodecID;
                                                                                break;
                                                                            case 46:
                                                                                if ((this.mAudioCodecID < 0 || this.mEnableRefreashCodecStatus) && mediaPlayer != null) {
                                                                                    this.mAudioCodecID = mediaPlayer.getIntOption(140, -1);
                                                                                }
                                                                                i2 = this.mAudioCodecID;
                                                                                break;
                                                                            default:
                                                                                switch (i) {
                                                                                    case 256:
                                                                                        if (mediaPlayer != null) {
                                                                                            i2 = mediaPlayer.getIntOption(989, 0);
                                                                                            break;
                                                                                        }
                                                                                        break;
                                                                                    case 257:
                                                                                        i2 = this.mEnablePlaySpeedExtend;
                                                                                        break;
                                                                                    case 258:
                                                                                        i2 = this.mEnableMasterM3u8Optimize;
                                                                                        break;
                                                                                    default:
                                                                                        i2 = super.getIntOption(i);
                                                                                        break;
                                                                                }
                                                                        }
                                                                }
                                                                return -1;
                                                            }
                                                            i2 = this.mCheckSilenceInterval;
                                                        } else {
                                                            i2 = this.mBindCore;
                                                        }
                                                    } else {
                                                        if (mediaPlayer == null) {
                                                            return -1;
                                                        }
                                                        i2 = mediaPlayer.getIntOption(569, -1);
                                                    }
                                                } else {
                                                    if (mediaPlayer == null) {
                                                        return -1;
                                                    }
                                                    i2 = mediaPlayer.getIntOption(961, -1);
                                                }
                                            } else {
                                                i2 = this.mHijackRetryBackupDNSType;
                                            }
                                        } else {
                                            i2 = this.mHijackRetryMainDNSType;
                                        }
                                    } else {
                                        i2 = this.mForbidP2P;
                                    }
                                } else {
                                    i2 = this.mP2PCDNType;
                                }
                            } else {
                                IPlayDurationManager iPlayDurationManager = this.mPlayDuration;
                                if (iPlayDurationManager == null) {
                                    return -1;
                                }
                                wiredPlayedDuration = iPlayDurationManager.getWirelessPlayedDuration(this.mContext);
                            }
                        } else {
                            IPlayDurationManager iPlayDurationManager2 = this.mPlayDuration;
                            if (iPlayDurationManager2 == null) {
                                return -1;
                            }
                            wiredPlayedDuration = iPlayDurationManager2.getWiredPlayedDuration();
                        }
                        i2 = (int) wiredPlayedDuration;
                    } else {
                        if ((this.mAudioCodecProfile == -1 || this.mEnableRefreashCodecStatus) && mediaPlayer != null) {
                            this.mAudioCodecProfile = mediaPlayer.getIntOption(402, -1);
                        }
                        i2 = this.mAudioCodecProfile;
                    }
                } else {
                    if ((this.mVideoCodecProfile == -1 || this.mEnableRefreashCodecStatus) && mediaPlayer != null) {
                        this.mVideoCodecProfile = mediaPlayer.getIntOption(403, -1);
                    }
                    i2 = this.mVideoCodecProfile;
                }
            }
            i2 = this.mLayoutType;
        } else {
            if (mediaPlayer == null) {
                return -1;
            }
            i2 = mediaPlayer.getIntOption(24, -1);
        }
        return i2;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void onMediaPlayerPrepared(MediaPlayer mediaPlayer) {
        MediaPlayer mediaPlayer2;
        boolean z;
        VideoSurface videoSurface;
        if (this.mShouldStop || (mediaPlayer2 = this.mMediaPlayer) == null) {
            return;
        }
        TTVideoEngineLog.i(logcatTag(), "receive onPrepared");
        int intOption = mediaPlayer2.getIntOption(141, -1);
        if (intOption == 33 && !FeatureManager.hasPermission("bytevc2")) {
            receivedError(new Error("kTTVideoErrorDomainLicenseCheck", -30001, -310003));
            return;
        }
        int intOption2 = mediaPlayer2.getIntOption(44, -1);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "onPrepared mediaFormat " + intOption2 + ", videoCodecID " + intOption);
        }
        if (intOption2 == 5 && !FeatureManager.hasPermission("dash")) {
            receivedError(new Error("kTTVideoErrorDomainLicenseCheck", -30001, -310001));
            return;
        }
        if (intOption2 == 6 && !FeatureManager.hasPermission("bash")) {
            receivedError(new Error("kTTVideoErrorDomainLicenseCheck", -30001, -310002));
            return;
        }
        if (!this.mErrorRetryOpt) {
            this.mErrorCount = 0;
        }
        this.mError = null;
        this.mDuration = mediaPlayer.getDuration();
        this.mPrepared = true;
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            iVideoEventLogger.prepareEnd();
            this.mLogger.setDuration(this.mDuration);
        }
        setDisplayVideoSize(getVideoWidth(), getVideoHeight());
        StrategyManager.instance().onPrepared(this.mEngineWrapper);
        notifyPrepared();
        _dumpSurface("onPrepared");
        if (getConfigInt(681, this.mSkipStartWhenPrepared ? 1 : 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        int intOption3 = mediaPlayer2.getIntOption(1746, 0);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "mPausedBeforePrepared:" + this.mPausedBeforePrepared + ", mShouldPlay:" + this.mShouldPlay + ", mIsStartPlayAutomatically:" + this.mIsStartPlayAutomatically + ", mIsPreDecodeAutoPause:" + this.mIsPreDecodeAutoPause + ", skip start:" + z + ", isOsPlayer:" + isOSPlayer());
        }
        if (intOption3 != 0) {
            if (this.mShouldPlay && !this.mPausedBeforePrepared && this.mIsStartPlayAutomatically) {
                mediaPlayer.start();
            }
        } else if (!z && ((!this.mPausedBeforePrepared && this.mShouldPlay) || (!isOSPlayer() && !this.mIsStartPlayAutomatically && this.mIsPreDecodeAutoPause))) {
            mediaPlayer.start();
        }
        if (this.mSeamSwitchingResolution && !this.mShouldPlay) {
            mediaPlayer.start();
            mediaPlayer.pause();
            _updateTextureState(2);
        }
        if (!TextUtils.isEmpty(this.mSubPathInfo) && this.mSeamSwitchingResolution && this.mEnableSubThread > 0) {
            mediaPlayer2.setIntOption(618, this.mEnableSub);
            mediaPlayer2.setStringOption(TTVideoEngineInterface.PLAYER_OPTION_IS_DEGRADE_RELEASE, this.mSubPathInfo);
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d(logcatTag(), "sub option: " + this.mEnableSub + " url:" + this.mSubPathInfo);
            }
        }
        if (this.mPlaybackParams != null && isOSPlayer() && Build.VERSION.SDK_INT >= 23) {
            mediaPlayer.setPlaybackParams(this.mPlaybackParams);
            this.mLogger.setPlaybackParams(this.mPlaybackParams);
        }
        int intOption4 = mediaPlayer.getIntOption(62, -100);
        int intOption5 = mediaPlayer.getIntOption(61, -100);
        if (intOption4 == 0) {
            this.mLogger.setIntOption(12, 1);
        } else {
            this.mLogger.setIntOption(12, 0);
        }
        if (intOption5 == 0) {
            this.mLogger.setIntOption(13, 1);
        } else {
            this.mLogger.setIntOption(13, 0);
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "videoEnabled:" + intOption4 + ",audioEnabled:" + intOption5);
        }
        if (intOption4 == 0 && this.mEnableTextureRenderNoRenderCheck == 1 && (videoSurface = this.mTextureSurface) != null) {
            this.mEnableTextureRenderNoRenderCheck = 0;
            videoSurface.setIntOption(34, 0);
        }
        long longOption = mediaPlayer2.getLongOption(524, -1L);
        long longOption2 = mediaPlayer2.getLongOption(525, -1L);
        this.mLogger.setLongOption(98, longOption);
        this.mLogger.setLongOption(99, longOption2);
        if (getConfigInt(656, this.mEnableHeartBeat ? 1 : 0) == 1 && !this.mHeartBeatStarted) {
            this.mLooperThread.postEngineMessage(24);
            this.mHeartBeatStarted = true;
        }
        if (mediaPlayer.isOSPlayer() && this.mRadioModeEnable == 1 && !this.mHasFirstFrameShown) {
            TTVideoEngineLog.i(logcatTag(), "OSPlayer in radioMode enter renderStart");
            _renderStart();
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void receivedError(Error error) {
        boolean z;
        String str;
        boolean z2;
        boolean z3;
        IVideoModel iVideoModel;
        IntertrustDrmHelper intertrustDrmHelper;
        this.mAllowedExpiredModel = false;
        _updateLogTime();
        if (this.mUserStopped) {
            this.mState = 0;
            return;
        }
        int i = this.mPlayAPIVersion;
        int _getPlayerTime = _getPlayerTime();
        if (!this.mRetrying) {
            int i2 = this.mStartTime;
            if (i2 != 0) {
                this.mLastPlaybackTime = i2;
                this.mStartTime = 0;
            } else if (isInHousePlayer() || (!isInHousePlayer() && this.mPrepared && !this.mSeamSwitchingResolution)) {
                int i3 = this.mDuration;
                if (i3 > 0 && _getPlayerTime - i3 > -1000) {
                    this.mLastPlaybackTime = 0;
                } else {
                    this.mLastPlaybackTime = _getPlayerTime;
                }
            }
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && (mediaPlayer.isOSPlayer() || this.mMediaPlayer.getPlayerType() == 3 || this.mMediaPlayer.getPlayerType() == 4 || this.mMediaPlayer.getPlayerType() == 5)) {
            z = true;
        } else {
            z = false;
        }
        int i4 = 2;
        if (!isInHousePlayer() && getConfigInt(34, this.mDrmType) == 2) {
            z = false;
        }
        MediaPlayer mediaPlayer2 = this.mMediaPlayer;
        if (mediaPlayer2 != null && (mediaPlayer2.getPlayerType() == 0 || this.mMediaPlayer.getPlayerType() == 2)) {
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mIsStartPlayAutomatically = true;
        }
        this.mErrorCount++;
        this.mAccumulatedErrorCount++;
        this.mState = 4;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "videoEngine failed:" + error.toString());
        }
        if (error.domain.equals("kTTVideoErrorDomainIntertrustDRM") && (intertrustDrmHelper = this.mIntertrustDrmHelper) != null) {
            intertrustDrmHelper.stop();
        }
        int i5 = error.code;
        if (i5 == -9939) {
            _notifyError(error);
            return;
        }
        if (i5 == -9987) {
            TTVideoEngineLog.e(logcatTag(), "can't decrypt video");
            _notifyError(error);
            return;
        }
        if (i5 == -9988) {
            TTVideoEngineLog.e(logcatTag(), "decode encryptionkey error, not need to retry");
            _notifyError(error);
            return;
        }
        if (i5 == -9990) {
            TTVideoEngineLog.e(logcatTag(), "invalid request, no need to retry");
            _notifyError(error);
            return;
        }
        if (this.mErrorCount >= 3) {
            TTVideoEngineLog.e(logcatTag(), "videoEngine retry failed");
            _notifyError(error);
            return;
        }
        if (this.mAccumulatedErrorCount >= getConfigInt(28, this.mMaxAccumulatedCountSetByUser)) {
            TTVideoEngineLog.e(logcatTag(), "videoEngine retry failed:reach maxAccumulatedErrorCount");
            _notifyError(error);
            return;
        }
        int i6 = error.code;
        if (i6 == -9966) {
            TTVideoEngineLog.e(logcatTag(), "invalid url");
            _notifyError(error);
            return;
        }
        if (i6 == -499897) {
            if (this.mIsDirectURL) {
                TTVideoEngineLog.e(logcatTag(), "directUrl 403");
                this.mLogger.setIntOption(142, 1);
                _notifyError(error);
                return;
            } else {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                    TTVideoEngineLog.e(logcatTag(), String.format(Locale.getDefault(), "-499897 happen, enable MDL:%d, MDL running:%d, mdlFallbackApiRetry option:%d", Integer.valueOf(getConfigInt(160, this.mDataLoaderEnable)), Integer.valueOf(DataLoaderHelper.getDataLoader().isRunning() ? 1 : 0), Integer.valueOf(this.mFallbackApiRetry)));
                }
                this.mLogger.setIntOption(142, 2);
            }
        }
        String currentURL = this.mURLInfo.getCurrentURL();
        if ((error.domain.equals("kTTVideoErrorDomainVideoOSPlayer") || error.equals("kTTVideoErrorDomainVideoExoPlayer") || error.code == -499975) && !TextUtils.isEmpty(currentURL) && currentURL.startsWith("mdl")) {
            if (this.mIsDirectURL && this.mDirectURL.startsWith("mdl")) {
                DataLoaderHelper.getDataLoader().setIntValue(1004, -1);
                this.mDirectURL = DataLoaderHelper.getDataLoader()._getProxyUrl(this.mDirectURL);
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                    TTVideoEngineLog.i(logcatTag(), "mdl failed: mIsDirectURL: " + this.mIsDirectURL + ", mDirectUrlSrc: " + this.mDirectUrlSrc);
                }
            } else if (!TextUtils.isEmpty(currentURL) && currentURL.startsWith("mdl")) {
                DataLoaderHelper.getDataLoader().setIntValue(1004, -1);
                this.mURLInfo.setHostURL(DataLoaderHelper.getDataLoader()._getProxyUrl(currentURL));
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                    TTVideoEngineLog.i(logcatTag(), "mdl failed: urlInfo: " + currentURL);
                }
            } else if (error.domain.equals("kTTVideoErrorDomainVideoOSPlayer") || error.domain.equals("kTTVideoErrorDomainVideoExoPlayer")) {
                DataLoaderHelper.getDataLoader().setIntValue(1004, -1);
            }
        }
        this.mRetrying = true;
        if (error.domain.equals("kTTVideoErrorDomainVideoOwnPlayer")) {
            this.mRetryingNotHandleError = true;
        }
        int retryStrategy = error.getRetryStrategy();
        if (this.mConfigCenterVersion > 0) {
            str = this.mEngineConfig.getStringOption(1000);
        } else {
            str = this.mCodecType;
        }
        if (this.mConfigCenterVersion > 0) {
            if (this.mEngineConfig.getIntOption(17) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = this.mDashEnabled;
        }
        if (this.mConfigCenterVersion > 0) {
            if (this.mEngineConfig.getIntOption(33) == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            z3 = this.mBashEnabled;
        }
        if ((str.equals("bytevc1") || str.equals("bytevc2") || z2 || z3 || this.mHttpsEnabled) && z) {
            if (this.mConfigCenterVersion > 0) {
                this.mEngineConfig.setStringOption(1000, "h264");
            } else {
                this.mCodecType = "h264";
            }
            this.mDashEnabled = false;
            this.mEngineConfig.setIntOption(17, 0);
            this.mBashEnabled = false;
            this.mEngineConfig.setIntOption(33, 0);
            this.mEnableHttps = false;
            this.mEngineConfig.setIntOption(312, 0);
            this.mRetryEnableHttps = false;
            this.mForceCodec = "h264";
            retryStrategy = 1;
        }
        int clearByErrcode = clearByErrcode(error, z);
        if (clearByErrcode == 10) {
            return;
        }
        if (clearByErrcode != 11) {
            retryStrategy = clearByErrcode;
        }
        int i7 = error.code;
        if (i7 == -499699 || i7 == -499698) {
            if (getConfigInt(37, this.mDrmRetry ? 1 : 0) != 1) {
                _notifyError(error);
                return;
            } else {
                this.mDrmType = 0;
                this.mEngineConfig.setIntOption(34, 0);
                retryStrategy = 3;
            }
        }
        if (this.mErrorCount == 2) {
            if (this.mPlayAPIVersion == 2 && !TextUtils.isEmpty(this.mAuthorization)) {
                this.mPlayAPIVersion = 1;
            }
            retryStrategy = 1;
        }
        if (this.mIsLocal || this.mIsDirectURL || ((z3 && this.mBashRetryRestartPlayer) || ((iVideoModel = this.mVideoModel) != null && iVideoModel.getVideoRefBool(253)))) {
            retryStrategy = 3;
        }
        if (this.mIsPlayItem) {
            this.mIsPlayItem = false;
            retryStrategy = 1;
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "retry strategy:" + retryStrategy);
        }
        if (i != this.mPlayAPIVersion && TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "APIVersion rollback from PLAY_API_VERSION_" + i + " to PLAY_API_VERSION_" + this.mPlayAPIVersion + " errorCount:" + this.mErrorCount);
        }
        if (retryStrategy == 3 && !this.mIsLocal && error.code == -2139062143) {
            this.mMediaPlayer = null;
        }
        if (this.mIsPreloaderItem) {
            if (this.mVideoModel == null) {
                VideoInfoFetcher videoInfoFetcher = this.mFetcher;
                if (videoInfoFetcher != null) {
                    videoInfoFetcher.cancel();
                }
                i4 = 1;
            }
            this.mIsPreloaderItem = false;
        } else {
            i4 = retryStrategy;
        }
        if (i4 != 0) {
            this.mLogger.movieShouldRetry(error, i4, i);
        }
        if (i4 == 1) {
            if (this.mLooperThread.checkSendMainLooper()) {
                this.mLooperThread.postMainLooperMessage(TTVideoEngineInterface.PLAYER_OPTION_ENABEL_HARDWARE_DECODE_AUDIO, 0, 0, error, this.mAPIString);
            } else {
                this.mListenerCompact.onVideoURLRouteFailed(error, this.mAPIString);
            }
        }
        _retry(i4, error);
    }

    private static class MyTextureLogListenerExt implements r.b {
        static {
            Covode.recordClassIndex(652348);
        }

        private MyTextureLogListenerExt() {
        }

        public void d(String str, String str2) {
            TTVideoEngineLog.d(str, str2);
        }

        public void e(String str, String str2) {
            TTVideoEngineLog.e(str, str2);
        }

        public void i(String str, String str2) {
            TTVideoEngineLog.i(str, str2);
        }

        public void k(String str, String str2) {
            TTVideoEngineLog.k(str, str2);
        }

        public void t(String str, String str2) {
            TTVideoEngineLog.t(str, str2);
        }

        public void w(String str, String str2) {
            TTVideoEngineLog.w(str, str2);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void onMediaPlayerSeekComplete(MediaPlayer mediaPlayer, boolean z) {
        _seekComplete(z);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setCustomHeaderSync(String str, String str2) {
        _doSetCustomHeader(str, str2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSrMaxTexureSize(int i, int i2) {
        setSrMaxTextureSize(i, i2);
    }

    private String _generatePlayUrl(String str, Map<String, String> map) {
        return _generatePlayUrl(str, map, null);
    }

    void _doSetPlayerSurface(Surface surface, int i) {
        _doSetPlayerSurfaceTimeOut(surface, i, 0);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setCacheInfoLists(String[] strArr, long[] jArr) {
        DataLoaderHelper.getDataLoader().setCacheInfoLists(strArr, jArr);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setCustomInfo(IVideoEventLogger.VideoEventCustomInfo videoEventCustomInfo, Object obj) {
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            iVideoEventLogger.setCustomInfo(videoEventCustomInfo, obj);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDirectUrlUseDataLoader(String[] strArr, String str) {
        setDirectUrlUseDataLoader(strArr, str, this.mVideoID);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setExpectedParams(Resolution resolution, Map<Integer, String> map) {
        this.expectedResolution = resolution;
        this.expectedParams = map;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setExternLogListener(ExternVideoLoggerListener externVideoLoggerListener, String str) {
        this.mExternVideoLoggerListener = externVideoLoggerListener;
        this.mExternLogKey = str;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setLoggerIntOption(int i, int i2) {
        this.mLogger.setIntOption(i, i2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setLoggerLongOption(int i, long j) {
        this.mLogger.setLongOption(i, j);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setQcomVpp(boolean z, int i) {
        this.mUseQcomVpp = z ? 1 : 0;
        this.mQcomVppLevel = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$setupTextureRender$3(VideoSurface videoSurface, Surface surface) {
        ListenerCompact listenerCompact = this.mListenerCompact;
        if (listenerCompact != null) {
            return listenerCompact.onSetSurface(this.mEngineWrapper, videoSurface, surface);
        }
        return 0;
    }

    private void setDisplayVideoSize(int i, int i2) {
        DisplayMode displayMode = this.mDisplayMode;
        if (displayMode != null && i > 0 && i2 > 0) {
            displayMode.setVideoSize(i, i2);
        }
    }

    void _doSetDirectURL(String str, String str2) {
        _doSetDirectURL(str, new String[]{str});
        this.mFileKey = str2;
    }

    void _doSetTraitObject(int i, TraitObject traitObject) {
        this.mTraitObjManager.put(i, traitObject);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            ((MediaPlayerWrapper) mediaPlayer).setTraitObject(i, traitObject);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public boolean clearSurface(Surface surface, boolean z) {
        try {
            return s.h().a(surface, z);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDirectUrlUseDataLoader(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setDirectUrlUseDataLoader(str, str2, this.mVideoID);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDisplayMode(View view, int i) {
        TTVideoEngineLog.d(logcatTag(), "setDisplayMode TOB only");
    }

    private void _parseIPAddress(IVideoModel iVideoModel, Error error) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(301, 0, 0, iVideoModel, error);
        } else {
            _doParseIPAddress(iVideoModel, error);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void notifySARChanged(int i, int i2) {
        if (this.mLooperThread.checkSendMainLooper()) {
            this.mLooperThread.postMainLooperMessage(TTVideoEngineInterface.PLAYER_OPTION_FORBID_P2P_WHEN_SEEK, i, i2, null);
        } else {
            this.mListenerCompact.onSARChanged(i, i2);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void notifyVideoSizeChanged(int i, int i2) {
        if (this.mLooperThread.checkSendMainLooper()) {
            this.mLooperThread.postMainLooperMessage(402, i, i2, null);
        } else {
            this.mListenerCompact.onVideoSizeChanged(this.mEngineWrapper, i, i2);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void onMediaPlayerBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        if (this.mIsLocal) {
            i = 100;
        }
        this.mLoadedProgress = i;
        setPlayInfo(2, i);
        notifyBufferingUpdate(i);
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setAsyncInit(boolean z, int i) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(50, z ? 1 : 0, i);
        } else {
            _doSetAsyncInit(z, i);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setCustomHeader(String str, String str2) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(57, 0, 0, str, str2);
        } else {
            _doSetCustomHeader(str, str2);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setExtraSurface(Surface surface, int i) {
        synchronized (this.mExtraSurfaceQueue) {
            this.mExtraSurfaceQueue.offer(new Pair<>(surface, Integer.valueOf(i)));
            _setExtraSurface();
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setIntOption(int i, int i2) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(101, i, i2);
        } else {
            _doSetIntOption(i, i2);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setLongOption(int i, long j) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(102, i, 0, Long.valueOf(j));
        } else {
            _doSetLongOption(i, j);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setObjectOption(int i, Object obj) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(109, i, 0, obj);
        } else {
            _doSetObjectOption(i, obj);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setStringOption(int i, String str) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(108, i, 0, str);
        } else {
            _doSetStringOption(i, str);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setTraitObject(int i, TraitObject traitObject) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE, i, 0, traitObject);
        } else {
            _doSetTraitObject(i, traitObject);
        }
    }

    private void _doExternalWindowSetSurfaceNull(MediaPlayer mediaPlayer, boolean z) {
        if (this.mIsNewPlayerViewUsedExternal && mediaPlayer != null) {
            mediaPlayer.setSurfaceTimeOut(null, 0);
        }
        if (!z) {
            VideoSurface videoSurface = this.mTextureSurface;
            s sVar = this.mTextureRenderer;
            if (videoSurface != null && sVar != null) {
                int intOption = videoSurface.getIntOption(9);
                videoSurface.setIntOption(9, 1);
                videoSurface.updateRenderSurface((Surface) null);
                videoSurface.setIntOption(9, intOption);
            }
        }
    }

    private void _selectTrack(int i, int i2) {
        MediaPlayer.TrackInfo[] trackInfo;
        int i3;
        int i4;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || (trackInfo = mediaPlayer.getTrackInfo()) == null) {
            return;
        }
        if (i2 == VideoRef.TYPE_VIDEO) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        int length = trackInfo.length;
        int i5 = 0;
        while (true) {
            if (i5 < length) {
                MediaPlayer.TrackInfo trackInfo2 = trackInfo[i5];
                if (trackInfo2.getTrackType() == i3) {
                    MediaFormat format = trackInfo2.getFormat();
                    if (format.getInteger("bitrate") == i) {
                        i4 = format.getInteger("track-id");
                        break;
                    }
                }
                i5++;
            } else {
                i4 = -1;
                break;
            }
        }
        if (i4 != -1) {
            this.mMediaPlayer.selectTrack(i4);
        }
    }

    private void _updateCurrentPlaybackPosition(int i, boolean z) {
        if (getConfigInt(602, this.mPosUpdateInterval) > 0 && this.mCurPosition != i && i >= 0) {
            this.mCurPosition = i;
            ListenerCompact listenerCompact = this.mListenerCompact;
            if (z && listenerCompact != null) {
                if (this.mLooperThread.checkSendMainLooper()) {
                    this.mLooperThread.postMainLooperMessage(425, i, 0, null);
                } else {
                    listenerCompact.onCurrentPlaybackTimeUpdate(this.mEngineWrapper, i);
                }
            }
        }
    }

    private String[] addMdlFlag(String[] strArr, String str) {
        if (getConfigInt(302, this.mForbidP2P) == 0) {
            return strArr;
        }
        for (int i = 0; i < strArr.length; i++) {
            if (!TextUtils.isEmpty(strArr[i])) {
                strArr[i] = TTHelper.appendQueryString(strArr[i], "p2p=0");
            }
        }
        return strArr;
    }

    private boolean isSupportFileCache(String str, IVideoModel iVideoModel) {
        if (iVideoModel != null && (iVideoModel.hasFormat(IVideoModel.Format.DASH) || iVideoModel.getSource() == IVideoModel.Source.LIVE)) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            if (FormatProvider.FormatProviderHolder.isM3u8(str) || FormatProvider.FormatProviderHolder.isMpd(str)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public int TTVideoEngineImpl__clearByErrcode$___twin___(Error error, boolean z) {
        switch (error.code) {
            case -1094995529:
            case -499985:
            case -499978:
            case -499977:
                if (getConfigInt(603, this.mEnableClearMDLCache) > 0) {
                    clearMdlCache();
                }
                return 11;
            case -499972:
            case -499970:
                return clearHijackIpCacheByErrcode(error, z);
            default:
                return 11;
        }
    }

    void _doSetCustomHeader(String str, String str2) {
        Map<String, String> map;
        if (!TextUtils.isEmpty(str) && (map = this.mHeaders) != null) {
            map.put(str.substring(0, 1).toUpperCase() + str.substring(1), str2);
            if (TTVideoEngine.sDetectPrivateField) {
                this.mLogger.setPrivateFieldFlag(this.mHeaders);
            }
        }
    }

    void _doSetSurfaceTimeOut(Surface surface, int i) {
        IVideoEventLogger iVideoEventLogger;
        this.mSurface = surface;
        if (surface != null && (iVideoEventLogger = this.mLogger) != null && !this.mHasFirstFrameShown) {
            iVideoEventLogger.setSurface(surface.toString());
        }
        MediaPlayer mediaPlayer = this.mAsyncPlayer;
        if (mediaPlayer == null) {
            mediaPlayer = this.mMediaPlayer;
        }
        if (mediaPlayer != null) {
            setSurfaceHookTimeOut(this.mSurface, i);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void configParams(Resolution resolution, Map<Integer, String> map) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "configParams res:" + resolution + ", params:" + map);
        }
        if (resolution == null) {
            return;
        }
        _configResolution(resolution, map);
    }

    protected void notifyEngineInfo(VideoEngineInfos videoEngineInfos, boolean z) {
        if (this.mListenerCompact.getVideoEngineInfoListener() == null) {
            return;
        }
        if (this.mLooperThread.checkSendMainLooper()) {
            if (z) {
                this.mLooperThread.postMainLooperMessage(TTVideoEngineInterface.PLAYER_OPTION_USE_AJ_MEDIACODEC, 0, 0, videoEngineInfos);
                return;
            } else {
                this.mLooperThread.postEngineMessage(TTVideoEngineInterface.PLAYER_OPTION_USE_AJ_MEDIACODEC, 0, 0, videoEngineInfos);
                return;
            }
        }
        this.mListenerCompact.onVideoEngineInfos(videoEngineInfos);
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void seekTo(int i, SeekCompletionListener seekCompletionListener) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "seek to time:" + i);
        }
        this.mSeekCompletionListener = seekCompletionListener;
        if (this.mMediaPlayer != null && this.mStarted) {
            _updateCurrentPlaybackPosition(i, false);
        }
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(7, i);
        } else {
            _seekTo(i, false);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setAutoRangeRead(int i, int i2) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "set auto range read = " + i + ", " + i2);
        }
        this.mReadCacheMode = i;
        this.mAutoRangeOffset = i2;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setBarrageMaskUrlUseDataLoader(String str, String str2) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "setBarrageMaskUrl " + str);
        }
        this.mBarrageMaskUrl = str;
        this.mMaskFileHash = str2;
        StrategyHelper.buildMaskInfo(this.mMediaInfoMap, str, str2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setBufferThresholdControl(int i, int i2) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "setBufferThresholdControl= " + i + ", " + i2);
        }
        if (i > 0 && i2 > 0) {
            if (DataLoaderHelper.getDataLoader().getIntValue(1150) == 1) {
                i = 0;
                i2 = 0;
            }
            this.mDangerBufferThreshold = i;
            this.mSecureBufferThreshold = i2;
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDirectURL(String str, String str2) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(19, 0, 0, str, str2);
        } else {
            _doSetDirectURL(str, str2);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDirectUrlUseDataLoaderByFilePath(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(21, 0, 0, str, str2);
        } else {
            setDirectUrlUseDataLoaderByFilePath(new String[]{str}, str2);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setGearStrategyListener(IGearStrategyListener iGearStrategyListener, Object obj) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "[GearStrategy]setGearStrategyListener listener=" + iGearStrategyListener + " userData=" + obj);
        }
        this.mGearStrategyConfig.setGearStrategyListener(iGearStrategyListener).setUserData(obj);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setPlayAPIVersion(int i, String str) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "setPlayAPIVersion:" + i);
        }
        this.mPlayAPIVersion = i;
        this.mAuthorization = str;
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            iVideoEventLogger.setPlayAPIVersion(i, str);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSrMaxTextureSize(int i, int i2) {
        this.mMaxTextureWidth = i;
        this.mMaxTextureHeight = i2;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "[SRLog]setSrMaxTextureSize:" + this.mMaxTextureWidth + "," + this.mMaxTextureHeight);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setTestSpeedEnable(int i, TestNetSpeedListener testNetSpeedListener) {
        if (!FeatureManager.hasPermission("net_speed")) {
            return;
        }
        this.mTestNetSpeed = i;
        this.mTestNetSpeedListener = testNetSpeedListener;
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(52, i);
        } else {
            _doSetTestSpeedEnable(i);
        }
    }

    private void _isEnableEffect(int i, int i2) {
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface != null) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d(logcatTag(), "_isEnableEffect:" + i2 + ",type:" + i);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("action", 19);
            bundle.putInt("effect_type", i);
            bundle.putInt("int_value", i2);
            videoSurface.setEffect(bundle);
        }
    }

    private boolean _isUrlExpired(VideoInfo videoInfo, IVideoModel iVideoModel) {
        if (videoInfo == null || iVideoModel == null || getConfigInt(450, this.mAllowedExpiredModel ? 1 : 0) > 0) {
            return false;
        }
        if (iVideoModel.getVideoRefLong(220) > 0 && TimeService.isUpdated() && TimeService.currentTimeMillis() - (iVideoModel.getVideoRefLong(220) * 1000) > -30000) {
            return true;
        }
        if (videoInfo.getValueLong(30) <= 0 || !TimeService.isUpdated() || TimeService.currentTimeMillis() - (videoInfo.getValueLong(30) * 1000) <= -30000) {
            return false;
        }
        return true;
    }

    private void _playVideo(String str, String str2) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "start to play video, host:" + str + ", ip:" + str2);
        }
        if (this.mShouldStop) {
            TTVideoEngineLog.w(logcatTag(), "_playVideo should stop");
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.mURLInfo.setIpURL(str2);
            if (!TextUtils.isEmpty(str)) {
                this.currentHost = str;
                this.mHeaders.put("Host", String.format(" %s", str));
            }
            _playInternal(this.mURLInfo.ipURL, this.mHeaders);
            return;
        }
        _playInternal(this.mURLInfo.hostURL, this.mHeaders);
    }

    private void _setHDRInfoToTexturerender(MediaPlayer mediaPlayer, int i) {
        boolean z;
        VideoSurface videoSurface = this.mTextureSurface;
        if (mediaPlayer != null && videoSurface != null) {
            videoSurface.setIntOption(8, i);
            if (TTVideoEngineConfig.setEGLBitDepth > 8) {
                int intOption = mediaPlayer.getIntOption(1082, -1);
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(logcatTag(), "bitDepth:" + intOption);
                }
                videoSurface.setIntOption(130, intOption);
            }
            if (getConfigInt(652, this.mRenderHDR2SDR) == 1) {
                if (i != 1 && i != 2) {
                    z = false;
                } else {
                    z = true;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("effect_type", 4);
                if (z) {
                    bundle.putInt("action", 21);
                    bundle.putInt("hdr_type", i);
                    bundle.putInt("use_effect", 1);
                } else {
                    bundle.putInt("action", 19);
                    bundle.putInt("use_effect", 0);
                }
                videoSurface.setEffect(bundle);
            }
        }
    }

    private void _singleURLParseAndPlay(String str, Map<String, String> map) {
        this.mURLInfo.setHostURL(str);
        boolean _isDashSource = _isDashSource(str);
        this.mIsDashSource = _isDashSource;
        this.mDashEnabled = _isDashSource;
        this.mEngineConfig.setIntOption(17, _isDashSource ? 1 : 0);
        if (!_usePlayerDNS(true) && !this.mIsLocal) {
            if (TTHelper.isIP(str)) {
                _playInternal(str, map);
                return;
            }
            if (str.indexOf("http") == 0) {
                this.urlIPMap.put(this.mURLInfo.hostURL, new IpInfo("", "", getConfigInt(18, this.mUseDNSCache ? 1 : 0), getConfigInt(403, this.mIsUseServerDns ? 1 : 0), "single"));
                this.mURLs = new String[]{str};
                _updateVU();
                _parseDNS(str);
                return;
            }
            _playInternal(str, map);
            return;
        }
        _playInternal(str, map);
    }

    private boolean doOpenSR(int i, int i2) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "[SRLog]doOpenSR open=" + i + " reason=" + i2 + " mTextureSurface=" + this.mTextureSurface + " mHasFirstFrameShown=" + this.mHasFirstFrameShown);
        }
        this.mTextureSrOpen = i;
        if (i == 0) {
            this.mSRNotUseReason = i2;
        }
        VideoSurface videoSurface = this.mTextureSurface;
        boolean z = false;
        if (videoSurface == null) {
            return false;
        }
        try {
            if (1 == i) {
                if (!this.mHasFirstFrameShown) {
                    return false;
                }
                videoSurface.setSuperResolutionMode(i);
            } else {
                videoSurface.setSuperResolutionMode(i);
            }
            z = true;
            return true;
        } catch (Exception e) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "[SRLog]doOpenSR catch exception e=" + e);
                return z;
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doSetDisplayMode, reason: merged with bridge method [inline-methods] */
    public void lambda$setDisplayMode$1(View view, int i) {
        int i2 = 1;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "setDisplayMode " + i);
        }
        if (!this.mUseEngineDisplayMode) {
            i2 = i;
        }
        _doSetIntOption(4, i2);
        DisplayMode displayMode = this.mDisplayMode;
        if (displayMode != null) {
            displayMode.setDisplayView(view);
            displayMode.setDisplayMode(i);
            if (this.mFixSetDisplayModeSARBug && isPrepared()) {
                setDisplayVideoSize(getVideoWidth(), getVideoHeight());
            }
        }
    }

    private void mergeMediaExtraInfo(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        float f;
        JSONObject optJSONObject;
        if (jSONObject != null && jSONObject2 != null) {
            Boolean bool = Boolean.FALSE;
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.get(next));
                bool = Boolean.TRUE;
            }
            if (!jSONObject.has("volume_loudness") && this.mVolumeInfoJson != null) {
                try {
                    JSONObject jSONObject3 = new JSONObject(this.mVolumeInfoJson);
                    String optString = jSONObject3.optString("Loudness");
                    if (optString != null) {
                        f = Float.parseFloat(optString);
                    } else {
                        f = 0.0f;
                    }
                    JSONObject optJSONObject2 = jSONObject3.optJSONObject("Metrics");
                    if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("Loudness")) != null) {
                        optJSONObject.optString("Integrated");
                        f = Float.parseFloat(optString);
                    }
                    jSONObject.put("volume_loudness", f);
                    bool = Boolean.TRUE;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bool.booleanValue()) {
                jSONObject.put("mark_flags", 8);
            }
        }
    }

    void _doSetAsyncInit(boolean z, int i) {
        MediaPlayer mediaPlayer = this.mAsyncPlayer;
        if (mediaPlayer == null) {
            mediaPlayer = this.mMediaPlayer;
        }
        this.mAsyncInitEnable = z ? 1 : 0;
        if (this.mVideoModel != null) {
            i = -1;
        }
        this.mCodecId = i;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "setAsyncInit enable:" + this.mAsyncInitEnable + " codecid:" + this.mCodecId);
        }
        if (mediaPlayer != null && this.mHardwareDecodeEnablePlayer2 == 1) {
            mediaPlayer.setIntOption(181, this.mAsyncInitEnable);
            mediaPlayer.setIntOption(182, this.mCodecId);
            this.mLogger.useAsyncInit(this.mAsyncInitEnable, this.mCodecId);
        }
    }

    void _doSetDirectURL(String str, String[] strArr) {
        if (((!Arrays.equals(this.mOriginalUrls, strArr)) && (!TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 1L) || this.mEngineHasUsed)) || this.mForceShutDownOldSource == 1) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "set direct url:" + str);
            }
            _ShutdownOldSource();
            this.mState = 0;
            this.mFirstURL = true;
            this.mFirstIP = true;
            this.mFirstHost = true;
            this.mUserStopped = false;
            this.mLastPlaybackTime = 0;
            this.mAPIString = null;
        }
        this.mEngineHasUsed = true;
        this.mStarted = false;
        this.mIsDirectURL = true;
        this.mDirectURL = str;
        this.mDirectUrlSrc = str;
        this.mOriginalUrls = strArr;
        this.mBufferingStartT = 0L;
        this.mFileKey = null;
        Resolution resolution = Resolution.Undefine;
        this.currentResolution = resolution;
        this.mLogger.configResolution(_resolutionToString(resolution), "");
        this.mLogger.setSourceType(1, "");
    }

    void _doSetLongOption(int i, long j) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "set long option key:" + i + ",value:" + j);
        }
        if (ConfigItemFactory.isCommonPlayerOption(i)) {
            this.mOptionHolder.setLongOption(i, j);
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setLongOption(i, j);
            }
        }
        if (i != 440) {
            if (i != 709) {
                if (i != 725) {
                    super.setLongOption(i, j);
                    return;
                }
                IVideoEventLogger iVideoEventLogger = this.mLogger;
                if (iVideoEventLogger != null) {
                    iVideoEventLogger.setVrHeadMovementDelay(j);
                    return;
                }
                return;
            }
            this.mPrecisePausePts = j;
            MediaPlayer mediaPlayer2 = this.mMediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setLongOption(668, j);
                return;
            }
            return;
        }
        if (j > 0) {
            NativeAudioProcessor nativeAudioProcessor = new NativeAudioProcessor();
            this.mAudioProcessor = nativeAudioProcessor;
            nativeAudioProcessor.setNativeWrapper(j);
            MediaPlayer mediaPlayer3 = this.mMediaPlayer;
            if (mediaPlayer3 != null) {
                ((MediaPlayerWrapper) mediaPlayer3).setAudioProcessor(this.mAudioProcessor);
            }
        }
    }

    void _doSetObjectOption(int i, Object obj) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "set object option key:" + i + ",value:" + obj);
        }
        if (i == 441 && obj != null && (obj instanceof AudioProcessor)) {
            AudioProcessor audioProcessor = (AudioProcessor) obj;
            this.mAudioProcessor = audioProcessor;
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                ((MediaPlayerWrapper) mediaPlayer).setAudioProcessor(audioProcessor);
                if (this.mAudioProcessor == null && this.mEnableCheckUnbindAudioProcessor > 0) {
                    _doUnbindAudioProcessor();
                }
            }
        }
    }

    void _seekTo(int i, boolean z) {
        int _getPlayerTime;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "_seekTo:" + i);
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && this.mStarted) {
            if (z) {
                _getPlayerTime = this.mLastPlaybackTime;
            } else {
                _getPlayerTime = _getPlayerTime();
            }
            this.mSeeking = true;
            this.mSeekingStartTime = SystemClock.currentThreadTimeMillis();
            this.mLastPlaybackTime = i;
            setPlayInfo(6, 1L);
            if (this.mSeekMode != 0 && isPlayerSupportSeekMode()) {
                if (mediaPlayer instanceof MediaPlayerWrapper) {
                    ((MediaPlayerWrapper) mediaPlayer).seekTo(i, this.mSeekMode);
                }
            } else {
                mediaPlayer.seekTo(i);
            }
            setPlayInfo(1, i);
            VideoSurface videoSurface = this.mTextureSurface;
            if (videoSurface != null) {
                videoSurface.setIntOption(33, 0);
            }
            this.mLogger.seekTo(_getPlayerTime, i, z);
            return;
        }
        _seekComplete(false);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void openTextureSR(boolean z, boolean z2) {
        int i;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "[SRLog]openTextureSR =  sr = " + z + ", open =" + z2 + " srStrategyMode=" + this.mSRStrategy.getSRStrategyMode());
        }
        if (!FeatureManager.hasPermission("super_resolution") || this.mSRStrategy.getSRStrategyMode() == 0) {
            return;
        }
        this.mSRStrategy.setSRStrategyMode(1);
        this.mUseSRTexture = z;
        this.mTextureSrOpen = z2 ? 1 : 0;
        if (z && z2) {
            i = 0;
        } else {
            i = -7890;
        }
        if (this.mDynamicControlSR) {
            doOpenSR(z2 ? 1 : 0, i);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setPlayAuthToken(String str, int i) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "setPlayAPIVersion:" + i);
        }
        this.mPlayAPIVersion = i;
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            iVideoEventLogger.setPlayAPIVersion(i, str);
        }
        String base64Decode = TTHelper.base64Decode(str);
        if (!TextUtils.isEmpty(base64Decode)) {
            try {
                String optString = new JSONObject(base64Decode).optString("GetPlayInfoToken");
                this.mAuthorization = optString;
                if (TextUtils.isEmpty(optString)) {
                    this.mAuthorization = base64Decode;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                this.mAuthorization = base64Decode;
            }
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSurfaceHolder(SurfaceHolder surfaceHolder, boolean z) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "setSurfaceHolder = " + surfaceHolder + ", this:" + this);
        }
        if (surfaceHolder == null) {
            this.mLastSetSurfaceNullTime = System.currentTimeMillis();
        }
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(55, z ? 1 : 0, 0, surfaceHolder);
        } else {
            _doSetSurfaceHolder(surfaceHolder, z);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSurfaceSync(Surface surface, long j) {
        if (j < 0) {
            j = 0;
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "setSurfaceSync = " + surface + ",timeout:" + j + "this:" + this + ",setSurfaceDirectly:" + this.mSetSurfaceDirectly);
        }
        if (this.mSetSurfaceDirectly > 0) {
            MediaPlayer mediaPlayer = this.mAsyncPlayer;
            if (mediaPlayer == null) {
                mediaPlayer = this.mMediaPlayer;
            }
            if (mediaPlayer != null && mediaPlayer.getPlayerType() == 1) {
                if (surface == null) {
                    this.mLastSetSurfaceNullTime = System.currentTimeMillis();
                }
                _doSetSurfaceTimeOut(surface, (int) j);
                return;
            }
        }
        _setSurfaceSync(surface, j, true);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setVolume(float f, float f2) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "setVolume left:" + f + " right:" + f2);
        }
        this.mLeftVolume = f;
        this.mRightVolume = f2;
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(9, 0, 0, Float.valueOf(f), Float.valueOf(f2));
        } else {
            setPlayerVolume(f, f2);
        }
    }

    private void _retry(int i, Error error) {
        String str;
        String str2;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 12 && !this.mCodecStrategyAdapter.interceptFallbackRetry(error)) {
                            _notifyError(error);
                            return;
                        }
                        return;
                    }
                    MediaPlayer mediaPlayer = this.mMediaPlayer;
                    if (mediaPlayer != null && mediaPlayer.getPlayerType() == 1 && getConfigInt(1130, this.mEngineRetryNotify) == 1) {
                        this.mMediaPlayer.setIntOption(1349, 1);
                    }
                    boolean z = this.mIsLocal;
                    if (!z && !this.mIsDirectURL) {
                        boolean z2 = this.mIsPreloaderItem;
                        if (!z2 && !this.mIsPlayItem) {
                            _playInternal(this.mURLInfo.getCurrentURL(), this.mHeaders);
                            return;
                        }
                        if (z2) {
                            str2 = this.mPreloaderItem.mUrl;
                        } else {
                            str2 = this.mPlayItem.playURL;
                        }
                        _singleURLParseAndPlay(str2, this.mHeaders);
                        return;
                    }
                    if (z) {
                        str = this.mLocalURL;
                    } else {
                        str = this.mDirectURL;
                    }
                    _singleURLParseAndPlay(str, this.mHeaders);
                    return;
                }
                MediaPlayer mediaPlayer2 = this.mMediaPlayer;
                if (mediaPlayer2 != null && mediaPlayer2.getPlayerType() == 1 && getConfigInt(1130, this.mEngineRetryNotify) == 1) {
                    this.mMediaPlayer.setIntOption(1349, 1);
                }
                _tryNextURL(error);
                return;
            }
            resetFallbackApi(error);
            MediaPlayer mediaPlayer3 = this.mMediaPlayer;
            if (mediaPlayer3 != null && mediaPlayer3.getPlayerType() == 1 && getConfigInt(1130, this.mEngineRetryNotify) == 1) {
                this.mMediaPlayer.setIntOption(1349, 1);
            }
            _fetchVideoInfo();
            return;
        }
        _notifyError(error);
    }

    private void setMediaBuffer2Abr(rs1.g gVar, IVideoModel iVideoModel) {
        List<VideoInfo> videoInfoList;
        long cacheFileSize;
        if (iVideoModel != null) {
            if ((this.mStandAlongAbrStartUp != 0 || this.mEnableABR != 0) && (videoInfoList = iVideoModel.getVideoInfoList()) != null && videoInfoList.size() != 0) {
                for (VideoInfo videoInfo : videoInfoList) {
                    if (videoInfo != null) {
                        String valueStr = videoInfo.getValueStr(15);
                        if (getConfigInt(584, this.mQuickGetFileCache ? 1 : 0) == 1) {
                            cacheFileSize = TTVideoEngine.quickGetCacheFileSize(valueStr);
                        } else {
                            cacheFileSize = TTVideoEngine.getCacheFileSize(valueStr);
                        }
                        gVar.d(videoInfo.getMediatype(), valueStr, videoInfo.getValueInt(3), cacheFileSize, videoInfo.getValueInt(38));
                    }
                }
                gVar.h(34, getConfigInt(334, this.mScreenWidth));
                gVar.h(35, getConfigInt(335, this.mScreenHeight));
                gVar.h(6, this.mPlayerViewWidth);
                gVar.h(7, this.mPlayerViewHeight);
                gVar.j(75, this.mTag);
                gVar.j(76, this.mSubTag);
                JSONObject vodJsonObject = SettingsHelper.helper().getVodJsonObject("abr_params");
                if (vodJsonObject != null) {
                    this.mAbrUserQualitySensitivity = (float) vodJsonObject.optDouble("user_quality_sensitivity");
                    this.mAbrUserEnterFullScreen = vodJsonObject.optInt("user_enter_full_screen");
                    gVar.m(72, this.mAbrUserQualitySensitivity);
                    gVar.h(73, this.mAbrUserEnterFullScreen);
                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                        TTVideoEngineLog.i(logcatTag(), "standalong abr start up set mAbrUserQualitySensitivity=" + this.mAbrUserQualitySensitivity + " mAbrUserEnterFullScreen=" + this.mAbrUserEnterFullScreen);
                    }
                }
            }
        }
    }

    private void setSurfaceHookTimeOut(Surface surface, int i) {
        MediaPlayer mediaPlayer = this.mAsyncPlayer;
        if (mediaPlayer == null) {
            mediaPlayer = this.mMediaPlayer;
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "setSurfaceHook, player:" + mediaPlayer + ", surface:" + surface + ", texturesurface:" + this.mTextureSurface + ", this:" + this + ", timeoutMs:" + i);
        }
        if (this.mEnableSurfaceHashmapJudgement > 0) {
            _judgeSurfaceHashMap(surface);
        }
        if (mediaPlayer != null) {
            this.mLogger.setSurfaceSourceType("external");
            this.mLogger.setSurfaceBegin();
            if ((getConfigInt(TTVideoEngineInterface.PLAYER_OPTION_OPEN_TEXTUER_AFTER_FIRST_FRAME, this.mFirstFrameOpenTexture) == 1 && this.mSurfaceHolder == null && !this.mPlayerFirstFrame) || (getConfigInt(587, this.mEnableForceDisableOESRender ? 1 : 0) == 1 && getConfigInt(588, this.mForceDisableOESRender ? 1 : 0) == 1)) {
                _doSetPlayerSurfaceTimeOut(surface, 1, i);
            } else {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                    String logcatTag = logcatTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("set surface to player = ");
                    Surface surface2 = this.mTextureSurface;
                    if (surface2 == null) {
                        surface2 = surface;
                    }
                    sb.append(surface2);
                    TTVideoEngineLog.i(logcatTag, sb.toString());
                }
                Surface surface3 = this.mTextureSurface;
                if (surface3 == null) {
                    surface3 = surface;
                }
                _doSetPlayerSurfaceTimeOut(surface3, 0, i);
                VideoSurface videoSurface = this.mTextureSurface;
                if (videoSurface != null && this.mTextureRenderer != null) {
                    videoSurface.updateRenderSurface(surface);
                    this.mLogger.useTextureRender(1);
                }
            }
            if (this.mEnableSurfaceHashmapJudgement > 0 && surface != null) {
                this.mSurfaceRecord = surface;
            }
            this.mLogger.setSurfaceEnd();
        }
    }

    void _configResolution(Resolution resolution, Map<Integer, String> map) {
        IVideoModel iVideoModel;
        IVideoInfo selectBitrate;
        int i;
        int i2;
        boolean z;
        Map<Integer, String> map2;
        Resolution resolution2 = Resolution.Auto;
        if (resolution == resolution2 && !FeatureManager.hasPermission("abr")) {
            return;
        }
        if (this.mSRStrategy.getSRStrategyMode() == 0 && this.mHasFirstFrameShown) {
            VideoSurface videoSurface = this.mTextureSurface;
            if (videoSurface != null) {
                i2 = videoSurface.getIntOption(6);
            } else {
                i2 = 0;
            }
            if (this.currentResolution == resolution && (((map2 = this.currentParams) == null && map == null) || (map2 != null && map2.equals(map)))) {
                z = false;
            } else {
                z = true;
            }
            if (true == z || 1 == i2) {
                this.mSRStrategy.updateConfig(SRStrategyConfig.newConfig().resolutionChanged(true));
                this.mTextureSrOpen = 0;
                this.mSRNotUseReason = -7879;
                doOpenSR(0, -7879);
            }
        }
        if (getConfigInt(503, this.mABRSwitchMode) == 0) {
            if (resolution == resolution2 && this.mEnableGearStrategyV2 == 0) {
                i = 1;
            } else {
                i = 0;
            }
            setIntOption(494, i);
        }
        if (resolution == resolution2 && this.mEnableGearStrategyV2 == 1 && (iVideoModel = this.mVideoModel) != null && (selectBitrate = GearStrategySC.selectBitrate(iVideoModel, 1, this.mGearStrategyExtraParams, null)) != null) {
            resolution = selectBitrate.getResolution();
            this.currentResolution = resolution;
            this.currentParams = TTVideoEngineHelper.paramsFromVideoInfo(selectBitrate);
        }
        Resolution resolution3 = resolution;
        if (resolution3 != resolution2) {
            int i3 = this.mState;
            if (i3 != 0 && i3 != 1 && !this.mIsPlayComplete) {
                if (i3 == 3) {
                    if (this.mLooperThread.checkEngineLooperThread(false)) {
                        this.mLooperThread.postEngineMessage(8, 0, 0, resolution3, map);
                        return;
                    } else {
                        _switchToResolution(resolution3, map);
                        return;
                    }
                }
                return;
            }
            this.lastResolution = resolution3;
            this.currentResolution = resolution3;
            this.currentParams = map;
            if (TextUtils.isEmpty(this.mDirectURL) && TextUtils.isEmpty(this.mLocalURL)) {
                this.mLogger.configResolution(_resolutionToString(resolution3), _resolutionToString(resolution3));
            }
        }
    }

    void _doSetStringOption(int i, String str) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "set string option key:" + i + " value:" + str);
        }
        if (ConfigItemFactory.isCommonPlayerOption(i)) {
            this.mOptionHolder.setStringOption(i, str);
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setStringOption(i, str);
            }
        }
        if (i != 355) {
            if (i != 549) {
                if (i != 659) {
                    if (i != 662) {
                        if (i != 715) {
                            if (i != 957) {
                                if (i != 1000) {
                                    if (i != 1415) {
                                        if (i != 360) {
                                            if (i != 361) {
                                                if (i != 531) {
                                                    if (i != 532) {
                                                        switch (i) {
                                                            case 538:
                                                                this.mABR4GMaxResolutionQuality = str;
                                                                break;
                                                            case 539:
                                                                this.mWifiDefaultResolutionQuality = str;
                                                                break;
                                                            case 540:
                                                                this.mStartupMaxBitRateQuality = str;
                                                                break;
                                                            default:
                                                                switch (i) {
                                                                    case 545:
                                                                        this.mDowngradeResolutionQuality = str;
                                                                        break;
                                                                    case 546:
                                                                        this.mSubIds = str;
                                                                        break;
                                                                    case 547:
                                                                        this.mSubFormat = str;
                                                                        break;
                                                                    default:
                                                                        switch (i) {
                                                                            case 1410:
                                                                                this.mPlayLoadConfig = str;
                                                                                break;
                                                                            case 1411:
                                                                                this.mPlayRangeConfig = str;
                                                                                break;
                                                                            case 1412:
                                                                                this.mPlayBufferConfig = str;
                                                                                break;
                                                                            default:
                                                                                super.setStringOption(i, str);
                                                                                break;
                                                                        }
                                                                }
                                                        }
                                                    }
                                                    this.mSubLanIds = str;
                                                    return;
                                                }
                                                this.mSubHostName = str;
                                                return;
                                            }
                                            this.mAEGraphConfig = str;
                                            return;
                                        }
                                        this.mVolumeInfoJson = str;
                                        return;
                                    }
                                    this.mFormatType = str;
                                    return;
                                }
                                this.mSettedKeys.add(Integer.valueOf(i));
                                this.mCodecType = str;
                                return;
                            }
                            if (!this.mPrivCodecName.contains(str)) {
                                this.mPrivCodecName.add(str);
                                return;
                            }
                            return;
                        }
                        this.mLogger.setStringOption(113, str);
                        return;
                    }
                    this.mCheckInfoString = str;
                    return;
                }
                this.mClassLoaderState = str;
                return;
            }
            this.mSubVersions = str;
            return;
        }
        this.mAEConfigJson = str;
        MediaPlayer mediaPlayer2 = this.mMediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.setStringOption(1158, str);
        }
    }

    void _doSetSurfaceHolder(SurfaceHolder surfaceHolder, boolean z) {
        IPlayDurationManager iPlayDurationManager;
        if (z && (iPlayDurationManager = this.mPlayDuration) != null) {
            iPlayDurationManager.stop();
        }
        SurfaceHolder surfaceHolder2 = this.mSurfaceHolder;
        TTVideoEngineSurfaceCallback tTVideoEngineSurfaceCallback = this.mSurfaceCallback;
        if (tTVideoEngineSurfaceCallback != null && surfaceHolder2 != null) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d(logcatTag(), "remove callback:" + this.mSurfaceCallback + ", surfaceholder:" + surfaceHolder + ", mSurface:" + this.mSurface + ", mSurfaceHolder:" + this.mSurfaceHolder);
            }
            tTVideoEngineSurfaceCallback.reset();
            surfaceHolder2.removeCallback(tTVideoEngineSurfaceCallback);
            this.mSurfaceCallback = null;
        }
        this.mSurfaceHolder = surfaceHolder;
        if (getConfigInt(951, this.mSurfaceHolderByKernel) != 0) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                this.mLogger.setSurfaceSourceType("external");
                this.mLogger.setSurfaceBegin();
                mediaPlayer.setDisplay(surfaceHolder);
                this.mLogger.setSurfaceEnd();
                if (surfaceHolder != null) {
                    this.mLogger.setSurface(surfaceHolder.toString());
                    return;
                }
                return;
            }
            return;
        }
        if (surfaceHolder == null) {
            setSurfaceHook(null);
            return;
        }
        Surface surface = surfaceHolder.getSurface();
        addSurfaceCallback(surfaceHolder);
        setSurfaceHook(surface);
        if (surface != null) {
            this.mLogger.setSurface("SurfaceHolderWithSurface@" + surface.toString());
        }
        setSurfaceDimensionsToTextureRender();
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public ArrayList<HashMap<String, Object>> crosstalkHappen(ArrayList<TTVideoEngine> arrayList, HashMap<String, TTVideoEngineMonitor.TTVideoEngineLivePlayerInfo> hashMap) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList<HashMap<String, Object>> arrayList3 = new ArrayList<>();
        boolean z = false;
        HashMap<String, Object> generateCrosstalkMap = generateCrosstalkMap(this.mTag, this.mSubTag, 0, null);
        arrayList3.add(generateCrosstalkMap);
        String generateCrosstalkStr = generateCrosstalkStr(generateCrosstalkMap);
        if (!TextUtils.isEmpty(generateCrosstalkStr)) {
            arrayList2.add(generateCrosstalkStr);
        }
        Iterator<TTVideoEngine> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            TTVideoEngine next = it2.next();
            if (!next.equals(this.mEngineWrapper)) {
                HashMap<String, Object> generateCrosstalkMap2 = generateCrosstalkMap(next.getTag(), next.getSubTag(), 0, null);
                arrayList3.add(generateCrosstalkMap2);
                String generateCrosstalkStr2 = generateCrosstalkStr(generateCrosstalkMap2);
                if (!TextUtils.isEmpty(generateCrosstalkStr2)) {
                    arrayList2.add(generateCrosstalkStr2);
                }
            }
        }
        if (hashMap != null && hashMap.size() > 0) {
            Iterator<String> it4 = hashMap.keySet().iterator();
            while (true) {
                z = true;
                if (!it4.hasNext()) {
                    break;
                }
                String next2 = it4.next();
                TTVideoEngineMonitor.TTVideoEngineLivePlayerInfo tTVideoEngineLivePlayerInfo = hashMap.get(next2);
                if (tTVideoEngineLivePlayerInfo != null) {
                    String generateCrosstalkStr3 = generateCrosstalkStr(generateCrosstalkMap(tTVideoEngineLivePlayerInfo.mTag, tTVideoEngineLivePlayerInfo.mSubTag, 1, next2));
                    if (!TextUtils.isEmpty(generateCrosstalkStr3)) {
                        arrayList2.add(generateCrosstalkStr3);
                    }
                }
            }
        }
        if (!z && arrayList2.size() >= 2) {
            this.mLogger.crosstalkHappen(arrayList2.size(), arrayList2);
        }
        return arrayList3;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDirectUrlUseDataLoaderByFilePath(String[] strArr, String str) {
        if (strArr != null && strArr.length != 0 && !TextUtils.isEmpty(strArr[0])) {
            this.mInitialUrlBeforeMdlProxy = strArr[0];
            if (TextUtils.isEmpty(str)) {
                setDirectURL(strArr[0]);
                this.mLogger.setIntOption(174, IVideoEventLogger.MdlInvalidCode.EmptyFilepath.ordinal());
                return;
            }
            if (getConfigInt(160, this.mDataLoaderEnable) == 0) {
                setDirectURL(strArr[0]);
                this.mLogger.setIntOption(174, IVideoEventLogger.MdlInvalidCode.OptionNotSet.ordinal());
                return;
            }
            _resetUsingDataLoaderField();
            String keyFromFilePath = TTHelper.keyFromFilePath(this.mContext, str);
            String _mdlUrl = _mdlUrl(keyFromFilePath, this.mVideoID, getConfigInt(161, this.mLimitMDLCacheSize), strArr, Resolution.Undefine, this.mDecryptionKey, null, str, null, 0L, null, -1);
            if (!this.mFileHashs.contains(keyFromFilePath)) {
                this.mFileHashs.add(keyFromFilePath);
            }
            if (TextUtils.isEmpty(_mdlUrl)) {
                setDirectURL(strArr[0]);
                return;
            } else {
                setDirectURL(_mdlUrl);
                return;
            }
        }
        TTVideoEngineLog.e(logcatTag(), "invalid urls list, it is empty");
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setPlayInfo(int i, long j) {
        int i2;
        if (getConfigInt(160, this.mDataLoaderEnable) > 0) {
            if (TextUtils.isEmpty(this.mTraceId)) {
                TTVideoEngineLog.t(logcatTag(), "trace id null, not allow setplayinfo");
                return;
            }
            switch (i) {
                case 0:
                    i2 = 22;
                    break;
                case 1:
                    i2 = 23;
                    break;
                case 2:
                    i2 = 24;
                    break;
                case 3:
                    i2 = 25;
                    break;
                case 4:
                    i2 = 26;
                    break;
                case 5:
                    MediaPlayer mediaPlayer = this.mMediaPlayer;
                    if (mediaPlayer == null) {
                        TTVideoEngineLog.t("MDL-SETPLAYINFO", "mediaplayer is null not allow set PLAY_INFO_CURRENT_BUFFER");
                        return;
                    }
                    if (j == -1) {
                        j = mediaPlayer.getLongOption(73, -1L);
                        long longOption = mediaPlayer.getLongOption(72, -1L);
                        if (j >= 0 && longOption >= 0) {
                            j = Math.min(j, longOption);
                        } else if (longOption >= 0) {
                            j = longOption;
                        }
                    }
                    i2 = 27;
                    break;
                    break;
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    i2 = 28;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            if (this.mEnableSetPlayInfoToP2P != 0 && getConfigInt(302, this.mForbidP2P) != 1) {
                DataLoaderHelper.getDataLoader().setPlayInfo(i2, this.mTraceId, this.mVideoID, j);
            } else {
                DataLoaderHelper.getDataLoader().setPlayInfoOnlyForPreload(i2, this.mTraceId, this.mVideoID, j);
            }
            if (!TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 8L) && TTVideoEngineLog.isPredicateLoglevelTurnOn(3)) {
                TTVideoEngineLog.t("MDL-SETPLAYINFO", "set play info into mdl key:" + i2 + "value:" + j + "traceid:" + this.mTraceId);
            }
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void updateLoadState(int i, int i2) {
        MediaPlayer mediaPlayer;
        IVideoEventLogger iVideoEventLogger;
        IVideoEventLogger iVideoEventLogger2;
        int i3;
        if (this.mLoadState != i) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "load state changed, prev:" + this.mLoadState + ", current:" + i);
            }
            if (i == 2) {
                if (this.mHasFirstFrameShown && !this.mSeeking && this.mLoadState != 3) {
                    int _getPlayerTime = _getPlayerTime();
                    this.mBufferingType = i2;
                    IVideoEventLogger iVideoEventLogger3 = this.mLogger;
                    if (iVideoEventLogger3 != null) {
                        iVideoEventLogger3.movieStalled(i2, _getPlayerTime);
                        i3 = this.mLogger.getMovieStalledType();
                    } else {
                        i3 = -1;
                    }
                    if (i2 == 0) {
                        setPlayInfo(3, i3);
                    }
                    this.mBufferingStartT = SystemClock.elapsedRealtime();
                }
                if (this.mHasFirstFrameShown && this.mSeeking && (iVideoEventLogger2 = this.mLogger) != null) {
                    iVideoEventLogger2.setIntOption(155, i2 + 1);
                    this.mLogger.setLoggerTimes(170);
                }
            }
            if (i == 1 && this.mHasFirstFrameShown && this.mSeeking && (iVideoEventLogger = this.mLogger) != null) {
                iVideoEventLogger.setLoggerTimes(171);
            }
            this.mLoadState = i;
            notifyLoadStateChanged(i);
            if (i == 2 && (mediaPlayer = this.mMediaPlayer) != null) {
                long longOption = mediaPlayer.getLongOption(665, 0L);
                if (longOption > 0) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("diff", Long.valueOf(longOption));
                    this.mLogger.onAVBadInterlaced(longOption);
                    if (this.mLooperThread.checkSendMainLooper()) {
                        this.mLooperThread.postMainLooperMessage(420, 0, 0, hashMap);
                    } else {
                        this.mListenerCompact.onAVBadInterlaced(hashMap);
                    }
                }
            }
        }
    }

    private void _stop(boolean z, int i) {
        IPlayDurationManager iPlayDurationManager;
        IPlayDurationManager iPlayDurationManager2;
        IPlayDurationManager iPlayDurationManager3;
        if (getConfigInt(982, this.mPlayDurationExcludePlayerMethod ? 1 : 0) == 1 && (iPlayDurationManager3 = this.mPlayDuration) != null) {
            iPlayDurationManager3.stop();
        }
        resetTexture();
        MediaPlayer mediaPlayer = this.mAsyncPlayer;
        if (mediaPlayer == null) {
            mediaPlayer = this.mMediaPlayer;
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "_stop, mState:" + this.mState + ", this:" + this);
        }
        int i2 = this.mState;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            this.mUserStopped = true;
                            VideoInfoFetcher videoInfoFetcher = this.mFetcher;
                            if (videoInfoFetcher != null) {
                                videoInfoFetcher.cancel();
                            }
                            DNSParser dNSParser = this.mDNSParser;
                            if (dNSParser != null) {
                                dNSParser.cancel();
                            }
                        }
                    } else {
                        this.mUserStopped = true;
                    }
                } else {
                    this.mUserStopped = true;
                    DNSParser dNSParser2 = this.mDNSParser;
                    if (dNSParser2 != null) {
                        dNSParser2.cancel();
                    }
                }
            } else {
                this.mUserStopped = true;
                VideoInfoFetcher videoInfoFetcher2 = this.mFetcher;
                if (videoInfoFetcher2 != null) {
                    videoInfoFetcher2.cancel();
                }
            }
        } else {
            this.mUserStopped = true;
        }
        _updateLogger();
        if (mediaPlayer != null && z && (mediaPlayer.getPlayerType() != 0 || (mediaPlayer.getPlayerType() == 0 && this.mPrepared))) {
            mediaPlayer.stop();
        }
        if (getConfigInt(982, this.mPlayDurationExcludePlayerMethod ? 1 : 0) != 1 && (iPlayDurationManager2 = this.mPlayDuration) != null) {
            iPlayDurationManager2.stop();
        }
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface != null) {
            videoSurface.setIntOption(33, 0);
        }
        IntertrustDrmHelper intertrustDrmHelper = this.mIntertrustDrmHelper;
        if (intertrustDrmHelper != null) {
            intertrustDrmHelper.stop();
        }
        if (this.mLogger != null) {
            if (mediaPlayer != null) {
                int currentPosition = mediaPlayer.getCurrentPosition();
                _updateCurrentPlaybackPosition(currentPosition, false);
                this.mLogger.curPlayBackTime(currentPosition);
                if (this.mState == 3) {
                    this.mLogger.setHijackCode(mediaPlayer.getIntOption(204, -1));
                }
            }
            if (this.mPlaybackState != 0 && (iPlayDurationManager = this.mPlayDuration) != null) {
                this.mLogger.addWatchedDuration(iPlayDurationManager.getPlayedDuration());
            }
            this.mLogger.stop(i);
        }
        updatePlaybackState(0);
        this.mHasFirstFrameShown = false;
        this.mHasFetchedSubtitle = false;
        this.mRenderStartTime = -1L;
        this.mPlayStartTime = -1L;
        this.mHasAudioFirstFrameShown = false;
        this.mPlayTime = 0L;
        this.mDecodedVideoFirstFrame = false;
        this.mPlayerFirstFrame = false;
        this.mTextureFirstFrame = false;
        this.mSeeking = false;
        if (i != 6) {
            TTVideoEngineSurfaceCallback tTVideoEngineSurfaceCallback = this.mSurfaceCallback;
            if (tTVideoEngineSurfaceCallback != null) {
                SurfaceHolder surfaceHolder = this.mSurfaceHolder;
                if (surfaceHolder != null) {
                    surfaceHolder.removeCallback(tTVideoEngineSurfaceCallback);
                }
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                    TTVideoEngineLog.i(logcatTag(), "remove surface callback:" + this.mSurfaceCallback);
                }
                this.mSurfaceCallback.reset();
                this.mSurfaceCallback = null;
            }
            this.mSkipStartWhenPrepared = false;
            this.mEngineConfig.remove(681);
            _updateTextureState(3);
            _isEnableEffect(8, 0);
            this.mEnableTextureRenderNativeWindow = 0;
            this.mEnableFrameCallbackInRenderThread = 0;
        }
    }

    private int clearHijackIpCacheByErrcode(Error error, boolean z) {
        IVideoModel iVideoModel;
        String stringOption;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && this.mIsEnableHijackReportOpt > 0) {
            String stringOption2 = mediaPlayer.getStringOption(10202);
            if (stringOption2 != null && stringOption2.length() > 0) {
                this.mLogger.setMDLHijackURL(stringOption2);
                TTVideoEngineLog.e(logcatTag(), "hijackUrl :" + stringOption2);
            }
            MediaPlayer mediaPlayer2 = this.mMediaPlayer;
            if (mediaPlayer2 != null && this.mIsEnableHijackReportOpt > 0 && (stringOption = mediaPlayer2.getStringOption(10203)) != null && stringOption.length() > 0) {
                this.mLogger.setMDLHijackIP(stringOption);
                TTVideoEngineLog.e(logcatTag(), "hijackUrl :" + stringOption2);
            }
        }
        int i = 10;
        if (getConfigInt(427, this.mHijackRetry ? 1 : 0) != 1) {
            _notifyError(error);
            TTVideoEngineLog.e(logcatTag(), "_notifyError hijack not open");
            return 10;
        }
        this.mLogger.setHijackCode(error.code);
        int configInt = getConfigInt(424, this.mHijackRetryMainDNSType);
        int configInt2 = getConfigInt(425, this.mHijackRetryBackupDNSType);
        TTVideoEngine.setDNSType(configInt, configInt2);
        TTVideoEngine.removeCacheFile(this.mVideoModel);
        DataLoaderHelper.getDataLoader().clearNetinfoCache();
        DataLoaderHelper.getDataLoader().setIntValue(90, configInt);
        DataLoaderHelper.getDataLoader().setIntValue(91, configInt2);
        if (this.mIsHijackRetryStragy > -2) {
            TTVideoEngine.setIntValue(103, 0);
        }
        if (z) {
            TTVideoEngineLog.e(logcatTag(), "fallbackNeeded check fail");
        }
        if (this.mVideoModel == null) {
            TTVideoEngineLog.e(logcatTag(), "mVideoModel check is null");
        }
        IVideoModel iVideoModel2 = this.mVideoModel;
        if (iVideoModel2 != null && !iVideoModel2.getVideoRefBool(106)) {
            TTVideoEngineLog.e(logcatTag(), "VIDEO_ENABLE_SSL check is null");
        }
        if (this.mHijackRetryCount == 0 && !z && (iVideoModel = this.mVideoModel) != null && (iVideoModel.getVideoRefBool(106) || this.mIsHijackRetryStragy > -2)) {
            this.mHijackRetryCount++;
            this.mRetryEnableHttps = true;
            i = 2;
        } else {
            this.mHijackRetryCount = 0;
            _notifyError(error);
        }
        int i2 = this.mIsHijackRetryStragy;
        if (i2 > -2) {
            this.mHijackRetryCount = 0;
        }
        if (i2 > -1 && !z && this.mVideoModel != null) {
            if (this.mErrorCount != 2) {
                this.mIsHijackRetryStragy = -1;
            }
            return i2;
        }
        return i;
    }

    private void setMediaInfo2Abr(rs1.g gVar, IVideoModel iVideoModel) {
        HashMap hashMap;
        HashMap hashMap2;
        List<VideoInfo> videoInfoList = iVideoModel.getVideoInfoList();
        if (videoInfoList != null && videoInfoList.size() != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (VideoInfo videoInfo : videoInfoList) {
                if (videoInfo != null) {
                    if (videoInfo.getMediatype() == VideoRef.TYPE_VIDEO) {
                        rs1.f fVar = new rs1.f();
                        String valueStr = videoInfo.getValueStr(15);
                        fVar.a = valueStr;
                        fVar.g = videoInfo.getValueInt(3);
                        fVar.b = videoInfo.getValueStr(8);
                        fVar.j = videoInfo.getValueInt(44);
                        int valueInt = videoInfo.getValueInt(1);
                        int valueInt2 = videoInfo.getValueInt(2);
                        fVar.d = valueInt;
                        fVar.e = valueInt2;
                        fVar.f = -1;
                        fVar.c = 5000;
                        if (!TextUtils.isEmpty(valueStr)) {
                            arrayList.add(fVar);
                        }
                        boolean booleanValue = this.mSRStrategy.videoInfoSupportSR(videoInfo, videoInfoList).booleanValue();
                        int resolutionIndex = SRStrategy.getResolutionIndex(videoInfo);
                        fVar.h = booleanValue ? 1 : 0;
                        fVar.i = resolutionIndex;
                    } else {
                        rs1.a aVar = new rs1.a();
                        String valueStr2 = videoInfo.getValueStr(15);
                        aVar.a = valueStr2;
                        aVar.e = videoInfo.getValueInt(3);
                        aVar.b = videoInfo.getValueStr(8);
                        aVar.f = videoInfo.getValueInt(44);
                        aVar.d = -1;
                        aVar.c = 5000;
                        if (!TextUtils.isEmpty(valueStr2)) {
                            arrayList2.add(aVar);
                        }
                    }
                }
            }
            gVar.l(arrayList, arrayList2);
            String configString = getConfigString(538, this.mABR4GMaxResolutionQuality);
            Resolution valueOf = Resolution.valueOf(getConfigInt(502, this.mABR4GMaxResolutionIndex));
            HashMap hashMap3 = null;
            if (valueOf != null || !TextUtils.isEmpty(configString)) {
                if (!TextUtils.isEmpty(configString)) {
                    hashMap = new HashMap();
                    hashMap.put(32, configString);
                } else {
                    hashMap = null;
                }
                if (iVideoModel.getVideoInfo(valueOf, (Map<Integer, String>) hashMap, true) != null) {
                    gVar.i(2, r3.getValueInt(3));
                }
            }
            Resolution valueOf2 = Resolution.valueOf(getConfigInt(536, this.mWifiDefaultResolutionIndex));
            String configString2 = getConfigString(539, this.mWifiDefaultResolutionQuality);
            if (valueOf2 != null || !TextUtils.isEmpty(configString2)) {
                if (!TextUtils.isEmpty(configString2)) {
                    hashMap2 = new HashMap();
                    hashMap2.put(32, configString2);
                } else {
                    hashMap2 = null;
                }
                if (iVideoModel.getVideoInfo(valueOf2, (Map<Integer, String>) hashMap2, true) != null) {
                    gVar.i(12, r3.getValueInt(3));
                }
            }
            Resolution valueOf3 = Resolution.valueOf(getConfigInt(537, this.mStartupMaxBitRateIndex));
            String configString3 = getConfigString(540, this.mStartupMaxBitRateQuality);
            if (valueOf3 != null || !TextUtils.isEmpty(configString3)) {
                if (!TextUtils.isEmpty(configString3)) {
                    hashMap3 = new HashMap();
                    hashMap3.put(32, configString3);
                }
                if (iVideoModel.getVideoInfo(valueOf3, (Map<Integer, String>) hashMap3, true) != null) {
                    gVar.i(13, r3.getValueInt(3));
                }
            }
            gVar.h(66, iVideoModel.getVideoRefInt(3));
            String videoRefStr = iVideoModel.getVideoRefStr(237);
            if (!TextUtils.isEmpty(videoRefStr)) {
                gVar.j(69, videoRefStr);
            }
            gVar.h(82, this.mABREnableAggressivePortraitLowBit);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal, com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setFloatOption(int i, float f) {
        if (ConfigItemFactory.isCommonPlayerOption(i)) {
            this.mOptionHolder.setFloatOption(i, f);
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setFloatOption(i, f);
            }
        }
        if (i != 359) {
            if (i != 535) {
                if (i != 651) {
                    if (i != 722) {
                        if (i != 723) {
                            switch (i) {
                                case 325:
                                    this.mAEPreGain = f;
                                    break;
                                case 326:
                                    this.mAEThreshold = f;
                                    break;
                                case 327:
                                    this.mAERatio = f;
                                    break;
                                case 328:
                                    this.mAEPredelay = f;
                                    break;
                                default:
                                    boolean z = true;
                                    switch (i) {
                                        case 344:
                                            this.mTarLoudness = f;
                                            MediaPlayer mediaPlayer2 = this.mMediaPlayer;
                                            if (mediaPlayer2 != null) {
                                                mediaPlayer2.setFloatOption(645, f);
                                                break;
                                            }
                                            break;
                                        case 345:
                                            this.mHasSetAESrcLoudness = true;
                                            this.mSrcLoudness = f;
                                            MediaPlayer mediaPlayer3 = this.mMediaPlayer;
                                            if (mediaPlayer3 != null) {
                                                mediaPlayer3.setFloatOption(644, f);
                                                break;
                                            }
                                            break;
                                        case 346:
                                            this.mHasSetAESrcPeak = true;
                                            this.mSrcPeak = f;
                                            MediaPlayer mediaPlayer4 = this.mMediaPlayer;
                                            if (mediaPlayer4 != null) {
                                                mediaPlayer4.setFloatOption(646, f);
                                                break;
                                            }
                                            break;
                                        case 347:
                                            if (f <= 0.0f) {
                                                z = false;
                                            }
                                            this.mAEForbidCompressor = z;
                                            break;
                                        case 348:
                                            this.mReleaseTime = f;
                                            break;
                                        case 349:
                                            this.mLookAheadTime = f;
                                            break;
                                        case 350:
                                            this.mLuRange = f;
                                            MediaPlayer mediaPlayer5 = this.mMediaPlayer;
                                            if (mediaPlayer5 != null) {
                                                mediaPlayer5.setFloatOption(1153, f);
                                                break;
                                            }
                                            break;
                                        case 351:
                                            this.mLuStart = f;
                                            MediaPlayer mediaPlayer6 = this.mMediaPlayer;
                                            if (mediaPlayer6 != null) {
                                                mediaPlayer6.setFloatOption(1154, f);
                                                break;
                                            }
                                            break;
                                        case 352:
                                            this.mLuEnd = f;
                                            MediaPlayer mediaPlayer7 = this.mMediaPlayer;
                                            if (mediaPlayer7 != null) {
                                                mediaPlayer7.setFloatOption(1155, f);
                                                break;
                                            }
                                            break;
                                        case 353:
                                            this.mMaxMomLu = f;
                                            MediaPlayer mediaPlayer8 = this.mMediaPlayer;
                                            if (mediaPlayer8 != null) {
                                                mediaPlayer8.setFloatOption(1156, f);
                                                break;
                                            }
                                            break;
                                        case 354:
                                            this.mMaxShortermLu = f;
                                            MediaPlayer mediaPlayer9 = this.mMediaPlayer;
                                            if (mediaPlayer9 != null) {
                                                mediaPlayer9.setFloatOption(1157, f);
                                                break;
                                            }
                                            break;
                                        default:
                                            switch (i) {
                                                case 526:
                                                    this.mABRStartupBandwidthParameter = f;
                                                    break;
                                                case 527:
                                                    this.mABRStallPenaltyParameter = f;
                                                    break;
                                                case 528:
                                                    this.mABRSwitchPenaltyParameter = f;
                                                    break;
                                                case 529:
                                                    this.mABRBandwidthParameter = f;
                                                    break;
                                                default:
                                                    super.setFloatOption(i, f);
                                                    break;
                                            }
                                    }
                            }
                        } else {
                            IVideoEventLogger iVideoEventLogger = this.mLogger;
                            if (iVideoEventLogger != null) {
                                iVideoEventLogger.setVrDisplayFrameRate(f);
                            }
                        }
                    } else {
                        IVideoEventLogger iVideoEventLogger2 = this.mLogger;
                        if (iVideoEventLogger2 != null) {
                            iVideoEventLogger2.setVrDisplayDistance(f);
                        }
                    }
                } else {
                    VideoSurface videoSurface = this.mTextureSurface;
                    if (videoSurface != null) {
                        videoSurface.setFloatOption(4, f);
                    }
                }
            } else {
                this.mNetworkSpeedReportSamplingRate = f;
                this.mLogger.setFloatOption(20, f);
            }
        } else {
            this.mSpeedXDropFPSLimit = f;
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "set float option key:" + i + ",value:" + f);
        }
    }

    private void _setDataSource(String str, Map<String, String> map) throws IOException {
        String str2;
        if (this.mEnableTmpLog == 1) {
            showLongLog("setDatasource before url:" + str);
        }
        String _generatePlayUrl = _generatePlayUrl(str, map);
        if (this.mRetryEnableHttps) {
            _generatePlayUrl = TTHelper.buildHttpsUrl(_generatePlayUrl);
        }
        if (this.mEnableTmpLog == 1) {
            showLongLog("setDatasource after url:" + _generatePlayUrl);
        }
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            iVideoEventLogger.setCustomP2PCDNType(this.mP2PCDNType);
        }
        if (!this.mPrepared) {
            long currentTimeMillis = System.currentTimeMillis();
            IVideoEventLogger iVideoEventLogger2 = this.mLogger;
            if (iVideoEventLogger2 != null) {
                this.mTraceId = iVideoEventLogger2.getTraceID();
            } else {
                this.mTraceId = TTHelper.genTrackID(BaseAppInfo.mDeviceId, currentTimeMillis);
            }
            if (!TextUtils.isEmpty(this.mTraceId)) {
                map.put("X-Tt-Traceid", this.mTraceId);
                this.mHeaders.put("X-Tt-Traceid", this.mTraceId);
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                    TTVideoEngineLog.i(logcatTag(), "X-Tt-Traceid:" + this.mTraceId);
                }
            }
            if (!TextUtils.isEmpty(this.mMDLGroupId)) {
                map.put("X-Tt-GroupId", this.mMDLGroupId);
                this.mLogger.setStringOption(156, this.mMDLGroupId);
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                    TTVideoEngineLog.i(logcatTag(), "X-Tt-GroupId:" + this.mMDLGroupId);
                }
            }
            int i = this.mFallbackApiRetry;
            if (!this.mIsDirectURL && i != 0) {
                this.mHeaders.put("X-Tt-Fapi", String.valueOf(i));
                this.mHeaders.put("Engine-ID", String.valueOf(this.mEngineHash));
                this.mLogger.setIntOption(34, i);
            }
            int configInt = getConfigInt(857, this.mNetSpeedInterval);
            int i2 = TTVideoEngine.sABRSpeedPredictInputType;
            if (i2 == 1) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(logcatTag(), "HEADER_IS_SPEEDTEST single data, interval:" + TTVideoEngine.sTestSpeedInterval);
                }
                this.mHeaders.put("X-SpeedTest-TimeInternal", String.valueOf(TTVideoEngine.sTestSpeedInterval));
            } else if (i2 == 0 && this.mEnableNetLevel > 0 && configInt > 0) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(logcatTag(), "enableNetLevel, interval: " + configInt);
                }
                this.mHeaders.put("X-SpeedTest-TimeInternal", String.valueOf(configInt));
            }
            Map<String, String> map2 = this.mHeaders;
            if (TextUtils.isEmpty(this.mTag)) {
                str2 = "default";
            } else {
                str2 = this.mTag;
            }
            map2.put("X-Tt-Tag", str2);
            int i3 = this.mUseVdpDisk;
            if (this.mConfigCenterVersion > 0) {
                i3 = this.mEngineConfig.getIntOption(801);
                if (i3 == 1) {
                    i3 = 0;
                } else if (i3 == 0) {
                    i3 = 1;
                }
            }
            if (i3 == 0 || i3 == 1) {
                this.mHeaders.put("X-Tt-VdpIo", String.valueOf(i3));
            }
            if (!TextUtils.isEmpty(this.mSubTag)) {
                this.mHeaders.put("X-Tt-SubTag", this.mSubTag);
            }
        }
        if (map != null && TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "setDataSource X-Tt-Traceid:" + map.get("X-Tt-Traceid"));
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && mediaPlayer.getPlayerType() == 0 && getConfigInt(4022, this.mOSPlayerIgnoreHeaders ? 1 : 0) != 0) {
            map.clear();
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "setDataSource:" + _generatePlayUrl);
        }
        this.mMediaPlayer.setDataSource(this.mContext, Uri.parse(_generatePlayUrl), map);
    }

    protected void _switchToResolution(Resolution resolution, Map<Integer, String> map) {
        IPlayDurationManager iPlayDurationManager;
        int i;
        int i2;
        String str;
        Map<Integer, String> map2;
        if (this.currentResolution == resolution && (((map2 = this.currentParams) == null && map == null) || (map2 != null && map2.equals(map)))) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                TTVideoEngineLog.e(logcatTag(), "switch to the same resolution:" + _resolutionToString(resolution) + ", drop");
                return;
            }
            return;
        }
        IVideoModel iVideoModel = this.mVideoModel;
        if (iVideoModel == null) {
            return;
        }
        if (this.currentResolution != resolution && this.mListenerCompact != null) {
            VideoInfo videoInfo = iVideoModel.getVideoInfo(resolution, iVideoModel.getVideoRefInt(7), map, false);
            IVideoModel iVideoModel2 = this.mVideoModel;
            VideoInfo videoInfo2 = iVideoModel2.getVideoInfo(this.currentResolution, iVideoModel2.getVideoRefInt(7), this.currentParams, false);
            if (videoInfo2 != null && videoInfo != null) {
                if (videoInfo.getValueInt(3) == videoInfo2.getValueInt(3)) {
                    notifyStreamChanged(this.mVideoModel.getVideoRefInt(7));
                }
            }
        }
        if (this.mSetNotifyBufferingDirectlynBeforeRePlay > 0 && this.mNotifyBufferingDirectly > 0 && getCurrentPlaybackTime() <= 0) {
            this.mHasFirstFrameShown = false;
        }
        this.lastResolution = this.currentResolution;
        this.mLastSwitchResolutionTime = System.currentTimeMillis();
        this.currentResolution = resolution;
        this.currentParams = map;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "will switch to resolution:" + _resolutionToString(this.currentResolution) + ", from resolution:" + _resolutionToString(this.lastResolution));
        }
        if (map != null) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                    TTVideoEngineLog.i(logcatTag(), "will switch to params, Key = " + entry.getKey() + ",Value = " + entry.getValue());
                }
            }
        }
        boolean isSupportSeamlessSwitch = isSupportSeamlessSwitch(this.mVideoModel);
        if (isSupportSeamlessSwitch && this.mPlaybackState != 2) {
            int i3 = VideoRef.TYPE_VIDEO;
            if (this.mVideoModel.hasData()) {
                if (map == null) {
                    map = new HashMap<>();
                }
                if (this.mConfigCenterVersion > 0) {
                    str = this.mEngineConfig.getStringOption(1000);
                } else {
                    str = this.mCodecType;
                }
                if (str.equals("bytevc2") && this.mVideoModel.getVideoRefBool(228)) {
                    map.put(8, "bytevc2");
                } else if (str.equals("bytevc1") && this.mVideoModel.getVideoRefBool(204)) {
                    map.put(8, "bytevc1");
                } else if (this.mVideoModel.getVideoRefBool(203)) {
                    map.put(8, "h264");
                }
                VideoInfo _videoInfoForResolution = _videoInfoForResolution(this.currentResolution, this.mVideoModel.getVideoRefInt(7), map);
                if (_videoInfoForResolution != null) {
                    i2 = _videoInfoForResolution.getValueInt(3);
                    i = _videoInfoForResolution.getMediatype();
                } else {
                    i = i3;
                    i2 = 0;
                }
                if (this.mListenerCompact.getVideoEngineInfoListener() != null) {
                    ArrayList arrayList = new ArrayList();
                    if (this.mVideoModel.hasFormat(IVideoModel.Format.DASH)) {
                        String dynamicType = this.mVideoModel.getDynamicType();
                        if (!TextUtils.isEmpty(dynamicType) && dynamicType.equals("segment_base")) {
                            VideoInfo _videoInfoForResolution2 = _videoInfoForResolution(this.currentResolution, VideoRef.TYPE_VIDEO, map);
                            VideoInfo _videoInfoForResolution3 = _videoInfoForResolution(this.currentResolution, VideoRef.TYPE_AUDIO, map);
                            if (_videoInfoForResolution2 != null) {
                                arrayList.add(_videoInfoForResolution2);
                            }
                            if (_videoInfoForResolution3 != null) {
                                arrayList.add(_videoInfoForResolution3);
                            }
                        }
                    } else if (_videoInfoForResolution != null) {
                        arrayList.add(_videoInfoForResolution);
                    }
                    if (arrayList.size() > 0) {
                        VideoEngineInfos videoEngineInfos = new VideoEngineInfos();
                        videoEngineInfos.setKey("usingUrlInfos");
                        videoEngineInfos.setUrlInfos(arrayList);
                        notifyEngineInfo(videoEngineInfos, true);
                    }
                }
            } else {
                i = i3;
                i2 = 0;
            }
            if (this.mMediaPlayer != null && isInHousePlayer()) {
                this.mLogger.switchResolution(_resolutionToString(this.currentResolution), _resolutionToString(this.lastResolution), false);
                changeResolutionSwitchingState(true);
                this.mMediaPlayer.switchStream(i2, i);
                return;
            }
        }
        if (!this.mSeamSwitchingResolution) {
            this.mSeamSwitchingResolution = true;
            this.mLogger.switchResolution(_resolutionToString(this.currentResolution), _resolutionToString(this.lastResolution), true);
            changeResolutionSwitchingState(true);
            if (!isSupportSeamlessSwitch && (iPlayDurationManager = this.mPlayDuration) != null) {
                iPlayDurationManager.stop();
            }
            this.mLastPlaybackTime = _getPlayerTime();
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
        _parseIPAddress(this.mVideoModel);
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface != null) {
            videoSurface.setIntOption(33, 0);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void playUrlChanged(int i, String str, String str2) {
        if (this.mCurrentUrlIndex == i) {
            return;
        }
        this.mCurrentUrlIndex = i;
        this.mCurrentUrl = str;
        if (i != 0) {
            this.mListenerCompact.onPlayUrlChanged(i, str, str2);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDirectUrlUseDataLoader(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setDirectUrlUseDataLoader(new String[]{str}, str2, str3);
    }

    private void _setSurfaceSync(final Surface surface, long j, boolean z) {
        if (surface == null) {
            this.mLastSetSurfaceNullTime = System.currentTimeMillis();
        }
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            if (!this.mLooperThread.sendEngineMessage(54, j, 0, 0, surface) && surface != null) {
                this.mSetValidSurfaceTimeout = 1;
                return;
            }
            return;
        }
        if (z) {
            EngineThreadPool.addExecuteTaskSync(new Runnable() { // from class: com.ss.ttvideoengine.k
                @Override // java.lang.Runnable
                public final void run() {
                    TTVideoEngineImpl.this.lambda$_setSurfaceSync$5(surface);
                }
            }, j);
        } else {
            lambda$_setSurfaceSync$5(surface);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void notifyBufferStart(int i, int i2, int i3) {
        if (this.mLooperThread.checkSendMainLooper()) {
            HashMap hashMap = new HashMap();
            hashMap.put("bufferStartAction", Integer.valueOf(i3));
            hashMap.put("traceid", this.mTraceId);
            this.mLooperThread.postMainLooperMessage(415, i, i2, hashMap);
            return;
        }
        this.mListenerCompact.onBufferStart(i, i2, i3);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void onMediaPlayerSARChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "onSARChanged = " + i + ", " + i2);
        }
        notifySARChanged(i, i2);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) {
        this.mPipeOffset = j;
        this.mPipeLength = j2;
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(12, 0, 0, fileDescriptor);
        } else {
            _doSetDataSource(fileDescriptor);
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setPlayerSurface(Surface surface, int i, int i2) {
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            if (i2 == 1) {
                this.mLooperThread.sendEngineMessage(56, getConfigInt(950, (int) this.mSendEngineMsgTimeout), i, 0, surface);
                return;
            } else {
                this.mLooperThread.postEngineMessage(56, i, 0, surface);
                return;
            }
        }
        _doSetPlayerSurface(surface, i);
    }

    private VideoInfo _videoInfoForResolution(Resolution resolution, int i, Map<Integer, String> map) {
        IVideoModel iVideoModel = this.mVideoModel;
        if (iVideoModel != null && iVideoModel.hasData()) {
            VideoInfo videoInfo = this.mVideoModel.getVideoInfo(resolution, i, map, true);
            if (videoInfo != null) {
                int videoRefInt = this.mVideoModel.getVideoRefInt(7);
                if (videoRefInt == VideoRef.TYPE_AUDIO && videoInfo.getMediatype() == VideoRef.TYPE_AUDIO) {
                    this.currentResolution = videoInfo.getResolution();
                    this.mCurrentQualityDesc = videoInfo.getValueStr(32);
                } else if (videoRefInt == VideoRef.TYPE_VIDEO && videoInfo.getMediatype() == VideoRef.TYPE_VIDEO) {
                    this.currentResolution = videoInfo.getResolution();
                    this.mCurrentQualityDesc = videoInfo.getValueStr(32);
                }
                this.mLogger.setCurrentQualityDesc(this.mCurrentQualityDesc);
                this.mLogger.configResolution(_resolutionToString(this.currentResolution), "");
            }
            return videoInfo;
        }
        return null;
    }

    @TargetClass("com.ss.ttvideoengine.TTVideoEngineImpl")
    @Insert("_playInternal")
    public static void com_ss_ttvideoengine_TTVideoEngineImpl_com_dragon_read_aop_TTVideoEngineAop__playInternal(TTVideoEngineImpl tTVideoEngineImpl, String str, Map map) {
        LogWrapper.info("AudioCore-TTVideoEngineAops", "_playInternal ,url = " + str, new Object[0]);
        if (!TextUtils.isEmpty(str) && MdlNative.b().nativeMdlNetworkTimeoutControl && (str.startsWith("mdl://") || (MdlNative.b().nativeMdlNetworkTimeoutDashFix && str.startsWith("mem://")))) {
            tTVideoEngineImpl.setIntOption(12, MdlNative.b().nativeMdlNetworkTimeout);
        }
        LogWrapper.info("AudioCore-TTVideoEngineAops", "_playInternal ,network_timeout = " + Integer.valueOf(tTVideoEngineImpl.mNetworkTimeout), new Object[0]);
        tTVideoEngineImpl.TTVideoEngineImpl___playInternal$___twin___(str, map);
    }

    void _doSetPlayerSurfaceTimeOut(Surface surface, int i, int i2) {
        MediaPlayer mediaPlayer = this.mAsyncPlayer;
        if (mediaPlayer == null) {
            mediaPlayer = this.mMediaPlayer;
        }
        if (mediaPlayer != null) {
            if (surface == null) {
                ((MediaPlayerWrapper) mediaPlayer).setSurfaceTimeOut(null, i2);
                return;
            }
            int i3 = 0;
            if (i == 1) {
                if (this.mEnableMarkOffscreenRendering == 1) {
                    mediaPlayer.setIntOption(4024, 0);
                }
                ((MediaPlayerWrapper) mediaPlayer).setSurfaceTimeOut(surface, i2);
                this.mLogger.setPlayerSurface(surface.toString());
                return;
            }
            if (this.mEnableMarkOffscreenRendering == 1) {
                if (this.mTextureSurface != null) {
                    i3 = 1;
                }
                mediaPlayer.setIntOption(4024, i3);
            }
            MediaPlayerWrapper mediaPlayerWrapper = (MediaPlayerWrapper) mediaPlayer;
            Surface surface2 = this.mTextureSurface;
            if (surface2 == null) {
                surface2 = surface;
            }
            mediaPlayerWrapper.setSurfaceTimeOut(surface2, i2);
            IVideoEventLogger iVideoEventLogger = this.mLogger;
            Surface surface3 = this.mTextureSurface;
            if (surface3 != null) {
                surface = surface3;
            }
            iVideoEventLogger.setPlayerSurface(surface.toString());
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected boolean onMediaPlayerError(MediaPlayer mediaPlayer, int i, int i2) {
        IPlayDurationManager iPlayDurationManager = this.mPlayDuration;
        if (iPlayDurationManager != null) {
            iPlayDurationManager.stop();
        }
        updatePlaybackState(3);
        updateLoadState(3, -1);
        if (this.mState == 0) {
            TTVideoEngineLog.i(logcatTag(), "invalid state,return directly");
            return true;
        }
        String stringOption = mediaPlayer.getStringOption(5002);
        String domainForPlayer = Error.getDomainForPlayer(mediaPlayer);
        if (domainForPlayer.equals("kTTVideoErrorDomainVideoOwnPlayer") && this.mRetryingNotHandleError) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "retrying, not handle error: " + i + ", i1:" + i2);
            }
            return true;
        }
        Error error = new Error(domainForPlayer, i, i2, stringOption);
        this.mError = error;
        receivedError(error);
        return true;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDirectUrlUseDataLoader(String[] strArr, String str, String str2) {
        setDirectUrlUseDataLoader(strArr, str, str2, null, -1);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setDirectUrlUseDataLoaderByFilePath(String[] strArr, String str, String str2) {
        if (strArr != null && strArr.length != 0 && !TextUtils.isEmpty(strArr[0])) {
            this.mInitialUrlBeforeMdlProxy = strArr[0];
            if (TextUtils.isEmpty(str2)) {
                setDirectUrlUseDataLoader(strArr, str);
                return;
            }
            _resetUsingDataLoaderField();
            String _mdlUrl = _mdlUrl(str, this.mVideoID, getConfigInt(161, this.mLimitMDLCacheSize), strArr, Resolution.Undefine, this.mDecryptionKey, null, str2, null, 0L, null, -1);
            if (!this.mFileHashs.contains(str)) {
                this.mFileHashs.add(str);
            }
            if (TextUtils.isEmpty(_mdlUrl)) {
                setDirectURL(strArr[0]);
                return;
            } else {
                setDirectURL(_mdlUrl);
                return;
            }
        }
        TTVideoEngineLog.e(logcatTag(), "invalid urls list, it is empty");
    }

    @TargetClass("com.ss.ttvideoengine.TTVideoEngineImpl")
    @Insert("clearByErrcode")
    public static int com_ss_ttvideoengine_TTVideoEngineImpl_com_dragon_read_aop_TTVideoEngineAop_clearByErrcode(TTVideoEngineImpl tTVideoEngineImpl, Error error, boolean z) {
        HiJackConfig b = HiJackConfig.b();
        if (b.forceHttpDnsWhenInvalidData && b.forceErrorCodeList.contains(Integer.valueOf(error.code))) {
            DataLoaderHelper.getDataLoader().clearNetinfoCache();
            TTVideoEngine.setDNSType(2, 0);
            TTVideoEngine.setIntValue(90, 2);
            TTVideoEngine.setIntValue(91, 0);
            TTVideoEngine.setIntValue(103, 0);
        }
        if ((com.dragon.read.base.ssconfig.c.v().fixEngineInvalidError && error.code == -499960) || (b.clearMdlDataOpt && b.clearMdlDataErrorCode.contains(Integer.valueOf(error.code)))) {
            try {
                if (((Integer) i80.c.b(tTVideoEngineImpl, "getConfigInt", new Object[]{603, Integer.valueOf(tTVideoEngineImpl.mEnableClearMDLCache)})).intValue() > 0) {
                    i80.c.b(tTVideoEngineImpl, "clearMdlCache", new Object[0]);
                    return 11;
                }
                return 11;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return tTVideoEngineImpl.TTVideoEngineImpl__clearByErrcode$___twin___(error, z);
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected void onMediaPlayerVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        TTAVWindowClient tTAVWindowClient;
        TTVideoEngineLog.i(logcatTag(), "video size changed = " + i + ", " + i2);
        VideoSurface videoSurface = this.mTextureSurface;
        if (videoSurface != null) {
            videoSurface.updateTexDimension(i, i2);
            if (this.mPlayBackUsedSR && !this.mSRIgnoreRes && !videoSurface.supportProcessResolution(i, i2)) {
                TTVideoEngineLog.i(logcatTag(), "VideoSurface resolution not support for sr");
                doOpenSR(0, -7891);
            }
            if (mediaPlayer != null) {
                videoSurface.setIntOption(133, mediaPlayer.getIntOption(139, -1));
                videoSurface.setIntOption(169, mediaPlayer.getIntOption(1087, -1));
            }
        }
        int intOption = mediaPlayer.getIntOption(912, -1);
        int i3 = 1;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "colorTrc " + intOption);
        }
        if (intOption != 16) {
            if (intOption == 18) {
                i3 = 2;
            } else {
                i3 = 0;
            }
        }
        _setHDRInfoToTexturerender(mediaPlayer, i3);
        this.mLogger.setIntOption(90, i3);
        if (!this.mFixSetDisplayModeSARBug) {
            setDisplayVideoSize(i, i2);
        }
        if (this.mIsNewPlayerViewUsedExternal && (tTAVWindowClient = this.mWindowClient) != null) {
            tTAVWindowClient.updateVideoSize(i, i2);
        }
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        notifyVideoSizeChanged(i, i2);
        if (!this.mSeamSwitchingResolution && this.mFirstGetWidthHeight) {
            TTVideoEngineLog.d(logcatTag(), "changed video size set");
            this.mFirstGetWidthHeight = false;
            this.mLogger.setStartPlayWidth(i);
            this.mLogger.setStartPlayHeight(i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String _generatePlayUrl(java.lang.String r13, java.util.Map<java.lang.String, java.lang.String> r14, java.util.List<com.ss.ttvideoengine.model.VideoInfo> r15) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.TTVideoEngineImpl._generatePlayUrl(java.lang.String, java.util.Map, java.util.List):java.lang.String");
    }

    public void TTVideoEngineImpl__initEngine$___twin___(Context context, int i, Map map) {
        Looper looper;
        boolean z;
        boolean z2;
        super.initEngine(context, i);
        this.mOutputLog = TTVideoEngine.getPlayerOutputLog();
        boolean z3 = true;
        this.mFirstURL = true;
        this.mFirstIP = true;
        this.mFirstHost = true;
        this.mUseFallbackAPI = true;
        this.currentResolution = Resolution.Standard;
        this.expectedResolution = Resolution.Auto;
        this.urlIndexMap = new HashMap();
        this.dashVideoUrlMap = new HashMap();
        this.dashAudioUrlMap = new HashMap();
        this.dashUrlMap = new HashMap();
        _resetUrlIndexMap();
        this.urlIPMap = new HashMap();
        this.mHeaders = new ConcurrentHashMap();
        this.mTextureFirstFrame = false;
        this.mPlayerFirstFrame = false;
        this.mSendEngineMsgTimeout = 500L;
        int i2 = TTVideoEngine.sUseConfigCenter;
        this.mConfigCenterVersion = i2;
        if (i2 > 0) {
            if (TTVideoEngine.sConfigCenterCheckDiff > 0) {
                z = true;
            } else {
                z = false;
            }
            this.mEngineConfig = new EngineConfig(z, new ConcurrentHashMap());
            if (this.mConfigCenterVersion > 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mPlayerConfigExecutor = new PlayerConfigExecutor(z2);
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "ConfigCenter is used, cc Version:" + this.mConfigCenterVersion);
            }
        } else {
            this.mEngineConfig = IEngineConfig.EMPTY;
            this.mPlayerConfigExecutor = PlayerConfigExecutor.EMPTY;
        }
        this.mDataLoaderEnable = EngineGlobalConfig.getInstance().isOnlyUseMediaLoader() ? 1 : 0;
        this.mEngineConfig.setIntOption(160, EngineGlobalConfig.getInstance().isOnlyUseMediaLoader() ? 1 : 0);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "DataLoaderEnable is: " + getConfigInt(160, this.mDataLoaderEnable));
        }
        if (i == 3) {
            TTVideoEngine.setForceUseLitePlayer(true);
        }
        this.mHeadsetMonitor = HeadsetStateMonitor.getInstance(context);
        this.mLogger = new VideoEventLoggerV2(context, new MyLoggerDataSource(this), this.mHeadsetMonitor);
        TTVideoEngineMonitor tTVideoEngineMonitor = TTVideoEngineMonitor.getInstance(context);
        this.mEngineStateMonitor = tTVideoEngineMonitor;
        if (tTVideoEngineMonitor != null) {
            tTVideoEngineMonitor.startObserve(hashCode(), this.mEngineWrapper);
        }
        this.mLogger.setUploadLogEnabled(true);
        this.mLogger.configResolution(_resolutionToString(this.currentResolution), "");
        this.mLogger.setIntOption(132, hashCode());
        if (!EngineGlobalConfig.getInstance().isOnlyUseMediaLoader()) {
            createDefaultCacheFileDirectory();
        }
        this.mPlayDuration = new PlayDurationManager(this.mHeadsetMonitor);
        if (!TimeService.isUpdated()) {
            TimeService.updateTimeFromNTP(this.mContext);
        }
        EngineThreadPool.addExecuteTask(new VideoInfoCollector.myVideoCollectorRegister(this.mEngineWrapper, this.mSerial));
        this.mLooperThread = new TTVideoEngineLooperThread2(this);
        if (SettingsHelper.helper().getVodInt("engine_enable_looper", 0) == 0) {
            z3 = false;
        }
        this.mEnableLooperThread = z3;
        HandlerThread handlerThread = null;
        if (map != null && map.containsKey("callback_looper")) {
            looper = (Looper) map.get("callback_looper");
        } else {
            looper = null;
        }
        if (map != null && map.containsKey("enable_looper")) {
            this.mEnableLooperThread = ((Boolean) map.get("enable_looper")).booleanValue();
        }
        if (this.mEnableLooperThread) {
            if (map != null && map.containsKey("handler_thread")) {
                handlerThread = (HandlerThread) map.get("handler_thread");
            }
            if (map != null && map.containsKey("handler_thread_not_allow_destroy")) {
                this.mLooperThread.setIntValue(0, ((Integer) map.get("handler_thread_not_allow_destroy")).intValue());
            }
            this.mLooperThread.start(handlerThread, looper);
        }
        VideoEventManager.instance.setContext(context);
        initMDLFetcher(context);
        this.mEngineHash = String.valueOf(hashCode());
        this.mCodecStrategyAdapter = new CodecStrategyAdapter(this);
        this.mOptionHolder = new OptionHolder();
        EngineInstanceHolder.getInstance().add(this.mEngineWrapper);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "initEngine, engine hash:" + this.mEngineHash);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.ss.ttvideoengine.TTVideoEngineInternal
    protected boolean onMediaPlayerInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i != 3) {
            if (i != 4) {
                if (i != 701) {
                    if (i != 702) {
                        switch (i) {
                            case -268435438:
                                _updateCurrentPlaybackPosition(i2, true);
                                _updateCurrentInfoToMDL(i2);
                                break;
                            case -268435392:
                                IVideoEventLogger iVideoEventLogger = this.mLogger;
                                if (iVideoEventLogger != null) {
                                    iVideoEventLogger.setMaskErrorCode(i2);
                                    break;
                                }
                                break;
                            case -268435390:
                                notifyReadyForDisplay();
                                break;
                            case 801:
                                _seekComplete(false);
                                break;
                            case 251658244:
                                _streamChanged(i2);
                                break;
                            default:
                                switch (i) {
                                    case -268435436:
                                        notifyInfoIdChanged(i2);
                                        break;
                                    case -268435435:
                                        updatePlaybackState(2);
                                        break;
                                    case -268435434:
                                        _onABRGetPredictResult(i2);
                                        break;
                                    default:
                                        switch (i) {
                                            case -268435408:
                                                _preBuffering(i2);
                                                break;
                                            case -268435407:
                                                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                                                    TTVideoEngineLog.i(logcatTag(), "av outsync start:" + i2);
                                                }
                                                this.mLogger.AVOutSyncStart(i2);
                                                break;
                                            case -268435406:
                                                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                                                    TTVideoEngineLog.i(logcatTag(), "av outsync end:" + i2);
                                                }
                                                this.mLogger.AVOutSyncEnd(i2);
                                                break;
                                            case -268435405:
                                                _formaterStart();
                                                break;
                                            case -268435404:
                                                _decoderStart(i2);
                                                break;
                                            case -268435403:
                                                this.mLogger.AVNoRenderStart(i2, 0);
                                                break;
                                            case -268435402:
                                                this.mLogger.AVNoRenderEnd(i2);
                                                break;
                                            case -268435401:
                                                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                                                    TTVideoEngineLog.i(logcatTag(), "starttime is bigger than video duration:" + i2);
                                                }
                                                this.mShouldUseAudioRenderStart = true;
                                                break;
                                            default:
                                                switch (i) {
                                                    case -268435388:
                                                        _secondFrame();
                                                        break;
                                                    case -268435387:
                                                        TTVideoEngineLog.i(logcatTag(), "FIRST FRAME AFTER SURFACE CHANGE");
                                                        TTVideoEngineLooperThread2 tTVideoEngineLooperThread2 = this.mLooperThread;
                                                        if (tTVideoEngineLooperThread2 != null && tTVideoEngineLooperThread2.checkSendMainLooper()) {
                                                            this.mLooperThread.postMainLooperMessage(427, 0, 0, null);
                                                            break;
                                                        } else {
                                                            ListenerCompact listenerCompact = this.mListenerCompact;
                                                            if (listenerCompact != null) {
                                                                listenerCompact.OnFirstFrameAfterSurfaceChange(this.mEngineWrapper);
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    case -268435386:
                                                        _firstAVSyncFrame();
                                                        break;
                                                    case -268435385:
                                                        _refreshSurface();
                                                        break;
                                                    case -268435384:
                                                        _abnormalOccured(i2);
                                                        break;
                                                    case -268435383:
                                                        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                                            TTVideoEngineLog.d("TTVideoEngine", "MEDIA_INFO_RENDER_EXCEPTION:" + i2);
                                                        }
                                                        if (this.mTextureSurface == null && getConfigInt(1504, this.mEnableNotifyRenderException) > 0) {
                                                            Error error = new Error("kTTVideoErrorDomainVideoOwnPlayer", -8000, i2);
                                                            if (this.mLooperThread.checkSendMainLooper()) {
                                                                this.mLooperThread.postMainLooperMessage(409, 0, 0, error);
                                                                break;
                                                            } else {
                                                                this.mListenerCompact.onError(error);
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    case -268435382:
                                                        TTVideoEngineLog.i(logcatTag(), "player callback video render device changed");
                                                        VideoSurface videoSurface = this.mTextureSurface;
                                                        if (videoSurface != null) {
                                                            videoSurface.setIntOption(133, i2);
                                                            break;
                                                        }
                                                        break;
                                                    default:
                                                        switch (i) {
                                                            case 251658248:
                                                                _renderSeekComplete(i2);
                                                                break;
                                                            case 251658249:
                                                                _videoBitrateChanged(i2);
                                                                break;
                                                            default:
                                                                switch (i) {
                                                                    case 251658252:
                                                                        _audioRenderStart();
                                                                        break;
                                                                    case 251658253:
                                                                        _silenceDetected();
                                                                        break;
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                    } else {
                        _bufferEnd(i2);
                    }
                } else {
                    _bufferStart(i2);
                }
            } else if (this.mPlaybackState != 0) {
                _logFirstFrame();
            }
        } else {
            TTVideoEngineLog.i(logcatTag(), "player callback video render start");
            _videoRenderStartNotify();
            if (getConfigInt(TTVideoEngineInterface.PLAYER_OPTION_OPEN_TEXTUER_AFTER_FIRST_FRAME, this.mFirstFrameOpenTexture) == 1) {
                this.mPlayerFirstFrame = true;
                _renderStart();
                if (1 == this.mIsEnabelUsedRefactorSurfaceView) {
                    if (this.mWindowClient != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (this.mEnableMarkOffscreenRendering == 1 && this.mTextureSurface != null) {
                            mediaPlayer.setIntOption(4024, 1);
                        }
                        _doSetWindowClient(this.mWindowClient);
                        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                            TTVideoEngineLog.i(logcatTag(), "renderstart change to texturesurface,time:" + (SystemClock.elapsedRealtime() - elapsedRealtime));
                        }
                    }
                } else if (this.mTextureSurface != null && this.mSurface != null && this.mSurfaceHolder == null) {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    if (this.mEnableMarkOffscreenRendering == 1) {
                        mediaPlayer.setIntOption(4024, 1);
                    }
                    mediaPlayer.setSurface(this.mTextureSurface);
                    this.mTextureSurface.updateRenderSurface(this.mSurface);
                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                        TTVideoEngineLog.i(logcatTag(), "renderstart change to texturesurface,time:" + (SystemClock.elapsedRealtime() - elapsedRealtime2));
                    }
                }
            } else if (this.mTextureSurface != null && (getConfigInt(587, this.mEnableForceDisableOESRender ? 1 : 0) != 1 || getConfigInt(588, this.mForceDisableOESRender ? 1 : 0) != 1)) {
                this.mPlayerFirstFrame = true;
                if (this.mTextureFirstFrame) {
                    TTVideoEngineLog.i(logcatTag(), "render start by player after texture");
                    _renderStart();
                }
            } else {
                TTVideoEngineLog.i(logcatTag(), "render start by player");
                _renderStart();
            }
            if (!isInHousePlayer()) {
                _streamChanged(0);
            }
            VideoSurface videoSurface2 = this.mTextureSurface;
            if (videoSurface2 != null && mediaPlayer != null) {
                videoSurface2.setIntOption(133, mediaPlayer.getIntOption(139, -1));
            }
        }
        return false;
    }

    public TTVideoEngineImpl(Context context, int i, TTVideoEngine tTVideoEngine) {
        Resolution resolution = Resolution.Undefine;
        this.mABR4GMaxResolutionIndex = resolution.getIndex();
        Resolution resolution2 = Resolution.SuperHigh;
        this.mWifiDefaultResolutionIndex = resolution2.getIndex();
        this.mStartupMaxBitRateIndex = resolution2.getIndex();
        this.mABRWithSR = 1;
        this.mABR4GMaxResolutionQuality = null;
        this.mWifiDefaultResolutionQuality = null;
        this.mStartupMaxBitRateQuality = null;
        this.mClassLoaderState = null;
        this.mDowngradeResolutionIndex = resolution.getIndex();
        this.mDowngradeResolutionQuality = null;
        this.mNativeCallAbr = 0;
        this.mABR4GMaxResolutionMode = 0;
        this.mABRSpeedPredictOutType = 0;
        this.mABRStartupBandwidthParameter = 0.9f;
        this.mABRStallPenaltyParameter = 9.0f;
        this.mABRSwitchPenaltyParameter = 2.0f;
        this.mABRBandwidthParameter = 1.0f;
        this.mABRProbeMode = 0;
        this.mABREnableAggressivePortraitLowBit = 0;
        this.mScreenWidth = -1;
        this.mScreenHeight = -1;
        this.mPlayerViewWidth = -1;
        this.mPlayerViewHeight = -1;
        this.mDisablePlayerStayAwake = 0;
        this.mEnableSpeedReport = false;
        this.mNetworkSpeedReportSamplingRate = 0.0f;
        this.mEnableNativeYV12Render = 0;
        this.mForceCloseCodec = 0;
        this.mFilePlayNoBuffering = 0;
        this.mNoBufferUpdate = 0;
        this.mClipHEAACV2FirstPtsPacket = 0;
        this.mEnableVideoTimestampMonotonic = 0;
        this.mFeedPacketUntilEmpty = 0;
        this.mEnableDemuxNonBlockRead = 0;
        this.mEnableThreadPriority = 0;
        this.mThreadPriorityValue = 0;
        this.mEnableVodVideoRenderStall = 0;
        this.mRenderStallThreshold = 0;
        this.mEnableOptInaccurateStart = 0;
        this.mEnableOptSeekClk = 0;
        this.mEnableAudioTrackSmoothClock = 0;
        this.mDisableSpiltVoiceWrite = 0;
        this.mIgnoreDirectlyBuffering = 0;
        this.mDynamicThreadPriorityValue = 0;
        this.mEnableMediaCodecRealtime = 1;
        this.mEnablePreRenderBufferingUpdate = 0;
        this.mPreRenderBufferingUpdatePercentage = 0;
        this.mEnableHEAACV2PtsMSCorrection = 0;
        this.mEnableVC1BlockList = 1;
        this.mEnableHChipAdaptiveWorkAround = 0;
        this.mEnableMChipSkipAdaptiveWorkAround = 0;
        this.mEnableCPPBYTEVC1CodecOpt = 0;
        this.mQuickGetFileCache = false;
        this.mReportFirstFrameFrameBufferOnly = 0;
        this.mEnbalePreDemux = 0;
        this.mEnableCPPBYTEVC2CodecOpt = 0;
        this.mEnableAudioMemIntergration = 0;
        this.mEnableBufferingLowerCapacity = 0;
        this.mEnableDowngradeAsyncCodec = 0;
        this.mEnableMediaCodecSyncClose = 0;
        this.mEnableSeekBuffering = 0;
        this.mBytevc2NalsizeCheck = 0;
        this.mHardwareCodecerFlushClose = 0;
        this.mOptAudioRenderTimeReport = 0;
        this.mBT601CloseCodecAsync = 0;
        this.mForbidFallbackNativeRender = 0;
        this.mDecoderRenderContinueRetry = 0;
        this.mDecoderRenderClearSurface = 0;
        this.mDecoderRenderClearTextureRenderRef = 0;
        this.mEnableDecoderRenderVC2RenderLatency = 0;
        this.mDecoderRenderVC2RenderLatencyGeneral = 0;
        this.mDecoderRenderVC2RenderLatencySR = 0;
        this.mTraceId = "";
        this.mEnableLooperThread = false;
        this.mBashDashDefaultMDLKeys = new HashMap<>();
        this.mSubPathInfo = null;
        this.mFileHashs = new ArrayList();
        this.mReadCacheMode = 0;
        this.mBindCore = 0;
        this.mCheckSilenceInterval = -1;
        this.mEnableBarrageMask = 0;
        this.mEnableMaskThread = 0;
        this.mEnableAIBarrageThread = 0;
        this.mEnableAIBarrage = 0;
        this.mLiveStartIndex = -3;
        this.mEnableRefreshByTime = 0;
        this.mEnableSub = 0;
        this.mEnableSubThread = 0;
        this.mOpenSubRetryTimes = -1;
        this.mEnableOptSubSearch = 0;
        this.mEnableRecreateSubIfDetached = 0;
        this.mCurPosition = -1;
        this.mPosUpdateInterval = 0;
        this.mAudioCodecProfile = -1;
        this.mVideoCodecProfile = -1;
        this.mBitrate = -1L;
        this.mContainerFPS = 0.0f;
        this.mThreadSafeRefSwitcher = 0;
        this.mEnableNetLevel = 0;
        this.mNetSpeedInterval = 0;
        this.mCloseRenderStartMsgOnSwitchResolutionDone = false;
        this.mEnableFastStop = 0;
        this.mEnableCodecRecycle = 0;
        this.mTlsLog = 0;
        this.mIntertrustDrmHelper = null;
        this.mFrameCount = 0;
        this.mHeartBeatStarted = false;
        this.mEnableHeartBeat = false;
        this.mGetPositionSkipLooper = false;
        this.mPlayDurationExcludePlayerMethod = false;
        this.mHeartBeatInterval = 300;
        this.mSRNotUseReason = 0;
        this.mSendEngineMsgTimeout = 0L;
        this.mMediacodecStopTimeout = 0;
        this.mQueryWinEnable = -1;
        this.mPreferNearestMaxPosOffset = -1;
        this.mMediaCodecAsyncModeEnable = -1;
        this.mSettingCodecName = -1;
        this.mPrivCodecName = new ArrayList<>();
        this.mAVsyncRefined = -1;
        this.mOnlyPlayAudioForBothStream = -1;
        this.mIgnoreSurfaceCreated = -1;
        this.mNativeRenderRotationAdapt = 0;
        this.mEnableOutletDropLimit = false;
        this.mPreciseCache = 0;
        this.mMediaInfoMap = new ConcurrentHashMap();
        this.mEnableClockResumeResetEof = 0;
        this.mMdlEnableSeekReopen = 0;
        this.mIgnoreAudioRenderEOSDelayMs = 0;
        this.mAutoAddMedia = 1;
        this.mEnableOptimizeMp4Abr = 0;
        this.mEnableMediaCodecFairMutex = 0;
        this.mEnableRangeOptimize = 0;
        this.mThreadName2CharSuffix = 0;
        this.mEnableOptimizePrerender = 0;
        this.mEnableAsyncDownload = 0;
        this.mEnablePreloadGear = 0;
        this.mEnableAsyncProbe = 0;
        this.mEnableOptimizeAsyncDownload = 0;
        this.mMetrcisAbility = 0;
        this.mMetrcisInterVal = 60;
        this.mEnableCacheInfo = 0;
        this.mEnableOptimizeRadioMode = 0;
        this.mEnableOptimizeIO = 0;
        this.mEnableOptimizeDashSeek = 0;
        this.mAnRenderRefreshSurface = 0;
        this.mSurfaceRecord = null;
        this.mFFmpegProtocol = null;
        this.mForceCodec = null;
        this.mSkipStartWhenPrepared = false;
        this.mEnableMp4Check = 0;
        this.mPrecisePausePts = 0L;
        this.mHlsSubDemuxerProbeType = -1;
        this.mEnableTmpLog = 0;
        this.mCodecAndSurfaceReuse = -1;
        this.mMCMaxWidth = -1;
        this.mMCMaxHeight = -1;
        this.mAsyncManageResource = -1;
        this.mAudioUseDirectBuffer = -1;
        this.mCloseCodecPool = -1;
        this.mMaxCodecNumsInPool = -1;
        this.mDummySurfaceForbid = -1;
        this.mCalibrationAudioPts = -1;
        this.mAudioPtsCalibrationType = -1;
        this.mSetSurfaceRetryCount = -1;
        this.mSetSurfaceRetryInterval = -1;
        this.mChangeRecBufferSpeed = -1;
        this.mEnableVideoSecondFrame = -1;
        this.mGiveBackCodecEarly = -1;
        this.mWaitingCodecMs = -1;
        this.mAsyncSetWindow = -1;
        this.mAutoDisconnectedCpu = -1;
        this.mRetryErrCnt = -1;
        this.mForbidBufferingNotFinished = -1;
        this.mUseVdpDisk = -1;
        this.mMdlUseOriginalUrlEncode = -1;
        this.mEnableReportFirstAVSyncFrame = 1;
        this.mQueryAdaptivePlayback = -1;
        this.mFlushWhenSetSurface = -1;
        this.mEnableMediaCodecDeathCheck = -1;
        this.mMediaCodecDeathCheckInterval = -1;
        this.mMediaCodecDeathTimeout = -1;
        this.mCodecPoolSupportDynamicExtend = -1;
        this.mDynamicExtendCodecNums = -1;
        this.mEnableOptimizeHWDec2SWDec = -1;
        this.mCreateAudioTrackEarly = -1;
        this.mEnableMediaCodecPipeline = -1;
        this.mFrameNumsInMediaCodec = -1;
        this.mEnableMCRenderHandleSAR = -1;
        this.mRecBufferThresh = -1;
        this.mRecBufferType = -1;
        this.mUserExitTimeMs = -1;
        this.mAudioGraphRefactor = -1;
        this.mAudioDecoderGraphMerged = -1;
        this.mCodecPoolVersion = -1;
        this.mDiscardCodecStrategy1 = -1;
        this.mDiscardCodecStrategy2 = -1;
        this.mCodecHistoryLength = -1;
        this.mCodecMaxUsedCount = -1;
        this.mEnableFallbackInMaxInstanceErr = -1;
        this.mSetSurfaceDirectly = -1;
        this.mEnableStartPlaySync = -1;
        this.mEnableClearTextureRefAsync = 0;
        this.mEnableSetupMediaCodec = false;
        this.mEnableSCABRStrategy = false;
        this.mFixDashInitUrlLog = false;
        this.mRefreshSurfaceFlag = false;
        this.mRefreshSurfaceDone = false;
        this.mRefreshTextureSurface = false;
        this.effectTypeSet = new CopyOnWriteArraySet();
        this.mEnableReportPreloadTraceId = false;
        this.mErrorThrowOptEnable = false;
        this.mErrorRetryOpt = false;
        this.mMDLGroupId = null;
        this.mInitialUrlBeforeMdlProxy = null;
        this.mBashRetryRestartPlayer = false;
        this.mForceShutDownOldSource = 0;
        this.mFormat = null;
        this.mCustomBitrate = -1;
        this.mEnableExchangeUrlWhenRetry = false;
        this.mEnableRefreashCodecStatus = false;
        this.mAEEnableReadAudioSDKAPI2InfoFromStream = false;
        this.mEnableAudioSDKReportOpt = false;
        this.mRefactorSurface = null;
        this.mWindowWidth = 0;
        this.mWindowHeight = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mWindowClient = null;
        this.mWindowClientExternal = null;
        this.mIsEnabelUsedRefactorSurfaceView = 0;
        this.mIsNewPlayerViewUsedExternal = false;
        this.mIsHijackRetryStragy = -2;
        this.mIsEnableHijackReportOpt = -1;
        this.mDaspSignals = new ArrayList();
        this.mEngineWrapper = tTVideoEngine;
        if (EngineGlobalConfig.getInstance().getLazyLoadVideodec() != 1) {
            TTVideoEngineLog.d(logcatTag(), "JniUtils.loadLibrary in TTVideoEngineImpl new");
            JniUtils.loadLibrary();
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "init, type:" + i + ", this:" + this + ", version:1.10.252.100-novel");
        }
        initEngine(context, i, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$snapshot$d0aa4498$1(SnapshotListener snapshotListener, ByteBuffer byteBuffer, int i, int i2) {
        if (byteBuffer == null) {
            snapshotListener.onSnapShot(null, 0, 0);
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(byteBuffer);
            snapshotListener.onSnapShot(createBitmap, i, i2);
        }
        return 0;
    }

    private static HashMap<String, Object> generateCrosstalkMap(String str, String str2, int i, String str3) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("tag", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("subtag", str2);
        }
        hashMap.put("islive", Integer.valueOf(i));
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("enginehash", str3);
        }
        return hashMap;
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSRInitConfig(int i, String str, String str2, String str3) {
        this.mOldTextureAlgType = this.mTextureAlgType;
        this.mTextureAlgType = i;
        this.mTextureSRBinPath = str;
        this.mTextureSROclModuleName = str2;
        this.mTextureSRDspModuleName = str3;
        this.mLogger.setSrAlgorithm(i);
        this.mLogger.setEnableBmfSr(EngineGlobalConfig.getInstance().getEnableBmf());
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "[SRLog]sr init config = " + this.mTextureAlgType + "," + this.mTextureSRBinPath + "," + this.mTextureSROclModuleName + ", " + this.mTextureSRDspModuleName);
        }
    }

    @TargetClass("com.ss.ttvideoengine.TTVideoEngineImpl")
    @Insert("initEngine")
    public static void com_ss_ttvideoengine_TTVideoEngineImpl_com_dragon_read_aop_TTVideoEngineAop_initEngine(TTVideoEngineImpl tTVideoEngineImpl, Context context, int i, Map map) {
        if (QualityOptExperiment.INSTANCE.getConfig().engineLooperEnable) {
            LogWrapper.info("AudioCore-TTVideoEngineAops", "VideoEngineLooper enable by setting", new Object[0]);
            map = b0.o(map);
        }
        tTVideoEngineImpl.TTVideoEngineImpl__initEngine$___twin___(context, i, map);
        if (!b0.d.getAndSet(true)) {
            LogWrapper.info("AudioCore-TTVideoEngineAops", "init common config", new Object[0]);
            TTVideoEngine.setTTDNSServerHost("dig.bdurl.net");
            PlayerGlobalConfig b = PlayerGlobalConfig.b();
            if (b.enableThread2Pool) {
                tTVideoEngineImpl.setIntOption(5024, 1);
                tTVideoEngineImpl.setIntOption(5025, b.thread2PoolSize);
            }
            if (b.threadStackSizeOpt) {
                tTVideoEngineImpl.setIntOption(4020, 1);
                tTVideoEngineImpl.setIntOption(4021, b.threadStackSizeValue);
            }
        }
        tTVideoEngineImpl.setIntOption(160, 1);
        tTVideoEngineImpl.setCacheControlEnabled(true);
        if (EngineNetReport.b().enable) {
            tTVideoEngineImpl.setIntOption(604, EngineNetReport.b().sampleInterval);
            tTVideoEngineImpl.setIntOption(605, EngineNetReport.b().maxSampleCount);
            tTVideoEngineImpl.setStringOption(715, EngineNetReport.b().networkQualityString);
        }
        if (AudioPtsOpt.b().enableGlobal) {
            tTVideoEngineImpl.setIntOption(987, AudioPtsOpt.b().calibrationAudioPts);
            tTVideoEngineImpl.setIntOption(565, AudioPtsOpt.b().disableSpiltVoiceWrite);
        }
        if (EngineNetReport.b().enable) {
            tTVideoEngineImpl.setIntOption(857, EngineNetReport.b().updateInterval);
        }
        if (MediacodecAsyncConfig.b().enable) {
            tTVideoEngineImpl.setIntOption(955, 1);
            tTVideoEngineImpl.setIntOption(42087, MediacodecAsyncConfig.b().fixMediacodecCrash ? 1 : 0);
        }
        if (MediacodecAsyncConfig.b().fixMediacodecAsyncCrash) {
            tTVideoEngineImpl.setIntOption(46074, MediacodecAsyncConfig.b().fixMediacodecAsyncCrash ? 1 : 0);
        }
        if (TTVideoEngineLogOptV689.b().enable == 1) {
            tTVideoEngineImpl.setIntOption(46034, 1);
            tTVideoEngineImpl.setIntOption(46035, (int) TTVideoEngineLogOptV689.b().interval);
        }
        try {
            LogWrapper.info("AudioCore-TTVideoEngineAops", "initEngine ,type = " + i, new Object[0]);
        } catch (Throwable th) {
            LogWrapper.error("AudioCore-TTVideoEngineAops", "initEngine ,exception = " + th.getMessage(), new Object[0]);
        }
    }

    public void setDirectUrlUseDataLoader(String[] strArr, String str, String str2, String str3, int i) {
        this.mFormat = str3;
        this.mCustomBitrate = i;
        if (this.mLooperThread.checkEngineLooperThread(false)) {
            this.mLooperThread.postEngineMessage(20, 0, 0, strArr, str, str2);
        } else {
            _doSetDirectUrlUseDataLoader(strArr, str, str2, 0L, null);
        }
    }

    void _doSetDirectUrlUseDataLoader(String[] strArr, String str, String str2, long j, String[] strArr2) {
        String str3;
        if (strArr != null && strArr.length != 0) {
            boolean z = false;
            if (!TextUtils.isEmpty(strArr[0])) {
                this.mInitialUrlBeforeMdlProxy = strArr[0];
                if (TextUtils.isEmpty(str)) {
                    _doSetDirectURL(strArr[0], strArr);
                    this.mLogger.setIntOption(174, IVideoEventLogger.MdlInvalidCode.EmptyKey.ordinal());
                } else if (getConfigInt(160, this.mDataLoaderEnable) == 0) {
                    _doSetDirectURL(strArr[0], strArr);
                    this.mLogger.setIntOption(174, IVideoEventLogger.MdlInvalidCode.OptionNotSet.ordinal());
                } else {
                    _resetUsingDataLoaderField();
                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                        TTVideoEngineLog.i(logcatTag(), "setDirectUrlUseDataLoader key = " + str + ", videoId = " + str2);
                    }
                    String _mdlUrl = _mdlUrl(str, str2, getConfigInt(161, this.mLimitMDLCacheSize), strArr, Resolution.Undefine, this.mDecryptionKey, null, null, null, j, strArr2, this.mRetryErrCnt);
                    if (!this.mFileHashs.contains(str)) {
                        this.mFileHashs.add(str);
                    }
                    if (TextUtils.isEmpty(_mdlUrl)) {
                        _doSetDirectURL(strArr[0], strArr);
                        str3 = str2;
                    } else {
                        str3 = str2;
                        this.mVideoID = str3;
                        if (getConfigInt(606, this.mEnableDirectUrlCheck) == 1) {
                            int length = strArr.length;
                            int i = 0;
                            while (true) {
                                if (i >= length) {
                                    break;
                                }
                                if (URLUtil.isValidUrl(strArr[i])) {
                                    z = true;
                                    break;
                                }
                                i++;
                            }
                            if (!z) {
                                TTVideoEngineLog.e(logcatTag(), "invalid urls list, all url invalid");
                                receivedError(new Error("kTTVideoErrorDomainVideoOwnPlayer", -9966, "Direct url is invalid url."));
                                return;
                            }
                        }
                        _doSetDirectURL(_mdlUrl, strArr);
                        StrategyHelper.buildMediaInfo(this.mMediaInfoMap, str3, str, strArr);
                    }
                    IVideoEventLogger iVideoEventLogger = this.mLogger;
                    if (iVideoEventLogger != null) {
                        iVideoEventLogger.setProxyUrl(_mdlUrl);
                    }
                    this.mVideoID = str3;
                    return;
                }
                str3 = str2;
                this.mVideoID = str3;
                return;
            }
        }
        TTVideoEngineLog.e(logcatTag(), "invalid urls list, it is empty");
    }

    private class IpInfo {
        public String dns;
        public String ip;
        public int isDNSCacheOpen;
        public int isServerDNSOpen;
        public String urlDesc;

        static {
            Covode.recordClassIndex(652336);
        }

        public IpInfo(String str, String str2, int i, int i2, String str3) {
            this.ip = str;
            this.dns = str2;
            this.isDNSCacheOpen = i;
            this.isServerDNSOpen = i2;
            this.urlDesc = str3;
        }
    }

    @Override // com.ss.ttvideoengine.TTVideoEngineInterface
    public void setSRInitConfig(int i, String str, String str2, String str3, int i2, int i3, int i4) {
        this.mOldTextureAlgType = this.mTextureAlgType;
        this.mTextureAlgType = i;
        this.mTextureSRBinPath = str;
        this.mTextureSROclModuleName = str2;
        this.mTextureSRDspModuleName = str3;
        this.mSrBackend = i2;
        this.mSrScaleType = i3;
        this.mSrPoolSize = i4;
        IVideoEventLogger iVideoEventLogger = this.mLogger;
        if (iVideoEventLogger != null) {
            iVideoEventLogger.setSrAlgorithm(i);
            this.mLogger.setSrScaleType(i3);
            this.mLogger.setEnableBmfSr(EngineGlobalConfig.getInstance().getEnableBmf());
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i(logcatTag(), "[SRLog]sr init config = " + this.mTextureAlgType + "," + this.mTextureSRBinPath + "," + this.mTextureSROclModuleName + ", " + this.mTextureSRDspModuleName);
        }
    }

    private String _mdlUrl(String str, String str2, long j, String[] strArr, Resolution resolution, String str3, VideoInfo videoInfo, String str4, String str5, long j2, String[] strArr2, int i) {
        boolean z;
        boolean z2;
        String str6;
        String str7;
        boolean equals = "hls".equals(this.mFormatType);
        IVideoModel iVideoModel = this.mVideoModel;
        if (iVideoModel != null && iVideoModel.hasFormat(IVideoModel.Format.HLS)) {
            z = true;
        } else {
            z = equals;
        }
        if (this.mPlayerType != 0 && (getConfigInt(5010, this.mExoEnableNativeMdl ? 1 : 0) == 0 || this.mPlayerType != 5)) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i(logcatTag(), "force disable native mal because play type: " + this.mPlayerType);
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d(logcatTag(), "cdn type is: " + this.mP2PCDNType);
        }
        String _proxyUrl = DataLoaderHelper.getDataLoader()._proxyUrl(str, str2, j, strArr, resolution, str3, videoInfo, str4, str5, z2, z, this.mTTHlsDrmToken, j2, strArr2, i, this.mEngineHash, false, this.mMdlUseOriginalUrlEncode, this.mHlsProxyVVEnable);
        int mdlInvalidCode = DataLoaderHelper.getDataLoader().getMdlInvalidCode();
        if (mdlInvalidCode > 0) {
            this.mLogger.setIntOption(174, mdlInvalidCode);
            if (mdlInvalidCode == IVideoEventLogger.MdlInvalidCode.StateError.ordinal()) {
                loggerSetMdlInitializeState();
            }
        }
        if (!TextUtils.isEmpty(_proxyUrl)) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                String logcatTag = logcatTag();
                StringBuilder sb = new StringBuilder();
                sb.append("_mdlUrl get proxyUrl: key = ");
                str6 = str;
                sb.append(str6);
                sb.append(", videoId = ");
                str7 = str2;
                sb.append(str7);
                TTVideoEngineLog.i(logcatTag, sb.toString());
            } else {
                str6 = str;
                str7 = str2;
            }
            if (this.mEnableTmpLog == 1) {
                showLongLog(_proxyUrl);
            }
            if (_proxyUrl.startsWith("mdl://")) {
                this.mLogger.setEnableMDL(2);
                if (this.mFirstURL) {
                    this.mLogger.setIntOption(173, 2);
                }
            } else {
                this.mLogger.setEnableMDL(1);
                if (this.mFirstURL) {
                    this.mLogger.setIntOption(173, 1);
                }
            }
            this.mLogger.setProxyUrl(_proxyUrl);
            if (TextUtils.isEmpty(str2)) {
                str7 = str6;
            }
            this.mUsingDataLoaderPlayRawKey = str7;
            if (!TextUtils.isEmpty(str4)) {
                this.mUsingDataLoaderPlayFilePaths.add(str4);
            }
            if (!TextUtils.isEmpty(str)) {
                this.mUsingDataLoaderPlayTaskKeys.add(str6);
            }
            _dataLoaderAddEngineRef();
        }
        return _proxyUrl;
    }
}
