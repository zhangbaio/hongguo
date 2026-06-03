package com.dragon.read.kmp.reader.detail.viewmodel;

import com.dragon.read.kmp.reader.detail.n2;
import com.dragon.read.kmp.utils.c0;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.viewmodel.BookDetailViewModel$refreshAlsoReadItems$1", f = "BookDetailViewModel.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailViewModel$refreshAlsoReadItems$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bookId;
    int label;
    final /* synthetic */ BookDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailViewModel$refreshAlsoReadItems$1(BookDetailViewModel bookDetailViewModel, String str, Continuation<? super BookDetailViewModel$refreshAlsoReadItems$1> continuation) {
        super(2, continuation);
        this.this$0 = bookDetailViewModel;
        this.$bookId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookDetailViewModel$refreshAlsoReadItems$1(this.this$0, this.$bookId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookDetailViewModel$refreshAlsoReadItems$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableStateFlow mutableStateFlow;
        n2 b;
        Object withContext;
        MutableStateFlow mutableStateFlow2;
        Object value;
        n2 b2;
        BookDetailViewModel$refreshAlsoReadItems$1 bookDetailViewModel$refreshAlsoReadItems$1 = this;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = bookDetailViewModel$refreshAlsoReadItems$1.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                withContext = obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = bookDetailViewModel$refreshAlsoReadItems$1.this$0.a;
            while (true) {
                Object value2 = mutableStateFlow.getValue();
                b = r5.b((r34 & 1) != 0 ? r5.a : null, (r34 & 2) != 0 ? r5.b : false, (r34 & 4) != 0 ? r5.c : false, (r34 & 8) != 0 ? r5.d : null, (r34 & 16) != 0 ? r5.e : null, (r34 & 32) != 0 ? r5.f : null, (r34 & 64) != 0 ? r5.g : null, (r34 & 128) != 0 ? r5.h : null, (r34 & 256) != 0 ? r5.i : null, (r34 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 ? r5.j : null, (r34 & 1024) != 0 ? r5.k : false, (r34 & 2048) != 0 ? r5.l : false, (r34 & 4096) != 0 ? r5.m : null, (r34 & 8192) != 0 ? r5.n : null, (r34 & 16384) != 0 ? r5.o : null, (r34 & 32768) != 0 ? ((n2) value2).p : true);
                if (mutableStateFlow.compareAndSet(value2, b)) {
                    break;
                }
                bookDetailViewModel$refreshAlsoReadItems$1 = this;
            }
            CoroutineDispatcher io2 = Dispatchers.getIO();
            BookDetailViewModel$refreshAlsoReadItems$1$result$1 bookDetailViewModel$refreshAlsoReadItems$1$result$1 = new BookDetailViewModel$refreshAlsoReadItems$1$result$1(bookDetailViewModel$refreshAlsoReadItems$1.this$0, bookDetailViewModel$refreshAlsoReadItems$1.$bookId, null);
            bookDetailViewModel$refreshAlsoReadItems$1.label = 1;
            withContext = BuildersKt.withContext(io2, bookDetailViewModel$refreshAlsoReadItems$1$result$1, bookDetailViewModel$refreshAlsoReadItems$1);
            if (withContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        List list = (List) withContext;
        if (c0.a(list)) {
            mutableStateFlow2 = bookDetailViewModel$refreshAlsoReadItems$1.this$0.a;
            do {
                value = mutableStateFlow2.getValue();
                Intrinsics.checkNotNull(list);
                b2 = r3.b((r34 & 1) != 0 ? r3.a : null, (r34 & 2) != 0 ? r3.b : false, (r34 & 4) != 0 ? r3.c : false, (r34 & 8) != 0 ? r3.d : null, (r34 & 16) != 0 ? r3.e : null, (r34 & 32) != 0 ? r3.f : null, (r34 & 64) != 0 ? r3.g : null, (r34 & 128) != 0 ? r3.h : list, (r34 & 256) != 0 ? r3.i : null, (r34 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 ? r3.j : null, (r34 & 1024) != 0 ? r3.k : false, (r34 & 2048) != 0 ? r3.l : false, (r34 & 4096) != 0 ? r3.m : null, (r34 & 8192) != 0 ? r3.n : null, (r34 & 16384) != 0 ? r3.o : null, (r34 & 32768) != 0 ? ((n2) value).p : false);
            } while (!mutableStateFlow2.compareAndSet(value, b2));
        }
        return Unit.INSTANCE;
    }
}
