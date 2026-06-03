package com.ss.ttvideoengine;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.model.VideoInfo;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoEngineInfos {
    String mKey;
    Object mObject;
    List<VideoInfo> mUrlInfos;
    String mUsingMDLPlayTaskKey = null;
    String mUsingMDLPlayFilePath = null;
    long mHitCacheSize = 0;
    String mGroupID = "";

    static {
        Covode.recordClassIndex(652383);
    }

    public String getGroupID() {
        return this.mGroupID;
    }

    public String getKey() {
        return this.mKey;
    }

    public Object getObject() {
        return this.mObject;
    }

    public List<VideoInfo> getUrlInfos() {
        return this.mUrlInfos;
    }

    public long getUsingMDLHitCacheSize() {
        return this.mHitCacheSize;
    }

    public String getUsingMDLPlayTaskKey() {
        return this.mUsingMDLPlayTaskKey;
    }

    public String getmUsingMDLPlayFilePath() {
        return this.mUsingMDLPlayFilePath;
    }

    public void setGroupID(String str) {
        this.mGroupID = str;
    }

    public void setKey(String str) {
        this.mKey = str;
    }

    public void setObject(Object obj) {
        this.mObject = obj;
    }

    public void setUrlInfos(List<VideoInfo> list) {
        this.mUrlInfos = list;
    }

    public void setUsingMDLHitCacheSize(long j) {
        if (j >= 0) {
            this.mHitCacheSize = j;
        }
    }

    public void setUsingMDLPlayTaskKey(String str) {
        if (str.isEmpty()) {
            return;
        }
        this.mUsingMDLPlayTaskKey = str;
    }
}
