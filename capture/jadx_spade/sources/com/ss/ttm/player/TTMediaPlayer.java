package com.ss.ttm.player;

import android.content.Context;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TTMediaPlayer implements MediaPlayer {
    protected MediaPlayerClient mClient;
    protected int mPlayerType = 0;

    @Override // com.ss.ttm.player.MediaPlayer
    public void setCacheFile(String str, int i) {
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void pause() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.pause();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void preDemux() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.preDemux();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void prepare() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.prepare();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void prepareAsync() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.prepareAsync();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void prevClose() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.prevClose();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void release() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.release();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void releaseAsync() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.releaseAsync();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void reset() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.reset();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void start() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.start();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void stop() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.stop();
        }
    }

    static {
        Covode.recordClassIndex(652177);
        TTVersion.saveVersionInfo();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getCurrentPosition() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public String getDataSource() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getDataSource();
        }
        return null;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getDuration() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getDuration();
        }
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getPlayerType() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getType();
        }
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getTrackInfo();
        }
        return null;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getVideoHeight() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getVideoHeight();
        }
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getVideoType() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getVideoType();
        }
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getVideoWidth() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getVideoWidth();
        }
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public boolean isLooping() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.isLooping();
        }
        return false;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public boolean isMute() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.isMute();
        }
        return false;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public boolean isOSPlayer() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null && mediaPlayerClient.getType() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public boolean isPlaying() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.isPlaying();
        }
        return false;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void seekTo(int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.seekTo(i);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDisplay(surfaceHolder);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setIsMute(boolean z) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setIsMute(z);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setLooping(boolean z) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setLooping(z);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setMediaTransport(MediaTransport mediaTransport) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setMediaTransport(mediaTransport);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnBufferingUpdateListener(onBufferingUpdateListener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnCompletionListener(onCompletionListener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnErrorListener(onErrorListener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnExternInfoListener(MediaPlayer.OnExternInfoListener onExternInfoListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnExternInfoListener(onExternInfoListener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnInfoListener(onInfoListener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnLogListener(MediaPlayer.OnLogListener onLogListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnLogListener(onLogListener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnPreparedListener(onPreparedListener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnSARChangedListener(MediaPlayer.onSARChangedListener onsarchangedlistener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnSARChangedListener(onsarchangedlistener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnSeekCompleteListener(onSeekCompleteListener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setPanoVideoControlModel(int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setPanoVideoControlModel(i);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setPlaybackParams(PlaybackParams playbackParams) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setScreenOnWhilePlaying(z);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void takeScreenshot(MediaPlayer.OnScreenshotListener onScreenshotListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.takeScreenshot(onScreenshotListener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getSelectedTrack(int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getSelectedTrack(i);
        }
        return -1;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public String getStringOption(int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getStringOption(i);
        }
        return null;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void selectTrack(int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null && i == 0) {
            mediaPlayerClient.setIntOption(261, 0);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setWindowClient(TTAVWindowClient tTAVWindowClient) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient == null) {
            return;
        }
        mediaPlayerClient.setWindowClient(tTAVWindowClient);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void deselectTrack(int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null && i == 0) {
            mediaPlayerClient.setIntOption(261, 1);
        } else if (mediaPlayerClient != null) {
            mediaPlayerClient.setIntOption(65, (i << 8) | 0);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, IOException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(iMediaDataSource);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setSurface(Surface surface) {
        MediaPlayerClient mediaPlayerClient;
        if (surface != null && surface.isValid() && (mediaPlayerClient = this.mClient) != null) {
            mediaPlayerClient.setSurface(surface);
        }
    }

    public void setUnSupportSampleRates(int[] iArr) {
        if (isOSPlayer() || (iArr.length) <= 0) {
            return;
        }
        int length = MediaPlayer.MEDIA_PLAYER_SUPPORT_SAMPLERATES.length;
        int i = 0;
        for (int i2 : iArr) {
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (MediaPlayer.MEDIA_PLAYER_SUPPORT_SAMPLERATES[i3] == i2) {
                    i |= 1 << i3;
                    break;
                }
                i3++;
            }
        }
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setIntOption(TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE, i);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDataSource(String str) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a4 A[Catch: all -> 0x00be, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0013, B:15:0x00a4, B:20:0x00b0, B:24:0x00ba, B:31:0x0095, B:33:0x009e, B:9:0x0083, B:11:0x0089, B:28:0x008f), top: B:3:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b8 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ba A[Catch: all -> 0x00be, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0013, B:15:0x00a4, B:20:0x00b0, B:24:0x00ba, B:31:0x0095, B:33:0x009e, B:9:0x0083, B:11:0x0089, B:28:0x008f), top: B:3:0x0003, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final synchronized com.ss.ttm.player.TTMediaPlayer create(android.content.Context r9) {
        /*
            java.lang.Class<com.ss.ttm.player.TTMediaPlayer> r0 = com.ss.ttm.player.TTMediaPlayer.class
            monitor-enter(r0)
            com.ss.ttm.player.TTMediaPlayer r1 = new com.ss.ttm.player.TTMediaPlayer     // Catch: java.lang.Throwable -> Lbe
            r1.<init>()     // Catch: java.lang.Throwable -> Lbe
            boolean r2 = com.ss.ttm.player.TTPlayerConfiger.isPrintInfo()     // Catch: java.lang.Throwable -> Lbe
            r3 = 1
            r4 = 7
            r5 = 11
            r6 = 0
            if (r2 == 0) goto L82
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbe
            r2.<init>()     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r7 = "ttplayer:"
            r2.append(r7)     // Catch: java.lang.Throwable -> Lbe
            boolean r7 = com.ss.ttm.player.TTPlayerConfiger.getValue(r3, r6)     // Catch: java.lang.Throwable -> Lbe
            r2.append(r7)     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r7 = ",ipc:"
            r2.append(r7)     // Catch: java.lang.Throwable -> Lbe
            r7 = 2
            boolean r7 = com.ss.ttm.player.TTPlayerConfiger.getValue(r7, r6)     // Catch: java.lang.Throwable -> Lbe
            r2.append(r7)     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r7 = ",crashed:"
            r2.append(r7)     // Catch: java.lang.Throwable -> Lbe
            boolean r7 = com.ss.ttm.player.TTPlayerConfiger.getValue(r4, r6)     // Catch: java.lang.Throwable -> Lbe
            r2.append(r7)     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r7 = ",cpu family"
            r2.append(r7)     // Catch: java.lang.Throwable -> Lbe
            int r7 = com.ss.ttm.utils.HardWareInfo.getCpuFamily()     // Catch: java.lang.Throwable -> Lbe
            r2.append(r7)     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r7 = ",debug:"
            r2.append(r7)     // Catch: java.lang.Throwable -> Lbe
            r2.append(r6)     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r7 = ",timeout count:"
            r2.append(r7)     // Catch: java.lang.Throwable -> Lbe
            r7 = 10
            int r7 = com.ss.ttm.player.TTPlayerConfiger.getValue(r7, r6)     // Catch: java.lang.Throwable -> Lbe
            r2.append(r7)     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r7 = ",forbid create os player:"
            r2.append(r7)     // Catch: java.lang.Throwable -> Lbe
            boolean r7 = com.ss.ttm.player.TTPlayerConfiger.getValue(r5, r6)     // Catch: java.lang.Throwable -> Lbe
            r2.append(r7)     // Catch: java.lang.Throwable -> Lbe
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbe
            r2.<init>()     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r7 = "version info:"
            r2.append(r7)     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r7 = "not find version info"
            r8 = 15
            java.lang.String r7 = com.ss.ttm.player.TTPlayerConfiger.getValue(r8, r7)     // Catch: java.lang.Throwable -> Lbe
            r2.append(r7)     // Catch: java.lang.Throwable -> Lbe
        L82:
            r2 = 0
            boolean r7 = com.ss.ttm.player.TTPlayerConfiger.isOnTTPlayer()     // Catch: java.lang.Throwable -> L94
            if (r7 != 0) goto L8f
            boolean r7 = com.ss.ttm.player.TTPlayerConfiger.getValue(r5, r6)     // Catch: java.lang.Throwable -> L94
            if (r7 == 0) goto La1
        L8f:
            com.ss.ttm.player.TTPlayerClient r3 = com.ss.ttm.player.TTPlayerClient.create(r1, r9, r2, r2)     // Catch: java.lang.Throwable -> L94
            goto La2
        L94:
            r7 = move-exception
            r7.printStackTrace()     // Catch: java.lang.Throwable -> Lbe
            boolean r7 = com.ss.ttm.player.TTPlayerConfiger.getValue(r4, r6)     // Catch: java.lang.Throwable -> Lbe
            if (r7 != 0) goto La1
            com.ss.ttm.player.TTPlayerConfiger.setValue(r4, r3)     // Catch: java.lang.Throwable -> Lbe
        La1:
            r3 = r2
        La2:
            if (r3 != 0) goto Lb6
            boolean r3 = com.ss.ttm.player.TTPlayerConfiger.isPrintInfo()     // Catch: java.lang.Throwable -> Lbe
            boolean r3 = com.ss.ttm.player.TTPlayerConfiger.getValue(r5, r6)     // Catch: java.lang.Throwable -> Lbe
            if (r3 == 0) goto Lb0
            monitor-exit(r0)
            return r2
        Lb0:
            com.ss.ttm.player.OSPlayerClient r3 = com.ss.ttm.player.OSPlayerClient.create(r1, r9)     // Catch: java.lang.Throwable -> Lbe
            r1.mPlayerType = r6     // Catch: java.lang.Throwable -> Lbe
        Lb6:
            if (r3 != 0) goto Lba
            monitor-exit(r0)
            return r2
        Lba:
            r1.mClient = r3     // Catch: java.lang.Throwable -> Lbe
            monitor-exit(r0)
            return r1
        Lbe:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.TTMediaPlayer.create(android.content.Context):com.ss.ttm.player.TTMediaPlayer");
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void rotateCamera(float f, float f2) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.rotateCamera(f, f2);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDataSource(Context context, Uri uri) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(context, uri);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setFloatOptionArray(int[] iArr, float[] fArr) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setFloatOptionArray(iArr, fArr);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setIntOption(int i, int i2) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setIntOption(i, i2);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setIntOptionArray(int[] iArr, int[] iArr2) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setIntOptionArray(iArr, iArr2);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setLongOptionArray(int[] iArr, long[] jArr) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setLongOptionArray(iArr, jArr);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient == null) {
            mediaPlayerClient.setOnImageAvailableListener(onImageAvailableListener, handler);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setStringOption(int i, String str) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setStringOption(i, str);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setStringOptionArray(int[] iArr, String[] strArr) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setStringOptionArray(iArr, strArr);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setTraitObject(int i, TraitObject traitObject) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setTraitObject(i, traitObject);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setVolume(float f, float f2) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setVolume(f, f2);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setWakeMode(Context context, int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setWakeMode(context, i);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void switchStream(int i, int i2) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.switchStream(i, i2);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public float getFloatOption(int i, float f) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getFloatOption(i, f);
        }
        return f;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getIntOption(int i, int i2) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getIntOption(i, i2);
        }
        return i2;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public long getLongOption(int i, long j) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getLongOption(i, j);
        }
        return j;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int setFloatOption(int i, float f) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.setFloatOption(i, f);
        }
        return -1;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public long setLongOption(int i, long j) {
        if (this.mClient != null) {
            return r0.setLongOption(i, j);
        }
        return -1L;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setSurfaceTimeOut(Surface surface, int i) {
        MediaPlayerClient mediaPlayerClient;
        if (surface != null && surface.isValid() && (mediaPlayerClient = this.mClient) != null) {
            mediaPlayerClient.setSurfaceTimeOut(surface, i);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void mouseEvent(int i, int i2, int i3) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.mouseEvent(i, i2, i3);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(context, uri, map);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IllegalArgumentException, IOException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(fileDescriptor, j, j2);
        }
    }
}
