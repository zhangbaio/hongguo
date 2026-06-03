package com.dragon.read.kmp.reader.bookcover.epub;

import androidx.compose.material.n2;
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

@DebugMetadata(c = "com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1", f = "BookCoverSheetContent.kt", i = {}, l = {61, 65}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookCoverSheetContentKt$BookCoverSheetContent$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ n2 $sheetState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookCoverSheetContentKt$BookCoverSheetContent$2$1(Function0<Unit> function0, n2 n2Var, Continuation<? super BookCoverSheetContentKt$BookCoverSheetContent$2$1> continuation) {
        super(2, continuation);
        this.$onDismiss = function0;
        this.$sheetState = n2Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookCoverSheetContentKt$BookCoverSheetContent$2$1(this.$onDismiss, this.$sheetState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookCoverSheetContentKt$BookCoverSheetContent$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    this.$onDismiss.invoke();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            final n2 n2Var = this.$sheetState;
            final Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.reader.bookcover.epub.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean m;
                    m = n2Var.m();
                    return Boolean.valueOf(m);
                }
            });
            Flow<Boolean> flow = new Flow<Boolean>() { // from class: com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }

                /* renamed from: com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector a;

                    @DebugMetadata(c = "com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$1$2", f = "BookCoverSheetContent.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    /* renamed from: com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        Object L$1;
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

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.a = flowCollector;
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
                            boolean r0 = r6 instanceof com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L48
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            kotlin.ResultKt.throwOnFailure(r6)
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.a
                            r2 = r5
                            java.lang.Boolean r2 = (java.lang.Boolean) r2
                            boolean r2 = r2.booleanValue()
                            if (r2 == 0) goto L48
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L48
                            return r1
                        L48:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            };
            this.label = 1;
            if (FlowKt.first(flow, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        final n2 n2Var2 = this.$sheetState;
        final Flow snapshotFlow2 = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.reader.bookcover.epub.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean m;
                m = n2Var2.m();
                return Boolean.valueOf(m);
            }
        });
        Flow<Boolean> flow2 = new Flow<Boolean>() { // from class: com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$2
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                Object coroutine_suspended2;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended2) {
                    return collect;
                }
                return Unit.INSTANCE;
            }

            /* renamed from: com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$2$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector a;

                @DebugMetadata(c = "com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$2$2", f = "BookCoverSheetContent.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$2$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.a = flowCollector;
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
                        boolean r0 = r6 instanceof com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$2$2$1 r0 = (com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$2$2$1 r0 = new com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$2$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.a
                        r2 = r5
                        java.lang.Boolean r2 = (java.lang.Boolean) r2
                        boolean r2 = r2.booleanValue()
                        r2 = r2 ^ r3
                        if (r2 == 0) goto L49
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt$BookCoverSheetContent$2$1$invokeSuspend$$inlined$filter$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
        this.label = 2;
        if (FlowKt.first(flow2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.$onDismiss.invoke();
        return Unit.INSTANCE;
    }
}
