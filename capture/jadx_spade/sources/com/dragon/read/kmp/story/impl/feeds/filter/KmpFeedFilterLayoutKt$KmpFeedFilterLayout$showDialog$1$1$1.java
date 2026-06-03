package com.dragon.read.kmp.story.impl.feeds.filter;

import androidx.compose.foundation.lazy.grid.LazyGridState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.filter.KmpFeedFilterLayoutKt$KmpFeedFilterLayout$showDialog$1$1$1", f = "KmpFeedFilterLayout.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpFeedFilterLayoutKt$KmpFeedFilterLayout$showDialog$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.dragon.read.kmp.service.g $controller;
    final /* synthetic */ LazyGridState $lazyGridState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpFeedFilterLayoutKt$KmpFeedFilterLayout$showDialog$1$1$1(com.dragon.read.kmp.service.g gVar, LazyGridState lazyGridState, Continuation<? super KmpFeedFilterLayoutKt$KmpFeedFilterLayout$showDialog$1$1$1> continuation) {
        super(2, continuation);
        this.$controller = gVar;
        this.$lazyGridState = lazyGridState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpFeedFilterLayoutKt$KmpFeedFilterLayout$showDialog$1$1$1(this.$controller, this.$lazyGridState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpFeedFilterLayoutKt$KmpFeedFilterLayout$showDialog$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$controller.c(this.$lazyGridState);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
