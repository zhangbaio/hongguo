package com.ss.ttm.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.agent.instrumentation.ThreadMonitor;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.dragon.read.base.util.LogWrapper;
import com.ss.ttm.utils.AVLogger;
import com.ss.ttm.utils.Util;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AJVoice implements AudioTrack.OnPlaybackPositionUpdateListener {
    private static final int SDK_INT;
    private static String mDeviceName;
    private static boolean mNeedReleaseWorkAround;
    private AudioTrackPositionTracker audioTrackPositionTracker;
    private byte[] mMinBytes;
    private float[] mMinfloats;
    private int mOutputPcmFrameSize;
    private long mRawPlaybackHeadWrapCount;
    private ConditionVariable mReleasingConditionVariable;
    private int mStartMediaTimeMs;
    private AudioTrack mAudioTrack = null;
    private Context mContext = null;
    private int mBlockSize = 2048;
    private int mSampleRate = 44100;
    private int mChannels = 2;
    private int mSampleBytes = 2;
    private int mSampleFormat = 0;
    private int mFrameSamples = 0;
    private AudioManager mAudioManager = null;
    private int mChannelsLayout = 0;
    private int mAudioFormat = 2;
    private float mLeftVolume = -1.0f;
    private int mMaxVolume = 0;
    private volatile boolean mStoped = true;
    private int mSerial = -1;
    private Method getLatencyMethod = null;
    private int mTrackBufferSize = 0;
    private int mLatencyMs = 0;
    private int mBufferSizeMs = 0;
    private long mLastGetLatencyMs = 0;
    private long mWrittenPcmBytes = 0;
    private long lastRawPlaybackHeadPosition = 0;
    private long forceResetWorkaroundTimeMs = -9223372036854775807L;
    private long mStartTime = 0;
    private int mStreamType = 3;
    private int mEnableAudioTrackSmoothClock = 0;
    private int mSessionId = -1;
    private int mContentType = -1;
    private ByteBuffer mPCMFrameBuffer = null;
    private boolean mUseDirectBuffer = false;
    private int mCalibrationType = 0;
    private AudioTrackPool mAudioTrackPool = null;
    private boolean mEnableAudioTrackPool = false;
    private boolean mForceReleaseAudioTrackByPool = false;
    private int mUsedCount = 0;
    private int mErrorOccurred = 0;
    private int mAudioPerformanceMode = 0;
    private int mMuteOptType = 0;
    private VolumeKeyReceiver mVolumeReceiver = null;
    private boolean mIsSysMute = false;
    private int mDirectBufferSize = 0;
    private float mIsSetVolume = 1.0f;
    private boolean mEnableFixAudioTrackFlush = false;
    private boolean mEnableAudioTrackCreateOpt = false;
    private AudioLatencyTuner mAudioLatencyTuner = null;
    private int mAvailableSize = -1;
    private boolean mEnableMemSizeOpt = false;
    private boolean mEnableAudioTrackReuseWhenPause = false;
    private boolean mEnableDirectBufferPool = false;
    private DirectBufferPool mDirectBufferPool = null;
    private boolean mEnableDirectBufferReuseWhenPause = false;
    private boolean mIsReuseAudioTrack = false;
    private long mNativeObject = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AJVoiceOptionDef {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onSysVolumeChange(long j, int i);

    private static Object com_ss_ttm_player_AJVoice_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    public static int getAudioTrackChannelConfig(int i) {
        switch (i) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return 252;
            case 7:
                return 1276;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return 6396;
            default:
                return 0;
        }
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public void onMarkerReached(AudioTrack audioTrack) {
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public void onPeriodicNotification(AudioTrack audioTrack) {
    }

    public int getErrorOccurred() {
        return this.mErrorOccurred;
    }

    public boolean getIsReuseAudioTrack() {
        return this.mIsReuseAudioTrack;
    }

    public ByteBuffer getPCMFrameBuffer() {
        return this.mPCMFrameBuffer;
    }

    public int getTrackBufferSize() {
        return this.mTrackBufferSize;
    }

    private long getPlaybackBytes() {
        return getPlaybackHeadPosition() * getPcmFrameSize(this.mAudioFormat, this.mChannels);
    }

    private long getPlaybackPositionMs() {
        return (getPlaybackHeadPosition() * 1000) / this.mSampleRate;
    }

    public int getSessionId() {
        AudioTrack audioTrack;
        int i = this.mSessionId;
        if (i == -1 && (audioTrack = this.mAudioTrack) != null) {
            return audioTrack.getAudioSessionId();
        }
        return i;
    }

    public void resetQueue() {
        AudioTrackPool audioTrackPool;
        if (this.mEnableAudioTrackPool && (audioTrackPool = this.mAudioTrackPool) != null) {
            audioTrackPool.resetQueue();
        }
    }

    static {
        Covode.recordClassIndex(652075);
        SDK_INT = Build.VERSION.SDK_INT;
        mNeedReleaseWorkAround = false;
        mDeviceName = null;
    }

    private long getWrittenDurationMs() {
        return ((this.mWrittenPcmBytes / getPcmFrameSize(this.mAudioFormat, this.mChannels)) * 1000) / this.mSampleRate;
    }

    public int getAvailableBufferSize() {
        if (this.mAvailableSize < 0) {
            this.mAvailableSize = this.mTrackBufferSize - ((int) (this.mWrittenPcmBytes - (getPlaybackHeadPositionV2() * this.mOutputPcmFrameSize)));
        }
        return this.mAvailableSize;
    }

    public int getBufferCacheMS() {
        if (this.mAudioTrack == null) {
            return -1;
        }
        return (int) (getWrittenDurationMs() - getPlaybackPositionMs());
    }

    public String getCurrentAudioOutputDeviceName() {
        AudioDeviceInfo routedDevice;
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack == null || Build.VERSION.SDK_INT < 23 || (routedDevice = audioTrack.getRoutedDevice()) == null) {
            return "";
        }
        return routedDevice.getProductName().toString();
    }

    public int getCurrentAudioOutputDeviceType() {
        AudioDeviceInfo routedDevice;
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack == null || Build.VERSION.SDK_INT < 23 || (routedDevice = audioTrack.getRoutedDevice()) == null) {
            return 0;
        }
        return routedDevice.getType();
    }

    public int getCurrentPositionMs() {
        AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
        if (audioTrackPositionTracker == null) {
            return 0;
        }
        return this.mStartMediaTimeMs + ((int) (audioTrackPositionTracker.getCurrentPositionUs(false) / 1000));
    }

    public int getEOSDelayMs() {
        long j;
        long writtenDurationMs = getWrittenDurationMs();
        long playbackPositionMs = getPlaybackPositionMs();
        if (getLatency() > 0) {
            j = this.mLatencyMs - this.mBufferSizeMs;
        } else {
            j = 0;
        }
        return (int) ((writtenDurationMs - playbackPositionMs) + j);
    }

    public int getMaxVolume() {
        StringBuilder sb = new StringBuilder();
        sb.append("getMaxVolume:");
        sb.append(this.mMaxVolume);
        return this.mMaxVolume;
    }

    public int getUnderRunCount() {
        AudioTrack audioTrack;
        if (Build.VERSION.SDK_INT >= 24 && (audioTrack = this.mAudioTrack) != null) {
            return audioTrack.getUnderrunCount();
        }
        return -1;
    }

    public void stop() {
        if (this.mStoped) {
            return;
        }
        this.mStoped = true;
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                audioTrackPositionTracker.pause();
            }
            this.mAudioTrack.pause();
        } catch (Throwable th) {
            th.printStackTrace();
            this.mForceReleaseAudioTrackByPool = true;
            this.mErrorOccurred = 1;
        }
    }

    private AudioTrack createAudioTrack() {
        int i = Util.SDK_INT;
        if (i >= 26 && (this.mAudioPerformanceMode != 0 || this.mEnableAudioTrackCreateOpt)) {
            return createAudioTrackV26();
        }
        if (i >= 21 && (this.mAudioPerformanceMode != 0 || this.mEnableAudioTrackCreateOpt)) {
            return createAudioTrackV21();
        }
        return createAudioTrackV9();
    }

    private AudioTrack createAudioTrackV9() {
        if (this.mSessionId == -1) {
            return new AudioTrack(this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mTrackBufferSize, 1);
        }
        return new AudioTrack(this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mTrackBufferSize, 1, this.mSessionId);
    }

    private long getPlaybackHeadPosition() {
        int playState = this.mAudioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = this.mAudioTrack.getPlaybackHeadPosition() & 4294967295L;
        if (playbackHeadPosition == 0 && this.lastRawPlaybackHeadPosition > 0 && playState == 3) {
            if (this.forceResetWorkaroundTimeMs == -9223372036854775807L) {
                this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
            }
            return this.lastRawPlaybackHeadPosition;
        }
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.lastRawPlaybackHeadPosition = playbackHeadPosition;
        return playbackHeadPosition;
    }

    private boolean needsReset() {
        if (this.forceResetWorkaroundTimeMs != -9223372036854775807L && this.mWrittenPcmBytes > 0 && SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs >= 200) {
            return true;
        }
        return false;
    }

    public void flush() {
        if (this.mAudioTrack == null) {
            return;
        }
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                audioTrackPositionTracker.reset();
            }
            this.mStartMediaTimeMs = -1;
            if (this.mCalibrationType >= 1) {
                this.lastRawPlaybackHeadPosition = 0L;
                this.mRawPlaybackHeadWrapCount = 0L;
            }
            this.mAudioTrack.flush();
            this.mAvailableSize = -1;
            if (this.mWrittenPcmBytes > 0) {
                this.mWrittenPcmBytes = 0L;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            this.mForceReleaseAudioTrackByPool = true;
        }
    }

    public void flushV2() {
        boolean z;
        try {
            this.mStartMediaTimeMs = -1;
            this.lastRawPlaybackHeadPosition = 0L;
            this.mRawPlaybackHeadWrapCount = 0L;
            if (this.mAudioTrack.getPlayState() == 3) {
                this.mAudioTrack.pause();
                z = true;
            } else {
                z = false;
            }
            this.mAudioTrack.flush();
            if (z && this.mAudioTrack.getPlayState() != 3) {
                this.mAudioTrack.play();
            }
            if (this.mWrittenPcmBytes > 0) {
                this.mWrittenPcmBytes = 0L;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            this.mForceReleaseAudioTrackByPool = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public float getVolume() {
        /*
            r4 = this;
            float r0 = r4.mLeftVolume
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L1f
            android.media.AudioManager r0 = r4.mAudioManager
            if (r0 == 0) goto L1f
            int r1 = r4.mStreamType     // Catch: java.lang.Exception -> L1e
            int r0 = r0.getStreamMaxVolume(r1)     // Catch: java.lang.Exception -> L1e
            android.media.AudioManager r1 = r4.mAudioManager     // Catch: java.lang.Exception -> L1c
            int r3 = r4.mStreamType     // Catch: java.lang.Exception -> L1c
            int r2 = r1.getStreamVolume(r3)     // Catch: java.lang.Exception -> L1c
            goto L20
        L1c:
            goto L20
        L1e:
        L1f:
            r0 = 0
        L20:
            if (r2 < 0) goto L24
            float r0 = (float) r2
            return r0
        L24:
            if (r0 <= 0) goto L2a
            int r0 = r0 / 4
            float r0 = (float) r0
            return r0
        L2a:
            r0 = 1092616192(0x41200000, float:10.0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.AJVoice.getVolume():float");
    }

    public int reconfigPCMFrameBuffer() {
        int i;
        if (this.mUseDirectBuffer && (i = this.mDirectBufferSize) > 0) {
            if (this.mEnableDirectBufferPool) {
                this.mPCMFrameBuffer = this.mDirectBufferPool.getReuseDirectBuffer(i);
            }
            if (this.mPCMFrameBuffer == null) {
                try {
                    this.mPCMFrameBuffer = ByteBuffer.allocateDirect(this.mDirectBufferSize);
                    return 0;
                } catch (Exception unused) {
                    AVLogger.Error("JAJVoice", this, "out of memory error when new audio buffer for audiotrack");
                    return -10;
                }
            }
            return 0;
        }
        return 0;
    }

    private int configureDirectBuffer() {
        if (this.mEnableMemSizeOpt) {
            this.mDirectBufferSize = Math.min(this.mTrackBufferSize, this.mBlockSize);
        } else {
            this.mDirectBufferSize = this.mTrackBufferSize;
        }
        if (this.mAudioFormat == 4) {
            try {
                this.mMinfloats = new float[this.mDirectBufferSize / 4];
            } catch (OutOfMemoryError unused) {
                AVLogger.Error("JAJVoice", this, "out of memory error when new audio buffer for audiotrack");
                return -10;
            }
        }
        boolean z = this.mUseDirectBuffer;
        if (!z || Util.SDK_INT < 21) {
            try {
                this.mMinBytes = new byte[this.mDirectBufferSize];
            } catch (OutOfMemoryError unused2) {
                AVLogger.Error("JAJVoice", this, "out of memory error when new audio buffer for audiotrack");
                return -10;
            }
        }
        if (z) {
            if (this.mEnableDirectBufferPool) {
                this.mPCMFrameBuffer = this.mDirectBufferPool.getReuseDirectBuffer(this.mDirectBufferSize);
            }
            if (this.mPCMFrameBuffer == null) {
                try {
                    this.mPCMFrameBuffer = ByteBuffer.allocateDirect(this.mDirectBufferSize);
                } catch (Exception unused3) {
                    AVLogger.Error("JAJVoice", this, "out of memory error when new audio buffer for audiotrack");
                    return -10;
                }
            }
        }
        this.mBufferSizeMs = ((this.mTrackBufferSize / this.mOutputPcmFrameSize) * 1000) / this.mSampleRate;
        return 0;
    }

    private AudioTrack createAudioTrackV21() {
        int i;
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(this.mStreamType);
        int i2 = this.mContentType;
        if (i2 != -1) {
            builder.setContentType(i2);
        }
        if (this.mAudioPerformanceMode == 1) {
            builder.setFlags(256);
        }
        AudioAttributes build = builder.build();
        AudioFormat build2 = new AudioFormat.Builder().setChannelMask(this.mChannelsLayout).setEncoding(this.mAudioFormat).setSampleRate(this.mSampleRate).build();
        int i3 = this.mTrackBufferSize;
        int i4 = this.mSessionId;
        if (i4 != -1) {
            i = i4;
        } else {
            i = 0;
        }
        return new AudioTrack(build, build2, i3, 1, i);
    }

    private AudioTrack createAudioTrackV26() {
        AudioTrack.Builder builder = new AudioTrack.Builder();
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setUsage(1);
        int i = this.mContentType;
        if (i == -1) {
            i = 3;
        }
        AudioTrack.Builder bufferSizeInBytes = builder.setAudioAttributes(usage.setContentType(i).setLegacyStreamType(this.mStreamType).build()).setAudioFormat(new AudioFormat.Builder().setEncoding(this.mAudioFormat).setSampleRate(this.mSampleRate).setChannelMask(this.mChannelsLayout).build()).setBufferSizeInBytes(this.mTrackBufferSize);
        int i2 = this.mSessionId;
        if (i2 == -1) {
            i2 = 0;
        }
        return bufferSizeInBytes.setSessionId(i2).setPerformanceMode(this.mAudioPerformanceMode).build();
    }

    private long getPlaybackHeadPositionV2() {
        int playState = this.mAudioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = this.mAudioTrack.getPlaybackHeadPosition() & 4294967295L;
        if (Util.SDK_INT <= 29) {
            if (playbackHeadPosition == 0 && this.lastRawPlaybackHeadPosition > 0 && playState == 3) {
                if (this.forceResetWorkaroundTimeMs == -9223372036854775807L) {
                    this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
                }
                return this.lastRawPlaybackHeadPosition;
            }
            this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        }
        if (this.lastRawPlaybackHeadPosition > playbackHeadPosition) {
            this.mRawPlaybackHeadWrapCount++;
        }
        this.lastRawPlaybackHeadPosition = playbackHeadPosition;
        return playbackHeadPosition + (this.mRawPlaybackHeadWrapCount << 32);
    }

    private int reset() {
        this.mWrittenPcmBytes = 0L;
        this.mLatencyMs = 0;
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.mLastGetLatencyMs = 0L;
        this.lastRawPlaybackHeadPosition = 0L;
        this.mLeftVolume = -1.0f;
        this.mAvailableSize = -1;
        if (this.mEnableAudioTrackPool && !this.mForceReleaseAudioTrackByPool) {
            StringBuilder sb = new StringBuilder();
            sb.append("AudioTrackPool log: reset try pushback AudioTrack: ");
            sb.append(this.mAudioTrack);
            if (this.mAudioTrackPool.pushAudioTrackBack(new AudioTrackBuffer(this.mAudioTrack, this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mFrameSamples, this.mUsedCount), this.mIsSetVolume) == 0) {
                this.mAudioTrack = null;
            }
        }
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            this.mAudioTrack = null;
            AudioLatencyTuner audioLatencyTuner = this.mAudioLatencyTuner;
            if (audioLatencyTuner != null) {
                audioLatencyTuner.close();
            }
            try {
                audioTrack.flush();
                audioTrack.release();
            } catch (Exception unused) {
            }
        }
        return reconfigure();
    }

    public void close() {
        VolumeKeyReceiver volumeKeyReceiver;
        Context context;
        if (this.mEnableAudioTrackPool && !this.mForceReleaseAudioTrackByPool) {
            if (this.mAudioTrackPool.pushAudioTrackBack(new AudioTrackBuffer(this.mAudioTrack, this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mFrameSamples, this.mUsedCount), this.mIsSetVolume) == 0) {
                this.mAudioTrack = null;
            }
        }
        if (this.mAudioTrack != null) {
            AudioLatencyTuner audioLatencyTuner = this.mAudioLatencyTuner;
            if (audioLatencyTuner != null) {
                audioLatencyTuner.close();
            }
            final AudioTrack audioTrack = this.mAudioTrack;
            this.mAudioTrack = null;
            try {
                AVThreadPool.addTask(new Runnable() { // from class: com.ss.ttm.player.AJVoice.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AJVoice.this.releaseTrack(audioTrack);
                    }
                });
            } catch (Throwable th) {
                AVLogger.Warn("JAJVoice", this, "create close thread fail = " + th);
                releaseTrack(audioTrack);
            }
        }
        if (this.mMuteOptType == 2 && (volumeKeyReceiver = this.mVolumeReceiver) != null && (context = this.mContext) != null) {
            INVOKEVIRTUAL_com_ss_ttm_player_AJVoice_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(context, volumeKeyReceiver);
        }
        if (this.mEnableDirectBufferPool && this.mUseDirectBuffer) {
            this.mDirectBufferPool.pushDirectBufferBack(this.mPCMFrameBuffer);
        }
        AVLogger.InfoTrackLife("JAJVoice", this, "JAJVoice#$");
    }

    public void flushAndStop() {
        this.mStoped = true;
        this.mWrittenPcmBytes = 0L;
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.mLatencyMs = 0;
        this.mLastGetLatencyMs = 0L;
        this.lastRawPlaybackHeadPosition = 0L;
        this.mRawPlaybackHeadWrapCount = 0L;
        this.mStartMediaTimeMs = -1;
        this.mLeftVolume = -1.0f;
        this.mNativeObject = 0L;
        this.mContext = null;
        try {
            AudioTrack audioTrack = this.mAudioTrack;
            if (audioTrack != null) {
                audioTrack.stop();
            }
        } catch (Exception e) {
            AVLogger.Warn("JAJVoice", this, "flushAndStop failed: " + e);
            this.mErrorOccurred = 1;
        }
    }

    public int getLatency() {
        if (this.mCalibrationType == 0) {
            getPlaybackHeadPosition();
        }
        if (this.getLatencyMethod != null) {
            long nanoTime = System.nanoTime() / 1000000;
            if (nanoTime - this.mLastGetLatencyMs > 500) {
                try {
                    int intValue = ((Integer) com_ss_ttm_player_AJVoice_java_lang_reflect_Method_invoke(this.getLatencyMethod, this.mAudioTrack, null)).intValue();
                    this.mLatencyMs = intValue;
                    int max = Math.max(intValue, 0);
                    this.mLatencyMs = max;
                    if (max > 5000) {
                        AVLogger.Warn("JAJVoice", this, "Ignoring impossibly large audio latency: " + this.mLatencyMs);
                        this.mLatencyMs = 0;
                    }
                } catch (Exception unused) {
                    this.getLatencyMethod = null;
                }
                this.mLastGetLatencyMs = nanoTime;
            }
        }
        return this.mLatencyMs;
    }

    public void pause() {
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                audioTrackPositionTracker.pause();
            }
            this.mAudioTrack.pause();
            if (this.mEnableAudioTrackPool && this.mEnableAudioTrackReuseWhenPause) {
                if (this.mAudioTrackPool.pushAudioTrackBack(new AudioTrackBuffer(this.mAudioTrack, this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mFrameSamples, this.mUsedCount), this.mIsSetVolume) == 0) {
                    this.mAudioTrack = null;
                }
            }
            if (this.mEnableDirectBufferPool && this.mUseDirectBuffer && this.mEnableDirectBufferReuseWhenPause) {
                this.mDirectBufferPool.pushDirectBufferBack(this.mPCMFrameBuffer);
                this.mPCMFrameBuffer = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            this.mForceReleaseAudioTrackByPool = true;
            this.mErrorOccurred = 1;
        }
    }

    public int start() {
        if (this.mAudioTrack == null) {
            AVLogger.Error("JAJVoice", this, "audiotrack start before created");
            return -2;
        }
        this.mStoped = false;
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                AudioTrack audioTrack = this.mAudioTrack;
                int i = this.mAudioFormat;
                audioTrackPositionTracker.setAudioTrack(audioTrack, i, getPcmFrameSize(i, this.mChannels), this.mTrackBufferSize);
            }
            this.mAudioTrack.play();
            this.mSerial = -1;
            if (mNeedReleaseWorkAround) {
                this.mStartTime = SystemClock.elapsedRealtime();
            }
            return 0;
        } catch (Throwable th) {
            AVLogger.Error("JAJVoice", this, "audioTrack start failed = " + th);
            this.mForceReleaseAudioTrackByPool = true;
            this.mErrorOccurred = 1;
            return -3;
        }
    }

    public AJVoice() {
        AVLogger.InfoTrackLife("JAJVoice", this, "JAJVoice#^");
        this.mStartMediaTimeMs = -1;
        if (mDeviceName == null) {
            String str = Build.DEVICE;
            mDeviceName = str;
            if (str.equals("OnePlus6T")) {
                mNeedReleaseWorkAround = true;
            }
        }
    }

    private int initAudioTrack() {
        int i = 0;
        if (this.mEnableAudioTrackPool) {
            AudioTrackBuffer reuseAudioTrack = this.mAudioTrackPool.getReuseAudioTrack(this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mFrameSamples);
            if (reuseAudioTrack != null) {
                this.mAudioTrack = reuseAudioTrack.AudioTrack;
                this.mUsedCount = reuseAudioTrack.usedCount;
                this.mIsReuseAudioTrack = true;
            } else {
                this.mIsReuseAudioTrack = false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("AudioTrackPool log: initAudioTrack, try get reuse AudioTrack: ");
            sb.append(this.mAudioTrack);
        }
        if (this.mAudioTrack == null) {
            try {
                this.mAudioTrack = createAudioTrack();
                if (this.mEnableAudioTrackPool) {
                    this.mUsedCount = 0;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("AudioTrackPool log: create new AudioTrack:");
                    sb2.append(this.mAudioTrack);
                }
            } catch (Throwable th) {
                AVLogger.Error("JAJVoice", this, "create audio track failed ,detail = " + th);
                return -1;
            }
        }
        AudioLatencyTuner audioLatencyTuner = this.mAudioLatencyTuner;
        if (audioLatencyTuner != null && Build.VERSION.SDK_INT >= 24) {
            this.mTrackBufferSize = audioLatencyTuner.updateAudioTrack(this.mAudioTrack, this.mOutputPcmFrameSize);
        } else if (this.mCalibrationType > 0 && Build.VERSION.SDK_INT >= 23) {
            this.mTrackBufferSize = this.mAudioTrack.getBufferSizeInFrames() * this.mOutputPcmFrameSize;
        }
        if (this.mEnableMemSizeOpt) {
            i = configureDirectBuffer();
        }
        if (this.mAudioTrack.getState() != 1) {
            try {
                this.mAudioTrack.release();
                this.mAudioTrack = null;
                AudioLatencyTuner audioLatencyTuner2 = this.mAudioLatencyTuner;
                if (audioLatencyTuner2 != null) {
                    audioLatencyTuner2.close();
                }
                AVLogger.Error("JAJVoice", this, "create audiotrack but failed to initialize");
                return -3;
            } catch (Exception unused) {
                this.mAudioTrack = null;
                AudioLatencyTuner audioLatencyTuner3 = this.mAudioLatencyTuner;
                if (audioLatencyTuner3 != null) {
                    audioLatencyTuner3.close();
                }
                AVLogger.Error("JAJVoice", this, "create audiotrack but failed to initialize");
                return -3;
            } catch (Throwable unused2) {
                this.mAudioTrack = null;
                AudioLatencyTuner audioLatencyTuner4 = this.mAudioLatencyTuner;
                if (audioLatencyTuner4 != null) {
                    audioLatencyTuner4.close();
                }
                AVLogger.Error("JAJVoice", this, "create audiotrack but failed to initialize");
                return -3;
            }
        }
        return i;
    }

    public void resume() {
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                AudioTrack audioTrack = this.mAudioTrack;
                int i = this.mAudioFormat;
                audioTrackPositionTracker.setAudioTrack(audioTrack, i, getPcmFrameSize(i, this.mChannels), this.mTrackBufferSize);
                this.audioTrackPositionTracker.start();
            }
            if (this.mEnableAudioTrackPool && this.mEnableAudioTrackReuseWhenPause) {
                AudioTrackBuffer reuseAudioTrack = this.mAudioTrackPool.getReuseAudioTrack(this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mFrameSamples);
                if (reuseAudioTrack != null) {
                    this.mAudioTrack = reuseAudioTrack.AudioTrack;
                    this.mUsedCount = reuseAudioTrack.usedCount;
                } else {
                    this.mAudioTrack = createAudioTrack();
                    this.mUsedCount = 0;
                }
                float f = this.mIsSetVolume;
                if (f != 1.0f) {
                    setTrackVolume(f, f);
                }
                if (this.mCalibrationType >= 1) {
                    this.lastRawPlaybackHeadPosition = 0L;
                    this.mRawPlaybackHeadWrapCount = 0L;
                    this.mWrittenPcmBytes = 0L;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("AudioTrackPool log: try get resume AudioTrack: ");
                sb.append(this.mAudioTrack);
            }
            if (this.mEnableDirectBufferPool && this.mUseDirectBuffer && this.mEnableDirectBufferReuseWhenPause) {
                ByteBuffer reuseDirectBuffer = this.mDirectBufferPool.getReuseDirectBuffer(this.mDirectBufferSize);
                this.mPCMFrameBuffer = reuseDirectBuffer;
                if (reuseDirectBuffer == null) {
                    try {
                        this.mPCMFrameBuffer = ByteBuffer.allocateDirect(this.mDirectBufferSize);
                    } catch (Exception unused) {
                        AVLogger.Error("JAJVoice", this, "out of memory error when new audio buffer for audiotrack");
                    }
                }
            }
            this.mAudioTrack.play();
        } catch (Throwable th) {
            th.printStackTrace();
            this.mForceReleaseAudioTrackByPool = true;
            this.mErrorOccurred = 1;
        }
    }

    private int reconfigure() {
        int configureDirectBuffer;
        boolean z;
        Context context = this.mContext;
        if (context != null) {
            this.mAudioManager = (AudioManager) context.getSystemService("audio");
        }
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            this.mMaxVolume = audioManager.getStreamMaxVolume(this.mStreamType);
            if (this.mMuteOptType == 2) {
                if (getVolume() == 0.0f) {
                    z = true;
                } else {
                    z = false;
                }
                this.mIsSysMute = z;
                if (z) {
                    _onSysVolumeChange(this.mNativeObject, 1);
                }
                this.mVolumeReceiver = new VolumeKeyReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
                INVOKEVIRTUAL_com_ss_ttm_player_AJVoice_com_dragon_read_aop_BroadcastAop_registerReceiver(this.mContext, this.mVolumeReceiver, intentFilter);
            }
        }
        int audioTrackChannelConfig = getAudioTrackChannelConfig(this.mChannels);
        this.mChannelsLayout = audioTrackChannelConfig;
        if (audioTrackChannelConfig == 0) {
            String.format(Locale.US, "not supoort channel:%d", Integer.valueOf(this.mChannels));
            return -1;
        }
        int i = this.mSampleBytes;
        if (i == 1) {
            this.mAudioFormat = 3;
        } else if (i == 2) {
            this.mAudioFormat = 2;
        } else if (i == 4) {
            this.mAudioFormat = 4;
        } else {
            String.format(Locale.US, "not supoort format:%d", Integer.valueOf(i));
            return -12;
        }
        AudioLatencyTuner audioLatencyTuner = this.mAudioLatencyTuner;
        if (audioLatencyTuner != null) {
            this.mTrackBufferSize = audioLatencyTuner.getSuggestedInitialSize(this.mSampleRate, audioTrackChannelConfig, this.mAudioFormat, this.mBlockSize);
        } else {
            this.mTrackBufferSize = AudioTrack.getMinBufferSize(this.mSampleRate, audioTrackChannelConfig, this.mAudioFormat);
        }
        if (this.mTrackBufferSize <= 0) {
            AVLogger.Error("JAJVoice", this, "getMinBufferSize failed, trace: sampleRate = " + this.mSampleRate + ", mChannelsLayout = " + this.mChannelsLayout + ", mAudioFormat = " + this.mAudioFormat);
            return this.mTrackBufferSize;
        }
        this.mOutputPcmFrameSize = getPcmFrameSize(this.mAudioFormat, this.mChannels);
        if (!this.mEnableMemSizeOpt && (configureDirectBuffer = configureDirectBuffer()) != 0) {
            return configureDirectBuffer;
        }
        String.format(Locale.US, "mNativeObject:%d,mBlockSize:%d,mSampleRate:%d,mChannels:%d,mSampBit:%d,minBufSize:%d,mFrameSamples:%d,format:%d", Long.valueOf(this.mNativeObject), Integer.valueOf(this.mBlockSize), Integer.valueOf(this.mSampleRate), Integer.valueOf(this.mChannelsLayout), Integer.valueOf(this.mSampleBytes), Integer.valueOf(this.mTrackBufferSize), Integer.valueOf(this.mFrameSamples), Integer.valueOf(this.mAudioFormat));
        this.mRawPlaybackHeadWrapCount = 0L;
        return initAudioTrack();
    }

    public class VolumeKeyReceiver extends BroadcastReceiver {
        static {
            Covode.recordClassIndex(652077);
        }

        public VolumeKeyReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);
            if (AJVoice.this.mIsSysMute && intExtra > 0) {
                AJVoice.this.mIsSysMute = false;
                AJVoice._onSysVolumeChange(AJVoice.this.mNativeObject, 0);
            } else if (!AJVoice.this.mIsSysMute && intExtra == 0) {
                AJVoice.this.mIsSysMute = true;
                AJVoice._onSysVolumeChange(AJVoice.this.mNativeObject, 1);
            }
        }
    }

    public void setContentType(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("setContentType contentType=");
        sb.append(i);
        this.mContentType = i;
        if (reset() == 0) {
            start();
        }
    }

    public void setSessionId(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("setSessionId : ");
        sb.append(i);
        this.mSessionId = i;
        if (reset() == 0) {
            start();
        }
    }

    public void setStreamType(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("set Stream type : ");
        sb.append(i);
        this.mStreamType = i;
        if (reset() == 0) {
            start();
        }
    }

    public void setUseDirectBuffer(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("useDirectBuffer: ");
        sb.append(z);
        this.mUseDirectBuffer = z;
    }

    public void releaseTrack(AudioTrack audioTrack) {
        if (audioTrack == null) {
            return;
        }
        try {
            if (mNeedReleaseWorkAround) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.mStartTime;
                if (elapsedRealtime <= 80) {
                    ThreadMonitor.sleepMonitor(80 - elapsedRealtime);
                }
            }
        } catch (Exception unused) {
        }
        try {
            audioTrack.release();
        } catch (Exception e) {
            AVLogger.Warn("JAJVoice", this, "release in invalid state = " + e);
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static void INVOKEVIRTUAL_com_ss_ttm_player_AJVoice_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }

    public void setPlayerHandler(long j, Context context) {
        this.mNativeObject = j;
        this.mContext = context;
        if (this.mIsSetVolume != 1.0f) {
            setTrackVolume(1.0f, 1.0f);
        }
    }

    public static int getPcmFrameSize(int i, int i2) {
        if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    return i2 * 4;
                }
                throw new IllegalArgumentException();
            }
            return i2;
        }
        return i2 * 2;
    }

    public void setTrackVolume(float f, float f2) {
        this.mIsSetVolume = f;
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            if (SDK_INT < 21) {
                audioTrack.setStereoVolume(f, f2);
            } else {
                audioTrack.setVolume(f);
            }
        }
    }

    public void setFloatOption(int i, float f) {
        AudioLatencyTuner audioLatencyTuner;
        StringBuilder sb = new StringBuilder();
        sb.append("setAjvoiceOption, key:");
        sb.append(i);
        sb.append(", value:");
        sb.append(f);
        if (i != 11) {
            if (i == 12 && (audioLatencyTuner = this.mAudioLatencyTuner) != null) {
                audioLatencyTuner.setFloatOption(i, f);
                return;
            }
            return;
        }
        AudioLatencyTuner audioLatencyTuner2 = this.mAudioLatencyTuner;
        if (audioLatencyTuner2 != null) {
            audioLatencyTuner2.setFloatOption(i, f);
        }
    }

    public void setVolume(float f, float f2) {
        AudioTrack audioTrack;
        try {
            int i = this.mMaxVolume;
            if (i < f) {
                f = i;
            }
            if (f2 == -1048575.0f && (audioTrack = this.mAudioTrack) != null) {
                audioTrack.setStereoVolume(f, f2);
            } else {
                AudioManager audioManager = this.mAudioManager;
                if (audioManager != null) {
                    audioManager.setStreamVolume(this.mStreamType, (int) f, 0);
                }
            }
            this.mLeftVolume = f;
        } catch (Exception unused) {
        }
    }

    public int write(ByteBuffer byteBuffer, int i) {
        if (byteBuffer == null) {
            AVLogger.Error("JAJVoice", this, "buffer is nullpoint");
            return -1;
        }
        if (this.mAudioTrack.write(byteBuffer, 0, byteBuffer.capacity()) != byteBuffer.capacity()) {
            return -1;
        }
        byteBuffer.flip();
        return 0;
    }

    public int open(long j, Context context) {
        if (this.mEnableAudioTrackPool) {
            this.mAudioTrackPool = AudioTrackPool.getInstance();
        }
        if (this.mEnableDirectBufferPool && this.mUseDirectBuffer) {
            this.mDirectBufferPool = DirectBufferPool.getInstance();
        }
        this.mNativeObject = j;
        String.format(Locale.US, "native object:%d", Long.valueOf(j));
        this.mContext = context;
        int reconfigure = reconfigure();
        if (reconfigure == 0) {
            float f = this.mLeftVolume;
            if (f != -1.0f) {
                setVolume(f, f);
            }
            try {
                this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        return reconfigure;
    }

    public void setIntOption(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("setAjvoiceOption, key:");
        sb.append(i);
        sb.append(", value:");
        sb.append(i2);
        boolean z = false;
        switch (i) {
            case 1:
                if (Util.SDK_INT >= 21) {
                    this.mEnableAudioTrackSmoothClock = i2;
                    if (i2 > 0) {
                        this.audioTrackPositionTracker = new AudioTrackPositionTracker(null);
                        this.mReleasingConditionVariable = new ConditionVariable(true);
                        break;
                    }
                }
                break;
            case 2:
                this.mCalibrationType = i2;
                break;
            case 3:
                if (i2 > 0) {
                    z = true;
                }
                this.mEnableAudioTrackCreateOpt = z;
                break;
            case 5:
                if (i2 > 0) {
                    z = true;
                }
                this.mEnableAudioTrackPool = z;
                break;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                if (i2 > 0) {
                    z = true;
                }
                this.mEnableFixAudioTrackFlush = z;
                break;
            case 7:
                this.mMuteOptType = i2;
                break;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                if (i2 >= 0 && i2 <= 2) {
                    this.mAudioPerformanceMode = i2;
                    break;
                }
                break;
            case 9:
                this.mAudioLatencyTuner = new AudioLatencyTuner();
                break;
            case 10:
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
            case 14:
            case 15:
            case 16:
            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
            case 18:
                AudioLatencyTuner audioLatencyTuner = this.mAudioLatencyTuner;
                if (audioLatencyTuner != null) {
                    audioLatencyTuner.setIntOption(i, i2);
                    break;
                }
                break;
            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                if (i2 > 0) {
                    z = true;
                }
                this.mEnableMemSizeOpt = z;
                break;
            case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                if (i2 > 0) {
                    z = true;
                }
                this.mEnableAudioTrackReuseWhenPause = z;
                break;
            case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                if (i2 > 0) {
                    z = true;
                }
                this.mEnableDirectBufferPool = z;
                break;
            case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                if (i2 > 0) {
                    z = true;
                }
                this.mEnableDirectBufferReuseWhenPause = z;
                break;
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    public static Intent INVOKEVIRTUAL_com_ss_ttm_player_AJVoice_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
                return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
            }
            throw e;
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static Intent INVOKEVIRTUAL_com_ss_ttm_player_AJVoice_com_dragon_read_aop_BroadcastAop_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (Build.VERSION.SDK_INT >= 34) {
            if (!(context instanceof Context)) {
                context = null;
            }
            if (context == null) {
                return null;
            }
            LogWrapper.error("BroadcastAop", "registerReceiver 要传flag参数啦！", new Object[0]);
            return ContextCompat.registerReceiver(context, broadcastReceiver, filter, 2);
        }
        return INVOKEVIRTUAL_com_ss_ttm_player_AJVoice_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context, broadcastReceiver, filter);
    }

    public int write(int i, int i2, int i3) {
        int write;
        int i4 = 0;
        if (this.mStoped) {
            return 0;
        }
        long j = 0;
        if (this.mSerial != i3) {
            this.mSerial = i3;
            if (this.mWrittenPcmBytes > 0) {
                if (this.mEnableFixAudioTrackFlush) {
                    flushV2();
                } else {
                    this.mAudioTrack.flush();
                }
            }
        }
        if (this.mAudioLatencyTuner != null && Build.VERSION.SDK_INT >= 24) {
            j = System.currentTimeMillis();
        }
        try {
            if (Util.SDK_INT >= 21) {
                if (this.mAudioFormat == 4) {
                    this.mPCMFrameBuffer.order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer().get(this.mMinfloats);
                    write = this.mAudioTrack.write(this.mMinfloats, i, i2 / 4, 0);
                    if (write >= 0) {
                        write *= 4;
                    }
                } else {
                    write = this.mAudioTrack.write(this.mPCMFrameBuffer, i2, 0);
                }
            } else {
                this.mPCMFrameBuffer.get(this.mMinBytes, i, i2);
                write = this.mAudioTrack.write(this.mMinBytes, 0, i2);
            }
            if (write < 0) {
                AVLogger.Error("JAJVoice", this, "write failed : ret: " + write + ", size = " + i2);
                this.mForceReleaseAudioTrackByPool = true;
                this.mErrorOccurred = 1;
                return write;
            }
            this.mWrittenPcmBytes += write;
            this.mAvailableSize = -1;
            AudioLatencyTuner audioLatencyTuner = this.mAudioLatencyTuner;
            if (audioLatencyTuner != null && Build.VERSION.SDK_INT >= 24) {
                this.mTrackBufferSize = audioLatencyTuner.update(getAvailableBufferSize(), System.currentTimeMillis() - j);
            }
            if (needsReset() && reset() == 0) {
                i4 = start();
            }
            this.mPCMFrameBuffer.clear();
            if (i4 != 0) {
                return i4;
            }
            return write;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("write fail = ");
            sb.append(e);
            e.printStackTrace();
            this.mForceReleaseAudioTrackByPool = true;
            this.mErrorOccurred = 1;
            return -1;
        }
    }

    public int write(byte[] bArr, int i, int i2, int i3) {
        int write;
        if (bArr != null && bArr.length != 0) {
            int i4 = 0;
            if (this.mStoped) {
                return 0;
            }
            long j = 0;
            if (this.mSerial != i3) {
                this.mSerial = i3;
                if (this.mWrittenPcmBytes > 0) {
                    if (this.mEnableFixAudioTrackFlush) {
                        flushV2();
                    } else {
                        this.mAudioTrack.flush();
                    }
                }
            }
            if (this.mAudioLatencyTuner != null && Build.VERSION.SDK_INT >= 24) {
                j = System.currentTimeMillis();
            }
            try {
                if (this.mAudioFormat == 4) {
                    ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer().get(this.mMinfloats);
                    write = this.mAudioTrack.write(this.mMinfloats, i, i2 / 4, 0);
                    if (write >= 0) {
                        write *= 4;
                    }
                } else {
                    write = this.mAudioTrack.write(bArr, i, i2);
                }
                if (write < 0) {
                    AVLogger.Error("JAJVoice", this, "write failed : ret: " + write + ", size = " + i2);
                    this.mForceReleaseAudioTrackByPool = true;
                    this.mErrorOccurred = 1;
                    return write;
                }
                this.mWrittenPcmBytes += write;
                this.mAvailableSize = -1;
                AudioLatencyTuner audioLatencyTuner = this.mAudioLatencyTuner;
                if (audioLatencyTuner != null && Build.VERSION.SDK_INT >= 24) {
                    this.mTrackBufferSize = audioLatencyTuner.update(getAvailableBufferSize(), System.currentTimeMillis() - j);
                }
                if (needsReset() && reset() == 0) {
                    i4 = start();
                }
                if (i4 != 0) {
                    return i4;
                }
                return write;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("write fail = ");
                sb.append(e);
                e.printStackTrace();
                this.mForceReleaseAudioTrackByPool = true;
                this.mErrorOccurred = 1;
                return -1;
            }
        }
        AVLogger.Error("JAJVoice", this, "buffer is nullpoint");
        return -10;
    }

    public int write(byte[] bArr, int i, int i2, int i3, long j) {
        if (bArr != null && bArr.length != 0) {
            int i4 = 0;
            if (this.mStoped) {
                return 0;
            }
            if (this.mSerial != i3) {
                this.mSerial = i3;
                AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
                if (audioTrackPositionTracker != null && this.mReleasingConditionVariable != null) {
                    if (this.mWrittenPcmBytes > 0) {
                        if (audioTrackPositionTracker.isPlaying()) {
                            this.mAudioTrack.pause();
                        }
                        this.audioTrackPositionTracker.reset();
                        this.mStartMediaTimeMs = -1;
                        this.mReleasingConditionVariable.close();
                        this.mWrittenPcmBytes = 0L;
                        final AudioTrack audioTrack = this.mAudioTrack;
                        this.mAudioTrack = null;
                        AVThreadPool.addTask(new Runnable() { // from class: com.ss.ttm.player.AJVoice.2
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    audioTrack.flush();
                                    audioTrack.release();
                                } finally {
                                    if (AJVoice.this.mReleasingConditionVariable != null) {
                                        AJVoice.this.mReleasingConditionVariable.open();
                                    }
                                }
                            }
                        });
                        this.mReleasingConditionVariable.block();
                        reconfigure();
                        start();
                        this.mSerial = i3;
                    }
                } else if (this.mWrittenPcmBytes > 0) {
                    if (this.mEnableFixAudioTrackFlush) {
                        flushV2();
                    } else {
                        this.mAudioTrack.flush();
                    }
                }
            }
            int i5 = this.mStartMediaTimeMs;
            if (i5 == -1) {
                this.mStartMediaTimeMs = (int) Math.max(0L, j);
            } else {
                long writtenDurationMs = i5 + getWrittenDurationMs();
                if (Math.abs(writtenDurationMs - j) > 200) {
                    AVLogger.Error("JAJVoice", this, "Discontinuity detected [expected " + writtenDurationMs + ", got " + j + "]");
                    this.mStartMediaTimeMs = (int) (((long) this.mStartMediaTimeMs) + (j - writtenDurationMs));
                }
            }
            try {
                int write = this.mAudioTrack.write(bArr, i, i2);
                if (write < 0) {
                    AVLogger.Error("JAJVoice", this, "write failed : ret: " + write + ", size = " + i2);
                    this.mErrorOccurred = 1;
                    return write;
                }
                this.mWrittenPcmBytes += write;
                if (needsReset() && reset() == 0) {
                    i4 = start();
                    this.mSerial = i3;
                }
                if (i4 != 0) {
                    return i4;
                }
                return write;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("write fail = ");
                sb.append(e);
                e.printStackTrace();
                this.mErrorOccurred = 1;
                return -1;
            }
        }
        AVLogger.Error("JAJVoice", this, "buffer is nullpoint");
        return -10;
    }

    public void setSampleInfo(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mSampleRate = i2;
        this.mChannels = i3;
        this.mBlockSize = i4;
        this.mSampleBytes = i6;
        this.mSampleFormat = i;
        this.mFrameSamples = i5;
        StringBuilder sb = new StringBuilder();
        sb.append("mBlockSize:");
        sb.append(this.mBlockSize);
    }
}
