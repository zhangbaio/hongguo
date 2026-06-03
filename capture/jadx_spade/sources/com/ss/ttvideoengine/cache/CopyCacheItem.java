package com.ss.ttvideoengine.cache;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class CopyCacheItem {
    public String mCustomDir;
    public String mDestPath;
    public String mFileKey;
    public boolean mForceCopyUnfinished;
    public final CopyCacheListener mListener;
    public boolean mWaitIfCaching;

    static {
        Covode.recordClassIndex(652399);
    }

    public CopyCacheItem(String str, String str2, CopyCacheListener copyCacheListener) {
        this.mFileKey = str;
        this.mDestPath = str2;
        this.mListener = copyCacheListener;
        this.mCustomDir = null;
        this.mWaitIfCaching = false;
        this.mForceCopyUnfinished = false;
    }

    public CopyCacheItem(String str, String str2, boolean z, CopyCacheListener copyCacheListener) {
        this.mFileKey = str;
        this.mDestPath = str2;
        this.mListener = copyCacheListener;
        this.mCustomDir = null;
        this.mWaitIfCaching = z;
        this.mForceCopyUnfinished = false;
    }

    public CopyCacheItem(String str, String str2, boolean z, boolean z2, CopyCacheListener copyCacheListener) {
        this.mFileKey = str;
        this.mDestPath = str2;
        this.mListener = copyCacheListener;
        this.mCustomDir = null;
        this.mWaitIfCaching = z;
        this.mForceCopyUnfinished = z2;
        if (z2) {
            this.mWaitIfCaching = false;
        }
    }
}
