package com.ss.ttvideoengine;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.source.DirectUrlSource;
import com.ss.ttvideoengine.source.strategy.CodecStrategy;
import com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PreloaderURLItem {
    public CodecStrategyAdapter mAdapter;
    private IPreLoaderItemCallBackListener mCallBackListener;
    private int mCdnType;
    private boolean mEnableHlsProxy;
    private String mFilePath;
    private String mFormatType;
    private String mGroupId;
    private HashMap<String, String> mHeaders;
    private String mItemHash;
    private String mKey;
    private int mPlayIndexGap;
    private long mPreloadFooterSize;
    private long mPreloadSize;
    private int mPriorityLevel;
    private DataLoaderResourceProvider mProvider;
    public long mStartTimestamp;
    private String mSubTag;
    private String mTag;
    private String[] mUrlExpireTimes;
    private String[] mUrls;
    private int mUseOriginalUrlEncode;
    private String mVideoId;

    static {
        Covode.recordClassIndex(652306);
    }

    public HashMap<String, String> customHeaders() {
        return this.mHeaders;
    }

    public IPreLoaderItemCallBackListener getCallBackListener() {
        return this.mCallBackListener;
    }

    public boolean getEnableHlsProxy() {
        return this.mEnableHlsProxy;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public String getFormatType() {
        return this.mFormatType;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public String getKey() {
        return this.mKey;
    }

    public int getPlayIndexGap() {
        return this.mPlayIndexGap;
    }

    public long getPreloadFooterSize() {
        return this.mPreloadFooterSize;
    }

    public long getPreloadSize() {
        return this.mPreloadSize;
    }

    public int getPriorityLevel() {
        return this.mPriorityLevel;
    }

    public DataLoaderResourceProvider getProvider() {
        return this.mProvider;
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

    public String[] getUrlExpireTimes() {
        return this.mUrlExpireTimes;
    }

    public String[] getUrls() {
        return this.mUrls;
    }

    public int getUseOriginalUrlEncode() {
        return this.mUseOriginalUrlEncode;
    }

    public String getVideoId() {
        return this.mVideoId;
    }

    public int getCdnType() {
        throw new UnsupportedOperationException("tob only");
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

    public void setEnableHlsProxy(boolean z) {
        this.mEnableHlsProxy = z;
    }

    public void setFormatType(String str) {
        this.mFormatType = str;
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
    }

    public void setKey(String str) {
        this.mKey = str;
    }

    public void setPlayIndexGap(int i) {
        this.mPlayIndexGap = i;
    }

    public void setPreloadFooterSize(long j) {
        this.mPreloadFooterSize = j;
    }

    public void setPriorityLevel(int i) {
        this.mPriorityLevel = i;
    }

    public void setProvider(DataLoaderResourceProvider dataLoaderResourceProvider) {
        this.mProvider = dataLoaderResourceProvider;
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

    public void setUseOriginalUrlEncode(int i) {
        this.mUseOriginalUrlEncode = i;
    }

    /* renamed from: com.ss.ttvideoengine.PreloaderURLItem$1, reason: invalid class name */
    class AnonymousClass1 implements CodecStrategyAdapter.PreloadSourceSetter {
        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.PreloadSourceSetter, com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public /* synthetic */ String createTag() {
            return CodecStrategyAdapter.PreloadSourceSetter.CC.$default$createTag(this);
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.PreloadSourceSetter, com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public /* synthetic */ void setVideoID(String str, String str2, Resolution resolution, String str3, CodecStrategy.Dimension dimension) {
            TTVideoEngineLog.d(createTag(), "setVideoID vid = " + str + ", playAuthToken = " + str2 + ", encodeType = " + str3 + ", dimension = " + dimension);
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
        public void setDirectUrl(String str, DirectUrlSource.UrlItem urlItem, CodecStrategy.Dimension dimension, boolean z) {
            TTVideoEngineLog.d(createTag(), "setDirectUrl vid = " + str + ", urlItem = " + urlItem + ", dimension = " + dimension + ", isFetchSmartUrl = " + z);
            PreloaderURLItem.this.mKey = urlItem.getCacheKey();
            PreloaderURLItem.this.mUrls = urlItem.getUrls();
            PreloaderURLItem.this.mUrlExpireTimes = urlItem.getUrlExpires();
        }
    }

    public void setCdnType(int i) {
        throw new UnsupportedOperationException("tob only");
    }

    public PreloaderURLItem(DirectUrlSource directUrlSource, long j) {
        this.mKey = null;
        this.mFilePath = null;
        this.mVideoId = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPreloadSize = 0L;
        this.mPreloadFooterSize = 0L;
        this.mStartTimestamp = 0L;
        this.mPriorityLevel = 0;
        this.mUseOriginalUrlEncode = -1;
        this.mUrls = null;
        this.mUrlExpireTimes = null;
        this.mProvider = null;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mEnableHlsProxy = false;
        this.mCallBackListener = null;
        this.mHeaders = null;
        throw new UnsupportedOperationException("toB only");
    }

    public void setCustomHeader(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mHeaders == null) {
            this.mHeaders = new HashMap<>();
        }
        this.mHeaders.put(str.substring(0, 1).toUpperCase() + str.substring(1), str2);
    }

    public PreloaderURLItem(String str, long j, String[] strArr, String str2) {
        this.mKey = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPreloadFooterSize = 0L;
        this.mStartTimestamp = 0L;
        this.mPriorityLevel = 0;
        this.mUseOriginalUrlEncode = -1;
        this.mUrlExpireTimes = null;
        this.mProvider = null;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mEnableHlsProxy = false;
        this.mCallBackListener = null;
        this.mHeaders = null;
        this.mFilePath = str2;
        this.mVideoId = str;
        this.mPreloadSize = j;
        this.mUrls = strArr;
    }

    public PreloaderURLItem(String str, String str2, long j, String[] strArr) {
        this.mFilePath = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPreloadFooterSize = 0L;
        this.mStartTimestamp = 0L;
        this.mPriorityLevel = 0;
        this.mUseOriginalUrlEncode = -1;
        this.mUrlExpireTimes = null;
        this.mProvider = null;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mEnableHlsProxy = false;
        this.mCallBackListener = null;
        this.mHeaders = null;
        this.mKey = str;
        this.mVideoId = str2;
        this.mPreloadSize = j;
        this.mUrls = strArr;
    }

    public PreloaderURLItem(String str, String str2, long j, DataLoaderResourceProvider dataLoaderResourceProvider, String str3) {
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPreloadFooterSize = 0L;
        this.mStartTimestamp = 0L;
        this.mPriorityLevel = 0;
        this.mUseOriginalUrlEncode = -1;
        this.mUrls = null;
        this.mUrlExpireTimes = null;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mEnableHlsProxy = false;
        this.mCallBackListener = null;
        this.mHeaders = null;
        this.mProvider = dataLoaderResourceProvider;
        this.mVideoId = str2;
        this.mPreloadSize = j;
        this.mKey = str;
        this.mFilePath = str3;
    }

    public PreloaderURLItem(String str, String str2, long j, String[] strArr, String str3) {
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPreloadFooterSize = 0L;
        this.mStartTimestamp = 0L;
        this.mPriorityLevel = 0;
        this.mUseOriginalUrlEncode = -1;
        this.mUrlExpireTimes = null;
        this.mProvider = null;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mEnableHlsProxy = false;
        this.mCallBackListener = null;
        this.mHeaders = null;
        this.mKey = str;
        this.mVideoId = str2;
        this.mPreloadSize = j;
        this.mUrls = strArr;
        this.mFilePath = str3;
    }
}
