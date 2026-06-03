package com.ss.ttvideoengine.selector;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.log.PortraitNetworkScore;
import com.ss.ttvideoengine.model.IVideoInfo;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.selector.shift.SpeedShiftConfig;
import com.ss.ttvideoengine.selector.shift.SpeedShiftSelector;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BestResolution {
    static {
        Covode.recordClassIndex(652640);
    }

    public static Resolution findDefaultResolution(IVideoModel iVideoModel, Resolution resolution) {
        int abs;
        if (iVideoModel != null && resolution != null) {
            int length = Resolution.getAllResolutions().length;
            Resolution[] supportResolutions = iVideoModel.getSupportResolutions();
            if (supportResolutions != null && supportResolutions.length != 0) {
                Resolution resolution2 = resolution;
                for (Resolution resolution3 : supportResolutions) {
                    if (resolution3 != null && (abs = Math.abs(resolution3.ordinal() - resolution.ordinal())) < length) {
                        resolution2 = resolution3;
                        if (abs == 0) {
                            break;
                        }
                        length = abs;
                    }
                }
                return resolution2;
            }
            return resolution;
        }
        return Resolution.Standard;
    }

    public static Resolution findMaxCacheResolution(IVideoModel iVideoModel, Resolution resolution) {
        if (iVideoModel != null && resolution != null) {
            Resolution[] supportResolutions = iVideoModel.getSupportResolutions();
            if (supportResolutions != null && supportResolutions.length != 0) {
                long j = 0;
                for (Resolution resolution2 : supportResolutions) {
                    long cacheFileSize = TTVideoEngine.getCacheFileSize(iVideoModel, resolution2);
                    if (cacheFileSize > j) {
                        resolution = resolution2;
                        j = cacheFileSize;
                    }
                }
            }
            return resolution;
        }
        return Resolution.Standard;
    }

    public static Resolution findMaxQualityResolution(IVideoModel iVideoModel, Resolution resolution) {
        if (iVideoModel != null && resolution != null) {
            Resolution[] supportResolutions = iVideoModel.getSupportResolutions();
            if (supportResolutions != null && supportResolutions.length != 0) {
                for (Resolution resolution2 : supportResolutions) {
                    if (TTVideoEngine.getCacheFileSize(iVideoModel, resolution2) > 0 && resolution2.ordinal() > resolution.ordinal()) {
                        resolution = resolution2;
                    }
                }
            }
            return resolution;
        }
        return Resolution.Standard;
    }

    public static Resolution findByNetLevel(IVideoModel iVideoModel, Resolution resolution) {
        if (iVideoModel != null && resolution != null) {
            if (iVideoModel instanceof VideoModel) {
                ((VideoModel) iVideoModel).setVideoRefStr(245, "{\"select_resolution\":[\"net_target_bitrate\"]}");
            }
            List<VideoInfo> videoInfoList = iVideoModel.getVideoInfoList();
            if (videoInfoList != null && videoInfoList.size() != 0) {
                double lastTargetBitrate = PortraitNetworkScore.getInstance().getLastTargetBitrate();
                if (lastTargetBitrate <= 0.0d) {
                    return resolution;
                }
                double d = 3.4028234663852886E38d;
                for (VideoInfo videoInfo : videoInfoList) {
                    if (videoInfo != null) {
                        int i = videoInfo.mBitrate;
                        if (i <= lastTargetBitrate && lastTargetBitrate - i < d) {
                            d = lastTargetBitrate - i;
                            resolution = videoInfo.getResolution();
                        }
                    }
                }
            }
            return resolution;
        }
        return Resolution.Standard;
    }

    public static VideoInfo findMaxCacheInfo(IVideoModel iVideoModel, int i) {
        boolean z;
        VideoInfo videoInfo = null;
        if (iVideoModel == null) {
            return null;
        }
        if (i != VideoRef.TYPE_VIDEO && i != VideoRef.TYPE_AUDIO) {
            z = false;
        } else {
            z = true;
        }
        List<VideoInfo> videoInfoList = iVideoModel.getVideoInfoList();
        if (videoInfoList != null && !videoInfoList.isEmpty()) {
            long j = 0;
            for (VideoInfo videoInfo2 : videoInfoList) {
                if (!z || videoInfo2.getMediatype() == i) {
                    long cacheFileSize = DataLoaderHelper.getDataLoader().getCacheFileSize(videoInfo2.getValueStr(15));
                    if (cacheFileSize > j) {
                        videoInfo = videoInfo2;
                        j = cacheFileSize;
                    }
                }
            }
        }
        return videoInfo;
    }

    public static Resolution findAwemeShiftResolution(IVideoModel iVideoModel, Resolution resolution, double d, SpeedShiftConfig speedShiftConfig) {
        IVideoInfo videoInfo;
        if (iVideoModel != null && resolution != null && speedShiftConfig != null && (videoInfo = new SpeedShiftSelector(speedShiftConfig).select(iVideoModel, new SpeedShiftSelector.Params().speed(d).build()).getVideoInfo()) != null) {
            return videoInfo.getResolution();
        }
        return resolution;
    }
}
