package com.dragon.read.kmp.reader.utils;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.e0;
import androidx.compose.ui.input.pointer.h0;
import androidx.compose.ui.input.pointer.v;
import androidx.compose.ui.input.pointer.w;
import androidx.compose.ui.platform.g3;
import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class GestureKt {
    private static final n a;
    private static final float b;
    private static final float c;
    private static final float d;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k() {
        return Unit.INSTANCE;
    }

    static {
        Covode.recordClassIndex(608653);
        a = new a();
        float g = x0.i.g((float) 0.125d);
        b = g;
        float g2 = x0.i.g(18);
        c = g2;
        d = g / g2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(a0.f fVar) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(float f) {
        return Unit.INSTANCE;
    }

    public static final class a implements n {
        a() {
        }

        @Override // com.dragon.read.kmp.reader.utils.n
        public float a(long j) {
            return Float.intBitsToFloat((int) (j & 4294967295L));
        }

        @Override // com.dragon.read.kmp.reader.utils.n
        public float c(long j) {
            return Float.intBitsToFloat((int) (j >> 32));
        }

        @Override // com.dragon.read.kmp.reader.utils.n
        public long b(float f, float f2) {
            return a0.f.e((Float.floatToRawIntBits(f) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32));
        }
    }

    public static final float n(g3 pointerSlop, int i) {
        Intrinsics.checkNotNullParameter(pointerSlop, "$this$pointerSlop");
        if (h0.g(i, h0.a.b())) {
            return pointerSlop.f() * d;
        }
        return pointerSlop.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(androidx.compose.ui.input.pointer.m mVar, long j) {
        Object obj;
        Iterator it2 = mVar.a.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                if (v.b(((w) obj).a, j)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        w wVar = (w) obj;
        boolean z = false;
        if (wVar != null && wVar.d) {
            z = true;
        }
        return !z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f8, code lost:
    
        if ((!r0) != false) goto L53;
     */
    /* JADX WARN: Path cross not found for [B:53:0x00e0, B:40:0x00bd], limit reached: 67 */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0086 -> B:10:0x0089). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object o(androidx.compose.ui.input.pointer.d r17, long r18, androidx.compose.ui.input.pointer.PointerEventPass r20, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.w, kotlin.Unit> r21, kotlin.coroutines.Continuation<? super java.lang.Boolean> r22) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.utils.GestureKt.o(androidx.compose.ui.input.pointer.d, long, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00df A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0148 -> B:18:0x00c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x01a3 -> B:11:0x01a9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x01f8 -> B:17:0x01b3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(androidx.compose.ui.input.pointer.d r18, long r19, int r21, androidx.compose.ui.input.pointer.PointerEventPass r22, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.w, ? super java.lang.Float, kotlin.Unit> r23, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.w> r24) {
        /*
            Method dump skipped, instructions count: 511
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.utils.GestureKt.f(androidx.compose.ui.input.pointer.d, long, int, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object g(e0 e0Var, Function1<? super a0.f, Unit> function1, Function1<? super Float, Unit> function12, Function0<Unit> function0, Function2<? super w, ? super Float, Unit> function2, PointerEventPass pointerEventPass, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object e = ForEachGestureKt.e(e0Var, new GestureKt$detectVerticalDragGesturesInPass$5(pointerEventPass, function1, function2, function12, function0, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (e == coroutine_suspended) {
            return e;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0109, code lost:
    
        if ((!r0) != false) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0098 -> B:10:0x009e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object l(androidx.compose.ui.input.pointer.d r18, long r19, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.w, kotlin.Unit> r21, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.w, java.lang.Float> r22, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.w, java.lang.Boolean> r23, androidx.compose.ui.input.pointer.PointerEventPass r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.w> r25) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.utils.GestureKt.l(androidx.compose.ui.input.pointer.d, long, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x01ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x014e -> B:17:0x00c5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x01ac -> B:11:0x01b4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x01f6 -> B:17:0x00c5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(androidx.compose.ui.input.pointer.d r19, long r20, int r22, com.dragon.read.kmp.reader.utils.n r23, boolean r24, androidx.compose.ui.input.pointer.PointerEventPass r25, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.w, ? super a0.f, kotlin.Unit> r26, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.w> r27) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.utils.GestureKt.e(androidx.compose.ui.input.pointer.d, long, int, com.dragon.read.kmp.reader.utils.n, boolean, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object h(e0 e0Var, Function1 function1, Function1 function12, Function0 function0, Function2 function2, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: com.dragon.read.kmp.reader.utils.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit i2;
                    i2 = GestureKt.i((a0.f) obj2);
                    return i2;
                }
            };
        }
        Function1 function13 = function1;
        if ((i & 2) != 0) {
            function12 = new Function1() { // from class: com.dragon.read.kmp.reader.utils.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit j;
                    j = GestureKt.j(((Float) obj2).floatValue());
                    return j;
                }
            };
        }
        Function1 function14 = function12;
        if ((i & 4) != 0) {
            function0 = new Function0() { // from class: com.dragon.read.kmp.reader.utils.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit k;
                    k = GestureKt.k();
                    return k;
                }
            };
        }
        Function0 function02 = function0;
        if ((i & 16) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return g(e0Var, function13, function14, function02, function2, pointerEventPass, continuation);
    }
}
