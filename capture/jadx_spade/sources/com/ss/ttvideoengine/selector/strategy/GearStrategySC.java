package com.ss.ttvideoengine.selector.strategy;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.model.IVideoInfo;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.strategrycenter.StrategyHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class GearStrategySC {
    static {
        Covode.recordClassIndex(652673);
    }

    private static IVideoInfo findLowestBitrate(IVideoModel iVideoModel) {
        List<VideoInfo> videoInfoList = iVideoModel.getVideoInfoList();
        VideoInfo videoInfo = null;
        if (videoInfoList == null) {
            TTVideoEngineLog.e("TTVideoEngine.GearStrategySC", "[GearStrategy] videoModel videoInfoList is null!!");
            return null;
        }
        for (VideoInfo videoInfo2 : videoInfoList) {
            if (videoInfo2 != null && videoInfo2.getMediatype() == VideoRef.TYPE_VIDEO && (videoInfo == null || videoInfo.getValueInt(3) >= videoInfo2.getValueInt(3))) {
                videoInfo = videoInfo2;
            }
        }
        return videoInfo;
    }

    private static IVideoInfo parseSelectResult(IVideoModel iVideoModel, Map<String, String> map) {
        int i = 0;
        try {
            i = Integer.parseInt(String.valueOf(map.get("video_bitrate")));
            Integer.parseInt(String.valueOf(map.get("audio_bitrate")));
            Integer.parseInt(String.valueOf(map.get("video_bitrate_before")));
        } catch (Throwable th) {
            TTVideoEngineLog.i("TTVideoEngine.GearStrategySC", "[GearStrategy]GearStrategy parse result failed" + th.toString());
        }
        List<VideoInfo> videoInfoList = iVideoModel.getVideoInfoList();
        VideoInfo videoInfo = null;
        if (videoInfoList == null) {
            TTVideoEngineLog.e("TTVideoEngine.GearStrategySC", "[GearStrategy] videoModel videoInfoList is null!!");
            return null;
        }
        for (VideoInfo videoInfo2 : videoInfoList) {
            if (videoInfo2 != null) {
                if (videoInfo2.getValueInt(3) == i) {
                    return videoInfo2;
                }
                if (videoInfo == null) {
                    videoInfo = videoInfo2;
                }
            }
        }
        return videoInfo;
    }

    public static IVideoInfo selectBitrate(IVideoModel iVideoModel, int i, Map<String, Object> map, Map<String, String> map2) {
        if (iVideoModel == null) {
            TTVideoEngineLog.w("TTVideoEngine.GearStrategySC", "[GearStrategy] select bitrate but videomodel is null!!");
            return null;
        }
        TTVideoEngineLog.i("TTVideoEngine.GearStrategySC", "[GearStrategy]GearStrategy.selectBitrate select start type: " + i + ", videoId:" + iVideoModel.getVideoRefStr(2));
        Map<String, String> selectResolutionStringMapV2 = StrategyHelper.helper().selectResolutionStringMapV2(iVideoModel, i, map);
        if (selectResolutionStringMapV2 != null) {
            TTVideoEngineLog.d("TTVideoEngine.GearStrategySC", "[GearStrategy]GearStrategy select result: " + selectResolutionStringMapV2);
            if (map2 != null) {
                map2.putAll(selectResolutionStringMapV2);
            }
            return parseSelectResult(iVideoModel, selectResolutionStringMapV2);
        }
        return findLowestBitrate(iVideoModel);
    }
}
