package com.dragon.read.kmp.story.impl.feeds.actionbar;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType;
import com.dragon.read.kmp.service.KmpBookshelfService;
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

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.actionbar.StoryTopMenuBarKt$AddBookshelfButton$1$1", f = "StoryTopMenuBar.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryTopMenuBarKt$AddBookshelfButton$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<kp4.b> $currentStory$delegate;
    final /* synthetic */ MutableState<Boolean> $isInBookshelf$delegate;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryTopMenuBarKt$AddBookshelfButton$1$1(State<kp4.b> state, MutableState<Boolean> mutableState, Continuation<? super StoryTopMenuBarKt$AddBookshelfButton$1$1> continuation) {
        super(2, continuation);
        this.$currentStory$delegate = state;
        this.$isInBookshelf$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryTopMenuBarKt$AddBookshelfButton$1$1(this.$currentStory$delegate, this.$isInBookshelf$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryTopMenuBarKt$AddBookshelfButton$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.actionbar.StoryTopMenuBarKt$AddBookshelfButton$1$1$1", f = "StoryTopMenuBar.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.story.impl.feeds.actionbar.StoryTopMenuBarKt$AddBookshelfButton$1$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ State<kp4.b> $currentStory$delegate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State<kp4.b> state, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$currentStory$delegate = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$currentStory$delegate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            kp4.b l;
            String str;
            com.dragon.read.kmp.story.impl.feeds.data.e d;
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
                KmpBookshelfService kmpBookshelfService = KmpBookshelfService.a;
                l = StoryTopMenuBarKt.l(this.$currentStory$delegate);
                if (l == null || (d = l.d()) == null || (str = d.getBookId()) == null) {
                    str = "";
                }
                BookType bookType = BookType.READ;
                this.label = 1;
                obj = kmpBookshelfService.c(str, bookType, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return obj;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        kp4.b l;
        MutableState<Boolean> mutableState;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                mutableState = (MutableState) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            l = StoryTopMenuBarKt.l(this.$currentStory$delegate);
            if (l != null) {
                MutableState<Boolean> mutableState2 = this.$isInBookshelf$delegate;
                CoroutineDispatcher io2 = Dispatchers.getIO();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentStory$delegate, null);
                this.L$0 = mutableState2;
                this.label = 1;
                Object withContext = BuildersKt.withContext(io2, anonymousClass1, this);
                if (withContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableState = mutableState2;
                obj = withContext;
            }
            return Unit.INSTANCE;
        }
        StoryTopMenuBarKt.n(mutableState, ((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }
}
