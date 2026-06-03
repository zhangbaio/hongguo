package com.dragon.read.kmp.service;

import androidx.compose.foundation.gestures.s2;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@DebugMetadata(c = "com.dragon.read.kmp.service.KmpDialogServiceKt$handleNestScroll$2$1", f = "KmpDialogService.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpDialogServiceKt$handleNestScroll$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ s2 $scrollableState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpDialogServiceKt$handleNestScroll$2$1(s2 s2Var, String str, Continuation<? super KmpDialogServiceKt$handleNestScroll$2$1> continuation) {
        super(2, continuation);
        this.$scrollableState = s2Var;
        this.$key = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpDialogServiceKt$handleNestScroll$2$1(this.$scrollableState, this.$key, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpDialogServiceKt$handleNestScroll$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0(s2 s2Var) {
        return !s2Var.e();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            final s2 s2Var = this.$scrollableState;
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.service.q0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = KmpDialogServiceKt$handleNestScroll$2$1.invokeSuspend$lambda$0(s2Var);
                    return Boolean.valueOf(invokeSuspend$lambda$0);
                }
            }));
            a aVar = new a(this.$key);
            this.label = 1;
            if (distinctUntilChanged.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            r0.a(this.a, z);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Boolean) obj).booleanValue(), continuation);
        }
    }
}
