package com.ss.ttvideoengine.fetcher.mdlfethcer;

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
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MDLFetcherNew implements AVMDLURLFetcherInterface {
    private VideoInfoFetcher mFetcher;
    private String mFileHash;
    private AVMDLURLFetcherListener mListener;
    private WeakReference<MDLFetcherListener> mMDLFetcherListener;
    private String[] mNewUrls = null;
    private String mOldUrl;
    private String mVideoID;
    private VideoModel mVideoModel;

    static {
        Covode.recordClassIndex(652449);
    }

    public void close() {
        VideoInfoFetcher videoInfoFetcher = this.mFetcher;
        if (videoInfoFetcher != null) {
            videoInfoFetcher.cancel();
            this.mFetcher = null;
        }
        this.mMDLFetcherListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MDLFetcherListener getMDLFetcherListener() {
        WeakReference<MDLFetcherListener> weakReference = this.mMDLFetcherListener;
        if (weakReference == null) {
            TTVideoEngineLog.d("MDLFetcherNew", "getMDLFetcherListener is null");
            return null;
        }
        return weakReference.get();
    }

    public String[] getURLs() {
        TTVideoEngineLog.i("MDLFetcherNew", "mdl getURLs " + Arrays.toString(this.mNewUrls));
        return this.mNewUrls;
    }

    private static class MyFetcherListener implements VideoInfoFetcher.FetcherListener {
        private final WeakReference<MDLFetcherNew> mFetcherRef;

        static {
            Covode.recordClassIndex(652450);
        }

        public MyFetcherListener(MDLFetcherNew mDLFetcherNew) {
            this.mFetcherRef = new WeakReference<>(mDLFetcherNew);
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onLog(String str) {
            MDLFetcherNew mDLFetcherNew = this.mFetcherRef.get();
            if (mDLFetcherNew != null && mDLFetcherNew.getMDLFetcherListener() != null) {
                mDLFetcherNew.getMDLFetcherListener().onLog(str);
            }
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onRetry(Error error) {
            MDLFetcherNew mDLFetcherNew = this.mFetcherRef.get();
            if (mDLFetcherNew != null && mDLFetcherNew.getMDLFetcherListener() != null) {
                mDLFetcherNew.getMDLFetcherListener().onRetry(error);
            }
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onStatusException(int i, String str) {
            MDLFetcherNew mDLFetcherNew = this.mFetcherRef.get();
            if (mDLFetcherNew == null) {
                TTVideoEngineLog.i("MDLFetcherNew", "onStatusException but fetcher is null");
            } else {
                mDLFetcherNew.onError(new Error("kTTVideoErrorDomainMDLRetry", -10005, i, str), true);
            }
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onCompletion(VideoModel videoModel, Error error) {
            TTVideoEngineLog.i("MDLFetcherNew", "onCompletion model " + videoModel + ", error " + error);
            MDLFetcherNew mDLFetcherNew = this.mFetcherRef.get();
            if (mDLFetcherNew == null) {
                TTVideoEngineLog.i("MDLFetcherNew", "onCompletion but fetcher is null");
                return;
            }
            if (error == null) {
                if (videoModel != null) {
                    mDLFetcherNew.mNewUrls = mDLFetcherNew.getUrlsFromVideoModelByFileHash(videoModel, mDLFetcherNew.mFileHash);
                    TTVideoEngineLog.i("MDLFetcherNew", "onCompletion newUrls " + Arrays.toString(mDLFetcherNew.mNewUrls));
                    if (mDLFetcherNew.mNewUrls != null && mDLFetcherNew.mNewUrls.length != 0) {
                        if (MDLFetcherNew.isNewUrlsValid(mDLFetcherNew.mNewUrls, mDLFetcherNew.mOldUrl)) {
                            mDLFetcherNew.mListener.onCompletion(0, mDLFetcherNew.mVideoID, mDLFetcherNew.mFileHash, mDLFetcherNew.mNewUrls);
                            mDLFetcherNew.onCompletion(videoModel, true);
                            return;
                        } else {
                            mDLFetcherNew.onError(new Error("kTTVideoErrorDomainMDLRetry", -10004, "fetch videoModel is expired"), true);
                            return;
                        }
                    }
                    mDLFetcherNew.onError(new Error("kTTVideoErrorDomainMDLRetry", -10003, "file hash invalid"), true);
                    JSONObject mediaInfo = videoModel.getMediaInfo();
                    if (mediaInfo != null) {
                        TTVideoEngineLog.i("MDLFetcherNew", String.format("new video model: %s", mediaInfo.toString()));
                        return;
                    }
                    return;
                }
                mDLFetcherNew.onError(new Error("kTTVideoErrorDomainMDLRetry", -9997, "fetch empty"), true);
                return;
            }
            mDLFetcherNew.onError(error, true);
        }
    }

    public MDLFetcherNew(MDLFetcherListener mDLFetcherListener) {
        this.mMDLFetcherListener = new WeakReference<>(mDLFetcherListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompletion(VideoModel videoModel, boolean z) {
        MDLFetcherListener mDLFetcherListener = getMDLFetcherListener();
        if (mDLFetcherListener != null) {
            mDLFetcherListener.onCompletion(videoModel, z, this.mFileHash);
        }
        close();
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
                TTVideoEngineLog.d("MDLFetcherNew", "new urls is invalid");
                return false;
            }
        }
        return true;
    }

    private String[] getURLsFromCache(String str, String str2) {
        VideoModelCache.VideoModelCacheInfo videoModelCacheInfo = VideoModelCache.getInstance().get(this.mVideoID, str);
        if (videoModelCacheInfo != null && !videoModelCacheInfo.isExpired) {
            VideoModel videoModel = videoModelCacheInfo.model;
            this.mVideoModel = videoModel;
            String[] urlsFromVideoModelByFileHash = getUrlsFromVideoModelByFileHash(videoModel, this.mFileHash);
            if (urlsFromVideoModelByFileHash != null && urlsFromVideoModelByFileHash.length > 0) {
                if (!isNewUrlsValid(urlsFromVideoModelByFileHash, str2)) {
                    VideoModelCache.getInstance().remove(this.mVideoID, str);
                    TTVideoEngineLog.i("MDLFetcherNew", "getURLsFromCache urls is invalid");
                    return null;
                }
                TTVideoEngineLog.i("MDLFetcherNew", "getURLsFromCache " + Arrays.toString(urlsFromVideoModelByFileHash));
                return urlsFromVideoModelByFileHash;
            }
            TTVideoEngineLog.i("MDLFetcherNew", "getURLsFromCache temUrls is null");
            return null;
        }
        TTVideoEngineLog.i("MDLFetcherNew", "getURLsFromCache cacheInfo is null or isExpired");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] getUrlsFromVideoModelByFileHash(VideoModel videoModel, String str) {
        if (videoModel != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put(15, str);
            if (str.startsWith("fileid")) {
                try {
                    hashMap.put(28, str.substring(6));
                } catch (IndexOutOfBoundsException unused) {
                    TTVideoEngineLog.e("MDLFetcherNew", "fileid index out of bounds");
                }
            }
            VideoInfo videoInfo = videoModel.getVideoInfo(hashMap);
            if (videoInfo == null) {
                TTVideoEngineLog.i("MDLFetcherNew", "getUrlsFromVideoModelByFileHash videoInfo is null");
                return null;
            }
            String[] valueStrArr = videoInfo.getValueStrArr(16);
            TTVideoEngineLog.i("MDLFetcherNew", "getUrlsFromVideoModelByFileHash " + Arrays.toString(valueStrArr));
            return valueStrArr;
        }
        TTVideoEngineLog.i("MDLFetcherNew", "getUrlsFromVideoModelByFileHash videoModel is null or fileHash is empty " + str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Error error, boolean z) {
        VideoModel oldVideoModel;
        JSONObject mediaInfo;
        if (z) {
            this.mListener.onCompletion(error.code, this.mVideoID, this.mFileHash, (String[]) null);
        }
        MDLFetcherListener mDLFetcherListener = getMDLFetcherListener();
        if (mDLFetcherListener != null) {
            mDLFetcherListener.onError(error, this.mFileHash);
            if (error.code == -10003 && (oldVideoModel = mDLFetcherListener.getOldVideoModel()) != null && (mediaInfo = oldVideoModel.getMediaInfo()) != null) {
                TTVideoEngineLog.i("MDLFetcherNew", String.format("old video model: %s", mediaInfo.toString()));
            }
        }
        close();
    }

    public int start(String str, String str2, String str3, AVMDLURLFetcherListener aVMDLURLFetcherListener) {
        TTVideoEngineLog.i("MDLFetcherNew", "start rawKey " + str + ", fileKey " + str2 + ", olderUrl " + str3 + ", listener " + aVMDLURLFetcherListener);
        this.mVideoID = str;
        this.mFileHash = str2;
        this.mListener = aVMDLURLFetcherListener;
        this.mOldUrl = str3;
        MDLFetcherListener mDLFetcherListener = getMDLFetcherListener();
        boolean z = true;
        if (mDLFetcherListener == null) {
            TTVideoEngineLog.i("MDLFetcherNew", "start MDLFetcherListener is null return MDL_GET_URLS");
            onError(new Error("kTTVideoErrorDomainMDLRetry", -10001, "MDLFetcherListener is empty"), false);
            return 1;
        }
        String fallbackApi = mDLFetcherListener.getFallbackApi();
        if (TextUtils.isEmpty(fallbackApi)) {
            TTVideoEngineLog.i("MDLFetcherNew", "start fallbackApi is empty return MDL_GET_URLS");
            onError(new Error("kTTVideoErrorDomainMDLRetry", -10002, "fallbackApi is empty"), false);
            return 1;
        }
        String[] uRLsFromCache = getURLsFromCache(fallbackApi, str3);
        if (uRLsFromCache != null && uRLsFromCache.length > 0) {
            this.mNewUrls = uRLsFromCache;
            TTVideoEngineLog.i("MDLFetcherNew", "start return MDL_GET_URLS");
            onCompletion(this.mVideoModel, false);
            return 1;
        }
        Context context = mDLFetcherListener.getContext();
        VideoInfoFetcher videoInfoFetcher = new VideoInfoFetcher(context, null);
        this.mFetcher = videoInfoFetcher;
        if (context == null) {
            z = false;
        }
        videoInfoFetcher.setUseVideoModelCache(z);
        this.mFetcher.setVideoID(str);
        this.mFetcher.setListener(new MyFetcherListener(this));
        this.mFetcher.setUseFallbakApi(Boolean.TRUE);
        this.mFetcher.fetchInfo(fallbackApi, null, 0, null);
        TTVideoEngineLog.i("MDLFetcherNew", "start return CALLBACK_URLS_TO_MDL");
        return 0;
    }
}
