package com.ss.ttm.player;

import android.hardware.HardwareBuffer;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceControl;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttm.utils.AVLogger;
import com.ss.ttm.utils.Util;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AJMediaCodec {
    private static final Object mAsyncLock;
    private static final ArrayList<MediaCodecInfo> mAudioSWDecoderCodecs;
    private static int mCodecInstanceNums;
    private static final Object mCodecListLock;
    private static boolean mDeviceNeedsSetOutputSurfaceWorkaround;
    private static int mEnableMediaCodecSyncClose;
    private static boolean mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private static boolean mIsByteVC1Blocklist;
    private static int mIsByteVC1BlocklistEnable;
    private static boolean mIsInitDetected;
    private static boolean mNeedByteVC1WorkAround;
    private static final Condition mSingleCodecCond;
    private static final ReentrantLock mSingleCodecLock;
    private static final ArrayList<MediaCodecInfo> mVideoHWDecoderCodecs;
    private static final ArrayList<MediaCodecInfo> mVideoSWDecoderCodecs;
    private Handler mAsyncHandler;
    private HandlerThread mAsyncThread;
    private MediaCodec.BufferInfo mBufferInfo;
    private DummySurface mDummySurface;
    private Surface mDummySurfaceV29;
    private String mExceptionInfo;
    private ByteBuffer[] mInputBuffers;
    private MediaCodec mMediaCodec;
    private ByteBuffer[] mOutputBuffers;
    private boolean mInputBuffersValid = false;
    private android.media.MediaFormat mOutputMediaFormat = null;
    private final AJMediaFormat mAJMediaFormat = new AJMediaFormat();
    private int mMcMode = 0;
    private long mHandler = 0;
    private int mPendingFlushCount = 0;
    private final Object mAsyncLock2 = new Object();
    private volatile boolean mCodecIsClosed = false;
    private MediaCodecInfo mCodecInfo = null;
    private String mCodecType = null;
    private int mSupportAdaptivePlayBack = -1;
    private int mFixedMemcpyCrash = 0;
    private int mEnableSingleCodec = 0;
    private int mDowngradeSw = 0;
    private int mHandleOutputBuffersChanged = 0;
    private int mHandleStopAsync = 0;
    private boolean mStopAsync = false;
    private int mEnableBlockMode = 0;
    private int mEnableUseCodec2 = 0;
    private ConcurrentHashMap<Integer, MediaCodec.LinearBlock> mBlockHashMap = new ConcurrentHashMap<>();
    private int mMCOperatingRateMode = 0;
    private int mMCPriority = 0;
    private int mEnableMCVppLevel = 0;
    private int mMCVppLevel = 0;
    private int mEnableMCVppDebug = 0;
    private int mHisiFrequenceValue = -1;
    private int mEnableQcomOrder = 0;
    private int mEnableQcomSliceDelivery = 0;
    private int mEnableQcomTimestampReorder = 0;
    private int mEnableQcomCpuAffinityMask = 0;
    private int mQcomCpuAffinityMaskValue = 0;
    private int mEnableQcomEarlyNotify = 0;
    private int mQcomEarlyNotifyValue = 0;
    private int mEnableLowLatency = 0;
    private int mEnableHisiLowLatency = 0;
    private int mDecoderType = 0;
    private int mLowLatencyType = 0;
    private int mEnableSetVideoScalingMode = 0;
    private int mMCOperatingRateBeforeOpen = -1;
    private int mImportanceValue = -1;
    private int mDisableAllowFrameDrop = 0;
    private int mSpecifyMaxInputSize = -1;
    private int mEnableGetCodecInfosOpt = 0;
    private int mCreateCodecTimeoutMs = 0;
    private boolean mEnableCacheCodecAsync = false;

    private static native void _clearBufferIndex(long j);

    private static native void _clearBufferIndex2(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onClosed2(long j);

    private static native void _onDrawFrame(long j, HardwareBuffer hardwareBuffer, int[] iArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onEmptyBuffer(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onEmptyBuffer2(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onError(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onError2(long j, int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onFilledBuffer(long j, int i, int i2, int i3, long j2, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onFilledBuffer2(long j, int i, int i2, int i3, long j2, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onFormatChanged(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onFormatChanged2(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    private static native void _setSurfaceCompleted(long j);

    private static native void _setSurfaceCompleted2(long j);

    public boolean MTKByteVC1NeedWorkAround() {
        return mNeedByteVC1WorkAround;
    }

    public String getErrorInfo() {
        return this.mExceptionInfo;
    }

    public int getOSVerion() {
        return Util.SDK_INT;
    }

    private boolean supportSetSurface() {
        return !mDeviceNeedsSetOutputSurfaceWorkaround;
    }

    public int getChannelCount() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger("channel-count");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public ByteBuffer[] getInputBuffers() {
        if (this.mInputBuffersValid) {
            return this.mInputBuffers;
        }
        return null;
    }

    public ByteBuffer[] getOutputBuffers() {
        if (this.mInputBuffersValid) {
            return this.mOutputBuffers;
        }
        return null;
    }

    public int getSampleRate() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger("sample-rate");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getSliceHeight() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger("slice-height");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getStride() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger("stride");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    private boolean isAdaptivePlaybackV19() {
        String str;
        MediaCodecInfo mediaCodecInfo = this.mCodecInfo;
        if (mediaCodecInfo != null && (str = this.mCodecType) != null) {
            try {
                return mediaCodecInfo.getCapabilitiesForType(str).isFeatureSupported("adaptive-playback");
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private int isLowLatencyDecode() {
        MediaCodecInfo mediaCodecInfo;
        String str;
        if (Build.VERSION.SDK_INT >= 30 && (mediaCodecInfo = this.mCodecInfo) != null && (str = this.mCodecType) != null) {
            try {
                return mediaCodecInfo.getCapabilitiesForType(str).isFeatureSupported("low-latency") ? 1 : 0;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    private void releaseDummySurface() {
        AVLogger.Info("JAJMediaCodec", this, "release dummy surface");
        Surface surface = this.mDummySurfaceV29;
        if (surface != null) {
            surface.release();
            this.mDummySurfaceV29 = null;
        }
        DummySurface dummySurface = this.mDummySurface;
        if (dummySurface != null) {
            dummySurface.release();
            this.mDummySurface = null;
        }
    }

    public int getColorFormat() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                int integer = mediaFormat.getInteger("color-format");
                if (integer != 21 && integer != 2130706688 && integer != 2141391872) {
                    return 0;
                }
                return 3;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getColorTransfer() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                int integer = mediaFormat.getInteger("color-transfer");
                if (integer != 6) {
                    if (integer != 7) {
                        return 0;
                    }
                    return 18;
                }
                return 16;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    private boolean isMtkByteVC1BlockList() {
        String lowerCase = Util.HARDWARE.toLowerCase(Locale.US);
        if (!lowerCase.startsWith("mt6763") && !lowerCase.startsWith("mt6757") && !lowerCase.startsWith("mt6739") && !lowerCase.startsWith("mt6750")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSetSurfaceCompleted() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("onSetSurfaceCompleted, closed = ");
        sb.append(this.mCodecIsClosed);
        if (this.mMcMode == 2) {
            obj = this.mAsyncLock2;
        } else {
            obj = mAsyncLock;
        }
        synchronized (obj) {
            if (this.mCodecIsClosed) {
                return;
            }
            if (this.mMcMode == 2) {
                _setSurfaceCompleted2(this.mHandler);
            } else {
                _setSurfaceCompleted(this.mHandler);
            }
        }
    }

    private void releaseBlockHashMap() {
        ConcurrentHashMap<Integer, MediaCodec.LinearBlock> concurrentHashMap = this.mBlockHashMap;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            for (Map.Entry<Integer, MediaCodec.LinearBlock> entry : this.mBlockHashMap.entrySet()) {
                if (Build.VERSION.SDK_INT >= 30) {
                    entry.getValue().recycle();
                }
            }
            this.mBlockHashMap.clear();
        }
    }

    public int isAdaptivePlayback() {
        int i = this.mSupportAdaptivePlayBack;
        if (i != -1) {
            return i;
        }
        this.mSupportAdaptivePlayBack = isAdaptivePlaybackV19() ? 1 : 0;
        if ("Q7-G1".equals(Build.MODEL) && "kunlun".equals(Build.HARDWARE)) {
            "GK6323V100C".equals(Build.BOARD);
        }
        return this.mSupportAdaptivePlayBack;
    }

    public int vendorOppoHWEnable() {
        if (Util.BARND.equals("OPPO")) {
            String property = getProperty("persist.sys.aweme.hdsupport", "1");
            StringBuilder sb = new StringBuilder();
            sb.append("oppo property = ");
            sb.append(property);
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException unused) {
                AVLogger.Warn("JAJMediaCodec", this, "vendor oppo property abnormal");
            }
        }
        return 1;
    }

    static {
        Covode.recordClassIndex(652066);
        mVideoHWDecoderCodecs = new ArrayList<>();
        mVideoSWDecoderCodecs = new ArrayList<>();
        mAudioSWDecoderCodecs = new ArrayList<>();
        mCodecListLock = new Object();
        mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = false;
        mDeviceNeedsSetOutputSurfaceWorkaround = false;
        mIsInitDetected = false;
        mIsByteVC1Blocklist = false;
        mNeedByteVC1WorkAround = false;
        mIsByteVC1BlocklistEnable = 1;
        mEnableMediaCodecSyncClose = 0;
        mAsyncLock = new Object();
        mCodecInstanceNums = 0;
        ReentrantLock reentrantLock = new ReentrantLock();
        mSingleCodecLock = reentrantLock;
        mSingleCodecCond = reentrantLock.newCondition();
    }

    private boolean isHisiByteVC1BlockList() {
        double d;
        String property = getProperty("ro.board.platform", null);
        if (Util.SDK_INT == 26 && property != null) {
            if (property.startsWith("kirin960") || property.startsWith("hi3660")) {
                try {
                    d = Double.parseDouble(getProperty("ro.config.hw_codec_support", "0.0"));
                } catch (NumberFormatException unused) {
                    AVLogger.Warn("JAJMediaCodec", this, "vendor property abnormal");
                    d = 0.0d;
                }
                if (d < 0.18041d) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int flush() {
        AVLogger.Info("JAJMediaCodec", this, "flush");
        try {
            this.mMediaCodec.flush();
            releaseBlockHashMap();
            int i = this.mMcMode;
            if (i == 1) {
                synchronized (mAsyncLock) {
                    this.mPendingFlushCount++;
                    this.mAsyncHandler.post(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.4
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (AJMediaCodec.this.mMediaCodec == null) {
                                    return;
                                }
                                AJMediaCodec.this.onFlushCompleted(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AJMediaCodec.this.mMediaCodec != null) {
                                            AJMediaCodec.this.mMediaCodec.start();
                                        }
                                    }
                                });
                            } catch (Exception unused) {
                            }
                        }
                    });
                }
            } else if (i == 2) {
                this.mPendingFlushCount++;
                this.mAsyncHandler.post(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (AJMediaCodec.this.mMediaCodec == null) {
                                return;
                            }
                            AJMediaCodec.this.onFlushCompleted(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (AJMediaCodec.this.mMediaCodec != null) {
                                        AJMediaCodec.this.mMediaCodec.start();
                                    }
                                }
                            });
                        } catch (Exception e) {
                            AVLogger.Error("JAJMediaCodec", this, e.toString());
                        }
                    }
                });
            }
            AVLogger.Info("JAJMediaCodec", this, "flush done");
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public int getFormatHeight() {
        boolean z;
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                if (mediaFormat.containsKey("crop-right") && this.mOutputMediaFormat.containsKey("crop-left") && this.mOutputMediaFormat.containsKey("crop-bottom") && this.mOutputMediaFormat.containsKey("crop-top")) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return (this.mOutputMediaFormat.getInteger("crop-bottom") - this.mOutputMediaFormat.getInteger("crop-top")) + 1;
                }
                return this.mOutputMediaFormat.getInteger("height");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getFormatWidth() {
        boolean z;
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                if (mediaFormat.containsKey("crop-right") && this.mOutputMediaFormat.containsKey("crop-left") && this.mOutputMediaFormat.containsKey("crop-bottom") && this.mOutputMediaFormat.containsKey("crop-top")) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return (this.mOutputMediaFormat.getInteger("crop-right") - this.mOutputMediaFormat.getInteger("crop-left")) + 1;
                }
                return this.mOutputMediaFormat.getInteger("width");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int start() {
        AVLogger.Info("JAJMediaCodec", this, "start");
        try {
            this.mMediaCodec.start();
            if (this.mMcMode == 0) {
                this.mInputBuffers = this.mMediaCodec.getInputBuffers();
                if (Util.SDK_INT >= 21) {
                    this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                }
            } else {
                this.mInputBuffers = null;
                this.mOutputBuffers = null;
            }
            this.mInputBuffersValid = true;
            this.mBufferInfo = new MediaCodec.BufferInfo();
            AVLogger.Info("JAJMediaCodec", this, "start end");
            return 0;
        } catch (Exception e) {
            AVLogger.Error("JAJMediaCodec", this, "start failed, exception = " + e);
            handleCodecException(e);
            return -1;
        }
    }

    public int stop() {
        if (this.mHandleStopAsync == 1) {
            AVLogger.Info("JAJMediaCodec", this, "stop async");
            this.mInputBuffersValid = false;
            this.mStopAsync = true;
            return 0;
        }
        if (this.mInputBuffersValid) {
            AVLogger.Info("JAJMediaCodec", this, "stop");
            try {
                this.mInputBuffersValid = false;
                this.mMediaCodec.stop();
            } catch (Exception e) {
                AVLogger.Error("JAJMediaCodec", this, "stop failed, exception = " + e);
                handleCodecException(e);
                return -1;
            }
        }
        return 0;
    }

    public AJMediaCodec() {
        boolean z = false;
        if (!mIsInitDetected) {
            if (Util.HARDWARE.toLowerCase(Locale.US).startsWith("mt") && Util.SDK_INT < 26) {
                z = true;
            }
            mNeedByteVC1WorkAround = z;
            if (isHisiByteVC1BlockList() || isMtkByteVC1BlockList()) {
                mIsByteVC1Blocklist = true;
            }
        }
        codecNeedsSetOutputSurfaceWorkaround();
        mIsInitDetected = true;
        AVLogger.InfoTrackLife("JAJMediaCodec", this, "JAJMediaCodec#^workaround:" + mDeviceNeedsSetOutputSurfaceWorkaround);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0088 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007c A[Catch: all -> 0x0093, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000e, B:10:0x0018, B:11:0x008d, B:14:0x0020, B:26:0x0061, B:35:0x008b, B:36:0x0072, B:39:0x007c, B:42:0x005f, B:43:0x0039, B:46:0x0043, B:49:0x004d, B:52:0x008f), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean codecNeedsSetOutputSurfaceWorkaround() {
        /*
            java.lang.Class<com.ss.ttm.player.AJMediaCodec> r0 = com.ss.ttm.player.AJMediaCodec.class
            monitor-enter(r0)
            boolean r1 = com.ss.ttm.player.AJMediaCodec.mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround     // Catch: java.lang.Throwable -> L93
            if (r1 != 0) goto L8f
            int r1 = com.ss.ttm.utils.Util.SDK_INT     // Catch: java.lang.Throwable -> L93
            r2 = 27
            r3 = 1
            if (r1 > r2) goto L1c
            java.lang.String r4 = "dangal"
            java.lang.String r5 = com.ss.ttm.utils.Util.DEVICE     // Catch: java.lang.Throwable -> L93
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Throwable -> L93
            if (r4 == 0) goto L1c
            com.ss.ttm.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L93
            goto L8d
        L1c:
            if (r1 < r2) goto L20
            goto L8d
        L20:
            java.lang.String r1 = com.ss.ttm.utils.Util.DEVICE     // Catch: java.lang.Throwable -> L93
            int r2 = r1.hashCode()     // Catch: java.lang.Throwable -> L93
            r4 = 99329(0x18401, float:1.3919E-40)
            r5 = 0
            r6 = 2
            r7 = -1
            if (r2 == r4) goto L4d
            r4 = 3351335(0x332327, float:4.69622E-39)
            if (r2 == r4) goto L43
            r4 = 1865889110(0x6f373556, float:5.6700236E28)
            if (r2 == r4) goto L39
            goto L57
        L39:
            java.lang.String r2 = "santoni"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L57
            r1 = 2
            goto L58
        L43:
            java.lang.String r2 = "mido"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L57
            r1 = 1
            goto L58
        L4d:
            java.lang.String r2 = "deb"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L57
            r1 = 0
            goto L58
        L57:
            r1 = -1
        L58:
            if (r1 == 0) goto L5f
            if (r1 == r3) goto L5f
            if (r1 == r6) goto L5f
            goto L61
        L5f:
            com.ss.ttm.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L93
        L61:
            java.lang.String r1 = com.ss.ttm.utils.Util.MODEL     // Catch: java.lang.Throwable -> L93
            int r2 = r1.hashCode()     // Catch: java.lang.Throwable -> L93
            r4 = 2006354(0x1e9d52, float:2.811501E-39)
            if (r2 == r4) goto L7c
            r4 = 2006367(0x1e9d5f, float:2.811519E-39)
            if (r2 == r4) goto L72
            goto L85
        L72:
            java.lang.String r2 = "AFTN"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L85
            r5 = 1
            goto L86
        L7c:
            java.lang.String r2 = "AFTA"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L85
            goto L86
        L85:
            r5 = -1
        L86:
            if (r5 == 0) goto L8b
            if (r5 == r3) goto L8b
            goto L8d
        L8b:
            com.ss.ttm.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L93
        L8d:
            com.ss.ttm.player.AJMediaCodec.mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L93
        L8f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L93
            boolean r0 = com.ss.ttm.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround
            return r0
        L93:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L93
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.AJMediaCodec.codecNeedsSetOutputSurfaceWorkaround():boolean");
    }

    public void close() {
        HandlerThread handlerThread;
        AVLogger.Info("JAJMediaCodec", this, "~JAJMediaCodec#{");
        final MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            if (this.mHandleStopAsync == 0) {
                stop();
            } else if (this.mStopAsync) {
                stopCodec(mediaCodec);
                this.mStopAsync = false;
            }
            this.mInputBuffers = null;
            this.mOutputBuffers = null;
            int i = this.mMcMode;
            if (i == 1 && Util.SDK_INT >= 23) {
                synchronized (mAsyncLock) {
                    HandlerThread handlerThread2 = this.mAsyncThread;
                    if (handlerThread2 != null) {
                        handlerThread2.quit();
                    }
                    _clearBufferIndex(this.mHandler);
                    this.mCodecIsClosed = true;
                    this.mMediaCodec = null;
                }
            } else if (i == 2) {
                if (Util.SDK_INT >= 23 && (handlerThread = this.mAsyncThread) != null) {
                    handlerThread.quit();
                }
                this.mCodecIsClosed = true;
                this.mMediaCodec = null;
                try {
                    AVThreadPool.addTask(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.2
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (AJMediaCodec.this.mAsyncLock2) {
                                AJMediaCodec._onClosed2(AJMediaCodec.this.mHandler);
                            }
                        }
                    });
                } catch (Throwable unused) {
                    AVLogger.Warn("JAJMediaCodec", this, "onClosed in current thread");
                    synchronized (this.mAsyncLock2) {
                        _onClosed2(this.mHandler);
                    }
                }
            } else {
                this.mMediaCodec = null;
            }
            if (mEnableMediaCodecSyncClose > 0) {
                AVLogger.Info("JAJMediaCodec", this, "sync releaseCodec");
                releaseCodec(mediaCodec);
            } else {
                Runnable runnable = new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AVLogger.Info("JAJMediaCodec", this, "start releaseCodec task");
                        AJMediaCodec.this.releaseCodec(mediaCodec);
                    }
                };
                try {
                    AVThreadPool.addTask(runnable);
                } catch (Throwable unused2) {
                    AVLogger.Warn("JAJMediaCodec", this, "new thread failed");
                    runnable.run();
                }
            }
        }
        AVLogger.InfoTrackLife("JAJMediaCodec", this, "~JAJMediaCodec#}");
    }

    public void setCreateCodecTimeoutMs(int i) {
        this.mCreateCodecTimeoutMs = i;
    }

    public void setEnableMediaCodecSyncClose(int i) {
        mEnableMediaCodecSyncClose = i;
    }

    public void setEnableVC1BlockList(int i) {
        mIsByteVC1BlocklistEnable = i;
    }

    public void setEnableCacheCodecAsync(int i) {
        boolean z;
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        this.mEnableCacheCodecAsync = z;
    }

    public int handleCodecException(Exception exc) {
        this.mExceptionInfo = exc.toString();
        if (Util.SDK_INT >= 21) {
            return handleCodecExceptionV21(exc);
        }
        if (exc instanceof IllegalStateException) {
            return -10002;
        }
        return -10000;
    }

    public void setBlockMode(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("ttmn: EnableBlockModel ");
        sb.append(i);
        this.mEnableBlockMode = i;
    }

    public void setDowngradeSw(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("ttmn: downgradeSw ");
        sb.append(i);
        this.mDowngradeSw = i;
    }

    public void setHandleOutputBuffersChanged(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("ttmn: handleOutputBuffersChanged ");
        sb.append(i);
        this.mHandleOutputBuffersChanged = i;
    }

    public void setHandleStopAsync(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("ttmn: handleStopAsync ");
        sb.append(i);
        this.mHandleStopAsync = i;
    }

    public void setHandler(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("ttmn: setHandler ");
        sb.append(j);
        this.mHandler = j;
    }

    public void setSingleCodec(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("ttmn: EnableSingleCodec ");
        sb.append(i);
        this.mEnableSingleCodec = i;
    }

    public void setUseCodec2(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("ttmn: EnableUseCodec2 ");
        sb.append(i);
        this.mEnableUseCodec2 = i;
    }

    private static boolean codecNeedsFlushWorkaround(String str) {
        int i = Util.SDK_INT;
        if (i >= 18 && ((i != 18 || (!"OMX.SEC.avc.dec".equals(str) && !"OMX.SEC.avc.dec.secure".equals(str))) && (i != 19 || !Util.MODEL.startsWith("SM-G800") || (!"OMX.Exynos.avc.dec".equals(str) && !"OMX.Exynos.avc.dec.secure".equals(str))))) {
            return false;
        }
        return true;
    }

    private void stopCodec(MediaCodec mediaCodec) {
        if (mediaCodec == null) {
            return;
        }
        try {
            mediaCodec.stop();
        } catch (Exception e) {
            AVLogger.Warn("JAJMediaCodec", this, "stop failed, exception = " + e);
        }
        AVLogger.Info("JAJMediaCodec", this, "codec stop end");
    }

    public int dequeueInputBuffer(long j) {
        try {
            return this.mMediaCodec.dequeueInputBuffer(j);
        } catch (Exception e) {
            AVLogger.Error("JAJMediaCodec", this, "dequeueInputBuffer failed, exception: " + e);
            return handleCodecException(e);
        }
    }

    public ByteBuffer getInputBuffer(int i) {
        if (this.mInputBuffersValid) {
            try {
                return this.mMediaCodec.getInputBuffer(i);
            } catch (Exception e) {
                AVLogger.Error("JAJMediaCodec", this, "getInputBuffer failed, exception = " + e);
            }
        }
        return null;
    }

    private Surface createDummySurface(boolean z) {
        AVLogger.Info("JAJMediaCodec", this, "create dummy surface, optimize = " + z);
        if (Util.SDK_INT >= 29 && z) {
            try {
                Surface surface = new Surface(new SurfaceControl.Builder().setName("mc_dummy_surface").setBufferSize(1, 1).build());
                this.mDummySurfaceV29 = surface;
                return surface;
            } catch (Exception e) {
                AVLogger.Warn("JAJMediaCodec", this, "create dummy surface exp = " + e);
                this.mDummySurfaceV29 = null;
            }
        }
        DummySurface newInstanceV17 = DummySurface.newInstanceV17(false);
        this.mDummySurface = newInstanceV17;
        return newInstanceV17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFlushCompleted(Runnable runnable) {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("onFlushCompleted, closed = ");
        sb.append(this.mCodecIsClosed);
        if (this.mMcMode == 2) {
            obj = this.mAsyncLock2;
        } else {
            obj = mAsyncLock;
        }
        synchronized (obj) {
            if (this.mCodecIsClosed) {
                return;
            }
            int i = this.mPendingFlushCount - 1;
            this.mPendingFlushCount = i;
            if (i > 0) {
                return;
            }
            if (i < 0) {
                return;
            }
            if (this.mMcMode == 2) {
                _clearBufferIndex2(this.mHandler);
            } else {
                _clearBufferIndex(this.mHandler);
            }
            try {
                runnable.run();
            } catch (Exception e) {
                if (e instanceof IllegalStateException) {
                    if (this.mMcMode == 2) {
                        _onError2(this.mHandler, -10002, "onFlushCompleted exception");
                    } else {
                        _onError(this.mHandler);
                    }
                } else {
                    AVLogger.Error("JAJMediaCodec", this, e.toString());
                }
            }
        }
    }

    public void decodeFRC(int i) {
        if (this.mMediaCodec != null && this.mInputBuffersValid && Util.SDK_INT >= 23) {
            StringBuilder sb = new StringBuilder();
            sb.append("frc level = ");
            sb.append(i);
            Bundle bundle = new Bundle();
            bundle.putInt("vivo.video-dec.dynamic-frc", i);
            try {
                this.mMediaCodec.setParameters(bundle);
            } catch (Exception e) {
                AVLogger.Warn("JAJMediaCodec", this, "setParameters failed ret = " + e);
            }
        }
    }

    public ByteBuffer getInputBufferByQueueRequest(int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            if (this.mBlockHashMap.get(Integer.valueOf(i)) != null && this.mBlockHashMap.get(Integer.valueOf(i)).isMappable()) {
                return this.mBlockHashMap.get(Integer.valueOf(i)).map();
            }
            MediaCodec.LinearBlock obtain = MediaCodec.LinearBlock.obtain(1048576, new String[]{this.mMediaCodec.getName()});
            this.mBlockHashMap.put(Integer.valueOf(i), obtain);
            return obtain.map();
        }
        return null;
    }

    public int handleCodecExceptionV21(Exception exc) {
        if (exc instanceof MediaCodec.CodecException) {
            MediaCodec.CodecException codecException = (MediaCodec.CodecException) exc;
            if (Util.SDK_INT >= 23) {
                StringBuilder sb = new StringBuilder();
                sb.append("exception codecExc isRecoverable: ");
                sb.append(codecException.isRecoverable());
                sb.append(", errorcode: ");
                sb.append(codecException.getErrorCode());
                if (!codecException.isRecoverable() && codecException.getErrorCode() != 1100 && codecException.getErrorCode() != 1101) {
                    return -10001;
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("exception codecExc isRecoverable: ");
                sb2.append(codecException.isRecoverable());
                if (!codecException.isRecoverable()) {
                    return -10001;
                }
            }
        }
        if (exc instanceof IllegalStateException) {
            return -10002;
        }
        return -10000;
    }

    public void hisiFrenquenceChange(int i) {
        if (this.mMediaCodec != null && this.mInputBuffersValid && Util.SDK_INT >= 23) {
            StringBuilder sb = new StringBuilder();
            sb.append("hisiFrenquence value ");
            sb.append(i);
            Bundle bundle = new Bundle();
            bundle.putInt("vendor.hisi-ext-frequence-request-video-dec.video-scene-for-frequence-req", i);
            try {
                this.mMediaCodec.setParameters(bundle);
            } catch (Exception e) {
                AVLogger.Warn("JAJMediaCodec", this, "setParameters failed ret = " + e);
            }
        }
    }

    public void importanceChange(int i) {
        if (this.mMediaCodec != null && this.mInputBuffersValid && Util.SDK_INT >= 35) {
            StringBuilder sb = new StringBuilder();
            sb.append("importance value ");
            sb.append(i);
            Bundle bundle = new Bundle();
            bundle.putInt("importance", i);
            try {
                this.mMediaCodec.setParameters(bundle);
            } catch (Exception e) {
                AVLogger.Warn("JAJMediaCodec", this, "setParameters failed ret = " + e);
            }
        }
    }

    public int setCallback(int i) {
        if (i != 0) {
            try {
                MediaCodec.Callback callback = new MediaCodec.Callback() { // from class: com.ss.ttm.player.AJMediaCodec.1
                    @Override // android.media.MediaCodec.Callback
                    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
                        Object obj;
                        AVLogger.Error("JAJMediaCodec", this, "ttmn: " + codecException + " closed = " + AJMediaCodec.this.mCodecIsClosed);
                        if (AJMediaCodec.this.mMcMode == 2) {
                            obj = AJMediaCodec.this.mAsyncLock2;
                        } else {
                            obj = AJMediaCodec.mAsyncLock;
                        }
                        synchronized (obj) {
                            if (AJMediaCodec.this.mCodecIsClosed) {
                                return;
                            }
                            if (AJMediaCodec.this.mMcMode != 2) {
                                AJMediaCodec._onError(AJMediaCodec.this.mHandler);
                            } else {
                                AJMediaCodec._onError2(AJMediaCodec.this.mHandler, AJMediaCodec.this.handleCodecException(codecException), AJMediaCodec.this.mExceptionInfo);
                            }
                        }
                    }

                    @Override // android.media.MediaCodec.Callback
                    public void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
                        Object obj;
                        if (mediaCodec == AJMediaCodec.this.mMediaCodec) {
                            if (AJMediaCodec.this.mMcMode == 2) {
                                obj = AJMediaCodec.this.mAsyncLock2;
                            } else {
                                obj = AJMediaCodec.mAsyncLock;
                            }
                            synchronized (obj) {
                                if (AJMediaCodec.this.mCodecIsClosed) {
                                    return;
                                }
                                if (AJMediaCodec.this.mMcMode == 2) {
                                    AJMediaCodec._onEmptyBuffer2(AJMediaCodec.this.mHandler, i2);
                                } else {
                                    AJMediaCodec._onEmptyBuffer(AJMediaCodec.this.mHandler, i2);
                                }
                            }
                        }
                    }

                    @Override // android.media.MediaCodec.Callback
                    public void onOutputFormatChanged(MediaCodec mediaCodec, android.media.MediaFormat mediaFormat) {
                        int i2;
                        boolean z;
                        int integer;
                        int integer2;
                        int i3;
                        int i4;
                        int i5;
                        int i6;
                        AVLogger.Info("JAJMediaCodec", this, "onOutputFormatChanged = " + mediaFormat);
                        AJMediaCodec.this.mOutputMediaFormat = mediaFormat;
                        if (AJMediaCodec.this.mEnableSetVideoScalingMode > 0 && !AJMediaCodec.this.mCodecIsClosed) {
                            mediaCodec.setVideoScalingMode(2);
                        }
                        if (mediaFormat != null) {
                            try {
                                String string = mediaFormat.getString("mime");
                                int i7 = 0;
                                if (string.startsWith("video")) {
                                    if (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    AJMediaFormat aJMediaFormat = AJMediaCodec.this.mAJMediaFormat;
                                    if (z) {
                                        integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
                                    } else {
                                        integer = mediaFormat.getInteger("width");
                                    }
                                    aJMediaFormat.width = integer;
                                    AJMediaFormat aJMediaFormat2 = AJMediaCodec.this.mAJMediaFormat;
                                    if (z) {
                                        integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
                                    } else {
                                        integer2 = mediaFormat.getInteger("height");
                                    }
                                    aJMediaFormat2.height = integer2;
                                    if (mediaFormat.containsKey("color-format")) {
                                        i3 = mediaFormat.getInteger("color-format");
                                    } else {
                                        i3 = 0;
                                    }
                                    if (i3 != 21 && i3 != 2130706688 && i3 != 2141391872) {
                                        AJMediaCodec.this.mAJMediaFormat.colorFormat = 0;
                                    } else {
                                        AJMediaCodec.this.mAJMediaFormat.colorFormat = 3;
                                    }
                                    if (mediaFormat.containsKey("color-transfer")) {
                                        i4 = mediaFormat.getInteger("color-transfer");
                                    } else {
                                        i4 = 0;
                                    }
                                    if (i4 != 6) {
                                        if (i4 != 7) {
                                            AJMediaCodec.this.mAJMediaFormat.colorTrans = 0;
                                        } else {
                                            AJMediaCodec.this.mAJMediaFormat.colorTrans = 18;
                                        }
                                    } else {
                                        AJMediaCodec.this.mAJMediaFormat.colorTrans = 16;
                                    }
                                    AJMediaFormat aJMediaFormat3 = AJMediaCodec.this.mAJMediaFormat;
                                    if (mediaFormat.containsKey("slice-height")) {
                                        i5 = mediaFormat.getInteger("slice-height");
                                    } else {
                                        i5 = 0;
                                    }
                                    aJMediaFormat3.sliceHeight = i5;
                                    AJMediaFormat aJMediaFormat4 = AJMediaCodec.this.mAJMediaFormat;
                                    if (mediaFormat.containsKey("stride")) {
                                        i6 = mediaFormat.getInteger("stride");
                                    } else {
                                        i6 = 0;
                                    }
                                    aJMediaFormat4.stride = i6;
                                }
                                if (string.startsWith("audio")) {
                                    AJMediaFormat aJMediaFormat5 = AJMediaCodec.this.mAJMediaFormat;
                                    if (mediaFormat.containsKey("sample-rate")) {
                                        i2 = mediaFormat.getInteger("sample-rate");
                                    } else {
                                        i2 = 0;
                                    }
                                    aJMediaFormat5.sampleRate = i2;
                                    AJMediaFormat aJMediaFormat6 = AJMediaCodec.this.mAJMediaFormat;
                                    if (mediaFormat.containsKey("channel-count")) {
                                        i7 = mediaFormat.getInteger("channel-count");
                                    }
                                    aJMediaFormat6.channelCount = i7;
                                }
                            } catch (Exception e) {
                                AVLogger.Error("JAJMediaCodec", this, e.toString());
                                AJMediaCodec.this.mAJMediaFormat.reset();
                                if (AJMediaCodec.this.mMcMode == 2) {
                                    synchronized (AJMediaCodec.this.mAsyncLock2) {
                                        if (AJMediaCodec.this.mCodecIsClosed) {
                                            return;
                                        }
                                        AJMediaCodec._onFormatChanged2(AJMediaCodec.this.mHandler, -1, 0, 0, 0, 0, 0, 0, 0, 0);
                                        return;
                                    }
                                }
                                AJMediaCodec._onFormatChanged(AJMediaCodec.this.mHandler, -1, 0, 0, 0, 0, 0, 0, 0, 0);
                                return;
                            }
                        }
                        if (AJMediaCodec.this.mMcMode == 2) {
                            synchronized (AJMediaCodec.this.mAsyncLock2) {
                                if (AJMediaCodec.this.mCodecIsClosed) {
                                    return;
                                }
                                AJMediaCodec._onFormatChanged2(AJMediaCodec.this.mHandler, 0, AJMediaCodec.this.mAJMediaFormat.width, AJMediaCodec.this.mAJMediaFormat.height, AJMediaCodec.this.mAJMediaFormat.sampleRate, AJMediaCodec.this.mAJMediaFormat.channelCount, AJMediaCodec.this.mAJMediaFormat.colorFormat, AJMediaCodec.this.mAJMediaFormat.colorTrans, AJMediaCodec.this.mAJMediaFormat.sliceHeight, AJMediaCodec.this.mAJMediaFormat.stride);
                                return;
                            }
                        }
                        AJMediaCodec._onFormatChanged(AJMediaCodec.this.mHandler, 0, AJMediaCodec.this.mAJMediaFormat.width, AJMediaCodec.this.mAJMediaFormat.height, AJMediaCodec.this.mAJMediaFormat.sampleRate, AJMediaCodec.this.mAJMediaFormat.channelCount, AJMediaCodec.this.mAJMediaFormat.colorFormat, AJMediaCodec.this.mAJMediaFormat.colorTrans, AJMediaCodec.this.mAJMediaFormat.sliceHeight, AJMediaCodec.this.mAJMediaFormat.stride);
                    }

                    @Override // android.media.MediaCodec.Callback
                    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo bufferInfo) {
                        Object obj;
                        if (mediaCodec == AJMediaCodec.this.mMediaCodec) {
                            if (AJMediaCodec.this.mMcMode == 2) {
                                obj = AJMediaCodec.this.mAsyncLock2;
                            } else {
                                obj = AJMediaCodec.mAsyncLock;
                            }
                            synchronized (obj) {
                                if (AJMediaCodec.this.mCodecIsClosed) {
                                    return;
                                }
                                if (AJMediaCodec.this.mMcMode == 2) {
                                    AJMediaCodec._onFilledBuffer2(AJMediaCodec.this.mHandler, i2, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
                                } else {
                                    AJMediaCodec._onFilledBuffer(AJMediaCodec.this.mHandler, i2, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
                                }
                            }
                        }
                    }
                };
                if (Util.SDK_INT < 23) {
                    this.mMediaCodec.setCallback(callback);
                    this.mAsyncHandler = new HandlerDelegate(Looper.getMainLooper());
                } else {
                    HandlerThread handlerThread = new HandlerThread("mc_async");
                    this.mAsyncThread = handlerThread;
                    handlerThread.start();
                    Handler handlerDelegate = new HandlerDelegate(this.mAsyncThread.getLooper());
                    this.mAsyncHandler = handlerDelegate;
                    this.mMediaCodec.setCallback(callback, handlerDelegate);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("success to set callback = ");
                sb.append(callback);
                return 0;
            } catch (Exception e) {
                AVLogger.Error("JAJMediaCodec", this, "failed to set callback, exception = " + e);
                return -1;
            }
        }
        return 0;
    }

    public int setOutputSurface(Surface surface) {
        AVLogger.Info("JAJMediaCodec", this, "setOutputSurface surface = " + surface);
        if (mDeviceNeedsSetOutputSurfaceWorkaround || !this.mInputBuffersValid) {
            return -1;
        }
        if (surface == null) {
            if (this.mDummySurface == null) {
                createDummySurface(false);
            }
            AVLogger.Info("JAJMediaCodec", this, "use dummy surface = " + this.mDummySurface);
            surface = this.mDummySurface;
        }
        if (Util.SDK_INT < 23) {
            return -1;
        }
        return setOutputSurfaceV23(this.mMediaCodec, surface);
    }

    public void speedEnhance(float f) {
        if (this.mMediaCodec != null && this.mInputBuffersValid && Util.SDK_INT >= 23) {
            if (f > 30.0f || (this.mMCOperatingRateMode == 1 && f >= 0.0f)) {
                StringBuilder sb = new StringBuilder();
                sb.append("rate ");
                sb.append(f);
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", f);
                try {
                    this.mMediaCodec.setParameters(bundle);
                } catch (Exception e) {
                    AVLogger.Warn("JAJMediaCodec", this, "setParameters failed ret = " + e);
                }
            }
        }
    }

    public int write(AJMediaCodecFrame aJMediaCodecFrame) {
        if (aJMediaCodecFrame != null && aJMediaCodecFrame.data != null) {
            try {
                int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(30000L);
                if (dequeueInputBuffer >= 0) {
                    this.mInputBuffers[dequeueInputBuffer].put(aJMediaCodecFrame.data);
                    this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, aJMediaCodecFrame.size, aJMediaCodecFrame.pts, 0);
                    return 0;
                }
                if (dequeueInputBuffer != -1) {
                    return -1;
                }
                return 4;
            } catch (Exception e) {
                AVLogger.Error("JAJMediaCodec", this, "write meet exception =" + e);
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodec(MediaCodec mediaCodec) {
        ReentrantLock reentrantLock;
        ReentrantLock reentrantLock2;
        if (mediaCodec == null) {
            return;
        }
        try {
            try {
                mediaCodec.release();
                if (this.mDummySurface != null) {
                    AVLogger.Info("JAJMediaCodec", this, "release dummy surface:" + this.mDummySurface);
                    this.mDummySurface.release();
                    this.mDummySurface = null;
                }
            } catch (Exception e) {
                AVLogger.Warn("JAJMediaCodec", this, "release failed, exception = " + e);
                if (this.mDummySurface != null) {
                    AVLogger.Info("JAJMediaCodec", this, "release dummy surface:" + this.mDummySurface);
                    this.mDummySurface.release();
                    this.mDummySurface = null;
                }
                if (this.mEnableSingleCodec == 1) {
                    try {
                        reentrantLock = mSingleCodecLock;
                        reentrantLock.lock();
                        mCodecInstanceNums--;
                        mSingleCodecCond.signal();
                    } catch (Exception unused) {
                        reentrantLock = mSingleCodecLock;
                    } catch (Throwable th) {
                        mSingleCodecLock.unlock();
                        throw th;
                    }
                }
            }
            if (this.mEnableSingleCodec == 1) {
                try {
                    reentrantLock = mSingleCodecLock;
                    reentrantLock.lock();
                    mCodecInstanceNums--;
                    mSingleCodecCond.signal();
                } catch (Exception unused2) {
                    reentrantLock = mSingleCodecLock;
                } catch (Throwable th2) {
                    mSingleCodecLock.unlock();
                    throw th2;
                }
                reentrantLock.unlock();
            }
            releaseBlockHashMap();
            AVLogger.Info("JAJMediaCodec", this, "codec release end");
        } catch (Throwable th3) {
            if (this.mDummySurface != null) {
                AVLogger.Info("JAJMediaCodec", this, "release dummy surface:" + this.mDummySurface);
                this.mDummySurface.release();
                this.mDummySurface = null;
            }
            if (this.mEnableSingleCodec == 1) {
                try {
                    reentrantLock2 = mSingleCodecLock;
                    reentrantLock2.lock();
                    mCodecInstanceNums--;
                    mSingleCodecCond.signal();
                } catch (Exception unused3) {
                    reentrantLock2 = mSingleCodecLock;
                } catch (Throwable th4) {
                    mSingleCodecLock.unlock();
                    throw th4;
                }
                reentrantLock2.unlock();
            }
            releaseBlockHashMap();
            AVLogger.Info("JAJMediaCodec", this, "codec release end");
            throw th3;
        }
    }

    public int createByCodecName(String str) {
        boolean z;
        AVLogger.Info("JAJMediaCodec", this, "createByCodecName = " + str);
        try {
            boolean z2 = true;
            if (this.mEnableSingleCodec == 1) {
                try {
                    ReentrantLock reentrantLock = mSingleCodecLock;
                    reentrantLock.lock();
                    if (mCodecInstanceNums > 0) {
                        mSingleCodecCond.await(3000L, TimeUnit.MILLISECONDS);
                    }
                    if (mCodecInstanceNums > 0) {
                        AVLogger.Warn("JAJMediaCodec", this, "already create a media codec");
                        reentrantLock.unlock();
                        return -1;
                    }
                    long j = this.mCreateCodecTimeoutMs;
                    if (mEnableMediaCodecSyncClose > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    MediaCodec createByCodecName = MediacodecBlockManager.createByCodecName(str, j, z);
                    this.mMediaCodec = createByCodecName;
                    if (createByCodecName != null) {
                        mCodecInstanceNums++;
                    }
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    mSingleCodecLock.unlock();
                    throw th;
                }
            } else {
                long j2 = this.mCreateCodecTimeoutMs;
                if (mEnableMediaCodecSyncClose <= 0) {
                    z2 = false;
                }
                this.mMediaCodec = MediacodecBlockManager.createByCodecName(str, j2, z2);
            }
            if (this.mMediaCodec == null) {
                return -1;
            }
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            AVLogger.Error("JAJMediaCodec", this, "createByCodecName failed, exception = " + e);
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:216:0x02f2, code lost:
    
        if (r9.endsWith("low_latency") != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x02c0, code lost:
    
        if (r9.startsWith("omx") != false) goto L169;
     */
    /* JADX WARN: Removed duplicated region for block: B:173:0x037e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0278 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x032c A[Catch: all -> 0x03b2, TryCatch #0 {, blocks: (B:21:0x0070, B:23:0x0079, B:25:0x007d, B:28:0x0086, B:30:0x0090, B:32:0x0094, B:35:0x009d, B:37:0x00a5, B:40:0x00ae, B:42:0x00b4, B:45:0x00bd, B:47:0x00c5, B:50:0x00cd, B:52:0x00d4, B:56:0x0239, B:57:0x00f3, B:59:0x00fb, B:62:0x0104, B:64:0x010c, B:66:0x0115, B:70:0x012a, B:74:0x0132, B:76:0x0136, B:80:0x0231, B:81:0x0140, B:83:0x0146, B:85:0x014f, B:87:0x0158, B:89:0x015c, B:90:0x0162, B:91:0x0167, B:93:0x016d, B:95:0x0175, B:97:0x017d, B:98:0x0182, B:102:0x018a, B:104:0x019f, B:107:0x01a7, B:109:0x01af, B:111:0x01b7, B:113:0x01bf, B:115:0x01c7, B:119:0x01d0, B:121:0x01d8, B:125:0x01df, B:129:0x01e6, B:133:0x01ef, B:135:0x0212, B:137:0x0218, B:141:0x0225, B:143:0x022e, B:151:0x011b, B:153:0x0124, B:158:0x0241, B:160:0x0247, B:162:0x024a, B:163:0x0278, B:165:0x027e, B:167:0x0288, B:171:0x0378, B:181:0x0296, B:184:0x029c, B:188:0x02c3, B:194:0x02f5, B:201:0x0326, B:203:0x032c, B:204:0x035c, B:206:0x02ce, B:208:0x02d8, B:212:0x02e1, B:215:0x02ec, B:217:0x02b1, B:221:0x02ba, B:227:0x0383, B:228:0x03a1, B:229:0x03ad, B:231:0x03af), top: B:20:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0132 A[Catch: all -> 0x03b2, TryCatch #0 {, blocks: (B:21:0x0070, B:23:0x0079, B:25:0x007d, B:28:0x0086, B:30:0x0090, B:32:0x0094, B:35:0x009d, B:37:0x00a5, B:40:0x00ae, B:42:0x00b4, B:45:0x00bd, B:47:0x00c5, B:50:0x00cd, B:52:0x00d4, B:56:0x0239, B:57:0x00f3, B:59:0x00fb, B:62:0x0104, B:64:0x010c, B:66:0x0115, B:70:0x012a, B:74:0x0132, B:76:0x0136, B:80:0x0231, B:81:0x0140, B:83:0x0146, B:85:0x014f, B:87:0x0158, B:89:0x015c, B:90:0x0162, B:91:0x0167, B:93:0x016d, B:95:0x0175, B:97:0x017d, B:98:0x0182, B:102:0x018a, B:104:0x019f, B:107:0x01a7, B:109:0x01af, B:111:0x01b7, B:113:0x01bf, B:115:0x01c7, B:119:0x01d0, B:121:0x01d8, B:125:0x01df, B:129:0x01e6, B:133:0x01ef, B:135:0x0212, B:137:0x0218, B:141:0x0225, B:143:0x022e, B:151:0x011b, B:153:0x0124, B:158:0x0241, B:160:0x0247, B:162:0x024a, B:163:0x0278, B:165:0x027e, B:167:0x0288, B:171:0x0378, B:181:0x0296, B:184:0x029c, B:188:0x02c3, B:194:0x02f5, B:201:0x0326, B:203:0x032c, B:204:0x035c, B:206:0x02ce, B:208:0x02d8, B:212:0x02e1, B:215:0x02ec, B:217:0x02b1, B:221:0x02ba, B:227:0x0383, B:228:0x03a1, B:229:0x03ad, B:231:0x03af), top: B:20:0x0070 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getBestCodecName(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 949
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.AJMediaCodec.getBestCodecName(java.lang.String):java.lang.String");
    }

    public static int ceilDivide(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public void setMode(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("ttmn: mode ");
        sb.append(i);
        sb.append(", memcpyCrash ");
        sb.append(i2);
        this.mMcMode = i;
        this.mFixedMemcpyCrash = i2;
    }

    public static String getProperty(String str, String str2) {
        try {
            try {
                Class q = l3.a.q("android.os.SystemProperties");
                return (String) q.getMethod("get", String.class, String.class).invoke(q, str, str2);
            } catch (Exception e) {
                e.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    private int renderOutputBufferV21(int i, long j) {
        try {
            this.mMediaCodec.releaseOutputBuffer(i, j);
            return 0;
        } catch (Exception e) {
            AVLogger.Error("JAJMediaCodec", this, "releaseOutputBufferV21 failed, exception = " + e);
            return handleCodecException(e);
        }
    }

    private int setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface) {
        int i = 2;
        try {
            mediaCodec.setOutputSurface(surface);
            if (this.mMcMode == 1 && this.mFixedMemcpyCrash == 1) {
                synchronized (mAsyncLock) {
                    this.mAsyncHandler.post(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.6
                        @Override // java.lang.Runnable
                        public void run() {
                            AJMediaCodec.this.onSetSurfaceCompleted();
                        }
                    });
                }
            }
            if (this.mMcMode == 2 && this.mFixedMemcpyCrash == 1) {
                this.mAsyncHandler.post(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.7
                    @Override // java.lang.Runnable
                    public void run() {
                        AJMediaCodec.this.onSetSurfaceCompleted();
                    }
                });
                return 0;
            }
            return 0;
        } catch (Exception e) {
            AVLogger.Error("JAJMediaCodec", this, "setOutputSurface failed, exception = " + e);
            handleCodecException(e);
            DummySurface dummySurface = this.mDummySurface;
            if (dummySurface != null) {
                if (surface == dummySurface) {
                    i = 1;
                }
                dummySurface.addEvent(i);
            }
            if (e instanceof IllegalArgumentException) {
                return -10003;
            }
            return -1;
        }
    }

    public void setIntOption(int i, int i2) {
        switch (i) {
            case 1:
                this.mMCOperatingRateMode = i2;
                break;
            case 2:
                this.mMCPriority = i2;
                break;
            case 3:
                this.mEnableMCVppLevel = i2;
                break;
            case 4:
                this.mMCVppLevel = i2;
                break;
            case 5:
                this.mEnableMCVppDebug = i2;
                break;
            case 7:
                this.mHisiFrequenceValue = i2;
                break;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                this.mEnableQcomOrder = i2;
                break;
            case 9:
                this.mEnableQcomSliceDelivery = i2;
                break;
            case 10:
                this.mEnableQcomTimestampReorder = i2;
                break;
            case 11:
                this.mEnableQcomCpuAffinityMask = i2;
                break;
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                this.mQcomCpuAffinityMaskValue = i2;
                break;
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                this.mEnableQcomEarlyNotify = i2;
                break;
            case 14:
                this.mQcomEarlyNotifyValue = i2;
                break;
            case 15:
                this.mEnableLowLatency = i2;
                break;
            case 16:
                this.mEnableHisiLowLatency = i2;
                break;
            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                this.mDecoderType = i2;
                break;
            case 18:
                this.mLowLatencyType = i2;
                break;
            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                this.mEnableSetVideoScalingMode = i2;
                break;
            case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                this.mMCOperatingRateBeforeOpen = i2;
                break;
            case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                this.mImportanceValue = i2;
                break;
            case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                this.mDisableAllowFrameDrop = i2;
                break;
            case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                this.mSpecifyMaxInputSize = i2;
                break;
            case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                this.mEnableGetCodecInfosOpt = i2;
                break;
        }
    }

    public int read(AJMediaCodecFrame aJMediaCodecFrame, long j) {
        do {
            try {
                int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, j);
                if (dequeueOutputBuffer >= 0) {
                    aJMediaCodecFrame.data = this.mOutputBuffers[dequeueOutputBuffer];
                    MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
                    aJMediaCodecFrame.pts = bufferInfo.presentationTimeUs;
                    aJMediaCodecFrame.index = dequeueOutputBuffer;
                    aJMediaCodecFrame.size = bufferInfo.size;
                    aJMediaCodecFrame.flags = bufferInfo.flags;
                    return 0;
                }
                if (dequeueOutputBuffer == -3) {
                    try {
                        if (this.mEnableSetVideoScalingMode > 0) {
                            this.mMediaCodec.setVideoScalingMode(2);
                        }
                        this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                    } catch (Exception e) {
                        AVLogger.Error("JAJMediaCodec", this, "getOutputBuffers failed, exception = " + e);
                        return handleCodecException(e);
                    }
                } else {
                    if (dequeueOutputBuffer == -2) {
                        try {
                            if (this.mEnableSetVideoScalingMode > 0) {
                                this.mMediaCodec.setVideoScalingMode(2);
                            }
                            this.mOutputMediaFormat = this.mMediaCodec.getOutputFormat();
                            AVLogger.Info("JAJMediaCodec", this, "getOutputFormat = " + this.mOutputMediaFormat);
                            if (this.mOutputBuffers == null) {
                                try {
                                    this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                                } catch (Exception e2) {
                                    AVLogger.Error("JAJMediaCodec", this, "getOutputBuffers failed, exception = " + e2);
                                    return handleCodecException(e2);
                                }
                            }
                            return dequeueOutputBuffer;
                        } catch (Exception e3) {
                            AVLogger.Error("JAJMediaCodec", this, "getOutputFormat failed, exception =" + e3);
                            return handleCodecException(e3);
                        }
                    }
                    if (dequeueOutputBuffer != -1) {
                        AVLogger.Error("JAJMediaCodec", this, "error, idx = " + dequeueOutputBuffer);
                    }
                    return -1;
                }
            } catch (Exception e4) {
                AVLogger.Error("JAJMediaCodec", this, "dequeueOutputBuffer failed, exception = " + e4);
                return handleCodecException(e4);
            }
        } while (this.mHandleOutputBuffersChanged != 1);
        return -3;
    }

    private static void maybeSetInteger(AJMediaFormat aJMediaFormat, String str, int i) {
        if (i != -1) {
            aJMediaFormat.setInteger(str, i);
        }
    }

    private static void maybeSetCsdBuffers(AJMediaFormat aJMediaFormat, ByteBuffer byteBuffer, int i) {
        if (byteBuffer == null) {
            return;
        }
        aJMediaFormat.setByteBuffer("csd-" + i, byteBuffer);
    }

    private static int getMaxInputSize(String str, int i, int i2) {
        int i3;
        int i4;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        if (!str.equals("video/3gpp") && !str.equals("video/mp4v-es")) {
            if (str.equals("video/avc")) {
                if ("BRAVIA 4K 2015".equals(Util.MODEL)) {
                    return -1;
                }
                i3 = ceilDivide(i, 16) * ceilDivide(i2, 16) * 16 * 16;
                i4 = 2;
                return (i3 * 3) / (i4 * 2);
            }
            if (!str.equals("video/x-vnd.on2.vp8")) {
                if (!str.equals("video/hevc") && !str.equals("video/x-vnd.on2.vp9")) {
                    return -1;
                }
                i3 = i * i2;
                i4 = 4;
                return (i3 * 3) / (i4 * 2);
            }
        }
        i3 = i * i2;
        i4 = 2;
        return (i3 * 3) / (i4 * 2);
    }

    public int releaseBuffer(int i, boolean z, long j, boolean z2) {
        if (z && this.mEnableSetVideoScalingMode > 0) {
            if (z2) {
                this.mMediaCodec.setVideoScalingMode(2);
            } else {
                this.mMediaCodec.setVideoScalingMode(1);
            }
        }
        if (Util.SDK_INT >= 21 && z) {
            return renderOutputBufferV21(i, j);
        }
        try {
            this.mMediaCodec.releaseOutputBuffer(i, z);
            return 0;
        } catch (Exception e) {
            AVLogger.Error("JAJMediaCodec", this, "releaseOutputBuffer failed, exception = " + e);
            return handleCodecException(e);
        }
    }

    public int queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        try {
            this.mMediaCodec.queueInputBuffer(i, i2, i3, j, i4);
            return 0;
        } catch (Exception e) {
            AVLogger.Error("JAJMediaCodec", this, "queueInputBuffer failed, exception = " + e);
            return handleCodecException(e);
        }
    }

    public int queueInputBufferByQueueRequest(int i, int i2, int i3, long j, int i4) {
        MediaCodec.LinearBlock linearBlock;
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                MediaCodec.QueueRequest queueRequest = this.mMediaCodec.getQueueRequest(i);
                ConcurrentHashMap<Integer, MediaCodec.LinearBlock> concurrentHashMap = this.mBlockHashMap;
                if (concurrentHashMap != null && (linearBlock = concurrentHashMap.get(Integer.valueOf(i))) != null) {
                    queueRequest.setLinearBlock(linearBlock, 0, i3);
                }
                queueRequest.setFlags(i4);
                queueRequest.setPresentationTimeUs(j);
                queueRequest.queue();
            }
            return 0;
        } catch (Exception e) {
            AVLogger.Error("JAJMediaCodec", this, "queueInputBuffer failed, exception: " + e);
            return handleCodecException(e);
        }
    }

    public int getOutputFrameByQueueRequest(int i, int i2, int i3, int i4, RenderTrait renderTrait, int i5, long j) {
        HardwareBuffer hardwareBuffer;
        int i6;
        int i7;
        if (Build.VERSION.SDK_INT >= 30 && (renderTrait != null || j != 0)) {
            hardwareBuffer = this.mMediaCodec.getOutputFrame(i).getHardwareBuffer();
        } else {
            hardwareBuffer = null;
        }
        if (hardwareBuffer != null) {
            android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
            int i8 = -1;
            if (mediaFormat != null) {
                i6 = mediaFormat.getInteger("color-standard");
            } else {
                i6 = -1;
            }
            if (i5 == 1) {
                android.media.MediaFormat mediaFormat2 = this.mOutputMediaFormat;
                if (mediaFormat2 != null) {
                    i8 = mediaFormat2.getInteger("color-range");
                    i7 = this.mOutputMediaFormat.getInteger("color-transfer");
                } else {
                    i7 = -1;
                }
                if (i6 > 0 && i8 > 0 && i7 > 0) {
                    i6 = (i6 << 16) | (i7 << 22) | (i8 << 27);
                }
            }
            AJMediaFormat aJMediaFormat = this.mAJMediaFormat;
            AJCodecHardwareBuffer aJCodecHardwareBuffer = new AJCodecHardwareBuffer(hardwareBuffer, new int[]{0, 0, aJMediaFormat.width, aJMediaFormat.height}, 0, i6);
            if (renderTrait != null) {
                renderTrait.onDrawFrame(aJCodecHardwareBuffer);
            } else {
                _onDrawFrame(j, aJCodecHardwareBuffer.hardwareBuffer, aJCodecHardwareBuffer.roi, aJCodecHardwareBuffer.rotation, aJCodecHardwareBuffer.colorSpace);
            }
        }
        return 0;
    }

    private int setExtOptions(AJMediaFormat aJMediaFormat, boolean z, int i, boolean z2, boolean z3, int i2, int i3, int i4, String str) {
        String[] strArr;
        if (this.mMCOperatingRateMode == 2) {
            MediaCodecHelper.setMaxOperatingRate(aJMediaFormat);
        } else {
            int i5 = this.mMCOperatingRateBeforeOpen;
            if (i5 >= 0) {
                MediaCodecHelper.setOperatingRateBeforeOpen(aJMediaFormat, i5);
            }
        }
        MediaCodecHelper.setPriority(aJMediaFormat, this.mMCPriority);
        if (this.mEnableMCVppLevel > 0) {
            MediaCodecHelper.setupVpp(aJMediaFormat, this.mMCVppLevel, this.mCodecInfo.getName());
        }
        if (this.mEnableMCVppDebug > 0) {
            MediaCodecHelper.debugEffect(aJMediaFormat, this.mCodecInfo.getName());
        }
        int i6 = this.mHisiFrequenceValue;
        if (i6 >= 0) {
            MediaCodecHelper.setHisiFrequence(aJMediaFormat, i6, this.mCodecInfo.getName());
        }
        if (this.mEnableQcomOrder > 0) {
            MediaCodecHelper.setQcomOrder(aJMediaFormat, this.mCodecInfo.getName());
        }
        if (this.mEnableQcomSliceDelivery > 0) {
            MediaCodecHelper.setQcomSliceDeliveryMode(aJMediaFormat, this.mCodecInfo.getName());
        }
        if (this.mEnableQcomTimestampReorder > 0) {
            MediaCodecHelper.setQcomTimestampReorder(aJMediaFormat, this.mCodecInfo.getName());
        }
        if (this.mEnableQcomCpuAffinityMask > 0) {
            MediaCodecHelper.setQcomCpuAffinityMask(aJMediaFormat, this.mQcomCpuAffinityMaskValue, this.mCodecInfo.getName());
        }
        if (this.mEnableQcomEarlyNotify > 0) {
            MediaCodecHelper.setQcomEarlyNotifyValue(aJMediaFormat, this.mQcomEarlyNotifyValue, this.mCodecInfo.getName());
        }
        int i7 = this.mEnableLowLatency;
        if (i7 > 0) {
            MediaCodecHelper.setLowLatency(aJMediaFormat, this.mCodecInfo, i7);
        }
        if (this.mEnableHisiLowLatency > 0) {
            MediaCodecHelper.setHisiLowLatency(aJMediaFormat, this.mCodecInfo.getName());
        }
        int i8 = this.mImportanceValue;
        if (i8 >= 0) {
            MediaCodecHelper.setImportance(aJMediaFormat, i8);
        }
        if (this.mDisableAllowFrameDrop > 0) {
            MediaCodecHelper.disableAllowFrameDrop(aJMediaFormat);
        }
        if (z) {
            VendorQTI.setupVpp(aJMediaFormat, i);
        }
        if (z2) {
            VendorQTI.debugEffect(aJMediaFormat);
        }
        if (z3) {
            VendorQTI.enableLowLatency(aJMediaFormat);
        }
        if (i4 > 0 && isLowLatencyDecode() > 0) {
            maybeSetInteger(aJMediaFormat, "low-latency", 1);
        }
        if (i3 > 0 && i2 >= 0) {
            String dolbyCodecs = MediaCodecUtil.getDolbyCodecs(i2, i3);
            StringBuilder sb = new StringBuilder();
            sb.append("dv codecs = ");
            sb.append(dolbyCodecs);
            if (dolbyCodecs != null) {
                strArr = dolbyCodecs.split("\\.");
            } else {
                strArr = null;
            }
            Pair<Integer, Integer> dolbyVisionProfileAndLevel = MediaCodecUtil.getDolbyVisionProfileAndLevel(dolbyCodecs, strArr);
            if (dolbyVisionProfileAndLevel != null) {
                AVLogger.Info("JAJMediaCodec", this, "dv profile & level  = " + dolbyVisionProfileAndLevel.toString());
                maybeSetInteger(aJMediaFormat, "profile", ((Integer) dolbyVisionProfileAndLevel.first).intValue());
            }
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String str2 : str.split(",")) {
                    String[] split = str2.split("_");
                    if (split.length == 2) {
                        try {
                            maybeSetInteger(aJMediaFormat, split[0], Integer.parseInt(split[1]));
                            AVLogger.Info("JAJMediaCodec", this, "ext config " + split[0] + " = " + split[1]);
                        } catch (Exception e) {
                            AVLogger.Warn("JAJMediaCodec", this, "set ext config = " + str2 + " exp = " + e);
                        }
                    } else {
                        AVLogger.Warn("JAJMediaCodec", this, "unsupported ext config = " + str2);
                    }
                }
            } catch (Exception e2) {
                AVLogger.Warn("JAJMediaCodec", this, "parse ext config = " + str + " exp = " + e2);
            }
        }
        return aJMediaFormat.getMap().size();
    }

    public int configure(int i, int i2, int i3, int i4, int i5, String str, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, Surface surface, boolean z, boolean z2, int i6, int i7, boolean z3, int i8, boolean z4, boolean z5, int i9, int i10, int i11, String str2) {
        int i12;
        Surface surface2 = surface;
        int i13 = i6;
        int i14 = i7;
        AVLogger.Info("JAJMediaCodec", this, "configure surface = " + surface2 + ", surfaceConfigure = " + z);
        int i15 = Util.SDK_INT;
        if (i15 >= 21 && setCallback(this.mMcMode) == -1) {
            return -1;
        }
        AJMediaFormat aJMediaFormat = new AJMediaFormat();
        aJMediaFormat.setString("mime", str);
        maybeSetInteger(aJMediaFormat, "width", i);
        maybeSetInteger(aJMediaFormat, "height", i2);
        if (i13 != -1 && i14 != -1) {
            if (i13 <= i) {
                i13 = i;
            }
            maybeSetInteger(aJMediaFormat, "max-width", i13);
            if (i14 <= i2) {
                i14 = i2;
            }
            maybeSetInteger(aJMediaFormat, "max-height", i14);
        }
        maybeSetInteger(aJMediaFormat, "sample-rate", i4);
        maybeSetInteger(aJMediaFormat, "channel-count", i5);
        int i16 = this.mSpecifyMaxInputSize;
        if (i16 < 0) {
            i16 = getMaxInputSize(str, i, i2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("max input = ");
        sb.append(i16);
        maybeSetInteger(aJMediaFormat, "max-input-size", i16);
        maybeSetCsdBuffers(aJMediaFormat, byteBuffer, 0);
        maybeSetCsdBuffers(aJMediaFormat, byteBuffer2, 1);
        maybeSetCsdBuffers(aJMediaFormat, byteBuffer3, 2);
        if (z) {
            if (i15 >= 21) {
                maybeSetInteger(aJMediaFormat, "rotation-degrees", i3);
            }
            if ((surface2 == null || !surface.isValid()) && i15 >= 23 && !mDeviceNeedsSetOutputSurfaceWorkaround) {
                if (this.mDummySurface == null) {
                    createDummySurface(false);
                }
                AVLogger.Info("JAJMediaCodec", this, "use dummy surface = " + this.mDummySurface);
                surface2 = this.mDummySurface;
            }
            if (surface2 == null) {
                this.mExceptionInfo = "Error: configure with null surface";
                AVLogger.Error("JAJMediaCodec", this, "Error: configure with null surface");
                return -10003;
            }
        }
        if (this.mCodecInfo == null || TextUtils.isEmpty(this.mCodecType)) {
            try {
                this.mCodecInfo = this.mMediaCodec.getCodecInfo();
                this.mCodecType = str;
            } catch (Exception unused) {
            }
        }
        setExtOptions(aJMediaFormat, z3, i8, z4, z5, i9, i10, i11, str2);
        AVLogger.Info("JAJMediaCodec", this, "format = " + aJMediaFormat.getMediaFormat());
        try {
            if (Util.SDK_INT >= 30) {
                AVLogger.Info("JAJMediaCodec", this, "block mode = " + this.mEnableBlockMode);
                MediaCodec mediaCodec = this.mMediaCodec;
                android.media.MediaFormat mediaFormat = aJMediaFormat.getMediaFormat();
                if (this.mEnableBlockMode == 1) {
                    i12 = 2;
                } else {
                    i12 = 0;
                }
                mediaCodec.configure(mediaFormat, surface2, (MediaCrypto) null, i12);
            } else {
                this.mMediaCodec.configure(aJMediaFormat.getMediaFormat(), surface2, (MediaCrypto) null, 0);
            }
            if (this.mEnableSetVideoScalingMode > 0) {
                this.mMediaCodec.setVideoScalingMode(2);
            }
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            AVLogger.Error("JAJMediaCodec", this, "configure failed, codec = " + this.mMediaCodec + ", exception = " + e);
            if (!(e instanceof IllegalArgumentException)) {
                return -1;
            }
            return -10003;
        }
    }
}
