package com.ss.ttvideoengine.selector.gracie;

import com.bytedance.covode.number.Covode;
import com.bytedance.vcloud.abrmodule.IPlayStateSupplier;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.strategrycenter.StrategyCenter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import ss1.b;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class GracieStateSupplier implements IPlayStateSupplier {
    IVideoModel mVideoModel;

    static {
        Covode.recordClassIndex(652648);
    }

    public int getCurrentDownloadAudioBitrate() {
        return -1;
    }

    public int getCurrentDownloadAudioSegmentIndex() {
        return -1;
    }

    public int getCurrentDownloadVideoBitrate() {
        return -1;
    }

    public int getCurrentDownloadVideoSegmentIndex() {
        return -1;
    }

    public int getCurrentPlaybackTime() {
        return -1;
    }

    public int getLoaderType() {
        return -1;
    }

    public int getMaxCacheAudioTime() {
        return -1;
    }

    public int getMaxCacheVideoTime() {
        return -1;
    }

    public float getPlaySpeed() {
        return 1.0f;
    }

    public int getPlayerAudioCacheTime() {
        return -1;
    }

    public int getPlayerVideoCacheTime() {
        return 0;
    }

    public List<Object> getSegmentInfoList(int i, int i2) {
        return null;
    }

    public Queue<Object> getTimelineNetworkSpeed() {
        return null;
    }

    public float getNetworkSpeed() {
        b bVar = StrategyCenter.sNetAbrSpeedPredictor;
        if (bVar != null) {
            return bVar.d(0);
        }
        return -1.0f;
    }

    public int getNetworkState() {
        return DataLoaderHelper.getDataLoader().getIntValue(1008);
    }

    public float getSpeedConfidence() {
        b bVar = StrategyCenter.sNetAbrSpeedPredictor;
        if (bVar != null) {
            return bVar.a();
        }
        return -1.0f;
    }

    public float getDownloadSpeed() {
        Map f;
        b bVar = StrategyCenter.sNetAbrSpeedPredictor;
        if (bVar != null && (f = bVar.f(VideoRef.TYPE_VIDEO)) != null && f.get("download_speed") != null) {
            return Float.parseFloat((String) f.get("download_speed"));
        }
        return -1.0f;
    }

    public Map<String, Object> getAudioBufferInfo() {
        HashMap hashMap = new HashMap();
        List<VideoInfo> videoInfoList = this.mVideoModel.getVideoInfoList();
        if (videoInfoList != null && videoInfoList.size() != 0) {
            for (VideoInfo videoInfo : videoInfoList) {
                if (videoInfo != null && videoInfo.getMediatype() == VideoRef.TYPE_AUDIO) {
                    rs1.b bVar = new rs1.b();
                    String valueStr = videoInfo.getValueStr(15);
                    bVar.a = valueStr;
                    bVar.c = TTVideoEngine.getCacheFileSize(valueStr);
                    if (videoInfo.getBitrateFitterInfo() != null) {
                        bVar.d = r4.getHeaderSize();
                    }
                    hashMap.put("" + videoInfo.getValueInt(3), bVar);
                }
            }
        }
        return hashMap;
    }

    public Map<String, Object> getVideoBufferInfo() {
        HashMap hashMap = new HashMap();
        List<VideoInfo> videoInfoList = this.mVideoModel.getVideoInfoList();
        if (videoInfoList != null && videoInfoList.size() != 0) {
            for (VideoInfo videoInfo : videoInfoList) {
                if (videoInfo != null && videoInfo.getMediatype() == VideoRef.TYPE_VIDEO) {
                    rs1.b bVar = new rs1.b();
                    String valueStr = videoInfo.getValueStr(15);
                    bVar.a = valueStr;
                    bVar.c = TTVideoEngine.getCacheFileSize(valueStr);
                    if (videoInfo.getBitrateFitterInfo() != null) {
                        bVar.d = r4.getHeaderSize();
                    }
                    hashMap.put("" + videoInfo.getValueInt(3), bVar);
                }
            }
        }
        return hashMap;
    }

    private GracieStateSupplier(IVideoModel iVideoModel) {
        this.mVideoModel = iVideoModel;
    }

    public float getAverageDownloadSpeed(int i, int i2, boolean z) {
        b bVar = StrategyCenter.sNetAbrSpeedPredictor;
        if (bVar != null) {
            return bVar.c(i, i2, z);
        }
        return -1.0f;
    }
}
