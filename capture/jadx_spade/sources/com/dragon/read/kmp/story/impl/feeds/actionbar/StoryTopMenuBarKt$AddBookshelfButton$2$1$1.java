package com.dragon.read.kmp.story.impl.feeds.actionbar;

import androidx.compose.runtime.MutableState;
import com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType;
import com.dragon.read.kmp.service.KmpBookshelfService;
import com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.actionbar.StoryTopMenuBarKt$AddBookshelfButton$2$1$1", f = "StoryTopMenuBar.kt", i = {0}, l = {186}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u240"}, s = {"L$1"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryTopMenuBarKt$AddBookshelfButton$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $isInBookshelf$delegate;
    final /* synthetic */ kp4.b $story;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryTopMenuBarKt$AddBookshelfButton$2$1$1(kp4.b bVar, MutableState<Boolean> mutableState, Continuation<? super StoryTopMenuBarKt$AddBookshelfButton$2$1$1> continuation) {
        super(2, continuation);
        this.$story = bVar;
        this.$isInBookshelf$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryTopMenuBarKt$AddBookshelfButton$2$1$1(this.$story, this.$isInBookshelf$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryTopMenuBarKt$AddBookshelfButton$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        kp4.b bVar;
        MutableState<Boolean> mutableState;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        String str = "";
        if (i != 0) {
            if (i == 1) {
                mutableState = (MutableState) this.L$2;
                bVar = (kp4.b) this.L$1;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            bVar = this.$story;
            if (bVar != null) {
                MutableState<Boolean> mutableState2 = this.$isInBookshelf$delegate;
                KmpBookshelfService kmpBookshelfService = KmpBookshelfService.a;
                String bookId = bVar.d().getBookId();
                if (bookId == null) {
                    bookId = "";
                }
                BookType bookType = BookType.READ;
                this.L$0 = bVar;
                this.L$1 = bVar;
                this.L$2 = mutableState2;
                this.label = 1;
                Object b = kmpBookshelfService.b(bookId, bookType, true, this);
                if (b == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableState = mutableState2;
                obj = b;
            }
            return Unit.INSTANCE;
        }
        StoryTopMenuBarKt.n(mutableState, ((Boolean) obj).booleanValue());
        StoryDataSource storyDataSource = StoryDataSource.a;
        String bookId2 = bVar.d().getBookId();
        if (bookId2 != null) {
            str = bookId2;
        }
        storyDataSource.f(str);
        return Unit.INSTANCE;
    }
}
