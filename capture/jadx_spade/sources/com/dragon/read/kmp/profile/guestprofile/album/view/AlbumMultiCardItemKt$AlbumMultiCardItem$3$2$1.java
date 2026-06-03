package com.dragon.read.kmp.profile.guestprofile.album.view;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import com.dragon.read.kmp.service.d1;
import com.dragon.read.kmp.utils.g0;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.album.view.AlbumMultiCardItemKt$AlbumMultiCardItem$3$2$1", f = "AlbumMultiCardItem.kt", i = {}, l = {192, 193}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class AlbumMultiCardItemKt$AlbumMultiCardItem$3$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.dragon.read.rpc.kmp.community.model.z $albumData;
    final /* synthetic */ MutableState<Boolean> $hasExecuted$delegate;
    final /* synthetic */ Integer $justSawIndex;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ int $screenWidth;
    final /* synthetic */ float $width;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AlbumMultiCardItemKt$AlbumMultiCardItem$3$2$1(com.dragon.read.rpc.kmp.community.model.z zVar, LazyListState lazyListState, Integer num, int i, float f, MutableState<Boolean> mutableState, Continuation<? super AlbumMultiCardItemKt$AlbumMultiCardItem$3$2$1> continuation) {
        super(2, continuation);
        this.$albumData = zVar;
        this.$listState = lazyListState;
        this.$justSawIndex = num;
        this.$screenWidth = i;
        this.$width = f;
        this.$hasExecuted$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AlbumMultiCardItemKt$AlbumMultiCardItem$3$2$1(this.$albumData, this.$listState, this.$justSawIndex, this.$screenWidth, this.$width, this.$hasExecuted$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AlbumMultiCardItemKt$AlbumMultiCardItem$3$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int invokeSuspend$lambda$0(LazyListState lazyListState) {
        return lazyListState.x().f();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean r;
        Integer num;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    AlbumMultiCardItemKt.s(this.$hasExecuted$delegate, true);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            r = AlbumMultiCardItemKt.r(this.$hasExecuted$delegate);
            if (!r) {
                List list = this.$albumData.i;
                if (list != null) {
                    num = Boxing.boxInt(list.size());
                } else {
                    num = null;
                }
                final int c = g0.c(num);
                final LazyListState lazyListState = this.$listState;
                final Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.album.view.t
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        int invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = AlbumMultiCardItemKt$AlbumMultiCardItem$3$2$1.invokeSuspend$lambda$0(lazyListState);
                        return Integer.valueOf(invokeSuspend$lambda$0);
                    }
                });
                Flow<Integer> flow = new Flow<Integer>() { // from class: com.dragon.read.kmp.profile.guestprofile.album.view.AlbumMultiCardItemKt$AlbumMultiCardItem$3$2$1$invokeSuspend$$inlined$filter$1
                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super Integer> flowCollector, Continuation continuation) {
                        Object coroutine_suspended2;
                        Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, c), continuation);
                        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (collect == coroutine_suspended2) {
                            return collect;
                        }
                        return Unit.INSTANCE;
                    }

                    /* renamed from: com.dragon.read.kmp.profile.guestprofile.album.view.AlbumMultiCardItemKt$AlbumMultiCardItem$3$2$1$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector a;
                        final /* synthetic */ int b;

                        @DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.album.view.AlbumMultiCardItemKt$AlbumMultiCardItem$3$2$1$invokeSuspend$$inlined$filter$1$2", f = "AlbumMultiCardItem.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        /* renamed from: com.dragon.read.kmp.profile.guestprofile.album.view.AlbumMultiCardItemKt$AlbumMultiCardItem$3$2$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
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

                        public AnonymousClass2(FlowCollector flowCollector, int i) {
                            this.a = flowCollector;
                            this.b = i;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                            /*
                                r5 = this;
                                boolean r0 = r7 instanceof com.dragon.read.kmp.profile.guestprofile.album.view.AlbumMultiCardItemKt$AlbumMultiCardItem$3$2$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r7
                                com.dragon.read.kmp.profile.guestprofile.album.view.AlbumMultiCardItemKt$AlbumMultiCardItem$3$2$1$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.dragon.read.kmp.profile.guestprofile.album.view.AlbumMultiCardItemKt$AlbumMultiCardItem$3$2$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.dragon.read.kmp.profile.guestprofile.album.view.AlbumMultiCardItemKt$AlbumMultiCardItem$3$2$1$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.dragon.read.kmp.profile.guestprofile.album.view.AlbumMultiCardItemKt$AlbumMultiCardItem$3$2$1$invokeSuspend$$inlined$filter$1$2$1
                                r0.<init>(r7)
                            L18:
                                java.lang.Object r7 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.throwOnFailure(r7)
                                goto L54
                            L29:
                                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                                r6.<init>(r7)
                                throw r6
                            L31:
                                kotlin.ResultKt.throwOnFailure(r7)
                                kotlinx.coroutines.flow.FlowCollector r7 = r5.a
                                r2 = r6
                                java.lang.Number r2 = (java.lang.Number) r2
                                int r2 = r2.intValue()
                                int r4 = r5.b
                                if (r2 > r4) goto L48
                                r2 = 20
                                if (r4 >= r2) goto L46
                                goto L48
                            L46:
                                r2 = 0
                                goto L49
                            L48:
                                r2 = 1
                            L49:
                                if (r2 == 0) goto L54
                                r0.label = r3
                                java.lang.Object r6 = r7.emit(r6, r0)
                                if (r6 != r1) goto L54
                                return r1
                            L54:
                                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                                return r6
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.album.view.AlbumMultiCardItemKt$AlbumMultiCardItem$3$2$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }
                };
                this.label = 1;
                if (FlowKt.first(flow, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        LazyListState lazyListState2 = this.$listState;
        int intValue = this.$justSawIndex.intValue();
        int i2 = -d1.b((int) ((this.$screenWidth - this.$width) / 2.0f));
        this.label = 2;
        if (lazyListState2.D(intValue, i2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        AlbumMultiCardItemKt.s(this.$hasExecuted$delegate, true);
        return Unit.INSTANCE;
    }
}
