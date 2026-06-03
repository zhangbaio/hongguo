package com.ss.ttm.player;

import android.app.Application;
import android.content.Context;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ssconfig.template.CodecNameCache;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttm.net.AVResolver;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.utils.AVErrorInfo;
import com.ss.ttm.utils.AVLogger;
import com.ss.ttm.utils.AVTime;
import com.ss.ttm.utils.OnceConfig;
import com.ss.ttvideoengine.ITTVideoEngineInternal;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TTPlayerClient extends MediaPlayerClient implements Handler.Callback, ISurfaceListener {
    private static final String TAG;
    private String mBufferingInfo;
    private TTSurfaceCallback mCallback;
    private int mCodecAndSurfaceReuse;
    private HashMap<Integer, Integer> mConfigParams;
    private boolean mConnectedCpu;
    private Context mContext;
    private int mCrashType;
    private final StringBuilder mCrashedInfo;
    private int mDisablePlayerStayAwake;
    private int mErrorCode;
    private Handler mHandler;
    private int mIgnoreSurfaceCreated;
    private MediaPlayer.OnLogListener mLogListener;
    private int mMediaCodecStopTimeOutMs;
    private MediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
    private MediaPlayer.OnCompletionListener mOnCompletionListener;
    private MediaPlayer.OnErrorListener mOnErrorListener;
    private MediaPlayer.OnExternInfoListener mOnExternInfoListener;
    private MediaPlayer.OnInfoListener mOnInfoListener;
    private MediaPlayer.OnPreparedListener mOnPreparedListener;
    private MediaPlayer.onSARChangedListener mOnSARChangedListener;
    private MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private MediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private ITTPlayerRef mPlayer;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private volatile boolean mRealsedSurface;
    private int mRtcPlay;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private SurfaceHolder mSurfaceHolder;
    private String mUri;
    private String mVoiceInfo;
    private PowerManager.WakeLock mWakeLock;
    private MediaPlayer mWrapper;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;
    private boolean mSeekComplete = true;
    private LinkedList<String> mLogInfo = new LinkedList<>();
    private int mPlayLifeId = -1;
    private final ReentrantLock mReentrantLock = new ReentrantLock();
    private final ReentrantLock mReentrantLockInRtc = new ReentrantLock();

    public static synchronized TTPlayerClient create(MediaPlayer mediaPlayer, Context context, HashMap hashMap, OnceConfig onceConfig) {
        TTPlayerClient com_ss_ttm_player_TTPlayerClient_com_dragon_read_aop_TTVideoEngineAop_create;
        synchronized (TTPlayerClient.class) {
            com_ss_ttm_player_TTPlayerClient_com_dragon_read_aop_TTVideoEngineAop_create = com_ss_ttm_player_TTPlayerClient_com_dragon_read_aop_TTVideoEngineAop_create(mediaPlayer, context, hashMap, onceConfig);
        }
        return com_ss_ttm_player_TTPlayerClient_com_dragon_read_aop_TTVideoEngineAop_create;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getSelectedTrack(int i) {
        if (i == 2) {
            return 1;
        }
        if (i == 1) {
            return 0;
        }
        return i == 4 ? 2 : -1;
    }

    @Override // com.ss.ttm.player.ISurfaceListener
    public void onSurfaceChanged(SurfaceHolder surfaceHolder) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void prepareAsync() {
        com_ss_ttm_player_TTPlayerClient_com_dragon_read_aop_TTVideoEngineAop_prepareAsync(this);
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void release() {
        com_ss_ttm_player_TTPlayerClient_com_dragon_read_aop_TTVideoEngineAop_release(this);
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public String getDataSource() {
        return this.mUri;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void prepare() {
        prepareAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValid() {
        ITTPlayerRef iTTPlayerRef = this.mPlayer;
        if (iTTPlayerRef != null && iTTPlayerRef.isValid()) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(652180);
        TAG = TTPlayerClient.class.getSimpleName();
        TTVersion.saveVersionInfo();
    }

    public void close() {
        this.mRealsedSurface = true;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.close();
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getCurrentPosition() {
        this.mReadLock.lock();
        try {
            int i = 0;
            if (isValid()) {
                i = this.mPlayer.getIntOption(2, 0);
            }
            return i;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getDuration() {
        this.mReadLock.lock();
        try {
            int i = 0;
            if (isValid()) {
                i = this.mPlayer.getIntOption(1, 0);
            }
            return i;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        MediaPlayer.TrackInfo[] trackInfoArr;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                trackInfoArr = this.mPlayer.getTrackInfo();
            } else {
                trackInfoArr = null;
            }
            return trackInfoArr;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getType() {
        int i;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                i = this.mPlayer.getType();
            } else {
                i = 0;
            }
            return i;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getVideoHeight() {
        this.mReadLock.lock();
        try {
            int i = 0;
            if (isValid()) {
                i = this.mPlayer.getIntOption(4, 0);
            }
            return i;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getVideoWidth() {
        this.mReadLock.lock();
        try {
            int i = 0;
            if (isValid()) {
                i = this.mPlayer.getIntOption(3, 0);
            }
            return i;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void preDemux() {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.preDemux();
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setupMediaCodec() {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setupMediaCodec();
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    public void updateSurfaceScreenOn() {
        boolean z;
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null && this.mDisablePlayerStayAwake == 0) {
            if (this.mScreenOnWhilePlaying && this.mStayAwake) {
                z = true;
            } else {
                z = false;
            }
            surfaceHolder.setKeepScreenOn(z);
        }
    }

    public void TTPlayerClient__prepareAsync$___twin___() {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mErrorCode = 0;
                this.mLogInfo.clear();
                if (this.mRealsedSurface) {
                    this.mPlayer.setSurfaceTimeOut(this.mSurfaceHolder.getSurface(), 0);
                    this.mRealsedSurface = false;
                }
                this.mPlayer.prepare();
                updateLifeId();
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getVideoType() {
        this.mReadLock.lock();
        try {
            int i = 0;
            if (isValid()) {
                i = this.mPlayer.getIntOption(11, 0);
            }
            return i;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public boolean isLooping() {
        this.mReadLock.lock();
        try {
            boolean z = false;
            if (isValid()) {
                if (this.mPlayer.getIntOption(5, 0) == 1) {
                    z = true;
                }
            }
            return z;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public boolean isMute() {
        this.mReadLock.lock();
        try {
            boolean z = false;
            if (isValid()) {
                if (this.mPlayer.getIntOption(12, 0) == 1) {
                    z = true;
                }
            }
            return z;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public boolean isPlaying() {
        this.mReadLock.lock();
        try {
            boolean z = false;
            if (isValid()) {
                if (this.mPlayer.getIntOption(6, 0) == 1) {
                    z = true;
                }
            }
            return z;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void pause() {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.pause();
            }
            this.mReadLock.unlock();
            stayAwake(false);
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void prevClose() {
        this.mRealsedSurface = true;
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.mCallback);
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.prevClose();
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void releaseAsync() {
        this.mRealsedSurface = true;
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.mCallback);
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.prevClose();
            }
            this.mReadLock.unlock();
            new Thread(new Runnable() { // from class: com.ss.ttm.player.TTPlayerClient.1
                @Override // java.lang.Runnable
                public void run() {
                    TTPlayerClient.this.release();
                }
            }).start();
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void reset() {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.reset();
                SurfaceHolder surfaceHolder = this.mSurfaceHolder;
                if (surfaceHolder != null && this.mCodecAndSurfaceReuse == 0) {
                    this.mPlayer.setSurfaceTimeOut(surfaceHolder.getSurface(), 0);
                }
                this.mHandler.removeCallbacksAndMessages(null);
                this.mErrorCode = 0;
                this.mLogInfo.clear();
                updateLifeId();
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void start() {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.start();
                updateLifeId();
                this.mRtcPlay = this.mPlayer.getIntOption(800, 0);
            }
            this.mReadLock.unlock();
            stayAwake(true);
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    protected void updateLifeId() {
        try {
            this.mReentrantLock.lock();
            this.mPlayLifeId = this.mPlayer.getLifeId();
            StringBuilder sb = new StringBuilder();
            sb.append("reset.mPlayLifeId");
            sb.append(this.mPlayLifeId);
        } finally {
            if (this.mReentrantLock.isLocked()) {
                this.mReentrantLock.unlock();
            }
        }
    }

    private String getPlayerErrorInfo() {
        try {
            StringBuilder sb = new StringBuilder();
            LinkedList<String> linkedList = this.mLogInfo;
            if ((linkedList != null && linkedList.size() > 0) || this.mBufferingInfo != null || this.mVoiceInfo != null) {
                AVErrorInfo.setupErrorInfo(this.mContext, sb, "error", "play error", this.mUri);
                Iterator<String> it2 = this.mLogInfo.iterator();
                while (it2.hasNext()) {
                    sb.append(it2.next());
                    sb.append("\n");
                }
                String str = this.mBufferingInfo;
                if (str != null) {
                    sb.append(str);
                    sb.append("\n");
                    this.mBufferingInfo = null;
                }
                String str2 = this.mVoiceInfo;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append("\n");
                    this.mVoiceInfo = null;
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public void TTPlayerClient__release$___twin___() {
        String playerErrorInfo;
        stayAwake(false);
        updateSurfaceScreenOn();
        this.mWriteLock.lock();
        try {
            ITTPlayerRef iTTPlayerRef = this.mPlayer;
            this.mPlayer = null;
            this.mPlayLifeId = -1;
            if (iTTPlayerRef != null) {
                iTTPlayerRef.release();
            }
            SurfaceHolder surfaceHolder = this.mSurfaceHolder;
            if (surfaceHolder != null) {
                surfaceHolder.removeCallback(this.mCallback);
                this.mSurfaceHolder = null;
                this.mRealsedSurface = true;
            }
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.mHandler = null;
            }
            if (this.mLogListener != null && (playerErrorInfo = getPlayerErrorInfo()) != null && !playerErrorInfo.isEmpty()) {
                this.mLogListener.onLogInfo(this.mWrapper, playerErrorInfo);
            }
            this.mContext = null;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void stop() {
        SurfaceHolder surfaceHolder;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                if (this.mConnectedCpu && this.mCodecAndSurfaceReuse == 1 && (surfaceHolder = this.mSurfaceHolder) != null) {
                    surfaceHolder.removeCallback(this.mCallback);
                    this.mSurfaceHolder = null;
                    this.mPlayer.setSurfaceTimeOut(null, 0);
                    this.mConnectedCpu = false;
                    AVLogger.Warn(TAG, this, "testlog: mConnected Cpu " + this.mConnectedCpu);
                }
                this.mPlayer.stop();
            }
            this.mReadLock.unlock();
            stayAwake(false);
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    private String getPlayerCrashedInfo() {
        Context context;
        String crashFileContext;
        String crashFileContext2;
        int value = TTPlayerConfiger.getValue(18, 1);
        StringBuilder sb = new StringBuilder();
        ITTPlayerRef iTTPlayerRef = this.mPlayer;
        if (iTTPlayerRef == null) {
            context = this.mContext;
        } else {
            context = iTTPlayerRef.getContext();
        }
        if (context == null) {
            return "context is null";
        }
        if (value > 1) {
            String existsCrashFilePath = TTCrashUtil.existsCrashFilePath(context);
            if (existsCrashFilePath != null && (crashFileContext2 = TTCrashUtil.getCrashFileContext(context, existsCrashFilePath, sb)) != null) {
                TTCrashUtil.deleteCrashFile(this.mContext, existsCrashFilePath);
                this.mCrashType = 1;
                TTPlayerConfiger.getValue(5, false);
                return crashFileContext2;
            }
            AVErrorInfo.setupPhoneInfo(context, sb);
        }
        String value2 = TTPlayerConfiger.getValue(19, (String) null);
        if (value2 != null && (crashFileContext = TTCrashUtil.getCrashFileContext(this.mContext, value2, sb)) != null) {
            TTCrashUtil.deleteCrashFile(this.mContext, value2);
            this.mCrashType = 1;
            TTPlayerConfiger.getValue(5, false);
            return crashFileContext;
        }
        sb.append("\ncreate time:" + AVTime.getFormatNow());
        sb.append("\nport version:");
        sb.append(value);
        sb.append("\nstart service info:");
        sb.append(TTPlayerConfiger.getValue(16, "not find service start info"));
        sb.append("\nstop service info:");
        sb.append(TTPlayerConfiger.getValue(12, "not find service stop info"));
        sb.append("\ncrash:");
        sb.append(TTPlayerConfiger.getValue(7, false));
        sb.append("\nsdk info:");
        sb.append(TTPlayerConfiger.getValue(15, "not find sdk info"));
        sb.append("\ntimeout count:");
        sb.append(TTPlayerConfiger.getValue(10, -1));
        sb.append("\nforeground:");
        sb.append(TTPlayerConfiger.getValue(21, -1));
        sb.append("\non screen:");
        sb.append(TTPlayerConfiger.getValue(22, -1));
        sb.append("\n battery info:");
        sb.append(TTPlayerConfiger.getValue(23, "not find"));
        sb.append("\nurl:");
        sb.append(this.mUri);
        sb.append("\ncrash:\r\n");
        sb.append((CharSequence) this.mCrashedInfo);
        this.mCrashType = 0;
        if (value > 1) {
            if (TTPlayerConfiger.getValue(5, false)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("<TTPlayerIPClient,getCrashedInfo>");
                sb2.append(sb.toString());
            }
            return TTCrashUtil.getBase64SampleCrash(sb.toString());
        }
        return sb.toString();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnLogListener(MediaPlayer.OnLogListener onLogListener) {
        this.mLogListener = onLogListener;
    }

    @TargetClass("com.ss.ttm.player.TTPlayerClient")
    @Insert("prepareAsync")
    public static void com_ss_ttm_player_TTPlayerClient_com_dragon_read_aop_TTVideoEngineAop_prepareAsync(TTPlayerClient tTPlayerClient) {
        CodecNameCache.g(tTPlayerClient);
        tTPlayerClient.TTPlayerClient__prepareAsync$___twin___();
    }

    @TargetClass("com.ss.ttm.player.TTPlayerClient")
    @Insert("release")
    public static void com_ss_ttm_player_TTPlayerClient_com_dragon_read_aop_TTVideoEngineAop_release(TTPlayerClient tTPlayerClient) {
        CodecNameCache.f(tTPlayerClient);
        tTPlayerClient.TTPlayerClient__release$___twin___();
    }

    public static long getDemuxerFactory(int i) {
        return TTPlayer.getDemuxerFactory(i);
    }

    private void sendSeekCompleted(int i) {
        MediaPlayer.OnSeekCompleteListener onSeekCompleteListener;
        if (!this.mSeekComplete && (onSeekCompleteListener = this.mOnSeekCompleteListener) != null) {
            this.mSeekComplete = true;
            if (i >= this.mPlayLifeId) {
                onSeekCompleteListener.onSeekComplete(this.mWrapper);
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public Object getObjectOption(int i) {
        Object obj;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                obj = this.mPlayer.getObjectOption(i);
            } else {
                obj = null;
            }
            return obj;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public String getSubtitleContent(int i) {
        String str;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                str = this.mPlayer.getSubtitleContent(i);
            } else {
                str = null;
            }
            return str;
        } finally {
            this.mReadLock.unlock();
        }
    }

    protected void onCrashedInfo(String str) {
        if (this.mCrashedInfo.length() < 1024) {
            StringBuilder sb = this.mCrashedInfo;
            sb.append(str);
            sb.append("\n");
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void seekTo(int i) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mSeekComplete = false;
                this.mPlayer.seekTo(i);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void selectTrack(int i) {
        this.mReadLock.lock();
        ITTPlayerRef iTTPlayerRef = this.mPlayer;
        if (iTTPlayerRef != null && i == 0) {
            iTTPlayerRef.setIntOption(261, 0);
        }
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setABRStrategy(ABRStrategy aBRStrategy) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setABRStrategy(aBRStrategy);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setAIBarrageInfo(MaskInfo maskInfo) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setAIBarrageInfo(maskInfo);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setAudioProcessor(AudioProcessor audioProcessor) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setAudioProcessor(audioProcessor);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        ParcelFileDescriptor dup = ParcelFileDescriptor.dup(fileDescriptor);
        try {
            ITTPlayerRef iTTPlayerRef = this.mPlayer;
            if (iTTPlayerRef != null) {
                iTTPlayerRef.setDataSourceFd(dup.getFd());
            }
        } finally {
            if (dup != null) {
                dup.close();
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setFrameMetadataListener(FrameMetadataListener frameMetadataListener) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setFrameMetadataListener(frameMetadataListener);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setLoadControl(LoadControl loadControl) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setLoadControl(loadControl);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setMaskInfo(MaskInfo maskInfo) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setMaskInfo(maskInfo);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setMediaTransport(MediaTransport mediaTransport) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setMediaTransport(mediaTransport);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setPanoVideoControlModel(int i) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setIntOption(11, i);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setScreenOnWhilePlaying(boolean z) {
        if (this.mScreenOnWhilePlaying != z) {
            if (z && this.mSurfaceHolder == null) {
                AVLogger.Warn(TAG, this, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z;
            updateSurfaceScreenOn();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setStrategyParamsTransport(StrategyParamsTransport strategyParamsTransport) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setStrategyParamsTransport(strategyParamsTransport);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setSubInfo(SubInfo subInfo) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setSubInfo(subInfo);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setSurface(Surface surface) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setSurfaceTimeOut(surface, 0);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setWindowClient(TTAVWindowClient tTAVWindowClient) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setWindowClient(tTAVWindowClient);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    private void sendCompletioned(int i) {
        try {
            this.mReentrantLock.lock();
            MediaPlayer.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
            if (onCompletionListener != null && i >= this.mPlayLifeId) {
                onCompletionListener.onCompletion(this.mWrapper);
            }
        } finally {
            if (this.mReentrantLock.isLocked()) {
                this.mReentrantLock.unlock();
            }
        }
    }

    private void stayAwake(boolean z) {
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (z && !wakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!z && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        this.mStayAwake = z;
        updateSurfaceScreenOn();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void deselectTrack(int i) {
        this.mReadLock.lock();
        ITTPlayerRef iTTPlayerRef = this.mPlayer;
        if (iTTPlayerRef != null && i == 0) {
            iTTPlayerRef.setIntOption(261, 1);
        } else if (iTTPlayerRef != null) {
            iTTPlayerRef.setIntOption(65, (i << 8) | 0);
        }
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public String getStringOption(int i) {
        if (i == 5001) {
            return getPlayerCrashedInfo();
        }
        String str = null;
        if (i == 5002) {
            LinkedList<String> linkedList = this.mLogInfo;
            if (linkedList == null || linkedList.size() == 0) {
                return null;
            }
            return getPlayerErrorInfo();
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                str = this.mPlayer.getStringOption(i);
            }
            return str;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        if (iMediaDataSource != null) {
            this.mReadLock.lock();
            try {
                if (isValid()) {
                    this.mPlayer.setDataSource(iMediaDataSource);
                }
                return;
            } finally {
                this.mReadLock.unlock();
            }
        }
        throw new IllegalArgumentException("null mediadatasource pointer.");
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setIsMute(boolean z) {
        int i;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                ITTPlayerRef iTTPlayerRef = this.mPlayer;
                if (z) {
                    i = 1;
                } else {
                    i = 0;
                }
                iTTPlayerRef.setIntOption(12, i);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setLooping(boolean z) {
        int i;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                ITTPlayerRef iTTPlayerRef = this.mPlayer;
                if (z) {
                    i = 1;
                } else {
                    i = 0;
                }
                iTTPlayerRef.setLooping(i);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(3L);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(13L);
                this.mPlayer.setNotifyState(111L);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
        long[] jArr = {0, 45};
        this.mReadLock.lock();
        try {
            if (isValid()) {
                for (int i = 0; i < 2; i++) {
                    this.mPlayer.setNotifyState(jArr[i]);
                }
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(2L);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnSARChangedListener(MediaPlayer.onSARChangedListener onsarchangedlistener) {
        this.mOnSARChangedListener = onsarchangedlistener;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(23L);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(12L);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(6L);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setPlaybackParams(PlaybackParams playbackParams) {
        this.mReadLock.lock();
        try {
            if (isValid() && playbackParams != null && playbackParams.getSpeed() != -1.0f) {
                this.mPlayer.setFloatOption(60, playbackParams.getSpeed());
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void takeScreenshot(MediaPlayer.OnScreenshotListener onScreenshotListener) {
        if (this.mPlayer != null && onScreenshotListener != null) {
            this.mReadLock.lock();
            try {
                if (isValid()) {
                    this.mPlayer.setNotifyState(15L);
                    this.mPlayer.setOnScreenshotListener(onScreenshotListener);
                    this.mPlayer.takeScreenshot();
                }
            } finally {
                this.mReadLock.unlock();
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String str;
        if (message.what != 3) {
            StringBuilder sb = new StringBuilder();
            sb.append("handleMessage send message prev.thread id:");
            sb.append(Thread.currentThread().getId());
        }
        int i = message.arg2;
        int i2 = message.what;
        int i3 = message.arg1;
        Object obj = message.obj;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        handleNotify(i, i2, i3, str);
        if (message.what != 3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("handleMessage send message after.thread id:");
            sb2.append(Thread.currentThread().getId());
            return true;
        }
        return true;
    }

    @Override // com.ss.ttm.player.ISurfaceListener
    public void onSurfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        if (this.mRealsedSurface || this.mIgnoreSurfaceCreated == 1) {
            return;
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                SurfaceHolder surfaceHolder2 = this.mSurfaceHolder;
                if (surfaceHolder != surfaceHolder2) {
                    if (surfaceHolder2 != null) {
                        surfaceHolder2.removeCallback(this.mCallback);
                    }
                    this.mSurfaceHolder = surfaceHolder;
                    if (surfaceHolder != null) {
                        surfaceHolder.addCallback(this.mCallback);
                    }
                }
                this.mPlayer.setSurfaceTimeOut(surfaceHolder.getSurface(), 0);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.ISurfaceListener
    public void onSurfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (this.mRealsedSurface) {
            return;
        }
        if (this.mMediaCodecStopTimeOutMs > 0) {
            try {
                AVThreadPool.addTask(new Callable<String>() { // from class: com.ss.ttm.player.TTPlayerClient.2
                    @Override // java.util.concurrent.Callable
                    public String call() {
                        try {
                            TTPlayerClient.this.mReadLock.lockInterruptibly();
                            try {
                                if (TTPlayerClient.this.isValid()) {
                                    TTPlayerClient.this.mPlayer.setSurfaceTimeOut(null, 0);
                                }
                                TTPlayerClient.this.mReadLock.unlock();
                                return "OK";
                            } catch (Throwable th) {
                                TTPlayerClient.this.mReadLock.unlock();
                                throw th;
                            }
                        } catch (InterruptedException unused) {
                            AVLogger.Error(TTPlayerClient.TAG, this, "mPlayer setsurface null failed.");
                            return "OK";
                        }
                    }
                }).get(this.mMediaCodecStopTimeOutMs, TimeUnit.MILLISECONDS);
                return;
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                AVLogger.Error(TAG, this, "set surface time out");
                return;
            }
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setSurfaceTimeOut(null, 0);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDisplay(SurfaceHolder surfaceHolder) {
        Surface surface;
        SurfaceHolder surfaceHolder2;
        if (this.mCodecAndSurfaceReuse != 0 && (surfaceHolder2 = this.mSurfaceHolder) == surfaceHolder && surfaceHolder2 != null) {
            return;
        }
        SurfaceHolder surfaceHolder3 = this.mSurfaceHolder;
        if (surfaceHolder3 != null) {
            surfaceHolder3.removeCallback(this.mCallback);
        }
        this.mSurfaceHolder = surfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.addCallback(this.mCallback);
            surface = this.mSurfaceHolder.getSurface();
        } else {
            surface = null;
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setSurfaceTimeOut(surface, 0);
            }
            this.mReadLock.unlock();
            updateSurfaceScreenOn();
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnExternInfoListener(MediaPlayer.OnExternInfoListener onExternInfoListener) {
        this.mOnExternInfoListener = onExternInfoListener;
        long[] jArr = {63, 59, 19, 33, 40, 43, 44, 68, 85, 87, 90};
        this.mReadLock.lock();
        try {
            if (isValid()) {
                for (int i = 0; i < 11; i++) {
                    this.mPlayer.setNotifyState(jArr[i]);
                }
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
        long[] jArr = {1, 4, 5, 7, 8, 9, 10, 21, 22, 20, 24, 25, 26, 28, 27, 29, 32, 34, 35, 36, 37, 38, 39, 41, 42, 50, 49, 47, 51, 52, 53, 54, 30, 57, 58, 61, 62, 65, 66, 67, 70, 71, 72, 73, 82, 84, 88, 91, 92};
        this.mReadLock.lock();
        try {
            if (isValid()) {
                for (int i = 0; i < 49; i++) {
                    this.mPlayer.setNotifyState(jArr[i]);
                }
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(String str) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        if (str.toLowerCase(Locale.US).indexOf("://") <= 0) {
            this.mUri = "file://" + str;
        } else {
            this.mUri = str;
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setDataSource(this.mUri);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    public static void setGlobalIntOptionForKey(int i, int i2) {
        ITTPlayerRef.setGlobalIntOptionForKey(i, i2);
    }

    public static void setGlobalStringOptionForKey(int i, String str) {
        ITTPlayerRef.setGlobalStringOptionForKey(i, str);
    }

    public static TTPlayerClient create(MediaPlayer mediaPlayer, Context context) {
        return create(mediaPlayer, context, null, null);
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public float getFloatOption(int i, float f) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                f = this.mPlayer.getFloatOption(i, f);
            }
            return f;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public long getLongOption(int i, long j) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                j = this.mPlayer.getLongOption(i, j);
            }
            return j;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void rotateCamera(float f, float f2) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.rotateCamera(f, f2);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setCacheFile(String str, int i) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setCacheFile(str, i);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setFloatOption(int i, float f) {
        int i2;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                i2 = this.mPlayer.setFloatOption(i, f);
            } else {
                i2 = -1;
            }
            return i2;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setFloatOptionArray(int[] iArr, float[] fArr) {
        int i;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                i = this.mPlayer.setFloatOptionArray(iArr, fArr);
            } else {
                i = -1;
            }
            return i;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setIntOptionArray(int[] iArr, int[] iArr2) {
        int i;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                i = this.mPlayer.setIntOptionArray(iArr, iArr2);
            } else {
                i = -1;
            }
            return i;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setLongOption(int i, long j) {
        int i2;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                i2 = this.mPlayer.setLongOption(i, j);
            } else {
                i2 = -1;
            }
            return i2;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setLongOptionArray(int[] iArr, long[] jArr) {
        int i;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                i = this.mPlayer.setLongOptionArray(iArr, jArr);
            } else {
                i = -1;
            }
            return i;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setOnImageAvailableListener(onImageAvailableListener, handler);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setStringOption(int i, String str) {
        int i2;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                i2 = this.mPlayer.setStringOption(i, str);
            } else {
                i2 = -1;
            }
            return i2;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setStringOptionArray(int[] iArr, String[] strArr) {
        int i;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                i = this.mPlayer.setStringOptionArray(iArr, strArr);
            } else {
                i = -1;
            }
            return i;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setSurfaceTimeOut(Surface surface, int i) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setSurfaceTimeOut(surface, i);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setTraitObject(int i, TraitObject traitObject) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setTraitObject(i, traitObject);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setVolume(float f, float f2) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setVolume(f, f2);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    private void sendErrorInfo(int i, int i2) {
        try {
            this.mReentrantLock.lock();
            MediaPlayer.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null && i2 >= this.mPlayLifeId) {
                int i3 = this.mErrorCode;
                if (i3 == 0) {
                    if (i == 0) {
                        i = -1048575;
                    }
                } else {
                    i = i3;
                }
                onErrorListener.onError(this.mWrapper, i, 0);
            }
        } finally {
            if (this.mReentrantLock.isLocked()) {
                this.mReentrantLock.unlock();
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getIntOption(int i, int i2) {
        if (i == 5000) {
            return this.mErrorCode;
        }
        if (i == 26) {
            return this.mCrashType;
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                i2 = this.mPlayer.getIntOption(i, i2);
            }
            return i2;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void seekTo(int i, int i2) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mSeekComplete = false;
                this.mPlayer.seekTo(i, i2);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setWakeMode(Context context, int i) {
        boolean z;
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                this.mWakeLock.release();
                z = true;
            } else {
                z = false;
            }
            this.mWakeLock = null;
        } else {
            z = false;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i | 536870912, TTPlayerClient.class.getName());
        this.mWakeLock = newWakeLock;
        if (newWakeLock != null) {
            newWakeLock.setReferenceCounted(false);
            if (z) {
                this.mWakeLock.acquire();
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void switchStream(int i, int i2) {
        if (this.mPlayer != null) {
            this.mReadLock.lock();
            try {
                if (isValid()) {
                    this.mPlayer.switchStream(i, i2);
                }
            } finally {
                this.mReadLock.unlock();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
    
        if (0 == 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        setDataSource(r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0059, code lost:
    
        if (0 == 0) goto L32;
     */
    @Override // com.ss.ttm.player.MediaPlayerClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setDataSource(android.content.Context r3, android.net.Uri r4) throws java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException, java.io.IOException {
        /*
            r2 = this;
            if (r4 != 0) goto L3
            return
        L3:
            java.lang.String r0 = r4.getScheme()
            java.lang.String r1 = "content"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L2f
            java.lang.String r0 = "settings"
            java.lang.String r1 = r4.getAuthority()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L2f
            int r4 = android.media.RingtoneManager.getDefaultType(r4)
            android.net.Uri r4 = android.media.RingtoneManager.getActualDefaultRingtoneUri(r3, r4)
            if (r4 == 0) goto L27
            goto L2f
        L27:
            java.io.FileNotFoundException r3 = new java.io.FileNotFoundException
            java.lang.String r4 = "Can't resolve default ringtone"
            r3.<init>(r4)
            throw r3
        L2f:
            r0 = 0
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L54 java.lang.SecurityException -> L58
            java.lang.String r1 = "r"
            android.content.res.AssetFileDescriptor r0 = com.bytedance.security.android.aopcheck.ContentResolverWrapper.openAssetFileDescriptor(r3, r4, r1)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L54 java.lang.SecurityException -> L58
            if (r0 != 0) goto L42
            if (r0 == 0) goto L41
            r0.close()
        L41:
            return
        L42:
            java.io.FileDescriptor r3 = r0.getFileDescriptor()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L54 java.lang.SecurityException -> L58
            r2.setDataSource(r3)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L54 java.lang.SecurityException -> L58
            r0.close()
            return
        L4d:
            r3 = move-exception
            if (r0 == 0) goto L53
            r0.close()
        L53:
            throw r3
        L54:
            if (r0 == 0) goto L5e
            goto L5b
        L58:
            if (r0 == 0) goto L5e
        L5b:
            r0.close()
        L5e:
            java.lang.String r3 = r4.toString()
            r2.setDataSource(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.TTPlayerClient.setDataSource(android.content.Context, android.net.Uri):void");
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setIntOption(int i, int i2) {
        int i3;
        if (i == 1301) {
            if (Looper.myLooper() != null) {
                this.mHandler = new HandlerDelegate(this);
            } else {
                this.mHandler = new HandlerDelegate(Looper.getMainLooper(), this);
            }
            return 0;
        }
        if (i == 41) {
            AVResolver.HOST_MAX_CACHE_TIME = i2;
            return 0;
        }
        if (i == 5003) {
            this.mDisablePlayerStayAwake = i2;
            return 0;
        }
        if (i == 952) {
            this.mMediaCodecStopTimeOutMs = i2;
            return 0;
        }
        if (i == 1007) {
            this.mCodecAndSurfaceReuse = i2;
        } else if (i == 1036) {
            this.mIgnoreSurfaceCreated = i2;
        } else if (i == 984) {
            if (i2 == 0) {
                i2 = 0;
            } else if (i2 == 1) {
                i2 = 16777216;
            } else if (i2 == 2) {
                i2 = 33554432;
            } else if (i2 == 3 || i2 == 4) {
                i2 = 34603008;
            } else if (i2 == 5) {
                i2 = 50331648;
            } else if (i2 == 6) {
                i2 = 67108864;
            }
            AVLogger.setLogLevel(i2);
        } else if (i == 1501) {
            AVLogger.setLogLevel(i2);
        } else if (i == 1502) {
            AVLogger.setLogLevel(i2);
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                i3 = this.mPlayer.setIntOption(i, i2);
            } else {
                i3 = -1;
            }
            return i3;
        } finally {
            this.mReadLock.unlock();
        }
    }

    private void notifyInfo(int i, int i2) {
        int i3;
        if (this.mOnInfoListener == null) {
            return;
        }
        if (i != 4) {
            if (i != 5) {
                if (i != 41) {
                    if (i != 42) {
                        if (i != 57) {
                            if (i != 58) {
                                if (i != 61) {
                                    if (i != 62) {
                                        switch (i) {
                                            case 7:
                                                StringBuilder sb = new StringBuilder();
                                                sb.append("handleNotify --------------->>>>>>info rendering start:what:");
                                                sb.append(i);
                                                sb.append("");
                                                i3 = 3;
                                                break;
                                            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                                                i3 = 801;
                                                break;
                                            case 9:
                                                i3 = 802;
                                                break;
                                            case 10:
                                                i3 = 901;
                                                break;
                                            default:
                                                switch (i) {
                                                    case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                                                        i3 = 251658243;
                                                        break;
                                                    case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                                                        i3 = 251658244;
                                                        break;
                                                    case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                                                        i3 = 251658245;
                                                        break;
                                                    case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                                                        i3 = 251658246;
                                                        break;
                                                    case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                                                        i3 = 251658247;
                                                        break;
                                                    case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                                                        i3 = 251658248;
                                                        break;
                                                    case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                                                        i3 = 251658249;
                                                        break;
                                                    case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                                                        StringBuilder sb2 = new StringBuilder();
                                                        sb2.append("handleNotify --------------->>>>>>info video render stall:what:");
                                                        sb2.append(i);
                                                        sb2.append("");
                                                        i3 = 251658250;
                                                        break;
                                                    case 28:
                                                        StringBuilder sb3 = new StringBuilder();
                                                        sb3.append("handleNotify --------------->>>>>>info audio render stall:what:");
                                                        sb3.append(i);
                                                        sb3.append("");
                                                        i3 = 251658251;
                                                        break;
                                                    case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                                                        StringBuilder sb4 = new StringBuilder();
                                                        sb4.append("handleNotify --------------->>>>>>info audio rendering start:what:");
                                                        sb4.append(i);
                                                        sb4.append("");
                                                        i3 = 251658252;
                                                        break;
                                                    case 30:
                                                        StringBuilder sb5 = new StringBuilder();
                                                        sb5.append("handleNotify --------------->>>>>>info ready for display:what:");
                                                        sb5.append(i);
                                                        sb5.append("");
                                                        i3 = -268435390;
                                                        break;
                                                    case ConstantsAPI.COMMAND_PRELOAD_MINI_PROGRAM_ENVIRONMENT /* 32 */:
                                                        i3 = 251658253;
                                                        break;
                                                    case 47:
                                                        StringBuilder sb6 = new StringBuilder();
                                                        sb6.append("handleNotify --------------->>>>>>info preBuffering  start:what:");
                                                        sb6.append(i);
                                                        sb6.append("");
                                                        i3 = -268435408;
                                                        break;
                                                    case 82:
                                                        i3 = -268435384;
                                                        break;
                                                    case 84:
                                                        i3 = -268435383;
                                                        break;
                                                    case 88:
                                                        i3 = -268435382;
                                                        break;
                                                    case 91:
                                                        i3 = -268435381;
                                                        break;
                                                    case 92:
                                                        i3 = -268435380;
                                                        break;
                                                    case TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE /* 111 */:
                                                        i3 = -268435379;
                                                        break;
                                                    case 1000:
                                                        i3 = 16777217;
                                                        break;
                                                    default:
                                                        switch (i) {
                                                            case ConstantsAPI.COMMAND_FINDER_OPEN_PROFILE /* 34 */:
                                                                StringBuilder sb7 = new StringBuilder();
                                                                sb7.append("handleNotify --------------->>>>>>info video demuxer stall:what:");
                                                                sb7.append(i);
                                                                sb7.append("");
                                                                i3 = -268435442;
                                                                break;
                                                            case ConstantsAPI.COMMAND_FINDER_OPEN_LIVE /* 35 */:
                                                                StringBuilder sb8 = new StringBuilder();
                                                                sb8.append("handleNotify --------------->>>>>>info audio demuxer stall:what:");
                                                                sb8.append(i);
                                                                sb8.append("");
                                                                i3 = -268435441;
                                                                break;
                                                            case ConstantsAPI.COMMAND_FINDER_OPEN_FEED /* 36 */:
                                                                StringBuilder sb9 = new StringBuilder();
                                                                sb9.append("handleNotify --------------->>>>>>info video decode stall:what:");
                                                                sb9.append(i);
                                                                sb9.append("");
                                                                i3 = -268435440;
                                                                break;
                                                            case ConstantsAPI.COMMAND_OPEN_CUSTOMER_SERVICE_CHAT /* 37 */:
                                                                StringBuilder sb10 = new StringBuilder();
                                                                sb10.append("handleNotify --------------->>>>>>info audio decode stall:what:");
                                                                sb10.append(i);
                                                                sb10.append("");
                                                                i3 = -268435439;
                                                                break;
                                                            case ConstantsAPI.COMMAND_OPEN_QRCODE_PAY /* 38 */:
                                                                i3 = -268435438;
                                                                break;
                                                            case ConstantsAPI.COMMAND_FINDER_START_LIVE /* 39 */:
                                                                StringBuilder sb11 = new StringBuilder();
                                                                sb11.append("handleNotify --------------->>>>>>info audio pts back:what:");
                                                                sb11.append(i);
                                                                sb11.append("");
                                                                i3 = -268435437;
                                                                break;
                                                            default:
                                                                switch (i) {
                                                                    case 49:
                                                                        i3 = -268435392;
                                                                        break;
                                                                    case 50:
                                                                        i3 = -268435391;
                                                                        break;
                                                                    case IVideoEventLogger.LOGGER_OPTION_ENABLE_PLAYER_DEGRADE /* 51 */:
                                                                        i3 = -268435407;
                                                                        break;
                                                                    case IVideoEventLogger.LOGGER_OPTION_IS_DEGRADE_RELEASE /* 52 */:
                                                                        i3 = -268435406;
                                                                        break;
                                                                    case ITTVideoEngineInternal.PLAYER_OPTION_GET_WATCHED_DUTATION /* 53 */:
                                                                        StringBuilder sb12 = new StringBuilder();
                                                                        sb12.append("handleNotify --------------->>>>>>formater start:what:");
                                                                        sb12.append(i);
                                                                        sb12.append("");
                                                                        i3 = -268435405;
                                                                        break;
                                                                    case 54:
                                                                        StringBuilder sb13 = new StringBuilder();
                                                                        sb13.append("handleNotify --------------->>>>>>decoder start:what:");
                                                                        sb13.append(i);
                                                                        sb13.append("");
                                                                        i3 = -268435404;
                                                                        break;
                                                                    default:
                                                                        switch (i) {
                                                                            case 65:
                                                                                i3 = -268435435;
                                                                                break;
                                                                            case 66:
                                                                                i3 = -268435434;
                                                                                break;
                                                                            case 67:
                                                                                i3 = -268435389;
                                                                                break;
                                                                            default:
                                                                                switch (i) {
                                                                                    case 70:
                                                                                        i3 = -268435388;
                                                                                        break;
                                                                                    case 71:
                                                                                        i3 = -268435387;
                                                                                        break;
                                                                                    case 72:
                                                                                        i3 = -268435386;
                                                                                        break;
                                                                                    case 73:
                                                                                        i3 = -268435385;
                                                                                        break;
                                                                                    default:
                                                                                        i3 = -1;
                                                                                        break;
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                    } else {
                                        i3 = -268435436;
                                    }
                                } else {
                                    i3 = -268435401;
                                }
                            } else {
                                i3 = -268435402;
                            }
                        } else {
                            i3 = -268435403;
                        }
                    } else {
                        StringBuilder sb14 = new StringBuilder();
                        sb14.append("handleNotify --------------->>>>>>info rtc audio decode stall:what:");
                        sb14.append(i);
                        sb14.append("");
                        i3 = -268435423;
                    }
                } else {
                    StringBuilder sb15 = new StringBuilder();
                    sb15.append("handleNotify --------------->>>>>>info rtc video decode stall:what:");
                    sb15.append(i);
                    sb15.append("");
                    i3 = -268435424;
                }
            } else {
                StringBuilder sb16 = new StringBuilder();
                sb16.append("handleNotify --------------->>>>>>info buffering  end:what:");
                sb16.append(i);
                sb16.append("");
                i3 = TTVideoEngineInterface.PLAYER_OPTION_KERNAL_LOG_LEVER;
            }
        } else {
            StringBuilder sb17 = new StringBuilder();
            sb17.append("handleNotify --------------->>>>>>info buffering  start:what:");
            sb17.append(i);
            sb17.append("");
            i3 = 701;
        }
        this.mOnInfoListener.onInfo(this.mWrapper, i3, i2);
    }

    public static TTPlayerClient create(MediaPlayer mediaPlayer, Context context, HashMap<Integer, Integer> hashMap) {
        return create(mediaPlayer, context, hashMap, null);
    }

    private void onExternInfo(int i, int i2, String str) {
        if (this.mRtcPlay != 0) {
            try {
                this.mReentrantLockInRtc.lock();
                MediaPlayer.OnExternInfoListener onExternInfoListener = this.mOnExternInfoListener;
                if (onExternInfoListener != null && str != null) {
                    onExternInfoListener.onExternInfo(this.mWrapper, i, str);
                    this.mOnExternInfoListener.onExternInfo2(this.mWrapper, i, i2, str);
                }
                return;
            } finally {
                this.mReentrantLockInRtc.unlock();
            }
        }
        MediaPlayer.OnExternInfoListener onExternInfoListener2 = this.mOnExternInfoListener;
        if (onExternInfoListener2 != null && str != null) {
            onExternInfoListener2.onExternInfo(this.mWrapper, i, str);
            this.mOnExternInfoListener.onExternInfo2(this.mWrapper, i, i2, str);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void mouseEvent(int i, int i2, int i3) {
        int i4 = 1;
        if (i != 0) {
            if (i != 1) {
                i4 = 2;
                if (i != 2) {
                    i4 = 0;
                }
            } else {
                i4 = 3;
            }
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.mouseEvent(i4, i2, i3);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    protected void onPlayLogInfo(int i, int i2, String str) {
        if (i == 2) {
            if (i2 == 1) {
                this.mVoiceInfo = str;
                return;
            } else {
                if (i2 == 0) {
                    this.mBufferingInfo = str;
                    return;
                }
                return;
            }
        }
        if (i == 0) {
            this.mErrorCode = i2;
        }
        if (str != null) {
            if (this.mLogInfo.size() > 40) {
                this.mLogInfo.removeFirst();
            }
            this.mLogInfo.addLast(String.format(Locale.US, "%s&&time:%d", str, Long.valueOf(System.currentTimeMillis())));
        }
    }

    private TTPlayerClient(Context context, HashMap<Integer, Integer> hashMap, OnceConfig onceConfig) {
        this.mRealsedSurface = false;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWritedLock = reentrantReadWriteLock;
        this.mReadLock = reentrantReadWriteLock.readLock();
        this.mWriteLock = reentrantReadWriteLock.writeLock();
        this.mErrorCode = 0;
        this.mRtcPlay = 0;
        this.mCrashedInfo = new StringBuilder(1024);
        this.mCrashType = -1;
        this.mDisablePlayerStayAwake = 0;
        this.mMediaCodecStopTimeOutMs = -1;
        this.mCodecAndSurfaceReuse = 0;
        this.mIgnoreSurfaceCreated = 0;
        this.mConnectedCpu = false;
        this.mConfigParams = hashMap;
        this.mRealsedSurface = false;
        this.mCallback = new TTSurfaceCallback(this);
        this.mContext = context;
        if (Looper.myLooper() != null) {
            this.mHandler = new HandlerDelegate(this);
        } else {
            this.mHandler = new HandlerDelegate(Looper.getMainLooper(), this);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        if (uri == null) {
            return;
        }
        setDataSource(context, uri);
        if (map != null && map.size() != 0) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append(": ");
                sb.append(entry.getValue());
                sb.append("\r\n");
            }
            this.mReadLock.lock();
            try {
                if (isValid()) {
                    this.mPlayer.setStringOption(20, sb.toString());
                }
            } finally {
                this.mReadLock.unlock();
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IllegalArgumentException, IOException {
        setDataSource(fileDescriptor);
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setLongOption(135, j);
                this.mPlayer.setLongOption(136, j2);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @TargetClass("com.ss.ttm.player.TTPlayerClient")
    @Insert("create")
    public static TTPlayerClient com_ss_ttm_player_TTPlayerClient_com_dragon_read_aop_TTVideoEngineAop_create(MediaPlayer mediaPlayer, Context context, HashMap hashMap, OnceConfig onceConfig) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        return TTPlayerClient__create$___twin___(mediaPlayer, context, hashMap, onceConfig);
    }

    public void onPlayerNotify(int i, int i2, int i3, String str) {
        if (i2 != 3) {
            StringBuilder sb = new StringBuilder();
            sb.append("onPlayerNotify send message start .thread id:");
            sb.append(Thread.currentThread().getId());
        }
        onPlayerNotifyWithoutLock(i, i2, i3, str);
    }

    public static synchronized TTPlayerClient TTPlayerClient__create$___twin___(MediaPlayer mediaPlayer, Context context, HashMap<Integer, Integer> hashMap, OnceConfig onceConfig) {
        synchronized (TTPlayerClient.class) {
            TTVersion.saveVersionInfo();
            if (context != null) {
                context = context.getApplicationContext();
            }
            TTPlayerClient tTPlayerClient = new TTPlayerClient(context, hashMap, onceConfig);
            ITTPlayerRef create = ITTPlayerRef.create(context, tTPlayerClient, hashMap, onceConfig);
            if (create == null) {
                return null;
            }
            tTPlayerClient.mPlayer = create;
            tTPlayerClient.mWrapper = mediaPlayer;
            return tTPlayerClient;
        }
    }

    private void onPlayerNotifyWithoutLock(int i, int i2, int i3, String str) {
        if (this.mHandler == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("onPlayerNotify send message play is null:thread id");
            sb.append(Thread.currentThread().getId());
            return;
        }
        if (i2 == 40 && str != null) {
            handleNotify(i, i2, i3, str);
            return;
        }
        if (i2 != 3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onPlayerNotify send message prev.thread id:");
            sb2.append(Thread.currentThread().getId());
        }
        Message obtainMessage = this.mHandler.obtainMessage(i2, i3, i);
        obtainMessage.obj = str;
        obtainMessage.sendToTarget();
        if (i2 != 3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("onPlayerNotify send message after.thread id:");
            sb3.append(Thread.currentThread().getId());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void handleNotify(int i, int i2, int i3, String str) {
        if (i2 != 0) {
            if (i2 != 12) {
                if (i2 != 13) {
                    if (i2 != 84) {
                        if (i2 != 85) {
                            switch (i2) {
                                case 0:
                                case 45:
                                    break;
                                case ConstantsAPI.COMMAND_PRELOAD_MINI_PROGRAM_ENVIRONMENT /* 32 */:
                                case ConstantsAPI.COMMAND_FINDER_OPEN_PROFILE /* 34 */:
                                case ConstantsAPI.COMMAND_FINDER_OPEN_LIVE /* 35 */:
                                case ConstantsAPI.COMMAND_FINDER_OPEN_FEED /* 36 */:
                                case ConstantsAPI.COMMAND_OPEN_CUSTOMER_SERVICE_CHAT /* 37 */:
                                case ConstantsAPI.COMMAND_OPEN_QRCODE_PAY /* 38 */:
                                case ConstantsAPI.COMMAND_FINDER_START_LIVE /* 39 */:
                                case ConstantsAPI.COMMAND_FINDER_OPEN_EVENT /* 41 */:
                                case 42:
                                case 47:
                                case 49:
                                case 82:
                                case 88:
                                case 91:
                                case 92:
                                case TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE /* 111 */:
                                case 1000:
                                    break;
                                case ConstantsAPI.COMMAND_FINDER_SHARE_VIDEO /* 33 */:
                                case 40:
                                case 43:
                                case 44:
                                case 87:
                                case 90:
                                    break;
                                case 20000:
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("handleNotify -------------->>>>>>>Completed:what:");
                                    sb.append(i2);
                                    sb.append(",parameter:");
                                    sb.append(i3);
                                    if (this.mErrorCode == -2139062143) {
                                        return;
                                    }
                                    this.mErrorCode = -2139062143;
                                    this.mWriteLock.lock();
                                    try {
                                        ITTPlayerRef iTTPlayerRef = this.mPlayer;
                                        if (iTTPlayerRef != null) {
                                            this.mPlayer = null;
                                            iTTPlayerRef.invalid();
                                            this.mWriteLock.unlock();
                                            HashMap<Integer, Integer> hashMap = this.mConfigParams;
                                            if (hashMap != null && hashMap.get(100).intValue() == 1) {
                                                this.mConfigParams.put(7, 1);
                                            } else {
                                                TTPlayerConfiger.setValue(7, true);
                                            }
                                            stayAwake(false);
                                            sendSeekCompleted(i);
                                            sendErrorInfo(i3, i);
                                            sendCompletioned(i);
                                            return;
                                        }
                                        return;
                                    } finally {
                                        this.mWriteLock.unlock();
                                    }
                                default:
                                    switch (i2) {
                                        case 2:
                                            if (this.mOnPreparedListener != null) {
                                                StringBuilder sb2 = new StringBuilder();
                                                sb2.append("handleNotify --------------->>>>>>Prepared:what:");
                                                sb2.append(i2);
                                                sb2.append(",parameter:");
                                                sb2.append(i3);
                                                this.mOnPreparedListener.onPrepared(this.mWrapper);
                                                return;
                                            }
                                            return;
                                        case 3:
                                            if (i3 == 100) {
                                                StringBuilder sb3 = new StringBuilder();
                                                sb3.append("handleNotify -------------->>>>>>>update buffer:what:");
                                                sb3.append(i2);
                                                sb3.append(",parameter:");
                                                sb3.append(i3);
                                            }
                                            MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = this.mOnBufferingUpdateListener;
                                            if (onBufferingUpdateListener != null) {
                                                onBufferingUpdateListener.onBufferingUpdate(this.mWrapper, i3);
                                                return;
                                            }
                                            return;
                                        case 4:
                                        case 5:
                                        case 7:
                                        case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                                        case 9:
                                        case 10:
                                            break;
                                        case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                                            MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
                                            if (onVideoSizeChangedListener != null) {
                                                onVideoSizeChangedListener.onVideoSizeChanged(this.mWrapper, 65535 & i3, i3 >> 16);
                                                return;
                                            }
                                            return;
                                        default:
                                            switch (i2) {
                                                case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                                                    break;
                                                case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                                                case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                                                case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                                                case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                                                case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                                                case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                                                case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                                                case 28:
                                                case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                                                case 30:
                                                    break;
                                                case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                                                    StringBuilder sb4 = new StringBuilder();
                                                    sb4.append("handleNotify --------------->>>>>>IsSARChange:what:");
                                                    sb4.append(i2);
                                                    sb4.append(",num:");
                                                    int i4 = 65535 & i3;
                                                    sb4.append(i4);
                                                    sb4.append(",den:");
                                                    int i5 = i3 >> 16;
                                                    sb4.append(i5);
                                                    MediaPlayer.onSARChangedListener onsarchangedlistener = this.mOnSARChangedListener;
                                                    if (onsarchangedlistener != null) {
                                                        onsarchangedlistener.onSARChanged(this.mWrapper, i4, i5);
                                                        return;
                                                    }
                                                    return;
                                                default:
                                                    switch (i2) {
                                                        default:
                                                            switch (i2) {
                                                                case 57:
                                                                case 58:
                                                                    break;
                                                                case 59:
                                                                    break;
                                                                default:
                                                                    switch (i2) {
                                                                        case 61:
                                                                        case 62:
                                                                            break;
                                                                        case 63:
                                                                            break;
                                                                        default:
                                                                            switch (i2) {
                                                                                case 65:
                                                                                case 66:
                                                                                case 67:
                                                                                    break;
                                                                                case 68:
                                                                                    break;
                                                                                default:
                                                                                    switch (i2) {
                                                                                        case 70:
                                                                                        case 71:
                                                                                        case 72:
                                                                                            break;
                                                                                        case 73:
                                                                                            this.mConnectedCpu = true;
                                                                                            notifyInfo(i2, i3);
                                                                                            return;
                                                                                        default:
                                                                                            return;
                                                                                    }
                                                                            }
                                                                    }
                                                            }
                                                        case IVideoEventLogger.LOGGER_OPTION_ENABLE_PLAYER_DEGRADE /* 51 */:
                                                        case IVideoEventLogger.LOGGER_OPTION_IS_DEGRADE_RELEASE /* 52 */:
                                                        case ITTVideoEngineInternal.PLAYER_OPTION_GET_WATCHED_DUTATION /* 53 */:
                                                        case 54:
                                                            notifyInfo(i2, i3);
                                                            return;
                                                    }
                                            }
                                    }
                            }
                        }
                        onExternInfo(i2, i3, str);
                        return;
                    }
                    notifyInfo(i2, i3);
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleNotify -------------->>>>>>>Completed:what:");
                sb5.append(i2);
                sb5.append(",parameter:");
                sb5.append(i3);
                stayAwake(false);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("life:");
                sb6.append(i);
                sb6.append(",plifeId:");
                sb6.append(this.mPlayLifeId);
                sendSeekCompleted(i);
                sendCompletioned(i);
                return;
            }
            StringBuilder sb7 = new StringBuilder();
            sb7.append("handleNotify -------------->>>>>>>update seek complete:what:");
            sb7.append(i2);
            sb7.append(",parameter:");
            sb7.append(i3);
            sendSeekCompleted(i);
            return;
        }
        StringBuilder sb8 = new StringBuilder();
        sb8.append("handleNotify -------------->>>>>>>Error:what:");
        sb8.append(i2);
        sb8.append(",parameter:");
        sb8.append(i3);
        stayAwake(false);
        if (i3 == -499989) {
            HashMap<Integer, Integer> hashMap2 = this.mConfigParams;
            if (hashMap2 != null && hashMap2.get(100).intValue() == 1) {
                this.mConfigParams.put(8, 1);
            } else {
                TTPlayerConfiger.setValue(8, true);
            }
        }
        StringBuilder sb9 = new StringBuilder();
        sb9.append("life:");
        sb9.append(i);
        sb9.append(",plifeId:");
        sb9.append(this.mPlayLifeId);
        sendSeekCompleted(i);
        sendErrorInfo(i3, i);
    }
}
