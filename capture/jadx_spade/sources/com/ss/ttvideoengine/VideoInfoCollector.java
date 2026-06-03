package com.ss.ttvideoengine;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoInfoCollector {
    private static final VideoInfoCollector ourInstance;
    private long mWastedDataSize = 0;
    private long mPlayConsumedSize = 0;
    private final HashMap<Long, WeakReference<TTVideoEngine>> mActiveEngines = new HashMap<>();

    public static VideoInfoCollector getInstance() {
        return ourInstance;
    }

    public static class myVideoCollectorAddConsumeSize implements Runnable {
        long mConsumeSize;

        static {
            Covode.recordClassIndex(652389);
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoInfoCollector videoInfoCollector = VideoInfoCollector.getInstance();
            if (videoInfoCollector != null) {
                videoInfoCollector.addPlayConsumedSize(this.mConsumeSize);
            }
        }

        public myVideoCollectorAddConsumeSize(long j) {
            this.mConsumeSize = j;
        }
    }

    static class myVideoCollectorUnregister implements Runnable {
        long mSerial;

        static {
            Covode.recordClassIndex(652391);
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoInfoCollector videoInfoCollector = VideoInfoCollector.getInstance();
            if (videoInfoCollector != null) {
                videoInfoCollector.unregistEngine(this.mSerial);
            }
        }

        public myVideoCollectorUnregister(long j) {
            this.mSerial = j;
        }
    }

    static {
        Covode.recordClassIndex(652388);
        ourInstance = new VideoInfoCollector();
    }

    public synchronized long getPlayConsumedSize() {
        long j;
        j = this.mPlayConsumedSize;
        this.mPlayConsumedSize = 0L;
        return j;
    }

    static class myVideoCollectorRegister implements Runnable {
        long mSerial;
        private final WeakReference<TTVideoEngine> mVideoEngineRef;

        static {
            Covode.recordClassIndex(652390);
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoInfoCollector videoInfoCollector;
            TTVideoEngine tTVideoEngine = this.mVideoEngineRef.get();
            if (tTVideoEngine != null && (videoInfoCollector = VideoInfoCollector.getInstance()) != null) {
                videoInfoCollector.registEngine(this.mSerial, tTVideoEngine);
            }
        }

        public myVideoCollectorRegister(TTVideoEngine tTVideoEngine, long j) {
            this.mVideoEngineRef = new WeakReference<>(tTVideoEngine);
            this.mSerial = j;
        }
    }

    private VideoInfoCollector() {
    }

    public synchronized long getPlayWastDataSize() {
        long j;
        j = this.mWastedDataSize;
        this.mWastedDataSize = 0L;
        try {
            Iterator<WeakReference<TTVideoEngine>> it2 = this.mActiveEngines.values().iterator();
            while (it2.hasNext()) {
                TTVideoEngine tTVideoEngine = it2.next().get();
                if (tTVideoEngine != null) {
                    long longOption = tTVideoEngine.getLongOption(81);
                    if (longOption > 0) {
                        j += longOption;
                    }
                }
            }
            TTVideoEngineLog.d("VideoInfoCollecor", "get play waste data size: " + j);
        } catch (Exception unused) {
            return j;
        }
        return j;
    }

    public synchronized void addPlayConsumedSize(long j) {
        if (j > 0) {
            this.mPlayConsumedSize += j;
        }
    }

    public synchronized void unregistEngine(long j) {
        try {
            if (this.mActiveEngines.containsKey(Long.valueOf(j))) {
                TTVideoEngine tTVideoEngine = this.mActiveEngines.get(Long.valueOf(j)).get();
                if (tTVideoEngine == null) {
                    return;
                }
                long longOption = tTVideoEngine.getLongOption(81);
                if (longOption > 0) {
                    this.mWastedDataSize += longOption;
                }
                this.mActiveEngines.remove(Long.valueOf(j));
                TTVideoEngineLog.d("VideoInfoCollecor", "delete engine: " + j + ", waste data: " + longOption);
            }
        } catch (Exception unused) {
        }
    }

    public synchronized void registEngine(long j, TTVideoEngine tTVideoEngine) {
        if (!this.mActiveEngines.containsKey(Long.valueOf(j)) && tTVideoEngine != null) {
            this.mActiveEngines.put(Long.valueOf(j), new WeakReference<>(tTVideoEngine));
            TTVideoEngineLog.d("VideoInfoCollecor", "new engine: " + j);
        }
    }
}
