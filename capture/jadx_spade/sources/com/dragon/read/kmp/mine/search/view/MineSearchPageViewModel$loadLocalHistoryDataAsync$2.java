package com.dragon.read.kmp.mine.search.view;

import com.dragon.read.kmp.mine.data.LocalSearchDataManagerAdapter;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@DebugMetadata(c = "com.dragon.read.kmp.mine.search.view.MineSearchPageViewModel$loadLocalHistoryDataAsync$2", f = "MineSearchPageViewModel.kt", i = {0}, l = {145}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class MineSearchPageViewModel$loadLocalHistoryDataAsync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MineSearchPageViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MineSearchPageViewModel$loadLocalHistoryDataAsync$2(MineSearchPageViewModel mineSearchPageViewModel, Continuation<? super MineSearchPageViewModel$loadLocalHistoryDataAsync$2> continuation) {
        super(2, continuation);
        this.this$0 = mineSearchPageViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MineSearchPageViewModel$loadLocalHistoryDataAsync$2 mineSearchPageViewModel$loadLocalHistoryDataAsync$2 = new MineSearchPageViewModel$loadLocalHistoryDataAsync$2(this.this$0, continuation);
        mineSearchPageViewModel$loadLocalHistoryDataAsync$2.L$0 = obj;
        return mineSearchPageViewModel$loadLocalHistoryDataAsync$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MineSearchPageViewModel$loadLocalHistoryDataAsync$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.mine.search.view.MineSearchPageViewModel$loadLocalHistoryDataAsync$2$1", f = "MineSearchPageViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.mine.search.view.MineSearchPageViewModel$loadLocalHistoryDataAsync$2$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<com.dragon.read.kmp.mine.data.b> $data;
        int label;
        final /* synthetic */ MineSearchPageViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(MineSearchPageViewModel mineSearchPageViewModel, List<? extends com.dragon.read.kmp.mine.data.b> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = mineSearchPageViewModel;
            this.$data = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$data, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MineSearchPageViewModel mineSearchPageViewModel = this.this$0;
                mineSearchPageViewModel.i = this.$data;
                mineSearchPageViewModel.j = null;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            LocalSearchDataManagerAdapter localSearchDataManagerAdapter = LocalSearchDataManagerAdapter.a;
            this.L$0 = coroutineScope2;
            this.label = 1;
            Object c = localSearchDataManagerAdapter.c(this);
            if (c == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope2;
            obj = c;
        }
        kotlinx.coroutines.i.e(coroutineScope, Dispatchers.getMain(), null, new AnonymousClass1(this.this$0, (List) obj, null), 2, null);
        return Unit.INSTANCE;
    }
}
