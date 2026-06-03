package com.ss.ttvideoengine.selector.gracie;

import com.bytedance.covode.number.Covode;
import com.bytedance.vcloud.abrmodule.IDeviceInfo;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class GracieDeviceInfo implements IDeviceInfo {
    private int mHeight;
    private int mWidth;

    static {
        Covode.recordClassIndex(652644);
    }

    public int getHDRInfo() {
        return -1;
    }

    public int getHWDecodeMaxLength() {
        return -1;
    }

    public int getScreenFps() {
        return -1;
    }

    public int getScreenHeight() {
        return this.mHeight;
    }

    public int getScreenWidth() {
        return this.mWidth;
    }

    private GracieDeviceInfo(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }
}
