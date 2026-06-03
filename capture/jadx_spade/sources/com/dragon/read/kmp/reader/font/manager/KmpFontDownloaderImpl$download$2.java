package com.dragon.read.kmp.reader.font.manager;

import com.dragon.read.base.util.AppUtils;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.font.manager.KmpFontDownloaderImpl$download$2", f = "KmpFontDownloader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpFontDownloaderImpl$download$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ IDownloadListener $mainThreadListener;
    final /* synthetic */ String $name;
    final /* synthetic */ String $savePath;
    final /* synthetic */ IDownloadListener $subThreadListener;
    final /* synthetic */ String $url;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpFontDownloaderImpl$download$2(String str, String str2, String str3, IDownloadListener iDownloadListener, IDownloadListener iDownloadListener2, Continuation<? super KmpFontDownloaderImpl$download$2> continuation) {
        super(2, continuation);
        this.$url = str;
        this.$name = str2;
        this.$savePath = str3;
        this.$mainThreadListener = iDownloadListener;
        this.$subThreadListener = iDownloadListener2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpFontDownloaderImpl$download$2(this.$url, this.$name, this.$savePath, this.$mainThreadListener, this.$subThreadListener, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((KmpFontDownloaderImpl$download$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(Downloader.with(AppUtils.context()).url(this.$url).name(this.$name).savePath(this.$savePath).mainThreadListener(this.$mainThreadListener).subThreadListener(this.$subThreadListener).download());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
