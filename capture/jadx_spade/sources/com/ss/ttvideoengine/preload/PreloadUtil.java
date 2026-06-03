package com.ss.ttvideoengine.preload;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PreloadUtil {
    public long mPlayBufferLowerBound = 0;
    public long mPlayBufferUpperBound = 0;
    private final ReentrantLock mPlayInfoLock = new ReentrantLock();
    private final HashMap<String, PlayInfo> mPlayInfoMap = new HashMap<>();

    static {
        Covode.recordClassIndex(652637);
    }

    static class PlayInfo {
        long mLastPlayableBuffer = 0;
        long mLastPlayPosition = 0;
        long mDuration = 0;
        String mVideoID = "";
        boolean mCacheEnd = false;
        boolean mTriggered = false;

        static {
            Covode.recordClassIndex(652638);
        }

        PlayInfo() {
        }
    }

    public void removePlayInfo(String str) {
        this.mPlayInfoLock.lock();
        if (this.mPlayInfoMap.containsKey(str)) {
            this.mPlayInfoMap.remove(str);
        }
        this.mPlayInfoLock.unlock();
    }

    private void checkPlayBuffer(String str) {
        PlayInfo playInfo = this.mPlayInfoMap.get(str);
        if (playInfo == null) {
            return;
        }
        if (playInfo.mLastPlayableBuffer > this.mPlayBufferUpperBound && !playInfo.mTriggered) {
            TTVideoEngineLog.d("PreloadUtil", "trigger preload " + str + " playable buffer is: " + playInfo.mLastPlayableBuffer);
            DataLoaderHelper.getDataLoader().notifyTriggerPreload(playInfo.mLastPlayableBuffer);
            playInfo.mTriggered = true;
        }
        if (!playInfo.mCacheEnd) {
            long j = playInfo.mDuration;
            if (j <= 0 || playInfo.mLastPlayableBuffer + playInfo.mLastPlayPosition + 1000 < j) {
                if (playInfo.mLastPlayableBuffer < this.mPlayBufferLowerBound) {
                    long preloadTaskCount = DataLoaderHelper.getDataLoader().getPreloadTaskCount();
                    if (playInfo.mTriggered && preloadTaskCount > 0) {
                        cancelPreload("low_buffer", str);
                        playInfo.mTriggered = false;
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (!playInfo.mTriggered) {
            TTVideoEngineLog.d("PreloadUtil", "cached video trigger preload " + str + " playable buffer is: " + playInfo.mLastPlayableBuffer);
            DataLoaderHelper.getDataLoader().notifyTriggerPreload(playInfo.mLastPlayableBuffer);
            playInfo.mTriggered = true;
        }
    }

    public void notifyCacheEnd(String str) {
        this.mPlayInfoLock.lock();
        if (!this.mPlayInfoMap.containsKey(str)) {
            if (this.mPlayInfoMap.size() >= 2) {
                this.mPlayInfoMap.clear();
            }
            this.mPlayInfoMap.put(str, new PlayInfo());
        }
        TTVideoEngineLog.d("PreloadUtil", "key :" + str + " cache end.");
        PlayInfo playInfo = this.mPlayInfoMap.get(str);
        if (playInfo != null) {
            playInfo.mCacheEnd = true;
            if (!playInfo.mTriggered) {
                TTVideoEngineLog.d("PreloadUtil", "cached video trigger preload " + str + " cache end ");
                DataLoaderHelper.getDataLoader().notifyTriggerPreload(playInfo.mLastPlayableBuffer);
                playInfo.mTriggered = true;
            }
        } else {
            TTVideoEngineLog.d("PreloadUtil", "key :" + str + " play info null");
        }
        this.mPlayInfoLock.unlock();
    }

    private void cancelPreload(String str, String str2) {
        TTVideoEngineLog.d("PreloadUtil", "cancel preload because:" + str + " traceId:" + str2);
        DataLoaderHelper.getDataLoader().cancelAllTasks();
        DataLoaderHelper.getDataLoader().notifyPreloadCancelled(str, str2);
    }

    public void updatePlayInfo(int i, String str, String str2, long j) {
        this.mPlayInfoLock.lock();
        if (!this.mPlayInfoMap.containsKey(str2)) {
            if (this.mPlayInfoMap.size() >= 2) {
                this.mPlayInfoMap.clear();
            }
            PlayInfo playInfo = new PlayInfo();
            playInfo.mVideoID = str2;
            this.mPlayInfoMap.put(str2, playInfo);
        }
        PlayInfo playInfo2 = this.mPlayInfoMap.get(str2);
        if (playInfo2 == null) {
            this.mPlayInfoLock.unlock();
            return;
        }
        if (i != 22) {
            if (i != 23) {
                if (i != 25) {
                    if (i == 27) {
                        playInfo2.mLastPlayableBuffer = j;
                        checkPlayBuffer(str2);
                    }
                } else {
                    cancelPreload("buffering", str2);
                }
            } else {
                playInfo2.mLastPlayPosition = j;
                checkPlayBuffer(str2);
            }
        } else {
            playInfo2.mDuration = j;
        }
        this.mPlayInfoLock.unlock();
    }
}
