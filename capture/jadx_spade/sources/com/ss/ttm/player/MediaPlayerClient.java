package com.ss.ttm.player;

import android.content.Context;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class MediaPlayerClient {
    static {
        Covode.recordClassIndex(652137);
    }

    public abstract void deselectTrack(int i);

    public abstract int getCurrentPosition();

    public String getDataSource() {
        return null;
    }

    public double getDoubleOption(int i, double d) {
        return d;
    }

    public abstract int getDuration();

    public float getFloatOption(int i, float f) {
        return f;
    }

    public int getIntOption(int i, int i2) {
        return i2;
    }

    public long getLongOption(int i, long j) {
        return j;
    }

    public Object getObjectOption(int i) {
        return null;
    }

    public abstract int getSelectedTrack(int i);

    public String getStringOption(int i) {
        return null;
    }

    public String getSubtitleContent(int i) {
        return null;
    }

    public abstract MediaPlayer.TrackInfo[] getTrackInfo();

    public abstract int getType();

    public abstract int getVideoHeight();

    public int getVideoType() {
        return 0;
    }

    public abstract int getVideoWidth();

    public abstract boolean isLooping();

    public boolean isMute() {
        return false;
    }

    public abstract boolean isPlaying();

    public void mouseEvent(int i, int i2, int i3) {
    }

    public abstract void pause();

    public abstract void preDemux();

    public abstract void prepare();

    public abstract void prepareAsync();

    public abstract void prevClose();

    public abstract void release();

    public abstract void releaseAsync();

    public abstract void reset();

    public abstract void seekTo(int i);

    public void seekTo(int i, int i2) {
    }

    public abstract void selectTrack(int i);

    public void setABRStrategy(ABRStrategy aBRStrategy) {
    }

    public void setAIBarrageInfo(MaskInfo maskInfo) {
    }

    public void setAudioProcessor(AudioProcessor audioProcessor) {
    }

    public void setCacheFile(String str, int i) {
    }

    public abstract void setDataSource(Context context, Uri uri) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IllegalArgumentException, IOException;

    public abstract void setDataSource(String str) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDisplay(SurfaceHolder surfaceHolder);

    public int setDoubleOption(int i, double d) {
        return -1;
    }

    public int setFloatOption(int i, float f) {
        return -1;
    }

    public int setFloatOptionArray(int[] iArr, float[] fArr) {
        return -1;
    }

    public abstract void setFrameMetadataListener(FrameMetadataListener frameMetadataListener);

    public int setIntOptionArray(int[] iArr, int[] iArr2) {
        return -1;
    }

    public void setIsMute(boolean z) {
    }

    public void setLoadControl(LoadControl loadControl) {
    }

    public int setLongOption(int i, long j) {
        return -1;
    }

    public int setLongOptionArray(int[] iArr, long[] jArr) {
        return -1;
    }

    public abstract void setLooping(boolean z);

    public void setMaskInfo(MaskInfo maskInfo) {
    }

    public abstract void setMediaTransport(MediaTransport mediaTransport);

    public abstract void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener);

    public abstract void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener);

    public abstract void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener);

    public abstract void setOnExternInfoListener(MediaPlayer.OnExternInfoListener onExternInfoListener);

    public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) {
    }

    public abstract void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener);

    public void setOnLogListener(MediaPlayer.OnLogListener onLogListener) {
    }

    public abstract void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener);

    public abstract void setOnSARChangedListener(MediaPlayer.onSARChangedListener onsarchangedlistener);

    public abstract void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener);

    public abstract void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener);

    public void setPanoVideoControlModel(int i) {
    }

    public abstract void setPlaybackParams(PlaybackParams playbackParams);

    public abstract void setScreenOnWhilePlaying(boolean z);

    public void setStrategyParamsTransport(StrategyParamsTransport strategyParamsTransport) {
    }

    public int setStringOption(int i, String str) {
        return -1;
    }

    public int setStringOptionArray(int[] iArr, String[] strArr) {
        return -1;
    }

    public void setSubInfo(SubInfo subInfo) {
    }

    public abstract void setSurface(Surface surface);

    public abstract void setSurfaceTimeOut(Surface surface, int i);

    public void setTraitObject(int i, TraitObject traitObject) {
    }

    public abstract void setVolume(float f, float f2);

    public abstract void setWakeMode(Context context, int i);

    public void setupMediaCodec() {
    }

    public abstract void start();

    public abstract void stop();

    public abstract void switchStream(int i, int i2);

    public abstract void takeScreenshot(MediaPlayer.OnScreenshotListener onScreenshotListener);

    public void setWindowClient(TTAVWindowClient tTAVWindowClient) {
        throw new RuntimeException("Not implements");
    }

    public void rotateCamera(float f, float f2) {
        Log.i("ttplayer", "<MediaPlayerClient.java,rotateCamera,55>rotateCamera is not implemented");
    }

    public int setIntOption(int i, int i2) {
        Log.i("ttplayer", "<MediaPlayerClient.java,setIntOption,65>set os player is not inval");
        return -1;
    }
}
