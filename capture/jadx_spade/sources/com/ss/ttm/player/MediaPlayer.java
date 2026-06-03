package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ImageReader;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.covode.number.Covode;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface MediaPlayer {
    public static final int MEDIA_PLAYER_OPTION_ABR_STREAM_INFO = 147;
    public static final int MEDIA_PLAYER_OPTION_APPID = 512;
    public static final int MEDIA_PLAYER_OPTION_CODECPOOL_RESPONSE = 1331;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE = 514;
    public static final int MEDIA_PLAYER_OPTION_HTTP_LOAD_PER_PERCENT = 18;
    public static final int MEDIA_PLAYER_OPTION_HTTP_RECONNECT = 7;
    public static final int MEDIA_PLAYER_OPTION_HTTP_TIMEOUT = 9;
    public static final int MEDIA_PLAYER_OPTION_LICENSE_DIR = 510;
    public static final int MEDIA_PLAYER_OPTION_LICENSE_FILENAME = 511;
    public static final int MEDIA_PLAYER_OPTION_MODULE_ID = 513;
    public static final int MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE = 882;
    public static final int MEDIA_PLAYER_OPTION_USE_TARGET_WINDOW = 42001;
    public static final int[] MEDIA_PLAYER_SUPPORT_SAMPLERATES;
    public static final int MEDIA_PLAYER_TEST_SURFACE_CHANGED_VALUE = 2;

    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(MediaPlayer mediaPlayer, int i);
    }

    public interface OnCompletionListener {
        void onCompletion(MediaPlayer mediaPlayer);
    }

    public interface OnErrorListener {
        boolean onError(MediaPlayer mediaPlayer, int i, int i2);
    }

    public interface OnExternInfoListener {

        /* renamed from: com.ss.ttm.player.MediaPlayer$OnExternInfoListener$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onExternInfo2(OnExternInfoListener onExternInfoListener, MediaPlayer mediaPlayer, int i, int i2, String str) {
            }
        }

        void onExternInfo(MediaPlayer mediaPlayer, int i, String str);

        void onExternInfo2(MediaPlayer mediaPlayer, int i, int i2, String str);
    }

    public interface OnInfoListener {
        boolean onInfo(MediaPlayer mediaPlayer, int i, int i2);
    }

    public interface OnLogListener {
        void onLogInfo(MediaPlayer mediaPlayer, String str);
    }

    public interface OnPreparedListener {
        void onPrepared(MediaPlayer mediaPlayer);
    }

    public interface OnScreenshotListener {
        void onTakeScreenShotCompletion(Bitmap bitmap);
    }

    public interface OnSeekCompleteListener {
        void onSeekComplete(MediaPlayer mediaPlayer);
    }

    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2);
    }

    public interface onSARChangedListener {
        void onSARChanged(MediaPlayer mediaPlayer, int i, int i2);
    }

    void deselectTrack(int i);

    int getCurrentPosition();

    String getDataSource();

    int getDuration();

    float getFloatOption(int i, float f);

    int getIntOption(int i, int i2);

    long getLongOption(int i, long j);

    int getPlayerType();

    int getSelectedTrack(int i);

    String getStringOption(int i);

    TrackInfo[] getTrackInfo();

    int getVideoHeight();

    int getVideoType();

    int getVideoWidth();

    boolean isLooping();

    boolean isMute();

    boolean isOSPlayer();

    boolean isPlaying();

    void mouseEvent(int i, int i2, int i3);

    void pause();

    void preDemux();

    void prepare();

    void prepareAsync();

    void prevClose();

    void release();

    void releaseAsync();

    void reset();

    void rotateCamera(float f, float f2);

    void seekTo(int i);

    void selectTrack(int i);

    void setCacheFile(String str, int i);

    void setDataSource(Context context, Uri uri) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    void setDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, IOException;

    void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IllegalArgumentException, IOException;

    void setDataSource(String str) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    void setDisplay(SurfaceHolder surfaceHolder);

    int setFloatOption(int i, float f);

    void setFloatOptionArray(int[] iArr, float[] fArr);

    void setIntOption(int i, int i2);

    void setIntOptionArray(int[] iArr, int[] iArr2);

    void setIsMute(boolean z);

    long setLongOption(int i, long j);

    void setLongOptionArray(int[] iArr, long[] jArr);

    void setLooping(boolean z);

    void setMediaTransport(MediaTransport mediaTransport);

    void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnExternInfoListener(OnExternInfoListener onExternInfoListener);

    void setOnImageAvailableListener(ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnLogListener(OnLogListener onLogListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSARChangedListener(onSARChangedListener onsarchangedlistener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setPanoVideoControlModel(int i);

    void setPlaybackParams(PlaybackParams playbackParams);

    void setScreenOnWhilePlaying(boolean z);

    void setStringOption(int i, String str);

    void setStringOptionArray(int[] iArr, String[] strArr);

    void setSurface(Surface surface);

    void setSurfaceTimeOut(Surface surface, int i);

    void setTraitObject(int i, TraitObject traitObject);

    void setVolume(float f, float f2);

    void setWakeMode(Context context, int i);

    void setWindowClient(TTAVWindowClient tTAVWindowClient);

    void start();

    void stop();

    void switchStream(int i, int i2);

    void takeScreenshot(OnScreenshotListener onScreenshotListener);

    public static class TrackInfo {
        private MediaFormat mFormat;
        private String mLanguage;
        private int mStreamType;

        static {
            Covode.recordClassIndex(652135);
        }

        public MediaFormat getFormat() {
            return this.mFormat;
        }

        public String getLanguage() {
            return this.mLanguage;
        }

        public int getTrackType() {
            return this.mStreamType;
        }

        public TrackInfo(MediaPlayer.TrackInfo trackInfo) {
            this.mStreamType = trackInfo.getTrackType();
            this.mLanguage = trackInfo.getLanguage();
            int i = this.mStreamType;
            if (i == 2) {
                this.mFormat = MediaFormat.createAudioFormat(trackInfo.getFormat());
            } else if (i == 1) {
                this.mFormat = MediaFormat.createVideoFormat(trackInfo.getFormat());
            } else if (i == 4) {
                this.mFormat = MediaFormat.createSubtitleFormat(trackInfo.getFormat());
            }
        }

        public TrackInfo(int i, MediaFormat mediaFormat) {
            this.mFormat = mediaFormat;
            this.mStreamType = 0;
            if (i == 1) {
                this.mStreamType = 2;
            } else if (i == 0) {
                this.mStreamType = 1;
            } else if (i == 2) {
                this.mStreamType = 4;
            }
            this.mLanguage = "zh-cn";
        }
    }

    static {
        Covode.recordClassIndex(652124);
        MEDIA_PLAYER_SUPPORT_SAMPLERATES = TTPlayerKeys.SupportSampleRates;
    }

    /* renamed from: com.ss.ttm.player.MediaPlayer$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$preDemux(MediaPlayer mediaPlayer) {
        }

        public static void $default$setFloatOptionArray(MediaPlayer mediaPlayer, int[] iArr, float[] fArr) {
        }

        public static void $default$setIntOptionArray(MediaPlayer mediaPlayer, int[] iArr, int[] iArr2) {
        }

        public static void $default$setLongOptionArray(MediaPlayer mediaPlayer, int[] iArr, long[] jArr) {
        }

        public static void $default$setOnImageAvailableListener(MediaPlayer mediaPlayer, ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) {
        }

        public static void $default$setStringOptionArray(MediaPlayer mediaPlayer, int[] iArr, String[] strArr) {
        }

        public static void $default$setSurfaceTimeOut(MediaPlayer mediaPlayer, Surface surface, int i) {
        }

        public static void $default$setTraitObject(MediaPlayer mediaPlayer, int i, TraitObject traitObject) {
        }

        public static void $default$setWindowClient(MediaPlayer mediaPlayer, TTAVWindowClient tTAVWindowClient) {
            throw new RuntimeException("Not implements");
        }
    }
}
