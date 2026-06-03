package com.dragon.read.kmp.search.searchlinkpage;

import androidx.compose.runtime.State;
import com.dragon.read.kmp.service.l0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;

@DebugMetadata(c = "com.dragon.read.kmp.search.searchlinkpage.SearchLinkDialogViewKmpKt$SearchLinkDialogViewKmp$1$1", f = "SearchLinkDialogViewKmp.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SearchLinkDialogViewKmpKt$SearchLinkDialogViewKmp$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<d> $dataState$delegate;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchLinkDialogViewKmpKt$SearchLinkDialogViewKmp$1$1(State<d> state, Continuation<? super SearchLinkDialogViewKmpKt$SearchLinkDialogViewKmp$1$1> continuation) {
        super(2, continuation);
        this.$dataState$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SearchLinkDialogViewKmpKt$SearchLinkDialogViewKmp$1$1 searchLinkDialogViewKmpKt$SearchLinkDialogViewKmp$1$1 = new SearchLinkDialogViewKmpKt$SearchLinkDialogViewKmp$1$1(this.$dataState$delegate, continuation);
        searchLinkDialogViewKmpKt$SearchLinkDialogViewKmp$1$1.L$0 = obj;
        return searchLinkDialogViewKmpKt$SearchLinkDialogViewKmp$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchLinkDialogViewKmpKt$SearchLinkDialogViewKmp$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            kotlinx.coroutines.i.e((CoroutineScope) this.L$0, Dispatchers.getIO(), null, new AnonymousClass1(this.$dataState$delegate, null), 2, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @DebugMetadata(c = "com.dragon.read.kmp.search.searchlinkpage.SearchLinkDialogViewKmpKt$SearchLinkDialogViewKmp$1$1$1", f = "SearchLinkDialogViewKmp.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.search.searchlinkpage.SearchLinkDialogViewKmpKt$SearchLinkDialogViewKmp$1$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ State<d> $dataState$delegate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State<d> state, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$dataState$delegate = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$dataState$delegate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Boolean value;
            Boolean value2;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                for (d0 d0Var : SearchLinkDialogViewKmpKt.W(this.$dataState$delegate).a) {
                    if (d0Var instanceof a) {
                        String a = ((a) d0Var).a();
                        MutableStateFlow<Boolean> mutableStateFlow = d0Var.b;
                        do {
                            value = mutableStateFlow.getValue();
                            value.booleanValue();
                        } while (!mutableStateFlow.compareAndSet(value, Boxing.boxBoolean(l0.a.F0(com.dragon.read.kmp.service.c0.a.getUserId(), a, 0))));
                    } else if (d0Var instanceof f0) {
                        String a2 = ((f0) d0Var).a();
                        MutableStateFlow<Boolean> mutableStateFlow2 = d0Var.b;
                        do {
                            value2 = mutableStateFlow2.getValue();
                            value2.booleanValue();
                        } while (!mutableStateFlow2.compareAndSet(value2, Boxing.boxBoolean(l0.a.F0(com.dragon.read.kmp.service.c0.a.getUserId(), a2, 2))));
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
