package com.ss.ttvideoengine.model;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IVideoModel {
    String[] allVideoURLs(Resolution resolution);

    String[] allVideoURLs(Resolution resolution, Map<Integer, String> map);

    int fromMediaInfoJsonObject(JSONObject jSONObject);

    int fromMediaInfoJsonString(String str);

    String[] getCodecs();

    JSONObject getDnsInfo();

    String getDynamicType();

    Set<Format> getFormats();

    JSONObject getMediaInfo();

    List<Integer> getOriginalAudioInfo();

    Source getSource();

    String getSpadea();

    List<SubInfo> getSubInfoList();

    List<Integer> getSupportInfoId(int i);

    String[] getSupportQualityInfos();

    Resolution[] getSupportResolutions();

    int[] getSupportSubtitleLangs();

    List<Integer> getSupportedTTSAudioInfo();

    String getVType();

    VideoInfo getVideoInfo(Resolution resolution);

    VideoInfo getVideoInfo(Resolution resolution, int i, Map<Integer, String> map);

    VideoInfo getVideoInfo(Resolution resolution, int i, Map<Integer, String> map, boolean z);

    VideoInfo getVideoInfo(Resolution resolution, int i, boolean z);

    VideoInfo getVideoInfo(Resolution resolution, Map<Integer, String> map);

    VideoInfo getVideoInfo(Resolution resolution, Map<Integer, String> map, boolean z);

    VideoInfo getVideoInfo(Resolution resolution, boolean z);

    VideoInfo getVideoInfo(Map<Integer, String> map);

    VideoInfo getVideoInfoByInfoId(int i);

    List<VideoInfo> getVideoInfoList();

    boolean getVideoRefBool(int i);

    float getVideoRefFloat(int i);

    int getVideoRefInt(int i);

    long getVideoRefLong(int i);

    String getVideoRefStr(int i);

    VideoStyle getVideoStyle();

    boolean hasData();

    boolean hasFormat(Format format);

    boolean isSupportBash();

    boolean isSupportHLSSeamlessSwitch();

    String resolutionToString(Resolution resolution);

    void setUpResolution(HashMap<String, Resolution> hashMap);

    String toMediaInfoJsonString();

    public enum Source {
        None,
        LIVE,
        VOD,
        BARE;

        static {
            Covode.recordClassIndex(652537);
        }
    }

    public enum Format {
        NONE,
        MP4,
        DASH,
        HLS,
        MP3;

        static {
            Covode.recordClassIndex(652536);
        }
    }
}
