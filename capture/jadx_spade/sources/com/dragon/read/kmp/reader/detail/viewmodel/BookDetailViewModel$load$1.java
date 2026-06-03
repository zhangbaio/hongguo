package com.dragon.read.kmp.reader.detail.viewmodel;

import com.bytedance.kmp.reading.model.t3;
import com.bytedance.kmp.ugc.model.xy;
import com.dragon.read.kmp.community.bookcomment.t;
import com.dragon.read.kmp.reader.detail.d;
import com.dragon.read.kmp.reader.detail.n2;
import com.dragon.read.kmp.reader.detail.repo.b;
import com.dragon.read.kmp.widget.w;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
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

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.viewmodel.BookDetailViewModel$load$1", f = "BookDetailViewModel.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailViewModel$load$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d $args;
    final /* synthetic */ Function1<w, Unit> $reject;
    final /* synthetic */ Function1<b, Unit> $resolve;
    int label;
    final /* synthetic */ BookDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BookDetailViewModel$load$1(Function1<? super w, Unit> function1, BookDetailViewModel bookDetailViewModel, Function1<? super b, Unit> function12, d dVar, Continuation<? super BookDetailViewModel$load$1> continuation) {
        super(2, continuation);
        this.$reject = function1;
        this.this$0 = bookDetailViewModel;
        this.$resolve = function12;
        this.$args = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookDetailViewModel$load$1(this.$reject, this.this$0, this.$resolve, this.$args, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookDetailViewModel$load$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        Object obj3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
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
            BookDetailViewModel$load$1$result$1 bookDetailViewModel$load$1$result$1 = new BookDetailViewModel$load$1$result$1(this.this$0, this.$args, null);
            this.label = 1;
            withContext = BuildersKt.withContext(io2, bookDetailViewModel$load$1$result$1, this);
            if (withContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Object m782unboximpl = ((Result) withContext).m782unboximpl();
        if (Result.m779isFailureimpl(m782unboximpl)) {
            Function1<w, Unit> function1 = this.$reject;
            Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m782unboximpl);
            Intrinsics.checkNotNull(m776exceptionOrNullimpl);
            String message = m776exceptionOrNullimpl.getMessage();
            if (message == null) {
                message = "";
            }
            function1.invoke(new w(-1, message));
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
                t3 t3Var = bVar.a;
                boolean z = bVar.b;
                List<com.dragon.read.kmp.reader.detail.widget.a> list = bVar.c;
                List<com.dragon.read.kmp.reader.detail.widget.a> list2 = bVar.d;
                List<com.dragon.read.kmp.reader.detail.widget.a> list3 = bVar.e;
                String str = bVar.f;
                String str2 = bVar.g;
                List<com.dragon.read.kmp.reader.detail.widget.a> list4 = bVar.h;
                t tVar = bVar.i;
                xy xyVar = bVar.j;
                com.dragon.read.kmp.reader.detail.repo.a aVar = bVar.k;
                b = r6.b((r34 & 1) != 0 ? r6.a : t3Var, (r34 & 2) != 0 ? r6.b : z, (r34 & 4) != 0 ? r6.c : false, (r34 & 8) != 0 ? r6.d : null, (r34 & 16) != 0 ? r6.e : list4, (r34 & 32) != 0 ? r6.f : list2, (r34 & 64) != 0 ? r6.g : list3, (r34 & 128) != 0 ? r6.h : list, (r34 & 256) != 0 ? r6.i : tVar, (r34 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 ? r6.j : xyVar, (r34 & 1024) != 0 ? r6.k : aVar.a, (r34 & 2048) != 0 ? r6.l : aVar.b, (r34 & 4096) != 0 ? r6.m : aVar.c, (r34 & 8192) != 0 ? r6.n : str, (r34 & 16384) != 0 ? r6.o : str2, (r34 & 32768) != 0 ? ((n2) value).p : false);
            } while (!mutableStateFlow.compareAndSet(value, b));
            Function1<b, Unit> function12 = this.$resolve;
            if (Result.m779isFailureimpl(m782unboximpl)) {
                obj3 = null;
            } else {
                obj3 = m782unboximpl;
            }
            Intrinsics.checkNotNull(obj3);
            function12.invoke(obj3);
        }
        return Unit.INSTANCE;
    }
}
