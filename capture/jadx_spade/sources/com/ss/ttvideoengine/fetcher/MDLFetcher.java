package com.ss.ttvideoengine.fetcher;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.mediakit.fetcher.AVMDLURLFetcherInterface;
import com.ss.mediakit.fetcher.AVMDLURLFetcherListener;
import com.ss.ttvideoengine.VideoModelCache;
import com.ss.ttvideoengine.fetcher.VideoInfoFetcher;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MDLFetcher implements AVMDLURLFetcherInterface {
    private Context mContext;
    private String mFallbackAPI;
    private VideoInfoFetcher mFetcher;
    private String mFileHash;
    private String mKeyseed;
    private AVMDLURLFetcherListener mListener;
    private String[] mNewUrls = null;
    private String mOldUrl;
    private String mVideoID;

    static {
        Covode.recordClassIndex(652439);
    }

    public void close() {
        VideoInfoFetcher videoInfoFetcher = this.mFetcher;
        if (videoInfoFetcher != null) {
            videoInfoFetcher.cancel();
            this.mFetcher = null;
        }
        this.mNewUrls = null;
    }

    public String[] getURLs() {
        String[] strArr = this.mNewUrls;
        if (strArr != null && strArr.length > 0) {
            TTVideoEngineLog.d("MDLFetcher", "get urls from cache. + urls.length = " + this.mNewUrls.length);
            return this.mNewUrls;
        }
        return null;
    }

    private static class MyFetcherListener implements VideoInfoFetcher.FetcherListener {
        private final WeakReference<MDLFetcher> mFetcherRef;

        static {
            Covode.recordClassIndex(652440);
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onLog(String str) {
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onRetry(Error error) {
        }

        public MyFetcherListener(MDLFetcher mDLFetcher) {
            this.mFetcherRef = new WeakReference<>(mDLFetcher);
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onStatusException(int i, String str) {
            MDLFetcher mDLFetcher = this.mFetcherRef.get();
            if (mDLFetcher == null) {
                TTVideoEngineLog.i("MDLFetcher", "onStatusException but fetcher is null");
            } else if (mDLFetcher.mListener != null) {
                mDLFetcher.mListener.onCompletion(i, mDLFetcher.mVideoID, mDLFetcher.mFileHash, (String[]) null);
            }
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onCompletion(VideoModel videoModel, Error error) {
            int i;
            TTVideoEngineLog.i("MDLFetcher", "onCompletion model " + videoModel + ", error " + error);
            MDLFetcher mDLFetcher = this.mFetcherRef.get();
            if (mDLFetcher == null) {
                TTVideoEngineLog.i("MDLFetcher", "onCompletion but fetcher is null");
                return;
            }
            if (videoModel != null && error == null) {
                mDLFetcher.mNewUrls = mDLFetcher._getUrlsFromVideoModelByFileHash(videoModel, mDLFetcher.mFileHash);
                TTVideoEngineLog.i("MDLFetcher", "onCompletion newUrls " + Arrays.toString(mDLFetcher.mNewUrls));
                if (MDLFetcher.isNewUrlsValid(mDLFetcher.mNewUrls, mDLFetcher.mOldUrl)) {
                    TTVideoEngineLog.i("MDLFetcher", "onCompletion success");
                    if (mDLFetcher.mListener != null) {
                        mDLFetcher.mListener.onCompletion(0, mDLFetcher.mVideoID, mDLFetcher.mFileHash, mDLFetcher.mNewUrls);
                        return;
                    }
                    return;
                }
                TTVideoEngineLog.i("MDLFetcher", "onCompletion invalid");
                if (mDLFetcher.mListener != null) {
                    mDLFetcher.mListener.onCompletion(-1, mDLFetcher.mVideoID, mDLFetcher.mFileHash, (String[]) null);
                    return;
                }
                return;
            }
            if (error != null) {
                i = error.code;
            } else {
                i = -9997;
            }
            if (mDLFetcher.mListener != null) {
                mDLFetcher.mListener.onCompletion(i, mDLFetcher.mVideoID, mDLFetcher.mFileHash, (String[]) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isNewUrlsValid(String[] strArr, String str) {
        if (strArr == null || strArr.length <= 0) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        for (String str2 : strArr) {
            if (TextUtils.equals(str2, str)) {
                TTVideoEngineLog.d("MDLFetcher", "new urls is invalid");
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] _getUrlsFromVideoModelByFileHash(VideoModel videoModel, String str) {
        if (videoModel != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put(15, str);
            VideoInfo videoInfo = videoModel.getVideoInfo(hashMap);
            if (videoInfo != null) {
                String[] valueStrArr = videoInfo.getValueStrArr(16);
                TTVideoEngineLog.d("MDLFetcher", "_getUrlsFromVideoModel " + Arrays.toString(valueStrArr));
                if (valueStrArr == null || valueStrArr.length <= 0) {
                    return null;
                }
                return valueStrArr;
            }
            TTVideoEngineLog.d("MDLFetcher", "_getUrlsFromVideoModel videoInfo is null");
            return null;
        }
        TTVideoEngineLog.d("MDLFetcher", "_getUrlsFromVideoModel videoModel is null or fileHash is empty " + str);
        return null;
    }

    public MDLFetcher(Context context, String str, String str2) {
        this.mContext = context;
        this.mFallbackAPI = TTVideoEngineUtils.BuildHttpsApi(str);
        this.mKeyseed = str2;
    }

    public int start(String str, String str2, String str3, AVMDLURLFetcherListener aVMDLURLFetcherListener) {
        VideoModelCache.VideoModelCacheInfo videoModelCacheInfo;
        boolean z;
        TTVideoEngineLog.i("MDLFetcher", "start rawKey " + str + ", fileKey " + str2 + ", olderUrl " + str3 + ", listener " + aVMDLURLFetcherListener);
        this.mVideoID = str;
        this.mFileHash = str2;
        this.mListener = aVMDLURLFetcherListener;
        this.mOldUrl = str3;
        synchronized (MDLFetcher.class) {
            videoModelCacheInfo = VideoModelCache.getInstance().get(this.mVideoID, this.mFallbackAPI);
        }
        if (videoModelCacheInfo != null && !videoModelCacheInfo.isExpired) {
            TTVideoEngineLog.i("MDLFetcher", String.format("get videoModel from cache,key is %s; videoId = %s", this.mFileHash, this.mVideoID));
            String[] _getUrlsFromVideoModelByFileHash = _getUrlsFromVideoModelByFileHash(videoModelCacheInfo.model, this.mFileHash);
            if (!TextUtils.isEmpty(str3) && _getUrlsFromVideoModelByFileHash != null && _getUrlsFromVideoModelByFileHash.length > 0) {
                this.mNewUrls = _getUrlsFromVideoModelByFileHash;
                for (String str4 : _getUrlsFromVideoModelByFileHash) {
                    if (str4.equals(str3)) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                if (this.mNewUrls != null) {
                    TTVideoEngineLog.i("MDLFetcher", "start get urls from cache " + Arrays.toString(this.mNewUrls));
                    return 1;
                }
            } else {
                this.mNewUrls = null;
                synchronized (MDLFetcher.class) {
                    VideoModelCache.getInstance().remove(this.mVideoID, this.mFallbackAPI);
                }
            }
        }
        VideoInfoFetcher videoInfoFetcher = new VideoInfoFetcher(this.mContext, null);
        this.mFetcher = videoInfoFetcher;
        if (this.mContext != null) {
            videoInfoFetcher.setUseVideoModelCache(true);
        }
        this.mFetcher.setVideoID(str);
        this.mFetcher.setListener(new MyFetcherListener(this));
        this.mFetcher.setUseFallbakApi(Boolean.valueOf(!TextUtils.isEmpty(this.mFallbackAPI)));
        this.mFetcher.fetchInfo(this.mFallbackAPI, null, 0, this.mKeyseed);
        return 0;
    }
}
