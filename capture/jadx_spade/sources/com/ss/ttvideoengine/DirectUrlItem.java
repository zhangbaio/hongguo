package com.ss.ttvideoengine;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DirectUrlItem {
    private int mBitrate;
    private long mCDNUrlExpiredTime;
    private String[] mExpireTimes;
    private final String mFileKey;
    private String mFormat;
    private String[] mUrls;
    private String mVideoId;

    static {
        Covode.recordClassIndex(652279);
    }

    public String[] allUrls() {
        return this.mUrls;
    }

    public long cdnExpiredTime() {
        return this.mCDNUrlExpiredTime;
    }

    public String fileKey() {
        return this.mFileKey;
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public String getFormat() {
        return this.mFormat;
    }

    public String[] urlExpireTimes() {
        return this.mExpireTimes;
    }

    public String vid() {
        return this.mVideoId;
    }

    public DirectUrlItem(String[] strArr, String str, String str2, long j) {
        this.mExpireTimes = null;
        this.mBitrate = -1;
        this.mVideoId = str2;
        this.mUrls = strArr;
        this.mCDNUrlExpiredTime = j;
        this.mFileKey = str;
    }

    public DirectUrlItem(String[] strArr, String str, String str2, long j, String[] strArr2) {
        this.mBitrate = -1;
        this.mVideoId = str2;
        this.mUrls = strArr;
        this.mCDNUrlExpiredTime = j;
        this.mFileKey = str;
        this.mExpireTimes = strArr2;
    }

    public DirectUrlItem(String[] strArr, String str, String str2, long j, String[] strArr2, String str3, int i) {
        this.mVideoId = str2;
        this.mUrls = strArr;
        this.mCDNUrlExpiredTime = j;
        this.mFileKey = str;
        this.mExpireTimes = strArr2;
        this.mFormat = str3;
        this.mBitrate = i;
    }
}
