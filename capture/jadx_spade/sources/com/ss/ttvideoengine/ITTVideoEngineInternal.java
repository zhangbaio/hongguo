package com.ss.ttvideoengine;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.PlaybackParams;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface ITTVideoEngineInternal {
    public static final int PLAYER_OPTION_ENABEL_HARDWARE_DECODE = 7;
    public static final int PLAYER_OPTION_GET_WATCHED_DUTATION = 53;

    static {
        Covode.recordClassIndex(652290);
    }

    int getBufferingType();

    int getCurrentPlaybackTime();

    int getCurrentPlaybackTimeAsync();

    int getDuration();

    float getFloatOption(int i);

    int getIntOption(int i);

    int getLoadState();

    int getLoadedProgress();

    long getLongOption(int i);

    int getPlaybackState();

    String getStringOption(int i);

    Surface getSurface();

    int getVideoHeight();

    int getVideoWidth();

    float getVolume();

    int getWatchedDuration();

    void initEngine(Context context, int i);

    boolean isLooping();

    boolean isMute();

    boolean isOSPlayer();

    boolean isPlayerType(int i);

    boolean isShouldPlay();

    boolean isStarted();

    void pause();

    void play();

    void prepare();

    void release();

    void releaseAsync();

    void resetEngine();

    void seekTo(int i, SeekCompletionListener seekCompletionListener);

    void setAsyncInit(boolean z, int i);

    void setDirectURL(String str);

    void setFloatOption(int i, float f);

    void setIntOption(int i, int i2);

    void setIsMute(boolean z);

    void setLocalURL(String str);

    void setLongOption(int i, long j);

    void setLooping(boolean z);

    void setPlaybackParams(PlaybackParams playbackParams);

    void setStringOption(int i, String str);

    void setSubTag(String str);

    void setSurface(Surface surface);

    void setSurfaceHolder(SurfaceHolder surfaceHolder);

    void setTag(String str);

    void setVolume(float f, float f2);

    void start();

    void stop();
}
