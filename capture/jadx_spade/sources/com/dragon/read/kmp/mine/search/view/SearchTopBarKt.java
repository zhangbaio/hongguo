package com.dragon.read.kmp.mine.search.view;

import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.u2;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SearchTopBarKt {
    static {
        Covode.recordClassIndex(607779);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Function0 function0, Function1 function1, Function1 function12, Function0 function02, Function0 function03, Modifier modifier, int i, int i2, Composer composer, int i3) {
        k(function0, function1, function12, function02, function03, modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(String it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(String it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String y(MutableState<String> mutableState) {
        return (String) mutableState.getValue();
    }

    private static final boolean n(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void m(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    private static final void o(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Function0 function0, MutableState mutableState) {
        m(mutableState, "");
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final class a implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {
        final /* synthetic */ MutableState<String> a;

        a(MutableState<String> mutableState) {
            this.a = mutableState;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function2, Composer composer, Integer num) {
            a(function2, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer, int i) {
            int i2;
            boolean z;
            int i3;
            int i4;
            Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
            if ((i & 6) == 0) {
                if (composer.changedInstance(innerTextField)) {
                    i4 = 4;
                } else {
                    i4 = 2;
                }
                i2 = i | i4;
            } else {
                i2 = i;
            }
            boolean z2 = false;
            if ((i2 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(369963296, i2, -1, "com.dragon.read.kmp.mine.search.view.SearchTopBar.<anonymous>.<anonymous>.<anonymous> (SearchTopBar.kt:107)");
                }
                composer.startReplaceGroup(-947556574);
                if (SearchTopBarKt.y(this.a).length() == 0) {
                    z2 = true;
                }
                if (z2) {
                    i3 = i2;
                    a6.j("输入关键词", (Modifier) null, og4.a.a.h(composer, og4.a.b).d(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3078, 0, 131058);
                } else {
                    i3 = i2;
                }
                composer.endReplaceGroup();
                innerTextField.invoke(composer, Integer.valueOf(i3 & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Function1 function1, MutableState mutableState, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        m(mutableState, value);
        function1.invoke(value);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Function0 function0, MutableState mutableState, androidx.compose.ui.focus.c0 it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        if (!n(mutableState) && it2.isFocused()) {
            function0.invoke();
        }
        o(mutableState, it2.isFocused());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Function1 function1, u2 u2Var, MutableState mutableState, androidx.compose.foundation.text.u2 KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        function1.invoke(y(mutableState));
        if (u2Var != null) {
            u2Var.hide();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x06db  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x06ca  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void k(final kotlin.jvm.functions.Function0<kotlin.Unit> r83, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r84, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r85, kotlin.jvm.functions.Function0<kotlin.Unit> r86, kotlin.jvm.functions.Function0<kotlin.Unit> r87, androidx.compose.ui.Modifier r88, androidx.compose.runtime.Composer r89, final int r90, final int r91) {
        /*
            Method dump skipped, instructions count: 1774
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.mine.search.view.SearchTopBarKt.k(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}
