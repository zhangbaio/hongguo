package com.dragon.read.lib.community.inner;

import androidx.fragment.app.FragmentActivity;
import com.dragon.community.saas.utils.LifecycleKtxKt;
import com.dragon.read.lib.community.inner.CssThemeKtxKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@DebugMetadata(c = "com.dragon.read.lib.community.inner.CssThemeKtxKt$observeThemeUpdate$1", f = "CssThemeKtx.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class CssThemeKtxKt$observeThemeUpdate$1 extends SuspendLambda implements Function3<FragmentActivity, Function0<? extends Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ CssThemeKtxKt.c $listener;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CssThemeKtxKt$observeThemeUpdate$1(CssThemeKtxKt.c cVar, Continuation<? super CssThemeKtxKt$observeThemeUpdate$1> continuation) {
        super(3, continuation);
        this.$listener = cVar;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FragmentActivity fragmentActivity, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        CssThemeKtxKt$observeThemeUpdate$1 cssThemeKtxKt$observeThemeUpdate$1 = new CssThemeKtxKt$observeThemeUpdate$1(this.$listener, continuation);
        cssThemeKtxKt$observeThemeUpdate$1.L$0 = fragmentActivity;
        cssThemeKtxKt$observeThemeUpdate$1.L$1 = function0;
        return cssThemeKtxKt$observeThemeUpdate$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FragmentActivity fragmentActivity, Function0<? extends Unit> function0, Continuation<? super Unit> continuation) {
        return invoke2(fragmentActivity, (Function0<Unit>) function0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FragmentActivity fragmentActivity = (FragmentActivity) this.L$0;
            ((Function0) this.L$1).invoke();
            b.a.a(this.$listener);
            final CssThemeKtxKt.c cVar = this.$listener;
            LifecycleKtxKt.c(fragmentActivity, new Function2() { // from class: com.dragon.read.lib.community.inner.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = CssThemeKtxKt$observeThemeUpdate$1.invokeSuspend$lambda$0(CssThemeKtxKt.c.this, (FragmentActivity) obj2, (Function0) obj3);
                    return invokeSuspend$lambda$0;
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(CssThemeKtxKt.c cVar, FragmentActivity fragmentActivity, Function0 function0) {
        function0.invoke();
        b.a.c(cVar);
        return Unit.INSTANCE;
    }
}
