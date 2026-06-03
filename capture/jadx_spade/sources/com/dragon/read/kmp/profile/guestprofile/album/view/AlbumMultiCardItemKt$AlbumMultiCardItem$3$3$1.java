package com.dragon.read.kmp.profile.guestprofile.album.view;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.album.view.AlbumMultiCardItemKt$AlbumMultiCardItem$3$3$1", f = "AlbumMultiCardItem.kt", i = {}, l = {201}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class AlbumMultiCardItemKt$AlbumMultiCardItem$3$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.dragon.read.rpc.kmp.community.model.z $albumData;
    final /* synthetic */ int $index;
    final /* synthetic */ boolean $isPinToTop;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ hl4.a $tabViewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AlbumMultiCardItemKt$AlbumMultiCardItem$3$3$1(LazyListState lazyListState, hl4.a aVar, com.dragon.read.rpc.kmp.community.model.z zVar, int i, boolean z, Continuation<? super AlbumMultiCardItemKt$AlbumMultiCardItem$3$3$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$tabViewModel = aVar;
        this.$albumData = zVar;
        this.$index = i;
        this.$isPinToTop = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AlbumMultiCardItemKt$AlbumMultiCardItem$3$3$1(this.$listState, this.$tabViewModel, this.$albumData, this.$index, this.$isPinToTop, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AlbumMultiCardItemKt$AlbumMultiCardItem$3$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            final LazyListState lazyListState = this.$listState;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.album.view.u
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean b;
                    b = lazyListState.b();
                    return Boolean.valueOf(b);
                }
            });
            a aVar = new a(ref$BooleanRef, this.$tabViewModel, this.$albumData, this.$index, this.$isPinToTop);
            this.label = 1;
            if (snapshotFlow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ Ref$BooleanRef a;
        final /* synthetic */ hl4.a b;
        final /* synthetic */ com.dragon.read.rpc.kmp.community.model.z c;
        final /* synthetic */ int d;
        final /* synthetic */ boolean e;

        a(Ref$BooleanRef ref$BooleanRef, hl4.a aVar, com.dragon.read.rpc.kmp.community.model.z zVar, int i, boolean z) {
            this.a = ref$BooleanRef;
            this.b = aVar;
            this.c = zVar;
            this.d = i;
            this.e = z;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Boolean) obj).booleanValue(), continuation);
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            if (z) {
                this.a.element = true;
            } else if (!z && this.a.element) {
                AlbumMultiCardItemKt.C(this.b, this.c, this.d, this.e, false, "video_slide");
                this.a.element = false;
            }
            return Unit.INSTANCE;
        }
    }
}
