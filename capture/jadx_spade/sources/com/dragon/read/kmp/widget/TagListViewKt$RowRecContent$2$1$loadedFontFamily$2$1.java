package com.dragon.read.kmp.widget;

import androidx.compose.runtime.s2;
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

@DebugMetadata(c = "com.dragon.read.kmp.widget.TagListViewKt$RowRecContent$2$1$loadedFontFamily$2$1", f = "TagListView.kt", i = {0}, l = {746}, m = "invokeSuspend", n = {"$this$produceState"}, s = {"L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class TagListViewKt$RowRecContent$2$1$loadedFontFamily$2$1 extends SuspendLambda implements Function2<s2<androidx.compose.ui.text.font.j>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fontName;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TagListViewKt$RowRecContent$2$1$loadedFontFamily$2$1(String str, Continuation<? super TagListViewKt$RowRecContent$2$1$loadedFontFamily$2$1> continuation) {
        super(2, continuation);
        this.$fontName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TagListViewKt$RowRecContent$2$1$loadedFontFamily$2$1 tagListViewKt$RowRecContent$2$1$loadedFontFamily$2$1 = new TagListViewKt$RowRecContent$2$1$loadedFontFamily$2$1(this.$fontName, continuation);
        tagListViewKt$RowRecContent$2$1$loadedFontFamily$2$1.L$0 = obj;
        return tagListViewKt$RowRecContent$2$1$loadedFontFamily$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(s2<androidx.compose.ui.text.font.j> s2Var, Continuation<? super Unit> continuation) {
        return ((TagListViewKt$RowRecContent$2$1$loadedFontFamily$2$1) create(s2Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.widget.TagListViewKt$RowRecContent$2$1$loadedFontFamily$2$1$1", f = "TagListView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.widget.TagListViewKt$RowRecContent$2$1$loadedFontFamily$2$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super androidx.compose.ui.text.font.j>, Object> {
        final /* synthetic */ String $fontName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$fontName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$fontName, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super androidx.compose.ui.text.font.j> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                androidx.compose.ui.text.font.j a = com.dragon.read.kmp.service.s0.a.a(this.$fontName);
                if (a == null) {
                    return androidx.compose.ui.text.font.j.b.b();
                }
                return a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        s2 s2Var;
        s2 s2Var2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                s2Var2 = (s2) this.L$1;
                s2Var = (s2) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable unused) {
                    s2Var.setValue(androidx.compose.ui.text.font.j.b.b());
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            s2 s2Var3 = (s2) this.L$0;
            try {
                CoroutineDispatcher io2 = Dispatchers.getIO();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$fontName, null);
                this.L$0 = s2Var3;
                this.L$1 = s2Var3;
                this.label = 1;
                Object withContext = BuildersKt.withContext(io2, anonymousClass1, this);
                if (withContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                s2Var2 = s2Var3;
                obj = withContext;
                s2Var = s2Var2;
            } catch (Throwable unused2) {
                s2Var = s2Var3;
                s2Var.setValue(androidx.compose.ui.text.font.j.b.b());
                return Unit.INSTANCE;
            }
        }
        s2Var2.setValue(obj);
        return Unit.INSTANCE;
    }
}
