package com.dragon.read.lib.community.inner;

import androidx.fragment.app.Fragment;
import com.dragon.community.saas.utils.LifecycleKtxKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@DebugMetadata(c = "com.dragon.read.lib.community.inner.CssThemeKtxKt$observeThemeUpdate$2", f = "CssThemeKtx.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class CssThemeKtxKt$observeThemeUpdate$2 extends SuspendLambda implements Function3<Fragment, Function0<? extends Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ j $listener;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    CssThemeKtxKt$observeThemeUpdate$2(j jVar, Continuation<? super CssThemeKtxKt$observeThemeUpdate$2> continuation) {
        super(3, continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Fragment fragment, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        CssThemeKtxKt$observeThemeUpdate$2 cssThemeKtxKt$observeThemeUpdate$2 = new CssThemeKtxKt$observeThemeUpdate$2(null, continuation);
        cssThemeKtxKt$observeThemeUpdate$2.L$0 = fragment;
        cssThemeKtxKt$observeThemeUpdate$2.L$1 = function0;
        return cssThemeKtxKt$observeThemeUpdate$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Fragment fragment, Function0<? extends Unit> function0, Continuation<? super Unit> continuation) {
        return invoke2(fragment, (Function0<Unit>) function0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Fragment fragment = (Fragment) this.L$0;
            ((Function0) this.L$1).invoke();
            final j jVar = null;
            b.a.a(null);
            LifecycleKtxKt.c(fragment, new Function2(jVar) { // from class: com.dragon.read.lib.community.inner.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = CssThemeKtxKt$observeThemeUpdate$2.invokeSuspend$lambda$0(null, (Fragment) obj2, (Function0) obj3);
                    return invokeSuspend$lambda$0;
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(j jVar, Fragment fragment, Function0 function0) {
        function0.invoke();
        b.a.c(jVar);
        return Unit.INSTANCE;
    }
}
