package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.model.BareVideoInfo;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BareVideoModel implements IVideoModel {
    private boolean mAdaptive;
    private String mBashString;
    private String mBid;
    private int mCategory;
    private long mDuration;
    private String mDynamicType;
    private List<VideoInfo> mInfos;
    private float mLoudness;
    private float mPeak;
    private int mPlaceHolder;
    private String mVid;

    static {
        Covode.recordClassIndex(652529);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public JSONObject getDnsInfo() {
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public List<Integer> getOriginalAudioInfo() {
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public List<SubInfo> getSubInfoList() {
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public List<Integer> getSupportInfoId(int i) {
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public int[] getSupportSubtitleLangs() {
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public List<Integer> getSupportedTTSAudioInfo() {
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String getVType() {
        return "mp4";
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfoByInfoId(int i) {
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public boolean getVideoRefBool(int i) {
        return false;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public long getVideoRefLong(int i) {
        return 0L;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoStyle getVideoStyle() {
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public boolean isSupportHLSSeamlessSwitch() {
        return false;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public void setUpResolution(HashMap<String, Resolution> hashMap) {
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String getDynamicType() {
        return this.mDynamicType;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public IVideoModel.Source getSource() {
        return IVideoModel.Source.BARE;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public List<VideoInfo> getVideoInfoList() {
        return this.mInfos;
    }

    private BareVideoModel() {
        this.mCategory = 0;
        this.mBid = "";
        this.mBashString = "";
        this.mPlaceHolder = 0;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public boolean hasData() {
        List<VideoInfo> list = this.mInfos;
        if (list != null && !list.isEmpty()) {
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

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String getSpadea() {
        Iterator<VideoInfo> it2 = this.mInfos.iterator();
        while (it2.hasNext()) {
            String valueStr = it2.next().getValueStr(5);
            if (!TextUtils.isEmpty(valueStr)) {
                return valueStr;
            }
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String[] getCodecs() {
        HashSet hashSet = new HashSet();
        Iterator<VideoInfo> it2 = this.mInfos.iterator();
        while (it2.hasNext()) {
            String valueStr = it2.next().getValueStr(8);
            if (!TextUtils.isEmpty(valueStr)) {
                hashSet.add(valueStr);
            }
        }
        return (String[]) hashSet.toArray(new String[0]);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String[] getSupportQualityInfos() {
        HashSet hashSet = new HashSet();
        Iterator<VideoInfo> it2 = this.mInfos.iterator();
        while (it2.hasNext()) {
            String valueStr = it2.next().getValueStr(32);
            if (!TextUtils.isEmpty(valueStr)) {
                hashSet.add(valueStr);
            }
        }
        return (String[]) hashSet.toArray(new String[0]);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public Resolution[] getSupportResolutions() {
        HashSet hashSet = new HashSet();
        Iterator<VideoInfo> it2 = this.mInfos.iterator();
        while (it2.hasNext()) {
            hashSet.add(it2.next().getResolution());
        }
        return (Resolution[]) hashSet.toArray(new Resolution[0]);
    }

    public static class Builder {
        private String mVid = null;
        private long mDuration = 0;
        private boolean mAdaptive = false;
        private String mDynamicType = null;
        private float mLoudness = 0.0f;
        private float mPeak = 0.0f;
        private int mCategory = 0;
        private String mFirstSubVid = null;
        private int mSubListIndex = -1;
        private List<VideoInfo> mInfos = null;
        private String mBid = "";
        private int mPlaceHolder = 0;

        static {
            Covode.recordClassIndex(652530);
        }

        public BareVideoModel build() {
            BareVideoModel bareVideoModel = new BareVideoModel();
            bareVideoModel.mVid = this.mVid;
            bareVideoModel.mBid = this.mBid;
            bareVideoModel.mDuration = this.mDuration;
            bareVideoModel.mAdaptive = this.mAdaptive;
            bareVideoModel.mDynamicType = this.mDynamicType;
            bareVideoModel.mLoudness = this.mLoudness;
            bareVideoModel.mPeak = this.mPeak;
            bareVideoModel.mCategory = this.mCategory;
            if (this.mInfos == null) {
                this.mInfos = new ArrayList();
            }
            bareVideoModel.mInfos = this.mInfos;
            bareVideoModel.mPlaceHolder = this.mPlaceHolder;
            return bareVideoModel;
        }

        public Builder adaptive(boolean z) {
            this.mAdaptive = z;
            return this;
        }

        public Builder bid(String str) {
            this.mBid = str;
            return this;
        }

        public Builder category(int i) {
            this.mCategory = i;
            return this;
        }

        public Builder duration(long j) {
            this.mDuration = j;
            return this;
        }

        public Builder dynamicType(String str) {
            this.mDynamicType = str;
            return this;
        }

        public Builder firstSubVideoId(String str) {
            this.mFirstSubVid = str;
            return this;
        }

        public Builder loudness(float f) {
            this.mLoudness = f;
            return this;
        }

        public Builder peak(float f) {
            this.mPeak = f;
            return this;
        }

        public Builder placeHolder(int i) {
            this.mPlaceHolder = i;
            return this;
        }

        public Builder vid(String str) {
            this.mVid = str;
            if (TextUtils.isEmpty(this.mBid)) {
                this.mBid = str;
            }
            return this;
        }

        public Builder addVideoInfo(VideoInfo videoInfo) {
            if (this.mInfos == null) {
                this.mInfos = new ArrayList();
            }
            this.mInfos.add(videoInfo);
            return this;
        }

        public Builder setVideoInfos(List<? extends VideoInfo> list) {
            if (this.mInfos == null) {
                this.mInfos = new ArrayList();
            }
            this.mInfos.clear();
            this.mInfos.addAll(list);
            return this;
        }

        public Builder firstSubVideoId(String str, int i) {
            this.mFirstSubVid = str;
            this.mSubListIndex = i;
            return this;
        }
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public Set<IVideoModel.Format> getFormats() {
        String valueStr;
        HashSet hashSet = new HashSet();
        List<VideoInfo> list = this.mInfos;
        if (list != null) {
            for (VideoInfo videoInfo : list) {
                if (videoInfo != null && (valueStr = videoInfo.getValueStr(6)) != null) {
                    if (valueStr.equals("mp3")) {
                        hashSet.add(IVideoModel.Format.MP3);
                    } else if (valueStr.equals("dash")) {
                        hashSet.add(IVideoModel.Format.DASH);
                    } else if (valueStr.equals("hls")) {
                        hashSet.add(IVideoModel.Format.HLS);
                    } else {
                        valueStr.equals("mp4");
                    }
                }
            }
        }
        hashSet.add(IVideoModel.Format.MP4);
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
        String str;
        if (hasFormat(IVideoModel.Format.MP3)) {
            str = "mp3";
        } else if (hasFormat(IVideoModel.Format.DASH)) {
            str = "dash";
        } else if (hasFormat(IVideoModel.Format.HLS)) {
            str = "hls";
        } else if (hasFormat(IVideoModel.Format.MP4)) {
            str = "mp4";
        } else {
            str = "";
        }
        String videoRefStr = getVideoRefStr(2);
        long j = this.mDuration;
        List<VideoInfo> videoInfoList = getVideoInfoList();
        try {
            HashMap hashMap = new HashMap();
            if (videoInfoList != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<VideoInfo> it2 = videoInfoList.iterator();
                while (it2.hasNext()) {
                    arrayList.add(it2.next().toMediaInfo());
                }
                hashMap.put("infos", arrayList);
            }
            hashMap.put("format", str);
            hashMap.put("vid", videoRefStr);
            hashMap.put("bid", this.mBid);
            hashMap.put("category", Integer.valueOf(getVideoRefInt(232)));
            hashMap.put("placeholder", Integer.valueOf(getVideoRefInt(254)));
            hashMap.put("duration", Long.valueOf(j));
            return new JSONObject(hashMap);
        } catch (Throwable th) {
            TTVideoEngineLog.d(th);
            return null;
        }
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String[] allVideoURLs(Resolution resolution) {
        return allVideoURLs(resolution, null);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution resolution) {
        return getVideoInfo(resolution, (Map<Integer, String>) null);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String resolutionToString(Resolution resolution) {
        return resolution.toString(VideoRef.TYPE_VIDEO);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public float getVideoRefFloat(int i) {
        if (i != 224) {
            if (i != 225) {
                return 0.0f;
            }
            return this.mPeak;
        }
        return this.mLoudness;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String getVideoRefStr(int i) {
        if (i != 2) {
            if (i != 246) {
                return null;
            }
            return this.mBid;
        }
        return this.mVid;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public boolean hasFormat(IVideoModel.Format format) {
        return getFormats().contains(format);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public int getVideoRefInt(int i) {
        if (i != 3) {
            if (i != 7) {
                if (i != 232) {
                    if (i != 254) {
                        return 0;
                    }
                    return this.mPlaceHolder;
                }
                return this.mCategory;
            }
            return VideoRef.TYPE_VIDEO;
        }
        return (int) this.mDuration;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public int fromMediaInfoJsonString(String str) {
        try {
            return fromMediaInfoJsonObject(new JSONObject(str));
        } catch (Exception e) {
            TTVideoEngineLog.i("TTVideoEngine.BareVideoModel", "[GearStrategy]fromMediaInfoJsonString exception=" + e);
            return -1;
        }
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public int fromMediaInfoJsonObject(JSONObject jSONObject) {
        try {
            this.mVid = jSONObject.optString("vid");
            String optString = jSONObject.optString("bid");
            this.mBid = optString;
            if (TextUtils.isEmpty(optString)) {
                this.mBid = this.mVid;
            }
            this.mCategory = jSONObject.optInt("category");
            this.mDuration = jSONObject.optLong("duration");
            JSONArray jSONArray = jSONObject.getJSONArray("infos");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    BareVideoInfo build = new BareVideoInfo.Builder().build();
                    build.fromMediaInfoJsonObject(jSONArray.getJSONObject(i));
                    if (this.mInfos == null) {
                        this.mInfos = new ArrayList();
                    }
                    this.mInfos.add(build);
                }
            }
            return 0;
        } catch (Exception e) {
            TTVideoEngineLog.i("TTVideoEngine.BareVideoModel", "[GearStrategy]fromMediaInfoJsonObject exception=" + e);
            return -1;
        }
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Map<Integer, String> map) {
        boolean z;
        Iterator<VideoInfo> it2 = this.mInfos.iterator();
        while (it2.hasNext()) {
            VideoInfo next = it2.next();
            if (next != null) {
                if (map != null && !map.isEmpty()) {
                    Iterator<Map.Entry<Integer, String>> it4 = map.entrySet().iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            Map.Entry<Integer, String> next2 = it4.next();
                            int intValue = next2.getKey().intValue();
                            String value = next2.getValue();
                            if (!TextUtils.isEmpty(value) && !value.equals(next.getValueStr(intValue))) {
                                z = false;
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        return next;
                    }
                } else {
                    return next;
                }
            }
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public String[] allVideoURLs(Resolution resolution, Map<Integer, String> map) {
        VideoInfo videoInfo = getVideoInfo(resolution, map);
        if (videoInfo == null) {
            return new String[0];
        }
        return videoInfo.getValueStrArr(16);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution resolution, Map<Integer, String> map) {
        return getVideoInfo(resolution, getVideoRefInt(7), map);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution resolution, boolean z) {
        return getVideoInfo(resolution, getVideoRefInt(7), null, z);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution resolution, int i, boolean z) {
        return getVideoInfo(resolution, i, null, z);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution resolution, Map<Integer, String> map, boolean z) {
        return getVideoInfo(resolution, getVideoRefInt(7), map, z);
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution resolution, int i, Map<Integer, String> map) {
        boolean z;
        Iterator<VideoInfo> it2 = this.mInfos.iterator();
        while (it2.hasNext()) {
            VideoInfo next = it2.next();
            if (next != null && resolution == next.getResolution() && i == next.getMediatype()) {
                if (map != null && !map.isEmpty()) {
                    Iterator<Map.Entry<Integer, String>> it4 = map.entrySet().iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            Map.Entry<Integer, String> next2 = it4.next();
                            int intValue = next2.getKey().intValue();
                            String value = next2.getValue();
                            if (!TextUtils.isEmpty(value) && !value.equals(next.getValueStr(intValue))) {
                                z = false;
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        return next;
                    }
                } else {
                    return next;
                }
            }
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.model.IVideoModel
    public VideoInfo getVideoInfo(Resolution resolution, int i, Map<Integer, String> map, boolean z) {
        VideoInfo videoInfo = getVideoInfo(resolution, i, map);
        if (!z) {
            return videoInfo;
        }
        String[] allQualityInfos = TTVideoEngine.getAllQualityInfos();
        int i2 = 0;
        if (allQualityInfos.length > 0 && map != null && map.containsKey(32)) {
            int length = allQualityInfos.length - 1;
            while (videoInfo == null) {
                String str = map.get(32);
                if (str != null) {
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
                    length = i4;
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
