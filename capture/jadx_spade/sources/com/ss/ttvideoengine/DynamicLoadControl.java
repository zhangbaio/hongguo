package com.ss.ttvideoengine;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.LoadControl;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.log.PortraitNetworkScore;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DynamicLoadControl extends LoadControl {
    private int mAudioTrackCacheDurationMs;
    private float mBeta;
    private int mCostTimeMaxMs;
    private float mGamma;
    protected MediaPlayer mMediaPlayer;
    private int mRebufferingDurationInitMs;
    private int mRebufferingDurationMaxMs;
    private float mRebufferingIncFactor;
    private int mRebufferingIncType;
    private int mRebufferingTimeEarlyMs;
    private int mStartupDurationMaxMs;
    private int mStartupDurationMinMs;
    private TTVideoEngine mVideoEngine;
    private int mVideoTrackCacheDurationMs;
    private int mRebufferingCount = 0;
    private long mNeedBuffer = 2000;
    private boolean mFirstCallBack = true;
    private boolean mIfStartup = true;
    private int mCaseType = 0;
    private int mCallbackCount = 0;

    static {
        Covode.recordClassIndex(652280);
    }

    @Override // com.ss.ttm.player.LoadControl
    protected int onCodecStackSelected(int i) {
        if (i != 1) {
            if (i != 2) {
                return -1;
            }
            return this.mAudioTrackCacheDurationMs;
        }
        return this.mVideoTrackCacheDurationMs;
    }

    @Override // com.ss.ttm.player.LoadControl
    protected int onFilterStackSelected(int i) {
        if (i != 1) {
            if (i != 2) {
                return -1;
            }
            return this.mAudioTrackCacheDurationMs;
        }
        return this.mVideoTrackCacheDurationMs;
    }

    @Override // com.ss.ttm.player.LoadControl
    protected int onTrackSelected(int i) {
        if (i != 1) {
            if (i != 2) {
                return -1;
            }
            return this.mAudioTrackCacheDurationMs;
        }
        return this.mVideoTrackCacheDurationMs;
    }

    @Override // com.ss.ttm.player.LoadControl
    protected boolean shouldStartPlayback(long j, float f, boolean z) {
        String str;
        String str2;
        long j2;
        boolean z2;
        double d;
        int i;
        long min;
        if (z) {
            int i2 = this.mRebufferingIncType;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        min = this.mRebufferingDurationInitMs;
                    } else {
                        int i3 = this.mRebufferingDurationMaxMs;
                        min = (long) (((i3 + r6) / 2.0d) - ((((i3 + r6) / 2.0d) - this.mRebufferingDurationInitMs) * Math.cos((this.mRebufferingIncFactor * 6.283185307179586d) * this.mRebufferingCount)));
                    }
                } else {
                    min = (long) Math.min(this.mRebufferingDurationInitMs * ((this.mRebufferingIncFactor * Math.log1p(this.mRebufferingCount)) + 1.0d), this.mRebufferingDurationMaxMs);
                }
            } else {
                int i4 = this.mRebufferingDurationInitMs;
                min = (long) Math.min(i4 + (this.mRebufferingCount * this.mRebufferingIncFactor * i4), this.mRebufferingDurationMaxMs);
            }
            if (j >= min) {
                this.mRebufferingCount++;
                TTVideoEngineLog.d("dynamiclc", " parameters:  rdi " + this.mRebufferingDurationInitMs + ", rdm " + this.mRebufferingDurationMaxMs + ", rif " + this.mRebufferingIncFactor + ", rit " + this.mRebufferingIncType);
                StringBuilder sb = new StringBuilder();
                sb.append(" buffer end:  rebuf count ");
                sb.append(this.mRebufferingCount);
                sb.append(", need buf ");
                sb.append(min);
                sb.append(", now buf ");
                sb.append(j);
                TTVideoEngineLog.d("dynamiclc", sb.toString());
                return true;
            }
            return false;
        }
        if (!this.mFirstCallBack) {
            str = ", now buf ";
            str2 = ", need buf ";
            j2 = this.mNeedBuffer;
        } else {
            if (PortraitNetworkScore.getInstance().getLastTargetBitrate() >= 0.0d) {
                d = PortraitNetworkScore.getInstance().getLastTargetBitrate() * 1024.0d * 1024.0d;
            } else {
                d = -1.0d;
            }
            long j3 = (long) d;
            MediaPlayer mediaPlayer = this.mVideoEngine.getMediaPlayer();
            long j4 = -1;
            if (mediaPlayer != null) {
                j4 = mediaPlayer.getLongOption(171, -1L);
            }
            if (this.mIfStartup) {
                str = ", now buf ";
                str2 = ", need buf ";
                j4 = (long) (j4 * (this.mBeta + (this.mGamma * Math.exp(1.0d - ((this.mRebufferingTimeEarlyMs * 1.0d) / 1000.0d)))));
            } else {
                str = ", now buf ";
                str2 = ", need buf ";
            }
            float f2 = (j3 * 1.0f) / j4;
            int i5 = this.mRebufferingTimeEarlyMs;
            float f3 = ((i5 - j) * 1.0f) / (i5 + this.mCostTimeMaxMs);
            TTVideoEngineLog.d("dynamiclc", " targetBitrate: " + j3 + ", videoBitrate: " + j4 + ", rate: " + f2 + ", threshold: " + f3);
            int i6 = this.mRebufferingTimeEarlyMs;
            if (j >= i6) {
                j2 = this.mStartupDurationMinMs;
                i = 1;
            } else if (j3 > 0 && j4 > 0) {
                if (f2 >= 1.0f) {
                    j2 = this.mStartupDurationMinMs;
                    i = 2;
                } else if (f2 < 1.0f && f2 >= f3) {
                    j2 = (long) Math.min(Math.max((1.0f - f2) * i6, this.mStartupDurationMinMs), this.mStartupDurationMaxMs);
                    i = 3;
                } else {
                    j2 = (long) Math.min(Math.max((1.0f - f3) * i6, this.mStartupDurationMinMs), this.mStartupDurationMaxMs);
                    i = 4;
                }
            } else {
                j2 = (long) Math.min(Math.max((1.0f - f3) * i6, this.mStartupDurationMinMs), this.mStartupDurationMaxMs);
                i = 5;
            }
            this.mNeedBuffer = j2;
            this.mCaseType = i;
            this.mFirstCallBack = false;
        }
        if (j >= j2) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mCallbackCount++;
        if (z2) {
            TTVideoEngineLog.d("dynamiclc", " parameters:  D_min " + this.mStartupDurationMinMs + ", D_max " + this.mStartupDurationMaxMs + ", T_min " + this.mRebufferingTimeEarlyMs + ", C_max " + this.mCostTimeMaxMs);
            TTVideoEngineLog.d("dynamiclc", " start up: ifstartup " + this.mIfStartup + ", case " + this.mCaseType + str2 + j2 + str + j + ", callback count " + this.mCallbackCount);
            this.mFirstCallBack = true;
            this.mIfStartup = false;
            this.mCallbackCount = 0;
            return z2;
        }
        return z2;
    }

    public DynamicLoadControl(int i, int i2, int i3, int i4, float f, float f2, int i5, int i6, float f3, int i7, TTVideoEngine tTVideoEngine) {
        this.mStartupDurationMinMs = i;
        this.mStartupDurationMaxMs = i2;
        this.mRebufferingTimeEarlyMs = i3;
        this.mCostTimeMaxMs = i4;
        this.mBeta = f;
        this.mGamma = f2;
        this.mRebufferingDurationInitMs = i5;
        this.mRebufferingDurationMaxMs = i6;
        this.mRebufferingIncFactor = f3;
        this.mRebufferingIncType = i7;
        this.mVideoEngine = tTVideoEngine;
    }
}
