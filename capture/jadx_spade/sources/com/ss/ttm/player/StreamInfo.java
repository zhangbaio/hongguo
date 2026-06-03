package com.ss.ttm.player;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class StreamInfo {
    private int mBitrate;
    private int mChannels;
    private String mCodecName;
    private long mDuration;
    private int mFrameRate;
    private int mHeight;
    private int mRotation;
    private int mSampleRate;
    private int mStreamIndex;
    private int mStreamType;
    private int mWidth;

    static {
        Covode.recordClassIndex(652164);
    }

    public MediaPlayer.TrackInfo convertToTrackInfo() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setInteger("track-id", this.mStreamIndex);
        mediaFormat.setInteger("frame-rate", this.mFrameRate);
        mediaFormat.setInteger("bitrate", this.mBitrate);
        mediaFormat.setInteger("width", this.mWidth);
        mediaFormat.setInteger("height", this.mHeight);
        mediaFormat.setInteger("sample-rate", this.mSampleRate);
        mediaFormat.setInteger("channel-count", this.mChannels);
        mediaFormat.setLong("duration", this.mDuration);
        mediaFormat.setLong("rotation", this.mRotation);
        mediaFormat.setString("codec-name", this.mCodecName);
        return new MediaPlayer.TrackInfo(this.mStreamType, mediaFormat);
    }

    public String toString() {
        return "StreamInfo{mStreamType=" + this.mStreamType + ", mStreamIndex=" + this.mStreamIndex + ", mCodecName='" + this.mCodecName + "', mFrameRate=" + this.mFrameRate + ", mBitrate=" + this.mBitrate + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mSampleRate=" + this.mSampleRate + ", mChannels=" + this.mChannels + ", mDuration=" + this.mDuration + ", mRotation=" + this.mRotation + '}';
    }

    public StreamInfo(int i, int i2, String str, int i3, int i4, int i5, int i6, int i7, int i8, long j, int i9) {
        this.mStreamType = i;
        this.mStreamIndex = i2;
        this.mCodecName = str;
        this.mFrameRate = i3;
        this.mBitrate = i4;
        this.mWidth = i5;
        this.mHeight = i6;
        this.mSampleRate = i7;
        this.mChannels = i8;
        this.mDuration = j;
        this.mRotation = i9;
    }
}
