package com.ss.ttvideoengine;

import com.ss.ttvideoengine.model.VideoInfo;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface PreloaderVidItemListener {
    String apiString(Map<String, String> map, String str, int i);

    String authString(String str, int i);

    void onUsingUrlInfos(List<VideoInfo> list);
}
