package com.dragon.read.kmp.reader.detail.viewmodel;

import com.dragon.read.kmp.reader.detail.catalog.b;
import com.dragon.read.kmp.reader.detail.catalog.r;
import com.dragon.read.kmp.reader.detail.catalog.s;
import com.dragon.read.kmp.reader.detail.n2;
import com.dragon.read.kmp.widget.w;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.viewmodel.BookDetailViewModel$loadCatalog$1", f = "BookDetailViewModel.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailViewModel$loadCatalog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bookId;
    final /* synthetic */ Function1<w, Unit> $reject;
    final /* synthetic */ Function1<b, Unit> $resolve;
    int label;
    final /* synthetic */ BookDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BookDetailViewModel$loadCatalog$1(Function1<? super w, Unit> function1, BookDetailViewModel bookDetailViewModel, Function1<? super b, Unit> function12, String str, Continuation<? super BookDetailViewModel$loadCatalog$1> continuation) {
        super(2, continuation);
        this.$reject = function1;
        this.this$0 = bookDetailViewModel;
        this.$resolve = function12;
        this.$bookId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookDetailViewModel$loadCatalog$1(this.$reject, this.this$0, this.$resolve, this.$bookId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookDetailViewModel$loadCatalog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object withContext;
        Object obj2;
        MutableStateFlow mutableStateFlow;
        Object value;
        n2 b;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        Object obj3 = null;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                withContext = obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            BookDetailViewModel$loadCatalog$1$result$1 bookDetailViewModel$loadCatalog$1$result$1 = new BookDetailViewModel$loadCatalog$1$result$1(this.this$0, this.$bookId, null);
            this.label = 1;
            withContext = BuildersKt.withContext(io2, bookDetailViewModel$loadCatalog$1$result$1, this);
            if (withContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Object m782unboximpl = ((Result) withContext).m782unboximpl();
        if (Result.m779isFailureimpl(m782unboximpl)) {
            Function1<w, Unit> function1 = this.$reject;
            Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m782unboximpl);
            if (m776exceptionOrNullimpl == null || (str = sc4.b.a.c(m776exceptionOrNullimpl)) == null) {
                str = "";
            }
            function1.invoke(new w(-1, str));
        } else {
            if (Result.m779isFailureimpl(m782unboximpl)) {
                obj2 = null;
            } else {
                obj2 = m782unboximpl;
            }
            Intrinsics.checkNotNull(obj2);
            b bVar = (b) obj2;
            mutableStateFlow = this.this$0.a;
            do {
                value = mutableStateFlow.getValue();
                n2 n2Var = (n2) value;
                b = n2Var.b((r34 & 1) != 0 ? n2Var.a : null, (r34 & 2) != 0 ? n2Var.b : false, (r34 & 4) != 0 ? n2Var.c : false, (r34 & 8) != 0 ? n2Var.d : s.b(n2Var.d, false, false, r.a(bVar.a, true), 3, null), (r34 & 16) != 0 ? n2Var.e : null, (r34 & 32) != 0 ? n2Var.f : null, (r34 & 64) != 0 ? n2Var.g : null, (r34 & 128) != 0 ? n2Var.h : null, (r34 & 256) != 0 ? n2Var.i : null, (r34 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 ? n2Var.j : null, (r34 & 1024) != 0 ? n2Var.k : false, (r34 & 2048) != 0 ? n2Var.l : false, (r34 & 4096) != 0 ? n2Var.m : null, (r34 & 8192) != 0 ? n2Var.n : null, (r34 & 16384) != 0 ? n2Var.o : null, (r34 & 32768) != 0 ? n2Var.p : false);
            } while (!mutableStateFlow.compareAndSet(value, b));
            Function1<b, Unit> function12 = this.$resolve;
            if (!Result.m779isFailureimpl(m782unboximpl)) {
                obj3 = m782unboximpl;
            }
            Intrinsics.checkNotNull(obj3);
            function12.invoke(obj3);
        }
        return Unit.INSTANCE;
    }
}
