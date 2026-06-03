package com.ss.ttvideoengine.strategrycenter;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Representation {
    private int mBitrate;
    private String mCodec;
    private String mFileID;
    private int mFileSize;
    private int mHeight;
    private String mMediaType;
    private String mQuality;
    private int mWidth;

    static {
        Covode.recordClassIndex(652712);
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public String getFileID() {
        return this.mFileID;
    }

    public int getFileSize() {
        return this.mFileSize;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getMediaType() {
        return this.mMediaType;
    }

    public String getQuality() {
        return this.mQuality;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setBitrate(int i) {
        this.mBitrate = i;
    }

    public void setFileID(String str) {
        this.mFileID = str;
    }

    public void setFileSize(int i) {
        this.mFileSize = i;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setMediaType(String str) {
        this.mMediaType = str;
    }

    public void setQuality(String str) {
        this.mQuality = str;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }
}
