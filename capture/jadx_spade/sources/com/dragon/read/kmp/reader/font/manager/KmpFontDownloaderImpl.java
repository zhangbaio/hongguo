package com.dragon.read.kmp.reader.font.manager;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.AppUtils;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpFontDownloaderImpl implements i {
    public static final KmpFontDownloaderImpl a;

    static {
        Covode.recordClassIndex(608451);
        a = new KmpFontDownloaderImpl();
    }

    private KmpFontDownloaderImpl() {
    }

    @Override // com.dragon.read.kmp.reader.font.manager.i
    public void a(int i) {
        Downloader.getInstance(AppUtils.context()).resume(i);
    }

    @Override // com.dragon.read.kmp.reader.font.manager.i
    public DownloadInfo b(int i) {
        return Downloader.getInstance(AppUtils.context()).getDownloadInfo(i);
    }

    @Override // com.dragon.read.kmp.reader.font.manager.i
    public Object c(String str, String str2, String str3, IDownloadListener iDownloadListener, IDownloadListener iDownloadListener2, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new KmpFontDownloaderImpl$download$2(str, str3, str2, iDownloadListener, iDownloadListener2, null), continuation);
    }
}
