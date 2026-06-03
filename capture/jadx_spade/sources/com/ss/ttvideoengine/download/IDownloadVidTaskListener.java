package com.ss.ttvideoengine.download;

import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IDownloadVidTaskListener {
    String apiString(Map<String, String> map, String str, int i);

    String authString(String str, int i);
}
