package com.ss.ttvideoengine.log;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SuperResolutionMonitor {
    private int mSrAlgorithm = Integer.MIN_VALUE;
    private int mEnableBmf = 0;
    private float mProccessSuccessRate = Float.MIN_VALUE;
    private float mProcessorAverageCostTime = Float.MIN_VALUE;
    private int mSrScaleType = Integer.MIN_VALUE;

    static {
        Covode.recordClassIndex(652483);
    }

    public int getEnableBmf() {
        return this.mEnableBmf;
    }

    public float getProccessSuccessRate() {
        return this.mProccessSuccessRate;
    }

    public float getProcessorAverageCostTime() {
        return this.mProcessorAverageCostTime;
    }

    public int getSrAlgorithm() {
        return this.mSrAlgorithm;
    }

    public float getHeightFactor() {
        int i = this.mSrAlgorithm;
        if (i == 0) {
            return 2.0f;
        }
        switch (i) {
            case 5:
            case 7:
                int i2 = this.mSrScaleType;
                if (i2 != 0) {
                    if (i2 == 1) {
                    }
                }
                break;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
            case 9:
            case 10:
            case 11:
                int i3 = this.mSrScaleType;
                if (i3 != 0) {
                    if (i3 == 1) {
                    }
                }
                break;
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                int i4 = this.mSrScaleType;
                if (i4 != 4) {
                    if (i4 != 8) {
                        if (i4 != 16) {
                            if (i4 != 32) {
                                if (i4 != 1) {
                                    if (i4 == 2) {
                                    }
                                }
                            }
                        }
                    }
                }
                break;
        }
        return 2.0f;
    }

    public float getWidthFactor() {
        int i = this.mSrAlgorithm;
        if (i == 0) {
            return 2.0f;
        }
        switch (i) {
            case 5:
            case 7:
                int i2 = this.mSrScaleType;
                if (i2 != 0) {
                    if (i2 == 1) {
                    }
                }
                break;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
            case 9:
            case 10:
            case 11:
                int i3 = this.mSrScaleType;
                if (i3 != 0) {
                    if (i3 == 1) {
                    }
                }
                break;
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                int i4 = this.mSrScaleType;
                if (i4 != 4) {
                    if (i4 != 8) {
                        if (i4 != 16) {
                            if (i4 != 32) {
                                if (i4 != 1) {
                                    if (i4 == 2) {
                                    }
                                }
                            }
                        }
                    }
                }
                break;
        }
        return 2.0f;
    }

    public void setAlgorithm(int i) {
        this.mSrAlgorithm = i;
    }

    public void setEnableBmf(int i) {
        this.mEnableBmf = i;
    }

    public void setProccessSuccessRate(float f) {
        this.mProccessSuccessRate = f;
    }

    public void setProcessorAverageCostTime(float f) {
        this.mProcessorAverageCostTime = f;
    }

    public void setSrScaleType(int i) {
        this.mSrScaleType = i;
    }
}
