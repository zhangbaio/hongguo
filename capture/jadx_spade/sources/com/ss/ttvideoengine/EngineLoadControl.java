package com.ss.ttvideoengine;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.LoadControl;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class EngineLoadControl extends LoadControl {
    private int mAudioTrackCacheDurationMs;
    private int mRebufferingCount = 0;
    private int mRebufferingDurationInitMs;
    private int mRebufferingDurationMaxMs;
    private float mRebufferingIncFactor;
    private int mRebufferingIncType;
    private int mStartupDurationNonpreloadedMs;
    private int mStartupDurationPreloadedMs;
    private TTVideoEngine mVideoEngine;
    private int mVideoTrackCacheDurationMs;

    static {
        Covode.recordClassIndex(652284);
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
        boolean z2;
        int i;
        int i2;
        String str;
        String str2;
        long min;
        if (z) {
            int i3 = this.mRebufferingIncType;
            if (i3 == 0) {
                str = ", now buf ";
                str2 = ", need buf ";
                int i4 = this.mRebufferingDurationInitMs;
                min = (long) Math.min(i4 + (this.mRebufferingCount * this.mRebufferingIncFactor * i4), this.mRebufferingDurationMaxMs);
            } else if (i3 == 1) {
                str = ", now buf ";
                str2 = ", need buf ";
                min = (long) Math.min(this.mRebufferingDurationInitMs * ((this.mRebufferingIncFactor * Math.log1p(this.mRebufferingCount)) + 1.0d), this.mRebufferingDurationMaxMs);
            } else {
                min = this.mRebufferingDurationInitMs;
                str = ", now buf ";
                str2 = ", need buf ";
            }
            if (j >= min) {
                this.mRebufferingCount++;
                TTVideoEngineLog.d("defaultlc", " parameters:  sdp " + this.mStartupDurationPreloadedMs + " sdnp " + this.mStartupDurationNonpreloadedMs + " rdi " + this.mRebufferingDurationInitMs + " rdm " + this.mRebufferingDurationMaxMs + " rif " + this.mRebufferingIncFactor + " rit " + this.mRebufferingIncType);
                StringBuilder sb = new StringBuilder();
                sb.append(" buffer end:  rebuf count ");
                sb.append(this.mRebufferingCount);
                sb.append(str2);
                sb.append(min);
                sb.append(str);
                sb.append(j);
                TTVideoEngineLog.d("defaultlc", sb.toString());
                return true;
            }
            return false;
        }
        boolean z3 = true;
        if (this.mVideoEngine.getLongOption(461) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i = this.mStartupDurationPreloadedMs;
        } else {
            i = this.mStartupDurationNonpreloadedMs;
        }
        if (j < i) {
            z3 = false;
        }
        if (z3) {
            TTVideoEngineLog.d("defaultlc", " parameters:  sdp " + this.mStartupDurationPreloadedMs + " sdnp " + this.mStartupDurationNonpreloadedMs + " rdi " + this.mRebufferingDurationInitMs + " rdm " + this.mRebufferingDurationMaxMs + " rif " + this.mRebufferingIncFactor + " rit " + this.mRebufferingIncType);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" start up:    preloaded ");
            sb2.append(z2);
            sb2.append(", need buf ");
            if (z2) {
                i2 = this.mStartupDurationPreloadedMs;
            } else {
                i2 = this.mStartupDurationNonpreloadedMs;
            }
            sb2.append(i2);
            sb2.append(", now buf ");
            sb2.append(j);
            TTVideoEngineLog.d("defaultlc", sb2.toString());
        }
        return z3;
    }

    public EngineLoadControl(int i, int i2, int i3, int i4, float f, int i5, TTVideoEngine tTVideoEngine) {
        this.mStartupDurationPreloadedMs = i;
        this.mStartupDurationNonpreloadedMs = i2;
        this.mRebufferingDurationInitMs = i3;
        this.mRebufferingDurationMaxMs = i4;
        this.mRebufferingIncFactor = f;
        this.mRebufferingIncType = i5;
        this.mVideoEngine = tTVideoEngine;
    }
}
