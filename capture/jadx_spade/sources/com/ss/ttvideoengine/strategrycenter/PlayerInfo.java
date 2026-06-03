package com.ss.ttvideoengine.strategrycenter;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PlayerInfo {
    private float mFrameRate;
    private int mPlaybackPos;
    private float mPlaybackSpeed;

    static {
        Covode.recordClassIndex(652711);
    }

    public float getFrameRate() {
        return this.mFrameRate;
    }

    public int getPlaybackPos() {
        return this.mPlaybackPos;
    }

    public float getPlaybackSpeed() {
        return this.mPlaybackSpeed;
    }

    public void setFrameRate(float f) {
        this.mFrameRate = f;
    }

    public void setPlaybackPos(int i) {
        this.mPlaybackPos = i;
    }

    public void setPlaybackSpeed(float f) {
        this.mPlaybackSpeed = f;
    }
}
