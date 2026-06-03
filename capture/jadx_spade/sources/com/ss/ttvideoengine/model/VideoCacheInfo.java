package com.ss.ttvideoengine.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoCacheInfo {
    public String fileName;
    public String filePath;
    public String filekey;
    public String spadeaKey;

    static {
        Covode.recordClassIndex(652550);
    }

    public VideoCacheInfo(String str, String str2, String str3, String str4) {
        this.filePath = str;
        this.fileName = str2;
        this.filekey = str3;
        this.spadeaKey = str4;
    }
}
