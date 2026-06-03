package com.ss.ttvideoengine;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttm.player.TTPlayerConfiger;
import com.ss.ttvideoengine.configcenter.IEngineConfig;
import com.ss.ttvideoengine.configcenter.PlayerConfigExecutor;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.IPlayDurationManager;
import com.ss.ttvideoengine.utils.TTVideoEngineInternalHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineInternalLog;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class TTVideoEngineInternal implements ITTVideoEngineInternal, ITTVideoEngineEventSource {
    private static int sIsColdStart;
    protected int mAllowAllExtensions;
    protected int mConfigCenterVersion;
    protected Context mContext;
    protected int mEnableMasterM3u8Optimize;
    protected int mEnablePlaySpeedExtend;
    protected IEngineConfig mEngineConfig;
    protected String mInitialURL;
    protected boolean mIsMute;
    protected boolean mLooping;
    protected MediaPlayer mMediaPlayer;
    protected MyMediaPlayerListener mMediaPlayerListener;
    protected IPlayDurationManager mPlayDuration;
    protected PlaybackParams mPlaybackParams;
    protected PlayerConfigExecutor mPlayerConfigExecutor;
    protected int mPlayerType;
    protected SeekCompletionListener mSeekCompletionListener;
    protected Surface mSurface;
    protected SurfaceHolder mSurfaceHolder;
    protected String mTag = "";
    protected String mSubTag = "";
    protected HashMap<Integer, Integer> mConfigParams = null;
    protected int mSurfaceHolderByKernel = 0;
    protected int mState = 0;
    protected int mPlaybackState = 0;
    protected int mLoadState = 0;
    protected int mSyncMaster = 0;
    protected int mExtVoiceFormat = -1;
    protected int mBufferingType = -1;
    private String mSourceTypeStr = "";
    protected boolean mIsDirectURL = false;
    protected String mDirectURL = "";
    protected String mDirectUrlSrc = "";
    protected String[] mOriginalUrls = null;
    protected String mCurrentUrl = null;
    protected int mCurrentUrlIndex = 0;
    protected boolean mIsLocal = false;
    protected String mLocalURL = "";
    protected int mConfigParamsOption = 1;
    protected int mForbidOSPlayer = 0;
    protected int mFallbackExoFirst = -1;
    protected int mPlayerDegradeMode = 0;
    protected int mDisableThreadPoolUsing = 0;
    protected int mIsColdStart = 0;
    protected boolean mShouldPlay = false;
    protected boolean mShouldStop = false;
    protected boolean mUserStopped = false;
    protected boolean mPausedBeforePrepared = false;
    protected boolean mStarted = false;
    protected boolean mPrepared = false;
    protected volatile boolean mReleased = false;
    protected boolean mHasComplete = false;
    protected boolean mErrorEnd = false;
    protected boolean mEngineHasUsed = false;
    protected long mPlayTime = 0;
    protected boolean mRetrying = false;
    protected boolean mRetryingNotHandleError = false;
    protected int mAccumulatedErrorCount = 0;
    protected boolean mIsPlayComplete = false;
    protected boolean mHasFirstFrameShown = false;
    protected boolean mTexNotifyFirstFrame = false;
    protected boolean mFirstGetWidthHeight = true;
    protected boolean mSeeking = false;
    protected long mSeekingStartTime = 0;
    protected int mLastPlaybackTime = 0;
    protected float mLeftVolume = -1.0f;
    protected float mRightVolume = -1.0f;
    protected int mDuration = 0;
    protected int mCurPlayBackTime = 0;
    protected int mLoadedProgress = 0;
    protected int mWidth = 0;
    protected int mHeight = 0;
    protected int mCodecId = 0;
    protected int mAsyncInitEnable = 0;
    protected int mSetTrackVolume = 0;
    protected boolean mIsStartPlayAutomatically = true;
    protected int mCleanWhenStop = 0;
    protected int mMaxAccumulatedCountSetByUser = 30;
    protected int mRadioModeEnable = 0;
    protected long mLastSwitchRadioModeTime = 0;
    protected int mHardwareDecodeEnablePlayer2 = 0;
    protected int mDisableResetSystemVolume = 0;
    protected int mVideoCodecType = -1;
    protected int mAudioCodecType = -1;
    protected int mVideoCodecID = -1;
    protected int mAudioCodecID = -1;
    protected String mExoLoadControlParameters = null;
    protected int mExoRenderReadyMs = -1;
    protected int mExoConsecutiveFailNum = -1;
    protected int mExoCodecReusable = 0;
    protected int mExoCodecAsyncInitEnable = 0;
    protected int mExoAllowMediaCodecHelper = 0;
    protected boolean mExoEnableNativeMdl = false;
    protected int mErrorCount = 0;
    protected Error mError = null;
    protected String mPlayLoadConfig = "";
    protected String mPlayRangeConfig = "";
    protected String mPlayBufferConfig = "";

    abstract MediaPlayer createMediaPlayer();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public float getFloatOption(int i) {
        return 0.0f;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public String getStringOption(int i) {
        return "";
    }

    public abstract String logcatTag();

    protected void notifyBufferEnd(int i) {
    }

    protected void notifyBufferStart(int i, int i2, int i3) {
    }

    protected void notifyBufferingUpdate(int i) {
    }

    protected void notifyCompletion() {
    }

    protected void notifyError(Error error) {
    }

    protected void notifyInfoIdChanged(int i) {
    }

    protected void notifyLoadStateChanged(int i) {
    }

    protected void notifyPlaybackStateChanged(int i) {
    }

    protected void notifyPrepare() {
    }

    protected void notifyPrepared() {
    }

    protected void notifyReadyForDisplay() {
    }

    protected void notifyRenderStart() {
    }

    protected void notifySARChanged(int i, int i2) {
    }

    protected void notifySeekCompletion(boolean z) {
    }

    protected void notifyStreamChanged(int i) {
    }

    protected void notifyVideoSizeChanged(int i, int i2) {
    }

    protected void onMediaPlayerBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    protected void onMediaPlayerCompletion(MediaPlayer mediaPlayer) {
    }

    protected boolean onMediaPlayerError(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }

    protected boolean onMediaPlayerInfo(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }

    protected void onMediaPlayerPrepared(MediaPlayer mediaPlayer) {
    }

    protected void onMediaPlayerSARChanged(MediaPlayer mediaPlayer, int i, int i2) {
    }

    protected void onMediaPlayerSeekComplete(MediaPlayer mediaPlayer, boolean z) {
    }

    protected void onMediaPlayerVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
    }

    protected void receivedError(Error error) {
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void resetEngine() {
    }

    protected void updateLoadState(int i, int i2) {
    }

    protected void updatePlaybackState(int i) {
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getBufferingType() {
        return this.mBufferingType;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getDuration() {
        return this.mDuration;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getLoadState() {
        return this.mLoadState;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getLoadedProgress() {
        return this.mLoadedProgress;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getPlaybackState() {
        return this.mPlaybackState;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public Surface getSurface() {
        return this.mSurface;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isLooping() {
        return this.mLooping;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isShouldPlay() {
        return this.mShouldPlay;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isStarted() {
        return this.mStarted;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getCurrentPlaybackTimeAsync() {
        return getCurrentPlaybackTime();
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public float getVolume() {
        return TTVideoEngineInternalHelper.getVolume(this.mContext);
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isOSPlayer() {
        return isPlayerType(2);
    }

    static {
        Covode.recordClassIndex(652357);
        sIsColdStart = 1;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getVideoHeight() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getVideoWidth() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getWatchedDuration() {
        IPlayDurationManager iPlayDurationManager = this.mPlayDuration;
        if (iPlayDurationManager != null) {
            return iPlayDurationManager.getPlayedDuration();
        }
        return 0;
    }

    protected void releaseMediaPlayer() {
        this.mMediaPlayer.release();
        this.mMediaPlayer = null;
        this.mTexNotifyFirstFrame = false;
    }

    protected void resetMediaPlayerOptions() {
        this.mMediaPlayer.setIntOption(59, this.mHardwareDecodeEnablePlayer2);
    }

    public boolean isInHousePlayer() {
        if (!isPlayerType(0) && !isPlayerType(1) && !isPlayerType(3) && !isPlayerType(4)) {
            return false;
        }
        return true;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isMute() {
        if (this.mState == 3 && (this.mShouldPlay || this.mPlaybackState == 2)) {
            boolean z = this.mIsMute;
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                return mediaPlayer.isMute();
            }
            return z;
        }
        return this.mIsMute;
    }

    protected boolean shouldPrepare() {
        int i = this.mPlaybackState;
        if ((i == 0 || i == 3) && !this.mPrepared) {
            return true;
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && mediaPlayer.getPlayerType() == 0 && !this.mPrepared) {
            return true;
        }
        return false;
    }

    protected boolean needReleaseMediaPlayer() {
        if (this.mMediaPlayer.getPlayerType() != 0 && this.mMediaPlayer.getPlayerType() != 5 && this.mMediaPlayer.getPlayerType() != 3 && this.mMediaPlayer.getPlayerType() != 4) {
            return false;
        }
        return true;
    }

    protected void registerListenerMediaPlayer() {
        if (this.mMediaPlayer == null) {
            return;
        }
        MyMediaPlayerListener myMediaPlayerListener = new MyMediaPlayerListener(this);
        this.mMediaPlayerListener = myMediaPlayerListener;
        this.mMediaPlayer.setOnPreparedListener(myMediaPlayerListener);
        this.mMediaPlayer.setOnInfoListener(this.mMediaPlayerListener);
        this.mMediaPlayer.setOnBufferingUpdateListener(this.mMediaPlayerListener);
        this.mMediaPlayer.setOnCompletionListener(this.mMediaPlayerListener);
        this.mMediaPlayer.setOnErrorListener(this.mMediaPlayerListener);
        this.mMediaPlayer.setOnSeekCompleteListener(this.mMediaPlayerListener);
        this.mMediaPlayer.setOnVideoSizeChangedListener(this.mMediaPlayerListener);
        this.mMediaPlayer.setOnSARChangedListener(this.mMediaPlayerListener);
    }

    protected void setMediaPlayerOptions() {
        this.mMediaPlayer.setIntOption(94, getConfigInt(415, this.mSetTrackVolume));
        this.mMediaPlayer.setIntOption(98, getConfigInt(340, this.mDisableResetSystemVolume));
        this.mMediaPlayer.setIntOption(261, this.mRadioModeEnable);
        setPlayerMute(this.mIsMute);
        float f = this.mLeftVolume;
        if (f >= 0.0f) {
            float f2 = this.mRightVolume;
            if (f2 >= 0.0f) {
                setPlayerVolume(f, f2);
            }
        }
        if (this.mHardwareDecodeEnablePlayer2 == 1) {
            this.mMediaPlayer.setIntOption(182, this.mCodecId);
            this.mMediaPlayer.setIntOption(181, this.mAsyncInitEnable);
        }
        if (this.mPlayerType == 5) {
            String str = this.mExoLoadControlParameters;
            if (str != null) {
                this.mMediaPlayer.setStringOption(5000, str);
            }
            int i = this.mExoRenderReadyMs;
            if (i >= 0) {
                this.mMediaPlayer.setIntOption(5001, i);
            }
            int i2 = this.mExoConsecutiveFailNum;
            if (i2 >= 0) {
                this.mMediaPlayer.setIntOption(5002, i2);
            }
            int i3 = this.mExoCodecReusable;
            if (i3 >= 0) {
                this.mMediaPlayer.setIntOption(5003, i3);
            }
            int i4 = this.mExoCodecAsyncInitEnable;
            if (i4 >= 0) {
                this.mMediaPlayer.setIntOption(5004, i4);
            }
            int i5 = this.mExoAllowMediaCodecHelper;
            if (i5 >= 0) {
                this.mMediaPlayer.setIntOption(5005, i5);
            }
        }
    }

    private static class MyMediaPlayerListener implements MediaPlayer.OnPreparedListener, MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.onSARChangedListener {
        private final WeakReference<TTVideoEngineInternal> mVideoEngineInternalRef;

        static {
            Covode.recordClassIndex(652358);
        }

        public MyMediaPlayerListener(TTVideoEngineInternal tTVideoEngineInternal) {
            this.mVideoEngineInternalRef = new WeakReference<>(tTVideoEngineInternal);
        }

        @Override // com.ss.ttm.player.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            TTVideoEngineInternal tTVideoEngineInternal = this.mVideoEngineInternalRef.get();
            if (tTVideoEngineInternal == null) {
                return;
            }
            tTVideoEngineInternal.onMediaPlayerCompletion(mediaPlayer);
        }

        @Override // com.ss.ttm.player.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            TTVideoEngineInternal tTVideoEngineInternal = this.mVideoEngineInternalRef.get();
            if (tTVideoEngineInternal == null) {
                return;
            }
            tTVideoEngineInternal.onMediaPlayerPrepared(mediaPlayer);
        }

        @Override // com.ss.ttm.player.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            TTVideoEngineInternal tTVideoEngineInternal = this.mVideoEngineInternalRef.get();
            if (tTVideoEngineInternal == null) {
                return;
            }
            tTVideoEngineInternal.onMediaPlayerSeekComplete(mediaPlayer, true);
        }

        @Override // com.ss.ttm.player.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            TTVideoEngineInternal tTVideoEngineInternal = this.mVideoEngineInternalRef.get();
            if (tTVideoEngineInternal == null) {
                return;
            }
            tTVideoEngineInternal.onMediaPlayerBufferingUpdate(mediaPlayer, i);
        }

        @Override // com.ss.ttm.player.MediaPlayer.onSARChangedListener
        public void onSARChanged(MediaPlayer mediaPlayer, int i, int i2) {
            TTVideoEngineInternal tTVideoEngineInternal = this.mVideoEngineInternalRef.get();
            if (tTVideoEngineInternal == null) {
                return;
            }
            tTVideoEngineInternal.onMediaPlayerSARChanged(mediaPlayer, i, i2);
        }

        @Override // com.ss.ttm.player.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            TTVideoEngineInternal tTVideoEngineInternal = this.mVideoEngineInternalRef.get();
            if (tTVideoEngineInternal == null) {
                return;
            }
            tTVideoEngineInternal.onMediaPlayerVideoSizeChanged(mediaPlayer, i, i2);
        }

        @Override // com.ss.ttm.player.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            TTVideoEngineInternal tTVideoEngineInternal = this.mVideoEngineInternalRef.get();
            if (tTVideoEngineInternal == null) {
                return false;
            }
            return tTVideoEngineInternal.onMediaPlayerError(mediaPlayer, i, i2);
        }

        @Override // com.ss.ttm.player.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            TTVideoEngineInternal tTVideoEngineInternal = this.mVideoEngineInternalRef.get();
            if (tTVideoEngineInternal == null) {
                return false;
            }
            return tTVideoEngineInternal.onMediaPlayerInfo(mediaPlayer, i, i2);
        }
    }

    public static String logcatTag(TTVideoEngineInternal tTVideoEngineInternal) {
        if (tTVideoEngineInternal == null) {
            return "TTVideoEngine";
        }
        return tTVideoEngineInternal.logcatTag();
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public long getLongOption(int i) {
        if (this.mConfigCenterVersion > 0) {
            return this.mEngineConfig.getLongOption(i);
        }
        return -1L;
    }

    protected static int transMediaPlayerType(MediaPlayer mediaPlayer) {
        if (mediaPlayer == null) {
            return 0;
        }
        int playerType = mediaPlayer.getPlayerType();
        if (playerType == 0) {
            return 2;
        }
        if (playerType != 2) {
            int i = 3;
            if (playerType != 3) {
                i = 4;
                if (playerType != 4) {
                    i = 5;
                    if (playerType != 5) {
                        return 0;
                    }
                }
            }
            return i;
        }
        return 1;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isPlayerType(int i) {
        int i2;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            i2 = transMediaPlayerType(mediaPlayer.getPlayerType());
        } else {
            i2 = this.mPlayerType;
        }
        if (i2 == i) {
            return true;
        }
        return false;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setIsMute(boolean z) {
        TTVideoEngineInternalLog.i(logcatTag(), String.format("setIsMute:%s", Boolean.valueOf(z)));
        this.mIsMute = z;
        setPlayerMute(z);
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setPlaybackParams(PlaybackParams playbackParams) {
        this.mPlaybackParams = playbackParams;
        if (this.mMediaPlayer != null) {
            try {
                if (isOSPlayer() && (Build.VERSION.SDK_INT < 23 || !this.mPrepared)) {
                    return;
                }
                this.mMediaPlayer.setPlaybackParams(playbackParams);
            } catch (NullPointerException unused) {
            }
        }
    }

    protected void setPlayerMute(boolean z) {
        float f;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isOSPlayer()) {
                if (z) {
                    f = 0.0f;
                } else {
                    f = 1.0f;
                }
                try {
                    mediaPlayer.setVolume(f, f);
                    return;
                } catch (Exception e) {
                    TTVideoEngineInternalLog.d(e);
                    return;
                }
            }
            mediaPlayer.setIsMute(z);
        }
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setSubTag(String str) {
        TTVideoEngineInternalLog.i(logcatTag(), "setSubTag: " + str);
        this.mSubTag = str;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setTag(String str) {
        TTVideoEngineInternalLog.i(logcatTag(), "setTag: " + str);
        this.mTag = str;
    }

    protected static int transMediaPlayerType(int i) {
        if (i == 0) {
            return 2;
        }
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return 3;
                }
                if (i == 4) {
                    return 4;
                }
                if (i == 5) {
                    return 5;
                }
                throw new RuntimeException("unknown internal player type: " + i);
            }
            return 1;
        }
        return 0;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setLooping(boolean z) {
        TTVideoEngineInternalLog.i(logcatTag(), "setLooping:" + z);
        this.mLooping = z;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z);
        }
    }

    public void setSourceType(int i) {
        switch (i) {
            case 0:
                this.mSourceTypeStr = "local_url";
                break;
            case 1:
                this.mSourceTypeStr = "dir_url";
                break;
            case 2:
                this.mSourceTypeStr = "playitem";
                break;
            case 3:
                this.mSourceTypeStr = "preload";
                break;
            case 4:
                this.mSourceTypeStr = "feed";
                break;
            case 5:
                this.mSourceTypeStr = "vid";
                break;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                this.mSourceTypeStr = "fd";
                break;
            case 7:
                this.mSourceTypeStr = "mds";
                break;
        }
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getIntOption(int i) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        int i2 = -1;
        try {
            if (i != 480) {
                switch (i) {
                    case 43:
                        if (this.mVideoCodecType < 0 && mediaPlayer != null) {
                            this.mVideoCodecType = mediaPlayer.getIntOption(157, -1);
                        }
                        return this.mVideoCodecType;
                    case 44:
                        if (this.mAudioCodecType < 0 && mediaPlayer != null) {
                            this.mAudioCodecType = mediaPlayer.getIntOption(158, -1);
                        }
                        return this.mAudioCodecType;
                    case 45:
                        if (this.mVideoCodecID < 0 && mediaPlayer != null) {
                            this.mVideoCodecID = mediaPlayer.getIntOption(141, -1);
                        }
                        return this.mVideoCodecID;
                    case 46:
                        if (this.mAudioCodecID < 0 && mediaPlayer != null) {
                            this.mAudioCodecID = mediaPlayer.getIntOption(140, -1);
                        }
                        return this.mAudioCodecID;
                    case 47:
                        return this.mPlayerType;
                    case 48:
                        Context context = this.mContext;
                        if (context == null) {
                            return -1;
                        }
                        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                        if (audioManager != null) {
                            i2 = audioManager.getStreamMaxVolume(3);
                        }
                        if (i2 >= 0) {
                            return i2;
                        }
                        break;
                    case 49:
                        Context context2 = this.mContext;
                        if (context2 == null) {
                            return -1;
                        }
                        AudioManager audioManager2 = (AudioManager) context2.getSystemService("audio");
                        if (audioManager2 != null) {
                            i2 = audioManager2.getStreamVolume(3);
                        }
                        if (i2 >= 0) {
                            return i2;
                        }
                        break;
                    case 50:
                        return this.mDuration;
                    case IVideoEventLogger.LOGGER_OPTION_ENABLE_PLAYER_DEGRADE /* 51 */:
                        return this.mLoadedProgress;
                    case IVideoEventLogger.LOGGER_OPTION_IS_DEGRADE_RELEASE /* 52 */:
                        if (mediaPlayer != null) {
                            return mediaPlayer.getCurrentPosition();
                        }
                        break;
                    case ITTVideoEngineInternal.PLAYER_OPTION_GET_WATCHED_DUTATION /* 53 */:
                        IPlayDurationManager iPlayDurationManager = this.mPlayDuration;
                        if (iPlayDurationManager == null) {
                            return -1;
                        }
                        return iPlayDurationManager.getPlayedDuration();
                    case 54:
                        return this.mBufferingType;
                    case 55:
                        return this.mPlaybackState;
                    case 56:
                        return this.mLoadState;
                    case 57:
                        return this.mState;
                    default:
                        if (this.mConfigCenterVersion <= 0) {
                            return -1;
                        }
                        return this.mEngineConfig.getIntOption(i);
                }
                return 0;
            }
            return this.mRadioModeEnable;
        } catch (Throwable th) {
            TTVideoEngineInternalLog.d(th);
            return -1;
        }
    }

    protected void updateConfigParams(Map<Integer, Integer> map) {
        int i;
        int i2;
        if (map == null) {
            return;
        }
        int i3 = 0;
        if (this.mPlayerType == 1) {
            i = 1;
        } else {
            i = 0;
        }
        map.put(2, Integer.valueOf(i));
        int i4 = this.mPlayerType;
        if (i4 != 2 && i4 != 5) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        map.put(1, Integer.valueOf(i2));
        HashMap<Integer, Integer> hashMap = this.mConfigParams;
        if (this.mPlayerType == 5) {
            i3 = 1;
        }
        hashMap.put(26, Integer.valueOf(i3));
        map.put(11, Integer.valueOf(this.mForbidOSPlayer));
        map.put(100, Integer.valueOf(this.mConfigParamsOption));
        map.put(43, Integer.valueOf(this.mDisableThreadPoolUsing));
        if (getConfigInt(85, this.mFallbackExoFirst) >= 0) {
            map.put(27, Integer.valueOf(getConfigInt(85, this.mFallbackExoFirst)));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0165, code lost:
    
        if (r8.equals("chiphardware") == false) goto L4;
     */
    @Override // com.ss.ttvideoengine.log.EventSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object get(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 808
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.TTVideoEngineInternal.get(java.lang.String):java.lang.Object");
    }

    protected float getConfigFloat(int i, float f) {
        if (this.mConfigCenterVersion > 0) {
            return this.mEngineConfig.getFloatOption(i);
        }
        return f;
    }

    protected int getConfigInt(int i, int i2) {
        if (this.mConfigCenterVersion > 0) {
            return this.mEngineConfig.getIntOption(i);
        }
        return i2;
    }

    protected String getConfigString(int i, String str) {
        if (this.mConfigCenterVersion > 0) {
            return this.mEngineConfig.getStringOption(i);
        }
        return str;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setFloatOption(int i, float f) {
        if (this.mConfigCenterVersion > 0) {
            this.mPlayerConfigExecutor.execute(this.mEngineConfig.setFloatOption(i, f));
        }
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setLongOption(int i, long j) {
        if (this.mConfigCenterVersion > 0) {
            this.mPlayerConfigExecutor.execute(this.mEngineConfig.setLongOption(i, j));
        }
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void initEngine(Context context, int i) {
        int i2;
        boolean z;
        this.mContext = context;
        this.mPlayerType = i;
        this.mConfigParams = new HashMap<>();
        this.mIsMute = false;
        this.mIsColdStart = sIsColdStart;
        sIsColdStart = 0;
        TTPlayerConfiger.setValue(6, false);
        boolean z2 = true;
        if (i != 2 && i != 5) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        TTPlayerConfiger.setValue(1, i2);
        if (i == 1) {
            z = true;
        } else {
            z = false;
        }
        TTPlayerConfiger.setValue(2, z);
        if (i != 5) {
            z2 = false;
        }
        TTPlayerConfiger.setValue(26, z2);
        TTPlayerConfiger.setValue(11, false);
        TTPlayerConfiger.setValue(4, false);
    }

    protected void setPlayerVolume(float f, float f2) {
        float f3;
        float f4;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        if (getConfigInt(415, this.mSetTrackVolume) == 0 && !isInHousePlayer()) {
            if (f != 0.0f) {
                f4 = 1.0f;
                f3 = 1.0f;
            } else {
                f3 = f2;
                f4 = f;
            }
            AudioManager audioManager = (AudioManager) this.mContext.getSystemService("audio");
            if (audioManager != null) {
                audioManager.setStreamVolume(3, (int) f, 0);
            }
            f = f4;
            f2 = f3;
        }
        mediaPlayer.setVolume(f, f2);
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setStringOption(int i, String str) {
        if (i != 5000) {
            if (this.mConfigCenterVersion > 0) {
                this.mPlayerConfigExecutor.execute(this.mEngineConfig.setStringOption(i, str));
            }
        } else {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null && mediaPlayer.getPlayerType() == 5) {
                this.mMediaPlayer.setStringOption(5000, str);
            }
            this.mExoLoadControlParameters = str;
        }
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setVolume(float f, float f2) {
        TTVideoEngineInternalLog.i(logcatTag(), "setVolume left:" + f + " right:" + f2);
        this.mLeftVolume = f;
        this.mRightVolume = f2;
        setPlayerVolume(f, f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setIntOption(int i, int i2) {
        if (i != 3) {
            if (i != 7) {
                if (i != 85) {
                    boolean z = 0;
                    boolean z2 = false;
                    if (i != 100) {
                        if (i != 117) {
                            if (i != 340) {
                                if (i != 415) {
                                    if (i != 480) {
                                        if (i != 5010) {
                                            if (i != 27) {
                                                if (i != 28) {
                                                    switch (i) {
                                                        case 5001:
                                                            this.mExoRenderReadyMs = i2;
                                                            MediaPlayer mediaPlayer = this.mMediaPlayer;
                                                            if (mediaPlayer != null && mediaPlayer.getPlayerType() == 5) {
                                                                this.mMediaPlayer.setIntOption(5001, i2);
                                                                break;
                                                            }
                                                            break;
                                                        case 5002:
                                                            this.mExoConsecutiveFailNum = i2;
                                                            MediaPlayer mediaPlayer2 = this.mMediaPlayer;
                                                            if (mediaPlayer2 != null && mediaPlayer2.getPlayerType() == 5) {
                                                                this.mMediaPlayer.setIntOption(5002, i2);
                                                                break;
                                                            }
                                                            break;
                                                        case 5003:
                                                            this.mExoCodecReusable = i2;
                                                            MediaPlayer mediaPlayer3 = this.mMediaPlayer;
                                                            if (mediaPlayer3 != null && mediaPlayer3.getPlayerType() == 5) {
                                                                this.mMediaPlayer.setIntOption(5003, i2);
                                                                break;
                                                            }
                                                            break;
                                                        case 5004:
                                                            this.mExoCodecAsyncInitEnable = i2;
                                                            MediaPlayer mediaPlayer4 = this.mMediaPlayer;
                                                            if (mediaPlayer4 != null && mediaPlayer4.getPlayerType() == 5) {
                                                                this.mMediaPlayer.setIntOption(5004, i2);
                                                                break;
                                                            }
                                                            break;
                                                        case 5005:
                                                            this.mExoAllowMediaCodecHelper = i2;
                                                            MediaPlayer mediaPlayer5 = this.mMediaPlayer;
                                                            if (mediaPlayer5 != null && mediaPlayer5.getPlayerType() == 5) {
                                                                this.mMediaPlayer.setIntOption(5005, i2);
                                                                break;
                                                            }
                                                            break;
                                                    }
                                                }
                                                this.mMaxAccumulatedCountSetByUser = i2;
                                                return;
                                            }
                                            this.mCleanWhenStop = i2;
                                            return;
                                        }
                                        if (i2 != 0) {
                                            z2 = true;
                                        }
                                        this.mExoEnableNativeMdl = z2;
                                        return;
                                    }
                                    this.mRadioModeEnable = i2;
                                    this.mLastSwitchRadioModeTime = System.currentTimeMillis();
                                    MediaPlayer mediaPlayer6 = this.mMediaPlayer;
                                    if (mediaPlayer6 != null) {
                                        mediaPlayer6.setIntOption(261, i2);
                                        return;
                                    }
                                    return;
                                }
                                this.mSetTrackVolume = i2;
                                MediaPlayer mediaPlayer7 = this.mMediaPlayer;
                                if (mediaPlayer7 != null) {
                                    mediaPlayer7.setIntOption(94, i2);
                                    return;
                                }
                                return;
                            }
                            this.mDisableResetSystemVolume = i2;
                            MediaPlayer mediaPlayer8 = this.mMediaPlayer;
                            if (mediaPlayer8 != null) {
                                mediaPlayer8.setIntOption(98, i2);
                                return;
                            }
                            return;
                        }
                        TTPlayerConfiger.setValue(4, i2);
                        return;
                    }
                    if (i2 != 0) {
                        z = 1;
                    }
                    this.mIsStartPlayAutomatically = z;
                    MediaPlayer mediaPlayer9 = this.mMediaPlayer;
                    if (mediaPlayer9 != null) {
                        mediaPlayer9.setIntOption(196, !z);
                        return;
                    }
                    return;
                }
                this.mFallbackExoFirst = i2;
                return;
            }
            this.mHardwareDecodeEnablePlayer2 = i2;
            TTVideoEngineInternalLog.i(logcatTag(), "hardware enable = " + this.mHardwareDecodeEnablePlayer2);
            MediaPlayer mediaPlayer10 = this.mMediaPlayer;
            if (mediaPlayer10 != null) {
                mediaPlayer10.setIntOption(59, i2);
                return;
            }
            return;
        }
        this.mForbidOSPlayer = i2;
        TTPlayerConfiger.setValue(11, i2);
    }
}
