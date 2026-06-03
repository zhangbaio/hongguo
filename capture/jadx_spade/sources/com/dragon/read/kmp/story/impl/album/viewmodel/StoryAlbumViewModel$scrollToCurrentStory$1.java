package com.dragon.read.kmp.story.impl.album.viewmodel;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.o;
import androidx.compose.foundation.lazy.x;
import androidx.compose.runtime.SnapshotStateKt;
import com.dragon.read.kmp.service.b1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.album.viewmodel.StoryAlbumViewModel$scrollToCurrentStory$1", f = "StoryAlbumViewModel.kt", i = {}, l = {181, 187}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryAlbumViewModel$scrollToCurrentStory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    int label;
    final /* synthetic */ StoryAlbumViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryAlbumViewModel$scrollToCurrentStory$1(StoryAlbumViewModel storyAlbumViewModel, int i, Continuation<? super StoryAlbumViewModel$scrollToCurrentStory$1> continuation) {
        super(2, continuation);
        this.this$0 = storyAlbumViewModel;
        this.$index = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryAlbumViewModel$scrollToCurrentStory$1(this.this$0, this.$index, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryAlbumViewModel$scrollToCurrentStory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x invokeSuspend$lambda$0(StoryAlbumViewModel storyAlbumViewModel) {
        return storyAlbumViewModel.b.x();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean z;
        boolean z2;
        int i;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            final StoryAlbumViewModel storyAlbumViewModel = this.this$0;
            final Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.story.impl.album.viewmodel.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    x invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = StoryAlbumViewModel$scrollToCurrentStory$1.invokeSuspend$lambda$0(StoryAlbumViewModel.this);
                    return invokeSuspend$lambda$0;
                }
            });
            final int i3 = this.$index;
            Flow<x> flow = new Flow<x>() { // from class: com.dragon.read.kmp.story.impl.album.viewmodel.StoryAlbumViewModel$scrollToCurrentStory$1$invokeSuspend$$inlined$filter$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super x> flowCollector, Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, i3), continuation);
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }

                /* renamed from: com.dragon.read.kmp.story.impl.album.viewmodel.StoryAlbumViewModel$scrollToCurrentStory$1$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector a;
                    final /* synthetic */ int b;

                    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.album.viewmodel.StoryAlbumViewModel$scrollToCurrentStory$1$invokeSuspend$$inlined$filter$1$2", f = "StoryAlbumViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    /* renamed from: com.dragon.read.kmp.story.impl.album.viewmodel.StoryAlbumViewModel$scrollToCurrentStory$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
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
                            boolean r0 = r7 instanceof com.dragon.read.kmp.story.impl.album.viewmodel.StoryAlbumViewModel$scrollToCurrentStory$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r7
                            com.dragon.read.kmp.story.impl.album.viewmodel.StoryAlbumViewModel$scrollToCurrentStory$1$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.dragon.read.kmp.story.impl.album.viewmodel.StoryAlbumViewModel$scrollToCurrentStory$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.dragon.read.kmp.story.impl.album.viewmodel.StoryAlbumViewModel$scrollToCurrentStory$1$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.dragon.read.kmp.story.impl.album.viewmodel.StoryAlbumViewModel$scrollToCurrentStory$1$invokeSuspend$$inlined$filter$1$2$1
                            r0.<init>(r7)
                        L18:
                            java.lang.Object r7 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r7)
                            goto L4f
                        L29:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L31:
                            kotlin.ResultKt.throwOnFailure(r7)
                            kotlinx.coroutines.flow.FlowCollector r7 = r5.a
                            r2 = r6
                            androidx.compose.foundation.lazy.x r2 = (androidx.compose.foundation.lazy.x) r2
                            int r2 = r2.f()
                            int r4 = r5.b
                            if (r2 <= r4) goto L43
                            r2 = 1
                            goto L44
                        L43:
                            r2 = 0
                        L44:
                            if (r2 == 0) goto L4f
                            r0.label = r3
                            java.lang.Object r6 = r7.emit(r6, r0)
                            if (r6 != r1) goto L4f
                            return r1
                        L4f:
                            kotlin.Unit r6 = kotlin.Unit.INSTANCE
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.album.viewmodel.StoryAlbumViewModel$scrollToCurrentStory$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            };
            this.label = 1;
            if (FlowKt.first(flow, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        List h = this.this$0.b.x().h();
        int i4 = this.$index;
        int i5 = 0;
        if (!(h instanceof Collection) || !h.isEmpty()) {
            Iterator it2 = h.iterator();
            while (it2.hasNext()) {
                if (((o) it2.next()).getIndex() == i4) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        if (!z2) {
            int i6 = this.$index;
            if (i6 == 1) {
                i = 0;
            } else {
                i = i6;
            }
            if (i6 != 1) {
                i5 = -b1.a.e(24.0f);
            }
            LazyListState lazyListState = this.this$0.b;
            this.label = 2;
            if (lazyListState.D(i, i5, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
