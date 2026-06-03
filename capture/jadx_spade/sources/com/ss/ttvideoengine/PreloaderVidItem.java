package com.ss.ttvideoengine;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.source.DirectUrlSource;
import com.ss.ttvideoengine.source.VidPlayAuthTokenSource;
import com.ss.ttvideoengine.source.strategy.CodecStrategy;
import com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PreloaderVidItem {
    public CodecStrategyAdapter mAdapter;
    public int mApiVersion;
    private String mAuthorization;
    public boolean mBoeEnable;
    private IPreLoaderItemCallBackListener mCallBackListener;
    public int mCdnType;
    public String mCodecType;
    public boolean mDashEnable;
    public boolean mEncryptEnable;
    private PreloaderVidItemFetchListener mFetchEndListener;
    private PreloaderFilePathListener mFilePathListener;
    public boolean mForbidP2p;
    private String mFormatType;
    public int mGearStrategyEnabled;
    public Map<String, Object> mGearStrategyExtraParams;
    public boolean mHlsEnable;
    public boolean mHttpsEnable;
    private String mItemHash;
    public PreloaderVidItemListener mListener;
    private TTVNetClient mNetClient;
    private boolean mOnlyFetchVideoModel;
    public Map<Integer, String> mParams;
    private int mPlayIndexGap;
    public long mPreloadSize;
    public int mPriorityLevel;
    public Resolution mResolution;
    public HashMap<String, Resolution> mResolutionMap;
    public long mStartTimestamp;
    private String mSubTag;
    private String mTag;
    public String mVideoId;

    static {
        Covode.recordClassIndex(652307);
    }

    public void setAuthorization(String str) {
    }

    String getAuthorization() {
        return this.mAuthorization;
    }

    public IPreLoaderItemCallBackListener getCallBackListener() {
        return this.mCallBackListener;
    }

    PreloaderVidItemFetchListener getFetchEndListener() {
        return this.mFetchEndListener;
    }

    PreloaderFilePathListener getFilePathListener() {
        return this.mFilePathListener;
    }

    public String getFormatType() {
        return this.mFormatType;
    }

    public PreloaderVidItemListener getListener() {
        return this.mListener;
    }

    boolean getOnlyFetchVideoModel() {
        return this.mOnlyFetchVideoModel;
    }

    public int getPlayIndexGap() {
        return this.mPlayIndexGap;
    }

    public int getPriorityLevel() {
        return this.mPriorityLevel;
    }

    public long getStartTimestamp() {
        return this.mStartTimestamp;
    }

    public String getSubTag() {
        return this.mSubTag;
    }

    public String getTag() {
        return this.mTag;
    }

    public PreloaderVidItem(String str, String str2, Resolution resolution, long j, boolean z) {
        this.mVideoId = null;
        this.mResolution = Resolution.SuperHigh;
        this.mPreloadSize = 0L;
        this.mApiVersion = 0;
        this.mCodecType = "h264";
        this.mDashEnable = false;
        this.mHttpsEnable = false;
        this.mForbidP2p = false;
        this.mBoeEnable = false;
        this.mParams = null;
        this.mHlsEnable = false;
        this.mEncryptEnable = false;
        this.mGearStrategyEnabled = 0;
        this.mPriorityLevel = 0;
        this.mAuthorization = null;
        this.mOnlyFetchVideoModel = false;
        this.mNetClient = null;
        this.mListener = null;
        this.mFetchEndListener = null;
        this.mFilePathListener = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mCallBackListener = null;
        this.mStartTimestamp = 0L;
        this.mItemHash = null;
        this.mFormatType = null;
    }

    public PreloaderVidItem(String str, String str2, Resolution resolution, long j, String str3) {
        this.mVideoId = null;
        this.mResolution = Resolution.SuperHigh;
        this.mPreloadSize = 0L;
        this.mApiVersion = 0;
        this.mCodecType = "h264";
        this.mDashEnable = false;
        this.mHttpsEnable = false;
        this.mForbidP2p = false;
        this.mBoeEnable = false;
        this.mParams = null;
        this.mHlsEnable = false;
        this.mEncryptEnable = false;
        this.mGearStrategyEnabled = 0;
        this.mPriorityLevel = 0;
        this.mAuthorization = null;
        this.mOnlyFetchVideoModel = false;
        this.mNetClient = null;
        this.mListener = null;
        this.mFetchEndListener = null;
        this.mFilePathListener = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mCallBackListener = null;
        this.mStartTimestamp = 0L;
        this.mItemHash = null;
        this.mFormatType = null;
    }

    public PreloaderVidItem(String str, String str2, boolean z) {
        this.mVideoId = null;
        this.mResolution = Resolution.SuperHigh;
        this.mPreloadSize = 0L;
        this.mApiVersion = 0;
        this.mCodecType = "h264";
        this.mDashEnable = false;
        this.mHttpsEnable = false;
        this.mForbidP2p = false;
        this.mBoeEnable = false;
        this.mParams = null;
        this.mHlsEnable = false;
        this.mEncryptEnable = false;
        this.mGearStrategyEnabled = 0;
        this.mPriorityLevel = 0;
        this.mAuthorization = null;
        this.mOnlyFetchVideoModel = false;
        this.mNetClient = null;
        this.mListener = null;
        this.mFetchEndListener = null;
        this.mFilePathListener = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mCallBackListener = null;
        this.mStartTimestamp = 0L;
        this.mItemHash = null;
        this.mFormatType = null;
    }

    public int getCdnType() {
        throw new UnsupportedOperationException("tob only");
    }

    public TTVNetClient getNetClient() {
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

    public synchronized String getHash() {
        if (this.mItemHash == null) {
            this.mItemHash = String.valueOf(hashCode());
        }
        return this.mItemHash;
    }

    public void setCallBackListener(IPreLoaderItemCallBackListener iPreLoaderItemCallBackListener) {
        this.mCallBackListener = iPreLoaderItemCallBackListener;
    }

    public void setFetchEndListener(PreloaderVidItemFetchListener preloaderVidItemFetchListener) {
        this.mFetchEndListener = preloaderVidItemFetchListener;
    }

    public void setFilePathListener(PreloaderFilePathListener preloaderFilePathListener) {
        this.mFilePathListener = preloaderFilePathListener;
    }

    public void setFormatType(String str) {
        this.mFormatType = str;
    }

    public void setListener(PreloaderVidItemListener preloaderVidItemListener) {
        this.mListener = preloaderVidItemListener;
    }

    public void setNetworkClient(TTVNetClient tTVNetClient) {
        this.mNetClient = tTVNetClient;
    }

    public void setOnlyFetchVideoModel(boolean z) {
        this.mOnlyFetchVideoModel = z;
    }

    public void setPlayIndexGap(int i) {
        this.mPlayIndexGap = i;
    }

    public void setPriorityLevel(int i) {
        this.mPriorityLevel = i;
    }

    public void setStartTimestamp(long j) {
        this.mStartTimestamp = j;
    }

    public void setSubTag(String str) {
        this.mSubTag = str;
    }

    public void setTag(String str) {
        this.mTag = str;
    }

    /* renamed from: com.ss.ttvideoengine.PreloaderVidItem$1, reason: invalid class name */
    class AnonymousClass1 implements CodecStrategyAdapter.PreloadSourceSetter {
        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.PreloadSourceSetter, com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public /* synthetic */ String createTag() {
            return CodecStrategyAdapter.PreloadSourceSetter.CC.$default$createTag(this);
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.PreloadSourceSetter, com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public /* synthetic */ void setDirectUrl(String str, DirectUrlSource.UrlItem urlItem, CodecStrategy.Dimension dimension, boolean z) {
            TTVideoEngineLog.d(createTag(), "setDirectUrl vid = " + str + ", urlItem = " + urlItem + ", dimension = " + dimension + ", isFetchSmartUrl = " + z);
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.PreloadSourceSetter, com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public /* synthetic */ void setVideoModel(String str, IVideoModel iVideoModel, Resolution resolution) {
            TTVideoEngineLog.d(createTag(), "setVideoModel vid = " + str + ", videoModel = " + iVideoModel + ", resolution = " + resolution);
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.PreloadSourceSetter, com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public /* synthetic */ int type() {
            return CodecStrategyAdapter.PreloadSourceSetter.CC.$default$type(this);
        }

        AnonymousClass1() {
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.PreloadSourceSetter, com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public void setVideoID(String str, String str2, Resolution resolution, String str3, CodecStrategy.Dimension dimension) {
            TTVideoEngineLog.d(createTag(), "setVideoID vid = " + str + ", playAuthToken = " + str2 + ", encodeType = " + str3 + ", dimension = " + dimension);
            PreloaderVidItem preloaderVidItem = PreloaderVidItem.this;
            preloaderVidItem.mVideoId = str;
            preloaderVidItem.setAuthorization(str2);
            if (dimension != null) {
                PreloaderVidItem.this.mCodecType = dimension.encodeType;
            } else if (str3 != null) {
                PreloaderVidItem.this.mCodecType = str3;
            } else {
                PreloaderVidItem.this.mCodecType = null;
            }
            if (resolution != null) {
                PreloaderVidItem.this.mResolution = resolution;
            }
        }
    }

    public void setCdnType(int i) {
        throw new UnsupportedOperationException("tob only");
    }

    public void setResolutionMap(HashMap<String, Resolution> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            this.mResolutionMap = hashMap;
        }
    }

    public PreloaderVidItem(VidPlayAuthTokenSource vidPlayAuthTokenSource, long j) {
        this.mVideoId = null;
        this.mResolution = Resolution.SuperHigh;
        this.mPreloadSize = 0L;
        this.mApiVersion = 0;
        this.mCodecType = "h264";
        this.mDashEnable = false;
        this.mHttpsEnable = false;
        this.mForbidP2p = false;
        this.mBoeEnable = false;
        this.mParams = null;
        this.mHlsEnable = false;
        this.mEncryptEnable = false;
        this.mGearStrategyEnabled = 0;
        this.mPriorityLevel = 0;
        this.mAuthorization = null;
        this.mOnlyFetchVideoModel = false;
        this.mNetClient = null;
        this.mListener = null;
        this.mFetchEndListener = null;
        this.mFilePathListener = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mCallBackListener = null;
        this.mStartTimestamp = 0L;
        this.mItemHash = null;
        this.mFormatType = null;
        throw new UnsupportedOperationException("toB only");
    }

    public PreloaderVidItem(String str, Resolution resolution, long j, String str2) {
        this.mVideoId = null;
        Resolution resolution2 = Resolution.Undefine;
        this.mApiVersion = 0;
        this.mDashEnable = false;
        this.mHttpsEnable = false;
        this.mForbidP2p = false;
        this.mBoeEnable = false;
        this.mParams = null;
        this.mHlsEnable = false;
        this.mEncryptEnable = false;
        this.mGearStrategyEnabled = 0;
        this.mPriorityLevel = 0;
        this.mAuthorization = null;
        this.mOnlyFetchVideoModel = false;
        this.mNetClient = null;
        this.mListener = null;
        this.mFetchEndListener = null;
        this.mFilePathListener = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mCallBackListener = null;
        this.mStartTimestamp = 0L;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mVideoId = str;
        this.mResolution = resolution;
        this.mPreloadSize = j;
        this.mCodecType = str2;
    }

    public PreloaderVidItem(String str, Resolution resolution, long j, boolean z) {
        this.mVideoId = null;
        Resolution resolution2 = Resolution.Undefine;
        this.mApiVersion = 0;
        this.mCodecType = "h264";
        this.mDashEnable = false;
        this.mHttpsEnable = false;
        this.mForbidP2p = false;
        this.mBoeEnable = false;
        this.mParams = null;
        this.mHlsEnable = false;
        this.mEncryptEnable = false;
        this.mGearStrategyEnabled = 0;
        this.mPriorityLevel = 0;
        this.mAuthorization = null;
        this.mOnlyFetchVideoModel = false;
        this.mNetClient = null;
        this.mListener = null;
        this.mFetchEndListener = null;
        this.mFilePathListener = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mCallBackListener = null;
        this.mStartTimestamp = 0L;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mVideoId = str;
        this.mResolution = resolution;
        this.mPreloadSize = j;
        if (z) {
            this.mCodecType = "bytevc1";
        }
    }

    public PreloaderVidItem(String str, Resolution resolution, long j, String str2, boolean z) {
        this.mVideoId = null;
        Resolution resolution2 = Resolution.Undefine;
        this.mApiVersion = 0;
        this.mDashEnable = false;
        this.mHttpsEnable = false;
        this.mBoeEnable = false;
        this.mParams = null;
        this.mHlsEnable = false;
        this.mEncryptEnable = false;
        this.mGearStrategyEnabled = 0;
        this.mPriorityLevel = 0;
        this.mAuthorization = null;
        this.mOnlyFetchVideoModel = false;
        this.mNetClient = null;
        this.mListener = null;
        this.mFetchEndListener = null;
        this.mFilePathListener = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mCallBackListener = null;
        this.mStartTimestamp = 0L;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mVideoId = str;
        this.mResolution = resolution;
        this.mPreloadSize = j;
        this.mCodecType = str2;
        this.mForbidP2p = z;
    }

    public PreloaderVidItem(String str, Resolution resolution, long j, boolean z, boolean z2) {
        this.mVideoId = null;
        Resolution resolution2 = Resolution.Undefine;
        this.mApiVersion = 0;
        this.mCodecType = "h264";
        this.mDashEnable = false;
        this.mHttpsEnable = false;
        this.mForbidP2p = false;
        this.mBoeEnable = false;
        this.mParams = null;
        this.mHlsEnable = false;
        this.mEncryptEnable = false;
        this.mGearStrategyEnabled = 0;
        this.mPriorityLevel = 0;
        this.mAuthorization = null;
        this.mOnlyFetchVideoModel = false;
        this.mNetClient = null;
        this.mListener = null;
        this.mFetchEndListener = null;
        this.mFilePathListener = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mCallBackListener = null;
        this.mStartTimestamp = 0L;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mVideoId = str;
        this.mResolution = resolution;
        this.mPreloadSize = j;
        if (z) {
            this.mCodecType = "bytevc1";
        }
        this.mForbidP2p = z2;
    }
}
