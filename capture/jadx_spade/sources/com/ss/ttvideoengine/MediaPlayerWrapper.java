package com.ss.ttvideoengine;

import al2.b0;
import android.content.Context;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.base.ssconfig.template.SetSurfaceAsync;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.local.KvCacheMgr;
import com.ss.ttm.player.ABRStrategy;
import com.ss.ttm.player.AudioProcessor;
import com.ss.ttm.player.FrameMetadataListener;
import com.ss.ttm.player.IMediaDataSource;
import com.ss.ttm.player.LoadControl;
import com.ss.ttm.player.MaskInfo;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.player.MediaPlayerClient;
import com.ss.ttm.player.MediaTransport;
import com.ss.ttm.player.OSPlayerClient;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttm.player.SubInfo;
import com.ss.ttm.player.TTAVWindowClient;
import com.ss.ttm.player.TraitObject;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineInternalLog;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MediaPlayerWrapper implements MediaPlayer {
    private static final List<Throwable> sErrorList;
    private static boolean sHasLoadPlayerClass;
    private MediaPlayerClient mClient;
    private boolean mHasException = false;
    private String mExceptionStr = "";

    public static MediaPlayer create(Context context, int i, HashMap hashMap) {
        return com_ss_ttvideoengine_MediaPlayerWrapper_com_dragon_read_aop_TTVideoEngineAop_create(context, i, hashMap);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public /* synthetic */ void preDemux() {
        MediaPlayer.CC.$default$preDemux(this);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public /* synthetic */ void setFloatOptionArray(int[] iArr, float[] fArr) {
        MediaPlayer.CC.$default$setFloatOptionArray(this, iArr, fArr);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public /* synthetic */ void setIntOptionArray(int[] iArr, int[] iArr2) {
        MediaPlayer.CC.$default$setIntOptionArray(this, iArr, iArr2);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public /* synthetic */ void setLongOptionArray(int[] iArr, long[] jArr) {
        MediaPlayer.CC.$default$setLongOptionArray(this, iArr, jArr);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public /* synthetic */ void setOnImageAvailableListener(ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) {
        MediaPlayer.CC.$default$setOnImageAvailableListener(this, onImageAvailableListener, handler);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public /* synthetic */ void setStringOptionArray(int[] iArr, String[] strArr) {
        MediaPlayer.CC.$default$setStringOptionArray(this, iArr, strArr);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setSurface(Surface surface) {
        com_ss_ttvideoengine_MediaPlayerWrapper_com_dragon_read_aop_TTVideoEngineAop_setSurface(this, surface);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setSurfaceTimeOut(Surface surface, int i) {
        com_ss_ttvideoengine_MediaPlayerWrapper_com_dragon_read_aop_TTVideoEngineAop_setSurfaceTimeOut(this, surface, i);
    }

    public String getExceptionStr() {
        return this.mExceptionStr;
    }

    public MediaPlayerClient getPlayerClient() {
        return this.mClient;
    }

    public boolean hasException() {
        return this.mHasException;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public boolean isOSPlayer() {
        return this.mClient instanceof OSPlayerClient;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void pause() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.pause();
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
    public boolean isPlaying() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.isPlaying();
        }
        return false;
    }

    static {
        Covode.recordClassIndex(652297);
        sErrorList = new ArrayList();
        sHasLoadPlayerClass = false;
    }

    public static String getPluginVersion() {
        try {
            return TTHelper.getClzUsingPluginLoader(201, "com.ss.ttmplugin.player.TTVersion").getField("VERSION_NAME").get(null).toString();
        } catch (Throwable th) {
            TTVideoEngineInternalLog.d(th);
            return "";
        }
    }

    public static boolean tryLoadPlayerPlugin() {
        if (sHasLoadPlayerClass) {
            return true;
        }
        try {
            TTHelper.getClzUsingPluginLoader(200, "com.ss.ttm.player.TTPlayerClient");
            sHasLoadPlayerClass = true;
            return true;
        } catch (Throwable th) {
            TTVideoEngineInternalLog.d(th);
            return false;
        }
    }

    public void setupMediaCodec() {
        if (this.mClient == null) {
            return;
        }
        try {
            Method method = TTHelper.getClzUsingPluginLoader(200, "com.ss.ttm.player.TTPlayerClient").getMethod("setupMediaCodec", new Class[0]);
            method.setAccessible(true);
            method.invoke(this.mClient, new Object[0]);
        } catch (Throwable th) {
            TTVideoEngineInternalLog.d(th);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void deselectTrack(int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.deselectTrack(i);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void seekTo(int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.seekTo(i);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void selectTrack(int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.selectTrack(i);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDisplay(surfaceHolder);
        }
    }

    public void setFrameMetadataListener(FrameMetadataListener frameMetadataListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setFrameMetadataListener(frameMetadataListener);
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

    public Object getObjectOption(int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient == null) {
            return null;
        }
        return mediaPlayerClient.getObjectOption(i);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getSelectedTrack(int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.getSelectedTrack(i);
            return 0;
        }
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public String getStringOption(int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getStringOption(i);
        }
        return null;
    }

    public String getSubtitleContent(int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient == null) {
            return null;
        }
        return mediaPlayerClient.getSubtitleContent(i);
    }

    public void setABRStrategy(ABRStrategy aBRStrategy) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient == null) {
            return;
        }
        mediaPlayerClient.setABRStrategy(aBRStrategy);
    }

    public void setAIBarrageInfo(MaskInfo maskInfo) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient == null) {
            return;
        }
        mediaPlayerClient.setAIBarrageInfo(maskInfo);
    }

    public void setAudioProcessor(AudioProcessor audioProcessor) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient == null) {
            return;
        }
        mediaPlayerClient.setAudioProcessor(audioProcessor);
    }

    public void setLoadControl(LoadControl loadControl) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient == null) {
            return;
        }
        mediaPlayerClient.setLoadControl(loadControl);
    }

    public void setMaskInfo(MaskInfo maskInfo) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient == null) {
            return;
        }
        mediaPlayerClient.setMaskInfo(maskInfo);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setMediaTransport(MediaTransport mediaTransport) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient == null) {
            return;
        }
        mediaPlayerClient.setMediaTransport(mediaTransport);
    }

    public void setSubInfo(SubInfo subInfo) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient == null) {
            return;
        }
        mediaPlayerClient.setSubInfo(subInfo);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setWindowClient(TTAVWindowClient tTAVWindowClient) {
        MediaPlayerClient mediaPlayerClient;
        if (tTAVWindowClient != null && (mediaPlayerClient = this.mClient) != null) {
            mediaPlayerClient.setWindowClient(tTAVWindowClient);
        }
    }

    public void MediaPlayerWrapper__setSurface$___twin___(Surface surface) {
        MediaPlayerClient mediaPlayerClient;
        if ((surface != null && !surface.isValid()) || (mediaPlayerClient = this.mClient) == null) {
            return;
        }
        mediaPlayerClient.setSurface(surface);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, IOException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(iMediaDataSource);
        }
    }

    public static long getDemuxerFactory(int i) {
        try {
            Class<?> clzUsingPluginLoader = TTHelper.getClzUsingPluginLoader(200, "com.ss.ttm.player.TTPlayerClient");
            Method declaredMethod = clzUsingPluginLoader.getDeclaredMethod("getDemuxerFactory", Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(clzUsingPluginLoader, Integer.valueOf(i));
            if (invoke == null) {
                return 0L;
            }
            return ((Long) invoke).longValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    private static boolean shouldFallbackExoPlayer(HashMap<Integer, Integer> hashMap) {
        boolean isFallbackUseExoPlayer = TTVideoEngine.isFallbackUseExoPlayer();
        if (hashMap != null && hashMap.containsKey(27)) {
            try {
                if (((Integer) TTHelper.nonNullElse(hashMap.get(27), 0)).intValue() != 1) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return isFallbackUseExoPlayer;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDataSource(String str) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(str);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void rotateCamera(float f, float f2) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.rotateCamera(f, f2);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setCacheFile(String str, int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setCacheFile(str, i);
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
    public void setIntOption(int i, int i2) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setIntOption(i, i2);
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

    public void seekTo(int i, int i2) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient == null) {
            return;
        }
        mediaPlayerClient.seekTo(i, i2);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int setFloatOption(int i, float f) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setFloatOption(i, f);
            return 0;
        }
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public long setLongOption(int i, long j) {
        if (this.mClient != null) {
            return r0.setLongOption(i, j);
        }
        return -1L;
    }

    public void MediaPlayerWrapper__setSurfaceTimeOut$___twin___(Surface surface, int i) {
        MediaPlayerClient mediaPlayerClient;
        if ((surface != null && !surface.isValid()) || (mediaPlayerClient = this.mClient) == null) {
            return;
        }
        mediaPlayerClient.setSurfaceTimeOut(surface, i);
    }

    @TargetClass("com.ss.ttvideoengine.MediaPlayerWrapper")
    @Insert("setSurface")
    public static void com_ss_ttvideoengine_MediaPlayerWrapper_com_dragon_read_aop_TTVideoEngineAop_setSurface(MediaPlayerWrapper mediaPlayerWrapper, Surface surface) {
        if (SetSurfaceAsync.b().enable && !SetSurfaceAsync.b().onlyVideoShop && surface == null) {
            b0.m(new b0.a(mediaPlayerWrapper.getPlayerClient(), surface));
        } else {
            mediaPlayerWrapper.MediaPlayerWrapper__setSurface$___twin___(surface);
        }
    }

    public static void setGlobalIntOptionForKey(int i, int i2) {
        try {
            Class<?> clzUsingPluginLoader = TTHelper.getClzUsingPluginLoader(200, "com.ss.ttm.player.TTPlayerClient");
            Class<?> cls = Integer.TYPE;
            Method declaredMethod = clzUsingPluginLoader.getDeclaredMethod("setGlobalIntOptionForKey", cls, cls);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(clzUsingPluginLoader, Integer.valueOf(i), Integer.valueOf(i2));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static boolean createExoClient(Context context, MediaPlayerWrapper mediaPlayerWrapper) {
        try {
            Class q = l3.a.q("com.ss.ttexo.ExoPlayerClient");
            Method declaredMethod = q.getDeclaredMethod("create", MediaPlayer.class, Context.class);
            declaredMethod.setAccessible(true);
            mediaPlayerWrapper.mClient = (MediaPlayerClient) declaredMethod.invoke(q, mediaPlayerWrapper, context);
            return true;
        } catch (Throwable th) {
            TTVideoEngineInternalLog.e("MediaPlayerWrapper", th.toString());
            mediaPlayerWrapper.mHasException = true;
            mediaPlayerWrapper.mExceptionStr += th.toString();
            sErrorList.add(th);
            return false;
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

    @TargetClass("com.ss.ttvideoengine.MediaPlayerWrapper")
    @Insert("create")
    public static MediaPlayer com_ss_ttvideoengine_MediaPlayerWrapper_com_dragon_read_aop_TTVideoEngineAop_create(Context context, int i, HashMap hashMap) {
        if (KvCacheMgr.getPrivate(App.context(), "force_os_media_player").getBoolean("force_media_player_degrade", false)) {
            MediaPlayerWrapper mediaPlayerWrapper = new MediaPlayerWrapper();
            i80.c.n(mediaPlayerWrapper, "mClient", OSPlayerClient.create(mediaPlayerWrapper, context));
            return mediaPlayerWrapper;
        }
        return MediaPlayerWrapper__create$___twin___(context, i, hashMap);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IllegalArgumentException, IOException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(fileDescriptor, j, j2);
        }
    }

    @TargetClass("com.ss.ttvideoengine.MediaPlayerWrapper")
    @Insert("setSurfaceTimeOut")
    public static void com_ss_ttvideoengine_MediaPlayerWrapper_com_dragon_read_aop_TTVideoEngineAop_setSurfaceTimeOut(MediaPlayerWrapper mediaPlayerWrapper, Surface surface, int i) {
        if (SetSurfaceAsync.b().enable && !SetSurfaceAsync.b().onlyVideoShop && surface == null) {
            String str = mediaPlayerWrapper.mExceptionStr;
            if ((str instanceof String) && str.contains("AudioPlayer-SDK")) {
                mediaPlayerWrapper.MediaPlayerWrapper__setSurfaceTimeOut$___twin___(surface, i);
                LogWrapper.info("AudioCore-TTVideoEngineAops", "setSurfaceTimeOut timeoutMS=" + i + ", mExceptionStr=" + ((Object) str), new Object[0]);
                return;
            }
            b0.m(new b0.b(mediaPlayerWrapper.getPlayerClient(), surface, i));
            LogWrapper.info("AudioCore-TTVideoEngineAops", "setSurfaceTimeOut post async timeoutMS=" + i, new Object[0]);
            return;
        }
        mediaPlayerWrapper.MediaPlayerWrapper__setSurfaceTimeOut$___twin___(surface, i);
        LogWrapper.info("AudioCore-TTVideoEngineAops", "setSurfaceTimeOut timeoutMS=" + i, new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x02e0 A[Catch: all -> 0x002f, TryCatch #4 {all -> 0x002f, blocks: (B:116:0x0017, B:118:0x0027, B:54:0x02dc, B:56:0x02e0, B:57:0x02fa, B:60:0x0300, B:62:0x0310, B:64:0x0320, B:66:0x0330, B:67:0x0336, B:69:0x033a, B:71:0x0340, B:72:0x0343, B:74:0x0347, B:76:0x0357, B:77:0x035d, B:7:0x003a, B:9:0x004c, B:11:0x005c, B:13:0x006c, B:15:0x007c, B:17:0x008c, B:18:0x00e8, B:20:0x00ee, B:22:0x0135, B:27:0x01e1, B:33:0x0210, B:35:0x0236, B:37:0x023e, B:38:0x026e, B:39:0x0269, B:42:0x016e, B:44:0x0194, B:46:0x019c, B:47:0x01cc, B:48:0x01c7, B:89:0x011f, B:90:0x0283, B:98:0x02b5, B:99:0x0098, B:101:0x00a8, B:102:0x00b1, B:104:0x00b7, B:106:0x00bd, B:108:0x00c3, B:110:0x00c9, B:112:0x00cf, B:114:0x00df, B:95:0x028c, B:26:0x013d, B:86:0x00f4, B:30:0x01e5), top: B:115:0x0017, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02fe A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x033a A[Catch: all -> 0x002f, TryCatch #4 {all -> 0x002f, blocks: (B:116:0x0017, B:118:0x0027, B:54:0x02dc, B:56:0x02e0, B:57:0x02fa, B:60:0x0300, B:62:0x0310, B:64:0x0320, B:66:0x0330, B:67:0x0336, B:69:0x033a, B:71:0x0340, B:72:0x0343, B:74:0x0347, B:76:0x0357, B:77:0x035d, B:7:0x003a, B:9:0x004c, B:11:0x005c, B:13:0x006c, B:15:0x007c, B:17:0x008c, B:18:0x00e8, B:20:0x00ee, B:22:0x0135, B:27:0x01e1, B:33:0x0210, B:35:0x0236, B:37:0x023e, B:38:0x026e, B:39:0x0269, B:42:0x016e, B:44:0x0194, B:46:0x019c, B:47:0x01cc, B:48:0x01c7, B:89:0x011f, B:90:0x0283, B:98:0x02b5, B:99:0x0098, B:101:0x00a8, B:102:0x00b1, B:104:0x00b7, B:106:0x00bd, B:108:0x00c3, B:110:0x00c9, B:112:0x00cf, B:114:0x00df, B:95:0x028c, B:26:0x013d, B:86:0x00f4, B:30:0x01e5), top: B:115:0x0017, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0347 A[Catch: all -> 0x002f, TryCatch #4 {all -> 0x002f, blocks: (B:116:0x0017, B:118:0x0027, B:54:0x02dc, B:56:0x02e0, B:57:0x02fa, B:60:0x0300, B:62:0x0310, B:64:0x0320, B:66:0x0330, B:67:0x0336, B:69:0x033a, B:71:0x0340, B:72:0x0343, B:74:0x0347, B:76:0x0357, B:77:0x035d, B:7:0x003a, B:9:0x004c, B:11:0x005c, B:13:0x006c, B:15:0x007c, B:17:0x008c, B:18:0x00e8, B:20:0x00ee, B:22:0x0135, B:27:0x01e1, B:33:0x0210, B:35:0x0236, B:37:0x023e, B:38:0x026e, B:39:0x0269, B:42:0x016e, B:44:0x0194, B:46:0x019c, B:47:0x01cc, B:48:0x01c7, B:89:0x011f, B:90:0x0283, B:98:0x02b5, B:99:0x0098, B:101:0x00a8, B:102:0x00b1, B:104:0x00b7, B:106:0x00bd, B:108:0x00c3, B:110:0x00c9, B:112:0x00cf, B:114:0x00df, B:95:0x028c, B:26:0x013d, B:86:0x00f4, B:30:0x01e5), top: B:115:0x0017, inners: #0, #1, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.ss.ttm.player.MediaPlayer MediaPlayerWrapper__create$___twin___(android.content.Context r16, int r17, java.util.HashMap<java.lang.Integer, java.lang.Integer> r18) {
        /*
            Method dump skipped, instructions count: 883
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.MediaPlayerWrapper.MediaPlayerWrapper__create$___twin___(android.content.Context, int, java.util.HashMap):com.ss.ttm.player.MediaPlayer");
    }
}
