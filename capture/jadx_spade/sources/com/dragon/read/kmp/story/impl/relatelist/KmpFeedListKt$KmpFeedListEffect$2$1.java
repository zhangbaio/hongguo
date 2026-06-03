package com.dragon.read.kmp.story.impl.relatelist;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.relatelist.KmpFeedListKt$KmpFeedListEffect$2$1", f = "KmpFeedList.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpFeedListKt$KmpFeedListEffect$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.dragon.read.kmp.story.impl.relatelist.a $depend;
    final /* synthetic */ LazyListState $listState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpFeedListKt$KmpFeedListEffect$2$1(LazyListState lazyListState, com.dragon.read.kmp.story.impl.relatelist.a aVar, Continuation<? super KmpFeedListKt$KmpFeedListEffect$2$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpFeedListKt$KmpFeedListEffect$2$1(this.$listState, null, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpFeedListKt$KmpFeedListEffect$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            final LazyListState lazyListState = this.$listState;
            final Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.story.impl.relatelist.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    int v;
                    v = lazyListState.v();
                    return Integer.valueOf(v);
                }
            });
            final LazyListState lazyListState2 = this.$listState;
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: com.dragon.read.kmp.story.impl.relatelist.KmpFeedListKt$KmpFeedListEffect$2$1$invokeSuspend$$inlined$map$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, lazyListState2), continuation);
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }

                /* renamed from: com.dragon.read.kmp.story.impl.relatelist.KmpFeedListKt$KmpFeedListEffect$2$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector a;
                    final /* synthetic */ LazyListState b;

                    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.relatelist.KmpFeedListKt$KmpFeedListEffect$2$1$invokeSuspend$$inlined$map$1$2", f = "KmpFeedList.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    /* renamed from: com.dragon.read.kmp.story.impl.relatelist.KmpFeedListKt$KmpFeedListEffect$2$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, LazyListState lazyListState) {
                        this.a = flowCollector;
                        this.b = lazyListState;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof com.dragon.read.kmp.story.impl.relatelist.KmpFeedListKt$KmpFeedListEffect$2$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.dragon.read.kmp.story.impl.relatelist.KmpFeedListKt$KmpFeedListEffect$2$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.dragon.read.kmp.story.impl.relatelist.KmpFeedListKt$KmpFeedListEffect$2$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.dragon.read.kmp.story.impl.relatelist.KmpFeedListKt$KmpFeedListEffect$2$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.dragon.read.kmp.story.impl.relatelist.KmpFeedListKt$KmpFeedListEffect$2$1$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L56
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            kotlin.ResultKt.throwOnFailure(r6)
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.a
                            java.lang.Number r5 = (java.lang.Number) r5
                            int r5 = r5.intValue()
                            androidx.compose.foundation.lazy.LazyListState r2 = r4.b
                            int r2 = r2.u()
                            if (r2 != 0) goto L48
                            if (r5 > r3) goto L48
                            r5 = 1
                            goto L49
                        L48:
                            r5 = 0
                        L49:
                            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L56
                            return r1
                        L56:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.relatelist.KmpFeedListKt$KmpFeedListEffect$2$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            });
            a aVar = new a(null);
            this.label = 1;
            if (distinctUntilChanged.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        a(com.dragon.read.kmp.story.impl.relatelist.a aVar) {
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Boolean) obj).booleanValue(), continuation);
        }
    }
}
