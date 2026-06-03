package com.ss.ttvideoengine.preload;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.DataLoaderResourceProvider;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PreloadURLMedia extends PreloadMedia {
    private HashMap<String, String> mHeaders;
    private DataLoaderResourceProvider mProvider;
    private String[] mUrls;

    static {
        Covode.recordClassIndex(652636);
    }

    public HashMap<String, String> customHeaders() {
        return this.mHeaders;
    }

    public DataLoaderResourceProvider getProvider() {
        return this.mProvider;
    }

    public String[] getUrls() {
        return this.mUrls;
    }

    @Override // com.ss.ttvideoengine.preload.PreloadMedia
    public int hashCode() {
        int hashCode = super.hashCode();
        if (this.mProvider != null) {
            hashCode = Objects.hash(Integer.valueOf(super.hashCode()), this.mProvider);
        }
        String[] strArr = this.mUrls;
        if (strArr != null) {
            return (hashCode * 31) + Arrays.hashCode(strArr);
        }
        return hashCode;
    }

    public void setProvider(DataLoaderResourceProvider dataLoaderResourceProvider) {
        this.mProvider = dataLoaderResourceProvider;
    }

    public void setUrls(String[] strArr) {
        this.mUrls = strArr;
    }

    @Override // com.ss.ttvideoengine.preload.PreloadMedia
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
        if (!(obj instanceof PreloadURLMedia)) {
            return false;
        }
        PreloadURLMedia preloadURLMedia = (PreloadURLMedia) obj;
        if (this.mPreloadSize == preloadURLMedia.mPreloadSize) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.mCacheKey.equals(preloadURLMedia.mCacheKey)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (getCallBackListener() != null || preloadURLMedia.getCallBackListener() != null) {
            if (getCallBackListener() == null || preloadURLMedia.getCallBackListener() == null) {
                z2 = false;
            }
            if (z2) {
                if (z2 && getCallBackListener() == preloadURLMedia.getCallBackListener()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
        }
        DataLoaderResourceProvider dataLoaderResourceProvider = this.mProvider;
        if (dataLoaderResourceProvider != null || preloadURLMedia.mProvider != null) {
            if (dataLoaderResourceProvider == null || preloadURLMedia.mProvider == null) {
                z2 = false;
            }
            if (z2) {
                if (z2 && dataLoaderResourceProvider == preloadURLMedia.mProvider) {
                    z3 = true;
                }
                return z3;
            }
            return z2;
        }
        return z2;
    }

    public void setCustomHeader(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mHeaders == null) {
            this.mHeaders = new HashMap<>();
        }
        this.mHeaders.put(str.substring(0, 1).toUpperCase() + str.substring(1), str2);
    }

    public PreloadURLMedia(String str, String str2, long j, DataLoaderResourceProvider dataLoaderResourceProvider) {
        this.mUrls = null;
        this.mHeaders = null;
        this.mProvider = dataLoaderResourceProvider;
        this.mVideoId = str2;
        this.mPreloadSize = j;
        this.mCacheKey = str;
    }

    public PreloadURLMedia(String str, String str2, long j, String[] strArr) {
        this.mProvider = null;
        this.mHeaders = null;
        this.mCacheKey = str;
        this.mVideoId = str2;
        this.mPreloadSize = j;
        this.mUrls = strArr;
    }
}
