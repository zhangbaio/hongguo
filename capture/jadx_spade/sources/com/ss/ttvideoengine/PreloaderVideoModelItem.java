package com.ss.ttvideoengine;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.source.VideoModelSource;
import com.ss.ttvideoengine.utils.Error;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PreloaderVideoModelItem {
    public long mAudioHeaderExtraSize;
    public long mAudioPacketExtraOffset;
    private IPreLoaderItemCallBackListener mCallBackListener;
    public int mCdnType;
    private long mDashAudioPreloadSize;
    private long mDashVideoPreloadSize;
    private PreloaderFilePathListener mFilePathListener;
    public boolean mForbidP2p;
    private String mFormatType;
    public int mGearStrategyEnabled;
    public Map<String, Object> mGearStrategyExtraParams;
    private String mGroupId;
    private String mItemHash;
    public Map<Integer, String> mParams;
    private int mPlayIndexGap;
    public float mPreloadMilliSecond;
    public long mPreloadMilliSecondOffset;
    public long mPreloadSize;
    private int mPriorityLevel;
    public Resolution mResolution;
    public long mStartTimestamp;
    public String mSubTag;
    public String mTag;
    public long mTimePreloadLowerLimitSize;
    public long mTimePreloadUpperLimitSize;
    private int mUseOriginalUrlEncode;
    public long mVideoHeaderExtraSize;
    public IVideoModel mVideoModel;
    public long mVideoPacketExtraOffset;

    static {
        Covode.recordClassIndex(652310);
    }

    public IPreLoaderItemCallBackListener getCallBackListener() {
        return this.mCallBackListener;
    }

    public long getDashAudioPreloadSize() {
        return this.mDashAudioPreloadSize;
    }

    public long getDashVideoPreloadSize() {
        return this.mDashVideoPreloadSize;
    }

    PreloaderFilePathListener getFilePathListener() {
        return this.mFilePathListener;
    }

    public String getFormatType() {
        return this.mFormatType;
    }

    public String getGroupId() {
        return this.mGroupId;
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

    public int getUseOriginalUrlEncode() {
        return this.mUseOriginalUrlEncode;
    }

    public PreloaderVideoModelItem(VideoModelSource videoModelSource, long j) {
        this.mVideoModel = null;
        this.mResolution = Resolution.Undefine;
        this.mPreloadSize = 0L;
        this.mPreloadMilliSecond = 0.0f;
        this.mTimePreloadLowerLimitSize = 0L;
        this.mTimePreloadUpperLimitSize = 0L;
        this.mForbidP2p = false;
        this.mGearStrategyEnabled = 0;
        this.mParams = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPriorityLevel = 0;
        this.mStartTimestamp = 0L;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mUseOriginalUrlEncode = -1;
        this.mFilePathListener = null;
        this.mCallBackListener = null;
        this.mDashVideoPreloadSize = -1L;
        this.mDashAudioPreloadSize = -1L;
        throw new UnsupportedOperationException("toB only");
    }

    public PreloaderVideoModelItem(VideoModel videoModel, Resolution resolution, long j, boolean z) {
        this.mVideoModel = null;
        Resolution resolution2 = Resolution.Undefine;
        this.mPreloadMilliSecond = 0.0f;
        this.mTimePreloadLowerLimitSize = 0L;
        this.mTimePreloadUpperLimitSize = 0L;
        this.mGearStrategyEnabled = 0;
        this.mParams = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPriorityLevel = 0;
        this.mStartTimestamp = 0L;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mUseOriginalUrlEncode = -1;
        this.mFilePathListener = null;
        this.mCallBackListener = null;
        this.mDashVideoPreloadSize = -1L;
        this.mDashAudioPreloadSize = -1L;
        this.mVideoModel = videoModel;
        this.mResolution = resolution;
        this.mPreloadSize = j;
        this.mForbidP2p = z;
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

    public void setDashAudioPreloadSize(long j) {
        this.mDashAudioPreloadSize = j;
    }

    public void setDashVideoPreloadSize(long j) {
        this.mDashVideoPreloadSize = j;
    }

    public void setFilePathListener(PreloaderFilePathListener preloaderFilePathListener) {
        this.mFilePathListener = preloaderFilePathListener;
    }

    public void setFormatType(String str) {
        this.mFormatType = str;
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
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

    public void setUseOriginalUrlEncode(int i) {
        this.mUseOriginalUrlEncode = i;
    }

    public void setCdnType(int i) {
        throw new UnsupportedOperationException("tob only");
    }

    public void _notifyError(int i) {
        if (getCallBackListener() != null) {
            PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(3);
            preLoaderItemCallBackInfo.preloadError = new Error("kTTVideoErrorDomainDataLoaderPreload", i);
            getCallBackListener().preloadItemInfo(preLoaderItemCallBackInfo);
        }
    }

    public PreloaderVideoModelItem(IVideoModel iVideoModel, Resolution resolution, long j, PreloaderFilePathListener preloaderFilePathListener) {
        this.mVideoModel = null;
        Resolution resolution2 = Resolution.Undefine;
        this.mPreloadMilliSecond = 0.0f;
        this.mTimePreloadLowerLimitSize = 0L;
        this.mTimePreloadUpperLimitSize = 0L;
        this.mForbidP2p = false;
        this.mGearStrategyEnabled = 0;
        this.mParams = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPriorityLevel = 0;
        this.mStartTimestamp = 0L;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mUseOriginalUrlEncode = -1;
        this.mCallBackListener = null;
        this.mDashVideoPreloadSize = -1L;
        this.mDashAudioPreloadSize = -1L;
        this.mVideoModel = iVideoModel;
        this.mResolution = resolution;
        this.mPreloadSize = j;
        this.mFilePathListener = preloaderFilePathListener;
    }

    public PreloaderVideoModelItem(VideoModel videoModel, Resolution resolution, long j, PreloaderFilePathListener preloaderFilePathListener) {
        this.mVideoModel = null;
        Resolution resolution2 = Resolution.Undefine;
        this.mPreloadMilliSecond = 0.0f;
        this.mTimePreloadLowerLimitSize = 0L;
        this.mTimePreloadUpperLimitSize = 0L;
        this.mForbidP2p = false;
        this.mGearStrategyEnabled = 0;
        this.mParams = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPriorityLevel = 0;
        this.mStartTimestamp = 0L;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mUseOriginalUrlEncode = -1;
        this.mCallBackListener = null;
        this.mDashVideoPreloadSize = -1L;
        this.mDashAudioPreloadSize = -1L;
        this.mVideoModel = videoModel;
        this.mResolution = resolution;
        this.mPreloadSize = j;
        this.mFilePathListener = preloaderFilePathListener;
    }

    public PreloaderVideoModelItem(VideoModel videoModel, Resolution resolution, float f, long j, long j2) {
        this.mVideoModel = null;
        Resolution resolution2 = Resolution.Undefine;
        this.mPreloadSize = 0L;
        this.mForbidP2p = false;
        this.mGearStrategyEnabled = 0;
        this.mParams = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPriorityLevel = 0;
        this.mStartTimestamp = 0L;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mUseOriginalUrlEncode = -1;
        this.mFilePathListener = null;
        this.mCallBackListener = null;
        this.mDashVideoPreloadSize = -1L;
        this.mDashAudioPreloadSize = -1L;
        this.mVideoModel = videoModel;
        this.mResolution = resolution;
        this.mPreloadMilliSecond = f;
        this.mTimePreloadLowerLimitSize = j;
        this.mTimePreloadUpperLimitSize = j2;
    }

    public PreloaderVideoModelItem(VideoModel videoModel, Resolution resolution, long j, long j2, boolean z) {
        this.mVideoModel = null;
        Resolution resolution2 = Resolution.Undefine;
        this.mPreloadMilliSecond = 0.0f;
        this.mTimePreloadLowerLimitSize = 0L;
        this.mTimePreloadUpperLimitSize = 0L;
        this.mGearStrategyEnabled = 0;
        this.mParams = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPriorityLevel = 0;
        this.mStartTimestamp = 0L;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mUseOriginalUrlEncode = -1;
        this.mFilePathListener = null;
        this.mCallBackListener = null;
        this.mDashVideoPreloadSize = -1L;
        this.mDashAudioPreloadSize = -1L;
        this.mVideoModel = videoModel;
        this.mResolution = resolution;
        this.mPreloadSize = j;
        this.mPreloadMilliSecondOffset = j2;
        this.mForbidP2p = z;
    }

    public PreloaderVideoModelItem(VideoModel videoModel, Resolution resolution, long j, float f, long j2, long j3) {
        this.mVideoModel = null;
        Resolution resolution2 = Resolution.Undefine;
        this.mPreloadSize = 0L;
        this.mForbidP2p = false;
        this.mGearStrategyEnabled = 0;
        this.mParams = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPriorityLevel = 0;
        this.mStartTimestamp = 0L;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mUseOriginalUrlEncode = -1;
        this.mFilePathListener = null;
        this.mCallBackListener = null;
        this.mDashVideoPreloadSize = -1L;
        this.mDashAudioPreloadSize = -1L;
        this.mVideoModel = videoModel;
        this.mResolution = resolution;
        this.mPreloadMilliSecondOffset = j;
        this.mPreloadMilliSecond = f;
        this.mTimePreloadLowerLimitSize = j2;
        this.mTimePreloadUpperLimitSize = j3;
    }

    public PreloaderVideoModelItem(VideoModel videoModel, Resolution resolution, long j, long j2, long j3, boolean z) {
        this.mVideoModel = null;
        Resolution resolution2 = Resolution.Undefine;
        this.mTimePreloadLowerLimitSize = 0L;
        this.mTimePreloadUpperLimitSize = 0L;
        this.mGearStrategyEnabled = 0;
        this.mParams = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mPlayIndexGap = -1;
        this.mGroupId = "";
        this.mPriorityLevel = 0;
        this.mStartTimestamp = 0L;
        this.mItemHash = null;
        this.mFormatType = null;
        this.mUseOriginalUrlEncode = -1;
        this.mFilePathListener = null;
        this.mCallBackListener = null;
        this.mDashVideoPreloadSize = -1L;
        this.mDashAudioPreloadSize = -1L;
        this.mVideoModel = videoModel;
        this.mResolution = resolution;
        this.mPreloadSize = j;
        this.mPreloadMilliSecondOffset = j2;
        this.mPreloadMilliSecond = j3;
        this.mForbidP2p = z;
    }
}
