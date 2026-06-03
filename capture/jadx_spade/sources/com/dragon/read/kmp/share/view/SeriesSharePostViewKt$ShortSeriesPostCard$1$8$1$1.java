package com.dragon.read.kmp.share.view;

import androidx.compose.runtime.n1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.share.view.SeriesSharePostViewKt$ShortSeriesPostCard$1$8$1$1", f = "SeriesSharePostView.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SeriesSharePostViewKt$ShortSeriesPostCard$1$8$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.dragon.read.kmp.share.business.series.o $videoPlayerPost;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeriesSharePostViewKt$ShortSeriesPostCard$1$8$1$1(com.dragon.read.kmp.share.business.series.o oVar, Continuation<? super SeriesSharePostViewKt$ShortSeriesPostCard$1$8$1$1> continuation) {
        super(2, continuation);
        this.$videoPlayerPost = oVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeriesSharePostViewKt$ShortSeriesPostCard$1$8$1$1(this.$videoPlayerPost, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeriesSharePostViewKt$ShortSeriesPostCard$1$8$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    static final class a implements Function1<Long, Unit> {
        public static final a a = new a();

        a() {
        }

        public final void a(long j) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            a(l.longValue());
            return Unit.INSTANCE;
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
            this.label = 1;
            if (n1.c(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Function0<Unit> function0 = this.$videoPlayerPost.k;
        if (function0 != null) {
            function0.invoke();
        }
        this.$videoPlayerPost.k = null;
        return Unit.INSTANCE;
    }
}
