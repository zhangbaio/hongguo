package com.ss.ttvideoengine;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.vcloud.strategy.IPreloadTaskCallbackListener;
import com.bytedance.vcloud.strategy.ISelectBitrateListener;
import com.bytedance.vcloud.vctrace.VCTrace;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.mediakit.medialoader.AVMDLCopyOperation;
import com.ss.mediakit.medialoader.AVMDLCopyOperationListener;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.ss.mediakit.medialoader.AVMDLDataLoaderListener;
import com.ss.mediakit.medialoader.AVMDLDataLoaderNotifyInfo;
import com.ss.mediakit.medialoader.AVMDLFileInfo;
import com.ss.mediakit.medialoader.AVMDLLog;
import com.ss.mediakit.medialoader.AVMDLStartCompleteListener;
import com.ss.mediakit.medialoader.AVMDLTaskEventListener;
import com.ss.mediakit.medialoader.LoaderListener;
import com.ss.mediakit.net.AVMDLDNSParser;
import com.ss.mediakit.net.AVMDLMultiNetwork;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.VideoModelCache;
import com.ss.ttvideoengine.cache.CopyCacheItem;
import com.ss.ttvideoengine.cache.CopyCacheListener;
import com.ss.ttvideoengine.download.Downloader;
import com.ss.ttvideoengine.fetcher.VideoInfoFetcher;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.ss.ttvideoengine.log.IVideoEventUploader;
import com.ss.ttvideoengine.log.PortraitNetworkScore;
import com.ss.ttvideoengine.log.VideoEventBase;
import com.ss.ttvideoengine.log.VideoEventEngineUploader;
import com.ss.ttvideoengine.model.IVideoInfo;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.net.NetUtils;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.portrait.PortraitChangeListener;
import com.ss.ttvideoengine.preload.PreloadConfig;
import com.ss.ttvideoengine.preload.PreloadLoadProgressCenter;
import com.ss.ttvideoengine.preload.PreloadMedia;
import com.ss.ttvideoengine.preload.PreloadModelMedia;
import com.ss.ttvideoengine.preload.PreloadScene;
import com.ss.ttvideoengine.preload.PreloadTaskConfig;
import com.ss.ttvideoengine.preload.PreloadURLMedia;
import com.ss.ttvideoengine.preload.PreloadUtil;
import com.ss.ttvideoengine.selector.strategy.GearStrategySC;
import com.ss.ttvideoengine.setting.SettingsHelper;
import com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter;
import com.ss.ttvideoengine.source.strategy.SmartUrlFetcher;
import com.ss.ttvideoengine.strategrycenter.ISelectBitrateCallback;
import com.ss.ttvideoengine.strategrycenter.StrategyHelper;
import com.ss.ttvideoengine.strategy.StrategyManager;
import com.ss.ttvideoengine.utils.ABLock;
import com.ss.ttvideoengine.utils.ABLockWrapper;
import com.ss.ttvideoengine.utils.DataLoaderCDNLog;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.FormatProvider;
import com.ss.ttvideoengine.utils.MDLExtraInfoHelper;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import com.ss.ttvideoengine.utils.ValueWeakReference;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DataLoaderHelper implements AVMDLDataLoaderListener, AVMDLStartCompleteListener, PortraitChangeListener {
    public static final int DATALOADER_KEY_INT_ENABLE_P2P_STRAGETY_CONTROL = 95;
    public static final int DATALOADER_KEY_INT_P2P_LEVEL = 16;
    private volatile boolean isProxyLibraryLoaded;
    private DataLoaderTaskQueue mAllPlayTasks;
    private DataLoaderTaskQueue mAllPreloadTasks;
    private final HashMap<String, ArrayList<WeakReference<TTVideoEngine>>> mAllUsingEngies;
    private boolean mAudioPreloadFirst;
    private int mBackupLoaderType;
    private ClassLoader mClasssLoader;
    private boolean mCloseLocalServer;
    private AVMDLDataLoaderConfigure mConfigure;
    private Context mContext;
    private int mCurrentAccessType;
    private int mDashAudioPreloadMinSize;
    private int mDashAudioPreloadRatio;
    private DataLoaderHelperAdapter mDataLoaderHelperAdapter;
    private long mDemuxerHandle;
    private boolean mDidConfigMdlV2;
    private int mDisableFilePathCheck;
    private int mEnableBackupIP;
    private int mEnableBufferPreload;
    private int mEnableCenterPreloadProgressCallback;
    private int mEnableCheckHLSProxyVVCtrl;
    private int mEnableCheckPreloadUrls;
    private int mEnableDumpLibMd5;
    private int mEnableFirstNativeMDL;
    private int mEnableHLSProxy;
    private int mEnableHls;
    private int mEnableLibManager;
    private int mEnableLoadMdlv2Fulllib;
    private boolean mEnableMdlProtocol;
    private int mEnableMdlV2;
    private int mEnableNetworkChangedListen;
    private int mEnableNotOnlyNotifyNetError;
    private int mEnableNotifyError;
    private int mEnablePreParseHost;
    private int mEnablePreloadAllTs;
    private int mEnablePreloadFirstTs;
    private int mEnableReportSpeed;
    private int mEnableSetMDLNetStatus;
    private int mEnableSplitPreload;
    private int mEnableStrategyCenterCancelAll;
    private int mEnableVideoModelHitCacheCallback;
    private final ReentrantLock mEngineLock;
    private VideoEventEngineUploader mEngineUploader;
    private Exception mException;
    private DataLoaderTaskQueue mExecuteTasks;
    private int mFloatSize;
    private boolean mForbidNativeMDLForOriUrl;
    private boolean mHLSProxyValid;
    private DataLoaderHeartBeat mHeartBeat;
    private int mHeartBeatInterval;
    private String mInitializeErrorString;
    private int mInitializeState;
    private AVMDLDataLoader mInnerDataLoader;
    private volatile boolean mInnerDataloaderStartComplete;
    private int mInvalidCode;
    private boolean mInvalidMdlProcotol;
    private final DataLoaderListenerWrapper mListener;
    private final ABLockWrapper mLock;
    private int mMdlDataSourceId;
    private int mMdlOldPreloadStrategy;
    private int mMdlPreloadStrategy;
    private long mMdlProtocolHandle;
    private VideoModelCache mModelCache;
    private int mNeedDLLoadP2PLib;
    private boolean mNeedMDLLoadMDLV2Lib;
    private int mNeedSpeedTestByTimeInternal;
    private TTNetworkStateCallback mNetWorkChangeCb;
    private WeakReference<TTNetworkStateCallback> mNetWorkChangeCbr;
    private ArrayList<Integer> mNotifyNetErrors;
    private int mPreloadPreConnect;
    private int mPreloadTaskIgnorePlayerStall;
    private DataLoaderTaskQueue mPreloadTasks;
    private final PreloadUtil mPreloadUtil;
    private volatile LibraryLoaderProxy mProxy;
    private volatile boolean mReportLogEnable;
    private volatile int mState;
    private boolean mSupportHls;
    private TestSpeedListener mTestSpeedListener;
    private String mUpdatePlaySourceId;
    private IVideoEventUploader mUploader;
    private VCTrace mVCTrace;
    private String mVersionInfo;
    private PreloadMediaThread mediaOperateThread;

    private interface TaskListener {
        void taskFinished(DataLoaderTaskItem dataLoaderTaskItem);
    }

    static {
        Covode.recordClassIndex(652251);
    }

    private String _apiStringForVid(PreloaderVidItem preloaderVidItem) {
        return null;
    }

    private void startVCTrace() {
    }

    public void addPreloadUrlMedia(PreloadURLMedia preloadURLMedia) {
    }

    public long getInt64Value(int i, long j) {
        return 0L;
    }

    String getNetworkName(long j) {
        int i = (int) j;
        if (i == 0) {
            return "default";
        }
        if (i == 1) {
            return "cellular";
        }
        if (i != 2) {
            return null;
        }
        return "wifi";
    }

    public int getProbeIntervalMS() {
        return -1;
    }

    public int getProbeType() {
        return 0;
    }

    public void p2pPredown(String str) {
    }

    public float playTaskProgress() {
        return -1.0f;
    }

    public void removePreloadMedia(PreloadMedia preloadMedia, String str) {
    }

    public void setNetworkClient(TTVNetClient tTVNetClient) {
    }

    public void setPlayTaskProgress(float f) {
    }

    public void setProbeIntervalMS(int i) {
    }

    public void setProbeType(int i) {
    }

    public void setTaskConfigs(List<PreloadTaskConfig> list) {
    }

    private static class Holder {
        private static DataLoaderHelper instance;

        private Holder() {
        }

        static {
            Covode.recordClassIndex(652265);
            instance = new DataLoaderHelper();
        }
    }

    public int getMdlInitializeState() {
        return this.mInitializeState;
    }

    public void addTask(String str, String str2, VideoModel videoModel, Resolution resolution, long j) {
        addTask(new PreloaderVideoModelItem(videoModel, resolution, j, (PreloaderFilePathListener) null));
    }

    public void addTask(String str, String str2, String str3, long j) {
        if (TextUtils.isEmpty(str3)) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] url invalid.");
        } else {
            addTask(new PreloaderURLItem(str, str2, j, new String[]{str3}));
        }
    }

    public void addTask(String str, String str2, String[] strArr, long j) {
        if (strArr == null || strArr.length == 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "urls invalid.");
        } else {
            addTask(new PreloaderURLItem(str, str2, j, strArr));
        }
    }

    public void addTask(String str, String str2, String[] strArr, long j, String str3) {
        if (strArr == null || strArr.length == 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "urls invalid.");
        } else {
            addTask(new PreloaderURLItem(str, str2, j, strArr, str3));
        }
    }

    public void addTask(String str, String str2, long j, String str3) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.e("DataLoaderHelper", "url invalid.");
        } else {
            addTask(new String[]{str}, str2, j, str3);
        }
    }

    public void addTask(String[] strArr, String str, long j, String str2) {
        if (strArr == null || strArr.length == 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "urls invalid.");
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            String keyFromFilePath = TTHelper.keyFromFilePath(this.mContext, str2);
            PreloaderURLItem preloaderURLItem = new PreloaderURLItem(str, j, strArr, str2);
            preloaderURLItem.setKey(keyFromFilePath);
            addTask(preloaderURLItem);
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    public void addTask(String str, String str2, long j, DataLoaderResourceProvider dataLoaderResourceProvider, String str3) {
        if (dataLoaderResourceProvider == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "provider invalid.");
        } else {
            addTask(new PreloaderURLItem(str, str2, j, dataLoaderResourceProvider, str3));
        }
    }

    public void setIntValue(int i, int i2) {
        this.mLock.lock(ABLock.TYPE_READ);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d("DataLoaderHelper", "setIntValue key = " + i + ", value = " + i2);
        }
        try {
            try {
                if (i == 1) {
                    this.mConfigure.mMaxCacheSize = i2;
                } else if (i == 2) {
                    this.mConfigure.mRWTimeOut = i2;
                } else if (i == 3) {
                    this.mConfigure.mOpenTimeOut = i2;
                } else if (i == 4) {
                    this.mConfigure.mTryCount = i2;
                } else if (i == 5) {
                    this.mConfigure.mLoaderType = i2;
                } else if (i == 7) {
                    this.mConfigure.mEnableExternDNS = i2;
                } else if (i == 8) {
                    this.mConfigure.mEnableSocketReuse = i2;
                } else if (i == 9) {
                    this.mConfigure.mSocketIdleTimeOut = i2;
                } else if (i == 55) {
                    this.mConfigure.mMaxCacheAge = i2;
                } else if (i == 56) {
                    this.mConfigure.mEnableMaxCacheAgeForAllDir = i2;
                } else if (i == 60) {
                    this.mConfigure.mEnablePreloadReUse = i2;
                } else if (i == 61) {
                    this.mHeartBeatInterval = i2;
                } else if (i == 100) {
                    this.mConfigure.mMaxTlsVersion = i2;
                } else if (i != 101) {
                    switch (i) {
                        case 11:
                            this.mConfigure.mPreloadParallelNum = i2;
                            AVMDLDataLoader aVMDLDataLoader = this.mInnerDataLoader;
                            if (aVMDLDataLoader != null) {
                                aVMDLDataLoader.setIntValue(102, i2);
                                break;
                            }
                            break;
                        case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                            if (i2 >= 100) {
                                AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure = this.mConfigure;
                                this.mMdlOldPreloadStrategy = aVMDLDataLoaderConfigure.mPreloadStrategy;
                                aVMDLDataLoaderConfigure.mPreloadStrategy = 100;
                            } else {
                                AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure2 = this.mConfigure;
                                this.mMdlOldPreloadStrategy = aVMDLDataLoaderConfigure2.mPreloadStrategy;
                                aVMDLDataLoaderConfigure2.mPreloadStrategy = i2;
                            }
                            this.mMdlPreloadStrategy = i2;
                            if (i2 == 200) {
                                this.mConfigure.mEnableIOManager = 1;
                                break;
                            }
                            break;
                        case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                            this.mConfigure.mCheckSumLevel = i2;
                            break;
                        case 14:
                            this.mConfigure.mTestSpeedTypeVersion = i2;
                            break;
                        case 15:
                            this.mNeedDLLoadP2PLib = i2;
                            break;
                        default:
                            switch (i) {
                                case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                                        TTVideoEngineLog.i("DataLoaderHelper", "set write file notify intervalMS " + i2);
                                    }
                                    this.mConfigure.mWriteFileNotifyIntervalMS = i2;
                                    break;
                                case 18:
                                    this.mPreloadTaskIgnorePlayerStall = i2;
                                    break;
                                case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                                    this.mFloatSize = i2;
                                    break;
                                case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                                    this.mPreloadPreConnect = i2;
                                    break;
                                case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                                    this.mConfigure.mEnableDownloaderLog = i2;
                                    break;
                                case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                                    this.mConfigure.mEnableTTNetLoader = i2;
                                    break;
                                case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                                    this.mConfigure.mTTNetLoaderCronetBufSizeKB = i2;
                                    break;
                                case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                                    this.mConfigure.mEnableTTQuicHeLoader = i2;
                                    break;
                                case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                                    this.mConfigure.mEnableTTQuicHeLoaderCheckWithNetworkType = i2;
                                    break;
                                case 50:
                                    this.mConfigure.mIsCloseFileCache = i2;
                                    break;
                                case 80:
                                    this.mConfigure.mPreloadWaitListType = i2;
                                    break;
                                case 103:
                                    AVMDLDNSParser.setIntValue(4, i2);
                                    break;
                                case 104:
                                    AVMDLDNSParser.setIntValue(5, i2);
                                    break;
                                case 105:
                                    AVMDLDNSParser.setIntValue(6, i2);
                                    break;
                                case 106:
                                    AVMDLDNSParser.setIntValue(7, i2);
                                    break;
                                case 112:
                                    this.mConfigure.mSpeedSampleInterval = i2;
                                    break;
                                case 113:
                                    this.mConfigure.mGlobalSpeedSampleInterval = i2;
                                    AVMDLDataLoader aVMDLDataLoader2 = this.mInnerDataLoader;
                                    if (aVMDLDataLoader2 != null) {
                                        aVMDLDataLoader2.setIntValue(7370, i2);
                                        break;
                                    }
                                    break;
                                case 119:
                                    SettingsHelper.helper().setEnable(i2);
                                    break;
                                case 121:
                                    this.mConfigure.mUseNewSpeedTestForSingle = i2;
                                    break;
                                case 123:
                                    if (i2 > 0) {
                                        this.mConfigure.mDeviceScoreEx = i2;
                                        break;
                                    }
                                    break;
                                case 200:
                                    this.mConfigure.mEnableEventInfo = i2;
                                    break;
                                case 500:
                                    this.mConfigure.mLiveP2pAllow = i2;
                                    break;
                                case 501:
                                    this.mConfigure.mLiveLoaderType = i2;
                                    break;
                                case 502:
                                    this.mConfigure.mLiveLoaderEnable = i2;
                                    break;
                                case 505:
                                    this.mConfigure.mLiveWatchDurationThreshold = i2;
                                    break;
                                case 506:
                                    this.mConfigure.mLiveCacheThresholdHttpToP2p = i2;
                                    break;
                                case TTVideoEngineInterface.PLAYER_OPTION_ABR_4GMAX_RESOULUTION_MODE /* 507 */:
                                    this.mConfigure.mLiveCacheThresholdP2pToHttp = i2;
                                    break;
                                case 508:
                                    this.mConfigure.mLiveMaxTrySwitchP2pTimes = i2;
                                    break;
                                case 509:
                                    this.mConfigure.mLiveWaitP2pReadyThreshold = i2;
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_DIR /* 510 */:
                                    this.mConfigure.mLiveMobileUploadAllow = i2;
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_FILENAME /* 511 */:
                                    this.mConfigure.mLiveMobileDownloadAllow = i2;
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_APPID /* 512 */:
                                    this.mConfigure.mAlogEnable = i2;
                                    AVMDLDataLoader aVMDLDataLoader3 = this.mInnerDataLoader;
                                    if (aVMDLDataLoader3 != null) {
                                        aVMDLDataLoader3.setIntValue(7225, i2);
                                        break;
                                    }
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_ID /* 513 */:
                                    this.mConfigure.mLiveRecvDataTimeout = i2;
                                    break;
                                case 1000:
                                    if (this.mEnableNetworkChangedListen == 1) {
                                        clearNetinfoCache();
                                        AVMDLDataLoader aVMDLDataLoader4 = this.mInnerDataLoader;
                                        if (aVMDLDataLoader4 != null) {
                                            aVMDLDataLoader4.setIntValue(7217, 1);
                                            break;
                                        }
                                    }
                                    break;
                                case 1001:
                                    this.mConfigure.mEnablePreconnect = i2;
                                    break;
                                case 1002:
                                    this.mConfigure.mPreconnectNum = i2;
                                    break;
                                case 1004:
                                    if (i2 == 0) {
                                        r0 = false;
                                    }
                                    this.mInvalidMdlProcotol = r0;
                                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                                        TTVideoEngineLog.i("DataLoaderHelper", "setIntValue: mInvalidMdlProcotol: " + this.mInvalidMdlProcotol);
                                        break;
                                    }
                                    break;
                                case 1005:
                                    if (i2 != 1) {
                                        r0 = false;
                                    }
                                    this.mEnableMdlProtocol = r0;
                                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                                        TTVideoEngineLog.i("DataLoaderHelper", "config DATALOADER_KEY_SET_MDL_PROTOCOL_ENABLE: " + this.mEnableMdlProtocol);
                                        break;
                                    }
                                    break;
                                case 1006:
                                    this.mConfigure.mRingBufferSizeKB = i2;
                                    break;
                                case 1007:
                                    this.mConfigure.mEnableFileCacheV2 = i2;
                                    break;
                                case 1009:
                                    this.mConfigure.mEnableFileRingBuffer = i2;
                                    break;
                                case 1010:
                                    this.mConfigure.mEnableUseFileExtendLoaderBuffer = i2;
                                    break;
                                case 1011:
                                    this.mEnableNetworkChangedListen = i2;
                                    break;
                                case 1012:
                                    this.mEnableFirstNativeMDL = i2;
                                    break;
                                case 1013:
                                    if (i2 != 1) {
                                        r0 = false;
                                    }
                                    this.mCloseLocalServer = r0;
                                    break;
                                case 1100:
                                    this.mEnableReportSpeed = i2;
                                    break;
                                case 1101:
                                    this.mConfigure.mEnableLoaderPreempt = i2;
                                    break;
                                case 1102:
                                    this.mConfigure.mAccessCheckLevel = i2;
                                    break;
                                case 1103:
                                    this.mConfigure.mNextDownloadThreshold = i2;
                                    break;
                                case 1104:
                                    AVMDLDataLoader aVMDLDataLoader5 = this.mInnerDataLoader;
                                    if (aVMDLDataLoader5 != null) {
                                        aVMDLDataLoader5.setIntValue(7219, i2);
                                        break;
                                    }
                                    break;
                                case 1105:
                                    this.mConfigure.mSocketSendBufferKB = i2;
                                    break;
                                case 1108:
                                    this.mConfigure.mEnableSyncDnsForPcdn = i2;
                                    break;
                                case 1109:
                                    AVMDLDataLoader aVMDLDataLoader6 = this.mInnerDataLoader;
                                    if (aVMDLDataLoader6 != null) {
                                        aVMDLDataLoader6.setIntValue(7227, i2);
                                        break;
                                    }
                                    break;
                                case 1110:
                                    this.mConfigure.mXYLibValue = i2;
                                    break;
                                case 1111:
                                    this.mConfigure.mCheckPreloadLevel = i2;
                                    break;
                                case 1112:
                                    this.mNeedSpeedTestByTimeInternal = i2;
                                    break;
                                case 1113:
                                    if (i2 == 0) {
                                        r0 = false;
                                    }
                                    this.mAudioPreloadFirst = r0;
                                    break;
                                case 1115:
                                    this.mConfigure.mMaxIPV6Num = i2;
                                    break;
                                case TTVideoEngineInterface.PLAYER_OPTION_CODECPOOL_RESPONSE /* 1116 */:
                                    this.mConfigure.mMaxIPV4Num = i2;
                                    break;
                                case 1117:
                                    this.mConfigure.mForbidByPassCookie = i2;
                                    break;
                                case 1118:
                                    this.mConfigure.mEnableLazyBufferpool = i2;
                                    break;
                                case 1119:
                                    this.mConfigure.mSessionTimeout = i2;
                                    break;
                                case 1120:
                                    this.mConfigure.mEnableNewBufferpool = i2;
                                    break;
                                case 1121:
                                    this.mConfigure.mNewBufferPoolBlockSize = i2;
                                    break;
                                case 1122:
                                    this.mConfigure.mNewBufferPoolResidentSize = i2;
                                    break;
                                case 1123:
                                    this.mConfigure.mNewBufferPoolGrowBlockCount = i2;
                                    break;
                                case 1124:
                                    this.mConfigure.mEnablePlayInfoCache = i2;
                                    break;
                                case 1125:
                                    this.mConfigure.mControlCDNRangeType = i2;
                                    break;
                                case 1126:
                                    this.mConfigure.mEnableP2PPreDown = i2;
                                    break;
                                case 1127:
                                    this.mConfigure.mEnablePlayLog = i2;
                                    break;
                                case 1128:
                                    this.mConfigure.mEnableNetScheduler = i2;
                                    break;
                                case 1129:
                                    this.mConfigure.mNetSchedulerBlockAllNetErr = i2;
                                    break;
                                case 1130:
                                    this.mConfigure.mNetSchedulerBlockErrCount = i2;
                                    break;
                                case 1131:
                                    this.mConfigure.mNetSChedulerBlockDurationMs = i2;
                                    break;
                                case 1132:
                                    this.mConfigure.mFirstRangeLeftThreshold = i2;
                                    break;
                                case 1133:
                                    this.mConfigure.mIsAllowTryTheLastUrl = i2;
                                    break;
                                case 1134:
                                    this.mConfigure.mEnableCacheReqRange = i2;
                                    break;
                                case 1135:
                                    this.mConfigure.mEnableLoaderSeek = i2;
                                    break;
                                case 1136:
                                    this.mConfigure.mP2PPreDownPeerCount = i2;
                                    break;
                                case 1137:
                                    this.mConfigure.mEnableDynamicTimeout = i2;
                                    break;
                                case 1138:
                                    this.mConfigure.mSocketInitialTimeout = i2;
                                    break;
                                case 1139:
                                    this.mConfigure.mMaxSocketReuseCount = i2;
                                    break;
                                case 1140:
                                    AVMDLDNSParser.setIntValue(10, i2);
                                    break;
                                case 1141:
                                    AVMDLDNSParser.setIntValue(2, i2);
                                    this.mConfigure.mDefaultExpiredTime = i2;
                                    break;
                                case 1143:
                                    this.mConfigure.mP2PFirstRangeLoaderType = i2;
                                    break;
                                case 1145:
                                    this.mConfigure.mMaxAliveHostNum = i2;
                                    break;
                                case 1146:
                                    this.mConfigure.mFileExtendSizeKB = i2;
                                    break;
                                case 1147:
                                    this.mConfigure.mMinAllowSpeed = i2;
                                    break;
                                case 1148:
                                    this.mConfigure.mNetSchedulerBlockHostIpErrCount = i2;
                                    break;
                                case 1150:
                                    if (FeatureManager.hasPermission("strategy_center")) {
                                        this.mConfigure.mEnableIOManager = i2;
                                        break;
                                    }
                                    break;
                                case 1151:
                                    this.mConfigure.mEnableOwnVDPPreloadNotify = i2;
                                    break;
                                case 1154:
                                    this.mEnableMdlV2 = i2;
                                    this.mDidConfigMdlV2 = true;
                                    break;
                                case 1155:
                                    this.mEnableSplitPreload = i2;
                                    break;
                                case 1156:
                                    if (i2 > 0) {
                                        this.mPreloadUtil.mPlayBufferLowerBound = i2;
                                        break;
                                    }
                                    break;
                                case 1157:
                                    if (i2 > 0) {
                                        this.mPreloadUtil.mPlayBufferUpperBound = i2;
                                        break;
                                    }
                                    break;
                                case 1158:
                                    this.mConfigure.mMaxFileMemCacheSize = i2;
                                    break;
                                case 1159:
                                    this.mConfigure.mMaxFileMemCacheNum = i2;
                                    break;
                                case 1160:
                                    if (i2 >= 0) {
                                        this.mConfigure.mEnableEarlyData = i2;
                                        break;
                                    }
                                    break;
                                case 1161:
                                    if (i2 > 0) {
                                        this.mConfigure.mSocketRecvBufferSize = i2;
                                        break;
                                    }
                                    break;
                                case 1162:
                                    if (i2 > 0) {
                                        this.mConfigure.mEnableSpeedPredict = i2;
                                        break;
                                    }
                                    break;
                                case 1163:
                                    this.mEnableBufferPreload = i2;
                                    break;
                                case 1164:
                                    this.mConfigure.mEnableUseOriginalUrl = i2;
                                    break;
                                case 1166:
                                    this.mConfigure.mEnableLoaderLogExtractUrls = i2;
                                    break;
                                case 1167:
                                    this.mConfigure.mMaxLoaderLogNum = i2;
                                    break;
                                case 1168:
                                    this.mConfigure.mCheckContentTypeMethod = i2;
                                    break;
                                case 1169:
                                    this.mConfigure.mCloseThreadPool = i2;
                                    break;
                                case 1170:
                                    this.mEnableSetMDLNetStatus = i2;
                                    break;
                                case 1171:
                                    if (i2 > 0) {
                                        this.mConfigure.mEnableSpeedEngine = i2;
                                        break;
                                    }
                                    break;
                                case 1172:
                                    if (i2 > 0) {
                                        this.mConfigure.mEnableSpeedReport = i2;
                                        break;
                                    }
                                    break;
                                case 1501:
                                    this.mConfigure.mEnableCellularUp = i2;
                                    break;
                                case 1503:
                                    this.mDashAudioPreloadMinSize = i2;
                                    break;
                                case 1504:
                                    this.mDashAudioPreloadRatio = i2;
                                    break;
                                case 1505:
                                    this.mEnableStrategyCenterCancelAll = i2;
                                    break;
                                case 1513:
                                    this.mEnableCheckPreloadUrls = i2;
                                    break;
                                case 1514:
                                    this.mConfigure.mGetCookieTokenLevel = i2;
                                    break;
                                case 1701:
                                    this.mConfigure.mEnableByteMediaNetLoader = i2;
                                    break;
                                case 2000:
                                    this.mConfigure.mEnableStorageModule = i2;
                                    break;
                                case 2001:
                                    this.mConfigure.mStoPlayDldWinSizeKBNM = i2;
                                    break;
                                case 2002:
                                    this.mConfigure.mStoPlayDldWinSizeKBLS = i2;
                                    break;
                                case 2003:
                                    this.mConfigure.mStoRingBufferSizeKB = i2;
                                    break;
                                case 2004:
                                    this.mConfigure.mStoIoWriteLimitKBTh1 = i2;
                                    break;
                                case 2005:
                                    this.mConfigure.mStoIoWriteLimitKBTh2 = i2;
                                    break;
                                case 2006:
                                    this.mConfigure.mStoMaxIdleTimeSec = i2;
                                    break;
                                case 2008:
                                    if (i2 >= 0) {
                                        this.mConfigure.mThreadStackSizeLevel = i2;
                                        break;
                                    }
                                    break;
                                case 2009:
                                    if (i2 > 0) {
                                        this.mConfigure.mThreadPoolMinCount = i2;
                                        break;
                                    }
                                    break;
                                case 2010:
                                    if (i2 > 0) {
                                        this.mConfigure.mEnableThreadPoolCheckIdle = i2;
                                        break;
                                    }
                                    break;
                                case 2011:
                                    if (i2 > 0) {
                                        this.mConfigure.mThreadPoolTTLSecond = i2;
                                        break;
                                    }
                                    break;
                                case 2012:
                                    if (i2 > 0) {
                                        this.mConfigure.mMaxIpNum = i2;
                                        break;
                                    }
                                    break;
                                case 2013:
                                    this.mConfigure.mNonBlockRangeMode = i2;
                                    break;
                                case 2014:
                                    this.mConfigure.mNonBlockRangeMaxSizeKB = i2;
                                    break;
                                case 2015:
                                    if (i2 >= 0) {
                                        this.mConfigure.mNetUnreachableStopRetry = i2;
                                        break;
                                    }
                                    break;
                                case 2016:
                                    if (i2 >= 0) {
                                        this.mConfigure.mEnableWaitNetReachable = i2;
                                        break;
                                    }
                                    break;
                                case 2017:
                                    this.mConfigure.mEnableFileMutexOptimize = i2;
                                    break;
                                case 2018:
                                    if (i2 > 0) {
                                        this.mConfigure.mSkipCDNBeforeExpiredSec = i2;
                                        break;
                                    }
                                    break;
                                case 2019:
                                    if (i2 > 0) {
                                        this.mConfigure.mNetUnreachableTimeout = i2;
                                        break;
                                    }
                                    break;
                                case 2020:
                                case 2021:
                                    if (i2 >= 1 && i2 <= 32) {
                                        if (!TextUtils.isEmpty(this.mConfigure.mP2PCostTag)) {
                                            StringBuilder sb = new StringBuilder();
                                            AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure3 = this.mConfigure;
                                            sb.append(aVMDLDataLoaderConfigure3.mP2PCostTag);
                                            sb.append(',');
                                            sb.append(Integer.toString(i2));
                                            aVMDLDataLoaderConfigure3.mP2PCostTag = sb.toString();
                                        } else {
                                            this.mConfigure.mP2PCostTag = Integer.toString(i2);
                                        }
                                        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                            TTVideoEngineLog.d("DataLoaderHelper", "cur p2p cost tag is: " + this.mConfigure.mP2PCostTag);
                                            break;
                                        }
                                    }
                                    break;
                                case 2022:
                                    if (i2 > 0) {
                                        this.mConfigure.mIgnoreTextSpeedTest = i2;
                                        break;
                                    }
                                    break;
                                case 2023:
                                    if (i2 > 0) {
                                        this.mConfigure.mEnableOptimizeRange = i2;
                                        break;
                                    }
                                    break;
                                case 2024:
                                    if (i2 > 0) {
                                        this.mConfigure.mDownLogMaxSize = i2;
                                        break;
                                    }
                                    break;
                                case 2025:
                                    this.mConfigure.mCheckCacheDir = i2;
                                    break;
                                case 2026:
                                    this.mConfigure.mEnableUseGroupId = i2;
                                    break;
                                case 2027:
                                    this.mConfigure.mDisableRecentCache = i2;
                                    break;
                                case 2028:
                                    this.mConfigure.mUpdateCacheFileInternal = i2;
                                    break;
                                case 2031:
                                    this.mConfigure.mEnableMissReason = i2;
                                    break;
                                case 2032:
                                    this.mConfigure.mPreloadInfoRecordMaxCnt = i2;
                                    break;
                                case 2033:
                                    this.mConfigure.mEnableTraceIdPreloadLog = i2;
                                    break;
                                case 2034:
                                    this.mConfigure.mSessionCacheInterval = i2;
                                    break;
                                case 2035:
                                    this.mConfigure.mFileManagerInterval = i2;
                                    break;
                                case 2036:
                                    this.mConfigure.mEnableEnginePortrait = i2;
                                    break;
                                case 2037:
                                    this.mConfigure.mEnableCustomDirSearchAllPath = i2;
                                    break;
                                case 2100:
                                    if (i2 >= 0) {
                                        this.mConfigure.mEnableP2pUpload = i2;
                                        break;
                                    }
                                    break;
                                case 2102:
                                    if (i2 >= 0) {
                                        this.mConfigure.mDevDiskSizeMB = i2;
                                        break;
                                    }
                                    break;
                                case 2104:
                                    if (i2 >= 0) {
                                        this.mConfigure.mDevMemorySizeMB = i2;
                                        break;
                                    }
                                    break;
                                case 9000:
                                    this.mEnableDumpLibMd5 = i2;
                                    break;
                                case 9001:
                                    this.mConfigure.mIgnorePlayInfo = i2;
                                    break;
                                case 9008:
                                    this.mEnableHls = i2;
                                    break;
                                case 9013:
                                    this.mEnableLibManager = i2;
                                    break;
                                case 9014:
                                    if (i2 == 1 || i2 == 0) {
                                        this.mConfigure.mEnableMultiDownloadPath = i2;
                                        break;
                                    }
                                case 9016:
                                    this.mEnableHLSProxy = i2;
                                    break;
                                case 9017:
                                    this.mEnableCenterPreloadProgressCallback = i2;
                                    break;
                                case 9018:
                                    this.mEnableNotifyError = i2;
                                    break;
                                case 9019:
                                    this.mEnableNotOnlyNotifyNetError = i2;
                                    break;
                                case 9021:
                                    this.mEnablePreloadFirstTs = i2;
                                    break;
                                case 9022:
                                    this.mDisableFilePathCheck = i2;
                                    break;
                                case 9023:
                                    this.mEnablePreloadAllTs = i2;
                                    break;
                                case 9030:
                                    this.mEnableLoadMdlv2Fulllib = i2;
                                    break;
                                case 12002:
                                    this.mEnableVideoModelHitCacheCallback = i2;
                                    break;
                                case 80001:
                                    this.mEnableCheckHLSProxyVVCtrl = i2;
                                    break;
                                case 80002:
                                    AVMDLLog.enableLogOptimization = i2;
                                    break;
                                case 80004:
                                    AVMDLDNSParser.setIntValue(11, i2);
                                    break;
                                default:
                                    switch (i) {
                                        case 30:
                                            this.mConfigure.mEncryptVersion = i2;
                                            break;
                                        case 31:
                                            this.mConfigure.mEnableOkHttpLoader = i2;
                                            break;
                                        case ConstantsAPI.COMMAND_PRELOAD_MINI_PROGRAM_ENVIRONMENT /* 32 */:
                                            if (i2 <= 0) {
                                                r0 = false;
                                            }
                                            this.mForbidNativeMDLForOriUrl = r0;
                                            break;
                                        case ConstantsAPI.COMMAND_FINDER_SHARE_VIDEO /* 33 */:
                                            this.mNeedMDLLoadMDLV2Lib = i2 != 0;
                                            break;
                                        case ConstantsAPI.COMMAND_FINDER_OPEN_PROFILE /* 34 */:
                                            this.mConfigure.mEnablePcdnAuto = i2;
                                            break;
                                        default:
                                            switch (i) {
                                                case 63:
                                                    this.mConfigure.mMaxIpCountEachDomain = i2;
                                                    break;
                                                case 64:
                                                    this.mConfigure.mEnableIpBucket = i2;
                                                    break;
                                                case 65:
                                                    this.mConfigure.mErrorStateTrustTime = i2;
                                                    break;
                                                case 66:
                                                    this.mConfigure.mOnlyUseCdn = i2;
                                                    break;
                                                default:
                                                    switch (i) {
                                                        case 90:
                                                            this.mConfigure.mDNSMainType = i2;
                                                            AVMDLDNSParser.setIntValue(0, i2);
                                                            break;
                                                        case 91:
                                                            this.mConfigure.mDNSBackType = i2;
                                                            AVMDLDNSParser.setIntValue(1, i2);
                                                            break;
                                                        case 92:
                                                            this.mConfigure.mMainToBackUpDelayedTime = i2;
                                                            AVMDLDNSParser.setIntValue(3, i2);
                                                            break;
                                                        case 93:
                                                            this.mConfigure.mEnableBenchMarkIOSpeed = i2;
                                                            break;
                                                        case 94:
                                                            this.mConfigure.mSpeedCoefficientValue = i2;
                                                            break;
                                                    }
                                            }
                                    }
                            }
                            break;
                    }
                } else {
                    this.mConfigure.mEnableSessionReuse = i2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x055f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0584 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0596  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x076d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0776  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0674  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x06a2  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x06ec A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0744  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0746  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void _exectTask(com.ss.ttvideoengine.DataLoaderHelper.DataLoaderTaskItem r54) {
        /*
            Method dump skipped, instructions count: 2218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.DataLoaderHelper._exectTask(com.ss.ttvideoengine.DataLoaderHelper$DataLoaderTaskItem):void");
    }

    private class DataLoaderHeartBeat {
        private MyHeartBeatTask mHbTask;
        private Timer mHbTimer;

        static {
            Covode.recordClassIndex(652254);
        }

        public void stop() {
            Timer timer = this.mHbTimer;
            if (timer != null) {
                timer.cancel();
            }
        }

        private class MyHeartBeatTask extends TimerTask {
            private AVMDLDataLoader mDataLoader;

            static {
                Covode.recordClassIndex(652255);
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    AVMDLDataLoader aVMDLDataLoader = this.mDataLoader;
                    if (aVMDLDataLoader != null) {
                        aVMDLDataLoader.onLogInfo(70, 0, aVMDLDataLoader.getStringValue(1011));
                    }
                } catch (Exception e) {
                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                        TTVideoEngineLog.d(e);
                    }
                }
            }

            public MyHeartBeatTask(AVMDLDataLoader aVMDLDataLoader) {
                this.mDataLoader = aVMDLDataLoader;
            }
        }

        private DataLoaderHeartBeat() {
            this.mHbTimer = null;
            this.mHbTask = null;
        }

        public void start(AVMDLDataLoader aVMDLDataLoader, int i) {
            if (this.mHbTask == null && this.mHbTimer == null && i > 0) {
                this.mHbTask = new MyHeartBeatTask(aVMDLDataLoader);
                PthreadTimer pthreadTimer = new PthreadTimer("DataLoaderHelper$DataLoaderHeartBeat");
                this.mHbTimer = pthreadTimer;
                long j = i;
                pthreadTimer.schedule(this.mHbTask, j, j);
            }
        }
    }

    public static DataLoaderHelper getDataLoader() {
        return Holder.instance;
    }

    public void clearAllCaches() {
        clearAllCaches(false);
    }

    public static class DataLoaderTaskItem {
        public String mVideoId = null;
        public IVideoModel mResponseData = null;
        public Error mResponseError = null;
        public long mPreloadSize = 0;
        public long mDashVideoPreloadSize = -1;
        public long mDashAudioPreloadSize = -1;
        public long mPreloadMilliSecondOffset = 0;
        public float mPreloadSecond = 0.0f;
        public long mTimePreloadLowerLimitSize = 0;
        public long mTimePreloadUpperLimitSize = 0;
        public int mPriorityLevel = 0;
        public Resolution mSetResolution = Resolution.Undefine;
        public VideoInfoFetcher mFetcher = null;
        public TaskListener mListener = null;
        public PreloaderVidItem mVidItem = null;
        public String mApiString = null;
        public String mGroupId = "";
        public PreloaderVideoModelItem mVideoModelItem = null;
        public PreloaderURLItem mURLItem = null;
        public boolean mDidCanceled = false;
        public PreloadMedia mPreloadMedia = null;
        public String mTag = null;
        public String mSubTag = null;
        public int mPlayIndexGap = -1;
        public List<TrackItem> mTracks = new CopyOnWriteArrayList();
        public List<TrackItem> mPreloadEndTracks = new CopyOnWriteArrayList();

        static {
            Covode.recordClassIndex(652256);
        }

        public int getNotEndTrackItemCount() {
            return this.mTracks.size() - this.mPreloadEndTracks.size();
        }

        public void setFetchListener() {
            VideoInfoFetcher videoInfoFetcher = this.mFetcher;
            if (videoInfoFetcher != null) {
                videoInfoFetcher.setListener(new MyFetcherListener(this));
            }
        }

        public void removeVidPlaceholderTrack() {
            if (this.mVidItem == null) {
                return;
            }
            try {
                if (this.mTracks.size() == 1) {
                    this.mTracks.remove(0);
                }
            } catch (Exception e) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(e);
                }
            }
        }

        public IPreLoaderItemCallBackListener getCallBackListener() {
            PreloaderURLItem preloaderURLItem = this.mURLItem;
            if (preloaderURLItem != null && preloaderURLItem.getCallBackListener() != null) {
                return this.mURLItem.getCallBackListener();
            }
            PreloaderVidItem preloaderVidItem = this.mVidItem;
            if (preloaderVidItem != null) {
                return preloaderVidItem.getCallBackListener();
            }
            PreloaderVideoModelItem preloaderVideoModelItem = this.mVideoModelItem;
            if (preloaderVideoModelItem != null) {
                return preloaderVideoModelItem.getCallBackListener();
            }
            PreloadMedia preloadMedia = this.mPreloadMedia;
            if (preloadMedia != null) {
                return preloadMedia.getCallBackListener();
            }
            return null;
        }

        public void setListener(TaskListener taskListener) {
            this.mListener = taskListener;
        }

        private static class MySmartUrlFetcherListener implements SmartUrlFetcher.Callback {
            private final WeakReference<DataLoaderTaskItem> mTaskItemRef;

            static {
                Covode.recordClassIndex(652258);
            }

            public MySmartUrlFetcherListener(DataLoaderTaskItem dataLoaderTaskItem) {
                this.mTaskItemRef = new WeakReference<>(dataLoaderTaskItem);
            }

            @Override // com.ss.ttvideoengine.source.strategy.SmartUrlFetcher.Callback
            public void onError(SmartUrlFetcher.RequestParams requestParams, Error error) {
                PreloaderURLItem preloaderURLItem;
                CodecStrategyAdapter codecStrategyAdapter;
                DataLoaderTaskItem dataLoaderTaskItem = this.mTaskItemRef.get();
                if (dataLoaderTaskItem == null || (preloaderURLItem = dataLoaderTaskItem.mURLItem) == null || (codecStrategyAdapter = preloaderURLItem.mAdapter) == null) {
                    return;
                }
                dataLoaderTaskItem.mResponseError = error;
                codecStrategyAdapter.fallbackToDirectUrl();
                TaskListener taskListener = dataLoaderTaskItem.mListener;
                if (taskListener != null) {
                    taskListener.taskFinished(dataLoaderTaskItem);
                }
            }

            @Override // com.ss.ttvideoengine.source.strategy.SmartUrlFetcher.Callback
            public void onComplete(SmartUrlFetcher.RequestParams requestParams, int i, SmartUrlFetcher.Result result) {
                DataLoaderTaskItem dataLoaderTaskItem = this.mTaskItemRef.get();
                if (dataLoaderTaskItem == null) {
                    return;
                }
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d("DataLoaderHelper", "fetchSmartUrlInfo success " + result);
                }
                dataLoaderTaskItem.mResponseData = result.videoModel;
                TaskListener taskListener = dataLoaderTaskItem.mListener;
                if (taskListener != null) {
                    taskListener.taskFinished(dataLoaderTaskItem);
                }
            }
        }

        public void _notifyError(int i) {
            if (getCallBackListener() != null) {
                PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(3);
                preLoaderItemCallBackInfo.preloadError = new Error("kTTVideoErrorDomainDataLoaderPreload", i);
                getCallBackListener().preloadItemInfo(preLoaderItemCallBackInfo);
            }
        }

        public TrackItem addTrackItemByKey(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            TrackItem trackItem = getTrackItem(str);
            if (trackItem == null) {
                TrackItem trackItem2 = new TrackItem();
                trackItem2.mTaskKey = str;
                this.mTracks.add(trackItem2);
                return trackItem2;
            }
            return trackItem;
        }

        public TrackItem getTrackItem(String str) {
            for (TrackItem trackItem : this.mTracks) {
                if (trackItem.mTaskKey.equals(str)) {
                    return trackItem;
                }
            }
            return null;
        }

        public class TrackItem {
            public String mTaskKey = null;
            public String mProxyUrl = null;
            public Resolution mUsingResolution = Resolution.Undefine;
            public String mDecryptionKey = null;
            public VideoInfo mVideoInfo = null;
            public String[] mUrls = null;
            public String[] mUrlExpireTimes = null;
            public String mExternalInfo = null;
            public long mPreloadHeaderSize = 0;
            public long mPreloadOffset = 0;
            public long mPreSize = 0;
            public long mMediaSize = 0;
            public long mCacheSize = 0;
            public String mLocalFilePath = null;
            public String mCustomHeader = null;
            public long mPreloadFooterSize = 0;
            public boolean mIsFooterPreloaded = false;

            static {
                Covode.recordClassIndex(652259);
            }

            public TrackItem() {
            }
        }

        public void trackItemPreloadEnd(String str) {
            for (TrackItem trackItem : this.mTracks) {
                if (trackItem.mTaskKey.equals(str)) {
                    if (!this.mPreloadEndTracks.contains(trackItem)) {
                        this.mPreloadEndTracks.add(trackItem);
                        return;
                    }
                    return;
                }
            }
        }

        private class MyFetcherListener implements VideoInfoFetcher.FetcherListener {
            private final WeakReference<DataLoaderTaskItem> mTaskItemRef;

            static {
                Covode.recordClassIndex(652257);
            }

            @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
            public void onLog(String str) {
            }

            @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
            public void onRetry(Error error) {
            }

            public MyFetcherListener(DataLoaderTaskItem dataLoaderTaskItem) {
                this.mTaskItemRef = new WeakReference<>(dataLoaderTaskItem);
            }

            @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
            public void onCompletion(VideoModel videoModel, Error error) {
                DataLoaderTaskItem dataLoaderTaskItem = this.mTaskItemRef.get();
                if (dataLoaderTaskItem == null) {
                    return;
                }
                dataLoaderTaskItem.mResponseData = videoModel;
                dataLoaderTaskItem.mResponseError = error;
                TaskListener taskListener = dataLoaderTaskItem.mListener;
                if (taskListener != null) {
                    taskListener.taskFinished(dataLoaderTaskItem);
                }
            }

            @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
            public void onStatusException(int i, String str) {
                DataLoaderTaskItem dataLoaderTaskItem = this.mTaskItemRef.get();
                if (dataLoaderTaskItem == null) {
                    return;
                }
                if (i != 0 && i != 10) {
                    dataLoaderTaskItem.mResponseError = new Error("kTTVideoErrorDomainFetchingInfo", -7996);
                }
                TaskListener taskListener = dataLoaderTaskItem.mListener;
                if (taskListener != null) {
                    taskListener.taskFinished(dataLoaderTaskItem);
                }
            }
        }

        public void setUp(String str, Resolution resolution, long j) {
            if (this.mTracks.size() == 0) {
                TrackItem trackItem = new TrackItem();
                trackItem.mTaskKey = str;
                trackItem.mUsingResolution = resolution;
                trackItem.mPreSize = j;
                this.mTracks.add(trackItem);
            } else {
                TTVideoEngineLog.e("DataLoaderHelper", "[preload] DataLoaderTaskItem setup fail");
            }
            this.mSetResolution = resolution;
            this.mPreloadSize = j;
        }
    }

    public String getMdlInitializeErrorString() {
        String str = this.mInitializeErrorString;
        if (str == null) {
            return null;
        }
        this.mInitializeErrorString = null;
        return str;
    }

    public int getMdlInvalidCode() {
        int i = this.mInvalidCode;
        this.mInvalidCode = IVideoEventLogger.MdlInvalidCode.None.ordinal();
        return i;
    }

    public void switchToCellularNetwork() {
        TTVideoEngineLog.d("multinetwork", "start do switch to cellular");
        AVMDLMultiNetwork.switchToCellularNetwork();
        TTVideoEngineLog.d("multinetwork", "end do switch to cellular");
    }

    public void switchToDefaultNetwork() {
        TTVideoEngineLog.d("multinetwork", "start do switch to default");
        AVMDLMultiNetwork.switchToDefaultNetwork();
        TTVideoEngineLog.d("multinetwork", "end do switch to default");
    }

    public class DataLoaderTaskLoadProgress {
        public String mVideoId = null;
        public int mTaskType = 0;
        public List<CacheInfo> mCacheInfos = null;
        protected boolean mSeparateAudioVideo = false;

        static {
            Covode.recordClassIndex(652260);
        }

        public class CacheInfo {
            public String mKey = null;
            public long mMediaSize = 0;
            public long mPreloadSize = 0;
            public Resolution mResolution = Resolution.Undefine;
            public List<CacheRange> mCacheRanges = null;
            public String mLocalFilePath = null;
            public Error mError = null;

            static {
                Covode.recordClassIndex(652261);
            }

            public long getCacheSize() {
                List<CacheRange> list = this.mCacheRanges;
                if (list != null && list.size() > 0) {
                    return this.mCacheRanges.get(r0.size() - 1).mSize;
                }
                return 0L;
            }

            public boolean finished() {
                long j;
                CacheRange cacheRange;
                long j2 = this.mPreloadSize;
                if (j2 > 0) {
                    j = Math.min(j2, this.mMediaSize);
                } else {
                    j = this.mMediaSize;
                }
                List<CacheRange> list = this.mCacheRanges;
                if (list != null) {
                    cacheRange = list.get(list.size() - 1);
                } else {
                    cacheRange = null;
                }
                if (this.mError != null) {
                    return true;
                }
                if (cacheRange != null && this.mMediaSize > 0 && cacheRange.mOffset + cacheRange.mSize >= j) {
                    return true;
                }
                return false;
            }

            public class CacheRange {
                public long mOffset = 0;
                public long mSize = 0;

                static {
                    Covode.recordClassIndex(652262);
                }

                public CacheRange() {
                }
            }

            public CacheInfo() {
            }

            void setCacheSize(long j) {
                if (this.mCacheRanges == null) {
                    this.mCacheRanges = new ArrayList();
                }
                if (this.mCacheRanges.size() == 0) {
                    this.mCacheRanges.add(new CacheRange());
                }
                this.mCacheRanges.get(0).mOffset = 0L;
                this.mCacheRanges.get(0).mSize = j;
            }
        }

        public long getTotalCacheSize() {
            long j = 0;
            if (this.mCacheInfos != null) {
                for (int i = 0; i < this.mCacheInfos.size(); i++) {
                    j += this.mCacheInfos.get(i).getCacheSize();
                }
            }
            return j;
        }

        public boolean isPreloadComplete() {
            if (this.mTaskType != 2) {
                TTVideoEngineLog.d("DataLoaderHelper", "task is not a preload task");
                return false;
            }
            if (this.mCacheInfos != null) {
                for (int i = 0; i < this.mCacheInfos.size(); i++) {
                    CacheInfo cacheInfo = this.mCacheInfos.get(i);
                    if (cacheInfo != null && !cacheInfo.finished()) {
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean isCacheEnd() {
            boolean z;
            int i;
            if (this.mCacheInfos != null) {
                z = true;
                i = 0;
                for (int i2 = 0; i2 < this.mCacheInfos.size(); i2++) {
                    CacheInfo cacheInfo = this.mCacheInfos.get(i2);
                    if (cacheInfo != null && !cacheInfo.finished()) {
                        z = false;
                    } else {
                        i++;
                    }
                }
            } else {
                z = true;
                i = 0;
            }
            if (!this.mSeparateAudioVideo) {
                if (z) {
                    return true;
                }
                if (i >= 1 && this.mTaskType == 1) {
                    return true;
                }
                return false;
            }
            if (z) {
                return true;
            }
            if (i >= 2 && this.mTaskType == 1) {
                return true;
            }
            return false;
        }

        public DataLoaderTaskLoadProgress() {
        }

        private CacheInfo getCacheInfo(String str) {
            List<CacheInfo> list;
            if (!TextUtils.isEmpty(str) && (list = this.mCacheInfos) != null) {
                for (CacheInfo cacheInfo : list) {
                    if (cacheInfo.mKey.equals(str)) {
                        return cacheInfo;
                    }
                }
            }
            return null;
        }

        public void setUp(DataLoaderTaskItem dataLoaderTaskItem) {
            this.mVideoId = dataLoaderTaskItem.mVideoId;
            if (this.mCacheInfos == null) {
                this.mCacheInfos = new ArrayList();
            }
            Iterator<DataLoaderTaskItem.TrackItem> it2 = dataLoaderTaskItem.mTracks.iterator();
            int i = 0;
            int i2 = 0;
            while (true) {
                boolean z = true;
                if (!it2.hasNext()) {
                    break;
                }
                DataLoaderTaskItem.TrackItem next = it2.next();
                CacheInfo cacheInfo = getCacheInfo(next.mTaskKey);
                if (cacheInfo == null) {
                    cacheInfo = new CacheInfo();
                    z = false;
                }
                cacheInfo.mKey = next.mTaskKey;
                cacheInfo.mMediaSize = next.mMediaSize;
                cacheInfo.mResolution = next.mUsingResolution;
                cacheInfo.setCacheSize(next.mCacheSize);
                cacheInfo.mLocalFilePath = next.mLocalFilePath;
                cacheInfo.mPreloadSize = next.mPreSize;
                VideoInfo videoInfo = next.mVideoInfo;
                if (videoInfo != null) {
                    if (videoInfo.getMediatype() == VideoRef.TYPE_VIDEO) {
                        i2++;
                    } else if (next.mVideoInfo.getMediatype() == VideoRef.TYPE_AUDIO) {
                        i++;
                    }
                }
                if (!z) {
                    this.mCacheInfos.add(cacheInfo);
                }
            }
            if (i > 0 && i2 > 0) {
                this.mSeparateAudioVideo = true;
            }
        }

        public void onError(String str, Error error) {
            CacheInfo cacheInfo = getCacheInfo(str);
            if (cacheInfo != null) {
                cacheInfo.mError = error;
            }
        }
    }

    private class DataLoaderTaskQueue {
        private final ReentrantLock mLock;
        private long mMaxCount;
        private final ArrayList<DataLoaderTaskItem> mTaskItems;

        static {
            Covode.recordClassIndex(652264);
        }

        private Boolean _enoughItems() {
            boolean z;
            if (this.mMaxCount >= 1) {
                if (this.mTaskItems.size() >= this.mMaxCount) {
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            return Boolean.FALSE;
        }

        public long count() {
            this.mLock.lock();
            long size = this.mTaskItems.size();
            this.mLock.unlock();
            return size;
        }

        public void removeAll() {
            try {
                this.mLock.lock();
                this.mTaskItems.clear();
            } finally {
                this.mLock.unlock();
            }
        }

        public ArrayList<DataLoaderTaskItem> toArray() {
            try {
                this.mLock.lock();
                ArrayList<DataLoaderTaskItem> arrayList = new ArrayList<>();
                arrayList.addAll(this.mTaskItems);
                return arrayList;
            } finally {
                this.mLock.unlock();
            }
        }

        public DataLoaderTaskItem backItem() {
            this.mLock.lock();
            if (this.mTaskItems.size() == 0) {
                this.mLock.unlock();
                return null;
            }
            DataLoaderTaskItem dataLoaderTaskItem = this.mTaskItems.get(r0.size() - 1);
            this.mLock.unlock();
            return dataLoaderTaskItem;
        }

        public DataLoaderTaskItem frontItem() {
            this.mLock.lock();
            if (this.mTaskItems.size() == 0) {
                this.mLock.unlock();
                return null;
            }
            DataLoaderTaskItem dataLoaderTaskItem = this.mTaskItems.get(0);
            this.mLock.unlock();
            return dataLoaderTaskItem;
        }

        public DataLoaderTaskItem popBackItem() {
            this.mLock.lock();
            if (this.mTaskItems.size() == 0) {
                this.mLock.unlock();
                return null;
            }
            DataLoaderTaskItem dataLoaderTaskItem = this.mTaskItems.get(r0.size() - 1);
            this.mTaskItems.remove(dataLoaderTaskItem);
            this.mLock.unlock();
            return dataLoaderTaskItem;
        }

        public DataLoaderTaskItem popFrontItem() {
            this.mLock.lock();
            if (this.mTaskItems.size() == 0) {
                this.mLock.unlock();
                return null;
            }
            DataLoaderTaskItem dataLoaderTaskItem = this.mTaskItems.get(0);
            this.mTaskItems.remove(dataLoaderTaskItem);
            this.mLock.unlock();
            return dataLoaderTaskItem;
        }

        public void setMaxCount(long j) {
            this.mMaxCount = j;
        }

        private DataLoaderTaskQueue() {
            this.mLock = new ReentrantLock();
            this.mTaskItems = new ArrayList<>();
            this.mMaxCount = 0L;
        }

        public boolean containItem(String str) {
            int i = 0;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Boolean bool = Boolean.FALSE;
            this.mLock.lock();
            while (true) {
                if (i >= this.mTaskItems.size()) {
                    break;
                }
                if (this.mTaskItems.get(i).getTrackItem(str) != null) {
                    bool = Boolean.TRUE;
                    break;
                }
                i++;
            }
            this.mLock.unlock();
            return bool.booleanValue();
        }

        boolean enqueueItem(DataLoaderTaskItem dataLoaderTaskItem) {
            Boolean bool;
            if (dataLoaderTaskItem == null || dataLoaderTaskItem.mTracks.size() == 0) {
                return false;
            }
            this.mLock.lock();
            if (_enoughItems().booleanValue()) {
                bool = Boolean.FALSE;
            } else {
                this.mTaskItems.add(dataLoaderTaskItem);
                bool = Boolean.TRUE;
            }
            this.mLock.unlock();
            return bool.booleanValue();
        }

        public DataLoaderTaskItem itemForKey(String str) {
            DataLoaderTaskItem dataLoaderTaskItem = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.mLock.lock();
            int i = 0;
            while (true) {
                if (i >= this.mTaskItems.size()) {
                    break;
                }
                DataLoaderTaskItem dataLoaderTaskItem2 = this.mTaskItems.get(i);
                if (dataLoaderTaskItem2.getTrackItem(str) != null) {
                    dataLoaderTaskItem = dataLoaderTaskItem2;
                    break;
                }
                i++;
            }
            this.mLock.unlock();
            return dataLoaderTaskItem;
        }

        public DataLoaderTaskItem itemForVideoId(String str) {
            DataLoaderTaskItem dataLoaderTaskItem = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.mLock.lock();
            int i = 0;
            while (true) {
                if (i >= this.mTaskItems.size()) {
                    break;
                }
                DataLoaderTaskItem dataLoaderTaskItem2 = this.mTaskItems.get(i);
                if (!TextUtils.isEmpty(dataLoaderTaskItem2.mVideoId) && dataLoaderTaskItem2.mVideoId.equals(str)) {
                    dataLoaderTaskItem = dataLoaderTaskItem2;
                    break;
                }
                i++;
            }
            this.mLock.unlock();
            return dataLoaderTaskItem;
        }

        public DataLoaderTaskItem popItem(DataLoaderTaskItem dataLoaderTaskItem) {
            DataLoaderTaskItem dataLoaderTaskItem2;
            if (!TextUtils.isEmpty(dataLoaderTaskItem.mVideoId)) {
                dataLoaderTaskItem2 = popItemForVideoId(dataLoaderTaskItem.mVideoId);
                if (dataLoaderTaskItem2 != null) {
                    return dataLoaderTaskItem2;
                }
            } else {
                dataLoaderTaskItem2 = null;
            }
            Iterator<DataLoaderTaskItem.TrackItem> it2 = dataLoaderTaskItem.mTracks.iterator();
            while (it2.hasNext() && (dataLoaderTaskItem2 = popItem(it2.next().mTaskKey)) == null) {
            }
            return dataLoaderTaskItem2;
        }

        public DataLoaderTaskItem popItemForVideoId(String str) {
            DataLoaderTaskItem dataLoaderTaskItem = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.mLock.lock();
            int i = 0;
            while (true) {
                if (i >= this.mTaskItems.size()) {
                    break;
                }
                DataLoaderTaskItem dataLoaderTaskItem2 = this.mTaskItems.get(i);
                if (!TextUtils.isEmpty(dataLoaderTaskItem2.mVideoId) && dataLoaderTaskItem2.mVideoId.equals(str)) {
                    dataLoaderTaskItem = dataLoaderTaskItem2;
                    break;
                }
                i++;
            }
            if (dataLoaderTaskItem != null) {
                this.mTaskItems.remove(dataLoaderTaskItem);
            }
            this.mLock.unlock();
            return dataLoaderTaskItem;
        }

        public DataLoaderTaskItem popItem(String str) {
            DataLoaderTaskItem dataLoaderTaskItem = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.mLock.lock();
            int i = 0;
            while (true) {
                if (i >= this.mTaskItems.size()) {
                    break;
                }
                DataLoaderTaskItem dataLoaderTaskItem2 = this.mTaskItems.get(i);
                if (dataLoaderTaskItem2.getTrackItem(str) != null) {
                    dataLoaderTaskItem = dataLoaderTaskItem2;
                    break;
                }
                i++;
            }
            if (dataLoaderTaskItem != null) {
                this.mTaskItems.remove(dataLoaderTaskItem);
            }
            this.mLock.unlock();
            return dataLoaderTaskItem;
        }
    }

    public long getPreloadTaskCount() {
        return this.mExecuteTasks.count() + this.mAllPreloadTasks.count() + this.mPreloadTasks.count();
    }

    public boolean isNeedPlayInfo() {
        if (this.mEnableBufferPreload <= 0) {
            return false;
        }
        PreloadUtil preloadUtil = this.mPreloadUtil;
        if (preloadUtil.mPlayBufferLowerBound <= 0 || preloadUtil.mPlayBufferUpperBound <= 0) {
            return false;
        }
        return true;
    }

    public boolean isReportLogEnable() {
        this.mLock.lock(ABLock.TYPE_VOID);
        try {
            return this.mReportLogEnable;
        } finally {
            this.mLock.unlock(ABLock.TYPE_VOID);
        }
    }

    public boolean isRunning() {
        boolean z;
        this.mLock.lock(ABLock.TYPE_VOID);
        try {
            if (this.mState == 0) {
                z = true;
            } else {
                z = false;
            }
            return z;
        } finally {
            this.mLock.unlock(ABLock.TYPE_VOID);
        }
    }

    public void resumePreconnect() {
        if (this.mInnerDataLoader == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "need start mdl first");
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        this.mInnerDataLoader.resumePreConnect();
        this.mLock.unlock(ABLock.TYPE_READ);
    }

    public void suspendPreconnect() {
        if (this.mInnerDataLoader == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "need start mdl first");
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        this.mInnerDataLoader.suspendPreconnect();
        this.mLock.unlock(ABLock.TYPE_READ);
    }

    private static class PreloadMediaThread {
        private Handler mHandler;
        private HandlerThread mHandlerThread;

        static {
            Covode.recordClassIndex(652269);
        }

        public PreloadMediaThread() {
            try {
                HandlerThread handlerThread = new HandlerThread("vclould.engine.preload.media");
                this.mHandlerThread = handlerThread;
                handlerThread.start();
                this.mHandler = new HandlerDelegate(this.mHandlerThread.getLooper()) { // from class: com.ss.ttvideoengine.DataLoaderHelper.PreloadMediaThread.1
                    public void handleMessage(Message message) {
                        if (message == null) {
                        }
                        try {
                            Object obj = message.obj;
                            if (!(obj instanceof ArrayList)) {
                                TTVideoEngineLog.d("DataLoaderHelper", "[preload] obj should instance of ArrayList");
                                return;
                            }
                            ArrayList arrayList = (ArrayList) obj;
                            if (arrayList == null) {
                                TTVideoEngineLog.d("DataLoaderHelper", "[preload] obj should instance of ArrayList");
                                return;
                            }
                            DataLoaderHelper dataLoaderHelper = (DataLoaderHelper) arrayList.get(0);
                            switch (message.what) {
                                case TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE /* 111 */:
                                    if (arrayList.size() == 3) {
                                        PreloadModelMedia preloadModelMedia = (PreloadModelMedia) arrayList.get(1);
                                        String str = (String) arrayList.get(2);
                                        if (dataLoaderHelper != null) {
                                            dataLoaderHelper._doMl_addMedia(preloadModelMedia, str);
                                            break;
                                        }
                                    }
                                    break;
                                case 112:
                                    if (arrayList.size() == 3) {
                                        String str2 = (String) arrayList.get(1);
                                        String str3 = (String) arrayList.get(2);
                                        if (dataLoaderHelper != null) {
                                            dataLoaderHelper._doMl_removeMedia(str2, str3);
                                            break;
                                        }
                                    }
                                    break;
                                case 113:
                                    if (arrayList.size() == 3) {
                                        String str4 = (String) arrayList.get(1);
                                        int intValue = ((Integer) arrayList.get(2)).intValue();
                                        if (dataLoaderHelper != null) {
                                            dataLoaderHelper._doMl_removeAllMedias(str4, intValue);
                                            break;
                                        }
                                    }
                                    break;
                                case 114:
                                    if (arrayList.size() == 3) {
                                        String str5 = (String) arrayList.get(1);
                                        int intValue2 = ((Integer) arrayList.get(2)).intValue();
                                        if (dataLoaderHelper != null) {
                                            StrategyHelper.helper().getCenter().m(str5, intValue2);
                                            break;
                                        }
                                    }
                                    break;
                                case 115:
                                    if (arrayList.size() == 2) {
                                        PreloadModelMedia preloadModelMedia2 = (PreloadModelMedia) arrayList.get(1);
                                        if (dataLoaderHelper != null) {
                                            dataLoaderHelper._doMl_addPriorityTask(preloadModelMedia2);
                                            break;
                                        }
                                    }
                                    break;
                                case 116:
                                    if (arrayList.size() == 2) {
                                        String str6 = (String) arrayList.get(1);
                                        if (dataLoaderHelper != null) {
                                            dataLoaderHelper._doMl_removePriorityTask(str6);
                                            break;
                                        }
                                    }
                                    break;
                            }
                        } catch (Throwable th) {
                            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                TTVideoEngineLog.d(th);
                            }
                        }
                    }
                };
            } catch (Throwable th) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(th);
                }
                this.mHandlerThread = null;
                this.mHandler = null;
            }
        }

        public void postMessage(ArrayList<Object> arrayList, int i) {
            if (this.mHandler != null && this.mHandlerThread != null) {
                Message obtain = Message.obtain();
                obtain.what = i;
                obtain.obj = arrayList;
                this.mHandler.sendMessage(obtain);
            }
        }
    }

    private void _startExecuteTask() {
        if (this.mInnerDataLoader == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] need load mdl first.");
            return;
        }
        DataLoaderTaskItem backItem = this.mPreloadTasks.backItem();
        if (backItem != null && this.mExecuteTasks.enqueueItem(backItem)) {
            this.mPreloadTasks.popBackItem();
            if (backItem.mResponseData == null && backItem.mURLItem == null) {
                _startFetchVideoInfo(backItem);
            } else {
                _exectTask(backItem);
            }
        }
    }

    private void _tryToSetDefaultCacheDir() {
        if (this.mContext == null || !TextUtils.isEmpty(this.mConfigure.mCacheDir)) {
            return;
        }
        String str = TTHelper.getAppFilesPath(this.mContext) + File.separator + "mdlcache";
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
        if (!polarisFileWrapper.exists()) {
            polarisFileWrapper.mkdir();
        }
        this.mConfigure.mCacheDir = str;
    }

    private boolean isMDLPrecisePreloadEnable() {
        AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure = this.mConfigure;
        if (aVMDLDataLoaderConfigure == null || TextUtils.isEmpty(aVMDLDataLoaderConfigure.mPrecisePreloadConfigStr)) {
            return false;
        }
        try {
            if (new JSONObject(this.mConfigure.mPrecisePreloadConfigStr).getInt("enable") <= 0) {
                return false;
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void clearNetinfoCache() {
        AVMDLDataLoader aVMDLDataLoader;
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            aVMDLDataLoader = this.mInnerDataLoader;
        } finally {
            try {
            } finally {
            }
        }
        if (aVMDLDataLoader == null) {
            return;
        }
        aVMDLDataLoader.clearNetinfoCache();
    }

    public long getAllCacheSize() {
        long j = 0;
        if (this.mState != 0) {
            return 0L;
        }
        if (this.mLock.tryLock(ABLock.TYPE_READ)) {
            try {
                if (this.mInnerDataLoader == null) {
                    TTVideoEngineLog.e("DataLoaderHelper", "mInnerDataLoader == null");
                }
                j = 0 + this.mInnerDataLoader.getAllCacheSize();
            } finally {
                try {
                } finally {
                }
            }
        }
        return j;
    }

    public void resumeFileWriteIO() {
        if (this.mState != 0) {
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            AVMDLDataLoader aVMDLDataLoader = this.mInnerDataLoader;
            if (aVMDLDataLoader != null) {
                aVMDLDataLoader.resumeFileWriteIO();
            }
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    public void updateCurrentNetStatus() {
        if (this.mState != 0) {
            TTVideoEngineLog.d("DataLoaderHelper", "dataloader not started, not allow set play info");
            return;
        }
        if (this.mEnableSetMDLNetStatus <= 0) {
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        this.mInnerDataLoader.setIntValue(7410, TTNetWorkListener.getInstance().getCurrentAccessStrength());
        this.mInnerDataLoader.setIntValue(7409, PortraitNetworkScore.getInstance().getPortraitResult());
        this.mLock.unlock(ABLock.TYPE_READ);
    }

    private void dumpLibMd5() {
        String str;
        if (this.mEnableDumpLibMd5 != 1 || this.mContext == null) {
            return;
        }
        try {
            str = this.mContext.getApplicationInfo().dataDir + "/lib";
        } catch (Exception unused) {
            str = null;
        }
        if (str == null) {
            return;
        }
        String fileMd5 = TTHelper.getFileMd5(new PolarisFileWrapper(str + File.separatorChar + "libavmdl.so"));
        if (fileMd5 != null && TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
            TTVideoEngineLog.e("DataLoaderHelper", "libavmdl md5: " + fileMd5);
        }
    }

    private boolean loadLibrary() {
        if (this.mProxy == null) {
            return true;
        }
        dumpLibMd5();
        if (this.mProxy != null && !this.isProxyLibraryLoaded) {
            if (this.mEnableMdlV2 == 1) {
                try {
                    this.mProxy.loadLibrary("avmdlbase");
                    this.isProxyLibraryLoaded = this.mProxy.loadLibrary("avmdlv2");
                } catch (Exception unused) {
                    this.isProxyLibraryLoaded = false;
                }
            }
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d("DataLoaderHelper", "try to load avmdl: " + this.isProxyLibraryLoaded);
            }
            if (!this.isProxyLibraryLoaded) {
                this.isProxyLibraryLoaded = this.mProxy.loadLibrary("avmdl");
            }
        }
        return this.isProxyLibraryLoaded;
    }

    public void cancelAllTasks() {
        if (this.mInnerDataLoader != null && this.mState == 0) {
            if (this.mEnableStrategyCenterCancelAll == 1 && StrategyHelper.helper().isRunning()) {
                StrategyHelper.helper().getCenter().e(31205, 1);
            }
            this.mLock.lock(ABLock.TYPE_READ);
            try {
                cancelAllTasksInternal();
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        TTVideoEngineLog.e("DataLoaderHelper", "need start mdl first");
    }

    public void cancelAllWaitReqs() {
        TTVideoEngineLog.d("DataLoaderHelper", "start do cancel all wait reqs");
        if (this.mInnerDataLoader != null && this.mState == 0) {
            this.mLock.lock(ABLock.TYPE_READ);
            try {
                this.mInnerDataLoader.cancelAllPreloadWaitReqs();
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        TTVideoEngineLog.e("DataLoaderHelper", "need start mdl first");
    }

    public void close() {
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            if (this.mState == 1) {
                TTVideoEngineLog.e("DataLoaderHelper", "DataLoader not started, not need close");
                return;
            }
            this.mListener.clearListeners();
            this.mInnerDataLoader.close();
            cancelAllTasksInternal();
            removeAllPreloadMedia(null, 1);
            this.mState = 1;
            TTNetWorkListener.getInstance().stopListen(this.mNetWorkChangeCbr);
            TTNetWorkListener.getInstance().unregisterListener(this.mContext);
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    public void onStartComplete() {
        this.mInnerDataloaderStartComplete = true;
        if (this.mInitializeState == IVideoEventLogger.MdlInitializeState.Initializing.ordinal()) {
            this.mInitializeState = IVideoEventLogger.MdlInitializeState.InitializeComplete.ordinal();
        }
        TTVideoEngineLog.d("DataLoaderHelper", "MediaDataLoader start complete");
        int currentAccessType = TTNetWorkListener.getInstance().getCurrentAccessType();
        this.mCurrentAccessType = currentAccessType;
        AVMDLDataLoader aVMDLDataLoader = this.mInnerDataLoader;
        if (aVMDLDataLoader != null) {
            aVMDLDataLoader.setIntValue(7219, currentAccessType);
            if (!StrategyHelper.helper().isRunning()) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d("DataLoaderHelper", "strategy center running failed, set mdl preload strategy back " + this.mMdlOldPreloadStrategy);
                }
                this.mInnerDataLoader.setIntValue(1030, this.mMdlOldPreloadStrategy);
            }
        }
        DataLoaderListenerWrapper dataLoaderListenerWrapper = this.mListener;
        if (dataLoaderListenerWrapper != null) {
            dataLoaderListenerWrapper.onNotify(11, 0L, 0L, "mdl start complete");
        }
        this.mListener.onStartComplete();
    }

    public void cancelAllTasksInternal() {
        ArrayList arrayList = new ArrayList();
        if (this.mExecuteTasks.count() > 0) {
            while (true) {
                DataLoaderTaskItem popBackItem = this.mExecuteTasks.popBackItem();
                if (popBackItem == null) {
                    break;
                }
                if (popBackItem.mPriorityLevel >= 10000) {
                    arrayList.add(popBackItem);
                } else {
                    VideoInfoFetcher videoInfoFetcher = popBackItem.mFetcher;
                    if (videoInfoFetcher != null) {
                        videoInfoFetcher.cancel();
                    }
                    _notifyPreloadCancel(popBackItem);
                }
            }
            for (int i = 0; i < arrayList.size(); i++) {
                this.mExecuteTasks.enqueueItem((DataLoaderTaskItem) arrayList.get(i));
            }
            arrayList.clear();
        }
        if (this.mPreloadTasks.count() > 0) {
            while (true) {
                DataLoaderTaskItem popBackItem2 = this.mPreloadTasks.popBackItem();
                if (popBackItem2 == null) {
                    break;
                }
                if (popBackItem2.mPriorityLevel >= 10000) {
                    arrayList.add(popBackItem2);
                } else {
                    VideoInfoFetcher videoInfoFetcher2 = popBackItem2.mFetcher;
                    if (videoInfoFetcher2 != null) {
                        videoInfoFetcher2.cancel();
                    }
                    _notifyPreloadCancel(popBackItem2);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                this.mPreloadTasks.enqueueItem((DataLoaderTaskItem) arrayList.get(i2));
            }
            arrayList.clear();
        }
        if (this.mAllPreloadTasks.count() > 0) {
            boolean z = false;
            while (true) {
                DataLoaderTaskItem popBackItem3 = this.mAllPreloadTasks.popBackItem();
                if (popBackItem3 == null) {
                    break;
                }
                if (popBackItem3.mPriorityLevel >= 10000) {
                    arrayList.add(popBackItem3);
                } else {
                    _notifyPreloadCancel(popBackItem3);
                    z = true;
                }
            }
            if (z) {
                this.mInnerDataLoader.cancelAll();
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                this.mAllPreloadTasks.enqueueItem((DataLoaderTaskItem) arrayList.get(i3));
            }
            arrayList.clear();
        }
    }

    private DataLoaderHelper() {
        this.isProxyLibraryLoaded = false;
        this.mProxy = null;
        this.mListener = new DataLoaderListenerWrapper();
        this.mTestSpeedListener = null;
        this.mState = 1;
        this.mPreloadTasks = new DataLoaderTaskQueue();
        this.mExecuteTasks = new DataLoaderTaskQueue();
        this.mAllPreloadTasks = new DataLoaderTaskQueue();
        this.mAllPlayTasks = new DataLoaderTaskQueue();
        this.mAllUsingEngies = new HashMap<>();
        this.mEngineLock = new ReentrantLock();
        this.mInnerDataLoader = null;
        this.mConfigure = null;
        this.mVCTrace = null;
        this.mDataLoaderHelperAdapter = new DataLoaderHelperAdapter();
        this.mContext = null;
        this.mClasssLoader = null;
        this.mModelCache = null;
        this.mException = null;
        this.mVersionInfo = null;
        this.mHeartBeat = null;
        this.mUploader = null;
        this.mEngineUploader = null;
        this.mNeedDLLoadP2PLib = 0;
        this.mNeedMDLLoadMDLV2Lib = false;
        this.mMdlProtocolHandle = -1L;
        this.mDemuxerHandle = 0L;
        this.mInvalidMdlProcotol = true;
        this.mMdlDataSourceId = 0;
        this.mEnableMdlProtocol = false;
        this.mHeartBeatInterval = 0;
        this.mEnableReportSpeed = 0;
        this.mEnableNetworkChangedListen = 0;
        this.mNetWorkChangeCb = null;
        this.mNetWorkChangeCbr = null;
        this.mCurrentAccessType = -1;
        this.mEnableDumpLibMd5 = 0;
        this.mNeedSpeedTestByTimeInternal = 0;
        this.mAudioPreloadFirst = false;
        this.mPreloadTaskIgnorePlayerStall = 1;
        this.mUpdatePlaySourceId = null;
        this.mFloatSize = 0;
        this.mPreloadPreConnect = 0;
        this.mEnablePreParseHost = 0;
        this.mEnableBackupIP = 0;
        this.mEnableFirstNativeMDL = 0;
        this.mCloseLocalServer = false;
        this.mEnableHls = 0;
        this.mSupportHls = false;
        this.mediaOperateThread = null;
        this.mReportLogEnable = true;
        this.mBackupLoaderType = 0;
        this.mMdlPreloadStrategy = 1;
        this.mMdlOldPreloadStrategy = 0;
        this.mEnableMdlV2 = 0;
        this.mDidConfigMdlV2 = false;
        this.mEnableBufferPreload = 0;
        this.mEnableSetMDLNetStatus = 0;
        this.mEnableStrategyCenterCancelAll = 0;
        this.mEnableCheckPreloadUrls = 0;
        this.mEnableSplitPreload = 0;
        this.mDashAudioPreloadMinSize = 0;
        this.mDashAudioPreloadRatio = 0;
        this.mForbidNativeMDLForOriUrl = false;
        this.mPreloadUtil = new PreloadUtil();
        this.mEnableLibManager = 0;
        this.mEnableHLSProxy = 0;
        this.mEnableCheckHLSProxyVVCtrl = 0;
        this.mEnablePreloadFirstTs = 0;
        this.mEnablePreloadAllTs = 0;
        this.mEnableLoadMdlv2Fulllib = 0;
        this.mEnableVideoModelHitCacheCallback = 0;
        this.mHLSProxyValid = false;
        this.mEnableCenterPreloadProgressCallback = 0;
        this.mEnableNotifyError = 0;
        this.mEnableNotOnlyNotifyNetError = 0;
        this.mDisableFilePathCheck = 0;
        this.mNotifyNetErrors = new ArrayList<>();
        this.mInvalidCode = IVideoEventLogger.MdlInvalidCode.None.ordinal();
        this.mInitializeState = IVideoEventLogger.MdlInitializeState.Default.ordinal();
        this.mInnerDataloaderStartComplete = false;
        this.mInitializeErrorString = null;
        this.mModelCache = VideoModelCache.getInstance();
        this.mState = 1;
        this.mConfigure = AVMDLDataLoaderConfigure.getDefaultonfigure();
        this.mVCTrace = new VCTrace();
        this.mLock = new ABLockWrapper(EngineGlobalConfig.getInstance().dataLoaderHelperLockType);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0191 A[Catch: Exception -> 0x01c5, TryCatch #0 {Exception -> 0x01c5, blocks: (B:88:0x017a, B:90:0x0191, B:92:0x0195, B:93:0x019f, B:95:0x01ad), top: B:87:0x017a }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ad A[Catch: Exception -> 0x01c5, TRY_LEAVE, TryCatch #0 {Exception -> 0x01c5, blocks: (B:88:0x017a, B:90:0x0191, B:92:0x0195, B:93:0x019f, B:95:0x01ad), top: B:87:0x017a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean initInternal() {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.DataLoaderHelper.initInternal():boolean");
    }

    public void tryStartStrategyCenter() {
        boolean z;
        if (this.mConfigure.mEnableIOManager != 0) {
            long longValue = this.mInnerDataLoader.getLongValue(7390);
            long longValue2 = this.mInnerDataLoader.getLongValue(7402);
            if (longValue != 0 && longValue != -1 && longValue != -998 && longValue2 >= 0) {
                this.mediaOperateThread = new PreloadMediaThread();
                StrategyHelper.helper().setIOManager(longValue, longValue2);
                StrategyHelper.helper().setContext(this.mContext);
                if (this.mProxy != null) {
                    z = StrategyHelper.helper().loadPluginLibrary(this.mProxy);
                } else {
                    z = false;
                }
                StrategyHelper.helper().start(!z);
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d("DataLoaderHelper", "after start strategy center running=" + StrategyHelper.helper().isRunning());
                }
                StrategyHelper.helper().configAppInfo(BaseAppInfo.toJsonString(), null);
                StrategyHelper.helper().getCenter().h(31211, VideoEventBase.appSessionId);
                StrategyHelper.helper().getCenter().h(31209, this.mConfigure.mCacheDir);
                if (this.mInnerDataLoader.isRunning()) {
                    if (!StrategyHelper.helper().isRunning()) {
                        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                            TTVideoEngineLog.d("DataLoaderHelper", "strategy center start failed, set mdl preload strategy back " + this.mMdlOldPreloadStrategy);
                        }
                        this.mInnerDataLoader.setIntValue(1030, this.mMdlOldPreloadStrategy);
                        return;
                    }
                    this.mInnerDataLoader.setIntValue(1030, this.mMdlPreloadStrategy);
                    return;
                }
                return;
            }
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d("DataLoaderHelper", "tryStartStrategyCenter iomanagerHandle or iomanagerVersion is not validiomanagerHandle=" + longValue + " iomanagerVersion=" + longValue2);
            }
        }
    }

    public void start() throws Exception {
        boolean z;
        Throwable targetException;
        int i;
        this.mLock.lock(ABLock.TYPE_WRITE);
        try {
            if (this.mState == 0) {
                TTVideoEngineLog.e("DataLoaderHelper", "DataLoader has started not need start");
                if (i > 0) {
                    return;
                } else {
                    return;
                }
            }
            this.mInitializeState = IVideoEventLogger.MdlInitializeState.Initializing.ordinal();
            if (initInternal()) {
                this.mExecuteTasks.setMaxCount(4L);
                this.mPreloadTasks.setMaxCount(20L);
                if (this.mConfigure == null) {
                    this.mConfigure = AVMDLDataLoaderConfigure.getDefaultonfigure();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!TextUtils.isEmpty(BaseAppInfo.mAppChannel)) {
                        jSONObject.put("app_channel", BaseAppInfo.mAppChannel);
                    }
                    if (!TextUtils.isEmpty(BaseAppInfo.mAppName)) {
                        jSONObject.put("app_name", BaseAppInfo.mAppName);
                    }
                    if (!TextUtils.isEmpty(BaseAppInfo.mDeviceId)) {
                        jSONObject.put("device_id", BaseAppInfo.mDeviceId);
                    }
                    if (!TextUtils.isEmpty(BaseAppInfo.mAppVersion)) {
                        jSONObject.put("app_version", BaseAppInfo.mAppVersion);
                    }
                    int i2 = BaseAppInfo.mAppID;
                    if (i2 >= 0) {
                        jSONObject.put("app_id", i2);
                    }
                    if (jSONObject.has("app_id")) {
                        this.mConfigure.mAppInfo = jSONObject.toString();
                        this.mConfigure.mAppID = BaseAppInfo.mAppID;
                    }
                } catch (JSONException e) {
                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                        TTVideoEngineLog.d(e);
                    }
                }
                if (this.mEngineUploader != null) {
                    this.mConfigure.mEnableReportTaskLog = 1;
                }
                if (this.mCloseLocalServer) {
                    this.mConfigure.mCloseLocalServer = 1;
                }
                this.mInnerDataLoader.setConfigure(this.mConfigure);
                if (this.mInnerDataLoader.start() >= 0) {
                    startVCTrace();
                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                        TTVideoEngineLog.i("DataLoaderHelper", "[preload] preload strategy " + this.mMdlPreloadStrategy);
                    }
                    tryStartStrategyCenter();
                    long longValue = this.mInnerDataLoader.getLongValue(7218);
                    this.mMdlProtocolHandle = longValue;
                    if (longValue == -1) {
                        this.mInvalidMdlProcotol = true;
                    }
                    if (this.mEnableFirstNativeMDL == 1 && this.mEnableMdlProtocol && longValue > 0) {
                        try {
                            Class<?> clzUsingPluginLoader = TTHelper.getClzUsingPluginLoader(200, "com.ss.ttm.player.TTPlayer");
                            Method declaredMethod = clzUsingPluginLoader.getDeclaredMethod("registerNativeMdl", Long.TYPE);
                            declaredMethod.setAccessible(true);
                            if (((Integer) declaredMethod.invoke(clzUsingPluginLoader, Long.valueOf(this.mMdlProtocolHandle))).intValue() == 0) {
                                TTVideoEngineLog.i("DataLoaderHelper", "firstNativeMDL effect");
                                TTVideoEngineImpl.setNativeMDLRegister();
                                this.mInvalidMdlProcotol = false;
                            }
                        } catch (Throwable th) {
                            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                                TTVideoEngineLog.e("DataLoaderHelper", th.toString());
                            }
                            if ((th instanceof InvocationTargetException) && (targetException = th.getTargetException()) != null && TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                                TTVideoEngineLog.e("DataLoaderHelper", targetException.toString());
                            }
                        }
                    }
                    if (this.mInnerDataLoader.getLongValue(9407) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.mSupportHls = z;
                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                        TTVideoEngineLog.i("DataLoaderHelper", "start: get mdlprotocolHandle: " + this.mMdlProtocolHandle);
                    }
                    this.mHeartBeat.start(this.mInnerDataLoader, this.mHeartBeatInterval);
                    this.mState = 0;
                    if (this.mInnerDataloaderStartComplete && this.mInitializeState == IVideoEventLogger.MdlInitializeState.Initializing.ordinal()) {
                        this.mInitializeState = IVideoEventLogger.MdlInitializeState.InitializeComplete.ordinal();
                    }
                    this.mNetWorkChangeCb = new TTNetworkStateCallback() { // from class: com.ss.ttvideoengine.DataLoaderHelper.3
                        @Override // com.ss.ttvideoengine.TTNetworkStateCallback
                        public void onAccessChanged(int i3, int i4, int i5) {
                            if (i3 != 0) {
                                return;
                            }
                            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                TTVideoEngineLog.d("DataLoaderHelper", "access changed, from: " + i4 + " to: " + i5);
                            }
                            DataLoaderHelper.this.mCurrentAccessType = i5;
                            DataLoaderHelper.this.setIntValue(1000, 1);
                            DataLoaderHelper.this.setIntValue(1104, i5);
                        }
                    };
                    this.mNetWorkChangeCbr = new WeakReference<>(this.mNetWorkChangeCb);
                    TTNetWorkListener.getInstance().startListen(this.mNetWorkChangeCbr);
                    int longValue2 = (int) this.mInnerDataLoader.getLongValue(7433);
                    this.mDemuxerHandle = MediaPlayerWrapper.getDemuxerFactory(longValue2);
                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                        TTVideoEngineLog.d("DataLoaderHelper", "KeyIsGetDemuxerVersion: " + longValue2 + ", handle: " + this.mDemuxerHandle);
                    }
                    if (this.mDemuxerHandle != 0) {
                        TTVideoEngineLog.d("DataLoaderHelper", "set KeyIsSetDemuxerHandle");
                        this.mInnerDataLoader.setLongValue(7432, this.mDemuxerHandle);
                    }
                    TTVideoEngineLog.d("DataLoaderHelper", "DataLoader start.");
                    this.mLock.unlock(ABLock.TYPE_WRITE);
                    if (EngineGlobalConfig.getInstance().enableMdlLockOptimizeV2 > 0) {
                        this.mLock.updateLockType(ABLock.LOCK_IMPL_VOID);
                        return;
                    }
                    return;
                }
                this.mInitializeState = IVideoEventLogger.MdlInitializeState.InitializeError.ordinal();
                this.mInitializeErrorString = "start data loader fail";
                throw new Exception("start data loader fail");
            }
            String str = "initMdlFail:" + AVMDLDataLoader.getLoadFailMsg();
            this.mInitializeState = IVideoEventLogger.MdlInitializeState.InitializeError.ordinal();
            throw new Exception(str);
        } finally {
            this.mLock.unlock(ABLock.TYPE_WRITE);
            if (EngineGlobalConfig.getInstance().enableMdlLockOptimizeV2 > 0) {
                this.mLock.updateLockType(ABLock.LOCK_IMPL_VOID);
            }
        }
    }

    public void setUploader(IVideoEventUploader iVideoEventUploader) {
        this.mUploader = iVideoEventUploader;
    }

    private boolean _supportProxy(String str) {
        return _supportProxy(str, 0);
    }

    private void reportSpeed(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo) {
        if (this.mEnableReportSpeed == 0) {
            return;
        }
        long j = aVMDLDataLoaderNotifyInfo.code;
    }

    public void _removePlayTask(String str) {
        this.mAllPlayTasks.popItem(str);
    }

    public void addListener(DataLoaderListener2 dataLoaderListener2) {
        this.mListener.addListener(dataLoaderListener2);
    }

    public long getCacheFileSize(String str) {
        return getCacheSize(str);
    }

    public void removeListener(DataLoaderListener2 dataLoaderListener2) {
        this.mListener.removeListener(dataLoaderListener2);
    }

    public synchronized void setEngineUploader(VideoEventEngineUploader videoEventEngineUploader) {
        this.mEngineUploader = videoEventEngineUploader;
    }

    public void setListener(DataLoaderListener dataLoaderListener) {
        this.mListener.setListener(dataLoaderListener);
    }

    public boolean startDownload(String str) {
        return startDownload(str, false);
    }

    public void updateLockType(int i) {
        this.mLock.updateLockType(i);
    }

    public class DataLoaderCacheFileInfo {
        public String mLocalFilePath = null;
        public long mMediaSize = 0;
        public long mCacheSizeFromZero = 0;

        static {
            Covode.recordClassIndex(652252);
        }

        public DataLoaderCacheFileInfo() {
        }
    }

    public class DataLoaderCacheInfo {
        public long mMediaSize = 0;
        public long mCacheSizeFromZero = 0;
        public String mLocalFilePath = null;

        static {
            Covode.recordClassIndex(652253);
        }

        public DataLoaderCacheInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _doMl_removePriorityTask(String str) {
        StrategyHelper.helper().getCenter().y(str);
    }

    public void cancelTaskByFilePath(String str) {
        cancelTask(TTHelper.keyFromFilePath(this.mContext, str));
    }

    public void createScene(PreloadScene preloadScene) {
        StrategyHelper.helper().getCenter().k(preloadScene.toJsonString());
    }

    public void destroyScene(String str) {
        StrategyHelper.helper().getCenter().l(str);
    }

    public void doParseHosts(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            this.mEnablePreParseHost = 1;
            this.mInnerDataLoader.doParseHosts(strArr);
        }
    }

    public boolean isNotifyNetworkErrorCodes(int i) {
        if (this.mNotifyNetErrors.contains(Integer.valueOf(i))) {
            return true;
        }
        return false;
    }

    public void moveToScene(String str) {
        StrategyHelper.helper().getCenter().O(str);
    }

    public void notifyTriggerPreload(long j) {
        DataLoaderListenerWrapper dataLoaderListenerWrapper = this.mListener;
        if (dataLoaderListenerWrapper == null) {
            return;
        }
        dataLoaderListenerWrapper.onNotify(9, 0L, j, "");
    }

    public void setPreloadLogLevel(int i) {
        if (i == 1) {
            i = 1;
        }
        if (i >= 4) {
            i = 5;
        }
        StrategyHelper.helper().setLogLevel(i);
    }

    public class DataLoaderTaskProgressInfo {
        public String mKey = null;
        public String mVideoId = null;
        public String mLocalFilePath = null;
        public long mMediaSize = 0;
        public long mCacheSizeFromZero = 0;
        public Resolution mResolution = Resolution.Undefine;
        public String mDecryptionKey = null;
        public VideoInfo mUsingVideoInfo = null;
        public int mTaskType = 0;

        static {
            Covode.recordClassIndex(652263);
        }

        public DataLoaderTaskProgressInfo() {
        }
    }

    private void _notifyPreloadCancel(DataLoaderTaskItem dataLoaderTaskItem) {
        if (dataLoaderTaskItem == null || dataLoaderTaskItem.mDidCanceled) {
            return;
        }
        dataLoaderTaskItem.mDidCanceled = true;
        if (dataLoaderTaskItem.getCallBackListener() != null) {
            dataLoaderTaskItem.getCallBackListener().preloadItemInfo(new PreLoaderItemCallBackInfo(5));
        }
    }

    private void _startFetchSmartUrlInfo(DataLoaderTaskItem dataLoaderTaskItem) {
        CodecStrategyAdapter codecStrategyAdapter;
        PreloaderURLItem preloaderURLItem = dataLoaderTaskItem.mURLItem;
        if (preloaderURLItem == null || (codecStrategyAdapter = preloaderURLItem.mAdapter) == null) {
            return;
        }
        codecStrategyAdapter.fetchSmartUrlInfo(new DataLoaderTaskItem.MySmartUrlFetcherListener(dataLoaderTaskItem));
    }

    public void addPriorityPreloadTask(PreloadModelMedia preloadModelMedia) {
        if (preloadModelMedia != null) {
            if (this.mediaOperateThread != null) {
                ArrayList<Object> arrayList = new ArrayList<>();
                arrayList.add(this);
                arrayList.add(preloadModelMedia);
                this.mediaOperateThread.postMessage(arrayList, 115);
                return;
            }
            _doMl_addPriorityTask(preloadModelMedia);
        }
    }

    public DataLoaderCacheFileInfo cacheFileInfo(String str) {
        DataLoaderCacheInfo cacheInfo = getCacheInfo(str);
        if (cacheInfo != null) {
            DataLoaderCacheFileInfo dataLoaderCacheFileInfo = new DataLoaderCacheFileInfo();
            dataLoaderCacheFileInfo.mMediaSize = cacheInfo.mMediaSize;
            dataLoaderCacheFileInfo.mCacheSizeFromZero = cacheInfo.mCacheSizeFromZero;
            dataLoaderCacheFileInfo.mLocalFilePath = cacheInfo.mLocalFilePath;
            return dataLoaderCacheFileInfo;
        }
        return null;
    }

    public void copyCache(final CopyCacheItem copyCacheItem) {
        if (copyCacheItem == null) {
            return;
        }
        AVMDLCopyOperation aVMDLCopyOperation = new AVMDLCopyOperation(copyCacheItem.mFileKey, copyCacheItem.mDestPath, copyCacheItem.mForceCopyUnfinished, copyCacheItem.mWaitIfCaching, new AVMDLCopyOperationListener() { // from class: com.ss.ttvideoengine.DataLoaderHelper.4
            public void onFileInfo(AVMDLFileInfo aVMDLFileInfo) {
                if (copyCacheItem.mListener != null) {
                    DataLoaderCacheInfo dataLoaderCacheInfo = DataLoaderHelper.this.new DataLoaderCacheInfo();
                    dataLoaderCacheInfo.mMediaSize = aVMDLFileInfo.mContentLenght;
                    dataLoaderCacheInfo.mCacheSizeFromZero = aVMDLFileInfo.mCacheSize;
                    copyCacheItem.mListener.onFileInfo(dataLoaderCacheInfo);
                }
            }

            public void onCopyComplete(boolean z, int i, String str) {
                CopyCacheListener copyCacheListener = copyCacheItem.mListener;
                if (copyCacheListener != null) {
                    copyCacheListener.onCopyComplete(z, i, str);
                }
            }
        });
        aVMDLCopyOperation.mCustomDir = copyCacheItem.mCustomDir;
        asyncCopyOperation(aVMDLCopyOperation);
    }

    public String getCheckSumInfo(String str) {
        try {
            if (this.mListener == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return this.mListener.getCheckSumInfo(str);
        } catch (Exception e) {
            if (!TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                return null;
            }
            TTVideoEngineLog.d(e);
            return null;
        }
    }

    public void removePriorityPreloadTask(String str) {
        if (str != null) {
            if (this.mediaOperateThread != null) {
                ArrayList<Object> arrayList = new ArrayList<>();
                arrayList.add(this);
                arrayList.add(str);
                this.mediaOperateThread.postMessage(arrayList, 116);
                return;
            }
            _doMl_removePriorityTask(str);
        }
    }

    public void setLoadProxy(LibraryLoaderProxy libraryLoaderProxy) {
        this.mLock.lock(ABLock.TYPE_WRITE);
        if (libraryLoaderProxy != null) {
            try {
                this.mProxy = libraryLoaderProxy;
            } finally {
                this.mLock.unlock(ABLock.TYPE_WRITE);
            }
        }
    }

    public void setLoaderEventListener(LoaderListener loaderListener) {
        this.mLock.lock(ABLock.TYPE_VOID);
        try {
            AVMDLDataLoader.getInstance().setEventListener(loaderListener);
        } finally {
            this.mLock.unlock(ABLock.TYPE_VOID);
        }
    }

    public void setReportLogEnable(boolean z) {
        this.mLock.lock(ABLock.TYPE_VOID);
        try {
            this.mReportLogEnable = z;
        } finally {
            this.mLock.unlock(ABLock.TYPE_VOID);
        }
    }

    public void setTaskEventListener(AVMDLTaskEventListener aVMDLTaskEventListener) {
        if (this.mInnerDataLoader == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "need start mdl first");
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        this.mInnerDataLoader.setTaskEventListener(aVMDLTaskEventListener);
        this.mLock.unlock(ABLock.TYPE_READ);
    }

    public void setTestSpeedListener(TestSpeedListener testSpeedListener) {
        this.mLock.lock(ABLock.TYPE_VOID);
        try {
            this.mTestSpeedListener = testSpeedListener;
        } finally {
            this.mLock.unlock(ABLock.TYPE_VOID);
        }
    }

    private String _constructEnginePortaint(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enable_engineportaint", this.mConfigure.mEnableEnginePortrait);
            for (String str : map.keySet()) {
                jSONObject.put(str, map.get(str));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d(e);
            }
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _doMl_addPriorityTask(PreloadModelMedia preloadModelMedia) {
        MySelectBitrateListener mySelectBitrateListener;
        MyPreloadTaskCallbackListener myPreloadTaskCallbackListener = null;
        if (preloadModelMedia.getSelectCallback() != null) {
            mySelectBitrateListener = new MySelectBitrateListener(preloadModelMedia.getSelectCallback());
        } else {
            mySelectBitrateListener = null;
        }
        if (preloadModelMedia.getCallBackListener() != null) {
            myPreloadTaskCallbackListener = new MyPreloadTaskCallbackListener(preloadModelMedia.getCallBackListener());
        }
        StrategyHelper.helper().getCenter().d(preloadModelMedia.toStrategyInfo(), mySelectBitrateListener, myPreloadTaskCallbackListener);
    }

    private JSONObject _onHeartBeatFire(JSONObject jSONObject) {
        try {
            long playWastDataSize = VideoInfoCollector.getInstance().getPlayWastDataSize();
            if (playWastDataSize > 0) {
                jSONObject.put("_play_waste_data", playWastDataSize);
            }
            long playConsumedSize = VideoInfoCollector.getInstance().getPlayConsumedSize();
            if (playConsumedSize > 0) {
                jSONObject.put("_play_consumed_data", playConsumedSize);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void asyncCopyOperation(AVMDLCopyOperation aVMDLCopyOperation) {
        AVMDLDataLoader aVMDLDataLoader;
        if (this.mState != 0) {
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            aVMDLDataLoader = this.mInnerDataLoader;
        } finally {
            try {
            } finally {
            }
        }
        if (aVMDLDataLoader == null) {
            return;
        }
        aVMDLDataLoader.asyncCopyOperation(aVMDLCopyOperation);
    }

    private void changeConfigWithPermission(AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure) {
        if (!FeatureManager.hasPermission("http_dns")) {
            aVMDLDataLoaderConfigure.mEnableExternDNS = 0;
        }
        if (FeatureManager.hasPermission("native_mdl") && InfoWrapper.getNativeMdlEnable() == 1) {
            this.mEnableMdlProtocol = true;
        }
        StrategyManager.instance().mdlStart(aVMDLDataLoaderConfigure);
    }

    public void addTask(PreloaderURLItem preloaderURLItem) {
        if (preloaderURLItem == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] url item invalid");
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            _addTask(preloaderURLItem.getKey(), preloaderURLItem.getVideoId(), preloaderURLItem.getPreloadSize(), null, null, preloaderURLItem);
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    public void cleanCacheDir(long j) {
        if (this.mState != 0) {
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            AVMDLDataLoader aVMDLDataLoader = this.mInnerDataLoader;
            if (aVMDLDataLoader != null) {
                aVMDLDataLoader.cleanCacheDir(j);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public void clearAllCaches(boolean z) {
        AVMDLDataLoader aVMDLDataLoader;
        if (this.mState != 0) {
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            aVMDLDataLoader = this.mInnerDataLoader;
        } finally {
            try {
            } finally {
            }
        }
        if (aVMDLDataLoader == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "mInnerDataLoader == null");
            return;
        }
        if (z) {
            aVMDLDataLoader.forceClearAllCaches();
        } else {
            aVMDLDataLoader.clearAllCaches();
        }
    }

    public void disableAutoTrim(String str) {
        if (!TextUtils.isEmpty(str) && this.mInnerDataLoader != null) {
            this.mLock.lock(ABLock.TYPE_READ);
            try {
                this.mInnerDataLoader.makeFileAutoDeleteFlag(str, 1);
            } finally {
                this.mLock.unlock(ABLock.TYPE_READ);
            }
        }
    }

    public void enableAutoTrim(String str) {
        if (!TextUtils.isEmpty(str) && this.mInnerDataLoader != null) {
            this.mLock.lock(ABLock.TYPE_READ);
            try {
                this.mInnerDataLoader.makeFileAutoDeleteFlag(str, 0);
            } finally {
                this.mLock.unlock(ABLock.TYPE_READ);
            }
        }
    }

    public long getCacheSize(String str) {
        long j = 0;
        if (this.mState != 0) {
            return 0L;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            AVMDLDataLoader aVMDLDataLoader = this.mInnerDataLoader;
            if (aVMDLDataLoader != null) {
                long cacheSize = aVMDLDataLoader.getCacheSize(str);
                if (cacheSize > 0) {
                    j = cacheSize;
                }
            }
        } finally {
            try {
                return j;
            } finally {
            }
        }
        return j;
    }

    public long getCacheSizeByFilePath(String str) {
        this.mLock.lock(ABLock.TYPE_READ);
        long j = 0;
        try {
            if (this.mInnerDataLoader != null) {
                long cacheSize = this.mInnerDataLoader.getCacheSize(TTHelper.keyFromFilePath(this.mContext, str), str);
                if (cacheSize > 0) {
                    j = cacheSize;
                }
            }
        } finally {
            try {
                return j;
            } finally {
            }
        }
        return j;
    }

    public String getPlayLog(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            try {
                AVMDLDataLoader aVMDLDataLoader = this.mInnerDataLoader;
                if (aVMDLDataLoader != null) {
                    str2 = aVMDLDataLoader.getStringValueByStr(str, 1010);
                }
            } catch (Exception e) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(e);
                }
            }
            return str2;
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    public String getPreloadTraceId(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            try {
                AVMDLDataLoader aVMDLDataLoader = this.mInnerDataLoader;
                if (aVMDLDataLoader != null) {
                    str2 = aVMDLDataLoader.getStringValueByStr(str, 1012);
                }
            } catch (Exception e) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(e);
                }
            }
            return str2;
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    public long quickQueryCacheFileSize(String str) {
        long j = 0;
        if (this.mState != 0) {
            return 0L;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            AVMDLDataLoader aVMDLDataLoader = this.mInnerDataLoader;
            if (aVMDLDataLoader != null) {
                long quickQueryCacheSize = aVMDLDataLoader.quickQueryCacheSize(str);
                if (quickQueryCacheSize > 0) {
                    j = quickQueryCacheSize;
                }
            }
        } finally {
            try {
                return j;
            } finally {
            }
        }
        return j;
    }

    public void setProtectCacheDirsAvoidClear(String[] strArr) {
        TTVideoEngineLog.d("DataLoaderHelper", "set protect dirs avoid clear when use clear interface");
        this.mLock.lock(ABLock.TYPE_WRITE);
        try {
            this.mConfigure.setProtectCacheDirs(strArr);
        } finally {
            this.mLock.unlock(ABLock.TYPE_WRITE);
        }
    }

    public long tryQuickGetCacheFileSize(String str) {
        long j = 0;
        if (this.mState != 0) {
            return 0L;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            AVMDLDataLoader aVMDLDataLoader = this.mInnerDataLoader;
            if (aVMDLDataLoader != null) {
                long tryQuickGetCacheSize = aVMDLDataLoader.tryQuickGetCacheSize(str);
                if (tryQuickGetCacheSize > 0) {
                    j = tryQuickGetCacheSize;
                }
            }
        } finally {
            try {
                return j;
            } finally {
            }
        }
        return j;
    }

    public void tryToClearCachesByUsedTime(long j) {
        AVMDLDataLoader aVMDLDataLoader;
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            aVMDLDataLoader = this.mInnerDataLoader;
        } finally {
            try {
            } finally {
            }
        }
        if (aVMDLDataLoader == null) {
            return;
        }
        aVMDLDataLoader.tryToClearCachesByUsedTime(j);
    }

    private ArrayList<WeakReference<TTVideoEngine>> _getEnginesByRawKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            this.mEngineLock.lock();
            ArrayList<WeakReference<TTVideoEngine>> arrayList = this.mAllUsingEngies.get(str);
            if (arrayList == null) {
                return null;
            }
            ArrayList<WeakReference<TTVideoEngine>> arrayList2 = new ArrayList<>();
            arrayList2.addAll(arrayList);
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i("DataLoaderHelper", "get engine ref,rawKey = " + str + " engine ref count: " + arrayList2.size());
            }
            return arrayList2;
        } finally {
            this.mEngineLock.unlock();
        }
    }

    private DataLoaderCacheInfo _processCacheInfo(String str) {
        DataLoaderCacheInfo dataLoaderCacheInfo = null;
        if (str == null) {
            return null;
        }
        String[] split = str.split(",");
        if (split.length >= 4) {
            dataLoaderCacheInfo = new DataLoaderCacheInfo();
            dataLoaderCacheInfo.mLocalFilePath = split[3];
            if (!TextUtils.isEmpty(split[0])) {
                dataLoaderCacheInfo.mCacheSizeFromZero = Long.valueOf(split[0]).longValue();
            }
            if (!TextUtils.isEmpty(split[1])) {
                dataLoaderCacheInfo.mMediaSize = Long.valueOf(split[1]).longValue();
            }
        }
        return dataLoaderCacheInfo;
    }

    private String[] _removeRepeatUrls(String[] strArr) {
        if (strArr != null && strArr.length > 1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(strArr[0]);
            for (int i = 1; i < strArr.length; i++) {
                String str = strArr[i];
                Boolean bool = Boolean.TRUE;
                int size = arrayList.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    if (((String) arrayList.get(size)).equals(str)) {
                        bool = Boolean.FALSE;
                        break;
                    }
                    size--;
                }
                if (bool.booleanValue()) {
                    arrayList.add(str);
                }
            }
            String[] strArr2 = new String[arrayList.size()];
            arrayList.toArray(strArr2);
            return strArr2;
        }
        return strArr;
    }

    public static final String encodeUrlByQuery(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d("TTHelperEncode", "before encode:" + str);
        }
        try {
            String queryComponentEncode = AVMDLDataLoader.queryComponentEncode(str);
            if (TextUtils.isEmpty(queryComponentEncode)) {
                TTVideoEngineLog.d("TTHelperEncode", "call native encode fail,try java");
                queryComponentEncode = URLEncoder.encode(str, "UTF-8");
            }
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d("TTHelperEncode", "after encode:" + queryComponentEncode);
                return queryComponentEncode;
            }
            return queryComponentEncode;
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public String _getProxyUrl(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("mdl://")) {
                return str;
            }
            int indexOf = str.indexOf("?");
            if (indexOf == -1) {
                return null;
            }
            String localAddr = this.mInnerDataLoader.getLocalAddr();
            if (TextUtils.isEmpty(localAddr)) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("http://");
            stringBuffer.append(localAddr);
            stringBuffer.append(str.substring(indexOf));
            String stringBuffer2 = stringBuffer.toString();
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                TTVideoEngineLog.e("DataLoaderHelper", "_proxyUrl: " + stringBuffer2);
            }
            return stringBuffer2;
        } catch (Exception unused) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                TTVideoEngineLog.e("DataLoaderHelper", "get proxy url failed: " + str);
                return str;
            }
            return str;
        }
    }

    String _headerString(HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.size() >= 1) {
            StringBuilder sb = new StringBuilder();
            for (String str : hashMap.keySet()) {
                sb.append(str);
                sb.append(":");
                sb.append(" ");
                sb.append(hashMap.get(str));
                sb.append("\r\n");
            }
            return sb.toString();
        }
        return null;
    }

    public void addPreloadModelMedia(PreloadModelMedia preloadModelMedia) {
        IVideoModel iVideoModel;
        if (!FeatureManager.hasPermission("preload")) {
            return;
        }
        if (preloadModelMedia != null && (iVideoModel = preloadModelMedia.mVideoModel) != null && preloadModelMedia.mResolution != null) {
            if (TextUtils.isEmpty(iVideoModel.getVideoRefStr(2))) {
                TTVideoEngineLog.e("DataLoaderHelper", "[preload] videoId invalid.");
                if (preloadModelMedia.getCallBackListener() != null) {
                    PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(3);
                    preLoaderItemCallBackInfo.preloadError = new Error("kTTVideoErrorDomainDataLoaderPreload", -100001);
                    preloadModelMedia.getCallBackListener().preloadItemInfo(preLoaderItemCallBackInfo);
                    return;
                }
                return;
            }
            _ml_addMedia(preloadModelMedia, preloadModelMedia.mSceneId);
            return;
        }
        TTVideoEngineLog.e("DataLoaderHelper", "[preload] addTask videoModel input invalid");
        if (preloadModelMedia != null && preloadModelMedia.getCallBackListener() != null) {
            PreLoaderItemCallBackInfo preLoaderItemCallBackInfo2 = new PreLoaderItemCallBackInfo(3);
            preLoaderItemCallBackInfo2.preloadError = new Error("kTTVideoErrorDomainDataLoaderPreload", -100001);
            preloadModelMedia.getCallBackListener().preloadItemInfo(preLoaderItemCallBackInfo2);
        }
    }

    public void addTask(PreloaderVidItem preloaderVidItem) {
        if (preloaderVidItem == null || this.mState != 0) {
            return;
        }
        if (TextUtils.isEmpty(preloaderVidItem.mVideoId)) {
            TTVideoEngineLog.e("DataLoaderHelper", "videoId invalid.");
            return;
        }
        String str = preloaderVidItem.mVideoId + "_" + preloaderVidItem.mResolution.toString(0) + preloaderVidItem.mCodecType + preloaderVidItem.mDashEnable + preloaderVidItem.mHlsEnable + preloaderVidItem.mEncryptEnable;
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            _addTask(str, preloaderVidItem.mVideoId, preloaderVidItem.mPreloadSize, preloaderVidItem, null, null);
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    public void checkLoaderType(int i) {
        int i2;
        this.mLock.lock(ABLock.TYPE_READ);
        if (this.mConfigure.mLoaderType != i && (i2 = this.mBackupLoaderType) != i) {
            if (i2 > 0) {
                return;
            }
            try {
                try {
                    this.mInnerDataLoader.setIntValue(7227, i);
                } catch (Exception unused) {
                    TTVideoEngineLog.d("DataLoaderHelper", "set backup loader type failed");
                }
            } finally {
                this.mLock.unlock(ABLock.TYPE_READ);
            }
        }
    }

    void forceRemoveCacheFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
        } finally {
            try {
            } finally {
            }
        }
        if (this.mInnerDataLoader == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "mInnerDataLoader == null");
            return;
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i("DataLoaderHelper", " force remove mdl file. key " + str);
        }
        this.mInnerDataLoader.forceRemoveFileCache(str);
    }

    public JSONObject getCDNLog(String str) {
        String cDNLog;
        if (this.mState != 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            try {
                AVMDLDataLoader aVMDLDataLoader = this.mInnerDataLoader;
                if (aVMDLDataLoader != null && (cDNLog = aVMDLDataLoader.getCDNLog(str)) != null) {
                    JSONObject jSONObject = new JSONObject(cDNLog);
                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                        TTVideoEngineLog.d("DataLoaderHelper", "get cdn log suc" + jSONObject.toString());
                    }
                    return jSONObject;
                }
            } catch (Exception e) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d("DataLoaderHelper", "get log exception" + e.toString());
                }
            }
            return null;
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    public DataLoaderCacheInfo getCacheInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            if (this.mInnerDataLoader != null && this.mState == 0) {
                return _processCacheInfo(this.mInnerDataLoader.getStringCacheInfo(str));
            }
        } finally {
            try {
                return null;
            } finally {
            }
        }
        return null;
    }

    public DataLoaderCacheInfo getCacheInfoByFilePath(String str) {
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            if (this.mInnerDataLoader != null) {
                return _processCacheInfo(this.mInnerDataLoader.getStringCacheInfo(TTHelper.keyFromFilePath(this.mContext, str), str));
            }
        } finally {
            try {
                return null;
            } finally {
            }
        }
        return null;
    }

    public long getDownloadCountByVid(String str) {
        long j = -1;
        if (this.mState != 0 || TextUtils.isEmpty(str)) {
            return -1L;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            try {
                AVMDLDataLoader aVMDLDataLoader = this.mInnerDataLoader;
                if (aVMDLDataLoader != null) {
                    j = aVMDLDataLoader.getDownloadCount(str);
                }
            } catch (Exception e) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d("DataLoaderHelper", "get download count failed:" + e.toString());
                }
            }
            return j;
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    public long getIoWriteError(String str) {
        if (TextUtils.isEmpty(str) || this.mState != 0) {
            return -1L;
        }
        this.mLock.lock();
        try {
            AVMDLDataLoader aVMDLDataLoader = this.mInnerDataLoader;
            if (aVMDLDataLoader != null) {
                long longValueByStr = aVMDLDataLoader.getLongValueByStr(str, 1013);
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d("DataLoaderHelper", "get io write error code = " + longValueByStr);
                }
                return longValueByStr;
            }
        } finally {
            try {
                return -1L;
            } finally {
            }
        }
        return -1L;
    }

    public long getLongValue(int i) {
        long j;
        this.mLock.lock(ABLock.TYPE_READ);
        long j2 = -1;
        try {
            if (i != 1003) {
                if (i != 1152) {
                    if (i != 1153) {
                        return -1L;
                    }
                    j = this.mConfigure.mMonitorMinAllowLoadSize;
                } else {
                    j = this.mConfigure.mMonitorTimeInternal;
                }
                return j;
            }
            if (this.mEnableMdlProtocol) {
                j2 = this.mMdlProtocolHandle;
            }
            return j2;
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    public long getLongestUnusedTimeOfCacheDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            if (this.mInnerDataLoader != null && this.mState == 0) {
                return this.mInnerDataLoader.getLongestUnusedTimeOfCacheDir(str);
            }
        } finally {
            try {
                return -1L;
            } finally {
            }
        }
        return -1L;
    }

    public String getStringValue(int i) {
        String str;
        AVMDLDataLoader aVMDLDataLoader;
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            try {
            } catch (Exception e) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(e);
                }
            }
            if (i != 0) {
                if (i != 6) {
                    if (i != 1509) {
                        if (i == 9010) {
                            str = this.mConfigure.mSocketTraingCenterConfigStr;
                        }
                        return null;
                    }
                    str = this.mConfigure.mCustomUA;
                } else {
                    if (this.mVersionInfo == null && (aVMDLDataLoader = this.mInnerDataLoader) != null) {
                        this.mVersionInfo = aVMDLDataLoader.getStringValue(11);
                    }
                    str = this.mVersionInfo;
                }
            } else {
                str = this.mConfigure.mCacheDir;
            }
            return str;
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    public void preConnect(String str) {
        if (this.mState == 0 && !TextUtils.isEmpty(str)) {
            this.mLock.lock(ABLock.TYPE_READ);
            try {
                Uri parse = Uri.parse(str);
                int port = parse.getPort();
                if (port == -1) {
                    if (str.startsWith("https")) {
                        port = 443;
                    } else {
                        port = 80;
                    }
                }
                AVMDLDataLoader aVMDLDataLoader = this.mInnerDataLoader;
                if (aVMDLDataLoader != null) {
                    aVMDLDataLoader.preConnectByHost(parse.getHost(), port);
                }
            } finally {
                this.mLock.unlock(ABLock.TYPE_READ);
            }
        }
    }

    public void removeCacheFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
        } finally {
            try {
            } finally {
            }
        }
        if (this.mInnerDataLoader == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "mInnerDataLoader == null");
            return;
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i("DataLoaderHelper", "remove mdl file. key " + str);
        }
        this.mInnerDataLoader.removeFileCache(str);
    }

    public void removeDownloadFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
        } finally {
            try {
            } finally {
            }
        }
        if (this.mInnerDataLoader == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "mInnerDataLoader == null");
            return;
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i("DataLoaderHelper", "remove mdl file, download key " + str);
        }
        this.mInnerDataLoader.removeFileCache(str);
    }

    public void resetPreloadTraceId(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            try {
            } catch (Exception e) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(e);
                }
            }
            if (this.mInnerDataLoader != null && this.mState == 0) {
                this.mInnerDataLoader.resetPreloadTraceId(str);
            }
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    public void setClassLoader(ClassLoader classLoader) {
        if (classLoader == null) {
            TTVideoEngineLog.d("DataLoaderHelper", "class loader null");
            return;
        }
        this.mLock.lock(ABLock.TYPE_WRITE);
        try {
            if (this.mClasssLoader == null) {
                this.mClasssLoader = classLoader;
            }
            this.mLock.unlock(ABLock.TYPE_WRITE);
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d("DataLoaderHelper", "set class loader end" + classLoader);
            }
        } catch (Throwable th) {
            this.mLock.unlock(ABLock.TYPE_WRITE);
            throw th;
        }
    }

    public void setContext(Context context) {
        if (context == null) {
            TTVideoEngineLog.d("DataLoaderHelper", "set context null");
            return;
        }
        this.mLock.lock(ABLock.TYPE_WRITE);
        try {
            if (this.mContext == null) {
                SettingsHelper.helper().setContext(context);
                SettingsHelper.helper().loadMDLCache();
            }
            this.mContext = context;
            this.mLock.unlock(ABLock.TYPE_WRITE);
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d("DataLoaderHelper", "set context end" + context);
            }
        } catch (Throwable th) {
            this.mLock.unlock(ABLock.TYPE_WRITE);
            throw th;
        }
    }

    public void suspendedDownload(String str) {
        AVMDLDataLoader aVMDLDataLoader;
        if (this.mState != 0) {
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            aVMDLDataLoader = this.mInnerDataLoader;
        } finally {
            try {
            } finally {
            }
        }
        if (aVMDLDataLoader == null) {
            return;
        }
        aVMDLDataLoader.suspendDownload(str);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i("DataLoaderHelper", "[downloader] suspended download, key = " + str);
        }
    }

    private class MyTaskListener implements TaskListener {
        private final WeakReference<DataLoaderHelper> mDataLoader;

        static {
            Covode.recordClassIndex(652268);
        }

        @Override // com.ss.ttvideoengine.DataLoaderHelper.TaskListener
        public void taskFinished(DataLoaderTaskItem dataLoaderTaskItem) {
            IVideoInfo selectBitrate;
            DataLoaderHelper dataLoaderHelper = this.mDataLoader.get();
            if (dataLoaderHelper == null || dataLoaderTaskItem == null) {
                return;
            }
            IVideoModel iVideoModel = dataLoaderTaskItem.mResponseData;
            if (iVideoModel != null) {
                PreloaderVidItem preloaderVidItem = dataLoaderTaskItem.mVidItem;
                if (preloaderVidItem.mGearStrategyEnabled == 3 && preloaderVidItem.mResolution == Resolution.Auto && (selectBitrate = GearStrategySC.selectBitrate(iVideoModel, 2, preloaderVidItem.mGearStrategyExtraParams, null)) != null) {
                    dataLoaderTaskItem.mVidItem.mResolution = selectBitrate.getResolution();
                    dataLoaderTaskItem.mSetResolution = dataLoaderTaskItem.mVidItem.mResolution;
                }
            }
            if (dataLoaderTaskItem.mResponseData != null && dataLoaderTaskItem.getCallBackListener() != null) {
                PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(4);
                preLoaderItemCallBackInfo.fetchVideoModel = (VideoModel) dataLoaderTaskItem.mResponseData;
                dataLoaderTaskItem.getCallBackListener().preloadItemInfo(preLoaderItemCallBackInfo);
                PreloaderVidItem preloaderVidItem2 = dataLoaderTaskItem.mVidItem;
                if (preloaderVidItem2 != null) {
                    dataLoaderTaskItem.mSetResolution = preloaderVidItem2.mResolution;
                }
            }
            PreloaderVidItem preloaderVidItem3 = dataLoaderTaskItem.mVidItem;
            if (preloaderVidItem3 != null && preloaderVidItem3.getFetchEndListener() != null) {
                dataLoaderTaskItem.mVidItem.getFetchEndListener().fetchEnd((VideoModel) dataLoaderTaskItem.mResponseData, dataLoaderTaskItem.mResponseError);
                dataLoaderTaskItem.mSetResolution = dataLoaderTaskItem.mVidItem.mResolution;
            }
            PreloaderVidItem preloaderVidItem4 = dataLoaderTaskItem.mVidItem;
            if (preloaderVidItem4 != null && !preloaderVidItem4.getOnlyFetchVideoModel()) {
                dataLoaderHelper._exectTask(dataLoaderTaskItem);
            }
            if (dataLoaderTaskItem.mResponseError != null) {
                if (dataLoaderHelper.mListener != null) {
                    dataLoaderHelper.mListener.dataLoaderError(dataLoaderTaskItem.mVideoId, 1, dataLoaderTaskItem.mResponseError);
                }
                if (dataLoaderTaskItem.getCallBackListener() != null) {
                    PreLoaderItemCallBackInfo preLoaderItemCallBackInfo2 = new PreLoaderItemCallBackInfo(3);
                    preLoaderItemCallBackInfo2.preloadError = dataLoaderTaskItem.mResponseError;
                    dataLoaderTaskItem.getCallBackListener().preloadItemInfo(preLoaderItemCallBackInfo2);
                }
            }
        }

        public MyTaskListener(DataLoaderHelper dataLoaderHelper) {
            this.mDataLoader = new WeakReference<>(dataLoaderHelper);
        }
    }

    private void notifyUrlChange(String str) {
        int i;
        TTVideoEngine tTVideoEngine;
        if (str == null) {
            return;
        }
        String[] split = str.split(",");
        if (split.length >= 3) {
            String str2 = split[0];
            try {
                i = Integer.parseInt(split[1]);
            } catch (Exception e) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d("DataLoaderHelper", "notifyUrlChange " + e);
                }
                i = -1;
            }
            String str3 = split[2];
            ArrayList<WeakReference<TTVideoEngine>> _getEnginesByRawKey = _getEnginesByRawKey(str2);
            if (_getEnginesByRawKey == null) {
                TTVideoEngineLog.d("DataLoaderHelper", "notifyUrlChange weakReferences is null");
                return;
            }
            try {
                str3 = URLDecoder.decode(str3, "UTF-8");
            } catch (Exception e2) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                    TTVideoEngineLog.e("DataLoaderHelper", "notifyUrlChange " + e2);
                }
            }
            Iterator<WeakReference<TTVideoEngine>> it2 = _getEnginesByRawKey.iterator();
            while (it2.hasNext()) {
                WeakReference<TTVideoEngine> next = it2.next();
                if (next != null && (tTVideoEngine = next.get()) != null) {
                    tTVideoEngine.playUrlChanged(i, str3, str2);
                }
            }
        }
    }

    public void cancelTask(String str) {
        CodecStrategyAdapter codecStrategyAdapter;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mInnerDataLoader != null && this.mState == 0) {
            this.mLock.lock(ABLock.TYPE_READ);
            try {
                DataLoaderTaskItem popItem = this.mPreloadTasks.popItem(str);
                if (popItem != null) {
                    _notifyPreloadCancel(popItem);
                } else {
                    DataLoaderTaskItem popItem2 = this.mExecuteTasks.popItem(str);
                    if (popItem2 != null) {
                        VideoInfoFetcher videoInfoFetcher = popItem2.mFetcher;
                        if (videoInfoFetcher != null) {
                            videoInfoFetcher.cancel();
                        }
                        PreloaderURLItem preloaderURLItem = popItem2.mURLItem;
                        if (preloaderURLItem != null && (codecStrategyAdapter = preloaderURLItem.mAdapter) != null && codecStrategyAdapter.isFetchSmartUrl()) {
                            popItem2.mURLItem.mAdapter.cancelFetchSmartUrlInfo();
                        }
                        _notifyPreloadCancel(popItem2);
                    } else {
                        DataLoaderTaskItem popItem3 = this.mAllPreloadTasks.popItem(str);
                        if (popItem3 != null) {
                            this.mInnerDataLoader.cancel(str);
                            _notifyPreloadCancel(popItem3);
                        }
                    }
                }
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                    TTVideoEngineLog.i("DataLoaderHelper", "[preload] cancel preload task. key = " + str);
                }
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        TTVideoEngineLog.e("DataLoaderHelper", "need start mdl first");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int getIntValue(int i) {
        int i2;
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            switch (i) {
                case 1:
                    i2 = this.mConfigure.mMaxCacheSize;
                    return i2;
                case 7:
                    i2 = this.mConfigure.mEnableExternDNS;
                    return i2;
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    i2 = this.mConfigure.mEnableSocketReuse;
                    return i2;
                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                    i2 = this.mMdlPreloadStrategy;
                    return i2;
                case 90:
                    i2 = this.mConfigure.mDNSMainType;
                    return i2;
                case 100:
                    i2 = this.mConfigure.mMaxTlsVersion;
                    return i2;
                case 101:
                    i2 = this.mConfigure.mEnableSessionReuse;
                    return i2;
                case 103:
                    i2 = AVMDLDNSParser.getIntValue(4);
                    return i2;
                case 105:
                    i2 = AVMDLDNSParser.getIntValue(6);
                    return i2;
                case 114:
                    i2 = this.mEnablePreParseHost;
                    return i2;
                case 115:
                    i2 = this.mEnableBackupIP;
                    return i2;
                case 1001:
                    i2 = this.mConfigure.mEnablePreconnect;
                    return i2;
                case 1008:
                    i2 = this.mCurrentAccessType;
                    return i2;
                case 1150:
                    i2 = this.mConfigure.mEnableIOManager;
                    return i2;
                case 9009:
                    i2 = this.mSupportHls;
                    return i2;
                case 9016:
                    i2 = this.mEnableHLSProxy;
                    return i2;
                case 9018:
                    i2 = this.mEnableNotifyError;
                    return i2;
                case 9019:
                    i2 = this.mEnableNotOnlyNotifyNetError;
                    return i2;
                case 9021:
                    i2 = this.mEnablePreloadFirstTs;
                    return i2;
                case 9023:
                    i2 = this.mEnablePreloadAllTs;
                    return i2;
                case 80001:
                    i2 = this.mEnableCheckHLSProxyVVCtrl;
                    return i2;
                default:
                    i2 = -1;
                    return i2;
            }
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    private void _startFetchVideoInfo(DataLoaderTaskItem dataLoaderTaskItem) {
        String str;
        String str2;
        VideoModelCache.VideoModelCacheInfo videoModelCacheInfo;
        IVideoInfo selectBitrate;
        PreloaderVidItemListener preloaderVidItemListener;
        dataLoaderTaskItem.removeVidPlaceholderTrack();
        HashMap hashMap = new HashMap();
        PreloaderVidItem preloaderVidItem = dataLoaderTaskItem.mVidItem;
        if (preloaderVidItem != null && preloaderVidItem.mCodecType.equals("bytevc2")) {
            hashMap.put("codec_type", "4");
        } else {
            PreloaderVidItem preloaderVidItem2 = dataLoaderTaskItem.mVidItem;
            if (preloaderVidItem2 != null && preloaderVidItem2.mCodecType.equals("bytevc1")) {
                hashMap.put("codec_type", "3");
            }
        }
        PreloaderVidItem preloaderVidItem3 = dataLoaderTaskItem.mVidItem;
        if (preloaderVidItem3 != null && preloaderVidItem3.mDashEnable) {
            hashMap.put("format_type", "dash");
        }
        PreloaderVidItem preloaderVidItem4 = dataLoaderTaskItem.mVidItem;
        if (preloaderVidItem4 != null && preloaderVidItem4.mHttpsEnable) {
            hashMap.put("ssl", "1");
        }
        PreloaderVidItem preloaderVidItem5 = dataLoaderTaskItem.mVidItem;
        String str3 = null;
        if (preloaderVidItem5 != null && (preloaderVidItemListener = preloaderVidItem5.mListener) != null) {
            str = preloaderVidItemListener.apiString(hashMap, dataLoaderTaskItem.mVideoId, preloaderVidItem5.mApiVersion);
            PreloaderVidItem preloaderVidItem6 = dataLoaderTaskItem.mVidItem;
            str2 = preloaderVidItem6.mListener.authString(dataLoaderTaskItem.mVideoId, preloaderVidItem6.mApiVersion);
            if (dataLoaderTaskItem.mVidItem.mBoeEnable) {
                str = TTHelper.buildBoeUrl(str);
            }
            dataLoaderTaskItem.mApiString = str;
        } else {
            str = null;
            str2 = null;
        }
        if (this.mListener != null && TextUtils.isEmpty(dataLoaderTaskItem.mApiString)) {
            String apiStringForFetchVideoModel = this.mListener.apiStringForFetchVideoModel(hashMap, dataLoaderTaskItem.mVideoId, dataLoaderTaskItem.mSetResolution);
            str2 = this.mListener.authStringForFetchVideoModel(dataLoaderTaskItem.mVideoId, dataLoaderTaskItem.mSetResolution);
            if (dataLoaderTaskItem.mVidItem.mBoeEnable) {
                apiStringForFetchVideoModel = TTHelper.buildBoeUrl(apiStringForFetchVideoModel);
            }
            str = apiStringForFetchVideoModel;
            dataLoaderTaskItem.mApiString = TTVideoEngineUtils.BuildHttpsApi(str);
        }
        int lastPortraitResult = PortraitNetworkScore.getInstance().getLastPortraitResult();
        if (lastPortraitResult != -1) {
            str = str + String.format("&%s=%s", "network_score", Integer.valueOf(lastPortraitResult));
            dataLoaderTaskItem.mApiString = TTVideoEngineUtils.BuildHttpsApi(str);
        }
        String BuildHttpsApi = TTVideoEngineUtils.BuildHttpsApi(str);
        synchronized (PreloaderVidItem.class) {
            videoModelCacheInfo = this.mModelCache.get(dataLoaderTaskItem.mVideoId, BuildHttpsApi);
        }
        if (videoModelCacheInfo != null && !videoModelCacheInfo.isExpired) {
            dataLoaderTaskItem.mResponseData = videoModelCacheInfo.model;
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i("DataLoaderHelper", String.format("[preload] get videoModel , videoId = %s", dataLoaderTaskItem.mVideoId));
            }
            PreloaderVidItem preloaderVidItem7 = dataLoaderTaskItem.mVidItem;
            if (preloaderVidItem7 != null && preloaderVidItem7.mGearStrategyEnabled == 3 && preloaderVidItem7.mResolution == Resolution.Auto && (selectBitrate = GearStrategySC.selectBitrate(videoModelCacheInfo.model, 2, preloaderVidItem7.mGearStrategyExtraParams, null)) != null) {
                dataLoaderTaskItem.mVidItem.mResolution = selectBitrate.getResolution();
                dataLoaderTaskItem.mSetResolution = dataLoaderTaskItem.mVidItem.mResolution;
            }
            if (this.mEnableVideoModelHitCacheCallback == 1) {
                if (dataLoaderTaskItem.mResponseData != null && dataLoaderTaskItem.getCallBackListener() != null) {
                    PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(4);
                    preLoaderItemCallBackInfo.fetchVideoModel = (VideoModel) dataLoaderTaskItem.mResponseData;
                    dataLoaderTaskItem.getCallBackListener().preloadItemInfo(preLoaderItemCallBackInfo);
                    PreloaderVidItem preloaderVidItem8 = dataLoaderTaskItem.mVidItem;
                    if (preloaderVidItem8 != null) {
                        dataLoaderTaskItem.mSetResolution = preloaderVidItem8.mResolution;
                    }
                }
                PreloaderVidItem preloaderVidItem9 = dataLoaderTaskItem.mVidItem;
                if (preloaderVidItem9 != null && preloaderVidItem9.getFetchEndListener() != null) {
                    dataLoaderTaskItem.mVidItem.getFetchEndListener().fetchEnd((VideoModel) dataLoaderTaskItem.mResponseData, dataLoaderTaskItem.mResponseError);
                    dataLoaderTaskItem.mSetResolution = dataLoaderTaskItem.mVidItem.mResolution;
                }
            }
            _exectTask(dataLoaderTaskItem);
            return;
        }
        if (dataLoaderTaskItem.mVidItem != null) {
            dataLoaderTaskItem.mFetcher = new VideoInfoFetcher(this.mContext, dataLoaderTaskItem.mVidItem.getNetClient());
            dataLoaderTaskItem.setFetchListener();
            dataLoaderTaskItem.mFetcher.setResolutionMap(dataLoaderTaskItem.mVidItem.mResolutionMap);
            dataLoaderTaskItem.mFetcher.setVideoID(dataLoaderTaskItem.mVidItem.mVideoId);
            dataLoaderTaskItem.mFetcher.setUseVideoModelCache(true);
            VideoInfoFetcher videoInfoFetcher = dataLoaderTaskItem.mFetcher;
            int i = dataLoaderTaskItem.mVidItem.mApiVersion;
            if (i != 2 && i != 4) {
                str3 = str2;
            }
            videoInfoFetcher.fetchInfo(BuildHttpsApi, str3, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0128 A[LOOP:6: B:86:0x0128->B:88:0x012e, LOOP_START, PHI: r1
  0x0128: PHI (r1v3 int) = (r1v1 int), (r1v4 int) binds: [B:85:0x0126, B:88:0x012e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x013a A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void cancelTaskByVideoId(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.DataLoaderHelper.cancelTaskByVideoId(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x021b A[EDGE_INSN: B:116:0x021b->B:117:0x021b BREAK  A[LOOP:2: B:97:0x01d2->B:121:0x01d2], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01d2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void addTask(com.ss.ttvideoengine.PreloaderVideoModelItem r18) {
        /*
            Method dump skipped, instructions count: 670
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.DataLoaderHelper.addTask(com.ss.ttvideoengine.PreloaderVideoModelItem):void");
    }

    public void onNotify(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo) {
        int i;
        String str;
        TestSpeedListener testSpeedListener;
        String str2;
        DataLoaderTaskItem itemForKey;
        String str3;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (aVMDLDataLoaderNotifyInfo == null) {
            return;
        }
        JSONObject jSONObject3 = aVMDLDataLoaderNotifyInfo.jsonLog;
        if (jSONObject3 != null) {
            try {
                if (!jSONObject3.has("app_session_id")) {
                    aVMDLDataLoaderNotifyInfo.jsonLog.put("app_session_id", VideoEventBase.appSessionId);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        int i2 = aVMDLDataLoaderNotifyInfo.what;
        boolean z = true;
        if (i2 != 10) {
            if (i2 != 11) {
                if (i2 != 24) {
                    if (i2 != 50) {
                        if (i2 != 70) {
                            if (i2 != 700) {
                                if (i2 != 702) {
                                    if (i2 != 703) {
                                        if (i2 != 901) {
                                            if (i2 != 902) {
                                                switch (i2) {
                                                    case 0:
                                                        VideoEventEngineUploader videoEventEngineUploader = this.mEngineUploader;
                                                        if (videoEventEngineUploader != null) {
                                                            videoEventEngineUploader.onEvent(aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
                                                            return;
                                                        }
                                                        DataLoaderListenerWrapper dataLoaderListenerWrapper = this.mListener;
                                                        if (dataLoaderListenerWrapper != null) {
                                                            dataLoaderListenerWrapper.onLogInfo(0, aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
                                                        }
                                                        if (this.mUploader != null && this.mReportLogEnable) {
                                                            this.mUploader.onUplaod(aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
                                                            return;
                                                        }
                                                        return;
                                                    case 1:
                                                        VideoEventEngineUploader videoEventEngineUploader2 = this.mEngineUploader;
                                                        if (videoEventEngineUploader2 != null) {
                                                            videoEventEngineUploader2.onEvent(aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
                                                            return;
                                                        }
                                                        DataLoaderListenerWrapper dataLoaderListenerWrapper2 = this.mListener;
                                                        if (dataLoaderListenerWrapper2 != null) {
                                                            dataLoaderListenerWrapper2.onLogInfo(1, aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
                                                        }
                                                        if (this.mUploader != null && this.mReportLogEnable) {
                                                            this.mUploader.onUplaod(aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
                                                            return;
                                                        }
                                                        return;
                                                    case 2:
                                                        StrategyHelper.helper().speedInfoUpdate();
                                                        if (!FeatureManager.hasPermission("net_speed")) {
                                                            return;
                                                        }
                                                        DataLoaderListenerWrapper dataLoaderListenerWrapper3 = this.mListener;
                                                        if (dataLoaderListenerWrapper3 != null) {
                                                            dataLoaderListenerWrapper3.onNotify(2, aVMDLDataLoaderNotifyInfo.code, aVMDLDataLoaderNotifyInfo.parameter, aVMDLDataLoaderNotifyInfo.logInfo);
                                                        }
                                                        reportSpeed(aVMDLDataLoaderNotifyInfo);
                                                        return;
                                                    case 3:
                                                    case 4:
                                                        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                                            TTVideoEngineLog.d("DataLoaderHelper", "KeyIsFileCacheProgress log = " + aVMDLDataLoaderNotifyInfo.logInfo + ", task type = " + aVMDLDataLoaderNotifyInfo.parameter + " code = " + ((int) aVMDLDataLoaderNotifyInfo.code));
                                                        }
                                                        if (aVMDLDataLoaderNotifyInfo.logInfo != null) {
                                                            long j = aVMDLDataLoaderNotifyInfo.parameter;
                                                            if (j == 3) {
                                                                Downloader.getInstance().progress(aVMDLDataLoaderNotifyInfo.logInfo);
                                                                return;
                                                            }
                                                            if (j != 2) {
                                                                z = false;
                                                            }
                                                            _progressInfoString(aVMDLDataLoaderNotifyInfo, z);
                                                            return;
                                                        }
                                                        return;
                                                    case 5:
                                                        DataLoaderListenerWrapper dataLoaderListenerWrapper4 = this.mListener;
                                                        if (dataLoaderListenerWrapper4 != null) {
                                                            dataLoaderListenerWrapper4.onNotify(20, aVMDLDataLoaderNotifyInfo.code, aVMDLDataLoaderNotifyInfo.parameter, aVMDLDataLoaderNotifyInfo.logInfo);
                                                            return;
                                                        }
                                                        return;
                                                    case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                                                        try {
                                                            JSONObject process = DataLoaderCDNLog.process(aVMDLDataLoaderNotifyInfo.jsonLog);
                                                            if (process != null) {
                                                                DataLoaderListenerWrapper dataLoaderListenerWrapper5 = this.mListener;
                                                                if (dataLoaderListenerWrapper5 != null) {
                                                                    dataLoaderListenerWrapper5.onNotifyCDNLog(process);
                                                                }
                                                                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                                                    TTVideoEngineLog.d("avmdlcdnlog", "receive log:" + process);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        } catch (Exception e2) {
                                                            e2.printStackTrace();
                                                            return;
                                                        }
                                                    case 7:
                                                        return;
                                                    case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                                                        break;
                                                    default:
                                                        switch (i2) {
                                                            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                                                                DataLoaderListenerWrapper dataLoaderListenerWrapper6 = this.mListener;
                                                                if (dataLoaderListenerWrapper6 != null && (jSONObject = aVMDLDataLoaderNotifyInfo.jsonLog) != null) {
                                                                    dataLoaderListenerWrapper6.onLogInfo(0, aVMDLDataLoaderNotifyInfo.logType, jSONObject);
                                                                    return;
                                                                }
                                                                return;
                                                            case 14:
                                                                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                                                                    TTVideoEngineLog.i("DataLoaderHelper", "MDL Alog: " + aVMDLDataLoaderNotifyInfo.logInfo);
                                                                    return;
                                                                }
                                                                return;
                                                            case 15:
                                                                VideoEventEngineUploader videoEventEngineUploader3 = this.mEngineUploader;
                                                                if (videoEventEngineUploader3 != null) {
                                                                    videoEventEngineUploader3.onEvent(aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
                                                                    return;
                                                                }
                                                                DataLoaderListenerWrapper dataLoaderListenerWrapper7 = this.mListener;
                                                                if (dataLoaderListenerWrapper7 != null && (jSONObject2 = aVMDLDataLoaderNotifyInfo.jsonLog) != null) {
                                                                    dataLoaderListenerWrapper7.onLogInfoToMonitor(6, aVMDLDataLoaderNotifyInfo.logType, jSONObject2);
                                                                    return;
                                                                }
                                                                return;
                                                            case 16:
                                                                DataLoaderListenerWrapper dataLoaderListenerWrapper8 = this.mListener;
                                                                if (dataLoaderListenerWrapper8 != null) {
                                                                    dataLoaderListenerWrapper8.onLogInfo(0, aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
                                                                    return;
                                                                }
                                                                return;
                                                            default:
                                                                switch (i2) {
                                                                    case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                                                                        VideoEventEngineUploader videoEventEngineUploader4 = this.mEngineUploader;
                                                                        if (videoEventEngineUploader4 != null) {
                                                                            videoEventEngineUploader4.onEvent(aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
                                                                            break;
                                                                        } else {
                                                                            DataLoaderListenerWrapper dataLoaderListenerWrapper9 = this.mListener;
                                                                            if (dataLoaderListenerWrapper9 != null) {
                                                                                dataLoaderListenerWrapper9.onLogInfo(7, aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                                                                        break;
                                                                    case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                                                                        if (aVMDLDataLoaderNotifyInfo.logInfo != null) {
                                                                            Downloader.getInstance().progress(aVMDLDataLoaderNotifyInfo.logInfo);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                                                                        String str4 = aVMDLDataLoaderNotifyInfo.logInfo;
                                                                        if (str4 != null) {
                                                                            Downloader.getInstance().downloadDidSuspened(str4);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    default:
                                                                        switch (i2) {
                                                                            case 1000:
                                                                            case 1001:
                                                                            case 1002:
                                                                            case 1003:
                                                                            case 1005:
                                                                                VideoEventEngineUploader videoEventEngineUploader5 = this.mEngineUploader;
                                                                                if (videoEventEngineUploader5 != null) {
                                                                                    videoEventEngineUploader5.onEvent(aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
                                                                                    break;
                                                                                } else {
                                                                                    DataLoaderListenerWrapper dataLoaderListenerWrapper10 = this.mListener;
                                                                                    if (dataLoaderListenerWrapper10 != null) {
                                                                                        dataLoaderListenerWrapper10.onLogInfo(10, aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
                                                                                    }
                                                                                    if (this.mUploader != null && this.mReportLogEnable) {
                                                                                        this.mUploader.onUplaod(aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 1004:
                                                                                VideoEventEngineUploader videoEventEngineUploader6 = this.mEngineUploader;
                                                                                if (videoEventEngineUploader6 != null) {
                                                                                    videoEventEngineUploader6.onEventV2("videoplayer_mdl_sample", aVMDLDataLoaderNotifyInfo.jsonLog);
                                                                                    break;
                                                                                }
                                                                                break;
                                                                            default:
                                                                                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                                                                    TTVideoEngineLog.d("DataLoaderHelper", "NOT DEAL notify info what =  " + aVMDLDataLoaderNotifyInfo.what);
                                                                                    break;
                                                                                }
                                                                                break;
                                                                        }
                                                                }
                                                                return;
                                                        }
                                                }
                                                String str5 = aVMDLDataLoaderNotifyInfo.logInfo;
                                                if (str5 != null && aVMDLDataLoaderNotifyInfo.parameter == 3) {
                                                    Downloader.getInstance().downloadFail(str5, _errorWithCode((int) aVMDLDataLoaderNotifyInfo.code, aVMDLDataLoaderNotifyInfo.parameter, str5));
                                                    return;
                                                }
                                                if (str5 != null) {
                                                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                                                        TTVideoEngineLog.i("DataLoaderHelper", " task fail log = " + aVMDLDataLoaderNotifyInfo.logInfo + ", code = " + aVMDLDataLoaderNotifyInfo.code + ", task type = " + aVMDLDataLoaderNotifyInfo.parameter);
                                                    }
                                                    String[] split = aVMDLDataLoaderNotifyInfo.logInfo.split(",");
                                                    if (split.length < 1 || (itemForKey = this.mAllPreloadTasks.itemForKey((str2 = split[0]))) == null) {
                                                        return;
                                                    }
                                                    DataLoaderTaskQueue dataLoaderTaskQueue = this.mAllPreloadTasks;
                                                    Error error = new Error("kTTVideoErrorDomainDataLoaderPreload", (int) aVMDLDataLoaderNotifyInfo.code, aVMDLDataLoaderNotifyInfo.logInfo);
                                                    if (TextUtils.isEmpty(itemForKey.mVideoId)) {
                                                        str3 = str2;
                                                    } else {
                                                        str3 = itemForKey.mVideoId;
                                                    }
                                                    DataLoaderTaskLoadProgress loadProgressByRawKey = PreloadLoadProgressCenter.center().getLoadProgressByRawKey(str3);
                                                    if (loadProgressByRawKey == null) {
                                                        loadProgressByRawKey = new DataLoaderTaskLoadProgress();
                                                    }
                                                    loadProgressByRawKey.mVideoId = itemForKey.mVideoId;
                                                    loadProgressByRawKey.mTaskType = (int) aVMDLDataLoaderNotifyInfo.parameter;
                                                    loadProgressByRawKey.setUp(itemForKey);
                                                    loadProgressByRawKey.onError(str2, error);
                                                    DataLoaderListenerWrapper dataLoaderListenerWrapper11 = this.mListener;
                                                    if (dataLoaderListenerWrapper11 != null) {
                                                        dataLoaderListenerWrapper11.onLoadProgress(loadProgressByRawKey);
                                                    }
                                                    PreloadLoadProgressCenter.center().putByRawKey(str3, loadProgressByRawKey);
                                                    if (loadProgressByRawKey.isCacheEnd() || loadProgressByRawKey.isPreloadComplete()) {
                                                        dataLoaderTaskQueue.popItem(str2);
                                                        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                                                            TTVideoEngineLog.i("DataLoaderHelper", "pop all task item. videoId = " + itemForKey.mVideoId + " key = " + str2);
                                                        }
                                                        PreloadLoadProgressCenter.center().removeLoadProgressByRawKey(str3);
                                                        if (this.mListener != null) {
                                                            DataLoaderTaskProgressInfo dataLoaderTaskProgressInfo = new DataLoaderTaskProgressInfo();
                                                            dataLoaderTaskProgressInfo.mTaskType = (int) aVMDLDataLoaderNotifyInfo.parameter;
                                                            dataLoaderTaskProgressInfo.mVideoId = itemForKey.mVideoId;
                                                            dataLoaderTaskProgressInfo.mKey = str2;
                                                            PreloaderURLItem preloaderURLItem = itemForKey.mURLItem;
                                                            if (preloaderURLItem != null && preloaderURLItem.getFilePath() != null) {
                                                                dataLoaderTaskProgressInfo.mLocalFilePath = itemForKey.mURLItem.getFilePath();
                                                                dataLoaderTaskProgressInfo.mKey = null;
                                                            }
                                                            this.mListener.onTaskProgress(dataLoaderTaskProgressInfo);
                                                        }
                                                        if (itemForKey.getCallBackListener() != null && aVMDLDataLoaderNotifyInfo.parameter == 2) {
                                                            PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(3);
                                                            preLoaderItemCallBackInfo.preloadError = error;
                                                            preLoaderItemCallBackInfo.loadProgress = loadProgressByRawKey;
                                                            preLoaderItemCallBackInfo.preloadDataInfo = null;
                                                            itemForKey.getCallBackListener().preloadItemInfo(preLoaderItemCallBackInfo);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                                TTVideoEngineLog.d("DataLoaderHelper", "KeyIsFileDeleteSizeByUsedTime size: " + aVMDLDataLoaderNotifyInfo.code);
                                            }
                                            DataLoaderListenerWrapper dataLoaderListenerWrapper12 = this.mListener;
                                            if (dataLoaderListenerWrapper12 != null) {
                                                dataLoaderListenerWrapper12.onNotify(31, 0L, aVMDLDataLoaderNotifyInfo.code, null);
                                                return;
                                            }
                                            return;
                                        }
                                        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                            TTVideoEngineLog.d("multinetwork", String.format("target network:%d current network:%d", Long.valueOf(aVMDLDataLoaderNotifyInfo.parameter), Long.valueOf(aVMDLDataLoaderNotifyInfo.code)));
                                        }
                                        String networkName = getNetworkName(aVMDLDataLoaderNotifyInfo.parameter);
                                        String networkName2 = getNetworkName(aVMDLDataLoaderNotifyInfo.code);
                                        if (!TextUtils.isEmpty(networkName) && !TextUtils.isEmpty(networkName2) && this.mListener != null) {
                                            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                                TTVideoEngineLog.d("multinetwork", "do callback target: " + networkName + " current: " + networkName2);
                                            }
                                            this.mListener.onMultiNetworkSwitch(networkName, networkName2);
                                            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                                TTVideoEngineLog.d("multinetwork", "end do callback target: " + networkName + " current: " + networkName2);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                if (FeatureManager.hasPermission("net_speed") && (testSpeedListener = this.mTestSpeedListener) != null && testSpeedListener != null) {
                                    testSpeedListener.onNotify(2, aVMDLDataLoaderNotifyInfo.logInfo);
                                    return;
                                }
                                return;
                            }
                            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                TTVideoEngineLog.d("DataLoaderHelper", "KeyIsSpeedTestSampledByTime  mNeedSpeedTestByTimeInternal:" + this.mNeedSpeedTestByTimeInternal + " code:" + aVMDLDataLoaderNotifyInfo.code);
                            }
                            if (!FeatureManager.hasPermission("net_speed")) {
                                return;
                            }
                            TestSpeedListener testSpeedListener2 = this.mTestSpeedListener;
                            if (testSpeedListener2 != null) {
                                testSpeedListener2.onNotify(2, aVMDLDataLoaderNotifyInfo.code, aVMDLDataLoaderNotifyInfo.parameter, aVMDLDataLoaderNotifyInfo.logInfo, aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.logExtraJsonStr);
                            }
                            int i3 = this.mNeedSpeedTestByTimeInternal;
                            if (i3 != 1) {
                                if (i3 != 2) {
                                    i = -1;
                                } else {
                                    i = 32;
                                }
                            } else {
                                i = 2;
                            }
                            if (this.mListener != null && i != -1) {
                                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("KeyIsSpeedTestSampledByTimenotify by");
                                    if (i == 2) {
                                        str = "general";
                                    } else {
                                        str = "timeinternal";
                                    }
                                    sb.append(str);
                                    sb.append("speed info code:");
                                    sb.append(aVMDLDataLoaderNotifyInfo.code);
                                    sb.append(" parameter:");
                                    sb.append(aVMDLDataLoaderNotifyInfo.parameter);
                                    TTVideoEngineLog.d("DataLoaderHelper", sb.toString());
                                }
                                this.mListener.onNotify(i, aVMDLDataLoaderNotifyInfo.code, aVMDLDataLoaderNotifyInfo.parameter, aVMDLDataLoaderNotifyInfo.logInfo);
                                return;
                            }
                            return;
                        }
                        JSONObject _onHeartBeatFire = _onHeartBeatFire(aVMDLDataLoaderNotifyInfo.jsonLog);
                        aVMDLDataLoaderNotifyInfo.jsonLog = _onHeartBeatFire;
                        VideoEventEngineUploader videoEventEngineUploader7 = this.mEngineUploader;
                        if (videoEventEngineUploader7 != null) {
                            videoEventEngineUploader7.onEvent(aVMDLDataLoaderNotifyInfo.logType, _onHeartBeatFire);
                            return;
                        }
                        DataLoaderListenerWrapper dataLoaderListenerWrapper13 = this.mListener;
                        if (dataLoaderListenerWrapper13 != null) {
                            dataLoaderListenerWrapper13.onLogInfo(3, aVMDLDataLoaderNotifyInfo.logType, _onHeartBeatFire);
                        }
                        if (this.mUploader != null && this.mReportLogEnable) {
                            this.mUploader.onUplaod(aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
                        }
                        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                            TTVideoEngineLog.d("DataLoaderHelper", "heart beat msg: " + aVMDLDataLoaderNotifyInfo.logInfo);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d("DataLoaderHelper", "KeyIsTaskOpen " + aVMDLDataLoaderNotifyInfo.logInfo);
                }
                notifyUrlChange(aVMDLDataLoaderNotifyInfo.logInfo);
                DataLoaderListenerWrapper dataLoaderListenerWrapper14 = this.mListener;
                if (dataLoaderListenerWrapper14 != null) {
                    dataLoaderListenerWrapper14.onNotify(30, 0L, aVMDLDataLoaderNotifyInfo.parameter, aVMDLDataLoaderNotifyInfo.logInfo);
                    return;
                }
                return;
            }
            VideoEventEngineUploader videoEventEngineUploader8 = this.mEngineUploader;
            if (videoEventEngineUploader8 != null) {
                videoEventEngineUploader8.onEvent(aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
                return;
            }
            DataLoaderListenerWrapper dataLoaderListenerWrapper15 = this.mListener;
            if (dataLoaderListenerWrapper15 != null) {
                dataLoaderListenerWrapper15.onLogInfo(5, aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
                TTVideoEngineLog.d("DataLoaderHelper", "live loader log sample msg: " + aVMDLDataLoaderNotifyInfo.logInfo);
                return;
            }
            return;
        }
        VideoEventEngineUploader videoEventEngineUploader9 = this.mEngineUploader;
        if (videoEventEngineUploader9 != null) {
            videoEventEngineUploader9.onEvent(aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
            return;
        }
        DataLoaderListenerWrapper dataLoaderListenerWrapper16 = this.mListener;
        if (dataLoaderListenerWrapper16 != null) {
            dataLoaderListenerWrapper16.onLogInfo(4, aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d("DataLoaderHelper", "live loader log msg: " + aVMDLDataLoaderNotifyInfo.logInfo);
            }
        }
    }

    public void removeAllPreloadMedia(String str, int i) {
        _ml_removeAllMedias(str, i);
    }

    public void removeMedia(String str, String str2) {
        _ml_removeMedia(str, str2);
    }

    class MyPreloadTaskCallbackListener implements IPreloadTaskCallbackListener {
        private IPreLoaderItemCallBackListener mCallBackListener;

        static {
            Covode.recordClassIndex(652266);
        }

        MyPreloadTaskCallbackListener(IPreLoaderItemCallBackListener iPreLoaderItemCallBackListener) {
            this.mCallBackListener = iPreLoaderItemCallBackListener;
        }

        public void preloadItemInfo(int i, String str, String str2) {
            int i2;
            String str3;
            if (this.mCallBackListener != null) {
                if (i == 4) {
                    i2 = 3;
                } else {
                    i2 = 5;
                    if (i != 5) {
                        if (i == 2) {
                            i2 = 8;
                        } else if (i == 1) {
                            i2 = 7;
                        } else if (i == 6) {
                            i2 = 9;
                        } else {
                            i2 = 2;
                        }
                    }
                }
                PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(i2);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        preLoaderItemCallBackInfo.businessContext = new JSONObject(str2).optString("businessContext");
                    } catch (JSONException e) {
                        TTVideoEngineLog.d("DataLoaderHelper", "[originPreload] preloadItemInfo, json error:" + e.toString());
                    }
                }
                if (!TextUtils.isEmpty(str) && str.contains(",")) {
                    String[] split = str.split(",");
                    if (split.length >= 3) {
                        long longValue = Long.valueOf(split[0]).longValue();
                        long longValue2 = Long.valueOf(split[1]).longValue();
                        String str4 = split[2];
                        if (split.length >= 4) {
                            str3 = split[3];
                        } else {
                            str3 = "";
                        }
                        DataLoaderTaskProgressInfo dataLoaderTaskProgressInfo = DataLoaderHelper.this.new DataLoaderTaskProgressInfo();
                        preLoaderItemCallBackInfo.preloadDataInfo = dataLoaderTaskProgressInfo;
                        dataLoaderTaskProgressInfo.mKey = str4;
                        dataLoaderTaskProgressInfo.mCacheSizeFromZero = longValue;
                        dataLoaderTaskProgressInfo.mMediaSize = longValue2;
                        dataLoaderTaskProgressInfo.mLocalFilePath = str3;
                    }
                } else if (i2 == 8) {
                    preLoaderItemCallBackInfo.fileHash = str;
                }
                this.mCallBackListener.preloadItemInfo(preLoaderItemCallBackInfo);
            }
        }
    }

    class MySelectBitrateListener implements ISelectBitrateListener {
        private ISelectBitrateCallback mCallback;

        static {
            Covode.recordClassIndex(652267);
        }

        MySelectBitrateListener(ISelectBitrateCallback iSelectBitrateCallback) {
            this.mCallback = iSelectBitrateCallback;
        }

        public String selectBitrateJsonString(String str, int i) {
            Map<String, Integer> selectBitrate;
            ISelectBitrateCallback iSelectBitrateCallback = this.mCallback;
            if (iSelectBitrateCallback != null && (selectBitrate = iSelectBitrateCallback.selectBitrate(i)) != null) {
                return new JSONObject(selectBitrate).toString();
            }
            return null;
        }
    }

    public String generateSubUrlKey(String str, String str2) {
        return AVMDLDataLoader.makeTsFileKey(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _doMl_removeAllMedias(String str, int i) {
        StrategyHelper.helper().getCenter().w(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _doMl_removeMedia(String str, String str2) {
        StrategyHelper.helper().getCenter().x(str, str2);
    }

    public void notifyPreloadCancelled(String str, String str2) {
        DataLoaderListenerWrapper dataLoaderListenerWrapper = this.mListener;
        if (dataLoaderListenerWrapper == null) {
            return;
        }
        dataLoaderListenerWrapper.onNotify(8, 0L, 0L, str);
    }

    public String proxyUrl(String str, String str2) {
        return proxyUrl(str, str, new String[]{str2}, null, null);
    }

    private String[] _addP2pFlag(boolean z, String[] strArr) {
        if (!z) {
            return strArr;
        }
        for (int i = 0; i < strArr.length; i++) {
            if (!TextUtils.isEmpty(strArr[i])) {
                strArr[i] = TTHelper.appendQueryString(strArr[i], "p2p=0");
            }
        }
        return strArr;
    }

    private void _ml_addMedia(PreloadModelMedia preloadModelMedia, String str) {
        if (preloadModelMedia != null) {
            if (this.mediaOperateThread != null) {
                ArrayList<Object> arrayList = new ArrayList<>();
                arrayList.add(this);
                arrayList.add(preloadModelMedia);
                arrayList.add(str);
                this.mediaOperateThread.postMessage(arrayList, TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE);
                return;
            }
            _doMl_addMedia(preloadModelMedia, str);
        }
    }

    private void _ml_removeMedia(String str, String str2) {
        if (this.mediaOperateThread != null) {
            ArrayList<Object> arrayList = new ArrayList<>();
            arrayList.add(this);
            arrayList.add(str);
            arrayList.add(str2);
            this.mediaOperateThread.postMessage(arrayList, 112);
            return;
        }
        _doMl_removeMedia(str, str2);
    }

    public void setBackUpIP(String str, String str2) {
        AVMDLDNSParser.getInstance().setBackUpIP(str, str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mEnableBackupIP = 1;
        }
    }

    private void _ml_removeAllMedias(String str, int i) {
        if (this.mediaOperateThread != null) {
            ArrayList<Object> arrayList = new ArrayList<>();
            arrayList.add(this);
            arrayList.add(str);
            arrayList.add(Integer.valueOf(i));
            this.mediaOperateThread.postMessage(arrayList, 113);
            return;
        }
        _doMl_removeAllMedias(str, i);
    }

    public void cleanCacheDirForExpiredFiles(String str, long j) {
        if (this.mState != 0) {
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            AVMDLDataLoader aVMDLDataLoader = this.mInnerDataLoader;
            if (aVMDLDataLoader != null) {
                aVMDLDataLoader.cleanCacheDirForExpiredFiles(str, j);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public void cleanSpecifiedCacheDir(String str, int i) {
        AVMDLDataLoader aVMDLDataLoader;
        if (this.mState != 0) {
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            aVMDLDataLoader = this.mInnerDataLoader;
        } finally {
            try {
            } finally {
            }
        }
        if (aVMDLDataLoader == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "mInnerDataLoader == null");
        } else {
            aVMDLDataLoader.cleanSpecifiedCacheDir(str, i);
        }
    }

    public void focusMedia(String str, int i) {
        if (this.mediaOperateThread != null) {
            ArrayList<Object> arrayList = new ArrayList<>();
            arrayList.add(this);
            arrayList.add(str);
            arrayList.add(Integer.valueOf(i));
            this.mediaOperateThread.postMessage(arrayList, 114);
            return;
        }
        StrategyHelper.helper().getCenter().m(str, i);
    }

    public void setCacheInfoLists(String[] strArr, long[] jArr) {
        TTVideoEngineLog.d("DataLoaderHelper", "setcustom paths and maxcaches ");
        this.mLock.lock(ABLock.TYPE_WRITE);
        try {
            this.mConfigure.setCacheInfoList(strArr, jArr);
        } finally {
            this.mLock.unlock(ABLock.TYPE_WRITE);
        }
    }

    public long tryToClearAndGetCachesByUsedTime(long j, boolean z) {
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            AVMDLDataLoader aVMDLDataLoader = this.mInnerDataLoader;
            if (aVMDLDataLoader == null) {
                this.mLock.unlock(ABLock.TYPE_READ);
                return -1L;
            }
            return aVMDLDataLoader.tryToClearAndGetCachesByUsedTime(j, z);
        } catch (Throwable th) {
            try {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(th);
                }
                this.mLock.unlock(ABLock.TYPE_READ);
                return 0L;
            } finally {
                this.mLock.unlock(ABLock.TYPE_READ);
            }
        }
    }

    private void _cacheEndNotifyEngine(DataLoaderTaskItem dataLoaderTaskItem, String str) {
        boolean z;
        ArrayList<DataLoaderTaskItem> array = this.mAllPlayTasks.toArray();
        int i = 0;
        while (true) {
            if (i < array.size()) {
                DataLoaderTaskItem dataLoaderTaskItem2 = array.get(i);
                if (!TextUtils.isEmpty(dataLoaderTaskItem2.mVideoId) && !TextUtils.isEmpty(dataLoaderTaskItem.mVideoId) && dataLoaderTaskItem2.mVideoId.equals(dataLoaderTaskItem.mVideoId)) {
                    z = false;
                    break;
                }
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            this.mLock.lock(ABLock.TYPE_VOID);
            this.mPreloadUtil.notifyCacheEnd(dataLoaderTaskItem.mVideoId);
            this.mLock.unlock(ABLock.TYPE_VOID);
            ArrayList<WeakReference<TTVideoEngine>> _getEnginesByRawKey = _getEnginesByRawKey(dataLoaderTaskItem.mVideoId);
            if (_getEnginesByRawKey != null && _getEnginesByRawKey.size() != 0) {
                for (int i2 = 0; i2 < _getEnginesByRawKey.size(); i2++) {
                    WeakReference<TTVideoEngine> weakReference = _getEnginesByRawKey.get(i2);
                    if (weakReference.get() != null) {
                        weakReference.get().notifyCacheEnd();
                    }
                }
            }
        }
    }

    private boolean _supportProxy(String str, int i) {
        boolean z;
        boolean z2;
        int i2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("mdl://") || lowerCase.startsWith("http://127.0.0.1") || lowerCase.startsWith("http://localhost") || lowerCase.startsWith("file://") || lowerCase.startsWith("/") || FormatProvider.FormatProviderHolder.isMpd(str)) {
            return false;
        }
        if (this.mEnableHLSProxy == 1 && ((i2 = this.mEnableCheckHLSProxyVVCtrl) == 0 || (i2 == 1 && i == 1))) {
            z = true;
        } else {
            z = false;
        }
        if (this.mEnableHls == 1 && (this.mSupportHls || (z && this.mHLSProxyValid))) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && FormatProvider.FormatProviderHolder.isM3u8(str)) {
            return false;
        }
        return true;
    }

    public void _addEngine(TTVideoEngine tTVideoEngine, String str) {
        if (!TextUtils.isEmpty(str) && tTVideoEngine != null) {
            try {
                this.mEngineLock.lock();
                ArrayList<WeakReference<TTVideoEngine>> arrayList = this.mAllUsingEngies.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.mAllUsingEngies.put(str, arrayList);
                }
                ValueWeakReference valueWeakReference = new ValueWeakReference(tTVideoEngine);
                if (!arrayList.contains(valueWeakReference)) {
                    arrayList.add(valueWeakReference);
                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                        TTVideoEngineLog.i("DataLoaderHelper", "add engine ref,rawKey = " + str + " engine ref count: " + arrayList.size());
                    }
                }
            } finally {
                this.mEngineLock.unlock();
            }
        }
    }

    public void _removeEngine(TTVideoEngine tTVideoEngine, String str) {
        if (!TextUtils.isEmpty(str) && tTVideoEngine != null) {
            try {
                this.mEngineLock.lock();
                ArrayList<WeakReference<TTVideoEngine>> arrayList = this.mAllUsingEngies.get(str);
                if (arrayList != null) {
                    arrayList.remove(new ValueWeakReference(tTVideoEngine));
                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                        TTVideoEngineLog.i("DataLoaderHelper", "remove engine ref,rawKey = " + str + " engine ref count: " + arrayList.size());
                    }
                    if (arrayList.size() == 0) {
                        this.mAllUsingEngies.remove(str);
                        PreloadUtil preloadUtil = this.mPreloadUtil;
                        if (preloadUtil.mPlayBufferLowerBound > 0 && preloadUtil.mPlayBufferUpperBound > 0) {
                            preloadUtil.removePlayInfo(str);
                        }
                    }
                }
            } finally {
                this.mEngineLock.unlock();
            }
        }
    }

    public void addPreloadMedias(List<PreloadMedia> list, String str) {
        if (!FeatureManager.hasPermission("preload") || list == null) {
            return;
        }
        if (str == null) {
            str = PreloadConfig.share().getCurrentSceneId();
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i("DataLoaderHelper", "[preload] add preload  mediaList ,size = " + list.size() + "sceneId = " + str);
        }
        for (int i = 0; i < list.size(); i++) {
            PreloadMedia preloadMedia = list.get(i);
            preloadMedia.mSceneId = str;
            if (preloadMedia instanceof PreloadURLMedia) {
                addPreloadUrlMedia((PreloadURLMedia) preloadMedia);
            } else if (preloadMedia instanceof PreloadModelMedia) {
                if (i == list.size() - 1) {
                    ((PreloadModelMedia) preloadMedia).isLast = true;
                }
                addPreloadModelMedia((PreloadModelMedia) preloadMedia);
            }
        }
    }

    public DataLoaderCacheInfo getOfflineCacheInfo(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            if (this.mInnerDataLoader != null && this.mState == 0) {
                return _processCacheInfo(this.mInnerDataLoader.getOfflineCacheInfo(str, str2));
            }
        } finally {
            try {
                return null;
            } finally {
            }
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.portrait.PortraitChangeListener
    public void onPortraitChange(String str, Object obj) {
        String str2;
        if (this.mInnerDataLoader == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, obj);
            str2 = jSONObject.toString();
        } catch (JSONException e) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d(e);
            }
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d("DataLoaderHelper", "onPortraitChange enginePortait: " + str2);
            }
            this.mInnerDataLoader.setStringValue(7446, str2);
        }
    }

    public boolean startDownload(String str, boolean z) {
        boolean z2 = false;
        if (!FeatureManager.hasPermission() || this.mState != 0) {
            return false;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            if (this.mInnerDataLoader != null && !TextUtils.isEmpty(str)) {
                this.mInnerDataLoader.downloadResource(str);
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                    TTVideoEngineLog.i("DataLoaderHelper", "[downloader] start download resource = " + str);
                }
                z2 = true;
            }
        } catch (Throwable th) {
            try {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(th);
                }
            } catch (Throwable unused) {
            }
        }
        this.mLock.unlock(ABLock.TYPE_READ);
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void _doMl_addMedia(com.ss.ttvideoengine.preload.PreloadModelMedia r11, java.lang.String r12) {
        /*
            r10 = this;
            if (r11 == 0) goto L88
            com.ss.ttvideoengine.strategrycenter.ISelectBitrateCallback r0 = r11.getSelectCallback()
            r1 = 0
            if (r0 == 0) goto L14
            com.ss.ttvideoengine.DataLoaderHelper$MySelectBitrateListener r0 = new com.ss.ttvideoengine.DataLoaderHelper$MySelectBitrateListener
            com.ss.ttvideoengine.strategrycenter.ISelectBitrateCallback r2 = r11.getSelectCallback()
            r0.<init>(r2)
            r5 = r0
            goto L15
        L14:
            r5 = r1
        L15:
            com.ss.ttvideoengine.IPreLoaderItemCallBackListener r0 = r11.getCallBackListener()
            if (r0 == 0) goto L24
            com.ss.ttvideoengine.DataLoaderHelper$MyPreloadTaskCallbackListener r1 = new com.ss.ttvideoengine.DataLoaderHelper$MyPreloadTaskCallbackListener
            com.ss.ttvideoengine.IPreLoaderItemCallBackListener r0 = r11.getCallBackListener()
            r1.<init>(r0)
        L24:
            r6 = r1
            com.ss.ttvideoengine.model.IVideoModel r0 = r11.mVideoModel
            java.lang.String r0 = r0.toMediaInfoJsonString()
            boolean r1 = r11.isNeedConvertStrategyInfo()
            if (r1 == 0) goto L3d
            java.lang.String r1 = r11.toStrategyInfo()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L3d
            r4 = r1
            goto L3e
        L3d:
            r4 = r0
        L3e:
            int r0 = r10.mEnableCheckPreloadUrls
            r1 = 1
            if (r0 != r1) goto L79
            com.ss.ttvideoengine.model.IVideoModel r0 = r11.mVideoModel
            if (r0 == 0) goto L79
            java.util.List r0 = r0.getVideoInfoList()
            if (r0 == 0) goto L79
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L79
            java.util.Iterator r0 = r0.iterator()
        L57:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L79
            java.lang.Object r1 = r0.next()
            com.ss.ttvideoengine.model.VideoInfo r1 = (com.ss.ttvideoengine.model.VideoInfo) r1
            r2 = 16
            java.lang.String[] r1 = r1.getValueStrArr(r2)
            int r2 = r1.length
            r3 = 0
        L6b:
            if (r3 >= r2) goto L57
            r7 = r1[r3]
            boolean r7 = r10._supportProxy(r7)
            if (r7 != 0) goto L76
            return
        L76:
            int r3 = r3 + 1
            goto L6b
        L79:
            com.ss.ttvideoengine.strategrycenter.StrategyHelper r0 = com.ss.ttvideoengine.strategrycenter.StrategyHelper.helper()
            com.bytedance.vcloud.strategy.StrategyCenter r3 = r0.getCenter()
            boolean r8 = r11.isLast
            r9 = 0
            r7 = r12
            r3.a(r4, r5, r6, r7, r8, r9)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.DataLoaderHelper._doMl_addMedia(com.ss.ttvideoengine.preload.PreloadModelMedia, java.lang.String):void");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0078 -> B:18:0x0084). Please report as a decompilation issue!!! */
    public void setIntValueSync(int i, int i2) {
        this.mLock.lock(ABLock.TYPE_READ);
        if (this.mInnerDataLoader == null) {
            this.mLock.unlock(ABLock.TYPE_READ);
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d("DataLoaderHelper", "setIntValueSync failed, key = " + i + ", value = " + i2);
                return;
            }
            return;
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d("DataLoaderHelper", "setIntValueSync key = " + i + ", value = " + i2);
        }
        try {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i != 2103) {
                if (i == 2105 && i2 >= 0) {
                    this.mInnerDataLoader.setIntValue(11005, i2);
                }
            } else if (i2 >= 0) {
                this.mInnerDataLoader.setIntValue(11003, i2);
            }
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    public void setLongValue(int i, long j) {
        int i2;
        this.mLock.lock(ABLock.TYPE_READ);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d("DataLoaderHelper", "setLongValue key = " + i + ", value = " + j);
        }
        try {
            try {
                if (i != 62) {
                    if (i != 1142) {
                        if (i != 1144) {
                            if (i != 80003) {
                                if (i != 1152) {
                                    if (i != 1153) {
                                        switch (i) {
                                            case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                                                i2 = 7210;
                                                break;
                                            case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                                                i2 = 7211;
                                                break;
                                            case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                                                i2 = 7212;
                                                break;
                                            case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                                                i2 = 7213;
                                                break;
                                            case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                                                i2 = 7214;
                                                break;
                                            case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                                                i2 = 7215;
                                                break;
                                            case 28:
                                                i2 = 7338;
                                                break;
                                        }
                                    } else {
                                        this.mConfigure.mMonitorMinAllowLoadSize = j;
                                    }
                                } else {
                                    this.mConfigure.mMonitorTimeInternal = j;
                                }
                            } else {
                                this.mConfigure.mMaxCacheSize64 = j;
                            }
                        } else {
                            this.mConfigure.mConnectPoolStragetyValue = j;
                        }
                    } else {
                        this.mConfigure.mP2PStragetyLevel = j;
                    }
                    i2 = -1;
                } else {
                    i2 = 1100;
                }
                AVMDLDataLoader aVMDLDataLoader = this.mInnerDataLoader;
                if (aVMDLDataLoader != null) {
                    aVMDLDataLoader.setLongValue(i2, j);
                }
            } catch (Exception unused) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                    TTVideoEngineLog.e("DataLoaderHelper", "setLongValue failed, key: " + i + ", value: " + j);
                }
            }
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    public void setStringValueSync(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        if (this.mInnerDataLoader == null) {
            this.mLock.unlock(ABLock.TYPE_READ);
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d("DataLoaderHelper", "setStringValueSync failed, key = " + i + ", value = " + str);
                return;
            }
            return;
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d("DataLoaderHelper", "setStringValueSync key = " + i + ", value = " + str);
        }
        try {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i != 2030) {
                if (i == 2106) {
                    this.mInnerDataLoader.setStringValue(11006, str);
                }
            }
            this.mInnerDataLoader.setStringValue(7437, str);
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    public void updateDnsInfo(JSONObject jSONObject, long j) {
        String next;
        if (jSONObject == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "ip direct info invalid");
            return;
        }
        long j2 = NetUtils.netUpdateTimeMs;
        if (j2 != -1 && 1000 * j < j2) {
            TTVideoEngineLog.e("DataLoaderHelper", "network did change, dnsinfo is invalid");
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            try {
                Iterator<String> keys = jSONObject.keys();
                do {
                    next = keys.next();
                    JSONArray optJSONArray = jSONObject.optJSONArray(next);
                    String str = "";
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        str = str + optJSONArray.optString(i);
                        if (i < optJSONArray.length() - 1) {
                            str = str + ",";
                        }
                    }
                    AVMDLDNSParser.updateDNSInfo(next, str, j);
                    if (!keys.hasNext()) {
                        break;
                    }
                } while (!TextUtils.isEmpty(next));
            } catch (Exception e) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6)) {
                    TTVideoEngineLog.e("DataLoaderHelper", e.toString());
                }
            }
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    private void _prepareUrlInfo(VideoInfo videoInfo, DataLoaderTaskItem dataLoaderTaskItem) {
        boolean z;
        String cacheFilePath;
        if (videoInfo != null && dataLoaderTaskItem != null) {
            String[] valueStrArr = videoInfo.getValueStrArr(16);
            String valueStr = videoInfo.getValueStr(15);
            DataLoaderTaskItem.TrackItem addTrackItemByKey = dataLoaderTaskItem.addTrackItemByKey(valueStr);
            if (valueStrArr != null && valueStrArr.length >= 1) {
                String[] strArr = (String[]) valueStrArr.clone();
                PreloaderVidItem preloaderVidItem = dataLoaderTaskItem.mVidItem;
                if (preloaderVidItem != null) {
                    z = preloaderVidItem.mForbidP2p;
                } else {
                    PreloaderVideoModelItem preloaderVideoModelItem = dataLoaderTaskItem.mVideoModelItem;
                    if (preloaderVideoModelItem != null) {
                        z = preloaderVideoModelItem.mForbidP2p;
                    } else {
                        z = false;
                    }
                }
                String[] _addP2pFlag = _addP2pFlag(z, strArr);
                PreloaderVidItem preloaderVidItem2 = dataLoaderTaskItem.mVidItem;
                String str = null;
                if (preloaderVidItem2 != null && preloaderVidItem2.getFilePathListener() != null && !TextUtils.isEmpty(valueStr)) {
                    cacheFilePath = dataLoaderTaskItem.mVidItem.getFilePathListener().cacheFilePath(dataLoaderTaskItem.mVideoId, videoInfo);
                    if (this.mDisableFilePathCheck == 0) {
                        if (!TextUtils.isEmpty(cacheFilePath) && cacheFilePath.contains(valueStr)) {
                            str = cacheFilePath;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            valueStr = TTHelper.keyFromFilePath(this.mContext, str);
                        }
                    }
                    str = cacheFilePath;
                } else {
                    PreloaderVideoModelItem preloaderVideoModelItem2 = dataLoaderTaskItem.mVideoModelItem;
                    if (preloaderVideoModelItem2 != null && preloaderVideoModelItem2.getFilePathListener() != null && !TextUtils.isEmpty(valueStr)) {
                        cacheFilePath = dataLoaderTaskItem.mVideoModelItem.getFilePathListener().cacheFilePath(dataLoaderTaskItem.mVideoId, videoInfo);
                        if (this.mDisableFilePathCheck == 0) {
                            if (!TextUtils.isEmpty(cacheFilePath) && cacheFilePath.contains(valueStr)) {
                                str = cacheFilePath;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                valueStr = TTHelper.keyFromFilePath(this.mContext, str);
                            }
                        }
                        str = cacheFilePath;
                    }
                }
                if (addTrackItemByKey == null) {
                    addTrackItemByKey = dataLoaderTaskItem.addTrackItemByKey(valueStr);
                }
                if (addTrackItemByKey == null) {
                    dataLoaderTaskItem._notifyError(-100001);
                    return;
                }
                addTrackItemByKey.mTaskKey = valueStr;
                addTrackItemByKey.mVideoInfo = videoInfo;
                addTrackItemByKey.mDecryptionKey = videoInfo.getValueStr(5);
                addTrackItemByKey.mUsingResolution = videoInfo.getResolution();
                addTrackItemByKey.mUrls = _addP2pFlag;
                addTrackItemByKey.mLocalFilePath = str;
                addTrackItemByKey.mExternalInfo = MDLExtraInfoHelper.createMDLExtraInfo(videoInfo, dataLoaderTaskItem);
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d("DataLoaderHelper", "[preload] prepare url info. videoId = " + dataLoaderTaskItem.mVideoId + ", key is " + valueStr + ", resolution = " + addTrackItemByKey.mUsingResolution.toString());
                    return;
                }
                return;
            }
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] url info, urls info invalid");
            dataLoaderTaskItem._notifyError(-100001);
            return;
        }
        TTVideoEngineLog.e("DataLoaderHelper", "[preload] prepare url info fail. info or taskItem is null");
    }

    public void setStringValue(int i, String str) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d("DataLoaderHelper", "setStringValue key = " + i + ", value = " + str);
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            try {
                switch (i) {
                    case 0:
                        this.mConfigure.mCacheDir = str;
                        break;
                    case 102:
                        this.mConfigure.mNetCacheDir = str;
                        break;
                    case 107:
                        AVMDLDNSParser.setStringValue(8, str);
                        break;
                    case 108:
                        AVMDLDNSParser.setStringValue(9, str);
                        break;
                    case TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE /* 111 */:
                        this.mConfigure.mDownloadDir = str;
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE /* 514 */:
                        this.mConfigure.mLiveContainerString = str;
                        break;
                    case 1106:
                        this.mConfigure.mVdpABTestId = str;
                        break;
                    case 1107:
                        this.mConfigure.mVdpGroupId = str;
                        break;
                    case 1149:
                        this.mConfigure.mNetSchedulerConfigStr = str;
                        break;
                    case 1165:
                        this.mConfigure.mDynamicPreconnectConfigStr = str;
                        break;
                    case 1173:
                        this.mConfigure.mSpeedEngineSetting = str;
                        break;
                    case 1500:
                        this.mConfigure.mMdlExtensionOptsStr = str;
                        break;
                    case 1502:
                        this.mConfigure.mTemporaryOptStr = str;
                        break;
                    case 1506:
                    case 1507:
                    case 1508:
                        if (!TextUtils.isEmpty(str)) {
                            if (TextUtils.isEmpty(this.mConfigure.mCustomUA)) {
                                this.mConfigure.mCustomUA = str;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure = this.mConfigure;
                                sb.append(aVMDLDataLoaderConfigure.mCustomUA);
                                sb.append(",");
                                sb.append(str);
                                aVMDLDataLoaderConfigure.mCustomUA = sb.toString();
                            }
                        }
                        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                            TTVideoEngineLog.d("DataLoaderHelper", "cur custom UA" + this.mConfigure.mCustomUA);
                            break;
                        }
                        break;
                    case 1510:
                        this.mConfigure.mFileRingBufferOptStr = str;
                        break;
                    case 1511:
                        this.mConfigure.mN80OptsStr = str;
                        break;
                    case 1512:
                        this.mConfigure.mMdlTTQuicHeOptsStr = str;
                        break;
                    case 2007:
                        this.mConfigure.mStoStrategyConfig = str;
                        break;
                    case 2029:
                        this.mConfigure.mPrecisePreloadConfigStr = str;
                        break;
                    case 2101:
                        this.mConfigure.mVdpExtGlobalInfo = str;
                        break;
                    case 9002:
                        this.mConfigure.mSettingsDomain = str;
                        break;
                    case 9003:
                        this.mConfigure.mDmDomain = str;
                        break;
                    case 9004:
                        this.mConfigure.mForesightDomain = str;
                        break;
                    case 9005:
                        this.mConfigure.mDomains = str;
                        break;
                    case 9006:
                        this.mConfigure.mKeyDomain = str;
                        break;
                    case 9007:
                        this.mConfigure.mKeyToken = str;
                        break;
                    case 9010:
                        this.mConfigure.mSocketTraingCenterConfigStr = str;
                        break;
                    case 9012:
                        this.mConfigure.mP2PConfigStr = str;
                        break;
                    case 9020:
                        for (String str2 : str.split(",")) {
                            if (!TextUtils.isEmpty(str2)) {
                                this.mNotifyNetErrors.add(Integer.valueOf(Integer.parseInt(str2)));
                            }
                        }
                        break;
                    case 12003:
                        this.mConfigure.mFileKeyRule = str;
                        break;
                }
            } catch (Exception e) {
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                    TTVideoEngineLog.d(e);
                }
            }
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0219 A[Catch: Exception -> 0x02ec, TryCatch #0 {Exception -> 0x02ec, blocks: (B:11:0x001f, B:14:0x003d, B:16:0x0041, B:18:0x0047, B:21:0x005e, B:23:0x0065, B:26:0x006b, B:28:0x0073, B:30:0x0079, B:31:0x008f, B:33:0x0093, B:35:0x00a6, B:37:0x00af, B:41:0x00c2, B:44:0x00c8, B:46:0x00dd, B:48:0x00ee, B:54:0x00f2, B:55:0x011c, B:57:0x0122, B:60:0x012c, B:62:0x0136, B:65:0x013b, B:67:0x0141, B:68:0x015c, B:71:0x0189, B:74:0x0197, B:76:0x01a1, B:77:0x01a6, B:80:0x01b0, B:83:0x01bb, B:85:0x01bf, B:87:0x01c6, B:90:0x01df, B:91:0x01f6, B:93:0x01fa, B:94:0x01fd, B:97:0x020c, B:99:0x0212, B:103:0x0219, B:105:0x0221, B:107:0x022a, B:109:0x0241, B:111:0x024d, B:113:0x0254, B:114:0x0268, B:115:0x026b, B:118:0x0294, B:120:0x02ab, B:121:0x02c3, B:123:0x02c7, B:125:0x02d1, B:133:0x0194, B:134:0x0165, B:144:0x017a, B:157:0x00f5, B:159:0x00fd, B:161:0x0103, B:164:0x011a), top: B:10:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x024d A[Catch: Exception -> 0x02ec, TryCatch #0 {Exception -> 0x02ec, blocks: (B:11:0x001f, B:14:0x003d, B:16:0x0041, B:18:0x0047, B:21:0x005e, B:23:0x0065, B:26:0x006b, B:28:0x0073, B:30:0x0079, B:31:0x008f, B:33:0x0093, B:35:0x00a6, B:37:0x00af, B:41:0x00c2, B:44:0x00c8, B:46:0x00dd, B:48:0x00ee, B:54:0x00f2, B:55:0x011c, B:57:0x0122, B:60:0x012c, B:62:0x0136, B:65:0x013b, B:67:0x0141, B:68:0x015c, B:71:0x0189, B:74:0x0197, B:76:0x01a1, B:77:0x01a6, B:80:0x01b0, B:83:0x01bb, B:85:0x01bf, B:87:0x01c6, B:90:0x01df, B:91:0x01f6, B:93:0x01fa, B:94:0x01fd, B:97:0x020c, B:99:0x0212, B:103:0x0219, B:105:0x0221, B:107:0x022a, B:109:0x0241, B:111:0x024d, B:113:0x0254, B:114:0x0268, B:115:0x026b, B:118:0x0294, B:120:0x02ab, B:121:0x02c3, B:123:0x02c7, B:125:0x02d1, B:133:0x0194, B:134:0x0165, B:144:0x017a, B:157:0x00f5, B:159:0x00fd, B:161:0x0103, B:164:0x011a), top: B:10:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02ab A[Catch: Exception -> 0x02ec, TryCatch #0 {Exception -> 0x02ec, blocks: (B:11:0x001f, B:14:0x003d, B:16:0x0041, B:18:0x0047, B:21:0x005e, B:23:0x0065, B:26:0x006b, B:28:0x0073, B:30:0x0079, B:31:0x008f, B:33:0x0093, B:35:0x00a6, B:37:0x00af, B:41:0x00c2, B:44:0x00c8, B:46:0x00dd, B:48:0x00ee, B:54:0x00f2, B:55:0x011c, B:57:0x0122, B:60:0x012c, B:62:0x0136, B:65:0x013b, B:67:0x0141, B:68:0x015c, B:71:0x0189, B:74:0x0197, B:76:0x01a1, B:77:0x01a6, B:80:0x01b0, B:83:0x01bb, B:85:0x01bf, B:87:0x01c6, B:90:0x01df, B:91:0x01f6, B:93:0x01fa, B:94:0x01fd, B:97:0x020c, B:99:0x0212, B:103:0x0219, B:105:0x0221, B:107:0x022a, B:109:0x0241, B:111:0x024d, B:113:0x0254, B:114:0x0268, B:115:0x026b, B:118:0x0294, B:120:0x02ab, B:121:0x02c3, B:123:0x02c7, B:125:0x02d1, B:133:0x0194, B:134:0x0165, B:144:0x017a, B:157:0x00f5, B:159:0x00fd, B:161:0x0103, B:164:0x011a), top: B:10:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02c7 A[Catch: Exception -> 0x02ec, TryCatch #0 {Exception -> 0x02ec, blocks: (B:11:0x001f, B:14:0x003d, B:16:0x0041, B:18:0x0047, B:21:0x005e, B:23:0x0065, B:26:0x006b, B:28:0x0073, B:30:0x0079, B:31:0x008f, B:33:0x0093, B:35:0x00a6, B:37:0x00af, B:41:0x00c2, B:44:0x00c8, B:46:0x00dd, B:48:0x00ee, B:54:0x00f2, B:55:0x011c, B:57:0x0122, B:60:0x012c, B:62:0x0136, B:65:0x013b, B:67:0x0141, B:68:0x015c, B:71:0x0189, B:74:0x0197, B:76:0x01a1, B:77:0x01a6, B:80:0x01b0, B:83:0x01bb, B:85:0x01bf, B:87:0x01c6, B:90:0x01df, B:91:0x01f6, B:93:0x01fa, B:94:0x01fd, B:97:0x020c, B:99:0x0212, B:103:0x0219, B:105:0x0221, B:107:0x022a, B:109:0x0241, B:111:0x024d, B:113:0x0254, B:114:0x0268, B:115:0x026b, B:118:0x0294, B:120:0x02ab, B:121:0x02c3, B:123:0x02c7, B:125:0x02d1, B:133:0x0194, B:134:0x0165, B:144:0x017a, B:157:0x00f5, B:159:0x00fd, B:161:0x0103, B:164:0x011a), top: B:10:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0194 A[Catch: Exception -> 0x02ec, TryCatch #0 {Exception -> 0x02ec, blocks: (B:11:0x001f, B:14:0x003d, B:16:0x0041, B:18:0x0047, B:21:0x005e, B:23:0x0065, B:26:0x006b, B:28:0x0073, B:30:0x0079, B:31:0x008f, B:33:0x0093, B:35:0x00a6, B:37:0x00af, B:41:0x00c2, B:44:0x00c8, B:46:0x00dd, B:48:0x00ee, B:54:0x00f2, B:55:0x011c, B:57:0x0122, B:60:0x012c, B:62:0x0136, B:65:0x013b, B:67:0x0141, B:68:0x015c, B:71:0x0189, B:74:0x0197, B:76:0x01a1, B:77:0x01a6, B:80:0x01b0, B:83:0x01bb, B:85:0x01bf, B:87:0x01c6, B:90:0x01df, B:91:0x01f6, B:93:0x01fa, B:94:0x01fd, B:97:0x020c, B:99:0x0212, B:103:0x0219, B:105:0x0221, B:107:0x022a, B:109:0x0241, B:111:0x024d, B:113:0x0254, B:114:0x0268, B:115:0x026b, B:118:0x0294, B:120:0x02ab, B:121:0x02c3, B:123:0x02c7, B:125:0x02d1, B:133:0x0194, B:134:0x0165, B:144:0x017a, B:157:0x00f5, B:159:0x00fd, B:161:0x0103, B:164:0x011a), top: B:10:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a1 A[Catch: Exception -> 0x02ec, TryCatch #0 {Exception -> 0x02ec, blocks: (B:11:0x001f, B:14:0x003d, B:16:0x0041, B:18:0x0047, B:21:0x005e, B:23:0x0065, B:26:0x006b, B:28:0x0073, B:30:0x0079, B:31:0x008f, B:33:0x0093, B:35:0x00a6, B:37:0x00af, B:41:0x00c2, B:44:0x00c8, B:46:0x00dd, B:48:0x00ee, B:54:0x00f2, B:55:0x011c, B:57:0x0122, B:60:0x012c, B:62:0x0136, B:65:0x013b, B:67:0x0141, B:68:0x015c, B:71:0x0189, B:74:0x0197, B:76:0x01a1, B:77:0x01a6, B:80:0x01b0, B:83:0x01bb, B:85:0x01bf, B:87:0x01c6, B:90:0x01df, B:91:0x01f6, B:93:0x01fa, B:94:0x01fd, B:97:0x020c, B:99:0x0212, B:103:0x0219, B:105:0x0221, B:107:0x022a, B:109:0x0241, B:111:0x024d, B:113:0x0254, B:114:0x0268, B:115:0x026b, B:118:0x0294, B:120:0x02ab, B:121:0x02c3, B:123:0x02c7, B:125:0x02d1, B:133:0x0194, B:134:0x0165, B:144:0x017a, B:157:0x00f5, B:159:0x00fd, B:161:0x0103, B:164:0x011a), top: B:10:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01fa A[Catch: Exception -> 0x02ec, TryCatch #0 {Exception -> 0x02ec, blocks: (B:11:0x001f, B:14:0x003d, B:16:0x0041, B:18:0x0047, B:21:0x005e, B:23:0x0065, B:26:0x006b, B:28:0x0073, B:30:0x0079, B:31:0x008f, B:33:0x0093, B:35:0x00a6, B:37:0x00af, B:41:0x00c2, B:44:0x00c8, B:46:0x00dd, B:48:0x00ee, B:54:0x00f2, B:55:0x011c, B:57:0x0122, B:60:0x012c, B:62:0x0136, B:65:0x013b, B:67:0x0141, B:68:0x015c, B:71:0x0189, B:74:0x0197, B:76:0x01a1, B:77:0x01a6, B:80:0x01b0, B:83:0x01bb, B:85:0x01bf, B:87:0x01c6, B:90:0x01df, B:91:0x01f6, B:93:0x01fa, B:94:0x01fd, B:97:0x020c, B:99:0x0212, B:103:0x0219, B:105:0x0221, B:107:0x022a, B:109:0x0241, B:111:0x024d, B:113:0x0254, B:114:0x0268, B:115:0x026b, B:118:0x0294, B:120:0x02ab, B:121:0x02c3, B:123:0x02c7, B:125:0x02d1, B:133:0x0194, B:134:0x0165, B:144:0x017a, B:157:0x00f5, B:159:0x00fd, B:161:0x0103, B:164:0x011a), top: B:10:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void _progressInfoString(com.ss.mediakit.medialoader.AVMDLDataLoaderNotifyInfo r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 760
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.DataLoaderHelper._progressInfoString(com.ss.mediakit.medialoader.AVMDLDataLoaderNotifyInfo, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x021b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void _startMDLPreloadTask(com.ss.ttvideoengine.DataLoaderHelper.DataLoaderTaskItem r36, com.ss.ttvideoengine.DataLoaderHelper.DataLoaderTaskItem.TrackItem r37) {
        /*
            Method dump skipped, instructions count: 762
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.DataLoaderHelper._startMDLPreloadTask(com.ss.ttvideoengine.DataLoaderHelper$DataLoaderTaskItem, com.ss.ttvideoengine.DataLoaderHelper$DataLoaderTaskItem$TrackItem):void");
    }

    public void addTask(String str, PreloaderVidItem preloaderVidItem) {
        if (this.mState != 0) {
            return;
        }
        if (preloaderVidItem != null && !TextUtils.isEmpty(preloaderVidItem.mVideoId)) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i("DataLoaderHelper", String.format("addTask key is %s; videoId = %s", str, preloaderVidItem.mVideoId));
            }
            this.mLock.lock(ABLock.TYPE_READ);
            try {
                _addTask(str, preloaderVidItem.mVideoId, preloaderVidItem.mPreloadSize, preloaderVidItem, null, null);
                return;
            } finally {
                this.mLock.unlock(ABLock.TYPE_READ);
            }
        }
        TTVideoEngineLog.e("DataLoaderHelper", "videoId invalid.");
    }

    public void addTask(IVideoModel iVideoModel, Resolution resolution, long j) {
        addTask(iVideoModel, resolution, (Map<Integer, String>) null, j);
    }

    public DataLoaderCacheFileInfo cacheFileInfoByTimeOut(String str, long j, TimeUnit timeUnit) {
        DataLoaderCacheInfo cacheInfoByTimeOut = getCacheInfoByTimeOut(str, j, timeUnit);
        if (cacheInfoByTimeOut != null) {
            DataLoaderCacheFileInfo dataLoaderCacheFileInfo = new DataLoaderCacheFileInfo();
            dataLoaderCacheFileInfo.mMediaSize = cacheInfoByTimeOut.mMediaSize;
            dataLoaderCacheFileInfo.mCacheSizeFromZero = cacheInfoByTimeOut.mCacheSizeFromZero;
            dataLoaderCacheFileInfo.mLocalFilePath = cacheInfoByTimeOut.mLocalFilePath;
            return dataLoaderCacheFileInfo;
        }
        return null;
    }

    public String downloadUrl(String str, String str2, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length >= 1) {
            return downloadProxyQuery(str, str2, 0L, 0L, strArr, null, null, false, null, -1, -1L, 0);
        }
        return null;
    }

    public long getContinueCacheSize(String str, int i, long j) {
        long j2 = 0;
        if (this.mState != 0) {
            return 0L;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        try {
            AVMDLDataLoader aVMDLDataLoader = this.mInnerDataLoader;
            if (aVMDLDataLoader != null) {
                long continueCacheSize = aVMDLDataLoader.getContinueCacheSize(str, i, j);
                if (continueCacheSize > 0) {
                    j2 = continueCacheSize;
                }
            }
        } finally {
            try {
                return j2;
            } finally {
            }
        }
        return j2;
    }

    private Error _errorWithCode(int i, long j, String str) {
        String str2;
        int i2;
        String str3;
        int i3;
        if (i != -5000) {
            if (i != -4000) {
                if (i != -2000) {
                    if (i != -3001) {
                        if (i != -3000) {
                            switch (i) {
                                case -1002:
                                    str2 = "Waiting for too many tasks, > 20";
                                    break;
                                case -1001:
                                    str2 = "add the same key task.";
                                    break;
                                case -1000:
                                    str2 = "create preload task fail.";
                                    break;
                                default:
                                    str2 = "task fail. reply task error.";
                                    break;
                            }
                        } else {
                            if (!NetUtils.isNetAvailable(this.mContext)) {
                                i3 = -9960;
                            } else {
                                i3 = -9945;
                            }
                            i2 = i3;
                            str2 = "url invalid. response status code >= 400";
                        }
                    } else {
                        str2 = "server invalid. response status code >= 500";
                        i2 = -9944;
                    }
                } else {
                    str2 = "media data content length invalid";
                }
            } else {
                str2 = "request invalid.";
            }
            i2 = i;
        } else {
            str2 = "write file fail.";
            i2 = -9948;
        }
        if (j == 3) {
            str3 = "kTTVideoErrorDomainDownload";
        } else {
            str3 = "kTTVideoErrorDomainDataLoaderPreload";
        }
        return new Error(str3, i2, i, "key = " + str + ", reason = " + str2);
    }

    public void addTask(VideoModel videoModel, Resolution resolution, long j) {
        addTask(videoModel, resolution, (Map<Integer, String>) null, j);
    }

    public DataLoaderCacheInfo getCacheInfoByTimeOut(String str, long j, TimeUnit timeUnit) {
        ABLockWrapper aBLockWrapper;
        int i;
        DataLoaderCacheInfo dataLoaderCacheInfo = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d("DataLoaderHelper", "****try get cacheinfo lock timeout" + j);
            }
            if (this.mLock.tryLock(ABLock.TYPE_READ, j, timeUnit)) {
                TTVideoEngineLog.d("DataLoaderHelper", "####get cacheinfo lock suc");
                try {
                } catch (Throwable th) {
                    try {
                        TTVideoEngineLog.d(th);
                        aBLockWrapper = this.mLock;
                        i = ABLock.TYPE_READ;
                    } finally {
                        this.mLock.unlock(ABLock.TYPE_READ);
                    }
                }
                if (this.mInnerDataLoader != null && this.mState == 0) {
                    dataLoaderCacheInfo = _processCacheInfo(this.mInnerDataLoader.getStringCacheInfo(str));
                    TTVideoEngineLog.d("DataLoaderHelper", "get cacheinfo native end");
                    aBLockWrapper = this.mLock;
                    i = ABLock.TYPE_READ;
                    aBLockWrapper.unlock(i);
                }
                TTVideoEngineLog.d("DataLoaderHelper", "get cacheinfo fail mdl not start");
                return null;
            }
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d("DataLoaderHelper", "####not get cacheinfo lock timeout" + j);
            }
        } catch (InterruptedException e) {
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                TTVideoEngineLog.d("DataLoaderHelper", "get cacheinfo interrupt exception:" + e.getLocalizedMessage());
            }
        }
        TTVideoEngineLog.d("DataLoaderHelper", "get cacheinfo all end");
        return dataLoaderCacheInfo;
    }

    public String getStringValue(int i, long j, String str) {
        DataLoaderTaskItem dataLoaderTaskItem;
        PreloaderURLItem preloaderURLItem;
        String str2;
        String str3 = str;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            TTVideoEngineLog.i("DataLoaderHelper", "[preload] getStringValue, key = " + str3);
        }
        String str4 = null;
        if (i != 1506) {
            if (i == 1509 && this.mListener != null && !TextUtils.isEmpty(str)) {
                HashMap<String, String> customHttpHeaders = this.mListener.getCustomHttpHeaders(str3);
                if (customHttpHeaders == null || customHttpHeaders.size() == 0) {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                for (String str5 : customHttpHeaders.keySet()) {
                    if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(customHttpHeaders.get(str5))) {
                        sb.append(str5);
                        sb.append(": ");
                        sb.append(customHttpHeaders.get(str5));
                        sb.append("\r\n");
                    }
                }
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                    TTVideoEngineLog.i("DataLoaderHelper", String.format("[customheader] get custom header:%s url: %s", str3, sb.toString()));
                }
                return sb.toString();
            }
        } else {
            DataLoaderTaskQueue dataLoaderTaskQueue = this.mAllPreloadTasks;
            if (dataLoaderTaskQueue != null) {
                dataLoaderTaskItem = dataLoaderTaskQueue.itemForKey(str3);
            } else {
                dataLoaderTaskItem = null;
            }
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                TTVideoEngineLog.i("DataLoaderHelper", "[preload] getStringValue, key = " + str3);
            }
            if (dataLoaderTaskItem != null && (preloaderURLItem = dataLoaderTaskItem.mURLItem) != null && preloaderURLItem.getProvider() != null) {
                String key = dataLoaderTaskItem.mURLItem.getProvider().getKey();
                String[] urls = dataLoaderTaskItem.mURLItem.getProvider().getUrls();
                DataLoaderTaskItem.TrackItem trackItem = dataLoaderTaskItem.getTrackItem(str3);
                long j2 = trackItem.mPreSize;
                long preloadSize = dataLoaderTaskItem.mURLItem.getProvider().getPreloadSize();
                String cacheDir = dataLoaderTaskItem.mURLItem.getProvider().getCacheDir();
                if (dataLoaderTaskItem.mTag != null) {
                    str2 = "tag=" + TTHelper.encodeUrl(dataLoaderTaskItem.mTag);
                } else {
                    str2 = null;
                }
                str4 = proxyQuery(key, key, trackItem.mPreloadOffset, preloadSize, urls, cacheDir, str2, false, null, -1, -1);
                if (!TextUtils.isEmpty(key)) {
                    str3 = key;
                }
                trackItem.mTaskKey = str3;
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
                    TTVideoEngineLog.i("DataLoaderHelper", String.format("[preload] get proxxy url from url: %s", str4));
                }
            }
        }
        return str4;
    }

    public void addTask(IVideoModel iVideoModel, Resolution resolution, Map<Integer, String> map, long j) {
        PreloaderVideoModelItem preloaderVideoModelItem = new PreloaderVideoModelItem(iVideoModel, resolution, j, (PreloaderFilePathListener) null);
        preloaderVideoModelItem.mParams = map;
        addTask(preloaderVideoModelItem);
    }

    public void setPlayInfoOnlyForPreload(int i, String str, String str2, long j) {
        if (this.mState != 0) {
            TTVideoEngineLog.d("DataLoaderHelper", "dataloader not started, not allow set play info");
            return;
        }
        if (this.mEnableBufferPreload <= 0) {
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        PreloadUtil preloadUtil = this.mPreloadUtil;
        if (preloadUtil.mPlayBufferLowerBound > 0 && preloadUtil.mPlayBufferUpperBound > 0) {
            preloadUtil.updatePlayInfo(i, str, str2, j);
        }
        this.mLock.unlock(ABLock.TYPE_READ);
    }

    public String downloadUrl(String str, String str2, String[] strArr, int i) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length >= 1) {
            return downloadProxyQuery(str, str2, 0L, 0L, strArr, null, null, false, null, i, 0L, 0);
        }
        return null;
    }

    public long getMissReason(int i, String str, String str2, String str3) {
        AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure;
        this.mLock.lock(ABLock.TYPE_READ);
        long j = 0;
        try {
            if (this.mInnerDataLoader != null && ((aVMDLDataLoaderConfigure = this.mConfigure) == null || aVMDLDataLoaderConfigure.mEnableMissReason != 0)) {
                if (i == 0) {
                    str = TTHelper.keyFromFilePath(this.mContext, str);
                } else if (i != 1) {
                    str = null;
                }
                if (str != null) {
                    if (this.mConfigure.mEnableUseGroupId > 0 && !TextUtils.isEmpty(str3)) {
                        str2 = str3;
                    }
                    long missReason = this.mInnerDataLoader.getMissReason(str, str2);
                    if (missReason > 0) {
                        j = missReason;
                    }
                }
            }
        } finally {
            try {
                return j;
            } finally {
            }
        }
        return j;
    }

    public void setPlayInfo(int i, String str, String str2, long j) {
        int i2;
        if (this.mState != 0) {
            TTVideoEngineLog.d("DataLoaderHelper", "dataloader not started, not allow set play info");
            return;
        }
        this.mLock.lock(ABLock.TYPE_READ);
        setPlayInfoOnlyForPreload(i, str, str2, j);
        switch (i) {
            case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                i2 = 7210;
                break;
            case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                i2 = 7211;
                break;
            case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                i2 = 7212;
                break;
            case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                i2 = 7213;
                break;
            case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                i2 = 7214;
                break;
            case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                i2 = 7215;
                break;
            case 28:
                i2 = 7338;
                break;
            default:
                i2 = -1;
                break;
        }
        try {
            try {
                this.mInnerDataLoader.setInt64ValueByStrKey(i2, str, j);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            this.mLock.unlock(ABLock.TYPE_READ);
        }
    }

    public void addTask(VideoModel videoModel, Resolution resolution, Map<Integer, String> map, long j) {
        PreloaderVideoModelItem preloaderVideoModelItem = new PreloaderVideoModelItem(videoModel, resolution, j, (PreloaderFilePathListener) null);
        preloaderVideoModelItem.mParams = map;
        addTask(preloaderVideoModelItem);
    }

    public String getDataLoaderUrl(String str, String str2, String[] strArr, Resolution resolution, String str3) {
        return _proxyUrl(str, str2, 0L, strArr, resolution, str3, null, null, null, false, false, null, 0L, null, -1, null, false, -1);
    }

    public String proxyUrl(String str, String str2, String[] strArr, Resolution resolution, String str3) {
        return _proxyUrl(str, str2, 0L, strArr, resolution, str3, null, null, null, false, false, null, 0L, null, -1, null, false, -1);
    }

    private String proxyQueryProvideMode(String str, String str2, int i, int i2, String str3) {
        if (TextUtils.isEmpty(str) || i2 == 0) {
            return null;
        }
        String encodeUrl = TTHelper.encodeUrl(str);
        if (TextUtils.isEmpty(encodeUrl)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
        }
        String encodeUrl2 = TTHelper.encodeUrl(str2);
        if (!TextUtils.isEmpty(encodeUrl2)) {
            str = encodeUrl2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?rk=");
        stringBuffer.append(str);
        stringBuffer.append("&k=");
        stringBuffer.append(encodeUrl);
        stringBuffer.append("&pv=");
        stringBuffer.append(1);
        if (!TextUtils.isEmpty(str3)) {
            stringBuffer.append("&gid=");
            stringBuffer.append(str3);
        }
        if (i > 0) {
            stringBuffer.append("&l=");
            stringBuffer.append(i);
        }
        return stringBuffer.toString();
    }

    public int writeDataToFile(String str, long j, long j2, int i, byte[] bArr) {
        if (this.mState != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "not start");
            return -1;
        }
        int i2 = 0;
        if (this.mLock.tryLock(ABLock.TYPE_READ)) {
            if (this.mInnerDataLoader != null) {
                TTVideoEngineLog.d("DataLoaderHelper", "start write");
                int writeDataToFile = this.mInnerDataLoader.writeDataToFile(str, j, j2, i, bArr);
                TTVideoEngineLog.d("DataLoaderHelper", "end write");
                i2 = writeDataToFile;
            }
            this.mLock.unlock(ABLock.TYPE_READ);
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
            TTVideoEngineLog.d("DataLoaderHelper", "write data to file ret:" + i2);
        }
        return i2;
    }

    public String proxyUrl(String str, String str2, String[] strArr, Resolution resolution, String str3, String str4) {
        return _proxyUrl(str, str2, 0L, strArr, resolution, str3, null, str4, null, false, false, null, 0L, null, -1, null, false, -1);
    }

    public String downloadUrl(String str, String str2, String[] strArr, int i, String str3, int i2) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length >= 1) {
            return downloadProxyQuery(str, str2, 0L, 0L, strArr, str3, null, false, null, i, 0L, i2);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void _addTask(java.lang.String r7, java.lang.String r8, long r9, com.ss.ttvideoengine.PreloaderVidItem r11, com.ss.ttvideoengine.PreloaderVideoModelItem r12, com.ss.ttvideoengine.PreloaderURLItem r13) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.DataLoaderHelper._addTask(java.lang.String, java.lang.String, long, com.ss.ttvideoengine.PreloaderVidItem, com.ss.ttvideoengine.PreloaderVideoModelItem, com.ss.ttvideoengine.PreloaderURLItem):void");
    }

    private String proxyQuery(String str, String str2, long j, long j2, String[] strArr, String str3, String str4, boolean z, String str5, int i, int i2) {
        return preloadProxyQuery(str, str2, j, j2, strArr, str3, str4, 0, null, z, str5, 0, 0L, "", -1, i, i2);
    }

    private String downloadProxyQuery(String str, String str2, long j, long j2, String[] strArr, String str3, String str4, boolean z, String str5, int i, long j3, int i2) {
        return preloadProxyQuery(str, str2, j, j2, strArr, str3, str4, 0, null, z, str5, i, j3, "", -1, -1, i2);
    }

    private String preloadProxyQuery(String str, String str2, long j, long j2, String[] strArr, String str3, String str4, int i, String str5, boolean z, String str6, String str7, int i2, int i3) {
        return preloadProxyQuery(str, str2, j, j2, strArr, str3, str4, i, str5, z, str6, 0, 0L, str7, i2, -1, i3);
    }

    private String preloadProxyQuery(String str, String str2, long j, long j2, String[] strArr, String str3, String str4, int i, String str5, boolean z, String str6, int i2, long j3, String str7, int i3, int i4, int i5) {
        long j4;
        String str8;
        String str9;
        boolean z2;
        String str10;
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length < 1) {
            return null;
        }
        String[] strArr2 = (String[]) strArr.clone();
        if (j2 > 0) {
            j4 = j2;
        } else {
            j4 = 0;
        }
        for (String str11 : strArr2) {
            if (!_supportProxy(str11)) {
                return null;
            }
        }
        String[] _removeRepeatUrls = _removeRepeatUrls(strArr2);
        String encodeUrl = TTHelper.encodeUrl(str);
        if (TextUtils.isEmpty(encodeUrl)) {
            return null;
        }
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("preloadProxyQuery: key = ");
            str8 = str;
            sb.append(str8);
            sb.append(", rawKey = ");
            str9 = str2;
            sb.append(str9);
            TTVideoEngineLog.i("DataLoaderHelper", sb.toString());
        } else {
            str8 = str;
            str9 = str2;
        }
        if (TextUtils.isEmpty(str2)) {
            str9 = str8;
        }
        String encodeUrl2 = TTHelper.encodeUrl(str9);
        if (TextUtils.isEmpty(encodeUrl2)) {
            encodeUrl2 = "videoId";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?rk=");
        stringBuffer.append(encodeUrl2);
        stringBuffer.append("&k=");
        stringBuffer.append(encodeUrl);
        if (j4 > 0) {
            stringBuffer.append("&s=");
            stringBuffer.append(j + j4);
        }
        if (i > 0) {
            stringBuffer.append("&l=");
            stringBuffer.append(i);
        }
        if (!TextUtils.isEmpty(str3)) {
            String encodeUrl3 = TTHelper.encodeUrl(str3);
            if (!TextUtils.isEmpty(encodeUrl3)) {
                stringBuffer.append("&p=");
                stringBuffer.append(encodeUrl3);
            }
        }
        if (!TextUtils.isEmpty(str5)) {
            String encodeUrl4 = TTHelper.encodeUrl(str5);
            if (!TextUtils.isEmpty(encodeUrl4)) {
                stringBuffer.append("&h=");
                stringBuffer.append(encodeUrl4);
            }
        }
        if (!TextUtils.isEmpty(str7)) {
            stringBuffer.append("&gid=");
            stringBuffer.append(str7);
        }
        if (!z && !FormatProvider.FormatProviderHolder.isM3u8(_removeRepeatUrls[0])) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            stringBuffer.append("&ft=1");
        }
        if (i2 > 0) {
            stringBuffer.append("&ev=" + i2);
        }
        if (j3 > 0) {
            stringBuffer.append("&ue=" + j3);
        }
        if (!TextUtils.isEmpty(str6)) {
            String encodeUrl5 = TTHelper.encodeUrl(str6);
            if (!TextUtils.isEmpty(encodeUrl5)) {
                stringBuffer.append("&dtk=");
                stringBuffer.append(encodeUrl5);
            }
        }
        if (i3 > 0) {
            stringBuffer.append("&play_index_gap=" + i3);
        }
        if (i4 > 0) {
            stringBuffer.append("&retry_err_cnt=" + i4);
        }
        if (i5 > 0) {
            stringBuffer.append("&use_ori_en=1");
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i6 = 0; i6 < _removeRepeatUrls.length; i6++) {
            if (this.mConfigure.mEnableUseOriginalUrl != 1 && i5 <= 0) {
                str10 = encodeUrlByQuery(_removeRepeatUrls[i6]);
            } else {
                try {
                    str10 = URLEncoder.encode(_removeRepeatUrls[i6], "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                    if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1)) {
                        TTVideoEngineLog.d("TTHelperEncode", "encode failed:" + _removeRepeatUrls[i6]);
                    }
                    str10 = null;
                }
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            if (!TextUtils.isEmpty(str10)) {
                stringBuffer3.append("&u");
                stringBuffer3.append(i6);
                stringBuffer3.append("=");
                stringBuffer3.append(str10);
            }
            if (stringBuffer.length() + stringBuffer2.length() + stringBuffer3.length() + 32 > 3096) {
                break;
            }
            stringBuffer2.append(stringBuffer3);
        }
        if (stringBuffer2.length() < 1) {
            return null;
        }
        stringBuffer.append(stringBuffer2);
        if (!TextUtils.isEmpty(str4) && stringBuffer.length() + str4.length() + 33 <= 3096) {
            stringBuffer.append("&");
            stringBuffer.append(str4);
        }
        return stringBuffer.toString();
    }

    public String _proxyUrl(String str, String str2, long j, String[] strArr, Resolution resolution, String str3, VideoInfo videoInfo, String str4, String str5, boolean z, boolean z2, String str6, long j2, String[] strArr2, int i, String str7, boolean z3, int i2) {
        return _proxyUrl(str, str2, j, strArr, resolution, str3, videoInfo, str4, str5, z, z2, str6, j2, strArr2, i, str7, z3, i2, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0147 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014f A[Catch: all -> 0x0218, TRY_ENTER, TryCatch #0 {all -> 0x0218, blocks: (B:36:0x0092, B:38:0x0098, B:40:0x00a0, B:45:0x00ca, B:47:0x00d0, B:48:0x00e6, B:50:0x00ec, B:52:0x00f0, B:54:0x00f6, B:56:0x00fe, B:61:0x010a, B:64:0x0110, B:68:0x013d, B:72:0x014f, B:74:0x015f, B:77:0x0165, B:78:0x0186, B:80:0x019d, B:81:0x01ab, B:83:0x01b5, B:92:0x0176, B:94:0x00af, B:96:0x00bb), top: B:35:0x0092 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String _proxyUrl(java.lang.String r25, java.lang.String r26, long r27, java.lang.String[] r29, com.ss.ttvideoengine.Resolution r30, java.lang.String r31, com.ss.ttvideoengine.model.VideoInfo r32, java.lang.String r33, java.lang.String r34, boolean r35, boolean r36, java.lang.String r37, long r38, java.lang.String[] r40, int r41, java.lang.String r42, boolean r43, int r44, int r45) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.DataLoaderHelper._proxyUrl(java.lang.String, java.lang.String, long, java.lang.String[], com.ss.ttvideoengine.Resolution, java.lang.String, com.ss.ttvideoengine.model.VideoInfo, java.lang.String, java.lang.String, boolean, boolean, java.lang.String, long, java.lang.String[], int, java.lang.String, boolean, int, int):java.lang.String");
    }
}
