package com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting;

import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.animation.core.k0;
import androidx.compose.animation.core.s2;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.v1;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.ReadingSettingDialogKt$OptionSelector$handleOptionSelect$1", f = "ReadingSettingDialog.kt", i = {}, l = {332}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ReadingSettingDialogKt$OptionSelector$handleOptionSelect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $isAnimating$delegate;
    final /* synthetic */ Function1<T, Unit> $onOptionSelected;
    final /* synthetic */ T $option;
    final /* synthetic */ List<T> $options;
    final /* synthetic */ v1 $selectedIndex$delegate;
    final /* synthetic */ MutableState<T> $selectedOption$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ReadingSettingDialogKt$OptionSelector$handleOptionSelect$1(List<? extends T> list, T t, MutableState<Boolean> mutableState, v1 v1Var, Function1<? super T, Unit> function1, MutableState<T> mutableState2, Continuation<? super ReadingSettingDialogKt$OptionSelector$handleOptionSelect$1> continuation) {
        super(2, continuation);
        this.$options = list;
        this.$option = t;
        this.$isAnimating$delegate = mutableState;
        this.$selectedIndex$delegate = v1Var;
        this.$onOptionSelected = function1;
        this.$selectedOption$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReadingSettingDialogKt$OptionSelector$handleOptionSelect$1(this.$options, this.$option, this.$isAnimating$delegate, this.$selectedIndex$delegate, this.$onOptionSelected, this.$selectedOption$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReadingSettingDialogKt$OptionSelector$handleOptionSelect$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        float G;
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
            ReadingSettingDialogKt.F(this.$isAnimating$delegate, true);
            final int indexOf = this.$options.indexOf(this.$option);
            G = ReadingSettingDialogKt.G(this.$selectedIndex$delegate);
            s2 n = androidx.compose.animation.core.j.n(300, 0, k0.n(), 2, (Object) null);
            final T t = this.$option;
            final Function1<T, Unit> function1 = this.$onOptionSelected;
            final v1 v1Var = this.$selectedIndex$delegate;
            final MutableState<T> mutableState = this.$selectedOption$delegate;
            final MutableState<Boolean> mutableState2 = this.$isAnimating$delegate;
            Function2 function2 = new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = ReadingSettingDialogKt$OptionSelector$handleOptionSelect$1.invokeSuspend$lambda$0(indexOf, t, function1, v1Var, mutableState, mutableState2, ((Float) obj2).floatValue(), ((Float) obj3).floatValue());
                    return invokeSuspend$lambda$0;
                }
            };
            this.label = 1;
            if (SuspendAnimationKt.n(G, indexOf, 0.0f, n, function2, this, 4, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(int i, Object obj, Function1 function1, v1 v1Var, MutableState mutableState, MutableState mutableState2, float f, float f2) {
        boolean z;
        ReadingSettingDialogKt.H(v1Var, f);
        if (f == i) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ReadingSettingDialogKt.D(mutableState, obj);
            ReadingSettingDialogKt.F(mutableState2, false);
            function1.invoke(obj);
        }
        return Unit.INSTANCE;
    }
}
