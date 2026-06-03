package com.dragon.read.kmp.reader.font.manager;

import com.dragon.read.kmp.reader.font.manager.f;
import com.dragon.read.kmp.reader.services.x;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.font.manager.FontDownloadManager$download$2", f = "FontDownloadManager.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class FontDownloadManager$download$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IDownloadListener $downloadListener;
    final /* synthetic */ String $fontFamily;
    final /* synthetic */ String $url;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontDownloadManager$download$2(String str, IDownloadListener iDownloadListener, String str2, Continuation<? super FontDownloadManager$download$2> continuation) {
        super(2, continuation);
        this.$url = str;
        this.$downloadListener = iDownloadListener;
        this.$fontFamily = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FontDownloadManager$download$2(this.$url, this.$downloadListener, this.$fontFamily, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FontDownloadManager$download$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public static final class a extends AbsDownloadListener {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        public void onSuccessed(DownloadInfo downloadInfo) {
            String n;
            Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
            super.onSuccessed(downloadInfo);
            FontDownloadManager fontDownloadManager = FontDownloadManager.a;
            String p = fontDownloadManager.p(this.a);
            n = fontDownloadManager.n();
            fontDownloadManager.u(n, p, this.b, downloadInfo);
        }

        public void onProgress(DownloadInfo downloadInfo) {
            Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
            super.onProgress(downloadInfo);
            int downloadProcess = downloadInfo.getDownloadProcess();
            if (downloadProcess % 10 == 0) {
                FontDownloadManager.b.d("下载进度, " + this.b + ": " + downloadProcess);
            }
        }

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void onFailed(DownloadInfo downloadInfo, BaseException e) {
            Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
            Intrinsics.checkNotNullParameter(e, "e");
            super.onFailed(downloadInfo, e);
            if (x.a.g().isNetworkAvailable()) {
                String url = downloadInfo.getUrl();
                if (url != null) {
                    FontDownloadManager.e.remove(url);
                    FontDownloadManager.b.a("downloadingTask remove: " + url);
                    return;
                }
                return;
            }
            com.dragon.read.kmp.i.c(FontDownloadManager.b, "网络断开，暂不清理任务", (Throwable) null, 2, (Object) null);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean z;
        String n;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            String str = this.$url;
            boolean z2 = false;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                f.d.a().a(new DownloadInfo(), new IllegalStateException("下载url是空的"));
                return Unit.INSTANCE;
            }
            FontDownloadManager fontDownloadManager = FontDownloadManager.a;
            n = fontDownloadManager.n();
            if (n.length() == 0) {
                z2 = true;
            }
            if (z2) {
                f.d.a().a(new DownloadInfo(), new IllegalStateException("下载目录是空的"));
                return Unit.INSTANCE;
            }
            f.a aVar = f.d;
            aVar.a().e(this.$url, this.$downloadListener);
            if (fontDownloadManager.s(this.$url)) {
                com.dragon.read.kmp.i.c(FontDownloadManager.b, "下载任务进行中，url=" + this.$url, (Throwable) null, 2, (Object) null);
                return Unit.INSTANCE;
            }
            String str2 = this.$fontFamily + ".zip";
            i iVar = FontDownloadManager.d;
            if (iVar != null) {
                String str3 = this.$url;
                f a2 = aVar.a();
                a aVar2 = new a(str2, this.$fontFamily);
                this.label = 1;
                obj = iVar.c(str3, n, str2, a2, aVar2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        Integer num = (Integer) obj;
        if (num != null) {
            int intValue = num.intValue();
            FontDownloadManager.e.put(this.$url, Boxing.boxInt(intValue));
            FontDownloadManager.b.a("downloadingTask put: " + this.$fontFamily + ", taskId=" + intValue);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
