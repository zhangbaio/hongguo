package com.dragon.read.kmp.reader.download;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.EpubImageDownloadHelper$isImageDownloaded$2", f = "EpubImageDownloadHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class EpubImageDownloadHelper$isImageDownloaded$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $bookId;
    final /* synthetic */ String $url;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EpubImageDownloadHelper$isImageDownloaded$2(String str, String str2, Continuation<? super EpubImageDownloadHelper$isImageDownloaded$2> continuation) {
        super(2, continuation);
        this.$url = str;
        this.$bookId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EpubImageDownloadHelper$isImageDownloaded$2(this.$url, this.$bookId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((EpubImageDownloadHelper$isImageDownloaded$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            wf4.f a = wf4.f.b.a(this.$url);
            String str = EpubImageDownloadHelper.a.f(this.$bookId) + "/image";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append('/');
            String a2 = a.a();
            if (a2 != null) {
                i = a2.hashCode();
            } else {
                i = 0;
            }
            sb.append(i);
            rn0.c cVar = new rn0.c(sb.toString());
            boolean exists = cVar.exists();
            EpubImageDownloadHelper.c.a("check file exists : " + exists + ", bookId: " + this.$bookId + ", dirName; " + str + ", " + cVar.getPath() + ", url: " + this.$url + ", lastPathSegment: " + a.a());
            return Boxing.boxBoolean(exists);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
