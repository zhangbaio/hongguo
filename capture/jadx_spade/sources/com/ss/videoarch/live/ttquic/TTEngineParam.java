package com.ss.videoarch.live.ttquic;

import android.os.Environment;
import com.bytedance.covode.number.Covode;
import java.io.File;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class TTEngineParam {
    public static final String DEFAULT_CACHE_PATH;
    public String agentName = "ttplayer-live";
    public int cacheMaxSize;
    public String cachePath;
    public String flvCachePath;
    public int logLevel;

    TTEngineParam() {
        String str = DEFAULT_CACHE_PATH;
        this.cachePath = str;
        this.flvCachePath = str;
        this.cacheMaxSize = 209715200;
        this.logLevel = 2;
    }

    static {
        Covode.recordClassIndex(652888);
        DEFAULT_CACHE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Environment.DIRECTORY_DOWNLOADS;
    }
}
