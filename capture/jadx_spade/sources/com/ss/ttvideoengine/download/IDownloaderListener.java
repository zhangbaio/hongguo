package com.ss.ttvideoengine.download;

import com.ss.ttvideoengine.utils.Error;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IDownloaderListener {

    /* renamed from: com.ss.ttvideoengine.download.IDownloaderListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$downloaderProgress(IDownloaderListener iDownloaderListener, Downloader downloader, DownloadTask downloadTask, long j, long j2) {
        }
    }

    void downloaderDidComplete(Downloader downloader, DownloadTask downloadTask, Error error);

    void downloaderDidLoadAllTask(Downloader downloader, List<DownloadTask> list, Error error);

    void downloaderDidResume(Downloader downloader, DownloadTask downloadTask, long j, long j2);

    void downloaderProgress(Downloader downloader, DownloadTask downloadTask, long j, long j2);

    void downloaderStateChanged(Downloader downloader, DownloadTask downloadTask, int i);

    void downloaderWriteData(Downloader downloader, DownloadTask downloadTask, long j, long j2);
}
