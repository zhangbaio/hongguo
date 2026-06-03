package com.ss.ttvideoengine.log;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VRTracker {
    private int mVideoStyle = Integer.MIN_VALUE;
    private int mDimension = Integer.MIN_VALUE;
    private int mProjectStyle = Integer.MIN_VALUE;
    private int mViewSize = Integer.MIN_VALUE;

    static {
        Covode.recordClassIndex(652484);
    }

    public int getDimension() {
        return this.mDimension;
    }

    public int getProjectStyle() {
        return this.mProjectStyle;
    }

    public int getVideoStyle() {
        return this.mVideoStyle;
    }

    public int getViewSize() {
        return this.mViewSize;
    }

    public void setDimension(int i) {
        this.mDimension = i;
    }

    public void setProjectStyle(int i) {
        this.mProjectStyle = i;
    }

    public void setVideoStyle(int i) {
        this.mVideoStyle = i;
    }

    public void setViewSize(int i) {
        this.mViewSize = i;
    }
}
