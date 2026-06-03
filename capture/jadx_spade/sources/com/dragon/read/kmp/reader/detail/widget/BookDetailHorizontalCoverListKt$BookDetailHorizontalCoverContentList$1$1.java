package com.dragon.read.kmp.reader.detail.widget;

import androidx.compose.animation.core.Animatable;
import androidx.compose.runtime.MutableState;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.widget.BookDetailHorizontalCoverListKt$BookDetailHorizontalCoverContentList$1$1", f = "BookDetailHorizontalCoverList.kt", i = {}, l = {137, 144, 152, 158, 159}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailHorizontalCoverListKt$BookDetailHorizontalCoverContentList$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, androidx.compose.animation.core.m> $alpha;
    final /* synthetic */ MutableState<List<a>> $displayedItems$delegate;
    final /* synthetic */ String $displayedSignature;
    final /* synthetic */ boolean $enableRefreshAnimation;
    final /* synthetic */ List<a> $items;
    final /* synthetic */ String $newSignature;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailHorizontalCoverListKt$BookDetailHorizontalCoverContentList$1$1(boolean z, List<a> list, Animatable<Float, androidx.compose.animation.core.m> animatable, String str, String str2, MutableState<List<a>> mutableState, Continuation<? super BookDetailHorizontalCoverListKt$BookDetailHorizontalCoverContentList$1$1> continuation) {
        super(2, continuation);
        this.$enableRefreshAnimation = z;
        this.$items = list;
        this.$alpha = animatable;
        this.$newSignature = str;
        this.$displayedSignature = str2;
        this.$displayedItems$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookDetailHorizontalCoverListKt$BookDetailHorizontalCoverContentList$1$1(this.$enableRefreshAnimation, this.$items, this.$alpha, this.$newSignature, this.$displayedSignature, this.$displayedItems$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookDetailHorizontalCoverListKt$BookDetailHorizontalCoverContentList$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ce A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.widget.BookDetailHorizontalCoverListKt$BookDetailHorizontalCoverContentList$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
