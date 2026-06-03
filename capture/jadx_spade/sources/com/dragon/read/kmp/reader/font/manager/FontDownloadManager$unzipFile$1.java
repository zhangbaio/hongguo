package com.dragon.read.kmp.reader.font.manager;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.font.manager.FontDownloadManager$unzipFile$1", f = "FontDownloadManager.kt", i = {}, l = {209}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class FontDownloadManager$unzipFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadInfo $downloadInfo;
    final /* synthetic */ String $saveFileName;
    final /* synthetic */ String $sourceFilePath;
    final /* synthetic */ String $targetDir;
    final /* synthetic */ String $url;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontDownloadManager$unzipFile$1(String str, String str2, DownloadInfo downloadInfo, String str3, String str4, Continuation<? super FontDownloadManager$unzipFile$1> continuation) {
        super(2, continuation);
        this.$targetDir = str;
        this.$sourceFilePath = str2;
        this.$downloadInfo = downloadInfo;
        this.$saveFileName = str3;
        this.$url = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FontDownloadManager$unzipFile$1(this.$targetDir, this.$sourceFilePath, this.$downloadInfo, this.$saveFileName, this.$url, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FontDownloadManager$unzipFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        com.dragon.read.kmp.i iVar;
        StringBuilder sb;
        Object t;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                FontDownloadManager fontDownloadManager = FontDownloadManager.a;
                String str = this.$targetDir;
                String str2 = this.$sourceFilePath;
                this.label = 1;
                t = fontDownloadManager.t(str, str2, this);
                if (t == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            f.d.a().b(this.$downloadInfo, this.$saveFileName);
            FontDownloadManager.e.remove(this.$url);
            iVar = FontDownloadManager.b;
            sb = new StringBuilder();
        } catch (Throwable th) {
            try {
                f.d.a().a(this.$downloadInfo, th);
                FontDownloadManager.e.remove(this.$url);
                iVar = FontDownloadManager.b;
                sb = new StringBuilder();
            } catch (Throwable th2) {
                FontDownloadManager.e.remove(this.$url);
                FontDownloadManager.b.a("downloadingTask remove: " + this.$url);
                throw th2;
            }
        }
        sb.append("downloadingTask remove: ");
        sb.append(this.$url);
        iVar.a(sb.toString());
        return Unit.INSTANCE;
    }
}
