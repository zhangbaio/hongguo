package com.dragon.read.kmp.reader.detail;

import androidx.compose.runtime.MutableState;
import com.dragon.read.kmp.dsl.PlatformDslService_androidKt;
import com.dragon.read.kmp.reader.font.Font;
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

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.BookDetailModulesKt$PeakRankTitle$1$1", f = "BookDetailModules.kt", i = {}, l = {565}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailModulesKt$PeakRankTitle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<androidx.compose.ui.text.font.j> $fontFamily;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailModulesKt$PeakRankTitle$1$1(MutableState<androidx.compose.ui.text.font.j> mutableState, Continuation<? super BookDetailModulesKt$PeakRankTitle$1$1> continuation) {
        super(2, continuation);
        this.$fontFamily = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookDetailModulesKt$PeakRankTitle$1$1(this.$fontFamily, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookDetailModulesKt$PeakRankTitle$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.reader.detail.BookDetailModulesKt$PeakRankTitle$1$1$1", f = "BookDetailModules.kt", i = {}, l = {566}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.reader.detail.BookDetailModulesKt$PeakRankTitle$1$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super androidx.compose.ui.text.font.j>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super androidx.compose.ui.text.font.j> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                String fontFamily = Font.COPPERPLATE.getFontFamily();
                this.label = 1;
                obj = PlatformDslService_androidKt.a(fontFamily, this);
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
        MutableState<androidx.compose.ui.text.font.j> mutableState;
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
            MutableState<androidx.compose.ui.text.font.j> mutableState2 = this.$fontFamily;
            CoroutineDispatcher io2 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.L$0 = mutableState2;
            this.label = 1;
            Object withContext = BuildersKt.withContext(io2, anonymousClass1, this);
            if (withContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableState = mutableState2;
            obj = withContext;
        }
        mutableState.setValue(obj);
        return Unit.INSTANCE;
    }
}
