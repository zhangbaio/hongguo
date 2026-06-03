package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.EngineGlobalConfig;
import com.ss.ttvideoengine.ITTVideoEngineInternal;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoModelPb;
import com.ss.ttvideoengine.utils.TTHelper;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoInfo implements IVideoInfo {
    public boolean isAutoDefinition;
    private String mAIBarrageUrl;
    private String mAudioProfile;
    private int mAvgBitrate;
    public String mBackupUrl1;
    private String mBackupUrl1Ver2;
    public String mBackupUrl2;
    public String mBackupUrl3;
    public String mBackupUrlExpire;
    private String mBarrageMaskOffset;
    private String mBarrageMaskUrl;
    public int mBitrate;
    private MediaBitrateFitterInfo mBitrateFitterInfo;
    private int mBitrateVer2;
    private String mCheckInfo;
    public String mCodecType;
    private String mCodecTypeVer2;
    public String mDefinition;
    private String mDefinitionVer2;
    public String mDubVersion;
    private String mEncodeUserTag;
    public boolean mEncrypt;
    public String mFileHash;
    private String mFileHashVer2;
    private String mFileId;
    private String mFirstMoofRange;
    public int mGbr;
    private String mIndexRange;
    public int mInfoId;
    private String mInitRange;
    private String mKeyseed;
    private String mKid;
    public String mLanguageCode;
    public int mLanguageId;
    private String mLogoType;
    private String mLogoTypeVer2;
    public float mLoudness;
    private float mLuEnd;
    private float mLuRange;
    private float mLuStart;
    public String mMainUrl;
    public String mMainUrlExpire;
    private String mMainUrlVer2;
    private float mMaxMomLu;
    private float mMaxShortermLu;
    private int mMediaType;
    private String mP2pVerifyUrl;
    public HashMap<Double, Long> mPacketOffset;
    public float mPeak;
    protected JSONObject mPreloadGear;
    public String mQuality;
    private String mQualityDesc;
    private int mQualityType;
    private String mQualityVer2;
    public int mRealBitrate;
    private Resolution mResolution;
    private String mResolutionStr;
    private String mSegmentSizeInfo;
    public long mSize;
    private long mSizeVer2;
    private int mSocketBuffer;
    public String mSpadea;
    private String mSpadeaVer2;
    public String mStorePath;
    public String[] mURLExpires;
    public String[] mURLs;
    private String[] mURLsVer2;
    private String mUfqInfo;
    private long mUrlExpiredT;
    public int mVHeight;
    private int mVHeightVer2;
    public String mVType;
    private String mVTypeVer2;
    public int mVWidth;
    private int mVWidthVer2;
    private int mVersion = 1;
    public int mVideoDuration;
    private int mVolumInfoVer;
    private String mVolumeInfoJson;
    public int playLoadMaxStep;
    public int playLoadMinStep;
    private int preLoadIntervalVer2;
    private int preLoadMaxStepVer2;
    private int preLoadMinStepVer2;
    private int preLoadSizeVer2;
    public int preloadInterval;
    public int preloadSize;
    public int useVideoProxy;

    static {
        Covode.recordClassIndex(652551);
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public int fromMediaInfoJsonObject(JSONObject jSONObject) {
        return -1;
    }

    public void parseFromPb(VideoModelPb.Audio audio) {
    }

    public void parseFromPb(VideoModelPb.Video video) {
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public MediaBitrateFitterInfo getBitrateFitterInfo() {
        return this.mBitrateFitterInfo;
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public int getMediatype() {
        return this.mMediaType;
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public Resolution getResolution() {
        return this.mResolution;
    }

    public int getVersion() {
        return this.mVersion;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x03c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void extractFields(org.json.JSONObject r31) {
        /*
            Method dump skipped, instructions count: 3259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.model.VideoInfo.extractFields(org.json.JSONObject):void");
    }

    public int getPreloadInterval() {
        int i = this.mVersion;
        if (i != 2 && i != 4) {
            return this.preloadInterval;
        }
        return this.preLoadIntervalVer2;
    }

    public int getSocketBuffer() {
        int i = this.mVersion;
        if (i != 2 && i != 4) {
            return this.mSocketBuffer;
        }
        return 0;
    }

    public boolean isUseVideoProxy() {
        int i = this.mVersion;
        if (i == 2 || i == 4 || this.useVideoProxy != 1) {
            return false;
        }
        return true;
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public JSONObject toBashJsonObject() {
        String str;
        int valueInt;
        try {
            JSONObject jSONObject = new JSONObject();
            String[] valueStrArr = getValueStrArr(16);
            if (valueStrArr != null && valueStrArr.length > 0) {
                String valueStr = getValueStr(34);
                String valueStr2 = getValueStr(6);
                if (!TextUtils.isEmpty(valueStr2) && valueStr2.equals("mp4") && (valueInt = getValueInt(38)) > 0) {
                    valueStr = "0-" + (valueInt - 1);
                }
                jSONObject.put("main_url", valueStrArr[0]);
                if (valueStrArr.length > 1) {
                    str = valueStrArr[1];
                } else {
                    str = "";
                }
                jSONObject.put("backup_url_1", str);
                jSONObject.put("bitrate", getValueInt(3));
                jSONObject.put("vwidth", getValueInt(1));
                jSONObject.put("vheight", getValueInt(2));
                jSONObject.put("init_range", valueStr);
                jSONObject.put("index_range", getValueStr(35));
                jSONObject.put("first_moof_range", getValueStr(47));
                jSONObject.put("segment_size_info", getValueStr(53));
                jSONObject.put("check_info", getValueStr(31));
                jSONObject.put("kid", getValueStr(36));
                jSONObject.put("file_hash", TTHelper.encodeUrl(getValueStr(15)));
                jSONObject.put("loudness", getValueFloat(39));
                jSONObject.put("peak", getValueFloat(40));
                jSONObject.put("info_id", getValueInt(42));
                return jSONObject;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public VideoInfo copyInfo() {
        VideoInfo videoInfo = new VideoInfo(this.mKeyseed);
        videoInfo.mVersion = this.mVersion;
        videoInfo.mURLs = this.mURLs;
        videoInfo.mURLExpires = this.mURLExpires;
        videoInfo.mMainUrlExpire = this.mMainUrlExpire;
        videoInfo.mBackupUrlExpire = this.mBackupUrlExpire;
        videoInfo.mMainUrl = this.mMainUrl;
        videoInfo.mBackupUrl1 = this.mBackupUrl1;
        videoInfo.mBackupUrl2 = this.mBackupUrl2;
        videoInfo.mBackupUrl3 = this.mBackupUrl3;
        videoInfo.mVWidth = this.mVWidth;
        videoInfo.mVHeight = this.mVHeight;
        videoInfo.mEncrypt = this.mEncrypt;
        videoInfo.mSpadea = this.mSpadea;
        videoInfo.mGbr = this.mGbr;
        videoInfo.mStorePath = this.mStorePath;
        videoInfo.mVType = this.mVType;
        videoInfo.mCodecType = this.mCodecType;
        videoInfo.mFileHash = this.mFileHash;
        videoInfo.mDefinition = this.mDefinition;
        videoInfo.preloadSize = this.preloadSize;
        videoInfo.playLoadMinStep = this.playLoadMinStep;
        videoInfo.playLoadMaxStep = this.playLoadMaxStep;
        videoInfo.mSize = this.mSize;
        videoInfo.mVideoDuration = this.mVideoDuration;
        videoInfo.preloadInterval = this.preloadInterval;
        videoInfo.useVideoProxy = this.useVideoProxy;
        videoInfo.mSocketBuffer = this.mSocketBuffer;
        videoInfo.isAutoDefinition = this.isAutoDefinition;
        videoInfo.mQuality = this.mQuality;
        videoInfo.mLogoType = this.mLogoType;
        videoInfo.mFileHash = this.mFileHash;
        videoInfo.mCheckInfo = this.mCheckInfo;
        videoInfo.mInitRange = this.mInitRange;
        videoInfo.mIndexRange = this.mIndexRange;
        videoInfo.mFirstMoofRange = this.mFirstMoofRange;
        videoInfo.mSegmentSizeInfo = this.mSegmentSizeInfo;
        videoInfo.mEncodeUserTag = this.mEncodeUserTag;
        videoInfo.mAudioProfile = this.mAudioProfile;
        videoInfo.mKid = this.mKid;
        videoInfo.mQualityType = this.mQualityType;
        videoInfo.mBitrateFitterInfo = this.mBitrateFitterInfo;
        videoInfo.mURLsVer2 = this.mURLsVer2;
        videoInfo.mMainUrlVer2 = this.mMainUrlVer2;
        videoInfo.mVWidthVer2 = this.mVWidthVer2;
        videoInfo.mVHeightVer2 = this.mVHeightVer2;
        videoInfo.mSpadeaVer2 = this.mSpadeaVer2;
        videoInfo.mVTypeVer2 = this.mVTypeVer2;
        videoInfo.mCodecTypeVer2 = this.mCodecTypeVer2;
        videoInfo.mDefinitionVer2 = this.mDefinitionVer2;
        videoInfo.preLoadSizeVer2 = this.preLoadSizeVer2;
        videoInfo.preLoadMinStepVer2 = this.preLoadMinStepVer2;
        videoInfo.preLoadMaxStepVer2 = this.preLoadMaxStepVer2;
        videoInfo.mSizeVer2 = this.mSizeVer2;
        videoInfo.preLoadIntervalVer2 = this.preLoadIntervalVer2;
        videoInfo.mLogoTypeVer2 = this.mLogoTypeVer2;
        videoInfo.mFileId = this.mFileId;
        videoInfo.mP2pVerifyUrl = this.mP2pVerifyUrl;
        videoInfo.mMediaType = this.mMediaType;
        videoInfo.mFileHashVer2 = this.mFileHashVer2;
        videoInfo.mRealBitrate = this.mRealBitrate;
        videoInfo.mInfoId = this.mInfoId;
        videoInfo.mBitrate = this.mBitrate;
        videoInfo.mQualityVer2 = this.mQualityVer2;
        videoInfo.mBackupUrl1Ver2 = this.mBackupUrl1Ver2;
        videoInfo.mBitrateVer2 = this.mBitrateVer2;
        videoInfo.mAvgBitrate = this.mAvgBitrate;
        return videoInfo;
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
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
        if (1 == EngineGlobalConfig.getInstance().getEnableUseRealBitrate()) {
            if (getValueInt(44) > 0) {
                hashMap.put("bitrate", Integer.valueOf(getValueInt(44)));
            } else {
                hashMap.put("bitrate", Integer.valueOf(getValueInt(3)));
            }
        } else {
            hashMap.put("bitrate", Integer.valueOf(getValueInt(3)));
        }
        hashMap.put("real_bitrate", Integer.valueOf(getValueInt(44)));
        hashMap.put("avg_bitrate", Integer.valueOf(getValueInt(52)));
        hashMap.put("quality", getValueStr(18));
        hashMap.put("definition", getValueStr(7));
        hashMap.put("video_resolution", getValueStr(48));
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
        hashMap.put("header_size", Integer.valueOf(getValueInt(38)));
        hashMap.put("quality_desc", getValueStr(32));
        hashMap.put("first_moof_range", getValueStr(47));
        hashMap.put("segment_size_info", getValueStr(53));
        JSONObject jSONObject = this.mPreloadGear;
        if (jSONObject != null) {
            hashMap.put("preload_gear_data", jSONObject);
        }
        String valueStr = getValueStr(29);
        if (valueStr == null) {
            valueStr = "";
        }
        hashMap.put("p2p_crc", TTHelper.encodeUrl(valueStr));
        return hashMap;
    }

    public void setMediaType(int i) {
        this.mMediaType = i;
    }

    public void setResolution(Resolution resolution) {
        this.mResolution = resolution;
    }

    public void setVersion(int i) {
        this.mVersion = i;
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public boolean getValueBool(int i) {
        if (i != 4) {
            return false;
        }
        int i2 = this.mVersion;
        if (i2 != 1 && i2 != 3) {
            return false;
        }
        return this.mEncrypt;
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public long getValueLong(int i) {
        if (this.mVersion == 2) {
            if (i != 12) {
                return -1L;
            }
            return this.mSizeVer2;
        }
        if (i != 12) {
            if (i != 30) {
                return -1L;
            }
            return this.mUrlExpiredT;
        }
        return this.mSize;
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public String[] getValueStrArr(int i) {
        if (this.mVersion == 2) {
            if (i != 16) {
                return new String[0];
            }
            return this.mURLsVer2;
        }
        if (i != 16) {
            if (i != 51) {
                return new String[0];
            }
            return this.mURLExpires;
        }
        return this.mURLs;
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public float getValueFloat(int i) {
        if (i != 39) {
            if (i != 40) {
                if (i != 252) {
                    switch (i) {
                        case 247:
                            return this.mLuStart;
                        case 248:
                            return this.mLuEnd;
                        case 249:
                            return this.mMaxMomLu;
                        case 250:
                            return this.mMaxShortermLu;
                        default:
                            return 0.0f;
                    }
                }
                return this.mLuRange;
            }
            return this.mPeak;
        }
        return this.mLoudness;
    }

    public VideoInfo(String str) {
        Resolution resolution = Resolution.Standard;
        this.mResolution = resolution;
        this.mResolutionStr = resolution.toString(VideoRef.TYPE_VIDEO);
        this.mFileId = null;
        this.mP2pVerifyUrl = null;
        this.mUrlExpiredT = 0L;
        this.mEncrypt = false;
        this.mSpadea = null;
        this.mSize = 0L;
        this.mVideoDuration = 0;
        this.preloadInterval = 0;
        this.useVideoProxy = 1;
        this.mSocketBuffer = 0;
        this.isAutoDefinition = false;
        this.mMediaType = 0;
        this.mPreloadGear = null;
        this.mUfqInfo = "";
        this.mLoudness = 0.0f;
        this.mPeak = 0.0f;
        this.mLuRange = 0.0f;
        this.mLuStart = 0.0f;
        this.mLuEnd = 0.0f;
        this.mMaxMomLu = 0.0f;
        this.mMaxShortermLu = 0.0f;
        this.mVolumInfoVer = 0;
        this.mVolumeInfoJson = "";
        this.mQualityType = 0;
        this.mInfoId = -1;
        this.mLanguageId = -1;
        this.mLanguageCode = "";
        this.mDubVersion = "";
        this.mURLsVer2 = null;
        this.mSpadeaVer2 = null;
        this.mCodecTypeVer2 = null;
        this.preLoadIntervalVer2 = 0;
        this.mSizeVer2 = 0L;
        this.mLogoTypeVer2 = null;
        this.mQualityVer2 = null;
        this.mBackupUrl1Ver2 = null;
        this.mEncodeUserTag = null;
        this.mAudioProfile = null;
        this.mQualityDesc = null;
        this.mBarrageMaskOffset = null;
        this.mBitrateFitterInfo = null;
        this.mMainUrlExpire = "";
        this.mBackupUrlExpire = "";
        this.mURLExpires = null;
        this.mKeyseed = str;
    }

    private void externalizablePallasLabels(String str) {
        String optString;
        if (str != null && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("preloadsize") && (optString = jSONObject.optString("preloadsize")) != null && !TextUtils.isEmpty(optString)) {
                    this.mPreloadGear = new JSONObject(optString);
                }
                if (jSONObject.has("ufq")) {
                    String optString2 = jSONObject.optString("ufq");
                    if (!TextUtils.isEmpty(optString2)) {
                        this.mUfqInfo = optString2;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void setResolutionBaseMap(HashMap<String, Resolution> hashMap) {
        String str;
        if (hashMap != null && hashMap.size() > 0) {
            int i = this.mMediaType;
            if (i == VideoRef.TYPE_AUDIO) {
                str = getValueStr(18);
                if (TextUtils.isEmpty(str)) {
                    str = Resolution.Standard.toString(this.mMediaType);
                }
            } else if (i == VideoRef.TYPE_VIDEO) {
                str = getValueStr(7);
                if (TextUtils.isEmpty(str)) {
                    str = Resolution.Standard.toString(this.mMediaType);
                }
            } else {
                str = null;
            }
            Resolution resolution = hashMap.get(str);
            this.mResolution = resolution;
            if (resolution == null) {
                this.mResolution = Resolution.Standard;
            }
        }
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public int getValueInt(int i) {
        if (i == 38) {
            MediaBitrateFitterInfo mediaBitrateFitterInfo = this.mBitrateFitterInfo;
            if (mediaBitrateFitterInfo != null) {
                return mediaBitrateFitterInfo.getHeaderSize();
            }
            return 0;
        }
        if (this.mVersion == 2) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 13) {
                            if (i != 44) {
                                if (i != 52) {
                                    if (i != 251) {
                                        if (i != 41) {
                                            if (i != 42) {
                                                switch (i) {
                                                    case 9:
                                                        return this.preLoadSizeVer2;
                                                    case 10:
                                                        return this.preLoadMinStepVer2;
                                                    case 11:
                                                        return this.preLoadMaxStepVer2;
                                                    default:
                                                        return -1;
                                                }
                                            }
                                            return this.mInfoId;
                                        }
                                        return this.mQualityType;
                                    }
                                    return this.mVolumInfoVer;
                                }
                                return this.mAvgBitrate;
                            }
                            return this.mRealBitrate;
                        }
                        return this.preLoadIntervalVer2;
                    }
                    return this.mBitrateVer2;
                }
                return this.mVHeightVer2;
            }
            return this.mVWidthVer2;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 13) {
                        if (i != 27) {
                            if (i != 44) {
                                if (i != 52) {
                                    if (i != 251) {
                                        if (i != 41) {
                                            if (i != 42) {
                                                switch (i) {
                                                    case 9:
                                                        return this.preloadSize;
                                                    case 10:
                                                        return this.playLoadMinStep;
                                                    case 11:
                                                        return this.playLoadMaxStep;
                                                    default:
                                                        switch (i) {
                                                            case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                                                                return this.mGbr;
                                                            case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                                                                return this.useVideoProxy;
                                                            case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                                                                return this.mSocketBuffer;
                                                            default:
                                                                return -1;
                                                        }
                                                }
                                            }
                                            return this.mInfoId;
                                        }
                                        return this.mQualityType;
                                    }
                                    return this.mVolumInfoVer;
                                }
                                return this.mAvgBitrate;
                            }
                            return this.mRealBitrate;
                        }
                        return this.mVideoDuration;
                    }
                    return this.preloadInterval;
                }
                return this.mBitrate;
            }
            return this.mVHeight;
        }
        return this.mVWidth;
    }

    @Override // com.ss.ttvideoengine.model.IVideoInfo
    public String getValueStr(int i) {
        if (i != 26) {
            if (i != 31) {
                if (i != 42) {
                    if (i != 260) {
                        if (i != 28) {
                            if (i != 29) {
                                if (i != 47) {
                                    if (i != 48) {
                                        switch (i) {
                                            case ConstantsAPI.COMMAND_FINDER_OPEN_PROFILE /* 34 */:
                                                return this.mInitRange;
                                            case ConstantsAPI.COMMAND_FINDER_OPEN_LIVE /* 35 */:
                                                return this.mIndexRange;
                                            case ConstantsAPI.COMMAND_FINDER_OPEN_FEED /* 36 */:
                                                return this.mKid;
                                            default:
                                                switch (i) {
                                                    case ITTVideoEngineInternal.PLAYER_OPTION_GET_WATCHED_DUTATION /* 53 */:
                                                        return this.mSegmentSizeInfo;
                                                    case 54:
                                                        return this.mEncodeUserTag;
                                                    case 55:
                                                        return this.mAudioProfile;
                                                    case 56:
                                                        return this.mUfqInfo;
                                                    default:
                                                        if (this.mVersion == 2) {
                                                            if (i != 0) {
                                                                if (i != 15) {
                                                                    if (i != 5) {
                                                                        if (i != 6) {
                                                                            if (i != 7) {
                                                                                if (i != 8) {
                                                                                    switch (i) {
                                                                                        case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                                                                                            return this.mBackupUrl1Ver2;
                                                                                        case 18:
                                                                                            return this.mQualityVer2;
                                                                                        case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                                                                                            return this.mLogoTypeVer2;
                                                                                        default:
                                                                                            return "";
                                                                                    }
                                                                                }
                                                                                return this.mCodecTypeVer2;
                                                                            }
                                                                            return this.mDefinitionVer2;
                                                                        }
                                                                        return this.mVTypeVer2;
                                                                    }
                                                                    return this.mSpadeaVer2;
                                                                }
                                                                return this.mFileHashVer2;
                                                            }
                                                            return this.mMainUrlVer2;
                                                        }
                                                        if (i != 0) {
                                                            if (i != 15) {
                                                                if (i != 37) {
                                                                    if (i != 43) {
                                                                        if (i != 5) {
                                                                            if (i != 6) {
                                                                                if (i != 7) {
                                                                                    if (i != 8) {
                                                                                        if (i != 32) {
                                                                                            if (i != 33) {
                                                                                                if (i != 49) {
                                                                                                    if (i != 50) {
                                                                                                        switch (i) {
                                                                                                            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                                                                                                                return this.mBackupUrl1;
                                                                                                            case 18:
                                                                                                                return this.mQuality;
                                                                                                            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                                                                                                                return this.mLogoType;
                                                                                                            default:
                                                                                                                switch (i) {
                                                                                                                    case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                                                                                                                        return this.mBackupUrl2;
                                                                                                                    case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                                                                                                                        return this.mBackupUrl3;
                                                                                                                    case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                                                                                                                        return this.mStorePath;
                                                                                                                    default:
                                                                                                                        return "";
                                                                                                                }
                                                                                                        }
                                                                                                    }
                                                                                                    return this.mBackupUrlExpire;
                                                                                                }
                                                                                                return this.mMainUrlExpire;
                                                                                            }
                                                                                            return this.mBarrageMaskOffset;
                                                                                        }
                                                                                        return this.mQualityDesc;
                                                                                    }
                                                                                    return this.mCodecType;
                                                                                }
                                                                                return this.mDefinition;
                                                                            }
                                                                            return this.mVType;
                                                                        }
                                                                        return this.mSpadea;
                                                                    }
                                                                    return this.mAIBarrageUrl;
                                                                }
                                                                return this.mBarrageMaskUrl;
                                                            }
                                                            return this.mFileHash;
                                                        }
                                                        return this.mMainUrl;
                                                }
                                        }
                                    }
                                    return this.mResolution.toString(VideoRef.TYPE_VIDEO);
                                }
                                return this.mFirstMoofRange;
                            }
                            return this.mP2pVerifyUrl;
                        }
                        return this.mFileId;
                    }
                    return this.mVolumeInfoJson;
                }
                return "" + this.mInfoId;
            }
            return this.mCheckInfo;
        }
        return this.mResolutionStr;
    }

    public void setValue(int i, boolean z) {
        if (i != 4) {
            return;
        }
        this.mEncrypt = z;
    }

    public void setValue(int i, float f) {
        if (i != 39) {
            if (i != 40) {
                return;
            }
            this.mPeak = f;
            return;
        }
        this.mLoudness = f;
    }

    public void setValue(int i, long j) {
        if (i != 12) {
            return;
        }
        this.mSize = j;
        this.mSizeVer2 = j;
    }

    public void setValue(int i, String[] strArr) {
        if (i != 16) {
            return;
        }
        this.mURLs = strArr;
        this.mURLsVer2 = strArr;
    }

    public void setValue(int i, int i2) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 13) {
                        if (i != 27) {
                            switch (i) {
                                case 9:
                                    this.preloadSize = i2;
                                    this.preLoadSizeVer2 = i2;
                                    break;
                                case 10:
                                    this.playLoadMinStep = i2;
                                    break;
                                case 11:
                                    this.playLoadMaxStep = i2;
                                    break;
                                default:
                                    switch (i) {
                                        case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                                            this.mGbr = i2;
                                            break;
                                        case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                                            this.useVideoProxy = i2;
                                            break;
                                        case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                                            this.mSocketBuffer = i2;
                                            break;
                                    }
                            }
                            return;
                        }
                        this.mVideoDuration = i2;
                        return;
                    }
                    this.preloadInterval = i2;
                    this.preLoadIntervalVer2 = i2;
                    return;
                }
                this.mBitrate = i2;
                this.mBitrateVer2 = i2;
                return;
            }
            this.mVHeight = i2;
            this.mVHeightVer2 = i2;
            return;
        }
        this.mVWidth = i2;
        this.mVWidthVer2 = i2;
    }

    public void setValue(int i, String str) {
        if (i != 0) {
            if (i != 15) {
                if (i != 5) {
                    if (i != 6) {
                        if (i != 7) {
                            if (i != 8) {
                                if (i != 49) {
                                    if (i != 50) {
                                        switch (i) {
                                            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                                                this.mBackupUrl1Ver2 = str;
                                                this.mBackupUrl1 = str;
                                                break;
                                            case 18:
                                                this.mQualityVer2 = str;
                                                this.mQuality = str;
                                                break;
                                            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                                                this.mLogoTypeVer2 = str;
                                                this.mLogoType = str;
                                                break;
                                            default:
                                                switch (i) {
                                                    case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                                                        this.mBackupUrl2 = str;
                                                        break;
                                                    case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                                                        this.mBackupUrl3 = str;
                                                        break;
                                                    case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                                                        this.mStorePath = str;
                                                        break;
                                                    case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                                                        this.mResolutionStr = str;
                                                        break;
                                                }
                                        }
                                        return;
                                    }
                                    this.mBackupUrlExpire = str;
                                    return;
                                }
                                this.mMainUrlExpire = str;
                                return;
                            }
                            this.mCodecTypeVer2 = str;
                            this.mCodecType = str;
                            return;
                        }
                        this.mDefinitionVer2 = str;
                        this.mDefinition = str;
                        return;
                    }
                    this.mVTypeVer2 = str;
                    this.mVType = str;
                    return;
                }
                this.mSpadeaVer2 = str;
                this.mSpadea = str;
                return;
            }
            this.mFileHashVer2 = str;
            this.mFileHash = str;
            return;
        }
        this.mMainUrlVer2 = str;
        this.mMainUrl = str;
    }
}
