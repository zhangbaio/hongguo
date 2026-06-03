package com.dragon.read.kmp.widget.expandableText;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.m;
import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.widget.expandableText.ExtandableTextKt$rememberExpandableTextData$3$1", f = "ExtandableText.kt", i = {}, l = {242, 258}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ExtandableTextKt$rememberExpandableTextData$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, m> $animatableHeight;
    final /* synthetic */ androidx.compose.animation.core.i<Float> $animationSpec;
    final /* synthetic */ int $collapsedHeight;
    final /* synthetic */ androidx.compose.ui.text.e $collapsedText;
    final /* synthetic */ MutableState<Integer> $displayedLines$delegate;
    final /* synthetic */ MutableState<androidx.compose.ui.text.e> $displayedText$delegate;
    final /* synthetic */ boolean $expand;
    final /* synthetic */ int $expandedHeight;
    final /* synthetic */ MutableState<Boolean> $internalExpand$delegate;
    final /* synthetic */ int $limitedMaxLines;
    final /* synthetic */ androidx.compose.ui.text.e $originalText;
    final /* synthetic */ i<Float> $textHeight;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExtandableTextKt$rememberExpandableTextData$3$1(boolean z, androidx.compose.ui.text.e eVar, Animatable<Float, m> animatable, int i, int i2, androidx.compose.animation.core.i<Float> iVar, i<Float> iVar2, androidx.compose.ui.text.e eVar2, int i3, MutableState<Boolean> mutableState, MutableState<androidx.compose.ui.text.e> mutableState2, MutableState<Integer> mutableState3, Continuation<? super ExtandableTextKt$rememberExpandableTextData$3$1> continuation) {
        super(2, continuation);
        this.$expand = z;
        this.$originalText = eVar;
        this.$animatableHeight = animatable;
        this.$expandedHeight = i;
        this.$collapsedHeight = i2;
        this.$animationSpec = iVar;
        this.$textHeight = iVar2;
        this.$collapsedText = eVar2;
        this.$limitedMaxLines = i3;
        this.$internalExpand$delegate = mutableState;
        this.$displayedText$delegate = mutableState2;
        this.$displayedLines$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExtandableTextKt$rememberExpandableTextData$3$1(this.$expand, this.$originalText, this.$animatableHeight, this.$expandedHeight, this.$collapsedHeight, this.$animationSpec, this.$textHeight, this.$collapsedText, this.$limitedMaxLines, this.$internalExpand$delegate, this.$displayedText$delegate, this.$displayedLines$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ExtandableTextKt$rememberExpandableTextData$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0087  */
    /* JADX WARN: Type inference failed for: r1v12, types: [T, java.lang.Float] */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Float] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.expandableText.ExtandableTextKt$rememberExpandableTextData$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(float f, androidx.compose.ui.text.e eVar, int i, MutableState mutableState, MutableState mutableState2, Animatable animatable) {
        androidx.compose.ui.text.e t;
        if (((Number) animatable.k()).floatValue() < f) {
            t = ExtandableTextKt.t(mutableState);
            if (!Intrinsics.areEqual(t, eVar) && (((Number) animatable.k()).floatValue() - ((Number) animatable.j()).floatValue()) / (f - ((Number) animatable.j()).floatValue()) < 0.2f) {
                ExtandableTextKt.u(mutableState, eVar);
                ExtandableTextKt.w(mutableState2, i);
            }
        }
        return Unit.INSTANCE;
    }
}
