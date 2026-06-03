package com.dragon.read.kmp.reader.font.manager;

import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.coroutines.Continuation;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface i {
    void a(int i);

    DownloadInfo b(int i);

    Object c(String str, String str2, String str3, IDownloadListener iDownloadListener, IDownloadListener iDownloadListener2, Continuation<? super Integer> continuation);
}
