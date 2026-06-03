package com.dragon.read.kmp.reader.font.manager;

import com.dragon.read.kmp.reader.services.x;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.font.manager.FontDownloadManager$checkFontFileValid$1$isValid$1", f = "FontDownloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class FontDownloadManager$checkFontFileValid$1$isValid$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $fileName;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontDownloadManager$checkFontFileValid$1$isValid$1(String str, Continuation<? super FontDownloadManager$checkFontFileValid$1$isValid$1> continuation) {
        super(2, continuation);
        this.$fileName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FontDownloadManager$checkFontFileValid$1$isValid$1(this.$fileName, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((FontDownloadManager$checkFontFileValid$1$isValid$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            ref$BooleanRef.element = true;
            x.a.e().G6(this.$fileName, new Function1() { // from class: com.dragon.read.kmp.reader.font.manager.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = FontDownloadManager$checkFontFileValid$1$isValid$1.invokeSuspend$lambda$0(Ref$BooleanRef.this, ((Boolean) obj2).booleanValue());
                    return invokeSuspend$lambda$0;
                }
            });
            return Boxing.boxBoolean(ref$BooleanRef.element);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(Ref$BooleanRef ref$BooleanRef, boolean z) {
        ref$BooleanRef.element = z;
        return Unit.INSTANCE;
    }
}
