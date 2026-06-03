package com.ss.ttvideoengine;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.utils.Error;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PreLoaderItemCallBackInfo {
    private int mKey;
    public List<VideoInfo> usingUrlInfos = null;
    public DataLoaderHelper.DataLoaderTaskProgressInfo preloadDataInfo = null;
    public DataLoaderHelper.DataLoaderTaskLoadProgress loadProgress = null;
    public Error preloadError = null;
    public VideoModel fetchVideoModel = null;
    public String businessContext = null;
    public String fileHash = null;
    public int preloadType = 0;
    public long audioPreloadSize = 0;
    public long videoPreloadSize = 0;

    static {
        Covode.recordClassIndex(652304);
    }

    public int getKey() {
        return this.mKey;
    }

    public PreLoaderItemCallBackInfo(int i) {
        this.mKey = i;
    }
}
