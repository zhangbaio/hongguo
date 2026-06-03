package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ImageReader;
import android.os.Handler;
import android.os.RemoteException;
import android.view.Surface;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.utils.AVLogger;
import com.ss.ttm.utils.InitConfig;
import com.ss.ttm.utils.OnceConfig;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TTPlayer {
    private static String mAppPath;
    private static String mCachePath;
    private static String mCrashPath;
    private static ILibraryLoader mDebugLibLoader;
    private static boolean mIsIPCPlayer;
    private static boolean mSetLibraryLoader;
    private static int mSupportSampleRateNB;
    private static int[] mSupportSampleRates;
    private static String playerLibName;
    private Context mContext;
    private FrameMetadataListener mFrameMetadataListener;
    private long mHandle;
    private long mId;
    private long mMediaDataSource;
    private IPlayerNotifyer mNotifyer;
    private MediaPlayer.OnScreenshotListener mScreenshotListener;
    private StrategyParamsTransport mStrategyParamsTransport;
    private int mTracker = 0;

    private static final native void _close(long j);

    private final native long _create(Context context, long j, String str);

    private static final native String _getAppPath();

    private static final native int _getCurrentPosition(long j);

    private static final native long _getDemuxerFactory(int i);

    private static final native double _getDoubleValue(long j, int i, double d);

    private static final native int _getDuration(long j);

    private static final native float _getFloatValue(long j, int i, float f);

    private static final native int _getIntValue(long j, int i, int i2);

    private static final native Object _getJObjectValue(long j, int i);

    private static final native long _getLongValue(long j, int i, long j2);

    private static final native Object[] _getStreamInfo(long j);

    private static final native String _getStringValue(long j, int i);

    private static final native String _getSubtitleContent(long j, int i);

    private static final native int _getVideoHeight(long j);

    private static final native int _getVideoWidth(long j);

    private static final native int _isLooping(long j);

    private static final native int _isPlaying(long j);

    private static final native void _mouseEvent(long j, int i, int i2, int i3);

    private static final native int _pause(long j);

    private static final native int _preDemux(long j);

    private static final native int _prepare(long j);

    private static final native int _registerNativeMdl(long j);

    private static final native void _registerPlayerInfo();

    private static final native void _release(long j);

    private static final native int _reset(long j);

    private static final native void _rotateCamera(long j, float f, float f2);

    private static final native int _seek(long j, int i);

    private static final native int _seek2(long j, int i, int i2);

    private static final native void _setABRStrategy(long j, ABRStrategy aBRStrategy);

    private static final native void _setAIBarrageInfo(long j, MaskInfo maskInfo);

    private static final native void _setAudioProcessor(long j, AudioProcessor audioProcessor);

    private static final native void _setDataSource(long j, IMediaDataSource iMediaDataSource);

    private static final native void _setDataSource(long j, String str);

    private static final native void _setDataSourceFd(long j, int i);

    private static final native int _setDoubleValue(long j, int i, double d);

    private static final native int _setFloatValue(long j, int i, float f);

    private static final native int _setFloatValueArray(long j, int[] iArr, float[] fArr);

    private static final native void _setGlobalIntForKey(int i, int i2);

    private static final native void _setGlobalStringForKey(int i, String str);

    private static final native int _setIntValue(long j, int i, int i2);

    private static final native int _setIntValueArray(long j, int[] iArr, int[] iArr2);

    private static final native void _setLoadControl(long j, LoadControl loadControl);

    private static final native int _setLongValue(long j, int i, long j2);

    private static final native int _setLongValueArray(long j, int[] iArr, long[] jArr);

    private static final native void _setLooping(long j, int i);

    private static final native void _setMaskInfo(long j, MaskInfo maskInfo);

    private static final native void _setMediaTransport(long j, MediaTransport mediaTransport);

    private static final native int _setStringValue(long j, int i, String str);

    private static final native int _setStringValueArray(long j, int[] iArr, String[] strArr);

    private static final native void _setSubInfo(long j, SubInfo subInfo);

    private static final native void _setSupportFormatNB(int i);

    private static final native void _setSupprotSampleRates(int[] iArr, int i);

    private static final native int _setSurfaceValue(long j, long j2);

    private static final native void _setTraitObject(long j, int i, int i2, TraitObject traitObject);

    private static final native int _setVideoSurface(long j, Surface surface);

    private static final native int _setVideoSurfaceTimeout(long j, Surface surface, int i);

    private static final native void _setVolume(long j, float f, float f2);

    private static final native int _setupMediaCodec(long j);

    private static final native int _start(long j);

    private static final native void _stop(long j);

    private static final native void _switchStream(long j, int i, int i2);

    private static final native void _takeScreenshot(long j);

    private static final void checkPlayerModel() {
    }

    public static final String getAppPath() {
        return mAppPath;
    }

    public static final String getCachePath() {
        return mCachePath;
    }

    public static final String getCrashPath() {
        return mCrashPath;
    }

    public static void registerPlayerInfo() {
        _registerPlayerInfo();
    }

    public Context getContext() {
        return this.mContext;
    }

    public final long getHandle() {
        return this.mHandle;
    }

    public long getNativePlayer() {
        return this.mHandle;
    }

    public static int getVC2DecPoolSize() {
        return TTPlayerConfiger.getValue(42, 0);
    }

    public static int getVC2StackSizeValue() {
        return TTPlayerConfiger.getValue(40, 0);
    }

    public static int getVC2ThreadPriorityValue() {
        return TTPlayerConfiger.getValue(35, 0);
    }

    public static int isEnableVC2DecPool() {
        return TTPlayerConfiger.getValue(41, false) ? 1 : 0;
    }

    public static int isEnableVC2ThreadPriority() {
        return TTPlayerConfiger.getValue(34, false) ? 1 : 0;
    }

    public static int isEnableVC2ThreadPriorityLite() {
        return TTPlayerConfiger.getValue(36, false) ? 1 : 0;
    }

    public static int isUseThreadV2() {
        return TTPlayerConfiger.getValue(38, 0);
    }

    public static int isUsedThreadPool() {
        return TTPlayerConfiger.getValue(24, false) ? 1 : 0;
    }

    public static int isVC2StackSizeOpt() {
        return TTPlayerConfiger.getValue(39, 0);
    }

    public int setupMediaCodec() {
        return _setupMediaCodec(this.mHandle);
    }

    public void takeScreenshot() {
        _takeScreenshot(this.mHandle);
    }

    public static int getThreadPoolStackSize() {
        return TTPlayerConfiger.getValue(25, 32);
    }

    public int close() {
        long j = this.mHandle;
        if (j == 0) {
            return -1;
        }
        _close(j);
        return 0;
    }

    public StreamInfo[] getStreamInfo() {
        return (StreamInfo[]) _getStreamInfo(this.mHandle);
    }

    protected int pause() {
        long j = this.mHandle;
        if (j == 0) {
            return -1;
        }
        return _pause(j);
    }

    protected int preDemux() {
        long j = this.mHandle;
        if (j == 0) {
            return -1;
        }
        return _preDemux(j);
    }

    protected int prepare() {
        long j = this.mHandle;
        if (j == 0) {
            return -1;
        }
        return _prepare(j);
    }

    public int prevClose() {
        long j = this.mHandle;
        if (j == 0) {
            return -1;
        }
        _setVideoSurface(j, null);
        return 0;
    }

    protected int reset() {
        long j = this.mHandle;
        if (j == 0) {
            return -1;
        }
        return _reset(j);
    }

    protected int start() {
        long j = this.mHandle;
        if (j == 0) {
            return -1;
        }
        return _start(j);
    }

    protected int stop() {
        long j = this.mHandle;
        if (j != 0) {
            _stop(j);
            return 0;
        }
        return -1;
    }

    private static void detectAudioFormat() {
        if (mSupportSampleRateNB == 0) {
            int[] iArr = new int[AudioFormats.getDefaultSampleRatesNB()];
            mSupportSampleRates = iArr;
            int maxSupportedSampleRates = AudioFormats.getMaxSupportedSampleRates(iArr);
            mSupportSampleRateNB = maxSupportedSampleRates;
            _setSupprotSampleRates(mSupportSampleRates, maxSupportedSampleRates);
        }
    }

    public static boolean isIPPlayer() {
        StringBuilder sb = new StringBuilder();
        sb.append("mIsIPCPlayer:");
        sb.append(mIsIPCPlayer);
        return mIsIPCPlayer;
    }

    static {
        Covode.recordClassIndex(652178);
        mSupportSampleRateNB = 0;
        mIsIPCPlayer = false;
        mSetLibraryLoader = false;
        mDebugLibLoader = new DefaultLibraryLoader(true);
        playerLibName = "";
        synchronized (TTPlayer.class) {
            TTPlayerLibLoader.loadLibrary();
            playerLibName = TTPlayerLibLoader.getPlayerLibName();
            try {
                detectAudioFormat();
            } catch (UnsatisfiedLinkError e) {
                String errorInfo = TTPlayerLibLoader.getErrorInfo();
                if (errorInfo != null) {
                    throw new UnsatisfiedLinkError(errorInfo);
                }
                throw e;
            }
        }
    }

    public MediaPlayer.TrackInfo[] getTrackInfo() {
        StreamInfo[] streamInfoArr = (StreamInfo[]) _getStreamInfo(this.mHandle);
        if (streamInfoArr != null && streamInfoArr.length != 0) {
            int length = streamInfoArr.length;
            MediaPlayer.TrackInfo[] trackInfoArr = new MediaPlayer.TrackInfo[length];
            for (int i = 0; i < length; i++) {
                trackInfoArr[i] = streamInfoArr[i].convertToTrackInfo();
            }
            return trackInfoArr;
        }
        return null;
    }

    protected void release() {
        AVLogger.InfoTrackLife("TTPlayerJava", this, String.format(Locale.US, "release TTPlayer:%x", Long.valueOf(this.mHandle)));
        long j = this.mHandle;
        if (j != 0) {
            _release(j);
            this.mHandle = 0L;
        }
        this.mNotifyer = null;
        this.mScreenshotListener = null;
    }

    public static final void setCachePath(String str) {
        mCachePath = str;
    }

    public static final void setCrashPath(String str) {
        mCrashPath = str;
    }

    public static void setIsIPPlayer(boolean z) {
        mIsIPCPlayer = z;
    }

    public static final void setTempFileDir(String str) {
        mAppPath = str;
    }

    public void setFrameMetadataListener(FrameMetadataListener frameMetadataListener) {
        this.mFrameMetadataListener = frameMetadataListener;
    }

    public void setNotifyer(IPlayerNotifyer iPlayerNotifyer) {
        this.mNotifyer = iPlayerNotifyer;
    }

    public void setOnScreenshotListener(MediaPlayer.OnScreenshotListener onScreenshotListener) {
        this.mScreenshotListener = onScreenshotListener;
    }

    public void setStrategyParamsTransport(StrategyParamsTransport strategyParamsTransport) {
        this.mStrategyParamsTransport = strategyParamsTransport;
    }

    private static class DefaultLibraryLoader implements ILibraryLoader {
        boolean mLoadLibraryPath;

        static {
            Covode.recordClassIndex(652179);
        }

        public DefaultLibraryLoader(boolean z) {
            this.mLoadLibraryPath = z;
        }

        @Override // com.ss.ttm.player.ILibraryLoader
        public boolean onLoadNativeLibs(List<String> list) {
            for (String str : list) {
                try {
                    if (this.mLoadLibraryPath) {
                        System.load(str);
                    } else {
                        System.loadLibrary(str);
                    }
                } catch (Throwable th) {
                    AVLogger.Error("TTPlayerJava", this, "load lib failed = " + th.getMessage());
                    return false;
                }
            }
            return true;
        }
    }

    public static long getDemuxerFactory(int i) {
        return _getDemuxerFactory(i);
    }

    public static int registerNativeMdl(long j) {
        return _registerNativeMdl(j);
    }

    public Object getObjectValue(int i) {
        return _getJObjectValue(this.mHandle, i);
    }

    public String getSubtitleContent(int i) {
        return _getSubtitleContent(this.mHandle, i);
    }

    public void seekTo(int i) {
        _seek(this.mHandle, i);
    }

    public void setLooping(int i) {
        _setLooping(this.mHandle, i);
    }

    public int setSurfaceValue(long j) {
        return _setSurfaceValue(this.mHandle, j);
    }

    public final void takeScreenshotComplete(Bitmap bitmap) {
        MediaPlayer.OnScreenshotListener onScreenshotListener = this.mScreenshotListener;
        if (onScreenshotListener != null) {
            onScreenshotListener.onTakeScreenShotCompletion(bitmap);
        }
    }

    public static int getAudioTrackPoolSize(int i) {
        AudioTrackPool audioTrackPool = AudioTrackPool.getInstance();
        int audioTrackPoolSize = audioTrackPool.getAudioTrackPoolSize();
        if (i > 0 && audioTrackPoolSize == 0) {
            audioTrackPool.preBuild();
        }
        return audioTrackPoolSize;
    }

    public String getStringOption(int i) {
        if (i == 1095) {
            return playerLibName;
        }
        return _getStringValue(this.mHandle, i);
    }

    public void receiveBinarySei(ByteBuffer byteBuffer) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.receiveBinarySei(byteBuffer);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setABRStrategy(ABRStrategy aBRStrategy) {
        long j = this.mHandle;
        if (j != 0) {
            _setABRStrategy(j, aBRStrategy);
        }
    }

    public void setAIBarrageInfo(MaskInfo maskInfo) {
        long j = this.mHandle;
        if (j != 0) {
            _setAIBarrageInfo(j, maskInfo);
        }
    }

    public void setAudioProcessor(AudioProcessor audioProcessor) {
        long j = this.mHandle;
        if (j != 0) {
            _setAudioProcessor(j, audioProcessor);
        }
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException {
        long j = this.mHandle;
        if (j != 0) {
            _setDataSource(j, iMediaDataSource);
        }
    }

    public void setDataSourceFd(int i) {
        long j = this.mHandle;
        if (j != 0) {
            _setDataSourceFd(j, i);
        }
    }

    public void setLoadControl(LoadControl loadControl) {
        long j = this.mHandle;
        if (j != 0) {
            _setLoadControl(j, loadControl);
        }
    }

    public void setMaskInfo(MaskInfo maskInfo) {
        long j = this.mHandle;
        if (j != 0) {
            _setMaskInfo(j, maskInfo);
        }
    }

    public void setMediaTransport(MediaTransport mediaTransport) {
        long j = this.mHandle;
        if (j != 0) {
            _setMediaTransport(j, mediaTransport);
        }
    }

    public void setNotifyerState(long j) {
        _setIntValue(this.mHandle, 16, (int) j);
    }

    public void setSubInfo(SubInfo subInfo) {
        long j = this.mHandle;
        if (j != 0) {
            _setSubInfo(j, subInfo);
        }
    }

    protected int setVideoSurface(Surface surface) {
        long j = this.mHandle;
        if (j != 0) {
            return _setVideoSurface(j, surface);
        }
        return -1;
    }

    public String getStrategyParams(String str) {
        try {
            StrategyParamsTransport strategyParamsTransport = this.mStrategyParamsTransport;
            if (strategyParamsTransport == null) {
                return "none";
            }
            return strategyParamsTransport.getStrategyParams(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "none";
        }
    }

    public void setDataSource(String str) {
        long j = this.mHandle;
        if (j != 0) {
            _setDataSource(j, str);
        }
    }

    public static final void setGlobalIntOptionForKey(int i, int i2) {
        _setGlobalIntForKey(i, i2);
    }

    public static final void setGlobalStringOptionForKey(int i, String str) {
        _setGlobalStringForKey(i, str);
    }

    public double getDoubleOption(int i, double d) {
        return _getDoubleValue(this.mHandle, i, d);
    }

    public float getFloatOption(int i, float f) {
        return _getFloatValue(this.mHandle, i, f);
    }

    public void rotateCamera(float f, float f2) {
        _rotateCamera(this.mHandle, f, f2);
    }

    public int setDoubleOption(int i, double d) {
        return _setDoubleValue(this.mHandle, i, d);
    }

    public int setFloatOption(int i, float f) {
        return _setFloatValue(this.mHandle, i, f);
    }

    public int setFloatOptionArray(int[] iArr, float[] fArr) {
        return _setFloatValueArray(this.mHandle, iArr, fArr);
    }

    public int setIntOptionArray(int[] iArr, int[] iArr2) {
        return _setIntValueArray(this.mHandle, iArr, iArr2);
    }

    public int setLongOption(int i, long j) {
        return _setLongValue(this.mHandle, i, j);
    }

    public int setLongOptionArray(int[] iArr, long[] jArr) {
        return _setLongValueArray(this.mHandle, iArr, jArr);
    }

    public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) {
        AJProducerManager.setOnImageAvailableListener(this.mHandle, onImageAvailableListener, handler);
    }

    public int setStringOption(int i, String str) {
        return _setStringValue(this.mHandle, i, str);
    }

    public int setStringOptionArray(int[] iArr, String[] strArr) {
        return _setStringValueArray(this.mHandle, iArr, strArr);
    }

    public void setVolume(float f, float f2) {
        _setVolume(this.mHandle, f, f2);
    }

    public void switchStream(int i, int i2) {
        _switchStream(this.mHandle, i, i2);
    }

    public long getLongOption(int i, long j) {
        if (i == 50) {
            return this.mHandle;
        }
        return _getLongValue(this.mHandle, i, j);
    }

    public void onAbrDecisionInfo(long j, String str) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.onAbrDecisionInfo(j, str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void seekTo(int i, int i2) {
        _seek2(this.mHandle, i, i2);
    }

    protected int setVideoSurfaceTimeOut(Surface surface, int i) {
        long j = this.mHandle;
        if (j != 0) {
            return _setVideoSurfaceTimeout(j, surface, i);
        }
        return -1;
    }

    public void setTraitObject(int i, TraitObject traitObject) {
        int i2;
        if (this.mHandle != 0) {
            if (traitObject != null) {
                i2 = traitObject.version();
            } else {
                i2 = -1;
            }
            _setTraitObject(this.mHandle, i, i2, traitObject);
        }
    }

    private void create(long j, InitConfig initConfig) throws Exception {
        this.mNotifyer = null;
        long _create = _create(this.mContext, initConfig.nativeHandle(), mAppPath);
        this.mHandle = _create;
        AVLogger.InfoTrackLife("TTPlayerJava", this, String.format(Locale.US, "create TTPlayer:%x", Long.valueOf(_create)));
        this.mId = j;
        if (this.mHandle != 0) {
        } else {
            throw new Exception("create native player is fail.");
        }
    }

    public int setIntOption(int i, int i2) throws RemoteException {
        if (i == 111) {
            int[] iArr = TTPlayerKeys.SupportSampleRates;
            int length = iArr.length;
            int[] iArr2 = new int[iArr.length];
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                if (((1 << i4) & i2) == 0) {
                    iArr2[i3] = TTPlayerKeys.SupportSampleRates[i4];
                    i3++;
                }
            }
            _setSupprotSampleRates(iArr2, i3);
            return 0;
        }
        return _setIntValue(this.mHandle, i, i2);
    }

    public int getIntOption(int i, int i2) {
        if (i != 11) {
            if (i != 51) {
                switch (i) {
                    case 1:
                        return _getDuration(this.mHandle);
                    case 2:
                        return _getCurrentPosition(this.mHandle);
                    case 3:
                        return _getVideoWidth(this.mHandle);
                    case 4:
                        return _getVideoHeight(this.mHandle);
                    case 5:
                        return _isLooping(this.mHandle);
                    case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                        return _isPlaying(this.mHandle);
                    default:
                        return _getIntValue(this.mHandle, i, i2);
                }
            }
            return this.mTracker;
        }
        return _getIntValue(this.mHandle, i, i2);
    }

    public void mouseEvent(int i, int i2, int i3) {
        _mouseEvent(this.mHandle, i, i2, i3);
    }

    public TTPlayer(Context context, long j, OnceConfig onceConfig) throws Exception {
        this.mContext = context;
        create(j, onceConfig);
    }

    public void frameDTSNotify(int i, long j, long j2) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.frameDTSNotify(i, j2, j);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void updateFrameTerminatedDTS(int i, long j, long j2) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.updateFrameTerminatedDTS(i, j, j2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onLogInfo(int i, int i2, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("type:");
        sb.append(i);
        sb.append(" code:");
        sb.append(i2);
        sb.append(str);
        IPlayerNotifyer iPlayerNotifyer = this.mNotifyer;
        if (iPlayerNotifyer != null) {
            try {
                iPlayerNotifyer.handleErrorNotify(this.mId, i, i2, str);
            } catch (Throwable unused) {
            }
        }
    }

    public void didReceivePacket(int i, long j, long j2, Map<Integer, String> map) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.didReceivePacket(i, j, j2, map);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onFrameAboutToBeRendered(int i, long j, long j2, Map<Integer, String> map) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.onFrameAboutToBeRendered(i, j, j2, map);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onNotify(int i, int i2, int i3, String str) {
        try {
            IPlayerNotifyer iPlayerNotifyer = this.mNotifyer;
            if (iPlayerNotifyer != null) {
                iPlayerNotifyer.handlePlayerNotify(this.mId, i, i2, i3, str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void willRenderFrame(int i, long j, long j2, String str) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.willRenderFrame(i, j, j2, str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
