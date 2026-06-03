package com.ss.ttm.player;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PlaybackParams {
    private int mDescribeContents = -1;
    private int mAudioFallbackMode = -1;
    private float mPitch = -1.0f;
    private float mSpeed = -1.0f;

    static {
        Covode.recordClassIndex(652158);
    }

    public PlaybackParams allowDefaults() {
        return this;
    }

    public int describeContents() {
        return this.mDescribeContents;
    }

    public int getAudioFallbackMode() {
        return this.mAudioFallbackMode;
    }

    public float getPitch() {
        return this.mPitch;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public PlaybackParams setAudioFallbackMode(int i) {
        this.mAudioFallbackMode = i;
        return this;
    }

    public PlaybackParams setPitch(float f) {
        this.mPitch = f;
        return this;
    }

    public PlaybackParams setSpeed(float f) {
        this.mSpeed = f;
        return this;
    }
}
