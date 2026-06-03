package com.dragon.read.kmp.mine.preference.widget;

import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState;
import com.dragon.read.kmp.compose.common.list.ScrollableListState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.mine.preference.widget.WatchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1$1$1$1", f = "WatchPreferencePinLayout.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class WatchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CollapsibleListState $collapsingState;
    final /* synthetic */ int $index;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WatchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1$1$1$1(CollapsibleListState collapsibleListState, int i, Continuation<? super WatchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$collapsingState = collapsibleListState;
        this.$index = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1$1$1$1 watchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1$1$1$1 = new WatchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1$1$1$1(this.$collapsingState, this.$index, continuation);
        watchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1$1$1$1.L$0 = obj;
        return watchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.mine.preference.widget.WatchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1$1$1$1$1", f = "WatchPreferencePinLayout.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.mine.preference.widget.WatchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1$1$1$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CollapsibleListState $collapsingState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CollapsibleListState collapsibleListState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$collapsingState = collapsibleListState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$collapsingState, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                if (!this.$collapsingState.p()) {
                    CollapsibleListState collapsibleListState = this.$collapsingState;
                    this.label = 1;
                    if (collapsibleListState.e(200, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.dragon.read.kmp.mine.preference.widget.WatchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1$1$1$1$2", f = "WatchPreferencePinLayout.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.mine.preference.widget.WatchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1$1$1$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CollapsibleListState $collapsingState;
        final /* synthetic */ int $index;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(CollapsibleListState collapsibleListState, int i, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$collapsingState = collapsibleListState;
            this.$index = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$collapsingState, this.$index, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                ScrollableListState k = this.$collapsingState.k();
                int i2 = this.$index;
                this.label = 1;
                if (ScrollableListState.b(k, i2, 0, this, 2, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            kotlinx.coroutines.i.e(coroutineScope, null, null, new AnonymousClass1(this.$collapsingState, null), 3, null);
            kotlinx.coroutines.i.e(coroutineScope, null, null, new AnonymousClass2(this.$collapsingState, this.$index, null), 3, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
