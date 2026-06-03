package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoModel implements IVideoModel {
    public VideoRef videoRef = null;
    public List<VideoAdRef> videoAdRefList = null;
    public LiveVideoRef liveVideoRef = null;
    private VideoRef vodVideoRef = null;
    private int mSourceType = 1;
    private int mVersion = 1;
    private HashMap<String, Resolution> mResolutionMap = null;
    private JSONObject mJsonInfo = null;
    private boolean mURLEncrypted = false;
    private String mKeyseed = null;

    static {
        Covode.recordClassIndex(652552);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public int fromMediaInfoJsonObject(JSONObject jSONObject) {
        return -1;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public int fromMediaInfoJsonString(String str) {
        return -1;
    }

    public JSONObject getJsonInfo() {
        return this.mJsonInfo;
    }

    public int getSourceType() {
        return this.mSourceType;
    }

    public VideoRef getVideoRef() {
        return this.vodVideoRef;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String[] getCodecs() {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.getCodecs();
        }
        return new String[0];
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public JSONObject getDnsInfo() {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.getDnsInfo();
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String getDynamicType() {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.getValueStr(215);
        }
        return "";
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public IVideoModel.Source getSource() {
        IVideoModel.Source source = IVideoModel.Source.None;
        int i = this.mSourceType;
        if (i != 0) {
            if (i == 1) {
                return IVideoModel.Source.VOD;
            }
            return source;
        }
        return IVideoModel.Source.LIVE;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public List<SubInfo> getSubInfoList() {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.mSubInfoList;
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String[] getSupportQualityInfos() {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.getSupportQualityInfos();
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public Resolution[] getSupportResolutions() {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.getSupportResolutions();
        }
        return new Resolution[0];
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public int[] getSupportSubtitleLangs() {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.getSupportSubtitleLangs();
        }
        return null;
    }

    public List<VideoThumbInfo> getThumbInfoList() {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.mThumbInfoList;
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String getVType() {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.getValueStr(TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES_FXAA);
        }
        return "mp4";
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public List<VideoInfo> getVideoInfoList() {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef == null) {
            return Collections.emptyList();
        }
        return videoRef.getVideoInfoList();
    }

    public VideoSeekTs getVideoSeekTS() {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.mSeekTs;
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoStyle getVideoStyle() {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.mVideoStyle;
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public boolean hasData() {
        if (this.vodVideoRef == null && this.liveVideoRef == null) {
            return false;
        }
        return true;
    }

    public boolean isLiveSource() {
        if (getSource() == IVideoModel.Source.LIVE) {
            return true;
        }
        return false;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String toMediaInfoJsonString() {
        JSONObject mediaInfo = getMediaInfo();
        if (mediaInfo != null) {
            return mediaInfo.toString();
        }
        return null;
    }

    public boolean isDashSource() {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null && videoRef.getValueBool(205).booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isHlsSource() {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null && videoRef.getValueBool(208).booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isMp4Source() {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null && videoRef.getValueBool(206).booleanValue()) {
            return true;
        }
        return false;
    }

    /* renamed from: com.ss.ttvideoengine.model.VideoModel$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$ttvideoengine$model$IVideoModel$Format;

        static {
            int[] iArr = new int[IVideoModel.Format.values().length];
            $SwitchMap$com$ss$ttvideoengine$model$IVideoModel$Format = iArr;
            try {
                iArr[IVideoModel.Format.HLS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$ttvideoengine$model$IVideoModel$Format[IVideoModel.Format.MP4.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$ttvideoengine$model$IVideoModel$Format[IVideoModel.Format.DASH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$ttvideoengine$model$IVideoModel$Format[IVideoModel.Format.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public List<Integer> getOriginalAudioInfo() {
        VideoRef videoRef = this.vodVideoRef;
        ArrayList arrayList = null;
        if (videoRef == null) {
            return null;
        }
        List<VideoInfo> valueList = videoRef.getValueList(234);
        if (valueList != null && valueList.size() != 0) {
            arrayList = new ArrayList();
            Iterator<VideoInfo> it2 = valueList.iterator();
            while (it2.hasNext()) {
                arrayList.add(Integer.valueOf(it2.next().getValueInt(42)));
            }
        }
        return arrayList;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String getSpadea() {
        List<VideoInfo> videoInfoList;
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null && (videoInfoList = videoRef.getVideoInfoList()) != null && videoInfoList.size() != 0) {
            Iterator<VideoInfo> it2 = videoInfoList.iterator();
            while (it2.hasNext()) {
                String valueStr = it2.next().getValueStr(5);
                if (!TextUtils.isEmpty(valueStr)) {
                    return valueStr;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public List<Integer> getSupportedTTSAudioInfo() {
        VideoRef videoRef = this.vodVideoRef;
        ArrayList arrayList = null;
        if (videoRef == null) {
            return null;
        }
        List<VideoInfo> valueList = videoRef.getValueList(231);
        if (valueList != null && valueList.size() != 0) {
            arrayList = new ArrayList();
            Iterator<VideoInfo> it2 = valueList.iterator();
            while (it2.hasNext()) {
                arrayList.add(Integer.valueOf(it2.next().getValueInt(42)));
            }
        }
        return arrayList;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public boolean isSupportHLSSeamlessSwitch() {
        if (TextUtils.isEmpty(getVideoRefStr(8)) || !hasFormat(IVideoModel.Format.HLS) || !getVideoRefBool(222)) {
            return false;
        }
        return true;
    }

    public String getCodec() {
        VideoInfo videoInfo;
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            if (this.mVersion == 2) {
                boolean z = false;
                for (String str : videoRef.getCodecs()) {
                    if (str.equals("bytevc2")) {
                        return "bytevc2";
                    }
                    if (str.equals("bytevc1")) {
                        z = true;
                    }
                }
                if (!z) {
                    return "h264";
                }
                return "bytevc1";
            }
            List<VideoInfo> videoInfoList = videoRef.getVideoInfoList();
            if (videoInfoList != null && videoInfoList.size() != 0 && (videoInfo = videoInfoList.get(0)) != null) {
                String str2 = videoInfo.mCodecType;
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
            }
        }
        return "h264";
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public Set<IVideoModel.Format> getFormats() {
        HashSet hashSet = new HashSet();
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            if (videoRef.getValueBool(206).booleanValue()) {
                hashSet.add(IVideoModel.Format.MP4);
            } else if (this.vodVideoRef.getValueBool(208).booleanValue()) {
                hashSet.add(IVideoModel.Format.HLS);
            } else if (this.vodVideoRef.getValueBool(205).booleanValue() || this.vodVideoRef.getValueBool(207).booleanValue()) {
                hashSet.add(IVideoModel.Format.DASH);
            }
        }
        return hashSet;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public boolean isSupportBash() {
        if (TextUtils.isEmpty(getVideoRefStr(8))) {
            return false;
        }
        if (hasFormat(IVideoModel.Format.DASH)) {
            String dynamicType = getDynamicType();
            if (!TextUtils.isEmpty(dynamicType) && dynamicType.equals("segment_base")) {
                return true;
            }
        } else if (hasFormat(IVideoModel.Format.MP4) && getVideoRefBool(222) && TextUtils.isEmpty(getSpadea())) {
            return true;
        }
        return false;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public JSONObject getMediaInfo() {
        BarrageMaskInfo barrageMaskInfo;
        String videoRefStr = getVideoRefStr(TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES_FXAA);
        String videoRefStr2 = getVideoRefStr(2);
        int videoRefInt = getVideoRefInt(3);
        List<VideoInfo> videoInfoList = getVideoInfoList();
        if (videoInfoList != null) {
            try {
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                Iterator<VideoInfo> it2 = videoInfoList.iterator();
                while (it2.hasNext()) {
                    arrayList.add(it2.next().toMediaInfo());
                }
                VideoRef videoRef = this.vodVideoRef;
                if (videoRef != null && (barrageMaskInfo = videoRef.mMaskInfo) != null) {
                    arrayList.add(barrageMaskInfo.getMediaInfo());
                }
                hashMap.put("format", videoRefStr);
                hashMap.put("vid", videoRefStr2);
                hashMap.put("bid", getVideoRefStr(246));
                hashMap.put("category", Integer.valueOf(getVideoRefInt(232)));
                hashMap.put("duration", Integer.valueOf(videoRefInt));
                hashMap.put("infos", arrayList);
                VideoRef videoRef2 = this.vodVideoRef;
                if (videoRef2 != null) {
                    hashMap.put("pallas_vid_labels", videoRef2.getValueStr(237));
                }
                return new JSONObject(hashMap);
            } catch (Throwable th) {
                TTVideoEngineLog.d(th);
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String[] allVideoURLs(Resolution resolution) {
        return allVideoURLs(resolution, null);
    }

    public void setVideoRef(VideoRef videoRef) {
        this.vodVideoRef = videoRef;
        setUpResolution(this.mResolutionMap);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution resolution) {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef == null) {
            return null;
        }
        return videoRef.getVideoInfo(resolution, null);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public boolean getVideoRefBool(int i) {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.getValueBool(i).booleanValue();
        }
        return false;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public float getVideoRefFloat(int i) {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.getValueFloat(i);
        }
        return 0.0f;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public int getVideoRefInt(int i) {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.getValueInt(i);
        }
        return -1;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public long getVideoRefLong(int i) {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.getValueLong(i);
        }
        return 0L;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String getVideoRefStr(int i) {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.getValueStr(i);
        }
        return "";
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String resolutionToString(Resolution resolution) {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.resolutionToString(resolution);
        }
        return resolution.toString(VideoRef.TYPE_VIDEO);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public void setUpResolution(HashMap<String, Resolution> hashMap) {
        this.mResolutionMap = hashMap;
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            videoRef.setUpResolution(hashMap);
        }
    }

    public int getPreloadInterval(Resolution resolution) {
        VideoInfo videoInfo;
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef == null || (videoInfo = videoRef.getVideoInfo(resolution, null)) == null) {
            return 0;
        }
        return videoInfo.getValueInt(13);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public List<Integer> getSupportInfoId(int i) {
        VideoRef videoRef = this.vodVideoRef;
        ArrayList arrayList = null;
        if (videoRef == null) {
            return null;
        }
        List<VideoInfo> videoInfoList = videoRef.getVideoInfoList();
        if (videoInfoList != null && videoInfoList.size() != 0) {
            arrayList = new ArrayList();
            for (VideoInfo videoInfo : videoInfoList) {
                if (videoInfo.getMediatype() == i) {
                    arrayList.add(Integer.valueOf(videoInfo.mInfoId));
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfoByInfoId(int i) {
        VideoRef videoRef;
        List<VideoInfo> videoInfoList;
        if (i >= 0 && (videoRef = this.vodVideoRef) != null && (videoInfoList = videoRef.getVideoInfoList()) != null && videoInfoList.size() != 0) {
            for (VideoInfo videoInfo : videoInfoList) {
                if (videoInfo.mInfoId == i) {
                    return videoInfo;
                }
            }
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public boolean hasFormat(IVideoModel.Format format) {
        if (this.vodVideoRef == null) {
            return false;
        }
        int i = AnonymousClass1.$SwitchMap$com$ss$ttvideoengine$model$IVideoModel$Format[format.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return false;
                }
                return this.vodVideoRef.getValueBool(205).booleanValue();
            }
            return this.vodVideoRef.getValueBool(206).booleanValue();
        }
        return this.vodVideoRef.getValueBool(208).booleanValue();
    }

    public void initWithJson(JSONObject jSONObject) throws Throwable {
        if (jSONObject == null) {
            return;
        }
        jSONObject.put("mb_refactor", true);
        extractFields(new JSONObject().put("video_info", new JSONObject().put("data", jSONObject)));
    }

    public void extractFields(JSONObject jSONObject) throws Throwable {
        if (jSONObject == null) {
            return;
        }
        try {
            this.mJsonInfo = new JSONObject(jSONObject.toString());
        } catch (Throwable unused) {
            TTVideoEngineLog.e("VideoModel", "generate mJsonInfo error");
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("video_info");
        if (optJSONObject != null && optJSONObject.length() > 0) {
            this.mVersion = 1;
            VideoRef videoRef = new VideoRef();
            videoRef.setVersion(this.mVersion);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
            videoRef.setValue(219, this.mURLEncrypted);
            videoRef.setValueStr(218, this.mKeyseed);
            videoRef.extractFields(optJSONObject2);
            this.videoRef = videoRef;
            this.vodVideoRef = videoRef;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("video_ad_list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.videoAdRefList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    VideoAdRef videoAdRef = new VideoAdRef();
                    videoAdRef.extractFields(optJSONArray.getJSONObject(i));
                    this.videoAdRefList.add(videoAdRef);
                } catch (Exception unused2) {
                }
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("live_info");
        if (optJSONObject3 != null) {
            this.mSourceType = 0;
            this.liveVideoRef = new LiveVideoRef();
            this.liveVideoRef.extractFields(optJSONObject3.optJSONObject("data"));
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("PlayInfoList");
        if ((optJSONArray2 != null && optJSONArray2.length() > 0) || !TextUtils.isEmpty(jSONObject.optString("VideoID")) || !TextUtils.isEmpty(jSONObject.optString("Vid"))) {
            if (jSONObject.optInt("Version") == 4) {
                this.mVersion = 4;
            } else {
                this.mVersion = 2;
            }
            VideoRef videoRef2 = new VideoRef();
            this.vodVideoRef = videoRef2;
            videoRef2.setVersion(this.mVersion);
            this.vodVideoRef.extractFields(jSONObject);
        }
        setUpResolution(this.mResolutionMap);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Map<Integer, String> map) {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.getVideoInfo(map);
        }
        return null;
    }

    public void setVideoRefBool(int i, boolean z) {
        if (i == 219) {
            this.mURLEncrypted = z;
        }
    }

    public void setVideoRefStr(int i, String str) {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            videoRef.setValueStr(i, str);
        }
        if (i == 218) {
            this.mKeyseed = str;
        }
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String[] allVideoURLs(Resolution resolution, Map<Integer, String> map) {
        LiveVideoInfo liveVideoInfo;
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.allVideoURLs(resolution, map);
        }
        LiveVideoRef liveVideoRef = this.liveVideoRef;
        if (liveVideoRef != null && (liveVideoInfo = liveVideoRef.getLiveVideoInfo()) != null) {
            return liveVideoInfo.mURLs;
        }
        return new String[0];
    }

    public int getPreloadInterval(Resolution resolution, Map<Integer, String> map) {
        VideoInfo videoInfo;
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null && (videoInfo = videoRef.getVideoInfo(resolution, map)) != null) {
            videoInfo.getValueInt(13);
            return 0;
        }
        return 0;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution resolution, Map<Integer, String> map) {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.getVideoInfo(resolution, map);
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution resolution, boolean z) {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef == null) {
            return null;
        }
        return getVideoInfo(resolution, videoRef.getValueInt(7), null, z);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution resolution, int i, Map<Integer, String> map) {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return videoRef.getVideoInfo(resolution, i, map);
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution resolution, int i, boolean z) {
        if (this.vodVideoRef == null) {
            return null;
        }
        return getVideoInfo(resolution, i, null, z);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution resolution, Map<Integer, String> map, boolean z) {
        VideoRef videoRef = this.vodVideoRef;
        if (videoRef != null) {
            return getVideoInfo(resolution, videoRef.getValueInt(7), map, z);
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution resolution, int i, Map<Integer, String> map, boolean z) {
        String str;
        VideoInfo videoInfo = getVideoInfo(resolution, i, map);
        if (!z) {
            return videoInfo;
        }
        String[] allQualityInfos = TTVideoEngine.getAllQualityInfos();
        int i2 = 0;
        if (allQualityInfos.length > 0 && map != null && map.containsKey(32)) {
            int length = allQualityInfos.length - 1;
            if (videoInfo == null && (str = map.get(32)) != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= allQualityInfos.length) {
                        break;
                    }
                    if (allQualityInfos[i3].equals(str)) {
                        length = i3;
                        break;
                    }
                    i3++;
                }
                int i4 = length;
                while (videoInfo == null) {
                    map.put(32, allQualityInfos[i4]);
                    videoInfo = getVideoInfo(resolution, i, map);
                    if (videoInfo != null) {
                        return videoInfo;
                    }
                    i4 = ((i4 + allQualityInfos.length) - 1) % allQualityInfos.length;
                    if (i4 == length) {
                        break;
                    }
                }
            }
        }
        Resolution[] allResolutions = Resolution.getAllResolutions();
        if (allResolutions.length <= 0) {
            return videoInfo;
        }
        int length2 = allResolutions.length - 1;
        if (resolution != null) {
            while (true) {
                if (i2 >= allResolutions.length) {
                    break;
                }
                if (allResolutions[i2].getIndex() == resolution.getIndex()) {
                    length2 = i2;
                    break;
                }
                i2++;
            }
        }
        int i5 = length2;
        while (videoInfo == null) {
            videoInfo = getVideoInfo(allResolutions[i5], i, (Map<Integer, String>) null);
            if (videoInfo != null || (i5 = ((i5 + allResolutions.length) - 1) % allResolutions.length) == length2) {
                break;
            }
        }
        return videoInfo;
    }
}
