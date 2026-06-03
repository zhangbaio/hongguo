package bm4;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import bm4.h0;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.image.options.i;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h0 {
    static {
        Covode.recordClassIndex(608282);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(String str, Modifier modifier, Function1 function1, Function1 function12, int i, int i2, Composer composer, int i3) {
        c(str, modifier, function1, function12, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final class a implements com.bytedance.kmp.image.options.i {
        final /* synthetic */ MutableState<Boolean> a;
        final /* synthetic */ Function1<Boolean, Unit> b;

        public void onLoadStart() {
            this.a.setValue(Boolean.FALSE);
        }

        public void a(i.c successResult) {
            Intrinsics.checkNotNullParameter(successResult, "successResult");
            MutableState<Boolean> mutableState = this.a;
            Boolean bool = Boolean.TRUE;
            mutableState.setValue(bool);
            Function1<Boolean, Unit> function1 = this.b;
            if (function1 != null) {
                function1.invoke(bool);
            }
        }

        public void onFail(Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
            MutableState<Boolean> mutableState = this.a;
            Boolean bool = Boolean.FALSE;
            mutableState.setValue(bool);
            Function1<Boolean, Unit> function1 = this.b;
            if (function1 != null) {
                function1.invoke(bool);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(MutableState<Boolean> mutableState, Function1<? super Boolean, Unit> function1) {
            this.a = mutableState;
            this.b = function1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(MutableState mutableState, androidx.compose.ui.layout.w coords) {
        Intrinsics.checkNotNullParameter(coords, "coords");
        mutableState.setValue(coords);
        return Unit.INSTANCE;
    }

    static final class b implements PointerInputEventHandler {
        final /* synthetic */ MutableState<androidx.compose.ui.layout.w> a;
        final /* synthetic */ Function1<a0.h, Unit> b;

        b(MutableState<androidx.compose.ui.layout.w> mutableState, Function1<? super a0.h, Unit> function1) {
            this.a = mutableState;
            this.b = function1;
        }

        public final Object invoke(androidx.compose.ui.input.pointer.e0 e0Var, Continuation<? super Unit> continuation) {
            Object coroutine_suspended;
            final MutableState<androidx.compose.ui.layout.w> mutableState = this.a;
            final Function1<a0.h, Unit> function1 = this.b;
            Object m = TapGestureDetectorKt.m(e0Var, (Function1) null, (Function1) null, (Function3) null, new Function1() { // from class: bm4.i0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit b;
                    b = h0.b.b(mutableState, function1, (a0.f) obj);
                    return b;
                }
            }, continuation, 7, (Object) null);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (m == coroutine_suspended) {
                return m;
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit b(MutableState mutableState, Function1 function1, a0.f fVar) {
            androidx.compose.ui.layout.w wVar = (androidx.compose.ui.layout.w) mutableState.getValue();
            if (wVar != null && wVar.U() && function1 != null) {
                function1.invoke(androidx.compose.ui.layout.x.c(wVar));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(final java.lang.String r30, androidx.compose.ui.Modifier r31, kotlin.jvm.functions.Function1<? super a0.h, kotlin.Unit> r32, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bm4.h0.c(java.lang.String, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
