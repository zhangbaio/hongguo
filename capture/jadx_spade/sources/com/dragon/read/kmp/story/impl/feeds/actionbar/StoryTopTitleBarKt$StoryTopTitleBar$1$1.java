package com.dragon.read.kmp.story.impl.feeds.actionbar;

import androidx.compose.runtime.State;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.actionbar.StoryTopTitleBarKt$StoryTopTitleBar$1$1", f = "StoryTopTitleBar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryTopTitleBarKt$StoryTopTitleBar$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Boolean> $canShowTitle$delegate;
    final /* synthetic */ Lazy<tp4.b> $log$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryTopTitleBarKt$StoryTopTitleBar$1$1(Lazy<tp4.b> lazy, State<Boolean> state, Continuation<? super StoryTopTitleBarKt$StoryTopTitleBar$1$1> continuation) {
        super(2, continuation);
        this.$log$delegate = lazy;
        this.$canShowTitle$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryTopTitleBarKt$StoryTopTitleBar$1$1(this.$log$delegate, this.$canShowTitle$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryTopTitleBarKt$StoryTopTitleBar$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        tp4.b k;
        boolean n;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            k = StoryTopTitleBarKt.k(this.$log$delegate);
            StringBuilder sb = new StringBuilder();
            sb.append("canShowTitle: ");
            n = StoryTopTitleBarKt.n(this.$canShowTitle$delegate);
            sb.append(n);
            k.a(sb.toString());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
