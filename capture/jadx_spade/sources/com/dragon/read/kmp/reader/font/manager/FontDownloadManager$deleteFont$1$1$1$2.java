package com.dragon.read.kmp.reader.font.manager;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$DoubleRef;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.font.manager.FontDownloadManager$deleteFont$1$1$1$2", f = "FontDownloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class FontDownloadManager$deleteFont$1$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fileName;
    final /* synthetic */ Ref$DoubleRef $releasedSpaceMB;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontDownloadManager$deleteFont$1$1$1$2(String str, Ref$DoubleRef ref$DoubleRef, Continuation<? super FontDownloadManager$deleteFont$1$1$1$2> continuation) {
        super(2, continuation);
        this.$fileName = str;
        this.$releasedSpaceMB = ref$DoubleRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FontDownloadManager$deleteFont$1$1$1$2(this.$fileName, this.$releasedSpaceMB, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FontDownloadManager$deleteFont$1$1$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            d.c.a().a(this.$fileName, this.$releasedSpaceMB.element, "");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
