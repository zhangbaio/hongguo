package com.dragon.read.kmp.reader.font;

import androidx.compose.material.n2;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.font.FontItemMultiTypeKt$FontItemMultiType$1$1$1$1", f = "FontItemMultiType.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class FontItemMultiTypeKt$FontItemMultiType$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Boolean> $onFontLongClick;
    final /* synthetic */ n2 $sheetState;
    final /* synthetic */ a0 $uiState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontItemMultiTypeKt$FontItemMultiType$1$1$1$1(a0 a0Var, Function0<Boolean> function0, n2 n2Var, Continuation<? super FontItemMultiTypeKt$FontItemMultiType$1$1$1$1> continuation) {
        super(2, continuation);
        this.$uiState = a0Var;
        this.$onFontLongClick = function0;
        this.$sheetState = n2Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FontItemMultiTypeKt$FontItemMultiType$1$1$1$1(this.$uiState, this.$onFontLongClick, this.$sheetState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FontItemMultiTypeKt$FontItemMultiType$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
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
            com.dragon.read.kmp.j jVar = com.dragon.read.kmp.j.a;
            String o = com.dragon.read.kmp.reader.utils.p.o("Font-FontItem");
            StringBuilder sb = new StringBuilder();
            sb.append("【长按事件】");
            sb.append(this.$uiState.a);
            sb.append(", \" +\n                \"isSelected:");
            sb.append(this.$uiState.e);
            sb.append(", \" +\n                \"downloadStatus:");
            sb.append(this.$uiState.f);
            sb.append(",\" +\n                \" ");
            if (this.$uiState.f == DownloadStatus.STATUS_DOWNLOADING) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.$uiState.g);
                sb2.append('%');
                str = sb2.toString();
            } else {
                str = "";
            }
            sb.append(str);
            sb.append('\"');
            jVar.a(o, sb.toString());
            if (this.$onFontLongClick.invoke().booleanValue()) {
                n2 n2Var = this.$sheetState;
                this.label = 1;
                if (n2Var.n(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
