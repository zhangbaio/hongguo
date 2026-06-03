package com.dragon.read.kmp.reader.detail;

import androidx.compose.runtime.State;
import com.bytedance.kmp.ugc.model.xy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.BookDetailPageKt$BookDetailPage$8$1", f = "BookDetailPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailPageKt$BookDetailPage$8$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d $args;
    final /* synthetic */ p2 $detailReporter;
    final /* synthetic */ State<n2> $state$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailPageKt$BookDetailPage$8$1(State<n2> state, p2 p2Var, d dVar, Continuation<? super BookDetailPageKt$BookDetailPage$8$1> continuation) {
        super(2, continuation);
        this.$state$delegate = state;
        this.$detailReporter = p2Var;
        this.$args = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookDetailPageKt$BookDetailPage$8$1(this.$state$delegate, this.$detailReporter, this.$args, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookDetailPageKt$BookDetailPage$8$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        n2 l;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            l = BookDetailPageKt.l(this.$state$delegate);
            xy xyVar = l.j;
            if (xyVar != null) {
                this.$detailReporter.l(this.$args.a, xyVar.g, "page");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
