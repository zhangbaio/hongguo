package com.dragon.read.kmp.reader.detail.viewmodel;

import com.dragon.read.kmp.reader.detail.n2;
import com.ss.ttm.player.MediaPlayer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.viewmodel.BookDetailViewModel$updateBookshelfState$1", f = "BookDetailViewModel.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailViewModel$updateBookshelfState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bookId;
    int label;
    final /* synthetic */ BookDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailViewModel$updateBookshelfState$1(BookDetailViewModel bookDetailViewModel, String str, Continuation<? super BookDetailViewModel$updateBookshelfState$1> continuation) {
        super(2, continuation);
        this.this$0 = bookDetailViewModel;
        this.$bookId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookDetailViewModel$updateBookshelfState$1(this.this$0, this.$bookId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookDetailViewModel$updateBookshelfState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object withContext;
        MutableStateFlow mutableStateFlow;
        Object value;
        n2 b;
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
            BookDetailViewModel$updateBookshelfState$1$result$1 bookDetailViewModel$updateBookshelfState$1$result$1 = new BookDetailViewModel$updateBookshelfState$1$result$1(this.this$0, this.$bookId, null);
            this.label = 1;
            withContext = BuildersKt.withContext(io2, bookDetailViewModel$updateBookshelfState$1$result$1, this);
            if (withContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        boolean booleanValue = ((Boolean) withContext).booleanValue();
        if (booleanValue != this.this$0.b.getValue().b) {
            mutableStateFlow = this.this$0.a;
            do {
                value = mutableStateFlow.getValue();
                b = r3.b((r34 & 1) != 0 ? r3.a : null, (r34 & 2) != 0 ? r3.b : booleanValue, (r34 & 4) != 0 ? r3.c : false, (r34 & 8) != 0 ? r3.d : null, (r34 & 16) != 0 ? r3.e : null, (r34 & 32) != 0 ? r3.f : null, (r34 & 64) != 0 ? r3.g : null, (r34 & 128) != 0 ? r3.h : null, (r34 & 256) != 0 ? r3.i : null, (r34 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 ? r3.j : null, (r34 & 1024) != 0 ? r3.k : false, (r34 & 2048) != 0 ? r3.l : false, (r34 & 4096) != 0 ? r3.m : null, (r34 & 8192) != 0 ? r3.n : null, (r34 & 16384) != 0 ? r3.o : null, (r34 & 32768) != 0 ? ((n2) value).p : false);
            } while (!mutableStateFlow.compareAndSet(value, b));
        }
        return Unit.INSTANCE;
    }
}
