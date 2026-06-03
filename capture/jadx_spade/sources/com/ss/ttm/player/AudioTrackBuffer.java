package com.ss.ttm.player;

import android.media.AudioTrack;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
class AudioTrackBuffer {
    AudioTrack AudioTrack;
    int audioFormat;
    int channelsLayout;
    int frameSamples;
    long mFreeTimePoint;
    int sampleRate;
    int streamType;
    int usedCount;

    static {
        Covode.recordClassIndex(652090);
    }

    public void resetFreeTimePoint() {
        this.mFreeTimePoint = System.currentTimeMillis();
    }

    public AudioTrackBuffer(AudioTrack audioTrack, int i, int i2, int i3, int i4, int i5, int i6) {
        this.AudioTrack = audioTrack;
        this.streamType = i;
        this.sampleRate = i2;
        this.channelsLayout = i3;
        this.audioFormat = i4;
        this.frameSamples = i5;
        this.usedCount = i6;
    }
}
