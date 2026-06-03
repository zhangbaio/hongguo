package com.dragon.read.kmp.story.impl.album;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
import com.dragon.community.base.sdk.load.KmpCSSLoadStatus;
import com.dragon.read.kmp.story.impl.album.viewmodel.StoryAlbumViewModel;
import kotlin.Pair;
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
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.album.StoryAlbumPanelKt$StoryAlbumListEffect$2$1", f = "StoryAlbumPanel.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryAlbumPanelKt$StoryAlbumListEffect$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.dragon.read.kmp.story.impl.album.a $depend;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ StoryAlbumViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryAlbumPanelKt$StoryAlbumListEffect$2$1(com.dragon.read.kmp.story.impl.album.a aVar, StoryAlbumViewModel storyAlbumViewModel, LazyListState lazyListState, Continuation<? super StoryAlbumPanelKt$StoryAlbumListEffect$2$1> continuation) {
        super(2, continuation);
        this.$depend = aVar;
        this.$viewModel = storyAlbumViewModel;
        this.$listState = lazyListState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryAlbumPanelKt$StoryAlbumListEffect$2$1(this.$depend, this.$viewModel, this.$listState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryAlbumPanelKt$StoryAlbumListEffect$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair invokeSuspend$lambda$0(LazyListState lazyListState) {
        return new Pair(Integer.valueOf(lazyListState.u()), Integer.valueOf(lazyListState.v()));
    }

    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.album.StoryAlbumPanelKt$StoryAlbumListEffect$2$1$3", f = "StoryAlbumPanel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.story.impl.album.StoryAlbumPanelKt$StoryAlbumListEffect$2$1$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function3<Boolean, com.dragon.read.kmp.story.impl.album.viewmodel.a, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ boolean Z$0;
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, com.dragon.read.kmp.story.impl.album.viewmodel.a aVar, Continuation<? super Boolean> continuation) {
            return invoke(bool.booleanValue(), aVar, continuation);
        }

        public final Object invoke(boolean z, com.dragon.read.kmp.story.impl.album.viewmodel.a aVar, Continuation<? super Boolean> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
            anonymousClass3.Z$0 = z;
            anonymousClass3.L$0 = aVar;
            return anonymousClass3.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                boolean z = this.Z$0;
                com.dragon.read.kmp.story.impl.album.viewmodel.a aVar = (com.dragon.read.kmp.story.impl.album.viewmodel.a) this.L$0;
                boolean z2 = false;
                if (z && (aVar.a != KmpCSSLoadStatus.Content || (!aVar.e && aVar.c == KmpCSSLoadStatus.Init))) {
                    z2 = true;
                }
                return Boxing.boxBoolean(z2);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
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
            if (this.$depend == null) {
                return Unit.INSTANCE;
            }
            final LazyListState lazyListState = this.$listState;
            final Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.story.impl.album.o
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Pair invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = StoryAlbumPanelKt$StoryAlbumListEffect$2$1.invokeSuspend$lambda$0(lazyListState);
                    return invokeSuspend$lambda$0;
                }
            });
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(FlowKt.flowCombine(FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: com.dragon.read.kmp.story.impl.album.StoryAlbumPanelKt$StoryAlbumListEffect$2$1$invokeSuspend$$inlined$map$1
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

                /* renamed from: com.dragon.read.kmp.story.impl.album.StoryAlbumPanelKt$StoryAlbumListEffect$2$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector a;

                    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.album.StoryAlbumPanelKt$StoryAlbumListEffect$2$1$invokeSuspend$$inlined$map$1$2", f = "StoryAlbumPanel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    /* renamed from: com.dragon.read.kmp.story.impl.album.StoryAlbumPanelKt$StoryAlbumListEffect$2$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
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
                            boolean r0 = r6 instanceof com.dragon.read.kmp.story.impl.album.StoryAlbumPanelKt$StoryAlbumListEffect$2$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.dragon.read.kmp.story.impl.album.StoryAlbumPanelKt$StoryAlbumListEffect$2$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.dragon.read.kmp.story.impl.album.StoryAlbumPanelKt$StoryAlbumListEffect$2$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.dragon.read.kmp.story.impl.album.StoryAlbumPanelKt$StoryAlbumListEffect$2$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.dragon.read.kmp.story.impl.album.StoryAlbumPanelKt$StoryAlbumListEffect$2$1$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L60
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            kotlin.ResultKt.throwOnFailure(r6)
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.a
                            kotlin.Pair r5 = (kotlin.Pair) r5
                            java.lang.Object r2 = r5.component1()
                            java.lang.Number r2 = (java.lang.Number) r2
                            int r2 = r2.intValue()
                            java.lang.Object r5 = r5.component2()
                            java.lang.Number r5 = (java.lang.Number) r5
                            int r5 = r5.intValue()
                            if (r2 != 0) goto L52
                            if (r5 > r3) goto L52
                            r5 = 1
                            goto L53
                        L52:
                            r5 = 0
                        L53:
                            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L60
                            return r1
                        L60:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.album.StoryAlbumPanelKt$StoryAlbumListEffect$2$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            }), this.$viewModel.g, new AnonymousClass3(null)));
            a aVar = new a(this.$depend);
            this.label = 1;
            if (distinctUntilChanged.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ com.dragon.read.kmp.story.impl.album.a a;

        a(com.dragon.read.kmp.story.impl.album.a aVar) {
            this.a = aVar;
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            this.a.b(z);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Boolean) obj).booleanValue(), continuation);
        }
    }
}
