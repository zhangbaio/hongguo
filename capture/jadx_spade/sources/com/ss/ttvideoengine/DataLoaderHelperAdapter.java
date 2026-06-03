package com.ss.ttvideoengine;

import com.bytedance.covode.number.Covode;
import com.ss.mediakit.medialoader.AVMDLDataLoaderNotifyInfo;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DataLoaderHelperAdapter {
    static {
        Covode.recordClassIndex(652271);
    }

    public static class HlsProxyQueryParam {
        public boolean enableInfoCallback;
        public String id;
        public String[] urlExpires;

        static {
            Covode.recordClassIndex(652272);
        }

        public String buildQuery() {
            throw new UnsupportedOperationException("hp only");
        }
    }

    public void cancelAll() {
        throw new UnsupportedOperationException("hp only");
    }

    public long getAllCacheSize() {
        throw new UnsupportedOperationException("hp only");
    }

    public void initHLSCacheModule() {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean isHlsProxyValid() {
        throw new UnsupportedOperationException("hp only");
    }

    public void onMDLStartComplete() {
        throw new UnsupportedOperationException("hp only");
    }

    public void removeAllHLSCache() {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean cancelDownload(String str) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean cancelPreload(String str) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean convertHLSProxyUrl(StringBuffer stringBuffer) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean downloadHlsSource(String str) {
        throw new UnsupportedOperationException("hp only");
    }

    public long getCacheSize(String str) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean onDownloadCompleted(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean onDownloadFail(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean onDownloadProgress(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean onLoaderCancel(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean onLoaderFail(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean onLoaderOpen(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean onLoaderProgress(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean removeCache(String str) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean removeCacheFile(String str) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean removeDownloadFile(String str) {
        throw new UnsupportedOperationException("hp only");
    }

    public void setEnablePreloadAllTs(int i) {
        throw new UnsupportedOperationException("hp only");
    }

    public void setEnablePreloadFirstTs(int i) {
        throw new UnsupportedOperationException("hp only");
    }

    public void setHLSCacheDir(String str) {
        throw new UnsupportedOperationException("hp only");
    }

    public void setHLSDownloadDir(String str) {
        throw new UnsupportedOperationException("hp only");
    }

    public boolean preloadHLSSource(String str, long j) {
        throw new UnsupportedOperationException("hp only");
    }
}
