package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoModelPb;
import com.ss.ttvideoengine.utils.TTHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoRef {
    public static int TYPE_AUDIO;
    public static int TYPE_VIDEO;
    private String mAIBarrageUrl;
    private VideoAdaptiveInfo mAdaptiveInfo;
    private VideoAdaptiveInfo mAdaptiveInfoVer2;
    private String[] mAllQualityInfos;
    private Resolution[] mAllResolutions;
    public String mAutoDefinition;
    public String mBackupURL;
    private String mBarrageMaskUrl;
    private String mBid;
    private int mCategory;
    public String mDecodingMode;
    private JSONObject mDnsInfo;
    private Map<String, VideoModelPb.DNS> mDnsInfoVer3;
    private long mDnsTime;
    public List<VideoInfo> mDubbedAudioInfo;
    public List<VideoInfo> mDynamicVideoList;
    public boolean mEnableAdaptive;
    public boolean mEnableSSL;
    public String mFallbackApi;
    private String mFirstSubVid;
    public String mFullScreen;
    public String mKeyseed;
    public String mLabelUsage;
    public float mLoudness;
    private float mLuEnd;
    private float mLuRange;
    private float mLuStart;
    public String mMainURL;
    private String mMaskFileHash;
    private long mMaskFileSize;
    private int mMaskHeadLen;
    public BarrageMaskInfo mMaskInfo;
    private float mMaxMomLu;
    private float mMaxShortermLu;
    public String mMediaType;
    public int mMediaTypeInt;
    private int mMediaTypeIntVer2;
    private String mMediaTypeVer2;
    public List<VideoInfo> mOriginalAudioInfo;
    private String mPallasDidLabels;
    private String mPallasVidLabels;
    public float mPeak;
    public int mPopularityLevel;
    private String mPosterUrl;
    private String mPosterUrlVer2;
    public VideoSeekTs mSeekTs;
    private VideoSeekTs mSeekTsVer2;
    public int mStatus;
    private int mStatusVer2;
    public List<SubInfo> mSubInfoList;
    public int[] mSubLangs;
    public List<VideoThumbInfo> mThumbInfoList;
    private List<VideoThumbInfo> mThumbInfoListVer2;
    private int mTotalCount;
    private int mTotalCountVer2;
    public String[] mURLs;
    private long mUrlExpire;
    public String mUserId;
    public String mValidate;
    public int mVideoDuration;
    private int mVideoDurationVer2;
    public String mVideoId;
    private String mVideoIdVer2;
    public List<VideoInfo> mVideoList;
    private List<VideoInfo> mVideoListVer2;
    public String mVideoName;
    public VideoStyle mVideoStyle;
    private int mVolumInfoVer;
    private String mVolumeInfoJson;
    private int mVersion = 1;
    private ArrayList<Resolution> mAllResolutionsArray = new ArrayList<>();
    private ArrayList<String> mAllQualityArray = new ArrayList<>();
    private String[] mCodecArray = null;
    private String mDynamicType = "";
    private String mFormat = "mp4";
    private String mBashString = "";
    private boolean mCodecHasByteVC1 = false;
    private boolean mCodecHasByteVC2 = false;
    private boolean mCodecHasH264 = false;
    private boolean mFormatHasDASH = false;
    private boolean mFormatHasMPD = false;
    private boolean mFormatHasMP4 = false;
    private boolean mFormatHasHls = false;
    private boolean mHasEmbeddedSubtitle = false;
    public int[] mDefaultInfoId = {-1, -1};
    private boolean mMBRefactor = false;
    public float mConstDepth = 0.0f;
    public float mSubtitlePositionX = 0.0f;
    public float mSubtitlePositionY = 0.0f;
    private boolean mURLEncrypted = false;
    private HashMap<String, Resolution> mVideoResolutionMap = TTHelper.defaultVideoResolutionMap();
    private HashMap<String, Resolution> mAudioResolutionMap = TTHelper.defaultAudioResolutionMap();

    public void parseFromPb(VideoModelPb.VideoInfo videoInfo) {
    }

    public JSONObject getDnsInfo() {
        return this.mDnsInfo;
    }

    public List<SubInfo> getSubInfoList() {
        return this.mSubInfoList;
    }

    public String[] getSupportQualityInfos() {
        return this.mAllQualityInfos;
    }

    public Resolution[] getSupportResolutions() {
        return this.mAllResolutions;
    }

    public int[] getSupportSubtitleLangs() {
        return this.mSubLangs;
    }

    public int getVersion() {
        return this.mVersion;
    }

    /* JADX WARN: Removed duplicated region for block: B:186:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x05fd A[LOOP:7: B:194:0x05f7->B:196:0x05fd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x062c A[LOOP:8: B:205:0x0626->B:207:0x062c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0650  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0678  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x073a  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x08a9  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0903  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0919  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0935 A[LOOP:13: B:333:0x092f->B:335:0x0935, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0956  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x097e  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x098a  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0997  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x09a4  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x09b1  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x09c0  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x09cf  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x09e5  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x09fd  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0a0d  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x089f  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x06de  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x05c8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0a2b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0a4b A[EDGE_INSN: B:93:0x0a4b->B:94:0x0a4b BREAK  A[LOOP:3: B:80:0x0a25->B:89:0x0a25], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0a77  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void extractFields(org.json.JSONObject r25) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 2687
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.model.VideoRef.extractFields(org.json.JSONObject):void");
    }

    static {
        Covode.recordClassIndex(652570);
        TYPE_VIDEO = 0;
        TYPE_AUDIO = 1;
    }

    public VideoSeekTs getSeekTs() {
        if (this.mVersion == 2) {
            return this.mSeekTsVer2;
        }
        return this.mSeekTs;
    }

    public List<VideoThumbInfo> getThumbInfoList() {
        if (this.mVersion == 2) {
            return this.mThumbInfoListVer2;
        }
        return this.mThumbInfoList;
    }

    public JSONObject toBashJsonObject() {
        return VideoListToJsonObject(getVideoInfoList());
    }

    public String toBashString() {
        return VideoListToBashString(getVideoInfoList());
    }

    public List<VideoInfo> getVideoInfoList() {
        List<VideoInfo> list;
        if (this.mVersion == 2) {
            return this.mVideoListVer2;
        }
        List<VideoInfo> list2 = this.mVideoList;
        if (list2 != null && list2.size() > 0) {
            list = this.mVideoList;
        } else {
            list = null;
        }
        List<VideoInfo> list3 = this.mDynamicVideoList;
        if (list3 != null && list3.size() > 0) {
            return this.mDynamicVideoList;
        }
        return list;
    }

    public String[] getCodecs() {
        if (this.mCodecArray == null) {
            List<VideoInfo> videoInfoList = getVideoInfoList();
            ArrayList arrayList = new ArrayList();
            if (videoInfoList != null && videoInfoList.size() > 0) {
                for (VideoInfo videoInfo : videoInfoList) {
                    if (videoInfo != null) {
                        String valueStr = videoInfo.getValueStr(8);
                        if (!TextUtils.isEmpty(valueStr) && !arrayList.contains(valueStr)) {
                            arrayList.add(valueStr);
                        }
                    }
                }
            }
            String[] strArr = new String[arrayList.size()];
            this.mCodecArray = strArr;
            arrayList.toArray(strArr);
        }
        return this.mCodecArray;
    }

    public VideoRef() {
        int i = TYPE_VIDEO;
        this.mMediaTypeInt = i;
        this.mLoudness = 0.0f;
        this.mPeak = 0.0f;
        this.mLuRange = 0.0f;
        this.mLuStart = 0.0f;
        this.mLuEnd = 0.0f;
        this.mMaxMomLu = 0.0f;
        this.mMaxShortermLu = 0.0f;
        this.mVolumInfoVer = 0;
        this.mVolumeInfoJson = "";
        this.mFirstSubVid = null;
        this.mPallasVidLabels = "";
        this.mPallasDidLabels = "";
        this.mBid = "";
        this.mCategory = 0;
        this.mVideoListVer2 = null;
        this.mMediaTypeIntVer2 = i;
        this.mUrlExpire = 0L;
        this.mMaskFileSize = 0L;
    }

    public void setVersion(int i) {
        this.mVersion = i;
    }

    public static String VideoListToBashString(List<VideoInfo> list) {
        JSONObject VideoListToJsonObject = VideoListToJsonObject(list);
        if (VideoListToJsonObject != null) {
            return VideoListToJsonObject.toString();
        }
        return "";
    }

    public String resolutionToString(Resolution resolution) {
        return resolutionToString(resolution, getValueInt(7));
    }

    public long getValueLong(int i) {
        if (i != 216) {
            if (i != 220) {
                if (i != 243) {
                    return 0L;
                }
                return this.mMaskFileSize;
            }
            return this.mUrlExpire;
        }
        return this.mDnsTime;
    }

    public String getResolutionStr(VideoInfo videoInfo) {
        if (videoInfo == null) {
            return resolutionToString(Resolution.Standard);
        }
        int mediatype = videoInfo.getMediatype();
        if (mediatype == TYPE_AUDIO) {
            String valueStr = videoInfo.getValueStr(18);
            if (valueStr == null) {
                return resolutionToString(Resolution.Standard, mediatype);
            }
            return valueStr;
        }
        if (mediatype == TYPE_VIDEO) {
            String valueStr2 = videoInfo.getValueStr(7);
            if (valueStr2 == null) {
                return resolutionToString(Resolution.Standard, mediatype);
            }
            return valueStr2;
        }
        return resolutionToString(Resolution.Standard);
    }

    public List<VideoInfo> getValueList(int i) {
        if (this.mVersion == 2) {
            if (i != 5) {
                return null;
            }
            return this.mVideoListVer2;
        }
        if (i != 5) {
            if (i != 210) {
                if (i != 231) {
                    if (i != 234) {
                        return null;
                    }
                    return this.mOriginalAudioInfo;
                }
                return this.mDubbedAudioInfo;
            }
            return this.mDynamicVideoList;
        }
        return this.mVideoList;
    }

    public static JSONObject VideoListToJsonObject(List<VideoInfo> list) {
        JSONObject bashJsonObject;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    JSONArray jSONArray2 = new JSONArray();
                    for (VideoInfo videoInfo : list) {
                        if (videoInfo != null && (bashJsonObject = videoInfo.toBashJsonObject()) != null) {
                            if (videoInfo.getMediatype() == TYPE_VIDEO) {
                                jSONArray.put(bashJsonObject);
                            } else if (videoInfo.getMediatype() == TYPE_AUDIO) {
                                jSONArray2.put(bashJsonObject);
                            }
                        }
                    }
                    if (jSONArray.length() > 0 || jSONArray2.length() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("dynamic_video_list", jSONArray);
                        jSONObject.put("dynamic_audio_list", jSONArray2);
                        return jSONObject;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Boolean getValueBool(int i) {
        if (i != 106) {
            if (i != 222) {
                if (i != 253) {
                    if (i != 228) {
                        if (i != 229) {
                            switch (i) {
                                case 203:
                                    return Boolean.valueOf(this.mCodecHasH264);
                                case 204:
                                    return Boolean.valueOf(this.mCodecHasByteVC1);
                                case 205:
                                    return Boolean.valueOf(this.mFormatHasDASH);
                                case 206:
                                    return Boolean.valueOf(this.mFormatHasMP4);
                                case 207:
                                    return Boolean.valueOf(this.mFormatHasMPD);
                                case 208:
                                    return Boolean.valueOf(this.mFormatHasHls);
                                default:
                                    return Boolean.FALSE;
                            }
                        }
                        return Boolean.valueOf(this.mHasEmbeddedSubtitle);
                    }
                    return Boolean.valueOf(this.mCodecHasByteVC2);
                }
                return Boolean.valueOf(this.mMBRefactor);
            }
            return Boolean.valueOf(this.mEnableAdaptive);
        }
        return Boolean.valueOf(this.mEnableSSL);
    }

    public float getValueFloat(int i) {
        if (i != 224) {
            if (i != 225) {
                if (i != 236) {
                    if (i != 252) {
                        if (i != 239) {
                            if (i != 240) {
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
                            return this.mSubtitlePositionY;
                        }
                        return this.mSubtitlePositionX;
                    }
                    return this.mLuRange;
                }
                return this.mConstDepth;
            }
            return this.mPeak;
        }
        return this.mLoudness;
    }

    public int getValueInt(int i) {
        int i2 = this.mVersion;
        if (i2 == 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 7) {
                        if (i != 209) {
                            if (i != 230) {
                                if (i != 232) {
                                    if (i != 242) {
                                        if (i != 251) {
                                            return 0;
                                        }
                                        return this.mVolumInfoVer;
                                    }
                                    return this.mMaskHeadLen;
                                }
                                return this.mCategory;
                            }
                            return this.mDefaultInfoId[TYPE_AUDIO];
                        }
                        return this.mTotalCountVer2;
                    }
                    return this.mMediaTypeIntVer2;
                }
                return this.mStatusVer2;
            }
            return this.mVideoDurationVer2;
        }
        if (i != 3) {
            if (i != 4) {
                if (i != 7) {
                    if (i != 9) {
                        if (i != 209) {
                            if (i != 227) {
                                if (i != 230) {
                                    if (i != 232) {
                                        if (i != 242) {
                                            if (i != 251) {
                                                return 0;
                                            }
                                            return this.mVolumInfoVer;
                                        }
                                        return this.mMaskHeadLen;
                                    }
                                    return this.mCategory;
                                }
                                return this.mDefaultInfoId[TYPE_AUDIO];
                            }
                            return this.mPopularityLevel;
                        }
                        return this.mTotalCount;
                    }
                    return i2;
                }
                return this.mMediaTypeInt;
            }
            return this.mStatus;
        }
        return this.mVideoDuration;
    }

    public VideoInfo getVideoInfo(Map<Integer, String> map) {
        boolean z;
        List<VideoInfo> videoInfoList = getVideoInfoList();
        if (videoInfoList != null && videoInfoList.size() != 0) {
            for (VideoInfo videoInfo : videoInfoList) {
                if (videoInfo != null) {
                    if (map != null && map.size() != 0) {
                        Iterator<Map.Entry<Integer, String>> it2 = map.entrySet().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                Map.Entry<Integer, String> next = it2.next();
                                int intValue = next.getKey().intValue();
                                String value = next.getValue();
                                if (!TextUtils.isEmpty(value) && !value.equals(videoInfo.getValueStr(intValue))) {
                                    z = false;
                                    break;
                                }
                            } else {
                                z = true;
                                break;
                            }
                        }
                        if (z) {
                        }
                    }
                    return videoInfo;
                }
            }
        }
        return null;
    }

    public VideoInfo getVideoInfoWithClarity(String str) {
        List<VideoInfo> videoInfoList;
        if (TextUtils.isEmpty(str) || (videoInfoList = getVideoInfoList()) == null || videoInfoList.size() == 0) {
            return null;
        }
        for (int i = 0; i < videoInfoList.size(); i++) {
            if (videoInfoList.get(i) != null && getResolutionStr(videoInfoList.get(i)).equals(str)) {
                return videoInfoList.get(i);
            }
        }
        return videoInfoList.get(0);
    }

    public String getValueStr(int i) {
        if (i == 211) {
            return this.mFormat;
        }
        if (i == 215) {
            return this.mDynamicType;
        }
        if (i == 8) {
            return this.mBashString;
        }
        if (i == 233) {
            return this.mFirstSubVid;
        }
        if (i == 237) {
            return this.mPallasVidLabels;
        }
        if (i == 244) {
            return this.mPallasDidLabels;
        }
        if (i == 245) {
            return this.mLabelUsage;
        }
        if (i == 260) {
            return this.mVolumeInfoJson;
        }
        if (this.mVersion == 2) {
            if (i != 2) {
                if (i != 7) {
                    if (i != 201) {
                        return "";
                    }
                    return this.mPosterUrlVer2;
                }
                return this.mMediaTypeVer2;
            }
            return this.mVideoIdVer2;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 7) {
                    if (i != 201) {
                        if (i != 221) {
                            if (i != 223) {
                                if (i != 226) {
                                    if (i != 235) {
                                        if (i != 241) {
                                            if (i != 246) {
                                                if (i != 104) {
                                                    if (i != 105) {
                                                        if (i != 217) {
                                                            if (i != 218) {
                                                                switch (i) {
                                                                    case 107:
                                                                        return this.mAutoDefinition;
                                                                    case 108:
                                                                        return this.mMainURL;
                                                                    case 109:
                                                                        return this.mBackupURL;
                                                                    default:
                                                                        return "";
                                                                }
                                                            }
                                                            return this.mKeyseed;
                                                        }
                                                        return this.mFallbackApi;
                                                    }
                                                    return this.mValidate;
                                                }
                                                return this.mVideoName;
                                            }
                                            return this.mBid;
                                        }
                                        return this.mMaskFileHash;
                                    }
                                    return this.mAIBarrageUrl;
                                }
                                return this.mFullScreen;
                            }
                            return this.mDecodingMode;
                        }
                        return this.mBarrageMaskUrl;
                    }
                    return this.mPosterUrl;
                }
                return this.mMediaType;
            }
            return this.mVideoId;
        }
        return this.mUserId;
    }

    public void setUpResolution(HashMap<String, Resolution> hashMap) {
        int valueInt = getValueInt(7);
        if (hashMap != null && hashMap.size() > 0) {
            if (valueInt == TYPE_AUDIO) {
                this.mAudioResolutionMap = hashMap;
            } else {
                this.mVideoResolutionMap = hashMap;
            }
        } else if (valueInt == TYPE_AUDIO) {
            hashMap = this.mAudioResolutionMap;
        } else {
            hashMap = this.mVideoResolutionMap;
        }
        Resolution resolution = Resolution.Undefine;
        List<VideoInfo> videoInfoList = getVideoInfoList();
        if (videoInfoList != null) {
            for (int i = 0; i < videoInfoList.size(); i++) {
                VideoInfo videoInfo = videoInfoList.get(i);
                if (videoInfo != null && videoInfo.getMediatype() == valueInt) {
                    videoInfo.setResolutionBaseMap(hashMap);
                    Resolution resolution2 = videoInfo.getResolution();
                    String valueStr = videoInfo.getValueStr(32);
                    if (!this.mAllQualityArray.contains(valueStr)) {
                        this.mAllQualityArray.add(valueStr);
                    }
                    if (!this.mAllResolutionsArray.contains(resolution2)) {
                        this.mAllResolutionsArray.add(resolution2);
                    }
                }
            }
        }
        Resolution[] resolutionArr = new Resolution[this.mAllResolutionsArray.size()];
        this.mAllResolutions = resolutionArr;
        this.mAllResolutionsArray.toArray(resolutionArr);
        String[] strArr = new String[this.mAllQualityArray.size()];
        this.mAllQualityInfos = strArr;
        this.mAllQualityArray.toArray(strArr);
    }

    public void setValue(int i, String[] strArr) {
        if (i != 213) {
            return;
        }
        this.mURLs = strArr;
    }

    public VideoInfo getVideoInfo(Resolution resolution, Map<Integer, String> map) {
        return getVideoInfo(resolution, getValueInt(7), map);
    }

    public void setValue(int i, VideoSeekTs videoSeekTs) {
        if (i != 214) {
            return;
        }
        this.mSeekTs = videoSeekTs;
        this.mSeekTsVer2 = videoSeekTs;
    }

    public String[] allVideoURLs(Resolution resolution, Map<Integer, String> map) {
        String[] strArr = this.mURLs;
        if (strArr != null && strArr.length > 0) {
            return strArr;
        }
        VideoInfo videoInfo = getVideoInfo(resolution, map);
        if (videoInfo == null) {
            return new String[0];
        }
        return videoInfo.getValueStrArr(16);
    }

    public void setValue(int i, List list) {
        if (i != 5) {
            if (i != 210) {
                if (i != 212) {
                    return;
                }
                this.mThumbInfoListVer2 = list;
                this.mThumbInfoList = list;
                return;
            }
            this.mDynamicVideoList = list;
            return;
        }
        this.mVideoList = list;
        this.mVideoListVer2 = list;
    }

    public void setValueStr(int i, String str) {
        if (i != 218) {
            if (i != 245) {
                if (i == 246) {
                    this.mBid = str;
                    return;
                }
                return;
            } else {
                if (!TextUtils.isEmpty(str)) {
                    this.mLabelUsage = str;
                    return;
                }
                return;
            }
        }
        this.mKeyseed = str;
    }

    public String resolutionToString(Resolution resolution, int i) {
        HashMap<String, Resolution> hashMap;
        String str;
        if (i == TYPE_AUDIO) {
            hashMap = this.mAudioResolutionMap;
        } else {
            hashMap = this.mVideoResolutionMap;
        }
        Iterator<Map.Entry<String, Resolution>> it2 = hashMap.entrySet().iterator();
        while (true) {
            if (it2.hasNext()) {
                Map.Entry<String, Resolution> next = it2.next();
                if (next.getValue().getIndex() == resolution.getIndex()) {
                    str = next.getKey();
                    break;
                }
            } else {
                str = null;
                break;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return resolution.toString(i);
        }
        return str;
    }

    public void setValue(int i, int i2) {
        if (i != 3) {
            if (i != 4) {
                if (i != 7) {
                    if (i != 209) {
                        if (i != 232) {
                            return;
                        }
                        this.mCategory = i2;
                        return;
                    }
                    this.mTotalCountVer2 = i2;
                    return;
                }
                this.mMediaTypeInt = i2;
                this.mMediaTypeIntVer2 = i2;
                return;
            }
            this.mStatus = i2;
            return;
        }
        this.mVideoDuration = i2;
        this.mVideoDurationVer2 = i2;
    }

    public void setValue(int i, String str) {
        if (i != 1) {
            if (i != 2) {
                if (i != 7) {
                    if (i != 201) {
                        if (i != 233) {
                            if (i != 104) {
                                if (i != 105) {
                                    switch (i) {
                                        case 107:
                                            this.mAutoDefinition = str;
                                            break;
                                        case 108:
                                            this.mMainURL = str;
                                            break;
                                        case 109:
                                            this.mBackupURL = str;
                                            break;
                                    }
                                    return;
                                }
                                this.mValidate = str;
                                return;
                            }
                            this.mVideoName = str;
                            return;
                        }
                        this.mFirstSubVid = str;
                        return;
                    }
                    this.mPosterUrlVer2 = str;
                    return;
                }
                this.mMediaTypeVer2 = str;
                this.mMediaType = str;
                return;
            }
            this.mVideoId = str;
            this.mVideoIdVer2 = str;
            if (TextUtils.isEmpty(this.mBid)) {
                this.mBid = str;
                return;
            }
            return;
        }
        this.mUserId = str;
    }

    public void setValue(int i, boolean z) {
        if (i != 106) {
            if (i != 219) {
                return;
            }
            this.mURLEncrypted = z;
            return;
        }
        this.mEnableSSL = z;
    }

    public VideoInfo getVideoInfo(Resolution resolution, int i, Map<Integer, String> map) {
        boolean z;
        List<VideoInfo> videoInfoList = getVideoInfoList();
        if (videoInfoList != null && videoInfoList.size() != 0) {
            for (VideoInfo videoInfo : videoInfoList) {
                if (videoInfo != null && i == videoInfo.getMediatype()) {
                    if (map != null && map.containsKey(42)) {
                        String str = map.get(42);
                        if (!TextUtils.isEmpty(videoInfo.getValueStr(42)) && videoInfo.getValueStr(42).equals(str)) {
                            return videoInfo;
                        }
                    }
                    if (map != null && map.containsKey(32)) {
                        String str2 = map.get(32);
                        if (!TextUtils.isEmpty(videoInfo.getValueStr(32)) && videoInfo.getValueStr(32).equals(str2)) {
                            return videoInfo;
                        }
                    }
                    if (map != null && map.containsKey(18)) {
                        String str3 = map.get(18);
                        if (!TextUtils.isEmpty(videoInfo.getValueStr(18)) && videoInfo.getValueStr(18).equals(str3)) {
                            return videoInfo;
                        }
                    }
                    if (resolution == videoInfo.getResolution()) {
                        if (map != null && map.size() != 0) {
                            Iterator<Map.Entry<Integer, String>> it2 = map.entrySet().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    Map.Entry<Integer, String> next = it2.next();
                                    int intValue = next.getKey().intValue();
                                    String value = next.getValue();
                                    if (!TextUtils.isEmpty(value) && !value.equals(videoInfo.getValueStr(intValue))) {
                                        z = false;
                                        break;
                                    }
                                } else {
                                    z = true;
                                    break;
                                }
                            }
                            if (z) {
                            }
                        }
                        return videoInfo;
                    }
                    continue;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x01c3, code lost:
    
        if (r6.equals(r1.toString(r5)) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.ss.ttvideoengine.model.VideoInfo _generateVideoInfo(org.json.JSONObject r4, int r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 603
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.model.VideoRef._generateVideoInfo(org.json.JSONObject, int, java.lang.String):com.ss.ttvideoengine.model.VideoInfo");
    }
}
