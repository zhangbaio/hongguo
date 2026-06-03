package com.dragon.read.kmp.util;

import androidx.compose.ui.graphics.e1;
import com.dragon.read.kmp.utils.ThreadUtils;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.util.BitmapUtils$fetchBitmapWithResize$2", f = "BitmapUtils.android.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BitmapUtils$fetchBitmapWithResize$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $callback;
    final /* synthetic */ String $path;
    final /* synthetic */ int $reqHeight;
    final /* synthetic */ int $reqWidth;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BitmapUtils$fetchBitmapWithResize$2(String str, int i, int i2, e eVar, Continuation<? super BitmapUtils$fetchBitmapWithResize$2> continuation) {
        super(2, continuation);
        this.$path = str;
        this.$reqWidth = i;
        this.$reqHeight = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BitmapUtils$fetchBitmapWithResize$2(this.$path, this.$reqWidth, this.$reqHeight, null, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BitmapUtils$fetchBitmapWithResize$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.util.BitmapUtils$fetchBitmapWithResize$2$1", f = "BitmapUtils.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.util.BitmapUtils$fetchBitmapWithResize$2$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ e1 $bitmap;
        final /* synthetic */ e $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(e eVar, e1 e1Var, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$bitmap = e1Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(null, this.$bitmap, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw null;
        }
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
            a aVar = a.a;
            String str = this.$path;
            int i2 = this.$reqWidth;
            int i3 = this.$reqHeight;
            this.label = 1;
            obj = aVar.b(str, i2, i3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        ThreadUtils.a.o(new AnonymousClass1(null, (e1) obj, null));
        return Unit.INSTANCE;
    }
}
