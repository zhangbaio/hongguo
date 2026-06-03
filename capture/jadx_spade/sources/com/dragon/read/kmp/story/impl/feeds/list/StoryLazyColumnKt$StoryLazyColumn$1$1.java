package com.dragon.read.kmp.story.impl.feeds.list;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.o;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.dragon.read.kmp.basenovel.ui.ui.FootLoadingState;
import java.util.List;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumnKt$StoryLazyColumn$1$1", f = "StoryLazyColumn.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryLazyColumnKt$StoryLazyColumn$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.dragon.read.kmp.story.impl.feeds.list.a $adapter;
    final /* synthetic */ Function3<FootLoadingState, Composer, Integer, Unit> $footerContent;
    final /* synthetic */ Function2<Composer, Integer, Unit> $headerContent;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ int $loadThreshold;
    final /* synthetic */ Lazy<tp4.b> $log$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryLazyColumnKt$StoryLazyColumn$1$1(LazyListState lazyListState, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super FootLoadingState, ? super Composer, ? super Integer, Unit> function3, int i, com.dragon.read.kmp.story.impl.feeds.list.a aVar, Lazy<tp4.b> lazy, Continuation<? super StoryLazyColumnKt$StoryLazyColumn$1$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$headerContent = function2;
        this.$footerContent = function3;
        this.$loadThreshold = i;
        this.$adapter = aVar;
        this.$log$delegate = lazy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryLazyColumnKt$StoryLazyColumn$1$1(this.$listState, this.$headerContent, this.$footerContent, this.$loadThreshold, this.$adapter, this.$log$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryLazyColumnKt$StoryLazyColumn$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer invokeSuspend$lambda$0(LazyListState lazyListState) {
        Object lastOrNull;
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) lazyListState.x().h());
        o oVar = (o) lastOrNull;
        if (oVar != null) {
            return Integer.valueOf(oVar.getIndex());
        }
        return null;
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
            final Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.list.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Integer invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = StoryLazyColumnKt$StoryLazyColumn$1$1.invokeSuspend$lambda$0(lazyListState);
                    return invokeSuspend$lambda$0;
                }
            });
            final Function2<Composer, Integer, Unit> function2 = this.$headerContent;
            final Function3<FootLoadingState, Composer, Integer, Unit> function3 = this.$footerContent;
            final LazyListState lazyListState2 = this.$listState;
            final int i2 = this.$loadThreshold;
            Flow<Boolean> flow = new Flow<Boolean>() { // from class: com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumnKt$StoryLazyColumn$1$1$invokeSuspend$$inlined$map$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, function2, function3, lazyListState2, i2), continuation);
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }

                /* renamed from: com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumnKt$StoryLazyColumn$1$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector a;
                    final /* synthetic */ Function2 b;
                    final /* synthetic */ Function3 c;
                    final /* synthetic */ LazyListState d;
                    final /* synthetic */ int e;

                    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumnKt$StoryLazyColumn$1$1$invokeSuspend$$inlined$map$1$2", f = "StoryLazyColumn.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    /* renamed from: com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumnKt$StoryLazyColumn$1$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
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

                    public AnonymousClass2(FlowCollector flowCollector, Function2 function2, Function3 function3, LazyListState lazyListState, int i) {
                        this.a = flowCollector;
                        this.b = function2;
                        this.c = function3;
                        this.d = lazyListState;
                        this.e = i;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                        /*
                            r6 = this;
                            boolean r0 = r8 instanceof com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumnKt$StoryLazyColumn$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r8
                            com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumnKt$StoryLazyColumn$1$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumnKt$StoryLazyColumn$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumnKt$StoryLazyColumn$1$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumnKt$StoryLazyColumn$1$1$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r8)
                        L18:
                            java.lang.Object r8 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r8)
                            goto L6d
                        L29:
                            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                            r7.<init>(r8)
                            throw r7
                        L31:
                            kotlin.ResultKt.throwOnFailure(r8)
                            kotlinx.coroutines.flow.FlowCollector r8 = r6.a
                            java.lang.Integer r7 = (java.lang.Integer) r7
                            kotlin.jvm.functions.Function2 r2 = r6.b
                            r4 = 0
                            if (r2 == 0) goto L3f
                            r2 = 1
                            goto L40
                        L3f:
                            r2 = 0
                        L40:
                            kotlin.jvm.functions.Function3 r5 = r6.c
                            if (r5 == 0) goto L46
                            int r2 = r2 + 1
                        L46:
                            androidx.compose.foundation.lazy.LazyListState r5 = r6.d
                            androidx.compose.foundation.lazy.x r5 = r5.x()
                            int r5 = r5.f()
                            int r5 = r5 - r2
                            if (r7 == 0) goto L60
                            if (r5 <= 0) goto L60
                            int r7 = r7.intValue()
                            int r2 = r6.e
                            int r5 = r5 - r2
                            int r5 = r5 - r3
                            if (r7 < r5) goto L60
                            r4 = 1
                        L60:
                            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
                            r0.label = r3
                            java.lang.Object r7 = r8.emit(r7, r0)
                            if (r7 != r1) goto L6d
                            return r1
                        L6d:
                            kotlin.Unit r7 = kotlin.Unit.INSTANCE
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumnKt$StoryLazyColumn$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            };
            a aVar = new a(this.$adapter, this.$log$delegate);
            this.label = 1;
            if (flow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ com.dragon.read.kmp.story.impl.feeds.list.a a;
        final /* synthetic */ Lazy<tp4.b> b;

        a(com.dragon.read.kmp.story.impl.feeds.list.a aVar, Lazy<tp4.b> lazy) {
            this.a = aVar;
            this.b = lazy;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Boolean) obj).booleanValue(), continuation);
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            tp4.b j;
            SnapshotStateList<yo4.c> snapshotStateList = this.a.b;
            j = StoryLazyColumnKt.j(this.b);
            StringBuilder sb = new StringBuilder();
            sb.append("loadMore, shouldLoad: ");
            sb.append(z);
            sb.append(", listLoadIngState: ");
            sb.append(this.a.g.getValue());
            sb.append(", hasMore: ");
            sb.append(this.a.e());
            sb.append(", dataNotEmpty: ");
            sb.append(!snapshotStateList.isEmpty());
            j.d(sb.toString());
            if (z && this.a.g.getValue() != FootLoadingState.LOADING && this.a.e() && this.a.g.getValue() != FootLoadingState.NOT_MORE && (!snapshotStateList.isEmpty())) {
                this.a.f();
            }
            return Unit.INSTANCE;
        }
    }
}
