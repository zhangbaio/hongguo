package com.dragon.read.kmp.story.impl.feeds.page.view;

import com.bytedance.kmp.ugc.model.d6;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.page.view.ContentEndAuthorPageViewKt$ContentAuthorPageView$1$1$1$1$1", f = "ContentEndAuthorPageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ContentEndAuthorPageViewKt$ContentAuthorPageView$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d6 $it;
    final /* synthetic */ kp4.b $story;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContentEndAuthorPageViewKt$ContentAuthorPageView$1$1$1$1$1(kp4.b bVar, d6 d6Var, Continuation<? super ContentEndAuthorPageViewKt$ContentAuthorPageView$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$story = bVar;
        this.$it = d6Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ContentEndAuthorPageViewKt$ContentAuthorPageView$1$1$1$1$1(this.$story, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ContentEndAuthorPageViewKt$ContentAuthorPageView$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$story.f.a.o(null, this.$it);
            this.$story.f.a.e(this.$it);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
