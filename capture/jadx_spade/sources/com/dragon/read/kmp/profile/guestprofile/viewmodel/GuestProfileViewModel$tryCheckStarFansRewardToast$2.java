package com.dragon.read.kmp.profile.guestprofile.viewmodel;

import com.bytedance.kmp.reading.model.cj0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$tryCheckStarFansRewardToast$2", f = "GuestProfileViewModel.kt", i = {}, l = {957}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class GuestProfileViewModel$tryCheckStarFansRewardToast$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GuestProfileViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GuestProfileViewModel$tryCheckStarFansRewardToast$2(GuestProfileViewModel guestProfileViewModel, Continuation<? super GuestProfileViewModel$tryCheckStarFansRewardToast$2> continuation) {
        super(2, continuation);
        this.this$0 = guestProfileViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GuestProfileViewModel$tryCheckStarFansRewardToast$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GuestProfileViewModel$tryCheckStarFansRewardToast$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            final MutableStateFlow<f0> mutableStateFlow = this.this$0.l;
            Flow filterNotNull = FlowKt.filterNotNull(new Flow<cj0>() { // from class: com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$tryCheckStarFansRewardToast$2$invokeSuspend$$inlined$map$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super cj0> flowCollector, Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }

                /* renamed from: com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$tryCheckStarFansRewardToast$2$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector a;

                    @DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$tryCheckStarFansRewardToast$2$invokeSuspend$$inlined$map$1$2", f = "GuestProfileViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    /* renamed from: com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$tryCheckStarFansRewardToast$2$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
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
                            boolean r0 = r6 instanceof com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$tryCheckStarFansRewardToast$2$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$tryCheckStarFansRewardToast$2$invokeSuspend$$inlined$map$1$2$1 r0 = (com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$tryCheckStarFansRewardToast$2$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$tryCheckStarFansRewardToast$2$invokeSuspend$$inlined$map$1$2$1 r0 = new com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$tryCheckStarFansRewardToast$2$invokeSuspend$$inlined$map$1$2$1
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
                            com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 r5 = (com.dragon.read.kmp.profile.guestprofile.viewmodel.f0) r5
                            com.bytedance.kmp.reading.model.eo r5 = r5.a
                            if (r5 == 0) goto L3f
                            com.bytedance.kmp.reading.model.cj0 r5 = r5.a
                            goto L40
                        L3f:
                            r5 = 0
                        L40:
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L49
                            return r1
                        L49:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$tryCheckStarFansRewardToast$2$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            });
            this.label = 1;
            obj = FlowKt.first(filterNotNull, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        cj0 cj0Var = (cj0) obj;
        this.this$0.b.d("starFansToast profile loaded, userId=" + cj0Var.a);
        this.this$0.u0(cj0Var);
        return Unit.INSTANCE;
    }
}
