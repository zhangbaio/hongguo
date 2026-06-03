package com.ss.ttvideoengine.preload;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import java.util.Objects;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PreloadMedia {
    protected String mCacheKey = null;
    protected String mVideoId = null;
    protected long mPreloadSize = 0;
    protected long mContentLength = 0;
    protected long mDuration = 0;
    protected float mPreloadSecond = 0.0f;
    public String mSceneId = null;
    private IPreLoaderItemCallBackListener mCallBackListener = null;

    static {
        Covode.recordClassIndex(652632);
    }

    public String getCacheKey() {
        return this.mCacheKey;
    }

    public IPreLoaderItemCallBackListener getCallBackListener() {
        return this.mCallBackListener;
    }

    public long getContentLength() {
        return this.mContentLength;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public float getPreloadSecond() {
        return this.mPreloadSecond;
    }

    public long getPreloadSize() {
        return this.mPreloadSize;
    }

    public String getVideoId() {
        return this.mVideoId;
    }

    public int hashCode() {
        return Objects.hash(this.mCacheKey, this.mVideoId, this.mCallBackListener);
    }

    public void setCacheKey(String str) {
        this.mCacheKey = str;
    }

    public void setCallBackListener(IPreLoaderItemCallBackListener iPreLoaderItemCallBackListener) {
        this.mCallBackListener = iPreLoaderItemCallBackListener;
    }

    public void setContentLength(long j) {
        this.mContentLength = j;
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }

    public void setPreloadSize(long j) {
        this.mPreloadSize = j;
    }

    public void setVideoId(String str) {
        this.mVideoId = str;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (obj == null) {
            return false;
        }
        if (super.equals(obj)) {
            return true;
        }
        if (!(obj instanceof PreloadMedia)) {
            return false;
        }
        PreloadMedia preloadMedia = (PreloadMedia) obj;
        if (this.mPreloadSize == preloadMedia.mPreloadSize) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.mCacheKey.equals(preloadMedia.mCacheKey)) {
            z2 = true;
        } else {
            z2 = false;
        }
        IPreLoaderItemCallBackListener iPreLoaderItemCallBackListener = this.mCallBackListener;
        if (iPreLoaderItemCallBackListener != null || preloadMedia.mCallBackListener != null) {
            if (iPreLoaderItemCallBackListener == null || preloadMedia.mCallBackListener == null) {
                z2 = false;
            }
            if (z2) {
                if (z2 && iPreLoaderItemCallBackListener == preloadMedia.mCallBackListener) {
                    z3 = true;
                }
                return z3;
            }
            return z2;
        }
        return z2;
    }
}
