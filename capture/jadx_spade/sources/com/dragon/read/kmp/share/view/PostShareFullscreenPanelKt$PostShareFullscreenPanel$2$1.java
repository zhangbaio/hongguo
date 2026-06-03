package com.dragon.read.kmp.share.view;

import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@DebugMetadata(c = "com.dragon.read.kmp.share.view.PostShareFullscreenPanelKt$PostShareFullscreenPanel$2$1", f = "PostShareFullscreenPanel.kt", i = {0}, l = {68}, m = "invokeSuspend", n = {"dismissAction"}, s = {"L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class PostShareFullscreenPanelKt$PostShareFullscreenPanel$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $exitDurationMills;
    final /* synthetic */ MutableState<Function0<Unit>> $pendingDismissAction$delegate;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PostShareFullscreenPanelKt$PostShareFullscreenPanel$2$1(long j, MutableState<Function0<Unit>> mutableState, Continuation<? super PostShareFullscreenPanelKt$PostShareFullscreenPanel$2$1> continuation) {
        super(2, continuation);
        this.$exitDurationMills = j;
        this.$pendingDismissAction$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PostShareFullscreenPanelKt$PostShareFullscreenPanel$2$1(this.$exitDurationMills, this.$pendingDismissAction$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PostShareFullscreenPanelKt$PostShareFullscreenPanel$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Function0 k;
        Function0 function0;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                function0 = (Function0) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            k = PostShareFullscreenPanelKt.k(this.$pendingDismissAction$delegate);
            if (k == null) {
                return Unit.INSTANCE;
            }
            long j = this.$exitDurationMills;
            this.L$0 = k;
            this.label = 1;
            if (DelayKt.delay(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            function0 = k;
        }
        function0.invoke();
        PostShareFullscreenPanelKt.l(this.$pendingDismissAction$delegate, null);
        return Unit.INSTANCE;
    }
}
