package com.ss.ttm.player;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class VoiceTrait extends TraitObject {

    public static class AudioFrameInfo {
        public ByteBuffer[] mBuffers;
        public int mSamples;
        public long mTimestamp;

        static {
            Covode.recordClassIndex(652213);
        }
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface Ver {
    }

    static {
        Covode.recordClassIndex(652212);
    }

    public abstract void audioClose();

    public abstract void audioFlush();

    public abstract int audioOpen(AudioMediaInfo audioMediaInfo);

    public abstract void audioPause();

    public abstract void audioResume();

    public abstract int audioWrite(AudioFrameInfo audioFrameInfo);

    public abstract int getLatency();

    public VoiceTrait(int i) {
        super(1, i, 0L);
    }

    public VoiceTrait(int i, long j) {
        super(i, j);
    }

    public VoiceTrait(int i, int i2, long j) {
        super(i, i2, j);
    }

    public static class AudioMediaInfo {
        public int mBytePerSample;
        public int mChannels;
        public int mDuration;
        public int mFormat;
        public int mFrameSampleNB;
        public int mIsPacked;
        public int mSampleRate;

        static {
            Covode.recordClassIndex(652214);
        }

        public AudioMediaInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.mSampleRate = i;
            this.mFrameSampleNB = i2;
            this.mBytePerSample = i3;
            this.mChannels = i4;
            this.mFormat = i5;
            this.mIsPacked = i6;
            this.mDuration = i7;
        }
    }
}
