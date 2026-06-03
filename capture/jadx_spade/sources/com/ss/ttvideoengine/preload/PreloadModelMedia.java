package com.ss.ttvideoengine.preload;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.DubbedInfo;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.strategrycenter.ISelectBitrateCallback;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PreloadModelMedia extends PreloadMedia {
    public boolean isLast;
    private long mCDNUrlExpiredTime;
    private String mContext;
    private String mCustomPath;
    private long mDubbedAudioPreloadSize;
    private List<DubbedInfo> mDubbedAudios;
    private Map<String, String> mExtraInfo;
    private String mFirstSubVid;
    public boolean mForbidP2p;
    private String mGroupId;
    private boolean mIsEnablePreloadDubbedAudio;
    private Map<Resolution, Float> mMultipleInfo;
    private int mPriorityLevel;
    public Resolution mResolution;
    private ISelectBitrateCallback mSelectCallback;
    public long mStartTimestamp;
    private int mSubListIndex;
    private String mSubTag;
    private String mTag;
    public IVideoModel mVideoModel;

    static {
        Covode.recordClassIndex(652633);
    }

    public long getCDNUrlExpiredTime() {
        return this.mCDNUrlExpiredTime;
    }

    public String getContext() {
        return this.mContext;
    }

    public String getCustomPath() {
        return this.mCustomPath;
    }

    public long getDubbedAudioPreloadSize() {
        return this.mDubbedAudioPreloadSize;
    }

    public List<DubbedInfo> getDubbedAudios() {
        return this.mDubbedAudios;
    }

    public Map<String, String> getExtraInfo() {
        return this.mExtraInfo;
    }

    public String getFirstSubVid() {
        return this.mFirstSubVid;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public Map<Resolution, Float> getMultipleInfo() {
        return this.mMultipleInfo;
    }

    public int getPriorityLevel() {
        return this.mPriorityLevel;
    }

    public ISelectBitrateCallback getSelectCallback() {
        return this.mSelectCallback;
    }

    public long getStartTimestamp() {
        return this.mStartTimestamp;
    }

    public int getSubListIndex() {
        return this.mSubListIndex;
    }

    public String getSubTag() {
        return this.mSubTag;
    }

    public String getTag() {
        return this.mTag;
    }

    public boolean isEnablePreloadDubbedAudio() {
        return this.mIsEnablePreloadDubbedAudio;
    }

    @Override // com.ss.ttvideoengine.preload.PreloadMedia
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.mVideoModel);
    }

    public boolean isNeedConvertStrategyInfo() {
        if (getExtraInfo() == null && getSubListIndex() == -1 && getFirstSubVid() == null && this.mCDNUrlExpiredTime == 0 && this.mTag.length() <= 0 && this.mSubTag.length() <= 0 && getMultipleInfo() == null && this.mStartTimestamp <= 0) {
            return false;
        }
        return true;
    }

    public String toStrategyInfo() {
        JSONObject mediaInfo = this.mVideoModel.getMediaInfo();
        if (mediaInfo == null) {
            return "";
        }
        try {
            mediaInfo.put("sc_priority", this.mPriorityLevel);
            if (this.mExtraInfo != null) {
                mediaInfo.put("sc_extra", new JSONObject(getExtraInfo()));
            }
            String str = this.mCustomPath;
            if (str != null) {
                mediaInfo.put("sc_custom_path", str);
            }
            String str2 = this.mContext;
            if (str2 != null) {
                mediaInfo.put("sc_context", str2);
            }
            long j = this.mPreloadSize;
            if (j > 0) {
                mediaInfo.put("sc_preload_size", j);
            }
            String str3 = this.mFirstSubVid;
            if (str3 != null) {
                mediaInfo.put("sc_frt_sub_vid", str3);
            }
            int i = this.mSubListIndex;
            if (i != -1) {
                mediaInfo.put("sc_sub_list_index", i);
            }
            long j2 = this.mCDNUrlExpiredTime;
            if (j2 != 0) {
                mediaInfo.put("sc_url_expired_t", j2);
            }
            if (this.mTag.length() > 0) {
                mediaInfo.put("sc_tag", this.mTag);
            }
            if (this.mSubTag.length() > 0) {
                mediaInfo.put("sc_sub_tag", this.mSubTag);
            }
            if (this.mGroupId.length() > 0) {
                mediaInfo.put("sc_gid", this.mGroupId);
            }
            if (this.mDubbedAudios != null && this.mIsEnablePreloadDubbedAudio) {
                JSONArray jSONArray = new JSONArray();
                for (DubbedInfo dubbedInfo : this.mDubbedAudios) {
                    if (dubbedInfo.toStrategyPreloadJsonObject() != null) {
                        jSONArray.put(dubbedInfo.toStrategyPreloadJsonObject());
                    }
                }
                mediaInfo.put("sc_dubbed_audios", jSONArray);
                mediaInfo.put("sc_dubbed_preload", this.mIsEnablePreloadDubbedAudio);
                mediaInfo.put("sc_dubbed_size", this.mDubbedAudioPreloadSize);
            }
            if (this.mMultipleInfo != null) {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<Resolution, Float> entry : this.mMultipleInfo.entrySet()) {
                    jSONObject.put(entry.getKey().toString(VideoRef.TYPE_VIDEO), entry.getValue());
                }
                mediaInfo.put("sc_multiple_info", jSONObject);
            }
            long j3 = this.mStartTimestamp;
            if (j3 > 0) {
                mediaInfo.put("timestamp", j3);
            }
            return mediaInfo.toString();
        } catch (Throwable th) {
            TTVideoEngineLog.d(th);
            return "";
        }
    }

    public void setCDNUrlExpiredTime(long j) {
        this.mCDNUrlExpiredTime = j;
    }

    public void setContext(String str) {
        this.mContext = str;
    }

    public void setCustomPath(String str) {
        this.mCustomPath = str;
    }

    public void setDubbedAudioPreloadSize(long j) {
        this.mDubbedAudioPreloadSize = j;
    }

    public void setDubbedAudios(List<DubbedInfo> list) {
        this.mDubbedAudios = list;
    }

    public void setEnablePreloadDubbedAudio(boolean z) {
        this.mIsEnablePreloadDubbedAudio = z;
    }

    public void setExtraInfo(Map<String, String> map) {
        this.mExtraInfo = map;
    }

    public void setFirstSubVideoId(String str) {
        this.mFirstSubVid = str;
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
    }

    public void setMultipleInfo(Map<Resolution, Float> map) {
        this.mMultipleInfo = map;
    }

    public void setPriorityLevel(int i) {
        this.mPriorityLevel = i;
    }

    public void setSelectBitrateCallback(ISelectBitrateCallback iSelectBitrateCallback) {
        this.mSelectCallback = iSelectBitrateCallback;
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

    @Override // com.ss.ttvideoengine.preload.PreloadMedia
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreloadModelMedia) || !super.equals(obj)) {
            return false;
        }
        return Objects.equals(this.mVideoModel, ((PreloadModelMedia) obj).mVideoModel);
    }

    public PreloadModelMedia(IVideoModel iVideoModel) {
        this.mVideoModel = null;
        this.mResolution = Resolution.Undefine;
        this.mForbidP2p = false;
        this.mSelectCallback = null;
        this.mExtraInfo = null;
        this.mPriorityLevel = 0;
        this.mCustomPath = null;
        this.mContext = null;
        this.mFirstSubVid = null;
        this.mSubListIndex = -1;
        this.mCDNUrlExpiredTime = 0L;
        this.mDubbedAudios = null;
        this.mIsEnablePreloadDubbedAudio = false;
        this.mDubbedAudioPreloadSize = 0L;
        this.mMultipleInfo = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mGroupId = "";
        this.isLast = false;
        this.mStartTimestamp = 0L;
        this.mVideoModel = iVideoModel;
    }

    public void setFirstSubVideoId(String str, int i) {
        this.mFirstSubVid = str;
        this.mSubListIndex = i;
    }

    public PreloadModelMedia(IVideoModel iVideoModel, ISelectBitrateCallback iSelectBitrateCallback) {
        this.mVideoModel = null;
        this.mResolution = Resolution.Undefine;
        this.mForbidP2p = false;
        this.mExtraInfo = null;
        this.mPriorityLevel = 0;
        this.mCustomPath = null;
        this.mContext = null;
        this.mFirstSubVid = null;
        this.mSubListIndex = -1;
        this.mCDNUrlExpiredTime = 0L;
        this.mDubbedAudios = null;
        this.mIsEnablePreloadDubbedAudio = false;
        this.mDubbedAudioPreloadSize = 0L;
        this.mMultipleInfo = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mGroupId = "";
        this.isLast = false;
        this.mStartTimestamp = 0L;
        this.mVideoModel = iVideoModel;
        this.mSelectCallback = iSelectBitrateCallback;
    }

    public PreloadModelMedia(IVideoModel iVideoModel, Resolution resolution, long j, boolean z) {
        this.mVideoModel = null;
        Resolution resolution2 = Resolution.Undefine;
        this.mSelectCallback = null;
        this.mExtraInfo = null;
        this.mPriorityLevel = 0;
        this.mCustomPath = null;
        this.mContext = null;
        this.mFirstSubVid = null;
        this.mSubListIndex = -1;
        this.mCDNUrlExpiredTime = 0L;
        this.mDubbedAudios = null;
        this.mIsEnablePreloadDubbedAudio = false;
        this.mDubbedAudioPreloadSize = 0L;
        this.mMultipleInfo = null;
        this.mTag = "";
        this.mSubTag = "";
        this.mGroupId = "";
        this.isLast = false;
        this.mStartTimestamp = 0L;
        this.mVideoModel = iVideoModel;
        this.mResolution = resolution;
        this.mPreloadSize = j;
        this.mForbidP2p = z;
    }
}
