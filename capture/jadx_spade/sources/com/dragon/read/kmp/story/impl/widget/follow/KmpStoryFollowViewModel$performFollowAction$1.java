package com.dragon.read.kmp.story.impl.widget.follow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.widget.follow.KmpStoryFollowViewModel$performFollowAction$1", f = "KmpStoryFollowViewModel.kt", i = {0}, l = {103}, m = "invokeSuspend", n = {"follow"}, s = {"I$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryFollowViewModel$performFollowAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ KmpStoryFollowViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryFollowViewModel$performFollowAction$1(KmpStoryFollowViewModel kmpStoryFollowViewModel, Continuation<? super KmpStoryFollowViewModel$performFollowAction$1> continuation) {
        super(2, continuation);
        this.this$0 = kmpStoryFollowViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpStoryFollowViewModel$performFollowAction$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpStoryFollowViewModel$performFollowAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0069  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.widget.follow.KmpStoryFollowViewModel$performFollowAction$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
