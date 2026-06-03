package com.dragon.read.kmp.reader.utils;

import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.w;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;

@DebugMetadata(c = "com.dragon.read.kmp.reader.utils.GestureKt$detectVerticalDragGesturesInPass$5", f = "Gesture.kt", i = {0, 1, 1, 1, 2}, l = {69, 73, 89}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "overSlop", "velocityTracker", "velocityTracker"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class GestureKt$detectVerticalDragGesturesInPass$5 extends RestrictedSuspendLambda implements Function2<androidx.compose.ui.input.pointer.d, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function1<Float, Unit> $onDragEnd;
    final /* synthetic */ Function1<a0.f, Unit> $onDragStart;
    final /* synthetic */ Function2<w, Float, Unit> $onVerticalDrag;
    final /* synthetic */ PointerEventPass $pass;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    GestureKt$detectVerticalDragGesturesInPass$5(PointerEventPass pointerEventPass, Function1<? super a0.f, Unit> function1, Function2<? super w, ? super Float, Unit> function2, Function1<? super Float, Unit> function12, Function0<Unit> function0, Continuation<? super GestureKt$detectVerticalDragGesturesInPass$5> continuation) {
        super(2, continuation);
        this.$pass = pointerEventPass;
        this.$onDragStart = function1;
        this.$onVerticalDrag = function2;
        this.$onDragEnd = function12;
        this.$onDragCancel = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GestureKt$detectVerticalDragGesturesInPass$5 gestureKt$detectVerticalDragGesturesInPass$5 = new GestureKt$detectVerticalDragGesturesInPass$5(this.$pass, this.$onDragStart, this.$onVerticalDrag, this.$onDragEnd, this.$onDragCancel, continuation);
        gestureKt$detectVerticalDragGesturesInPass$5.L$0 = obj;
        return gestureKt$detectVerticalDragGesturesInPass$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(androidx.compose.ui.input.pointer.d dVar, Continuation<? super Unit> continuation) {
        return ((GestureKt$detectVerticalDragGesturesInPass$5) create(dVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00bc  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.utils.GestureKt$detectVerticalDragGesturesInPass$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(Function2 function2, androidx.compose.ui.input.pointer.util.a aVar, w wVar) {
        function2.invoke(wVar, Float.valueOf(Float.intBitsToFloat((int) (androidx.compose.ui.input.pointer.n.g(wVar) & 4294967295L))));
        aVar.a(wVar.b, wVar.c);
        wVar.a();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(androidx.compose.ui.input.pointer.util.a aVar, Ref$FloatRef ref$FloatRef, w wVar, float f) {
        if (f > 0.0f) {
            aVar.a(wVar.b, wVar.c);
            wVar.a();
            ref$FloatRef.element = f;
        }
        return Unit.INSTANCE;
    }
}
