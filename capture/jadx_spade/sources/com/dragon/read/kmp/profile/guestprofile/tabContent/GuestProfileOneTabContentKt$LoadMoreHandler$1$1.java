package com.dragon.read.kmp.profile.guestprofile.tabContent;

import androidx.compose.runtime.SnapshotStateKt;
import com.dragon.read.kmp.compose.common.list.ScrollableListState;
import com.dragon.read.kmp.profile.guestprofile.tabContent.data.FootLoadingState;
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

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt$LoadMoreHandler$1$1", f = "GuestProfileOneTabContent.kt", i = {}, l = {457}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class GuestProfileOneTabContentKt$LoadMoreHandler$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ScrollableListState $scrollListState;
    final /* synthetic */ tl4.l $tabViewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GuestProfileOneTabContentKt$LoadMoreHandler$1$1(ScrollableListState scrollableListState, tl4.l lVar, Continuation<? super GuestProfileOneTabContentKt$LoadMoreHandler$1$1> continuation) {
        super(2, continuation);
        this.$scrollListState = scrollableListState;
        this.$tabViewModel = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GuestProfileOneTabContentKt$LoadMoreHandler$1$1(this.$scrollListState, this.$tabViewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GuestProfileOneTabContentKt$LoadMoreHandler$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            final ScrollableListState scrollableListState = this.$scrollListState;
            final Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.w
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Integer e;
                    e = scrollableListState.e();
                    return e;
                }
            });
            final ScrollableListState scrollableListState2 = this.$scrollListState;
            final tl4.l lVar = this.$tabViewModel;
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt$LoadMoreHandler$1$1$invokeSuspend$$inlined$map$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, scrollableListState2, lVar), continuation);
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }

                /* renamed from: com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt$LoadMoreHandler$1$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector a;
                    final /* synthetic */ ScrollableListState b;
                    final /* synthetic */ tl4.l c;

                    @DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt$LoadMoreHandler$1$1$invokeSuspend$$inlined$map$1$2", f = "GuestProfileOneTabContent.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    /* renamed from: com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt$LoadMoreHandler$1$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
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

                    public AnonymousClass2(FlowCollector flowCollector, ScrollableListState scrollableListState, tl4.l lVar) {
                        this.a = flowCollector;
                        this.b = scrollableListState;
                        this.c = lVar;
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
                            boolean r0 = r6 instanceof com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt$LoadMoreHandler$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt$LoadMoreHandler$1$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt$LoadMoreHandler$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt$LoadMoreHandler$1$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt$LoadMoreHandler$1$1$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L78
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            kotlin.ResultKt.throwOnFailure(r6)
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.a
                            java.lang.Integer r5 = (java.lang.Integer) r5
                            com.dragon.read.kmp.compose.common.list.ScrollableListState r2 = r4.b
                            int r2 = r2.g()
                            if (r5 == 0) goto L6a
                            if (r2 <= r3) goto L6a
                            int r5 = r5.intValue()
                            int r2 = r2 + (-2)
                            if (r5 < r2) goto L6a
                            tl4.l r5 = r4.c
                            androidx.compose.runtime.MutableState<ql4.a> r5 = r5.g
                            java.lang.Object r5 = r5.getValue()
                            ql4.a r5 = (ql4.a) r5
                            boolean r5 = ql4.b.a(r5)
                            if (r5 == 0) goto L6a
                            tl4.l r5 = r4.c
                            com.dragon.read.kmp.profile.guestprofile.tabContent.b0 r5 = r5.h
                            androidx.compose.runtime.State<com.dragon.read.kmp.profile.guestprofile.tabContent.data.FootLoadingState> r5 = r5.c
                            java.lang.Object r5 = r5.getValue()
                            com.dragon.read.kmp.profile.guestprofile.tabContent.data.FootLoadingState r2 = com.dragon.read.kmp.profile.guestprofile.tabContent.data.FootLoadingState.GONE
                            if (r5 == r2) goto L6a
                            r5 = 1
                            goto L6b
                        L6a:
                            r5 = 0
                        L6b:
                            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L78
                            return r1
                        L78:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt$LoadMoreHandler$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            });
            a aVar = new a(this.$tabViewModel);
            this.label = 1;
            if (distinctUntilChanged.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ tl4.l a;

        a(tl4.l lVar) {
            this.a = lVar;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Boolean) obj).booleanValue(), continuation);
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            if (z && this.a.h.c.getValue() != FootLoadingState.LOADING) {
                tl4.l.A(this.a, false, 1, null);
            }
            return Unit.INSTANCE;
        }
    }
}
