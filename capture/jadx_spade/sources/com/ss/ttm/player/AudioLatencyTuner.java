package com.ss.ttm.player;

import android.media.AudioTrack;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AudioLatencyTuner {
    private float mSuggestedInitialSizeRate = 1.0f;
    private boolean mEnableInitialSizeAdaptFrameSize = false;
    private AudioTrack mAudioTrack = null;
    private int mOutputPcmFrameSize = 0;
    private int mInitialSize = 0;
    private int mActualSize = 0;
    private float mActualSizeRate = 1.0f;
    private boolean mEnableChangeSize = false;
    private int mChangeSizeRate = 2;
    private boolean mEnableAutoUpdateSize = false;
    private int mFramesPerBlock = 64;
    private int mPrimingThreshold = 8;
    private int mState = 0;
    private int mPreviousUnderrunCount = 0;
    private int mStableStopUpdateThresh = 0;
    private int mAutoUpdateSizeStableNum = 0;
    private int mGlobalUpdateSizeMode = 0;
    private boolean mAudioTrackWillBlock = true;
    private int mAudioTrackBlockCount = 0;
    private int mMinTrackSize = 0;
    private boolean[] mHistoryUnderRunRise = {false, false};

    static {
        Covode.recordClassIndex(652086);
    }

    public void close() {
        if (this.mGlobalUpdateSizeMode > 0 && this.mState == 3) {
            TTPlayerConfiger.setValue(74, this.mActualSize);
        }
        this.mAudioTrack = null;
    }

    private boolean incrementThreshold(int i) {
        int bufferSizeInFrames = this.mAudioTrack.getBufferSizeInFrames();
        int i2 = this.mFramesPerBlock;
        this.mActualSize = this.mAudioTrack.setBufferSizeInFrames(((bufferSizeInFrames / i2) + i) * i2) * this.mOutputPcmFrameSize;
        StringBuilder sb = new StringBuilder();
        sb.append("AudioLatencyTuner log: Buffer size changed from ");
        sb.append(this.mOutputPcmFrameSize * bufferSizeInFrames);
        sb.append(" to ");
        sb.append(this.mActualSize);
        if (this.mActualSize == bufferSizeInFrames * this.mOutputPcmFrameSize) {
            return true;
        }
        return false;
    }

    public void setFloatOption(int i, float f) {
        if (i != 11) {
            if (i == 12) {
                this.mActualSizeRate = f;
                return;
            }
            return;
        }
        this.mSuggestedInitialSizeRate = f;
    }

    public void setIntOption(int i, int i2) {
        boolean z = true;
        if (i != 10) {
            switch (i) {
                case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                    if (i2 <= 0) {
                        z = false;
                    }
                    this.mEnableChangeSize = z;
                    break;
                case 14:
                    this.mChangeSizeRate = i2;
                    break;
                case 15:
                    if (i2 <= 0) {
                        z = false;
                    }
                    this.mEnableAutoUpdateSize = z;
                    break;
                case 16:
                    this.mPrimingThreshold = i2;
                    break;
                case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                    this.mStableStopUpdateThresh = i2;
                    break;
                case 18:
                    this.mGlobalUpdateSizeMode = i2;
                    break;
            }
        }
        if (i2 <= 0) {
            z = false;
        }
        this.mEnableInitialSizeAdaptFrameSize = z;
    }

    public int updateAudioTrack(AudioTrack audioTrack, int i) {
        if (audioTrack == null) {
            return -1;
        }
        this.mAudioTrack = audioTrack;
        this.mOutputPcmFrameSize = i;
        int value = TTPlayerConfiger.getValue(74, 0);
        if (this.mGlobalUpdateSizeMode > 0 && value > 0) {
            this.mActualSize = this.mAudioTrack.setBufferSizeInFrames(value / this.mOutputPcmFrameSize) * this.mOutputPcmFrameSize;
            if (this.mGlobalUpdateSizeMode == 2) {
                this.mState = 3;
            }
        } else {
            this.mActualSize = this.mAudioTrack.setBufferSizeInFrames((int) ((this.mInitialSize * this.mActualSizeRate) / this.mOutputPcmFrameSize)) * this.mOutputPcmFrameSize;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("AudioLatencyTuner log: update audioTrack:");
        sb.append(this.mAudioTrack);
        sb.append(", actualSize:");
        sb.append(this.mActualSize);
        return this.mActualSize;
    }

    public int update(int i, long j) {
        boolean z;
        boolean z2;
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack == null) {
            return this.mActualSize;
        }
        int i2 = 1;
        if (!this.mAudioTrackWillBlock && j < 5) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.mAudioTrackBlockCount++;
        }
        if (i <= 256 && i >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mAudioTrackWillBlock = z2;
        if (this.mEnableChangeSize && this.mAudioTrackBlockCount > this.mChangeSizeRate) {
            int i3 = this.mActualSize;
            int i4 = this.mMinTrackSize;
            if (i3 != i4) {
                this.mActualSize = audioTrack.setBufferSizeInFrames(i4 / this.mOutputPcmFrameSize) * this.mOutputPcmFrameSize;
                this.mEnableChangeSize = false;
                StringBuilder sb = new StringBuilder();
                sb.append("AudioLatencyTuner log: SizeHasChanged:");
                sb.append(this.mActualSize);
            }
        }
        if (this.mEnableAutoUpdateSize && z) {
            int i5 = this.mState;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2) {
                        int underrunCount = this.mAudioTrack.getUnderrunCount();
                        if (underrunCount > this.mPreviousUnderrunCount) {
                            boolean[] zArr = this.mHistoryUnderRunRise;
                            if (zArr[0] || zArr[1]) {
                                incrementThreshold(3);
                            }
                            this.mAutoUpdateSizeStableNum = 0;
                            boolean[] zArr2 = this.mHistoryUnderRunRise;
                            zArr2[0] = zArr2[1];
                            zArr2[1] = true;
                        } else {
                            int i6 = this.mAutoUpdateSizeStableNum + 1;
                            this.mAutoUpdateSizeStableNum = i6;
                            boolean[] zArr3 = this.mHistoryUnderRunRise;
                            zArr3[0] = zArr3[1];
                            zArr3[1] = false;
                            int i7 = this.mStableStopUpdateThresh;
                            if (i7 > 0 && i6 > i7) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("AudioLatencyTuner log: update size stable:");
                                sb2.append(this.mActualSize);
                                sb2.append(", underRunCount:");
                                sb2.append(underrunCount);
                                i2 = 3;
                                this.mPreviousUnderrunCount = underrunCount;
                            }
                        }
                        i2 = i5;
                        this.mPreviousUnderrunCount = underrunCount;
                    }
                    i2 = i5;
                } else {
                    int underrunCount2 = this.mAudioTrack.getUnderrunCount();
                    if (underrunCount2 > this.mPreviousUnderrunCount) {
                        boolean[] zArr4 = this.mHistoryUnderRunRise;
                        if (zArr4[0] || zArr4[1]) {
                            incrementThreshold(3);
                            i5 = 2;
                        }
                        boolean[] zArr5 = this.mHistoryUnderRunRise;
                        zArr5[0] = zArr5[1];
                        zArr5[1] = true;
                    } else {
                        boolean[] zArr6 = this.mHistoryUnderRunRise;
                        if (!zArr6[0] && !zArr6[1] && incrementThreshold(-1)) {
                            i5 = 2;
                        }
                        boolean[] zArr7 = this.mHistoryUnderRunRise;
                        zArr7[0] = zArr7[1];
                        zArr7[1] = false;
                    }
                    i2 = i5;
                    this.mPreviousUnderrunCount = underrunCount2;
                }
                this.mState = i2;
            } else {
                if (this.mAudioTrackBlockCount > this.mPrimingThreshold) {
                    this.mPreviousUnderrunCount = this.mAudioTrack.getUnderrunCount();
                    this.mState = i2;
                }
                i2 = i5;
                this.mState = i2;
            }
        } else if (this.mActualSize < this.mMinTrackSize && z) {
            int underrunCount3 = this.mAudioTrack.getUnderrunCount();
            if (underrunCount3 > this.mPreviousUnderrunCount) {
                boolean[] zArr8 = this.mHistoryUnderRunRise;
                if (zArr8[0] || zArr8[1]) {
                    this.mActualSize = this.mAudioTrack.setBufferSizeInFrames(this.mMinTrackSize / this.mOutputPcmFrameSize) * this.mOutputPcmFrameSize;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("AudioLatencyTuner log: SizeHasChanged:");
                    sb3.append(this.mActualSize);
                    sb3.append(", underRunCount:");
                    sb3.append(underrunCount3);
                }
                boolean[] zArr9 = this.mHistoryUnderRunRise;
                zArr9[0] = zArr9[1];
                zArr9[1] = true;
            } else {
                boolean[] zArr10 = this.mHistoryUnderRunRise;
                zArr10[0] = zArr10[1];
                zArr10[1] = false;
            }
            this.mPreviousUnderrunCount = underrunCount3;
        }
        return this.mActualSize;
    }

    public int getSuggestedInitialSize(int i, int i2, int i3, int i4) {
        int minBufferSize = AudioTrack.getMinBufferSize(i, i2, i3);
        this.mMinTrackSize = minBufferSize;
        int i5 = (int) (minBufferSize * this.mSuggestedInitialSizeRate);
        this.mInitialSize = i5;
        if (this.mEnableInitialSizeAdaptFrameSize) {
            this.mInitialSize = ((i5 / i4) + 1) * i4;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("AudioLatencyTuner log: return initialSize:");
        sb.append(this.mInitialSize);
        sb.append(", mMinTrackSize:");
        sb.append(this.mMinTrackSize);
        return this.mInitialSize;
    }
}
