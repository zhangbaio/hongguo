package com.dragon.read.kmp.widget;

import com.bytedance.kmp.reading.model.e90;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.widget.TagListViewKt$KmpTagListView$2$2$1$8$1", f = "TagListView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class TagListViewKt$KmpTagListView$2$2$1$8$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e90 $info;
    final /* synthetic */ Function1<e90, Unit> $onTagShow;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TagListViewKt$KmpTagListView$2$2$1$8$1(Function1<? super e90, Unit> function1, e90 e90Var, Continuation<? super TagListViewKt$KmpTagListView$2$2$1$8$1> continuation) {
        super(2, continuation);
        this.$onTagShow = function1;
        this.$info = e90Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TagListViewKt$KmpTagListView$2$2$1$8$1(this.$onTagShow, this.$info, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TagListViewKt$KmpTagListView$2$2$1$8$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<e90, Unit> function1 = this.$onTagShow;
            if (function1 != null) {
                function1.invoke(this.$info);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
