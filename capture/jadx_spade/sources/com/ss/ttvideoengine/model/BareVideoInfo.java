package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BareVideoInfo extends VideoInfo {
    private List<BareGearInfo> mBareGearInfo;
    private long mBitrate;
    private Builder mBuilder;
    private String mCheckInfo;
    private String mCodecType;
    private long mDuration;
    private long mExpire;
    private String mFileHash;
    private String mFileId;
    private String mFormat;
    private String mGear;
    private int mMediaType;
    private String mQuality;
    private String mQualityDesc;
    private Resolution mResolution;
    private String mSegmentSizeInfo;
    private long mSize;
    private String mSpadea;
    private List<String> mUrlExpires;
    private List<String> mUrls;
    private int mVHeight;
    private int mVWidth;

    static {
        Covode.recordClassIndex(652525);
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public MediaBitrateFitterInfo getBitrateFitterInfo() {
        return null;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public boolean getValueBool(int i) {
        return false;
    }

    public enum GearType {
        Frame(0),
        TimeInSecond(1);

        private int gearType;

        public int getGearType() {
            return this.gearType;
        }

        static {
            Covode.recordClassIndex(652528);
        }

        public void setGearType(int i) {
            this.gearType = i;
        }

        GearType(int i) {
            this.gearType = i;
        }
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public int getMediatype() {
        return this.mMediaType;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public Resolution getResolution() {
        return this.mResolution;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public JSONObject toBashJsonObject() {
        return super.toBashJsonObject();
    }

    private BareVideoInfo() {
        super(null);
        this.mMediaType = -1;
        this.mVWidth = 0;
        this.mVHeight = 0;
        this.mBitrate = 0L;
        this.mDuration = 0L;
        this.mSize = 0L;
        this.mExpire = -1L;
        this.mFileHash = null;
        this.mFileId = null;
        this.mCodecType = null;
        this.mFormat = null;
        this.mCheckInfo = null;
        this.mResolution = null;
        this.mQuality = null;
        this.mGear = null;
        this.mSpadea = null;
        this.mQualityDesc = null;
        this.mSegmentSizeInfo = null;
        this.mUrls = null;
        this.mUrlExpires = null;
        this.mBareGearInfo = null;
    }

    public static class Builder {
        private int mMediaType = 0;
        private int mVWidth = 0;
        private int mVHeight = 0;
        private long mBitrate = 0;
        private long mDuration = 0;
        private long mSize = 0;
        private long mExpire = -1;
        private String mFileHash = null;
        private String mFileId = null;
        private String mCodecType = null;
        private String mFormat = null;
        private String mCheckInfo = null;
        private Resolution mResolution = null;
        private String mQuality = null;
        private String mQualityDesc = null;
        private String mGear = null;
        private String mSpadea = null;
        private String mSegmentSizeInfo = null;
        private List<String> mUrls = null;
        private List<String> mUrlExpires = null;
        private List<BareGearInfo> mBareGearInfo = null;

        static {
            Covode.recordClassIndex(652527);
        }

        public BareVideoInfo build() {
            BareVideoInfo bareVideoInfo = new BareVideoInfo();
            bareVideoInfo.mMediaType = this.mMediaType;
            bareVideoInfo.mVWidth = this.mVWidth;
            bareVideoInfo.mVHeight = this.mVHeight;
            bareVideoInfo.mBitrate = this.mBitrate;
            bareVideoInfo.mDuration = this.mDuration;
            bareVideoInfo.mSize = this.mSize;
            bareVideoInfo.mExpire = this.mExpire;
            bareVideoInfo.mFileHash = this.mFileHash;
            bareVideoInfo.mFileId = this.mFileId;
            bareVideoInfo.mCodecType = this.mCodecType;
            bareVideoInfo.mFormat = this.mFormat;
            bareVideoInfo.mCheckInfo = this.mCheckInfo;
            bareVideoInfo.mResolution = this.mResolution;
            bareVideoInfo.mQuality = this.mQuality;
            bareVideoInfo.mQualityDesc = this.mQualityDesc;
            bareVideoInfo.mGear = this.mGear;
            bareVideoInfo.mSpadea = this.mSpadea;
            bareVideoInfo.mUrls = this.mUrls;
            bareVideoInfo.mUrlExpires = this.mUrlExpires;
            bareVideoInfo.mBareGearInfo = this.mBareGearInfo;
            bareVideoInfo.mSegmentSizeInfo = this.mSegmentSizeInfo;
            bareVideoInfo.mBuilder = this;
            return bareVideoInfo;
        }

        public Builder bitrate(long j) {
            this.mBitrate = j;
            return this;
        }

        public Builder checkInfo(String str) {
            this.mCheckInfo = str;
            return this;
        }

        public Builder codecType(String str) {
            this.mCodecType = str;
            return this;
        }

        public Builder duration(long j) {
            this.mDuration = j;
            return this;
        }

        public Builder expire(long j) {
            this.mExpire = j;
            return this;
        }

        public Builder fileHash(String str) {
            this.mFileHash = str;
            return this;
        }

        public Builder fileId(String str) {
            this.mFileId = str;
            return this;
        }

        public Builder format(String str) {
            this.mFormat = str;
            return this;
        }

        public Builder gear(String str) {
            this.mGear = str;
            return this;
        }

        public Builder mediaType(int i) {
            this.mMediaType = i;
            return this;
        }

        public Builder quality(String str) {
            this.mQuality = str;
            return this;
        }

        public Builder qualityDesc(String str) {
            this.mQualityDesc = str;
            return this;
        }

        public Builder resolution(Resolution resolution) {
            this.mResolution = resolution;
            return this;
        }

        public Builder segmentSizeInfo(String str) {
            this.mSegmentSizeInfo = str;
            return this;
        }

        public Builder size(long j) {
            this.mSize = j;
            return this;
        }

        public Builder spadea(String str) {
            this.mSpadea = str;
            return this;
        }

        public Builder urlExpires(List<String> list) {
            this.mUrlExpires = list;
            return this;
        }

        public Builder urls(List<String> list) {
            this.mUrls = list;
            return this;
        }

        public Builder vHeight(int i) {
            this.mVHeight = i;
            return this;
        }

        public Builder vWidth(int i) {
            this.mVWidth = i;
            return this;
        }

        public Builder addUrl(String str) {
            if (this.mUrls == null) {
                this.mUrls = new ArrayList();
            }
            this.mUrls.add(str);
            return this;
        }

        public Builder addUrlExpire(String str) {
            if (this.mUrlExpires == null) {
                this.mUrlExpires = new ArrayList();
            }
            this.mUrlExpires.add(str);
            return this;
        }

        public Builder gearInfo(GearType gearType, int i, int i2) {
            if (this.mBareGearInfo == null) {
                this.mBareGearInfo = new ArrayList();
            }
            this.mBareGearInfo.add(new BareGearInfo(gearType, i, i2));
            return this;
        }
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo
    public BareVideoInfo copyInfo() {
        BareVideoInfo bareVideoInfo = new BareVideoInfo();
        bareVideoInfo.mUrls = new ArrayList(this.mUrls);
        bareVideoInfo.mUrlExpires = new ArrayList(this.mUrlExpires);
        bareVideoInfo.mMainUrl = this.mMainUrl;
        bareVideoInfo.mMainUrlExpire = this.mMainUrlExpire;
        bareVideoInfo.mBackupUrlExpire = this.mBackupUrlExpire;
        bareVideoInfo.mBackupUrl1 = this.mBackupUrl1;
        bareVideoInfo.mBackupUrl2 = this.mBackupUrl2;
        bareVideoInfo.mBackupUrl3 = this.mBackupUrl3;
        bareVideoInfo.mVWidth = this.mVWidth;
        bareVideoInfo.mVHeight = this.mVHeight;
        bareVideoInfo.mEncrypt = this.mEncrypt;
        bareVideoInfo.mSpadea = this.mSpadea;
        bareVideoInfo.mGbr = this.mGbr;
        bareVideoInfo.mStorePath = this.mStorePath;
        bareVideoInfo.mVType = this.mVType;
        bareVideoInfo.mCodecType = this.mCodecType;
        bareVideoInfo.mFileHash = this.mFileHash;
        bareVideoInfo.mDefinition = this.mDefinition;
        bareVideoInfo.preloadSize = this.preloadSize;
        bareVideoInfo.playLoadMinStep = this.playLoadMinStep;
        bareVideoInfo.playLoadMaxStep = this.playLoadMaxStep;
        bareVideoInfo.mSize = this.mSize;
        bareVideoInfo.mVideoDuration = this.mVideoDuration;
        bareVideoInfo.preloadInterval = this.preloadInterval;
        bareVideoInfo.useVideoProxy = this.useVideoProxy;
        bareVideoInfo.isAutoDefinition = this.isAutoDefinition;
        bareVideoInfo.mQuality = this.mQuality;
        bareVideoInfo.mFileHash = this.mFileHash;
        bareVideoInfo.mCheckInfo = this.mCheckInfo;
        bareVideoInfo.mFileId = this.mFileId;
        bareVideoInfo.mMediaType = this.mMediaType;
        bareVideoInfo.mRealBitrate = this.mRealBitrate;
        bareVideoInfo.mInfoId = this.mInfoId;
        bareVideoInfo.mBitrate = this.mBitrate;
        bareVideoInfo.mSegmentSizeInfo = this.mSegmentSizeInfo;
        return bareVideoInfo;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public Map<String, Object> toMediaInfo() {
        String str;
        int i;
        HashMap hashMap = new HashMap();
        hashMap.put("file_id", getValueStr(28));
        if (getMediatype() == VideoRef.TYPE_VIDEO) {
            str = "video";
        } else {
            str = "audio";
        }
        hashMap.put("media_type", str);
        hashMap.put("file_size", Long.valueOf(getValueLong(12)));
        hashMap.put("bitrate", Integer.valueOf(getValueInt(3)));
        hashMap.put("quality", getValueStr(18));
        hashMap.put("definition", getValueStr(7));
        Resolution resolution = this.mResolution;
        if (resolution != null) {
            i = resolution.getIndex();
        } else {
            i = 0;
        }
        hashMap.put("resolution", Integer.valueOf(i));
        hashMap.put("width", Integer.valueOf(getValueInt(1)));
        hashMap.put("height", Integer.valueOf(getValueInt(2)));
        hashMap.put("codec", getValueStr(8));
        hashMap.put("urls", getValueStrArr(16));
        hashMap.put("file_hash", getValueStr(15));
        hashMap.put("segment_size_info", getValueStr(53));
        JSONObject jSONObject = this.mPreloadGear;
        if (jSONObject != null) {
            hashMap.put("preload_gear_data", jSONObject);
        }
        if (this.mBareGearInfo != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (BareGearInfo bareGearInfo : this.mBareGearInfo) {
                    GearType gearType = bareGearInfo.mGearType;
                    if (gearType == GearType.Frame) {
                        jSONObject2.put("g_" + bareGearInfo.key, bareGearInfo.value);
                    } else if (gearType == GearType.TimeInSecond) {
                        jSONObject2.put("t_" + bareGearInfo.key, bareGearInfo.value);
                    }
                }
                hashMap.put("preload_gear_data", jSONObject2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public int getValueInt(int i) {
        long j;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 27) {
                        return 0;
                    }
                    j = this.mDuration;
                } else {
                    j = this.mBitrate;
                }
                return (int) j;
            }
            return this.mVHeight;
        }
        return this.mVWidth;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public long getValueLong(int i) {
        if (i != 12) {
            if (i != 30) {
                return 0L;
            }
            return this.mExpire;
        }
        return this.mSize;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public String[] getValueStrArr(int i) {
        if (i != 16) {
            if (i != 51) {
                return new String[0];
            }
            List<String> list = this.mUrlExpires;
            if (list != null) {
                return (String[]) list.toArray(new String[0]);
            }
            return new String[0];
        }
        List<String> list2 = this.mUrls;
        if (list2 != null) {
            return (String[]) list2.toArray(new String[0]);
        }
        return new String[0];
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public String getValueStr(int i) {
        if (i != 5) {
            if (i != 6) {
                if (i != 7) {
                    if (i != 8) {
                        if (i != 15) {
                            if (i != 18) {
                                if (i != 28) {
                                    if (i != 53) {
                                        if (i != 31) {
                                            if (i != 32) {
                                                return null;
                                            }
                                            return this.mQualityDesc;
                                        }
                                        return this.mCheckInfo;
                                    }
                                    return this.mSegmentSizeInfo;
                                }
                                return this.mFileId;
                            }
                            return this.mQuality;
                        }
                        return this.mFileHash;
                    }
                    return this.mCodecType;
                }
                return this.mGear;
            }
            return this.mFormat;
        }
        return this.mSpadea;
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo, com.ss.ttvideoengine.model.IVideoInfo
    public int fromMediaInfoJsonObject(JSONObject jSONObject) {
        int i;
        try {
            this.mFileId = jSONObject.optString("file_id");
            if (jSONObject.optString("media_type").compareTo("audio") == 0) {
                i = VideoRef.TYPE_AUDIO;
            } else {
                i = VideoRef.TYPE_VIDEO;
            }
            this.mMediaType = i;
            this.mSize = jSONObject.optLong("file_size");
            this.mBitrate = jSONObject.optInt("bitrate");
            this.mQuality = jSONObject.optString("quality");
            this.mDefinition = jSONObject.optString("definition");
            this.mResolution = Resolution.valueOf(jSONObject.optInt("resolution", 0));
            this.mVWidth = jSONObject.optInt("width");
            this.mVHeight = jSONObject.optInt("height");
            this.mCodecType = jSONObject.optString("codec");
            JSONArray jSONArray = jSONObject.getJSONArray("urls");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                if (!TextUtils.isEmpty(string)) {
                    if (this.mUrls == null) {
                        this.mUrls = new ArrayList();
                    }
                    this.mUrls.add(string);
                }
            }
            this.mFileHash = jSONObject.optString("file_hash");
            this.mSegmentSizeInfo = jSONObject.optString("segment_size_info");
            return 0;
        } catch (Exception e) {
            TTVideoEngineLog.i("TTVideoEngine.BareVideoInfo", "[GearStrategy]fromMediaInfoJsonObject exception=" + e);
            return -1;
        }
    }

    @Override // com.ss.ttvideoengine.model.VideoInfo
    public void setValue(int i, String[] strArr) {
        if (i != 16) {
            if (i != 51) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            this.mUrlExpires = arrayList;
            Collections.addAll(arrayList, strArr);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        this.mUrls = arrayList2;
        Collections.addAll(arrayList2, strArr);
    }

    public static class BareGearInfo {
        public int key;
        public GearType mGearType;
        public int value;

        static {
            Covode.recordClassIndex(652526);
        }

        BareGearInfo(GearType gearType, int i, int i2) {
            this.mGearType = gearType;
            this.key = i;
            this.value = i2;
        }
    }
}
