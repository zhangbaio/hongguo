package com.ss.ttvideoengine;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class EngineGlobalConfig {
    private int dnsCustomType;
    private boolean onlyUseMediaLoader = false;
    private boolean useVideoInfoFetcherHandlerThread = false;
    private int renderType = -1;
    private int outputLogLevel = 0;
    private int outputLogLevelPercise = -1;
    private long mALogWriteAddr = 0;
    private int mEnableCPPBYTEVC1CodecOpt = -1;
    private int mEnableBmf = 0;
    private int mEnableUseRealBitrate = 0;
    private int mLazyLoadVideodec = 0;
    private int mEnablePcdnAuto = 0;
    private long mEngineOptimizeFlag = 3;
    private int mEnableSelectStringMapMethod = 0;
    private int mEnableSelectUseObject = 0;
    public int dataLoaderHelperLockType = 0;
    public int enableMdlLockOptimizeV2 = 0;

    static {
        Covode.recordClassIndex(652282);
    }

    private static final class InstanceHolder {
        private static final EngineGlobalConfig sInstance;

        private InstanceHolder() {
        }

        static {
            Covode.recordClassIndex(652283);
            sInstance = new EngineGlobalConfig();
        }
    }

    public long getALogWriteAddr() {
        return this.mALogWriteAddr;
    }

    public int getDnsCustomType() {
        return this.dnsCustomType;
    }

    public int getEnableBmf() {
        return this.mEnableBmf;
    }

    public int getEnableCPPBYTEVC1CodecOpt() {
        return this.mEnableCPPBYTEVC1CodecOpt;
    }

    public int getEnableSelectStringMapMethod() {
        return this.mEnableSelectStringMapMethod;
    }

    public int getEnableSelectUseObject() {
        return this.mEnableSelectUseObject;
    }

    public int getEnableUseRealBitrate() {
        return this.mEnableUseRealBitrate;
    }

    public long getEngineOptimizeFlag() {
        return this.mEngineOptimizeFlag;
    }

    public int getLazyLoadVideodec() {
        return this.mLazyLoadVideodec;
    }

    public int getOutputLogLevel() {
        return this.outputLogLevel;
    }

    public int getOutputLogLevelPercise() {
        return this.outputLogLevelPercise;
    }

    public int getPcdnAuto() {
        return this.mEnablePcdnAuto;
    }

    public int getRenderType() {
        return this.renderType;
    }

    public boolean isOnlyUseMediaLoader() {
        return this.onlyUseMediaLoader;
    }

    public boolean isUseVideoInfoFetcherHandlerThread() {
        return this.useVideoInfoFetcherHandlerThread;
    }

    public static EngineGlobalConfig getInstance() {
        return InstanceHolder.sInstance;
    }

    public void onlyUseMediaLoader(boolean z) {
        this.onlyUseMediaLoader = z;
    }

    public void setALogWriteAddr(long j) {
        this.mALogWriteAddr = j;
    }

    public void setDnsCustomType(int i) {
        this.dnsCustomType = i;
    }

    public void setEnableBmf(int i) {
        this.mEnableBmf = i;
    }

    public void setEnableCPPBYTEVC1CodecOpt(int i) {
        this.mEnableCPPBYTEVC1CodecOpt = i;
    }

    public void setEnablePcdnAuto(int i) {
        this.mEnablePcdnAuto = i;
    }

    public void setEnableSelectStringMapMethod(int i) {
        this.mEnableSelectStringMapMethod = i;
    }

    public void setEnableSelectUseObject(int i) {
        this.mEnableSelectUseObject = i;
    }

    public void setEnableUseRealBitrate(int i) {
        this.mEnableUseRealBitrate = i;
    }

    public void setEngineOptimizeFlag(long j) {
        this.mEngineOptimizeFlag = j;
    }

    public void setLazyLoadVideodec(int i) {
        this.mLazyLoadVideodec = i;
    }

    public void setOutputLogLevel(int i) {
        this.outputLogLevel = i;
    }

    public void setOutputLogLevelPercise(int i) {
        this.outputLogLevelPercise = i;
    }

    public void setRenderType(int i) {
        this.renderType = i;
    }

    public void setUseVideoInfoFetcherHandlerThread(boolean z) {
        this.useVideoInfoFetcherHandlerThread = z;
    }
}
