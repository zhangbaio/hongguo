package com.ss.ttm.player;

import android.content.Context;
import android.media.ImageReader;
import android.os.Handler;
import android.os.RemoteException;
import android.view.Surface;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.utils.OnceConfig;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TTPlayerRef extends ITTPlayerRef implements IPlayerNotifyer {
    private static final String TAG;
    private static String mAppPath;
    private static String mLoadErr;
    private static boolean mLoadSoSuccess;
    private TTPlayerClient mClient;
    private final Context mContext;
    private long mId = System.currentTimeMillis();
    OnceConfig mOnceBySelf = null;
    private TTPlayer mPlayer;

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int getType() {
        return 1;
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setCacheFile(String str, int i) {
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public Context getContext() {
        return this.mContext;
    }

    public TTPlayer getPlayer() {
        return this.mPlayer;
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void close() {
        this.mPlayer.close();
    }

    public long getNativeObject() {
        return this.mPlayer.getNativePlayer();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected MediaPlayer.TrackInfo[] getTrackInfo() {
        return this.mPlayer.getTrackInfo();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected boolean isValid() {
        if (this.mPlayer == null) {
            return false;
        }
        return true;
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void pause() {
        this.mPlayer.pause();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int preDemux() {
        return this.mPlayer.preDemux();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void prepare() {
        this.mPlayer.prepare();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void prevClose() {
        this.mPlayer.prevClose();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void reset() {
        this.mPlayer.reset();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setupMediaCodec() {
        this.mPlayer.setupMediaCodec();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void start() {
        this.mPlayer.start();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void stop() {
        this.mPlayer.stop();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void takeScreenshot() {
        this.mPlayer.takeScreenshot();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected int getLifeId() {
        return this.mPlayer.getIntOption(35, -1);
    }

    static {
        Covode.recordClassIndex(652193);
        TAG = TTPlayerRef.class.getSimpleName();
        mAppPath = null;
        mLoadErr = null;
        mLoadSoSuccess = false;
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void release() {
        OnceConfig onceConfig = this.mOnceBySelf;
        if (onceConfig != null) {
            onceConfig.release();
            this.mOnceBySelf = null;
        }
        TTPlayer tTPlayer = this.mPlayer;
        this.mPlayer = null;
        tTPlayer.release();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected Object getObjectOption(int i) {
        return this.mPlayer.getObjectValue(i);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public String getStringOption(int i) {
        return this.mPlayer.getStringOption(i);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public String getSubtitleContent(int i) {
        return this.mPlayer.getSubtitleContent(i);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void seekTo(int i) {
        this.mPlayer.seekTo(i);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setABRStrategy(ABRStrategy aBRStrategy) {
        this.mPlayer.setABRStrategy(aBRStrategy);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setAIBarrageInfo(MaskInfo maskInfo) {
        this.mPlayer.setAIBarrageInfo(maskInfo);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setAudioProcessor(AudioProcessor audioProcessor) {
        this.mPlayer.setAudioProcessor(audioProcessor);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setDataSource(IMediaDataSource iMediaDataSource) {
        this.mPlayer.setDataSource(iMediaDataSource);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setDataSourceFd(int i) {
        this.mPlayer.setDataSourceFd(i);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setFrameMetadataListener(FrameMetadataListener frameMetadataListener) {
        this.mPlayer.setFrameMetadataListener(frameMetadataListener);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setLoadControl(LoadControl loadControl) {
        this.mPlayer.setLoadControl(loadControl);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setLooping(int i) {
        this.mPlayer.setLooping(i);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setMaskInfo(MaskInfo maskInfo) {
        this.mPlayer.setMaskInfo(maskInfo);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setMediaTransport(MediaTransport mediaTransport) {
        this.mPlayer.setMediaTransport(mediaTransport);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setNotifyState(long j) {
        this.mPlayer.setNotifyerState(j);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setOnScreenshotListener(MediaPlayer.OnScreenshotListener onScreenshotListener) {
        this.mPlayer.setOnScreenshotListener(onScreenshotListener);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setStrategyParamsTransport(StrategyParamsTransport strategyParamsTransport) {
        this.mPlayer.setStrategyParamsTransport(strategyParamsTransport);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setSubInfo(SubInfo subInfo) {
        this.mPlayer.setSubInfo(subInfo);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setSurface(Surface surface) {
        this.mPlayer.setVideoSurface(surface);
    }

    public TTPlayerRef(Context context) {
        this.mContext = context;
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setDataSource(String str) {
        this.mPlayer.setDataSource(str);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setWindowClient(TTAVWindowClient tTAVWindowClient) {
        if (tTAVWindowClient instanceof TTWindowClient) {
            ((TTWindowClient) tTAVWindowClient).bindPlayer(this.mPlayer);
        }
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected double getDoubleOption(int i, double d) {
        return this.mPlayer.getDoubleOption(i, d);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected float getFloatOption(int i, float f) {
        return this.mPlayer.getFloatOption(i, f);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int getIntOption(int i, int i2) {
        return this.mPlayer.getIntOption(i, i2);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public long getLongOption(int i, long j) {
        return this.mPlayer.getLongOption(i, j);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void rotateCamera(float f, float f2) {
        this.mPlayer.rotateCamera(f, f2);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected int setDoubleOption(int i, double d) {
        return this.mPlayer.setDoubleOption(i, d);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected int setFloatOption(int i, float f) {
        return this.mPlayer.setFloatOption(i, f);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setFloatOptionArray(int[] iArr, float[] fArr) {
        return this.mPlayer.setFloatOptionArray(iArr, fArr);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setIntOptionArray(int[] iArr, int[] iArr2) {
        return this.mPlayer.setIntOptionArray(iArr, iArr2);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setLongOption(int i, long j) {
        return this.mPlayer.setLongOption(i, j);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setLongOptionArray(int[] iArr, long[] jArr) {
        return this.mPlayer.setLongOptionArray(iArr, jArr);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) {
        this.mPlayer.setOnImageAvailableListener(onImageAvailableListener, handler);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setStringOption(int i, String str) {
        return this.mPlayer.setStringOption(i, str);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setStringOptionArray(int[] iArr, String[] strArr) {
        return this.mPlayer.setStringOptionArray(iArr, strArr);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setSurfaceTimeOut(Surface surface, int i) {
        this.mPlayer.setVideoSurfaceTimeOut(surface, i);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setTraitObject(int i, TraitObject traitObject) {
        this.mPlayer.setTraitObject(i, traitObject);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setVolume(float f, float f2) {
        this.mPlayer.setVolume(f, f2);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void switchStream(int i, int i2) {
        this.mPlayer.switchStream(i, i2);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void seekTo(int i, int i2) {
        this.mPlayer.seekTo(i, i2);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setIntOption(int i, int i2) {
        try {
            return this.mPlayer.setIntOption(i, i2);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void setGlobalStringOptionForKey(int i, String str) {
        if (i == 40050) {
            TTPlayerConfiger.setValue(77, str);
        }
        if (mLoadSoSuccess) {
            TTPlayer.setGlobalStringOptionForKey(i, str);
        }
    }

    public static void setGlobalIntOptionForKey(int i, int i2) {
        if (i != 1015) {
            if (i != 1016) {
                if (i != 1306) {
                    if (i != 1307) {
                        if (i != 40002) {
                            if (i != 40007) {
                                switch (i) {
                                    case 1356:
                                        TTPlayerConfiger.setValue(44, i2);
                                        break;
                                    case 1357:
                                        TTPlayerConfiger.setValue(45, i2);
                                        break;
                                    case 1358:
                                        TTPlayerConfiger.setValue(46, i2);
                                        break;
                                    case 1359:
                                        TTPlayerConfiger.setValue(47, i2);
                                        break;
                                    case 1360:
                                        TTPlayerConfiger.setValue(50, i2);
                                        break;
                                    case 1361:
                                        TTPlayerConfiger.setValue(51, i2);
                                        break;
                                    default:
                                        switch (i) {
                                            case 40013:
                                                TTPlayerConfiger.setValue(55, i2);
                                                break;
                                            case 40014:
                                                TTPlayerConfiger.setValue(56, i2);
                                                break;
                                            case 40015:
                                                TTPlayerConfiger.setValue(57, i2);
                                                break;
                                            case 40016:
                                                TTPlayerConfiger.setValue(58, i2);
                                                break;
                                            case 40017:
                                                TTPlayerConfiger.setValue(59, i2);
                                                break;
                                            case 40018:
                                                TTPlayerConfiger.setValue(60, i2);
                                                break;
                                            case 40019:
                                                TTPlayerConfiger.setValue(61, i2);
                                                break;
                                            case 40020:
                                                TTPlayerConfiger.setValue(62, i2);
                                                break;
                                            case 40021:
                                                TTPlayerConfiger.setValue(63, i2);
                                                break;
                                            case 40022:
                                                TTPlayerConfiger.setValue(64, i2);
                                                break;
                                            case 40023:
                                                TTPlayerConfiger.setValue(65, i2);
                                                break;
                                            case 40024:
                                                TTPlayerConfiger.setValue(66, i2);
                                                break;
                                            case 40025:
                                                TTPlayerConfiger.setValue(67, i2);
                                                break;
                                            case 40026:
                                                TTPlayerConfiger.setValue(68, i2);
                                                break;
                                            case 40027:
                                                TTPlayerConfiger.setValue(69, i2);
                                                break;
                                            case 40028:
                                                TTPlayerConfiger.setValue(70, i2);
                                                break;
                                            case 40029:
                                                TTPlayerConfiger.setValue(71, i2);
                                                break;
                                            case 40030:
                                                TTPlayerConfiger.setValue(72, i2);
                                                break;
                                            case 40031:
                                                TTPlayerConfiger.setValue(73, i2);
                                                break;
                                            default:
                                                switch (i) {
                                                    case 40034:
                                                        TTPlayerConfiger.setValue(75, i2);
                                                        break;
                                                    case 40035:
                                                        TTPlayerConfiger.setValue(79, i2);
                                                        break;
                                                    case 40036:
                                                        TTPlayerConfiger.setValue(80, i2);
                                                        break;
                                                    case 40037:
                                                        TTPlayerConfiger.setValue(81, i2);
                                                        break;
                                                    case 40038:
                                                        TTPlayerConfiger.setValue(82, i2);
                                                        break;
                                                    case 40039:
                                                        TTPlayerConfiger.setValue(84, i2);
                                                        break;
                                                    case 40040:
                                                        TTPlayerConfiger.setValue(85, i2);
                                                        break;
                                                    case 40041:
                                                        TTPlayerConfiger.setValue(86, i2);
                                                        break;
                                                    default:
                                                        switch (i) {
                                                            case 40051:
                                                                TTPlayerConfiger.setValue(78, i2);
                                                                break;
                                                            case 40052:
                                                                TTPlayerConfiger.setValue(83, i2);
                                                                break;
                                                            case 40053:
                                                                TTPlayerConfiger.setValue(87, i2);
                                                                break;
                                                            case 40054:
                                                                TTPlayerConfiger.setValue(88, i2);
                                                                break;
                                                        }
                                                }
                                        }
                                }
                            } else {
                                TTPlayerConfiger.setValue(54, i2);
                            }
                        } else {
                            TTPlayerConfiger.setValue(49, i2);
                        }
                    } else {
                        TTPlayerConfiger.setValue(53, i2);
                    }
                } else {
                    TTPlayerConfiger.setValue(52, i2);
                }
            } else {
                TTPlayerConfiger.setValue(32, i2);
            }
        } else {
            TTPlayerConfiger.setValue(31, i2);
        }
        if (mLoadSoSuccess) {
            TTPlayer.setGlobalIntOptionForKey(i, i2);
        }
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void mouseEvent(int i, int i2, int i3) {
        this.mPlayer.mouseEvent(i, i2, i3);
    }

    public static final synchronized TTPlayerRef create(TTPlayerClient tTPlayerClient, Context context, OnceConfig onceConfig) {
        TTPlayerRef tTPlayerRef;
        RuntimeException runtimeException;
        synchronized (TTPlayerRef.class) {
            if (mAppPath == null) {
                mAppPath = TTPlayerConfiger.getAppFileCachePath(context);
                try {
                    if (TTPlayer.getAppPath() == null) {
                        TTPlayer.setTempFileDir(mAppPath);
                    }
                } catch (UnsatisfiedLinkError e) {
                    mLoadErr = e.getMessage();
                }
            }
            if (mLoadErr == null) {
                if (!mLoadSoSuccess) {
                    TTPlayer.setGlobalIntOptionForKey(1015, TTPlayerConfiger.getValue(31, 0));
                    TTPlayer.setGlobalIntOptionForKey(1016, TTPlayerConfiger.getValue(32, 0));
                    TTPlayer.setGlobalIntOptionForKey(1356, TTPlayerConfiger.getValue(44, 0));
                    TTPlayer.setGlobalIntOptionForKey(1357, TTPlayerConfiger.getValue(45, 0));
                    TTPlayer.setGlobalIntOptionForKey(1358, TTPlayerConfiger.getValue(46, 0));
                    TTPlayer.setGlobalIntOptionForKey(40002, TTPlayerConfiger.getValue(49, 0));
                    TTPlayer.setGlobalIntOptionForKey(1306, TTPlayerConfiger.getValue(52, 0));
                    TTPlayer.setGlobalIntOptionForKey(1307, TTPlayerConfiger.getValue(53, 0));
                    TTPlayer.setGlobalIntOptionForKey(40007, TTPlayerConfiger.getValue(54, 0));
                    TTPlayer.setGlobalIntOptionForKey(40013, TTPlayerConfiger.getValue(55, 0));
                    TTPlayer.setGlobalIntOptionForKey(40014, TTPlayerConfiger.getValue(56, 0));
                    TTPlayer.setGlobalIntOptionForKey(40015, TTPlayerConfiger.getValue(57, 0));
                    TTPlayer.setGlobalIntOptionForKey(40016, TTPlayerConfiger.getValue(58, 0));
                    TTPlayer.setGlobalIntOptionForKey(40037, TTPlayerConfiger.getValue(81, 0));
                    TTPlayer.setGlobalIntOptionForKey(40038, TTPlayerConfiger.getValue(82, 0));
                    TTPlayer.setGlobalIntOptionForKey(40039, TTPlayerConfiger.getValue(84, 0));
                    TTPlayer.setGlobalIntOptionForKey(40040, TTPlayerConfiger.getValue(85, 0));
                    TTPlayer.setGlobalIntOptionForKey(40041, TTPlayerConfiger.getValue(86, 0));
                    TTPlayer.setGlobalIntOptionForKey(40017, TTPlayerConfiger.getValue(59, 0));
                    TTPlayer.setGlobalIntOptionForKey(40018, TTPlayerConfiger.getValue(60, 0));
                    TTPlayer.setGlobalIntOptionForKey(40019, TTPlayerConfiger.getValue(61, 0));
                    TTPlayer.setGlobalIntOptionForKey(40020, TTPlayerConfiger.getValue(62, 0));
                    TTPlayer.setGlobalIntOptionForKey(40021, TTPlayerConfiger.getValue(63, 0));
                    TTPlayer.setGlobalIntOptionForKey(40022, TTPlayerConfiger.getValue(64, 0));
                    TTPlayer.setGlobalIntOptionForKey(40023, TTPlayerConfiger.getValue(65, 0));
                    TTPlayer.setGlobalIntOptionForKey(40024, TTPlayerConfiger.getValue(66, 0));
                    TTPlayer.setGlobalIntOptionForKey(40025, TTPlayerConfiger.getValue(67, 0));
                    TTPlayer.setGlobalIntOptionForKey(40026, TTPlayerConfiger.getValue(68, 0));
                    TTPlayer.setGlobalIntOptionForKey(40027, TTPlayerConfiger.getValue(69, 0));
                    TTPlayer.setGlobalIntOptionForKey(40028, TTPlayerConfiger.getValue(70, 0));
                    TTPlayer.setGlobalIntOptionForKey(40029, TTPlayerConfiger.getValue(71, 0));
                    TTPlayer.setGlobalIntOptionForKey(40030, TTPlayerConfiger.getValue(72, 0));
                    TTPlayer.setGlobalIntOptionForKey(40031, TTPlayerConfiger.getValue(73, 0));
                    TTPlayer.setGlobalIntOptionForKey(40035, TTPlayerConfiger.getValue(79, 0));
                    TTPlayer.setGlobalIntOptionForKey(40036, TTPlayerConfiger.getValue(80, 0));
                    TTPlayer.setGlobalIntOptionForKey(40034, TTPlayerConfiger.getValue(75, 0));
                    TTPlayer.setGlobalStringOptionForKey(40050, TTPlayerConfiger.getValue(77, ""));
                    TTPlayer.setGlobalIntOptionForKey(40053, TTPlayerConfiger.getValue(87, 0));
                    TTPlayer.setGlobalIntOptionForKey(40054, TTPlayerConfiger.getValue(88, 0));
                }
                mLoadSoSuccess = true;
                tTPlayerRef = new TTPlayerRef(context);
                tTPlayerRef.mClient = tTPlayerClient;
                try {
                    TTPlayer tTPlayer = new TTPlayer(context, tTPlayerRef.mId, onceConfig);
                    tTPlayerRef.mPlayer = tTPlayer;
                    tTPlayer.setNotifyer(tTPlayerRef);
                } finally {
                }
            } else {
                throw new UnsatisfiedLinkError(mLoadErr);
            }
        }
        return tTPlayerRef;
    }

    @Override // com.ss.ttm.player.IPlayerNotifyer
    public void handleErrorNotify(long j, int i, int i2, String str) {
        this.mClient.onPlayLogInfo(i, i2, str);
    }

    @Override // com.ss.ttm.player.IPlayerNotifyer
    public void handlePlayerNotify(long j, int i, int i2, int i3, String str) {
        this.mClient.onPlayerNotify(i, i2, i3, str);
    }
}
