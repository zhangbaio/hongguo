package com.dragon.read.kmp.reader.ui;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.ui.HotLineDialogKt$HotLineDialog$1$1", f = "HotLineDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class HotLineDialogKt$HotLineDialog$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n $param;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HotLineDialogKt$HotLineDialog$1$1(n nVar, Continuation<? super HotLineDialogKt$HotLineDialog$1$1> continuation) {
        super(2, continuation);
        this.$param = nVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HotLineDialogKt$HotLineDialog$1$1(this.$param, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HotLineDialogKt$HotLineDialog$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            dm4.j reporterDepend = xf4.d.o3.a().reporterDepend();
            if (reporterDepend != null) {
                reporterDepend.a("show_quote_bookcard", new ym4.a().g("book_id", this.$param.a.a).g("hot_line_id", String.valueOf(this.$param.a.b)).g("quote_item_id", String.valueOf(this.$param.a.c)).g("module_name", "reader").g("page_name", "reader"));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
