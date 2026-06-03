package com.ss.ttvideoengine.preRender;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.preRender.Timer;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PlayBuffer implements Timer.TimerListener {
    private TTVideoEngine mEngine;
    private final CopyOnWriteArrayList<PlayBufferListener> mListeners = new CopyOnWriteArrayList<>();
    private final Timer mTimer;

    static {
        Covode.recordClassIndex(652611);
    }

    @Override // com.ss.ttvideoengine.preRender.Timer.TimerListener
    public void trigger() {
        checkBuffer();
    }

    public void start() {
        this.mTimer.addTimerListener(this);
        this.mTimer.start();
    }

    public void stop() {
        TTVideoEngineLog.d("PreRender_PlayBuffer", "stop");
        this.mTimer.removeTimerListener(this);
        this.mTimer.stop();
        this.mEngine = null;
    }

    private void checkBuffer() {
        MediaPlayer mediaPlayer;
        long max;
        TTVideoEngine tTVideoEngine = this.mEngine;
        if (tTVideoEngine != null && !tTVideoEngine.isReleased()) {
            if (this.mListeners.isEmpty() || (mediaPlayer = tTVideoEngine.getMediaPlayer()) == null) {
                return;
            }
            long longOption = mediaPlayer.getLongOption(73, -1L);
            long longOption2 = mediaPlayer.getLongOption(72, -1L);
            int intOption = mediaPlayer.getIntOption(62, 0);
            int intOption2 = mediaPlayer.getIntOption(61, 0);
            if (intOption == 1 && intOption2 == 1) {
                max = Math.max(0L, Math.min(longOption, longOption2));
            } else if (intOption2 == 1) {
                max = Math.max(0L, longOption);
            } else if (intOption == 1) {
                max = Math.max(0L, longOption2);
            } else {
                return;
            }
            if (!isMdlCacheEnd(tTVideoEngine) && !isPlayCacheEnd(tTVideoEngine, max)) {
                Iterator<PlayBufferListener> it2 = this.mListeners.iterator();
                while (it2.hasNext()) {
                    PlayBufferListener next = it2.next();
                    if (next != null) {
                        next.onCacheSize(tTVideoEngine, max);
                    }
                }
                return;
            }
            Iterator<PlayBufferListener> it4 = this.mListeners.iterator();
            while (it4.hasNext()) {
                PlayBufferListener next2 = it4.next();
                if (next2 != null) {
                    next2.onCacheEnd(tTVideoEngine);
                }
            }
            return;
        }
        TTVideoEngineLog.d("PreRender_PlayBuffer", "stop engine null");
        stop();
    }

    public void setEngine(TTVideoEngine tTVideoEngine) {
        this.mEngine = tTVideoEngine;
    }

    public void removePlayBufferListener(PlayBufferListener playBufferListener) {
        this.mListeners.remove(playBufferListener);
    }

    PlayBuffer(Timer timer) {
        this.mTimer = timer;
    }

    public void addPlayBufferListener(PlayBufferListener playBufferListener) {
        if (playBufferListener == null) {
            return;
        }
        this.mListeners.addIfAbsent(playBufferListener);
    }

    private boolean isMdlCacheEnd(TTVideoEngine tTVideoEngine) {
        List<String> cacheKeys;
        if (tTVideoEngine == null || (cacheKeys = tTVideoEngine.getCacheKeys()) == null || cacheKeys.size() <= 0) {
            return false;
        }
        Iterator<String> it2 = cacheKeys.iterator();
        boolean z = true;
        while (it2.hasNext()) {
            DataLoaderHelper.DataLoaderCacheInfo cacheInfo = TTVideoEngine.getCacheInfo(it2.next());
            if (cacheInfo == null || cacheInfo.mMediaSize > cacheInfo.mCacheSizeFromZero) {
                z = false;
            }
        }
        return z;
    }

    private boolean isPlayCacheEnd(TTVideoEngine tTVideoEngine, long j) {
        int duration = tTVideoEngine.getDuration();
        int currentPlaybackTime = tTVideoEngine.getCurrentPlaybackTime();
        if (duration > 0 && j + currentPlaybackTime + 1000 >= duration) {
            return true;
        }
        return false;
    }
}
