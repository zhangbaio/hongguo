package com.dragon.read.kmp.util;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@DebugMetadata(c = "com.dragon.read.kmp.util.BitmapUtils$saveBitmapToFile$3$1", f = "BitmapUtils.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BitmapUtils$saveBitmapToFile$3$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ k $callback;
    final /* synthetic */ String $imageFormat;
    final /* synthetic */ String $savePath;
    final /* synthetic */ l $size;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BitmapUtils$saveBitmapToFile$3$1(l lVar, String str, String str2, k kVar, Continuation<? super BitmapUtils$saveBitmapToFile$3$1> continuation) {
        super(1, continuation);
        this.$savePath = str;
        this.$imageFormat = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new BitmapUtils$saveBitmapToFile$3$1(null, this.$savePath, this.$imageFormat, null, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((BitmapUtils$saveBitmapToFile$3$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
